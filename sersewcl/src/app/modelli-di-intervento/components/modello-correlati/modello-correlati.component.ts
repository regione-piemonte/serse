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
import { Observable, catchError, of, tap } from 'rxjs';

// Models
import { ServizioModello } from '@core/api-serse/model/servizioModello';
import { TargetDestinatario } from '@core/api-serse/model/targetDestinatario';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { ServizioRegionale } from '@core/api-serse/model/servizioRegionale';
import { ProvinciaRistretto } from '@core/api-serse/model/provinciaRistretto';
import { TargetDestinatariAssociati } from '@core/api-serse/model/targetDestinatariAssociati';
import { Caratteristica } from '@core/api-serse/model/caratteristica';
import { RuoloEnte } from '@core/api-serse/model/ruoloEnte';
import { CaratteristicheAssociate } from '@core/api-serse/model/caratteristicheAssociate';
import { ModelloIntervento } from '@core/api-serse/model/modelloIntervento';

// Services
import { HomeBagService } from '@home/services/home-bag.service';
import { ModelliService } from '@modelli/services/modelli.service';
import { TipologieServiziService } from '@modelli/services/tipologie-servizi.service';
import { TargetDestinatariService } from '@core/services/target-destinatari.service';
import { CaratteristicheService } from '@core/services/caratteristiche.service';
import { EntiCoinvoltiService } from '@core/services/enti-coinvolti.service';
import { InfoComuniService } from '@core/services/info-comuni.service';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';


@Component({
  selector: 'app-modello-correlati',
  templateUrl: './modello-correlati.component.html',
  styleUrls: ['./modello-correlati.component.scss']
})
export class ModelloCorrelatiComponent implements OnInit {

  @Input() modelloIntervento!: ModelloIntervento;
  @Input() isModificabile!: boolean;  //-> è di proprietà

  // Handle Error -------------------------------------------------------------------------
  error: Error | null=null;

  // Target Destinatari -------------------------------------------------------------------
  targetDestinatari$!: Observable<TargetDestinatario[]>;
  targetDestinatariAssociati$!:Observable<TargetDestinatario[]>;

  // Caratteristiche ----------------------------------------------------------------------
  caratteristiche$!:Observable<Caratteristica[]>;
  caratteristicheAssociate$!:Observable<Caratteristica[]>;

  // Tipologia Servizi --------------------------------------------------------------------
  tipologieServiziModello$!:Observable<ServizioModello[]>;
  serviziRegionali$!: Observable<ServizioRegionale[]>;
  serviziRegionaliModello$!: Observable<ServizioRegionale[]>;
  servizioEsterno$:Observable<ServizioModello|null> | null = null;

  // Enti coinvolti -----------------------------------------------------------------------
  entiCoinvoltiModello$!: Observable<EnteCoinvoltoModello[]>;
  entiCoinvoltiModelloAssociati$!: Observable<EnteCoinvoltoModello[]>;

  constructor(
    private targetDestinatarioService: TargetDestinatariService,
    private tipologieServiziService: TipologieServiziService,
    private caratteristicheService: CaratteristicheService,
    private entiCoinvoltiService: EntiCoinvoltiService,
    private infoComuniService:InfoComuniService,
    private homeBag: HomeBagService,

    private router: Router
  ) {
    this.homeBag.userCase="MDI";
  }

  ngOnInit(): void {
    // ######################################################
    // Target destinatari
    this.handleTargetDestinatari();

    // ######################################################
    // Tipologie di servizi
    this.handleTipologieServizi();

    // ######################################################
    // Caratteristiche
    this.handleCaratteristiche();

    // ######################################################
    // ENTI COINVOLTI
    this.handleEntiCoinvolti();

  }

