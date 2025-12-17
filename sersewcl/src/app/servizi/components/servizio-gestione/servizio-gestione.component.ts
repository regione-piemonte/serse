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

import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TitleService } from '@core/services/title.service';

// Custome table
import { TableSettingsModel, ColumnSettingsModel, InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { ServiziBagService } from '../../services/servizi-bag.service';
import { ServiziService } from '../../services/servizi.service';
import { FiltriRicerca } from '@shared/model/filtri-ricerca.model';
import { tap } from 'rxjs';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { ServizioWrapper } from '@core/api-serse/model/servizioWrapper';
import { IconsSettings } from '@shared/const/icons-settings';
import { HomeBagService } from '@home/services/home-bag.service';
import { ExcelService } from '@core/services/excel.service';
import { ExcelServizio } from '@core/api-serse/model/excelServizio';
import { FilterServizi } from '@servizi/model/filterServizi';
import { HttpResponse } from '@angular/common/http';
import { ExportService } from '@shared/services/export.service';
import { FilterServiziSituazioneIncontro } from '@servizi/model/filterServiziSituazioneIncontro';
import { PageEvent } from '@angular/material/paginator';
import { CriteriRicercaBagService } from '@core/services/criteri-ricerca-bag.service';
import { Sort } from '@angular/material/sort';


@Component({
  selector: 'app-servizio-gestione',
  templateUrl: './servizio-gestione.component.html',
  styleUrls: ['./servizio-gestione.component.scss']
})
export class ServizioGestioneComponent implements OnInit {
  visibleTable = false;

  //Gestione tabella
  rowData :SimpleServizio[]=[];

  // Informazione paginazione tabella
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];
  data: ServizioWrapper[]=[];

  filtriRicerca!: FilterServizi; // nel formato CSI
  sort?: string; // nel formato CSI

  exportData:ExcelServizio[]=[];
  constructor(
    private serviziBag: ServiziBagService,
    private servizioService: ServiziService,
    private title: TitleService,
    private dialog: MatDialog,
    private homeService:HomeBagService,
    private router: Router,
    private criteriRicercaBag: CriteriRicercaBagService,
    private excelService: ExcelService,
    private exportSvc: ExportService
  ) { }

  ngOnInit(): void {
    this.title.setTitle("Gestione servizi");
    this.title.setIcon(IconsSettings.SERVIZI_ICON);
    this.servizioService.setIsModificabile(true);
    this.createTable();
  }

  //################ Criteri di ricerca ################//
  showTable(filtri:FiltriRicerca){
    this.filtriRicerca = this.createFilterServizi(filtri);
    this.getData(0)
  }

  getData(page: number){
    if (page == 0) {
      this.visibleTable = false;
    }
    const limit = this.criteriRicercaBag.pageSize;
    const offset = page * limit;

    this.servizioService.getServizi(this.filtriRicerca, offset, limit, this.sort).subscribe({
      next:response=>{
        this.data=response.items!;
        this.tableSettings = {...this.tableSettings,
            length: response.count!,
            pageIndex: page,
            pageSize: this.criteriRicercaBag.pageSize};
        this.rowData=[...this.data.map(servizioWrap=>{return {
          id:{
            simple: servizioWrap.servizio?.idServizio!.toString(),
            icon:this.getIsAssociatoIcon(servizioWrap.servizio?.idIntervento)
          },
          titolo:servizioWrap.servizio?.titoloServizio!,
          finalita:servizioWrap.servizio?.servizioRegionale?.descrFinalitaServizio!,

          destinatario:servizioWrap.destinatario?servizioWrap.destinatario?.nomeDestinatario!
          + " " +servizioWrap.destinatario?.cognomeDestinatario:"",

          soggAttuatore: servizioWrap.servizio?.soggettoAttuatore?.gruppoOperatore! + servizioWrap.servizio?.soggettoAttuatore!.codOperatore?.toString()
          +"-"+ servizioWrap.denominazioneSoggettoAttuatore,
          progressivoSede:servizioWrap.servizio?.progressivoSede,

          soggBeneficiario:servizioWrap.soggettoBeneficiario?.gruppoOperatore! + servizioWrap.soggettoBeneficiario?.codOperatore!
          +"-"+servizioWrap.soggettoBeneficiario?.denominazione,

          istanzaCandidatura:servizioWrap.servizio?.soggettoAttuatore?.modelId!.toString(),
          descrStatoServizio:servizioWrap.servizio?.statoServizio?.descrStatoServizio!,
          icons: this.createIconsServizio(servizioWrap.isProprietario!,servizioWrap.servizio?.statoServizio?.descrStatoServizio!,
            servizioWrap.sportelloDfine!)

        }})]
        this.visibleTable = true;
      }
    })
  }
  //################ Table ################//
  createTable(){
    this.tableSettings.title = 'Elenco Servizi';
    this.tableSettings.enableExport=true
    this.tableSettings.enableButtons=true;
    this.createColumnsTable();
  }

  createColumnsTable(){
    /**Columns */

    const idServizioColumn = new ColumnSettingsModel(
      'id',
      'Identificativo',
      false,
      'label'
    );
    const titoloColumn = new ColumnSettingsModel(
      'titolo',
      'Titolo',
      false,
      'simple'
    );
    const finalitaColumn = new ColumnSettingsModel(
      'finalita',
      'Finalità',
      false,
      'simple'
    );
    const destinatarioColumn = new ColumnSettingsModel(
      'destinatario',
      'Destinatario',
      false,
      'simple'
    );
    const soggAttuatoreColumn = new ColumnSettingsModel(
      'soggAttuatore',
      'Soggetto attuatore',
      false,
      'simple'
    );
    const progressivoSede = new ColumnSettingsModel(
      'progressivoSede',
      'Sede',
      false,
      'simple'
    );
    const soggBeneficiarioColumn = new ColumnSettingsModel(
      'soggBeneficiario',
      'Soggetto beneficiario',
      false,
      'simple'
    );
    const istanzaCandidaturaColumn = new ColumnSettingsModel(
      'istanzaCandidatura',
      'Istanza di candidatura',
      false,
      'simple'
    );
    const statoColumn = new ColumnSettingsModel(
      'descrStatoServizio',
      'Stato',
      true,
      'simple'
    );
    const customActionColumn = new ColumnSettingsModel(
      'icons',
      '',
      true,
      'customAction'
    );


    this.columnList.push(...[
      //selectColumn,
      idServizioColumn,
      titoloColumn,
      finalitaColumn,
      destinatarioColumn,
      soggAttuatoreColumn,
      progressivoSede,
      soggBeneficiarioColumn,
      istanzaCandidaturaColumn,
      statoColumn,
      customActionColumn
    ]);

  }


  //icone
  //############# Handle Icons #################
  createIconsServizio(isProprietario: boolean, stato:string, fineSportello:Date):InfoColumnActionSettingModel[]{
    // elimina  proprietà & associato a nessun intevento
    // modifica proprietà & sportello aperto & stato diverso da chiuso
    // occhio   stato chiuso &  non è di proprietà
    // duplica  sportello aperto

    let icons: InfoColumnActionSettingModel[] = [];




    if(!isProprietario || stato == "Chiuso" || !this.servizioService.isModificabile){
      icons.push(this.getViewIcon());
    }else{
      icons.push(this.getEditIcon());
    }
    if(isProprietario && stato=="In definizione" && this.servizioService.isModificabile){
      icons.push(this.getDeleteIcon());
    }
    return icons;
  }

  getEditIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.PEN_ICON,
        "icon",
        "modifica",
        (row) => {
              // recurpero l'id e rispendisco nella pagina di modifica

              this.openServizio(row.id.simple,true,true);
              },"modifica servizio",
        false
      );
  }
  getDeleteIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.TRS_ICON,
        "icon",
        "Elimina",
        (row) => {
          // recuperare l'id aprire modale per conferma
          this.apriModaleConferma(row.id.simple);
        },"elimina servizio"
      );
  }
  getViewIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.EYE_ICON,
        "icon",
        "visualizza",
        (row) => {

              this.openServizio(row.id.simple,false,true);
            },"visualizza servizio"
      );
  }
  getDuppIcon(){
    return  new InfoColumnActionSettingModel(
        IconsSettings.DUP_ICON,
        "icon",
        "duplica",
        (row) => {
              // TODO comportamento per ora ignoto
              },
              "duplica servizio"
      );
  }


  getIsAssociatoIcon(idIntervento?: number):InfoColumnActionSettingModel{
    if(idIntervento){
      return new InfoColumnActionSettingModel(
        IconsSettings.LINK_ICON,
        'icon',
        "servizio creato da intervento numero: " + idIntervento,
        undefined,
        "servizio creato da intervento numero: " + idIntervento,
      )
    }
    return new InfoColumnActionSettingModel();
  }

  openServizio(id:number, isModificabile:boolean, isSaved:boolean){
    this.servizioService.getServizioById(id).subscribe({
      next: (response) =>{

        this.servizioService.setServizio(response);
        this.servizioService.setIsModificabile(isModificabile);
        this.servizioService.setIsSaved(isSaved);
        this.servizioService.changeSelectedServizio(response)
        this.servizioService.tab = 0;

        this.servizioService.setBackTo('/dashboard/servizio/gestione');
        this.router.navigate(["/dashboard/servizio/form"]);
      }
    })
  }

  apriModaleConferma(id:number){
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        "Eliminazione servizio",
        [
        "L'eliminazione del servizio non è reversibile",
        "Confermi l'eliminazione"],
        "card-body--warning",
        "Attenzione!",
        [new DialogButton(
            "Annulla",
            "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--danger",
          ()=>{this.onConfermaEliminazione(id)},
          "conferma eliminazione servizio"
          )]
      )
    });
  }

  onConfermaEliminazione(idServizio:number){
    this.servizioService.deleteServizioById(idServizio)
    .pipe(
      tap({
        error: (error)=>{
            this.openModaleErrore(["Attenzione!"," eliminazione Servizio non riuscita. Si prega di riprovare ed eventualmente contattare il servizio di assistenza"])
        }
      })
    )
    .subscribe({
      next: ()=>{
        this.rowData.splice(
          this.rowData.findIndex((data)=> data.id!.simple == idServizio.toString())
          ,1);

        this.rowData = [...this.rowData]
      }
    })
  }

  onChangePage($event: PageEvent) {
    this.getData($event.pageIndex);
  }

  onChangeSort($event: Sort) {
    let sort: string|undefined = undefined;
    if ($event && $event.active && $event.direction) {
      const direction = $event?.direction == 'desc' ? '-' : '+';
      sort = direction + $event.active;
    }
    this.sort = sort;
    this.tableSettings.pageIndex = 0;
    this.getData(0);
  }

  //------------------------------------------------------excel
  estraiDatiExcel(){
    this.data.forEach(element => {
      this.exportData.push(this.createExportModel(element));
    });
    this.excelService.getExcelServizi(this.exportData)
    this.exportData=[];
  }

  createExportModel(ser: ServizioWrapper):ExcelServizio{

    return {
      tipolPso: this.homeService.selectedTipologiaPSO.descrizione!,
      sportello:this.homeService.selectedSportello.dataFine?new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString() +"-"+ new Date(this.homeService.selectedSportello.dataFine).toLocaleDateString() +" "+ this.homeService.selectedSportello.descrizioneSportello!:new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString()+"-"+" "+this.homeService.selectedSportello.descrizioneSportello!,
      soggettoBeneficiario: ser.soggettoBeneficiario?.gruppoOperatore!+ser.soggettoBeneficiario?.codOperatore! + ' - ' +  ser.soggettoBeneficiario?.denominazione!,
      soggettoAttuatore:  ser.servizio?.soggettoAttuatore?.gruppoOperatore! + ser.servizio?.soggettoAttuatore?.codOperatore + '-' + ser.denominazioneSoggettoAttuatore,
      progressivoSede: ser.servizio?.progressivoSede? ser.servizio?.progressivoSede?.toString(): "",
      modelId: ser.servizio?.soggettoAttuatore?.modelId!.toString()!,
      idServizio:ser.servizio!.idServizio!,
      titolo: ser.servizio?.titoloServizio!,
      tipologiaServizio: ser.servizio?.servizioRegionale?.codiceServizioRegionale! +" "+ser.servizio?.servizioRegionale?.descrServizioRegionale  ,
      finalitaServizio: ser.servizio?.servizioRegionale?.descrFinalitaServizio!,
      idIntervento: ser.servizio?.idIntervento!,
      statoServizio:ser.servizio?.statoServizio?.descrStatoServizio!,
      durata:ser.servizio?.durataOre!.toString()!,
      numMaxDestinatari: ser.servizio?.numMaxDestinatari!,
      numeroDestinatariAssociati: ser.destinatario?.codiceFiscaleDestinatario? 1:0,
      cognNomeDesctinatario: ser.destinatario ? ser.destinatario?.cognomeDestinatario+" "+ser.destinatario?.nomeDestinatario: '',
      cFDestinatario:ser.destinatario ?  ser.destinatario?.codiceFiscaleDestinatario!: '',
      codUserInserimento: ser.servizio?.codUserInserim!,
      codUserAggiornamento: ser.servizio?.codUserAggiorn!,
      valoreCampoAggiuntivo1: ser.servizio?.valoreCampoAggiuntivo1
    }
  }



  // liste da passare alla ricerca
  get soggettoBeneficiarioList() {
    return this.serviziBag.soggettoBeneficiarioList
  }
  get istanzeCandidaturaList() {
    return this.serviziBag.istanzaCandidaturaList
  }

  get statiServizioList(){
    return this.serviziBag.statiServizioList.map(ris=>ris.descrStatoServizio)
  }

  get tipologiaServizioList(){
    return this.serviziBag.tipologiaServizioList.map(ris=>ris.codiceServizioRegionale+"-"+ris.descrServizioRegionale)
  }
  get soggettoAttuatoreList() {
    return this.serviziBag.soggettiAttuatori;
  }
  /*get soggettoAttuatoreSediList() {
    return this.serviziBag.soggettiAttuatoriSedi;
  }*/

  openModaleErrore(msg: string[]) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        "Errore",
        msg,
        "card-body--danger"
      )
    });
  }

  createFilterServizi(filtri: FiltriRicerca): FilterServizi{
    let filtroServizio: FilterServizi = {
      numProgrSportello: {eq: this.homeService.selectedSportello.numProgrSportello},
      gruppoOperatore: {eq: this.homeService.gruppoOperatore},
      codOperatore: {eq: +this.homeService.codiceOperatore},
      isProprietario: {eq: filtri.miei}
    }

    if (filtri.identificativo) {
      filtroServizio.idServizio = {eq: +filtri.identificativo}
    }
    if (filtri.beneficiario) {
      filtroServizio.gruppoOpBeneficiario = { eq: this.serviziBag.soggettoBeneficiarioList.find(s => s.codiceFiscale === filtri.beneficiario!)!.gruppoOperatore }
      filtroServizio.codOpBeneficiario = { eq: +this.serviziBag.soggettoBeneficiarioList.find(s => s.codiceFiscale === filtri.beneficiario!)!.codOperatore! }
    }
    if (filtri.istanzaCandidatura) {
      filtroServizio.modelId = { eq: +this.serviziBag.istanzaCandidaturaList.find(i => i.modelId!.toString() == filtri.istanzaCandidatura!)!.modelId?.toString()! }
    }
    if (filtri.stato != undefined && filtri.stato !== '') {
      filtroServizio.idStatoServizio = { eq: this.serviziBag.statiServizioList[+filtri.stato].idStatoServizio }
    }
    if (filtri.tipologiaServizio != undefined && filtri.tipologiaServizio !== '') {
      filtroServizio.idServizioRegionale = { eq: +this.serviziBag.tipologiaServizioList[+filtri.tipologiaServizio].idServizioRegionale?.toString()! }
    }
    if (filtri.finalita) {
      filtroServizio.idFinalitaServizio = { eq: filtri.finalita }
    }
    if (filtri.enteCoinvolto) {
      filtroServizio.denominazioneEnte = { ci: filtri.enteCoinvolto }
    }
    if (filtri.destinatario) {
      filtroServizio.codFiscaleDestinatario = { eq: filtri.destinatario }
    }
    if (filtri.infoIncontro) {
      filtroServizio.situazioneIncontro = { eq: (filtri.infoIncontro as FilterServiziSituazioneIncontro.EqEnum) }
    }
    if (!filtri.miei && filtri.soggettoAttuatore != undefined && filtri.soggettoAttuatore != '') {
      // caso particolare: faccio finta di essere un altro operatore
      let sa = this.soggettoAttuatoreList.find(s => s.idSoggettoAttuatore == +filtri.soggettoAttuatore!)!;
      filtroServizio.gruppoOperatore = {eq: sa.gruppoOperatore}
      filtroServizio.codOperatore = {eq: sa.codOperatore}
      filtroServizio.isProprietario = {eq: true}
    }
    if (filtri.soggettoAttuatoreSede) {
      filtroServizio.progressivoSede = { eq: +filtri.soggettoAttuatoreSede }
    }

    return filtroServizio;
  }

  estraiDatiExcelV2() {
    let descrizionePso = this.homeService.selectedTipologiaPSO.descrizione!;
    let descrizioneSportello = this.homeService.selectedSportello.dataFine?new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString() +"-"+ new Date(this.homeService.selectedSportello.dataFine).toLocaleDateString() +" "+ this.homeService.selectedSportello.descrizioneSportello!:new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString()+"-"+" "+this.homeService.selectedSportello.descrizioneSportello!;
    this.servizioService.getServiziExcelV2(this.filtriRicerca, descrizionePso, descrizioneSportello).subscribe({
      next: (response: HttpResponse<Blob>) => {
        this.exportSvc.downloadResponse(response, 'application/octet-stream', 'elenco_servizi.xlsx');
      },
      error: error => {
        alert('Errore durante il download del file!');
        console.error('Errore durante il download del file:', error);
      }
    });
  }
}

export interface SimpleServizio{
  id?: ServizioConLabel,
  titolo?:string,
  finalita?: string,

  destinatario?: string,


  soggettoAttuatore?: string,
  progressivoSede?:number,
  soggettoBeneficiario?: string,
  istanzaCandidatura?: string,

  descrStatoServizio?: string,
  icons: InfoColumnActionSettingModel[];
}

export interface ServizioConLabel{
  simple?:string,
  icon?:InfoColumnActionSettingModel
}
