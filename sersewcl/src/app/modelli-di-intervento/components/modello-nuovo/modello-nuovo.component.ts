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

import { Component, OnInit , OnDestroy, AfterViewInit, ViewChild, Renderer2 } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { catchError, of, Subscription } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';

// MODELS
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { TipoModello } from '@core/api-serse/model/tipoModello';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { ModelloIntervento } from '@core/api-serse/model/modelloIntervento';
import { TestModelloInterventoModifica } from '@core/api-serse/model/testModelloInterventoModifica';
import { Referente } from '@core/api-serse/model/referente';

// COMPONENTS
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';

// CUSTOME ICON TEXT
import { IconsSettings } from '@shared/const/icons-settings';

//-Services
import { TitleService } from '@core/services/title.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { CriteriModelliRicercaService } from '@modelli/services/criteri-modelli-ricerca.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { Validation } from '@shared/utils/validation';
import { Pristinable } from '@home/models/pristinable';
import { PristineService } from '@home/services/pristine.service';
import { MatTabGroup } from '@angular/material/tabs';
import { TabClickInterceptorEvent } from '@shared/directives/tab-click-interceptor.directive';

@Component({
  selector: 'app-modello-nuovo',
  templateUrl: './modello-nuovo.component.html',
  styleUrls: ['./modello-nuovo.component.scss']
})
export class ModelloNuovoComponent implements OnInit, OnDestroy, AfterViewInit, Pristinable {
  backToSearch = false;
  selectedTab: number = 0;
  riferimentoA = 'modello';

  //------------Selects
  private _tipologieModello: TipoModello[] = [];
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

  @ViewChild(MatTabGroup, { static: false }) tabGroup!: MatTabGroup;

  //------------Handlers
  handleFailedSave = (err:any) => {

    this.openModaleErrore(["Attenzione",
                            "Salvataggio dati non riuscita.",
                            "Si prega di riprovare ed eventualmente contattare il servizio di assistenza."])
    return of(null)};


  constructor(
    private fb: FormBuilder,
    private dialog: MatDialog,
    private criteriRicerca: CriteriModelliRicercaService,
    private homeBag: HomeBagService,
    private title: TitleService,
    private modelliService: ModelliService,
    private router: Router,
    private _snackBar: MatSnackBar,
    private pristineService: PristineService,
    private renderer: Renderer2
  ) {
    // ###-Se atterro cui con "nuovo" nell'indirizzo-###
    // ###-ripulisco il modello selezionato-###
    if(!router.url.endsWith("nuovo")){
    //   modelliService.setIsModificabile(true)
    //   modelliService.setIsSaved(false)
    //   modelliService.setModelloIntervento({});
    //   modelliService.isProprietario = true;
    //   modelliService.tab = 0;
    // }
    // else{
      this.backToSearch = true;
      if(!this.modelloIntervento.idModelloIntervento){
        modelliService.reset();
        router.navigate(['/dashboard/modello/nuovo']);
        modelliService.tab = 0;        
      } 
    } else {
      //Reset variabili nel caso di nuovo inserimento
      this.modelliService.reset();
    }
    this.pristineService.componentAttivo = this;

    this.updateSelects();
  }

  ngOnInit(): void {
    //--------Title
    this.title.setIcon(IconsSettings.MODELLI_ICON);
    this.title.setTitle(this.router.url.endsWith("nuovo") ?"Nuovo modello di intervento" :"Modifica modello di intervento");

    this.subscriptionOnReload = this.modelliService.selectionChangeModello$.subscribe({next:()=>this.onReloadModello()});

    if(!this.modelliService.isModificabile){
      this.form.disable()
    }else if(this.modelliService.isModificabile &&
              this.modelliService.isSaved &&
              this.modelloIntervento.statoModelloIntervento?.idStatoModelloDiIntervento != 10){
      this.datiForm.get("candidatura")?.disable();
      this.datiForm.get("tipo")?.disable();
    }
    if(this.modelliService.isSaved) this.loadDataForm()
    this.selectedTab = this.modelliService.tab;
    this.modelliService.tab = 0;
  }

