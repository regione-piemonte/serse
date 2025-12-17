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

import { HttpParams } from "@angular/common/http";


export class DataSettingModel {

  /**
 * @description
 * Endpoint data of export excel setting model
 */
  endpointData?: string;

  /**
   * @description
   * Http params endpoint data of export excel setting model
   */
  httpParamsEndpointData?: HttpParams

  /**
   * @description
   * Data  of data setting model
   */
  data?: any[]
}

export class FileSettingModel {
  /**
   * @description
   * Filename  of export excel setting model
   */
  filename?: string;

  /**
   * @description
   * Filename  of export excel setting model
   */
  headers?: string[];

  /**
   * @description
   * Title file of export excel setting model
   */
  title?: string;

  /**
   * @description
   * Footer file of export excel setting model
   */
  footer?: string;

  /**
   * @description
   * Filters  of export excel setting model
   */
  filters?: string[];

}

export class MessageDialogSettingModel {

  /**
 * @description
 * Text message dialog of export excel setting model
 */
  text?: string;

}


