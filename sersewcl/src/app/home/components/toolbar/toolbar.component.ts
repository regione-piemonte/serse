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

import { Breakpoints } from '@angular/cdk/layout'
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { UserInfo } from '@core/api-serse/model/userInfo';
import { TitleService } from '@core/services/title.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { RoleTitleService } from '@home/services/role-title.service';
import { environment } from '@environment/environment';
import { BreakpointService } from 'src/app/servizi/services/breakpoint.service';
import { PristineService } from '@home/services/pristine.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  @Input() userInfo?:UserInfo;
  @Input() ruolo?:string;
  @Input() operatore?:string;

  @Output() openHelpEvent = new EventEmitter<void>();

  isXSmallScreen!: boolean;
  isSmallScreen!: boolean;
  isMediumScreen!: boolean;
  isLargeScreen!: boolean;
  isXLargeScreen!: boolean;

  panelOpenState=false;
  selectedMessage = '';

  constructor(
    private title: TitleService,
    private roleTitle: RoleTitleService,
    private breakpointService: BreakpointService,
    private pristineService: PristineService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.roleTitle.getValue().subscribe(value => this.selectedMessage = value);
    this.breakpointService.observeBreakpoints([
      Breakpoints.XSmall,
      Breakpoints.Small,
      Breakpoints.Medium,
      Breakpoints.Large,
      Breakpoints.XLarge
    ]).subscribe(result => {
      this.isXSmallScreen = result[Breakpoints.XSmall];
      this.isSmallScreen = result[Breakpoints.Small];
      this.isMediumScreen = result[Breakpoints.Medium];
      this.isLargeScreen = result[Breakpoints.Large];
      this.isXLargeScreen = result[Breakpoints.XLarge];
      this.showTitleResponsive();
    });
  }

  get titolo(){
    return this.title.titleString;
  }
  get icona(){
    return this.title.iconString;
  }

  showTitleResponsive(): boolean {
    if(this.isXSmallScreen) return true;
    if(this.isSmallScreen) return true;
    return false;
  }

  updateValue(value: any) {
    this.roleTitle.setValue(value);
  }


  clearStorage(){
    this.pristineService.checkPristine(() => {
      this.doClearStorage();
      this.router.navigate(['/home']);
    })
  }

  doClearStorage(){
    localStorage.removeItem("codiceOperatore");
    localStorage.removeItem("ruolo");
    localStorage.removeItem("selectedPso");
    localStorage.removeItem("descriOperatore");
    localStorage.removeItem("gruppoOperatore");
    localStorage.removeItem("infoOperatore");
    localStorage.removeItem("selectedTipologiaPso");
    localStorage.removeItem("selectedSportello");
    localStorage.removeItem("tipologiaGestioneSportello");
    this.updateValue("Home");
  }

  logOut(){
    this.pristineService.checkPristine(() => {
      this.doClearStorage();
      window.location.href = environment.logoutUrl;
    })
  }

  openHelp(){
    this.openHelpEvent.emit();
  }
}
