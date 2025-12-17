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

import { tap } from 'rxjs';
import { Component, OnInit, Input, ViewChild, TemplateRef } from '@angular/core';
import { Partecipanti } from '@core/api-serse/model/partecipanti';
import { IconsSettings } from '@shared/const/icons-settings';
import { PartecipantiService } from '../../services/partecipanti.service';
import { Incontro } from '@core/api-serse/model/incontro';
import { MatDialog } from '@angular/material/dialog';
import { IncontroDestinatarioServizio } from '@core/api-serse/model/incontroDestinatarioServizio';
import { HomeBagService } from '@home/services/home-bag.service';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { FormControl } from '@angular/forms';
import { ServiziService } from '@servizi/services/servizi.service';

@Component({
  selector: 'app-partecipanti-incontro',
  templateUrl: './partecipanti-incontro.component.html',
  styleUrls: ['./partecipanti-incontro.component.scss']
})
export class PartecipantiIncontroComponent implements OnInit {

  @Input() incontro!:Incontro;

  @Input() isModificabile: boolean = true;

  //-- Modale
  @ViewChild('partecipanti') partecipanti!: TemplateRef<any>;
  allComplete: boolean = false;

  partecipantiChecked: CheckPartecipanti[] = []
  partecipantiCheckedCopia: CheckPartecipanti[] = []


  partecipantiList:Partecipanti[] =[];
  oreErogate ="Ore erogate";

  trashIcon = IconsSettings.TRS_ICON;
  penIcon = IconsSettings.PEN_ICON;
  saveIcon = IconsSettings.SAVE_ICON;

  presAssArray: FormControl[]=[];
  numrOreArray: FormControl[]=[];

  isInModifica= false;
  formControl!:FormControl;
  indexForm!:number;
  bagDati: {
    isPresente: string,  //form -- 1/0
    orePresenz: string   //form -- ore
  } = {
    isPresente: "",  //form -- 1/0
    orePresenz: ""   //form -- ore
  };

  allPart: Partecipanti[] =[];

  constructor(
    private partecipantiService: PartecipantiService,
    private dialog:MatDialog,
    private homeBag:HomeBagService,
    private servizioService: ServiziService,
  ) { }

  ngOnInit(): void {
    this.fetchPartecipanti();
  }

  fetchPartecipanti(){
    this.partecipantiService.getPartecipantiForIncontro(this.incontro.idIncontro!.toString())
        .pipe()
        .subscribe(risp=>{
          this.partecipantiList = risp;
          this.presAssArray =[];
          this.numrOreArray =[];
          for (const element of this.partecipantiList) {
            let controlSelc = new FormControl(element.incontroDestinatarioServizio?.orePresenza?"1":"2")
            this.presAssArray.push(controlSelc);

            let controlInp = new FormControl(element.incontroDestinatarioServizio?.orePresenza?element.incontroDestinatarioServizio?.orePresenza:0);
            this.numrOreArray.push(controlInp);

            controlSelc.disable();
            controlInp.disable();
          }
        });
  }

  isAssociato(id:number):boolean{
    return this.partecipantiList.find(a=>a.destinatario?.idDestinatario == id) ?true:false;
  }
  mapDataToCheckPartecipanti(data: Partecipanti[]):CheckPartecipanti[]{
    let list = data.map(a=>{
      return {
        numerazioneDestinatario: a.numerazioneDestinatario,
        idPartecipante: a.idDestinatarioServizio,
        codFisc: a.destinatario?.codiceFiscaleDestinatario,
        nome: a.destinatario?.nomeDestinatario,
        cognome: a.destinatario?.cognomeDestinatario,
        data: new Date(a.destinatario?.dNascita!).toLocaleDateString(undefined,{
                                                                  day: '2-digit',
                                                                  month: '2-digit',
                                                                  year: 'numeric'}),
        idEnte: a.incontroDestinatarioServizio?.idEnteCoinvoltoServizio,

        completed: this.isAssociato(a.destinatario!.idDestinatario!)
      }
    });

    return list.filter(item=> !item.completed);
  }

  apriModale(){

    this.partecipantiService.getAllPartecipantiForServizio(this.incontro.idServizio!.toString())
    .pipe()
    .subscribe(risp=>{
      this.partecipantiChecked = this.mapDataToCheckPartecipanti(risp);
      this.partecipantiCheckedCopia = this.mapDataToCheckPartecipanti(risp);

      this.allPart = risp;

      this.dialog.open(this.partecipanti,{
        maxHeight: "800px",
        width: "50vw",
      });

    })

  }

  onPresenteAssente(partecipante:Partecipanti, value:string){
    partecipante.incontroDestinatarioServizio!.orePresenza = value == "2" ?0 : this.incontro.durataOre;
    this.numrOreArray[this.indexForm].setValue(value == "2" ?0 : this.incontro.durataOre);
  }

