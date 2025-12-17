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

import it.csi.serse.serseweb.api.ExcelApi;
import it.csi.serse.serseweb.api.manager.ExcelManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import java.util.List;

@Component
public class ExcelApiImpl extends ParentOverWebApi implements ExcelApi {
    @Autowired
    ExcelManager excelManager;

    @Override
    public Response exportExcelInterventi(List<ExcelIntervento> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return excelManager.exportExcelInterventi(body);
    }

    @Override
    public Response exportExcelModelli(List<ExcelModello> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return excelManager.exportExcelModelli(body);
    }


    @Override
    public Response exportExcelServizi(List<ExcelServizio> body, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
        return excelManager.exportExcelServizi(body);
    }

    // ====== V2 =======================================================================

    @Override
    public Response exportExcelModelliV2(String descrizionePso, String descrizioneSportello,
            FilterModelli filter, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        return excelManager.exportExcelModelliV2(filter, descrizionePso, descrizioneSportello);
    }

    @Override
    public Response exportExcelInterventiV2(String descrizionePso, String descrizioneSportello,
            FilterInterventi filter, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        return excelManager.exportExcelInterventiV2(filter, descrizionePso, descrizioneSportello);
    }

    @Override
    public Response exportExcelServiziV2(String descrizionePso, String descrizioneSportello,
            FilterServizi filter, SecurityContext securityContext, HttpHeaders httpHeaders,
            HttpServletRequest httpRequest) {
        return excelManager.exportExcelServiziV2(filter, descrizionePso, descrizioneSportello);
    }

}
