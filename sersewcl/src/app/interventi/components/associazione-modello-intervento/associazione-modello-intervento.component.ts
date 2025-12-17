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

import { HomeBagService } from './../../../home/services/home-bag.service';
import { Component, OnInit, ViewChild, TemplateRef, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { AbstractControl, FormControl, Validators } from '@angular/forms';
import { catchError, debounceTime, of } from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

//-Model
import { ModelloInterventoWrapper } from '@core/api-serse/model/modelloInterventoWrapper';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { FiltriModelli } from '@modelli/model/filtri-modelli.model';
import { SimpleModello } from '@modelli/model/simple-modello.model';
import { ButtonActionSettingModel, ColumnSettingsModel, TableSettingsModel } from '@shared/model/table-setting.model';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { SoggettoAttuatore } from '@core/api-serse/model/soggettoAttuatore';
import { TipoIntervento } from '@core/api-serse/model/tipoIntervento';

//-Services
import { CriteriRicercaService } from '@core/services/criteri-ricerca.service';
import { ModelliService } from '@modelli/services/modelli.service';

//-Utility
import { IconsSettings } from '@shared/const/icons-settings';
import { compareTipologiaservizio } from '@shared/utils/compares';
import { IDENTIFICATIVO_MASK } from '@shared/utils/text-masks';

//-Components
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { TableComponent } from '@shared/components/table/table.component';
import { FilterModelli } from '@modelli/model/filterModelli';

@Component({
  selector: 'app-associazione-modello-intervento',
  templateUrl: './associazione-modello-intervento.component.html',
  styleUrls: ['./associazione-modello-intervento.component.scss']
})
export class AssociazioneModelloInterventoComponent implements OnInit, OnChanges  {

  trashIcon = IconsSettings.TRS_ICON;
  tipologiaServizioList: ServizioRegionale[] = [];

  @Input() canAssoccia: boolean = false; // false
  @Input() canDisassocia?: boolean
  @Input() idPso: string = "";
  @Input() istanzaCandidatura?:  SoggettoAttuatore;
  @Input() tipoIntervento?: TipoIntervento;
  @Input() modelloAssociato: ModelloInterventoWrapper|null = null;
  modelli: ModelloInterventoWrapper[] = [];

  @Output() associaModello: EventEmitter<ModelloInterventoWrapper> = new EventEmitter();
  @Output() disassociaModello: EventEmitter<void> = new EventEmitter();

  //-modale
  @ViewChild('associazione') associazione!: TemplateRef<any>;
  dialogModelli!: MatDialogRef<any,any>;


  enteMessage = "";
  radioControl          = new FormControl("1");
  enteControl           = new FormControl('', Validators.minLength(3));
  identificativoControl = new FormControl();
  tipoServizioControl   = new FormControl();
  identificativoMask = IDENTIFICATIVO_MASK;

  //-Tabella Modale
  visibleTable = false;
  rowData: SimpleModello[]=[];
  columnList: ColumnSettingsModel[] = [];
  buttonsTabella : ButtonActionSettingModel[] = []
  tableSettings: TableSettingsModel = new TableSettingsModel();

  constructor(
    private criteriRicerca: CriteriRicercaService,
    private dialog: MatDialog,
    private homeService: HomeBagService,
    private modelliService: ModelliService,
    ) {}

  ngOnInit(): void {
    // if(this.modelloAssociato){}

    this.handleFormModale();
    this.createTable();
  }


  updateTipologiaServizio(){
    if(this.tipologiaServizioList.length != 0) return;
    this.criteriRicerca.getTipologiaServizio(this.idPso)
    .subscribe({
        next: (response) => {
            this.tipologiaServizioList = response;
            this.tipologiaServizioList.sort(compareTipologiaservizio)
      }});
  }

  //---RGx per il form
  handleFormModale(){
    // Uso rgx per non segnalare subito l'errore dando un margine di
    // scrittura all'utente
    this.enteControl?.valueChanges.pipe(
      debounceTime(1000)
    ).subscribe(
      value => this.setMessage(this.enteControl)
    );
  }
  setMessage(c: AbstractControl): void {
    this.enteMessage = '';
    if ((c.touched || c.dirty) && c.errors) {
      this.enteMessage = "minimo 3 caratteri";
    }
  }
 //###################################################
  // Dialog Info Section
  openDialog(title:string, content:string[], contentClass:string){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
          title,
          content,
          contentClass
      )
    });
  }

  openModaleErrore(msg: string[]){
    this.openDialog("Errore",msg, "card-body--danger")
  }

  apriModale(){
    this.visibleTable=false

    if(!(this.istanzaCandidatura && this.tipoIntervento)){
      this.openModaleErrore(["Attenzione: per associare un Modello di Intervento occorre indicare l\'Istanza di Candidatura e la Tipologia dell\'Intervento tramite le apposite liste di selezione in pagina"]);
      return;
    }
    this.updateTipologiaServizio()

    this.dialogModelli=this.dialog.open(this.associazione, {
      panelClass: 'dialog-multi-data',
      width: "70vw"
    });
  }

  onCerca(){
    if(this.enteControl.invalid) return;

    this.modelliService.getModelli(this.createFiltri())
    .pipe(catchError(err => {return of(null)}))
    .subscribe(resp => {
                        if(!resp) {/*ERRORE*/return;}
                        this.modelli = resp.items!;
                        this.rowData = [...this.modelli.map(r=>{return {
                          id: r.modelloIntervento?.idModelloIntervento,
                          titolo: r.modelloIntervento?.titolo,
                          tipoModello: r.modelloIntervento?.tipoModello?.descrizione,
                          soggAttuatore: r.modelloIntervento?.soggettoAttuatore?.gruppoOperatore!+
                                          r.modelloIntervento?.soggettoAttuatore?.codOperatore!+"/"+
                                          r.modelloIntervento?.soggettoAttuatore?.denominazioneGiuridica,
                          soggBeneficiario: r.soggettoBeneficiario!.gruppoOperatore!+"-"
                                            +r.soggettoBeneficiario!.codOperatore!+"/"
                                            +r.soggettoBeneficiario!.denominazione!,
                          isantzaCandi: r.modelloIntervento!.soggettoAttuatore!.modelId!,
                          stato: r.modelloIntervento!.statoModelloIntervento!.descrStatoModelloDiIntervento!,
                        }})]
                        this.visibleTable = true;
    })
  }
  createFiltri(): FilterModelli {
    let idServizioRegionale = this.tipoServizioControl.value
      ? this.tipologiaServizioList[this.tipoServizioControl.value].idServizioRegionale!.toString()
      : undefined;

    return {
      numProgrSportello: {eq: this.homeService.selectedSportello.numProgrSportello},
      gruppoOperatore: {eq: this.homeService.gruppoOperatore},
      codOperatore: {eq: +this.homeService.codiceOperatore},
      isProprietario: {eq: this.radioControl.value == "1"},
      codiceTipoModello: {eq: this.tipoIntervento!.codTipoIntervento === "PO" ? "OR" : "OI"},
      idStatoModelloIntervento: {eq: 20},
      modelId: {eq: this.istanzaCandidatura?.modelId},
      idServizioRegionale: idServizioRegionale ? {eq: +idServizioRegionale} : undefined,
      enteCoinvolto: this.enteControl.value ? {ci: this.enteControl.value} : undefined,
      idModelloIntervento: this.identificativoControl.value ? {eq: +this.identificativoControl.value} : undefined
    }
  }

  //-----------------------------------------------
  // Gestione tabella modale ricerca modelli
  createTable(){
    this.tableSettings.title = 'Elenco modelli';
    this.tableSettings.enableExport = false;
    this.tableSettings.enableButtons = true;
    // this.tableSettingsROperatore.enableRadioButton = true;

    this.createColumnsTable();
    this.createButtonsTable();
  }
  createColumnsTable(){
    const radioColumn = new ColumnSettingsModel(
      'radio',
      '',
      false,
      'radio'
    );

    const identificativoColumn = new ColumnSettingsModel(
      'id',
      'Identificativo',
      false,
      'simple'
    );
    const titoloColumn = new ColumnSettingsModel(
      'titolo',
      'Titolo',
      false,
      'simple'
    );
   /* const tipoColumn = new ColumnSettingsModel(
      'tipoModello',
      'Tipo modello',
      false,
      'simple'
    );*/
    const attuatoreColumn = new ColumnSettingsModel(
      'soggAttuatore',
      'Soggetto attuatore',
      false,
      'simple'
    );
    const beneficiarioColumn = new ColumnSettingsModel(
      'soggBeneficiario',
      'Soggetto beneficiario',
      false,
      'simple'
    );
    const candidaturaColumn = new ColumnSettingsModel(
      'isantzaCandi',
      'Istanza candidatura',
      false,
      'simple'
    );
    this.columnList.push(...[
      radioColumn,
      identificativoColumn,
      titoloColumn,
     //tipoColumn,
      attuatoreColumn,
      beneficiarioColumn,
      //candidaturaColumn,
    ]);
  }
  createButtonsTable(){
    let buttonConferma = new ButtonActionSettingModel(
      "CONFERMA",
      (data) => this.handleOnConferma(data),
      "d-none"
    )
    this.buttonsTabella.push(...[buttonConferma])
  }

  handleOnConferma(data:SimpleModello){
    if(!data) /*ERROR*/return;
    let selectedModello = this.modelli.find( a => a.modelloIntervento?.idModelloIntervento == data.id);

    this.associaModello.emit(selectedModello);

    this.dialogModelli.close();
  }

  //------------------------------------------------
  //disassocia
  onDisassocia(){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
        "Attenzione",
        ["eliminando l'associazione al Modello di Intervento saranno eliminati alcuni dati derivati dal Modello.",
          "Si conferma la disassociazione?”"],
        "card-body--warning",
        "",
        [new DialogButton("Annulla", "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton("Conferma", "btn btn--danger", ()=> this.onConfermaDisassoccia(),"disassocia modello")]
      )
    })

  }
  onConfermaDisassoccia(){
    this.disassociaModello.emit();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(this.istanzaCandidatura && changes["istanzaCandidatura"]){
      this.istanzaCandidatura=changes["istanzaCandidatura"].currentValue
    }

    if(this.tipoIntervento && changes["tipoModello"]){
      this.tipoIntervento=changes["tipoModello"].currentValue
    }
  }





  @ViewChild("table") table!:TableComponent;
  onConfermaModale(){
    this.table.clickButton(0);
  }
}
