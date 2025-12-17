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
import { RouterModule, Routes } from '@angular/router';

// components
import { TemplateComponent } from '@home/components/template/template.component';
import { HomeComponent } from '@home/components/home/home.component';
import { SelectRuoloComponent } from '@home/components/select-ruolo/select-ruolo.component';
import { SelectAvvisoComponent } from '@home/components/select-avviso/select-avviso.component';
import { SelectActionComponent } from '@home/components/select-action/select-action.component';
import { SideNavbarComponent } from '@home/components/side-navbar/side-navbar.component';


const routes: Routes = [
  {
    path: '', children:[
      {
        path: '', component: TemplateComponent, children: [

          //Home
          { path: 'home', component:HomeComponent,
          children:[
            {path: '', component:SelectRuoloComponent},
            {path: '2', component:SelectAvvisoComponent},
            {path: '3', component:SelectActionComponent},
            {path: '**', redirectTo:''}
          ]},

          //SidNavBar
          { path: 'dashboard', component:SideNavbarComponent, children:[
            { path: 'modello',
              loadChildren: () =>
                import('./modelli-di-intervento/modelli-di-intervento.module')
                .then(m => m.ModelliDiInterventoModule)
            },
            { path: 'intervento',
              loadChildren: () =>
                import('./interventi/interventi.module')
                .then(m => m.InterventiModule)
            },
            { path: 'servizio',
              loadChildren: () =>
                import('./servizi/servizi.module')
                .then(m => m.ServiziModule)
            },
            { path: 'strumenti',
              loadChildren: () =>
                import('./strumenti/strumenti.module')
                .then(m => m.StrumentiModule)
            },

            {path: '**', redirectTo:'home/3'}
          ]},

          //help section
          { path: 'help',
              loadChildren: () =>
                import('./aiuto/aiuto.module')
                .then(m => m.AiutoModule)
            },


          { path: '**', redirectTo:'home'}
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
