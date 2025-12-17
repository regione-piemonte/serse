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

import { ErrorHandler, Injectable } from '@angular/core';

// 2025-09 LV gli errori di rete sono catturati quasi esclusivamente dall'interceptor
// però il ChunkLoadError non viene intercettato, creo un ErrorHandler

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {

  constructor(
    ) {}

  handleError(error: any): void {
    if (error.message?.includes('ChunkLoadError')) {
      this.handleChunkLoadFailedError(error);
    } else {
      // questo ErrorHandler sostituisce completamente l'ErrorHandler di default!
      // questo mima il comportamento usuale:
      console.error(error);
    }
  }

  handleChunkLoadFailedError(error: any) {

    // QUI sembra non funzionare nè MatDialog, nè NotificationService

    alert('Il servizio non è disponibile, riprova più tardi!');
  }
}
