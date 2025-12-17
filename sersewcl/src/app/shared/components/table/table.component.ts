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

import { Component, EventEmitter, Input, OnChanges, OnInit, Output, ViewChild, SimpleChanges } from '@angular/core';

// Angualr Animation
import { animate, state, style, transition, trigger } from '@angular/animations';

// Angular material
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort, Sort } from '@angular/material/sort';
import { SelectionModel } from '@angular/cdk/collections';

// Model Table
import { TableSettingsModel, ColumnSettingsModel, ButtonActionSettingModel } from '@shared/model/table-setting.model';
import { CriteriRicercaBagService } from '@core/services/criteri-ricerca-bag.service';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],

  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed',
        animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class TableComponent implements OnInit, OnChanges {

  /**@description Data which will be displayed in tabular format */
  @Input() rowData: object[] = [];                            //Rows
  @Input('tableSettings') tableSettings!: TableSettingsModel;  //TableSettings
  @Input('columnList') columns: ColumnSettingsModel[] = [];     //Columns

  @Input() keepPagination: boolean = false;                       //Keep pagination

  @Input('buttonList') buttons: ButtonActionSettingModel[] = [];  //Buttons table

  @Input('rottaChiamante') rottaChiamante?: string;              //??

  selection = new SelectionModel<{}>(true, []);

  @Output() changePage: EventEmitter<PageEvent> = new EventEmitter<PageEvent>()
  @Output() changeSort: EventEmitter<Sort> = new EventEmitter<Sort>()
  @Output() esportaExcel: EventEmitter<void> = new EventEmitter<void>()
  @ViewChild('sort') sort!: MatSort;

  //######- Gestione Caso di tabella con select -#####
  selectedRadio: any; // Per la gestione dei radio button
  maxLength: number = 30;

  constructor(
    private criteriRicercaBag: CriteriRicercaBagService) { }

  @ViewChild(MatTable) table!: MatTable<any>;


  /**@description ViewChild to get the MatPaginator directive from DOM */
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    if (this.criteriRicercaBag.rottaChiamante === this.rottaChiamante) {
      this.tableSettings.pageSize = this.criteriRicercaBag.pageSize
    } else if (!this.keepPagination) {
      this.criteriRicercaBag.pageSize = 5;
      this.criteriRicercaBag.rottaChiamante = "";
    }

    if (!this.tableSettings?.length) {
      // Il paginatore non deve essere settato in modalità server-side
      this.dataSource.paginator = this.paginator;
    }
    if (this.paginator && this.paginator.page) {
      this.paginator.page.subscribe(
        (event) => {
          this.criteriRicercaBag.pageSize = event.pageSize;
          this.changePage.emit(event);
        }
      )
    }

    this.dataSource.sort = this.sort;
    if (this.rottaChiamante == '/dashboard/intervento/gestione' || this.rottaChiamante == '/dashboard/servizio/gestione')
      this.dataSource.sortData = this.sortData();
  }

  /**@description Column names for the table*/
  columnNames: string[] = [];

  /**@description Local variable to convert JSON data object to MatTableDataSource*/
  @Input() dataSource!: MatTableDataSource<{}>;

  expandedElement: object | null | undefined;

  ngOnInit(): void {

    for (const column of this.columns) {
      this.columnNames.push(column.name);
    }

    //Per ora mi serve questo da tenere in conto che ci potreebbero essere
    // essere delle selezioni singole o multiple
    if (!this.dataSource) {
      this.dataSource = new MatTableDataSource(this.rowData);
    }
    this.dataSource.sort = this.sort;
  }


  allSelected = false;
  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;

    return numSelected === numRows;
  }

  toggleAllRows() {
    this.isAllSelected()
      ? this.selection.clear()
      : this.selection.select(...this.dataSource.data);
    this.allSelected = this.isAllSelected();
  }

  updateSelected() {
    this.allSelected = this.isAllSelected();
  }

  clearSelection() {
    this.selection.clear();
  }

  /**
   * Lifecycle hook that is called when any data-bound property of a datasource changes.
   */
  ngOnChanges(changes: SimpleChanges) {

    if (!this.dataSource) {
      // a volte succede che questo evento viene chiamato prima del ngOnInit
      return;
    }

    if (changes['rowData']) {
      this.selectedRadio = undefined;
      this.dataSource.data = this.rowData;

      if (!this.tableSettings?.length) {
        // Il paginatore non deve essere settato in modalità server-side
        this.dataSource.paginator = this.paginator;
      }
      if (this.criteriRicercaBag.rottaChiamante === this.rottaChiamante) {
        this.tableSettings.pageSize = this.criteriRicercaBag.pageSize
      } else if (!this.keepPagination) {
        this.criteriRicercaBag.pageSize = 5;
        this.criteriRicercaBag.rottaChiamante = "";
      }

      this.dataSource.sort = this.sort;
      this.dataSource.sortData = this.sortData();
    }
  }

  //-Sorting
  sortDataDirection($event: Sort) {
    console.log($event, this.sort.active, this.sort.direction)
    this.changeSort.emit($event);
  }

  resetOrdinamento() {
    this.sort.direction = 'desc';
    this.sort.active = this.columnNames[0]
    this.sort.sortChange.emit();
  }

  sortData() {
    return (items: any[], sort: MatSort): object[] => {
      if (!sort.active || sort.direction === '') {
        return items;
      }

      return items.sort((a: any, b: any) => {
        let comparatorResult = 0;
        if (sort.active == 'idIcona') {
          comparatorResult = (+a.idIcona.simple) > (+b.idIcona.simple) ? 1 : -1;
        }
        else {
          if (!isNaN(Number(a[String(sort.active)]))) {
            comparatorResult = (+a[String(sort.active)]) > (+b[String(sort.active)]) ? 1 : -1;
          }
          else {
            const lowercaseA = String(a[String(sort.active)]).toLowerCase();
            const lowercaseB = String(b[String(sort.active)]).toLowerCase();
            comparatorResult = lowercaseA.localeCompare(lowercaseB, undefined, { sensitivity: 'base' });
          }
        }

        return comparatorResult * (sort.direction == 'asc' ? 1 : -1);
      });
    };
  }

  export() {
    this.esportaExcel.emit()
  }

  //- usato sulle modali principalmente per avere i pulsanti separati
  clickButton(index: number) {
    this.buttons[index].actionClick(this.tableSettings.isRadio ? this.selectedRadio : this.selection.selected);
  }
}
