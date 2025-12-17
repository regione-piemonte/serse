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
import { Observable } from 'rxjs';

//-Models
import { Caratteristica } from '@core/api-serse/model/caratteristica';
import { CaratteristicheAssociate } from '@core/api-serse/model/caratteristicheAssociate';
import { CaratteristicheServizio } from '@core/api-serse/model/caratteristicheServizio';

//-Services
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';


@Injectable({
  providedIn: 'root'
})
export class CaratteristicheService {


  constructor(
    private http:ManagedHttpClient,
    private config: ConfigService
  ) { }

  getCaratteristicheForPso(idPso: string): Observable<Caratteristica[]>{
    let queryParams = new HttpParams().
                      append("idPso",idPso);
   return  this.http.get<Caratteristica[]>(this.config.caratteristichePsoUrl,{params:queryParams})
  }

  getCaratteristicheForModello(idPso: string ,idModelloIntervento: string):Observable<Caratteristica[]>{
    let queryParams = new HttpParams().
        append("idPso",idPso).
        append("idModelloIntervento", idModelloIntervento);

    return this.http.get<Caratteristica[]>(
      this.config.caratteristicheAssociateUrl,
      {params:queryParams});
  }

  insertCaratteristiche(caratteristiche:CaratteristicheAssociate[]):Observable<any>{
    return this.http.post<any>(this.config.caratteristicheAssociateUrl,caratteristiche);
  }

  deleteCaratteristiche(caratteristiche:CaratteristicheAssociate[]):Observable<any>{
    return this.http.delete<any>(this.config.caratteristicheAssociateUrl,caratteristiche);
  }





  //servizio
  getCaratteristicheServizio(idPso: string,idServizio:string,isModificabile: boolean):Observable<Caratteristica[]>{
    let queryParams =new HttpParams()
                        .append("idPso",idPso)
                        .append("idServizio",idServizio)
                        .append("isModificabile",isModificabile);
    return this.http.get<Caratteristica[]>(this.config.caratteristicheServizioUrl,{params:queryParams});
  }

  getCaratteristicheAssociateServizio(idServizio:number):Observable<Caratteristica[]>{
    let queryParams =new HttpParams().append("idServizio",idServizio)
    return this.http.get<Caratteristica[]>(this.config.caratteristicheServizioAssociateUrl,{params:queryParams});
  }

  getCaratteristicheIntervento(idIntervento:number):Observable<Caratteristica[]>{
    let queryParams =new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<Caratteristica[]>(this.config.caratteristicheAssociateInterventoUrl,{params:queryParams});
  }
  insertCaratteristicheServizio(caratteristicheDaInserire:CaratteristicheServizio[]):Observable<any>{
    return this.http.post<any>(this.config.caratteristicheServizioUrl,caratteristicheDaInserire)
  }
  deleteCaratteristicheServizio(caratteristicheDaCancellare: CaratteristicheServizio[]):Observable<any>{
    return this.http.delete<any>(this.config.caratteristicheServizioUrl,caratteristicheDaCancellare)
  }
}
