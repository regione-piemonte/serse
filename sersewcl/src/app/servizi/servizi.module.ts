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


// CUSTOME MODULE
import { SharedModule } from '@shared/shared.module';

//CUSTOME COMPONENTS
import { ServizioNuovoComponent } from './components/servizio-nuovo/servizio-nuovo.component';
// import { ServizioIdentificativiComponent } from './components/servizio-identificativi/servizio-identificativi.component';
import { ServizioCorrelatiComponent } from './components/servizio-correlati/servizio-correlati.component';
import { ServizioSpesaComponent } from './components/servizio-spesa/servizio-spesa.component';
import { ServizioIncontriComponent } from './components/servizio-incontri/servizio-incontri.component';
import { ServizioDestinatariComponent } from './components/servizio-destinatari/servizio-destinatari.component';
import { ServizioGestioneComponent } from './components/servizio-gestione/servizio-gestione.component';
import { EntiGestioneComponent } from '@shared/components/enti-gestione/enti-gestione.component';
import { DestinatariGestioneComponent } from '@shared/components/destinatari-gestione/destinatari-gestione.component';


const routes: Routes = [
  {path: 'gestione', component:ServizioGestioneComponent},
  {path: 'nuovo', component:ServizioNuovoComponent},
  {path: 'form',component:ServizioNuovoComponent},
  {path: 'fromIntervento', children:[
    {path: 'nuovo', component:ServizioNuovoComponent},
    {path: 'form',component:ServizioNuovoComponent},
  ]},

  {path: 'enti',component:EntiGestioneComponent},
  {path: 'destinatari', component:DestinatariGestioneComponent},
  {path: 'incontri', children:[
    {
      path: '',
              loadChildren: () =>
                import('../incontri/incontri.module')
                .then(m => m.IncontriModule)
      }
  ]},
  {path: '**', redirectTo:'gestione'}
];

const components = [
  ServizioNuovoComponent,
  ServizioCorrelatiComponent,
  ServizioSpesaComponent,
  ServizioIncontriComponent,
  ServizioDestinatariComponent,
];

@NgModule({
  declarations: [
    components,
    ServizioGestioneComponent,
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
export class ServiziModule { }
