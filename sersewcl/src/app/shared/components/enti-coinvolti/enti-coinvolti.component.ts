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

import { Component, EventEmitter, Input, OnInit, Output, OnChanges, SimpleChanges } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

//-Models
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { InfoColumnActionSettingModel } from '@shared/model/table-setting.model';
import { DialogButton,DialogSettings } from '@shared/model/dialog-settings.model';
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { EnteCoinvoltoServizio } from '@core/api-serse/model/enteCoinvoltoServizio';

//-Services
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';

//-Const
import { IconsSettings } from '@shared/const/icons-settings';

//-Components
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogEntiComponent } from '../dialog-enti/dialog-enti.component';
import { HomeBagService } from '@home/services/home-bag.service';

@Component({
  selector: 'app-enti-coinvolti',
  templateUrl: './enti-coinvolti.component.html',
  styleUrls: ['./enti-coinvolti.component.scss'],
})
export class EntiCoinvoltiComponent implements OnInit, OnChanges{

  @Input("entiCoinvoltiAssociati$") entiCoinvoltiAssociati$!: Observable<(EnteCoinvoltoModello| EnteCoinvoltoIntervento| EnteCoinvoltoServizio)[]>;

  //nel caso di modello di intervento dal momento che anche quando pubblico permette di aggiungere enti isModificabile e
  //canAddEnte possono essere diversi, nel caso in cui il modello sia in stato pubblicato quindi isModificabile != canAddEnte
  //controllo che viene usato nel ngOnChanges per aggiornare i bottoni e le icone a seguito di un cambiamento di stato



  @Input() isModificabile:boolean = false;
  @Input() isEliminabile: boolean = false;
  @Input() canAddEnte:boolean = false;
  canAdd!:boolean;
  @Input() isIndividuale:boolean = false; //Interventi
  @Input() isEliminabileDaModello: boolean = false; //Interventi/Servizi
  @Input() isEliminabileDaIntervento: boolean = false; //Servizi

  @Input() isDestinatarioAssociato:boolean = false; //Servizi
  @Input() isAssociatoIntervento:boolean = false;
  @Input() userCase: string = 'MDI';

  @Input() backTo: string = "";

  enteSelezionato!:EnteCoinvoltoModello| EnteCoinvoltoIntervento| EnteCoinvoltoServizio;
  entiList:any[] = []; //-usiamo any perché altrimenti si arrabia per descrizioneRuoloEnte
  entiCessatiList:any[]=[]
  @Output() enteDaCancellare: EventEmitter<string> = new EventEmitter();
  @Output() enteDaAggiornare: EventEmitter<any[]> = new EventEmitter();

  dialogEnte!: MatDialogRef<any, any>;

  icons!:InfoColumnActionSettingModel[];
  iconsCessati:InfoColumnActionSettingModel[]=[];

  constructor(
    private entiService: EntiCoinvoltiService,
    private homeBag:HomeBagService,
    private router: Router,
    private dialog: MatDialog,
  ) {}

  ngOnInit(): void {
    this.canAdd = this.canAddEnte;
    this.icons = this.createIcons();
    this.iconsCessati?.push(this.getViewIcon())
    this.iconsCessati?.push(this.getEnteCessatoIcon())
  }

