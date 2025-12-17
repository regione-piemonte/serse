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
import { AbstractControl, FormGroup, ValidationErrors, ValidatorFn } from '@angular/forms';

export class Validation {

  static CHECK_CODICE_CONTROLLO = true; // check codice di controllo nel codice fiscale
  static EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

  static getValidatorErrorMessage(validatorName: string, validatorValue?: any):string{
      const config: ValidationConfig = {
          required: 'Campo Obbligatorio',
          invalidEmailAddress: 'Indirizzo email invalido',
          invalidEmailAddressNoAt: 'L\'indirizzo mail deve contenere \'@\'',
          phoneNumberValidator: 'Numero di telefono non valido',

          maxlength:`Attenzione: il campo deve contenere al massimo ${validatorValue.maxLength} caratteri`,
          minlength: `Attenzione: il campo deve contenere almeno ${validatorValue.requiredLength} caratteri`,
          caratteriAlfabeticiApostrofo: `Attenzione: il campo può contenere solo caratteri alfabetici`,
          caratteriNonAmmessi: `Attenzione: caratteri non ammessi nel ${validatorValue.campo}.`,
          spaziNonAmmessi: `Spazi non ammessi`,
          numeroSuperiore: `Attenzione: numero inserito è troppo grande.`,

          msg: validatorValue,

          outOfRange:`Il numero inserito è fuori dal range ammissibile ${validatorValue.range}`,

          matDatepickerParse: 'Attenzione: la data inserita non è formalmente corretta.',
          matDatepickerFilter: 'Attenzione: la data inserita è posteriore alla data odierna e non si può accettare.',

          formatoOreNonCorretto: 'Attenzione: le ore possono essere h oppure h.5 masssimo 999.5',
          formatoOreIncontro:'Attenzione: formato ore non corretto',
          erroreGruppoCodice: 'Attenzione: inserire un codice operatore oltre al gruppo',


          invalidCFiscaleAddress: 'Codice fiscale non valido',
          invalidLengthCFiscaleAddress: 'Il codice fiscale deve avere lunghezza 16',
          invalidCharCFiscaleAddress: 'Sono ammessi solo lettere e numeri',
          notAnObject: 'Selezionare una voce dal menu di scelta',
          pattern: 'Formato non valido',
      };
      return config[validatorName];
  }

  /*
    * Validazione codice fiscale (N.B. non usare una regex per validare il cf, non funziona
    *  nei casi di omocodia a meno di regex una regex lunghissima e non fa verifiche sul codice di controllo).
    * In caso di stringa blank ritorna vero. Altrimenti ritorna vero solo se il codice fiscale è valido.
    * Per rendere meno stringente il controllo settare CHECK_CODICE_CONTROLLO a false
    * Source: http://www.icosaedro.it/cf-pi/
    */
  static cFiscaleValidator(control:AbstractControl){
      const cf: string = control.value.toUpperCase();
      if (!cf || !cf.trim()) { return null; }
      if (cf.length !== 16) {
          return { invalidLengthCFiscaleAddress: true };
      }
      if (! /^[0-9A-Z]{16}$/.test(cf)) {
          return { invalidCharCFiscaleAddress: true };
      }
      const map = [1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 1, 0, 5, 7, 9, 13, 15, 17,
          19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23];
      let s = 0;
      for (let i = 0; i < 15; i++) {
          let c = cf.charCodeAt(i);
          if (c < 65) {
              c = c - 48;
          } else {
              c = c - 55;
          }
          if (i % 2 === 0) {
              s += map[c];
          } else {
              s += c < 10 ? c : c - 10;
          }
      }
      const atteso = String.fromCharCode(65 + s % 26);
      if (atteso !== cf.charAt(15) && Validation.CHECK_CODICE_CONTROLLO) {
          return { invalidCFiscaleAddress: true };
      }
      return null;
  }


  //----------------Congome & Nome

  static cognomeNomeValidator(isNome:boolean = false): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const nome: string = control.value;
    if (!nome || !nome.trim()) { return null; }

