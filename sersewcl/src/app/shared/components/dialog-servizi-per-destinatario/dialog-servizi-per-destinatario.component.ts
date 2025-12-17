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

import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { Servizio } from '@core/api-serse/model/servizio';
import { ServizioWrapper } from '@core/api-serse/model/servizioWrapper';
import { DestinatariService } from '@core/services/destinatari.service';
import { FiltriServizi } from '@servizi/model/filtri-servizi';
import { ServiziService } from '@servizi/services/servizi.service';
import { DialogSettings } from '@shared/model/dialog-settings.model';
import { TableSettingsModel, ColumnSettingsModel } from '@shared/model/table-setting.model';

@Component({
  selector: 'app-dialog-servizi-per-destinatario',
  templateUrl: './dialog-servizi-per-destinatario.component.html',
  styleUrls: ['./dialog-servizi-per-destinatario.component.scss'],
})
export class DialogServiziPerDestinatarioComponent implements OnInit {
  data:ServizioWrapper[]=[]
  filtro:FiltriServizi={
    miei: false,
    stato: '',
    gruppBeneficiario: '',
    codicBeneficiario: '',
    istanzaCandidatura: '',
    tipologiaServizio: '',
    finalitaServizio: '',
    enteCoinvolto: '',
    identificativo: '',
    destinatario: '',
    infoIncontri:0
  }
  destinatarioSelected: Destinatario = {};
  rowData:ServizioDest[]=[]
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];

  constructor(
    @Inject(MAT_DIALOG_DATA) public dialogSettings: DialogSettings,
    private destinatarioService:DestinatariService,
    private serviziService: ServiziService
    ) {}

  ngOnInit(): void {
    if (this.dialogSettings.data) {
      this.destinatarioSelected = this.dialogSettings.data[0];
      this.filtro.destinatario=this.destinatarioSelected.codiceFiscaleDestinatario!;
      this.serviziService.getServiziDestinatari(this.filtro,this.destinatarioSelected).subscribe({
        next: ris => {
          this.data = ris;
          this.rowData=[...this.data.map(servizioWrap=>{return {
            id:servizioWrap.servizio?.idServizio!.toString()!,
            titolo:servizioWrap.servizio?.titoloServizio!,
            codiceRegionale:servizioWrap.servizio?.servizioRegionale?.codiceServizioRegionale!,
            finalita:servizioWrap.servizio?.servizioRegionale?.descrFinalitaServizio!,
            soggettoAttuatore: servizioWrap.servizio?.soggettoAttuatore?.gruppoOperatore! + servizioWrap.servizio?.soggettoAttuatore!.codOperatore?.toString()
            +"-"+ servizioWrap.denominazioneSoggettoAttuatore,
            soggettoBeneficiario:servizioWrap.soggettoBeneficiario?.gruppoOperatore! + servizioWrap.soggettoBeneficiario?.codOperatore!
            +"-"+servizioWrap.soggettoBeneficiario?.denominazione,
            descrStatoServizio:servizioWrap.servizio?.statoServizio?.descrStatoServizio!,
          }})]
        }
      })
    }

    this.createTable()
  }

  createTable(){
    let nome=this.destinatarioSelected.nomeDestinatario!
    let cognome=this.destinatarioSelected.cognomeDestinatario!
    nome =this.destinatarioSelected.nomeDestinatario ?  nome.charAt(0).toUpperCase() + nome.slice(1).toLowerCase() : '';
    cognome =cognome ? cognome.charAt(0).toUpperCase() + cognome.slice(1).toLowerCase() : '';
    this.tableSettings.title="Servizi erogati a "+ nome + " " + cognome
    this.tableSettings.enableButtons=false
    this.tableSettings.enableExport=false
    this.createColumns()
  }

  createColumns(){
    const idColumn=new ColumnSettingsModel(
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
    const codiceRegionaleColumn = new ColumnSettingsModel(
      'codiceRegionale',
      'Codice Regionale',
      false,
      'simple'
    );

    const finalitaColumn = new ColumnSettingsModel(
      'finalita',
      'Finalità',
      false,
      'simple'
    );
    const soggAttuatoreColumn = new ColumnSettingsModel(
      'soggettoAttuatore',
      'Soggetto attuatore',
      false,
      'simple'
    );
    const soggBeneficiarioColumn = new ColumnSettingsModel(
      'soggettoBeneficiario',
      'Soggetto beneficiario',
      false,
      'simple'
    );
    const statoColumn = new ColumnSettingsModel(
      'descrStatoServizio',
      'Stato',
      true,
      'simple'
    );
    this.columnList.push(...[
      idColumn,
      titoloColumn,
      codiceRegionaleColumn,
      finalitaColumn,
      soggAttuatoreColumn,
      soggBeneficiarioColumn,
      statoColumn
    ])
  }
}

interface ServizioDest{
  id:string,
  titolo: string,
  finalita: string,
  codiceRegionale:string,
  soggettoAttuatore:string,
  soggettoBeneficiario: string,
  descrStatoServizio: string
}
