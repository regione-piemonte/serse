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

import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { catchError, map, of } from 'rxjs';

//-Utils
import { GRUPPO_CODICE_MASK, IVA_MASK } from '@shared/utils/text-masks';
import { Validation } from '@shared/utils/validation';

//--Services
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';

//-Models
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { ButtonActionSettingModel, ColumnSettingsModel, TableSettingsModel } from '@shared/model/table-setting.model';
import { SimpleOperatore } from '@shared/model/simple-operatore.model';

//-Const
import { MessagesTips } from '@shared/const/messagges-tips';
import { TableComponent } from '../table/table.component';

@Component({
  selector: 'app-dialog-operatori',
  templateUrl: './dialog-operatori.component.html',
  styleUrls: ['./dialog-operatori.component.scss']
})
export class DialogOperatoriComponent implements OnInit {

  //-Errori
  erroreRicercaOperatore = '';

  //-Form
  formRicercaOperatore = this.fb.group({
    gruppoCodice:['',Validation.gruppoCodiceValidator],
    denominazione:['', Validators.minLength(4)  ],
    codiceFiscale:['', Validators.maxLength(16) ],
    partitaIva:['',    [Validators.minLength(11), Validators.maxLength(11)]],
  });

  //-Tooltips
  toolTipGrpCod = MessagesTips.toolTipGrpCod;
  toolTipDenomi = MessagesTips.toolTipDenomi;
  toolTipCodFsc = MessagesTips.toolTipCodFsc;
  toolTipPrtIva = MessagesTips.toolTipPrtIva;

  //-Masks
  grppCodMask = GRUPPO_CODICE_MASK;
  ivaMask = IVA_MASK;

  //-Table
  showTableRiceOperatore = false;
  createdTableROperatore = false;

  rowDataROperatore: SimpleOperatore[] = [];
  columnListROperatore: ColumnSettingsModel[] = [];
  buttonsTabellaROperatore: ButtonActionSettingModel[] = [];
  tableSettingsROperatore: TableSettingsModel = new TableSettingsModel();

  constructor(
    private entiService: EntiCoinvoltiService,
    private fb: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public actionBtn: DialogButton,
    @Inject(MAT_DIALOG_DATA) public dialogSettings: DialogSettings
  ) { }

  ngOnInit(): void {
    this.createTableROperatore();
  }
  onCercaOperatore() {
    this.erroreRicercaOperatore ='';
    let grppCod = this.formRicercaOperatore.controls['gruppoCodice'];
    let denomin = this.formRicercaOperatore.controls['denominazione'];
    let codFisc = this.formRicercaOperatore.controls['codiceFiscale'];
    let partIva = this.formRicercaOperatore.controls['partitaIva'];

    if (!grppCod.value && !denomin.value && !codFisc.value && !partIva.value) {
      this.erroreRicercaOperatore = 'Attenzione: per effettuare la ricerca valorizzare almeno uno dei filtri di ricerca';
      return;
    }

    let grpCodString = ['', ''];
    if(grppCod.value){
      grpCodString[0]= String(grppCod.value).charAt(0)
      grpCodString[1]= String(grppCod.value).substring(1)
    }

    if (grppCod.valid && denomin.valid && codFisc.valid && partIva.valid) {
      this.fetchOperatori( grpCodString[0].toUpperCase(), grpCodString[1],
                          denomin?.value!, codFisc?.value!,
                          partIva?.value!);
    }
  }

  fetchOperatori(gruppoOperatore?: string, codOperatore?: string,
                  denominazione?: string, codiceFiscale?: string,
                  partitaIva?: string ) {
    this.entiService.getOperatori( gruppoOperatore, codOperatore, denominazione,
                      codiceFiscale, partitaIva)
        .pipe(
          map((risposta) => {
            if (!Array.isArray(risposta)) {
              return risposta;
            }
            if (risposta.length < 100)
              return risposta.map((r) => {
                return {
                  idSede: r.sede?.idSede,
                  grppCodice: r.gruppoOperatore + r.codOperatore!.toString(),
                  denominazione: r.denominazione,
                };
              })
              this.erroreRicercaOperatore='';
            return risposta;
          })
        )
        .subscribe((risposta) => {
          if (!Array.isArray(risposta)) {
            this.erroreRicercaOperatore =
              'Attenzione: troppi risultati ottenuti. Si prega di raffinare la ricerca valorizzando altri filtri e riprovare:';
            this.showTableRiceOperatore=false;
            return;
          }
          if (risposta.length == 0) {
            this.erroreRicercaOperatore =
              'Nessuna occorrenza trovata a fronte dei parametri di ricerca indicati';

            this.showTableRiceOperatore=false;
            return;
          }

          /**effective */
          this.rowDataROperatore = risposta;
          this.showTableRiceOperatore = true;
        });
  }

  // Gestione tabella modale ricerca operatore
  createTableROperatore() {
    this.tableSettingsROperatore.title = 'Elenco Operatori';
    this.tableSettingsROperatore.enableExport = false;
    this.tableSettingsROperatore.enableButtons = true;

    this.createColumnsTableROperatore();
    this.createButtonsTableROperatore();
  }
  createColumnsTableROperatore() {
    const radioColumn = new ColumnSettingsModel('radio', '', false, 'radio');
    const grpCodColumn = new ColumnSettingsModel(
      'grppCodice',
      'Gruppo e codice',
      false,
      'simple'
    );
    const denominazioneColumn = new ColumnSettingsModel(
      'denominazione',
      'Denominazione',
      false,
      'simple'
    );
    this.columnListROperatore.push(
      ...[radioColumn, grpCodColumn, denominazioneColumn]
    );
  }
  createButtonsTableROperatore() {
    let buttonConferma = new ButtonActionSettingModel(
      'CONFERMA OPERATORE SELEZIONATO',
      (data) => this.onConfermaOperatore(data),
      'd-none'
    );
    this.buttonsTabellaROperatore.push(...[buttonConferma]);
  }

  onConfermaOperatore(operatore: SimpleOperatore | undefined) {
    this.erroreRicercaOperatore = '';
    if (!operatore) {
      this.erroreRicercaOperatore = 'Selezionare un operatore per poter procedere';
      return;
    }

    this.dialogSettings!.buttons![0].action!(operatore);
  }

  onAggiungiNuovoEnte(){
    this.dialogSettings!.buttons![1].action!();
  }

  @ViewChild("table") table!:TableComponent;
  onConfermaModale(){
    this.table.clickButton(0);
  }

}



