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

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import it.csi.serse.serseweb.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.ServiziApi;
import it.csi.serse.serseweb.api.manager.ServiziManager;
import it.csi.serse.serseweb.api.manager.ServizioGamManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;

@Component
public class ServiziApiImpl extends ParentOverWebApi implements ServiziApi {
	@Autowired
	ServiziManager serviziManager;
	@Autowired
	ServizioGamManager serviziGamManager;


	@Override
	public Response getTipologieServiziForModelloIntervento(@NotNull Long idModellointervento,
															SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.getTipologieServiziForModelloIntervento(idModellointervento);
	}

	@Override
	public Response getTipologieServiziForIntervento(@NotNull Long idIntervento, SecurityContext securityContext,
													 HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.getTipologieServiziForIntervento(idIntervento);
	}

	/************************************************************************************
	 * Gestione Servizi Esterni
	 * ***********************************************************************************/
	@Override
	public Response getServiziEsternoForIdModelloIntervento(@NotNull Long idModelloIntervento,
															SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.getServiziEsternoForIdModelloIntervento(idModelloIntervento);
	}

	@Override
	public Response deleteServizioEsterno(@NotNull Long idModelloIntervento, @NotNull String codUserAggiornamento,
										  @NotNull Long idServizioModello, SecurityContext securityContext, HttpHeaders httpHeaders,
										  HttpServletRequest httpRequest) {

		return serviziManager.deleteServizioEsterno(idModelloIntervento, codUserAggiornamento, idServizioModello);
	}

	@Override
	public Response getServizioEsternoById(@NotNull Long idModelloIntervento, @NotNull Long idServizioModello,
										   SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.getServizioEsternoById(idServizioModello);
	}

	@Override
	public Response getStatiServizi(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getStatiServizio();
	}

	@Override
	public Response insertServizioModelloEsterno(@NotNull Long idModelloIntervento,
												 @NotNull String codUserAggiornamento, ServizioModello body, SecurityContext securityContext,
												 HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.insertServizioEsterno(body, idModelloIntervento, codUserAggiornamento);
	}

	@Override
	public Response updateServizioModelloEsterno(@NotNull Long idModelloIntervento,
												 @NotNull String codUserAggiornamento, ServizioModello body, SecurityContext securityContext,
												 HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.updateServizioEsterno(body, idModelloIntervento, codUserAggiornamento);
	}


	/************************************************************************************
	 * Gestione Servizi Regionali
	 * ***********************************************************************************/


	@Override
	public Response deleteServiziModelloRegionale(List<ServizioModello> body, @NotNull Long idModelloIntervento,
												  @NotNull String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders,
												  HttpServletRequest httpRequest) {

		return serviziManager.deleteServiziModelloRegionale(body, idModelloIntervento, codUserAggiornamento);
	}

	@Override
	public Response getServiziRegionaliForPso(@NotNull Long idPso, @NotNull Long idModelloIntervento,
											  SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.getServiziRegionaliForPso(idPso, idModelloIntervento);
	}

	@Override
	public Response getServizioById(@NotNull Long idServizio,SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getServizioById(idServizio);
	}

	@Override
	public Response insertServiziModelloRegionale(List<ServizioModello> body, @NotNull Long idModelloIntervento,
												  @NotNull String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders,
												  HttpServletRequest httpRequest) {

		return serviziManager.insertServiziModelloRegionale(body, idModelloIntervento, codUserAggiornamento);
	}

	@Override
	public Response updateServiziModelloRegionale(List<ServizioModello> body, @NotNull Long idModelloIntervento,
												  @NotNull String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders,
												  HttpServletRequest httpRequest) {

		return serviziManager.updateServiziModelloRegionale(body, idModelloIntervento, codUserAggiornamento);
	}


	/*
	 * FPL-SERSE-INT-CDU-022-V01-Gestione Servizi associati ad Intervento
	 */
	@Override
	public Response deleteServizioForId(@NotNull Long idServizio, SecurityContext securityContext,
										HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.deleteServizioForId(idServizio);
	}

