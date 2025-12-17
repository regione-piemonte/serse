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

import { Injectable} from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

import { Router } from '@angular/router';

import { NotificationService } from './notification.service';
import { Subject, tap, throttleTime } from 'rxjs';

@Injectable(
  {
    providedIn: 'root'
  }
)
export class ErrorHandlerService {

  private errorSubject$ = new Subject<any>();

  constructor(
    private router: Router,
    private notificationService: NotificationService
  ) {

    // throttleTime per evitare che chiamate da request diverse facciano apparire più di una modale
    this.errorSubject$.pipe(
      throttleTime(500),
      tap(request => {
        this.handleHttpErrorInternal(request);
      })
    ).subscribe();
  }

  public handleHttpError(error: HttpErrorResponse) {
    this.errorSubject$.next(error);
  }

  private handleHttpErrorInternal(error: HttpErrorResponse) {

    switch (error.status) {
      case 0: {
        this.notificationService.alert('Il servizio non è disponibile, riprova più tardi!');
        break;
      }
      case 400: { //ErroreGestitoException
        let msg = error.error?.errorMessage || 'Errore di sistema contattare l\'amministratore o riprovare più tardi';
        this.notificationService.alert(msg);
        break;
      }
      case 401: {
        this.notificationService.alert('Credenziali non valide, devi effettuare nuovamente l\'accesso');
        this.router.navigateByUrl('/home/1')
        break;
      }
      case 403: {
        this.notificationService.alert('Non possiedi i privilegi necessari per l\'operazione richiesta');
        break;
      }
      case 404: {
        this.notificationService.alert('Pagina o servizio non disponibile, contattare amministratore');
        break;
      }
      case 504: {
        this.notificationService.alert('504 Pagina o servizio non disponibile, contattare amministratore');
        break;
      }
      default: { // in part. errore 500
        this.notificationService.alert('Errore di sistema contattare l\'amministratore o riprovare più tardi');
      }
    }

  }

}
