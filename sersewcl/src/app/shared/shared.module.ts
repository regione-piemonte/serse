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

import { NgModule , ModuleWithProviders} from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TextMaskModule } from 'angular2-text-mask';

// Material
import { CdkMenuModule } from '@angular/cdk/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSelectModule } from '@angular/material/select';
import { MatTabsModule } from '@angular/material/tabs';
import { MatMenuModule } from '@angular/material/menu';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatStepperModule } from '@angular/material/stepper';
import { MatListModule } from '@angular/material/list';
import { MatRadioModule } from '@angular/material/radio';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';

import {DragDropModule} from '@angular/cdk/drag-drop';

// Custom components
import { InfoSceltaComponent } from './components/info-scelta/info-scelta.component';
import { TargetDestinatariComponent } from './components/target-destinatari/target-destinatari.component';
import { CaratteristicheComponent } from './components/caratteristiche/caratteristiche.component';
import { EntiCoinvoltiComponent } from './components/enti-coinvolti/enti-coinvolti.component';
import { TipologieDiServiziComponent } from './components/tipologie-di-servizi/tipologie-di-servizi.component';
import { DatiGeneraliComponent } from './components/dati-generali/dati-generali.component';
import { DatiRiferimentoComponent } from './components/dati-riferimento/dati-riferimento.component';
import { TableComponent } from './components/table/table.component';
import { CriteriRicercaComponent } from './components/criteri-ricerca/criteri-ricerca.component';
import { DialogConfermaComponent } from './components/dialog-conferma/dialog-conferma.component';
import { EntiGestioneComponent } from './components/enti-gestione/enti-gestione.component';
import { BackToBarComponent } from './components/back-to-bar/back-to-bar.component';
import { DialogEntiComponent } from './components/dialog-enti/dialog-enti.component';
import { DestinatariGestioneComponent } from './components/destinatari-gestione/destinatari-gestione.component';
import { DialogDestinatarioComponent } from './components/dialog-destinatario/dialog-destinatario.component';

import { ControlMessagesComponent } from './utils/validation';
import { CastFromControlPipe } from './pipe/cast-from-control.pipe';
import { EllipsisPipe } from './pipe/ellipsis.pipe';
import { DialogOperatoriComponent } from './components/dialog-operatori/dialog-operatori.component';
import { ToStringPipe } from './pipe/to-string.pipe';
import { DialogDatiParticolariComponent } from './components/dialog-dati-particolari/dialog-dati-particolari.component';
import { DialogServiziPerDestinatarioComponent } from './components/dialog-servizi-per-destinatario/dialog-servizi-per-destinatario.component';
import { DialogLuoghiIncontroComponent } from './components/dialog-luoghi-incontro/dialog-luoghi-incontro.component';
import { InfoSalvataggioComponent } from './components/info-salvataggio/info-salvataggio.component';
import { LocalStringaPipe } from './pipe/local-string.pipe';
import { CustomDatePipe } from './pipe/custom-date.pipe';
import { ReplaceSpacePipe } from './pipe/replace-space.pipe';
import { InfoGamComponent } from './components/info-gam/info-gam.component';
import { DatiIdentificativiComponent } from './components/dati-identificativi/dati-identificativi.component';
import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import { TabClickInterceptorDirective } from './directives/tab-click-interceptor.directive';


const materialModules = [
  MatIconModule,
  MatButtonModule,
  MatCardModule,
  MatDialogModule,
  MatExpansionModule,
  MatToolbarModule,
  MatSidenavModule,
  MatTabsModule,
  MatStepperModule,
  MatTableModule,
  MatSortModule,
  MatSnackBarModule,
  MatSelectModule,
  MatProgressSpinnerModule,
  MatPaginatorModule,
  MatInputModule,
  MatCardModule,
  MatListModule,
  MatRadioModule,
  MatCheckboxModule,
  MatTooltipModule,
  MatMenuModule,
  MatGridListModule,
  MatDatepickerModule,
  DragDropModule,

  //CDK
  CdkMenuModule,
];

const components = [
  InfoSceltaComponent,
  TargetDestinatariComponent,
  CaratteristicheComponent,
  EntiCoinvoltiComponent,
  TipologieDiServiziComponent,
  DatiGeneraliComponent,
  DatiRiferimentoComponent,
  TableComponent,
  CriteriRicercaComponent,
  DialogConfermaComponent,
  EntiGestioneComponent,
  BackToBarComponent,
  DialogEntiComponent,
  DestinatariGestioneComponent,
  DialogDestinatarioComponent,
  DialogOperatoriComponent,
  DialogDatiParticolariComponent,
  ControlMessagesComponent,
  DialogDatiParticolariComponent,
  DialogServiziPerDestinatarioComponent,
  DialogLuoghiIncontroComponent,
  InfoSalvataggioComponent,
  InfoGamComponent,
  DatiIdentificativiComponent,
  BreadcrumbComponent,
]

const modules = [
  FormsModule,
  ReactiveFormsModule,
  TextMaskModule
]

const pipes = [
  CastFromControlPipe,
  EllipsisPipe,
  ToStringPipe,
  LocalStringaPipe,
  CustomDatePipe,
  ReplaceSpacePipe,
]

const directives = [
  TabClickInterceptorDirective
]

@NgModule({
  declarations: [components, pipes, directives],

  imports: [
    CommonModule,
    RouterModule,
    materialModules,
    modules],

  exports: [materialModules,
            components,
            modules,
            pipes,
            directives],
})
export class SharedModule {
  static forRoot(): ModuleWithProviders<SharedModule> {
    return {
        ngModule: SharedModule,
        //providers: [services, guards]
    };
}
}
