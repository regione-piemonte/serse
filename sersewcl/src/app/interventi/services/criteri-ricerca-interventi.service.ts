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
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { StatoIntervento } from '@core/api-serse/model/statoIntervento';
import { TipoIntervento } from '@core/api-serse/model/tipoIntervento';
import { ConfigService } from '@core/services/config.service';
import { CriteriRicercaService } from '@core/services/criteri-ricerca.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CriteriRicercaInterventiService {

  constructor(
    private http:ManagedHttpClient,
    private criteriRicerca: CriteriRicercaService,
    private config: ConfigService,

  ) { }

  getTipiIntervento(idPso: string):Observable<TipoIntervento[]>{
    let queryParams= new HttpParams().append("idPso",idPso)
    return this.http.get<TipoIntervento[]>(this.config.tipologieInterventoUrl,{params:queryParams})
  }

  getTipologieServiziIntervento(idIntervento:string):Observable<ServizioRegionale[]>{
    let queryParams= new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<ServizioRegionale[]>(this.config.tipologieServiziInterventoUrl,{params:queryParams})
  }

  getStatiIntervento():Observable<StatoIntervento[]>{
    return this.http.get<StatoIntervento[]>(this.config.statiInterventoUrl)
  }

  getIstanzeCandidatura(numProgrSportello: string, codOperatore:string,
                             gruppoOperatore:string): Observable<SoggettoAttuatore[]>{
    return this.criteriRicerca.getIstanzeCandidatura(numProgrSportello, codOperatore, gruppoOperatore);
  }

}
