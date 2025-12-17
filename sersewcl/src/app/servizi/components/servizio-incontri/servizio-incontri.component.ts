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
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Incontro } from '@core/api-serse/model/incontro';
import { ServiziService } from '@servizi/services/servizi.service';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { IconsSettings } from '@shared/const/icons-settings';
import { DialogSettings, DialogButton } from '@shared/model/dialog-settings.model';
import { InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { tap } from 'rxjs';
import { IncontriService } from 'src/app/incontri/services/incontri.service';

@Component({
  selector: 'app-servizio-incontri',
  templateUrl: './servizio-incontri.component.html',
  styleUrls: ['./servizio-incontri.component.scss']
})
export class ServizioIncontriComponent implements OnInit, OnChanges {

  @Input() isModificabile!:boolean;
  @Input() disabled = false;

  incontri:IncontroSimple[]=[]
  icons!:InfoColumnActionSettingModel[];
  idStatoServizio:number=this.serviziService.servizio.statoServizio?.idStatoServizio!

  constructor(
    private incontriService:IncontriService,
    private serviziService:ServiziService,
    private dialog:MatDialog,
    private router:Router
  ) { }

  ngOnInit(): void {
    // il problema di questo tab è che non so se arrivo dal servizio o dall'incontro
    // se arrivo dall'incontro NON interviene il tab-click-interceptor
    this.serviziService.reloadStatoServizio()
    this.fetchIncontri()
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes["isModificabile"] || changes["disabled"]) {
      this.incontri.forEach(i => i.icons = this.createIcons(i.incontro))
    }
  }

  fetchIncontri(){
    this.incontriService.getIncontri(this.serviziService.servizio.idServizio!).subscribe({
      next:(response)=>{
       this.incontri = response.map(incontro=>{
        return{
          incontro:incontro,
          icons:this.createIcons(incontro)
        }
       })
      }
    })
  }

  createIcons(incontro:Incontro){
    let icons: InfoColumnActionSettingModel[] = [];

    if (this.isModificabile && incontro.statoIncontro?.idStatoIncontro!=40 && !this.disabled) {
      icons.push(this.getEditIcon());
      icons.push(this.getDeleteIcon());
     }
     else {
      icons.push(this.getViewIcon());
     }
     return icons;
  }
  getEditIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.PEN_ICON,
      'btn btn--plain-text--primary',
      'modifica',
      (incontro) => this.handleEdit(incontro.incontro),
      "modifica incontro"
    );
  }
  getDeleteIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.TRS_ICON,
      'btn btn--plain-text--danger',
      'Elimina',
      (incontro) => this.handleDelete(incontro.incontro.idIncontro),
      "elimina incontro"
    );
  }
  getViewIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.EYE_ICON,
      'btn btn--plain-text--primary',
      'visualizza',
      (incontro) => this.handleWiew(incontro.incontro),
      "visualizza incontro"
    );
  }

  handleDelete(idIncontro:string){
    if (!this.isModificabile) {
      // questo non dovrebbe succedere
      console.error("isModificabile = false")
      return ;
    }
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Eliminazione incontro',
        ['Attenzione: eliminando l’Incontro tutti i dati ad esso correlati verranno eliminati. Si desidera proseguire?'],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
            this.onConfermaEliminazione(idIncontro)
          },"conferma eliminazione incontro"),
        ]
      ),
    });
  }

  onConfermaEliminazione(idIncontro:string){
    this.incontriService.deleteIncontro(idIncontro)
    .pipe(
      tap({
        error: (error)=>{
            this.openModaleErrore(["Attenzione!"," eliminazione incontro non riuscita.Si prega di riprovare ed eventualmente contattare il servizio di assistenza"])
        }
      })
    ).subscribe({
      next:()=>{
        this.incontri.splice(this.incontri.findIndex(incontro=>incontro.incontro.idIncontro==Number(idIncontro)),1)
        this.incontri=[...this.incontri]
      }
    })
  }

  openModaleErrore(msg: string[]){

    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        "Errore",
        msg,
        "card-body--danger"
      )
    });
  }

  aggiungiIncontro(){
    if(this.serviziService.servizio.servizioRegionale?.codFinalitaServizio=="I" ){
      this.serviziService.getDestinatariAssociati(this.serviziService.servizio.idServizio?.toString()!).subscribe({
      next:ris=>{
        if(ris.length==0){
          this.openModaleErrore(["Attenzione","per inserire un Incontro di un Servizio di tipo Individuale occorre prima specificare il Destinatario del Servizio"])
          return;
        }
        this.incontriService.isIndividuale = (this.serviziService.servizio.servizioRegionale?.descrFinalitaServizio == 'I')
        this.openIncontro( this.createNewIncontro(), false, true);
      }
    })
    } else{
      this.incontriService.isIndividuale = (this.serviziService.servizio.servizioRegionale?.descrFinalitaServizio == 'I')
      this.openIncontro( this.createNewIncontro(), false, true);
    }
  }

  createNewIncontro():Incontro{
    return {
      idServizio:this.serviziService.servizio.idServizio,
      statoIncontro:{
        idStatoIncontro: 10,
        descrStatoIncontro: 'In Definizione'
      }
    }
  }

  handleWiew(incontro:Incontro){
    this.openIncontro( incontro, true, false);
  }

  handleEdit(incontro:Incontro){
    this.openIncontro( incontro, true, this.isModificabile);
  }

  openIncontro(incontro:Incontro, isSaved:boolean, isModificabile:boolean){
    this.incontriService.incontro       = incontro;
    this.incontriService.isSaved        = isSaved;
    this.incontriService.isModificabile = isModificabile;
    this.incontriService.selectedTab    = 0;
    this.router.navigate([`/dashboard/servizio/incontri/${isSaved?"form":"nuovo"}`])
  }
}
export interface IncontroSimple{
  incontro:Incontro,
  icons: InfoColumnActionSettingModel[]
}
