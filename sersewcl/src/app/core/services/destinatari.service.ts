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

import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { ManagedHttpClient } from './managed-http-client.service';
import { ConfigService } from './config.service';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { HttpParams } from '@angular/common/http';
import { DatiPeculiari } from '@core/api-serse/model/datiPeculiari';
import { TitoloStudioIgrue } from '@core/api-serse/model/titoloStudioIgrue';
import { CondizioneOccupazionaleIgrue } from '@core/api-serse/model/condizioneOccupazionaleIgrue';
import { DatiPeculiariWrapper } from '@core/api-serse/model/datiPeculiariWrapper';
import { GenericResponse } from '@core/api-serse/model/genericResponse';
import { Servizio } from '@core/api-serse/model/servizio';
import { Incontro } from '@core/api-serse/model/incontro';
import { DestinatarioServizio } from '@core/api-serse/model/destinatarioServizio';
import { Comune } from '@core/api-serse/model/comune';
import { StatoEstero } from '@core/api-serse/model/statoEstero';
import { DestinatarioServizioCaricato } from '@core/api-serse/model/destinatarioServizioCaricato';
import { ClasseDestinatario } from '@core/api-serse/model/classeDestinatario';

@Injectable({
  providedIn: 'root'
})
export class DestinatariService {

  idIntervento!: number;
  backTo: string = "";

  destAlreadyAssoc: string[] = [];
  numDestinatAssoc: number = 0;


  flagInterventoService = -1;
  _destinatario:Destinatario={};
  constructor(
    private http: ManagedHttpClient,
    private conf: ConfigService
  ) { }


  getDestinatari(cognome?:string, nome?:string ,
                codFisc?:string, dataDiNascita?:string):Observable<Destinatario[]>{

    let queryParams = new HttpParams();
    if(cognome)
      queryParams = queryParams.append("cognome",cognome);
    if(nome)
      queryParams = queryParams.append("nome",nome);
    if(codFisc)
      queryParams = queryParams.append("codiceFiscaleDestinatario",codFisc);
    if(dataDiNascita)
      queryParams = queryParams.append("dataDiNascita",dataDiNascita);

    return this.http.get<Destinatario[]>(this.conf.destinatariRicercaUrl,
                                        {params:queryParams})
  }

  getDestinatarioById(idDestinatario:string): Observable<Destinatario> {
    let queryParams = new HttpParams().append("idDestinatario", idDestinatario)
    return this.http.get<Destinatario>(this.conf.destinatariUrl,{params:queryParams})
  }

  getClassiDestinatario(idPso: number): Observable<ClasseDestinatario[]>{
	let queryParams = new HttpParams().append("idPso", idPso)
    return this.http.get<ClasseDestinatario[]>(this.conf.classiDestinatario, {params:queryParams})
  }

  getTitoliIgrue(): Observable<TitoloStudioIgrue[]>{
    return this.http.get<TitoloStudioIgrue[]>(this.conf.titoliStudioIgrueUrl)
  }

  getCondizioneOccupazionaleIgrue():Observable<CondizioneOccupazionaleIgrue[]>{
    return this.http.get<CondizioneOccupazionaleIgrue[]>(this.conf.condizioneOccupazionaleIgrueUrl)
  }

  getDatiPeculiari(idDestinatario:number,idServizio:number,idPso:number,numProgrSportello:number):Observable<DatiPeculiariWrapper>{
    let queryParams = new HttpParams().append("idDestinatario", idDestinatario)
                                      .append("idServizio", idServizio)
                                      .append("idPso",idPso)
                                      .append("numProgrSportello",numProgrSportello)
    return this.http.get<DatiPeculiariWrapper>(this.conf.datiPeculiariDestinatarioUrl,{params:queryParams})
  }
  aggiungiNuovoDestinatarioIntervento(idIntervento:string, codUserAggiornamento:string, destinatario:Destinatario){
    let queryParams = new HttpParams().append("idIntervento", idIntervento)
                                      .append("codUserAggiornamento",codUserAggiornamento)
    return this.http.post<Destinatario>(this.conf.aggiungiDestinatarioEdAssocciaAdInterventoaUrl,destinatario,queryParams);
  }
  aggiungiNuovoDestinatarioServizio(idServizio:number,codUserAggiornamento:string,destinatario:Destinatario):Observable<Destinatario>{
    let queryParams = new HttpParams().append("idServizio", idServizio)
                                      .append("codUserAggiornamento", codUserAggiornamento)
     return this.http.post<Destinatario>(this.conf.destinatariServizioUrl,destinatario,queryParams)
  }

