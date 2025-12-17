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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.CaratteristicheApi;
import it.csi.serse.serseweb.api.manager.CaratteristicheManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.vo.CaratteristicheAssociate;
import it.csi.serse.serseweb.vo.CaratteristicheServizio;

@Component
public class CaratteristicheApiImpl extends ParentOverWebApi implements CaratteristicheApi {
	
	@Autowired
	CaratteristicheManager manager;
	
	@Override
	public Response deleteCaratteristicheForModello(List<CaratteristicheAssociate> body,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.deleteCaratteristicheForModello(body);
	}

	@Override
	public Response getCaratteristicheForModello(@NotNull Long idPso, @NotNull Long idModelloDiIntervento,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getCaratteristicheForModello(idPso, idModelloDiIntervento);
	}

	@Override
	public Response getCaratteristicheForPso(@NotNull Long idPSo, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getCaratteristicheForPso(idPSo);
	}

	@Override
	public Response insertCaratteristicheForModello(List<CaratteristicheAssociate> body,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.insertCaratteristicheForModello(body);
	}

	

	/*
	 * FPL-SERSE-SER-CDU-018-V01- Gestione Caratteristiche Servizio
	 */

	@Override
	public Response getCaratteristicheForServizio(@NotNull Long idPso, @NotNull Long idServizio,
			@NotNull Boolean isModificabile, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		return manager.getCaratteristicheForServizio(idPso, idServizio, isModificabile);
	}

	@Override
	public Response getCaratteristicheServizioForIdServizio(Long idServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getCaratteristicheForIdServizio(idServizio);
	}

	@Override
	public Response deleteCaratteristicheServizio(List<CaratteristicheServizio> body, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return manager.deleteCaratteristicheServizio(body);
	}


	@Override
	public Response insertCaratteristicheServizio(List<CaratteristicheServizio> body, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return manager.insertCaratteristicheServizio(body);
	}

	/*
	CDU <036>: Dati correlati: elenco caratteristiche servizi associati all'intervento

	 */

	@Override
	public Response getCaratteristicheServizioForIdIntervento(Long idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getCaratteristicheForIdIntervento(idIntervento);
	}
	
}
