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
import { RouterModule, Routes } from '@angular/router';

//- Components
import { NuovoIncontroComponent } from './components/nuovo-incontro/nuovo-incontro.component';
import { PartecipantiIncontroComponent } from './components/partecipanti-incontro/partecipanti-incontro.component';
import { LuogoIncontroComponent } from './components/luogo-incontro/luogo-incontro.component';
import { AggiungiLuogoIncontroComponent } from './components/aggiungi-luogo-incontro/aggiungi-luogo-incontro.component';

//-Modules
import { SharedModule } from '@shared/shared.module';

const routes: Routes = [
  {path:'nuovo',component: NuovoIncontroComponent},
  {path:'form',component: NuovoIncontroComponent},
  {path:'luogo', component: AggiungiLuogoIncontroComponent},
]


const components = [
  NuovoIncontroComponent,
  PartecipantiIncontroComponent,
  LuogoIncontroComponent,
  AggiungiLuogoIncontroComponent
]

@NgModule({
  declarations: [ components ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class IncontriModule { }
