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
import { Cittadinanza } from '@core/api-serse/model/cittadinanza';
import { ComuneRistretto } from '@core/api-serse/model/comuneRistretto';
import { ProvinciaRistretto } from '@core/api-serse/model/provinciaRistretto';
import { StatoEstero } from '@core/api-serse/model/statoEstero';
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InfoComuniService {


  private provincie: ProvinciaRistretto[]=[];
  // comuni: ComuneRistretto[]=[];
  private statiEsteri: StatoEstero[]=[];
  private cittadinanze: Cittadinanza[]=[];


  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService)
  { }

  getProvince(codiceRegione?: string):Observable<ProvinciaRistretto[]>{
    let queryParams = new HttpParams()
    if(codiceRegione)
    queryParams = queryParams.append("regione", codiceRegione)

    return this.http.get<ProvinciaRistretto[]>(this.config.provinceUrl,{params:queryParams})
  }
  getProvincePiemonte():Observable<ProvinciaRistretto[]>{
    return this.getProvince('01');
  }

  getComuni(codiceProvincia: string):Observable<ComuneRistretto[]>{
    let queryParams = new HttpParams().
                          append("prov", codiceProvincia)

    return this.http.get<ComuneRistretto[]>(this.config.comuniUrl,{params:queryParams})
  }

  getStatiEsteri():Observable<StatoEstero[]>{
    return this.http.get<StatoEstero[]>(this.config.statiEsteriUrl)
  }
  getCittadinanze(){
    return this.http.get<Cittadinanza[]>(this.config.cittadinanzeUrl)
  }


  get provincieList(): ProvinciaRistretto[]{
    return this.provincie;
  }
  get statiEsteriList(): StatoEstero[]{
    return this.statiEsteri;
  }
  get cittadinanzeList(): Cittadinanza[]{
    return this.cittadinanze;
  }

  setProvincieList(provincieList:ProvinciaRistretto[]){
    this.provincie = provincieList;
  }
  setStatiEsteriList(statiEsteriList:StatoEstero[]){
    this.statiEsteri = statiEsteriList;
  }
  setCittadinanzeList(cittadinanzeList:Cittadinanza[]){
    this.cittadinanze = cittadinanzeList;
  }

}
