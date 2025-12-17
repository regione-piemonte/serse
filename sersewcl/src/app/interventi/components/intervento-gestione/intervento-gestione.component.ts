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

// CUSTOM ICONS
import { IconsSettings } from '@shared/const/icons-settings';

// CUSTOM SERVICES
import { TitleService } from '@core/services/title.service';

// CUSTOM TABLE
import {
  ColumnSettingsModel,
  InfoColumnActionSettingModel,
  TableSettingsModel,
} from '@shared/model/table-setting.model';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { InterventiBagService } from '../../services/interventi-bag.service';
import { FiltriRicerca } from '@shared/model/filtri-ricerca.model';
import { FiltriInterventi } from '../../model/filtri-interventi';
import { InterventiService } from '../../services/interventi.service';
import { tap } from 'rxjs';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import {
  DialogButton,
  DialogSettings,
} from '@shared/model/dialog-settings.model';
import { InterventoWrapper } from '@core/api-serse/model/interventoWrapper';
import { SimpleIntervento } from '../../model/simple-intervento';
import { HomeBagService } from '@home/services/home-bag.service';
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { ExcelService } from '@core/services/excel.service';
import { Intervento } from '@core/api-serse/model/intervento';
import { ExcelIntervento } from '@core/api-serse/model/excelIntervento';
import { FilterInterventi } from '@interventi/model/filterInterventi';
import { HttpResponse } from '@angular/common/http';
import { ExportService } from '@shared/services/export.service';
import { PageEvent } from '@angular/material/paginator';
import { CriteriRicercaBagService } from '@core/services/criteri-ricerca-bag.service';
import { Sort } from '@angular/material/sort';

@Component({
  selector: 'app-intervento-gestione',
  templateUrl: './intervento-gestione.component.html',
  styleUrls: ['./intervento-gestione.component.scss'],
})
export class InterventoGestioneComponent implements OnInit {
  panelOpenState = true;
  visibleTable = false;

