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

import it.csi.serse.serseweb.api.SoggettoAttuatoreApi;
import it.csi.serse.serseweb.api.manager.SoggettoAttuatoreManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;

@Component
public class SoggettoAttuatoreApiImpl extends ParentOverWebApi implements SoggettoAttuatoreApi {
	@Autowired
	SoggettoAttuatoreManager soManager;
	
	@Override
	public Response getIstanzeCandidatura(@NotNull Long numProgrSportello, @NotNull Long  codOperatore,
			@NotNull String  gruppoOperatore, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		return soManager.getIstanzeCandidatura(numProgrSportello, codOperatore, gruppoOperatore);
	}

	@Override
	public Response getSoggettiBeneficiari(@NotNull Integer numProgrSportello, @NotNull Integer codOperatore,
			@NotNull String gruppoOperatore, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return soManager.getSoggettiBeneficiari(numProgrSportello, codOperatore,gruppoOperatore );
	}



	@Override
	public Response getSoggettoAttuatoreForId(@NotNull Integer idSoggettoAttuatore, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return soManager.getSoggettoAttuatore(idSoggettoAttuatore);
	}



	@Override
	public Response getSoggettoBeneficiario(@NotNull Long idSoggettoAttuatore, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return soManager.getSoggettoBeneficiario(idSoggettoAttuatore);
	}

	@Override
	public Response getSoggettoBeneficiarioAssociatoModello(@NotNull Long idModelloIntervento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return soManager.getSoggettoBeneficiarioAssociatoModello(idModelloIntervento);
	}

	@Override
	public Response getIstanzeCandidaturaForIntervento(@NotNull Long idIntervento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return soManager.getIstanzeCandidaturaForIntervento(idIntervento);
	}

	@Override
	public Response getSoggettoBeneficiarioAssociatoIntervento(@NotNull Long idIntervento,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return soManager.getSoggettoBeneficiarioAssociatoIntervento(idIntervento);
	}

	/*
	 * FPL-SERSE-INT-CDU-024-V01-Inserimento e aggiornamento Servizio (con spesa)
	 */
	@Override
	public Response getAreeTerritorialiDiFinanziamento(@NotNull String gruppoOperatore, @NotNull Long codOperatore,
			@NotNull Integer modelId, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return soManager.getAreeTerritorialiDiFinanziamento(gruppoOperatore, codOperatore, modelId);
	}
	/*
		Evolutiva richiesta 20/10/2023  inserimento dell'area territoriale in ricerca e in inserimento
		fare in modo che nelle ricerche compaia anche il menù della scelta dell’area territoriale affinché
		sia possibile sceglierla e nel caso venga scelta questa influenzi (filtri) rispetto ai due menù
		istanza di candidatura
	 */
	@Override
	public Response getAreeTerritorialiDiFinanziamentoV2(String gruppoOperatore, Long codOperatore, Long numProgrSportello, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return soManager.getAreeTerritorialiDiFinanziamentoV2(gruppoOperatore, codOperatore, numProgrSportello);
	}
	@Override
	public Response getIstanzeCandidaturaPerCodAreaTerritoriale(String codAreaTerritoriale, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return soManager.getIstanzeCandidaturaPerCodAreaTerritoriale(codAreaTerritoriale);
	}

	@Override
	public Response getSoggettiAttuatori(Long numProgrSportello, Long codOperatore, String gruppoOperatore,Long modelId,
										 SecurityContext securityContext, HttpHeaders httpHeaders,
										 HttpServletRequest httpRequest)
	{
		return soManager.getSoggettiAttuatori(numProgrSportello,codOperatore,gruppoOperatore,modelId);
	}
}