  aggiornaDestinatario(destinatario:Destinatario){
    return this.http.put<Destinatario>(this.conf.destinatariUrl,destinatario);
  }
  aggiornaDatiPeculiariDest(datiPeculiari:DatiPeculiari){
    return this.http.put<DatiPeculiari>(this.conf.datiPeculiariDestinatarioUrl,datiPeculiari)
  }
  assocciaDestinatarioAdIntervento(idIntervento:number,codUserAggiornamento:string,idDestinatario:number){
    let queryParams = new HttpParams().append("idIntervento", idIntervento.toString())
                                      .append("codUserAggiornamento", codUserAggiornamento)
                                      .append("idDestinatario", idDestinatario.toString())
    return this.http.put<any>(this.conf.assocciaDestinatarioAdInterventoaUrl,null,queryParams)
  }

  rinumeraDestinatariServizio(idServizio: number){
    return this.http.post<Comune[]>(this.conf.rinumeraDestinatariServizioUrl, {idServizio: idServizio});
  }

  assocciaDestinatarioAServizio(idServizio:number,codUserAggiornamento:string,destinatari:Destinatario[]):Observable<DestinatarioServizio[]>{
    let queryParams = new HttpParams().append("idServizio", idServizio)
                                      .append("codUserAggiornamento", codUserAggiornamento)
    return this.http.post<DestinatarioServizio[]>(this.conf.AssociaDestinatarioAServizioUrl,destinatari,queryParams)
  }
  disassociaDestinatarioAservizio(idServizio:string,idDestinatario:string):Observable<GenericResponse>{
    let queryParams = new HttpParams().append("idServizio", idServizio)
                                      .append("idDestinatario", idDestinatario)
    return this.http.delete<GenericResponse>(this.conf.AssociaDestinatarioAServizioUrl,null,queryParams)
  }
  testCodiceFiscale(codFisc:string){
    let queryParams = new HttpParams().append("codiceFiscaleDestinatario", codFisc)

    return this.http.get<any>(this.conf.testCodiceFiscaleUrl,{params:queryParams})
  }



  getDestinatariInterventoServizio(idServizio:string):Observable<Destinatario[]>{
    let queryParams = new HttpParams().append("idServizio", idServizio)

    return this.http.get<Destinatario[]>(this.conf.destinatariInterventoServizioUrl,{params:queryParams})
  }

  getServiziForDestinatario(idDestinatario: number):Observable<Servizio[]>{
    let queryParams = new HttpParams().append("idDestinatario", idDestinatario)
    return this.http.get<Servizio[]>(this.conf.serviziPerDestinatarioUrl,{params:queryParams})
  }

  getServiziForDestinatarioIntervento(idDestinatario: number,idIntervento:number):Observable<Servizio[]>{
    let queryParams = new HttpParams().append("idDestinatario", idDestinatario)
                                      .append("idIntervento", idIntervento)
    return this.http.get<Servizio[]>(this.conf.serviziDestinatarioIntervento,{params:queryParams})
  }
  getDestinatariIntervento(idIntervento:number):Observable<Destinatario[]>{
    let queryParams = new HttpParams().append("idIntervento", idIntervento)
    return this.http.get<Destinatario[]>(this.conf.destinatariInterventoUrl,{params:queryParams})
  }

  getIncontriForDestinatario(idDestinatario: string):Observable<Incontro[]>{
    let queryParams = new HttpParams().append("idDestinatario", idDestinatario)
    return this.http.get<Incontro[]>(this.conf.incontriPerDestinatarioUrl,{params:queryParams})
  }
   get destinatario(){
    return this._destinatario;
   }

   set destinatario(_destinatario:Destinatario){
    this._destinatario=_destinatario;
   }



