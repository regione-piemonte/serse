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
import { CriteriRicercaService } from '@core/services/criteri-ricerca.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { CriteriRicercaServiziService } from './criteri-ricerca-servizi.service';
import { TipoIntervento } from '@core/api-serse/model/tipoIntervento';
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { StatoServizio } from '@core/api-serse/model/statoServizio';
import { compareTipologiaservizio } from '@shared/utils/compares';
import { SedeOperatore } from '@core/api-serse/model/sedeOperatore';

@Injectable({
  providedIn: 'root'
})
export class ServiziBagService {

  private _statiServizio: StatoServizio[] = [];
  private _soggettiBeneficiari: PersonaGiuridica[] = [];
  private _istanzeCandidature: SoggettoAttuatore[] = [];
  private _soggettiAttuatori: SoggettoAttuatore[] = [];
  private _tipologiaServizio: ServizioRegionale[] = [];

  miei: boolean = true;

  beneficiarioSelected: PersonaGiuridica = {};
  candidaturaSelected: SoggettoAttuatore = {};
  servizioSelected: ServizioRegionale = {};
  soggettiAttuatoriSelected: SoggettoAttuatore = {};
  statoServizioSelected: StatoServizio={};
  finalitaSelected: string="";
  enteCoinvolti: String = '';
  IdentificativoServizio: String= '';


  constructor(
    private criteriRicercaServizi: CriteriRicercaServiziService,
    private homeBag:HomeBagService) {
      criteriRicercaServizi.getIstanzeCandidatura(
        homeBag.selectedSportello.numProgrSportello!.toString(),
        homeBag.codiceOperatore,
        homeBag.gruppoOperatore
      ).subscribe({
        next: (response) => {
            this._istanzeCandidature = response;
        }});

        criteriRicercaServizi.getSoggettiBeneficiario(
        homeBag.selectedSportello.numProgrSportello!.toString(),
        homeBag.codiceOperatore,
        homeBag.gruppoOperatore
      ).subscribe({
        next: (response) => {
        this._soggettiBeneficiari = response;
      }});

      criteriRicercaServizi.getTipologiaServizio(homeBag.selectedPso.idPso!.toString())
      .subscribe({
        next: (response) => {
            this._tipologiaServizio = response;
            this._tipologiaServizio.sort(compareTipologiaservizio)
      }});

      criteriRicercaServizi.getStatiServizio().subscribe({
        next: (response)=>{
          this._statiServizio=response
        }
      })

      criteriRicercaServizi.getSoggettiAttuatori(
        homeBag.codiceOperatore,
        homeBag.gruppoOperatore
      ).subscribe({
        next: (response) => {
          this._soggettiAttuatori = response
        }
      })
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
    get soggettiAttuatori(){
      return this._soggettiAttuatori
    }
    get statiServizioList(){
      return this._statiServizio
    }
}
