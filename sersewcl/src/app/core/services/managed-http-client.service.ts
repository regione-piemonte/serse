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

import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CoreModule } from '@core/core.module';
import { defer, Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { OverlayService } from './overlay.service';

/*
 * This service is a wrapper around HttpClient to manage HTTP requests with an overlay for loading indication.
 * It provides methods for GET, POST, PATCH, PUT, DELETE, and file download operations.
 */
@Injectable({ providedIn: CoreModule })
export class ManagedHttpClient {

    constructor(
        private http: HttpClient,
        private overlay: OverlayService
    ) {
    }

    private handle<E>(o: Observable<E>): Observable<E> {
      // 2025-07 LV con il defer carico l'overlay solo al momento del subscribe()
      return defer(() => {
        this.overlay.load();
        return o.pipe(
                  finalize(() => this.overlay.unload()
                ));
      })
    }

    get<E>(url: string, options?: { params: HttpParams }): Observable<E> {
        return this.handle(this.http.get<E>(url, options));
    }

    post<E>(url: string, body: any, params?: HttpParams, responseType?: string ): Observable<E> {

        return this.handle(this.http.post<E>(url, body, {

          params: params,

          responseType: responseType as 'json',


      }));
    }

    patch<E>(url: string, body: any): Observable<E> {
        return this.handle(this.http.patch<E>(url, body));
    }

    put<E>(url: string, body: any,  params?: HttpParams ): Observable<E> {
        return this.handle(this.http.put<E>(url, body,{params:params}));
    }

    delete<E>(url: string, body?: any,queryParams?: HttpParams ): Observable<E> {
        return this.handle(this.http.delete<E>(url , {params: queryParams, body: body}));
    }

    getFile<E>(url: string, options?: { params: HttpParams}): Observable<HttpResponse<Blob>> {
      return this.handle(this.http.request('get', url, {
        responseType: 'blob',
        params: options?.params,
        observe: 'response'
      }));
  }
}
