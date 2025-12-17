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

import { Component, EventEmitter, Input, OnChanges, OnInit, Output, QueryList, SimpleChanges, ViewChildren } from '@angular/core';
import { ItemHelp } from '../../models/item-help.model';
import { Caricamento_Excel_HELP, Incontro_HELP, Intervento_HELP, Modello_HELP, Servizio_HELP } from '../../const/list-help.const';
import { MatExpansionPanel } from '@angular/material/expansion';
import { BehaviorSubject } from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-guide',
  templateUrl: './guide.component.html',
  styleUrls: ['./guide.component.scss']
})
export class GuideComponent implements OnInit, OnChanges {


  @Input("categoria") categoria!:string;

  guideList: ItemHelp[] = [];

  prova:any;

  constructor(
    private sanitizer: DomSanitizer,
  ) { }

  ngOnInit(): void {
    this.updateGuide();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(changes["categoria"]){
      this.updateGuide();
    }
    if(changes["indice"]){
      if(this.indice!=-1){
        this.openPanelByIndex(this.indice); //-Quando sono nella stessa pagina
        this.mioIndice = this.indice;

      }
    }
  }

  updateGuide(){
    switch(this.categoria){
      case "Modelli di intervento":
        this.guideList = Modello_HELP;
        break;
      case "Interventi":
        this.guideList = Intervento_HELP;
        break;
      case "Servizi":
        this.guideList = Servizio_HELP;
        break;
      case "Incontri":
        this.guideList = Incontro_HELP;
        break;
      case "Caricamento da file":
        this.guideList = Caricamento_Excel_HELP;
        break;
    }
  }

  @ViewChildren(MatExpansionPanel) panels!: QueryList<MatExpansionPanel>;
  openPanelByIndex(index: number) {
    const panel = this.panels.toArray()[index];
    if (panel) {
      panel.open();
    }
  }

  numPannelliSubject = new BehaviorSubject<number>(0);
  @Output() pannelliPronti = new EventEmitter<void>();
  @Input() indice = -1;
  mioIndice = -1;
  ngAfterViewInit() {
    // Inizializza il numero di pannelli
    this.numPannelliSubject.next(this.panels.length);

    // Osserva i cambiamenti nel numero di pannelli
    this.panels.changes.subscribe(() => {
      // Quando il numero di pannelli cambia, emetti l'evento
      this.numPannelliSubject.next(this.panels.length);
    });

    // Sottoscriviti al BehaviorSubject per emettere l'evento
    this.numPannelliSubject.subscribe(() => {

      if(this.mioIndice != -1 && this.mioIndice == this.indice){
        this.openPanelByIndex(this.mioIndice);
        this.mioIndice=-1;
        this.pannelliPronti.emit();
      }

    });
  }

}
