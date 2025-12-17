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

import { Ruolo } from '@core/api-serse/model/ruolo';
import { UserInfo } from '@core/api-serse/model/userInfo';
import { InMemoryDbService } from 'angular-in-memory-web-api';

export class MockData implements InMemoryDbService {
  createDb() {
    const users: UserInfo[] = [
      {
        nome: 'CSI PIEMONTE',
        cognome: 'DEMO 23',
        codFisc: 'AAAAAA00A11D000L',
        ente: '--',
        ruolo: '--',
        codRuolo: 'cod_ruolo_1',
        livAuth: 16,
      },
    ];

    const ruoli: Ruolo[] = [
      {
        codiceDominio: 'FLAI',
        codiceRuolo: 'SERVIZIO_ASSISTENZA_SERSE',
        mnemonico: 'SERVIZIO_ASSISTENZA_SERSE@FLAI',
        descrizione: 'SERVIZIO_ASSISTENZA_SERSE',
      },
      {
        codiceDominio: 'FLAI',
        codiceRuolo: 'RESPONSABILE_EROG_SERVIZI',
        mnemonico: 'RESPONSABILE_EROG_SERVIZI@FLAI',
        descrizione: 'RESPONSABILE_EROG_SERVIZI',
      },
    ];
    return { users, ruoli };
  }
}
