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

import { Component, OnInit, ViewChild, TemplateRef } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

//-Models
import { Destinatario } from '@core/api-serse/model/destinatario';
import { ButtonActionSettingModel, ColumnSettingsModel, InfoColumnActionSettingModel, TableSettingsModel } from '@shared/model/table-setting.model';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';

//-Services
import { HomeBagService } from '@home/services/home-bag.service';
import { DestinatariService } from '@core/services/destinatari.service';
import { InterventiService } from '@interventi/services/interventi.service';

//-Utils
import { IconsSettings } from '@shared/const/icons-settings';
import { Validation } from '@shared/utils/validation';

//-Components
import { DialogDestinatarioComponent } from '@shared/components/dialog-destinatario/dialog-destinatario.component';
import { DialogConfermaComponent } from '../dialog-conferma/dialog-conferma.component';
import { ServiziService } from '@servizi/services/servizi.service';
import { TableComponent } from '../table/table.component';
import { DatiPeculiariWrapper } from '@core/api-serse/model/datiPeculiariWrapper';
import { DatiPeculiari } from '@core/api-serse/model/datiPeculiari';
import { ServizioWrapper } from '@core/api-serse/model/servizioWrapper';
import { FilterServizi } from '@servizi/model/filterServizi';

@Component({
  selector: 'app-destinatari-gestione',
  templateUrl: './destinatari-gestione.component.html',
  styleUrls: ['./destinatari-gestione.component.scss']
})
export class DestinatariGestioneComponent implements OnInit {

  errorNessunCampo = "";

  form = this.fb.group({
    nome:['',[Validation.nomeValidator]],
    cognome:['',[Validation.cognomeValidator]],
    codFisc:['',[Validators.minLength(16)]],
    dataNascita:['',],
  })

  //--Table In Intervento
  rowDestInt : DestinatarioSimple[] = [];
  columnListDestInt: ColumnSettingsModel[] = [];
  buttonsTabellaDestInt : ButtonActionSettingModel[] = []
  tableSettingsDestInt: TableSettingsModel = new TableSettingsModel();

  //-Table
  visibileTable = false;
  rowDataDestinatari : DestinatarioSimple[] = [];
  columnListDestinatari: ColumnSettingsModel[] = [];
  buttonsTabellaDestinatari : ButtonActionSettingModel[] = []
  tableSettingsDestinatari: TableSettingsModel = new TableSettingsModel();

  destinatariList: Destinatario[] = [];
  destinatariIntList: Destinatario[] = [];

  dialogNovoDestinatario:any;

  modaleDatinCorrelati:any;
  datiPeculiari:DatiPeculiariWrapper|undefined={};
  fromIntervento = true;
  servizioIntervento = false;
  destinatario?:Destinatario
  //-Filtri Seleziona data
  myFilter = (d: any): boolean => {
    let day: Date;
    if(d)
      day = new Date(d)
    else
      day = new Date()
    return day < new Date();
  };

  constructor(
    private fb: FormBuilder,
    private destintariService: DestinatariService,
    private interventiService: InterventiService,
    private serviziService: ServiziService,
    private homeBag: HomeBagService,

    private router:Router,
    private dialog: MatDialog,
  ) { }

  ngOnInit(): void {

    this.createTableDestInt();
    this.fromIntervento = this.router.url.includes('servizio') ?false:true;

    if(!this.fromIntervento) {
      this.servizioIntervento = this.serviziService.servizio.idIntervento ?true :false;
      this.serviziService.tab = 2;
      if(this.servizioIntervento){
        this.fetchDestinatariIntervento();}
    }else{
      this.interventiService.tab = 1;
    }
    this.createTableDestinatari()
  }

