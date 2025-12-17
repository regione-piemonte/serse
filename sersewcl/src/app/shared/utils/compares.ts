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

import { InfoOperatore } from '@core/api-serse/model/infoOperatore';
import { Ruolo } from "@core/api-serse/model/ruolo";
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { StatoModelloIntervento } from '@core/api-serse/model/statoModelloIntervento';
import { TipoModello } from '@core/api-serse/model/tipoModello';


// Lotto1 Pagina Home/1
export const compareRuolo = (a:Ruolo, b:Ruolo) =>{
                        let aString: string = a.descrizione ? a.descrizione: '';
                        let bString: string = b.descrizione ? b.descrizione: '';
                        return aString.localeCompare(bString)};

export const compareOpetatore = (a:InfoOperatore, b:InfoOperatore) =>{
                        let aString: string = a.descrOperatore ? a.descrOperatore: '';
                        let bString: string = b.descrOperatore ? b.descrOperatore: '';
                        return aString.localeCompare(bString)};

// Lotto 2, Gestione modelli
export const compareStatoModello = (a:StatoModelloIntervento, b:StatoModelloIntervento) =>{
                        let aString : string = a.idStatoModelloDiIntervento ? a.idStatoModelloDiIntervento.toString(): '';
                        let bString : string = b.idStatoModelloDiIntervento ? b.idStatoModelloDiIntervento.toString(): '';
                        return aString.localeCompare(bString)};

export const compareTipologiaservizio = (a:ServizioRegionale, b:ServizioRegionale) =>{
                        let aString : string = a.codiceServizioRegionale ? a.codiceServizioRegionale.toString(): '';
                        let bString : string = b.codiceServizioRegionale ? b.codiceServizioRegionale.toString(): '';
                        return aString.localeCompare(bString)};
