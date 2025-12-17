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

import { catchError, map, tap } from 'rxjs';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

// Models
import { ProvinciaRistretto } from '@core/api-serse/model/provinciaRistretto';
import { ComuneRistretto } from '@core/api-serse/model/comuneRistretto';
import { ButtonActionSettingModel, ColumnSettingsModel, Table, TableSettingsModel } from '@shared/model/table-setting.model';
import { FonteDato } from '@core/api-serse/model/fonteDato';
import { Comune } from '@core/api-serse/model/comune';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { GradoScolastico } from '@core/api-serse/model/gradoScolastico';
import { TipologiaIstitutoScolastico } from '@core/api-serse/model/tipologiaIstitutoScolastico';
import { PercorsoScolastico } from '@core/api-serse/model/percorsoScolastico';
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { EnteCoinvoltoServizio } from '@core/api-serse/model/enteCoinvoltoServizio';
import { SimpleOperatore } from '@shared/model/simple-operatore.model';

// Services
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { InterventiService } from '@interventi/services/interventi.service';
import { InfoComuniService } from '@core/services/info-comuni.service';
import { ServiziService } from '@servizi/services/servizi.service';

// Components
import { DialogEntiComponent } from '@shared/components/dialog-enti/dialog-enti.component';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogOperatoriComponent } from '@shared/components/dialog-operatori/dialog-operatori.component';
import { IconsSettings } from '@shared/const/icons-settings';

@Component({
  selector: 'app-enti-gestione',
  templateUrl: './enti-gestione.component.html',
  styleUrls: ['./enti-gestione.component.scss'],
})
export class EntiGestioneComponent implements OnInit, OnDestroy {
  error: Error | null = null;
  iconaLente = IconsSettings.LENTE_ICON;


  pipeCatchError = (err:any) => {
    this.error = err;
    return [];};

  selected = '1'; // Radio button

  //----Gestione dialog enti
  dialogEnte!: MatDialogRef<any, any>;

  backUrl: string="";

  fonteDato: FonteDato = {
    idFonteDato1: false,
    idFonteDato2: false,
    idFonteDato3: false,
  };
  userCase: string = "MDI";

  //########### GESTIONE FORM ###########
  provinciaList: ProvinciaRistretto[] = [];
  comuniList: ComuneRistretto[] = [];

  formComuneProv = this.fb.group({
    provincia: [''],
    comune: [''],
  });
  formIstitutiScolastici = this.fb.group({
    codiceRegionale: [''],
    codiceMeccanografico: [''],
    denominazioneEnte: [''],
    formComuneProv: this.formComuneProv,
    gradoScolastico: [''],
    tipologiaDiIstituto: [''],
    percorsoScolastico: [''],
  });

  //################ 1- Istituti Scolastici ##########################
  showTableIstitutiScolastici=false;
  //-Selects
  gradiScolastici: GradoScolastico[] = [];
  tipologieDiIstituto: TipologiaIstitutoScolastico[] = [];
  percorsiScolastici: PercorsoScolastico[] = [];

  //--Tables
  rowDataIstitutiScolastici: SimpleIstituto[] = [];
  columnListRIstituti: ColumnSettingsModel[] = [];
  buttonsTabellaRIstituti: ButtonActionSettingModel[] = [];
  tableSettingsRIstituti: TableSettingsModel = new TableSettingsModel();

  istitutiInnerTable!:Table;
  columnListExpandedButtonIstituti:ColumnSettingsModel[]=[];
  tableSettingsInnerTable:TableSettingsModel=new TableSettingsModel();

  erroreRicercaIstituti: string='';

  //################ 2- Centro Impiego ##########################
  //######- Settings Main Table -#####
  buttonsMainTabella: ButtonActionSettingModel[] = [];
  rowDataMain: SimpleEnte[] = [];
  columnListMain: ColumnSettingsModel[] = [];
  tableSettingsMain: TableSettingsModel = new TableSettingsModel();
  showTableMain = false;

  //################ 3- Regionale Operatore ##########################
  dialogRO!: MatDialogRef<any, any>;
  selectedOperatore: SimpleOperatore | undefined;

