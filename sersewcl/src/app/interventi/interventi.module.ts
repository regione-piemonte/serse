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
import { Routes, RouterModule } from '@angular/router';

// Custome Modules
import { SharedModule } from '@shared/shared.module';

// Custome Components
import { InterventoNuovoComponent } from './components/intervento-nuovo/intervento-nuovo.component';
import { InterventoCorrelatiComponent } from './components/intervento-correlati/intervento-correlati.component';
import { InterventoServiziComponent } from './components/intervento-servizi/intervento-servizi.component';
import { InterventoGestioneComponent } from './components/intervento-gestione/intervento-gestione.component';
import { AssociazioneModelloInterventoComponent } from './components/associazione-modello-intervento/associazione-modello-intervento.component';
import { DestinatarioInterventoComponent } from './components/destinatario-intervento/destinatario-intervento.component';
import { DestinatariGestioneComponent } from '@shared/components/destinatari-gestione/destinatari-gestione.component';
import { EntiGestioneComponent } from '@shared/components/enti-gestione/enti-gestione.component';


const routes: Routes = [
  {path: 'gestione', component:InterventoGestioneComponent},
  {path: 'nuovo', component:InterventoNuovoComponent},
  {path: 'form', component:InterventoNuovoComponent},
  {path: 'enti', component:EntiGestioneComponent},
  {path: 'destinatari', component:DestinatariGestioneComponent},
  {path: '**', redirectTo:'gestione'},
];

const components = [
  InterventoNuovoComponent,
  InterventoCorrelatiComponent,
  InterventoServiziComponent,
  InterventoGestioneComponent,
  AssociazioneModelloInterventoComponent,
  DestinatarioInterventoComponent,
];

@NgModule({
  declarations: [
    components

  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class InterventiModule { }
