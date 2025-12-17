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
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { DestinatariService } from '@core/services/destinatari.service';
import { TitleService } from '@core/services/title.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { ServiziService } from '@servizi/services/servizi.service';
import { DialogDestinatarioComponent } from '@shared/components/dialog-destinatario/dialog-destinatario.component';
import { DialogServiziPerDestinatarioComponent } from '@shared/components/dialog-servizi-per-destinatario/dialog-servizi-per-destinatario.component';
import { IconsSettings } from '@shared/const/icons-settings';
import { DialogSettings, DialogButton } from '@shared/model/dialog-settings.model';
import { SimpleDestinatario } from '@shared/model/simple-destinatario.model';
import { ColumnSettingsModel, InfoColumnActionSettingModel, TableSettingsModel } from '@shared/model/table-setting.model';
import { Validation } from '@shared/utils/validation';

@Component({
  selector: 'app-verifica-servizi-destinatari',
  templateUrl: './verifica-servizi-destinatari.component.html',
  styleUrls: ['./verifica-servizi-destinatari.component.scss']
})
export class VerificaServiziDestinatariComponent implements OnInit {

  errorNessunCampo: string="";
  destinatari: Destinatario[]=[];
  //-Table
  rowData: SimpleDestinatario[]=[];
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];
  visibileTable: boolean= false;
  constructor(

    private serviziService:ServiziService,
    private destinatariService:DestinatariService,
    private router:Router,
    private dialog: MatDialog,
    private homeBagService: HomeBagService,

    private title: TitleService,
    private fb:FormBuilder

    ) { }

  ngOnInit(): void {
    this.title.setIcon(IconsSettings.STRUMENTI_ICON);
    this.title.setTitle("Verifica servizi per destinatario");

    this.createTable()
  }
  createTable(){
    this.tableSettings.title = 'Elenco Destinatari';
    this.tableSettings.enableExport = false;
    this.tableSettings.enableButtons = false;
    this.createColumnsTable()
  }

  myFilter = (d: any): boolean => {
    let day: Date;
    if(d)
      day = new Date(d)
    else
      day = new Date()
    return day < new Date();
  };

  createIconsDestinatari(): InfoColumnActionSettingModel[]{
    let icons: InfoColumnActionSettingModel[] = [];
    icons.push(this.getServCorrIcon());
    icons.push(this.getViewIcon());
    return icons
  }

  getServCorrIcon(){
    return new InfoColumnActionSettingModel(
      IconsSettings.SERV_CORR_ICON,
      "icon",
      "Mostra Servizi Erogati",
      (row)=>{this.handleServiziCorrelatiDestinatario(this.getDestinatario(row.idDestinatario))},"visualizza elenco servizi correlati al destinatario")
  }

  getViewIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.EYE_ICON,
        "icon",
        "visualizza",
        (row) => {
          this.handleViewDestinatario(this.getDestinatario(row.idDestinatario))
        },"visualizza dati destinatario")
  }

  handleViewDestinatario(destinatario:Destinatario){
    this.dialog.open(DialogDestinatarioComponent, {
      data: new DialogSettings(
        "",[],"","",
        [],
        [destinatario,true]
      )
    })
  }

  handleServiziCorrelatiDestinatario(destinatario:Destinatario){

    this.dialog.open(DialogServiziPerDestinatarioComponent, {
      data: new DialogSettings(
        "",[],"","",
        [],
        [destinatario]
      )
    })
  }

  getDestinatario(idDestinatario:number):Destinatario{
    let dest:Destinatario=this.destinatari.find(dest=>dest.idDestinatario==idDestinatario)!
    return dest;
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

  form = this.fb.group({
    nome:['',[Validation.nomeValidator]],
    cognome:['',[Validation.cognomeValidator]],
    codFisc:['',[Validators.minLength(16)]],
    dataNascita:['',],
  })

  onCerca(){
    this.errorNessunCampo = "";
    if(this.form.invalid) return;
    if(this.allFieldBlank()){
      this.errorNessunCampo = "Attenzione: compilare almeno uno dei parametri di ricerca."
      return;
    }
    this.fetchDestinatari();
  }

  fetchDestinatari(){
    let dataFilter =  this.form.controls['dataNascita'].value ?new Date(this.form.controls['dataNascita'].value) :undefined;
    let dataString = dataFilter ?dataFilter.getFullYear()+"-"+(dataFilter.getMonth()+1)+"-"+dataFilter.getDate() :undefined;

    this.destinatariService.getDestinatari(
      String(this.form.controls['cognome'].value),
      String(this.form.controls['nome'].value),
      String(this.form.controls['codFisc'].value),
      dataString)
    .pipe()
    .subscribe(response=> {
     this.destinatari = response;
      this.rowData = response.map(
        r=> {return {
          idDestinatario:r.idDestinatario,
          codFisc: r.codiceFiscaleDestinatario!,
          cognome: r.cognomeDestinatario!,
          nome: r.nomeDestinatario!,
          dataNascita: new Date(r.dNascita!).toLocaleDateString()!,
          luogoNascita: r.statoEsteroNascita ?r.statoEsteroNascita.decrizioneStato
                                              :r.comuneNascita?.descrizioneComune +" "+r.comuneNascita?.provincia?.siglaProvincia,
          icons: this.createIconsDestinatari()
        }}
      );
      this.visibileTable = true;
    })
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


}
