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

import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';

//-Models
import { Cittadinanza } from '@core/api-serse/model/cittadinanza';
import { ComuneRistretto } from '@core/api-serse/model/comuneRistretto';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { ProvinciaRistretto } from '@core/api-serse/model/provinciaRistretto';
import { StatoEstero } from '@core/api-serse/model/statoEstero';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';

//-Services
import { InfoComuniService } from '@core/services/info-comuni.service';
import { CAP_MASK, ITALIAN_TELEPHONE_MASK } from '@shared/utils/text-masks';
import { DialogConfermaComponent } from '../dialog-conferma/dialog-conferma.component';
import { Validation } from '@shared/utils/validation';
import { DestinatariService } from '@core/services/destinatari.service';

@Component({
  selector: 'app-dialog-destinatario',
  templateUrl: './dialog-destinatario.component.html',
  styleUrls: ['./dialog-destinatario.component.scss']
})
export class DialogDestinatarioComponent implements OnInit {

  errorRecapiti = "";
  errorNonCompilati = "";

  capMask = CAP_MASK;
  telefonoMask = ITALIAN_TELEPHONE_MASK;

  //----anagrafica
  anagrafica = this.fb.group({
    cognome: ['', [Validators.required, Validation.cognomeNomeValidator(false)]],
    nome: ['', [Validators.required, Validation.cognomeNomeValidator(true)]],
    codFisc:['',[Validators.minLength(16), Validators.required, Validation.noBlanks]],
    dataNascita:['',Validators.required],
  });

  //----Natalità
  natalitaItaliana = this.fb.group({
    provincia:['',Validators.required],
    comune:['',Validators.required],
  });
  natalitaEstero= this.fb.group({
    stato:['',Validators.required],
    citta:['',[Validators.maxLength(100)]],
  });

  //----Residenza
  residenzaItaliana = this.fb.group({
    provinciaResidenza:['',Validators.required],
    comuneResidenza:['',Validators.required],
    indirizzoResidenza:['',[Validators.required,Validators.maxLength(100)]],
    capResidenza:['',[Validators.minLength(5),Validators.required]],
  });
  residenzaEstera = this.fb.group({
    statoResidenza:['',Validators.required],
    cittaResidenza:['',[Validators.required,Validators.maxLength(100)]],
  })

  form = this.fb.group({
    anagrafica: this.anagrafica,

    //----------
    luogoNascita:['1',[Validators.required,Validators.maxLength(100)]],
    natalitaItaliana: this.natalitaItaliana,
    natalitaEstero: this.natalitaEstero,

    cittadinanza:['',Validators.required],

    //-----------
    luogoResidenza:['1',Validators.required],
    residenzaItaliana: this.residenzaItaliana,
    residenzaEstera: this.residenzaEstera,

    //-----------
    provinciaDomicilio:['',],
    comuneDomicilio:['',],
    indirizzoDomicilio:['',Validators.maxLength(100)],
    capDomicilio:['',[Validators.minLength(5)]],

    //-----------
    telefono:['',Validation.phoneNumberValidator],
    email:['',Validation.emailValidator],
  });
  //------------------------------------
  //-Filtri Seleziona data
  myFilter = (d: any): boolean => {
    let day: Date;
    if(d)
      day = new Date(d)
    else
      day = new Date()
    return day < new Date();
  };

  provincieList: ProvinciaRistretto[]=[]

  comuniNascitaList: ComuneRistretto[]=[];
  comuniResidenzaList: ComuneRistretto[]=[];
  comuniDomicilioList: ComuneRistretto[]=[];

  statiEsteriList: StatoEstero[]=[]
  cittadinanzeList: Cittadinanza[]=[]

  destinatario: Destinatario| null = null;

  soloView = false;

  constructor(
    @Inject(MAT_DIALOG_DATA) public dialogSettings: DialogSettings,
    private destinarioService: DestinatariService,
    private fb: FormBuilder,
    private infoComuni: InfoComuniService,
    private dialog:MatDialog
  ) {
  }

  ngOnInit(): void {


    if(this.dialogSettings.data){
      this.destinatario = <Destinatario> this.dialogSettings.data[0];
      this.updateForm();

      this.anagrafica.disable();
      this.form.controls.luogoNascita.disable()
      this.form.controls.natalitaEstero.disable()
      this.form.controls.natalitaItaliana.disable()
    }

    this.fetchProvincie();
    this.fetchStatiEsteri();
    this.fetchCittadinanze();

    if(this.dialogSettings.data && this.dialogSettings.data[1]){
      this.soloView = this.dialogSettings.data[1];
      this.form.disable()
    }
  }

