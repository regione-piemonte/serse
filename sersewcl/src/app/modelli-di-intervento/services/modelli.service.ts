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

import { map, catchError } from 'rxjs/operators';
import { HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of, tap } from 'rxjs';

// Modelli
import { ModelloInterventoWrapper } from '@core/api-serse/model/modelloInterventoWrapper';
import { ModelloIntervento } from '@core/api-serse/model/modelloIntervento';
import { ServizioModello } from '@core/api-serse/model/servizioModello';

// Services
import { ConfigService } from '@core/services/config.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { TestModelloInterventoModifica } from '@core/api-serse/model/testModelloInterventoModifica';
import { InterventiAssociatiModello } from '@core/api-serse/model/interventiAssociatiModello';
import { FilterModelli } from '@modelli/model/filterModelli';
import { ModelloInterventoPageWrapper } from '@core/api-serse/model/modelloInterventoPageWrapper';

@Injectable({
  providedIn: 'root'
})
export class ModelliService {

  tab = 0;

  private _isSaved = false;
  private _isModificabile = true;
  isProprietario = false;
  private _modelloIntervento : ModelloIntervento = {};

  private selectedModelloSource = new BehaviorSubject<ModelloIntervento>(this._modelloIntervento)
  selectionChangeModello$ = this.selectedModelloSource.asObservable()

  // Pipe Handling
  error: Error | null = null;

  tapPipe = {
    error: (error:any)=>{
      this.error = error;
      console.log(`Errore mostrato nel banner errore`);}
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

  changeSelectedModello(modelloSelected: ModelloIntervento){
    this.selectedModelloSource.next(modelloSelected);
  }

  //##############-CHIAMATE HTTP-##############//
  /** Chiamate Http Modelli */

  getModelli(filtri: FilterModelli, offset?: number, limit?: number, sort?: string): Observable<ModelloInterventoPageWrapper>{

    let queryParams = new HttpParams()
                        .append("filter", JSON.stringify(filtri));
    if (offset !== undefined) {
      queryParams = queryParams.append("offset", offset.toString());
    }
    if (limit !== undefined) {
      queryParams = queryParams.append("limit", limit.toString());
    }
    if (sort !== undefined) {
      queryParams = queryParams.append("sort", sort);
    }

    return this.http.get<ModelloInterventoPageWrapper>(
                  this.config.modelliInterventoUrl,
                  {params:queryParams})
  }

  getModelloById(id:string): Observable<ModelloIntervento>
  {
    let queryParams = new HttpParams().append("idModelloIntervento",id);
    return this.http.get<ModelloIntervento>(
                  this.config.modelloSelezionatoUrl,
                  {params:queryParams})
              .pipe(
                map(data=>{
                    // Eventuale trasformazione di dati...
                    return data}),
                tap(this.tapPipe),
                catchError(this.catchPipeSingle));
  }

  addModello(modello: ModelloIntervento): Observable<ModelloIntervento>{
    return this.http.post<ModelloIntervento>(this.config.modelliInterventoUrl,modello)

  }

  updateModello(modello: ModelloIntervento): Observable<ModelloIntervento>{
    return this.http.put<ModelloIntervento>(this.config.modelliInterventoUrl,modello)

  }

  deleteModelloById(id:string){
    return this.http.delete(this.config.modelliInterventoUrl+"/"+id)

  }

  getNumInterventiAssociati(id:number):Observable<InterventiAssociatiModello>{
    let queryParams = new HttpParams()
    .append("idModelloIntervento",id)

    return this.http.get<InterventiAssociatiModello>(
      this.config.datiExcelUrl,
      {params:queryParams})
  }


  getTipologieServiziByIdModello(id:string): Observable<ServizioModello[]>{
    let queryParams = new HttpParams()
                      .append("idModelloIntervento",id)
    return this.http.get<ServizioModello[]>(
                  this.config.tipologiaServizioUrl,
                  {params:queryParams})
              .pipe(
                map(data=>{

                    return data}),
                tap(this.tapPipe),
                catchError(this.catchPipe));
  }


  getTestModificaModello(id:string): Observable<TestModelloInterventoModifica>{
    let queryParams = new HttpParams().append("idModelloIntervento",id);
    return this.http.get<TestModelloInterventoModifica>(
                  this.config.modelloTestModificaUrl,
                  {params:queryParams});
  }



  getModelloAssociato(idModello:string): Observable<ModelloInterventoWrapper[]>{

    const filter: FilterModelli = {
      numProgrSportello: {eq: this.homeBag.selectedSportello.numProgrSportello},
      gruppoOperatore: {eq: this.homeBag.gruppoOperatore},
      codOperatore: {eq: +this.homeBag.codiceOperatore},
      idModelloIntervento: {eq: +idModello}
    };
    return this.getModelli(filter).pipe(map(wrapper => wrapper.items!));
  }

  duplicaModello(idModello:string,codUserAggiornamento:string):Observable<ModelloIntervento>{
    let queryParams = new HttpParams().append("idModelloDiIntervento",idModello)
                                      .append("codUserAggiornamento",codUserAggiornamento)
    return this.http.post<ModelloIntervento>(this.config.duplicaModelloInterventoUrl,null,queryParams)
  }


  getModelliExcelV2(filtri: FilterModelli, descrizionePso: string, descrizioneSportello: string): Observable<HttpResponse<Blob>> {
    let queryParams = new HttpParams()
      .append("filter", JSON.stringify(filtri))
      .append("descrizionePso", descrizionePso)
      .append("descrizioneSportello", descrizioneSportello);

    return this.http.getFile(this.config.excelModelliUrlV2, { params: queryParams });
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

  get modelloIntervento(){
    return this._modelloIntervento;
  }
  setModelloIntervento(modelloIntervento:ModelloIntervento){
    this._modelloIntervento = modelloIntervento;
  }

  reset() {
    this.setIsModificabile(true)
    this.setIsSaved(false)
    this.setModelloIntervento({});
    this.isProprietario = true;
    this.tab = 0;
  }

  reload() {
    if (this._modelloIntervento?.idModelloIntervento) {
      this.getModelloById(this._modelloIntervento!.idModelloIntervento!.toString()).subscribe({
        next: (modello) => {
          this.setModelloIntervento(modello);
          this.setIsSaved(true);
          this.changeSelectedModello(modello);
        }
      });
    } else {
      console.error("Si sta cercando di ricaricare un modello di intervento prima di averlo caricato");
    }
  }
}