  //---------------------------------------------------------------------------------------------------------
  //---------------------------------------------------------------------------------------------------------
  constructor(
    private dialog: MatDialog,

    private fb: FormBuilder,
    private entiService: EntiCoinvoltiService,
    private infoComuni: InfoComuniService,

    private router: Router,

    private homeBag: HomeBagService,

    private modelloService: ModelliService,
    private interventoService:InterventiService,
    private serviziService:ServiziService
  ) {}

  ngOnDestroy(): void {
    this.entiService.backTo = "";
  }
  ngOnInit(): void {
    this.handlerUserCase();
    this.handlerBack();
    this.handlerFonteDati();

    this.formComuneProv.controls['comune'].disable();
    this.fetchProvincia();
    this.fetchCampiIstitutiScolastici();
  }

  //-Base ngOnInit
  handlerUserCase(){
    this.userCase = this.router.url.endsWith('modello/enti') ? "MDI":
                    ( this.router.url.endsWith('intervento/enti') ? "INT" : "SER" );
  }
  handlerBack(){
    this.backUrl = this.entiService.backTo;
    switch(this.userCase){
      case "MDI":
        // this.backUrl='/dashboard/modello/form';
        this.modelloService.tab = 1;
        break;
      case "INT":
        // this.backUrl='/dashboard/intervento/form';
        this.interventoService.tab = 1;
        break;
      case "SER":
        // this.backUrl='/dashboard/servizio/form';
        this.serviziService.tab = 1;
        break;
    }
  }
  handlerFonteDati(){
    this.entiService.getEntiIdFonteDati(this.homeBag.selectedPso.idPso!.toString())
      .pipe()
      .subscribe((risposta) => {
        this.fonteDato = risposta;
        if (!risposta.idFonteDato1 && !risposta.idFonteDato2 && !risposta.idFonteDato3) {
          this.selected = '0';
          return;
        }
        this.createTableMain();
        this.createTableIstituti();
        if (risposta.idFonteDato1) {
          this.selected = '1';
        } else if (risposta.idFonteDato2) {
          this.selected = '2';
        } else {
          this.selected = '3';
        }
      });
  }

  fetchProvincia() {
    this.infoComuni.getProvincePiemonte()
      .pipe( catchError(this.pipeCatchError))
      .subscribe((risposta) => (this.provinciaList = risposta));
  }
  fetchCampiIstitutiScolastici() {
    this.entiService.getGradiScolastici()
        .pipe(catchError(this.pipeCatchError))
        .subscribe((risposta) => {this.gradiScolastici = risposta});
    this.entiService.getTipologieIstituti()
        .pipe(catchError(this.pipeCatchError))
        .subscribe((risposta) => {this.tipologieDiIstituto = risposta});
    this.entiService.getPercorsiScolastici()
        .pipe(catchError(this.pipeCatchError))
        .subscribe((risposta) => {this.percorsiScolastici = risposta});
  }

  //---------------------------------------------------------------------------------------------------------
  //---------------------------------------------------------------------------------------------------------
  //--- Navigazione tra radio button e gestione selects province e comuni
  onRadioChange() {
    this.formIstitutiScolastici.reset();
    this.formComuneProv.controls['comune'].disable();

    this.showTableMain= false;
    this.showTableIstitutiScolastici=false;
  }
  onSelectedProvincia() {
    this.fetchComuni(this.formComuneProv.get('provincia')?.value!);
  }
  fetchComuni(codiceProvincia: string) {
    this.infoComuni.getComuni(codiceProvincia)
      .pipe(catchError(this.pipeCatchError))
      .subscribe((risposta) => (this.comuniList = risposta));
    this.formComuneProv.get('comune')?.enable();
  }