   //---------------------------------------------------------------
   //-chiamta array destinatary
  //  postDestinatariServizio(destaintari:Destinatario[]):Observable<Destinatario[]>{
  //   let queryParams = new HttpParams().append("idServizio", idServizio)

  //   return this.http.post<Destinatario[]>(this.conf.destinatariInterventoServizioUrl,{params:queryParams})
  // }

  //-Array Comuni
  getComuniByCodiceIstat(comuni:Comune[]){
    return this.http.post<Comune[]>(this.conf.infoComuniUrl,comuni);
  }
  //-Array Stati
  getStatiByCodiceStato(stati:StatoEstero[]){
    return this.http.post<StatoEstero[]>(this.conf.infoStatiEsteriUrl,stati);
  }

  postDestinatari(idServizio:string, codUserAggiornamento:string,destinatari:Destinatario[]){
    //idServizio
    //codiceuserAggiornamento
    let queryParams = new HttpParams().append("idServizio", idServizio)
                                      .append("codUserAggiornamento", codUserAggiornamento);

    return this.http.post<DestinatarioServizioCaricato[]>(this.conf.caricaDestinatariArrayUrl,destinatari,queryParams);
  }


  checkCodiceFiscale(nome:String, cognome:string, dataNascita:Date, codFiscLuogo:string){
    let giornoNascita = dataNascita.getDate();
    let meseNascita = dataNascita.getMonth()+1;
    let annoNascita = dataNascita.getFullYear().toString().substring(2);

    let codFCognome = this.handelNomeCognome(String(cognome))!;
    let codFNome = this.handelNomeCognome(String(nome), true)!;
    let mese = this.handelMese(meseNascita)!;

    let CFM = codFCognome[0]+codFCognome[1]+codFCognome[2]+
              codFNome[0]+codFNome[1]+codFNome[2]+
              annoNascita+
              mese+
              (giornoNascita<10? "0"+giornoNascita:giornoNascita)+
              codFiscLuogo
    let CFF = codFCognome[0]+codFCognome[1]+codFCognome[2]+
              codFNome[0]+codFNome[1]+codFNome[2]+
              annoNascita+mese+(giornoNascita+40)+codFiscLuogo

    CFM += this.calcolaLetteraControllo(CFM);
    CFF += this.calcolaLetteraControllo(CFF);

    return [CFM, CFF];
  }




  calcolaLetteraControllo(CF:string){
    var caratteri_lista = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
    //#OPERAZIONI
     let somma_dispari = 0; // INIZIALIZZA SOMMA DISPARI
     let somma_pari = 0;  // INIZIALIZZA SOMMA PARI
     let pos = 0; // INIZIALIZZA SOMMA CONTROLLO
     for(let i = 0; i<CF.length; i++){
       if(i%2==0){
        somma_dispari+= this.convertOddCharachter(CF.charAt(i))
       }
       else{
         somma_pari += this.convertEvenCharachter(CF.charAt(i))
       }
     }
     pos = (somma_dispari + somma_pari) %26;
     return caratteri_lista[pos];
  }

  convertOddCharachter(char:string){
    switch (char) {
      case '0': case 'A': return 1;
      case '1': case 'B': return 0;
      case '2': case 'C': return 5;
      case '3': case 'D': return 7;
      case '4': case 'E': return 9;
      case '5': case 'F': return 13;
      case '6': case 'G': return 15;
      case '7': case 'H': return 17;
      case '8': case 'I': return 19;
      case '9': case 'J': return 21;
      case 'K': return 2;
      case 'L': return 4;
      case 'M': return 18;
      case 'N': return 20;
      case 'O': return 11;
      case 'P': return 3;
      case 'Q': return 6;
      case 'R': return 8;
      case 'S': return 12;
      case 'T': return 14;
      case 'U': return 16;
      case 'V': return 10;
      case 'W': return 22;
      case 'X': return 25;
      case 'Y': return 24;
      case 'Z': return 23;
    }
    return -1;
  }
  convertEvenCharachter(char:string){
    switch (char) {
      case '0': case 'A': return 0;
      case '1': case 'B': return 1;
      case '2': case 'C': return 2;
      case '3': case 'D': return 3;
      case '4': case 'E': return 4;
      case '5': case 'F': return 5;
      case '6': case 'G': return 6;
      case '7': case 'H': return 7;
      case '8': case 'I': return 8;
      case '9': case 'J': return 9;
      case 'K': return 10;
      case 'L': return 11;
      case 'M': return 12;
      case 'N': return 13;
      case 'O': return 14;
      case 'P': return 15;
      case 'Q': return 16;
      case 'R': return 17;
      case 'S': return 18;
      case 'T': return 19;
      case 'U': return 20;
      case 'V': return 21;
      case 'W': return 22;
      case 'X': return 23;
      case 'Y': return 24;
      case 'Z': return 25;
    }
    return -1;
  }