  fetchEnti(){
    this.entiCoinvoltiAssociati$
    .pipe(
      catchError((err)=> {return []})
    )
    .subscribe(risp => {
      if(this.userCase=="MDI"){
        let entiTmp: EnteCoinvoltoModello[]=[]
        entiTmp=risp

        this.entiList=[]
        this.entiCessatiList=[]

        this.entiList=entiTmp.filter(ente=>!ente.codUserCessazione)
        this.entiCessatiList=entiTmp.filter(ente=>ente.codUserCessazione)


      }else{
        this.entiList = []
        this.entiCessatiList=[]
        this.entiList = risp;
          if(this.userCase == 'INT'){
            if(this.entiList.length!=0 && this.isIndividuale || this.entiList.filter(e=>e.idEnteCoinvoltoModello).length!=0 || !this.isModificabile){
              this.canAdd = false;
            }
            else{
              this.canAdd = true;
            }
          }

          if(this.userCase == 'SER'){
            if((this.isIndividuale && this.entiList.length!=0) || (this.isAssociatoIntervento) || this.homeBag.selectedRuolo.codiceRuolo==='FUNZIONARIO_MASTER_SERSE'){
              this.canAdd = false;
            }else{
              this.canAdd = this.isModificabile;
            }
          }
      }
    });
  }
//-
  //---   ICONE
  createIcons(): InfoColumnActionSettingModel[] {
    let icons: InfoColumnActionSettingModel[] = [];
    if(this.isEliminabileDaModello || this.isEliminabileDaIntervento){
      icons.push(this.getViewIcon());
      icons.push(this.getDeleteIcon());
    }else if(this.isEliminabile){
      icons.push(this.getEditIcon());
      icons.push(this.getDeleteIcon());
    }else if(this.isModificabile) {
      icons.push(this.getEditIcon());
    }else if(this.userCase=="MDI"  && this.canAddEnte){
      icons.push(this.getViewIcon());
      icons.push(this.getCessazioneIcon());
    }else{
      icons.push(this.getViewIcon());
    }
    return icons;
  }

