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

import { TipologieServiziService } from '@modelli/services/tipologie-servizi.service';
import { Component, OnInit, ViewChild, TemplateRef, Input, OnChanges, SimpleChanges, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ServizioModello } from '@core/api-serse/model/servizioModello';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { ModelliBagService } from '@modelli/services/modelli-bag.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { IconsSettings } from '@shared/const/icons-settings';

// Custome table
import { ColumnSettingsModel, InfoColumnActionSettingModel, TableSettingsModel } from '@shared/model/table-setting.model';
import { Observable } from 'rxjs';
import { DialogConfermaComponent } from '../dialog-conferma/dialog-conferma.component';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { DialogRef } from '@angular/cdk/dialog';
import { Validation } from '@shared/utils/validation';

@Component({
  selector: 'app-tipologie-di-servizi',
  templateUrl: './tipologie-di-servizi.component.html',
  styleUrls: ['./tipologie-di-servizi.component.scss']
})
export class TipologieDiServiziComponent implements OnInit, OnChanges {

  @Input() tipologieServizi$!:Observable<ServizioModello[]>;
  @Input() serviziRegionali$!:Observable<ServizioRegionale[]>;
  @Input() serviziRegionaliModello$!:Observable<ServizioRegionale[]>;
  @Input() servizioEsterno$!:Observable<ServizioModello|null>|null;

  @Input() individuale!:boolean;

  @Output() elencoRegionaliDaCancellare:   EventEmitter<ServizioModello[]>= new EventEmitter();
  @Output() elencoRegionaliDaInserire:     EventEmitter<ServizioModello[]>= new EventEmitter();
  @Output() elencoRegionaliDaAggiornare:   EventEmitter<ServizioModello[]>= new EventEmitter();

  @Output() getServizioEsterno: EventEmitter<string>= new EventEmitter();


  @Output() servizioEsternoDaCancellare:   EventEmitter<string>= new EventEmitter();
  @Output() servizioEsternoDaInserire:     EventEmitter<ServizioModello>= new EventEmitter();
  @Output() servizioEsternoDaAggiornare:   EventEmitter<ServizioModello>= new EventEmitter();


  tipologieServizi:ServizioModello[] = [];

  tipologieRegionaliCheck: SimpleTipologia[]=[];
  tipologieRegionaliCheckCopia: SimpleTipologia[]=[];

  @Input() isModificabile!:boolean;
  @Input() isModificabileEsterni!:boolean;
  @Input() idModello!: number;
  @Input() isPubblico: boolean=false;
  tipologie:SimpleTipologia[] = [];
  nuovoServizio = true;


  @Output() codFisc = "";

  // modali
  @ViewChild('regionali') regionali!: TemplateRef<any>;
  @ViewChild('esterni') esterni!: TemplateRef<any>;


  servizioEsternoToUpdate!: ServizioModello;

  datiForm = this.fb.group({
    denominazione: ['', Validators.required],
    descrizione: ['', ],
    finalita: ['', Validators.required],
    durata: ['', Validation.oreRequired],
    attore: ['', Validators.required],
  });
  riferimentoForm = this.fb.group({
    cognome: ['', [Validators.required, Validation.cognomeNomeValidator(false)]],
    nome: ['', [Validators.required, Validation.cognomeNomeValidator(true)]],
    telefono: ['', [Validators.required, Validation.phoneNumberValidator]],
    email_pec: ['', [Validators.required, Validation.emailValidator]]
  });
  form = this.fb.group({
    dati: this.datiForm,
    referente: this.riferimentoForm
  })


