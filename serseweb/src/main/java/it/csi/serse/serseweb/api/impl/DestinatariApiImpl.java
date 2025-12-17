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

import it.csi.serse.serseweb.vo.DatiPeculiari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.DestinatariApi;
import it.csi.serse.serseweb.api.manager.DestinatariManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.DestinatariservizioRinumeraBody;
import it.csi.serse.serseweb.vo.TargetDestinatariAssociati;
import it.csi.serse.serseweb.vo.TargetDestinatariServizio;

@Component
public class DestinatariApiImpl extends ParentOverWebApi implements DestinatariApi {
	@Autowired
	DestinatariManager manager;


	/*
	 * 
	 * Gestione Target Destinatari
	 * 
	 * */
	@Override
	public Response getTargetDestinatariForPso(@NotNull Long idPso, SecurityContext securityContext,
											   HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getElencoTargetDestinatariForPSO(idPso);
	}

	@Override
	public Response deleteTargetDestinatarioForModello(List<TargetDestinatariAssociati> body,
													   SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.deleteTargetDestinatarioForModello(body);
	}

	@Override
	public Response getElencoTargetDestinatariForModello(@NotNull Long idPso, @NotNull Long idModelloIntervento,
														 SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getElencoTargetDestinatariForModello(idPso, idModelloIntervento);
	}

	@Override
	public Response getIncontriForDestinatario(Long idDestinatario, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getIncontriForDestinatario(idDestinatario);
	}

	@Override
	public Response insertTargetDestinatarioForModello(List<TargetDestinatariAssociati> body,
													   SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.insertTargetDestinatarioForModello(body);
	}

	/*
	 * 
	 * Gestione Destinatari
	 * 
	 * */
	@Override
	public Response getDestinatarioForId(@NotNull Long idDestinatario, SecurityContext securityContext,
										 HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return manager.getDestinatarioForId(idDestinatario);
	}


	/*
	 * FPL-SERSE-TRA-CDU-016-V02
	 *  Gestione Anagrafe Destinatari	
	 */
	@Override
	public Response getDestinatariDaRicerca(String nome, String cognome, String codiceFiscaleDestinatario,
											String dataDiNascita, SecurityContext securityContext, HttpHeaders httpHeaders,
											HttpServletRequest httpRequest) {

		return manager.getDestinatariDaRicerca(nome, cognome, codiceFiscaleDestinatario, dataDiNascita);
	}

	@Override
	public Response testCodiceFiscale(String codiceFiscaleDestinatario, SecurityContext securityContext,
									  HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return manager.testCodiceFiscale(codiceFiscaleDestinatario);
	}

	@Override
	public Response testMaxDestinatariAssociabili(@NotNull Long idServizio, SecurityContext securityContext,
												  HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return manager.testMaxDestinatariAssociabili(idServizio);
	}

	@Override
	public Response insertDestinatarioIntervento(Destinatario body, @NotNull Long idIntervento,
												 @NotNull String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders,
												 HttpServletRequest httpRequest) {

		return manager.insertDestinatarioIntervento(body, idIntervento, codUserAggiornamento);
	}

	@Override
	public Response updateDestinatario(Destinatario body, SecurityContext securityContext, HttpHeaders httpHeaders,
									   HttpServletRequest httpRequest) {

		return manager.updateDestinatario(body);
	}


	@Override
	public Response associaDestinatarioIntervento(@NotNull Long idIntervento, @NotNull String codUserAggiornamento,
												  @NotNull Long idDestinatario, SecurityContext securityContext, HttpHeaders httpHeaders,
												  HttpServletRequest httpRequest) {
		return manager.associaDestinatarioIntervento(idIntervento, codUserAggiornamento, idDestinatario);
	}

	@Override
	public Response insertDestinatarioServizio(Destinatario body, @NotNull Long idServizio,
											   @NotNull String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders,
											   HttpServletRequest httpRequest) {

		return manager.insertDestinatarioServizio(body, idServizio, codUserAggiornamento);
	}

