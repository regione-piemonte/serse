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

import { formatDate } from '@angular/common';

export class DateUtils {

  static ISODate(d: Date): string|null {
    return d ? formatDate(d, 'yyyy-MM-dd', 'en') : null;
  }

  /**
* Incrementa la data di @days giorni e restituisce la data come number per eventuali confronti
* ATTENZIONE: all'interno del metodo viene utilizzato il metodo getTime()
*  che restituisce il numero di millisecondi dal 1 Gennaio 1970
*/
  static increaseDay(d: Date, days: number): number|null {
    if (d) {
      const mday = (24 * 60 * 60 * 1000) * days;
      return new Date(d).getTime() + mday;
    } else {
      return null;
    }
  }

  /**
   * Decrementa la data di @days giorni e restituisce la data come number per eventuali confronti
   * ATTENZIONE: all'interno del metodo viene utilizzato il metodo getTime()
   *  che restituisce il numero di millisecondi dal 1 Gennaio 1970
   */
  static decreaseDay(d: Date, days: number): number|null {
    if (d) {
      const mday = (24 * 60 * 60 * 1000) * days;
      return new Date(d).getTime() - mday;
    } else {
      return null;
    }
  }

  static ISODateStandard(d: Date): string|null {
    return d ? formatDate(d, 'dd/MM/yyyy', 'en') : null;
  }

  static convertStringDateInFormatISO(s: string): string|null {
    return s ? s.split('/').reverse().join('-') : null;
  }

  static parseStandardDate(text: string): Date|null {
    return text ? new Date(DateUtils.convertStringDateInFormatISO(text)!) : null;
  }
}
