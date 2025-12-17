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

export interface ExportExcelServizi{
  tipolPso:string,
  sportello:string,
  soggettoBeneficiario:string,
  soggettoAttuatore:string,
  modelId:string,
  idServizio:number,
  titolo:string,
  tipologiaServizio:string,
  finalitaServizio:string|null,
  idIntervento:number|null,
  statoServizio:string,
  durata:string,
  numMaxDestinatari: number,
  numeroDestinatariAssociati: number|null,
  cognNomeDesctinatario:string|null,
  cFDestinatario:string,
  totIncontriDefiniti:number|undefined,
  totIncontriChiusi:number|undefined,
  entiCoinvolti:string|null|undefined,
  codUserInserimento:string,
  codUserAggiornamento:string
}
