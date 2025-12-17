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

import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

//-Models
import { CentroPerImpiego } from '@core/api-serse/model/centroPerImpiego';
import { EnteCoinvoltoIntervento } from '@core/api-serse/model/enteCoinvoltoIntervento';
import { EnteCoinvoltoModello } from '@core/api-serse/model/enteCoinvoltoModello';
import { EnteCoinvoltoServizio } from '@core/api-serse/model/enteCoinvoltoServizio';
import { EnteCoinvoltoWrapper } from '@core/api-serse/model/enteCoinvoltoWrapper';
import { FonteDato } from '@core/api-serse/model/fonteDato';
import { GradoScolastico } from '@core/api-serse/model/gradoScolastico';
import { IstitutoScolasticoWrapper } from '@core/api-serse/model/istitutoScolasticoWrapper';
import { PercorsoScolastico } from '@core/api-serse/model/percorsoScolastico';
import { PersonaGiuridica } from '@core/api-serse/model/personaGiuridica';
import { RuoloEnte } from '@core/api-serse/model/ruoloEnte';
import { SedeOperatore } from '@core/api-serse/model/sedeOperatore';
import { TestEnteCoinvoltoIntervento } from '@core/api-serse/model/testEnteCoinvoltoIntervento';
import { TipologiaIstitutoScolastico } from '@core/api-serse/model/tipologiaIstitutoScolastico';

//-Services
import { ConfigService } from '@core/services/config.service';
import { ManagedHttpClient } from '@core/services/managed-http-client.service';

@Injectable({
  providedIn: 'root'
})
export class EntiCoinvoltiService {
  entiCoinvolti: any[] = [];
  backTo: string = "";

  constructor(
    private http: ManagedHttpClient,
    private config: ConfigService
  ) { }

  //----------------------------------------------------------------------------------------------
  //# ENTI COINVOLTI MODELLO
  getEntiCoinvoltiForModelloIntervento(idModelloIntervento:string): Observable<EnteCoinvoltoModello[]>{
    let queryParams = new HttpParams().append("idModelloIntervento",idModelloIntervento);
    return this.http.get(this.config.entiCoinvoltoModelloUrl,{params:queryParams})
  }

  getEnteCoinvoltoModelloForId(idEnteCoinvoltoModello:string):Observable<EnteCoinvoltoModello>{
    let queryParams = new HttpParams().append("idEnteCoinvoltoModello",idEnteCoinvoltoModello)
    return this.http.get<EnteCoinvoltoModello>(this.config.enteCoinvoltoModelloUrl,{params:queryParams})
  }

  deleteEnteCoinvoltoModelloById(idEnteCoinvoltoModello:string,idModelloIntervento:string,codUserAggiornamento: string): Observable<void>{
    let queryParams =  new HttpParams().append("idEnteCoinvolto",idEnteCoinvoltoModello).
                                        append("idModelloIntervento",idModelloIntervento).
                                        append("codUserAggiornamento",codUserAggiornamento)
    return this.http.delete(this.config.enteCoinvoltoModelloUrl,null,queryParams)
  }

  deleteEntiCoinvoltiInterventoModello(idEnteCoinvoltoModello: string, idIntervento: number, codUserAggiornamento: string): Observable<void>{
    let queryParams =  new HttpParams().append("idEnteCoinvoltoModello",idEnteCoinvoltoModello).
                                        append("idIntervento",idIntervento).
                                        append("codUserAggiornamento",codUserAggiornamento)
    return this.http.delete(this.config.enteCoinvoltoInterventoModelloUrl,null,queryParams)
  }

  updateEnteCoinvoltoModello(body:EnteCoinvoltoModello): Observable<void>{
    return this.http.put(this.config.enteCoinvoltoModelloUrl,body);
  }

  insertEnteCoinvoltoModello(body:EnteCoinvoltoModello): Observable<void>{
    return this.http.post(this.config.enteCoinvoltoModelloUrl,body);
  }

  cessaEnteCoinvoltoModello(body:EnteCoinvoltoModello): Observable<void>{
    return this.http.put(this.config.cessazioneEnteUrl,body);
  }

  //----------------------------------------------------------------------------------------------
  //# ENTI COINVOLTI INTERVENTO

  insertEnteCoinvoltoIntervento(body:EnteCoinvoltoIntervento): Observable<void>{
    return this.http.post(this.config.enteCoinvoltoInterventoUrl,body);
  }