  handelNomeCognome(nomeOrCognome:string, isNome:boolean = false){
    let consonanti_nome = [];
    let vocali_nome = [];
    let vocali:string[]=[];

    // VARIABILI FILTRO
    let consonanti:string[]=[];
    // VARIABILE CONTROLLO
    let consonanti_prese_nome;
    //CONTATORI
    let n_cons = 0; // CONTA CONS

    //#1 STEP : LA LUNGHEZZA NOME
    if(nomeOrCognome.length < 3){
      nomeOrCognome += "x"
    }else{
      //#2 STEP : DISTINZIONE TRA VOCALI E CONSONANTI
      for(let i = 0; i<=nomeOrCognome.length; i++){
        if(nomeOrCognome.charAt(i).match(/[aeiouAEIOU]/)){
          //- Prendo le vocali
          vocali_nome[i] = nomeOrCognome.charAt(i).toUpperCase();
          vocali = vocali_nome.filter(Boolean);
        }
        else if(nomeOrCognome.charAt(i).match(/[/' ,/"]/)){continue;}
        else{
          //- Prendo le consonanti
          consonanti_nome[i] = nomeOrCognome.charAt(i).toUpperCase();
          consonanti = consonanti_nome.filter(Boolean);

          //#CONTA CONSONANTI
          if (consonanti_nome[i] != "") { n_cons++; }
        }
      }
    }

    //#3 STEP ---> SE LE CONSONANTI SONO MAGGIORI O UGUALI A 4
    //SE LE CONSONANTI SONO PIU' DI 4
    if (consonanti.length >= 4) {
      //prendo le consonanti a posizione 0,2,3
      if(isNome)
        consonanti_prese_nome = [consonanti[0], consonanti[2], consonanti[3]];
      else
        consonanti_prese_nome = [consonanti[0], consonanti[1], consonanti[2]];

    }
    //SE LE CONSONANTI SONO 1
    else if (consonanti.length == 1) {
      consonanti_prese_nome = [consonanti[0], vocali[0], vocali[1]];
    }
    //SE LE CONSONANTI SONO MENO DI 3
    else if (consonanti.length < 3) {
      //prendo le consonanti a posizione 0,1 e la prima vocale
      consonanti_prese_nome = [consonanti[0], consonanti[1], vocali[0]];
    }
    //SE LE CONSONANTI SONO 3
    else if (consonanti.length == 3) {
      //prendo le consonanti a posizione 0,1,2
      consonanti_prese_nome = [consonanti[0], consonanti[1], consonanti[2]];
    }
    return consonanti_prese_nome;
  }
  handelMese(mese:number){
    let cod_mese = ['A', 'B', 'C', 'D', 'E', 'H', 'L', 'M', 'P', 'R', 'S', 'T'];
    switch (mese) {
      case 1:
        return cod_mese[0];
      case 2:
        return cod_mese[1];
      case 3:
        return cod_mese[2];
      case 4:
        return cod_mese[3];
      case 5:
        return cod_mese[4];
      case 6:
        return cod_mese[5];
      case 7:
        return cod_mese[6];
      case 8:
        return cod_mese[7];
      case 9:
        return cod_mese[8];
      case 10:
        return cod_mese[9];
      case 11:
        return cod_mese[10];
      case 12:
        return cod_mese[11];
    }
    return 'Z';
  }


}
