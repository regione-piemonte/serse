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

import { Component, EventEmitter, Input, OnInit, Output, TemplateRef, ViewChild, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';

//-models
import { ComuneRistretto } from '@core/api-serse/model/comuneRistretto';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { ProvinciaRistretto } from '@core/api-serse/model/provinciaRistretto';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { EnteCoinvoltoServizio } from '@core/api-serse/model/enteCoinvoltoServizio';
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { RuoloEnte } from '@core/api-serse/model/ruoloEnte';

//-services
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { InfoComuniService } from '@core/services/info-comuni.service';
import { ModelliService } from '@modelli/services/modelli.service';

//-Utils
import { Validation } from '@shared/utils/validation';
import { Dialog } from '@angular/cdk/dialog';
import { DialogConfermaComponent } from '../dialog-conferma/dialog-conferma.component';
import { IstitutoScolastico } from '@core/api-serse/model/istitutoScolastico';
import { IstitutoScolasticoWrapper } from '@core/api-serse/model/istitutoScolasticoWrapper';
@Component({
  selector: 'app-dialog-enti',
  templateUrl: './dialog-enti.component.html',
  styleUrls: ['./dialog-enti.component.scss']
})
export class DialogEntiComponent implements OnInit {

  ruoliEnte: RuoloEnte[] = [];
  provinciaList:ProvinciaRistretto[]=[];
  comuniList:ComuneRistretto[]=[];


  //----------FORM
  //-Ha senso qui compongo l'ente e lo spedisco con il button
  riferimentoForm = this.fb.group({
    cognome: ['', [Validators.required, Validation.cognomeNomeValidator(false)]],
    nome: ['', [Validators.required, Validation.cognomeNomeValidator(true)]],
    telefono: ['', [Validators.required, Validation.phoneNumberValidator]],
    email_pec: ['', [Validators.required, Validation.emailValidator]]
  });
  ruoloControl = this.fb.control('',Validators.required);
  datiEnteEsternoForm = this.fb.group({
    denominazione: ['', Validators.required],
    denominazioneSedePrincipale: [''],
    provincia: ['', Validators.required],
    comune: ['', Validators.required],
    indirizzo: ['', Validators.required],
  });
  form = this.fb.group({
    riferimento: this.riferimentoForm,
    datiEnteEsternoForm: this.datiEnteEsternoForm,
    ruolo: this.ruoloControl
  })

  //-I dati gestiti da quello che ricevo
  enteInUse: EnteCoinvoltoModello |EnteCoinvoltoIntervento |EnteCoinvoltoServizio = {};
  //istituto?: IstitutoScolastico;
  isModificabile  = true;
  isEsterno = true;
  isNew     = true; //-> usato per la visualizzazione
  userCase  = "MDI"
  isModello = true;


  /**
   * data
   * 0 : ente
   * 1 : isEsterno
   * 2 : isNew
   * 3 : userCase
   *
   * Se esistono i buttons : isModificabile
   * 4 : provincie ???
   */

  constructor(
    private fb: FormBuilder,
    private infoComuniService: InfoComuniService,
    private entiService: EntiCoinvoltiService,

    private dialog: MatDialog,

    @Inject(MAT_DIALOG_DATA) public data: DialogSettings)
  {}

  ngOnInit(): void {
    this.isModificabile  = this.data.buttons?.length == 0 ? false : true;
    this.enteInUse = this.data.data![0];
    this.isEsterno = this.data.data![1];
    this.isNew     = this.data.data![2];
    this.isModello = (this.userCase = this.data.data![3]) == "MDI";

    if(this.isEsterno && this.isModificabile) {
      this.fetchProvincie();
      //this.fetchIstituto();
      this.uploadFormEnteEsterno();
    }

    if(this.isModello){
      if(this.isNew) this.fetchRuoli();
      else this.preSelectRuolo();
    }
    if(!this.isNew) {
      //this.fetchIstituto();
      this.uploadFormReferente();
    }
    if(!this.isModificabile) this.form.disable();
  }

  preSelectRuolo(){
    let ente: EnteCoinvoltoModello = this.enteInUse;
    this.ruoliEnte.push({
      idRuoloEnte: ente.idRuoloEnte,
      descrRuoloEnte: ente.descrizioneRuoloEnte
    });

    this.ruoloControl.setValue(String(ente.idRuoloEnte));
    this.ruoloControl.disable();
  }

  //-Casi
  //--1__Salvataggio nuovo ente selezionato
  //--2__Salvataggio nuovo ente esterno
  //--3__Salvataggio aggiorna ente regionale
  //--1__Salvataggio aggiorna ente esterno

  onConferma(){
    this.form.markAllAsTouched();

    //-Controllo validità form
    if( this.riferimentoForm.invalid ||
        (this.isEsterno ? this.datiEnteEsternoForm.invalid : false) ||
        (this.isModello ? this.ruoloControl.invalid : false) ){
      return
    }

    if(this.isEsterno) this.setDatiForEnteEsterno();
    if(this.isNew && this.isModello) this.setRuoloEnteRegionaleModello();
    this.setReferenteForEnte();

    if(this.isNew){
      let i = this.findIndexEnte();



      if( i != -1){
        this.dialog.open(DialogConfermaComponent,{
          data: new DialogSettings( "Errore", ['Errore l\'ente è già assocciato!'],"card-body--danger")
        });
        return;}
    }

    this.data.buttons![0].action!(this.enteInUse);
  }

  findIndexEnte(){
    return this.entiService.entiCoinvolti.findIndex(
      e => {
        let denome = e.denominazione   == this.enteInUse.denominazione
        let pso    = e.idPso           == this.enteInUse.idPso
        let cod1   = (e.codice1Soggetto ?e.codice1Soggetto :null)  == (this.enteInUse.codice1Soggetto ?this.enteInUse.codice1Soggetto :null)
        let cod2   = (e.codice2Soggetto ?e.codice2Soggetto :null)  == (this.enteInUse.codice2Soggetto ?this.enteInUse.codice2Soggetto :null)
        let denomSedeDiE = e.denominazioneSedePrincipale ?e.denominazioneSedePrincipale :null;
        let denomSedeInUse = this.enteInUse.denominazioneSedePrincipale ?this.enteInUse.denominazioneSedePrincipale :null;
        let denomSede = denomSedeDiE == denomSedeInUse;

        return denome && pso && cod1 && cod2 && denomSede;
      }
    )
  }


  //-Building Ente
  setRuoloEnteRegionaleModello(){
    let ente: EnteCoinvoltoModello = this.enteInUse;
    ente.idRuoloEnte = Number(this.ruoloControl.value);
    this.enteInUse = ente; //-non sono sicuro se è necessaria.
  }
  setReferenteForEnte(){
    this.enteInUse.referente = {
        referenteCognome : String(this.riferimentoForm.controls['cognome'].value),
        referenteNome    : String(this.riferimentoForm.controls['nome'].value),
        referenteEmail   : String(this.riferimentoForm.controls['email_pec'].value),
        referenteTelefono: String(this.riferimentoForm.controls['telefono'].value)}
  }
  setDatiForEnteEsterno(){
    this.enteInUse.denominazione = String(this.datiEnteEsternoForm.controls['denominazione'].value);
    this.enteInUse.denominazioneSedePrincipale = this.datiEnteEsternoForm.controls['denominazioneSedePrincipale'].value?.toString();
    this.enteInUse.comune    = {codiceIstatComune: String(this.datiEnteEsternoForm.controls['comune'].value)};
    this.enteInUse.indirizzo = String(this.datiEnteEsternoForm.controls['indirizzo'].value);
  }

  //-Fetching data
  fetchRuoli(){
    this.entiService.getRuoliEnti()
        .pipe()
        .subscribe(resp => this.ruoliEnte=resp);
  }
  fetchProvincie(){
    this.infoComuniService.getProvince().subscribe({
          next:(response)=>{
            this.provinciaList = response
            if(!this.isNew){
              this.datiEnteEsternoForm.get('provincia')?.setValue(this.enteInUse.comune?.provincia?.codiceProvincia!)
              this.fetchComuni();
            }
          }
        });
  }
  fetchIstituto(){
    this.entiService.getIstitutiScolastici(undefined, undefined, undefined, undefined, undefined, undefined, undefined,this.enteInUse.denominazione).subscribe({
      next: ris => {
        const istitutiScolastici = ris as IstitutoScolasticoWrapper[];
        istitutiScolastici.forEach(el => {
          if(el.istitutoScolastico?.indirizzo === this.enteInUse.indirizzo){
            //this.istituto = el.istitutoScolastico;
          }
        });
      }
    })
  }
  fetchComuni(){
    this.infoComuniService.getComuni(this.datiEnteEsternoForm.get('provincia')!.value!)
        .subscribe({
          next:(response)=>{
            this.comuniList = response
            if(!this.isNew)
              this.datiEnteEsternoForm.get('comune')?.setValue(this.enteInUse.comune!.codiceIstatComune!)
          }
        });
  }


  //##########################################################
  //### FORM UPLOADING
  uploadFormEnteEsterno(){
    this.datiEnteEsternoForm.get('denominazione')?.setValue(this.enteInUse.denominazione!)
    this.datiEnteEsternoForm.get('denominazioneSedePrincipale')?.setValue(this.enteInUse.denominazioneSedePrincipale!)
    this.datiEnteEsternoForm.get('indirizzo')?.setValue(this.enteInUse.indirizzo!)
  }
  uploadFormReferente(){
    this.riferimentoForm.get('cognome')?.setValue(this.enteInUse.referente?.referenteCognome!)
    this.riferimentoForm.get('nome')?.setValue(this.enteInUse.referente?.referenteNome!)
    this.riferimentoForm.get('telefono')?.setValue(this.enteInUse.referente?.referenteTelefono!)
    this.riferimentoForm.get('email_pec')?.setValue(this.enteInUse.referente?.referenteEmail!)
  }

}