  deleteEnteCoinvoltoIntervento(idEnteCoinvoltoIntervento:string, codUserAggiornamento: string): Observable<void>{
    let queryParams= new HttpParams().append("idEnteCoinvoltoIntervento", idEnteCoinvoltoIntervento)
                                     .append("codUserAggiornamento",codUserAggiornamento)
    return this.http.delete(this.config.enteCoinvoltoInterventoUrl,null,queryParams)
  }

  updateEnteCoinvoltoIntervento(enteCoinvoltoIntervento: EnteCoinvoltoIntervento, codUserAggiornamento: string): Observable<void>{
    let queryParams= new HttpParams().append("codUserAggiorn",codUserAggiornamento)
    return this.http.put(this.config.enteCoinvoltoInterventoUrl,enteCoinvoltoIntervento,queryParams)
  }

  getEntiCoinvoltiIntervento(idIntervento:string):Observable<EnteCoinvoltoWrapper[]>{
    let queryParams= new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<EnteCoinvoltoWrapper[]>(this.config.entiCoinvoltiInterventoUrl,{params:queryParams})
  }

  getEnteCoinvoltoInterventoById(idEnteCoinvoltoIntervento:string):Observable<EnteCoinvoltoIntervento>{
    let queryParams= new HttpParams().append("idEnteCoinvoltoIntervento",idEnteCoinvoltoIntervento)

    return this.http.get<EnteCoinvoltoIntervento>(this.config.enteCoinvoltoInterventoUrl,{params:queryParams})
  }

  testEnteCoinvoltoIntervento(idIntervento:string):Observable<TestEnteCoinvoltoIntervento>{
    let queryParams= new HttpParams().append("idIntervento",idIntervento)
    return this.http.get<TestEnteCoinvoltoIntervento>(this.config.enteCoinvoltoInterventoVerificaUrl,{params:queryParams})
  }

  //----------------------------------------------------------------------------------------------
  //# ENTI COINVOLTI SERVIZI

  insertEnteCoinvoltoServizio(body:EnteCoinvoltoServizio): Observable<void>{
    return this.http.post(this.config.enteCoinvoltoServizioUrl,body);
  }

  getEnteCoinvoltoServizioForId(idEnteCoinvoltoServizio: string):Observable<EnteCoinvoltoServizio>{
    let queryParams= new HttpParams().append("idEnteCoinvoltoServizio",idEnteCoinvoltoServizio)
    return this.http.get<EnteCoinvoltoServizio>(this.config.enteCoinvoltoServizioUrl,{params:queryParams})
  }

  deleteEnteCoinvoltoServizio(idEnteCoinvoltoServizio:string, codUserAggiornamento: string): Observable<void>{
    let queryParams= new HttpParams().append("idEnteCoinvoltoServizio", idEnteCoinvoltoServizio)
                                     .append("codUserAggiornamento",codUserAggiornamento)
    return this.http.delete(this.config.enteCoinvoltoServizioUrl,null,queryParams)
  }

  deleteEntiCoinvoltiServizioByIntervento(idEnteCoinvoltoIntervento: string, idServizio: number, codUserAggiornamento: string): Observable<void>{
    let queryParams =  new HttpParams().append("idEnteCoinvoltoIntervento",idEnteCoinvoltoIntervento).
                                        append("idServizio",idServizio).
                                        append("codUserAggiornamento",codUserAggiornamento)
    return this.http.delete(this.config.enteCoinvoltoServizioUrl,null,queryParams)
  }

  deleteEntiCoinvoltiServizioByModello(idEnteCoinvoltoModello: string, idServizio: number, idIntervento: number, codUserAggiornamento: string): Observable<void>{
    let queryParams =  new HttpParams().append("idEnteCoinvoltoModello",idEnteCoinvoltoModello).
                                        append("idServizio",idServizio).
                                        append("idIntervento",idIntervento).
                                        append("codUserAggiornamento",codUserAggiornamento)
    return this.http.delete(this.config.enteCoinvoltoServizioUrl,null,queryParams)
  }

  updateEnteCoinvoltoServizio(enteCoinvoltoServizio: EnteCoinvoltoServizio, codUserAggiornamento: string): Observable<void>{
    let queryParams= new HttpParams().append("codUserAggiornamento",codUserAggiornamento)
    return this.http.put(this.config.enteCoinvoltoServizioUrl,enteCoinvoltoServizio,queryParams)
  }

  getEntiCoinvoltiServizio(idServizio:string):Observable<EnteCoinvoltoWrapper[]>{
    let queryParams= new HttpParams().append("idServizio",idServizio)

    return this.http.get<EnteCoinvoltoWrapper[]>(this.config.entiCoinvoltiServizioUrl,{params:queryParams})
  }

