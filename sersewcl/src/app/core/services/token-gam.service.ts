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

import { Injectable } from '@angular/core';
import { ConfigService } from './config.service';
import { ManagedHttpClient } from './managed-http-client.service';
import { HttpParams } from '@angular/common/http';
import { TokenGam } from '@core/api-serse/model/tokenGam';
import { Observable } from 'rxjs';
import { ServizioGamPropostaModifica } from '@core/api-serse/model/servizioGamPropostaModifica';

@Injectable({
  providedIn: 'root'
})
export class TokenGamService {

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService
  ) { }

  getTokenGamServizioconCodice(idServizio:number, codTipoRichiestaGam:string):Observable<TokenGam[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio)
                                      .append("codTipoRichiestaGam",codTipoRichiestaGam);
    return this.http.get<TokenGam[]>(this.config.tokenGamServizioUrl,{params:queryParams})
  }

  getTokenGamServizio(idServizio:string):Observable<TokenGam[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<TokenGam[]>(this.config.tokenGamServizioUrl,{params:queryParams})
  }

  //- Proposta modifica
  postPropostaModifca(proposta:ServizioGamPropostaModifica): Observable<TokenGam>{
    return this.http.post<TokenGam>(this.config.serviziPropostaModificaUrl,proposta);
  }


}
