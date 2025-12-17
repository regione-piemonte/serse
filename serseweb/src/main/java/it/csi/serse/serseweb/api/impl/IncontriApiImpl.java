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

import it.csi.serse.serseweb.vo.Incontro;
import it.csi.serse.serseweb.vo.IncontroDestinatarioServizio;
import it.csi.serse.serseweb.vo.LuogoIncontro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.IncontriApi;
import it.csi.serse.serseweb.api.manager.IncontriManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;

import java.util.List;

@Component
public class IncontriApiImpl extends ParentOverWebApi implements IncontriApi{
	@Autowired
	IncontriManager manager;

	@Override
	public Response getSommaDurateOre(@NotNull Long idServizio, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return manager.getSommaDurateOre(idServizio);
	}

	/*
		FPL-SERSE-SER-CDU-029-V01-Gestione Incontri Servizio

	 */

	@Override
	public Response deleteIncontro(Long idIncontro, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.deleteIncontro(idIncontro);
	}

	//Incontri associati al Servizio
	@Override
	public Response getIncontriForIdServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getIncontriForIdServizio(idServizio);
	}


	/*
	FPL-SERSE-SER-CDU-030-V01-Inserimento e aggiornamento Incontro
	 */

	@Override
	public Response getIncontroForId(Long idIncontro, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getIncontroForId(idIncontro);
	}

	@Override
	public Response insertIncontro(Incontro body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.insertIncontro(body);
	}

	@Override
	public Response updateIncontro(Incontro body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.updateIncontro(body);
	}


	/*
	 * FPL-SERSE-TRA-CDU-030-V01-Inserimento e aggiornamento Incontro
	 */

	@Override
	public Response testChiudereIncontro(Long idIncontro,Long idSportello, Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.testChiudereIncontro(idIncontro,idSportello,idServizio);
	}

	/*
		FPL-SERSE-SER-CDU-034-V01-Elenco Destinatari associati Incontro
	 */

	@Override
	public Response deleteIncontroDestinatarioServizio(Long idIncontro, Long idDestinatarioServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.deleteIncontroDestinatarioServizio(idIncontro, idDestinatarioServizio);
	}

	@Override
	public Response getDestinatarioForIdIncontro(Long idIncontro, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getDestinatarioForIdIncontro(idIncontro);
	}

	@Override
	public Response getDestinatarioForIdIServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getDestinatarioForIdIServizio(idServizio);
	}

	@Override
	public Response associaDestinatariIncontro(List<IncontroDestinatarioServizio> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.associaDestinatariIncontro(body);
	}

	@Override
	public Response modificaDestinatariIncontro(IncontroDestinatarioServizio body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return manager.modificaDestinatariIncontro(body);
	}

	/*
		FPL-SERSE-SER-CDU-033-V01-Gestione Luogo Incontro
	 */

	@Override
	public Response getBaciniForCodProvincia(String codProvincia, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getBaciniForCodProvincia(codProvincia);
	}

	@Override
	public Response getComune(String codComune, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getComune(codComune);
	}

	@Override
	public Response geComuneForBacino(Long codBacino, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.geComuneForBacino(codBacino);
	}

	@Override
	public Response deleteLuogoIncontro(Long idIncontro, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.deleteLuogoIncontro(idIncontro);
	}

	@Override
	public Response updateLuogoIncontro(LuogoIncontro body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.updateLuogoIncontro(body);
	}

	@Override
	public Response insertLuogoIncontro(LuogoIncontro body, Long idIncontro, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.insertLuogoIncontro(body, idIncontro);
	}

	@Override
	public Response getLuogoIncontroForId(Long idLuogoIncontro, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getLuogoIncontroForId(idLuogoIncontro);
	}


}