  //---------------------------------------------------------------------------------------------------------
  //---------------------------------------------------------------------------------------------------------
  //################ 1- Istituti Scolastici ######################
  onCercaIstituti() {
    let idPercorsoScolastico  = (this.formIstitutiScolastici.get('percorsoScolastico')?.value!);
    let codiceComune          = (this.formComuneProv.get('comune')?.value!)
    let codiceProvincia       = (this.formComuneProv.get('provincia')?.value!)
    let idGradoScolastico     = (this.formIstitutiScolastici.get('gradoScolastico')?.value!)
    let idTipologiaIstituto   = (this.formIstitutiScolastici.get('tipologiaDiIstituto')?.value!)
    let codiceRegionale       = (this.formIstitutiScolastici.get('codiceRegionale')?.value!)
    let codiceMeccanografico  = (this.formIstitutiScolastici.get('codiceMeccanografico')?.value!)
    let enteCoinvolto         = (this.formIstitutiScolastici.get('denominazioneEnte')?.value!)

    if (!idPercorsoScolastico && !codiceComune &&
        !codiceProvincia      && !idGradoScolastico &&
        !idTipologiaIstituto  && !codiceRegionale &&
        !codiceMeccanografico && !enteCoinvolto) {
      this.erroreRicercaIstituti='Attenzione: per effettuare la ricerca valorizzare almeno uno dei filtri di ricerca';
      return;
    }
    this.fetchIstituti( idPercorsoScolastico, codiceComune,
                        codiceProvincia, idGradoScolastico,
                        idTipologiaIstituto, codiceRegionale,
                        codiceMeccanografico, enteCoinvolto);
  }
  fetchIstituti( idPercorsoScolastico?: string, codiceComune?: string, codiceProvincia?: string,
                idGradoScolastico?: string, idTipologiaIstituto?: string, codiceRegionale?: string,
                codiceMeccanografico?: string, enteCoinvolto?: string) {

    this.entiService.getIstitutiScolastici( idPercorsoScolastico, codiceComune,
                                            codiceProvincia,      idGradoScolastico,
                                            idTipologiaIstituto,  codiceRegionale,
                                            codiceMeccanografico, enteCoinvolto)
      .pipe(
        map((risposta) => {
          if (!Array.isArray(risposta)) {
            return risposta;
          }
          return risposta.map((r) => {
            return {
              codiceEnte: r.istitutoScolastico?.codRegionaleScuola,
              denominazione: r.istitutoScolastico?.denominazione,
              percorso: r.istitutoScolastico?.percorsoScolastico?.descrPercorso,
              autonomia: r.codiceRegionaleAutonomia + ' - ' + r.denominazioneAutonomia,
              indirizzo: r.istitutoScolastico?.indirizzo,
              comune: r.istitutoScolastico?.comuneScuola?.descrizioneComune,
              provincia: r.istitutoScolastico?.comuneScuola?.provincia?.siglaProvincia,
              codMeccanografico: r.istitutoScolastico?.codMeccanograficoScuola,
              codMeccanograficoAutonomia: r.istitutoScolastico?.codMeccanograficoAutonomia,
              gradoScolastico: r.istitutoScolastico?.gradoScolastico?.descrGradoScolastico,
              tipologia: r.istitutoScolastico?.tipologiaIstituto?.descrTipologia,
              fullComune: r.istitutoScolastico?.comuneScuola,
              contentExp: [{
                codMeccanografico: r.istitutoScolastico?.codMeccanograficoScuola,
                codMeccanograficoAutonomia: r.istitutoScolastico?.codMeccanograficoAutonomia,
                gradoScolastico: r.istitutoScolastico?.gradoScolastico?.descrGradoScolastico,
                tipologia: r.istitutoScolastico?.tipologiaIstituto?.descrTipologia,
              }]
            };
          });
        }),
        catchError(this.pipeCatchError))
      .subscribe((risposta) => {
        if (!Array.isArray(risposta)) {
          this.erroreRicercaIstituti = "Attenzione: troppi risultati ottenuti. Si prega di raffinare la ricerca valorizzando altri filtri e riprovare:";
          this.showTableIstitutiScolastici=false;
          return;
        }
        if (risposta.length == 0) this.erroreRicercaIstituti = "Nessuna occorrenza trovata a fronte dei parametri di ricerca indicati";
        else this.erroreRicercaIstituti='';
        this.rowDataIstitutiScolastici = risposta;
        this.showTableIstitutiScolastici=true;
      });

  }