  getCessazioneIcon(){
    return new InfoColumnActionSettingModel(
      IconsSettings.CESSAZIONE_ENTE_ICON,
      'btn btn--plain-text--danger',
      'cessazione ente',
      (enteCoinvolto)=> this.handleCessazione(enteCoinvolto)
    );
  }
  getEnteCessatoIcon(){
    return new InfoColumnActionSettingModel(
      "report",
      'btn btn--plain-text--danger',
      'ENTE CESSATO'
    );
  }
  getEditIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.PEN_ICON,
      'btn btn--plain-text--primary',
      'modifica',
      (enteCoinvolto) => this.handleEdit(enteCoinvolto)
    );
  }
  getDeleteIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.TRS_ICON,
      'btn btn--plain-text--danger',
      'Elimina',
      (enteCoinvolto) => this.handleDelete(enteCoinvolto)
    );
  }
  getViewIcon() {
    return new InfoColumnActionSettingModel(
      IconsSettings.EYE_ICON,
      'btn btn--plain-text--primary',
      'visualizza',
      (enteCoinvolto) => this.handleView(enteCoinvolto)
    );
  }

  onAggiungiEnteButton() {
    this.entiService.entiCoinvolti = this.entiList;
    this.entiService.backTo = this.backTo;
    let url = {
      'MDI': '/dashboard/modello/enti',
      'INT': '/dashboard/intervento/enti',
      'SER': '/dashboard/servizio/enti'
    }[this.userCase] ?? '';
    this.router.navigate([url]);
  }
  handleView(enteCoinvolto:any) {
    let isEsterno = enteCoinvolto.idFonteDato ?false :true;
    this.dialog.open(DialogEntiComponent, {
      data: new DialogSettings(
        '',[],'','',[],
        [enteCoinvolto, //-enti
          isEsterno,         //-isEsterno
          false,          //-isNew
          this.userCase, //-userCase
        ]
      ),
      panelClass: "dialog-enti"
    });
  }
  handleDelete(enteCoinvolto: any) {
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Eliminazione ente',
        ['Confermi l’eliminazione dell’Ente Coinvolto selezionato?'],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
            let idEnte = {
              'MDI': enteCoinvolto.idEnteCoinvoltoModello,
              'INT': this.isEliminabileDaModello ? enteCoinvolto.idEnteCoinvoltoModello : enteCoinvolto.idEnteCoinvoltoIntervento,
              'SER': (this.isEliminabileDaModello && enteCoinvolto.idEnteCoinvoltoModello) || (this.isEliminabileDaIntervento && enteCoinvolto.idEnteCoinvoltoIntervento) || enteCoinvolto.idEnteConvoltoServizio
            }[this.userCase] ?? '';
            this.onConfermaEliminazione(idEnte);
          },"elimina ente"),
        ]
      ),
    });
  }
  onConfermaEliminazione(idEnteCoinvolto: string) {

    if(this.userCase=="SER" && this.isDestinatarioAssociato){
      this.dialog.open(DialogConfermaComponent, {
        data: new DialogSettings(
          'Eliminazione ente',
          ['Non è possibile eliminare enti perchè al servizio sono associati dei destinatari'],
          'card-body--warning',
          'Attenzione!')
            }
          );
      return;
    }
    this.enteDaCancellare.emit(idEnteCoinvolto);
  }

  handleEdit(enteCoinvolto: any) {
    let isEsterno = enteCoinvolto.idFonteDato ?false :true;
    this.dialogEnte = this.dialog.open(DialogEntiComponent, {
            data: new DialogSettings(
              '',[],'','',
              [new DialogButton(
                "Usato solo per il metodo","",
                (ente)=>{ this.updateEnte(ente)})],
              [enteCoinvolto,  //-enti
                isEsterno,     //-isEsterno
                false,         //-isNew
                this.userCase, //-userCase
              ]
            ),
            panelClass: "dialog-enti"

          });
  }

  updateEnte(ente: EnteCoinvoltoModello| EnteCoinvoltoIntervento| EnteCoinvoltoServizio) {

    this.enteDaAggiornare.emit([ente,this.dialogEnte]);
  }

  handleCessazione(enteCoinvolto:any){
    this.dialog.open(DialogConfermaComponent, {
      data: new DialogSettings(
        'Cessazione ente',
        ['La cessazione non è un\'azione reversibile. Confermi la cessazione?'],
        'card-body--warning',
        'Attenzione!',
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
            this.onConfermaCessazione(enteCoinvolto);
          },"conferma cessazione ente"),
        ]
      ),
    });
  }


  onConfermaCessazione(ente:EnteCoinvoltoModello){
    let enteDaCessare:EnteCoinvoltoModello = {
      ...ente,
      codUserCessazione: this.homeBag.userInfo.codFisc
    }
    this.entiService.cessaEnteCoinvoltoModello(enteDaCessare).subscribe({
      next: () =>{
        this.dialog.open(DialogConfermaComponent, {
          data: new DialogSettings(
            'Cessazione ente',
            ['La cessazione è avvenuta con successo'],
            'card-body--success',
           ),

        })
        this.entiList.splice(this.entiList.find(e=>e.idEnteCoinvoltoModello==ente.idEnteCoinvoltoModello),1);
        this.entiCessatiList.push(ente);

      }

    })
  }

  //nel caso di modello di intervento dal momento che anche quando pubblico permette di aggiungere enti isModificabile e
  //canAddEnte possono essere diversi, nel caso in cui il modello sia in stato pubblicato quindi isModificabile != canAddEnte
  //controllo che viene usato nel ngOnChanges per aggiornare i bottoni e le icone a seguito di un cambiamento di stato

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['isModificabile'] || changes['entiCoinvoltiAssociati$'] || changes['canAddEnte']) {
      this.fetchEnti()
    }
    if(changes['isModificabile']){
      this.icons = this.createIcons();
      if((this.userCase == 'INT' && !this.canAdd)){
        return;
      }else if(this.userCase == 'MDI' && this.canAddEnte != this.isModificabile) {
        this.canAdd = true;
      }else {
        this.canAdd = this.isModificabile;
      }
    }
    if(changes['isEliminabileDaModello']){
      this.icons = this.createIcons();
    }
    if(changes['isEliminabileDaIntervento']){
      this.icons = this.createIcons();
    }

    if(changes['canAddEnte']){
      this.icons = this.createIcons();
      if(this.userCase == 'MDI' && this.canAddEnte != this.isModificabile){
        this.canAdd = true;
      }else{this.canAdd = this.isModificabile;}

    }

    if(changes['isDestinatarioAssociato']){
      this.isDestinatarioAssociato=changes['isDestinatarioAssociato'].currentValue
    }
  }

}
