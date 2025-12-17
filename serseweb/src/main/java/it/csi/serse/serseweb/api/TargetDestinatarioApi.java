package it.csi.serse.serseweb.api;

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

import it.csi.serse.serseweb.vo.*;


import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.TargetDestinatariPerModifica;
import it.csi.serse.serseweb.vo.TargetDestinatario;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.validation.constraints.*;
@Path("/target-destinatario")


public interface TargetDestinatarioApi  {
   
    @GET
    @Path("/elenco-associati")
    
    @Produces({ "application/json" })
    Response getElencoTargetDestinatariForModello( @NotNull @QueryParam("idPso") Integer idPso, @NotNull @QueryParam("idModelloDiIntervento") Integer idModelloDiIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    @GET
    @Path("/elenco-gestione")
    
    @Produces({ "application/json" })
    Response getElencoTargetDestinatariForPSO( @NotNull @QueryParam("idPso") Integer idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    @PUT
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateElencoTargetDestinatarioForModello( TargetDestinatariPerModifica body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