  createTableIstituti() {
    this.tableSettingsRIstituti.title = 'Elenco Enti';
    this.tableSettingsRIstituti.enableExport = false;
    this.tableSettingsRIstituti.enableButtons = true;
    this.tableSettingsRIstituti.enableExpansion= true;

    this.createColumnsTableIstituti();
    this.createButtonTableIstituti();
    this.createInnerTableIstituti();

    this.tableSettingsRIstituti.innerTableSettings=this.istitutiInnerTable
  }
  createInnerTableIstituti(){
    this.tableSettingsInnerTable.enableExport = false;
    this.tableSettingsInnerTable.enableButtons = false;
    this.tableSettingsInnerTable.enablePagination=false;
    this.createColumsExpandIstituti();
    this.istitutiInnerTable=new Table(this.rowDataIstitutiScolastici,this.tableSettingsInnerTable,this.columnListExpandedButtonIstituti);
  }
  createColumnsTableIstituti(){
    const radioButtonColumn = new ColumnSettingsModel(
      'radio',
      '',
      false,
      'radio'
    );
    const codiceEnteColumn = new ColumnSettingsModel(
      'codiceEnte',
      'Codice Ente',
      false,
      'simple'
    );
    const nomeColumn=new ColumnSettingsModel(
      'denominazione',
      'Nome',
      false,
      'simple'
    );
    const percorsoColumn=new ColumnSettingsModel(
      'percorso',
      'Percorso',
      false,
      'simple'
    );
    const autonomiaColumn=new ColumnSettingsModel(
      'autonomia',
      'Autonomia',
      false,
      'simple'
    );
    const indirizzoColumn = new ColumnSettingsModel(
      'indirizzo',
      'Indirizzo',
      false,
      'simple'
    );
    const comuneColumn = new ColumnSettingsModel(
      'comune',
      'Comune',
      false,
      'simple'
    );
    const provinciaColumn = new ColumnSettingsModel(
      'provincia',
      'Provincia',
      false,
      'simple'
    );
    const expandColumn = new ColumnSettingsModel(
      'expand',
      '',
      true,
      ''
    );
    this.columnListRIstituti.push(...[
      radioButtonColumn,
      codiceEnteColumn,
      nomeColumn,
      percorsoColumn,
      autonomiaColumn,
      indirizzoColumn,
      comuneColumn,
      provinciaColumn,
      expandColumn
    ])
  }
  createColumsExpandIstituti(){
    const codMeccanograficoColumn = new ColumnSettingsModel(
      'codMeccanografico',
      'Cod. meccanografico',
      false,
      'simple'
    );
    const codMeccanograficoAutonomiaColumn = new ColumnSettingsModel(
      'codMeccanograficoAutonomia',
      'Cod. meccanografico autonomia',
      false,
      'simple'
    );
    const gradoScolasticoColumn = new ColumnSettingsModel(
      'gradoScolastico',
      'Grado scolastico',
      false,
      'simple'
    );
    const tipologiaColumn = new ColumnSettingsModel(
      'tipologia',
      'Tipologia',
      false,
      'simple'
    );

    this.columnListExpandedButtonIstituti.push(...[
      codMeccanograficoColumn,
      codMeccanograficoAutonomiaColumn,
      gradoScolasticoColumn,
      tipologiaColumn
    ])
  }
  createButtonTableIstituti(){
    let buttonEnteSelezionato = new ButtonActionSettingModel(
      'AGGIUNGI ENTE SELEZIONATO',
      (data) => {
        this.handlerEnteSelezionato(data);
      },
      'btn btn--primary'
    );
    let buttonNuovoEnte = new ButtonActionSettingModel(
      'AGGIUNGI NUOVO ENTE',
      () => {
        this.handeleEnteNuovo();
      },
      'btn btn-link--primary'
    );
    this.buttonsTabellaRIstituti.push(...[buttonNuovoEnte, buttonEnteSelezionato]);
  }

