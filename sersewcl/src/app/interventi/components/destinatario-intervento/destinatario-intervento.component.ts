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

import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';

//-Models
import { Destinatario } from '@core/api-serse/model/destinatario';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';

//-Services
import { DestinatariService } from '@core/services/destinatari.service';
import { HomeBagService } from '@home/services/home-bag.service';

//-Costanti
import { IconsSettings } from '@shared/const/icons-settings';

//-Components
import { DialogDestinatarioComponent } from '@shared/components/dialog-destinatario/dialog-destinatario.component';

@Component({
  selector: 'app-destinatario-intervento',
  templateUrl: './destinatario-intervento.component.html',
  styleUrls: ['./destinatario-intervento.component.scss']
})
export class DestinatarioInterventoComponent implements OnInit {

  // @Input() idIntervento: Intervento = {};
  @Input() destinatario: Destinatario|null = null;
  @Input() isModificabile: boolean = false;
  @Input() stato: number = 0;
  @Input() backTo: string = "";

  penIcon = IconsSettings.PEN_ICON;
  eyeIcon = IconsSettings.EYE_ICON;
  swapIcon = IconsSettings.SWP_ICON;

  constructor(
    private destintariService: DestinatariService,

    private homeBagService: HomeBagService,

    private dialog: MatDialog,
    private route: Router,
  ){}

  ngOnInit(): void {}

  navigateToGeastioneDestinatari(){
    this.destintariService.flagInterventoService = 11;
    this.destintariService.destAlreadyAssoc = this.destinatario ?[this.destinatario!.codiceFiscaleDestinatario!]:[];
    this.destintariService.backTo = this.backTo;
    this.route.navigate(['/dashboard/intervento/destinatari'])
  }

  modaleDestinatari: any;

  apriModaleModificaDestinatario(){
   let destinatario:Destinatario = this.destinatario!;
   this.modaleDestinatari = this.dialog.open(DialogDestinatarioComponent, {
     data: new DialogSettings(
       "",[],"","",
       [new DialogButton(
          "Annulla",
          "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--primary",
          (destinatario)=>{this.onConfermaModificaDestinatario(destinatario)}
        ,"conferma modifiche al destinatario")],
       [destinatario]
     )
   })
  }
  apriModaleVisualizzaDestinatario(){
    let destinatario:Destinatario = this.destinatario!;
    this.dialog.open(DialogDestinatarioComponent, {
      data: new DialogSettings(
        "",[],"","",
        [],
        [destinatario, true]
      )
    })
  }

  onConfermaModificaDestinatario(destinatario:Destinatario){



    destinatario.gruppoOperatoreAggiornamento = this.homeBagService.gruppoOperatore
    destinatario.codOperatoreAggiornamento = +this.homeBagService.codiceOperatore
    destinatario.codUserAggiorn = this.homeBagService.userInfo.codFisc
    destinatario.dAggiorn = new Date()

    this.destintariService
        .aggiornaDestinatario(destinatario).
        pipe()
        .subscribe(
          resp=> {
            this.destinatario = resp
            this.modaleDestinatari.close()
        })

  }


}