  // Target Destinatari -------------------------------------------------------------------
  handleTargetDestinatari(){
    this.targetDestinatari$ = this.targetDestinatarioService.
    getTargetDestinatariForPso(this.homeBag.selectedPso.idPso!.toString()).pipe(
      catchError(error=>{
        this.error=error;
        return of([]);
      })
    )

    this.targetDestinatariAssociati$=this.targetDestinatarioService
    .getElencoTargetDestinatariForModello(this.homeBag.selectedPso.idPso!.toString(),
        this.modelloIntervento.idModelloIntervento!.toString()).pipe(
          catchError(error=>{
            this.error=error;
            return of([]);
          }
        )
    )
  }
  // Tipologie di servizi -------------------------------------------------------------------
  handleTipologieServizi(){
    this.tipologieServiziModello$ = this.tipologieServiziService.
    getTipologieServiziAssociati(this.modelloIntervento.idModelloIntervento!.toString()).pipe(
      catchError(error=>{
        this.error = error;
        return of([]);
      })
    )

    this.serviziRegionali$ = this.tipologieServiziService.
    getServiziRegionaliForPso(this.homeBag.selectedPso.idPso!.toString()).pipe(
      catchError(error=>{
        this.error = error;
        return of([]);
      })
    )

    this.serviziRegionaliModello$ = this.tipologieServiziService.
    getServiziRegionaliForPso(this.homeBag.selectedPso.idPso!.toString(),
                    this.modelloIntervento.idModelloIntervento?.toString()).pipe(
      catchError(error=>{
        this.error = error;
        return of([]);
      })
    )
  }
  // Caratteristiche -------------------------------------------------------------------
  handleCaratteristiche(){
    this.caratteristiche$= this.caratteristicheService.getCaratteristicheForPso(this.homeBag.selectedPso.idPso!.toString()).pipe(
      catchError(error=>{
        this.error=error;
        return of([]);
      })
    )

    this.caratteristicheAssociate$=this.caratteristicheService.getCaratteristicheForModello(this.homeBag.selectedPso.idPso!.toString(),
    this.modelloIntervento.idModelloIntervento!.toString()).pipe(
      catchError(error=>{
        this.error=error;
        return of([]);
      })
    )
  }

  // Enti coinvolti -------------------------------------------------------------------
  handleEntiCoinvolti(){
    this.entiCoinvoltiModelloAssociati$=this.entiCoinvoltiService.getEntiCoinvoltiForModelloIntervento(
      this.modelloIntervento.idModelloIntervento!.toString(),
      ).pipe(

        catchError(error=>{
          this.error=error;
          return of([]);
        })
    )
  }

  // ######################################################
  // Target destinatari
  insertTargetDestinatari(targetDaInserire: TargetDestinatariAssociati[]){
    this.targetDestinatarioService.insertTargetDestinatari(targetDaInserire).subscribe({
      complete:()=>this.aggiornaElencoDestinatari()
  });
  }
  deleteTargetDestinatari(targetDaCancellare:TargetDestinatariAssociati[]){
    this.targetDestinatarioService.deleteTargetDestinatari(targetDaCancellare).subscribe({
      complete:()=>this.aggiornaElencoDestinatari()
  });
  }
  aggiornaElencoDestinatari(){
    this.targetDestinatariAssociati$=this.targetDestinatarioService
    .getElencoTargetDestinatariForModello(this.homeBag.selectedPso.idPso!.toString(),
        this.modelloIntervento.idModelloIntervento!.toString()).pipe(
          catchError(error=>{
            this.error=error;
            return of([]);
          }
        )
    )
  }

  // ######################################################
  // Caratteristiche
  insertCaratteristiche(caratteristicheDaInserire:CaratteristicheAssociate[]){
    this.caratteristicheService.insertCaratteristiche(caratteristicheDaInserire).subscribe({
      complete:()=>this.aggiornaElencoCaratteristiche()
  });
  }
  deleteCaratteristiche(caratteristicheDaCancellare:CaratteristicheAssociate[]){
    this.caratteristicheService.deleteCaratteristiche(caratteristicheDaCancellare).subscribe({
      complete:()=>this.aggiornaElencoCaratteristiche()
  });
  }
  aggiornaElencoCaratteristiche(){
    this.caratteristicheAssociate$=this.caratteristicheService.getCaratteristicheForModello(this.homeBag.selectedPso.idPso!.toString(),
    this.modelloIntervento.idModelloIntervento!.toString()).pipe(
      catchError(error=>{
        this.error=error;
        return of([]);
      })
    )
  }

  // ######################################################
  // Enti coinvolti
  updateEnteCoinvolto(dati: any[]){
      let ente:EnteCoinvoltoModello = dati[0];
      let dialogEnte: MatDialogRef<any, any> = dati[1];



      this.entiCoinvoltiService.updateEnteCoinvoltoModello(ente).pipe(
        catchError(error=>{
          this.error=error;
          return of([]);
        })).subscribe({

          complete: ()=>{
            this.handleEntiCoinvolti()
            dialogEnte.close();
          }
        })
  }
  deleteEnteCoinvolto(idEnte:string){
    this.entiCoinvoltiService.deleteEnteCoinvoltoModelloById(
      idEnte,String(this.modelloIntervento.idModelloIntervento),this.homeBag.userInfo!.codFisc!).pipe(
        catchError(error=>{
          this.error=error;
          return of([]);
        })).subscribe({
          complete: ()=>this.handleEntiCoinvolti()
        })
  }
  aggiornaElencoEntiCoinvolti(){
    this.entiCoinvoltiModelloAssociati$=this.entiCoinvoltiService.getEntiCoinvoltiForModelloIntervento(
      this.modelloIntervento.idModelloIntervento!.toString()
     ).pipe(
        catchError(error=>{
          this.error=error;
          return of([]);
        })
    )
  }