  fetchDestinatariIntervento(){
    this.destintariService.getDestinatariInterventoServizio(this.serviziService.servizio.idServizio!.toString())
    .pipe()
    .subscribe(risp =>{

      const codFiscSet: Record<string, boolean> = {};
      for (const codFisc of this.destintariService.destAlreadyAssoc) {
        codFiscSet[codFisc] = true;
      }
      for (const element of risp) {
        if (!codFiscSet[element.codiceFiscaleDestinatario!]) {
          this.destinatariIntList.push(element);
        }
      }

      this.rowDestInt = this.destinatariIntList.map(r => {return {
        // select:false,
        idDestinatario: r.idDestinatario,
        codFisc: r.codiceFiscaleDestinatario,
        congome: r.cognomeDestinatario,
        nome: r.nomeDestinatario,
        dataNascita: new Date(r.dNascita!).toLocaleDateString(),
        luogoNascita: r.statoEsteroNascita
                      ?r.statoEsteroNascita.decrizioneStato
                      :r.comuneNascita?.descrizioneComune+" - "+r.comuneNascita?.provincia?.siglaProvincia,
        codCittadinanza:r.codCittadinanza!
      }})
    })
  }
  // Tabella destinatari da intervento---------------
  createTableDestInt(){
    this.tableSettingsDestInt.title = 'Elenco Destinatari Intervento';
    this.tableSettingsDestInt.enableExport = false;
    this.tableSettingsDestInt.enableButtons = true;
    this.tableSettingsDestInt.isRadio = false;

    this.createColumnsTableDestInt();
    this.createButtonsTableDestInt();
  }
  createColumnsTableDestInt(){
    const radioColumn = new ColumnSettingsModel( 'select', '', false, 'select');
    const codFiscColumn = new ColumnSettingsModel( 'codFisc', 'Codice Fiscale', false,'simple');
    const cognomeColumn = new ColumnSettingsModel( 'congome', 'Cognome', false, 'simple');
    const nomeColumn = new ColumnSettingsModel( 'nome', 'Nome', false, 'simple');
    const dataNascitaColumn = new ColumnSettingsModel( 'dataNascita', 'Data di nascita', false, 'simple');
    const luogoNascitaColumn = new ColumnSettingsModel( 'luogoNascita', 'Luogo di nascita', false, 'simple');
    const actionColumn = new ColumnSettingsModel( 'azioni', '', true, 'action');

    actionColumn.iconAction.push(...this.iconsActionColumn(true))

    this.columnListDestInt.push(...[ radioColumn, codFiscColumn, cognomeColumn,
                                      nomeColumn, dataNascitaColumn, luogoNascitaColumn,
                                      actionColumn
                                    ]);
  }
  createButtonsTableDestInt(){
    let buttonSeleziona = new ButtonActionSettingModel( "AGGIUNGI DESTINATARI SELEZIONATI",
      (data) => {this.handlerDestinatriInterventoServizio(data)},
      "btn btn--primary"
    )
    this.buttonsTabellaDestInt.push(...[buttonSeleziona])
  }

  handlerDestinatriInterventoServizio(destinatari:DestinatarioSimple[]){
    if(!destinatari.length){
      this.dialogSelezionaDestinatario()
      return;
    }
    if((destinatari.length+this.destintariService.numDestinatAssoc) > this.serviziService.servizio.numMaxDestinatari!){
      this.dialogAttenzioneServizi(["Con numero destinatari selezionati, si supera il numero dei destinatari massimi"]);
      return;
    }

    this.postDestinatariServizio(destinatari.map(d=> {return {idDestinatario:d.idDestinatario,
                                                              codiceFiscaleDestinatario: d.codFisc,
                                                              codCittadinanza:d.codCittadinanza}}), true);


  }


  //--------------------------------------
  //--Destinatari da anagrafica
  onCerca(){
    this.errorNessunCampo = "";
    if(this.form.invalid) return;
    if(this.allFieldBlank()){
      this.errorNessunCampo = "Attenzione: compilare almeno uno dei parametri di ricerca."
      return;
    }

    this.fetchDestinatari();
  }

