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
import { Bacino } from '@core/api-serse/model/bacino';
import { Comune } from '@core/api-serse/model/comune';
import { LuogoIncontro } from '@core/api-serse/model/luogoIncontro';
import { SedeOperatore } from '@core/api-serse/model/sedeOperatore';
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LuoghiService {
  private _luogoIncontro:LuogoIncontro={}

  constructor(
    private http:ManagedHttpClient,
    private config: ConfigService
  ) { }

    getLuogoIncontro(idLuogoIncontro:number):Observable<LuogoIncontro>{
      let queryParams= new HttpParams().append("idLuogoIncontro",idLuogoIncontro);
      return this.http.get<LuogoIncontro>(this.config.luogoIncontroUrl,{params:queryParams})
    }

    deleteLuogoIncontro(idIncontro:number):Observable<any>{
      let queryParams= new HttpParams().append("idIncontro",idIncontro);
      return this.http.delete(this.config.luogoIncontroUrl,null,queryParams);
    }

    insertLuogoIncontro(luogoIncontro:LuogoIncontro,idIncontro:number):Observable<LuogoIncontro>{
      let queryParams= new HttpParams().append("idIncontro",idIncontro);
      return this.http.post<LuogoIncontro>(this.config.luogoIncontroUrl,luogoIncontro,queryParams);
    }

    updateLuogoIncontro(luogoIncontro:LuogoIncontro):Observable<LuogoIncontro>{
      return this.http.put<LuogoIncontro>(this.config.luogoIncontroUrl,luogoIncontro);
    }

    getBaciniProvinca(codProvincia:string):Observable<Bacino[]>{
      let queryParams= new HttpParams().append("codProvincia",codProvincia);
      return this.http.get<Bacino[]>(this.config.baciniProvinciaUrl,{params:queryParams})
    }

    getcomuniBacino(codBacino:string):Observable<Comune[]>{
      let queryParams= new HttpParams().append("codBacino",codBacino);
      return this.http.get<Comune[]>(this.config.comuniBacinoUrl,{params:queryParams})
    }

    getElencoSediSoggAttuatore(idSoggettoAttuatore:number):Observable<SedeOperatore[]>{
      let queryParams = new HttpParams()
                      .append("idSoggettoAttuatore",idSoggettoAttuatore)
                      return this.http.get<SedeOperatore[]>(
                        this.config.sediSoggAttUrl,
                        {params:queryParams})
    }

    getElencoSediSoggAttuatoreCodGruppo(numProgrSportello?: number, codOperatore?: number, gruppoOperatore?: string, modelId?: number): Observable<SedeOperatore[]> {
      let queryParams = new HttpParams();
      if (numProgrSportello !== undefined) {
        queryParams = queryParams.append("numProgrSportello", numProgrSportello.toString());
      }
      if (codOperatore !== undefined) {
        queryParams = queryParams.append("codOperatore", codOperatore.toString());
      }
      if (gruppoOperatore !== undefined) {
        queryParams = queryParams.append("gruppoOperatore", gruppoOperatore);
      }
      if (modelId !== undefined) {
        queryParams = queryParams.append("modelId", modelId.toString());
      }
      return this.http.get<SedeOperatore[]>(this.config.sediSoggAttCodGruppoUrl, { params: queryParams });
    }
    


    get luogoIncontro(){
      return this._luogoIncontro;
    }

    set luogoIncontro(luogoIncontro:LuogoIncontro){
      this._luogoIncontro=luogoIncontro;
    }
  }
