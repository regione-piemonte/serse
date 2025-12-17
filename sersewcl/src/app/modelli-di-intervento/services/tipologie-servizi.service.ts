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

import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { ServiziModule } from 'src/app/servizi/servizi.module';
import { HttpParams } from '@angular/common/http';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { ServizioModello } from '@core/api-serse/model/servizioModello';

@Injectable({
  providedIn: 'root'
})
export class TipologieServiziService {

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService
  ) { }


  getTipologieServiziAssociati(idModelloIntervento:string):Observable<ServizioModello[]>{
    let queryParams = new HttpParams().
                      append("idModelloIntervento",idModelloIntervento);

    return this.http.get<ServizioModello[]>(
      this.config.tipologieServiziUrl,
      {params: queryParams}
    );
  }
  //##############################################################
  //#  SERVIZI MODELLO REGIONALI

  getServiziRegionaliForPso(idPso: string,idModelloIntervento?:string ):Observable<ServizioRegionale[]>{

    let queryParams = new HttpParams().
                      append("idPso", idPso);
    if(idModelloIntervento){
      queryParams.append("idModelloIntervento",idModelloIntervento)
    }
    return this.http.get<ServizioRegionale[]>(
      this.config.serviziRegionaliUrl,
      {params: queryParams}
    )
  }
  deleteServiziModelloRegionale(body:ServizioModello[], codUserAggiornamento: string,idModelloIntervento:string ):Observable<void>{
    let queryParams = new HttpParams().append("codUserAggiornamento",codUserAggiornamento).
                              append("idModelloIntervento",idModelloIntervento)
    return this.http.delete(this.config.serviziModelloRegionaliUrl,body,queryParams);
  }
  updateServiziModelloRegionale(body:ServizioModello[], codUserAggiornamento: string,idModelloIntervento:string ):Observable<void>{
    let queryParams = new HttpParams().append("codUserAggiornamento",codUserAggiornamento).
                              append("idModelloIntervento",idModelloIntervento)
    return this.http.put(this.config.serviziModelloRegionaliUrl,body,queryParams);
  }
  insertServiziModelloRegionale(body:ServizioModello[], codUserAggiornamento: string,idModelloIntervento:string ):Observable<void>{
    let queryParams = new HttpParams().append("codUserAggiornamento",codUserAggiornamento).
                              append("idModelloIntervento",idModelloIntervento)
    return this.http.post(this.config.serviziModelloRegionaliUrl,body,queryParams);
  }

  //##############################################################
  //#  SERVIZI MODELLO ESTERNI
  getServiziEsternoForIdModelloIntervento(idModelloIntervento:string): Observable<ServizioModello[]>{
    let queryParams = new HttpParams().append("idModelloIntervento",idModelloIntervento)
    return this.http.get<ServizioModello[]>(
      this.config.serviziModelloEsternoUrl,
      {params: queryParams})
  }

  getServizioEsternoById(idModelloIntervento:string, idServizioModello: string):Observable<ServizioModello>{
    let queryParams = new HttpParams().append("idModelloIntervento",idModelloIntervento)
                                      .append("idServizioModello",idServizioModello)

    return this.http.get<ServizioModello>(
      this.config.servizioModelloEsternoUrl,
      {params: queryParams})
  }

  insertServizioModelloEsterno(body:ServizioModello, codUserAggiornamento: string,idModelloIntervento:string ):Observable<void>{
    let queryParams = new HttpParams().append("codUserAggiornamento",codUserAggiornamento).
                              append("idModelloIntervento",idModelloIntervento)
    return this.http.post(this.config.servizioModelloEsternoUrl,body,queryParams);
  }
  updateServizioModelloEsterno(body:ServizioModello, codUserAggiornamento: string,idModelloIntervento:string ):Observable<void>{
    let queryParams = new HttpParams().append("codUserAggiornamento",codUserAggiornamento).
                              append("idModelloIntervento",idModelloIntervento)
    return this.http.put(this.config.servizioModelloEsternoUrl,body,queryParams);
  }

  deleteServizioModelloEsterno(idServizioModello:string, codUserAggiornamento: string,idModelloIntervento:string ):Observable<void>{
    let queryParams = new HttpParams()
                        .append("idServizioModello",idServizioModello)
                        .append("codUserAggiornamento",codUserAggiornamento)
                        .append("idModelloIntervento",idModelloIntervento)
    return this.http.delete(this.config.servizioModelloEsternoUrl,
                                null,
                                queryParams);
  }
}
