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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.EntiCoinvoltiApi;
import it.csi.serse.serseweb.api.manager.EntiCoinvoltiManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;


@Component
public class EntiCoinvoltiApiImpl extends ParentOverWebApi implements EntiCoinvoltiApi{
	@Autowired
	EntiCoinvoltiManager entiCoinvoltiManager;
	
	/************************************************************************************
	 * Gestione Enti Coinvolti Modello
	 * ***********************************************************************************/
	
	@Override
	public Response getEntiCoinvoltiForModelloIntervento(@NotNull Long idModelloIntervento,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return entiCoinvoltiManager.getEntiCoinvoltiForModelloIntervento( idModelloIntervento);
	}

	@Override
	public Response getFonteDatoPerPso(@NotNull Long idPso, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.getFonteDatoPerPso(idPso);
	}

	@Override
	public Response getRuoliEnte(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.getRuoliEnte();
	}

	@Override
	public Response getEnteCoinvoltoModelloForId(@NotNull Long idEnteCoinvoltoModello, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return entiCoinvoltiManager.getEnteCoinvoltoModelloForId(idEnteCoinvoltoModello);
	}

	@Override
	public Response deleteEnteCoinvoltoModelloById(@NotNull Long idEnteCoinvolto, @NotNull Long idModelloIntervento,
			 @NotNull String codUserAggiornamento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return entiCoinvoltiManager.deleteEnteCoinvoltoModelloById(idEnteCoinvolto,idModelloIntervento, codUserAggiornamento);
	}

	@Override
	public Response updateEnteCoinvoltoModello(EnteCoinvoltoModello body, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return entiCoinvoltiManager.updateEnteCoinvoltoModello(body);
	}

	@Override
	public Response insertEnteCoinvoltoModello(EnteCoinvoltoModello body, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return entiCoinvoltiManager.insertEnteCoinvoltoModello(body);
	}

	/************************************************************************************
	 * Gestione Enti Coinvolti Servizio
	 * ***********************************************************************************/
	
	@Override
	public Response insertEnteCoinvoltoServizio(EnteCoinvoltoServizio body, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.insertEnteCoinvoltoServizio(body);
	}

	@Override
	public Response getEnteCoinvoltoServizioForId(Long idEnteCoinvoltoServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.getEnteCoinvoltoServizioForId(idEnteCoinvoltoServizio);
	}

	@Override
	public Response getEntiCoinvoltiForIdServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.getEntiCoinvoltiForIdServizio(idServizio);
	}

	@Override
	public Response deleteEntiCoinvoltiServizio(String codUserAggiornamento, Long idEnteCoinvoltoServizio, Long idEnteCoinvoltoIntervento, Long idEnteCoinvoltoModello, Long idServizio, Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.deleteEntiCoinvoltiServizio(codUserAggiornamento, idEnteCoinvoltoServizio, idEnteCoinvoltoIntervento, idEnteCoinvoltoModello, idServizio, idIntervento);
	}

	@Override
	public Response updatetEnteCoinvoltoServizio(EnteCoinvoltoServizio body, String codUserAggiorn, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.updateEnteCoinvoltoServizio(body, codUserAggiorn);
	}
	/************************************************************************************
	 * Gestione Enti Coinvolti Intervento
	 * FPL-SERSE-INT-CDU-019-V01-Gestione Enti Coinvolti Intervento
	 * ***********************************************************************************/
	@Override
	public Response insertEnteCoinvoltoIntervento(EnteCoinvoltoIntervento body, SecurityContext securityContext,
												  HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return entiCoinvoltiManager.insertEnteCoinvoltoIntervento(body);
	}

	@Override
	public Response verificaPerAggiungiEntiCoinvoltiIntervento(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.verificaPerAggiungiEntiCoinvoltiIntervento(idIntervento);
	}

	@Override
	public Response deleteEntiCoinvoltiIntervento(Long idEnteCoinvoltoIntervento, String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.deleteEntiCoinvoltiIntervento(idEnteCoinvoltoIntervento, codUserAggiornamento);
	}

	@Override
	public Response getEntiCoinvoltiForIdIntervento(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.getEntiCoinvoltiForIntervento(idIntervento);
	}

	@Override
	public Response updatetEnteCoinvoltoIntervento(EnteCoinvoltoIntervento body, String codUserAggiorn, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.updateEnteCoinvoltoIntervento(body, codUserAggiorn);
	}

	@Override
	public Response getEnteCoinvoltoInterventoForId(@NotNull Long idEnteCoinvoltoIntervento,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.getEnteCoinvoltoInterventoForId(idEnteCoinvoltoIntervento);
	}

	/*
		FPL-SERSE-SER-CDU-026-V01-Gestione Destinatari Servizio

		Algoritmo Lista Enti Destinatario
	 */
	@Override
	public Response getEntiDestinatariForIdServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.getEntiDestinatariForIdServizio(idServizio);
	}

	// 1.1.0 priorita 1 ID 260 cessare un ente coinvolto modello
	@Override
	public Response cessareEnteCoinvoltoModello(EnteCoinvoltoModello body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return entiCoinvoltiManager.cessareEnteCoinvoltoModello(body);
	}

	@Override
	public Response deleteEntiCoinvoltiInterventoModello(@NotNull Long idEnteCoinvoltoModello, @NotNull Long idIntervento,
			@NotNull String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
			return entiCoinvoltiManager.deleteEntiCoinvoltiInterventoModello(idEnteCoinvoltoModello, idIntervento, codUserAggiornamento);
	}
}
