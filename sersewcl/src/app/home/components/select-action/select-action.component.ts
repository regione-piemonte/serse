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

import { AfterViewInit, Component, HostListener, OnInit } from '@angular/core';
import { TitleService } from '@core/services/title.service';

// Services
import { HomeBagService } from '@home/services/home-bag.service';

@Component({
  selector: 'app-select-action',
  templateUrl: './select-action.component.html',
  styleUrls: ['./select-action.component.scss']
})
export class SelectActionComponent implements OnInit, AfterViewInit {
  menuList : string[]=[];
  menuWidth: number = 0;

  constructor(
    private homeBagService: HomeBagService,
    private title: TitleService,
  ){

    this.uploadMenuList();
   }




  ngOnInit(): void {
    this.title.setTitle("Home page");
    this.title.setIcon("")
  }
  get tipologiaGestionSportello(){
    return this.homeBagService.gestioneSportello;
  }

  ngAfterViewInit(): void {
    this.getDivWidth();
   }
   @HostListener('window:resize')
   onWindowResize() {
     this.getDivWidth();
   }
   getDivWidth() {
    const element = document.getElementById('card-menu-1');
    if (element) {
      this.menuWidth = element.offsetWidth;
    }
  }

  uploadMenuList(){
    if(this.tipologiaGestionSportello.flagGestioneModello == "S"){
      this.menuList.push("modello")
    }
    if(this.tipologiaGestionSportello.tipoGestioneIntervento){
      this.menuList.push("intervento")
    }
    this.menuList.push("servizio")
    this.menuList.push("strumenti")
  }


}