  updateForm(){
    this.anagrafica.controls['cognome'].setValue(this.destinatario?.cognomeDestinatario!);
    this.anagrafica.controls['nome'].setValue(this.destinatario?.nomeDestinatario!);
    this.anagrafica.controls['codFisc'].setValue(this.destinatario?.codiceFiscaleDestinatario!);
    this.anagrafica.controls['dataNascita'].setValue(this.destinatario?.dNascita!.toLocaleString()!);

    this.form.controls['luogoNascita'].setValue(this.destinatario?.statoEsteroNascita ? "2":"1");
    this.form.controls['luogoResidenza'].setValue(this.destinatario?.statoEsteroResidenza ? "2":"1");
    this.residenzaItaliana.controls['indirizzoResidenza'].setValue(this.destinatario?.indirizzoResidenza!);
    this.residenzaItaliana.controls['capResidenza'].setValue(this.destinatario?.capResidenza!);

    this.form.controls['indirizzoDomicilio'].setValue(this.destinatario?.indDomicilio!);
    this.form.controls['capDomicilio'].setValue(this.destinatario?.capDomicilio!);

    this.form.controls['telefono'].setValue(this.destinatario?.recapitoTelefonico!);
    this.form.controls['email'].setValue(this.destinatario?.recapitoMail!);
  }

  //--
  setProvinciaPerModifica(){
    if(this.dialogSettings.data){
      if(this.form.controls['luogoNascita'].value == "1"){
        this.natalitaItaliana.controls['provincia'].setValue(this.destinatario?.comuneNascita?.provincia?.codiceProvincia!);
        //- Set value Comune Nascita
        this.fetchComuniNascita(this.natalitaItaliana.controls['provincia'].value!);
      }
      if(this.form.controls['luogoResidenza'].value == "1"){
        this.residenzaItaliana.controls['provinciaResidenza'].setValue(this.destinatario?.comuneResidenza?.provincia?.codiceProvincia!);
        //- Set value Comune Residenza
        this.fetchComuniResidenza(this.residenzaItaliana.controls['provinciaResidenza'].value!);
      }

      this.form.controls['provinciaDomicilio'].setValue(this.destinatario?.comuneDomicilio?.provincia?.codiceProvincia!)
      this.fetchComuniDomicilio(this.form.controls['provinciaDomicilio'].value!);
    }
  }

  setStatoPerModifica(){
    if(this.dialogSettings.data){
      if(this.form.controls['luogoNascita'].value == "2"){
        let codStato = this.destinatario?.statoEsteroNascita?.codStato!.toString();
        this.natalitaEstero.controls['stato'].setValue(codStato!);

        this.natalitaEstero.controls['citta'].setValue(this.destinatario?.descrCittaEsteraNascita?this.destinatario?.descrCittaEsteraNascita!:"")
      }
      if(this.form.controls['luogoResidenza'].value == "2"){
        let codStato = this.destinatario?.statoEsteroResidenza?.codStato!.toString();
        this.residenzaEstera.controls['statoResidenza'].setValue(codStato ? codStato : null);

        this.residenzaEstera.controls['cittaResidenza'].setValue(this.destinatario?.descrCittaEsteraResidenza!)
      }
    }
  }

  setCittadinanzaPerModifica(){
    if(this.dialogSettings.data){
      this.form.controls['cittadinanza'].setValue(this.destinatario?.codCittadinanza!);
    }
  }

  //---
  fetchProvincie(){
    if(this.provincieList.length != 0){
      this.setProvinciaPerModifica()
      return;}
    this.provincieList = this.infoComuni.provincieList;
    if(this.provincieList.length != 0){
      this.setProvinciaPerModifica()
      return;}
    this.infoComuni.getProvince()
    .pipe()
    .subscribe(responce => {
      this.provincieList = responce;
      this.infoComuni.setProvincieList(this.provincieList)

      this.setProvinciaPerModifica();
    })
  }

  fetchStatiEsteri(){
    if(this.statiEsteriList.length != 0)  {
      this.setStatoPerModifica()
      return;}
    this.statiEsteriList = this.infoComuni.statiEsteriList;
    if(this.statiEsteriList.length != 0)  {
      this.setStatoPerModifica()
      return;}
    this.infoComuni.getStatiEsteri()
    .pipe()
    .subscribe(
       {
        next:responce => {
          this.statiEsteriList = responce;
          this.infoComuni.setStatiEsteriList(this.statiEsteriList)
          this.setStatoPerModifica();
        }
      }
    )
  }

