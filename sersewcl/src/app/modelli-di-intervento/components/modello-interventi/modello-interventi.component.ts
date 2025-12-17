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
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Intervento } from '@core/api-serse/model/intervento';
import { ModelloIntervento } from '@core/api-serse/model/modelloIntervento';
import { HomeBagService } from '@home/services/home-bag.service';
import { InterventiService } from '@interventi/services/interventi.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { IconsSettings } from '@shared/const/icons-settings';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';

@Component({
  selector: 'app-modello-interventi',
  templateUrl: './modello-interventi.component.html',
  styleUrls: ['./modello-interventi.component.scss']
})
export class ModelloInterventiComponent implements OnInit {

  @Input() modello!: ModelloIntervento;
  interventiList: Intervento[] = [];

  @Input() stato?: number;

  penIcon = IconsSettings.PEN_ICON;
  eyeIcon = IconsSettings.EYE_ICON;
  trashIcon = IconsSettings.TRS_ICON;

  codOperatore!: number;
  gruppoOperatore: string = "";
  isModificabile: boolean = true;

  constructor(
    private dialog: MatDialog,
    private modelliService: ModelliService,
    private interventiService: InterventiService,
    private router: Router,
    private homeBag: HomeBagService) { }

  ngOnInit(): void {

    if (this.homeBag.selectedRuolo.codiceRuolo !== 'FUNZIONARIO_MASTER_SERSE') {
      this.codOperatore = +this.homeBag.codiceOperatore;
      this.gruppoOperatore = this.homeBag.gruppoOperatore;
    } else {
      this.isModificabile = false;
    }
    this.fetchInterventi();
  }

  fetchInterventi() {
    this.interventiService.getInterventiModello(this.modello.idModelloIntervento!)
      .subscribe({
        next: (interventi) => {
          this.interventiList = interventi;
        },
        error: (error) => {
          console.error(error);
        }
      })
  }

  apriInterventoPerModifica(intervento: Intervento) {
    this.interventiService.setIsModificabile(true);
    this.commonNaviga(intervento);
  }

  apriInterventoPerVisualizzare(intervento: Intervento) {
    this.interventiService.setIsModificabile(false);
    this.commonNaviga(intervento);
  }

  commonNaviga(intervento: Intervento) {
    this.interventiService.setIntervento(intervento);
    this.interventiService.setIsSaved(true);
    this.interventiService.isProprietario = (intervento.soggettoAttuatore?.codOperatore === this.codOperatore) &&
      (intervento.soggettoAttuatore?.gruppoOperatore === this.gruppoOperatore);
    this.modelliService.tab = 2;
    this.router.navigateByUrl("/dashboard/intervento/form");
  }

  onEliminaIntervento(intervento: Intervento) {
      this.dialog.open(DialogConfermaComponent, {
        data: new DialogSettings(
          "",
          ["Attenzione: eliminando l'Intervento tutti i dati ad esso correlati verranno eliminati.",
          "Si desidera proseguire?"],
          "card-body--warning", "",
          [new DialogButton("Annulla", "btn btn--outline-primary", undefined, "annulla"),
            new DialogButton("Conferma", "btn btn--danger", ()=>{this.onConfermaEliminazione(intervento.idIntervento!)},"conferma eliminazione servizio")]
        )
      })
  }

  onConfermaEliminazione(idIntervento: number) {
    this.interventiService.deleteInterventoById(idIntervento.toString())
      .subscribe({
        next: () => {
          this.interventiList = this.interventiList.filter(i => i.idIntervento !== idIntervento);
        }
      });
  }
}
