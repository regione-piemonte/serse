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

import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.StatoEstero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.DatiComuniApi;
import it.csi.serse.serseweb.api.manager.DatiComuniManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;

import java.util.List;

@Component
public class DatiComuniApiImpl extends ParentOverWebApi implements DatiComuniApi {
	
	@Autowired
	DatiComuniManager manager;

	@Override
	public Response getComuniPerProvincia(@NotNull String prov, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return manager.getComuniPerProvincia(prov);
	}

	@Override
	public Response getInfoComuni(List<Comune> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getInfoComuni(body);
	}

	@Override
	public Response getInfoStatiEsteri(List<StatoEstero> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return manager.getInfoStatiEsteri(body);
	}

	@Override
	public Response getProvinciePerRegione(@NotNull String regione, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		return manager.getProvinciePerRegione(regione);
	}

	@Override
	public Response getCittadinanze(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		return manager.getCittadinanze();
	}

	@Override
	public Response getStatiEsteri(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		return manager.getStatiEsteri();
	}



	

}
