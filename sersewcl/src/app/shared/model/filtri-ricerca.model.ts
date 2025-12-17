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

export class FiltriRicerca{

  constructor(
    public miei:boolean=true ,  // miei / altro
    public tipo?:string,    // tipologia del per il quale filtrare
    public stato?:string,   // lo stato varia in base
    // al modello{bozza,publico,chiuso}, intervento{attivo,chiuso}, servizi{in definizione, Finanziato, avviato, chiuso}

    public finalita?:string, // presente solo nei servizi

    public beneficiario?: string,
    public istanzaCandidatura?: string,

    public tipologiaServizio?:string, // non presente nel servizio


    public enteCoinvolto?: string,
    public identificativo?:string,

    public destinatario?:  string,
    public infoIncontro?: number,     // non presnete nel modello,

    public soggettoAttuatore?:string,

    public soggettoAttuatoreSede?:string

  ){}

}
