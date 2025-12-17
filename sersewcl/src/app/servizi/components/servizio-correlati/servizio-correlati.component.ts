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

//-Models
import { Servizio } from '@core/api-serse/model/servizio';
import { TargetDestinatario } from '@core/api-serse/model/targetDestinatario';
import { EnteCoinvoltoServizio } from '@core/api-serse/model/enteCoinvoltoServizio';
import { Errore } from '@core/api-serse/model/errore';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { Caratteristica } from '@core/api-serse/model/caratteristica';
import { TargetDestinatariServizio } from '@core/api-serse/model/targetDestinatariServizio';
import { CaratteristicheServizio } from '@core/api-serse/model/caratteristicheServizio';

//-Services
import { ServiziService } from '@servizi/services/servizi.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { TargetDestinatariService } from '@core/services/target-destinatari.service';
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { CaratteristicheService } from '@core/services/caratteristiche.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DestinatariService } from '@core/services/destinatari.service';
import { DialogConfermaComponent } from '@shared/components/dialog-conferma/dialog-conferma.component';
import { DialogSettings } from '@shared/model/dialog-settings.model';

@Component({
  selector: 'app-servizio-correlati',
  templateUrl: './servizio-correlati.component.html',
  styleUrls: ['./servizio-correlati.component.scss']
})
export class ServizioCorrelatiComponent implements OnInit {
  error: Errore={};
  @Input() servizio!: Servizio;
  @Input() isModificabile!: boolean;

  entCoinvoltiAssociati$!:Observable<(EnteCoinvoltoModello| EnteCoinvoltoIntervento| EnteCoinvoltoServizio)[]>;
  isEnteCoinvoltoServizioModificabile:boolean = this.isModificabile;

  targetDestinatariAssociatiElenco$!:Observable<TargetDestinatario[]>;
  targetDestinatariElenco$!:Observable<TargetDestinatario[]>;

  caratteristiche$!:Observable<Caratteristica[]>;
  caratteristicheAssociate$!:Observable<Caratteristica[]>;

  lengthOfEntCoinvoltiAssociati: number = 0;
  entiArrivanoDaModello:boolean = false
  entiArrivanoDaIntervento:boolean = false

  constructor(
    private targetDestinatariService: TargetDestinatariService,
    private caratteristicheService: CaratteristicheService,
    private entiService:EntiCoinvoltiService,
    private serviziService: ServiziService,
    private destinatariService: DestinatariService,
    private dialog:MatDialog,
    private homeBag: HomeBagService,
    private router: Router
  ) {
    this.homeBag.userCase="SER" ;

  }

  ngOnInit(): void {
    this.serviziService.checkIsAssociatoaModello(this.servizio.idServizio!).subscribe({
      next:ris=>{
        if(ris.valore){
          this.targetDestinatariElenco$= this.targetDestinatariService.getTargetDestinatariServizio(
            this.homeBag.selectedPso.idPso!.toString(),
            this.idServizio!.toString(),
            this.isModificabile
          )
          this.caratteristiche$= this.caratteristicheService.getCaratteristicheServizio(
            this.homeBag.selectedPso.idPso!.toString(),
            this.idServizio!.toString(),
            this.isModificabile
          )
        }else{
          this.targetDestinatariElenco$=this.targetDestinatariService
          .getTargetDestinatariForPso(this.homeBag.selectedPso.idPso!.toString())

          this.caratteristiche$=this.caratteristicheService
          .getCaratteristicheForPso(this.homeBag.selectedPso.idPso!.toString())
        }
        this.targetDestinatariAssociatiElenco$= this.targetDestinatariService.getTargetDestinatariServizioAssociati(
          this.idServizio!
        )

        this.caratteristicheAssociate$= this.caratteristicheService.getCaratteristicheAssociateServizio(
          this.servizio.idServizio!
         )

      }
    })

    //enti convolti
    this.handleEntiCoinvolti();

    
    this.serviziService.getDestinatariAssociati(this.servizio.idServizio!.toString())
      .subscribe({
        next: (resp) => {
          this.destinatariService.numDestinatAssoc = resp.length;
        }
      });
 }

  //----------------------------------------------------------------------
  //target destinatari
  deleteTargetDestinatari(targetDestinatari: TargetDestinatariServizio[]) {
    this.targetDestinatariService.deleteTargetDestinatariServizio(targetDestinatari).subscribe({
      complete:()=>this.aggiornElencoTargetDestinatari()
    })
  }

  insertTargetDestinatari(targetDestinatari: TargetDestinatariServizio[]) {
    this.targetDestinatariService.insertTargetDestinatariServizio(targetDestinatari).subscribe({
      complete:()=>this.aggiornElencoTargetDestinatari()
    })
  }

  aggiornElencoTargetDestinatari(){
    this.targetDestinatariAssociatiElenco$= this.targetDestinatariService.getTargetDestinatariServizioAssociati(
      this.idServizio!
    )
  }



  //----------------------------------------------------------------------
  //-Caratteristiche
  deleteCaratteristiche(caratteristiche: CaratteristicheServizio[]) {
    this.caratteristicheService.deleteCaratteristicheServizio(caratteristiche).subscribe({
      complete:()=>this.aggiornElencoCaratteristiche()
    })
  }

  insertCaratteristiche(caratteristiche: CaratteristicheServizio[]) {
    this.caratteristicheService.insertCaratteristicheServizio(caratteristiche).subscribe({
      complete:()=>this.aggiornElencoCaratteristiche()
    })
  }

