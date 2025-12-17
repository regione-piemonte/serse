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

import { BehaviorSubject, Observable } from 'rxjs';
import { HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AreaTerritoriale, Classificazione, DatiPeculiariWrapper, Destinatario, DestinatarioServizio, EnteDestinatario, GenericResponse, IncontriSomma, Intervento, Servizio, ServizioGamPropostaModifica, ServizioVoceSpesa, ServizioWrapper, TargetDestinatario, TokenGam } from '@core/api-serse/model/models';
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { of } from 'rxjs/internal/observable/of';
import { FiltriServizi } from '../model/filtri-servizi';
import { TestGenerico } from '@core/api-serse/model/testGenerico';
import { TestChiudiServizio } from '@core/api-serse/model/testChiudiServizio';
import { ServizioGamChiudiServizio } from '@core/api-serse/model/servizioGamChiudiServizio';
import { FilterServizi } from '@servizi/model/filterServizi';
import { ServizioPageWrapper } from '@core/api-serse/model/servizioPageWrapper';
import { DettaglioClasseDestinatarioServizio } from '@core/api-serse/model/dettaglioClasseDestinatarioServizio';

@Injectable({
  providedIn: 'root'
})
export class ServiziService {
  private _isSaved = false;
  private _isModificabile = true;
  private _servizio : Servizio = {};
  private _esisteElaborazioneInCorso = false;

  private selectedServizioSource = new BehaviorSubject<Servizio>(this._servizio)
  selectionChangeServizio$= this.selectedServizioSource.asObservable()

  private _backTo: string = "";

  intervento:Intervento = {};

  tab = 0;

  // Pipe Handling
  error: Error | null = null;

  tapPipe = {
    error: (error:any)=>{
      this.error = error;
      }
  }

  catchPipe = (err:any) => {

    return of([]);}

