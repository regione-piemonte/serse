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

import { IncontroDestinatarioServizio } from './../../core/api-serse/model/incontroDestinatarioServizio';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { Partecipanti } from '@core/api-serse/model/partecipanti';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PartecipantiService {

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService
  ) { }



  getPartecipantiForIncontro(idIncontro: string):Observable<Partecipanti[]>{
    let queryParams = new HttpParams().append("idIncontro",idIncontro)
    return this.http.get<Partecipanti[]>(this.config.incontroDestinatarioServizioUrl,
      {params:queryParams})

  }

  getAllPartecipantiForServizio(idServizio: string):Observable<Partecipanti[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio)
    return this.http.get<Partecipanti[]>(this.config.incontroDestAssServizioUrl,
      {params:queryParams})
  }

  assocciaDestinatariIncontro(partecipanti:IncontroDestinatarioServizio[]){
    return this.http.post<any>(this.config.assocIncontroDestinatarioURL,partecipanti);
  }

  disassocciaDestinatariIncontro(idIncontro:string, idDestinatarioServizio:string){
    let queryParams = new HttpParams().append("idIncontro",idIncontro)
                                      .append("idDestinatarioServizio",idDestinatarioServizio);

    return this.http.delete<any>(this.config.incontroDestinatarioServizioUrl,undefined,queryParams);
  }

  updateDestinatarioIncontro(partecipante:IncontroDestinatarioServizio){
    return this.http.put<any>(this.config.incontroDestinatarioServizioUrl,partecipante);
  }


}