  ngAfterViewInit(): void {
    if(!this.isSaved) return;
  }

  ngOnDestroy(): void {
    this.pristineService.componentAttivo = undefined;
    this.subscriptionOnReload.unsubscribe();
  }

  onReloadModello() : void {
    this.loadDataForm();
  }

  //###-Carico i dati del form solo per campi come input-###
  //!!!-Nota: i campi come le select che richiedono una chiamata asynchrona sono gestite
  //      nella chiamata
  loadDataForm(){
    this.datiForm.get('titolo')?.setValue(this.modelloIntervento.titolo!);
    this.datiForm.get('descrizione')?.setValue(this.modelloIntervento.descrizione!);

    this.riferimentoForm.get('cognome')?.setValue(this.modelloIntervento.referente?.referenteCognome!);
    this.riferimentoForm.get('nome')?.setValue(this.modelloIntervento.referente?.referenteNome!);
    this.riferimentoForm.get('telefono')?.setValue(this.modelloIntervento.referente?.referenteTelefono!);
    this.riferimentoForm.get('email_pec')?.setValue(this.modelloIntervento.referente?.referenteEmail!);
  }
  //####-Aggiorna le liste-####
  updateSelects(){
    this.updateTipiModello();
    this.updateIstanzeCandidatura()
  }
  updateTipiModello(){
    this.criteriRicerca.getTipiModello(this.homeBag.selectedPso.idPso!.toString())
      .subscribe({
          next: (response) => {
              this._tipologieModello = response;
              if(this.modelliService.isSaved){
                this.datiForm.get('tipo')
                     ?.setValue(this.findIndexOftipoModello(this.modelloIntervento.tipoModello!))}
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

              if(this.modelliService.isSaved){
                this.datiForm.get('candidatura')
                      ?.setValue(this.findIndexOfCandidatura(this.modelloIntervento.soggettoAttuatore!))
              }
          }});
  }
  findIndexOftipoModello(tipoModello: TipoModello):string{
    return this._tipologieModello
                .findIndex((a)=> a.codTipoModello === tipoModello.codTipoModello)
                .toString();
  }
  findIndexOfCandidatura(candidatura:SoggettoAttuatore){
    return this._istanzeCandidature
                .findIndex((a)=> a.modelId === candidatura.modelId
                                /*&& a.gruppoOperatore === candidatura.gruppoOperatore
                                && a.codOperatore === candidatura.codOperatore*/)
                .toString();
  }

  //###################################################
  //####-Gestione del salva e dell'aggiornamento-####
  onSalva(){
    this.form.markAllAsTouched();
    if(this.form.valid){
      this.saveUpdate();
    }else{
      this._snackBar.open("Attenzione: dati obbligatori mancanti e/o dati inseriti non corretti.", "chiudi", {
        duration:5000,
      });
    }
  }
  saveUpdate(){
    //##-Aggiorno Modello-##
    if(this.modelliService.isSaved){
      this.handleUpdateModello();
    }
    //##-Nuovo Modello-##
    else{
      this.saveNewModello();
    }
  }
  handleUpdateModello(){
    let nuovoModello = this.creteModelloUpdated();
    if(nuovoModello.tipoModello!.flgProgettazioneIndividuale !=
      this.modelloIntervento.tipoModello?.flgProgettazioneIndividuale)
    {
      this.modelliService.getTestModificaModello(this.modelloIntervento
                                                      .idModelloIntervento!.toString())
          .pipe(
            catchError(this.handleFailedSave)
          )
          .subscribe({
            next: response => {
              if(!response) return;
              if(response.idEnteCoinvolto || response.idRCaratteristica ||
                response.idRModelloTargetDest || response.idServizioModello){
                  this.datiForm.get("tipo")?.setValue(this.modelliService.modelloIntervento.tipoModello!.codTipoModello!.toString())
                  this.openDialog("Attenzione",
                                  ["Non è possibile salvare le modifiche in quanto il nuovo Tipo modello selezionato non ha le stesse caratteristiche del precedente e sono già presenti dei Dati Correlati.",
                                  "Selezionare un Tipo modello compatibile con il precedente oppure eliminare i Dati Correlati prima di effettuare la modifica."],
                                  "card-body--warning")
                }
              else{
                this.updateModello(nuovoModello)
              }
            }})
    }

    else{
      this.updateModello(nuovoModello)
    }
  }
  updateModello(nuovoModello:ModelloIntervento){
    this.modelliService.updateModello(nuovoModello)
    .pipe(
      catchError(this.handleFailedSave)
    )
    .subscribe({
      next: (resposne) => {
        if(!resposne) return;
        this.modelliService.setModelloIntervento(resposne);
        this.setPristine();
        //###-Messaggio di conferma-###
        this.avvisoSalvataggio();
      }
    })
  }

