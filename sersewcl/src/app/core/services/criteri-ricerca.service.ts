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
import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Services
import { ConfigService } from './config.service';

// Models
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { ManagedHttpClient } from './managed-http-client.service';

@Injectable({
  providedIn: 'root'
})
export class CriteriRicercaService {

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService
  ) { }

  getSoggettiBeneficiario(numProgrSportello: string, codOperatore: string,
    gruppoOperatore: string): Observable<PersonaGiuridica[]> {
    let queryParams = new HttpParams()
      .append("numProgrSportello", numProgrSportello)
      .append("codOperatore", codOperatore)
      .append("gruppoOperatore", gruppoOperatore);
    return this.http.get<PersonaGiuridica[]>(
      this.config.soggettoBeneficiarioUrl,
      { params: queryParams });
  }

  getIstanzeCandidatura(numProgrSportello: string, codOperatore: string,
    gruppoOperatore: string): Observable<SoggettoAttuatore[]> {
    let queryParams = new HttpParams()
      .append("numProgrSportello", numProgrSportello)
      .append("codOperatore", codOperatore)
      .append("gruppoOperatore", gruppoOperatore);
    return this.http.get<SoggettoAttuatore[]>(
      this.config.istanzeCandidaturaUrl,
      { params: queryParams });
  }

  getTipologiaServizio(idPSo: string): Observable<ServizioRegionale[]> {
    let queryParams = new HttpParams().append("idPso", idPSo);

    return this.http.get<ServizioRegionale[]>(
      this.config.serviziRegionaliUrl,
      { params: queryParams });
  }

  getSoggettiAttuatori(codOperatore: string, gruppoOperatore: string,
    numProgrSportello?: string): Observable<SoggettoAttuatore[]> {
    let queryParams = new HttpParams()
      .append("codOperatore", codOperatore)
      .append("gruppoOperatore", gruppoOperatore);
    if (numProgrSportello)
      queryParams = queryParams.append("numProgrSportello", numProgrSportello)
    return this.http.get<SoggettoAttuatore[]>(
      this.config.soggettiAttuatoriUrl,
      { params: queryParams });
  }

}