  //---------------------------------------------------------------------------------------------------------
  //---------------------------------------------------------------------------------------------------------
  //################ 2- Centro Impiego ##########################
  onCercaCentriImpiego() {
    this.entiService.getCentriImpiego( this.formComuneProv.get('provincia')?.value!,this.formComuneProv.get('comune')?.value!)
      .pipe(
        map((response) =>
          response.map((a) => {
            return {
              idCpi: a.idCpi,
              codiceEnte: a.codiceCpi,
              denominazione: a.cpi,
              indirizzo: a.indirizzo,
              comune: a.comune?.descrizioneComune,
              fullComune: a.comune,
              provincia: a.comune?.provincia?.siglaProvincia,
            };
          })
        ),

        catchError(this.pipeCatchError)
      )
      .subscribe((risposta) => {
        this.rowDataMain = risposta;
        this.showTableMain = true;
      });
  }

  //######################################################
  // Main Table
  createTableMain() {
    this.tableSettingsMain.title = 'Elenco Enti';
    this.tableSettingsMain.enableExport = false;
    this.tableSettingsMain.enableButtons = true;
    this.createColumnsTableMain();
    this.createButtonTableMain();
  }
  createColumnsTableMain() {
    const radioButtonColumn = new ColumnSettingsModel(
      'radio',
      '',
      false,
      'radio'
    );
    const codiceEnteColumn = new ColumnSettingsModel(
      'codiceEnte',
      'Codice Ente',
      false,
      'simple'
    );
    const nomeColumn = new ColumnSettingsModel(
      'denominazione',
      'Nome',
      false,
      'simple'
    );
    const indirizzoColumn = new ColumnSettingsModel(
      'indirizzo',
      'Indirizzo',
      false,
      'simple'
    );
    const comuneColumn = new ColumnSettingsModel(
      'comune',
      'Comune',
      false,
      'simple'
    );
    const provinciaColumn = new ColumnSettingsModel(
      'provincia',
      'Provincia',
      false,
      'simple'
    );
    const expandColumn = new ColumnSettingsModel(
      'expand',
      '',
      true,
      ''
    );
    this.columnListMain.push(
      ...[
        radioButtonColumn,
        codiceEnteColumn,
        nomeColumn,
        indirizzoColumn,
        comuneColumn,
        provinciaColumn
      ]
    );
  }
  createButtonTableMain() {
    let buttonEnteSelezionato = new ButtonActionSettingModel(
      'AGGIUNGI ENTE SELEZIONATO',
      (data) => this.handlerEnteSelezionato(data),
      'btn btn--primary'
    );
    let buttonNuovoEnte = new ButtonActionSettingModel(
      'AGGIUNGI NUOVO ENTE',
      () => this.handeleEnteNuovo(),
      'btn btn-link--primary'
    );
    this.buttonsMainTabella.push(...[buttonNuovoEnte, buttonEnteSelezionato]);
  }

