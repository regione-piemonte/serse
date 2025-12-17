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
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';


// SERVICES
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';

// MODELS
import { TipologiaPso } from '@core/api-serse/model/tipologiaPso';
import { Sportello } from '@core/api-serse/model/sportello';
import { PsoRistretto } from '@core/api-serse/model/psoRistretto';
import { TipoGestioneSportello } from '@core/api-serse/model/tipoGestioneSportello';

@Injectable({
  providedIn: 'root'
})
export class AvvisiService {

  constructor(
    private http: ManagedHttpClient,
    private config : ConfigService
    ) {}

  // Faccio una chiamata creando un Observable per ricevere le Tipologie
  getTipologiePSO(codOperatore: string = '', gruppoOperatore: string=''): Observable<TipologiaPso[]>{
    let queryParams = new HttpParams()
                        .append("codOperatore",codOperatore)
                        .append("gruppoOperatore",gruppoOperatore);
    return this.http.get<TipologiaPso[]>(
            this.config.tipologieUrl,
            {params:queryParams});
  }

  getPSO(tipologiaPsoId:string, idAttoIndirizzo:string, codOperatore:string): Observable<PsoRistretto[]>{
    let queryParams = new HttpParams()
                          .append("tipologiaPsoId",tipologiaPsoId)
                          .append("idAttoIndirizzo",idAttoIndirizzo)
                          .append("codOperatore",codOperatore);
    return this.http.get<PsoRistretto[]>(
              this.config.psoUrl,
              {params:queryParams});
  }
  getSportelli(idPso:string, codOperatore:string, gruppoOperatore:string): Observable<Sportello[]>{
    let queryParams = new HttpParams()
                      .append("idPso",idPso)
                      .append("codOperatore",codOperatore)
                      .append("gruppoOperatore",gruppoOperatore);
    return this.http.get<Sportello[]>(
      this.config.sportelliUrl,
      {params:queryParams});
  }



  //###################################################
  //###################################################



  updateTipoGestioneSportello(numProgSportello:string):Observable<TipoGestioneSportello>{
    return this.http.get<TipoGestioneSportello>
                    (this.config.sportelliUrl+'/'+numProgSportello)
  }








}
