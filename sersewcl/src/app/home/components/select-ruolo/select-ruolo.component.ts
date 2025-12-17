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

import { Component, OnInit, EventEmitter } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

// Models
import { InfoOperatore } from '@core/api-serse/model/infoOperatore';
import { Ruolo } from '@core/api-serse/model/ruolo';
import { UserInfo } from '@core/api-serse/model/userInfo';
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';

// Services
import { HomeBagService } from '@home/services/home-bag.service';
import { NotifyTemplateService } from '@home/services/notify-template.service';

// Compares
import { compareOpetatore, compareRuolo } from '@shared/utils/compares';

// MASKS
import { GRUPPO_OPERATORE_MASK, COD_OPERATORE_MASK } from '@shared/utils/text-masks';
import { FlaidoorService } from '@home/services/flaidoor.service';
import { Observable, catchError, map, of, tap, throwError } from 'rxjs';
import { TitleService } from '@core/services/title.service';

@Component({
  selector: 'app-select-ruolo',
  templateUrl: './select-ruolo.component.html',
  styleUrls: ['./select-ruolo.component.scss']
})
export class SelectRuoloComponent implements OnInit {

  gruppoMask = GRUPPO_OPERATORE_MASK;
  operatoreMask = COD_OPERATORE_MASK;

  ruoloForm = this.formBuilder.group({
    ruoloSelect: ['', Validators.required],
    operatoreSelect: ['', Validators.required],
    operatoreGroup: this.formBuilder.group({
      gruppo: ['', Validators.required],
      codice: ['', Validators.required],
    })
  });

  infoOperatoriList: InfoOperatore[] = [];
  //infoOperatoriList$!: Observable<InfoOperatore[]>;
  error: Error | null = null;

  ruoli$!: Observable <Ruolo[]>;
  ruoli!: Ruolo[];


  selectedRuolo!: Ruolo;
  selectedOpert!: InfoOperatore;



  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private homeBagService: HomeBagService,
    private flaidoorService: FlaidoorService,
    private title: TitleService,
  ){}

  ngOnInit(): void {
    this.title.setTitle("Selezionare ruolo");
    this.title.setIcon("")
    this.ruoli$ = this.flaidoorService.getRuoli().pipe(
      map(data => {
        if(data.length == 0){
          this.error = new Error("Nessun Ruolo è stato trovato")
        }
        data.sort( compareRuolo );
        return data.map(data => data);
      }),
      catchError(err => {
         this.error = new Error("Non è possibile contattare il server, riprovare più tardi o contattare l'assistenza")
        return of([]);
      }),
    );

    this.ruoli$.subscribe(risp=> this.ruoli = risp)

    this.ruoloForm.get('operatoreSelect')?.disable();
  }

  // Quando seleziono un ruolo lancio il seguente metodo
  onSelectionRuolo(ruolo:Ruolo, event:any): void{
    this.error = null;
    if(!event.isUserInput){return}// ignore on deselection of the previous option
    this.selectedRuolo = ruolo;
    if(ruolo.codiceRuolo !== 'SERVIZIO_ASSISTENZA_SERSE' && ruolo.codiceRuolo !=='FUNZIONARIO_MASTER_SERSE'){
      this.updateInfoOperatoriList(ruolo.codiceRuolo!);
    }
    this.ruoloForm.get('operatoreSelect')?.enable();
  }
  // Aggiorno la lista in base al ruolo
  updateInfoOperatoriList(codRuolo: string){
    this.flaidoorService.getInfoOperatore(codRuolo)
    .pipe(
      map(data => {
        data.sort(compareOpetatore);
        return data.map(data => data);
      }),
      tap({
        error: (error) => {
          this.error = new Error("Nessun Operatore presente per il ruolo selezionato");
        }
      }),
      catchError(err => {
        return of([]);
      }),)
    .subscribe(risposta => this.infoOperatoriList= risposta);
  }

  // Quando seleziono l'operatore dalla lista
  onSelectionOperatore(infoOperatore: InfoOperatore, event:any): void{
    if(!event.isUserInput){return}// ignore on deselection of the previous option
    // this.homeBagService.setSelectedInfoOperatore(infoOperatore);
    this.selectedOpert = infoOperatore;
  }

  onConferma(){
    if(this.ruoloForm.get('ruoloSelect')?.value === 'SERVIZIO_ASSISTENZA_SERSE' || this.ruoloForm.get('ruoloSelect')?.value ==='FUNZIONARIO_MASTER_SERSE'){
      // contattare il servizio e vedere se ho un ruscontro
      this.caseServizio();
    }
    else{
      this.caseNotServizio();
    }
    this.ruoloForm.markAllAsTouched();
  }

  // in base al caso controllo se posso procedere e procedo se posso
  caseServizio(){
    let gruppo = this.ruoloForm.get('operatoreGroup')?.get('gruppo')?.value;
    let codice = this.ruoloForm.get('operatoreGroup')?.get('codice')?.value;

    if(gruppo === undefined || gruppo === null || gruppo === ''){
      return;
    }
    if(codice === undefined || codice === null || codice === ''){
      return;
    }

    gruppo = gruppo.toUpperCase();
    this.flaidoorService.getPersonaGiuridica(gruppo, codice)
    .pipe(
      tap({
        error: (error) => {
          this.error = new Error("Nessun Operatore trovato per il gruppo e codice selezionato!");
        }
      }),
      catchError(err => {
        return of(null);
      }),)
    .subscribe({
        next: (response) => {
          if(response === null){
            return
          }
          if(this.ruoloForm.get('ruoloSelect')?.value === 'SERVIZIO_ASSISTENZA_SERSE' || this.ruoloForm.get('ruoloSelect')?.value === 'FUNZIONARIO_MASTER_SERSE' )
            this.homeBagService.setInfoOperatore(
              codice!,
              gruppo!,
              response.denominazione);

          this.homeBagService.setSelectedRuolo(this.selectedRuolo);
          this.navigate();
        }
    });

  }
  caseNotServizio(){
    if(this.ruoloForm.get('ruoloSelect')?.valid &&
        this.ruoloForm.get('operatoreSelect')?.valid){

      this.homeBagService.setSelectedRuolo(this.selectedRuolo);
      this.homeBagService.setSelectedInfoOperatore(this.selectedOpert);
      this.navigate();
    }
  }

  // navigo alla prossima pagina
  navigate(){
    this.router.navigateByUrl('/home/2');
  }

}
