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

import { Component, OnInit, ViewChild, TemplateRef, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable, of } from 'rxjs';

//-Models
import { TargetDestinatario } from '@core/api-serse/model/targetDestinatario';
import { Caratteristica } from '@core/api-serse/model/caratteristica';
import { CheckCaratteristica } from '@shared/model/check-carratteristica';
import { CaratteristicheAssociate } from '@core/api-serse/model/caratteristicheAssociate';
import { CaratteristicheServizio } from '@core/api-serse/model/caratteristicheServizio';

//-Services
import { HomeBagService } from '@home/services/home-bag.service';
import { ModelliService } from '@modelli/services/modelli.service';

@Component({
  selector: 'app-caratteristiche',
  templateUrl: './caratteristiche.component.html',
  styleUrls: ['./caratteristiche.component.scss']
})
export class CaratteristicheComponent implements OnInit, OnChanges {

  @Input() caratteristiche$: Observable<Caratteristica[]> = of([]);
  @Input() caratteristicheAssociate$: Observable<Caratteristica[]> = of([]);


  @Input() isModificabile!: boolean;
  @Input() id!: number;


  @Input() userCase!: string;
  @Input() idPso!: number;
  @Input() codFisc!: string;

  @Input() titolo:string="Caratteristiche";

  @Output() cancellaCaratteristiche: EventEmitter<CaratteristicheAssociate[]> = new EventEmitter();
  @Output() salvaCaratteristiche: EventEmitter<CaratteristicheAssociate[]> = new EventEmitter();

  caratteristicheAssociate: Caratteristica[]=[];

  caratteristicheChecked:      CheckCaratteristica[]=[];
  caratteristicheCheckedCopia: CheckCaratteristica[]=[];

  //-List caratteristiche da inserire e da eliminare
  caratteristicheDaInserire:  CaratteristicheAssociate[]|CaratteristicheServizio =[];
  caratteristicheDaCancellare:CaratteristicheAssociate[]|CaratteristicheServizio =[];

  // modale
  @ViewChild('caratteristiche') caratteristiche!: TemplateRef<any>;
  allComplete: boolean = false;


  constructor(private dialog: MatDialog) { }

  ngOnChanges(changes: SimpleChanges): void {
    if(this.caratteristicheAssociate$ && changes['caratteristicheAssociate$']){
      this.caratteristicheAssociate$.subscribe(risposta=>{
          risposta.sort((a,b)=>a.descrCaratteristica!.localeCompare(b.descrCaratteristica!))
          this.caratteristicheAssociate=risposta}
      )
    }
  }

  ngOnInit(): void {
    if(this.caratteristicheAssociate$)
      this.caratteristicheAssociate$.subscribe(risposta=>{
          risposta.sort((a,b)=>a.descrCaratteristica!.localeCompare(b.descrCaratteristica!))
          this.caratteristicheAssociate=risposta}
        )
  }

  isAssociato( id: number): boolean{
    return this.caratteristicheAssociate.find(a=>a.idCaratteristica==id)? true : false
  }


  mapDataToCheckCaratteristiche(data:Caratteristica[]):CheckCaratteristica[]{
    return data.map(a=>
              {return{ idCaratteristica: a.idCaratteristica,
                        descrCaratteristica: a.descrCaratteristica,
                        completed: this.isAssociato(a.idCaratteristica!)
              }})
  }

  //Apri modale
   apriModale(){
    this.caratteristiche$.subscribe(
      data=>{
        data.sort((a,b)=>a.descrCaratteristica!.localeCompare(b.descrCaratteristica!))

        this.caratteristicheChecked = this.mapDataToCheckCaratteristiche(data);
        this.caratteristicheCheckedCopia = this.mapDataToCheckCaratteristiche(data);

        this.dialog.open(this.caratteristiche, {
          maxHeight: "800px",
          width: "540px",
          panelClass: "ClasseCss",
        });
      }
    )

  }

  updateAllComplete() {
    this.allComplete = this.caratteristicheChecked != null
                    && this.caratteristicheChecked.every(t => t.completed);
  }
  someComplete(): boolean {
    if (this.caratteristicheChecked == null) {
      return false;
    }
    return this.caratteristicheChecked.filter(t => t.completed).length > 0 && !this.allComplete;
  }
  setAll(completed: boolean) {
    this.allComplete = completed;
    if (this.caratteristicheChecked == null) {
      return;
    }
    this.caratteristicheChecked.forEach(t => (t.completed = completed));
  }

  aggiorna(){
    this.caratteristicheDaInserire=[];
    this.caratteristicheDaCancellare=[];

    for(let i=0; i<this.caratteristicheChecked.length;i++){
      if(this.caratteristicheChecked[i].completed!==this.caratteristicheCheckedCopia[i].completed){
        if(this.caratteristicheCheckedCopia[i].completed){
          if(this.userCase==="MDI")
            this.caratteristicheDaCancellare.push(
              this.createCaratteristicaAssociata(this.createCaratteristicaFromSample(this.caratteristicheCheckedCopia[i])))
          if(this.userCase==="SER")
            this.caratteristicheDaCancellare.push(
              this.createCaratteristicaServizio(this.createCaratteristicaFromSample(this.caratteristicheCheckedCopia[i])))
        }else{
          if(this.userCase==="MDI")
            this.caratteristicheDaInserire.push(
                this.createCaratteristicaAssociata(this.createCaratteristicaFromSample(this.caratteristicheCheckedCopia[i])))
          if(this.userCase==="SER")
            this.caratteristicheDaInserire.push(
                this.createCaratteristicaServizio(this.createCaratteristicaFromSample(this.caratteristicheCheckedCopia[i])))
        }
      }
    }


    if(this.caratteristicheDaCancellare.length>0){
      this.cancellaCaratteristiche.emit(this.caratteristicheDaCancellare)
    }

    if(this.caratteristicheDaInserire.length>0){
      this.salvaCaratteristiche.emit(this.caratteristicheDaInserire)
    }
  }



  createCaratteristicaFromSample(caratteristica: CheckCaratteristica): Caratteristica{
    return{
      idCaratteristica: caratteristica.idCaratteristica,
      descrCaratteristica: caratteristica.descrCaratteristica
    }
  }

  createCaratteristicaAssociata(caratteristica:Caratteristica):CaratteristicheAssociate{
    return{
      idPso: this.idPso,
      idModelloDiIntervento: this.id,
      codiceFiscaleUtente: this.codFisc,
      caratteristica:caratteristica
    }
  }
  createCaratteristicaServizio(caratteristica:Caratteristica):CaratteristicheServizio{
    return{
      idPso: this.idPso,
      idServizio: this.id,
      codiceFiscaleUtente: this.codFisc,
      caratteristica:caratteristica
    }
  }

}