  //--------------Handle Row
  //------------------------------------------------------------------
  onModifica(index:number){
    if(this.isInModifica){
      this.dialog.open(DialogConfermaComponent,{
        data: new DialogSettings(
          "Attenzione",
          ['Un partecipante è in modifica, se si procede verranno perse le modifiche',
            'Continuare ?'],"card-body--warning","",
          [ new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"torna alla modifica"),
            new DialogButton('Continuare', 'btn btn--warning', () => {
              //-- Reset vecchi valori e setto
              this.resetPartForm();
              this.makeBagData(index);
            },"annulla modifica"),]
        )
      });

      return;
    }
    this.makeBagData(index);

    this.isInModifica = true;
  }
  onAnnullaModifica(){
    this.resetPartForm();
    this.isInModifica = false;
  }
  onSalvaModifica(index:number){
    let p = this.partecipantiList[index].incontroDestinatarioServizio;
    p!.orePresenza = Number(this.numrOreArray[this.indexForm].value);
    this.partecipantiService.updateDestinatarioIncontro(p!)
    .pipe(tap(r=>{
      if(r.message){
        this.isInModifica = false;
        this.presAssArray[index].disable();
        this.numrOreArray[index].disable();
      }
    }))
    .subscribe();

  }

  makeBagData(index:number){
    this.presAssArray[index].enable();
    this.numrOreArray[index].enable();
    this.bagDati.isPresente = this.presAssArray[index].value;
    this.bagDati.orePresenz = this.numrOreArray[index].value;
    this.indexForm = index;
  }
  resetPartForm(){
    this.presAssArray[this.indexForm].setValue(this.bagDati.isPresente);
    this.numrOreArray[this.indexForm].setValue(this.bagDati.orePresenz);
    this.presAssArray[this.indexForm].disable();
    this.numrOreArray[this.indexForm].disable();
  }
  //------------------------------------------------------------------

  onElimina(partecipante: Partecipanti){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(
        "Attenzione",
        ['Si desidera eliminare l’associazione tra il Destinatario e l’Incontro?'],
        "card-body--danger","",
        [
          new DialogButton('Annulla', 'btn btn--outline-primary',undefined,"annulla"),
          new DialogButton('Conferma', 'btn btn--danger', () => {
            this.partecipantiService.disassocciaDestinatariIncontro(
              this.incontro.idIncontro!.toString(),
              partecipante.idDestinatarioServizio!.toString()
            ).pipe(
              tap( risp => {
                if(risp.message){
                  this.partecipantiList.splice(
                    this.partecipantiList.findIndex(p=>p.idDestinatarioServizio==partecipante.idDestinatarioServizio)
                    ,1
                  )
                }
              })
            ).subscribe()
          },"rimuovi partecipante dall'incontro"),]

      )
    });

  }


  //---- MODALE
  updateAllComplete() {
    this.allComplete = this.partecipantiChecked?.every(t => t.completed);
  }
  someComplete(): boolean {
    if (this.partecipantiChecked == null) {
      return false;
    }
    return this.partecipantiChecked.filter(t => t.completed).length > 0 && !this.allComplete;
  }
  setAll(completed: boolean) {
    this.allComplete = completed;
    if (this.partecipantiChecked == null) {
      return;
    }
    this.partecipantiChecked.forEach(t => (t.completed = completed));
  }
  aggiorna(){
    let partecipantiDaInserire:IncontroDestinatarioServizio[]=[];

    for(let i=0; i<this.partecipantiChecked.length;i++){
      if(this.partecipantiChecked[i].completed!=this.partecipantiCheckedCopia[i].completed){
        partecipantiDaInserire.push(this.buildIncontroDestinatarioServizio(this.partecipantiCheckedCopia[i]))
      }
    }

    if(partecipantiDaInserire.length) this.partecipantiService.assocciaDestinatariIncontro(partecipantiDaInserire)
      .pipe(tap(risp=>{
        if(risp.message) this.fetchPartecipanti();
        if(risp.cod) this.dialog.open(DialogConfermaComponent,{
          data: new DialogSettings(
            "Errore",
            ['Errore di sistema contattare l\'amministratore o riprovare più tardi'],
            "card-body--danger"
          )
        });
      }))
      .subscribe();
  }

  buildIncontroDestinatarioServizio(partecipante:CheckPartecipanti):IncontroDestinatarioServizio{
    return{
      idIncontro:this.incontro.idIncontro,
      idDestinatarioServizio:partecipante.idPartecipante,
      idEnteCoinvoltoServizio: partecipante.idEnte,
      orePresenza:this.incontro.durataOre,

      codUserInserimento: this.homeBag.userInfo.codFisc,
      dataInserimento: new Date(),
      codUserAggiornamento: this.homeBag.userInfo.codFisc,
      dataAggiornamento: new Date(),
    }
  }



  get incontroInDef(){
    return this.incontro.statoIncontro?.idStatoIncontro == 10;
  }
  get servizioIsInd(){
    return this.servizioService.servizio.servizioRegionale?.codFinalitaServizio == 'I';
  }

  get visibleIcon(){
    return this.isModificabile && this.incontroInDef && !this.servizioIsInd;
  }

}
export interface CheckPartecipanti{
  numerazioneDestinatario?:number;
  idPartecipante?: number;
  codFisc?: string;
  nome?:string;
  cognome?:string;
  data?:string;

  idEnte?:number,

  completed: boolean
}
