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

import {  Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { IconsSettings } from '@shared/const/icons-settings';


// This URL path string is of type SafeResourceUrl. To parse the URL path string into SafeResourceUrl, we can make use of the DomSanitizer provided by Angular.

// Next, add the import for DomSanitizer:
import { DomSanitizer } from "@angular/platform-browser";


import { MatIconRegistry } from '@angular/material/icon';
import { HomeBagService } from '@home/services/home-bag.service';

@Component({
  selector: 'app-card-section',
  templateUrl: './card-section.component.html',
  styleUrls: ['./card-section.component.scss']
})
export class CardSectionComponent implements OnInit {
  @Input('sectionName') sectionFor: string = '';
  @Input('menuWidth') menuWidth: number = 0;
  downRowIcon = IconsSettings.DOWNR_ICON;
  labelMenu : string[] = ['',''];

  selectedIcon = '';
  label = '';
  url = '';

  isOpened = false;

  constructor(
    private router: Router,
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer,

    private homeBag: HomeBagService,
  ) {
    this.uploadIcons();

  }


  uploadIcons(){
    this.matIconRegistry.addSvgIcon(
      IconsSettings.MODELLI_ICON,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconMDI)
    );
    this.matIconRegistry.addSvgIcon(
      IconsSettings.INTERVENTI_ICON,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconINT)
    );
    this.matIconRegistry.addSvgIcon(
      IconsSettings.SERVIZI_ICON,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconSER)
    );
    this.matIconRegistry.addSvgIcon(
      IconsSettings.STRUMENTI_ICON,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconSTR)
    );

    this.matIconRegistry.addSvgIcon(
      IconsSettings.DOWNR_ICON,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconDOWNR)
    );
  }

  ngOnInit(): void {
    switch(this.sectionFor){
      case 'modello':
        this.selectedIcon = IconsSettings.MODELLI_ICON;
        this.label = 'Modelli di intervento';
        this.labelMenu[0] = 'Gestione modelli';
        if(this.homeBag.selectedRuolo.codiceRuolo != "FUNZIONARIO_MASTER_SERSE"){
          this.labelMenu[1] = 'Nuovo modello';
        }
        break;

      case 'intervento':
        this.selectedIcon = IconsSettings.INTERVENTI_ICON;
        this.label = 'Interventi';
        this.labelMenu[0] = 'Gestione interventi';
        if(this.homeBag.selectedRuolo.codiceRuolo != "FUNZIONARIO_MASTER_SERSE"){
          this.labelMenu[1] = 'Nuovo intervento';
        }
        break;


      case 'servizio':
        this.selectedIcon = IconsSettings.SERVIZI_ICON;
        this.label = 'Servizi';
        this.labelMenu[0] = 'Gestione servizi';
        if(this.homeBag.selectedRuolo.codiceRuolo != "FUNZIONARIO_MASTER_SERSE"){
          this.labelMenu[1] = 'Nuovo servizio';
        }
        break;

      case 'strumenti':
        this.selectedIcon = IconsSettings.STRUMENTI_ICON;
        this.label = 'Funzioni trasversali';
        if(this.homeBag.selectedRuolo.codiceRuolo != 'OPERATORE_EROG_SERVIZI'){
          this.labelMenu[0] = 'Verifica budget';
          this.labelMenu[1] = 'Verifica servizi per destinatario';}
        else{
          this.labelMenu[0] = 'Verifica servizi per destinatario';
        }
        break;
    }
  }

  navigate(fakeControl: boolean){
    let first = this.sectionFor == 'strumenti' ? "verifica/budget":"gestione";
    let second = this.sectionFor == 'strumenti' ? "verifica/servizi_destinatario":"nuovo";
    let last = "/"

    if(this.sectionFor == 'strumenti' && this.homeBag.selectedRuolo.codiceRuolo == 'OPERATORE_EROG_SERVIZI'){
      last = last + second;
    }else last = last + (fakeControl ? first:second);

    this.router.navigateByUrl("dashboard/"+this.sectionFor+last);
  }
}
