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

import { Component, OnInit, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

//-Models
import { Intervento } from '@core/api-serse/model/intervento';
import { Servizio } from '@core/api-serse/model/servizio';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';

//-Components
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';

//-const
import { IconsSettings } from '@shared/const/icons-settings';

//-Services
import { ServiziService } from 'src/app/servizi/services/servizi.service';
import { HomeBagService } from '@home/services/home-bag.service';

@Component({
  selector: 'app-intervento-servizi',
  templateUrl: './intervento-servizi.component.html',
  styleUrls: ['./intervento-servizi.component.scss']
})
export class InterventoServiziComponent implements OnInit {

  @Input() intervento!:Intervento;
  serviziList: Servizio[] = [];

  @Input() stato?: number;

  penIcon = IconsSettings.PEN_ICON;
  eyeIcon = IconsSettings.EYE_ICON;
  trashIcon = IconsSettings.TRS_ICON;

  codOperatore!: number;
  gruppoOperatore:string="";
  isModificabile:boolean =true;
  constructor(
    private dialog:MatDialog,
    private servizioService: ServiziService,
    private router: Router,
    private homeBag:HomeBagService
  ) {}

  ngOnInit(): void {

    if(this.homeBag.selectedRuolo.codiceRuolo!=='FUNZIONARIO_MASTER_SERSE'){
      this.codOperatore=Number(this.homeBag.codiceOperatore);
      this.gruppoOperatore=this.homeBag.gruppoOperatore;
    }else this.isModificabile=false;

    this.fetchServizi();
  }

  fetchServizi(){
    this.servizioService
        .getServiziIntervento(this.intervento.idIntervento!)
        .pipe()
        .subscribe(resp => this.serviziList = resp.sort( (a, b) => a.idServizio! > b.idServizio! ? 1:-1 ));
    // let s = this.servizi$.pipe()
    // .subscribe(resp => {this.serviziList = resp});

  }

  handlerServizoNavigation(modificabile:boolean, saved:boolean){
    this.servizioService.setIsModificabile(modificabile);
    this.servizioService.setIsSaved(saved);
    this.servizioService.setBackTo('/dashboard/intervento/form');
    this.servizioService.tab = 0;

    this.router.navigateByUrl(saved ?"/dashboard/servizio/fromIntervento/form"
                                :"/dashboard/servizio/fromIntervento/nuovo");
  }

  apriServizioPerModifica(servizio:Servizio){
    this.servizioService.setServizio(servizio);
    this.handlerServizoNavigation(true, true);
  }
  apriServizioPerVisualizzare(servizio:Servizio){
    this.servizioService.setServizio(servizio);
    this.handlerServizoNavigation(false, true);
  }
  aggiungiServizio(){
    if(this.stato != 20){
      this.dialog.open(DialogConfermaComponent,{
        data: new DialogSettings(
          'Attenzione',["Non è possibile aggiungere un Servizio perché l'Intervento non è Attivo."],
              "card-body--warning"
        )
      })
      return;
    }
    this.servizioService.reset();
    this.servizioService.setServizio({idIntervento:this.intervento.idIntervento});
    this.handlerServizoNavigation(true, false);
  }


  onEliminaServizio(servizio:Servizio){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
        "",
        ["Attenzione: eliminando il Servizio tutti i dati ad esso correlati verranno eliminati.",
        "Si desidera proseguire?"],
        "card-body--warning","",
        [new DialogButton("Annulla","btn btn--outline-primary",undefined,"annulla"),
          new DialogButton("Conferma","btn btn--danger",()=>{this.onConfermaEliminazione(servizio.idServizio!)},"conferma eliminazione servizio")]
      )
    })
  }
  onConfermaEliminazione(idServizio:number){
    this.servizioService.deleteServizioById(idServizio!)
    .pipe()
    .subscribe(
      risp => {

        this.serviziList = this.serviziList.filter(servizio => servizio.idServizio !== idServizio);
      }
    );
  }


  get isModificabileServizi(){
    return this.isModificabile && this.stato == 10;
  }

}