  saveNewModello(){
    this.modelliService.addModello(this.createModello())
    .pipe(
      catchError(this.handleFailedSave)
    )
    .subscribe({
      next: (resposne) => {
        if(!resposne) return;
        this.modelliService.setModelloIntervento(resposne);
        this.setPristine();
        this.modelliService.setIsSaved(true);
        //###-Messaggio di conferma-###
       this.avvisoSalvataggio();
      }
    })
  }

  //#######-Gestione Modello nuovo & aggiornato-##############
  // Creo un nuovo modello per l'inserimento n
  createModello(){
    let _modelloIntervento = this.createNeoModello();

    _modelloIntervento.idModelloIntervento= 0;
    _modelloIntervento.idPso= this.homeBag.selectedPso.idPso;
    _modelloIntervento!.soggettoAttuatore!.codOperatore=Number(this.homeBag.codiceOperatore!);
    _modelloIntervento!.soggettoAttuatore!.numProgrSportello=this.homeBag.selectedSportello.numProgrSportello;
    _modelloIntervento!.soggettoAttuatore!.gruppoOperatore=this.homeBag.gruppoOperatore;
    _modelloIntervento.statoModelloIntervento= {
        idStatoModelloDiIntervento: 10,
        descrStatoModelloDiIntervento: "Bozza"
      };
    _modelloIntervento.codUserInserimento= this.homeBag.userInfo.codFisc;
    _modelloIntervento.dataInserimento= new Date();

    return _modelloIntervento;
  }
  creteModelloUpdated(){
    let _modelloIntervento = this.createNeoModello();
    _modelloIntervento!.soggettoAttuatore!.codOperatore=Number(this.homeBag.codiceOperatore!);
    _modelloIntervento!.soggettoAttuatore!.numProgrSportello=this.homeBag.selectedSportello.numProgrSportello;
    _modelloIntervento!.soggettoAttuatore!.gruppoOperatore=this.homeBag.gruppoOperatore;

    _modelloIntervento.idModelloIntervento= this.modelloIntervento.idModelloIntervento
    _modelloIntervento.idPso= this.modelloIntervento.idPso;
    _modelloIntervento.statoModelloIntervento= {
        idStatoModelloDiIntervento: this.modelloIntervento.statoModelloIntervento?.idStatoModelloDiIntervento,
        descrStatoModelloDiIntervento: this.modelloIntervento.statoModelloIntervento?.descrStatoModelloDiIntervento
      }
    _modelloIntervento.codUserInserimento= this.modelloIntervento.codUserInserimento
    _modelloIntervento.dataInserimento= this.modelloIntervento.dataInserimento

    return _modelloIntervento;
  }
  createReferente(): Referente{
    return{
      referenteNome: this.riferimentoForm.get("nome")?.value?.toString(),
      referenteCognome: this.riferimentoForm.get("cognome")?.value?.toString(),
      referenteEmail: this.riferimentoForm.get("email_pec")?.value?.toString(),
      referenteTelefono: this.riferimentoForm.get("telefono")?.value?.toString()
    }
  }
  createNeoModello():ModelloIntervento{
    let tipologiaSelected = this._tipologieModello[+this.datiForm.get("tipo")!.value!];
    let candidaturaSelected = {modelId: this._istanzeCandidature[+this.datiForm.get("candidatura")!.value!].modelId};
    let referente = this.createReferente()
    return {
      titolo: this.datiForm.get("titolo")?.value?.toString(),
      descrizione: this.datiForm.get("descrizione")?.value?.toString(),
      tipoModello: tipologiaSelected,
      soggettoAttuatore: candidaturaSelected,
      referente: referente,
      codUserAggiornamento: this.homeBag.userInfo.codFisc,
      dataAggiornamento: new Date()
    }
  }

