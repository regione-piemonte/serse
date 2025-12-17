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

import { IncontriService } from '@incontri/services/incontri.service';
import { Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

//-Models
import { DatiPeculiari } from '@core/api-serse/model/datiPeculiari';
import { DatiPeculiariWrapper } from '@core/api-serse/model/datiPeculiariWrapper';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { Servizio } from '@core/api-serse/model/servizio';
import { TableSettingsModel, ColumnSettingsModel, InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';

//-Services
import { DestinatariService } from '@core/services/destinatari.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { ServiziService } from '@servizi/services/servizi.service';

//-Compoentns
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogDatiParticolariComponent } from '@shared/components/dialog-dati-particolari/dialog-dati-particolari.component';
import { DialogDestinatarioComponent } from '@shared/components/dialog-destinatario/dialog-destinatario.component';

//-Const
import { IconsSettings } from '@shared/const/icons-settings';


import * as XLSX from 'xlsx';
import { InterventiService } from '@interventi/services/interventi.service';
import { CondizioneOccupazionaleIgrue } from '@core/api-serse/model/condizioneOccupazionaleIgrue';
import { TitoloStudioIgrue } from '@core/api-serse/model/titoloStudioIgrue';
import { DestinatarioServizio } from '@core/api-serse/model/destinatarioServizio';
import { DettaglioClasseDestinatarioServizio } from '@core/api-serse/model/dettaglioClasseDestinatarioServizio';

@Component({
  selector: 'app-servizio-destinatari',
  templateUrl: './servizio-destinatari.component.html',
  styleUrls: ['./servizio-destinatari.component.scss']
})
export class ServizioDestinatariComponent implements OnInit, OnDestroy, OnChanges {

  @Input() isModificabile = true
  servizioSelected: Servizio = {};
  data: Destinatario[] = [];

  destinatario: Destinatario | undefined = {};
  datiPeculiari: DatiPeculiariWrapper | undefined = {};

  classeDestinatarioServizio: DettaglioClasseDestinatarioServizio | undefined = {};

  //dati peculiari del servizio
  datiPeculiariServizio: DatiPeculiariWrapper | undefined = {};
  titoliDIStudio: TitoloStudioIgrue[] = [];
  titoloDiStudio: string = "";
  condizioniOcuppazionale: CondizioneOccupazionaleIgrue[] = [];
  condizioneOccupazionale: string = ""

  //-Table
  rowData: SimpleDestinatario[] = [];
  tableSettings: TableSettingsModel = new TableSettingsModel();
  columnList: ColumnSettingsModel[] = [];

  _canAdd: boolean = true;
  esistonoIncontriChiusi = false;

  sub?: Subscription;

  modaleDatinCorrelati: any;
  modaleDestinatari: any;

  isDatiExcelCorretti: boolean = true;
  listaErroriCaricamentoFile: ErroreCaricamento[] = [];




  constructor(
    private serviziService: ServiziService,
    private destinatariService: DestinatariService,
    private interventoService: InterventiService,
    private incontriService: IncontriService,
    private router: Router,
    private dialog: MatDialog,
    private homeBagService: HomeBagService,) {
    this.rowData = [];
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes["isModificabile"]) {
      this._canAdd = this.canAddDest()
      this.rowData.forEach(r => r.icons = this.createIconsDestinatari())
    }
  }

  ngOnInit(): void {

    this.getDettaglioClasseServizio();
    this.destinatariService.getTitoliIgrue().subscribe({
      next: response => {
        this.titoliDIStudio = response
        if (this.servizioSelected.codTitoloStudioIgrue) {
          this.titoloDiStudio = this.titoliDIStudio.filter(tit => tit.codTitoloStudioIgrue == this.servizioSelected.codTitoloStudioIgrue)[0].descrTitoloStudioIgrue!
        }
      }
    })



    this.destinatariService.getCondizioneOccupazionaleIgrue().subscribe({
      next: response => {
        this.condizioniOcuppazionale = response
        if (this.servizioSelected.codCondizioneOccupazionaleIgrue) {
          this.condizioneOccupazionale = this.condizioniOcuppazionale.filter(cond => cond.codCondizioneOccupazionaleIgrue == this.servizioSelected.codCondizioneOccupazionaleIgrue)[0].descrCondizioneOccupazionaleIgrue!
        }
      }
    })

    // handling update service with BehaviourSubject
    this.sub = this.serviziService.selectionChangeServizio$.subscribe({
      next: ris => {
        // this.serviziService.setServizio(ris);
        this.servizioSelected = ris;
        this._canAdd = this.canAddDest()
      }
    });
    this.servizioSelected = this.serviziService.servizio;

    this.serviziService.verificaDatiPeculiariServizio(this.homeBagService.selectedSportello.numProgrSportello!, this.homeBagService.selectedPso.idPso!)
      .subscribe({
        next: resp => {
          this.datiPeculiariServizio = resp
        }
      })


    this.loadDestinatariServizio();

    this.createTable();

    this.incontriService.getIncontri(this.servizio.idServizio!).subscribe({
      next: incontri => {
        let unIncontroChiuso = incontri.find(x => x.statoIncontro?.idStatoIncontro == 40);
        this.esistonoIncontriChiusi = !!unIncontroChiuso;
      }
    });
  }

  getDettaglioClasseServizio() {
    this.serviziService.getClasseServizioByIdServzioAndIdPso(this.servizio.idServizio!, this.servizio.idPso!).subscribe({
      next: response => {
        this.classeDestinatarioServizio = response;
      }
    })
  }

  private loadDestinatariServizio() {
    this.serviziService.getDestinatariAssociati(this.servizioSelected.idServizio!.toString())
      .subscribe({
        next: (resp) => {
          this.data = resp;

          this.serviziService.getDestinatariServizio(this.servizioSelected.idServizio!.toString())
            .subscribe({
              next: (ris) => {
                let orderedRowData: DestinatarioServizio[] = [];
                ris.forEach(el => {
                  const foundItem = resp.find(item => item.idDestinatario === el.destinatario?.idDestinatario);
                  if (foundItem) {
                    el.destinatario = foundItem;
                    orderedRowData.push(el);
                  }
                });
                this.destinatariService.numDestinatAssoc = this.data.length;
                this.rowData = orderedRowData.map(destinatarioServizio => {
                  return {
                    numDest: destinatarioServizio.numerazioneDestinatario!,
                    codFisc: destinatarioServizio.destinatario?.codiceFiscaleDestinatario!,
                    nome: destinatarioServizio.destinatario?.nomeDestinatario!,
                    cognome: destinatarioServizio.destinatario?.cognomeDestinatario!,
                    dataNascita: new Date(destinatarioServizio.destinatario?.dNascita!).toLocaleDateString(),
                    luogoNascita: destinatarioServizio.destinatario?.comuneNascita ?
                      destinatarioServizio.destinatario?.comuneNascita.descrizioneComune + " (" + destinatarioServizio.destinatario?.comuneNascita.provincia?.siglaProvincia + ")" :
                      (destinatarioServizio.destinatario?.descrCittaEsteraNascita ? destinatarioServizio.destinatario?.descrCittaEsteraNascita.toUpperCase() + " (" + destinatarioServizio.destinatario?.statoEsteroNascita?.decrizioneStato : "(" + destinatarioServizio.destinatario?.statoEsteroNascita?.decrizioneStato)! + ")",
                    icons: this.createIconsDestinatari()
                  };

                }

                );
                this._canAdd = this.canAddDest();
              }
            });
        }
      }
      );
  }

  ngOnDestroy(): void {
    this.sub?.unsubscribe()
  }

  //------------------------------------------------------
  canAddDest(): boolean {
    let ris = true
    if (this.servizioSelected.statoServizio?.idStatoServizio == 40) {
      ris = false
    }
    if (this.servizioSelected!.numMaxDestinatari! <= this.rowData.length) {
      ris = false
    }
    if (this.servizioSelected!.servizioRegionale?.codFinalitaServizio == "I" && this.rowData.length != 0) {
      ris = false
    }
    if (!this.isModificabile) {
      ris = false
    }
    return ris;
  }
  //------------------------------------------------------
  onAggiungiDestinatario() {
    this.destinatariService.backTo = this.router.url;

    this.destinatariService.destAlreadyAssoc = this.data.map(dest => dest.codiceFiscaleDestinatario!);
    this.destinatariService.numDestinatAssoc = this.data.length;
    this.router.navigate((['/dashboard/servizio/destinatari']))
  }

  //------------------------------------------------------
  //- Table
  createTable() {
    this.tableSettings.title = "";
    this.tableSettings.enablePagination = false;
    this.createColumnsTable();
  }
  createColumnsTable() {
    const numDestinatarioColumn = new ColumnSettingsModel(
      'numDest',
      'Numero Destinatario',
      false,
      'simple'
    );
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
      numDestinatarioColumn,
      codFiscColumn,
      cognomeColumn,
      nomeColumn,
      dataNascitaColumn,
      luogoNascitaColumn,
      customActionColumn
    ]);
  }
  createIconsDestinatari(): InfoColumnActionSettingModel[] {
    let icons: InfoColumnActionSettingModel[] = [];
    icons.push(this.getDatiCorrIcon());
    if (!this.isModificabile) {
      icons.push(this.getViewIcon())

    } else {
      icons.push(this.getEditIcon());

      if (!this.interventoService.intervento.tipoIntervento?.flgProgettazioneIndividuale) {
        icons.push(this.getDeleteIcon())
      }
    }
    return icons
  }


  getViewIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.EYE_ICON,
      "icon",
      "visualizza",
      (row) => {
        this.openDestinatario(row.codFisc, false);
      }, "visualizza dati destinatario"
    );
  }
  getEditIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.PEN_ICON,
      "icon",
      "modifica",
      (row) => {
        this.openDestinatario(row.codFisc, this.isModificabile);
      }, "modifica dati destinatario"
    );
  }
  getDeleteIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.TRS_ICON,
      "icon",
      "Elimina",
      (row) => {
        if (!this.isModificabile) {
          // questo non dovrebbe succedere
          console.error("isModificabile = false")
          return;
        }
        // recuperare l'id aprire modale per conferma
        this.apriModaleConferma(this.data.find(dest => dest.codiceFiscaleDestinatario == row.codFisc.toString())!.idDestinatario!.toString(), row.codFisc);
      }, "elimina dati destinatario"
    );
  }
  getDatiCorrIcon() {
    let ariaLabel = ""
    return new InfoColumnActionSettingModel(
      IconsSettings.DATI_CORR_ICON,
      "icon",
      "Dati Peculiari",
      (row) => {
        this.destinatario = this.data.find(dest => dest.codiceFiscaleDestinatario == row.codFisc.toString())
        this.destinatariService.getDatiPeculiari(this.destinatario?.idDestinatario!, this.serviziService.servizio?.idServizio!, this.homeBagService.selectedPso.idPso!, this.homeBagService.selectedSportello.numProgrSportello!).subscribe(
          {
            next: response => {
              this.datiPeculiari = response
              if (this.isModificabile) {
                ariaLabel = "modifica dati particolari del destinatario"
                this.modaleDatinCorrelati = this.dialog.open(DialogDatiParticolariComponent,
                  {
                    width: '60vw',

                    data: new DialogSettings(
                      "", [], "", "",
                      [new DialogButton(
                        "Annulla",
                        "btn btn--outline-primary", undefined, "annulla"),
                      new DialogButton(
                        "Conferma",
                        "btn btn--primary",
                        (datiPeculiari) => { this.onConfermaModificaDatiParticolari(datiPeculiari) }
                        , "conferma modifica dati particolari")],
                      [this.destinatario, this.datiPeculiari, undefined, undefined, this.servizioSelected.idPso]
                    )
                  }
                )
              } else {
                ariaLabel = "visualizza dati particolari del destinatario"
                this.modaleDatinCorrelati = this.dialog.open(DialogDatiParticolariComponent,
                  {
                    data: new DialogSettings(
                      "", [], "", "",
                      [
                        new DialogButton(
                          "Annulla",
                          "btn btn--outline-primary", undefined, "chiudi finestra")
                      ],
                      [this.destinatario, this.datiPeculiari, undefined, undefined, this.servizioSelected.idPso]
                    )
                  }
                )
              }
            }
          }
        )
      }, ariaLabel
    )
  }

  //------------------------------------------------------
  //- Elimina destinatario
  apriModaleConferma(id: string, codFisc: string) {
    this.destinatariService.getIncontriForDestinatario(id).subscribe({
      next: ris => {
        let isEliminabile = true;
        if (ris.length > 0) {
          ris.forEach(incontro => {
            if (incontro.idServizio == this.servizio.idServizio) {
              isEliminabile = false
              this.openModaleErrore(["Attenzione", "impossibile eliminare il destinatario perchè è associato a degli incontri"])
            }
          })
        }
        if (isEliminabile) {
          this.dialog.open(DialogConfermaComponent, {
            data: new DialogSettings(
              "Rimozione destinatario",
              ["si è sicuri di voler eliminare il destinatario dal servizio",
                "Confermi l'eliminazione"],
              "card-body--warning",
              "Attenzione!",
              [new DialogButton(
                "Annulla",
                "btn btn--outline-primary", undefined, "annulla"),
              new DialogButton(
                "Conferma",
                "btn btn--danger",
                () => { this.disassociaDestinatario(id, codFisc) },
                "conferma rimozione destinatario da servizio"
              )]
            )
          });
        }
      }
    })
  }

  disassociaDestinatario(idDestinatario: string, codFisc: string) {
    this.destinatariService.disassociaDestinatarioAservizio(this.servizioSelected.idServizio!.toString(), idDestinatario)
      .subscribe({
        next: response => {
          if (response.message == "cancellazione avvenuta con successo") {
            this.openDialog("Avviso", [response.message], "card-body--success")

            this.rowData.splice(this.rowData.findIndex((data) => data.codFisc == codFisc), 1);
            this.data.splice(this.data.findIndex((data) => data.codiceFiscaleDestinatario == codFisc), 1);
            this.rowData = [...this.rowData];
            this.destinatariService.numDestinatAssoc -= 1;


            this._canAdd = this.canAddDest()

          } else {
            this.openModaleErrore([response.message!])
          }
        }
      })
  }

  openDestinatario(codFisc: string, isModificabile: boolean) {
    //let idDestinatario= this.data.find(dest=>dest.codiceFiscaleDestinatario==codFisc)?.idDestinatario;
    this.destinatario = this.data.find(dest => dest.codiceFiscaleDestinatario == codFisc);

    if (isModificabile) {
      this.apriModaleModificaDestinatario()
    }
    else {
      this.apriModaleVisualizzaDestinatario()
    }

  }
  apriModaleVisualizzaDestinatario() {
    let destinatario: Destinatario = this.destinatario!;
    this.dialog.open(DialogDestinatarioComponent, {
      data: new DialogSettings(
        "", [], "", "",
        [],
        [destinatario, true] //-Destinatari, soloView
      )
    })
  }
  apriModaleModificaDestinatario() {
    let destinatario: Destinatario = this.destinatario!;
    this.modaleDestinatari = this.dialog.open(DialogDestinatarioComponent, {
      data: new DialogSettings(
        "", [], "", "",
        [new DialogButton(
          "Annulla",
          "btn btn--outline-primary", undefined, "annulla"),
        new DialogButton(
          "Conferma",
          "btn btn--primary",
          (destinatario) => { this.onConfermaModificaDestinatario(destinatario) }
        )],
        [destinatario]
      )
    })
  }

  onConfermaModificaDestinatario(destinatario: Destinatario) {
    destinatario.gruppoOperatoreAggiornamento = this.homeBagService.gruppoOperatore;
    destinatario.codOperatoreAggiornamento = +this.homeBagService.codiceOperatore;
    destinatario.codUserAggiorn = this.homeBagService.userInfo.codFisc;
    destinatario.dAggiorn = new Date();

    this.destinatariService
      .aggiornaDestinatario(destinatario).
      pipe()
      .subscribe(
        resp => {
          this.destinatario = resp;
          this.modaleDestinatari.close();
          this.data.splice(
            this.data.findIndex(dest => dest.codiceFiscaleDestinatario == resp.codiceFiscaleDestinatario), 1
          );
          this.data.push(resp);
        }
      )

  }
  onConfermaModificaDatiParticolari(datiPeculiari: DatiPeculiari) {
    this.destinatariService.aggiornaDatiPeculiariDest(datiPeculiari).subscribe(
      resp => {
        this.datiPeculiari = resp
        this.modaleDatinCorrelati.close()
      })
  }
  modificaDatiPeculiariServizio() {
    this.serviziService.verificaDatiPeculiariServizio(this.homeBagService.selectedSportello.numProgrSportello!, this.homeBagService.selectedPso.idPso!)
      .subscribe({
        next: resp => {
          this.datiPeculiariServizio = resp
          this.modaleDatinCorrelati = this.dialog.open(DialogDatiParticolariComponent,
            {
              data: new DialogSettings(
                "", [], "", "",
                [new DialogButton(
                  "Annulla",
                  "btn btn--outline-primary"),
                new DialogButton(
                  "Conferma",
                  "btn btn--primary",
                  (datiPeculiariServizio) => { this.onConfermaModificaDatiParticolariServizio(datiPeculiariServizio) },
                  "conferma modifica dati peculiari del servizio"
                )],
                [undefined, this.datiPeculiariServizio, this.servizioSelected, this.classeDestinatarioServizio, this.servizioSelected.idPso]
              )
            }
          )
        }
      })

  }

  onConfermaModificaDatiParticolariServizio(datiPeculiariServizio: Servizio) {
    this.serviziService.updateDatiPeculiariServizio(datiPeculiariServizio).subscribe({
      next: ris => {
        this.servizioSelected = datiPeculiariServizio;
        this.getDettaglioClasseServizio();
        this.serviziService.setServizio(datiPeculiariServizio)
        if (this.servizioSelected.codCondizioneOccupazionaleIgrue) {
          this.condizioneOccupazionale = this.condizioniOcuppazionale.filter(cond => cond.codCondizioneOccupazionaleIgrue == this.servizioSelected.codCondizioneOccupazionaleIgrue)[0].descrCondizioneOccupazionaleIgrue!
        }

        if (this.servizioSelected.codTitoloStudioIgrue) {
          this.titoloDiStudio = this.titoliDIStudio.filter(tit => tit.codTitoloStudioIgrue == this.servizioSelected.codTitoloStudioIgrue)[0].descrTitoloStudioIgrue!
        }
        this.openDialog("", ["aggiornamento avvenuto con successo"], "card-body--success")
      }
    }
    )
    this.modaleDatinCorrelati.close();
  }
  //---------------------------------------------------------------------
  //- Dialog
  openDialog(title: string, msg: string[], cssClass: string, buttons?: DialogButton[]) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(title, msg, cssClass, "", buttons)
    })
  }
  openModaleErrore(msg: string[]) {
    this.openDialog("Errore", msg, "card-body--danger")
  }
  openModaleAttenzione(msg: string[]) {
    this.openDialog("Attenzione", msg, "card-body--warning")
  }
  openOkDialog(msg: string[], action?: () => void) {
    let button: DialogButton = new DialogButton('OK', 'btn btn--success', action, "OK")
    this.openDialog("Avviso", msg, "card-body--success", [button])
  }

  //---------------------------------------------------------------------
  //- File Handler
  file?: File;
  arrayBuffer: any;
  arrayColumnFile = [
    "CODICE FISCALE", "Cognome", "Nome", "Data di nascita",
    "LUOGO NASCITA (Italia o estero)", "Comune di nascita", "Stato estero di nascita", "Città estera nascita",
    "LUOGO RESIDENZA (Italia o estero)", "Comune di residenza", "Cap residenza", "Stato estero di residenza", "Città estera residenza", "Indirizzo residenza",
    "Comune domicilio", "Indirizzo  domicilio", "Cap domicilio",
    "Cittadinanza",
    "Recapito telefonico", "Recapito email",

    "Codice comune nascita", "Codice Fiscale Comune", "Codice stato nascita", "Codice Fiscale Stato",
    "codice comune residenza", "codice stato residenza",
    "codice comune domicilio",
    "codice cittadinanza"];
  addfile(event: any) {
    this.file = event.target.files[0];
    let fileReader: FileReader | null = new FileReader();
    fileReader.readAsArrayBuffer(this.file!);
    fileReader.onload = (e) => {
      this.arrayBuffer = fileReader!.result;
      let data = new Uint8Array(this.arrayBuffer);
      let arr = new Array();


      for (let i = 0; i < data.length; ++i) arr[i] = String.fromCharCode(data[i]);

      let bstr = arr.join("");
      let workbook = XLSX.read(bstr, { type: "binary" });
      let first_sheet_name = workbook.SheetNames[0];
      let worksheet = workbook.Sheets[first_sheet_name];

      //--------------------------------------------------------------------------
      //-----------Controllo Colonne
      const headerRow = XLSX.utils.sheet_to_json(worksheet, { raw: false, header: 1 })[0];
      //-Controllo che tutte le colonne sono presenti
      let columnMap: Record<string, boolean> = {};
      for (const columnName of this.arrayColumnFile) {
        columnMap[columnName] = false;
      }
      (<any>headerRow).forEach((element: any) => {
        columnMap[element] = true;
      });
      const allValuesTrue = Object.values(columnMap).every(value => value === true);
      if (!allValuesTrue) {
        this.openModaleAttenzione(["Il file che si sta cercando di caricare è stato modificato o non è aggiornato, provare ad importare i dati su un file che si è sicuri essere corretto, se si hanno dubbi su come fare invitiamo a seguire la relativa voce nella guida"])
        console.log(columnMap)
        event.target.value = '';
        return;
      }
      //--------------------------------------------------------------------------

      let arraylist = XLSX.utils.sheet_to_json(worksheet, { raw: true });
      let rowCompiled = arraylist.filter(a => (<any>a)['CODICE FISCALE']); //-Prendo solo le righe compilate (cioè quelle con il codice fiscale)

      this.hanlderArrayDestinatari(rowCompiled)
      // Reset dell'input file
      event.target.value = '';
    }
  }

  @ViewChild('listaDest') listaDialog!: TemplateRef<any>;
  destinatariToUpload: WrapperDestintario[] = [];
  dialogErrori: any;
  hanlderArrayDestinatari(array: any) {
    this.destinatariToUpload = array.map((a: any) => this.fromXLSXToDestinatari(a));


    if (!this.checkDestinatariCorrect()) {


      this.dialogErrori = this.dialog.open(this.listaErroriDialog, {
        width: '70vw',
      });

      return;
    }
    //-Controllo lunghezza
    if (this.data.length + this.destinatariToUpload.length > this.servizio.numMaxDestinatari!) {
      this.openModaleAttenzione(["Numero destinatari presenti nel file è maggiore di quelli inseribili"])
      return;
    }

    //-controllo della correttezza dei destinatari
    this.checkDestinatariCodiceFiscale();

    this.toLoad = true;
    this.dialogDestinataari = this.dialog.open(this.listaDialog, {
      width: '70vw',
    });
  }

  get ciSonoDestinatariCaricabili(): boolean {
    return this.destinatariToUpload && this.destinatariToUpload.find(w => w.isOk || w.chexkBox) !== undefined;
  }

  checkDestinatariCorrect(): boolean {
    let datiObbligatoriPresenti = true;
    this.listaErroriCaricamentoFile = [];
    this.destinatariToUpload.forEach(destW => {
      let dest = destW.destinatario;
      //-Nome , Cognome, dataNascita, Codice fiscale, Cittadinanza
      let checkAnagrafica: boolean = (!!dest.nomeDestinatario &&
        !!dest.cognomeDestinatario &&
        !!dest.dNascita &&
        !!dest.codiceFiscaleDestinatario &&
        !!dest.codCittadinanza)
      //-luogo nascita
      let checkLuogoNascita = ((!!dest.comuneNascita?.codiceIstatComune && dest.comuneNascita?.codiceIstatComune !== "undefined") ||
        (!!dest.statoEsteroNascita?.codStato)
      )
      //-residenza
      let checkLuogoResidenza: boolean = ((!!dest.comuneResidenza?.codiceIstatComune && dest.comuneResidenza?.codiceIstatComune !== "undefined" && !!dest.indirizzoResidenza) ||
        (!!dest.statoEsteroResidenza?.codStato &&
          !!dest.descrCittaEsteraResidenza)
      )
      //-recapiti
      let checkRecapiti: boolean = true
      if ((dest.recapitoMail != undefined && dest.recapitoMail.length > 100)) {
        checkRecapiti = false
      }
      if ((dest.recapitoTelefonico != undefined && dest.recapitoTelefonico.length > 50)) {
        checkRecapiti = false
      }

      datiObbligatoriPresenti = datiObbligatoriPresenti &&
        (checkAnagrafica && checkLuogoNascita && checkLuogoResidenza && checkRecapiti)
      if (!(checkAnagrafica && checkLuogoNascita && checkLuogoResidenza && checkRecapiti)) {
        this.listaErroriCaricamentoFile.push(this.createErroreCaricamento(destW));
      }
    });
    this.isDatiExcelCorretti = datiObbligatoriPresenti;
    return datiObbligatoriPresenti;
  }
  fromXLSXToDestinatari(dest: any): WrapperDestintario {
    let destJSon = dest as { [key: string]: any };

    destJSon = this.allToUpper(destJSon);

    let dNascitaCheck = destJSon['Data di nascita'];
    let tmp = false;
    let data = new Date()
    let capResidenzaCheck = destJSon['Cap residenza'];
    let capDomicilioCheck = destJSon['Cap domicilio'];
    if (isNaN(dNascitaCheck)) {
      tmp = true
      //per evitare che quando gli utenti inseriscono l'apostrofo all'inizio della
      //cella si rompa tutto dobbiamo fare questo, perchè viene letta come stringa e non come numero

      let partiData = dNascitaCheck.split('/');
      data = new Date(partiData[2], partiData[1] - 1, partiData[0]);

    }



    return {
      isOk: true,
      chexkBox: false,

      destinatario: {
        // idDestinatario?: number;
        codiceFiscaleDestinatario: destJSon['CODICE FISCALE'],
        // flgForzaturaControlCF?: string;
        cognomeDestinatario: destJSon['Cognome'],
        nomeDestinatario: destJSon['Nome'],
        dNascita: tmp ? data : new Date((dNascitaCheck - 25569) * 86400 * 1000),

        comuneNascita: String(destJSon['LUOGO NASCITA (Italia o estero)']).toUpperCase() == "ITALIA" ?
          {
            codiceIstatComune: String(this.addZeroCodiceComune(String(destJSon['Codice comune nascita']))),
            codiceFiscaleComune: destJSon['Codice Fiscale Comune'],
          } : undefined,
        statoEsteroNascita: String(destJSon['LUOGO NASCITA (Italia o estero)']).toUpperCase() != "ITALIA" ?
          {
            codStato: Number(destJSon['Codice stato nascita']),
            statoCodFiscale: destJSon['Codice Fiscale Stato'],
          } : undefined,
        descrCittaEsteraNascita: String(destJSon['LUOGO NASCITA (Italia o estero)']).toUpperCase() != "ITALIA" ?
          destJSon['Città estera nascita']
          : undefined,


        //-----------------------------------------------------------
        //--Residenza
        //-luogo di nascita
        comuneResidenza: String(destJSon['LUOGO RESIDENZA (Italia o estero)']).toUpperCase() == "ITALIA" ?
          {
            codiceIstatComune: String(this.addZeroCodiceComune(String(destJSon['codice comune residenza'])))
          } : undefined,
        capResidenza: destJSon['Cap residenza'],
        indirizzoResidenza: destJSon['Indirizzo residenza'],

        statoEsteroResidenza: String(destJSon['LUOGO RESIDENZA (Italia o estero)']).toUpperCase() != "ITALIA" ?
          {
            codStato: Number(destJSon['codice stato residenza'])
          } : undefined,
        descrCittaEsteraResidenza: String(destJSon['LUOGO RESIDENZA (Italia o estero)']).toUpperCase() != "ITALIA" ?
          destJSon['Città estera residenza']
          : undefined,

        //-----------------------------------------------------------
        //--DOMICILIO
        comuneDomicilio: destJSon['codice comune domicilio'] != '' ?
          {
            codiceIstatComune: String(this.addZeroCodiceComune(String(destJSon['codice comune domicilio'])))
          } : undefined,
        indDomicilio: destJSon['codice comune domicilio'] != '' ? destJSon['Indirizzo  domicilio'] : undefined,
        capDomicilio: destJSon['codice comune domicilio'] != '' ? destJSon['Cap domicilio'] : undefined,

        //-----------------------------------------------------------
        //--RECAPITI
        recapitoMail: destJSon['Recapito email'],
        recapitoTelefonico: destJSon['Recapito telefonico'],

        //-----------------------------------------------------------
        //--Cittadinanza
        codCittadinanza: destJSon['codice cittadinanza'],



        gruppoOperatoreInserimento: this.homeBagService.gruppoOperatore,
        codOperatoreInserimento: Number(this.homeBagService.codiceOperatore),
        codUserInserim: this.homeBagService.userInfo.codFisc,
        dInserim: new Date,

        gruppoOperatoreAggiornamento: this.homeBagService.gruppoOperatore,
        codOperatoreAggiornamento: Number(this.homeBagService.codiceOperatore),
        codUserAggiorn: this.homeBagService.userInfo.codFisc,
        dAggiorn: new Date
      }
    }
  }

  allToUpper(obj: { [key: string]: any }): { [key: string]: any } {
    const nuovoOggetto: { [key: string]: any } = {};

    for (const chiave in obj) {
      if (obj.hasOwnProperty(chiave)) {
        const valore = obj[chiave];

        if (typeof valore === 'string') {
          nuovoOggetto[chiave] = valore.toUpperCase();
        } else {
          nuovoOggetto[chiave] = valore;
        }
      }
    }

    return nuovoOggetto;
  }


  createErroreCaricamento(destErr: WrapperDestintario): ErroreCaricamento {
    /*codFisc?: string,
   cognome?:string,
   nome?:string,
   dataNascita?: string,
   luogoNascita?:string,
   codCittadinanza?: string,
   luogoRsidenza?:string*/
    return {
      codFisc: destErr.destinatario.codiceFiscaleDestinatario ? destErr.destinatario.codiceFiscaleDestinatario : "codice fiscale mancante",
      cognome: destErr.destinatario.cognomeDestinatario ? "" : "cognome ",
      nome: destErr.destinatario.nomeDestinatario ? "" : "nome ",
      dataNascita: destErr.destinatario.dNascita ? "" : "data di nascita ",
      luogoNascita: ((!!destErr.destinatario.comuneNascita?.codiceIstatComune && destErr.destinatario.comuneNascita?.codiceIstatComune !== "undefined") ||
        (!!destErr.destinatario.statoEsteroNascita?.codStato)) ? "" : "luogo di nascita ",
      codCittadinanza: destErr.destinatario.codCittadinanza ? "" : "codice cittadinanza ",
      luogoRsidenza: ((!!destErr.destinatario.comuneResidenza?.codiceIstatComune && destErr.destinatario.comuneResidenza?.codiceIstatComune !== "undefined" && !!destErr.destinatario.indirizzoResidenza) ||
        (!!destErr.destinatario.statoEsteroResidenza?.codStato &&
          !!destErr.destinatario.descrCittaEsteraResidenza)) ? "" : "residenza",
      recapitoMail: (destErr.destinatario.recapitoMail != undefined && destErr.destinatario.recapitoMail.length > 100) ? "campo mail troppo lungo" : "",
      recapitoTelefonico: (destErr.destinatario.recapitoTelefonico != undefined && destErr.destinatario.recapitoTelefonico.length > 50) ? "campo telefono troppo lungo" : ""
    }
  }


  @ViewChild('erroriDati') listaErroriDialog!: TemplateRef<any>;




  addZeroCodiceComune(codComune: string): string {
    while (codComune.length < 6) {
      codComune = "0" + codComune;
    }
    return codComune;
  }

  dialogDestinataari: any;
  checkDestinatariCodiceFiscale() {
    this.destinatariToUpload.forEach(dest => {
      let codFiscNascita = dest.destinatario.comuneNascita ? dest.destinatario.comuneNascita.codiceFiscaleComune : dest.destinatario.statoEsteroNascita!.statoCodFiscale
      // dest.destinatario.comuneNascita.
      let codiciFisc = this.destinatariService.checkCodiceFiscale(
        dest.destinatario.nomeDestinatario!,
        dest.destinatario.cognomeDestinatario!,
        dest.destinatario.dNascita!,
        codFiscNascita!);
      if (codiciFisc[0] != dest.destinatario.codiceFiscaleDestinatario && codiciFisc[1] != dest.destinatario.codiceFiscaleDestinatario) {
        dest.isOk = false;
      }
    })
  }

  toLoad = true;
  // 200 inserito e associato
  // 210 associato
  // 400 non inserito
  // 401 errore DB
  onConfermaAssocia() {
    let destinatariArray = this.destinatariToUpload.filter(dest => dest.chexkBox || dest.isOk)
      .map(dest => dest.destinatario);


    this.destinatariService
      .postDestinatari(this.servizio.idServizio!.toString(),
        this.homeBagService.userInfo.codFisc!,
        destinatariArray)
      .subscribe({
        next: r => {
          this.toLoad = false;

          // mostro eventuali messaggi di errore
          r.filter(x => !x.stato || (+x.stato >= 400))
            .forEach((dest) => {
              let tmp = this.destinatariToUpload.find(d => d.destinatario.codiceFiscaleDestinatario === dest.destinatarioServizio?.destinatario?.codiceFiscaleDestinatario);
              if (tmp) tmp.description = dest.description;
            });

          //senza questo la vista della tabella non si aggiorna
          this.loadDestinatariServizio();

          this.dialogDestinataari.close();
          this.dialog.open(this.listaDialog, {
            width: '70vw',
          });

          // destinatariArray = i destinatari che sono stati inviati al server
          // rowdata = destinatari attualmente mostrati a video (prima dell'upload), verranno ricaricati
          // in maniera asincrona da loadDestinatariServizio()
          // r = gli stessi destinatariArray, ricevuti dal server
          // destinatariToUpload = la lista dei destinatari mostrati nel dialogo modale

          let numDestinatariCaricati = r.filter(x => x.stato && x.stato >= "200" && x.stato < "300").length;
          if (numDestinatariCaricati < destinatariArray.length) {
            this.openModaleErrore(["Attenzione: il salvataggio di uno o più destinatari non è andato a buon fine. Si prega di riprovare ed eventualmente contattare il servizio di assistenza"]);
          }
        },
        error: response => {
          console.error("ERROR", response);
          this.openModaleErrore(["Attenzione: il salvataggio dei dati non è andato a buon fine. Si prega di riprovare ed eventualmente contattare il servizio di assistenza"]);
        }
      })
  }

  onRicalcolaNumerazione(): void {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Ricalcola Numerazione Destinatari',
        ['Attenzione: la numerazione attuale verrà ricalcolata ed assegnata in base all’ordine di inserimento dei destinatari; si desidera proseguire?'],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary', undefined, "annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
            this.doRicalcolaNumerazione();
          }, "ricalcola numerazione destinatari"),
        ]
      ),
    });
  }

  doRicalcolaNumerazione() {
    this.destinatariService.rinumeraDestinatariServizio(this.serviziService.servizio.idServizio!).subscribe({
      next: () => {
        this.loadDestinatariServizio();
        this.openOkDialog(["Ricalcolo numerazione destinatari effettuata correttamente"]);
      },
      error: err => {
        console.error(err);
        this.openModaleErrore(["Il ricalcolo della numerazione non è stato possibile; si prega di riprovare in un secondo momento ed eventualmente contattare il servizio assistenza."]);
        this.loadDestinatariServizio();
      }
    });
  }

  //---------------------------------------------------------------------

  get isSaved() {
    return this.serviziService.isSaved
  }
  get servizio() {
    return this.serviziService.servizio
  }
  get canAdd() {
    return this._canAdd
  }
  get canRecalc() {
    return this.isModificabile
      && this.servizio?.statoServizio?.idStatoServizio != 40 /* NON CHIUSO */
      && !this.esistonoIncontriChiusi
      && this.rowData.length > 0
      ;
  }

  get excelValid() {
    return this.isDatiExcelCorretti
  }
  get isIndividuale() {
    return this.servizio.servizioRegionale?.codFinalitaServizio == 'I';
  }
}
export interface SimpleDestinatario {
  numDest?: number,
  codFisc: string,
  cognome: string,
  nome: string,
  dataNascita: string,
  luogoNascita: string,
  icons: InfoColumnActionSettingModel[]
}

interface WrapperDestintario {
  isOk?: boolean,
  chexkBox?: boolean,
  description?: string,

  destinatario: Destinatario
}

interface ErroreCaricamento {
  codFisc?: string,
  cognome?: string,
  nome?: string,
  dataNascita?: string,
  luogoNascita?: string,
  codCittadinanza?: string,
  luogoRsidenza?: string,
  recapitoMail?: string,
  recapitoTelefonico?: string
}
