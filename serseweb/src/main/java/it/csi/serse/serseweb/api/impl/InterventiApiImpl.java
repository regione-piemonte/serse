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

import it.csi.serse.serseweb.vo.InterventoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import it.csi.serse.serseweb.api.InterventiApi;
import it.csi.serse.serseweb.api.manager.InterventiManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.vo.CambioStatoIntervento;
import it.csi.serse.serseweb.vo.FilterInterventi;
import it.csi.serse.serseweb.vo.Intervento;

import java.util.List;

@Component
public class InterventiApiImpl extends ParentOverWebApi implements InterventiApi{
	@Autowired
	private InterventiManager interventiManager;
	
	
	/**
	 * 
	 */
	@Override
	public Response getTipologieInterventoForPso(@NotNull Long idPso, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
	
		return interventiManager.getTipologieInterventoForPso(idPso);
	}
	/**
	 * 
	 */
	@Override
	public Response deleteInterventoById(@NotNull Long idIntervento, 
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return interventiManager.deleteInterventoById(idIntervento);
	}

	/**
	 * 
	 */
	@Override
	public Response verificaCampiIntervento(@NotNull Long idIntervento,@NotNull Long numProgrSportello, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return interventiManager.verificaCampiIntervento(idIntervento,numProgrSportello);
	}
	/**
	 * 
	 */
	@Override
	public Response insertIntervento(Intervento body, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		return interventiManager.insertIntervento(body);
	}

	@Override
	public Response testChiusuraIntervento(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return interventiManager.testChiusuraIntervento(idIntervento);
	}

	@Override
	public Response updateIntervento(Intervento body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return interventiManager.updateIntervento(body);
	}

	@Override
	public Response getInterventi(FilterInterventi filter, Integer offset, Integer limit, String sort,
	SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return interventiManager.getInterventi(filter, offset, limit, sort);
	}

	@Override
	public Response getInterventoById(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return interventiManager.selectIntervento(idIntervento);
	}

	@Override
	public Response getServiziAssociatiIntervento(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return interventiManager.getServiziAssociatiIntervento(idIntervento);
	}

	@Override
	public Response getStatiIntervento(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return interventiManager.getStatiIntervento();
	}
	
	/*
	 * FPL-SERSE-INT-CDU-024-V01-Inserimento e aggiornamento Servizio (con spesa)
	 */
	
	@Override
	public Response updateStatoIntervento(CambioStatoIntervento body,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return interventiManager.updateStatoIntervento(body);
	}

	/*
		FLP-SERSE-INT-CDU 012-V03 Duplica_Intervento
	 */

	@Override
	public Response duplicaIntervento(Long idIntervento, String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return interventiManager.duplicaIntervento(idIntervento, codUserAggiornamento);
	}

}