  //--------------------------------------
  //-Search Field is Blank or not
  allFieldBlank():boolean{
    return this.isCognomeBlank() && this.isNomeBlank() &&
            this.isDNascitaBlank() && this.isCodFiscBlank();
  }
  isCognomeBlank(): boolean{
    return this.form.controls['cognome'].value ?false:true;
  }
  isNomeBlank(): boolean{
    return this.form.controls['nome'].value ?false:true;
  }
  isCodFiscBlank(): boolean{
    return this.form.controls['codFisc'].value ?false:true;
  }
  isDNascitaBlank(): boolean{
    return this.form.controls['dataNascita'].value ?false:true;
  }

  //--------------------------------------------
  //-Gestione Tabella
  fetchDestinatari(){
    let dataFilter =  this.form.controls['dataNascita'].value ?new Date(this.form.controls['dataNascita'].value) :undefined;
    let dataString = dataFilter ?dataFilter.getFullYear()+"-"+(dataFilter.getMonth()+1)+"-"+dataFilter.getDate() :undefined;

    this.destintariService.getDestinatari(
      String(this.form.controls['cognome'].value),
      String(this.form.controls['nome'].value),
      String(this.form.controls['codFisc'].value),
      dataString,)
    .pipe()
    .subscribe(response=> {
      this.destinatariList = response;
      this.rowDataDestinatari = response.map(
        r=> {return {
          idDestinatario: r.idDestinatario,
          codFisc: r.codiceFiscaleDestinatario,
          congome: r.cognomeDestinatario,
          nome: r.nomeDestinatario,
          dataNascita: new Date(r.dNascita!).toLocaleDateString(),
          luogoNascita: r.statoEsteroNascita ?r.statoEsteroNascita.decrizioneStato
                                              :r.comuneNascita?.descrizioneComune +" "+r.comuneNascita?.provincia?.siglaProvincia,
          codCittadinanza:r.codCittadinanza!
        }}
      );
      this.visibileTable = true;
    })
  }
  createTableDestinatari(){
    this.tableSettingsDestinatari.title = 'Elenco Destinatari';
    this.tableSettingsDestinatari.enableExport = false;
    this.tableSettingsDestinatari.enableButtons = true;
    // this.tableSettingsROperatore.enableRadioButton = true;

    this.createColumnsTableDestinatari();
    this.createButtonsTableDestinatari();
  }
  createColumnsTableDestinatari(){
    const radioColumn = new ColumnSettingsModel( 'radio', '', false, 'radio');
    const codFiscColumn = new ColumnSettingsModel( 'codFisc', 'Codice Fiscale', false, 'simple');
    const cognomeColumn = new ColumnSettingsModel( 'congome', 'Cognome', false, 'simple');
    const nomeColumn = new ColumnSettingsModel( 'nome', 'Nome', false, 'simple');
    const dataNascitaColumn = new ColumnSettingsModel( 'dataNascita', 'Data di nascita', false, 'simple');
    const luogoNascitaColumn = new ColumnSettingsModel( 'luogoNascita', 'Luogo di nascita', false, 'simple');
    const actionColumn = new ColumnSettingsModel( 'azioni', '', true, 'action');

    actionColumn.iconAction.push(...this.iconsActionColumn())

    this.columnListDestinatari.push(...[ radioColumn, codFiscColumn, cognomeColumn,
                                          nomeColumn, dataNascitaColumn, luogoNascitaColumn,
                                          actionColumn
                                        ]);
  }
  iconsActionColumn(destInt:boolean = false): InfoColumnActionSettingModel[]{
    /** Icons */
    const editIcon = new InfoColumnActionSettingModel( IconsSettings.PEN_ICON, "icon", "modifica",
                        (row) => {
                          this.modificaDestinatario(row.idDestinatario,destInt)
                        },"modifica dati destinatario"
                      );
    return [editIcon];
  }
  createButtonsTableDestinatari(){
    let buttonSeleziona = new ButtonActionSettingModel(
      "AGGIUNGI DESTINATARIO SELEZIONATO",
      (data) => { this.handleAggiungiSelezionato(data? data.idDestinatario:undefined)},
      "btn btn--primary","AGGIUNGI DESTINATARIO SELEZIONATO","AGGIUNGI DESTINATARIO SELEZIONATO"

    )
    let buttonNuovo = new ButtonActionSettingModel(
      "AGGIUNGI NUOVO DESTINATARIO",
      () => { this.handleAggiungiNuovo()},
      "btn btn--primary","AGGIUNGI NUOVO DESTINATARIO","AGGIUNGI NUOVO DESTINATARIO"
    )
    this.buttonsTabellaDestinatari.push(...[buttonNuovo,buttonSeleziona])
  }
  //-Modifica Dati destinatario
  modificaDestinatario(idDestinatario:number, destInt:boolean = false){
    let destinatario;
    if(destInt) destinatario = this.destinatariIntList.find(d => d.idDestinatario == idDestinatario)
    else destinatario = this.destinatariList.find(d => d.idDestinatario == idDestinatario)
    this.dialogNovoDestinatario = this.dialog.open(DialogDestinatarioComponent, {
      disableClose:true,
      data: new DialogSettings(
        "",[],"","",
        [new DialogButton(
            "Annulla",
            "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--primary",
          (destinatario)=>{this.onConfermaModificaDestinatario(destinatario)},
          "conferma modifica destinatario"
        )],

        [destinatario]
      )
    })
  }

