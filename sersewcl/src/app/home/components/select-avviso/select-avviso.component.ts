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

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, Validators } from '@angular/forms';

// Model
import { TipologiaPso } from '@core/api-serse/model/tipologiaPso';
import { Pso } from '@core/api-serse/model/pso';
import { Sportello } from '@core/api-serse/model/sportello';
import { PsoRistretto } from '@core/api-serse/model/psoRistretto';

// Services
import { HomeBagService } from '@home/services/home-bag.service';
import { AvvisiService } from '@home/services/avvisi.service';
import { Observable, catchError, map, of, tap } from 'rxjs';
import { TitleService } from '@core/services/title.service';

@Component({
  selector: 'app-select-avviso',
  templateUrl: './select-avviso.component.html',
  styleUrls: ['./select-avviso.component.scss']
})
export class SelectAvvisoComponent implements OnInit {

  // Temporanei finche non ho i dati
  // poi si andrà ad utilizzare FormBuilder


  avvisoForm = this.formBuilder.group({
    tipologiaPsoForm: ['', Validators.required],
    ammECicloForm:['', Validators.required],
    sportelloForm:['', Validators.required]
  });

  // inzializzato nel ngOnInit
  codOperatore! :string;
  grpOperatore! :string;

  psoAmmCicloList: PsoRistretto[] = [];
  sportelloList: Sportello[] = [];

  error: Error | null = null;
  zeroAvviso = false;

  tipologiePSo$!: Observable <TipologiaPso[]>

  // Pipe Handling
  tapPipe = {
    error: (error:any)=>{
                    this.error = new Error("“Non è stato possibile recuperare le informazioni per un problema nei servizi. Si prega di riprovare più tardi o contattare l’assistenza”");
                  }
  }

  catchPipe = (err:any) => {
    this.error = new Error("“Non è stato possibile recuperare le informazioni per un problema nei servizi. Si prega di riprovare più tardi o contattare l’assistenza”");
    return of([]);
  }

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private avvisiService: AvvisiService,
    private homeBag: HomeBagService,
    private title: TitleService,
  ){}

  ngOnInit(): void {
    this.title.setTitle("Selezionare avviso");
    this.title.setIcon("")
    this.avvisoForm.get('ammECicloForm')?.disable()
    this.avvisoForm.get('sportelloForm')?.disable()

    // Caricamento la prima select
    this.codOperatore = this.homeBag.codiceOperatore;
    this.grpOperatore = this.homeBag.gruppoOperatore;

    this.tipologiePSo$ = this.avvisiService
        .getTipologiePSO(this.codOperatore,this.grpOperatore)
        .pipe(
          map(data=>{
              if(data.length === 1){
                this.selectOption("tipologiaPsoForm",data[0].tipologiaPsoId);
                this.selectTipologia(data[0]);
              }
              if(data.length === 0){
                this.zeroAvviso = true;
              }
              return data.map(data=>data)}),
          //tap(this.tapPipe),
          catchError(this.catchPipe)
        );
  }


  //#### Manage Form ####
  // Metodo utilizzato per impostare una select a un valore
  selectOption( to:string, value:string|undefined):void {
    let select: string = value === undefined ? '' :value;
    this.avvisoForm.get(to)?.setValue(select);
  }

  //################### Selezione Select 1 ###################
  // Quando seleziono la tipologia
  onSelectionTipologia(tipologia: TipologiaPso, event:any): void{
    if(!event.isUserInput){return}// ignore on deselection of the previous option
    this.selectTipologia(tipologia)
  }
  selectTipologia(tipologia: TipologiaPso){
    this.homeBag.setSelectedTipologiaPSO(tipologia);
    this.updatePSO( tipologia.tipologiaPsoId, tipologia.idAttoIndirizzo);
  }
  // Aggiorno le pso, cioè la seconda select( Amministrazione, Ciclo)
  updatePSO(tipologiaPsoIdSelcted?:string, idAttoIndirizzoSelected?:number): void{
    let tipologiaPsoId = tipologiaPsoIdSelcted ? tipologiaPsoIdSelcted : '';
    let idAttoIndirizzo = idAttoIndirizzoSelected ? idAttoIndirizzoSelected.toString() : '';

    this.avvisiService
        .getPSO( tipologiaPsoId, idAttoIndirizzo, this.codOperatore)
        .pipe(
          map(data=>{
              this.avvisoForm.get('ammECicloForm')?.enable()

              if(data.length === 1){
                this.selectOption("ammECicloForm",data[0].idPso?.toString());
                this.selectPso(data[0]);
              }

              this.error = null;
              return data.map(data=>data)}),
          tap(this.tapPipe),
          catchError(this.catchPipe))
        .subscribe(response => this.psoAmmCicloList = response);
  }

  //################### Selezione Select 2 ###################
  // Quando seleziono Amministratore.. & Ciclo..
  onSelectionPso(pso:PsoRistretto, event:any): void{
    if(!event.isUserInput){return}// ignore on deselection of the previous option
    this.selectPso(pso);
  }
  selectPso(pso:PsoRistretto){
    this.homeBag.setSelectedPso(pso);
    this.updateSportello(pso.idPso);
  }
  updateSportello(idPsoSelected?:number){
    let idPso = idPsoSelected ? idPsoSelected.toString() : '';

    this.avvisiService
        .getSportelli(idPso, this.codOperatore,this.grpOperatore)
        .pipe(
          map(data=>{
              this.avvisoForm.get('sportelloForm')?.enable()

              if(data.length === 1){
                this.selectOption("sportelloForm", data[0].numProgrSportello?.toString());
                this.selectSportello(data[0]);
              }
              this.error = null;
              data.sort((a,b)=>a.dataInizio!>b.dataInizio!?1:-1)
              return data.map(data=>data)}),
          tap(this.tapPipe),
          catchError(this.catchPipe))
        .subscribe(response=> this.sportelloList = response);
  }
  //################### Selezione Select 3 ###################
  onSelectionSportello(sportello:Sportello, event:any): void{
    if(!event.isUserInput){return}// ignore on deselection of the previous option
    this.selectSportello(sportello);
  }
  selectSportello(sportello:Sportello){
    this.homeBag.setSelectedSportello(sportello);
  }

  onConferma(){
    if(this.avvisoForm.invalid){
      this.avvisoForm.markAllAsTouched();
      return;
    }
    this.avvisiService.updateTipoGestioneSportello(this.homeBag.selectedSportello.numProgrSportello!.toString())
    .pipe(tap(this.tapPipe))
    .subscribe(response => {
      this.homeBag.setTipologiaGestioneSportello(response)
      this.router.navigateByUrl('/home/3')});

    // // Dati in locale
    // this._tipologiaGestioneSportello={
    //   tipoGestioneSoggettiRt : "Ok",
    //   flagGestioneModello: "S",  //mostra o meno il menu modello
    //   tipoGestioneIntervento: "OK", //mostra o meno il menu intervento
    //   tipoGestioneServizio: "Ok"   //Non Presente nel Mockup
    // }
  }
}
