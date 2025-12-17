package it.csi.serse.serseapi.api;

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

import it.csi.serse.serseapi.vo.*;


import it.csi.serse.serseapi.vo.AcquisisciElaborazioneGAMInput;
import it.csi.serse.serseapi.vo.AcquisisciElaborazioneGAMOutput;
import it.csi.serse.serseapi.vo.Errore;
import it.csi.serse.serseapi.vo.GenericResponse;
import it.csi.serse.serseapi.vo.OutputEsposizioneAnagrafiche;
import it.csi.serse.serseapi.vo.OutputEsposizioneServizi;

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
@Path("/gest-intersc-serse")


public interface GestInterscSerseApi  {
   
    /**
     * summary = verifica elaborazione GAM
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = esito<br>
           schema implementation = { @see AcquisisciElaborazioneGAMOutput }</p>
         </li>
         <li>    
           <p>responseCode = 400, description = usata quando i campi non sono validati correttamente<br>
           schema implementation = { @see Errore }</p>
         </li>
         <li>    
           <p>responseCode = 403, description = utente non autorizzato al caso d'uso<br>
           schema implementation = { @see Errore }</p>
         </li>
         <li>    
           <p>responseCode = 200, description = errore generico<br>
           schema implementation = { @see Errore }</p>
         </li>
       </ul>
    */
    @PUT
    @Path("/acquisisci-elaborazione-GAM")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response acquisisciElaborazioneGAM( AcquisisciElaborazioneGAMInput body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Esposizione delle anagrafiche per terze parti
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = esito<br>
           schema implementation = { @see OutputEsposizioneAnagrafiche }</p>
         </li>
         <li>    
           <p>responseCode = 400, description = usata quando i campi non sono validati correttamente<br>
           schema implementation = { @see OutputEsposizioneAnagrafiche }</p>
         </li>
         <li>    
           <p>responseCode = 404, description = CF non presente in SERSE<br>
           schema implementation = { @see OutputEsposizioneAnagrafiche }</p>
         </li>
         <li>    
           <p>responseCode = 403, description = utente non autorizzato al caso d'uso<br>
           schema implementation = { @see Errore }</p>
         </li>
       </ul>
    */
    @GET
    @Path("/esposizione-anagrafica-destinatario")
    
    @Produces({ "application/json" })
    Response esposizioneAnagraficaDestinatario( @NotNull @QueryParam("cfDestinatario") String cfDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Esposizione dei servizi somministrati a un dato destinatario, per terze parti
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = esito<br>
           schema implementation = { @see OutputEsposizioneServizi }</p>
         </li>
         <li>    
           <p>responseCode = 400, description = usata quando i campi non sono validati correttamente<br>
           schema implementation = { @see OutputEsposizioneServizi }</p>
         </li>
         <li>    
           <p>responseCode = 404, description = CF non presente in SERSE<br>
           schema implementation = { @see OutputEsposizioneServizi }</p>
         </li>
         <li>    
           <p>responseCode = 403, description = utente non autorizzato al caso d'uso<br>
           schema implementation = { @see Errore }</p>
         </li>
       </ul>
    */
    @GET
    @Path("/esposizione-servizi-destinatario")
    
    @Produces({ "application/json" })
    Response esposizioneServiziDestinatario( @NotNull @QueryParam("cfDestinatario") String cfDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = test
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = esito<br>
           schema implementation = { @see GenericResponse }</p>
         </li>
         <li>    
           <p>responseCode = 400, description = usata quando i campi non sono validati correttamente<br>
           schema implementation = { @see Errore }</p>
         </li>
         <li>    
           <p>responseCode = 403, description = utente non autorizzato al caso d'uso<br>
           schema implementation = { @see Errore }</p>
         </li>
         <li>    
           <p>responseCode = 200, description = errore generico<br>
           schema implementation = { @see Errore }</p>
         </li>
       </ul>
    */
    @GET
    @Path("/test")
    
    @Produces({ "application/json" })
    Response test(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