  dialogSelezionaDestinatario(){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
        "Attenzione",
        ["Nessun destinatario selezionato"],
        "card-body--danger"
      )
    });
  }
  filtro: FilterServizi = {
    numProgrSportello: {eq: this.homeBag.selectedSportello.numProgrSportello},
    gruppoOperatore: {eq: this.homeBag.gruppoOperatore},
    codOperatore: {eq: +this.homeBag.codiceOperatore},
    isProprietario: {eq: false}

  };
  listService: ServizioWrapper[] = [];

  //-Gestione Associa destinatario
  handleAggiungiSelezionato(idDestinatario?:number){
    this.destinatario=this.destinatariList.find(dest=> dest.idDestinatario == idDestinatario);

    if(!idDestinatario){
      this.dialogSelezionaDestinatario();
      return;
    }

    if(this.destinatarioGiaAssociato(idDestinatario)){
      this.dialogAttenzioneServizi(["il destinatario è già stato associato al "+(this.fromIntervento?"Intervento":"Servizio")]);
      return;
    }

    // From Intervento---------------------------------------------
    if(this.fromIntervento){
      this.destintariService.assocciaDestinatarioAdIntervento(
        this.interventiService.intervento.idIntervento!,
        this.homeBag.userInfo.codFisc!,
        idDestinatario
      ).pipe()
      .subscribe(r=>{
        this.interventiService.intervento.idDestinatario = idDestinatario;
        this.interventiService.tab = 1;
        this.router.navigateByUrl(this.backTo);
      })
    }
    // From Servizio---------------------------------------------
    else{

      if(this.serviziService.servizio.numMaxDestinatari! <= this.destintariService.numDestinatAssoc){
        this.dialogAttenzioneServizi(["Numero massimo destinatari raggiunto!"]);
        return;
      }

      this.filtro.codFiscaleDestinatario = {eq: this.destinatario?.codiceFiscaleDestinatario!};
      this.listService = [];
      this.serviziService.getServizi(this.filtro).subscribe({
        next: ris=>{
          // Cerco Servizi Simili
          ris.items!.forEach(serv=>{
            if(this.serviziService.servizio.servizioRegionale?.codiceServizioRegionale==serv.servizio?.servizioRegionale?.codiceServizioRegionale){
                this.listService.push(serv);
              }
            }
          );

          if(this.listService.length==0){
            this.postDestinatariServizio(
              [
                {
                  idDestinatario:this.destinatario!.idDestinatario,
                  codiceFiscaleDestinatario:this.destinatariList.find(dest=> dest.idDestinatario == this.destinatario!.idDestinatario)?.codiceFiscaleDestinatario,
                  codCittadinanza:this.destinatario!.codCittadinanza
                }
              ],
              undefined,undefined);
          }
          else{
            this.dialogConfermaServizioDuplicato();
          }
        }
      });

    }//this.dialogDatiParticolari()
  }

  //Servizi Gestione-------------------------------
  destinatarioGiaAssociato(idDestinatario:number){
    let codFisc =this.destinatariList.find(dest=> dest.idDestinatario == idDestinatario)?.codiceFiscaleDestinatario;
    return this.destintariService.destAlreadyAssoc.find( destCod => destCod == codFisc) ?true :false;
  }
  @ViewChild('tabellaDaInt') tabellaDaInt!: TableComponent;
  // Insert Destinatari Servizio ---------------
  postDestinatariServizio(destinatari: Destinatario[], fromIntervento:boolean=false, datiParticolari?:DatiPeculiari){
    this.destintariService.assocciaDestinatarioAServizio(
      this.serviziService.servizio.idServizio!,
      this.homeBag.userInfo.codFisc!,
      destinatari
    ).subscribe(ris=>{

      destinatari.forEach(dest=>{
        this.destintariService.destAlreadyAssoc.push(dest.codiceFiscaleDestinatario!);
        this.destintariService.numDestinatAssoc++;
      })
      /**
       * Se i destinatari associati sono tra quelli derivati dall'intervento
       * li rimuovo dalla tabella dei detinatari dall'intervento
      */
      if(fromIntervento) {
        destinatari.forEach(dest=>
          this.rowDestInt.splice(
            this.rowDestInt.findIndex((data)=>
              data.idDestinatario == dest.idDestinatario),1));
        this.rowDestInt = [...this.rowDestInt];
        this.tabellaDaInt.clearSelection();
      }
      this.dialogConfermaServizio()
      if(datiParticolari){

        datiParticolari.destinatarioServizio!.idServizio=this.servizio.idServizio
        datiParticolari.destinatarioServizio!.codUserInserim=this.homeBag.userInfo.codFisc
        datiParticolari.destinatarioServizio!.dInserim=ris[0].dInserim

        this.destintariService.aggiornaDatiPeculiariDest(datiParticolari).subscribe(
          resp=> {
            this.datiPeculiari=resp
            this.modaleDatinCorrelati.close()

        })
      }

    })
  }

  // Dialog Destinatari Servizio ---------------
  dialogConfermaServizio(){
    this.dialog.open(DialogConfermaComponent,{
      width: "40vw",
      data: new DialogSettings("Avviso",["Destinatario associato correttamente al Servizio"],"card-body--success",'',
        [
          new DialogButton("RIMANI IN QUESTA PAGINA","btn btn--outline-primary",undefined,"rimani in questa pagina"),
          new DialogButton("TORNA AI DESTINATARI DEL SERVIZIO","btn btn--primary",
            ()=>{
              this.serviziService.tab = 2;
              this.router.navigateByUrl(this.backTo);
            },"torna all'elenco destinatari")
        ]
      )
    });
  }

  @ViewChild('ListaServiziAssociati') dialogListService!: TemplateRef<any>;
  dialogConfermaServizioDuplicato(){
    this.dialog.open(this.dialogListService, {
      width: "40vw",
    });

  }




  dialogAttenzioneServizi(msg: string[]){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings("Attenzione",msg,"card-body--warning")
    });
  }

  // ---------------------------------------------------------

  handleAggiungiNuovo(){
    if(this.serviziService.servizio.numMaxDestinatari! <= this.destintariService.numDestinatAssoc){
      this.dialogAttenzioneServizi(["Numero massimo destinatari raggiunto!"]);
      return;
    }

    //-Caso intervento e servizio con ancora un po di spazio
    this.dialogNovoDestinatario = this.dialog.open(DialogDestinatarioComponent, {
      disableClose:true,
      data: new DialogSettings(
        "",[],"","",
        [new DialogButton(
            "Annulla",
            "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--primary",
          (destinatario)=>{this.onAggiungiNuovoDestinatario(destinatario)},
          "aggiungi nuovo destinario"
        )]
      )
    })
  }

  onConfermaModificaDestinatario(destinatario:Destinatario){
    destinatario.gruppoOperatoreAggiornamento = this.homeBag.gruppoOperatore
    destinatario.codOperatoreAggiornamento = +this.homeBag.codiceOperatore
    destinatario.codUserAggiorn = this.homeBag.userInfo.codFisc
    destinatario.dAggiorn = new Date()

    this.destintariService
        .aggiornaDestinatario(destinatario).
        pipe()
        .subscribe(
          resp=> {
            let index = this.destinatariList.findIndex(d=> d.idDestinatario == resp.idDestinatario);
            this.destinatariList[index] = resp;
            this.dialogNovoDestinatario.close()
        })

  }
  onAggiungiNuovoDestinatario(destinatario: Destinatario){
    destinatario.gruppoOperatoreInserimento = this.homeBag.gruppoOperatore
    destinatario.gruppoOperatoreAggiornamento = this.homeBag.gruppoOperatore

    destinatario.codOperatoreInserimento = +this.homeBag.codiceOperatore
    destinatario.codOperatoreAggiornamento = +this.homeBag.codiceOperatore

    destinatario.codUserAggiorn = this.homeBag.userInfo.codFisc
    destinatario.codUserInserim = this.homeBag.userInfo.codFisc

    destinatario.dInserim = new Date()
    destinatario.dAggiorn = new Date()

    this.destintariService.testCodiceFiscale(destinatario.codiceFiscaleDestinatario!)
        .pipe()
        .subscribe( risp =>{
          if(risp.isCodiceFiscaleInAnagrafica){
            this.dialog.open(DialogConfermaComponent,{
              data: new DialogSettings(
                "Errore",
                ["il destinatario selezionato è già presente nel sistema"],
                "card-body--danger"
              )
            });
          }
          else this.aggiungiDestinatario(destinatario);
        })
  }
  aggiungiDestinatario(destinatario:Destinatario){
    if(this.fromIntervento){
      this.destintariService.aggiungiNuovoDestinatarioIntervento(
        this.interventiService.intervento.idIntervento!.toString(),
        this.homeBag.userInfo.codFisc!,
        destinatario)
      .pipe()
      .subscribe(
        resp=> {
          this.dialogNovoDestinatario.close();
          this.interventiService.intervento.idDestinatario = resp.idDestinatario;
          this.interventiService.tab = 1;
          this.router.navigateByUrl(this.backTo);
        }
      )

    }else{
      this.destintariService.aggiungiNuovoDestinatarioServizio(
          this.serviziService.servizio.idServizio!,
          this.homeBag.userInfo.codFisc!,
          destinatario)
          .pipe()
          .subscribe({
            next:resp=> {
              this.dialogNovoDestinatario.close();
              this.destinatario=resp;
              //this.dialogDatiParticolariNuovoDest()
              this.destintariService.destAlreadyAssoc.push(resp.codiceFiscaleDestinatario!);
              this.destintariService.numDestinatAssoc++;
              this.dialogConfermaServizio()
            }
          });
    }//-END else
  }


  //-Gestione casistica Servizio
  testMaxDestiantarioAssociabile(){
    // this.destintariService.
  }


  get backTo(){
    return this.destintariService.backTo;
  }

  get servizio(){
    return this.serviziService.servizio
  }

}

interface DestinatarioSimple{
  idDestinatario?:number
  codFisc?: string
  congome?: string
  nome?: string
  dataNascita?: string
  luogoNascita?: string
  codCittadinanza: string
}