  // Informazione paginazione tabella
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];


  allComplete: boolean = false;


  constructor(
    private dialog: MatDialog,
    // private modelliService: ModelliService,
    private fb: FormBuilder,
    private tipolgieService:TipologieServiziService
    ) { }

  ngOnInit(): void {
    this.updateTipologie();
    this.createIcons();
  }
  ngOnChanges(changes: SimpleChanges): void {
    if(changes["tipologieServizi$"]){
      this.updateTipologie();
    }
    // if(changes["isModificabile"]){
    //   this.tipologie.forEach(tipologia => {
    //     if(tipologia.tipo=="Esterno"){tipologia.icons=true}
    //   });
    // }

  }

  updateTipologie(){
    this.tipologieServizi$.subscribe(response => {
      this.tipologieServizi = response
      this.tipologie =
            response.map(
                t => {return {

                  idServizioModello: t.idServizioModello,
                  // idModelloDiIntervento: t.idModelloDiIntervento,

                  // denominazione: t.titoloServizioEsterno,
                  descrizione: t.servizioRegionale?.idServizioRegionale ? t.servizioRegionale.codiceServizioRegionale+" "+t.servizioRegionale.descrServizioRegionale : t.titoloServizioEsterno,
                  tipo: t.servizioRegionale?.idServizioRegionale ? "Regionale" : "Esterno",
                  finalita: t.servizioRegionale?.idServizioRegionale ? t.servizioRegionale.descrFinalitaServizio : t.descrFinalitaServizioEsterno,
                  durata:  !t.servizioRegionale?.idServizioRegionale ? t.durataInOre?.toString():t.servizioRegionale?.oreConsentiteMin +"-"+t.servizioRegionale?.oreConsentiteMax,

                  icons: t.servizioRegionale?.idServizioRegionale? false : true
                }}
              );
    });
  }

  icons : InfoColumnActionSettingModel[] = [];
  createIcons(){
      this.icons.push(this.getEditIcon());
      this.icons.push(this.getDeleteIcon())
      this.icons.push(this.getViewIcon());
  }
  getEditIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.PEN_ICON,
        "btn btn--plain-text--primary",
        "modifica",
        (idServizio) => this.handleEdit(idServizio),
        "modifica tipologia di servizio esterno"

      );
  }
  getDeleteIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.TRS_ICON,
        "btn btn--plain-text--danger",
        "Elimina",
        (idServizio) => this.handleDelete(idServizio),
        "elimina tipologia di servizio esterno"
      );
  }
  getViewIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.EYE_ICON,
        "btn btn--plain-text--primary",
        "visualizza",
        (idServizio) => this.handleView(idServizio),
        "visualizza tipologia di servizio esterno"
      );
  }


  handleView(idServizio: string){
    this.tipolgieService
          .getServizioEsternoById(this.idModello!.toString(),idServizio)
          .subscribe(response => {
            this.uploadForm(response)
            this.form.disable()
            this.apriModaleEsterni(false)
          })
  }
  handleEdit(idServizio: string){
    this.tipolgieService
      .getServizioEsternoById(this.idModello!.toString(),idServizio)
      .subscribe(response => {
        this.servizioEsternoToUpdate = response;
        this.uploadForm(response)
        this.form.enable()
        this.apriModaleEsterni(false)
      })
  }
  handleDelete(idServizio: string){
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        "Eliminazione servizio",
        ["Confermi la eliminazione"],
        "card-body--warning",
        "Attenzione!",
        [new DialogButton(
            "Annulla",
            "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--danger",
          ()=>{this.onConfermaEliminazione(idServizio)},"conferma eliminazione servizio")]
      )
    });
  }
  onConfermaEliminazione(idServizio: string){
    this.servizioEsternoDaCancellare.emit(idServizio)
  }

  uploadForm(data: ServizioModello){
    this.datiForm.get('denominazione')?.setValue(data.titoloServizioEsterno!)
    this.datiForm.get('descrizione')?.setValue(data.descrizioneServizioEsterno!)
    this.datiForm.get('finalita')?.setValue(data.codFinalitaServizioEsterno!)
    this.datiForm.get('durata')?.setValue(data.durataInOre!.toString())
    this.datiForm.get('attore')?.setValue(String(data.attoreEsterno))

    this.riferimentoForm.get('cognome')?.setValue(data.referente?.referenteCognome!)
    this.riferimentoForm.get('nome')?.setValue(data.referente?.referenteNome!)
    this.riferimentoForm.get('telefono')?.setValue(data.referente?.referenteTelefono!)
    this.riferimentoForm.get('email_pec')?.setValue(data.referente?.referenteEmail!)
  }

  resetForm(){
    this.datiForm.get('denominazione')?.setValue("")
    this.datiForm.get('descrizione')?.setValue("")
    this.datiForm.get('finalita')?.setValue("")
    this.datiForm.get('durata')?.setValue("")
    this.datiForm.get('attore')?.setValue("")

    this.riferimentoForm.get('cognome')?.setValue("")
    this.riferimentoForm.get('nome')?.setValue("")
    this.riferimentoForm.get('telefono')?.setValue("")
    this.riferimentoForm.get('email_pec')?.setValue("")
  }
  enableForm(){
    this.form.enable()
  }

  //Apri modale
  apriModaleRegionali(){
    this.dialog.open(this.regionali, {
      panelClass: "dialog-tipologie-servizio",
    });
  }


  modale!: MatDialogRef<any,any>;
  apriModaleEsterni(nuovo:boolean){
    if(nuovo){
      this.form.enable();
      this.form.markAsUntouched();
      this.resetForm();
    }
    if(this.individuale){
      this.datiForm.controls['finalita'].setValue('I');
      this.datiForm.controls['finalita'].disable();
    }
    this.nuovoServizio = nuovo;


    this.modale = this.dialog.open(this.esterni, {
      panelClass: "dialog-tipologie-servizio",
    });
  }

  openRegionali(){
    this.serviziRegionali$
    .subscribe(
      response => {
        let filtred = response;
        if(this.individuale){
          filtred = response.filter(a => a.codFinalitaServizio=="I")
        }
        if(this.isPubblico){

        }

        this.tipologieRegionaliCheck = this.responseMapped(filtred);
        this.tipologieRegionaliCheckCopia = this.responseMapped(filtred);
        this.apriModaleRegionali();
      }
    )
  }

  responseMapped(response:ServizioRegionale[]): SimpleTipologia[]{

    let mapped = response.map(
      tipologia => {return {
              idServizioModello:this.tipologieServizi.find(a => {
                                  if(a.servizioRegionale?.idServizioRegionale){
                                    return a.servizioRegionale.idServizioRegionale ==
                                          tipologia.idServizioRegionale}
                                  return false;
                                  })?.idServizioModello,
              idServizioRegionale: tipologia.idServizioRegionale,

              check: this.tipologieServizi.find(a => {
                                  if(a.servizioRegionale?.idServizioRegionale){
                                    return a.servizioRegionale.idServizioRegionale ==
                                          tipologia.idServizioRegionale}
                                  return false;
                                  }) ? true : false,

              codice: tipologia.codiceServizioRegionale,
              descrizione: tipologia.descrServizioRegionale,
              finalita: tipologia.descrFinalitaServizio,
              durata: tipologia.oreConsentiteMin +"-"+ tipologia.oreConsentiteMax,
      }}
    )

    if(this.isPubblico){
      mapped=mapped.filter(a=>a.idServizioModello==undefined);
    }
    return mapped
  }

  updateAllComplete(){
    this.allComplete = this.tipologieRegionaliCheck.every(t=>t.check);
  }

  someComplete(): boolean {
    if (this.tipologieRegionaliCheck == null) {
      return false;
    }
    return this.tipologieRegionaliCheck.filter(t => t.check).length > 0 && !this.allComplete;
  }
  setAll(completed: boolean) {
    this.allComplete = completed;
    if (this.tipologieRegionaliCheck == null) {
      return;
    }
    this.tipologieRegionaliCheck.forEach(t => (t.check = completed));
  }

  aggiornaRegionali(){
    let serviziDaCancellare:ServizioModello[] =[];
    let serviziDaInserire  :ServizioModello[] =[];
    let serviziDaAggiornare:ServizioModello[] =[];
    for(let i=0; i<this.tipologieRegionaliCheck.length;i++){
        if(this.tipologieRegionaliCheck[i].check==this.tipologieRegionaliCheckCopia[i].check){
            if(this.tipologieRegionaliCheck[i].durata != this.tipologieRegionaliCheckCopia[i].durata ){
              serviziDaAggiornare.push(this.createServizioModelloFromSimple(this.tipologieRegionaliCheck[i]))
            }
        }
        else{
          if(this.tipologieRegionaliCheck[i].check){
            serviziDaInserire.push(this.createServizioModelloFromSimple(this.tipologieRegionaliCheck[i]));
          }else{
            serviziDaCancellare.push(this.createServizioModelloFromSimple(this.tipologieRegionaliCheck[i]))
          }}
    }
    if(serviziDaCancellare.length>0){
      this.elencoRegionaliDaCancellare.emit(serviziDaCancellare);
    }
    if(serviziDaInserire.length>0){
      this.elencoRegionaliDaInserire.emit(serviziDaInserire);
    }
    if(serviziDaAggiornare.length>0){
      this.elencoRegionaliDaAggiornare.emit(serviziDaAggiornare);
    }
  }

  createServizioModelloFromSimple(simple: SimpleTipologia):ServizioModello{
    return {
      idServizioModello: simple.idServizioModello,
      idModelloDiIntervento: this.idModello,
      servizioRegionale: {
        idServizioRegionale: simple.idServizioRegionale,
        descrServizioRegionale: simple.descrizione,
        descrFinalitaServizio: simple.finalita,
      },
      durataInOre:Number(simple.durata),
      // codUserInserim
    }
  }

  //########################################//
  //Handle Modale servizi Esterni
  onConfermaEsterno(){
    this.form.markAllAsTouched()
    if(this.form.valid){
      this.saveServizioEsterno();
    }
  }
  saveServizioEsterno(){
    if(this.nuovoServizio){
      this.servizioEsternoDaInserire.emit(this.createNewServizioEsterno())
    }else{
      this.servizioEsternoDaAggiornare.emit(this.createUpdatedServizioEsterno())
    }
    this.modale.close();
  }

  createUpdatedServizioEsterno(){
    let servizio = this.createNewServizioEsterno()
    servizio.idServizioModello = this.servizioEsternoToUpdate.idServizioModello;
    servizio.descrFinalitaServizioEsterno = this.servizioEsternoToUpdate.descrFinalitaServizioEsterno;
    servizio.idDestinatario = this.servizioEsternoToUpdate.idDestinatario;
    servizio.codUserInserim = this.servizioEsternoToUpdate.codUserInserim;
    servizio.dInserim = this.servizioEsternoToUpdate.dInserim;

    return servizio;
  }
  createNewServizioEsterno():ServizioModello{
    let servizio:ServizioModello = {
      idModelloDiIntervento: this.idModello,
      titoloServizioEsterno: this.datiForm.controls['denominazione']?.value!,
      descrizioneServizioEsterno: this.datiForm.controls['descrizione']?.value!,
      codFinalitaServizioEsterno: this.datiForm.controls['finalita']?.value!,
      attoreEsterno: String(this.datiForm.get('attore')?.value),
      durataInOre: this.handlerDurataVirgola(),
      referente: {
        referenteNome: String(this.riferimentoForm.controls['nome']?.value),
        referenteCognome: String(this.riferimentoForm.controls['cognome']?.value),
        referenteEmail: String(this.riferimentoForm.controls['email_pec']?.value),
        referenteTelefono: String(this.riferimentoForm.controls['telefono']?.value),
      },
      dInserim: new Date()
    }

    return servizio;
  }

  handlerDurataVirgola():number{
    let durata:string = String(this.datiForm.get('durata')?.value);
    if(durata.includes(",")) durata = durata.replace(",",".")

    return parseFloat(durata);
  }
}

interface SimpleTipologia {
  idServizioModello?:number,
  // idModelloDiIntervento?:number,
  idServizioRegionale?:number,

  check?: boolean,

  codice?:string,
  denominazione?: string,
  descrizione?: string,
  tipo?: string,
  finalita?: string,
  durata?: string,

  icons?: boolean,
}
