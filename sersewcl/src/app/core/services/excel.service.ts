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
import { FileSettingModel } from '@shared/model/button-export-excel-setting.model';
import { Workbook } from 'exceljs';
import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';
import { DateUtils } from '../utils/date.utils';
import { ConfigService } from './config.service';
import { ExportExcelServizi } from '@servizi/model/export-excel-servizi.model';
import { ManagedHttpClient } from './managed-http-client.service';
import { ExcelServizio } from '@core/api-serse/model/excelServizio';
import { Observable, tap } from 'rxjs';
import { HomeBagService } from '@home/services/home-bag.service';
import { HttpParams } from '@angular/common/http';
import { ServizioWrapper } from '@core/api-serse/model/servizioWrapper';
import { FiltriServizi } from '@servizi/model/filtri-servizi';
import { ExcelIntervento } from '@core/api-serse/model/excelIntervento';
import { ExcelModello } from '@core/api-serse/model/excelModello';


const EXCEL_TYPE = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';
const EXCEL_EXTENSION = '.xlsx';

@Injectable({
  providedIn: 'root'
})
export class ExcelService {
  constructor(
    private config:ConfigService,
    private http:ManagedHttpClient,
    private homeBag: HomeBagService
  ) { }

  public getExcelServizi(exportData:ExcelServizio[]){

    this.http.post<any>(this.config.excelServiziUrl,exportData,undefined,'blob').subscribe(
      {

       next: ris=>{


         const data: Blob = new Blob([ris], { type: EXCEL_TYPE });
         FileSaver.saveAs(data, "elenco_servizi" + EXCEL_EXTENSION);

       },
       error: error=>{
        console.error(error)
       }
      }
     );
  }
  public getExcelInterventi(exportData:ExcelIntervento[]){

    this.http.post<any>(this.config.excelInterventiUrl,exportData,undefined,'blob').subscribe(
      {

       next: ris=>{

         const data: Blob = new Blob([ris], { type: EXCEL_TYPE });
         FileSaver.saveAs(data, "elenco_interventi" + EXCEL_EXTENSION);

       },

       error: error=>{
        console.error(error)
       }
      }
     );
  }

  public getExcelModelli(exportData:ExcelModello[]){

    this.http.post<any>(this.config.excelModelliUrl,exportData,undefined,'blob').subscribe(
      {

       next: ris=>{

         const data: Blob = new Blob([ris], { type: EXCEL_TYPE });
         FileSaver.saveAs(data, "elenco_modelli_di_intervento" + EXCEL_EXTENSION);

       },

       error: error=>{
        console.error(error)
       }
      }
     );
  }

  public exportAsExcelFileFull(data: any[], fileSetting?: FileSettingModel) {
    let errors = new Map();


    // Excel Title, Header, Data

    const filename = fileSetting && fileSetting.filename? fileSetting.filename : ('Export_' + DateUtils.ISODateStandard(new Date()));
    let header: string[] |undefined= fileSetting && fileSetting.headers? fileSetting.headers: undefined;


    // Create workbook and worksheet
    const workbook = new Workbook();
    const worksheet = workbook.addWorksheet('Foglio');

    // Add Header Row
    const headerRow = worksheet.addRow(header);

    // Cell Style : Fill and Border
    headerRow.eachCell((cell, number) => {
      cell.fill = {
        type: 'pattern',
        pattern: 'solid',
        fgColor: { argb: 'FFFFFF00' },
        bgColor: { argb: 'FF0000FF' }
      };
      cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } };

    });

    // Add Data and Conditional Formatting
    let index = 0;
    for (let x1 of data)
    {
      index++;
      let x2=Object.keys(x1);

      let temp=[]
      for(let y of x2)
      {
        if(!(typeof x1[y] === 'object') || !x1[y]) {
          temp.push(x1[y]);
        } else {
          temp.push('');
          //TODO MESSAGGIO
          const v = new Map([[y, x1[y]]]);
          errors.set(index, v);

        }

      }
      let row=worksheet.addRow(temp)

      row.eachCell(cell=>{

          cell.alignment={
            wrapText: true ,
            shrinkToFit:true,
            //horizontal: "justify",
            vertical:"top"
          }
      })
      //
      row.height= 45
    }

    header!.forEach((v, i) => {
      if(worksheet.getColumn(i+1)) {
        worksheet.getColumn(i+1).width = header![i].length<25? 25: v.length + 2 ;
      }

    });
    workbook.xlsx.writeBuffer().then((data) => {
      this.saveAsExcelFile(data, filename);
    });

    return errors;
  }

  public exportAsExcelFileSimple(json:any, excelFilename: string): void {
    const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(json);
    const workbook: XLSX.WorkBook = { Sheets: { 'foglio': worksheet }, SheetNames: ['foglio'] };
    const excelBuffer: any = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
    this.saveAsExcelFile(excelBuffer, excelFilename);
  }

  private saveAsExcelFile(buffer: any, filename: string): void {
    const data: Blob = new Blob([buffer], { type: EXCEL_TYPE });
    FileSaver.saveAs(data, filename + EXCEL_EXTENSION);
  }

}
