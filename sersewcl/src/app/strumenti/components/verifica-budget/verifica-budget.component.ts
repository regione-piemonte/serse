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

import { formatCurrency, getCurrencySymbol } from '@angular/common';
import { Component, Inject, LOCALE_ID, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { TitleService } from '@core/services/title.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { IconsSettings } from '@shared/const/icons-settings';
import { DialogSettings } from '@shared/model/dialog-settings.model';
import { ColumnSettingsModel, TableSettingsModel } from '@shared/model/table-setting.model';
import { StrumentiService } from '@strumenti/services/strumenti.service';

@Component({
  selector: 'app-verifica-budget',
  templateUrl: './verifica-budget.component.html',
  styleUrls: ['./verifica-budget.component.scss']
})
export class VerificaBudgetComponent implements OnInit {


  rowData: SimpleBadget[] = [];
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];

  constructor(
    private strumentiService: StrumentiService,
    private homeBag:HomeBagService,

    private title: TitleService,

    private dialog: MatDialog,
    @Inject(LOCALE_ID) private locale: string
  ) { }

  ngOnInit(): void {

    this.title.setIcon(IconsSettings.STRUMENTI_ICON);
    this.title.setTitle("Verifica budget");

    this.createTable();
    this.strumentiService.getBudget().pipe()
      .subscribe({
        next: risp => {
          if(risp == null || !risp.length) return;
          if(risp[0].codEsito == "WEBE00025"){
            this.dialog.open(DialogConfermaComponent,{
              data: new DialogSettings(
                "Errore",
                ["E' stata rilevata una anomalia - contattare l'assistenza"],
                "card-body--danger"
              )
            });
            return;
          }

          this.rowData = risp.map( r => {return {
            istanza: r.istanza,
            soggetto: r.soggettoAttuatore?.gruppoOperatore+""+r.soggettoAttuatore?.codOperatore+"-"+r.soggettoAttuatore?.denominazioneGiuridica,
            areaFin: r.areaTerritoriale?.codAreaTerritoriale+" - "+r.areaTerritoriale?.descrAreaTerritoriale,
            fascia: r.fascia,
            classif: r.classificazioneFinanziamento?.asse+"."+
                      r.classificazioneFinanziamento?.obiettivo+"."+
                      r.classificazioneFinanziamento?.attivita+"."+
                      r.classificazioneFinanziamento?.codAzione,
            fonte: r.idFonte?.toString(),
            stanziato: formatCurrency(r.stanziato!,this.locale,getCurrencySymbol('EUR', 'wide')),
            finanziato: formatCurrency(r.finanziato!,this.locale,getCurrencySymbol('EUR', 'wide')),
            residuo: formatCurrency(r.residuo!,this.locale,getCurrencySymbol('EUR', 'wide'))
          }});
        },
        error: risp => {
          this.dialog.open(DialogConfermaComponent,{
            data: new DialogSettings(
              "Errore",
              ["Si è verificato un errore durante il caricamento dei dati"],
              "card-body--danger"
            )
          });
        }
      });
  }
  createTable(){
    this.tableSettings.enableExport=false;
    this.tableSettings.enablePagination=false;

    this.createColumnsTable();
  }
  createColumnsTable(){
    /**Columns */
    const istanzaColumn = new ColumnSettingsModel(
      'istanza',
      'Istanza',
      false,
      'simple'
    );
    const soggettoColumn = new ColumnSettingsModel(
      'soggetto',
      'Soggetto',
      false,
      'simple'
    );
    const areaFinColumn = new ColumnSettingsModel(
      'areaFin',
      'Area finanz.',
      false,
      'simple'
    );
    const fasciaColumn = new ColumnSettingsModel(
      'fascia',
      'Fascia',
      false,
      'simple'
    );
    const classificazioneColumn = new ColumnSettingsModel(
      'classif',
      'Classificazione',
      false,
      'simple'
    );
    const fonteColumn = new ColumnSettingsModel(
      'fonte',
      'Fonte',
      false,
      'simple'
    );
    const stanziatoColumn = new ColumnSettingsModel(
      'stanziato',
      'Stanziato',
      true,
      'simple'
    );
    const finanziatoColumn = new ColumnSettingsModel(
      'finanziato',
      'Finanziato',
      true,
      'simple'
    );
    const residuoColumn = new ColumnSettingsModel(
      'residuo',
      'Residuo',
      true,
      'simple'
    );


    this.columnList.push(...[
      istanzaColumn,
      soggettoColumn,
      areaFinColumn,
      fasciaColumn,
      classificazioneColumn,
      fonteColumn,
      stanziatoColumn,
      finanziatoColumn,
      residuoColumn
    ]);

  }

}

interface SimpleBadget{
  istanza?: number,
  soggetto?: string,
  areaFin?: string,
  fascia?: number,
  classif?: string,
  fonte?: string,
  stanziato?: string,
  finanziato?: string,
  residuo?: string,
}
