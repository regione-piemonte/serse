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

import { BehaviorSubject, filter, pairwise } from 'rxjs';
import { Injectable } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, NavigationEnd, Router, RoutesRecognized } from '@angular/router';
import { Location } from '@angular/common';
import { Breadcrumb } from '@shared/model/breadcrumb.model';

@Injectable({
  providedIn: 'root'
})
export class BreadcrumbService {

  // Subject emitting the breadcrumb hierarchy
  private readonly _breadcrumbs$ = new BehaviorSubject<any[]>([]);
  // Observable exposing the breadcrumb hierarchy
  readonly breadcrumbs$ = this._breadcrumbs$.asObservable();

  //-Build dei path
  private readonly dashBPath = '/dashboard';
  private readonly modelloPath = `${this.dashBPath}/modello`;
  private readonly gModelloPath = `${this.modelloPath}/gestione`;
  private readonly nModelloPath = `${this.modelloPath}/nuovo`;

  private readonly interventoPath = `${this.dashBPath}/intervento`;
  private readonly gInterventoPath = `${this.interventoPath}/gestione`;
  private readonly nInterventoPath = `${this.interventoPath}/nuovo`;

  private readonly servizioPath = `${this.dashBPath}/servizio`;
  private readonly gServizioPath = `${this.servizioPath}/gestione`;
  private readonly nServizioPath = `${this.servizioPath}/nuovo`;

  private readonly strumentiPath = `${this.dashBPath}/strumenti`;

  //-I Path che usero per resettare il BreadCrumb
  private readonly resetPath = [this.gModelloPath, this.nModelloPath,
                                this.gInterventoPath,this.nInterventoPath,
                                this.gServizioPath,this.nServizioPath,
                                this.strumentiPath]

  private lastId = -1;
  private breadcrumbsList: Breadcrumb[] = [];
  lastUrl = "";

  constructor(private router: Router) {
    this.router.events.pipe(
      // Filter the NavigationEnd events as the breadcrumb is updated only when the route reaches its end
      filter((event) => event instanceof NavigationEnd)
    ).subscribe(event => {
      // Construct the breadcrumb hierarchy
      this.addBreadcrumb();
      // Emit the new hierarchy
      this._breadcrumbs$.next(this.breadcrumbsList);
    });

    this.router.events
    .pipe(filter((evt: any) => evt instanceof RoutesRecognized), pairwise())
    .subscribe((events: RoutesRecognized[]) => {
      this.lastUrl = events[0].urlAfterRedirects;
    });
  }


  private readonly CLASS_A = 'breadcrumb-item active';
  private readonly CLASS_NA = 'breadcrumb-item';

  private addBreadcrumb() {
    let path = this.router.url;
    let breadCrumb: Breadcrumb = {
      label: this.getLabelByUrl(this.router.url),
      url: this.router.url,
      active: true,
      class: this.CLASS_A
    }
    if(this.resetPath.includes(path)){ //-Reset
      this.breadcrumbsList = [];
      this.lastId = -1;
      this.addBreadCrumb(breadCrumb);
      return;
    }

    if(this.breadcrumbsList.length != 0){
      let i = this.breadcrumbsList.findIndex(bc=>bc.url == path);
      if(i!=-1){
        this.breadcrumbsList = this.breadcrumbsList.slice(0, i + 1);

        this.breadcrumbsList[i].class = this.CLASS_A;
        this.breadcrumbsList[i].active = true;
        this.lastId = i;
        return;
      }
    }

    this.addBreadCrumb(breadCrumb);
  }

  addBreadCrumb(breadCrumb: Breadcrumb){
    this.breadcrumbsList.push(breadCrumb);
    if(this.lastId != -1){
      this.breadcrumbsList[this.lastId].class = this.CLASS_NA;
      this.breadcrumbsList[this.lastId].active = false;
    }
    this.lastId+=1;
  }

  getLabelByUrl(url:string): string{
    if(url.endsWith("gestione")){
      if(url.includes("modello")) return "Gestione modello";
      if(url.includes("intervento")) return "Gestione intervento";
      if(url.includes("servizio")) return "Gestione servizio";
      // if(url.includes("incontri")) return "incontro";
    }
    if(url.endsWith("nuovo") || url.endsWith("form")){
      if(url.includes("modello")) return "modello";
      if(url.includes("intervento")) return "intervento";
      if(url.includes("incontri")) return "incontro";
      if(url.includes("servizio")) return "servizio";
    }

    if(url.endsWith("enti")) return "enti";
    if(url.includes("destinatari")) return "destinatari";
    if(url.includes("luogo")) return "luogo";
    else return "ti sei perso";
  }

  getBreadcrumbsList(): Array<Breadcrumb>{
    return this.breadcrumbsList;
  }

}
