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

import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IncontriSomma } from '@core/api-serse/model/incontriSomma';
import { Incontro } from '@core/api-serse/model/incontro';
import { ServizioGamIncontro } from '@core/api-serse/model/servizioGamIncontro';
import { ServizioGamRiapriServizio } from '@core/api-serse/model/servizioGamRiapriServizio';
import { TestChiudiIncontro } from '@core/api-serse/model/testChiudiIncontro';
import { TokenGam } from '@core/api-serse/model/tokenGam';
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IncontriService {
  private _isSaved = false;
  private _isModificabile = true;
  private _isIndividuale=false;
  private _incontro: Incontro={};
  private _selectedTab=0;

  private selectedIncontroSource = new BehaviorSubject<Incontro>(this._incontro)
  selectionChangeIncontro$= this.selectedIncontroSource.asObservable()

  constructor(
    private http:ManagedHttpClient,
    private homeBag:HomeBagService,
    private config: ConfigService
  ) { }

    changeSelectedIncontro(incontroSelected: Incontro){
      this.selectedIncontroSource.next(incontroSelected);
    }

  getIncontri(idServizio:number):Observable<Incontro[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio)
    return this.http.get<Incontro[]>(this.config.incontriUrl,{params:queryParams})
  }
  deleteIncontro(idIncontro:string){
    let queryParams = new HttpParams().append("idIncontro",idIncontro)
    return this.http.delete(this.config.incontroUrl,null,queryParams);
  }

  getIncontro(idIncontro:number):Observable<Incontro>{
    let queryParams = new HttpParams().append("idIncontro",idIncontro)
    return this.http.get<Incontro>(this.config.incontroUrl,{params:queryParams});
  }

  insertIncontro(incontro:Incontro):Observable<Incontro>{
    return this.http.post<Incontro>(this.config.incontroUrl,incontro)
  }

  updateIncontro(incontro:Incontro):Observable<Incontro>{
    return this.http.put<Incontro>(this.config.incontroUrl,incontro)
  }

  testChiudiIncontro(idIncontro:number,idSportello:number,idServizio: number):Observable<TestChiudiIncontro>{
    let queryParams = new HttpParams().append("idIncontro",idIncontro)
    queryParams = queryParams.append("idSportello",idSportello)
    queryParams = queryParams.append("idServizio",idServizio)
    return this.http.get<TestChiudiIncontro>(this.config.testChiusuraIncontro,{params:queryParams})
  }

  getTokenGamServizio(idServizio:number, codTipoRichiestaGam:string):Observable<TokenGam[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio)
                                      .append("codTipoRichiestaGam",codTipoRichiestaGam);
    return this.http.get<TokenGam[]>(this.config.tokenGamServizioUrl,{params:queryParams})
  }

  getTokenGamIncontro(idIncontro:number, codTipoRichiestaGam?:string):Observable<TokenGam[]>{
    let queryParams = new HttpParams().append("idIncontro",idIncontro)
    if(codTipoRichiestaGam){
      queryParams.append("codTipoRichiestaGam",codTipoRichiestaGam);
    }
    return this.http.get<TokenGam[]>(this.config.tokenGamIncontroUrl,{params:queryParams})
  }

  chiudiIncontro(servizioGamIncontro:ServizioGamIncontro):Observable<TokenGam>{
    return this.http.post<TokenGam>(this.config.chiudiIncontroGamUrl,servizioGamIncontro)
  }

  riapriIncontro(servizioGamIncontro:ServizioGamIncontro):Observable<TokenGam>{
    return this.http.post<TokenGam>(this.config.riapriIncontroGamUrl,servizioGamIncontro)
  }

  riportaServizioInDefinizione(servizioGamIncontro:ServizioGamRiapriServizio):Observable<void>{
    return this.http.post<void>(this.config.riportaServizioInDefGamUrl,servizioGamIncontro)
  }

  getSommaDurataIncontri(idServizio:number):Observable<IncontriSomma>{
    let queryParams = new HttpParams().append("idServizio",idServizio)
    return this.http.get<IncontriSomma>(this.config.totaleOreIncontro,{params:queryParams});
  }

  reload() {
    if (this._incontro?.idIncontro) {
      this.getIncontro(this._incontro!.idIncontro).subscribe({
        next: (incontro) => {
        this.incontro = incontro;
        this.isSaved = true;
        this.selectedIncontroSource.next(incontro);
        }
      });
    } else {
      console.error("Si sta cercando di ricaricare un incontro prima di averlo caricato");
    }
  }

  get isSaved(){
    return this._isSaved
  }
  get isModificabile(){
    return this._isModificabile && this.homeBag.selectedRuolo.codiceRuolo!=='FUNZIONARIO_MASTER_SERSE'
  }
  get incontro(){
    return this._incontro
  }

  get isIndividuale(){
    return this._isIndividuale
  }

  get selectedTab(){
    return this._selectedTab
  }
  set incontro(incontr:Incontro){
    this._incontro=incontr
  }

  set isIndividuale(isIndividuale:boolean){
    this._isIndividuale=isIndividuale
  }

  set isModificabile(isModificabile:boolean){
    this._isModificabile=isModificabile
  }
  set isSaved(isSaved:boolean){
    this._isSaved=isSaved;
  }

  set selectedTab(selection:number){
    this._selectedTab=selection
  }
}
