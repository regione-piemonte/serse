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

import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { Observable, concatMap, map, of } from 'rxjs';

// Models
import { SimpleTargetDestinatari } from '@shared/model/simple-target-destinatari.model';
import { TargetDestinatariAssociati } from '@core/api-serse/model/targetDestinatariAssociati';
import { TargetDestinatario } from '@core/api-serse/model/targetDestinatario';

// Services
import { HomeBagService } from '@home/services/home-bag.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { TargetDestinatariServizio } from '@core/api-serse/model/targetDestinatariServizio';
import { ServiziService } from '@servizi/services/servizi.service';



@Component({
  selector: 'app-target-destinatari',
  templateUrl: './target-destinatari.component.html',
  styleUrls: ['./target-destinatari.component.scss']
})
export class TargetDestinatariComponent implements OnInit, OnChanges {

  @Input() targetDestinatariElenco$: Observable<TargetDestinatario[]>=of([]);
  @Input() targetDestinatariAssociatiElenco$: Observable<TargetDestinatario[]>=of([]);
  @Input() isModificabile = true;

  @Input() titolo:string="Target destinatari";

  targetDestinatariAssociati : TargetDestinatario[] = [];

  targetDestinatariChecked: SimpleTargetDestinatari[]=[];
  targetDestinatariCheckedCopia: SimpleTargetDestinatari[]=[];

  targetDaInserire:TargetDestinatariAssociati[]|TargetDestinatariServizio[] = [];
  targetDaCancellare: TargetDestinatariAssociati[]|TargetDestinatariServizio[] = [];

  @Output() elencoTargetDaCancellare:EventEmitter<TargetDestinatariAssociati[]|TargetDestinatariServizio[]>= new EventEmitter();
  @Output() elencoTargetDaInserire:  EventEmitter<TargetDestinatariAssociati[]|TargetDestinatariServizio[]>= new EventEmitter();


  // modale
  @ViewChild('provaModale') provaModale!: TemplateRef<any>;
  allComplete: boolean = false;

  constructor(
    public dialog: MatDialog,
    private bagService:HomeBagService,
    private modelliService: ModelliService,
    private serviziService: ServiziService
    ) { }



  ngOnInit(): void {

    if(this.targetDestinatariAssociatiElenco$)
      this.targetDestinatariAssociatiElenco$.subscribe(risposta => this.targetDestinatariAssociati = risposta);
  }

  ngOnChanges(changes: SimpleChanges): void {
      if(this.targetDestinatariAssociatiElenco$ && changes["targetDestinatariAssociatiElenco$"]){
        this.targetDestinatariAssociatiElenco$.subscribe(risposta => this.targetDestinatariAssociati = risposta);
      }
  }

  isAssociato( id: number): boolean{
    return this.targetDestinatariAssociati.find(a => a.idTargetDestinatario == id) ? true : false;
  }

  //Apri modale
  openModal(){
    this.targetDestinatariElenco$.subscribe(
      risposta => {
        risposta.sort((a,b)=>a.descrDestinatario!.localeCompare(b.descrDestinatario!))
        this.targetDestinatariChecked = risposta.map(
          a => {return {
                        id: a.idTargetDestinatario,
                        descrizione: a.descrDestinatario,
                        completed: this.isAssociato(a.idTargetDestinatario!),
                      }}

        )

        this.targetDestinatariCheckedCopia=risposta.map(
          a => {return {
                        id: a.idTargetDestinatario,
                        descrizione: a.descrDestinatario,
                        completed: this.isAssociato(a.idTargetDestinatario!),
                      }}

        )
        this.dialog.open(this.provaModale, {
          panelClass: "dialog-card",
        });
      })
  }

  updateAllComplete() {
    this.allComplete = this.targetDestinatariChecked.every(t=>t.completed);
  }
  someComplete(): boolean {
    if (this.targetDestinatariChecked == null) {
      return false;
    }
    return this.targetDestinatariChecked.filter(t => t.completed).length > 0 && !this.allComplete;
  }
  setAll(completed: boolean) {
    this.allComplete = completed;
    if (this.targetDestinatariChecked == null) {
      return;
    }
    this.targetDestinatariChecked.forEach(t => (t.completed = completed));
  }
  aggiorna() {
    this.targetDaCancellare=[];
    this.targetDaInserire=[];
    for(let i=0; i<this.targetDestinatariChecked.length;i++){
        if(this.targetDestinatariChecked[i].completed!=this.targetDestinatariCheckedCopia[i].completed){
          if(this.bagService.userCase=="MDI"){
          if(this.targetDestinatariCheckedCopia[i].completed){

            this.targetDaCancellare.push(this.createTargetDestinatarioAssociato
              (this.createTargetDestinatarioFromSample(this.targetDestinatariCheckedCopia[i])));
          }else{
            this.targetDaInserire.push(
              this.createTargetDestinatarioAssociato(
                this.createTargetDestinatarioFromSample(this.targetDestinatariCheckedCopia[i])))
          }
        }
        if(this.bagService.userCase=="SER"){
          if(this.targetDestinatariCheckedCopia[i].completed){
          this.targetDaCancellare.push(this.createTargetDestinatarioServizio
              (this.createTargetDestinatarioFromSample(this.targetDestinatariCheckedCopia[i])));
          }else{
            this.targetDaInserire.push(
              this.createTargetDestinatarioServizio(
                this.createTargetDestinatarioFromSample(this.targetDestinatariCheckedCopia[i])))
              }
        }
        }
    }

    if(this.targetDaCancellare.length>0){
      this.elencoTargetDaCancellare.emit(this.targetDaCancellare);
    }

    if(this.targetDaInserire.length>0){
        this.elencoTargetDaInserire.emit(this.targetDaInserire);
      }

  }

  createTargetDestinatarioFromSample(sample:SimpleTargetDestinatari):TargetDestinatario{
    return{
      idTargetDestinatario: sample.id,
      descrDestinatario: sample.descrizione
    }
  }

  createTargetDestinatarioAssociato(targetDestinatario: TargetDestinatario):TargetDestinatariAssociati{
    return {
      targetdestinatario: targetDestinatario,
      idPso: this.bagService.selectedPso.idPso,
      idModelloDiIntervento: this.modelliService.modelloIntervento.idModelloIntervento,
      codiceFiscaleUtente: this.bagService.userInfo.codFisc
    }
  }

  createTargetDestinatarioServizio(targetDestinatario: TargetDestinatario):TargetDestinatariServizio{
    return{
      targetdestinatario:targetDestinatario,
      idPso: this.bagService.selectedPso.idPso,
      codiceFiscaleUtente: this.bagService.userInfo.codFisc,
      idServizio: this.serviziService.servizio.idServizio
    }
  }
}


