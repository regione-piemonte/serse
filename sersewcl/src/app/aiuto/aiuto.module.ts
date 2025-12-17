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

import { AiutoComponent } from './components/aiuto/aiuto.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '@shared/shared.module';
import { GuideComponent } from './components/guide/guide.component';
import { DialogAiutoComponent } from './components/dialog-aiuto/dialog-aiuto.component';


// const routes: Routes = [
//   { path: '', component: AiutoComponent}
// ];


const components = [
  AiutoComponent,
  GuideComponent,
  DialogAiutoComponent
]

@NgModule({
  declarations: [ components ],
  imports: [
    CommonModule,
    // RouterModule.forChild(routes),
    SharedModule
  ],
  exports: [components]
})
export class AiutoModule { }
