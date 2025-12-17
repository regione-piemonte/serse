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
import { Observable, catchError, of, throwError, timeout } from 'rxjs';

// Constants
//import { StaticUrls } from 'constants/static-urls';

// Services
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';

// Models
import { InfoOperatore } from '@core/api-serse/model/infoOperatore';
import { Ruolo } from '@core/api-serse/model/ruolo';
import { UserInfo } from '@core/api-serse/model/userInfo';
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';

@Injectable({
  providedIn: 'root'
})
export class FlaidoorService {

 constructor(private http: ManagedHttpClient,
             private config : ConfigService) { }


  getRuoli(): Observable< Ruolo[]>{
    return this.http.get<Ruolo[]>(this.config.ruoliUrl).pipe(
      timeout(15000), //15000 = 15s
      catchError(() => {
        return throwError(() => {
          return new Error(`Non è possibile contattare il server, riprovare più tardi o contattare l'assistenza`);
        })
      })
    )
  }

  getUserInfo(): Observable<UserInfo>{
    return this.http.get<UserInfo>(this.config.userInfoUrl);
  }

  getInfoOperatore(codRuolo:string): Observable<InfoOperatore[]>{
    let queryParams = new HttpParams().append("codRuolo",codRuolo);
    return this.http.get<InfoOperatore[]>(
            this.config.infoOperatoreUrl,
            {params:queryParams}).pipe(
              timeout(15000), //15000 = 15s
              catchError(() => {
                console.info('Error gestito  da  FlaidoorService...');
                return throwError(() => {
                  console.error('Error rethrown da FlaidoorService...');
                  return new Error(`Non è possibile contattare il server, riprovare più tardi o contattare l'assistenza`);
                })
              })
            );
  }
  getPersonaGiuridica(gruppoOperatore:string,codOperatore:string): Observable<PersonaGiuridica>{
    let queryParams = new HttpParams()
                            .append("gruppoOperatore",gruppoOperatore)
                            .append("codOperatore",codOperatore);
    return this.http.get<PersonaGiuridica>(
            this.config.personaGiuridicaUrl,
            {params:queryParams});
  }
}
