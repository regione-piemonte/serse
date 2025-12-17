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
import { FiltriRicerca } from '@shared/model/filtri-ricerca.model';

@Injectable({
  providedIn: 'root'
})
export class CriteriRicercaBagService {
  private _rottaChiamante: string = "";
  private _filtriRicerca?: FiltriRicerca;
  private _pageSize: number = 5;

  constructor(
  ) { }

  get rottaChiamante() {
    return this._rottaChiamante
  }

  set rottaChiamante(rotta: string) {
    this._rottaChiamante = rotta;
  }

  get filtriRicerca(): FiltriRicerca | undefined {
    return this._filtriRicerca ? this._filtriRicerca : undefined;
  }

  set filtriRicerca(filtri: FiltriRicerca | undefined) {
    this._filtriRicerca = filtri;
  }

  get pageSize() {
    return this._pageSize;
  }

  set pageSize(risPerPagina: number) {
    this._pageSize = risPerPagina;
  }
}
