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

// Models
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { StatoModelloIntervento } from '@core/api-serse/model/statoModelloIntervento';
import { TipoModello } from '@core/api-serse/model/tipoModello';

// Services
import { HomeBagService } from '@home/services/home-bag.service';
import { CriteriModelliRicercaService } from '@modelli/services/criteri-modelli-ricerca.service';

// Comapre for Sorting
import { compareStatoModello, compareTipologiaservizio } from '@shared/utils/compares';


@Injectable(
  // {providedIn: 'root'}
)
export class ModelliBagService {

  private _tipologieModello: TipoModello[] = [];
  private _statiModello: StatoModelloIntervento[] = [];
  private _soggettiBeneficiari: PersonaGiuridica[] = [];
  private _istanzeCandidature: SoggettoAttuatore[] = [];
  private _tipologiaServizio: ServizioRegionale[] = [];



  miei: boolean = true;

  tipologiaSelected: TipoModello = {};
  statoSelected: StatoModelloIntervento = {};
  beneficiarioSelected: PersonaGiuridica = {};
  candidaturaSelected: SoggettoAttuatore = {};
  servizioSelected: ServizioRegionale = {};

  enteCoinvolti: String = '';
  IdentificativoModello: String= '';



  constructor(
    criteriRicerca: CriteriModelliRicercaService,
    homeBag: HomeBagService
  ) {
    criteriRicerca.getTipiModello(homeBag.selectedPso.idPso!.toString())
      .subscribe({
          next: (response) => {
              this._tipologieModello = response;
        }});

    criteriRicerca.getStatiModello()
      .subscribe({
          next: (response) => {
              this._statiModello = response;
              this._statiModello.sort(compareStatoModello);
        }});

    criteriRicerca.getSoggettiBeneficiario(
            homeBag.selectedSportello.numProgrSportello!.toString(),
            homeBag.codiceOperatore,
            homeBag.gruppoOperatore)
      .subscribe({
        next: (response) => {
            this._soggettiBeneficiari = response;
        }});

    criteriRicerca.getIstanzeCandidatura(
            homeBag.selectedSportello.numProgrSportello!.toString(),
            homeBag.codiceOperatore,
            homeBag.gruppoOperatore)
      .subscribe({
        next: (response) => {
            this._istanzeCandidature = response;
        }});

    criteriRicerca.getTipologiaServizio(homeBag.selectedPso.idPso!.toString())
      .subscribe({
          next: (response) => {
              this._tipologiaServizio = response;
              this._tipologiaServizio.sort(compareTipologiaservizio)
        }});
  }


  // Questo, per popolare i campi del form
  get tipoModelloList(){
    return this._tipologieModello
   }
  get statoModelloList(){
    return this._statiModello
  }
  get soggettoBeneficiarioList(){
    return this._soggettiBeneficiari
   }
  get istanzaCandidaturaList(){
    return this._istanzeCandidature
  }
  get tipologiaServizioList(){
    return this._tipologiaServizio
  }

}