  //---------------------------------------------------------------------------------------------------------
  //---------------------------------------------------------------------------------------------------------
  //------------              GESTIONE MODALE PER ASSOCIARE UN MODELLO SELEZIONATO O ESTERNO
  //-Gestione creazione ente
  createNeoEnte(): EnteCoinvoltoIntervento| EnteCoinvoltoModello| EnteCoinvoltoServizio{
    let enteInUse = {
      "MDI": <EnteCoinvoltoModello>{ idModelloDiIntervento: this.modelloService.modelloIntervento.idModelloIntervento},
      "INT": <EnteCoinvoltoIntervento>{ idIntervento: this.interventoService.intervento.idIntervento},
    }[this.userCase] ?? <EnteCoinvoltoServizio>{idServizio: this.serviziService.servizio.idServizio};
    enteInUse.codUserInserim = this.homeBag.userInfo.codFisc;
    enteInUse.codUserAggiorn = this.homeBag.userInfo.codFisc;
    enteInUse.dInserim = new Date();
    return enteInUse;
  }
  createEnteFromSelezionato(ente: SimpleEnte | SimpleIstituto):EnteCoinvoltoIntervento| EnteCoinvoltoModello| EnteCoinvoltoServizio{
    let enteInUse = this.createNeoEnte();

    enteInUse.denominazione = ente.denominazione;
    enteInUse.denominazioneSedePrincipale = ente.denominazioneSedePrincipale;
    enteInUse.idFonteDato = +this.selected;
    enteInUse.descrizioneFonteDato = {
          1: "Anagrafica Istituti scolastici",
          2: "Anagrafica Centro per l'impiego",
          3: "Anagrafica regionale Operatori"
        }[+this.selected] ?? "ERRORE";

    /*enteInUse.percorso = ente.percorso;
    enteInUse.codMeccanografico = ente.codMeccanografico;
    enteInUse.codMeccanograficoAutonomia = ente.codMeccanograficoAutonomia;
    enteInUse.autonomia = ente.autonomia;
    enteInUse.gradoScolastico = ente.gradoScolastico;
    enteInUse.tipologia = ente.tipologia;*/
    enteInUse.indirizzo = ente.indirizzo;
    enteInUse.comune = ente.fullComune;
    enteInUse.idPso = this.homeBag.selectedPso.idPso;

    if(this.selected=='1'){
      enteInUse={...enteInUse,
          percorso: ente.percorso,
          autonomia: ente.autonomia,
          codMeccanografico: ente.codMeccanografico,
          codMeccanograficoAutonomia: ente.codMeccanograficoAutonomia,
          gradoScolastico: ente.gradoScolastico,
          tipologia: ente.tipologia,
      };
    }

    if(this.selected!='3'){
      enteInUse.codice1Soggetto = ente.codiceEnte!;
      enteInUse.codice2Soggetto = '';
    }else{
      let tmp:string[] = ente.codiceEnte!.split('-')
      enteInUse.codice1Soggetto = tmp[0];
      enteInUse.codice2Soggetto = tmp[1];
    }

    return enteInUse;
  }
  //-Gestione ente nuovo
  handeleEnteNuovo() {
    let enteInUse = this.createNeoEnte();

    this.dialogEnte = this.dialog.open(DialogEntiComponent, {
      data: new DialogSettings(
        '',[],'','',
        [new DialogButton(
          "Usato solo per il metodo","",
          (ente)=>{ this.addEnteAndNavigate(ente)},"aggiungi ente")],
        [enteInUse, //-enti
          true,         //-isEsterno
          true,          //-isNew
          this.userCase, //-userCase
        ]
      ),
      panelClass: "dialog-enti"
    });
  }
  //-Gestione Ente Selezionato
  handlerEnteSelezionato(ente: SimpleEnte | SimpleIstituto) {
    if (!ente) {
       this.dialog.open(DialogConfermaComponent, {
        data: new DialogSettings( 'Attenzione',
                                ['selezionare un ente per procedere'],
                                'card-body--warning',
                                'Attenzione!'),});
      return;}

    let enteInUse = this.createEnteFromSelezionato(ente);

    let i = this.findIndexEnte(enteInUse);
    if( i != -1){
        this.dialog.open(DialogConfermaComponent,{
          data: new DialogSettings( "Errore", ['Errore l\'ente è già assocciato!'],"card-body--danger")
        });
        return;}

      this.dialogEnte = this.dialog.open(DialogEntiComponent, {
      data: new DialogSettings(
        '',[],'','',
        [new DialogButton(
          "Usato solo per il metodo","",
          (ente)=>{ this.addEnteAndNavigate(ente)},"aggiungi ente selezionato")],
        [enteInUse, //-enti
          false,         //-isEsterno
          true,          //-isNew
          this.userCase, //-userCase
        ]
      ),
      panelClass: "dialog-enti"

    });
  }
  addEnteAndNavigate(ente:EnteCoinvoltoModello|EnteCoinvoltoIntervento|EnteCoinvoltoServizio ) {
    switch(this.userCase){
      case "MDI":
        this.entiService.insertEnteCoinvoltoModello(ente)
        .subscribe(() => this.handleCommonLogic(this.modelloService));
      break;
      case "INT":
        this.entiService.insertEnteCoinvoltoIntervento(ente)
        .subscribe(()=>this.handleCommonLogic(this.interventoService));
      break;
      case "SER":
        this.entiService.insertEnteCoinvoltoServizio(ente)
        .subscribe(() => this.handleCommonLogic(this.serviziService))
    }
  }
  private handleCommonLogic(service:any) {
    this.dialogEnte.close();
    service.setIsModificabile(true);
    service.setIsSaved(true);
    this.router.navigate([this.backUrl]);
  }

