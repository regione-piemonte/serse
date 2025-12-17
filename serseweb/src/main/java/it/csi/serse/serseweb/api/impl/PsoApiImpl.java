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

import it.csi.serse.serseweb.api.PsoApi;
import it.csi.serse.serseweb.api.manager.PsoManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;

@Component
public class PsoApiImpl extends ParentOverWebApi implements PsoApi {
	@Autowired
	PsoManager psoManager;
	
	/*
	 * Servizio che Ricerca Tipologie PSO di competenza
	 */
	
	@Override
	public Response getPsoForTipologia(@NotNull String tipologiaPsoId, @NotNull Integer idAttoIndirizzo,
			@NotNull Integer codOperatore, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		return psoManager.getPsoForTipologia(tipologiaPsoId, idAttoIndirizzo, codOperatore);
	}



	
	
	

}
