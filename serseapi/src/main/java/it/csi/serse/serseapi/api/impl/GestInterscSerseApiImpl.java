package it.csi.serse.serseapi.api.impl;

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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import it.csi.serse.serseapi.api.GestInterscSerseApi;
import it.csi.serse.serseapi.api.manager.GestInterscSerseManager;
import it.csi.serse.serseapi.api.manager.TestResourcesSerseManager;
import it.csi.serse.serseapi.api.parent.ParentOverWebApi;
import it.csi.serse.serseapi.helper.ErrorHelper;
import it.csi.serse.serseapi.vo.AcquisisciElaborazioneGAMInput;

@Component
public class GestInterscSerseApiImpl extends ParentOverWebApi implements GestInterscSerseApi {
    @Autowired
    private GestInterscSerseManager gestInterscSerseManager;
    @Autowired
    private TestResourcesSerseManager testResourcesSerseManager;

    @Override
    public Response acquisisciElaborazioneGAM(AcquisisciElaborazioneGAMInput body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return gestInterscSerseManager.acquisisciElaborazioneGAM(body);
    }

    @Override
    public Response test(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        if (testResourcesSerseManager.testResources())
        	return Response.ok().build();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorHelper.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Errore")).build();
    }

    @Override
    public Response esposizioneAnagraficaDestinatario(String cfDestinatario, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return gestInterscSerseManager.esposizioneAnagraficaDestinatario(cfDestinatario);
    }

    @Override
    public Response esposizioneServiziDestinatario(@NotNull String cfDestinatario, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return gestInterscSerseManager.esposizioneServiziDestinatario(cfDestinatario);
    }
}