  //-----------------------------------------------------------------------------------------------------------
  //-----------------------------------------------------------------------------------------------------------
  //-------------                Anagrafica Regionale Operatori
  //###-Ricerca Operatore -###
  apriRicercaOperatore() {
    this.showTableMain=false;
    this.dialogRO = this.dialog.open(DialogOperatoriComponent, {
      panelClass: 'dialog-multi-data',
      data: new DialogSettings(
        "",[],"","",
        [new DialogButton("","",
          (operatore)=>{
            this.selectedOperatore = operatore;
            this.dialogRO.close();
          },"Aggiungi operatore selezionato" ),
         new DialogButton(
           "Aggiungi nuovo ente",
           "btn btn--primary",
           ()=>{this.handeleEnteNuovo()},
           "Aggiungi nuovo ente"
         )],
        []
      )

      /*new DialogButton("","",
          (operatore)=>{
            this.selectedOperatore = operatore;
            this.dialogRO.close();
          } )*/
    });
  }
  //###-Anagrafica regionale operatori-###
  onCercaregionaleOperatori() {
    let gruppoCodice:string[]=[];
    gruppoCodice[0] = this.selectedOperatore!.grppCodice!.charAt(0);
    gruppoCodice[1]=this.selectedOperatore!.grppCodice!.substring(1);
    this.entiService.getRegionaleOperatori( gruppoCodice[0], gruppoCodice[1],
                                            this.formComuneProv.get('provincia')?.value!,
                                            this.formComuneProv.get('comune')?.value!)
      .pipe(
        map((response) =>
          response.map((a) => {
            return {
              codiceEnte: this.selectedOperatore!.grppCodice! + '-' + a.idSede,
              denominazione: this.selectedOperatore?.denominazione,
              denominazioneSedePrincipale: a.denominazioneSede,
              indirizzo: a.indirizzoSede,
              comune: a.comune?.descrizioneComune,
              provincia: a.comune?.provincia?.siglaProvincia,
              fullComune: a.comune,
            };
          })
        ),
        catchError(this.pipeCatchError)
      )
      .subscribe((risposta) => {
        this.rowDataMain = risposta;
        this.showTableMain = true;
      });
  }
  //-----------------------------------------------------------------------------------------------------------
  //-----------------------------------------------------------------------------------------------------------

  findIndexEnte(enteInUse:EnteCoinvoltoModello|EnteCoinvoltoIntervento|EnteCoinvoltoServizio){
    return this.entiService.entiCoinvolti.findIndex(
      e => {
        let denome = e.denominazione   == enteInUse.denominazione
        let pso    = e.idPso           == enteInUse.idPso
        let cod1   = (e.codice1Soggetto ?e.codice1Soggetto :null)  == (enteInUse.codice1Soggetto ?enteInUse.codice1Soggetto :null)
        let cod2   = (e.codice2Soggetto ?e.codice2Soggetto :null)  == (enteInUse.codice2Soggetto ?enteInUse.codice2Soggetto :null)
        let denomSedeDiE = e.denominazioneSedePrincipale ?e.denominazioneSedePrincipale :null;
        let denomSedeInUse = enteInUse.denominazioneSedePrincipale ?enteInUse.denominazioneSedePrincipale :null;
        let denomSede = denomSedeDiE == denomSedeInUse;

        return denome && pso && cod1 && cod2 && denomSede;
      }
    )
  }
}

interface SimpleEnte {
  idCpi?: number;
  codiceEnte?: string;
  denominazione?: string;

  denominazioneSedePrincipale?: string;

  indirizzo?: string;

  fullComune?: Comune;
  comune?: string;
  provincia?: string;
  percorso?: string;
  autonomia?: string;
  codMeccanografico?: string;
  codMeccanograficoAutonomia?: string;
  gradoScolastico?: string;
  tipologia?: string;
}

interface SimpleIstituto {
  codiceEnte?: string;
  denominazione?: string;
  denominazioneSedePrincipale?:string;
  percorso?: string;
  autonomia?: string;
  indirizzo?: string;
  comune?: string;
  provincia?: string;
  fullComune?: Comune;


  //tasto espandi
  codMeccanografico?: string;
  codMeccanograficoAutonomia?: string;
  gradoScolastico?: string;
  tipologia?: string;
  contentExp: any[];
}
