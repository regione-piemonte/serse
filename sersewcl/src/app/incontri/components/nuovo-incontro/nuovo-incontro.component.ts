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

import { AfterViewInit, Component, ElementRef, OnDestroy, OnInit, Renderer2, ViewChild } from '@angular/core';
import { IncontriService } from '../../services/incontri.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Validation } from '@shared/utils/validation';
import { ServiziService } from '@servizi/services/servizi.service';
import { Incontro } from '@core/api-serse/model/incontro';
import { HomeBagService } from '@home/services/home-bag.service';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { MatDialog } from '@angular/material/dialog';
import { ServizioGamIncontro } from '@core/api-serse/model/servizioGamIncontro';
import { TokenGam } from '@core/api-serse/model/tokenGam';
import { MatIcon } from '@angular/material/icon';
import { InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { Router } from '@angular/router';
import { TitleService } from '@core/services/title.service';
import { ORARIO_INCONTRO_MASK } from '@shared/utils/text-masks';
import { PristineService } from '@home/services/pristine.service';
import { Pristinable } from '@home/models/pristinable';
import { MatTabGroup } from '@angular/material/tabs';
import { Subscription } from 'rxjs';
import { TabClickInterceptorEvent } from '@shared/directives/tab-click-interceptor.directive';

@Component({
  selector: 'app-nuovo-incontro',
  templateUrl: './nuovo-incontro.component.html',
  styleUrls: ['./nuovo-incontro.component.scss']
})
export class NuovoIncontroComponent implements OnInit, AfterViewInit, OnDestroy, Pristinable {

  backToSearch = true;
  riferimentoA = 'incontro'
  identificativo: number | undefined
  visibilityAggiorna = false
  isIndividuale: boolean = false

  numDestinatariServizio: number = 0;
  orarioIncontroMask = ORARIO_INCONTRO_MASK
  iconsLuogo: InfoColumnActionSettingModel[] = [];

  statoChiusura?: 'APERTO' | 'CHIUSO' | 'IN_CHIUSURA'; // in base a questo decidi quali bottoni fare apparire

  tooltip: string = this.isIndividuale ? 'Individuale' : 'Di gruppo'

  tokenGam?: TokenGam = undefined;
  datiToken = { id: "", dataRichiesta: "", statoRichiesta: "", esitoRichiesta: "" };

  subscriptionOnReload!: Subscription;

  @ViewChild(MatTabGroup, { static: false }) tabGroup!: MatTabGroup;

  constructor(
    private incontriService: IncontriService,
    private serviziService: ServiziService,
    private homeBag:HomeBagService,
    private fb:FormBuilder,
    private dialog:MatDialog,
    private elementRef: ElementRef,
    private renderer: Renderer2,
    private title: TitleService,
    private router: Router,
    private pristineService: PristineService
  ) { }

  form:FormGroup=this.fb.group({
      titoloIncontro:['',Validators.required],
      dataIncontro:['',Validators.required],
      oraInizio:['',Validation.oreIncontroValidator],
      oraFine:['',Validation.oreIncontroValidator],
      durata:['',Validation.oreRequired],
      note:['']
    }
  )

  riferimentoForm = this.fb.group({
    cognome: ['', [Validators.required, Validation.cognomeNomeValidator(false)]],
    nome: ['', [Validators.required, Validation.cognomeNomeValidator(true)]],
    telefono: ['', [Validators.required, Validation.phoneNumberValidator]],
    email_pec: ['', [Validators.required, Validation.emailValidator]]
  });



  @ViewChild('Icona') icona!:MatIcon;

  ngAfterViewInit(): void {
    const container = this.elementRef.nativeElement.querySelector('.mat-tab-label-container');
    const iconElement = this.icona._elementRef.nativeElement.cloneNode(true);
    this.renderer.appendChild(container, iconElement);
  }

  ngOnInit(): void {
    this.pristineService.componentAttivo = this;
    this.title.setTitle(this.router.url.endsWith("nuovo") ? "Nuovo incontro" : "Modifica incontro");

    this.subscriptionOnReload = this.incontriService.selectionChangeIncontro$.subscribe({next:()=>this.onReloadIncontro()});

    this.serviziService.tab = 4;
    if (!this.isModificabile) {
      this.form.disable()
      this.riferimentoForm.disable()
    }
    this.identificativo = this.incontriService.incontro.idIncontro
    this.incontro = this.incontriService.incontro
    if (this.isSaved) {
      this.caricaUltimoTokenEStato()
    } else {
      this.riferimentoForm.get("cognome")?.setValue(this.serviziService.servizio.referenteCognome!)
      this.riferimentoForm.get("nome")?.setValue(this.serviziService.servizio.referenteNome!)
      this.riferimentoForm.get("telefono")?.setValue(this.serviziService.servizio.referenteTelefono!)
      this.riferimentoForm.get("email_pec")?.setValue(this.serviziService.servizio.referenteEmail!)
    }

    if (this.identificativo)
      this.fetchDatiIncontro()
  }

  ngOnDestroy(): void {
    this.pristineService.componentAttivo = undefined;
    this.subscriptionOnReload.unsubscribe();
  }

  onReloadIncontro() : void {
    // questo metodo viene richiamato una volta anche all'oninit della pagina "Nuovo incontro", non so come mai
    if (this.incontro.idIncontro) {
      this.fetchDatiIncontro();
      this.caricaUltimoTokenEStato();
    }
  }

  /*
  LOGICA DELLA CHIUSURA:
  Se su DB c'è lo stato "chiuso", l'incontro è chiuso e basta
  Se su DB c'è lo stato "In definizione", cioè aperto, potrebbe anche esserci un'elaborazione di chiusura in corso, quindi
  a video dobbiamo distinguere APERTO/IN_CHIUSURA
   */
  caricaUltimoTokenEStato() {
    if (this.incontro.statoIncontro?.idStatoIncontro === 40) {
      // Questo succede quando entro in un incontro che è già chiuso
      this.statoChiusura = 'CHIUSO'
      this.form.disable()
      this.riferimentoForm.disable()
    }
    this.incontriService.getTokenGamIncontro(this.incontro.idIncontro!).subscribe({
      next:tokens => {
        let elabInCorso = false
        if(tokens.length > 0) {
            tokens.sort((a, b) => new Date(a.dInvioRichiesta!).getTime() - new Date(b.dInvioRichiesta!).getTime())
            const lastToken = this.tokenGam = tokens[tokens.length-1];
            this.aggiornaDatiToken()

            elabInCorso = (lastToken.codStatoRichiesta=="PC" && lastToken.codTipoRichiestaGam == '08' && !lastToken.codStatoElaborazione)
            this.visibilityAggiorna = elabInCorso;

            if (elabInCorso) {
              console.log("Esiste una elaborazione in corso");
            }

            if (this.statoChiusura == 'IN_CHIUSURA' && !elabInCorso) {
              // Questo succede quando l'utente chiude un incontro, e poi preme "Aggiorna"

              // L'ultima elaborazione di chiusura è andata in OK o KO?
              const lastTokenChiusura = tokens.filter(t => t.codTipoRichiestaGam == '08').at(-1);
              if (lastTokenChiusura === undefined) {
                console.error("Non trovo l'ultimo token di chiusura");
                this.statoChiusura = 'APERTO'
              } else if (lastTokenChiusura.codEsitoElaborazione === "SOAE00005") {
                // OK
                this.statoChiusura = 'CHIUSO'
                this.setStatoIncontroSuInterfaccia(40, 'Chiuso')
                this.setStatoServizioSuInterfaccia(30)
              } else {
                // KO
                this.statoChiusura = 'APERTO'
              }
              this.serviziService.reload()

            } else if (this.incontro.statoIncontro?.idStatoIncontro === 10) {
              // Qui arrivo se l'utente entra in un inconto che (su DB) risulta Aperto
              this.statoChiusura = elabInCorso ? 'IN_CHIUSURA' : 'APERTO'
            }
        } else { // tokens.length == 0
          if (this.incontro.statoIncontro?.idStatoIncontro === 10) {
            this.statoChiusura = 'APERTO'
          }
        }

        if (!elabInCorso && this.statoChiusura == 'APERTO') {
          this.form.enable()
          this.riferimentoForm.enable()
        } else {
          this.form.disable()
          this.riferimentoForm.disable()
        }
      }
    })
  }

  /**
   * Quando l'utente preme "Aggiorna"
   */
  onAggiorna(){
    this.caricaUltimoTokenEStato()
  }

  fetchDatiIncontro(){
    let dataI=new Date(this.incontro.dInizio!)
    let dataF=new Date(this.incontro.dFine!)

    this.form.get("titoloIncontro")?.setValue(this.incontro.titoloIncontro)

    this.form.get("oraInizio")?.setValue(dataI.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'}))
    this.form.get("oraFine")?.setValue(dataF.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'}))
    this.form.get("dataIncontro")?.setValue(dataI)

    this.form.get("durata")?.setValue(this.incontro.durataOre?.toString())
    this.form.get("note")?.setValue(this.incontro.note)

    this.riferimentoForm.get("cognome")?.setValue(this.incontro!.cognomeReferente!)
    this.riferimentoForm.get("nome")?.setValue(this.incontro.nomeReferente!)
    this.riferimentoForm.get("telefono")?.setValue(this.incontro.referenteTelefono!)
    this.riferimentoForm.get("email_pec")?.setValue(this.incontro.referenteEmail!)

  }

  onSalva(){

    let oraInizio=this.form.controls['oraInizio'].value.split(":")
    let oraFine=this.form.controls['oraFine'].value.split(":")
    if((oraInizio[0]>oraFine[0]) || (oraInizio[0]==oraFine[0] && oraInizio[1]>oraFine[1])){
      this.openAttentionDialog(["l'ora di inizio non può essere successiva all'ora di fine"])
      return;
    }

    this.form.markAllAsTouched()
    this.riferimentoForm.markAllAsTouched()
    if (this.form.invalid) {
      //this.openAttentionDialog(["dati obbligatori mancanti"])
      return;
    }
    if (this.isSaved) {
      let oreVecchie = this.incontro.durataOre!
      this.incontro = this.createIncontro();
      this.handleUpdate(oreVecchie);

    } else {
      this.incontro = this.createNewIncontro();
      this.handleSave()
    }
  }

  /*checkDate(){
    this.form.controls["dataInizio"].markAsTouched()
    this.form.controls["dataFine"].markAsTouched()
    if(new Date(this.form.get("dataInizio")?.value)>new Date(this.form.get("dataFine")?.value)){
      this.form.controls["dataInizio"].setErrors({msg:"la data inizio non può superare la data di fine"})
      this.form.controls["dataFine"].setErrors({msg:"la data inizio non può superare la data di fine"})
    }else{
      this.form.controls["dataInizio"].setErrors(null)
      this.form.controls["dataFine"].setErrors(null)
      this.form.controls["dataInizio"].markAsUntouched()
      this.form.controls["dataFine"].markAsUntouched()
    }
  }*/

  /*onChangeDFine(){
    this.checkDate()
  }


  myFilterDFine = (d: any): boolean => {

    let day: Date;
    let dayF:Date;
    if(this.form.get("dataInizio")?.value){
      dayF = new Date(this.form.get("dataInizio")?.value)
      day=new Date(d)
      return day>=dayF
    }else{
      day = new Date()}
    return day > new Date();
  };

  // filtri data fine
  onChangeDInizio(){

    this.form.get("dataFine")?.enable()
    this.myFilterDFine(this.form.get("dataInizio")?.value)
    this.checkDate()
  }

   myFilterDinizio= (d: any): boolean => {

    let day: Date;
    let dayF:Date;

    if(this.form.get("dataFine")?.value){
      dayF = new Date(this.form.get("dataFine")?.value)
      day=new Date(d)
      return day<=dayF
    }else{
      day = new Date(d)}
    return true;
  };*/

  handleSave(){
    if(this.riferimentoForm.invalid || this.form.invalid){
      this.openAttentionDialog(["Attenzione inserire tutti i campi obbligatori"])
      return
    }
    this.incontriService.getSommaDurataIncontri(this.idServizio!).subscribe(
      {
        next:ris=>{
          if((Number(ris.sommaIncontri!)+Number(this.incontro.durataOre!))> this.serviziService.servizio.durataOre!){
            this.segnalaDurataNonCorretta();
          }else{
            this.saveIncontro(this.incontro)
          }

        }
      }
    )
  }

  saveIncontro(incontro:Incontro){
    if(this.isIndividuale && this.numDestinatariServizio==0){
      this.openAttentionDialog(["Attenzione: per inserire un Incontro di un Servizio di tipo Individuale occorre prima specificare il Destinatario del Servizio"]);
      return;
    }

    this.incontriService.insertIncontro(incontro).subscribe({
      next:ris=>{
        this.incontriService.incontro = ris;
        this.incontriService.isSaved = true;
        this.incontriService.isModificabile = true;
        this.identificativo = ris.idIncontro
        this.statoChiusura = 'APERTO'
        this.setStatoIncontroSuInterfaccia(10, 'In definizione')
        this.setPristine();
        this.confermaSalvataggio()
      }
    })
  }

  handleUpdate(oreVecchie:number){
    if(this.riferimentoForm.invalid || this.form.invalid){
      this.openAttentionDialog(["Attenzione dati obbligatori mancanti"])
      return
    }
    this.incontriService.getSommaDurataIncontri(this.idServizio!).subscribe(
      {next:ris=>{
          if((Number(ris.sommaIncontri!)+Number(this.incontro.durataOre!) - Number(oreVecchie))> this.serviziService.servizio.durataOre!){
            this.segnalaDurataNonCorretta();
          }else{
            this.updateIncontro(this.incontro)
          }

        }
      }
    )
  }

  updateIncontro(incontro:Incontro){
    this.incontriService.updateIncontro(incontro).subscribe({
      next:ris => {
        this.incontriService.incontro = ris;
        this.setPristine()
        this.confermaSalvataggio()
      }
    })
  }

  createIncontro():Incontro{
    let giornoI:Date=new Date(this.form.get("dataIncontro")?.value);
    let giornoF:Date=new Date(this.form.get("dataIncontro")?.value);
    let dInizio=giornoI;
    let oraInizio:string[]=this.form.get("oraInizio")?.value.split(":");
    dInizio.setHours(+oraInizio[0]);
    dInizio.setMinutes(+oraInizio[1]);

    let dFine= giornoF;
    let oraFine:string[]=this.form.get("oraFine")?.value.split(":")
    dFine.setHours(+oraFine[0])
    dFine.setMinutes(+oraFine[1])


    return{
      ...this.incontro,
      titoloIncontro:this.form.get("titoloIncontro")?.value,
      dInizio:dInizio,
      dFine:dFine,
      durataOre:this.handlerDurataVirgola(),
      note:this.form.get("note")?.value,
      cognomeReferente:this.riferimentoForm.get("cognome")?.value!.toString(),
      nomeReferente:this.riferimentoForm.get("nome")?.value!.toString(),
      referenteTelefono: this.riferimentoForm.get("telefono")?.value!.toString(),
      referenteEmail:this.riferimentoForm.get("email_pec")?.value!.toString(),
      codUserAggiorn:this.homeBag.userInfo.codFisc
    }
  }

  createNewIncontro():Incontro{
    let giornoI:Date=new Date(this.form.get("dataIncontro")?.value);
    let giornoF:Date=new Date(this.form.get("dataIncontro")?.value);
    let dInizio=giornoI;

    let oraInizio:string[]=this.form.get("oraInizio")?.value.split(":");
    dInizio.setHours(+oraInizio[0]);
    dInizio.setMinutes(+oraInizio[1]);

    let dFine= giornoF;
    let oraFine:string[]=this.form.get("oraFine")?.value.split(":")
    dFine.setHours(+oraFine[0])
    dFine.setMinutes(+oraFine[1])


    return{
      ...this.incontro,
      titoloIncontro:this.form.get("titoloIncontro")?.value,
      dInizio:dInizio,
      dFine:dFine,
      durataOre: this.handlerDurataVirgola(),
      note:this.form.get("note")?.value,
      cognomeReferente:this.riferimentoForm.get("cognome")?.value!.toString(),
      nomeReferente:this.riferimentoForm.get("nome")?.value!.toString(),
      referenteTelefono: this.riferimentoForm.get("telefono")?.value!.toString(),
      referenteEmail:this.riferimentoForm.get("email_pec")?.value!.toString(),
      codUserAggiorn:this.homeBag.userInfo.codFisc,
      codUserInserim:this.homeBag.userInfo.codFisc,
    }
  }


  onChiudi(){
    let idSportello = JSON.parse(localStorage.getItem('selectedSportello')!).numProgrSportello;

    this.incontriService.testChiudiIncontro(this.identificativo!,idSportello,this.idServizio!).subscribe({
      next: ris=>{
        if(ris.participantiPresenti==0){
          this.openAttentionDialog(["Attenzione: non è possibile chiudere l\'Incontro perché non sono presenti partecipanti"])
        }
        else if(ris.dataFinePosterioreAllaAttuale){
          this.openAttentionDialog(["Attenzione: non è possibile chiudere l\'Incontro perché la data/ora di fine indicata nei Dati generali dell\'Incontro è posteriore alla data/ora attuali. Si prega di modificare i dati e riprovare"])
        }
        else if(ris.destinatarioSenzaOreErogate){
          this.openAttentionDialog(["Attenzione: non è possibile chiudere l\'Incontro perché è presente almeno un destinatario per cui non sono state indicate le ore effettivamente erogate. Si prega di indicarne il valore e riprovare"])
        }
        else if(!this.incontro.luogoIncontro?.idLuogoIncontro){
          this.openAttentionDialog(["Attenzione: non è possibile chiudere l\'Incontro perché non è stato ancora indicato il Luogo"])
        }
        else if(this.serviziService.servizio.statoServizio?.idStatoServizio !== 22 && this.serviziService.servizio.statoServizio?.idStatoServizio !== 30){
          this.openAttentionDialog(["Attenzione: non è possibile chiudere l\'Incontro perché lo stato del Servizio è diverso da Finanziato o Avviato"])
        }else if(ris.datiMonitoraggioPartecipantiNonCompilati){
          this.openAttentionDialog(['Attenzione! Per almeno uno dei Destinatari partecipanti all\'Incontro non sono stati compilati tutti i dati peculiari obbligatori. Si prega di accedere alla sezione "Dati Peculiari" di ogni partecipante e completare l\'inserimento delle informazioni richieste prima di riprovare a chiudere l\'Incontro.'])
        }else{
          this.handleClose()
        }
      },
      error:()=>{
        this.openAttentionDialog(["Errore in fase di verifica dati. Si prega di riprovare o eventualmente contattare l'assistenza."]);
      }
    })
  }

  handleClose(){
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Chiusura incontro',
        ['Attenzione: sarà possibile riaprire un Incontro chiuso solo fino a quando non sarà inserito in una richiesta di rimborso e il Servizio a cui appartiene sarà aperto. Si desidera proseguire?'],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
             this.incontriService.chiudiIncontro(this.closeInc()).subscribe({
              next:ris=>{
                this.tokenGam=ris;
                this.statoChiusura = 'IN_CHIUSURA'
                // ma *non* aggiorno ancora lo stato dell'incontro sull'interfaccia
                this.visibilityAggiorna=true
                this.incontriService.isModificabile=false
                this.caricaUltimoTokenEStato()

                this.form.disable()
                this.riferimentoForm.disable()
                this.confermaSalvataggio()
                this.serviziService.reload()
            },
            error:()=>{
              this.openAttentionDialog(["Errore in fase di salvataggio. Si prega di riprovare o eventualmente contattare l'assistenza."]);
            }
          })
          },"conferma chiusura incontro"),
        ]
      ),
    });
  }

  onRiapri() {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Riapertura incontro',
        ['Si desidera davvero riaprire l\'Incontro?'],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
             this.incontriService.riapriIncontro(this.reopenInc()).subscribe({
              next:()=>{
                this.statoChiusura = 'APERTO'
                this.setStatoIncontroSuInterfaccia(10, 'In definizione')
                this.visibilityAggiorna=false
                this.incontriService.isModificabile=true

                this.tokenGam = undefined
                this.caricaUltimoTokenEStato()

                this.form.enable()
                this.riferimentoForm.enable()
                this.confermaRiapertura()

                // se ci sono altri incontri chiusi il servizio resta Avviato,
                // se invece questo era l'unico incontro chiuso, il servizio deve tornare in Finanziato
                this.incontriService.getIncontri(this.idServizio!).subscribe({
                  next: incontri => {
                    if (incontri && incontri.findIndex(i => i.statoIncontro?.idStatoIncontro === 40) < 0) {
                      this.setStatoServizioSuInterfaccia(22)
                    }
                  }
                })
            },
            error:err=>{
              console.error(err)
              this.openAttentionDialog(["Attenzione: si è verificato un errore tecnico, si prega di riprovare ed eventualmente contattare l'assistenza"]);
            }
          })
          },"conferma riapertura incontro"),
        ]
      ),
    });
  }

  aggiornaDatiToken(){
    let t = this.tokenGam!;
    let pc = t.codStatoRichiesta == 'PC';
    let desc = pc ? t.descrEsitoElaborazione : t.descrStatoRichiesta;

    this.datiToken = {
      id: this.tokenGam!.idTokenGam!.toString(),
      dataRichiesta: new Date(this.tokenGam!.dInvioRichiesta!).toLocaleDateString(),
      statoRichiesta: (!pc || t.codEsitoElaborazione) ? "Elaborata": "In corso",
      esitoRichiesta: desc??"N.D"
    };
  }

  handlerDurataVirgola():number{
    let durata:string = String(this.form.get('durata')?.value);
    if(durata.includes(",")) durata = durata.replace(",",".")

    return parseFloat(durata);
  }

  /**
   * crea il body della chiamata al servizio di chiusura
   */
  closeInc():ServizioGamIncontro{
    return{
      servizio: this.serviziService.servizio,
      incontro:{...this.incontro,
                /* NON AGGIORNO ANCORA LO STATO DELL'INCONTRO*/
                dChiusura: new Date(),
                codUserChiusura: JSON.parse(localStorage.getItem('userInfo')!).codFisc
      },
      numProgrSportello:this.homeBag.selectedSportello.numProgrSportello,
      codiceFiscaleUtente:this.homeBag.userInfo.codFisc,
      codOperatore:Number(this.homeBag.codiceOperatore),
      gruppoOperatore:this.homeBag.gruppoOperatore,
      idPso:this.homeBag.selectedPso.idPso
    }
  }

  /**
   * crea il body della chiamata al servizio di riapertura
   */
  reopenInc():ServizioGamIncontro{
    return{
      servizio: this.serviziService.servizio,
      incontro:{...this.incontro,
                /* NON AGGIORNO ANCORA LO STATO DELL'INCONTRO*/
                dChiusura: undefined,
                codUserChiusura: JSON.parse(localStorage.getItem('userInfo')!).codFisc
      },
      numProgrSportello:this.homeBag.selectedSportello.numProgrSportello,
      codiceFiscaleUtente:this.homeBag.userInfo.codFisc,
      codOperatore:Number(this.homeBag.codiceOperatore),
      gruppoOperatore:this.homeBag.gruppoOperatore,
      idPso:this.homeBag.selectedPso.idPso
    }
  }

  setStatoServizioSuInterfaccia(idStato: number) {
    this.serviziService.aggiornaStatoServizio(idStato)
  }

  setStatoIncontroSuInterfaccia(idStato: number, descrizioneStato: string) {
    this.incontriService.incontro.statoIncontro = {
      idStatoIncontro: idStato,
      descrStatoIncontro: descrizioneStato
    }
  }

  openDialog(title:string, msg:string[],cssClass:string,buttons?:DialogButton[]){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(title, msg, cssClass, "", buttons)
    })
  }

  segnalaDurataNonCorretta(){
    this.openAttentionDialog(["Attenzione: il valore indicato per la Durata in ore, sommato alle durate degli eventuali altri incontri del servizio, supera quanto indicato a livello di servizio"]);
  }

  segnalaDateErrate(){
    this.openAttentionDialog(["Attenzione: il valore della data di fine incontro deve essere maggiore della data di inizio incontro"]);
  }

  openAttentionDialog(msg:string[], buttons?:DialogButton[]){
    this.openDialog("Attenzione!",msg,"card-body--warning", buttons)
  }

  confermaSalvataggio(){
    this.openDialog("Avviso",["I dati sono stati salvati correttamente"],"card-body--success")
  }

  confermaRiapertura(){
    this.openDialog("Avviso",["Incontro riaperto correttamente"],"card-body--success")
  }

  isPristine(): boolean {
    return this.form.pristine && this.riferimentoForm.pristine;
  }

  setPristine(){
    this.form.markAsPristine();
    this.riferimentoForm.markAsPristine();
  }

  onTabClick($event: TabClickInterceptorEvent) {
    this.pristineService.checkPristine(() => {
        this.selectedTab = $event.tabIndex;
        this.incontriService.reload();
      }, () => {
        this.setPristine();
        this.selectedTab = $event.tabIndex;
        this.incontriService.reload();
      }, () => {
        $event.preventDefault();
    });
  }

  get isSaved(){
    return this.incontriService.isSaved;
  }

  get isModificabile(){
    return this.incontriService.isModificabile;
  }

  get canClose(){
    let x = this.statoChiusura === 'APERTO'
      && this.isModificabile
      && this.isSaved
      && this.incontro.statoIncontro?.idStatoIncontro !== 40
    // esistono altre condizioni, ma il bottone si deve vedere, cfr. onChiudi()
    return x
  }

  get canReopen(){
    let x = this.statoChiusura === 'CHIUSO'
      && this.isSaved
      && (this.incontro.statoIncontro?.idStatoIncontro === 40) // chiuso
      && (this.serviziService.servizio.statoServizio?.idStatoServizio !== 40)
    return x
  }

  get incontro() {
    return this.incontriService.incontro;
  }

  set incontro(incontro: Incontro) {
    this.incontriService.incontro = incontro;
  }

  get statoIncontro(){
    return this.incontriService.incontro.statoIncontro?.descrStatoIncontro
  }

  get idServizio(){
    return this.incontriService.incontro.idServizio
  }
  get dataIns(){
    return this.incontriService.incontro.dInserim
  }
  get dataAgg(){
    return this.incontriService.incontro.dAggiorn
  }
  get soggettoAttuatoreCompetente(){
    return this.serviziService.servizio.soggettoAttuatore?.gruppoOperatore+""
            +this.serviziService.servizio.soggettoAttuatore?.codOperatore+"-"
            +this.serviziService.servizio.soggettoAttuatore?.denominazioneGiuridica
  }
  get codiceFiscaleIns(){
    return this.incontriService.incontro.codUserInserim
  }
  get codiceFiscaleAgg(){
    return this.incontriService.incontro.codUserAggiorn
  }

  get selectedTab(){
    return this.incontriService.selectedTab
  }

  set selectedTab(selection:number){
    this.incontriService.selectedTab=selection
  }

  get identificativoIncontro(){
    return this.incontro.idIncontro?.toString();
  }
  get identificativoModello(){
    return this.serviziService.intervento.idModelloIntervento?.toString();
  }
  get identificativoIntervento(){
    return this.serviziService.intervento.idIntervento?.toString();
  }
  get identificativoServizio(){
    return this.serviziService.servizio.idServizio?.toString();
  }
}
