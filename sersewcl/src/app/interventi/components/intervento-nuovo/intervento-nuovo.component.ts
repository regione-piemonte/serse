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

import { AfterViewInit, Component, OnDestroy, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { catchError, of, Subscription } from 'rxjs';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

// Models
import { Intervento } from '@core/api-serse/model/intervento';
import { Referente } from '@core/api-serse/model/referente';
import { TipoIntervento } from '@core/api-serse/model/tipoIntervento';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { ModelliService } from '@modelli/services/modelli.service';
import { ModelloInterventoWrapper } from '@core/api-serse/model/modelloInterventoWrapper';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';

// Services
import { HomeBagService } from '@home/services/home-bag.service';
import { CriteriRicercaInterventiService } from '@interventi/services/criteri-ricerca-interventi.service';
import { TitleService } from '@core/services/title.service';
import { InterventiService } from '@interventi/services/interventi.service';

// Components
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { InterventoCorrelatiComponent } from '../intervento-correlati/intervento-correlati.component';
import { IconsSettings } from '@shared/const/icons-settings'
import { Validation } from '@shared/utils/validation';
import { PristineService } from '@home/services/pristine.service';
import { Pristinable } from '@home/models/pristinable';
import { MatTabGroup } from '@angular/material/tabs';
import { TabClickInterceptorEvent } from '@shared/directives/tab-click-interceptor.directive';

@Component({
  selector: 'app-intervento-nuovo',
  templateUrl: './intervento-nuovo.component.html',
  styleUrls: ['./intervento-nuovo.component.scss']
})
export class InterventoNuovoComponent implements OnInit, OnDestroy, AfterViewInit, Pristinable {

  backToSearch = false;
  selectedTab: number = 0;
  riferimentoA = 'intervento';

  //------------Selects
  private _tipologieIntervento: TipoIntervento[] = [];
  private _istanzeCandidature: SoggettoAttuatore[] = [];

  //------------Form
  datiForm = this.fb.group({
    titolo: ['', Validators.required],
    descrizione: ['', ],
    candidatura: ['', Validators.required],
    tipo: ['', Validators.required]
  });
  riferimentoForm = this.fb.group({
    cognome: ['', [Validators.required, Validation.cognomeNomeValidator(false)]],
    nome: ['', [Validators.required, Validation.cognomeNomeValidator(true)]],
    telefono: ['', [Validators.required, Validation.phoneNumberValidator]],
    email_pec: ['', [Validators.required, Validation.emailValidator]]
  });
  form = this.fb.group({
    datiGenerali : this.datiForm,
    rifModello: this.riferimentoForm
  });

  subscriptionOnReload!: Subscription;

  //-------------Modello Assocciato
  modelloAssociato: ModelloInterventoWrapper|null = null;

  @ViewChild(MatTabGroup, { static: false }) tabGroup!: MatTabGroup;

  //-----------------------------------------------------------------------------------------------------------
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private dialog: MatDialog,
    private title: TitleService,
    private homeBag: HomeBagService,
    private criteriRicerca: CriteriRicercaInterventiService,
    private interventiService: InterventiService,
    private modelliService: ModelliService,
    private _snackBar: MatSnackBar,
    private pristineService: PristineService,
    private renderer: Renderer2
  ) {

    if(!router.url.endsWith("nuovo")){
    //   interventiService.setIsModificabile(true);
    //   interventiService.setIsSaved(false);
    //   interventiService.setIntervento({});
    //   interventiService.isProprietario = true;
    //   this.interventiService.tab = 0;
    // }else{
      this.backToSearch = true;
      if(!this.intervento.idIntervento ){
        interventiService.reset();
        router.navigate(['/dashboard/intervento/nuovo']);
        interventiService.tab = 0;
      }
    } else {
      //Reset variabili nel caso di nuovo inserimento
      this.interventiService.reset();
    }

    this.updateSelects();
  }

  ngOnInit(): void {
    this.title.setTitle(this.router.url.endsWith("nuovo") ?"Nuovo intervento" :"Modifica intervento");
    this.title.setIcon(IconsSettings.INTERVENTI_ICON);

    this.subscriptionOnReload = this.interventiService.selectionChangeIntervento$.subscribe({next:()=>this.onReloadIntervento()});

    //#############-identificativo-#################
    if (!this.interventiService.isModificabile) {
      this.form.disable()
    } else if(this.interventiService.isModificabile &&
      this.interventiService.isSaved &&
      this.interventiService.intervento
          .statoIntervento?.idStatoIntervento != 10) {
      this.disableSelects()
    }
    if (this.interventiService.isSaved) {
      this.loadDataForm();
      if (this.interventiService.intervento.idModelloIntervento) {
        this.disableSelects();
        this.getModelloAssociato();
      }
    }
    this.selectedTab = this.interventiService.tab;
    this.interventiService.tab = 0;
    this.pristineService.componentAttivo = this;
  }

  ngAfterViewInit(): void {
    if(!this.isSaved) return;
  }

  ngOnDestroy(): void {
    this.pristineService.componentAttivo = undefined;
    this.subscriptionOnReload.unsubscribe();
  }

  onReloadIntervento() : void {
    this.loadDataForm();
  }

  disableSelects(){
    this.datiForm.get("candidatura")?.disable();
    this.datiForm.get("tipo")?.disable();
  }
  enableSelects(){
    this.datiForm.get("candidatura")?.enable();
    this.datiForm.get("tipo")?.enable();
  }

  enableIfTrueOrDisable(enable:boolean){
    if(enable){
      this.enableSelects()
      return
    }
    this.disableSelects()
  }

  // Selects dati identificativi
  updateSelects(){
    this.updateTipiIntervento();
    this.updateIstanzeCandidatura();
  }

  updateTipiIntervento(){
    this.criteriRicerca.getTipiIntervento(this.idPso)
      .subscribe({
          next: (response) => {
              this._tipologieIntervento = response;
              if(this.interventiService.isSaved){
                this.datiForm.get('tipo')
                     ?.setValue(
                      this.findIndexOftipoIntervento(this.interventiService.intervento.tipoIntervento!))
                }else{
                  this.datiForm.get('tipo')?.setValue(null)
                }
              }
      });
  }

  updateIstanzeCandidatura(){
    this.criteriRicerca.getIstanzeCandidatura(
                this.homeBag.selectedSportello.numProgrSportello!.toString(),
                this.homeBag.codiceOperatore,
                this.homeBag.gruppoOperatore)
        .subscribe({
          next: (response) => {
              this._istanzeCandidature = response;
              if(this.interventiService.isSaved){
                this.datiForm.get('candidatura')
                      ?.setValue(
                        this.findIndexOfCandidatura(this.interventiService.intervento.soggettoAttuatore!))
              }else{
                this.datiForm.get('candidatura')?.setValue(null)
              }
        }});
  }

  //---Gestione Form
  loadDataForm(){
    this.datiForm.get('titolo')?.setValue(this.interventiService.intervento.titolo!);
    this.datiForm.get('descrizione')?.setValue(this.interventiService.intervento.descrizione!);

    this.riferimentoForm.get('cognome')?.setValue(this.interventiService.intervento.referente?.referenteCognome!);
    this.riferimentoForm.get('nome')?.setValue(this.interventiService.intervento.referente?.referenteNome!);
    this.riferimentoForm.get('telefono')?.setValue(this.interventiService.intervento.referente?.referenteTelefono!);
    this.riferimentoForm.get('email_pec')?.setValue(this.interventiService.intervento.referente?.referenteEmail!);
  }

  findIndexOftipoIntervento(tipoModello: TipoIntervento):string{
    return this._tipologieIntervento
                .findIndex((a)=> a.codTipoIntervento === tipoModello.codTipoIntervento)
                .toString();
  }

  findIndexOfCandidatura(candidatura:SoggettoAttuatore){
    return this._istanzeCandidature
                .findIndex((a)=> a.modelId === candidatura.modelId
                                /*&& a.gruppoOperatore === candidatura.gruppoOperatore
                                && a.codOperatore === candidatura.codOperatore*/)
                .toString();
  }

  //---Gestione Salva ed Aggiorna
  onSalva(){
    this.form.markAllAsTouched()
    if(this.form.valid){
      this.saveUpdate();
    }else{
      this._snackBar.open("Attenzione: dati obbligatori mancanti e/o dati inseriti non corretti", "chiudi", {
        duration:5000,
      });
    }
  }

  saveUpdate(){
    //##-Aggiorno Modello-##
    if(this.interventiService.isSaved){
      this.handleUpdateIntervento();
    }
    //##-Nuovo Modello-##
    else{
      this.handleAddIntervento();
    }
  }

  handleUpdateIntervento(){
    let interventoUpdated = this.createInterventoUpdated();

    this.interventiService
        .getTestModificaIntervento(this.interventiService.intervento.idIntervento!.toString(),
                                    this.homeBag.selectedSportello.numProgrSportello!.toString())
        .pipe(catchError(this.handleFailedAggiornamentoStato))
        .subscribe(resp => {
          if(!resp) return;

          //---------------------------------------------------------------------------
          //-a
          if(interventoUpdated.tipoIntervento?.flgProgettazioneIndividuale !=
            this.interventiService.intervento.tipoIntervento?.flgProgettazioneIndividuale){


          //---------------------------------------------------------------------------
          //-b
            if(resp.idModelloIntervento){
              this.openModaleErrore(["Attenzione",
                                      "Non è possibile modificare il Tipo intervento se all'Intervento è già associato un Modello di Intervento.",
                                      "Per modificare il Tipo di intervento, disassociare preventivamente il Modello di Intervento e riprovare."])
              return;}
            if(resp.idEnteCoinvoltoIntervento){
              this.openModaleErrore(["Attenzione",
                                      "Non è possibile modificare il Tipo intervento perché esistono degli Enti coinvolti associati all'Intervento.",])
              return;}
            if(resp.idDestinatario){
              this.openModaleErrore(["Attenzione",
                                      "Non è possibile modificare il Tipo intervento perché è già stato associato un Destinatario all'Intervento",])
              return;}
          }
          //---------------------------------------------------------------------------
          //-3
          if(resp.tipoGestioneIntervento == "2" && !resp.idModelloIntervento){
            this.openModaleErrore(["Attenzione",
                                      "La configurazione dell'Avviso prevede che l'Intervento sia obbligatoriamente associato ad un Modello di Intervento.",
                                      "Occorre quindi associare il Modello prima di salvare i dati",]);
              return;
          }
          this.updateIntervento(interventoUpdated);
        })
  }


  handleAddIntervento(){

    if(this.homeBag.gestioneSportello.tipoGestioneIntervento=="2"
        && !this.modelloAssociato ){
      this.openModaleErrore([
        "Attenzione:",
        "la configurazione dell'Avviso prevede che l'Intervento sia obbligatoriamente associato ad un Modello di Intervento.",
        "Occorre quindi associare il Modello prima di salvare i dati"]);
      return;
    }


    this.interventiService.addIntervento(this.createIntervento())
        .pipe(catchError(this.handleFailedSave))
        .subscribe(response => {
          if (!response) return;
          this.interventiService.setIntervento(response);
          this.interventiService.setIsSaved(true);
          this.setPristine();
          if (this.modelloAssociato)
            this.onAssociaModello(this.modelloAssociato);
          this.avvisoSalvataggio();
        })
  }
  createInterventoUpdated():Intervento{
    let interventoUpdated = this.createNeoIntervento();
    let intervento = this.interventiService.intervento;
    interventoUpdated.idIntervento = intervento.idIntervento;
    interventoUpdated.idPso = intervento.idPso;
    interventoUpdated.idModelloIntervento = intervento.idModelloIntervento;
    interventoUpdated.statoIntervento = intervento.statoIntervento;
    interventoUpdated.idDestinatario = intervento.idDestinatario;
    interventoUpdated.codUserInserimento = intervento.codUserInserimento;
    interventoUpdated.dataInserimento = intervento.dataInserimento;
    return interventoUpdated;
  }
  createIntervento():Intervento{
    let _intervento = this.createNeoIntervento();
    _intervento.idIntervento = 0;
    _intervento.idPso = this.homeBag.selectedPso.idPso;
    _intervento.soggettoAttuatore!.codOperatore=Number(this.homeBag.codiceOperatore!);
    _intervento.soggettoAttuatore!.numProgrSportello=this.homeBag.selectedSportello.numProgrSportello;
    _intervento.soggettoAttuatore!.gruppoOperatore=this.homeBag.gruppoOperatore;
    _intervento.statoIntervento = {
      idStatoIntervento: 10,
      descrStatoIntervento: "Bozza"
    }
    // _intervento.idDestinatario = 1;
    _intervento.codUserInserimento = this.homeBag.userInfo.codFisc;
    _intervento.dataInserimento = new Date();
    return _intervento;
  }
  createReferente(): Referente{
    return{
      referenteNome: this.riferimentoForm.get("nome")?.value?.toString(),
      referenteCognome: this.riferimentoForm.get("cognome")?.value?.toString(),
      referenteEmail: this.riferimentoForm.get("email_pec")?.value?.toString(),
      referenteTelefono: this.riferimentoForm.get("telefono")?.value?.toString()
    }
  }
  createSoggettoAttuatore():SoggettoAttuatore{
    return{
      modelId: this._istanzeCandidature[+this.datiForm.get("candidatura")!.value!].modelId,
      codOperatore: Number(this.homeBag.codiceOperatore!),
      numProgrSportello: this.homeBag.selectedSportello.numProgrSportello,
      gruppoOperatore: this.homeBag.gruppoOperatore,
    }
  }
  createNeoIntervento():Intervento{
    let neoIntervento: Intervento = {
      titolo: this.datiForm.get("titolo")?.value?.toString(),
      descrizione: this.datiForm.get("descrizione")?.value?.toString(),
      tipoIntervento: this._tipologieIntervento[+this.datiForm.get("tipo")!.value!],
      soggettoAttuatore: this.createSoggettoAttuatore(),
      referente: this.createReferente(),
      codUserAggiornamento: this.homeBag.userInfo.codFisc,
      dataAggiornamento: new Date()
    }

    return neoIntervento;
  }


  handleFailedSave = (err:any) => {
    this.openModaleErrore(["Attenzione",
                            "salvataggio dati non riuscita.",
                            "Si prega di riprovare ed eventualmente contattare il servizio di assistenza"])
    return of(null)};



  //##################################################
  //--Handling cambio Stato
  updateStatoIntervento(idStato:number){
    if(idStato!=40){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
          "Attenzione",
          ["Sicuro di voler procedere con "+ (this.attivaOrDisattiva(idStato)),
            "Continuare ?"],
          "card-body--warning",
          "",
        [new DialogButton(
            "Annulla",
            "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn " + ("btn--primary"),
          ()=>{this.onConfermaStato(idStato)},
          "conferma "+(this.attivaOrDisattiva(idStato)))]
      )
    });
  }else{this.onConfermaStato(40);}

  }
  attivaOrDisattiva(idStato: number):string{
    return (idStato == 20 ? " l'attivazione":"la disattivazione") + " dell'Intervento";
  }
  onConfermaStato(idStato:number){
    let interventoUpdated = {...this.interventiService.intervento};
    interventoUpdated.statoIntervento = {...this.interventiService.intervento.statoIntervento};
    interventoUpdated.statoIntervento.idStatoIntervento = idStato;

    switch(idStato){
      case 20:
        this.onAttiva(interventoUpdated);
        break;
      case 10:
        this.onDisattiva(interventoUpdated);
        break;
      case 40:
       this.onChiudi(interventoUpdated)
        break;
    }
  }

  onAttiva(interventoUpdated:Intervento){
    if(this.interventiService.intervento.tipoIntervento?.flgProgettazioneIndividuale == "S"
      && !this.interventiService.intervento.idDestinatario){
        this.openModaleErrore(["Attenzione:","non è possibile attivare l'Intervento perché non è stato indicato il Destinatario"])
        return;
    }
    this.updateIntervento(interventoUpdated, true);
  }
  onDisattiva(interventoUpdated:Intervento){
    /*Controllo*/
    this.interventiService
        .getTestModificaIntervento(this.interventiService.intervento.idIntervento!.toString(),
                                    this.homeBag.selectedSportello.numProgrSportello!.toString())
        .pipe(catchError(this.handleFailedAggiornamentoStato))
        .subscribe(resp => {
          if(!resp) return;
          if(resp.isServizioAssociato){
            this.openModaleErrore(
              ["Attenzione","non è possibile disattivare l'Intervento perché sono presenti dei Servizi correlati."])
            return;
          }
          this.updateIntervento(interventoUpdated, true, false);
        })
  }
  onChiudi(interventoUpdated:Intervento){
    this.interventiService.getTestChiusuraIntervento(this.interventiService.intervento.idIntervento!.toString())
    .pipe(catchError(this.handleFailedAggiornamentoStato))
    .subscribe(resp=>{
      if(!resp){
        this.openModaleErrore(["Attenzione","non è possibile chiudere l'Intervento perché sono presenti dei Servizi non chiusi."])
        return;
      }
      this.apriModaleConferma(interventoUpdated);
    })
  }

  updateIntervento(interventoUpdated:Intervento, isStato: boolean=false, attiva:boolean=true){
    this.interventiService.updateIntervento(interventoUpdated)
        .pipe(catchError( isStato ?this.handleFailedAggiornamentoStato :this.handleFailedSave))
        .subscribe(resp => {
              if(!resp) return;
              this.interventiService.setIntervento(resp)
              this.setPristine();
              this.avvisoSalvataggio();
              if(isStato){
                this.enableIfTrueOrDisable(!attiva);
                // issue 2025-IM054746: se l'intervento viene disattivato, gli enti tornano eliminabili, e viceversa
                this.correlati.ricaricaEntiCoinvolti();
              }
              if(interventoUpdated.statoIntervento?.idStatoIntervento==40){
                this.interventiService.setIsModificabile(false)
                this.form.disable();
              }else if(interventoUpdated.statoIntervento?.idStatoIntervento==20){
                this.interventiService.setIsModificabile(true)
                this.form.enable();
              }
        });
  }
  apriModaleConferma(interventoUpdated:Intervento){
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        "Chiusura intervento",
        [
        "Si intende chiudere l'intervento?",
        "Confermi la chiusura"],
        "card-body--warning",
        "Attenzione!",
        [new DialogButton(
            "Annulla",
            "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--danger",
          ()=>{this.updateIntervento(interventoUpdated, true, false);},
          "conferma chiusura intervento")]
      )
    });
  }

  handleFailedAggiornamentoStato = (err:any) => {
    this.openModaleErrore(["Attenzione",
                            "Stato non aggiornato.",
                            "Si prega di riprovare ed eventualmente contattare il servizio di assistenza"])
    return of(null)};

  //###################################################
  // Dialog Info Section
  openDialog(title:string, content:string[], contentClass:string){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
          title,
          content,
          contentClass
      )
    });
  }
  openModaleErrore(msg: string[]){
    this.openDialog("Errore",msg, "card-body--danger")
  }
  avvisoSalvataggio(){
    this.openDialog("Avviso",
                    ["I dati sono stati salvati correttamente."],
                    "card-body--success");
  }
  avvisoSalvataggioStato(){
    this.openDialog("Avviso",
                    ["Lo stato dell'intervento è stato aggiornato correttamente."],
                    "card-body--success");
    /*this.openDialog("Avviso",
    ["Lo stato dell'intervento è stato aggiornato correttamente."],
    "card-body--success");*/
  }


  //####--####
  get isModificabile(){
    return this.interventiService.isModificabile;
  }
  get isSaved(){
    return this.interventiService.isSaved;
  }
  get stato(){
    return this.interventiService.intervento.statoIntervento?.idStatoIntervento;
  }

  get statoDescrizione(){
    return this.interventiService.intervento.statoIntervento?.descrStatoIntervento;
  }

  get tipologieInterventoList(){
    return this._tipologieIntervento.map(tipo => tipo.descrizione!);
  }
  get istanzeCandidaturaList(){
    return this._istanzeCandidature.map(istanza =>  istanza.modelId!.toString()+" - "
                                                    +istanza.gruppoOperatore
                                                    +istanza.codOperatore!.toString()+" - "
                                                    +istanza.denominazioneGiuridica+ " - "
                                                    +istanza.descrAreaTerritoriale)
  }

  get identificativoIntervento(){
    return this.interventiService.intervento.idIntervento?.toString();
  }
  get identificativoModelloIntervento(){
    return this.interventiService.intervento.idModelloIntervento?.toString();
  }

  get codiceFiscaleIns(){
    return this.interventiService.intervento.codUserInserimento;
  }
  get dataIns(){
    return this.interventiService.intervento.dataInserimento;
  }

  get codiceFiscaleAgg(){
   return this.interventiService.intervento.codUserAggiornamento;
  }
  get dataAgg(){
    return this.interventiService.intervento.dataAggiornamento;
  }
  get idPso(){
    return this.homeBag.selectedPso.idPso!.toString()
  }

  get canAssoccia(){
    return this.isModificabile && (this.isSaved ?this.stato == 10 :true)
  }

  get canDisassocia(){
    return (this.homeBag.gestioneSportello.tipoGestioneIntervento!="2" || !this.isSaved) && this.isModificabile && (this.isSaved ?this.stato == 10 :true)
  }

  get istanzaCandidatura(){
    if(this.datiForm.get("candidatura")!.value!){
      return this._istanzeCandidature[+this.datiForm.get("candidatura")!.value!]
    }else{
      return undefined
    }
  }
  get tipo(){
    if(this.datiForm.get("tipo")!.value!){
      return this._tipologieIntervento[+this.datiForm.get("tipo")!.value!]
    }else{
      return undefined
    }
  }
  get intervento(){
    return this.interventiService.intervento;
  }
  get soggettoAttuatoreCompetente(){
    return this.intervento.soggettoAttuatore?.gruppoOperatore+""
            +this.intervento.soggettoAttuatore?.codOperatore+"-"
            +this.intervento.soggettoAttuatore?.denominazioneGiuridica
  }

  get isProprietario(){
    return this.interventiService.isProprietario;
  }

  get canReopen(){
    return this.homeBag.selectedRuolo.codiceRuolo!=='FUNZIONARIO_MASTER_SERSE'
  }

  /*#########-----Associazione modello di intervento------##########*/

  @ViewChild("correlati") correlati!: InterventoCorrelatiComponent;
  onAssociaModello(modello:ModelloInterventoWrapper){
    this.disableSelects()
    if(!this.isSaved){
      this.modelloAssociato = modello;
      if(this.riferimentoForm.invalid){
        this.riferimentoForm.get("cognome")?.setValue(modello.modelloIntervento?.referente?.referenteCognome!)
        this.riferimentoForm.get("nome")?.setValue(modello.modelloIntervento?.referente?.referenteNome!)
        this.riferimentoForm.get("telefono")?.setValue(modello.modelloIntervento?.referente?.referenteTelefono!)
        this.riferimentoForm.get("email_pec")?.setValue(modello.modelloIntervento?.referente?.referenteEmail!)
      }
      return;}
    this.interventiService.associaModello({
      idIntervento:this.interventiService.intervento.idIntervento,
      idModelloIntervento:modello.modelloIntervento?.idModelloIntervento,
      codFiscaleUtente:this.homeBag.userInfo.codFisc
      })
    .pipe()
    .subscribe(r => {
                    this.modelloAssociato = {...modello}
                    this.intervento.idModelloIntervento = modello.modelloIntervento?.idModelloIntervento;
                    this.correlati.handelEntiCoinvolti();
                  })

  }

  onDisassociaModello(){
    this.enableSelects()
    if(!this.isSaved){
      this.modelloAssociato = null;

      return;
    }
    this.interventiService.disassociaModello(
                      this.interventiService.intervento.idIntervento!.toString(),
                      this.modelloAssociato!.modelloIntervento!.idModelloIntervento!.toString())
      .pipe()
      .subscribe(()=>{
        this.modelloAssociato = null;
        this.intervento.idModelloIntervento = undefined;


        //TODO
        this.correlati.handelEntiCoinvolti();
      })

  }
  getModelloAssociato(){
    this.modelliService.getModelloAssociato(this.interventiService.intervento.idModelloIntervento!.toString())
    .pipe()
    .subscribe(resp=>{

      this.modelloAssociato = resp[0]})
  }

  isPristine(){
    return this.form.pristine && this.riferimentoForm.pristine && this.datiForm.pristine;
  }

  setPristine(): void {
    this.form.markAsPristine();
    this.riferimentoForm.markAsPristine();
    this.datiForm.markAsPristine();
  }

  onTabClick($event: TabClickInterceptorEvent) {
    this.pristineService.checkPristine(() => {
        this.selectedTab = $event.tabIndex;
        this.interventiService.reload();
      }, () => {
        this.setPristine();
        this.selectedTab = $event.tabIndex;
        this.interventiService.reload();
      }, () => {
        $event.preventDefault();
    });
  }
}
