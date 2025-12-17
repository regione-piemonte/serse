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

import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExportService {

  constructor() { }

  /**
   * Gestisce la response, scarica il Blob con il mime type indicato.
   * Cerca il nome del file nella header, se non c'è usa defaultFilename
   * @param response
   * @param mimeType es. 'application/octet-stream'
   * @param defaultFilename
   */
  downloadResponse(response: HttpResponse<Blob>, mimeType: string, defaultFilename: string) {
    // Verifica che la risposta contenga il file
    if (response.body instanceof Blob) {
      const blob = new Blob([response.body], { type: mimeType });
      const filename = this.getFilenameFromHeaders(response.headers) ||  defaultFilename;
      this.downloadBlob(blob, filename);
    } else {
      console.error("Expected Blob, got", response.body);
    }
  }

  /**
   * Cerca nelle header content-disposition il nome del file, se indicato
   * @param headers
   * @returns
   */
  getFilenameFromHeaders(headers: HttpHeaders): string {
    // see https://stackoverflow.com/a/40940790/5116356
    const contentDisposition = headers.get('content-disposition');
    if (contentDisposition) {
      const filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
      const matches = filenameRegex.exec(contentDisposition);
      if (matches != null && matches[1]) {
        return matches[1].replace(/['"]/g, '').trim();
      }
    }
    return '';
  }

  /**
   * Scarica dal browser un Blob (la chiamata di rete è già stata fatta)
   * @param blob
   * @param filename
   */
  downloadBlob(blob: Blob, filename: string): void {
    const url = window.URL.createObjectURL(blob);
    const anchor = document.createElement('a');
    anchor.href = url;
    anchor.download = filename; // Specifica il nome del file
    anchor.click();
    // Rilascia l'URL creato dopo il download
    window.URL.revokeObjectURL(url);
  }
}
