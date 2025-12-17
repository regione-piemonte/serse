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

import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Pristinable } from '@home/models/pristinable';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogSettings, DialogButton } from '@shared/model/dialog-settings.model';

@Injectable({
  providedIn: 'root'
})
export class PristineService {

  componentAttivo?: Pristinable;

  constructor(
    private dialog: MatDialog
  ) { }

  /**
   * Controlla se il form è pristine (cioè se non sono stati effettuati cambiamenti)
   * e in caso contrario apre un dialog di conferma
   * @param onPristine Callback da eseguire se il form è intonso
   * @param onConfirm Callback da eseguire se l'utente conferma di procedere, se viene omesso viene assunto onPristine
   * @param onCancel Callback da eseguire se l'utente annulla l'uscita (solitamente non serve)
   */
  checkPristine(onPristine: () => void, onConfirm?: () => void, onCancel?: () => void): void {
    if (this.pristine()) {
      onPristine();
      return;
    }

    this.openDialog(onConfirm ? onConfirm : onPristine, onCancel);
  }

  /**
   * Controlla se c'è un form attivo, e se è pristine (cioè se non sono stati effettuati cambiamenti)
   */
  private pristine(): boolean {
    if (this.componentAttivo) {
      return this.componentAttivo.isPristine();
    }
    return true;
  }

  /**
   * Apre un dialog di conferma per uscire dalla pagina senza salvare
   */
  private openDialog(onConfirm: () => void, onCancel?: () => void): void {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Dati non salvati',
        [
          'Attenzione! Si sta uscendo dalla pagina senza aver salvato i dati modificati.',
          'Si desidera uscire comunque dalla pagina senza aver salvato?',
        ],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Torna indietro', 'btn btn--outline-primary', onCancel, "torna indietro"),
          new DialogButton('Procedi', 'btn btn--danger', onConfirm, "procedi"),
        ]
      ),
    });
  }
}