  //Gestione tabella
  rowData: SimpleIntervento[] = [];
  // Informazione paginazione tabella
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];
  data: InterventoWrapper[] = [];
  exportData: ExcelIntervento[] = [];

  filtriRicerca!: FilterInterventi; // nel formato CSI
  sort?: string; // nel formato CSI

  constructor(
    private title: TitleService,
    private interventiBag: InterventiBagService,
    private interventiService: InterventiService,
    private homeService: HomeBagService,
    private dialog: MatDialog,
    private entiService: EntiCoinvoltiService,
    private excelService: ExcelService,
    private criteriRicercaBag: CriteriRicercaBagService,
    private router: Router,
    private exportSvc: ExportService
  ) {}

  ngOnInit(): void {
    this.title.setTitle('Gestione interventi');
    this.title.setIcon(IconsSettings.INTERVENTI_ICON);
    this.interventiService.setIsModificabile(
      true &&
        this.homeService.selectedRuolo.codiceRuolo !==
          'FUNZIONARIO_MASTER_SERSE'
    );
    this.createTable();
  }

  //################ Criteri di ricerca ################//
  showTable(filtri: FiltriRicerca) {
    this.filtriRicerca = this.createFilterInterventi(filtri);
    this.getData(0);
  }

  getData(page: number) {
    if (page == 0) {
      this.visibleTable = false;
    }
    const limit = this.criteriRicercaBag.pageSize;
    const offset = page * limit;

    this.interventiService.getInterventi(this.filtriRicerca, offset, limit, this.sort).subscribe({
      next: (response) => {
        this.data = response.items!;
        this.tableSettings = {...this.tableSettings,
            length: response.count!,
            pageIndex: page,
            pageSize: this.criteriRicercaBag.pageSize};

        this.rowData = [
          ...this.data.map((interventoWrap) => {
            return {
              id: {
                simple: interventoWrap.intervento?.idIntervento!.toString(),
                icon: this.getIsAssociatoIcon(
                  interventoWrap.intervento?.idModelloIntervento
                ),
              },

              titolo: interventoWrap.intervento?.titolo!,
              tipoIntervento:
                interventoWrap.intervento?.tipoIntervento!.descrizione,

              destinatario:
                interventoWrap.destinatario?.nomeDestinatario != null
                  ? interventoWrap.destinatario?.nomeDestinatario! +
                    ' ' +
                    interventoWrap.destinatario?.cognomeDestinatario!
                  : '',

              soggAttuatore:
                interventoWrap.intervento?.soggettoAttuatore?.gruppoOperatore! +
                String(
                  interventoWrap.intervento?.soggettoAttuatore?.codOperatore
                ) +
                ' - ' +
                interventoWrap.denominazioneSoggettoAttuatore!,

              soggBeneficiario:
                interventoWrap.soggettoBeneficiario?.gruppoOperatore! +
                String(interventoWrap.soggettoBeneficiario?.codOperatore) +
                ' - ' +
                interventoWrap.soggettoBeneficiario?.denominazione!,
              istanzaCandidatura:
                interventoWrap.intervento?.soggettoAttuatore?.modelId!.toString(),
              stato:
                interventoWrap.intervento?.statoIntervento
                  ?.descrStatoIntervento!,

              icons: this.createIconsIntervento(
                interventoWrap.isProprietario!,
                interventoWrap.isAssociatoServizio!,
                interventoWrap.intervento?.statoIntervento
                  ?.descrStatoIntervento!,
                interventoWrap.sportelloDfine!
              ),
              extendedContent: [
                "Nessuna Tipologia di servizio è presente per l'intervento selezionato",
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
  get tipoInterventoList() {
    return this.interventiBag.tipologieInterventoList.map(
      (tipo) => tipo.descrizione
    );
  }
  get statoModelloList() {
    return this.interventiBag.statiInterventoList.map(
      (stato) => stato.descrStatoIntervento
    );
  }
  get soggettoBeneficiarioList() {
    return this.interventiBag.soggettoBeneficiarioList
    // .map(
    //   (a) =>
    //     a.gruppoOperatore + a.codOperatore!.toString() + '-' + a.denominazione
    // );
  }
  get istanzaCandidaturaList() {
    return this.interventiBag.istanzaCandidaturaList
    // .map(
    //   (isatanza) => '' + isatanza.modelId?.toString()
    // );
  }
  get tipologiaServizioList() {
    return this.interventiBag.tipologiaServizioList.map(
      (a) => a.codiceServizioRegionale + '-' + a.descrServizioRegionale
    );
  }

  //################ Table ################//
  createTable() {
    this.tableSettings.title = 'Elenco Interventi';
    this.tableSettings.enableExpansion = true;
    this.tableSettings.enableButtons = true;
    this.createColumnsTable();
  }

  createColumnsTable() {
    /**Columns */
    const expandColumn = new ColumnSettingsModel('expand', '', true, '');
    const idInterventoColumn = new ColumnSettingsModel(
      'id',
      'identificativo intervento',
      false,
      'label'
    );

    const titoloColumn = new ColumnSettingsModel(
      'titolo',
      'Titolo',
      false,
      'simple'
    );

    const tipoInterventoColumn = new ColumnSettingsModel(
      'tipoIntervento',
      'Tipo intervento',
      false,
      'simple'
    );

    const destinatarioColumn = new ColumnSettingsModel(
      'destinatario',
      'Destinatario',
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
        idInterventoColumn,
        titoloColumn,
        tipoInterventoColumn,
        destinatarioColumn,
        soggAttuatoreColumn,
        soggBeneficiarioColumn,
        istanzaCandidaturaColumn,
        statoColumn,
        customActionColumn,
        //expandColumn
      ]
    );
  }

  //############# Handle Icons #################
  createIconsIntervento(
    isProprietario: boolean,
    isAssociatoAServizio: boolean,
    stato: string,
    fineSportello: Date
  ): InfoColumnActionSettingModel[] {
    // elimina  proprietà & associato a nessun intevento
    // modifica proprietà & sportello aperto & stato diverso da chiuso
    // occhio   stato chiuso &  non è di proprietà
    // duplica  sportello aperto

    let icons: InfoColumnActionSettingModel[] = [];

    icons.push(this.getExpandIcon());

    if (
      (new Date(fineSportello) > new Date() || !fineSportello) &&
      this.interventiService.isModificabile
    ) {
      icons.push(this.getDuppIcon());
    }
    if (
      !isProprietario ||
      stato == 'Chiuso' ||
      !this.interventiService.isModificabile
    ) {
      icons.push(this.getViewIcon(isProprietario));
    } else {
      icons.push(this.getEditIcon());
    }
    if (
      isProprietario &&
      !isAssociatoAServizio &&
      stato != 'Chiuso' &&
      this.interventiService.isModificabile
    ) {
      icons.push(this.getDeleteIcon());
    }
    return icons;
  }

  getEditIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.PEN_ICON,
      'icon',
      'modifica',
      (row) => {
        // recurpero l'id e rispendisco nella pagina di modifica

        this.openIntervento(row.id.simple, true, true);
      },
      'modifica intervento',
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
        this.apriModaleConferma(row.id.simple);
      },
      'elimina intervento'
    );
  }
  getViewIcon(isProprietario: boolean) {
    return new InfoColumnActionSettingModel(
      IconsSettings.EYE_ICON,
      'icon',
      'visualizza',
      (row) => {
        this.openIntervento(row.id.simple, false, true, isProprietario);
      },
      'visualizza intervento'
    );
  }
  getDuppIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.DUP_ICON,
      'icon',
      'duplica',
      (row) => {
        this.apriModaleConfermaDuplicazione(row.id.simple);
      },
      'duplica intervento'
    );
  }
  getExpandIcon() {
    return new InfoColumnActionSettingModel('expand', 'icon', '', (row) => {
      this.interventiService
        .getTipologieServiziByIdIntervento(row.id.simple)
        .subscribe({
          next: (response) => {
            if (response.length != 0) {
              row.extendedContent = response.map(
                (servizio) =>
                  servizio?.codiceServizioRegionale! +
                  '-' +
                  servizio?.descrServizioRegionale! +
                  '-' +
                  servizio?.descrFinalitaServizio!
              );
            }
          },
        });
    });
  }

  getIsAssociatoIcon(
    idModelloIntervento?: number
  ): InfoColumnActionSettingModel {
    if (idModelloIntervento) {
      return new InfoColumnActionSettingModel(
        IconsSettings.LINK_ICON,
        'icon ms-1',
        'intervento creato da modello numero: ' + idModelloIntervento,
        undefined,
        'intervento creato da modello numero: ' + idModelloIntervento
      );
    }
    return new InfoColumnActionSettingModel();
  }

  openIntervento(
    id: string,
    isModificabile: boolean,
    isSaved: boolean,
    isProprietario?: boolean
  ) {
    this.interventiService.getInterventoById(id).subscribe({
      next: (response) => {
        this.interventiService.setIntervento(response);
        this.interventiService.setIsModificabile(isModificabile);
        this.interventiService.setIsSaved(isSaved);
        this.interventiService.tab = 0;

        this.interventiService.isProprietario =
          isProprietario == undefined ? true : isProprietario;

        this.router.navigate(['/dashboard/intervento/form']);
      },
    });
  }

  apriModaleConferma(id: string) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Eliminazione intervento',
        [
          "L'eliminazione dell'intervento non è reversibile",
          'Confermi la chiusura',
        ],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton(
            'Annulla',
            'btn btn--outline-primary',
            undefined,
            'annulla'
          ),
          new DialogButton(
            'Conferma',
            'btn btn--danger',
            () => {
              this.onConfermaEliminazione(id);
            },
            'conferma eliminazione'
          ),
        ]
      ),
    });
  }

  onConfermaEliminazione(id: string): void {
    this.interventiService
      .deleteInterventoById(id)
      .pipe(
        tap({
          error: (error) => {
            this.openModaleErrore([
              'Attenzione!',
              ' eliminazione intervento non riuscita.Si prega di riprovare ed eventualmente contattare il servizio di assistenza',
            ]);
          },
        })
      )
      .subscribe({
        next: () => {
          this.rowData.splice(
            this.rowData.findIndex((data) => data.id!.simple == id),
            1
          );

          this.rowData = [...this.rowData];
        },
      });
  }

  apriModaleConfermaDuplicazione(id: number) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Duplicazione intervento',
        [
          "Attenzione: procedendo con la duplicazione, l'intervento sarà duplicato, assieme ai sui dati correlati. ",
          'Si desidera proseguire?',
        ],
        'card-body--info',
        'Attenzione!',
        [
          new DialogButton(
            'Annulla',
            'btn btn--outline-primary',
            undefined,
            'annulla'
          ),
          new DialogButton(
            'Duplicazione Completa',
            'btn btn--primary',
            () => {
              this.onConfermaDuplicazione(id);
            },
            'conferma duplicazione completa'
          ),
          new DialogButton(
            'Duplicazione Parziale',
            'btn btn--primary',
            () => {
              this.onConfermaDuplicazioneParziale(id);
            },
            'conferma duplicazione parziale'
          ),
        ]
      ),
    });
  }

  onConfermaDuplicazione(id: number) {
    this.interventiService
      .duplicaIntervento(id, this.homeService.userInfo.codFisc!)
      .subscribe({
        next: (response) => {
          this.interventiService.setIntervento(response);
          this.interventiService.setIsModificabile(true);
          this.interventiService.setIsSaved(true);
          this.interventiService.tab = 0;
        },
        complete: () => {
          this.dialog.open(DialogConfermaComponent, {
            data: new DialogSettings(
              'Duplica intervento',
              ['Duplicazione avvenuta con successo'],
              'card-body--success'
            ),
          });
          this.router.navigate(['/dashboard/intervento/form']);
        },
      });
  }

  onConfermaDuplicazioneParziale(id: number) {
    let interventoTmp: Intervento = {};
    this.interventiService.getInterventoById(id.toString()).subscribe({
      next: (ris) => {
        interventoTmp = ris;
        interventoTmp = {
          ...interventoTmp,
          idIntervento: undefined,
        };
        this.interventiService.addIntervento(interventoTmp).subscribe({
          next: (response) => {
            this.interventiService.setIntervento(response);
            this.interventiService.setIsModificabile(true);
            this.interventiService.setIsSaved(true);
            this.interventiService.tab = 0;

            this.entiService.getEntiCoinvoltiIntervento(ris.idIntervento?.toString()!).subscribe({
              next:(enti)=>{
                enti.forEach(ente => {
                  let tmpEnte={...ente.enteCoinvoltoIntervento};
                  tmpEnte.idIntervento=response.idIntervento;
                  tmpEnte.idEnteCoinvoltoIntervento=undefined;
                  this.entiService.insertEnteCoinvoltoIntervento(tmpEnte).subscribe();
                });
              },
              complete: () => {
              this.dialog.open(DialogConfermaComponent, {
                data: new DialogSettings(
                  'Duplica intervento',
                  ['Duplicazione avvenuta con successo'],
                  'card-body--success'
                ),
              });
              this.router.navigate(['/dashboard/intervento/form']);
          },

            })
          },


        });
      },
    });
  }

  estraiDatiExcel() {
    this.data.forEach((data) => {
      this.exportData.push(this.createExportModel(data));
    });
    this.excelService.getExcelInterventi(this.exportData);
    this.exportData=[];
  }


  createExportModel(int: InterventoWrapper): ExcelIntervento {
    return {
      tipolPso: this.homeService.selectedTipologiaPSO.descrizione!,
      sportello: this.homeService.selectedSportello.dataFine
        ? new Date(
            this.homeService.selectedSportello.dataInizio!
          ).toLocaleDateString() +
          '-' +
          new Date(
            this.homeService.selectedSportello.dataFine
          ).toLocaleDateString() +
          ' ' +
          this.homeService.selectedSportello.descrizioneSportello!
        : new Date(
            this.homeService.selectedSportello.dataInizio!
          ).toLocaleDateString() +
          '-' +
          ' ' +
          this.homeService.selectedSportello.descrizioneSportello!,
      soggettoBeneficiario:
        int.soggettoBeneficiario?.gruppoOperatore! +
        int.soggettoBeneficiario?.codOperatore! +
        ' - ' +
        int.soggettoBeneficiario?.denominazione!,
      soggettoAttuatore:
        int.intervento?.soggettoAttuatore?.gruppoOperatore! +
        int.intervento?.soggettoAttuatore?.codOperatore +
        '-' +
        int.denominazioneSoggettoAttuatore,
      modelId: int.intervento?.soggettoAttuatore?.modelId!.toString()!,
      idIntervento: int.intervento!.idIntervento!,
      titolo: int.intervento?.titolo!,
      tipoIntervento: int.intervento?.tipoIntervento?.descrizione!,
      finalitaIntervento: int.intervento?.tipoIntervento
        ?.flgProgettazioneIndividuale
        ? 'Individuale'
        : 'Di gruppo',
      idModelloAssociato: int.intervento?.idModelloIntervento!,
      referente: int.intervento?.referente
        ? int.intervento?.referente!.referenteCognome +
          ' ' +
          int.intervento?.referente!.referenteNome
        : '',
      statoIntervento: int.intervento?.statoIntervento?.descrStatoIntervento!,
      cognNomeDesctinatario: int.destinatario
        ? int.destinatario?.cognomeDestinatario +
          ' ' +
          int.destinatario?.nomeDestinatario
        : '',
      cFDestinatario: int.destinatario?.codiceFiscaleDestinatario!,
      codUserInserimento: int.intervento?.codUserInserimento!,
      codUserAggiornamento: int.intervento?.codUserAggiornamento!

    };
  }

  createFilterInterventi(filtri: FiltriRicerca): FilterInterventi {
        let filterInterventi: FilterInterventi = {
          numProgrSportello: {eq: this.homeService.selectedSportello.numProgrSportello},
          gruppoOperatore: {eq: this.homeService.gruppoOperatore},
          codOperatore: {eq: +this.homeService.codiceOperatore},
          isProprietario: {eq: filtri.miei}
        }

        if (filtri.identificativo) {
          filterInterventi.idIntervento = { eq: +filtri.identificativo }
        }
        if (filtri.beneficiario) {
          filterInterventi.gruppoOpBeneficiario = { eq: this.interventiBag.soggettoBeneficiarioList.find(s => s.codiceFiscale === filtri.beneficiario!)!.gruppoOperatore }
          filterInterventi.codOpBeneficiario = { eq: +this.interventiBag.soggettoBeneficiarioList.find(s => s.codiceFiscale === filtri.beneficiario!)!.codOperatore! }
        }
        if (filtri.istanzaCandidatura) {
          filterInterventi.modelId = { eq: +this.interventiBag.istanzaCandidaturaList.find(i => i.modelId!.toString() == filtri.istanzaCandidatura!)!.modelId?.toString()! }
        }
        if (filtri.tipo !== undefined && filtri.tipo !== '') {
          filterInterventi.codiceTipoIntervento = {eq: this.interventiBag.tipologieInterventoList[+filtri.tipo].codTipoIntervento}
        }
        if (filtri.stato !== undefined && filtri.stato !== '') {
          filterInterventi.idStatoIntervento = { eq: this.interventiBag.statiInterventoList[+filtri.stato].idStatoIntervento }
        }
        if (filtri.tipologiaServizio !== undefined && filtri.tipologiaServizio !== '') {
          filterInterventi.idServizio = { eq: +this.interventiBag.tipologiaServizioList[+filtri.tipologiaServizio].idServizioRegionale?.toString()! }
        }
        if (filtri.enteCoinvolto) {
          filterInterventi.denominazionEnteCoinvolto = { ci: filtri.enteCoinvolto }
        }
        if (filtri.destinatario) {
          filterInterventi.codiceFiscaleDestinatario = { eq: filtri.destinatario }
        }

        return filterInterventi;
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
      this.interventiService.getInterventiExcelV2(this.filtriRicerca, descrizionePso, descrizioneSportello).subscribe({
        next: (response: HttpResponse<Blob>) => {
          this.exportSvc.downloadResponse(response, 'application/octet-stream', 'elenco_interventi.xlsx');
        },
        error: error => {
          alert('Errore durante il download del file!');
          console.error('Errore durante il download del file:', error);
        }
      });
    }

}
