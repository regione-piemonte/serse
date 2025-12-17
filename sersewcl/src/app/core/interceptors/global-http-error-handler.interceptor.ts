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
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
} from '@angular/common/http';
import { catchError, Observable, retry, throwError, timer } from 'rxjs';
import { ErrorHandlerService } from '@core/services/error-handler.service';

@Injectable()
export class GlobalHttpErrorHandler implements HttpInterceptor {

  constructor(
      private errorService: ErrorHandlerService
    ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(request).pipe(
      // Ritenta la richiesta solo in caso di errore di rete
      retry({
        count: 2, // Numero massimo di tentativi
        delay: (error, retryCount) => {
          // Controlla se l'errore è un errore di rete (ProgressEvent), oppure se l'errore è 503 (Service Unavailable) o 504 (Gateway Timeout)
          if (error instanceof HttpErrorResponse && (error.error instanceof ProgressEvent || error.status === 503 || error.status === 504)) {
            return timer(retryCount * 300); // Ritardo crescente
          }
          // Altrimenti, non ritentare
          return throwError(() => error);
        }
      }),
      catchError(err => {
        // Gestione degli errori
        if (err instanceof HttpErrorResponse) {
          this.errorService.handleHttpError(err);
        }
        return throwError(() => err); // Rilancia l'errore per una gestione successiva
      })
    );
  }
}