  fetchCittadinanze(){
    if(this.cittadinanzeList.length != 0)  {
      this.setCittadinanzaPerModifica()
      return;}
    this.cittadinanzeList = this.infoComuni.cittadinanzeList;
    if(this.cittadinanzeList.length != 0)  {
      this.setCittadinanzaPerModifica()
      return;}
    this.infoComuni.getCittadinanze()
    .pipe()
    .subscribe(responce => {
      this.cittadinanzeList = responce;

      const index = this.cittadinanzeList.findIndex((item) => item.descrizione === "ITALIA");
      // Se l'elemento con la descrizione "ITALIA" è presente nell'array
      if (index !== -1) {
        // Rimuovi l'elemento dall'array e salvalo in una variabile
        const italiaElement = this.cittadinanzeList.splice(index, 1)[0];
        // Inserisci l'elemento in prima posizione nell'array
        this.cittadinanzeList.unshift(italiaElement);
      }

      this.infoComuni.setCittadinanzeList(this.cittadinanzeList);

      this.setCittadinanzaPerModifica()
    })
  }


  fetchComuniNascita(codiceProvincia:string){
    this.infoComuni.getComuni(codiceProvincia)
    .pipe()
    .subscribe( risposta => {
      this.comuniNascitaList = risposta
      if(this.dialogSettings.data){
        this.natalitaItaliana.controls['comune'].setValue(this.destinatario?.comuneNascita?.codiceIstatComune!);
      }
    });
  }

  fetchComuniResidenza(codiceProvincia:string){
    this.infoComuni.getComuni(codiceProvincia)
    .pipe()
    .subscribe( risposta => {
      this.comuniResidenzaList = risposta
      if(this.dialogSettings.data){
        this.residenzaItaliana.controls['comuneResidenza'].setValue(this.destinatario?.comuneResidenza?.codiceIstatComune!);
      }
    });
  }

  fetchComuniDomicilio(codiceProvincia:string){
    this.infoComuni.getComuni(codiceProvincia)
    .pipe()
    .subscribe( risposta => {
      this.comuniDomicilioList = risposta
      if(this.dialogSettings.data && codiceProvincia){
        this.form.controls['comuneDomicilio'].setValue(this.destinatario?.comuneDomicilio?.codiceIstatComune!);
      }
    });
  }

  onConferma(el:HTMLElement){
    this.errorRecapiti = "";
    this.errorNonCompilati = "";

    if(!this.isFormCompiled()){
      el.scrollTop = 0
      this.errorNonCompilati = "Attenzione: compilare i campi obbligatori";
      return;
    }

    this.tuttoMaiuscole();

    if(!this.isFormValid()) {
      el.scrollTop = 0
      // LV 2024-04 Aggiungo questo msg di errore perchè in alcuni casi non vengono mostrati
      // i messaggi di errore dei campi del form (es. se ci sono dati sporchi su DB)
      this.errorNonCompilati = "Attenzione: ci sono errori nel form";
      return;
    }

    if(!this.dialogSettings.data && this.checkCodiceFiscale()){
      this.modaleForzatura();
      return;
    }

    //--data non esiste -> devo creare un nuovo destinatario da aggiungere e assocciare
    //--data esiste -> modifico il destinatario che ho gia' aggiornandolo
    let destinatario = (!this.dialogSettings.data) ?this.createDestinatario() :this.updateDestinatario(this.dialogSettings.data![0])


    //-Gestisco il pulsante Conferma
    //-Si usa solo a scopo di metodo, per poter effettuare controlli sul form
    this.dialogSettings.buttons![1].action!(destinatario);
  }

  tuttoMaiuscole(){
    this._formTuttoMaiuscole(this.anagrafica);
    this._formTuttoMaiuscole(this.residenzaItaliana);
    this._formTuttoMaiuscole(this.residenzaEstera);
    this._formTuttoMaiuscole(this.natalitaItaliana);
    this._formTuttoMaiuscole(this.natalitaEstero);
  }

  _formTuttoMaiuscole(form: FormGroup) {
    let formValues: any = form.value;
    for (const key in formValues) {
      if (formValues.hasOwnProperty(key) && typeof formValues[key] === 'string') {
        formValues[key] = formValues[key].toUpperCase();
      }
    }
    form.patchValue(formValues);
  }

