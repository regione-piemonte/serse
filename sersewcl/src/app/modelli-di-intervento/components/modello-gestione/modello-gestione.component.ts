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

// CUSTOME ICON STRING
import { IconsSettings } from '@shared/const/icons-settings';

// Costume Services
import { TitleService } from '@core/services/title.service';

import { ModelliBagService } from '@modelli/services/modelli-bag.service';
import { ModelliService } from '@modelli/services/modelli.service';

// Custome table
import {
  TableSettingsModel,
  ColumnSettingsModel,
  InfoColumnActionSettingModel,
} from '@shared/model/table-setting.model';

// Components
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';

// Model
import { FiltriRicerca } from '@shared/model/filtri-ricerca.model';
import { SimpleModello } from '@modelli/model/simple-modello.model';
import { ModelloInterventoWrapper } from '@core/api-serse/model/modelloInterventoWrapper';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { FiltriModelli } from '@modelli/model/filtri-modelli.model';
import { tap } from 'rxjs';
import { HomeBagService } from '@home/services/home-bag.service';
import { ExcelService } from '@core/services/excel.service';
import { ExcelModello } from '@core/api-serse/model/excelModello';
import { ExportService } from '@shared/services/export.service';
import { HttpResponse } from '@angular/common/http';
import { FilterModelli } from '@modelli/model/filterModelli';
import { PageEvent } from '@angular/material/paginator';
import { CriteriRicercaBagService } from '@core/services/criteri-ricerca-bag.service';
import { Sort } from '@angular/material/sort';

@Component({
  selector: 'app-modello-gestione',
  templateUrl: './modello-gestione.component.html',
  styleUrls: ['./modello-gestione.component.scss'],
})
export class ModelloGestioneComponent implements OnInit {
  // @ViewChild('conferma') confermaaaaaaaa!: TemplateRef<any>;

  data: ModelloInterventoWrapper[] = [];
  exportData: ExcelModello[] = [];