  // ######################################################
  // Tipologia di servizi
  insertServiziRegionali(targetDaInserire: ServizioModello[]){
    this.tipologieServiziService
        .insertServiziModelloRegionale(
                    targetDaInserire,
                    this.homeBag.userInfo.codFisc!,
                    this.modelloIntervento.idModelloIntervento!.toString()
                    )
        .subscribe({
      complete:()=>this.aggiornaElencoRipologieServizi()
    });
  }
  deleteServiziRegionali(targetDaCancellare:ServizioModello[]){
    this.tipologieServiziService
        .deleteServiziModelloRegionale(
                    targetDaCancellare,
                    this.homeBag.userInfo.codFisc!,
                    this.modelloIntervento.idModelloIntervento!.toString())
        .subscribe({
      complete:()=>this.aggiornaElencoRipologieServizi()
    });
  }
  updateServiziRegionali(targetDaAggiornare:ServizioModello[]){
    this.tipologieServiziService
        .updateServiziModelloRegionale(
                    targetDaAggiornare,
                    this.homeBag.userInfo.codFisc!,
                    this.modelloIntervento.idModelloIntervento!.toString())
        .subscribe({
      complete:()=>this.aggiornaElencoRipologieServizi()
    });
  }
  getServizioEsterno(idServizioModello: string){
    this.servizioEsterno$ = this.tipologieServiziService
                .getServizioEsternoById(this.idModello.toString(),
                                        idServizioModello)
                .pipe(
                  catchError(error=>{
                    this.error = error;
                    return of(null);
                  })
                )
  }

  insertServiziEsterno(targetDaInserire: ServizioModello){
    targetDaInserire.codUserInserim = this.codFisc;
    targetDaInserire.codUserAggiorn = this.codFisc;
    this.tipologieServiziService
        .insertServizioModelloEsterno(
                    targetDaInserire,
                    this.homeBag.userInfo.codFisc!,
                    this.modelloIntervento.idModelloIntervento!.toString()
                    )
        .subscribe({
      complete:()=>this.aggiornaElencoRipologieServizi()
    });
  }
  deleteServiziEsterno(idServizioModello:string){
    this.tipologieServiziService
        .deleteServizioModelloEsterno(
                    idServizioModello,
                    this.homeBag.userInfo.codFisc!,
                    this.modelloIntervento.idModelloIntervento!.toString())
        .subscribe({
      complete:()=>this.aggiornaElencoRipologieServizi()
    });
  }
  updateServiziEsterno(targetDaAggiornare:ServizioModello){
    this.tipologieServiziService
        .updateServizioModelloEsterno(
                    targetDaAggiornare,
                    this.homeBag.userInfo.codFisc!,
                    this.modelloIntervento.idModelloIntervento!.toString())
        .subscribe({
      complete:()=>this.aggiornaElencoRipologieServizi()
    });
  }

  aggiornaElencoRipologieServizi(){
    this.tipologieServiziModello$ = this.tipologieServiziService.
    getTipologieServiziAssociati(this.modelloIntervento.idModelloIntervento!.toString()).pipe(
      catchError(error=>{
        this.error = error;
        return of([]);
      })
    )
  }

  //- Getter
  get idModello(){
    return this.modelloIntervento.idModelloIntervento!;
  }

  get individuale(){
    return this.modelloIntervento.tipoModello?.flgProgettazioneIndividuale;
  }

  get idPso(){
    return this.homeBag.selectedPso.idPso!;
  }
  get codFisc(){
    return this.homeBag.userInfo.codFisc!;
  }

  get isModificabileCorrelati(){

    return this.isModificabile && this.modelloIntervento.statoModelloIntervento?.idStatoModelloDiIntervento == 10;
  }

  get isModificabilePubblicato(){

    return this.isModificabile && (this.modelloIntervento.statoModelloIntervento?.idStatoModelloDiIntervento == 10 ||
    this.modelloIntervento.statoModelloIntervento?.idStatoModelloDiIntervento == 20);
  }

  get stato(){
    return this.modelloIntervento.statoModelloIntervento!.idStatoModelloDiIntervento!;
  }

  get backToURl(){
    return  this.router.url;
  }


}