  catchPipeSingle = (err:any) => {

    return of({});}

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService,
    private homeBag: HomeBagService
  ){}

  changeSelectedServizio(servizioSelected: Servizio){
    this.selectedServizioSource.next(servizioSelected);
  }

  getServizi(filtri: FilterServizi, offset?: number, limit?: number, sort?: string): Observable<ServizioPageWrapper>{
    let queryParams = new HttpParams()
      .append("filter", JSON.stringify(filtri));
    if (offset !== undefined) {
      queryParams = queryParams.append("offset", offset.toString());
    }
    if (limit !== undefined) {
      queryParams = queryParams.append("limit", limit.toString());
    }
    if (sort !== undefined) {
      queryParams = queryParams.append("sort", sort);
    }

    return this.http.get<ServizioPageWrapper>(this.config.serviziUrl, {params:queryParams});
  }
  getServiziDestinatari(filtri:FiltriServizi,destinatario: Destinatario):Observable<ServizioWrapper[]>{
    let queryParams = new HttpParams()
    .append("numProgrSportello",this.homeBag.selectedSportello.numProgrSportello?.toString()!)
    .append("codOperatore",this.homeBag.codiceOperatore)
    .append("gruppoOperatore",this.homeBag.gruppoOperatore)
    .append("idDestinatario",destinatario.idDestinatario!)
    if(filtri.codicBeneficiario && filtri.gruppBeneficiario){
      queryParams= queryParams.append("gruppoOperatoreSoggettoBeneficiario",filtri.gruppBeneficiario)
                              .append("codOperatoreSoggettoBeneficiario",filtri.codicBeneficiario);
    }
    if(filtri.infoIncontri){
      queryParams=queryParams.append("situazioneIncontro",filtri.infoIncontri);
    }
    return this.http.get<ServizioWrapper[]>(this.config.serviziDestinatariUrl,{params:queryParams});
  }
  getServizioById(idServizio:number):Observable<Servizio>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<Servizio>(this.config.servizioUrl,{params:queryParams});
  }
  deleteServizioById(idServizio:number){
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.delete(this.config.serviziUrl,null,queryParams);
  }


  getServiziIntervento(idIntervento:number):Observable<Servizio[]>{
    let queryParams = new HttpParams().append("idIntervento",idIntervento);
    return this.http.get<Servizio[]>(this.config.serviziInterventoUrl,{params:queryParams});
  }

  addServizio(servizio:Servizio){
    return this.http.post<Servizio>(this.config.serviziUrl,servizio);
  }
  updateServizio(servizio:Servizio){
    return this.http.put<Servizio>(this.config.serviziUrl,servizio);
  }


  getAreeTerritoriali(gruppoOperatore:string, codOperatore:string, modelId:string):Observable<AreaTerritoriale[]>{
    let queryParams = new HttpParams()
                          .append("gruppoOperatore",gruppoOperatore)
                          .append("codOperatore",codOperatore)
                          .append("modelId",modelId);
    return this.http.get<AreaTerritoriale[]>(this.config.areeTerritorialiUrl,{params:queryParams});
  }

  getClassificazioniPOR(idPso:string, idServizioRegionale:string):Observable<Classificazione[]>{
    let queryParams = new HttpParams()
                          .append("idPso",idPso)
                          .append("idServizioRegionale",idServizioRegionale);
    return this.http.get<Classificazione[]>(this.config.classificazioniPORUrl,{params:queryParams});
  }
  getSommaIncontri(idServizio:string):Observable<IncontriSomma>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<IncontriSomma>(this.config.totaleOreIncontro,{params:queryParams});
  }

  getDestinatariAssociati(idServizio:string):Observable<Destinatario[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<Destinatario[]>(this.config.destinatariServizioUrl,{params:queryParams})
  }

  getDestinatariServizio(idServizio: string):Observable<DestinatarioServizio[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<DestinatarioServizio[]>(this.config.destinatariServiziServizioUrl,{params:queryParams});
  }

  // =============================
  checkPeriodoAttivazioneServizio(numProgrSportello:string):Observable<any>{
    let queryParams = new HttpParams().append("numProgrSportello",numProgrSportello);
    return this.http.get<any>(this.config.verificaPeriodoAttivazioneUrl,{params:queryParams})
  }

  richiestaChiusura(richiestaChiusura:ServizioGamChiudiServizio):Observable<any>{
    return this.http.post<any>(this.config.chiusuraServizioUrl,richiestaChiusura)
  }
  checkChiusura(idServizio:number):Observable<TestChiudiServizio>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<TestChiudiServizio>(this.config.chiusuraServizioUrl,{params:queryParams})
  }

  checkIsAssociatoaModello(idServizio:number):Observable<TestGenerico>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<TestGenerico>(this.config.testServizioAssociatoAmodelloUrl,{params:queryParams})
  }

  getEntiCoinvoltiAssociatiDestinatario(idServizio:string):Observable<EnteDestinatario[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio);
    return this.http.get<EnteDestinatario[]>(this.config.entiDestinarioUrl,{params:queryParams});
  }

  verificaDatiPeculiariMancanti(idServizio:number,numProgrSportello:number,idPso:number):Observable<Destinatario[]>{
    let queryParams = new HttpParams().append("idServizio",idServizio)
                                      .append("numProgrSportello",numProgrSportello)
                                      .append("idPso",idPso)
    return this.http.get<Destinatario[]>(this.config.verificaDatiPeculiariMancantiUrl,{params:queryParams});
  }

  verificaDatiPeculiariServizio(numProgrSportello:number,idPso:number):Observable<DatiPeculiariWrapper>{
    let queryParams = new HttpParams().append("numProgrSportello",numProgrSportello)
                                      .append("idPso",idPso)
    return this.http.get<DatiPeculiariWrapper>(this.config.verificaDatiPeculiariServizio,{params:queryParams})
  }

  updateDatiPeculiariServizio(servizio:Servizio):Observable<GenericResponse>{
    return this.http.put(this.config.datiPeculiariServizi, servizio)
  }

  getLabelCampoAggiuntivo(idPso: number,numProgrSportello: number){
    let queryParams = new HttpParams().append("idPso",idPso)
                                      .append("numProgrSportello",numProgrSportello)
    return this.http.get<any>(this.config.labelCampoAggiuntivo,{params:queryParams})
  }

  getFlgCampoAggiuntivoByIdServizioRegionale(idServizioRegionale: number){
    let queryParams = new HttpParams().append("idServizioRegionale",idServizioRegionale)
    return this.http.get<any>(this.config.flgCampoAggiuntivo,{params:queryParams})
  }
  //####-Gestione Casi di visualizzazione-####//
  get isSaved(){
    return this._isSaved;
  }
  setIsSaved(isSaved:boolean){
    this._isSaved = isSaved;
  }
  get isModificabile(){
    return this._isModificabile && this.homeBag.selectedRuolo.codiceRuolo!=='FUNZIONARIO_MASTER_SERSE';
  }
  setIsModificabile(isModificabile:boolean){
    this._isModificabile = isModificabile;
  }
  get esisteElaborazioneInCorso(){
    return this._esisteElaborazioneInCorso;
  }
  setEsisteElaborazioneInCorso(esisteElaborazioneInCorso:boolean){
    this._esisteElaborazioneInCorso = esisteElaborazioneInCorso;
  }
  get servizio(){
    return this._servizio;
  }
  setServizio(servizio:Servizio){
    this._servizio=servizio;
  }


  get backTo(){
    return this._backTo;
  }
  setBackTo(url:string){
    this._backTo = url;
  }


  reset(){
    this.setIsModificabile(true)
    this.setIsSaved(false)
    this.setServizio({});
    this.setEsisteElaborazioneInCorso(false);
    // this.serviziService.isProprietario = true;
    this.tab = 0;
    this.intervento = {};
    this.changeSelectedServizio({});
  }

  reload() {
    if (this._servizio?.idServizio) {
      this.getServizioById(this._servizio!.idServizio).subscribe({
        next: (servizio) => {
        // NON cambio isModificabile
        this.setServizio(servizio);
        this.setIsSaved(true);
        this.changeSelectedServizio(servizio);
        }
      });
    } else {
      console.error("Si sta cercando di ricaricare un servizio prima di averlo caricato");
    }
  }

  reloadStatoServizio() {
    if (this._servizio?.idServizio) {
      this.getServizioById(this._servizio!.idServizio).subscribe({
        next: (servizio) => {
          // non aggiorno tutto il servizio ma solo lo stato
          this._servizio.statoServizio = servizio.statoServizio
        }
      });
    } else {
      console.error("Si sta cercando di ricaricare un servizio prima di averlo caricato");
    }
  }

  aggiornaStatoServizio(idStatoServizio: number) { // cfr. serse_d_stato_servizio
    let descrStatoServizio = "-"
    switch (idStatoServizio) {
      case 10: descrStatoServizio = "In definizione"; break;
      case 22: descrStatoServizio = "Finanziato"; break;
      case 30: descrStatoServizio = "Avviato"; break;
      case 40: descrStatoServizio = "Chiuso"; break;
    }

    if (this.servizio) {
      this.servizio.statoServizio = {
        idStatoServizio: idStatoServizio,
        descrStatoServizio: descrStatoServizio
      }
      this.changeSelectedServizio(this.servizio);
    } else {
      console.error("Si è cercato di aggiornare lo stato del servizio, ma il servizio è null")
    }
  }

  getServiziExcelV2(filtri: FilterServizi, descrizionePso: string, descrizioneSportello: string): Observable<HttpResponse<Blob>> {
    let queryParams = new HttpParams()
      .append("filter", JSON.stringify(filtri))
      .append("descrizionePso", descrizionePso)
      .append("descrizioneSportello", descrizioneSportello);

    return this.http.getFile(this.config.excelServiziUrlV2, { params: queryParams });
  }

  getClasseServizioByIdServzioAndIdPso(idServizio:number,idPso:number):Observable<DettaglioClasseDestinatarioServizio>{
    let queryParams = new HttpParams().append("idServizio",idServizio)
                                      .append("idPso",idPso)
    return this.http.get<DettaglioClasseDestinatarioServizio>(this.config.dettaglioClasseDestinatarioServizioUrl,{params:queryParams})
  }
}