  //--Gestione tabella
  visibleTable = false;
  rowData: SimpleModello[] = [];
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];

  filtriRicerca!: FilterModelli; // nel formato CSI
  sort?: string; // nel formato CSI

  constructor(
    private title: TitleService,
    private homeService: HomeBagService,
    private modelliBag: ModelliBagService,
    private modelliService: ModelliService,
    private homeBag: HomeBagService,
    private criteriRicercaBag: CriteriRicercaBagService,
    private excelService: ExcelService,
    private exportSvc: ExportService,
    private dialog: MatDialog,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.modelliService.setIsModificabile(true && this.homeBag.selectedRuolo.codiceRuolo!=='FUNZIONARIO_MASTER_SERSE');

    this.title.setTitle('Ricerca modelli di intervento');
    this.title.setIcon(IconsSettings.MODELLI_ICON);
    this.createTable();
  }

  //################ Criteri di ricerca ################//

  get tipoModelloList() {
    return this.modelliBag.tipoModelloList.map((tipo) => tipo.descrizione);
  }
  get statoModelloList() {
    return this.modelliBag.statoModelloList.map(
      (stato) => stato.descrStatoModelloDiIntervento
    );
  }
  get soggettoBeneficiarioList() {
    return this.modelliBag.soggettoBeneficiarioList
    // .map(
    //   (a) =>
    //     a.gruppoOperatore + a.codOperatore!.toString() + '-' + a.denominazione
    // );
  }
  get istanzaCandidaturaList() {
    return this.modelliBag.istanzaCandidaturaList
    // .map(
    //   (isatanza) => '' + isatanza.modelId?.toString()
    // );
  }
  get tipologiaServizioList() {
    return this.modelliBag.tipologiaServizioList.map(
      (a) => a.codiceServizioRegionale + '-' + a.descrServizioRegionale
    );
  }

  //####################-DATA-####################//
  showTable(filtri: FiltriRicerca) {
    this.filtriRicerca = this.createFilterModelli(filtri);
    this.getData(0);
  }

  getData(page: number) {
    if (page == 0) {
      this.visibleTable = false;
    }
    const limit = this.criteriRicercaBag.pageSize;
    const offset = page * limit;

    this.modelliService
      .getModelli(this.filtriRicerca, offset, limit, this.sort)
      .subscribe({
        next: (response) => {
          this.data = response.items!;
          this.tableSettings = {...this.tableSettings,
              length: response.count!,
              pageIndex: page,
              pageSize: this.criteriRicercaBag.pageSize};
          this.rowData = [
            ...this.data.map((a) => {
              return {
                id: a.modelloIntervento!.idModelloIntervento!,
                titolo: a.modelloIntervento!.titolo!,
                tipoModello: a.modelloIntervento!.tipoModello!.descrizione!,
                soggAttuatore:
                  a.modelloIntervento!.soggettoAttuatore!.gruppoOperatore! +
                  a.modelloIntervento!.soggettoAttuatore!.codOperatore +
                  ' - ' +
                  a.denominazioneSoggettoAttuatore,
                soggBeneficiario:
                  a.soggettoBeneficiario!.gruppoOperatore! +
                  a.soggettoBeneficiario!.codOperatore! +
                  ' - ' +
                  a.soggettoBeneficiario!.denominazione!,
                istanzaCandidatura: a.modelloIntervento!.soggettoAttuatore!.modelId!,
                stato:
                  a.modelloIntervento!.statoModelloIntervento!
                    .descrStatoModelloDiIntervento!,
                icons: this.createIconsModello(
                  a.isProprietario!,
                  a.isAssociatoAdIntervento!,
                  a.modelloIntervento!.statoModelloIntervento!
                    .descrStatoModelloDiIntervento!,
                  a.sportelloDfine!
                ),
                extendedContent: [
                  'Nessuna Tipologia di servizio è presente per il modello selezionato',
                ],
              };
            }),
          ];

          this.visibleTable = true;
        },
      });
  }

  openModaleErrore(msg: string[]) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings('Errore', msg, 'card-body--danger'),
    });
  }

  //############# Handle Icons #################
  createIconsModello(
    isProprietario: boolean,
    isAssociatoAdInterevnto: boolean,
    stato: string,
    fineSportello: Date
  ): InfoColumnActionSettingModel[] {
    // elimina  proprietà & associato a nessun intevento
    // modifica proprietà & sportello aperto & stato diverso da chiuso
    // occhio   stato chiuso &  non è di proprietà
    // duplica  sportello aperto

    let icons: InfoColumnActionSettingModel[] = [];

    icons.push(this.getExpandIcon());

    if ((new Date(fineSportello) > new Date() || !fineSportello) && this.modelliService.isModificabile) {
      icons.push(this.getDuppIcon());
    }
    if (!isProprietario || stato == 'Chiuso' || !this.modelliService.isModificabile) {
      icons.push(this.getViewIcon(isProprietario));
    }
    else {
      icons.push(this.getEditIcon());
    }
    if (isProprietario && !isAssociatoAdInterevnto && this.modelliService.isModificabile)
      icons.push(this.getDeleteIcon());
    return icons;
  }

  getEditIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.PEN_ICON,
      'icon',
      'modifica',
      (row) => {
        // recurpero l'id e rispendisco nella pagina di modifica

        this.openModello(row.id, true, true);
      },"modifica modello di intervento",
      false
    );
  }
  getDeleteIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.TRS_ICON,
      'icon',
      'Elimina',
      (row) => {
        // recuperare l'id aprire modale per conferma
        this.apriModaleConferma(row.id);
      },"elimina modello di intervento"
    );
  }
  getViewIcon(isProprietario: boolean) {
    return new InfoColumnActionSettingModel(
      IconsSettings.EYE_ICON,
      'icon',
      'visualizza',
      (row) => {
        // recupero l'id e reinderizzo nella pagina della visualizzazione

        this.openModello(row.id, false, true, isProprietario);
      },"visualizza modello di intervento"
    );
  }
  getDuppIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.DUP_ICON,
      'icon',
      'duplica',
      (row) => {
        this.apriModaleConfermaDuplicazione(row.id);
      },"duplica modello di intervento"
    );
  }

  apriModaleConfermaDuplicazione(id: string) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Duplicazione modello',
        [
          'Attenzione: procedendo con la duplicazione, il Modello sarà duplicato, assieme ai sui dati correlati. ',
          'Si desidera proseguire?',
        ],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
            this.onDuplicaModello(id);
          },"conferma duplicazione modello"),
        ]
      ),
    });
  }

  onDuplicaModello(id: string) {
    this.modelliService
      .duplicaModello(id, this.homeService.userInfo.codFisc!)
      .subscribe({
        next: (ris) => {
          this.modelliService.setModelloIntervento(ris);
          this.modelliService.setIsModificabile(true);
          this.modelliService.setIsSaved(true);
          this.modelliService.tab = 0;

        },
        complete: () => {
          this.dialog.open(DialogConfermaComponent,{
            data: new DialogSettings( "Duplica modello", ["Duplicazione avvenuta con successo"], "card-body--success")
          });
          this.router.navigate(['/dashboard/modello/form']);
        },
      });
  }

  getExpandIcon() {
    return new InfoColumnActionSettingModel('expand', 'icon', '', (row) => {
      this.modelliService.getTipologieServiziByIdModello(row.id).subscribe({
        next: (response) => {
          if (response.length != 0) {
            row.extendedContent = response.map((servizio) => {
              if (servizio.servizioRegionale?.idServizioRegionale) {
                return (
                  servizio.servizioRegionale?.codiceServizioRegionale! +
                  ' - ' +
                  servizio.servizioRegionale?.descrServizioRegionale! +
                  ' - ' +
                  servizio.servizioRegionale?.descrFinalitaServizio!
                );
              }
              return (
                servizio.titoloServizioEsterno! +
                ' - ' +
                servizio.descrizioneServizioEsterno! +
                ' - ' +
                servizio.descrFinalitaServizioEsterno!
              );
            });
          }
        },
      });
    });
  }

  openModello(id: string, isModificabile: boolean, isSaved: boolean, isProprietario?:boolean) {
    this.modelliService.getModelloById(id).subscribe({
      next: (response) => {
        this.modelliService.setModelloIntervento(response);
        this.modelliService.setIsModificabile(isModificabile);
        this.modelliService.setIsSaved(isSaved);
        this.modelliService.tab = 0;

        this.modelliService.isProprietario = isProprietario==undefined? true:isProprietario;

        this.router.navigate(['/dashboard/modello/form']);
      },
    });
  }

  apriModaleConferma(id: string) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Eliminazione modello',
        [
          'Se elimina il modello, non sarà più possibile usufruirne.',
          "L'eliminazione del modello non è reversibile",
          'Confermi la eliminazione',
        ],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
            this.onConfermaEliminazione(id);
          },"conferma eliminazione modello"),
        ]
      ),
    });
  }
  onConfermaEliminazione(id: string): void {
    this.modelliService
      .deleteModelloById(id)
      .pipe(
        tap({
          error: (error) => {
            this.openModaleErrore([
              'Attenzione!',
              ' eliminazione modello non riuscita.Si prega di riprovare ed eventualmente contattare il servizio di assistenza',
            ]);
          },
        })
      )
      .subscribe({
        next: () => {
          this.rowData.splice(
            this.rowData.findIndex((data) => data.id!.toString() == id),
            1
          );

          this.rowData = [...this.rowData];
        },
      });
    // this.table.refresh();
  }

  //################ Table ################//
  createTable() {
    this.tableSettings.title = 'Elenco Modelli di intervento';
    this.tableSettings.enableExpansion = true;
    this.tableSettings.enableButtons = true;

    this.createColumnsTable();
  }
  createColumnsTable() {
    /**Columns */

    const idModelloColumn = new ColumnSettingsModel(
      'id',
      'Identificativo',
      false,
      'simple'
    );
    const titoloColumn = new ColumnSettingsModel(
      'titolo',
      'Titolo',
      false,
      'simple'
    );
    const tipoModelloColumn = new ColumnSettingsModel(
      'tipoModello',
      'Tipo modello',
      false,
      'simple'
    );
    const soggAttuatoreColumn = new ColumnSettingsModel(
      'soggAttuatore',
      'Soggetto attuatore',
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
      'stato',
      'Stato',
      true,
      'simple'
    );

    const customActionColumn = new ColumnSettingsModel(
      'icone',
      '',
      true,
      'customAction'
    );

    this.columnList.push(
      ...[
        idModelloColumn,
        titoloColumn,
        tipoModelloColumn,
        soggAttuatoreColumn,
        soggBeneficiarioColumn,
        istanzaCandidaturaColumn,
        statoColumn,
        customActionColumn,
      ]
    );
  }


  estraiDatiExcel() {
    this.data.forEach((mod) => {
      this.exportData.push(this.createExportModel(mod));
    });
    this.excelService.getExcelModelli(this.exportData);
    this.exportData=[];
  }

  createExportModel(mod: ModelloInterventoWrapper): ExcelModello {
    return {
      tipolPso: this.homeService.selectedTipologiaPSO.descrizione!,
      sportello:this.homeService.selectedSportello.dataFine?new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString() +"-"+ new Date(this.homeService.selectedSportello.dataFine).toLocaleDateString() +" "+ this.homeService.selectedSportello.descrizioneSportello!:new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString()+"-"+" "+this.homeService.selectedSportello.descrizioneSportello!,
      soggettoBeneficiario:

        mod.soggettoBeneficiario?.gruppoOperatore! +
        mod.soggettoBeneficiario?.codOperatore! +
        ' - ' +
        mod.soggettoBeneficiario?.denominazione!,
      soggettoAttuatore:

        mod.modelloIntervento?.soggettoAttuatore?.gruppoOperatore! +
        mod.modelloIntervento?.soggettoAttuatore?.codOperatore +
        '-' +
        mod.modelloIntervento?.soggettoAttuatore?.denominazioneGiuridica,

      modelId: mod.modelloIntervento?.soggettoAttuatore?.modelId!.toString()!,
      idModello: mod.modelloIntervento?.idModelloIntervento!,
      titolo: mod.modelloIntervento?.titolo!,
      tipoModello: mod.modelloIntervento?.tipoModello?.descrizione!,
      finalitaModello: mod.modelloIntervento?.tipoModello
        ?.flgProgettazioneIndividuale
        ? 'Individuale'
        : 'Di gruppo',
      referente:
        mod.modelloIntervento?.referente!.referenteCognome +
        ' ' +
        mod.modelloIntervento?.referente!.referenteNome,
      statoModello:
        mod.modelloIntervento?.statoModelloIntervento
          ?.descrStatoModelloDiIntervento!,
      codUserInserimento:mod.modelloIntervento?.codUserInserimento!,
      codUserAggiornamento: mod.modelloIntervento?.codUserAggiornamento!
    };
  }

  createFilterModelli(filtri: FiltriRicerca): FilterModelli {
      let filterModelli: FilterModelli = {
        numProgrSportello: {eq: this.homeService.selectedSportello.numProgrSportello},
        gruppoOperatore: {eq: this.homeService.gruppoOperatore},
        codOperatore: {eq: +this.homeService.codiceOperatore},
        isProprietario: {eq: filtri.miei}
      }

      if (filtri.identificativo) {
        filterModelli.idModelloIntervento = { eq: +filtri.identificativo }
      }
      if (filtri.beneficiario) {
        filterModelli.gruppoOpBeneficiario = { eq: this.modelliBag.soggettoBeneficiarioList.find(s => s.codiceFiscale === filtri.beneficiario!)!.gruppoOperatore }
        filterModelli.codOpBeneficiario = { eq: +this.modelliBag.soggettoBeneficiarioList.find(s => s.codiceFiscale === filtri.beneficiario!)!.codOperatore! }
      }
      if (filtri.istanzaCandidatura) {
        filterModelli.modelId = { eq: +this.modelliBag.istanzaCandidaturaList.find(i => i.modelId!.toString() == filtri.istanzaCandidatura!)!.modelId?.toString()! }
      }
      if (filtri.tipo !== undefined && filtri.tipo !== '') {
        filterModelli.codiceTipoModello = {eq: this.modelliBag.tipoModelloList[+filtri.tipo].codTipoModello}
      }
      if (filtri.stato !== undefined && filtri.stato !== '') {
        filterModelli.idStatoModelloIntervento= { eq: this.modelliBag.statoModelloList[+filtri.stato].idStatoModelloDiIntervento }
      }
      if (filtri.tipologiaServizio !== undefined && filtri.tipologiaServizio !== '') {
        filterModelli.idServizioRegionale = { eq: +this.modelliBag.tipologiaServizioList[+filtri.tipologiaServizio].idServizioRegionale?.toString()! }
      }
      if (filtri.enteCoinvolto) {
        filterModelli.enteCoinvolto = { ci: filtri.enteCoinvolto }
      }

      return filterModelli;
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

  estraiDatiExcelV2() {
    let descrizionePso = this.homeService.selectedTipologiaPSO.descrizione!;
    let descrizioneSportello = this.homeService.selectedSportello.dataFine?new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString() +"-"+ new Date(this.homeService.selectedSportello.dataFine).toLocaleDateString() +" "+ this.homeService.selectedSportello.descrizioneSportello!:new Date(this.homeService.selectedSportello.dataInizio!).toLocaleDateString()+"-"+" "+this.homeService.selectedSportello.descrizioneSportello!;
    this.modelliService.getModelliExcelV2(this.filtriRicerca, descrizionePso, descrizioneSportello).subscribe({
      next: (response: HttpResponse<Blob>) => {
        this.exportSvc.downloadResponse(response, 'application/octet-stream', 'elenco_modelli_di_intervento.xlsx');
      },
      error: error => {
        alert('Errore durante il download del file!');
        console.error('Errore durante il download del file:', error);
      }
    });
  }
}
