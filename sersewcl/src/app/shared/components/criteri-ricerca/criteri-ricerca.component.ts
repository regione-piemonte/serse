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

import { EventEmitter, Output, Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { AbstractControl, FormControl, Validators } from '@angular/forms';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

// Models
import { FiltriRicerca } from '@shared/model/filtri-ricerca.model';

// Masks
import { IDENTIFICATIVO_MASK } from '@shared/utils/text-masks';
import { CF_MASK } from '@shared/utils/text-masks';

//-Icons
import { IconsSettings } from '@shared/const/icons-settings';
import { CriteriRicercaBagService } from '@core/services/criteri-ricerca-bag.service';
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { SedeOperatore } from '@core/api-serse/model/sedeOperatore';
import { LuoghiService } from '@incontri/services/luoghi.service';

@Component({
  selector: 'app-criteri-ricerca',
  templateUrl: './criteri-ricerca.component.html',
  styleUrls: ['./criteri-ricerca.component.scss']
})
export class CriteriRicercaComponent implements OnInit,OnChanges {

  panelOpenState = true;
  @Input('filterFor') filterFor: string = '';
  @Output('showTable') showTable: EventEmitter<FiltriRicerca> = new EventEmitter();


  @Input('tipologie') tipologie: (string|undefined)[] = [];
  @Input('stati') stati: (string|undefined)[] = [];

  /**
   * Cosa mi serve ?? :
   * 1- distinct sui soggetti beneficiari (CodFiscale?)
   * 2- se seleziono un beneficiario filtro le candidature ,per gruppo e codice del benficiario
   * 3- se seleziono una candidatura filtro i beneficiari ,per gruppo e codice della candidatura
   * 4- attenzione a quando deseleziono uno dei 2 potrebbe generare bug.
   * 5- la chiamata non cambia
  */
  @Input('beneficiari') soggettiBeneficiari: PersonaGiuridica[] = [];
  @Input('candidature') candidature: SoggettoAttuatore[] = [];
  soggettiBeneficiariBackup: PersonaGiuridica[] = [];
  candidatureBackup: SoggettoAttuatore[] = [];
  soggettiAttuatoriBackup: SoggettoAttuatore[] = [];
  soggettiAttuatoriSediBackup: SedeOperatore[] = [];
  @Input('tipologieServizio') tipologieServizio?: string[];

  @Input('rottaChiamante') rottaChiamante?:string;

  @Input('soggettoAttuatoreList') soggettoAttuatoreList?: SoggettoAttuatore[];
  @Input('soggettoAttuatoreSediList') soggettoAttuatoreSediList?: SedeOperatore[];

  radioControl          = new FormControl("1");
  tipologieControl      = new FormControl();
  statoControl          = new FormControl();
  beneficiarioControl   = new FormControl();
  candidaturaControl    = new FormControl();
  tipoServizioControl   = new FormControl();
  soggettoAttuatore     = new FormControl();
  soggettoAttuatoreSede = new FormControl();
  enteControl           = new FormControl('', Validators.minLength(3));
  identificativoControl = new FormControl();
  destinatarioControl   = new FormControl();
  finalitaControl       = new FormControl();
  incontriControl       = new FormControl("0");

  enteMessage = "";
  // Return to parent with data of filters
  filtroRicerca = new FiltriRicerca();

  identificativoMask = IDENTIFICATIVO_MASK;
  codiceFiscaleMask= CF_MASK;;

  // Icona Lente
  iconaLente = IconsSettings.LENTE_ICON;

  mainDisplay: {
    singolare:string,
    plurale: string
  } | undefined;

  modelloNomi = {
    singolare: "modello",
    plurale:"modelli"
  };
  interventoNomi = {
    singolare: "intervento",
    plurale:"interventi"
  };
  servizioNomi = {
    singolare: "servizio",
    plurale:"servizi"
  };



  constructor(
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer,
    private criteriRicercaBag:CriteriRicercaBagService,
    private luoghiService : LuoghiService
  ) {

  }

  ngOnInit(): void {

    // Aggiungo l'icona della lente
    this.matIconRegistry.addSvgIcon(
      IconsSettings.LENTE_ICON,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.searchIcon)
    );

    this.distinctSoggettiBeneficiari()


    // In base a quale casistica bisognerebbe filtrare
    switch (this.filterFor) {
      case 'modello':
        this.mainDisplay = this.modelloNomi;
        break;

      case 'intervento':
        this.mainDisplay = this.interventoNomi;
        break;

      case 'servizio':
        this.mainDisplay = this.servizioNomi;
        break;
    }

    this.ripristinaDatiRicerca();

  }

  ripristinaDatiRicerca() {
    if(this.criteriRicercaBag.rottaChiamante===this.rottaChiamante && this.criteriRicercaBag.filtriRicerca){

      this.filtroRicerca=this.criteriRicercaBag.filtriRicerca;

      this.radioControl.setValue(this.criteriRicercaBag.filtriRicerca.miei?"1":"2");
      this.tipologieControl.setValue(this.criteriRicercaBag.filtriRicerca.tipo);
      this.statoControl.setValue(this.criteriRicercaBag.filtriRicerca.stato);

      if (this.criteriRicercaBag.filtriRicerca.beneficiario) {
        this.beneficiarioControl.setValue(this.criteriRicercaBag.filtriRicerca.beneficiario);
        // in base al beneficiario occorre filtrare le candidature
        this.onBeneficiarioChange();
      }
      this.candidaturaControl.setValue(this.criteriRicercaBag.filtriRicerca.istanzaCandidatura);
      this.tipoServizioControl.setValue(this.criteriRicercaBag.filtriRicerca.tipologiaServizio);
      this.enteControl.setValue(this.criteriRicercaBag.filtriRicerca.enteCoinvolto!);
      this.identificativoControl.setValue(this.criteriRicercaBag.filtriRicerca.identificativo);
      this.destinatarioControl.setValue(this.criteriRicercaBag.filtriRicerca.destinatario);
      this.finalitaControl.setValue(this.criteriRicercaBag.filtriRicerca.finalita);
      this.incontriControl.setValue(this.criteriRicercaBag.filtriRicerca.infoIncontro?.toString()!);

      if (this.criteriRicercaBag.filtriRicerca.istanzaCandidatura) {
        // in base alla candidatura occorre filtrare i soggetti attuatori ed eventualmente le sedi
        this.serviziSoggettoAttuatore();
        if (this.criteriRicercaBag.filtriRicerca.soggettoAttuatore) {
          this.soggettoAttuatore.setValue(this.criteriRicercaBag.filtriRicerca.soggettoAttuatore);

          if (this.criteriRicercaBag.filtriRicerca.soggettoAttuatoreSede) {
            this.onSoggettoAttuatoreChange(this.criteriRicercaBag.filtriRicerca.soggettoAttuatoreSede);
          }
        } else {
          this.soggettoAttuatore.setValue(undefined);
          this.soggettoAttuatoreSede.setValue(undefined);
        }
      }
    } else {
      this.criteriRicercaBag.filtriRicerca=new FiltriRicerca();
      this.criteriRicercaBag.rottaChiamante="";
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(changes["soggettiBeneficiari"]){
      this.distinctSoggettiBeneficiari();
    }
    if(changes["candidature"]){
      this.candidatureBackup = this.candidature;
    }
  }
  isSoggettoDuplicato(soggettiUnivoci:SoggettoAttuatore[],soggetto:SoggettoAttuatore) {
    if(soggettiUnivoci.length == 0) return false;
    return soggettiUnivoci.some(existingSoggetto =>
      existingSoggetto.codOperatore === soggetto.codOperatore &&
      existingSoggetto.gruppoOperatore === soggetto.gruppoOperatore
    );
  }
  distinctSoggettiBeneficiari(){
    const soggettiUnivoci:SoggettoAttuatore[] = [];
    this.soggettiBeneficiari.forEach(soggetto => {
      if (!this.isSoggettoDuplicato(soggettiUnivoci,soggetto)) {
        soggettiUnivoci.push(soggetto);
      }
    });
    this.soggettiBeneficiari = soggettiUnivoci;
    this. soggettiBeneficiariBackup = this.soggettiBeneficiari;

  }


  setMessage(c: AbstractControl): void {
    this.enteMessage = '';
    if ((c.touched || c.dirty) && c.errors) {
      this.enteMessage = "minimo 3 caratteri";
    }
  }

  onCerca(){
    if(!this.enteControl.valid)
    {return}
    this.panelOpenState = !this.panelOpenState;
    this.updateFilters();

    this.showTable.emit(this.filtroRicerca)
  }

  clear(){
    this.radioControl.reset("1");
      this.tipologieControl.reset();
      this.statoControl.reset();
      this.beneficiarioControl.reset();
      this.candidaturaControl.reset();
      this.tipoServizioControl.reset();
      this.enteControl.reset();
      this.identificativoControl.reset();
      this.destinatarioControl.reset();
      this.finalitaControl.reset();
      this.incontriControl.reset("0")
      this.soggettoAttuatore.reset();
      this.soggettoAttuatoreSede.reset();
      window.location.reload();
  }

  updateFilters(){
    // Radio button
    this.filtroRicerca.miei = this.radioControl.value == "1" ? true : false;


    this.filtroRicerca.tipo               = this.settingValue(this.tipologieControl.value);
    this.filtroRicerca.stato              = this.settingValue(this.statoControl.value);
    this.filtroRicerca.beneficiario       = this.settingValue(this.beneficiarioControl.value);
    this.filtroRicerca.istanzaCandidatura = this.settingValue(this.candidaturaControl.value);
    this.filtroRicerca.tipologiaServizio  = this.settingValue(this.tipoServizioControl.value);
    this.filtroRicerca.enteCoinvolto      = this.settingValue(this.enteControl.value);
    this.filtroRicerca.identificativo     = this.settingValue(this.identificativoControl.value);
    this.filtroRicerca.destinatario       = this.settingValue(this.destinatarioControl.value);
    this.filtroRicerca.finalita           = this.settingValue(this.finalitaControl.value);
    this.filtroRicerca.infoIncontro       = this.settingValue(this.incontriControl.value ? this.incontriControl.value: 0)
    if(this.filterFor === 'servizio'){
      this.filtroRicerca.soggettoAttuatore         = this.settingValue(this.soggettoAttuatore.value);
      this.filtroRicerca.soggettoAttuatoreSede     = this.settingValue(this.soggettoAttuatoreSede.value);
    }
    this.criteriRicercaBag.filtriRicerca  = this.filtroRicerca
  }


  settingValue( element: any){

    if(element === undefined || element === null)
      return "";
    return element;
  }



  onBeneficiarioChange(){

    let soggettoTemp = this.soggettiBeneficiariBackup.find(sb=> sb.codiceFiscale == this.beneficiarioControl.value);
    if(soggettoTemp){
      this.candidatureBackup = this.candidature.filter( c=>  c.codOperatore == soggettoTemp!.codOperatore && c.gruppoOperatore == soggettoTemp!.gruppoOperatore)
    } else {
      this.candidatureBackup = this.candidature;
    }
  }
  onCandidaturaChange(){

    let candidaturaTemp = this.candidatureBackup.find(c=> c.modelId == this.candidaturaControl.value);
    if(candidaturaTemp){
      this.soggettiBeneficiariBackup = this.soggettiBeneficiari.filter( sb=>  sb.codOperatore == candidaturaTemp!.codOperatore && sb.gruppoOperatore == candidaturaTemp!.gruppoOperatore)
    } else {
      this.soggettiBeneficiariBackup = this.soggettiBeneficiari;
    }
    this.serviziSoggettoAttuatore()
  }
  onChangeOprion(){
    this.serviziSoggettoAttuatore();
  }

  serviziSoggettoAttuatore(){
    if(this.filterFor === 'servizio'){
      if(this.candidaturaControl.value && this.radioControl.value === "2" ){
        this.soggettiAttuatoriBackup = this.soggettoAttuatoreList!.filter( sb=> sb!.modelId == this.candidaturaControl.value )
      }

      this.soggettoAttuatore.setValue(undefined);

      if(this.candidaturaControl.value && this.radioControl.value === "1"){

        this.soggettiAttuatoriBackup = this.soggettoAttuatoreList!.filter( sb=>  sb.codOperatore! === JSON.parse(localStorage.getItem("codiceOperatore")!) && sb.gruppoOperatore === localStorage.getItem("gruppoOperatore")! && sb!.modelId === this.candidaturaControl.value )

        if(this.soggettiAttuatoriBackup.length>0){
          this.soggettoAttuatore.setValue(this.soggettiAttuatoriBackup[0].idSoggettoAttuatore);
          this.onSoggettoAttuatoreChange();
        }
      }
      this.soggettoAttuatoreSede.setValue(undefined);
    }
  }

  onSoggettoAttuatoreChange(sedeDaSelezionare?: string){
    if(this.filterFor === 'servizio'){
      // cerca sede per soggetto attuatore
      let soggettoAttuatore : SoggettoAttuatore =this.soggettiAttuatoriBackup.find(e => e.idSoggettoAttuatore == this.soggettoAttuatore.value)!;
      this.luoghiService.getElencoSediSoggAttuatore(soggettoAttuatore.idSoggettoAttuatore!).subscribe({
        next:(response)=>{
          this.soggettoAttuatoreSediList = response
          if (sedeDaSelezionare) {
            this.soggettoAttuatoreSede.setValue(sedeDaSelezionare);
          }
        }
      })
    }
  }
}
