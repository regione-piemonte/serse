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

import { BehaviorSubject, Observable, catchError, map, of, tap } from 'rxjs';
import { HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

//-Services
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { HomeBagService } from '@home/services/home-bag.service';

//-Models
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { Intervento } from '@core/api-serse/model/intervento';
import { AssociareModelloIntervento } from '@core/api-serse/model/associareModelloIntervento';
import { TestInterventoModifica } from '@core/api-serse/model/testInterventoModifica';
import { ServiziAssociatiIntervento } from '@core/api-serse/model/serviziAssociatiIntervento';
import { FilterInterventi } from '@interventi/model/filterInterventi';
import { InterventoPageWrapper } from '@core/api-serse/model/interventoPageWrapper';


@Injectable({
  providedIn: 'root'
})

export class InterventiService {

  private _isSaved = false;
  private _isModificabile = true ;
  private _intervento : Intervento = {};
  isProprietario = false;

  private selectedInterventoSource = new BehaviorSubject<Intervento>(this._intervento)
  selectionChangeIntervento$ = this.selectedInterventoSource.asObservable()

  tab = 0;

  // Pipe Handling
  error: Error | null = null;

  tapPipe = {
    error: (error:any)=>{
      this.error = error;
      console.error(`Errore mostrato nel banner errore`);}
  }

  catchPipe = (err:any) => {
    return of([]);}

  catchPipeSingle = (err:any) => {
    return of({});}


  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService,
    private homeBag: HomeBagService
  ) {

  }

  changeSelectedIntervento(interventoSelected: Intervento){
    this.selectedInterventoSource.next(interventoSelected);
  }

  getInterventi(filtri: FilterInterventi, offset?: number, limit?: number, sort?: string): Observable<InterventoPageWrapper>{

    let queryParams = new HttpParams().append("filter", JSON.stringify(filtri));
    if (offset !== undefined) {
      queryParams = queryParams.append("offset", offset.toString());
    }
    if (limit !== undefined) {
      queryParams = queryParams.append("limit", limit.toString());
    }
    if (sort !== undefined) {
      queryParams = queryParams.append("sort", sort);
    }

    return this.http.get<InterventoPageWrapper>(this.config.interventiUrl,{params:queryParams})

  }

  addIntervento(intervento: Intervento): Observable<Intervento>{
    return this.http.post<Intervento>(this.config.interventiUrl,intervento);
  }

  updateIntervento(intervento: Intervento): Observable<Intervento>{
    return this.http.put<Intervento>(this.config.interventiUrl,intervento);
  }
  getInterventoById(idIntervento: string):Observable<Intervento>{
    let queryParams= new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<Intervento>(this.config.interventiByIdUrl, {params:queryParams})
  }

  deleteInterventoById(idIntervento: string){
    let queryParams= new HttpParams().append("idIntervento",idIntervento)

    return this.http.delete(this.config.interventiUrl,undefined,queryParams)
  }

  getTipologieServiziByIdIntervento(id:string): Observable<ServizioRegionale[]>{
    let queryParams = new HttpParams()
                      .append("idIntervento",id)
    return this.http.get<ServizioRegionale[]>(
                  this.config.tipologieServiziInterventoUrl,
                  {params:queryParams})
              .pipe(
                map(data=>{

                    return data}),
                tap(this.tapPipe),
                catchError(this.catchPipe));
  }


  associaModello(associazione:AssociareModelloIntervento){
    return this.http.put(this.config.associaModelloInterventoUrl,
                              associazione);
  }
  disassociaModello( idIntervento:string, idModelloIntervento:string){
    let queryParams = new HttpParams().append("idIntervento",idIntervento)
                                      .append("idModelloIntervento",idModelloIntervento)

    return this.http.delete(this.config.disassociaModelloInterventoUrl,undefined,queryParams);
  }

  getTestModificaIntervento(idIntervento:string,numProgrSportello:string): Observable<TestInterventoModifica>{
    let queryParams = new HttpParams().append("idIntervento",idIntervento)
                                        .append("numProgrSportello",numProgrSportello);
    return this.http.get<TestInterventoModifica>(this.config.interventiTestModificaUrl,{params:queryParams})
  }

  getTestChiusuraIntervento(idIntervento:string):Observable<boolean>{
    let queryParams = new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<boolean>(this.config.interventiTestChiusuraUrl,{params:queryParams})
  }

  getNumServiziAssociatiIntervento(idIntervento: number): Observable<ServiziAssociatiIntervento>{
    let queryParams = new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<ServiziAssociatiIntervento>(this.config.excelInterventiUrl,{params:queryParams})
  }

  duplicaIntervento(idIntervento:number, codUserAggiornamento:string):Observable<Intervento>{
    let queryParams = new HttpParams().append("idIntervento",idIntervento)
                                      .append("codUserAggiornamento",codUserAggiornamento);
    return this.http.post<Intervento>(this.config.duplicaInterventoURL,null,queryParams);
  }

  getInterventiModello(idModelloIntervento: number): Observable<Intervento[]> {
    let queryParams = new HttpParams().append("idModelloIntervento",idModelloIntervento.toString())
    let url = this.config.interventiModelloUrl.replace(":idModelloIntervento", idModelloIntervento.toString())
    return this.http.get<Intervento[]>(url, {params:queryParams})
  }

  getInterventiExcelV2(filtri: FilterInterventi, descrizionePso: string, descrizioneSportello: string): Observable<HttpResponse<Blob>> {
    let queryParams = new HttpParams()
      .append("filter", JSON.stringify(filtri))
      .append("descrizionePso", descrizionePso)
      .append("descrizioneSportello", descrizioneSportello);

    return this.http.getFile(this.config.excelInterventiUrlV2, { params: queryParams });
  }

  //####-Gestione Casi di visualizzazione-####//
  get isSaved(){
    return this._isSaved;
  }
  setIsSaved(isSaved:boolean){
    this._isSaved = isSaved;
  }

  get isModificabile(){
    return this._isModificabile && this.homeBag.selectedRuolo.codiceRuolo!=='FUNZIONARIO_MASTER_SERSE';
  }
  setIsModificabile(isModificabile:boolean){
    this._isModificabile = isModificabile;
  }

  get intervento(){
    return this._intervento;
  }
  setIntervento(intervento:Intervento){
    this._intervento = intervento;
  }
  reset(){
    this.setIsModificabile(true)
    this.setIsSaved(false)
    this.setIntervento({});
    this.isProprietario = true;
    this.tab = 0;
  }

  reload() {
    if (this.intervento?.idIntervento) {
      this.getInterventoById(this._intervento!.idIntervento!.toString()).subscribe({
        next: (intervento) => {
          this.setIntervento(intervento);
          this.setIsSaved(true);
          this.changeSelectedIntervento(intervento);
        }
      });
    } else {
      console.error("Si sta cercando di ricaricare un intervento prima di averlo caricato");
    }
  }
}