	@Override
	public Response getServiziForIdIntervento(@NotNull Long idIntervento, SecurityContext securityContext,
											  HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getServiziForIdIntervento(idIntervento);
	}




	/*
	 * FPL-SERSE-INT-CDU-024-V01-Inserimento e aggiornamento Servizio (con spesa)
	 */
	@Override
	public Response getTipologieServiziForServizioPso(@NotNull Long idPso, Long idIntervento,
													  SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziManager.getTipologieServiziForServizioPso(idIntervento, idPso);
	}

	@Override
	public Response updateServizio(Servizio body,  SecurityContext securityContext,
								   HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.updateServizio(body);
	}

	@Override
	public Response insertServizio(Servizio body, Boolean isIndividuale,
								   SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.insertServizio(body);
	}

	@Override
	public Response insertTokenGam(ServizioGamPropostaModifica body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return serviziGamManager.insertTokenGam(body);
	}

	@Override
	public Response testChiudereServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.testChiudereServizio(idServizio);
	}

	@Override
	public Response verificaPeriodoAttivazioneServizio(Long numProgrSportello, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.verificaPeriodoAttivazioneServizio(numProgrSportello);
	}


	@Override
	public Response chiudiServizio(ServizioGamChiudiServizio body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziGamManager.chiudiServizio(body);
	}


	/*
	 * FPL-SERSE-SER-CDU-028-V01-Gestione Spesa Servizio
	 */

	@Override
	public Response getServiziFonti(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getServiziFonti(idServizio);
	}

	@Override
	public Response getServiziVoceSpesa(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getServiziVoceSpesa(idServizio);
	}

	/**
	 * @param idServizio
	 * @param securityContext
	 * @param httpHeaders
	 * @param httpRequest
	 * @return
	 */
	@Override
	public Response getServiziSto(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getServiziSto(idServizio);
	}

	// FPL-SERSE-SER-CDU-026-V01-Gestione Destinatari Servizio

	/**
	 * @param idServizio
	 * @param securityContext
	 * @param httpHeaders
	 * @param httpRequest
	 * @return
	 */
	@Override
	public Response getTestInterventoServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getTestInterventoServizio(idServizio);
	}

	//CDU 17 e 18

	@Override
	public Response verificaServizioAssociatoModelloDiIntervento(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.verificaServizioAssociatoModelloDiIntervento(idServizio);
	}

	//1.1.0 ID 270 dati peculiari da servizio
	@Override
	public Response servizioDatiPeculiari(Servizio body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.servizioDatiPeculiari(body);
	}

	@Override
	public Response getControlloDatiPeculiari(Long numProgrSportello, Long idPso, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getControlloDatiPeculiari(numProgrSportello, idPso);
	}
	/************************************************************************************
	 * Gestione Servizi per Servizi non associati(cdu 23)
	 * ***********************************************************************************/
	@Override
	public Response getServizi(FilterServizi filter, Integer offset, Integer limit, String sort,
	SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest)
	{
		return serviziManager.getServizi(filter, offset, limit, sort);
	}

	@Override
	public Response getLabelCampoAggiuntivo(Long idPso, Long numProgrSportello,SecurityContext securityContext, HttpHeaders httpHeaders,
											HttpServletRequest httpRequest){
		return serviziManager.getLabelCampoAggiuntivo(idPso,numProgrSportello);
	}

	@Override
	public Response getFlgCampoAggiuntivoByIdServizioRegionale(Long idServizioRegionale,SecurityContext securityContext, HttpHeaders httpHeaders,HttpServletRequest httpRequest){
		return serviziManager.getFlgCampoAggiuntivoByIdServizioRegionale(idServizioRegionale);
	}

	@Override
	public Response getServiziDestinatari(Long idDestinatario, Long numProgrSportello, String gruppoOperatore, Integer codOperatore, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest){
		return serviziManager.getServiziDestinatari(idDestinatario,numProgrSportello,gruppoOperatore,codOperatore);
	}

	@Override
	public Response getClasseServizioByIdServzioAndIdPso(@NotNull Long idServizio, @NotNull Long idPso,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return serviziManager.getClasseServizioByIdServzioAndIdPso(idServizio, idPso);
	}

}
