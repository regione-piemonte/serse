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

import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-widget-error',
 // standalone: true,
  template: `
    <div mat-dialog-content
        class="row mb-2">
      <div class="d-flex alert flex-column"
            [ngClass]="contentClass">
        <h5> {{title}}: </h5>

        <span *ngFor="let msg of message">{{msg}} <br></span>
      </div>
    </div>
    <!-- <p class="message">{{error?.message}}</p> -->
  `,
  styles: [`
    /* :host { padding: 5px 15px;
            box-sizing: border-box;
            display: block;
            color: red;
            background-color: #ffe2e2; } */
    p, h5 { margin: 0 }
    /* p {font-size: 10px} */
    h5 { margin-bottom: 3px; font-size: 12px }
  `]
})
export class WidgetErrorComponent {
  // @Input()error: Error | null = null;

  @Input() title: string = "";
  @Input() message: string[] = [];
  @Input() contentClass: string = "";



}
