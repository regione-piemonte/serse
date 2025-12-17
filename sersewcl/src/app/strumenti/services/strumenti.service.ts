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
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { Budget } from '@core/api-serse/model/budget';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StrumentiService {

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService,
    private homeBag:HomeBagService
  ) { }

  getBudget():Observable<Budget[]>{
    let queryParams = new HttpParams()
                        .append("numProgrSportello",this.homeBag.selectedSportello.numProgrSportello?.toString()!)
                        .append("codOperatore",this.homeBag.codiceOperatore)
                        .append("idPso",this.homeBag.selectedPso.idPso!)
                        .append("gruppoOperatore",this.homeBag.gruppoOperatore);

    return this.http.get<Budget[]>(this.config.verificaBudgetUrl,{params:queryParams});
  }

}
