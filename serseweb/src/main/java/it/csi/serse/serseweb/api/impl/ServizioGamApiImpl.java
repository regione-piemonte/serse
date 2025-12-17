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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import it.csi.serse.serseweb.vo.ServizioGamIncontro;
import it.csi.serse.serseweb.vo.ServizioGamRiapriServizio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.ServizioGamApi;
import it.csi.serse.serseweb.api.manager.ServizioGamManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.vo.ServizioGam;

@Component
public class ServizioGamApiImpl extends ParentOverWebApi implements ServizioGamApi {
	@Autowired
	ServizioGamManager manager;
	
	
	/*
	 * FPL-SERSE-SER-CDU-028-V01-Gestione Spesa Servizio
	 */  
	
	
	@Override
	public Response calcPreventivoSerse(ServizioGam body, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return manager.calcPreventivoSerse(body);
	}


	@Override
	public Response getTokenGamForIdServizio(Long idServizio, String codTipoRichiestaGam, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getTokenGamForIdServizio(idServizio, codTipoRichiestaGam);
	}

	@Override
	public Response nuovoServizioSerse(ServizioGam body, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return manager.nuovoServizioSerse(body);
	}

	/*
	 * FPL-SERSE-TRA-CDU-031-V01-Verifica Budget
	 */

	@Override
	public Response getBudgetForSoggetto(Long numProgrSportello, Long codOperatore, Long idPso, String gruppoOperatore, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getBudgetForSoggetto(numProgrSportello, codOperatore, idPso, gruppoOperatore);
	}

	/*
	 * FPL-SERSE-TRA-CDU-030-V01-Inserimento e aggiornamento Incontro
	 */

	@Override
	public Response nuovoIncontroSerse(ServizioGamIncontro body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.nuovoIncontroSerse(body);
	}

	@Override
	public Response getTokenGamForIdIncontro(Long idIncontro, String codTipoRichiestaGam, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getTokenGamForIdIncontro(idIncontro, codTipoRichiestaGam);
	}

	@Override
	public Response riapriIncontroSerse(ServizioGamIncontro body, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.riapriIncontroSerse(body);
	}

	@Override
	public Response riportaServizioInDefinizione( ServizioGamRiapriServizio body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest ) {
		return manager.riportaServizioInDefinizione(body);
	}
}
