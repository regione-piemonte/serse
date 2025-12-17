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
import { RouterModule } from '@angular/router';

// Modules
import { SharedModule } from '@shared/shared.module';

// Components
import { HomeComponent } from './components/home/home.component';
import { TemplateComponent } from './components/template/template.component';
import { SelectRuoloComponent } from './components/select-ruolo/select-ruolo.component';
import { SelectAvvisoComponent } from './components/select-avviso/select-avviso.component';
import { SideNavbarComponent } from './components/side-navbar/side-navbar.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { LoadingIndicatorComponent } from './components/loading-indicator/loading-indicator.component';
import { SelectActionComponent } from './components/select-action/select-action.component';
import { CardSectionComponent } from './components/card-section/card-section.component';

// Pipes
import { GetFirstWordPipe } from './pipes/get-first-word.pipe';
import { WidgetErrorComponent } from './components/widget-error/widget-error.component';
import { AiutoModule } from '../aiuto/aiuto.module';


const components = [
  HomeComponent,
  TemplateComponent,
  SideNavbarComponent,
  ToolbarComponent,
  SelectRuoloComponent,
  SelectAvvisoComponent,
  SelectActionComponent,
  CardSectionComponent,
  WidgetErrorComponent,
  LoadingIndicatorComponent,
];

const pipes = [
  GetFirstWordPipe,
]

@NgModule({
  declarations: [
    components,
    pipes
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    AiutoModule
  ],
  exports: []
})
export class HomeModule { }
