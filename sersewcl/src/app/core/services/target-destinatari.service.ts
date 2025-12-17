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

import { TargetDestinatario } from '@core/api-serse/model/targetDestinatario';
import { Observable } from 'rxjs';

import { TargetDestinatariAssociati } from '@core/api-serse/model/targetDestinatariAssociati';
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';

@Injectable({
  providedIn: 'root'
})
export class TargetDestinatariService {

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService
  ) { }

  getTargetDestinatariForPso(idPso: string):
          Observable<TargetDestinatario[]>{

    let queryParams = new HttpParams().
                      append("idPso",idPso);

    return this.http.get<TargetDestinatario[]>(
      this.config.targetDestinatariUrl,
      {params:queryParams});
  }

  //modello di intervento
  getElencoTargetDestinatariForModello(idPso: string ,idModelloIntervento: string):
      Observable<TargetDestinatario[]>{
    let queryParams = new HttpParams().
        append("idPso",idPso).
        append("idModelloIntervento", idModelloIntervento);

    return this.http.get<TargetDestinatario[]>(
      this.config.targetDestinatariAssociatiUrl,
      {params:queryParams});

  }
  insertTargetDestinatari(targetDaInserire:TargetDestinatariAssociati[]):Observable<any>{
    return this.http.post<any>(this.config.targetDestinatariAssociatiUrl,targetDaInserire)
  }

  deleteTargetDestinatari(targetDaCancellare: TargetDestinatariAssociati[]):Observable<any>{
    return this.http.delete<any>(this.config.targetDestinatariAssociatiUrl,targetDaCancellare)
  }


  //servizio
  getTargetDestinatariServizio(idPso: string,idServizio:string,isModificabile: boolean):Observable<TargetDestinatario[]>{
    let queryParams =new HttpParams()
                        .append("idPso",idPso)
                        .append("idServizio",idServizio)
                        .append("isModificabile",isModificabile);
    return this.http.get<TargetDestinatario[]>(this.config.targetDestinatariServiozioUrl,{params:queryParams});
  }

  getTargetDestinatariServizioAssociati(idServizio:number):Observable<TargetDestinatario[]>{
    let queryParams =new HttpParams().append("idServizio",idServizio)
    return this.http.get<TargetDestinatario[]>(this.config.targetDestinatariServizioAssociatiUrl,{params:queryParams});
  }

  getTargetDestinatariIntervento(idIntervento:number):Observable<TargetDestinatario[]>{
    let queryParams =new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<TargetDestinatario[]>(this.config.targetDestinatariAssociatiInterventoUrl,{params:queryParams});
  }
  insertTargetDestinatariServizio(targetDaInserire:TargetDestinatariAssociati[]):Observable<any>{
    return this.http.post<any>(this.config.targetDestinatariServiozioUrl,targetDaInserire)
  }


  deleteTargetDestinatariServizio(targetDaCancellare: TargetDestinatariAssociati[]):Observable<any>{
    return this.http.delete<any>(this.config.targetDestinatariServiozioUrl,targetDaCancellare)
  }

}
