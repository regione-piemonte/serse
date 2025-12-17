/**
 * @license
 *
 * Copyright © 2025 Regione Piemonte
 *
 * Licensed under the EUPL, Version 1.2 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://interoperable-europe.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 * or
 * https://opensource.org/license/EUPL-1.2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

import { registerLocaleData } from '@angular/common';
import { Component, Input, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

//-Models
import { Servizio } from '@core/api-serse/model/servizio';
import { ServizioFonte } from '@core/api-serse/model/servizioFonte';
import { ServizioSto } from '@core/api-serse/model/servizioSto';
import { ServizioVoceSpesa } from '@core/api-serse/model/servizioVoceSpesa';
import { TokenGam } from '@core/api-serse/model/tokenGam';
import { DestinatariService } from '@core/services/destinatari.service';

//-Services
import { HomeBagService } from '@home/services/home-bag.service';
import { ServiziService } from '@servizi/services/servizi.service';
import { SpesaService } from '@servizi/services/spesa.service';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogSettings } from '@shared/model/dialog-settings.model';

import localeEs419 from '@angular/common/locales/es-419';
import { ServizioGam } from '@core/api-serse/model/servizioGam';

@Component({
  selector: 'app-servizio-spesa',
  templateUrl: './servizio-spesa.component.html',
  styleUrls: ['./servizio-spesa.component.scss']
})
export class ServizioSpesaComponent implements OnInit {

  @Input() servizio!:Servizio;
  @Input() isModificabile:boolean = false;
  @Input() periodoValido:boolean = false;

  noTokenPC = false;

  titolo = "Spesa a preventivo";
  isVisibileSpesaPreventivo = false;
  vociSpesaList: ServizioVoceSpesa[] = []

  isVisibileFinanziamento = false;
  fonteFinanzList: ServizioFonte[] = []

  tokenGam: TokenGam[] = []
  lastRequest?: TokenGam;

  storicoServizio: ServizioSto[] = [];

  //-----------------------------------
  statoRiciesta="In corso"
  esitoRichiesta="N.D."
  //-----------------------------------

  disablePulsanti = false;
  //------------------------------------
  ricPCesitNull:boolean = false;
  //------------------------------------

  datiToken = {id:"", dataRichiesta:"", statoRichiesta:"", esitoRichiesta:""};

  @ViewChild('storico') storico!: TemplateRef<any>;

  constructor(
    private destinatariService:DestinatariService,
    private servizioService: ServiziService,
    private spesaService:SpesaService,
    private homeBag: HomeBagService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    registerLocaleData(localeEs419,"es-419");
    this.fetchTokenGam();
    this.fetchStorico();
    //this.servizio=this.servizioService.servizio
    //-1 Visualizzazare Sezione Dati richiesta ai servizi GAM [DONE]
    //-2 Contrllo tipo_tichiesta = 01 || 04  && stato_elaborazione = OK per l'ultimo
    //--- a Se esiste almeno fare questa chiamata /servizi/servizi-voce-spesa  recuperare gli elenchi
    //-3 Esiste almeno uno tipo_tichiesta = 01 && stato_elaborazione = OK
    //--- a Eseguo questa chiamata /servizi/servizi-fonte
  }

  onAggiorna(){
    this.servizioService.reload();
    this.fetchTokenGam();
    this.fetchStorico();
  }

  fetchTokenGam(){
    this.spesaService.getTokenGamServizio(this.idServizio!.toString())
        .pipe()
        .subscribe(
          risp => {

            this.tokenGam = risp;

            if(this.tokenGam.length){ // se è presente almeno un token recupero l'ultimo
              this.handlerTokensGAM();

            }else this.noTokenPC = true;
            // this.lastRequest!.descrEsitoElaborazione
          }
        )
  }
  fetchStorico(){
    this.spesaService.getStoricoServizio(this.idServizio!.toString())
        .pipe()
        .subscribe(risp=>{
          this.storicoServizio = risp;

        })
  }

  aggiornaRichiestaInfo(){
    this.ricPCesitNull = !(this.lastRequest?.codStatoRichiesta == "PC" && this.lastRequest?.codStatoElaborazione) && !(this.lastRequest?.codStatoRichiesta!=null && this.lastRequest.codStatoRichiesta!="PC")
    this.datiToken = {
      id: this.lastRequest!.idTokenGam!.toString(),
      dataRichiesta: new Date(this.lastRequest!.dInvioRichiesta!).toLocaleDateString(),
      statoRichiesta: "",
      esitoRichiesta: ""
    };

    if(this.ricPCesitNull){
      this.datiToken.statoRichiesta = "In corso";
      this.datiToken.esitoRichiesta = "N.D.";
    }else{
      this.datiToken.statoRichiesta = "Elaborata";
      this.disablePulsanti = false;
      if(this.lastRequest?.codStatoElaborazione == "IA"){
        this.datiToken.esitoRichiesta = "Positivo";
      }else{
        this.datiToken.esitoRichiesta = "Negativo - "+ this.lastRequest?.descrEsitoElaborazione
      }
    }
    if(this.lastRequest?.codStatoRichiesta!=null && this.lastRequest.codStatoRichiesta!="PC"){
        this.datiToken.statoRichiesta = "Elaborata";
        this.datiToken.esitoRichiesta = "Negativo - ET"
        this.disablePulsanti = false;
    }

    let i = this.tokenGam.find(t=> t.codStatoElaborazione == "PC")
    this.noTokenPC = !i;

    if (this.ricPCesitNull) {
      this.disablePulsanti = true;
    }
  }

  //=========================

  handlerTokensGAM(){

    this.tokenGam
      .sort((a, b) => new Date(a.dInvioRichiesta!).getTime() - new Date(b.dInvioRichiesta!).getTime());

    // non dobbiamo considerare finanziamenti precedenti la riapertura del servizio
    const firstIndexRiportaInDef = this.tokenGam.findIndex(token => token.codTipoRichiestaGam === "02");
    if (firstIndexRiportaInDef > -1) {
      this.tokenGam = this.tokenGam.slice(firstIndexRiportaInDef + 1);
    }

    const tokenInteressanti = this.tokenGam
      .filter(token => token.codTipoRichiestaGam === "01" || token.codTipoRichiestaGam === "04");

    if (tokenInteressanti.length == 0) {
      this.noTokenPC = true;
      return;
    }

    this.lastRequest = tokenInteressanti[tokenInteressanti.length-1];

    let calcolato = tokenInteressanti.find(token => token.codTipoRichiestaGam === "04" && token.codStatoElaborazione == "IA") != null;
    let finanziato = tokenInteressanti.find(token => token.codTipoRichiestaGam === "01" && token.codStatoElaborazione == "IA") != null;

    if (finanziato) {
      this.titolo = "Spesa a preventivo finanziata";
    } else if (calcolato) {
      this.titolo = "Spesa a preventivo calcolata";
    } else {
      this.titolo = "Spesa a preventivo";
    }


    this.aggiornaRichiestaInfo();

    this.isVisibileSpesaPreventivo = (calcolato || finanziato);
    this.isVisibileFinanziamento = finanziato;

    if (this.isVisibileSpesaPreventivo) this.fetchElencoVociSpesa();
    if (this.isVisibileFinanziamento) this.fetchElencoFontiFinanziamento();

  }

  totalePubblico = 0;

  totalePrivato = 0;

  totaleServizio = 0;

  fetchElencoVociSpesa(){
    this.spesaService.getElencoVociSpesa(this.idServizio!.toString())
        .pipe()
        .subscribe(risp => {
              this.vociSpesaList = risp;
              this.totalePubblico = 0;
              this.totalePrivato = 0;
              this.totaleServizio = 0;
              this.vociSpesaList.forEach(spesa=>{
                this.totalePubblico += spesa.voceSpesa?.codNaturaSpesa == 'PB' ?spesa.importoVoceSpesa!:0;
                this.totalePrivato += spesa.voceSpesa?.codNaturaSpesa == 'PR' ?spesa.importoVoceSpesa!:0;
                this.totaleServizio += spesa.importoVoceSpesa!;
              });
    });
 }
  fetchElencoFontiFinanziamento(){
    this.spesaService.getElencoFinanziamento(this.idServizio!.toString())
        .pipe()
        .subscribe(risp => this.fonteFinanzList = risp)
  }

  onCalcolaPreventivo(){
    this.spesaService.richiestaPreventivoSpesa(this.createWrapperServizio())
        .pipe()
        .subscribe(risp => {
          this.disablePulsanti = true
          this.tokenGam.push(risp)
          this.handlerTokensGAM()
          this.servizioService.reload()
          this.ricPCesitNull = true
        })
  }
  onRichiediFinanziamento(){
    if(this.servizio.servizioRegionale?.codFinalitaServizio == "I"){
      if(this.destinatariService.numDestinatAssoc != 1){
        this.dialog.open(DialogConfermaComponent,{
          data: new DialogSettings(
              "Attenzione!",
              ['Associare prima un destinatario'],
              "card-body--danger"
          )
        });
        return;
      }
    }

    let prova = this.createWrapperServizio();
    prova.servizio!.servizioRegionale!.idClassificazione = 5;

    this.spesaService.richiestaFinanziamento(prova)
        .pipe()
        .subscribe(risp => {
          this.disablePulsanti = true
          this.tokenGam.push(risp)
          this.handlerTokensGAM()
          this.servizioService.reload()
          this.ricPCesitNull = true
        })
  }

  createWrapperServizio():ServizioGam{
    let ris: ServizioGam={
      numProgrSportello: this.homeBag.selectedSportello.numProgrSportello,
      codOperatore: this.homeBag.selectedOperatore.codOperatore,
      gruppoOperatore: this.homeBag.selectedOperatore.gruppoOperatore,
      idPso: this.homeBag.selectedPso.idPso,
      codiceFiscaleUtente: this.homeBag.userInfo.codFisc,
      servizio:this.servizio
    }
    return ris;
  }

  //-------------------------------
  onOpenStorico(){
    this.dialog.open(this.storico, {
      maxHeight: "75vh",
      width: "50vw",
      panelClass: "ClasseCss",
    });
  }

  reset(){
    // da richiamare quando si riporta il servizio in definizione
    this.titolo = "Spesa a preventivo"
    this.isVisibileSpesaPreventivo = false
    this.vociSpesaList = []
    this.isVisibileFinanziamento = false
    this.fonteFinanzList = []
    this.storicoServizio = []
    this.tokenGam = []
    this.lastRequest = undefined
    }

  get idServizio(){
    return this.servizio.idServizio;
  }
  get visibilityCalcFin(){
    return this.periodoValido &&
            this.servizioInDefinizione &&
            this.isModificabile &&
            this.noTokenPC;
  }
  get servizioInDefinizione(){
    return this.servizio.statoServizio?.idStatoServizio==10
  }
  get visibilityAggiorna(){
    return this.servizioInDefinizione &&
            this.isModificabile &&
            this.ricPCesitNull;
  }

}
