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

import { PristineService } from '@home/services/pristine.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { Component, OnInit } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { RoleTitleService } from '@home/services/role-title.service'

@Component({
  selector: 'app-info-scelta',
  templateUrl: './info-scelta.component.html',
  styleUrls: ['./info-scelta.component.scss']
})
export class InfoSceltaComponent implements OnInit {

  constructor(
    public dialog: MatDialog,
    public homeBagService: HomeBagService,
    private router: Router,
    private roleTitle: RoleTitleService,
    private pristineService: PristineService
    ) { }

  ngOnInit(): void {
    this.updateValue(this.amministrazioneResponsabileCicloFinanziario.ammResponsabili?.descrizione);
  }

  updateValue(value: any) {
    this.roleTitle.setValue(value);
  }

  get tipologiaPso(){
    return this.homeBagService.selectedTipologiaPSO;
  }
  get amministrazioneResponsabileCicloFinanziario(){
    return this.homeBagService.selectedPso;
  }
  get sportello(){
    return this.homeBagService.selectedSportello;
  }

  apriModaleConferma() {
    this.pristineService.checkPristine(()=> this.router.navigate(["/home/2"]))
  }

}
