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
import { Observable, catchError, map, of } from 'rxjs';

//-Services
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { DestinatariService } from '@core/services/destinatari.service';

//-Models
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';

import { Intervento } from '@core/api-serse/model/intervento';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { TargetDestinatariService } from '@core/services/target-destinatari.service';
import { TargetDestinatario } from '@core/api-serse/model/targetDestinatario';
import { CaratteristicheService } from '@core/services/caratteristiche.service';
import { Caratteristica } from '@core/api-serse/model/caratteristica';
import { SimpleDestinatario } from '@shared/model/simple-destinatario.model';
import { TableSettingsModel, ColumnSettingsModel, InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { DialogDestinatarioComponent } from '@shared/components/dialog-destinatario/dialog-destinatario.component';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { IconsSettings } from '@shared/const/icons-settings';
import { Router } from '@angular/router';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';

@Component({
  selector: 'app-intervento-correlati',
  templateUrl: './intervento-correlati.component.html',
  styleUrls: ['./intervento-correlati.component.scss']
})
export class InterventoCorrelatiComponent implements OnInit {

  @Input() intervento!:Intervento;
  @Input() isModificabile!:boolean;
  targetDestinatariAssociatiElenco$!: Observable<TargetDestinatario[]>
  caratteristicheAssociateElenco$!: Observable<Caratteristica[]>
  destinatari: Destinatario[]=[]
  entCoinvoltiAssociati$!:Observable<(EnteCoinvoltoModello| EnteCoinvoltoIntervento)[]>;
  _isEnteCoinvoltoModificabile:boolean = this.isModificabile;
  entiArrivanoDaModello:boolean = false

  rowDataDestinatari:SimpleDestinatario[]=[];
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];
  hideEntiCoinvolti = false;

  destinatario: Destinatario|null = null;
  modaleDestinatari: any;

  lengthOfEntCoinvoltiAssociati: number = 0;
  // Handle Error -------------------------------------------------------------------------
  error: Error | null=null;

  constructor(
    private destinatarioService: DestinatariService,
    private entiCoinvoltiService:EntiCoinvoltiService,
    private targetDestinatariService: TargetDestinatariService,
    private caratteristicheService:CaratteristicheService,
    private homeBag: HomeBagService,
    private dialog:MatDialog,
    private router:Router
  ) { this.homeBag.userCase="INT";}

  ngOnInit(): void {
    this.createTable()
    if(this.isIndividuale){
      this.getDestinatario()
    }else{

      this.destinatarioService.getDestinatariIntervento(this.intervento.idIntervento!).subscribe({
        next:ris=>{
          this.destinatari=ris;
          this.rowDataDestinatari=this.destinatari.map(dest=>{
            return {
              idDestinatario:dest.idDestinatario!,
              codFisc:dest.codiceFiscaleDestinatario!,
              cognome:dest.cognomeDestinatario!,
              nome:dest.nomeDestinatario!,
              dataNascita: new Date(dest.dNascita!).toLocaleDateString(),
              luogoNascita:dest.comuneNascita ? dest.comuneNascita.descrizioneComune: dest.statoEsteroNascita?.decrizioneStato,
              icons:this.createIcons()
            }
         })

        }

      })

    }

    this.handelEntiCoinvolti();
    this.handleTargetDestinatari();
    this.handleCaratteristiche();
  }


  getDestinatario(){
    if(!this.idDestinatario){
      this.destinatario = null;
      return;
    }
    this.destinatarioService
        .getDestinatarioById(this.idDestinatario.toString())
        .pipe()
        .subscribe(
          resp => this.destinatario= resp
        )
  }

  get idDestinatario(){
    return this.intervento?.idDestinatario;
  }
  get isIndividuale(){
    return this.intervento.tipoIntervento?.flgProgettazioneIndividuale;
  }
  get stato(){
    return this.intervento.statoIntervento!.idStatoIntervento!;
  }

  get isModificabileCorrelati(){
    return this.isEnteCoinvoltoModificabile && this.isModificabile && (this.stato==10 || this.stato==20);
  }
  get isEliminabile(){
    return (this.stato==10 || this.stato==20) && !this.entiArrivanoDaModello;
  }
  get isEliminabileDaModello(){
    return (this.stato==10 || this.stato==20) && this.entiArrivanoDaModello && this.lengthOfEntCoinvoltiAssociati > 1;
  }
  get backToURl(){
    return  this.router.url;
  }

  get isEnteCoinvoltoModificabile(){
    return this._isEnteCoinvoltoModificabile;
  }
  //############################################################################à
  //######## Target Destinatari
  handleTargetDestinatari(){

      this.targetDestinatariAssociatiElenco$=this.targetDestinatariService.getTargetDestinatariIntervento(this.intervento.idIntervento!)

  }

  //############################################################################à
  //######## Caratteristiche
  handleCaratteristiche(){

      this.caratteristicheAssociateElenco$=this.caratteristicheService.getCaratteristicheIntervento(this.intervento.idIntervento!)

  }

  //############################################################################à
  //######## Enti Coinvolti
  handelEntiCoinvolti(){
    this.entCoinvoltiAssociati$ = this.entiCoinvoltiService.getEntiCoinvoltiIntervento(this.intervento.idIntervento!.toString())
        .pipe(
          map(response=>{
                this._isEnteCoinvoltoModificabile = this.isModificabile;
                this.lengthOfEntCoinvoltiAssociati = response.length;
                let tmp: (EnteCoinvoltoModello|EnteCoinvoltoIntervento)[]=[];
                response.forEach(enteCoinvolto=>{

                  // se ente coinvolto intervento deriva da ente coinvolto modello
                  //(idEnteCoinvoltoModello!=null) prendo i dati da ente coinvolto modello
                  if(enteCoinvolto.enteCoinvoltoModello){
                    this._isEnteCoinvoltoModificabile = false;
                    this.entiArrivanoDaModello = true;  // mi aspetto che tutti i record arrivino da modello, o nessuno
                    tmp.push(enteCoinvolto.enteCoinvoltoModello);
                  }else{
                    this.entiArrivanoDaModello = false;
                    if(enteCoinvolto.enteCoinvoltoIntervento && !enteCoinvolto.enteCoinvoltoIntervento.idEnteCoinvoltoModello){
                      this._isEnteCoinvoltoModificabile = true;
                    }else
                      this._isEnteCoinvoltoModificabile = false;
                    tmp.push(enteCoinvolto.enteCoinvoltoIntervento!)
                  }
                })

                return tmp;
          }),
          catchError(error=>{
            this.error=error;
            return of([]);
          })
        )
  }

  deleteEnteCoinvolto(idEnteCoinvolto:string){    
    if (this.isEliminabile) {
      this.entiCoinvoltiService.deleteEnteCoinvoltoIntervento(idEnteCoinvolto,this.homeBag.userInfo.codFisc!).subscribe({
        next: () => {
          this.openDialog("Avviso",
                  ["Cancellazione avvenuta con successo."],
                  "card-body--success");
        },
        error(error) {
          this.error=error;
          return of([]);
        },
        complete: () => {
          this.handelEntiCoinvolti()
        }
      })
    } else if (this.isEliminabileDaModello) { //Eliminazione ente coinvolto derivante da modello
      this.entiCoinvoltiService.deleteEntiCoinvoltiInterventoModello(idEnteCoinvolto, this.intervento.idIntervento!, this.homeBag.userInfo.codFisc!).subscribe({
        next: () => {
          this.openDialog("Avviso",
                  ["Cancellazione avvenuta con successo."],
                  "card-body--success");
        },
        error(error) {
          this.error=error;
          return of([]);
        },
        complete: () => {
          this.handelEntiCoinvolti();
        }

      })
    }
  }
  updateEnteCoinvolto(dati: any[]){
    let ente:EnteCoinvoltoIntervento = dati[0];
    let dialogEnte: MatDialogRef<any, any> = dati[1];
    this.entiCoinvoltiService.updateEnteCoinvoltoIntervento(ente,this.homeBag.userInfo.codFisc!).
    pipe(
      catchError(error=>{
        this.error=error;
        return of([]);
      })).subscribe({
        next: () => dialogEnte.close(),
        complete: () => {
          this.handelEntiCoinvolti();
        }})
  }
  //########################### Destinatari intervento non individuale #############



  getDestinatarioTabella(idDestinatario:number):Destinatario{
    let dest:Destinatario=this.destinatari.find(dest=>dest.idDestinatario==idDestinatario)!
    return dest;
  }

  createIcons():InfoColumnActionSettingModel[]{
    let icons:InfoColumnActionSettingModel[]=[]
    icons.push(this.getExpandIcon())
    if(this.isModificabile){
      icons.push(this.getEditIcon())
    }else{
      icons.push(this.getViewIcon())
    }
    return icons
  }

  getViewIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.EYE_ICON,
        "icon",
        "visualizza",
        (row) => {
          this.handleViewDestinatario(this.getDestinatarioTabella(row.idDestinatario))
        },
        "visualizza dati destinatario");
  }

  getEditIcon(){
    return new InfoColumnActionSettingModel(
        IconsSettings.PEN_ICON,
        "icon",
        "modifica",
        (row) => {
          this.handleEditDestinatario(this.getDestinatarioTabella(row.idDestinatario))
        },
        "modifica dati destinatario");
  }

  getExpandIcon(){
    return  new InfoColumnActionSettingModel(
      'expand',
      "icon",
      "",
      (row) => {
        this.destinatarioService.getServiziForDestinatarioIntervento(row.idDestinatario,this.intervento.idIntervento!)
        .subscribe({
          next:ris=>{
            if(ris.length>0 && !row.extendedContent){
              row.extendedContent=ris.map(ser=>{
                return ser.titoloServizio
              })
            }
          }
        })
      }
    )
  }


  handleViewDestinatario(destinatario:Destinatario){
    this.dialog.open(DialogDestinatarioComponent, {
      data: new DialogSettings(
        "",[],"","",
        [],
        [destinatario,true] // true = soloView
      )
    })
  }

  handleEditDestinatario(destinatario: Destinatario){
    this.modaleDestinatari = this.dialog.open(DialogDestinatarioComponent, {
      data: new DialogSettings(
        "",[],"","",
        [new DialogButton(
          "Annulla",
          "btn btn--outline-primary",undefined,"annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--primary",
          (destinatario)=>{this.onConfermaModificaDestinatario(destinatario)}
        )],
        [destinatario,false]
      )
    })
  }

  onConfermaModificaDestinatario(destinatario: Destinatario){
    destinatario.gruppoOperatoreAggiornamento = this.homeBag.gruppoOperatore;
    destinatario.codOperatoreAggiornamento = +this.homeBag.codiceOperatore;
    destinatario.codUserAggiorn = this.homeBag.userInfo.codFisc;
    destinatario.dAggiorn = new Date();

    this.destinatarioService
        .aggiornaDestinatario(destinatario).
        pipe()
        .subscribe(
          resp=> {
            this.destinatario = resp;
            this.modaleDestinatari.close();
            this.destinatari.splice(
              this.destinatari.findIndex(dest => dest.codiceFiscaleDestinatario == resp.codiceFiscaleDestinatario),1
            );
            this.destinatari.push(resp);
          }
        )

  }


  createTable(){
    this.tableSettings.listBoolView=[false,true,true];

    this.tableSettings.enableExpansion=true;
    this.tableSettings.enableExport=false;
    this.tableSettings.enablePagination=false;
    this.tableSettings.enableButtons=false;
    this.createColumnsTable();
  }

  createColumnsTable(){
    const codFiscColumn = new ColumnSettingsModel(
      'codFisc',
      'Codice fiscale',
      false,
      'simple'
    );
    const cognomeColumn = new ColumnSettingsModel(
      'cognome',
      'Cognome',
      false,
      'simple'
    );
    const nomeColumn = new ColumnSettingsModel(
      'nome',
      'Nome',
      false,
      'simple'
    );
    const dataNascitaColumn = new ColumnSettingsModel(
      'dataNascita',
      'Data di nascita',
      false,
      'simple'
    );
    const luogoNascitaColumn = new ColumnSettingsModel(
      'luogoNascita',
      'Luogo di nascita',
      false,
      'simple'
    );
    const customActionColumn = new ColumnSettingsModel(
      'icons',
      '',
      true,
      'customAction'
    );
    this.columnList.push(...[
      codFiscColumn,
      cognomeColumn,
      nomeColumn,
      dataNascitaColumn,
      luogoNascitaColumn,
      customActionColumn
    ]);
  }

  // per forzare il reload del component, lo faccio scomparire per una frazione di secondo
  // e lo faccio riapparire al prossimo giro di eventi
  ricaricaEntiCoinvolti() {
    this.hideEntiCoinvolti = true;
    setTimeout(() => {
      this.handelEntiCoinvolti();
      this.hideEntiCoinvolti = false;
    }, 0);
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
}
