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
import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Modelli
import { TipoModello } from '@core/api-serse/model/tipoModello';
import { StatoModelloIntervento } from '@core/api-serse/model/statoModelloIntervento';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';

// Servizi
import { ConfigService } from '@core/services/config.service';
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';
import { CriteriRicercaService } from '@core/services/criteri-ricerca.service';

// Module
import { ManagedHttpClient } from '@core/services/managed-http-client.service';


@Injectable()
export class CriteriModelliRicercaService {

  constructor(
    private http: ManagedHttpClient,
    private criteriRicerca: CriteriRicercaService,
    private config: ConfigService
  ) {}

  getTipiModello(idPso: string): Observable<TipoModello[]>{
    let queryParams = new HttpParams().append("idPso",idPso);
    return this.http.get<TipoModello[]>(
              this.config.tipiModelloUrl,
              {params:queryParams});
    // return of([]);
  }

  getStatiModello(): Observable<StatoModelloIntervento[]>{
    return this.http.get<StatoModelloIntervento[]>(
                this.config.statiModelloUrl);
  }

  getSoggettiBeneficiario(numProgrSportello: string, codOperatore:string,
                              gruppoOperatore:string): Observable<PersonaGiuridica[]>{
    return this.criteriRicerca.getSoggettiBeneficiario(numProgrSportello, codOperatore, gruppoOperatore);
  }
  getIstanzeCandidatura(numProgrSportello: string, codOperatore:string,
                             gruppoOperatore:string): Observable<SoggettoAttuatore[]>{
    return this.criteriRicerca.getIstanzeCandidatura(numProgrSportello, codOperatore, gruppoOperatore);
  }

  getTipologiaServizio(idPSo: string): Observable<ServizioRegionale[]>{
    return this.criteriRicerca.getTipologiaServizio(idPSo);
  }

}
