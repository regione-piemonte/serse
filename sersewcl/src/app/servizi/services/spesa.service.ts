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

import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { TokenGam } from '@core/api-serse/model/tokenGam';
import { ServizioVoceSpesa } from '@core/api-serse/model/servizioVoceSpesa';
import { HttpParams } from '@angular/common/http';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { ConfigService } from '@core/services/config.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { ServizioFonte } from '@core/api-serse/model/servizioFonte';
import { Servizio } from '@core/api-serse/model/servizio';
import { ServizioSto } from '@core/api-serse/model/servizioSto';
import { ServizioGam } from '@core/api-serse/model/servizioGam';

@Injectable({
  providedIn: 'root'
})
export class SpesaService {

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService,
    private homeBag: HomeBagService)
  { }

  // ==============
  getTokenGamServizio(idServizio:string):Observable<TokenGam[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<TokenGam[]>(this.config.tokenGamServizioUrl,{params:queryParams})
  }

  getElencoVociSpesa(idServizio:string):Observable<ServizioVoceSpesa[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<ServizioVoceSpesa[]>(this.config.voceSpesaUrl,{params:queryParams})
  }

  getElencoFinanziamento(idServizio:string):Observable<ServizioFonte[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<ServizioFonte[]>(this.config.fonteFinanzUrl,{params:queryParams})
  }


  richiestaPreventivoSpesa(servizio:ServizioGam):Observable<TokenGam>{
    return this.http.post<TokenGam>(this.config.calcPreventivoSerseUrl,servizio);
  }
  richiestaFinanziamento(servizio:ServizioGam):Observable<TokenGam>{
    return this.http.post<TokenGam>(this.config.nuovoServizioSerseUrl,servizio);
  }

  getStoricoServizio(idServizio:string):Observable<ServizioSto[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<ServizioSto[]>(this.config.storicoServizioUrl,{params:queryParams})
  }


}
