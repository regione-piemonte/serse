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

import it.csi.serse.serseweb.api.ModelliDiInterventoApi;
import it.csi.serse.serseweb.api.manager.InterventiManager;
import it.csi.serse.serseweb.api.manager.ModelliDiInterventoManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.vo.AssociareModelloIntervento;
import it.csi.serse.serseweb.vo.FilterModelli;
import it.csi.serse.serseweb.vo.ModelloIntervento;

@Component
public class ModelliDiInterventoApiImpl extends ParentOverWebApi implements ModelliDiInterventoApi{
	
	@Autowired
    ModelliDiInterventoManager manager;

	@Autowired
    InterventiManager interventiManager;
    
    @Override
    public Response getStatiModelliIntervento(SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        return manager.getStatiModelliIntervento();
    }
    
    @Override
    public Response deleteModelloInterventoById(Integer idModelloIntervento, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.deleteModelloInterventoById(idModelloIntervento);
    }

    
    @Override
    public Response insertModelloIntervento(ModelloIntervento body, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        return manager.insertModelloIntervento(body);
    }

    @Override
    public Response updateModelloIntervento(ModelloIntervento body, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        return manager.updateModelloIntervento(body);
    }

    @Override
    public Response verificaCampiModelloIntervento(@NotNull Long idModelloIntervento,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

        return manager.verificaCampiModelloIntervento(idModelloIntervento);
    }

    @Override
    public Response getModelloDiInterventoById(@NotNull Long idModelloIntervento, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        
        return manager.getModelloDiInterventoById(idModelloIntervento);
    }

    @Override
    public Response getModelliIntervento(FilterModelli filter, Integer offset, Integer limit, String sort,
    SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.getModelliIntervento(filter, offset, limit, sort);
    }

    @Override
    public Response associaModelloDiIntervento(AssociareModelloIntervento body, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.associaModelloDiIntervento(body);
    }


    @Override
    public Response disassociaModelloIntervento(Long idIntervento, Long idModelloIntervento,
            SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.disassociaModelloIntervento(idIntervento, idModelloIntervento);
	}

   //FPL-SERSE-MOD-CDURicerca Modello di Intervento

    @Override
    public Response duplicaModelloIntervento(Long idModelloDiIntervento, String codUserAggiornamento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.duplicaModelloIntervento(idModelloDiIntervento, codUserAggiornamento);
    }

    @Override
    public Response getDatiExcelModello(Long idModelloIntervento, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.getDatiExcelModello(idModelloIntervento);
    }

    // 1.1.0 ID 257
    @Override
    public Response cambioReversibilita(ModelloIntervento body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return manager.cambioReversibilita(body);
    }

    @Override
    public Response getInterventiPerModello(Long idModelloIntervento, SecurityContext securityContext,
            HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return interventiManager.getInterventiPerModello(idModelloIntervento);
    }

}