    let format = /[`!@#$0123456789%^&*()_+\-=\[\]{};:"\\|,.<>\/?~]/;

    if (nome.length < 2) {
      return { minlength: {
                actualLength:nome.length,
                requiredLength:2
              }};
    }
    if (nome.length == 2 && nome.indexOf("'") !== -1) {
      return { minlength: {
                actualLength:1,
                requiredLength:2
              }};
    }
    if(format.test(nome)){
      return { caratteriNonAmmessi: {
                    campo: isNome? "nome":"cognome"
      }};
    }
    return null;
    };
  }

  private static cognomeNomeRequired(control:AbstractControl,isNome:boolean = false):ValidationErrors | null{
    const nome: string = control.value;
    if (!nome || !nome.trim()) { return { required: true };}
    return Validation.cognomeNomeValidator(isNome)(control);
  }

  //----------------Cognome
  static cognomeValidator(control:AbstractControl):ValidationErrors | null{
    return Validation.cognomeNomeValidator(false)(control);
  }
  static cognomeRequired(control:AbstractControl):ValidationErrors | null{
    return Validation.cognomeNomeRequired(control);
  }

  //----------------Nome
  static nomeValidator(control:AbstractControl):ValidationErrors | null{
    return Validation.cognomeNomeValidator(true)(control);
  }
  static nomeRequired(control:AbstractControl):ValidationErrors | null{
    return Validation.cognomeNomeRequired(control, true);
  }
  // nome e cognome metodi che reinderizzano a quello in comune

  //----------------Codice fiscale
  static noBlanks(control: AbstractControl): ValidationErrors | null{
    const val: string = control.value;
    const format = /^\S*$/;
    if (!format.test(val)){
      return {
        spaziNonAmmessi: {
          actual: val
        }
      };
    }
    return null;
  }

  //----------------ORE
  /**
   * Questo Validator controlla che il valore del campo sia un numero, la parte intera
   * compresa tra 0 e 999 e la parte decimale opzionale può essere solamente .5
   *
   * @param control
   * @returns
   */
  static oreValidator(control:AbstractControl):ValidationErrors | null {
    const ore: string|null = control.value;
    if (ore == null || ore?.trim() == "") { return null; }

    let format = /^[0-9]{1,3}([.,][5])?$/;

    if(!format.test(ore)){
      return { formatoOreNonCorretto: true };
    }
    return null;
  }

  /**
   * Questo Validator controlla che il valore del campo sia un orario nel formato HH:mm
   * @param control
   * @returns
   */
  static oreIncontroValidator(control:AbstractControl):ValidationErrors | null{

    const ore: string = control.value;
    if (!ore?.trim()) { return { required: true };}
    if(!ore.match(/^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/)){
      {return{formatoOreIncontro:true}}
    }
    return null;
  }
  static oreRequired(control:AbstractControl):ValidationErrors | null{
    const ore: string = control.value;
    if (!ore?.trim()) { return { required: true };}
    return Validation.oreValidator(control);
  }

  /**
   * Questo Validator controlla che il valore del campo sia un numero intero compreso tra 0 e 999
   * @param control
   * @returns
   */
  static int4Validator(control:AbstractControl):ValidationErrors | null{
    const num: string|null = control.value;
    if (num == null || !num?.trim()) { return null; }

    let format = /^[0-9]{1,3}?$/;

    if(!format.test(num)){
      return { caratteriNonAmmessi: {campo: "numerico"} };
    }
    if(Number(num) > 999){
      return { numeroSuperiore: true };
    }
    return null;
  }
  static int4Required(control:AbstractControl):ValidationErrors | null{
    const num: string = control.value;

    if (!num?.trim()) { return { required: true };}
    return Validation.int4Validator(control);
  }

  /**
   * Questo Validator controlla che il valore del campo sia un numero compreso tra min e max
   * @param min
   * @param max
   * @returns
   */
  static rangeValidator(min: number, max:number): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const num: string|null = control.value;
      if (num != null && num.trim() !== "") {
        const value = parseInt(num, 10);
        if (value < min || value > max) {
          return { outOfRange: { range: `${min} - ${max}` } };
        }
      }
      return null;
    };
  }

  //----------------Gruppo Codice
  /**
   * Questo Validator controlla che il valore del campo sia un grupp/codice valido, es. B6.
   * La lettera può essere minuscola o maiuscola, seguita da un numero di 1 a 5 cifre.
   * @param control
   * @returns
   */
  static gruppoCodiceValidator(control:AbstractControl):ValidationErrors | null {
    const gruppoCodice: string = control.value;
    if (!gruppoCodice || !gruppoCodice.trim()) { return null; }

    let format = /^[a-zA-Z][\d]{1,5}$/;

    if(!format.test(gruppoCodice)){
      return{ erroreGruppoCodice: true };
    }
    return null;
  }

  //----------------Email
  /**
   * Questo Validator controlla che il valore del campo sia un indirizzo email valido, usando una semplice regex
   * (NB email strane con caratteri speciali non vengono accettate)
   *
   * @param control
   * @returns
   */
  static emailValidator(control:AbstractControl):ValidationErrors | null {
      const mail: string = control.value;
      if (!mail) return null;

      if (!mail.match(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/)) {
          return { invalidEmailAddress: true };
      }
      return null;
  }
  static emailRequired(control:AbstractControl):ValidationErrors | null{
    const mail: string = control.value;
    if (!mail || !mail.trim()) { return { required: true };}
    return Validation.emailValidator(control);
  }

  //----------------Phone Number
  /**
   * Questo Validator controlla che il valore del campo sia un numero di telefono valido, usando una regex
   * @param control
   * @returns
   */
  static phoneNumberValidator(control:AbstractControl):ValidationErrors | null {
      if (!control.value || control.value.match(/^\s*$/g) || control.value.match(/^[+]*([(]\d{1,4}[)])?[-\s\./0-9]*$/g)) {
          return null;
      } else {
          return { phoneNumberValidator: true };
      }
  }
  static phoneNumberRequired(control:AbstractControl):ValidationErrors | null{
    const phone: string = control.value;
    if (!phone || !phone.trim()) { return { required: true };}
    return Validation.phoneNumberValidator(control);
  }

  //-----------------Dati Peculiari
  static condOccupazionaleRequired(control:AbstractControl,isRequired:boolean):ValidationErrors|null{
    if(isRequired){
      const dato=control.value
      if(!dato || !dato.trim()){return {required:true}}
      return null
    }
    return null
  }

  static objectValidator(control: AbstractControl) {
      if (!control || !control.value || typeof control.value === 'object') {
          return null;
      } else {
          return { notAnObject: true };
      }
  }

  /**
   * Questo Validator controlla che il valore del campo rispetti un pattern specificato
   *
   * FUTURE: usare questo per controllare telefono, email, CF, ...
   *
   * @param errProperty quale errore restituire se non rispetta il pattern
   * @param control
   * @param pattern
   * @returns
   */
  static patternValidator(errProperty: string, control:AbstractControl, pattern: RegExp):ValidationErrors | null {
    if (!control.value || control.value === "" || control.value.match(pattern)) {
        return null;
    } else {
        return { [errProperty]: true };
    }
}

  /**
   * Questo Validator controlla che almeno uno dei campi specificati abbia un valore.
   * @param errProperty quale errore restituire se non rispetta il pattern
   * @param fields
   * @returns
   */
  static atLeastOneRequired(errProperty: string, ...fields: string[]): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const group = control as FormGroup;

      if (!group) {
        return null;
      }

      const hasValue = fields.some(field => {
        const control = group.get(field);
        return control && control.value !== null && control.value !== undefined && control.value !== '';
      });

      const r = hasValue ? null : { [errProperty]: true };
      return r
    };
  }
}


//---------------------------- Components ---------------------------------
@Component({
    selector: 'app-control-messages',
    template: '<div *ngIf="errorMessage !== null">{{errorMessage}}</div>'
})
export class ControlMessagesComponent {

    @Input() control!: AbstractControl;

    constructor() {
    }

    get errorMessage() {
      let a: any = null;

      //-> Per prevenire il caso in cui ho required con datePicker
      //->-> Anche se il campo input ha dei dati, ma sono formalmente incorretti
      //->-> Es: [ads] allora segnava 2 errori { required:.., matDatepickerParse:..}
      //->-> Cosi facendo prende l'ultimo errore ignorando gli altri
      for (const propertyName in this.control.errors) {
        a = propertyName;
      }

      if ( a && this.control.errors!.hasOwnProperty(a) && this.control.touched) {
        // es. a = "minLenght" this.control.errors![a] = {actualLength:1, requiredLength:2}
        return Validation.getValidatorErrorMessage(a, this.control.errors![a]);
      }
      return null;
    }
}



interface ValidationConfig {
  [key: string]: string;
}
