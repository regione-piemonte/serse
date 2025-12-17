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

import it.csi.serse.serseweb.api.IstitutiScolasticiApi;
import it.csi.serse.serseweb.api.manager.IstitutiScolasticiManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
@Component
public class IstitutiScolasticiApiImpl extends ParentOverWebApi implements IstitutiScolasticiApi {
    @Autowired
    IstitutiScolasticiManager istitutiScolasticiManager;

    @Override
    public Response getGradiScolastici(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return istitutiScolasticiManager.getGradiScolastici();
    }

    @Override
    public Response getIstitutiScolastici(Long idPercorsoScolastico, String codiceComune, String codiceProvincia, String idGradoScolastico,Long idTipologiaIstituto, String codiceRegionale, String codiceMeccanografico, String denominazioneEnte, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return istitutiScolasticiManager.getIstitutiScolastici(idPercorsoScolastico
                                                                ,codiceComune
                                                                ,codiceProvincia
                                                                ,idGradoScolastico
                                                                ,idTipologiaIstituto
                                                                ,codiceRegionale
                                                                ,codiceMeccanografico
                                                                ,denominazioneEnte);
    }

    @Override
    public Response getPercorsiScolastici(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return istitutiScolasticiManager.getPercorsiScolastici();
    }

    @Override
    public Response getTipologieIstituti(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return istitutiScolasticiManager.getTipologieIstituti();
    }
}
