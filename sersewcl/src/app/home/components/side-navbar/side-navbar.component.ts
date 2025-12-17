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

import { PristineService } from './../../services/pristine.service';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

//models shared
import { NavBarItem } from '@shared/model/navbar-item.model';

// List-items nav bar
import { HOME_ITEM, INTERVENTO_GEST_ITEM, INTERVENTO_ITEM, INTERVENTO_NEW_ITEM,
        MODELLO_GEST_ITEM, MODELLO_ITEM, MODELLO_NEW_ITEM, SERVIZI_GEST_ITEM,
                                          SERVIZI_ITEM, SERVIZI_NEW_ITEM, STRUMENTI_ITEM, VERIFICA_BUDGET, VERIFICA_SERVIZI_DESTINATARIO } from '@shared/const/navbar-items-list';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry } from '@angular/material/icon';
import { IconsSettings } from '@shared/const/icons-settings';
import { HomeBagService } from '@home/services/home-bag.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { InterventiService } from '@interventi/services/interventi.service';
import { ServiziService } from '@servizi/services/servizi.service';


@Component({
  selector: 'app-side-navbar',
  templateUrl: './side-navbar.component.html',
  styleUrls: ['./side-navbar.component.scss'],
  animations: [
    trigger('navInOut',[
      state('in', style({
        transform: 'translate3d(-100%,0,0)',
        display: 'none'
      })),
      state('out', style({
        transform: 'translate3d(0, 0, 0)'
      })),
      transition('in => out', animate('400ms ease-in-out')),
      transition('out => in', animate('400ms ease-in-out'))
    ]),
  ]
})
export class SideNavbarComponent implements OnInit {

  navbarItemsList: NavBarItem[] = [];
  tipologiaGestionSportello = this.homeBag.gestioneSportello;

  pulsante = true;


  isExpanded = true;

  constructor(
    private router: Router,
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer,
    private homeBag: HomeBagService,
    private pristineService: PristineService,
    private modelloService: ModelliService,
    private interventoService: InterventiService,
    private serviziService: ServiziService
  ) {
    this.matIconRegistry.addSvgIcon(
      IconsSettings.HOME_ICON,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.iconHOME)
    );
    this.addIcons();

  }

  ngOnInit(): void {
    this.buildNavbarItems();
  }

  addIcons(){
    this.matIconRegistry.addSvgIcon(
      IconsSettings.MODELLI_ICON_N,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.navIconMDI)
    );
    this.matIconRegistry.addSvgIcon(
      IconsSettings.INTERVENTI_ICON_N,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.navIconINT)
    );
    this.matIconRegistry.addSvgIcon(
      IconsSettings.SERVIZI_ICON_N,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.navIconSER)
    );
    this.matIconRegistry.addSvgIcon(
      IconsSettings.STRUMENTI_ICON_N,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.navIconSTR)
    );
  }

  // Aggiunge i vari elementi che andranno a popolare la nav-bar
  buildNavbarItems(){
    //- Home
    this.navbarItemsList.push(HOME_ITEM)
    //- Modello
    if(this.tipologiaGestionSportello.flagGestioneModello == "S"){

      this.navbarItemsList.push(
        MODELLO_ITEM,
        MODELLO_GEST_ITEM)

      if(this.homeBag.selectedRuolo.codiceRuolo != "FUNZIONARIO_MASTER_SERSE"){
        this.navbarItemsList.push(MODELLO_NEW_ITEM)
      }
    }
    //- Intervento
    if(this.tipologiaGestionSportello.tipoGestioneIntervento){
      this.navbarItemsList.push(
        INTERVENTO_ITEM,
        INTERVENTO_GEST_ITEM,

      )
      if(this.homeBag.selectedRuolo.codiceRuolo != "FUNZIONARIO_MASTER_SERSE"){
        this.navbarItemsList.push(INTERVENTO_NEW_ITEM,)
      }
    }
    //- Servizio
    this.navbarItemsList.push(
      SERVIZI_ITEM,
      SERVIZI_GEST_ITEM,
    )
    if(this.homeBag.selectedRuolo.codiceRuolo != "FUNZIONARIO_MASTER_SERSE"){
      this.navbarItemsList.push(SERVIZI_NEW_ITEM)
    }

    //- strumenti
    this.navbarItemsList.push(
      STRUMENTI_ITEM,
      // VERIFICA_BUDGET,
      // VERIFICA_SERVIZI_DESTINATARIO
    )
    if(this.homeBag.selectedRuolo.codiceRuolo != 'OPERATORE_EROG_SERVIZI'){
      this.navbarItemsList.push(
        // STRUMENTI_ITEM,
        VERIFICA_BUDGET,
        // VERIFICA_SERVIZI_DESTINATARIO
      )
    }
    this.navbarItemsList.push(
      // STRUMENTI_ITEM,
      // VERIFICA_BUDGET,
      VERIFICA_SERVIZI_DESTINATARIO
    )

  }

  navigate(path?: string, isSubSection: boolean = false) {
    if (!isSubSection) {
      return;
    }
    if (path) {
      this.pristineService.checkPristine(() => this.doNavigate(path));
    }
  }

  private doNavigate(path: string) {
    this.clearService()
    let actualUrl = this.router.url;
    this.router.navigate([path]).then(()=> {
      if(path.includes("nuovo") && path == actualUrl){ //-per evitare di fare il refresh la prima volta
        window.location.reload() //Refresh della pagina nuovo
      }});
  }

  clearService() {
    this.modelloService.reset();
    this.interventoService.reset();
    this.serviziService.reset();
  }




}
