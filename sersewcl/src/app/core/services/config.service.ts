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

import { Injectable } from '@angular/core';
import { environment } from '@environment/environment';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {


  beRootPath = '/serseweb/bff/v1';


  getBERootUrl(): string {
    return environment.beServerPrefix + this.beRootPath;
  }

  //############################################
  // Main Url
  get rootUrl() {
    return this.getBERootUrl();
  }

  get versioneUrl() {
    return this.rootUrl + "/test-resources/test-versione";
  }
  //############################################
  // Excel Urls
  get excelUrl() {
    return this.rootUrl + "/excel"
  }
  get excelServiziUrl() {
    return this.excelUrl + "/esporta-excel-servizi"
  }

  get excelInterventiUrl() {
    return this.excelUrl + "/esporta-excel-interventi"
  }

  get excelModelliUrl() {
    return this.excelUrl + "/esporta-excel-modelli"
  }

  get excelServiziUrlV2() {
    return this.excelUrl + "/v2/esporta-excel-servizi"
  }

  get excelInterventiUrlV2() {
    return this.excelUrl + "/v2/esporta-excel-interventi"
  }

  get excelModelliUrlV2() {
    return this.excelUrl + "/v2/esporta-excel-modelli"
  }

  //############################################
  // User info Urls
  get ruoliUrl() {
    return this.rootUrl + "/ruoli";
  }
  get userInfoUrl() {
    return this.rootUrl + "/user-info";
  }
  get infoOperatoreUrl() {
    return this.rootUrl + "/info-operatore";
  }
  get personaGiuridicaUrl() {
    return this.infoOperatoreUrl + "/persona-giuridica";
  }

  //############################################
  // Avvisi Url
  get tipologieUrl() {
    return this.rootUrl + "/tipologie-pso";
  }
  get psoUrl() {
    return this.rootUrl + "/pso";
  }
  get sportelliUrl() {
    return this.rootUrl + "/sportelli";
  }

  //############################################
  // Criteri di ricerca
  get soggettoAttuatoreUrl() {
    return this.rootUrl + "/soggetto-attuatore";
  }

  get soggettiAttuatoriUrl() {
    return this.soggettoAttuatoreUrl + "/soggetti-attuatori";
  }

  get areeTerritorialiUrl() {
    return this.soggettoAttuatoreUrl + "/aree-territoriali-di-finanziamento";
  }


  get serviziInterventoUrl() {
    return this.serviziUrl + "/id-intervento";
  }

  get soggettoBeneficiarioUrl() {
    return this.soggettoAttuatoreUrl + "/soggetti-beneficiari";
  }
  get istanzeCandidaturaUrl() {
    return this.soggettoAttuatoreUrl + "/istanze-candidatura";
  }

  get serviziRegionaliUrl() {
    return this.serviziUrl + "/servizi-regionali";
  }
  get serviziRegionaliServizioUrl() {
    return this.serviziUrl + "/servizi-regionali-per-servizio";
  }

  get tipologiaServizioUrl() {
    return this.serviziUrl + "/tipologie-servizi";
  }


  //############################################
  // Criteri di ricerca modelli
  get modelliInterventoUrl() {
    return this.rootUrl + "/modelli-di-intervento";
  }

  get tipiModelloUrl() {
    return this.rootUrl + "/tipi-modello";
  }

  get statiModelloUrl() {
    return this.modelliInterventoUrl + "/stati";
  }

  get associaModelloInterventoUrl() {
    return this.modelliInterventoUrl + "/associa-modello-di-intervento";
  }

  get disassociaModelloInterventoUrl() {
    return this.modelliInterventoUrl + "/disassocia-modello-di-intervento";
  }

  get duplicaModelloInterventoUrl() {
    return this.modelliInterventoUrl + "/duplica-modello-intervento";
  }

  get datiExcelUrl() {
    return this.modelliInterventoUrl + "/preparazione-excel"
  }

  get interventiModelloUrl() {
    return this.modelliInterventoUrl + "/:idModelloIntervento/interventi"
  }

  //############################################
  // Target-destinatari
  get destinatariUrl() {
    return this.rootUrl + "/destinatari";
  }

  get targetDestinatariUrl() {
    return this.destinatariUrl + "/target-destinatari";
  }
  get targetDestinatariAssociatiUrl() {
    return this.destinatariUrl + "/target-destinatario-associati";
  }

  get targetDestinatariServiozioUrl() {
    return this.destinatariUrl + "/target-destinatari-servizio"
  }

  get targetDestinatariServizioAssociatiUrl() {
    return this.destinatariUrl + "/target-destinatari-servizio-associato"
  }

  get targetDestinatariAssociatiInterventoUrl() {
    return this.destinatariUrl + "/target-destinatari-servizio-associato-intervento"
  }
  //###########################################
  //DESTINATARI
  get destinatariRicercaUrl() {
    return this.destinatariUrl + "/ricerca";
  }

  get assocciaDestinatarioAdInterventoaUrl() {
    return this.destinatariUrl + "/associa-destinatario-intervento";
  }
  get aggiungiDestinatarioEdAssocciaAdInterventoaUrl() {
    return this.destinatariUrl + "/destinatario-intervento";
  }
  get destinatariInterventoServizioUrl() {
    return this.destinatariUrl + "/destinatario-intervento-servizio";
  }

  get AssociaDestinatarioAServizioUrl() {
    return this.destinatariUrl + "/associa-destinatario-servizio"
  }
  get destinatariServizioUrl() {
    return this.destinatariUrl + "/destinatario-servizio";
  }

  get destinatariServiziServizioUrl() {
    return this.destinatariUrl + "/destinatari-servizi-servizio";
  }

  get rinumeraDestinatariServizioUrl() {
    return this.destinatariUrl + "/destinatari-servizio/rinumera";
  }

  get testCodiceFiscaleUrl() {
    return this.destinatariUrl + "/test-codice-fiscale";
  }

  get entiDestinarioUrl() {
    return this.entiCoinvoltiUrl + "/enti-destinatari"
  }

  get datiPeculiariDestinatarioUrl() {
    return this.destinatariServizioUrl + "/dati-peculiari"
  }

  get classiDestinatario() {
    return this.destinatariUrl + "/classi-destinatario"
  }

  get titoliStudioIgrueUrl() {
    return this.destinatariUrl + "/titoli-studio-igrue"
  }

  get condizioneOccupazionaleIgrueUrl() {
    return this.destinatariUrl + "/condizione-occupazionale-igrue"
  }

  get serviziPerDestinatarioUrl() {
    return this.destinatariUrl + "/servizi"
  }

  get serviziDestinatarioIntervento() {
    return this.destinatariUrl + "/servizi-intervento"
  }
  get incontriPerDestinatarioUrl() {
    return this.destinatariUrl + "/incontri"
  }

  get destinatariInterventoUrl() {
    return this.destinatariUrl + "/destinatario-servizio-intervento"
  }
  //############################################
  // Caratteristiche
  get caratteristicheUrl() {
    return this.rootUrl + "/caratteristiche";
  }

  get caratteristicheAssociateUrl() {
    return this.caratteristicheUrl + "/caratteristiche-associate";
  }

  get caratteristichePsoUrl() {
    return this.caratteristicheUrl + "/caratteristiche-per-pso";
  }
  get caratteristicheServizioUrl() {
    return this.caratteristicheUrl + "/caratteristiche-servizio";
  }

  get caratteristicheServizioAssociateUrl() {
    return this.caratteristicheUrl + "/caratteristiche-associate-servizio"
  }

  get caratteristicheAssociateInterventoUrl() {
    return this.caratteristicheUrl + "/caratteristiche-associate-servizio-intervento"
  }
  //############################################
  // Tipologie Servizi
  get tipologieServiziUrl() {
    return this.serviziUrl + "/tipologie-servizi";
  }

  get servizioModelloEsternoUrl() {
    return this.serviziUrl + "/servizio-modello-esterno";
  }
  get serviziModelloEsternoUrl() {
    return this.serviziUrl + "/servizi-modello-esterno";
  }

  get serviziModelloRegionaliUrl() {
    return this.serviziUrl + "/servizi-modello-regionali";
  }

  get serviziregionaliPerInterventoUrl() {
    return this.serviziUrl + "/tipologie-servizi-intervento";
  }
  //#############################################
  // Modelli
  get modelloSelezionatoUrl() {
    return this.modelliInterventoUrl + "/seleziona-modello"
  }
  get modelloTestModificaUrl() {
    return this.modelliInterventoUrl + "/test-modifica"
  }

  //#############################################
  // ENTI COINVOLTI
  get entiCoinvoltiUrl() {
    return this.rootUrl + "/enti-coinvolti"
  }
  get enteCoinvoltoModelloUrl() {
    return this.entiCoinvoltiUrl + "/ente-coinvolto-modello"
  }
  get enteCoinvoltoInterventoModelloUrl() {
    return this.entiCoinvoltiUrl + "/ente-coinvolto-intervento-modello"
  }
  get entiCoinvoltoModelloUrl() {
    return this.entiCoinvoltiUrl + "/enti-coinvolti-modello"
  }
  get entiFonteDatoUrl() {
    return this.entiCoinvoltiUrl + "/id-fonte-dato"
  }

  get cessazioneEnteUrl() {
    return this.enteCoinvoltoModelloUrl + "/cessare"
  }
  //#############################################
  //ENTI COINVOLTI INTERVENTO
  get enteCoinvoltoInterventoUrl() {
    return this.entiCoinvoltiUrl + "/ente-coinvolto-intervento"
  }

  get entiCoinvoltiInterventoUrl() {
    return this.entiCoinvoltiUrl + "/enti-coinvolti-intervento"
  }

  get enteCoinvoltoInterventoVerificaUrl() {
    return this.enteCoinvoltoInterventoUrl + "/verifica-aggiungi"
  }


  //#############################################
  //ENTI COINVOLTI SERVIZI
  get enteCoinvoltoServizioUrl() {
    return this.entiCoinvoltiUrl + "/ente-coinvolto-servizio"
  }

  get entiCoinvoltiServizioUrl() {
    return this.entiCoinvoltiUrl + "/enti-coinvolti-servizio"
  }

  //#############################################
  // Dati Comuni

  get datiComuniUrl() {
    return this.rootUrl + "/dati-comuni"
  }

  get provinceUrl() {
    return this.datiComuniUrl + "/province"
  }
  get comuniUrl() {
    return this.datiComuniUrl + "/comuni"
  }

  get infoComuniUrl() {
    return this.datiComuniUrl + "/info-comuni"
  }

  get infoStatiEsteriUrl() {
    return this.datiComuniUrl + "/info-stati-esteri"
  }

  get statiEsteriUrl() {
    return this.datiComuniUrl + "/stati-esteri"
  }

  get cittadinanzeUrl() {
    return this.datiComuniUrl + "/cittadinanze"
  }


  //#############################################
  // centri-per-impiego
  get centriPerImpiegoUrl() {
    return this.rootUrl + "/centri-per-impiego"
  }

  //############################################
  // ricerca-operatore
  get ricercaOperatoreUrl() {
    return this.infoOperatoreUrl + "/ricerca-operatore"
  }

  //###############################################
  // interventi

  get interventiUrl() {
    return this.rootUrl + "/interventi"
  }

  get interventiTestModificaUrl() {
    return this.interventiUrl + "/test-modifica"
  }

  get interventiTestChiusuraUrl() {
    return this.interventiUrl + "/test-chiusura"
  }


  get interventiByIdUrl() {
    return this.interventiUrl + "/seleziona-intervento"
  }


  //###############################################
  // criteri ricerca interventi
  get istanzeCandidaturaInterventiUrl() {
    return this.soggettoAttuatoreUrl + "/istanze-candidatura-per-intervento"
  }

  get soggettoBeneficiarioInterventiUrl() {
    return this.soggettoBeneficiarioUrl + "/intervento-associato"
  }

  get tipologieServiziInterventoUrl() {
    return this.serviziUrl + "/tipologie-servizi-intervento"
  }

  get tipologieInterventoUrl() {
    return this.interventiUrl + "/tipologie-intervento"
  }

  get statiInterventoUrl() {
    return this.interventiUrl + "/stati"

  }
  get regionaliOperatoriUrl() {
    return this.infoOperatoreUrl + "/elenco-sedi"
  }
  get ruoliEnteUrl() {
    return this.entiCoinvoltiUrl + "/ruolo-ente"
  }

  get duplicaInterventoURL() {
    return this.interventiUrl + "/duplica-intervento"
  }

  //###########################################
  // ISTITUTI SCOLASTICI

  get istitutiScolasticiUrl() {
    return this.rootUrl + "/istituti-scolastici"
  }

  get gradiScolasticiUrl() {
    return this.istitutiScolasticiUrl + "/gradi-scolastici"
  }

  get tipologieIstitutiUrl() {
    return this.istitutiScolasticiUrl + "/tipologie-istituti"
  }

  get percorsiScolasticiUrl() {
    return this.istitutiScolasticiUrl + "/percorsi-scolastici"
  }

  //##########################################
  //SERVIZI

  get serviziUrl() {
    return this.rootUrl + "/servizi";
  }

  get serviziDestinatariUrl() {
    return this.serviziUrl + "/destinatari"
  }

  get servizioUrl() {
    return this.serviziUrl + "/seleziona-servizio"
  }
  get statiServizioUrl() {
    return this.serviziUrl + "/stati-servizi"
  }

  get verificaPeriodoAttivazioneUrl() {
    return this.serviziUrl + "/verifica-periodo-attivazione-servizio"
  }

  get testServizioAssociatoAmodelloUrl() {
    return this.serviziUrl + "/target-destinatari-servizio-associato-test"
  }

  get chiusuraServizioUrl() {
    return this.serviziUrl + "/chiusura"
  }

  get verificaDatiPeculiariMancantiUrl() {
    return this.destinatariServizioUrl + "/destinatari-dati-peculiari-mancanti"
  }

  get verificaDatiPeculiariServizio() {
    return this.serviziUrl + "/dati-peculiari/controllo-dati-peculiari"
  }

  get datiPeculiariServizi() {
    return this.serviziUrl + "/dati-peculiari"
  }
  get caricaDestinatariArrayUrl() {
    return this.destinatariUrl + "/carica-destinatari-servizio"
  }

  get labelCampoAggiuntivo() {
    return this.serviziUrl + "/campo-aggiuntivo"
  }

  get flgCampoAggiuntivo() {
    return this.serviziUrl + "/flg-campo-aggiuntivo"
  }
  //###########################################
  //Classificazioni
  get classificazioniUrl() {
    return this.rootUrl + "/classificazioni"
  }
  get classificazioniPORUrl() {
    return this.classificazioniUrl + "/pso-servizio-regionale";
  }

  //###########################################
  //Incontri
  get incontriiUrl() {
    return this.rootUrl + "/incontri";
  }

  get incontroUrl() {
    return this.incontriUrl + "/incontro"
  }
  get totaleOreIncontro() {
    return this.incontriiUrl + "/somma-durate-ore";
  }

  get testChiusuraIncontro() {
    return this.incontriUrl + "/test-chiusura"
  }

  get luogoIncontroUrl() {
    return this.incontriUrl + "/luogo-incontro"
  }
  get sediSoggAttUrl() {
    return this.infoOperatoreUrl + '/elenco-sedi-autorizzati'
  }
  get sediSoggAttCodGruppoUrl() {
    return this.infoOperatoreUrl + '/elenco-sedi-autorizzati-codgruppo'
  }
  get baciniProvinciaUrl() {
    return this.luogoIncontroUrl + "/bacini-provincia"
  }

  get comuniBacinoUrl() {
    return this.luogoIncontroUrl + "/comuni-bacino"
  }
  //###########################################
  //-Servizio GAM
  get servizioGAMUrl() {
    return this.rootUrl + "/servizio-gam";
  }
  get tokenGamServizioUrl() {
    return this.servizioGAMUrl + "/token-gam-servizio";
  }
  get tokenGamIncontroUrl() {
    return this.servizioGAMUrl + "/token-gam-incontro"
  }
  get calcPreventivoSerseUrl() {
    return this.servizioGAMUrl + "/calc-preventivo-serse";
  }
  get nuovoServizioSerseUrl() {
    return this.servizioGAMUrl + "/nuovo-servizio-serse";
  }
  get chiudiIncontroGamUrl() {
    return this.servizioGAMUrl + "/nuovo-incontro-serse";
  }
  get riapriIncontroGamUrl() {
    return this.servizioGAMUrl + "/riapri-incontro-serse";
  }
  get riportaServizioInDefGamUrl() {
    return this.servizioGAMUrl + "/riporta-servizio-in-definizione";
  }
  get voceSpesaUrl() {
    return this.serviziUrl + "/servizi-voce-spesa";
  }
  get fonteFinanzUrl() {
    return this.serviziUrl + "/servizi-fonte";
  }

  get storicoServizioUrl() {
    return this.serviziUrl + "/servizio-sto"
  }

  get dettaglioClasseDestinatarioServizioUrl() {
    return this.serviziUrl + "/classe-servizio"
  }

  //###########################################
  //-Strumenti
  get verificaBudgetUrl() {
    return this.servizioGAMUrl + "/budget-disponibile-per-soggetto";
  }

  //Incontri servizi
  get incontriUrl() {
    return this.rootUrl + "/incontri"
  }

  //###########################################
  //-Partecipanti
  get incontroDestinatarioServizioUrl() {
    return this.incontriUrl + "/incontro-destinatario-servizio";
  }
  get incontroDestAssServizioUrl() {
    return this.incontroDestinatarioServizioUrl + "/idservizio";
  }
  get assocIncontroDestinatarioURL() {
    return this.incontroDestinatarioServizioUrl + "/associa-destinatari-incontro";
  }

  //###########################################
  //-Proposta modifica
  get serviziPropostaModificaUrl() {
    return this.serviziUrl + "/servizio-gam-proposta-modifica";
  }

}