  //####################-Gestione Stato Modello-##################//
  // la modale per decidere se procedere o meno
  updateStatoModelloDialog(idStato: number){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
          "Attenzione",
          ["Sicuro di voler procedere con "+ (idStato == 40 ? "la chiusura":this.pubblicOrNotPublic(idStato)),
            "Continuare ?"],
          "card-body--warning",
          "",
        [new DialogButton(
            "Annulla",
            "btn btn--outline-primary",
            undefined,
            "annulla"),
        new DialogButton(
          "Conferma",
          "btn " + (idStato == 40 ? "btn--danger" : "btn--primary"),
          ()=>{this.onConferma(idStato)},
          "conferma " + (idStato == 40 ? "la chiusura":this.pubblicOrNotPublic(idStato))
          )]
      )
    });
  }
  pubblicOrNotPublic(idStato: number):string{
    return idStato == 20 ? " la pubblicazione":"l'annullamento della pubblicazione";
  }
  // Azione quando si clicca su conferma, nella modale
  onConferma(idStato: number){
    if( idStato == 20 || idStato ==  10){
    this.modelliService
      .getTestModificaModello(this.modelloIntervento.idModelloIntervento!.toString())
      .pipe(
        catchError( err => {
          this.openModaleErrore(["Attenzione:",
                                "Aggiornamento stato non riuscito.",
                                "Si prega di riprovare ed eventualmente contattare il servizio di assistenza"])
          return of(null)
        })
      )
      .subscribe({
        next: response => {
          if(!response) return;
          if(idStato == 20) this.handleStatoPubblica(response, idStato)
          else this.handleAnnullaPubblica(response, idStato)
        }}
      );

    }else{
      this.updateStatoModello(idStato);
    }
  }

  handleStatoPubblica(response: TestModelloInterventoModifica, idStato: number){
    if(response.idRCaratteristica &&
        response.idRModelloTargetDest &&
        response.idServizioModello){
          this.updateStatoModello(idStato)
    }else{
        this.openModaleErrore(["Attenzione",
                              "Non è possibile pubblicare il Modello di Intervento perché non sono stati inseriti tutti i dati obbligatori previsti.",
                              "Completare l'inserimento dei dati e riprovare."])
    }
  }
  handleAnnullaPubblica(response: TestModelloInterventoModifica, idStato: number){
    if(response.idIntervento){
      this.openModaleErrore(["Attenzione",
                            "Non è possibile annullare la pubblicazione del Modello di Intervento perché ad esso sono associati uno o più Interventi"])
    }
    else{
      this.updateStatoModello(idStato)
    }
  }

  updateStatoModello(idStato: number){
    let modelloAggiornato = {...this.modelloIntervento};
    modelloAggiornato.statoModelloIntervento = {
      ...this.modelloIntervento.statoModelloIntervento,
      idStatoModelloDiIntervento:idStato
    };
    //modelloAggiornato.statoModelloIntervento.idStatoModelloDiIntervento = idStato;

    this.modelliService.updateModello(modelloAggiornato)
      .pipe(
        catchError((err:any) => {
            this.openModaleErrore(["Attenzione",
                                  "Aggiornamento dati non riuscito.",
                                  "Si prega di riprovare ed eventualmente contattare il servizio di assistenza."])
          return of(null)}
      ))
      .subscribe({
        next: (resposne) => {
          if(!resposne) return;

          this.modelliService.setModelloIntervento(resposne);
          this.modelliService.setIsModificabile(true)
          if(resposne.statoModelloIntervento?.idStatoModelloDiIntervento == 40){
            this.form.disable()
            this.modelliService.setIsModificabile(false)
          }else if(resposne.statoModelloIntervento?.idStatoModelloDiIntervento != 10){
            this.datiForm.controls["candidatura"].disable();
            this.datiForm.controls["tipo"].disable();
            this.riferimentoForm.enable();
            this.datiForm.controls["titolo"].enable();
            this.datiForm.controls["descrizione"].enable();
          }else{
            this.modelliService.setIsModificabile(true)
            this.datiForm.controls["candidatura"].enable();
            this.datiForm.controls["tipo"].enable();
          }
          //###-Messaggio di conferma-###
          this.openDialog("Avviso",
                        ["Lo stato del modello di intervento è stato aggiornato correttamente."],
                        "card-body--success");
        }
      })
  }

  //###################################################
  // Dialog Info Section
  openDialog(title:string, content:string[], contentClass:string){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings( title, content, contentClass)
    });
  }
  openModaleErrore(msg: string[]){
    this.openDialog("Errore",msg, "card-body--danger")
  }
  //###-Messaggio di conferma-###
  avvisoSalvataggio(){
    this.openDialog("Avviso",
                    ["I dati del modello di intervento sono stati salvati correttamente."],
                    "card-body--success");
  }

  isPristine(): boolean {
    return this.form.pristine && this.datiForm.pristine && this.riferimentoForm.pristine;
  }

  setPristine(): void {
    this.form.markAsPristine();
    this.datiForm.markAsPristine();
    this.riferimentoForm.markAsPristine();
  }

  onTabClick($event: TabClickInterceptorEvent) {
    this.pristineService.checkPristine(() => {
        this.selectedTab = $event.tabIndex;
        this.modelliService.reload();
      }, () => {
        this.setPristine();
        this.selectedTab = $event.tabIndex;
        this.modelliService.reload();
      }, () => {
        $event.preventDefault();
    });
  }

  //###################################################
  // GETTERS
  // Selects Array di Stringhe
  get tipoModelloList(): string[]{
    return this._tipologieModello.map( tipo => tipo.descrizione!);
  }
  get istanzaCandidaturaList(){
    return this._istanzeCandidature.map(istanza =>  istanza.modelId!.toString()+" - "
                                                    +istanza.gruppoOperatore
                                                    +istanza.codOperatore!.toString()+" - "
                                                    +istanza.denominazioneGiuridica+ " - "
                                                    +istanza.descrAreaTerritoriale)
  }

  get isModificabile(){
    return this.modelliService.isModificabile;
  }
  get canReopen(){
    return this.homeBag.selectedRuolo.codiceRuolo!=='FUNZIONARIO_MASTER_SERSE'
  }
  get isSaved(){
    return this.modelliService.isSaved;
  }
  get statoDescrizione(){
    return this.modelloIntervento.statoModelloIntervento?.descrStatoModelloDiIntervento;
  }

  get codiceFiscaleIns(){
    return this.modelloIntervento.codUserInserimento;
  }
  get dataIns(){
    return this.modelloIntervento.dataInserimento;
  }

  get codiceFiscaleAgg(){
   return this.modelloIntervento.codUserAggiornamento;
  }
  get dataAgg(){
    return this.modelloIntervento.dataAggiornamento;
  }

  get stato(){
    return this.modelloIntervento.statoModelloIntervento?.idStatoModelloDiIntervento;
  }

  get identificativoModello(){
    return this.modelloIntervento.idModelloIntervento?.toString();
  }

  get modelloIntervento(){
    return this.modelliService.modelloIntervento;
  }

  get soggettoAttuatoreCompetente(){
    return this.modelloIntervento.soggettoAttuatore?.gruppoOperatore+""
            +this.modelloIntervento.soggettoAttuatore?.codOperatore+"-"
            +this.modelloIntervento.soggettoAttuatore?.denominazioneGiuridica
  }

  get isProprietario(){
    return this.modelliService.isProprietario;
  }

  get isSuperUser(){
    return this.homeBag.selectedRuolo.codiceRuolo==='FUNZIONARIO_MASTER_SERSE'
  }
}
