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

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

// Costume module
import { SharedModule } from '@shared/shared.module';

//routing
import { RouterModule, Routes } from '@angular/router';

// Services
import { CriteriModelliRicercaService } from './services/criteri-modelli-ricerca.service';
import { ModelliBagService } from './services/modelli-bag.service';

//Costume components
import { ModelloNuovoComponent } from './components/modello-nuovo/modello-nuovo.component';
import { ModelloCorrelatiComponent } from './components/modello-correlati/modello-correlati.component';
import { ModelloGestioneComponent } from './components/modello-gestione/modello-gestione.component';
import { EntiGestioneComponent } from '@shared/components/enti-gestione/enti-gestione.component';
import { ModelloInterventiComponent } from './components/modello-interventi/modello-interventi.component';

const routes: Routes = [
  {path: 'gestione', component:ModelloGestioneComponent,},
  {path: 'nuovo', component:ModelloNuovoComponent,},
  {path: 'form', component:ModelloNuovoComponent,},

  {path: 'enti', component:EntiGestioneComponent,},

  {path: '**', redirectTo:'gestione'},
];

const components = [
  ModelloNuovoComponent,
  ModelloCorrelatiComponent,
  ModelloGestioneComponent
];

@NgModule({
  declarations: [
    components,
    ModelloInterventiComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ],
  providers: [
    CriteriModelliRicercaService,
    ModelliBagService
  ]
})
export class ModelliDiInterventoModule { }