  aggiornElencoCaratteristiche(){
    this.caratteristicheAssociate$= this.caratteristicheService.getCaratteristicheAssociateServizio(
      this.servizio.idServizio!
     )
  }


  //----------------------------------------------------------------------
  //enti coinvolti
  handleEntiCoinvolti(){

    this.entCoinvoltiAssociati$=this.entiService.getEntiCoinvoltiServizio(this.idServizio!.toString())
      .pipe(
        map(ris=>{
          this.isEnteCoinvoltoServizioModificabile = this.isModificabile;
          this.lengthOfEntCoinvoltiAssociati = ris.length;
          let tmp: (EnteCoinvoltoModello|EnteCoinvoltoServizio|EnteCoinvoltoIntervento)[]=[];
          ris.forEach(ente => {
            if(ente.enteCoinvoltoModello){
              this.isEnteCoinvoltoServizioModificabile=false;
              this.entiArrivanoDaModello = true;  // mi aspetto che tutti i record arrivino da modello, o nessuno
              this.entiArrivanoDaIntervento = false;
              tmp.push(ente.enteCoinvoltoModello);
            }else if(ente.enteCoinvoltoIntervento){
              this.isEnteCoinvoltoServizioModificabile=false;
              this.entiArrivanoDaModello = false;
              this.entiArrivanoDaIntervento = true;  // mi aspetto che tutti i record arrivino da intervento, o nessuno
              tmp.push(ente.enteCoinvoltoIntervento);
            }else if(ente.enteCoinvoltoServizio){
              this.entiArrivanoDaModello = false;
              this.entiArrivanoDaIntervento = false;
              tmp.push(ente.enteCoinvoltoServizio);
            }
          });

          return tmp;
        }),
        catchError(error=>{
          this.error=error;
          return of([]);
        })
    )
  }

  updateEnteCoinvolto(dati: any[]){
    let ente:EnteCoinvoltoServizio = dati[0];
    let dialogEnte: MatDialogRef<any, any> = dati[1];
    this.entiService.updateEnteCoinvoltoServizio(ente,this.homeBag.userInfo.codFisc!)
    .subscribe({

      complete: ()=>{
        this.aggiornaElencoEntiCoinvolti()
        dialogEnte.close();
      }
    });
  }

  deleteEnteCoinvolto(idEnte:string){    
    if (this.isEliminabile) {
      this.entiService.deleteEnteCoinvoltoServizio(idEnte,this.homeBag.userInfo.codFisc!).subscribe({
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
          this.aggiornaElencoEntiCoinvolti()
        }
      })
    } else if (this.isEliminabileDaIntervento) { //Eliminazione ente coinvolto derivante da intervento
      this.entiService.deleteEntiCoinvoltiServizioByIntervento(idEnte, this.servizio.idServizio!, this.homeBag.userInfo.codFisc!).subscribe({
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
          this.aggiornaElencoEntiCoinvolti();
        }

      })
    } else if (this.isEliminabileDaModello) { //Eliminazione ente coinvolto derivante da modello
      this.entiService.deleteEntiCoinvoltiServizioByModello(idEnte, this.servizio.idServizio!, this.servizio.idIntervento!, this.homeBag.userInfo.codFisc!).subscribe({
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
          this.aggiornaElencoEntiCoinvolti();
        }

      })
    }
  }

  aggiornaElencoEntiCoinvolti(){
    this.entCoinvoltiAssociati$=this.entiService.getEntiCoinvoltiServizio(this.idServizio!.toString())
    .pipe(
      map(ris=>{
        this.lengthOfEntCoinvoltiAssociati = ris.length;
        let tmp: (EnteCoinvoltoModello|EnteCoinvoltoServizio|EnteCoinvoltoIntervento)[]=[];
        ris.forEach(ente => {
          if(ente.enteCoinvoltoModello){
            tmp.push(ente.enteCoinvoltoModello);
          }else if(ente.enteCoinvoltoIntervento){
            tmp.push(ente.enteCoinvoltoIntervento);
          }else if(ente.enteCoinvoltoServizio){
            tmp.push(ente.enteCoinvoltoServizio);
          }
        });

        return tmp;
      }),
      catchError(error=>{
        this.error=error;
        return of([]);
      })
  )
  }

  //----------------------------------------------------------------------
  //-Getter
  get idServizio(){
    return this.servizio.idServizio;
  }
  get idPso(){
    return this.homeBag.selectedPso.idPso!;
  }
  get codFisc(){
    return this.homeBag.userInfo.codFisc!;
  }

  get backTo(){
    return this.router.url;
  }

  get isEntiModificabile(){
    return this.isModificabile && this.isEnteCoinvoltoServizioModificabile;
  }

  get isAssociatoDestinatari(){
    return this.destinatariService.numDestinatAssoc!=0;
  }

  get isIndividuale(){
    return this.servizio.numMaxDestinatari==1;
  }

  get isAssociatoIntervento(){
    return this.servizio.idIntervento ? true:false;
  }

  get isEliminabile(){
    return this.isEntiModificabile && !this.entiArrivanoDaModello && !this.entiArrivanoDaIntervento;
  }

  get isEliminabileDaModello(){
    return this.isModificabile && this.entiArrivanoDaModello && this.lengthOfEntCoinvoltiAssociati > 1;
  }

  get isEliminabileDaIntervento(){
    return this.isModificabile && this.entiArrivanoDaIntervento && this.lengthOfEntCoinvoltiAssociati > 1;
  }

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
