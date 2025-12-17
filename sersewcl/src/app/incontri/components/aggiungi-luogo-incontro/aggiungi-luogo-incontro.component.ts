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

import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ComuneRistretto } from '@core/api-serse/model/comuneRistretto';
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { EnteCoinvoltoServizio } from '@core/api-serse/model/enteCoinvoltoServizio';
import { Incontro } from '@core/api-serse/model/incontro';
import { LuogoIncontro } from '@core/api-serse/model/luogoIncontro';
import { ProvinciaRistretto } from '@core/api-serse/model/provinciaRistretto';
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { InfoComuniService } from '@core/services/info-comuni.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { DialogLuoghiIncontroComponent } from '@shared/components/dialog-luoghi-incontro/dialog-luoghi-incontro.component';
import { DialogOperatoriComponent } from '@shared/components/dialog-operatori/dialog-operatori.component';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { SimpleOperatore } from '@shared/model/simple-operatore.model';
import { ButtonActionSettingModel, ColumnSettingsModel, TableSettingsModel } from '@shared/model/table-setting.model';
import { catchError, map, of } from 'rxjs';
import { IncontriService } from '../../services/incontri.service';
import { LuoghiService } from '../../services/luoghi.service';
import { Comune } from '@core/api-serse/model/comune';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { ServiziService } from '@servizi/services/servizi.service';
import { TitleService } from '@core/services/title.service';
import { BreadcrumbService } from '@core/services/breadcrumb.service';

@Component({
  selector: 'app-aggiungi-luogo-incontro',
  templateUrl: './aggiungi-luogo-incontro.component.html',
  styleUrls: ['./aggiungi-luogo-incontro.component.scss']
})
export class AggiungiLuogoIncontroComponent implements OnInit {
  selected = '1';
  error: Error | null = null;
  //########### GESTIONE FORM ###########
  provinciaList: ProvinciaRistretto[] = [];
  comuniList: ComuneRistretto[] = [];

  dialogLuogo!:MatDialogRef<any, any>;
  dialogRO!: MatDialogRef<any, any>;

  selectedOperatore: SimpleOperatore | undefined;
  entiCoinvoltiAssociati: (EnteCoinvoltoModello| EnteCoinvoltoIntervento| EnteCoinvoltoServizio)[]=[];

  incontro!:Incontro;
  luogo?:LuogoIncontro;

  rowDataEnti: LuogoSimple[]=[];
  buttonsEnteTabella: ButtonActionSettingModel[] = [];
  columnListEnti:ColumnSettingsModel[] = [];
  showTableEnte=false;
  tableSettingsEnti:TableSettingsModel = new TableSettingsModel();

  buttonsMainTabella: ButtonActionSettingModel[] = [];
  rowDataMain: any[] = [];
  columnListMain: ColumnSettingsModel[] = [];
  tableSettingsMain: TableSettingsModel = new TableSettingsModel();
  showTableMain = false;

  rowDataSedi: LuogoSimple[]=[];
  showTableSedi= false;
  columnListSediSoggAtt: ColumnSettingsModel[] = [];

  selectionName="Ente coinvolto"
  selectionId=3;//selection id di ente coinvolto
  constructor(
    private dialog: MatDialog,

    private fb: FormBuilder,
    private entiService: EntiCoinvoltiService,
    private infoComuni: InfoComuniService,
    private incontriService: IncontriService,
    private luoghiService: LuoghiService,
    private router: Router,
    private serviziService:ServiziService,
    private homeBag: HomeBagService,
    private title: TitleService,
    private breadcrubService : BreadcrumbService,

  ) { }

  formComuneProv = this.fb.group({
    provincia: [''],
    comune: [''],
  });

  ngOnInit(): void {
    this.title.setTitle("Luogo d'incontro");

    this.incontro=this.incontriService.incontro
    this.fetchProvincia()
    this.selected ='1';
    this.createTableMain();
    this.createTableEnti();
    this.handleEntiCoinvolti();
    this.fetchSediSoggettoAttuatore();

  }

  pipeCatchError = (err:any) => {
    this.error = err;
    return [];
  };


