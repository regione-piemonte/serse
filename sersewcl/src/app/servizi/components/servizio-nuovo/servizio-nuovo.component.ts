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

import { TokenGam } from '@core/api-serse/model/tokenGam';
import { Component, OnInit, TemplateRef, ViewChild, AfterViewInit, Renderer2, ElementRef, OnDestroy } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

//-Services
import { ServiziService } from '@servizi/services/servizi.service';
import { TitleService } from '@core/services/title.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { CriteriRicercaServiziService } from '@servizi/services/criteri-ricerca-servizi.service';

//-Models
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { AreaTerritoriale } from '@core/api-serse/model/areaTerritoriale';
import { Classificazione } from '@core/api-serse/model/classificazione';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { Servizio } from '@core/api-serse/model/servizio';

//-Components
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { InterventiService } from '@interventi/services/interventi.service';
import { IconsSettings } from '@shared/const/icons-settings'
import { Validation } from '@shared/utils/validation';
import { TokenGamService } from '@core/services/token-gam.service';
import { ServizioGamChiudiServizio } from '@core/api-serse/model/servizioGamChiudiServizio';
import { MatIcon } from '@angular/material/icon';
import { lastValueFrom, Subscription } from 'rxjs';
import { ServizioGamPropostaModifica } from '@core/api-serse/model/servizioGamPropostaModifica';
import { ServizioSpesaComponent } from '../servizio-spesa/servizio-spesa.component';
import { DatiPeculiariWrapper } from '@core/api-serse/model/datiPeculiariWrapper';
import { TableSettingsModel, ColumnSettingsModel, InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { SimpleDestinatario } from '../servizio-destinatari/servizio-destinatari.component';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { DestinatariService } from '@core/services/destinatari.service';
import { DialogDatiParticolariComponent } from '@shared/components/dialog-dati-particolari/dialog-dati-particolari.component';
import { DatiPeculiari } from '@core/api-serse/model/datiPeculiari';
import { Intervento } from '@core/api-serse/model/intervento';
import { SedeOperatore } from '@core/api-serse/model/sedeOperatore';
import { LuoghiService } from '@incontri/services/luoghi.service';
import { compareTipologiaservizio } from '@shared/utils/compares';
import { Incontro } from '@core/api-serse/model/incontro';
import { IncontriService } from '@incontri/services/incontri.service';
import { ServizioGamRiapriServizio } from '@core/api-serse/model/servizioGamRiapriServizio';
import { ServizioIncontriComponent } from '../servizio-incontri/servizio-incontri.component';
import { Pristinable } from '@home/models/pristinable';
import { PristineService } from '@home/services/pristine.service';
import { MatTabGroup } from '@angular/material/tabs';
import { TabClickInterceptorEvent } from '@shared/directives/tab-click-interceptor.directive';

@Component({
  selector: 'app-servizio-nuovo',
  templateUrl: './servizio-nuovo.component.html',
  styleUrls: ['./servizio-nuovo.component.scss']
})
export class ServizioNuovoComponent implements OnInit, AfterViewInit, OnDestroy, Pristinable {
  //-Dialog
  @ViewChild('propostaModifica') proposta!: TemplateRef<any>;
  @ViewChild('chiusura')  chiusura!: TemplateRef<any>;
  @ViewChild('datiCorr') datiParticolari!: TemplateRef<any>

  //-Tab
  selectedTab: number = 0;

  @ViewChild(MatTabGroup, { static: false }) tabGroup!: MatTabGroup;
  @ViewChild('spesaTab') spesaTab!: ServizioSpesaComponent; //-Aggiorna il componenete spesa
  @ViewChild('incontriTab') incontriTab!: ServizioIncontriComponent;

  //-Forms
  riferimentoForm = this.fb.group({
    cognome: ['', [Validators.required, Validation.cognomeNomeValidator(false)]],
    nome: ['', [Validators.required, Validation.cognomeNomeValidator(true)]],
    telefono: ['', [Validators.required, Validation.phoneNumberValidator]],
    email_pec: ['', [Validators.required, Validation.emailValidator]]
  });
  form = this.fb.group({
    titolo: ['',Validators.required],
    territorio: ['',Validators.required],
    candidatura: ['',Validators.required],
    sedeRiferimento: ['',Validators.required],
    tipologia: ['',Validators.required],

    durataOre: ['',[Validators.required, Validation.oreValidator]], // questo validatore viene modificato dinamicamente dopo
    numDestinatari: ['', [Validators.required, Validation.int4Validator, Validation.rangeValidator(1, 99)]],
    numeroFamiglie: [''],

    durataOreProposta: ['',],
    numDestinatariProposta: ['',],

    classificazione: ['',Validators.required]
  });

  formIntervento = false;

  istanzeCandidatura: SoggettoAttuatore[] = [];
  sediRiferimentoList: SedeOperatore[] = [];
  tipologieServizio: ServizioRegionale[] = [];
  selectedTipologiaServizio?: ServizioRegionale;

  areeTerritoriali: AreaTerritoriale[] = [];
  classificazioniPor: Classificazione[] = [];


  toolTipDurataOre = "Selezionare prima la tipologia, min: _h - max: _h";

  // vari flag di stato
  periodoValido = true;   // questo viene settato solo all'onInit, dipende dallo sportello e non cambia
  esisteElaborazioneInCorso = false; // se esiste una qualsiasi elaborazione in corso
  esisteElaborazione03InCorso = false; // se esiste una elaborazione 03 in corso
  chiudibile = false; // se mostrare il bottone "chiudi"
  riportaInDefinizione = false; // se mostrare il bottone "riporta in definizione"
  canPropostaOre = false; // se mostrare il bottone "proposta modifica ore"
  canPropostaDest = false; // se mostrare il bottone "proposta modifica destinatari"
  propostaFattaDaSalvare = false; // se l'utente ha imputato una proposta di modifica ore/destinatari ma non ha ancora salvato

  intervento:Intervento = {};

  //-----------------------------------
  //- Proposta modifica
  isOre = true; //ore o destinatari
  formProposta =  this.fb.group({
    ore: ['',[Validators.required, Validation.oreValidator]], // questo validatore viene modificato dinamicamente dopo
    dest: ['', [Validators.required, Validation.int4Validator, Validation.rangeValidator(1, 99)]],
  })
  oreProposte = "";
  desProposte = "";
  isNewProposta: boolean[] =[false,false];  //- ore,dest; serve se è già presente uno diverso da PC e voglio fare una proposta
  dialogRef!: MatDialogRef<any, any>;

  datiToken = {id:"", dataRichiesta:"", statoRichiesta:"", esitoRichiesta:""};
  //-----------------------------------

  testoDialogChiusura:string = "";

  //--------------------
  visibilityAggiorna=false;
  //--------------------

  formChiusura=this.fb.group({
    dataChiusura:[""]
  })

  subscriptionOnReload!: Subscription;
  datiPeculiari:DatiPeculiariWrapper|undefined={};
  modaleDatinCorrelati:any;
  destinatario:Destinatario|undefined={};
  dialogDatiParticolari:any;

  labaleCampoAggiuntivo: string = ""
  showNumeroFamiglie: boolean = false;
  numeroFamiglieIsNull: boolean = false;

  //-Table
  data: Destinatario[]=[];
  rowData: SimpleDestinatario[]=[];
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private dialog: MatDialog,

    private title: TitleService,

    private homeBag: HomeBagService,
    private criteriRicerca: CriteriRicercaServiziService,
    private interventiService: InterventiService,
    private serviziService:ServiziService,
    private destinatariService:DestinatariService,
    private incontriService:IncontriService,
    private tokenGamService:TokenGamService,
    private pristineService: PristineService,
    //- Servono per aggiungere l'icona infondo alle tab sul scss mat-labels-container::after{content:""}
    private elementRef: ElementRef,
    private renderer: Renderer2,
    private luoghiService : LuoghiService,
  ){
    if(!this.router.url.endsWith("nuovo")){
      if(!this.serviziService.servizio){
        this.resetToNuovo();
      }
    }
  }

  //---------------------------------------------------
  //- Gestione icona a destra
  @ViewChild('IconaP') iconaP!:MatIcon;
  @ViewChild('IconaG') iconaG!:MatIcon;
  ngAfterViewInit(): void {
    if (!this.servizio?.idServizio && this.router.url.endsWith('/form')) {
      console.error("Situazione non corretta, forse F5 utente, redirect verso gestione servizi");
      setTimeout(() => {
        this.router.navigate(['/dashboard/servizio/gestione']);
      });
      return;
    }

    if(!this.isSaved) return;
    this.handlerIconTab();
  }

  handleNumeroFamiglie(idServizioRegionale: number) {
      if (this.form.get("tipologia")?.value! !== null || this.form.get("tipologia")?.value! !== undefined) {
        this.serviziService.getFlgCampoAggiuntivoByIdServizioRegionale(idServizioRegionale).subscribe(ris => {
          if (ris.flgCampoAggiuntivo1 !== null) {
            this.numeroFamiglieIsNull = false;
            if (ris.flgCampoAggiuntivo1 === "O") {
              this.form.controls["numeroFamiglie"].addValidators([Validators.required])
            } else {
              this.form.controls["numeroFamiglie"].clearValidators();
            }
            this.form.controls["numeroFamiglie"].updateValueAndValidity();
            if (this.servizio.valoreCampoAggiuntivo1 !== null) {
              this.form.controls["numeroFamiglie"].setValue(this.servizio.valoreCampoAggiuntivo1!);
            }
          } else {
            this.form.controls["numeroFamiglie"].removeValidators([Validators.required]);
            this.form.controls["numeroFamiglie"].setValue(null);
            this.form.controls["numeroFamiglie"].updateValueAndValidity();
            this.numeroFamiglieIsNull = true;
            //this.form.controls["numeroFamiglie"].setValue(null);
          }
        });

      }
    if(this.form.controls["tipologia"].value !== null || this.form.controls["tipologia"].value !== undefined || this.form.controls["tipologia"].value !== "") this.showNumeroFamiglie = true;
    else this.showNumeroFamiglie = false;
  }

  handlerIconTab(){
    const container = this.elementRef.nativeElement.querySelector('.mat-tab-label-container');
    let icona = this.isIndividuale ?this.iconaP:this.iconaG;
    const iconElement = icona._elementRef.nativeElement.cloneNode(true);
    this.renderer.appendChild(container, iconElement);
  }

  //---------------------------------------------------
  ngOnInit(): void {

    this.pristineService.componentAttivo = this;
    this.form.enable();
    this.createTable();
    this.title.setIcon(IconsSettings.SERVIZI_ICON);
    this.title.setTitle(this.router.url.endsWith("nuovo") ?"Nuovo servizio" :"Modifica servizio");

    this.subscriptionOnReload = this.serviziService.selectionChangeServizio$.subscribe({next:()=>this.onReloadServizio()});

    this.serviziService.checkPeriodoAttivazioneServizio(this.homeBag.selectedSportello.numProgrSportello!.toString())
        .subscribe(risp => {
          this.periodoValido = !!risp.valido

          if (this.router.url.includes("fromIntervento")) {this.handlerFromIntervento()}
          else {this.handlerIfServizioSave()}

          if (!this.periodoValido) return;

          if (this.isSaved) { //- salvato
            //- controllo se è presente una chiamata gam nel caso lo stato è 22
            if (this.stato == 22) {
              this.form.controls['numDestinatari'].disable();
              this.form.controls['durataOre'].disable();
            }
            if (this.stato != 10) {
              //- chiamata Token  ultima richiesta
              this.onAggiornaProposta();
            }
          }
          this.selectedTab = this.serviziService.tab;
          this.serviziService.tab = 0;
        });

    this.chiudibile= this.isModificabile && this.isSaved && this.servizio.statoServizio?.idStatoServizio == 30;
    if(this.chiudibile){
      this.tokenGamService.getTokenGamServizio(this.servizio.idServizio!.toString()).subscribe({
        next:ris=>{
          if(ris.length!=0){
            ris.forEach(token=>{
              if(token.codStatoElaborazione==="PC"){
                this.chiudibile=false;
              }})
          }} });
    }

    if(this.servizio.idIntervento){ //-Recupero i dati dell'intervento del servizio
      this.interventiService.getInterventoById(this.servizio.idIntervento!.toString())
      .subscribe(r=> {
        this.intervento = r;
        this.serviziService.intervento = r;
      })
    } else{
      this.serviziService.intervento = {};
    }

    let idPso = JSON.parse(localStorage.getItem("selectedPso")!).idPso;
    let numProgrSportello = JSON.parse(localStorage.getItem("selectedSportello")!).numProgrSportello;
    this.serviziService.getLabelCampoAggiuntivo(idPso,numProgrSportello).subscribe(ris => {
        this.labaleCampoAggiuntivo = ris.labelCampoAggiuntivo1;
      }
    )
  }

  ngOnDestroy(): void {
    this.pristineService.componentAttivo = undefined;
    this.subscriptionOnReload.unsubscribe();
  }

  onReloadServizio() {
      if (!this.servizio.idServizio) {
        return;
      }
      this.tokenGamService.getTokenGamServizio(this.servizio.idServizio.toString()).subscribe({
        next: tokens => {
          this.recalcFlags(tokens);
          const stato = this.servizio.statoServizio?.idStatoServizio;
          this.handlerIfServizioSave();
          this.setPristine();
          if(!this.isModificabile || stato == 22 || stato == 30 || stato == 40 || this.esisteElaborazioneInCorso) {
            this.form.disable();
          } else {
            this.form.enable();
          }
          if(!this.isModificabile || stato == 40 || this.esisteElaborazioneInCorso) {
            this.riferimentoForm.disable();
          } else {
            this.riferimentoForm.enable();
          }
          this.onAggiornaPropostaInternal(tokens)
        }
      });
  }

  //---------------------------------------
  //- Handling case view
  handlerFromIntervento() {
    if (this.isModificabile) {
      this.form.enable();
    }
    if (!this.serviziService.servizio.idIntervento) {
      this.resetToNuovo();
      return;}
    if (this.serviziService.servizio.servizioRegionale?.idServizioRegionale) {
      this.handleNumeroFamiglie(this.serviziService.servizio.servizioRegionale.idServizioRegionale!);
      this.form.get('numeroFamiglie')?.setValue(this.serviziService.servizio.valoreCampoAggiuntivo1! == null ? "0" : this.serviziService.servizio.valoreCampoAggiuntivo1!);
    }
    this.interventiService.tab = 2;
    this.formIntervento = true;

    this.handlerIfServizioSave();

    if (this.riferimentoForm.invalid) {
      this.riferimentoForm.get('cognome')?.setValue(this.interventiService.intervento.referente?.referenteCognome!);
      this.riferimentoForm.get('nome')?.setValue(this.interventiService.intervento.referente?.referenteNome!);
      this.riferimentoForm.get('telefono')?.setValue(this.interventiService.intervento.referente?.referenteTelefono!);
      this.riferimentoForm.get('email_pec')?.setValue(this.interventiService.intervento.referente?.referenteEmail!);
    }
  }

  handlerIfServizioSave() {
    if(this.serviziService.isSaved) {
      if(this.checkIfServizioNotSaved()) return;
      this.handlerFormOnSaved();
    } else if(this.formIntervento) {
            this.handlerFormOnNewFromIntervento();
    } else {
      this.updateSelects();
      this.handlerFormOnNew();
    }
    if (this.selectedTipologiaServizio?.idServizioRegionale)
      this.handleNumeroFamiglie(this.selectedTipologiaServizio.idServizioRegionale);
    if (!this.isModificabile) {
      this.form.disable()
      this.riferimentoForm.disable()
    }
  }

  checkIfServizioNotSaved() {
    if (!this.serviziService.servizio.idServizio) {
      this.router.navigate(['/dashboard/servizio/nuovo']).catch(error=>console.error(error));
      return true;
    }
    return false;
  }
  //---------------------------------------

  resetToNuovo(){
    this.serviziService.reset();
    this.serviziService.tab=0;
    this.router.navigateByUrl('/dashboard/servizio/nuovo');
  }

  //------------------------------------------------------------------------------------------------------
  //- Handling FORM
  handlerFormOnSaved(isNewSaved:boolean=false){
    this.form.controls['candidatura'].disable();
    this.form.controls['tipologia'].disable();

    this.form.controls['titolo'].setValue(this.serviziService.servizio.titoloServizio!);
    this.form.controls['durataOre'].setValue(String(this.serviziService.servizio.durataOre));
    this.form.controls['numDestinatari'].setValue(String(this.serviziService.servizio.numMaxDestinatari));
    this.form.controls['numeroFamiglie'].setValue(this.serviziService.servizio.valoreCampoAggiuntivo1 == null ? "0" : this.serviziService.servizio.valoreCampoAggiuntivo1); // hendling campo aggiuntivo

    this.riferimentoForm.get('cognome')?.setValue(this.serviziService.servizio.referenteCognome!);
    this.riferimentoForm.get('nome')?.setValue(this.serviziService.servizio.referenteNome!);
    this.riferimentoForm.get('telefono')?.setValue(this.serviziService.servizio.referenteTelefono!);
    this.riferimentoForm.get('email_pec')?.setValue(this.serviziService.servizio.referenteEmail!);

    if (!isNewSaved) {
      this.fetchIstanzeCandidatura();
    } else {
      this.fetchSediSoggettoAttuatore();
    }
    this.fetchAreeTerritoriali(String(this.servizio.soggettoAttuatore?.modelId));

    this.selectedTipologiaServizio = this.servizio.servizioRegionale;
    this.tipologieServizio = [this.selectedTipologiaServizio!];
    this.form.controls['tipologia'].setValue('0');
    this.toolTipDurataOre = "min: " + this.selectedTipologiaServizio!.oreConsentiteMin + "h - max: " + this.selectedTipologiaServizio!.oreConsentiteMax + "h";

    if (this.selectedTipologiaServizio!.codFinalitaServizio == "I") {
      this.form.controls['numDestinatari'].disable();
    }

    this.aggiornaValidatorsTipologiaServizio();

    this.fetchClassificazioniPOR(String(this.selectedTipologiaServizio!.idServizioRegionale));
  }

  private aggiornaValidatorsTipologiaServizio() {
    this.form.get('durataOre')?.setValidators([
      Validators.required,
      Validation.oreValidator,
      Validation.rangeValidator(this.selectedTipologiaServizio!.oreConsentiteMin!, this.selectedTipologiaServizio!.oreConsentiteMax!)
    ]);
    this.formProposta.get('ore')?.setValidators([
      Validators.required,
      Validation.oreValidator,
      Validation.rangeValidator(this.selectedTipologiaServizio!.oreConsentiteMin!, this.selectedTipologiaServizio!.oreConsentiteMax!)
    ]);
  }

  handlerFormOnNew(){
    this.form.controls['classificazione'].disable();
    this.form.controls['territorio'].disable();
    this.form.controls['sedeRiferimento'].disable();
    this.form.controls['durataOre'].disable();
    this.form.controls['numDestinatari'].disable();
  }

  handlerFormOnNewFromIntervento(){
    this.form.controls['candidatura'].disable();
    this.criteriRicerca.getIstanzeCandidatura(
      String(this.homeBag.selectedSportello.numProgrSportello),
      this.homeBag.codiceOperatore,
      this.homeBag.gruppoOperatore)
    .subscribe(risp => {
      this.istanzeCandidatura = risp
      this.form.controls['candidatura'].setValue(
          String(this.istanzeCandidatura.findIndex( a => a.modelId == this.interventiService.intervento.soggettoAttuatore?.modelId))
      );
      this.riferimentoForm.get('cognome')?.setValue(this.interventiService.intervento.referente?.referenteCognome!);
      this.riferimentoForm.get('nome')?.setValue(this.interventiService.intervento.referente?.referenteNome!);
      this.riferimentoForm.get('telefono')?.setValue(this.interventiService.intervento.referente?.referenteTelefono!);
      this.riferimentoForm.get('email_pec')?.setValue(this.interventiService.intervento.referente?.referenteEmail!);
      this.fetchAreeTerritoriali(String(this.istanzeCandidatura[+this.form.controls['candidatura'].value!].modelId));
      this.fetchSediSoggettoAttuatore();
      //Chiamata agli interventi
      this.fetchTipologieDiServizio(true);
    });

  }

  updateSelects(){
    this.fetchIstanzeCandidatura();
    this.fetchTipologieDiServizio();
  }
  fetchIstanzeCandidatura(){
    this.criteriRicerca.getIstanzeCandidatura(
        String(this.homeBag.selectedSportello.numProgrSportello),
        this.homeBag.codiceOperatore,
        this.homeBag.gruppoOperatore)
      .subscribe(risp => {
        this.istanzeCandidatura = risp
        if(this.isSaved)
        {
          this.form.controls['candidatura'].setValue(
            String(this.istanzeCandidatura.findIndex( a => a.modelId == this.servizio.soggettoAttuatore?.modelId))
          );
          this.fetchSediSoggettoAttuatore();
        }
      })
  }
// Metodo nel componente
fetchSediSoggettoAttuatore() {

  // 2025-01-22 LV in creazione il soggetto attuatore è l'utente collegato, invece in modifica è quello indicato in domanda

  const numProgrSportello = this.homeBag.selectedSportello?.numProgrSportello;
  const codOperatore = this.isSaved ? this.servizio!.soggettoAttuatore!.codOperatore : Number(this.homeBag.codiceOperatore);
  const gruppoOperatore = this.isSaved ? this.servizio!.soggettoAttuatore!.gruppoOperatore : this.homeBag.gruppoOperatore;
  const modelId = this.istanzeCandidatura[+this.form.controls['candidatura'].value!]?.modelId;
  this.luoghiService.getElencoSediSoggAttuatoreCodGruppo(
    numProgrSportello,
    codOperatore,
    gruppoOperatore,
    modelId
  ).subscribe(risp => {
    this.sediRiferimentoList = risp;

    if (this.isSaved) {
      if(this.servizio.progressivoSede) this.form.controls['sedeRiferimento'].setValue(String(this.servizio?.progressivoSede!));
    }
  });
}
  fetchTipologieDiServizio(fromIntervento:boolean=false){
    this.criteriRicerca.getTipologiaServizio(
                          String(this.homeBag.selectedPso.idPso),
                          fromIntervento ? this.interventiService?.intervento.idIntervento?.toString(): undefined
                          )
        .subscribe(risp => {
          this.tipologieServizio = risp
          this.tipologieServizio.sort(compareTipologiaservizio)
        })
  }

  //-Caricato dopo che viene selezionata una candidatura
  fetchAreeTerritoriali(modelId:string){
    let istanzaCandidatura:SoggettoAttuatore;
    if(this.isSaved){
      istanzaCandidatura = this.servizio.soggettoAttuatore!;
    }
    else{
      istanzaCandidatura = this.istanzeCandidatura[+this.form.controls['candidatura'].value!]
    }

    this.serviziService.getAreeTerritoriali(
      istanzaCandidatura.gruppoOperatore!,
      istanzaCandidatura.codOperatore!.toString(),
      modelId)
    .subscribe(risp => {
      this.areeTerritoriali = risp;
      if(this.isSaved && this.servizio.areaTerritoriale){
        this.form.controls['territorio'].setValue(this.servizio.areaTerritoriale.codAreaTerritoriale!)
      }else if(risp.length==1){
        this.form.controls['territorio'].setValue(risp[0].codAreaTerritoriale!)
      }
    });
  }

  fetchClassificazioniPOR(idServizioRegionale:string){
    this.serviziService.getClassificazioniPOR(
      String(this.homeBag.selectedPso.idPso),
      idServizioRegionale)
    .subscribe(risp => {
      this.classificazioniPor = risp;
      if (this.isSaved && this.servizio.classificazione) {
        this.form.controls['classificazione'].setValue(
          String(this.classificazioniPor.findIndex(
            c => c.idClassificazione = this.servizio.classificazione?.idClassificazione
          )))
      } else if(risp.length == 1) {
        this.form.controls['classificazione'].setValue(
          String(this.classificazioniPor.findIndex(
            c => c.idClassificazione = risp[0].idClassificazione!
          )))
      }
    });
  }

  onSelectedCandidatura() {
    if(this.form.controls['candidatura'].invalid) return;
    this.fetchAreeTerritoriali(String(this.istanzeCandidatura[+this.form.controls['candidatura'].value!].modelId));
    this.fetchSediSoggettoAttuatore();

    this.form.controls['territorio'].enable();
    this.form.controls['sedeRiferimento'].enable();
  }

  onSelectedTipolgia() {
    if(this.form.controls['tipologia'].invalid) return;
    this.selectedTipologiaServizio = this.tipologieServizio[+this.form.controls['tipologia'].value!];
    this.fetchClassificazioniPOR(String(this.selectedTipologiaServizio.idServizioRegionale));
    this.form.controls['classificazione'].enable();

    if(this.selectedTipologiaServizio.codFinalitaServizio == "I"){
      this.form.controls['numDestinatari'].setValue("1");
      this.form.controls['numDestinatari'].disable();
    } else{
      this.form.controls['numDestinatari'].enable();
    }

    this.aggiornaValidatorsTipologiaServizio(); // aggiorno i validatori *prima* di settare il valore

    this.form.controls['durataOre'].enable();
    this.form.controls['durataOre'].setValue(String(this.selectedTipologiaServizio.durataInOre));
    this.toolTipDurataOre = "min: "+this.selectedTipologiaServizio.oreConsentiteMin+"h - max: "+this.selectedTipologiaServizio.oreConsentiteMax+"h";

    if(!this.form.controls['titolo'].value){
      this.form.controls['titolo'].setValue(String(this.selectedTipologiaServizio.descrServizioRegionale));
    }
    if (this.selectedTipologiaServizio.idServizioRegionale)
      this.handleNumeroFamiglie(this.selectedTipologiaServizio.idServizioRegionale); // handling campo aggiuntivo

  }
  //------------------------------------------------------------------------------------------------------


  //--------------------------------------
  //- Proposta modifica ore/dest
  onConfermaProposta() {
    if (this.isOre) {
      if (this.formProposta.controls['ore'].valid) {
        let ore = +String(this.formProposta.controls['ore'].value);
        if (ore < this.selectedTipologiaServizio!.oreConsentiteMin! || ore > this.selectedTipologiaServizio!.oreConsentiteMax!) {
          this.formProposta.controls['ore'].setErrors({outOfRange: {
            range: "" + this.selectedTipologiaServizio!.oreConsentiteMin + "-" + this.selectedTipologiaServizio!.oreConsentiteMax
          }});
          return;
        }

        this.serviziService.getSommaIncontri(String(this.servizio.idServizio))
            .subscribe(resp => {
              if (ore < resp.sommaIncontri!) {
                this.formProposta.controls['ore'].setErrors({msg:
                  "Attenzione: La somma delle ore degli incontri associati è superiore alle ore selezionate"
                });
                return;
              }
              this.oreProposte = String(this.formProposta.controls['ore'].value);
              this.isNewProposta[0] = true;
              this.dialogRef.close();
              this.propostaFattaDaSalvare = true;
            });
      }
      else return;
    } else {
      if (this.formProposta.controls['dest'].valid){
        const numDestinatari = +String(this.formProposta.controls['dest'].value);
        if (numDestinatari < 1 || numDestinatari > 99) {
          this.formProposta.controls['dest'].setErrors({outOfRange:{ range: "1-99"}});
          return;
        }
        this.serviziService.getDestinatariAssociati(String(this.servizio.idServizio)).subscribe({
          next: resp => {
            if (+String(this.formProposta.controls['dest'].value) < resp.length) {
              this.formProposta.controls['dest'].setErrors({msg:
                "Attenzione: il campo Numero destinatari indicato è inferiore alla somma dei destinatari già inseriti a fronte del Servizio"
              });
              return
            }
            this.desProposte = String(this.formProposta.controls['dest'].value);
            this.isNewProposta[1] = true;
            this.dialogRef.close();
            this.propostaFattaDaSalvare = true;
          }
        })
      }
      else return;
    }
  }

  apriModale(isOre:boolean = false) {
    this.isOre = isOre;
    this.formProposta.reset()

    this.dialogRef = this.dialog.open(this.proposta, {
      maxHeight: "800px",
      width: "500px",
      panelClass: "ClasseCss",
    });

  }
  //--------------------------------------

  //------------------------------------------------------------------------------------------------------
  //- Chiudi Servizio
  dialogChiusura:any
  onChiudi() {
    this.serviziService.checkChiusura(this.servizio.idServizio!).subscribe({
      next: async ris => {

        const destDati= await lastValueFrom(this.serviziService.verificaDatiPeculiariMancanti(this.servizio.idServizio!,this.homeBag.selectedSportello.numProgrSportello!,this.homeBag.selectedPso.idPso!))

        if (destDati.length != 0){
          this.rowData = destDati.map(destinatario => {
            return {
              codFisc:destinatario.codiceFiscaleDestinatario!,
              nome:destinatario.nomeDestinatario!,
              cognome:destinatario.cognomeDestinatario!,
              dataNascita:new Date(destinatario.dNascita!).toLocaleDateString(),
              luogoNascita:destinatario.comuneNascita?
                destinatario.comuneNascita.descrizioneComune + " ("+destinatario.comuneNascita.provincia?.siglaProvincia+")":
                destinatario.descrCittaEsteraNascita + " " + destinatario.statoEsteroNascita?.decrizioneStato,
              icons: [
                new InfoColumnActionSettingModel(
                  IconsSettings.DATI_CORR_ICON,
                  "icon",
                  "Dati Peculiari",
                  (row)=>{
                    this.destinatario=this.data.find(dest=>dest.codiceFiscaleDestinatario==row.codFisc.toString())
                    this.destinatariService.getDatiPeculiari(destinatario?.idDestinatario!,this.serviziService.servizio?.idServizio!,this.homeBag.selectedPso.idPso!,this.homeBag.selectedSportello.numProgrSportello!).subscribe(
                      {
                        next: response=>{
                          this.datiPeculiari=response
                          this.modaleDatinCorrelati= this.dialog.open(DialogDatiParticolariComponent,
                            {
                              data: new DialogSettings(
                                "",[],"","",
                                [new DialogButton(
                                   "Annulla",
                                   "btn btn--outline-primary",undefined,"annulla"),
                                 new DialogButton(
                                   "Conferma",
                                   "btn btn--primary",
                                   (datiPeculiari)=>{this.onConfermaModificaDatiParticolari(datiPeculiari,destinatario)}
                                 ,"conferma modifica dati peculiari")],
                                [destinatario,this.datiPeculiari]
                              )
                            }
                          )

                        }
                      }
                    )
                  },"modifica dati particolari del destinatario"
                )
              ]
            }
          }
          )
          this.dialogDatiParticolari=this.dialog.open(this.datiParticolari,{

            panelClass: "ClasseCss",
          })

        } else if(ris.esisteIncontroNonChiuso) {
          this.openAttentionDialog(["Attenzione: non è possibile chiudere il Servizio perché esiste almeno un Incontro (correlato ad esso) non ancora chiuso. Si prega di chiudere tutti gli Incontri del Servizio e riprovare"])
          return;
        } else if(ris.sommaDurataIncontriConfrontoDiDurataOre) {
          this.testoDialogChiusura="Attenzione: la somma della durata degli Incontri del Servizio è inferiore alla durata indicata per il Servizio stesso.\n Se si desidera proseguire comunque (l\'azione di chiusura del Servizio non è reversibile), indicare la data effettiva di chiusura del Servizio e confermare."
          this.openDialogChiusura();
          return;
        } else {
          this.testoDialogChiusura="Attenzione: la chiusura di un Servizio è un'azione non reversibile. Se si decide di proseguire, indicare la data effettiva di chiusura e confermare."
          this.openDialogChiusura();
          return;
        }
      }
    })
  }

  openDialogChiusura(){
    this.dialogChiusura=this.dialog.open(this.chiusura, {
      maxHeight: "800px",
      width: "500px",
      panelClass: "ClasseCss",
    });
  }

  onRiportaInDefinizione() {
    this.incontriService.getIncontri(this.serviziService.servizio.idServizio!).subscribe({
      next: (incontri: Incontro[]) => {
        const ciSonoIncontriChiusi = incontri.find(x => x.statoIncontro?.idStatoIncontro === 40) !== undefined;
        if (ciSonoIncontriChiusi) {

          this.dialog.open(DialogConfermaComponent, {
            data: new DialogSettings(
              'Riporta servizio in Definizione',
              ['Attenzione! È presente almeno un Incontro chiuso per il Servizio; se si riapre il Servizio, tutti gli Incontri chiusi verranno riaperti e occorrerà poi procedere con una successiva chiusura. Si desidera procedere?'],
              'card-body--warning',
              'Attenzione!',
              [
                new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
                new DialogButton('Conferma', 'btn btn--danger', () => {
                  this.doRiportaInDefinizione();
                },"riporta servizio in definizione"),
              ]
            ),
          });
        } else {
          this.doRiportaInDefinizione();
        }
      }
    });
  }

  doRiportaInDefinizione() {
    let body: ServizioGamRiapriServizio = {
      idServizio: this.serviziService.servizio.idServizio,
      codiceFiscaleUtente: JSON.parse(localStorage.getItem('userInfo')!).codFisc
    }
    this.incontriService.riportaServizioInDefinizione(body).subscribe({
      next: () => {
        this.openOkDialog(["Servizio riaperto correttamente"], () => {
          this.riportaInDefinizione = false
          this.serviziService.reload();

          // ricarico gli incontri
          this.incontriTab.fetchIncontri()

          // cancello le spese - task #23
          this.spesaTab.reset()
        })
      },
      error: err => {
        console.error(err);
        this.openAttentionDialog(["Attenzione: si è verificato un errore tecnico, si prega di riprovare ed eventualmente contattare l'assistenza"]);
      }
    });
  }

  onConfermaModificaDatiParticolari(datiPeculiari: DatiPeculiari, destinatario:Destinatario) {
    this.destinatariService.aggiornaDatiPeculiariDest(datiPeculiari).subscribe(
      resp=> {
        this.datiPeculiari=resp
        this.modaleDatinCorrelati.close()
        this.rowData.splice(this.rowData.findIndex(dest=>destinatario?.codiceFiscaleDestinatario==dest.codFisc),1)
        this.rowData = [...this.rowData]
    })
  }

  handleChiusura() {
    this.formChiusura.get("dataChiusura")?.markAsTouched()
    if (this.formChiusura.invalid) {
      return
    }
    let data =new Date(this.formChiusura.get("dataChiusura")?.value!)

    this.serviziService.richiestaChiusura(this.richiestaChiusuraServizio(data)).subscribe({
      next: ris => {
        if(ris.idServizio){
          this.serviziService.setServizio(ris)
          this.serviziService.setIsModificabile(false)
          this.dialogChiusura.close()
          this.riferimentoForm.disable()
        } else {
          this.openAttentionDialog([ris.errorMessage])
        }
      }
    });
  }

  richiestaChiusuraServizio(dataChiusura: Date): ServizioGamChiudiServizio {
    return{
      numProgrSportello:this.homeBag.selectedSportello.numProgrSportello,
      codOperatore:Number(this.homeBag.codiceOperatore),
      gruppoOperatore:this.homeBag.gruppoOperatore,
      idPso:this.homeBag.selectedPso.idPso,
      codiceFiscaleUtente:this.homeBag.userInfo.codFisc,
      dataChiusuraServizio:dataChiusura,

      idServizio:this.servizio.idServizio
    }
  }


  //------------------------------------------------------------------------------------------------------
  //- GESTIONE SALVATAGGIO
  onSalva() {
    this.form.markAllAsTouched();
    if (this.form.controls['durataOre'].invalid || this.form.controls['numDestinatari'].invalid || this.form.controls['numeroFamiglie'].invalid) return;
    if (this.form.invalid || this.riferimentoForm.invalid){
      this.openAttentionDialog(["dati obbligatori mancanti"])
      return;
    }
    this.servizio.valoreCampoAggiuntivo1 = this.form.get("numeroFamiglie")?.value!;
    if (this.isSaved) {
      this.handlerUpdateServizio();
    } else {
      this.handlerNewServizio();
    }
  }

  handlerNewServizio() {
    let servizio = this.createNewServizio();
    this.serviziService.addServizio(servizio)
        .subscribe(resp => {
          this.serviziService.setServizio(resp);
          this.serviziService.changeSelectedServizio(resp)
          this.serviziService.setIsSaved(true);
          this.setPristine();
          this.confermaSalvataggio();        //-Dialog
          this.handlerFormOnSaved(true);
          this.handlerIconTab();

        })
  }

  handlerUpdateServizio() {
    let updatedServizio = this.createUpdatedServizio();
    this.serviziService.getDestinatariAssociati(String(this.servizio.idServizio)).subscribe({
      next: resp => {
        if(updatedServizio.numMaxDestinatari!< resp.length){
          this.segnalaModificaDestinatariNonCorretta()
          return
        }
        this.serviziService.getSommaIncontri(String(this.servizio.idServizio))
        .subscribe(resp2 => {
          if (updatedServizio.durataOre! < resp2.sommaIncontri!) {
            this.segnalaModificaOreNonCorretta();
            return;
          }
          this.updateServizio(updatedServizio);
        });
      }
    })
  }

  updateServizio(updatedServizio:Servizio) {
    this.serviziService.updateServizio(updatedServizio)
      .subscribe(resp=> {
        this.serviziService.setServizio(resp);

        //- Proposta modifica
        if (this.isNewProposta[0] || this.isNewProposta[1]) {

          // Questa è la vera "proposta modifica" che viene inviata a GAM
          this.postPropostaModifica(this.createServizioGamPropostaModifica());
        } else {
          this.serviziService.changeSelectedServizio(resp);
          this.confermaSalvataggio();
        }
      });
  }

  createServizioGamPropostaModifica():ServizioGamPropostaModifica{
    return {
      numProgrSportello: this.homeBag.selectedSportello.numProgrSportello,
      codOperatore: +(this.homeBag.codiceOperatore),
      gruppoOperatore: this.homeBag.gruppoOperatore,
      idPso: this.homeBag.selectedPso.idPso,
      codiceFiscaleUtente: this.homeBag.userInfo.codFisc,

      durataOreProposta: this.isNewProposta[0]? +(this.oreProposte): this.servizio.durataOre,
      numMaxDestinatariProposto:this.isNewProposta[1]? +(this.desProposte): this.servizio.numMaxDestinatari,

      servizio: this.servizio
    };
  }

  postPropostaModifica(propostaModifica:ServizioGamPropostaModifica){
    this.esisteElaborazioneInCorso = true;
    this.esisteElaborazione03InCorso = true;
    this.tokenGamService.postPropostaModifca(propostaModifica)
        .subscribe(risp=>{
          this.setDatiToken(risp);

          if(!risp.codEsitoElaborazione){
            this.visibilityAggiorna = true;
          }

          this.oreProposte = risp.durataOreProposta!.toString();
          this.desProposte = risp.numMaxDestinatariProposto!.toString();
          this.propostaFattaDaSalvare = false;

          this.confermaSalvataggio();
        });
  }

  setDatiToken(token:TokenGam){
    // caso tipico: richiesta asincrona 03, token_elab_gam valorizzato, cod_esito_elaborazione inizialmente null e
    // poi viene valorizzato a fine elaborazione (sia OK sia KO)
    // altro caso: errore in fase di assegnazione token gam, l'elaborazione non parte proprio
    this.datiToken = {
                      id: token.idTokenGam!.toString(),
                      dataRichiesta: new Date(token.dInvioRichiesta!).toLocaleDateString(),
                      statoRichiesta: token.idTokenElabGam ? (token.codEsitoElaborazione ? "Elaborata": "In corso") : "Non avviata",
                      esitoRichiesta: token.idTokenElabGam ? (!token.codEsitoElaborazione
                                          ?"N.D"
                                          :((token.codStatoElaborazione == 'IA') ?"Positivo" :"Negativo - "+ token.descrEsitoElaborazione))
                                      : "Negativo"
                    };
  }

  //------------------------------------------------------------------------------------------------------
  //--GESTIONE PULSANTE AGGIORNA - PER GAM
  onAggiornaProposta(clicked: boolean = false) {
    this.tokenGamService.getTokenGamServizio(this.servizio.idServizio!.toString())
      .subscribe(tokens => {
        this.onAggiornaPropostaInternal(tokens, clicked)
      });
  }

  onAggiornaPropostaInternal(tokens: TokenGam[], clicked: boolean = false) {
    this.recalcFlags(tokens);
    tokens = tokens
      .filter(t => t.codTipoRichiestaGam === "03")
      .sort((a, b) => new Date(a.dInvioRichiesta!).getTime() - new Date(b.dInvioRichiesta!).getTime());
    if (!tokens.length) {
      if (clicked) {
        // non ci sono token?! qualcuno li ha eliminati
        this.serviziService.reload();
      }
      return;
    }
    let last = tokens[tokens.length - 1];
    this.setDatiToken(last);
    if (last.codStatoElaborazione == 'IA') {
      this.visibilityAggiorna = !last.codEsitoElaborazione;
      if (this.datiToken.statoRichiesta == "Elaborata") {
        if (clicked) {
          this.servizio.durataOre = +this.oreProposte;
          this.servizio.numMaxDestinatari = +this.desProposte;
          this.form.controls['durataOre'].setValue(this.oreProposte);
          this.form.controls['numDestinatari'].setValue(this.desProposte);
        }
        this.desProposte = "";
        this.oreProposte = "";
        this.isNewProposta.fill(false);
      } else {
        this.oreProposte = last.durataOreProposta!.toString();
        this.desProposte = last.numMaxDestinatariProposto!.toString();
      }
    } else {
      this.visibilityAggiorna = !!last.idTokenElabGam && !last.codEsitoElaborazione;
    }

    if (clicked && last.codStatoElaborazione) {
      // elaborazione terminata
      this.serviziService.reload();
    }
  }

  //------------------------------------------------------------------------------------------------------
  //--CREAZIONE SERVIZIO
  createNewServizio(): Servizio {
    let newServizio: Servizio = this.createNeoServizio();
    newServizio.statoServizio = {idStatoServizio:10}
    newServizio.servizioRegionale = this.selectedTipologiaServizio;

    if (this.selectedTipologiaServizio?.codFinalitaServizio=="I") newServizio.numMaxDestinatari = 1;

    newServizio.codUserInserim = this.homeBag.userInfo.codFisc;
    newServizio.dInserim = new Date();
    return newServizio;
  }

  createUpdatedServizio(): Servizio {
    let updatedServizio = this.createNeoServizio();
    updatedServizio.idIntervento= this.servizio.idIntervento;
    updatedServizio.idServizio = this.servizio.idServizio;
    updatedServizio.statoServizio = {idStatoServizio: this.servizio.statoServizio?.idStatoServizio};
    updatedServizio.servizioRegionale = this.servizio.servizioRegionale;
    updatedServizio.codCondizioneOccupazionaleIgrue=this.servizio.codCondizioneOccupazionaleIgrue;
    updatedServizio.codTitoloStudioIgrue=this.servizio.codTitoloStudioIgrue;
    updatedServizio.flgDisabilita=this.servizio.flgDisabilita;
    updatedServizio.flgSvantaggioAbitativo=this.servizio.flgSvantaggioAbitativo;
    updatedServizio.valoreDatoPeculiare1=this.servizio.valoreDatoPeculiare1;
    updatedServizio.valoreDatoPeculiare2=this.servizio.valoreDatoPeculiare2;
    updatedServizio.valoreCampoAggiuntivo1=this.servizio.valoreCampoAggiuntivo1;

    if(this.selectedTipologiaServizio?.codFinalitaServizio=="I") updatedServizio.numMaxDestinatari = 1;

    updatedServizio.codUserInserim = this.servizio.codUserInserim;
    updatedServizio.dInserim = this.servizio.dInserim;
    return updatedServizio;
  }

  createNeoServizio(): Servizio {
    let newServizio: Servizio = {};

    newServizio.titoloServizio = this.form.controls['titolo'].value!;
    newServizio.areaTerritoriale = this.form.controls['territorio'].value
                                    ?{codAreaTerritoriale:this.form.controls['territorio'].value}
                                    :{};
    newServizio.idIntervento = this.formIntervento ?this.interventiService.intervento.idIntervento :undefined;

    if (this.form.controls['classificazione'].value) {
      newServizio.idPso = this.homeBag.selectedPso.idPso;
      newServizio.classificazione =  this.classificazioniPor[+this.form.controls['classificazione'].value]
    }

    newServizio.soggettoAttuatore = this.createSoggettoAttuatore();
    newServizio.progressivoSede = this.form.controls['sedeRiferimento'].value ? Number(this.form.controls['sedeRiferimento'].value) : undefined;
    newServizio.durataOre = +(this.form.controls['durataOre'].value! as string).replace(",",".");
    newServizio.numMaxDestinatari = +this.form.controls['numDestinatari'].value!;
    newServizio.valoreCampoAggiuntivo1 = this.form.controls['numeroFamiglie'].value!;
    newServizio.codUserAggiorn = this.homeBag.userInfo.codFisc;
    newServizio.dAggiorn = new Date();
    newServizio.referenteCognome= this.riferimentoForm.get('cognome')!.value!.toString();
    newServizio.referenteNome=this.riferimentoForm.get("nome")?.value?.toString();
    newServizio.referenteEmail=this.riferimentoForm.get("email_pec")?.value?.toString();
    newServizio.referenteTelefono=this.riferimentoForm.get("telefono")?.value?.toString();
    return newServizio;
  }

  createSoggettoAttuatore():SoggettoAttuatore{
    return{
      modelId: this.istanzeCandidatura[+this.form.controls['candidatura'].value!].modelId,
      codOperatore: Number(this.homeBag.codiceOperatore),
      numProgrSportello: this.homeBag.selectedSportello.numProgrSportello,
      gruppoOperatore: this.homeBag.gruppoOperatore,
    }
  }



  //------------------------------------------------------------------------------------------------------
  //--Dialog
  confermaSalvataggio() {
    this.openOkDialog(["I dati sono stati salvati correttamente"])
  }

  openOkDialog(msg:string[], action?: () => void) {
    let button: DialogButton = new DialogButton('OK', 'btn btn--success', undefined, "OK")
    let ref = this.openDialog("Avviso", msg, "card-body--success", [button])
    if (action) {
      // LV 2025-06 eseguo l'azione anche se l'utente clicca sullo sfondo per chiudere,
      // indipendentemente dal bottone
      ref.afterClosed().subscribe(result => {
        action();
      });
    }
  }
  openAttentionDialog(msg:string[], buttons?:DialogButton[]) {
    this.openDialog("Attenzione!",msg,"card-body--warning", buttons)
  }

  segnalaModificaOreNonCorretta() {
    this.openAttentionDialog(["Il campo Durata in ore non rispetta i limiti previsti la somma delle ore degli incontri associati è superiore alle ore selezionate",
                             ]);
  }

  segnalaDurataNonCorretta() {
    this.openAttentionDialog(["Il campo Durata in ore non rispetta i limiti previsti:",
                              "Il campo deve essere compreso tra "+
                              "min: "+
                              this.selectedTipologiaServizio!.oreConsentiteMin+
                              "h - max: "+
                              this.selectedTipologiaServizio!.oreConsentiteMax+"h"]);
  }

  segnalaModificaDestinatariNonCorretta() {
    this.openAttentionDialog(["Attenzione: il campo Numero destinatari indicato è inferiore alla somma dei destinatari già inseriti a fronte del Servizio"]);
  }

  openDialog(title:string, msg:string[],cssClass:string,buttons?:DialogButton[]) {
    return this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(title, msg, cssClass, "", buttons)
    })
  }


  //----------------------Tabella dati particolari in chiusura--------------------------------------------
  createTable(){
    this.tableSettings.title="";
    this.tableSettings.enablePagination=false;
    this.createColumnsTable();
  }

  createColumnsTable(){
    const codFiscColumn = new ColumnSettingsModel(
      'codFisc',
      'Codice fiscale',
      false,
      'simple'
    );
    const cognomeColumn = new ColumnSettingsModel(
      'cognome',
      'Cognome',
      false,
      'simple'
    );
    const nomeColumn = new ColumnSettingsModel(
      'nome',
      'Nome',
      false,
      'simple'
    );
    const dataNascitaColumn = new ColumnSettingsModel(
      'dataNascita',
      'Data di nascita',
      false,
      'simple'
    );
    const luogoNascitaColumn = new ColumnSettingsModel(
      'luogoNascita',
      'Luogo di nascita',
      false,
      'simple'
    );
    const customActionColumn = new ColumnSettingsModel(
      'icons',
      '',
      true,
      'customAction'
    );
    this.columnList.push(...[
      codFiscColumn,
      cognomeColumn,
      nomeColumn,
      dataNascitaColumn,
      luogoNascitaColumn,
      customActionColumn
    ]);
  }

  isPristine(): boolean{
    // il formProposta non posso controllarlo direttamente
    return this.form.pristine && this.riferimentoForm.pristine && !this.propostaFattaDaSalvare;
  }

  setPristine() {
    this.form.markAsPristine();
    this.riferimentoForm.markAsPristine();
    this.formProposta.markAsPristine();
    // resetto anche la proposta modifica
    this.propostaFattaDaSalvare = false;
    this.oreProposte = "";
    this.desProposte = "";
    this.isNewProposta.fill(false);
  }

  onTabClick($event: TabClickInterceptorEvent) {
    this.pristineService.checkPristine(() => {
        this.selectedTab = $event.tabIndex;
        this.serviziService.reload();
      }, undefined, () => {
        $event.preventDefault();
    });
  }

  //------------------------------------------------------------------------------------------------------
  //--GETTER
  get isSaved(){
    return this.serviziService.isSaved;
  }
  get isModificabile(){
    return this.serviziService.isModificabile;
  }
  get servizio(){
    return this.serviziService.servizio;
  }
  get stato(){
    return this.servizio.statoServizio?.idStatoServizio;
  }
  get statoDescrizione(){
    return this.servizio.statoServizio?.descrStatoServizio;
  }
  get codiceFiscaleIns(){
    return this.servizio.codUserInserim
  }
  get codiceFiscaleAgg(){
    return this.servizio.codUserAggiorn
  }
  get dataIns(){
    return this.servizio.dInserim
  }
  get dataAgg(){
    return this.servizio.dAggiorn
  }
  get soggettoAttuatoreCompetente(){
    return this.servizio.soggettoAttuatore?.gruppoOperatore+""
            +this.servizio.soggettoAttuatore?.codOperatore+"-"
            +this.servizio.soggettoAttuatore?.denominazioneGiuridica
  }
  get backTo(){
    return this.serviziService.backTo;
  }
  get isIndividuale(){
    return this.servizio.servizioRegionale?.codFinalitaServizio=='I';
  }

  recalcFlags(tokens: TokenGam[]){
    // assumo che this.servizio sia già settato
    const stato = this.servizio.statoServizio?.idStatoServizio;

    // Possibilità per la tabella dei token:
    // richiesta async:
    // statoRichesta <> PC -> la richiesta è terminata, non è stata presa in carico
    // statoRichiesta = PC && codEsitoElaborazione == null -> presa in carico
    // statoRichiesta = PC && codEsitoElaborazione != null -> terminata (codStatoElaborazione == IA se positiva)
    //
    // richiesta sync:
    // statoRichiesta = PC -> prima di inziare la richiesta
    // statoRichiesta = SOAE00005 -> terminata OK
    // statoRichiesta <> PC e <> SOAE00005 -> terminata errore
    const elaborazioniInCorso = tokens.filter(x => x.codStatoRichiesta == "PC" && !x.codEsitoElaborazione)
    this.esisteElaborazioneInCorso = elaborazioniInCorso.length > 0;
    this.serviziService.setEsisteElaborazioneInCorso(this.esisteElaborazioneInCorso);
    this.esisteElaborazione03InCorso = elaborazioniInCorso.some(t => t.codTipoRichiestaGam == "03"); // serve ???

    // i parametri esisteElaborazioneInCorso e propostaFattaDaSalvare NON influenzano la visibilità del pulsante ma il "disabled"

    this.canPropostaOre = this.isModificabile && (stato == 22 || stato==30) && this.isSaved ;
    this.canPropostaDest = this.isModificabile && (stato == 22 || stato==30) && this.isSaved && !this.isIndividuale;
    this.chiudibile = this.isModificabile && stato == 30 && this.isSaved;
    this.riportaInDefinizione = this.isModificabile && (stato == 22 || stato==30) && this.isSaved;
  }

  get identificativoServizio(){
    return this.servizio.idServizio?.toString();;
  }
  get identificativoIntervento(){
    return this.servizio.idIntervento?.toString();
  }
  get identificativoModello(){
    return this.intervento.idModelloIntervento?.toString();
  }
}