	@Override
	public Response associaDestinatarioServizio(Long idServizio, String codUserAggiornamento, List<Destinatario> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return manager.associaDestinatarioServizio(idServizio, codUserAggiornamento, body);
	}

	@Override
	public Response caricaDestinatariServizio(Long idServizio, String codUserAggiornamento, List<Destinatario> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.caricaDestinatariServizio(idServizio, codUserAggiornamento, body);
	}

	// CDU 17
	@Override
	public Response getTargetDestinatariForServizio(@NotNull Long idPso, @NotNull Long idServizio,
													@NotNull Boolean isModificabile, SecurityContext securityContext, HttpHeaders httpHeaders,
													HttpServletRequest httpRequest) {
		return manager.getElencoTargetDestinatariForPSOServizio(idPso, idServizio, isModificabile);
	}

	@Override
	public Response deleteTargetDestinatarioServizio(List<TargetDestinatariServizio> body,
													 SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return manager.deleteTargetDestinatarioServizio(body);
	}


	@Override
	public Response insertTargetDestinatarioServizio(List<TargetDestinatariServizio> body,
													 SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return manager.insertTargetDestinatarioServizio(body);
	}

	@Override
	public Response getTargetDestinatariForIdServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getTargetDestinatariForIdServizio(idServizio);
	}

	@Override
	public Response getDestinatarioForIdServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getDestinatarioForIdServizio(idServizio);
	}

    /*
		FPL-SERSE-SER-CDU-026-V01-Gestione Destinatari Servizio
	 */

	@Override
	public Response getDestinatarioServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getDestinatarioServizio(idServizio);
	}

	@Override
	public Response getDestinatariServiziServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest){
		return manager.getDestinatariServiziServizio(idServizio);
	}


	@Override
	public Response disassociaDestinatarioServizio(Long idServizio, Long idDestinatario, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.disassociaDestinatarioServizio(idServizio, idDestinatario);
	}


	@Override
	public Response salvaDatiPeculiari(DatiPeculiari body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.salvaDatiPeculiari(body);
	}

	/**
	 */
	@Override
	public Response getDestinatarioServizioDatiPeculiari(Long idDestinatario, Long idServizio, Long numProgrSportello, Long idPso, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getDestinatarioServizioDatiPeculiari(idDestinatario, idServizio, numProgrSportello, idPso);
	}

	/**
	 */
	@Override
	public Response getCondizioneOccupazionaleIgrue(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getCondizioneOccupazionaleIgrue();
	}


	/**
	 */
	@Override
	public Response getTitoliStudioIgrue(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getTitoliStudioIgrue();
	}

    /*
    FPL-SERSE-SER-CDU-039-V01-Verifica Servizi per Destinatario (ricerca, elenco, dettaglio)
     */

    @Override
    public Response getServiziForIdDestinatario(Long idDestinatario, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.getServiziForIdDestinatario(idDestinatario);
    }

	/*
		FPL-SERSE-INT-CDU-035-V02-Dati correlati: elenco target destinatari presenti nei servizi associati all'i
	 */

	@Override
	public Response getTargetDestinatariForIdIntervento(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getTargetDestinatariForIdIntervento(idIntervento);
	}

	/*
		FPL-SERSE-INT-CDU-037-V04-elenco destinatari presenti nei servizi associati all'intervento
	 */

	@Override
	public Response getDestinatariIntervento(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getDestinatariIntervento(idIntervento);
	}

	@Override
	public Response getServiziForIdDestinatarioIdIntervento(Long idDestinatario, Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getServiziForIdDestinatarioIdIntervento(idDestinatario, idIntervento);
	}

	@Override
	public Response getDestinatarioServizioDatiPeculiariMancanti(Long idServizio, Long numProgrSportello, Long idPso, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getDestinatarioServizioDatiPeculiariMancanti(idServizio,numProgrSportello,idPso);
	}

	@Override
	public Response rinumeraDestinatariServizio(DestinatariservizioRinumeraBody body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.rinumeraDestinatariServizio(body);
	}

	@Override
	public Response getClassiDestinatario(@NotNull Long idPso, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return manager.getClassiDestinatario(idPso);
	}

}