  fetchProvincia() {
    this.infoComuni.getProvincePiemonte()
      .pipe( catchError(this.pipeCatchError))
      .subscribe((risposta) => (this.provinciaList = risposta));
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

  fetchSediSoggettoAttuatore(){
    this.luoghiService.getElencoSediSoggAttuatore(this.serviziService.servizio.soggettoAttuatore?.idSoggettoAttuatore!).pipe(
      map((response) =>
        response.map((a) => {
          return {
            id:a.idSede!,
            nome: a.denominazioneSede!,
            indirizzo: a.indirizzoSede!,
            comune: a.comune?.descrizioneComune + " (" +a.comune?.provincia?.siglaProvincia +")",
            fullComune:a.comune
          };
        })
      ),
      catchError(this.pipeCatchError)
    )
    .subscribe((risposta) => {
      this.rowDataSedi = risposta;

    });
  }

  handleEntiCoinvolti(){
    this.entiService.getEntiCoinvoltiServizio(this.incontro.idServizio!.toString())
      .subscribe({
        next:ris=>{
          ris.forEach(ente => {
            if(ente.enteCoinvoltoModello){
              this.entiCoinvoltiAssociati.push(ente.enteCoinvoltoModello);
            }else if(ente.enteCoinvoltoIntervento){
              this.entiCoinvoltiAssociati.push(ente.enteCoinvoltoIntervento);
            }else if(ente.enteCoinvoltoServizio){
              this.entiCoinvoltiAssociati.push(ente.enteCoinvoltoServizio);
            }
          });
          this.rowDataEnti= ris.map(ente=>{
            if(ente.enteCoinvoltoModello){
              return{
                id:ente.enteCoinvoltoModello.idEnteCoinvoltoModello!,
                nome: ente.enteCoinvoltoModello.idFonteDato ? (ente.enteCoinvoltoModello?.codice2Soggetto ? ente.enteCoinvoltoModello.codice1Soggetto + "-" + ente.enteCoinvoltoModello?.codice2Soggetto:  ente.enteCoinvoltoModello.codice1Soggetto!)+" - "+ ente.enteCoinvoltoModello.denominazione : ente.enteCoinvoltoModello.denominazione!,
                denominazione: ente.enteCoinvoltoModello.denominazione!,
                indirizzo:ente.enteCoinvoltoModello.indirizzo!,
                comune: ente.enteCoinvoltoModello.comune?.descrizioneComune! +"("+ente.enteCoinvoltoModello.comune?.provincia?.codiceProvincia +")",
                fullComune: ente.enteCoinvoltoModello.comune!
              }
            }else if(ente.enteCoinvoltoIntervento){
              return{
                id:ente.enteCoinvoltoIntervento.idEnteCoinvoltoIntervento!,
                nome: ente.enteCoinvoltoIntervento.idFonteDato ? (ente.enteCoinvoltoIntervento?.codice2Soggetto ? ente.enteCoinvoltoIntervento.codice1Soggetto + "-" + ente.enteCoinvoltoIntervento?.codice2Soggetto:  ente.enteCoinvoltoIntervento.codice1Soggetto!)+ " - "+ ente.enteCoinvoltoIntervento.denominazione! : ente.enteCoinvoltoIntervento.denominazione!,
                denominazione: ente.enteCoinvoltoIntervento.denominazione!,
                indirizzo:ente.enteCoinvoltoIntervento.indirizzo!,
                comune: ente.enteCoinvoltoIntervento.comune?.descrizioneComune! +"("+ente.enteCoinvoltoIntervento.comune?.provincia?.codiceProvincia +")",
                fullComune:ente.enteCoinvoltoIntervento.comune!
              }
            }else if(ente.enteCoinvoltoServizio){
              return{
                id:ente.enteCoinvoltoServizio.idEnteConvoltoServizio!,
                nome: ente.enteCoinvoltoServizio.idFonteDato ? (ente.enteCoinvoltoServizio?.codice2Soggetto ? ente.enteCoinvoltoServizio.codice1Soggetto + "-" + ente.enteCoinvoltoServizio?.codice2Soggetto:  ente.enteCoinvoltoServizio.codice1Soggetto!) +" - "+ ente.enteCoinvoltoServizio.denominazione! : ente.enteCoinvoltoServizio.denominazione!,
                denominazione: ente.enteCoinvoltoServizio.denominazione!,
                indirizzo:ente.enteCoinvoltoServizio.indirizzo!,
                comune: ente.enteCoinvoltoServizio.comune?.descrizioneComune! +"("+ente.enteCoinvoltoServizio.comune?.provincia?.codiceProvincia +")",
                fullComune: ente.enteCoinvoltoServizio.comune!
              }
            }
            return {
              id:0,
              nome:"",
              indirizzo:"",
              comune:"",

            }

          })
          this.showTableEnte=true;
        }
        })
  }

  apriRicercaOperatore() {
    this.showTableMain=false;
    this.dialogRO = this.dialog.open(DialogOperatoriComponent, {
      panelClass: 'hm-700',
      data: new DialogSettings(
        "",[],"","",
        [new DialogButton("","",
          (operatore)=>{
            this.selectedOperatore = operatore;
            this.dialogRO.close();
          },"Aggiungi operatore selezionato" ),
        ],
        []
      )});
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
  createTableEnti(){
    this.tableSettingsEnti.title = this.selected=='1'? 'Enti coinvolti nel servizio' : 'Elenco sedi soggetto attuatore del servizio';
    this.tableSettingsEnti.enableExport = false;
    this.tableSettingsEnti.enableButtons = true;
    this.tableSettingsEnti.enablePagination=false;
    this.createColumnsTableEnti();
    this.createButtonTableMain();
  }

  createTableMain() {
    this.tableSettingsMain.title = 'Enti coinvolti nel servizio';
    this.tableSettingsMain.enableExport = false;
    this.tableSettingsMain.enableButtons = true;
    this.createColumnsTableMain();

    //this.createButtonTableMain();
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

  createColumnsTableEnti() {
    const radioButtonColumn = new ColumnSettingsModel(
      'radio',
      '',
      false,
      'radio'
    );
    const codiceEnteColumn = new ColumnSettingsModel(
      'nome',
      '',
      false,
      'simple'
    );

    const indirizzoColumn = new ColumnSettingsModel(
      'indirizzo',
      '',
      false,
      'simple'
    );
    const comuneColumn = new ColumnSettingsModel(
      'comune',
      '',
      false,
      'simple'
    );


    this.columnListEnti.push(
      ...[
        radioButtonColumn,
        codiceEnteColumn,
        indirizzoColumn,
        comuneColumn
      ]
    );
  }
  createButtonTableMain() {
    let buttonLuogoSelezionato = new ButtonActionSettingModel(
      'AGGIUNGI LUOGO SELEZIONATO',
      (data) =>  this.handleLuogoSelezionato(data),
      'btn btn--primary'
    );
    let buttonNuovoLuogo = new ButtonActionSettingModel(
      'AGGIUNGI NUOVO LUOGO',
      () => this.handleLuogoNuovo(),
      'btn btn-link--primary'
    );
    this.buttonsMainTabella.push(...[buttonNuovoLuogo, buttonLuogoSelezionato]);
    this.buttonsEnteTabella.push(...[buttonNuovoLuogo, buttonLuogoSelezionato]);
  }

  handleLuogoSelezionato(luogo:LuogoIncontro){
    if(luogo){
      this.dialogLuogo=this.dialog.open(DialogLuoghiIncontroComponent, {
        data: new DialogSettings(
          '',[],'','',
          [new DialogButton(
            "Usato solo per il metodo","",
            (luogoSave)=>{ this.saveLuogo(luogoSave)},
            "salva luogo selezionato")],
          [luogo,this.selectionName,this.selectionId,true]
        )
      });
    }else{
      this.dialog.open(DialogConfermaComponent, {
        data: new DialogSettings( 'Attenzione',
                                ['selezionare un ente per procedere'],
                                'card-body--warning',
                                'Attenzione!'),});
      return;
    }
  }

  handleLuogoNuovo(){
    this.dialogLuogo=this.dialog.open(DialogLuoghiIncontroComponent, {
      data: new DialogSettings(
        '',[],'','',
        [new DialogButton(
          "Usato solo per il metodo","",
          (luogoSave)=>{ this.saveLuogo(luogoSave)},"salva luogo selezionato")],
          [null,"Inserimento manuale"]
      )
    });
  }
  saveLuogo(luogo:LuogoIncontro){

    this.luoghiService.insertLuogoIncontro(luogo,this.incontro.idIncontro!).subscribe({
      next: ris=>{
        this.luoghiService.luogoIncontro=ris;
        this.incontriService.incontro.luogoIncontro=ris
        this.incontriService.selectedTab=2;
        if(this.breadcrubService.getBreadcrumbsList().find(breadcrumb => breadcrumb.url.includes('incontri/nuovo')))
          this.router.navigate(["/dashboard/servizio/incontri/nuovo"])
        else
          this.router.navigate(["/dashboard/servizio/incontri/form"])
        this.dialogLuogo.close()
      }
    });

  }

  onRadioChange(){
    switch (this.selected){
    case '1':
      this.selectionName="Ente coinvolto"
      this.selectionId=3;
      this.showTableEnte=true;
      this.showTableMain=false;
      this.showTableSedi=false;
      break;
    case '2':
      this.selectionName="Soggetto attuatore"
      this.selectionId=4
      this.showTableEnte=false;
      this.showTableMain=false;
      this.showTableSedi=true;

      break;
    case '3':
      this.selectionName="Anagrafica regionale operatori"
      this.selectionId=2
      this.showTableEnte=false;
      this.showTableMain=false;
      this.showTableSedi=false;
      break;
    case '4':
      this.selectionName="CPI"
      this.selectionId=1
      this.showTableEnte=false;
      this.showTableMain=false;
      this.showTableSedi=false;
      break;
    }
  }
}
interface LuogoSimple{
  id: number,
  nome: string,
  denominazione?:string,
  indirizzo:string,
  comune:string,
  fullComune?:Comune
}
