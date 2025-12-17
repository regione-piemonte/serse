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

import { Directive, ElementRef, EventEmitter, HostListener, Output } from '@angular/core';
import { MatTabGroup } from '@angular/material/tabs';

@Directive({
  selector: '[appTabClickInterceptor]'
})
/**
 * QUESTA DIRETTIVA E' STATA PENSATA PER VERIFICARE SE L'UTENTE CAMBIA TAB IN UN MAT-TAB-GROUP CON DATI NON SALVATI
 *
 * L'evento tabClick viene sollevato se e solo se l'utente ha cliccato su  un tab diverso da quello corrente
 */
export class TabClickInterceptorDirective {

  @Output() tabClick = new EventEmitter<TabClickInterceptorEvent>();

  constructor(private tabGroup: MatTabGroup, private el: ElementRef) {}

  @HostListener('mousedown', ['$event'])
  onClick($event: MouseEvent) {
    if (this.isTabHeaderClick($event)) {
      const index = this.getTabIndexFromEvent($event);
      if (index !== null && index != this.tabGroup.selectedIndex && !this.tabGroup._allTabs.get(index)?.disabled) {

        this.tabClick.emit({
          target: $event.target as HTMLElement,
          tabIndex: index,
          preventDefault: () => {
            // Blocca il comportamento default di Material
            $event.stopPropagation();
            $event.preventDefault();
          }
        });
      }
    }
  }

  private isTabHeaderClick(event: MouseEvent): boolean {
    const tabHeader = this.el.nativeElement.querySelector('mat-tab-header');
    return tabHeader && tabHeader.contains(event.target as Node);
  }

  private getTabIndexFromEvent($event: MouseEvent): number | null {

    const target = $event.target as HTMLElement;
    if (!target) {
      return null;
    }
    const label: HTMLElement = target.closest('div.mat-tab-label')!;
    if (label.id.startsWith("mat-tab-label-")) {
      return Array.from(label.parentElement!.children).indexOf(label);
    }
    return null;
  }

}

export class TabClickInterceptorEvent {
  constructor(
    public target: HTMLElement,
    public tabIndex: number,
    public preventDefault: () => void
  ) {}
}
