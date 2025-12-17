package it.csi.serse.serseweb.api.impl;

/*-
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

import java.math.BigDecimal;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.DettaglioPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultDettaglioPersonaGiuridica;
import it.csi.serse.serseweb.api.InfoOperatoreApi;
import it.csi.serse.serseweb.api.manager.InfoOperatoreManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgsediHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.SecurityHelper;
import it.csi.serse.serseweb.mapper.FlaiAnagMapper;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.SedeOperatore;

@Component
public class InfoOperatoreApiImpl extends ParentOverWebApi implements InfoOperatoreApi {
	@Autowired
	private SecurityHelper securityHelper;
	
	@Autowired
	private FlaiAnagMapper flaiAnagMapper;
	
	@Autowired
	private FlaianagpgHelper flaiAnagPg;
	
	@Autowired
	private FlaianagpgsediHelper flaiAnagPgSedi;
	
	@Autowired
	private InfoOperatoreManager infoOperatoreManager;

	/*
	 * Nel momento in cui l’utente seleziona il ruolo nella lista “Seleziona un
	 * ruolo” (vedi paragrafo precedente), il sistema richiama il servizio di
	 * FLAIDOOR getInfoPersonaInUseCase passando come parametri l’oggetto identità e
	 * ricevendo in out una lista contenente le informazioni aggiuntive relative ai
	 * ruoli previsti per l’utente che si sta connettendo. Le informazioni
	 * aggiuntive previste nel caso dei ruoli “Responsabile Erogazione Servizi” o
	 * “Operatore Erogazione Servizi” sono, facendo un esempio concreto:
	 * 
	 * <codiceDbOperatore>20013</codiceDbOperatore>
	 * <codiceOperatore>6</codiceOperatore> 
	 * <descrizioneOperatore>B6 - * CNOS-FAP</descrizioneOperatore> 
	 * <gruppoOperatore>B</gruppoOperatore>
	 * 
	 * Il sistema deve filtrare l’elenco di queste Info Aggiuntive in base al
	 * cod_ruolo scelto dall’utente nella prima selezione e visualizzarle nella
	 * lista di selezione “Seleziona un Operatore” secondo questo formato:
	 * “[<gruppoOperatore><codiceOperatore>] - <descrizioneOperatore>”
	 * 
	 * Esempio: “[B6] – CNOS-FAP”
	 * 
	 * ordinando la lista in ordine alfabetico crescente di
	 * gruppoOPeratore||codiceOperatore e descrizioneOperatore
	 * 
	 * L’utente deve selezionare una voce dalla lista e confermare le scelte
	 * mediante il pulsante CONFERMA (vedi interfacce)
	 */
	@Override
	public Response getInfoOperatoreForRuolo(@NotNull String codRuolo, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return securityHelper.getInfoOperatoreForRuolo(codRuolo, securityContext, httpHeaders, httpRequest);
	}

	/*
	 * Indicazione Operatore per ruolo Servizio Assistenza Se l’utente ha
	 * selezionato il ruolo “Servizio Assistenza SERSE”, l’applicativo aggiorna la
	 * pagina visualizzando i campi relativo al Gruppo Operatore e Codice Operatore,
	 * come indicato nell’interfaccia al §2.1.2
	 * 
	 * L’utente deve popolare i 2 campi: Gruppo: accettare solo 1 carattere (solo
	 * lettere, niente numeri né simboli) Codice: accettare solo caratteri numerici
	 * per un massimo di 6
	 * 
	 * Alla conferma, tramite apposito pulsante, il sistema effettua il controllo
	 * sui campi inseriti, come indicato sopra. Se quanto inserito non rispetta i
	 * requisiti, visualizzare un messaggio bloccante d’errore: Attenzione: i valori
	 * inseriti non sono corretti
	 * 
	 * e indicare con una “X” la riga dei campi Gruppo e Codice contenente l’errore.
	 * 
	 * Se il controllo va a buon fine, il sistema deve invocare il servizio
	 * FLAIANAG.AnagrafePG.getDettaglioOperatore passando come parametri: in0: ‘FP’
	 * in1: codiceGruppoOperatore: quanto inserito nel campo Gruppo codiceOperatore:
	 * quanto inserito nel campo Codice
	 * 
	 * Se il servizio non restituisce alcun risultato, il sistema visualizza un
	 * messaggio:
	 * 
	 * Nessun Operatore trovato per i parametri indicati
	 * 
	 * Se invece il servizio restituisce un’occorrenza (ad un gruppo e codice
	 * Operatore corrisponderà una ed una sola occorrenza), recuperare dall’output
	 * fornito il tag <denominazionePersonaGiuridica>.
	 */
	@Override
	public Response getPersonaGiuridicaForRuolo(@NotNull String gruppoOperatore, @NotNull BigDecimal codOperatore,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		DettaglioPersonaGiuridica ris = flaiAnagPg.getDettaglioOperatore(gruppoOperatore, codOperatore.intValue());
		if (ris == null)  {
			return Response.ok(null).build();
		}
		PersonaGiuridica pg = flaiAnagMapper.toVo(ris);
		return Response.ok(pg).build();
	}

	@Override
	public Response getElencoSediForOperatore(@NotNull String gruppoOperatore, @NotNull BigDecimal codOperatore,
			String codiceIstatComune, String codiceProvincia, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
	
		return infoOperatoreManager.getElencoSediForOperatore(gruppoOperatore, codOperatore, codiceIstatComune, codiceProvincia);
	}



	@Override
	public Response ricercaOperatore(String gruppoOperatore, String codOperatore, String denominazionePersonaGiuridica,
			String codiceFiscale, String partitaIva, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		return infoOperatoreManager.ricercaOperatore(gruppoOperatore, codOperatore, denominazionePersonaGiuridica, codiceFiscale, partitaIva);
	}

	/*
		CDU 33
	 */

	@Override
	public Response getElencoSediAutorizzati(Long idSoggettoAttuatore, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		List<SedeOperatore> data = infoOperatoreManager.getElencoSediAutorizzati(idSoggettoAttuatore);
		return Response.ok(data).build();
	}

	@Override
	public Response getElencoSediAutorizzatiCodGruppo(Long numProgrSportello, Long codOperatore,
													  String gruppoOperatore, Long modelId,
													  SecurityContext securityContext, HttpHeaders httpHeaders,
													  HttpServletRequest httpRequest)
	{
		List<SedeOperatore> data = infoOperatoreManager.getElencoSediAutorizzatiCodGruppo(numProgrSportello,codOperatore,gruppoOperatore,modelId);
		return Response.ok(data).build();
	}

}