  modaleForzatura(){
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        "ATTENZIONE!",
        [
        "I dati anagrafici inseriti non sono coerenti con il Codice Fiscale secondo le regole di composizione.",
        "I dati anagrafici inseriti sono i seguenti:",
        "<strong>Nome</strong>:"+this.anagrafica.controls['nome'].value+
        ", &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Cognome</strong>:"+this.anagrafica.controls['cognome'].value,
        "<strong>Data di nascita:</strong>"+new Date(this.anagrafica.controls.dataNascita.value!).toLocaleDateString(),
        "<strong>Luogo di nascita:</strong>"+this.form.controls.luogoNascita.value == "1"? this.natalitaItaliana.controls.comune.value!: this.natalitaEstero.controls.stato.value!,
        "<br>",
        "Il Codice fiscale calcolato dovrebbe essere questo:",
         "<strong>"+this.CFM+"</strong>  oppure   <strong>"+this.CFF+"</strong>",
        "<br>",
        "<strong> Si desidera proseguire con il salvataggio assumendosi la responsabilità dei dati inseriti e dichiarandone la correttezza?</strong>"],
        "card-body--warning",
        "Attenzione!",
        [new DialogButton(
            "ANNULLA",
            "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "SALVA",
          "btn btn--danger",
          ()=>{this.handelForzatura()},
          "conferma codice fiscale",
          )]
      )
    });
  }

  handelForzatura(){
    //-FLG Forzatura
    let destinatario = this.createDestinatario()
    destinatario.flgForzaturaControlCF = "S";
    this.dialogSettings.buttons![1].action!(destinatario);
  }

  //-------------------- CODICE FISCALE
  //--------------------------------------------------------------
  CFM = ""
  CFF = ""
  checkCodiceFiscale(){
    let nome = this.anagrafica.controls['nome'].value!;
    let cognome = this.anagrafica.controls['cognome'].value!;

    let dataNascita = new Date(this.anagrafica.controls['dataNascita'].value!);

    let codFisc = this.anagrafica.controls['codFisc'].value!;

    let comune = this.form.controls['luogoNascita'].value == "1"
                  ?this.comuniNascitaList.find( c => c.codiceIstatComune == this.natalitaItaliana.controls['comune'].value)?.codiceFiscaleComune
                  :this.statiEsteriList.find(s => s.codStato?.toString() == this.natalitaEstero.controls['stato'].value)?.statoCodFiscale
    // let stato = this.statiEsteriList.find( s => s.codStato == +this.natalitaEstero.controls['stato'].value!)

    let CFArray = this.destinarioService.checkCodiceFiscale(nome.toString(),cognome.toString(),dataNascita,comune!);

    this.CFM = CFArray[0];
    this.CFF = CFArray[1];
    if( this.CFM == codFisc || this.CFF == codFisc ){
      return false
    }else
      return true;
  }



  //--------------------------------------------------------------

  createDestinatario(): Destinatario{
    let destinatario: Destinatario = {}

    //--------------------------------------
    destinatario.nomeDestinatario  = String(this.anagrafica.controls['nome'].value!);
    destinatario.cognomeDestinatario  = String(this.anagrafica.controls['cognome'].value!);
    destinatario.codiceFiscaleDestinatario  = this.anagrafica.controls['codFisc'].value!;
    destinatario.dNascita  = new Date(this.anagrafica.controls['dataNascita'].value!);

    //------------- Luogo Nascita & Cittadinanza
    if(this.form.controls['luogoNascita'].value == '1'){
      destinatario.comuneNascita = {codiceIstatComune:this.natalitaItaliana.controls['comune'].value!}
    }else{
      destinatario.statoEsteroNascita = {codStato: +this.natalitaEstero.controls['stato'].value!};
      destinatario.descrCittaEsteraNascita  = this.natalitaEstero.controls['citta'].value!;
    }
    destinatario.codCittadinanza = this.form.controls['cittadinanza'].value!;

    this.setDatiComuniSalvaUpdate(destinatario);

    return destinatario;
  }
  updateDestinatario(old:Destinatario): Destinatario{
    let destinatario: Destinatario = {}

    destinatario.idDestinatario = old.idDestinatario;
    destinatario.flgForzaturaControlCF = old.flgForzaturaControlCF;

    destinatario.nomeDestinatario = old.nomeDestinatario;
    destinatario.cognomeDestinatario = old.cognomeDestinatario;
    destinatario.codiceFiscaleDestinatario = old.codiceFiscaleDestinatario;
    destinatario.dNascita = old.dNascita;

    //------------- Luogo Nascita & Cittadinanza
    destinatario.comuneNascita = old.comuneNascita;
    destinatario.statoEsteroNascita = old.statoEsteroNascita;
    destinatario.descrCittaEsteraNascita = old.descrCittaEsteraNascita;

    destinatario.codCittadinanza = this.form.controls['cittadinanza'].value!;

    this.setDatiComuniSalvaUpdate(destinatario);

    destinatario.gruppoOperatoreInserimento = old.gruppoOperatoreInserimento;
    destinatario.codOperatoreInserimento = old.codOperatoreInserimento;
    destinatario.codUserInserim = old.codUserInserim;
    destinatario.dInserim = old.dInserim;

    return destinatario;
  }
  setDatiComuniSalvaUpdate(destinatario:Destinatario){
    //------------- Luogo Residenza
    if(this.form.controls['luogoResidenza'].value == '1'){
      destinatario.comuneResidenza = {codiceIstatComune: this.residenzaItaliana.controls['comuneResidenza'].value!};
      destinatario.indirizzoResidenza = this.residenzaItaliana.controls['indirizzoResidenza'].value!;
      destinatario.capResidenza = this.residenzaItaliana.controls['capResidenza'].value!;

      destinatario.descrCittaEsteraResidenza = undefined
      destinatario.statoEsteroResidenza = undefined
    }else{
      destinatario.statoEsteroResidenza = {codStato: +this.residenzaEstera.controls['statoResidenza'].value!};
      destinatario.descrCittaEsteraResidenza  = this.residenzaEstera.controls['cittaResidenza'].value!;

      destinatario.comuneResidenza = undefined;
      destinatario.indirizzoResidenza = undefined;
    }

    //-------------- Domicilio
    destinatario.comuneDomicilio =  this.form.controls['comuneDomicilio'].value ?{codiceIstatComune: this.form.controls['comuneDomicilio'].value!} :undefined;
    destinatario.indDomicilio = this.form.controls['indirizzoDomicilio'].value!;
    destinatario.capDomicilio = this.form.controls['capDomicilio'].value!;

    destinatario.recapitoTelefonico  = String(this.form.controls['telefono'].value!);
    destinatario.recapitoMail  = String(this.form.controls['email'].value!);
  }

  //--------------------------------------
  isFormCompiled(){
    let anagraficaCheck =
            !!this.anagrafica.controls['cognome'].value?.toString().trim() &&
            !!this.anagrafica.controls['nome'].value?.toString().trim() &&
            !!this.anagrafica.controls['dataNascita'].value?.toString().trim() &&
            !!this.anagrafica.controls['codFisc'].value?.toString().trim();
    this.anagrafica.markAllAsTouched();



    let natalita = false;
    if(this.form.controls['luogoNascita'].value == "1"){
      natalita = this.natalitaItaliana.valid;
      this.natalitaItaliana.markAllAsTouched();
    }else{
      natalita = this.natalitaEstero.valid;
      this.natalitaEstero.markAllAsTouched()
    }

    let cittadinanza = this.form.controls['cittadinanza'].valid;
    this.form.controls['cittadinanza'].markAsTouched();

    let residenza = false;
    if(this.form.controls['luogoResidenza'].value == "1"){
      residenza =
            this.residenzaItaliana.controls['provinciaResidenza'].valid &&
            this.residenzaItaliana.controls['comuneResidenza'].valid &&
            this.residenzaItaliana.controls['indirizzoResidenza'].valid &&
            !!this.residenzaItaliana.controls['capResidenza'].value;
      this.residenzaItaliana.markAllAsTouched()
    }else{
      residenza = this.residenzaEstera.valid;
      this.residenzaEstera.markAllAsTouched()
    }

    let recapiti = false;
    if(this.form.controls['telefono'].value || this.form.controls['email'].value){
      recapiti = true;
    }else{
      this.errorRecapiti = "Attenzione: compilare almeno uno dei due campi Recapiti";
    }
    this.form.controls['telefono'].markAsTouched()
    this.form.controls['email'].markAsTouched()


    anagraficaCheck = this.dialogSettings.data ?true :anagraficaCheck
    natalita = this.dialogSettings.data ?true :natalita

    return anagraficaCheck && natalita &&
            cittadinanza && residenza &&
            recapiti;
  }

  isFormValid(){
    // this.form.valid è sempre false perchè ad esempio la residenzaItaliana e la residenzaEstera sono alternativi

    let anagraficaCheck = this.anagrafica.valid;

    let residenza = this.form.controls['luogoResidenza'].value == "1"
              ?this.residenzaItaliana.controls['capResidenza'].valid
              :this.residenzaEstera.valid;

    let recapiti = this.form.controls['telefono'].valid && this.form.controls['email'].valid
      && (this.form.controls['telefono'].value || this.form.controls['email'].value);

    anagraficaCheck = this.dialogSettings.data ? true : anagraficaCheck

    return  anagraficaCheck &&
            residenza &&
            recapiti;
  }

}