  //----------------------------------------------------------------------------------------------
  // Main
  getEntiIdFonteDati(idPso:string): Observable<FonteDato>{
    let queryParams = new HttpParams().append("idPso",idPso);
    return this.http.get<FonteDato>(this.config.entiFonteDatoUrl, {params:queryParams})
  }

  //----------------------------------------------------------------------------------------------
  // Centri per impiego
  getCentriImpiego(idProvincia?:string, idComune?:string): Observable<CentroPerImpiego[]>{
    let queryParams = new HttpParams();

    if(idProvincia)
      queryParams = queryParams.append("codProvincia",idProvincia)
    if(idProvincia && idComune)
      queryParams = queryParams.append("codIstatComune",idComune)

    return this.http.get<CentroPerImpiego[]>(this.config.centriPerImpiegoUrl, {params:queryParams})
  }

  getOperatori(gruppoOperatore?:string,codOperatore?:string,
              denominazione?:string, codiceFiscale?:string,
              partitaIva?:string):Observable<PersonaGiuridica[]|{message:string}>{
    let queryParams = new HttpParams();
    if(gruppoOperatore)
      queryParams = queryParams.append("gruppoOperatore",gruppoOperatore)
                               .append("codOperatore",codOperatore!);
    if(denominazione)
      queryParams = queryParams.append("denominazionePersonaGiuridica",denominazione);
    if(codiceFiscale)
      queryParams = queryParams.append("codiceFiscale",codiceFiscale);
    if(partitaIva)
      queryParams = queryParams.append("partitaIva",partitaIva);



    return this.http.get<PersonaGiuridica[] | {message:string}>(this.config.ricercaOperatoreUrl,
                                            {params:queryParams})
  }

  //----------------------------------------------------------------------------------------------
  // regionale  operatori
  getRegionaleOperatori(
              gruppoOperatore:string, codOperatore:string,
              idProvincia?:string, idComune?:string): Observable<SedeOperatore[]>{
    let queryParams = new HttpParams().append("gruppoOperatore",gruppoOperatore)
                                      .append("codOperatore",codOperatore)

    if(idComune)
      queryParams = queryParams.append("codiceIstatComune",idComune)
    else if(idProvincia)
      queryParams = queryParams.append("codiceProvincia",idProvincia)

    return this.http.get<SedeOperatore[]>(
      this.config.regionaliOperatoriUrl,
      {params:queryParams})
  }

  getRuoliEnti():Observable<RuoloEnte[]>{
    return this.http.get<RuoloEnte[]>(this.config.ruoliEnteUrl)
  }

  //----------------------------------------------------------------------------------------------
  // ISTITUTI SCOLASTICI

  getGradiScolastici():Observable<GradoScolastico[]>{
    return this.http.get<GradoScolastico[]>(this.config.gradiScolasticiUrl);
  }
  getTipologieIstituti():Observable<TipologiaIstitutoScolastico[]>{
    return this.http.get<TipologiaIstitutoScolastico[]>(this.config.tipologieIstitutiUrl)
  }
  getPercorsiScolastici():Observable<PercorsoScolastico[]>{
    return this.http.get<PercorsoScolastico[]>(this.config.percorsiScolasticiUrl)
  }

  getIstitutiScolastici(idPercorsoScolastico?:string ,codiceComune?:string ,codiceProvincia?:string ,idGradoScolastico?:string
                        ,idTipologiaIstituto?:string ,codiceRegionale?:string,codiceMeccanografico?:string ,enteCoinvolto?:string): Observable<IstitutoScolasticoWrapper[]|{message:string}>{

    let queryParams = new HttpParams();
    if(idPercorsoScolastico)
      queryParams = queryParams.append("idPercorsoScolastico",idPercorsoScolastico);
    if(codiceComune)
      queryParams = queryParams.append("codiceComune",codiceComune);
    if(codiceProvincia){
      queryParams = queryParams.append("codiceProvincia",codiceProvincia);}
    if(idGradoScolastico)
      queryParams = queryParams.append("idGradoScolastico",idGradoScolastico);
    if(idTipologiaIstituto)
      queryParams = queryParams.append("idTipologiaIstituto",idTipologiaIstituto);
    if(codiceRegionale)
      queryParams = queryParams.append("codiceRegionale",codiceRegionale);
    if(codiceMeccanografico)
      queryParams = queryParams.append("codiceMeccanografico",codiceMeccanografico);
    if(enteCoinvolto)
      queryParams = queryParams.append("denominazioneEnte",enteCoinvolto);

    return this.http.get<IstitutoScolasticoWrapper[]|{message:string}>(this.config.istitutiScolasticiUrl,{params:queryParams});
  }

}
