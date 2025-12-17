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

import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { EnteCoinvoltoServizio } from '@core/api-serse/model/enteCoinvoltoServizio';
import { Incontro } from '@core/api-serse/model/incontro';
import { LuogoIncontro } from '@core/api-serse/model/luogoIncontro';
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { Observable, catchError, map, of } from 'rxjs';
import { LuoghiService } from '../../services/luoghi.service';
import { InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { IconsSettings } from '@shared/const/icons-settings';
import { DialogLuoghiIncontroComponent } from '@shared/components/dialog-luoghi-incontro/dialog-luoghi-incontro.component';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { IncontriService } from '@incontri/services/incontri.service';

@Component({
  selector: 'app-luogo-incontro',
  templateUrl: './luogo-incontro.component.html',
  styleUrls: ['./luogo-incontro.component.scss']
})
export class LuogoIncontroComponent implements OnInit, OnChanges {
  error: Error|null=null;
  @Input() incontro!:Incontro;
  @Input() isModificabile: boolean = true;

  icons: InfoColumnActionSettingModel[]=[];
  luogo?:LuogoIncontro;
  dialogLuogo!:MatDialogRef<any, any>;


  constructor(
    private dialog: MatDialog,
    private router:Router,
    private luoghiService:LuoghiService,
    private incontriService:IncontriService
  ) { }
  ngOnChanges(changes: SimpleChanges): void {
    if(changes["isModificabile"]){
      this.isModificabile=changes["isModificabile"].currentValue
      this.createIcons();
    }
  }

  ngOnInit(): void {

    if(this.incontro.luogoIncontro?.idLuogoIncontro)
    this.luoghiService.getLuogoIncontro(this.incontro.luogoIncontro?.idLuogoIncontro).subscribe({
      next:ris=>{
        this.luogo=ris
        this.luoghiService.luogoIncontro=ris;
        this.createIcons();
      }
    })

  }

  createIcons(){
    this.icons=[]
    if(this.incontro.statoIncontro?.idStatoIncontro==10 && this.isModificabile){
      this.icons.push(this.getEditIcon())
      this.icons.push(this.getDeleteIcon())
    }else{
      this.icons.push(this.getViewIcon())
    }
  }

  getEditIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.PEN_ICON,
      'btn btn--plain-text--primary',
      'modifica',
      (luogoIncontro) => this.handleEdit(luogoIncontro),
      "modifica luogo incontro"
    );
  }
  getDeleteIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.TRS_ICON,
      'btn btn--plain-text--danger',
      'Elimina',
      () => this.handleDelete(),
      "elimina luogo incontro"
    );
  }
  getViewIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.EYE_ICON,
      'btn btn--plain-text--primary',
      'visualizza',
      (luogoIncontro) => this.handleView(luogoIncontro),
      "visualizza luogo incontro"
    );
  }

  handleView(luogoIncontro:LuogoIncontro){
    this.handleLuogoSelezionato(luogoIncontro,false);
  }

  handleEdit(luogoIncontro:LuogoIncontro){
    this.handleLuogoSelezionato(luogoIncontro,true);
  }


  handleLuogoSelezionato(luogo:LuogoIncontro,isModificabile:boolean){
    this.dialogLuogo=this.dialog.open(DialogLuoghiIncontroComponent, {
      data: new DialogSettings(
        '',[],'','', [
          new DialogButton(
            "Usato solo per il metodo","",
            (luogoSave)=>{
              this.updateLuogo(luogoSave);
              this.dialogLuogo.close();
            },
            "aggiorna dati luogo")
        ],
        [
          luogo
          ,luogo.provenienzaLuogo?.descrProvenienzaLuogo ? luogo.provenienzaLuogo?.descrProvenienzaLuogo:luogo.provenienzaLuogo?.descrFonteDato
          ,luogo.provenienzaLuogo?.idProvenienzaLuogo
          ,isModificabile
        ]
      )
    });
  }

  updateLuogo(luogoIncontro:LuogoIncontro){
    this.luoghiService.updateLuogoIncontro(luogoIncontro).subscribe({
      next:ris=>{
        this.luogo=ris
      }
    })
  }

  handleDelete(){
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Eliminazione Luogo',
        ['Confermi la eliminazione'],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {

            this.onConfermaEliminazione();
          },"conferma eliminazione"),
        ]
      ),
    });
  }

  onConfermaEliminazione(){
    this.luoghiService.deleteLuogoIncontro(this.incontro.idIncontro!).subscribe({
      next:()=>{
        this.incontriService.incontro.luogoIncontro=undefined
        this.luoghiService.luogoIncontro={}
        this.luogo=undefined
      }
    })
  }
  onAggiungiLuogo(){
    this.router.navigate(['/dashboard/servizio/incontri/luogo'])
  }

  onchanges(changes:SimpleChanges){

  }
}
