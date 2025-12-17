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

import { Component, OnInit } from '@angular/core';
import { TitleService } from '@core/services/title.service';
import { InterventiService } from '@interventi/services/interventi.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { ServiziService } from '@servizi/services/servizi.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {


  constructor(
    private title: TitleService,

    private modelloService: ModelliService,
    private interventoService: InterventiService,
    private serviziService: ServiziService
  ){}

  ngOnInit(): void {
    this.clearService();
  }

  clearService(){
    this.modelloService.reset();


    this.interventoService.reset();


    this.serviziService.reset();
  }




}
