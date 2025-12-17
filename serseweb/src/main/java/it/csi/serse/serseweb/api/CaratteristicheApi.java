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


import it.csi.serse.serseweb.vo.Caratteristica;
import it.csi.serse.serseweb.vo.CaratteristicheAssociate;
import it.csi.serse.serseweb.vo.CaratteristicheServizio;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.GenericResponse;

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
@Path("/caratteristiche")


public interface CaratteristicheApi  {
   
    /**
     * summary = cancella le caratteristiche associate al modello di intervento e Pso
     * description = cancella le caratteristiche associate al modello di intervento e Pso
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = il servizio è stato cancellato correttamente<br>
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
    @DELETE
    @Path("/caratteristiche-associate")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response deleteCaratteristicheForModello( List<CaratteristicheAssociate> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella caratteristiche associato al servizio e Pso
     * description = cancella caratteristiche associato al servizio e Pso
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = è stato cancellato correttamente<br>
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
    @DELETE
    @Path("/caratteristiche-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response deleteCaratteristicheServizio( List<CaratteristicheServizio> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = caratteristiche associate al modello di intervento
     * description = elenco delle caratteristiche associate al modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco delle descrizione delle caratteristiche associate al modello di intervento.<br>
           schema implementation = { @see Caratteristica }</p>
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
    @Path("/caratteristiche-associate")
    
    @Produces({ "application/json" })
    Response getCaratteristicheForModello( @NotNull @QueryParam("idPso") Long idPso, @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco caratteristiche per pso
     * description = restituisce l'elenco di descrizioni e id delle caratteristiche
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco delle caratteristiche<br>
           schema implementation = { @see Caratteristica }</p>
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
    @Path("/caratteristiche-per-pso")
    
    @Produces({ "application/json" })
    Response getCaratteristicheForPso( @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco caratteristiche associati al servizio
     * description = restituisce l'elenco delle descrizioni e id delle caratteristiche associati al servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco delle caratteristiche<br>
           schema implementation = { @see Caratteristica }</p>
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
    @Path("/caratteristiche-servizio")
    
    @Produces({ "application/json" })
    Response getCaratteristicheForServizio( @NotNull @QueryParam("idPso") Long idPso, @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("isModificabile") Boolean isModificabile,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco caratteristiche associate ai servizi associati al idIntervento
     * description = elenco delle caratteristiche associate ai servizi associati al idIntervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco delle descrizione delle caratteristiche associate ai servizi associati al idIntervento<br>
           schema implementation = { @see Caratteristica }</p>
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
    @Path("/caratteristiche-associate-servizio-intervento")
    
    @Produces({ "application/json" })
    Response getCaratteristicheServizioForIdIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco caratteristiche associate idServizio
     * description = elenco delle caratteristiche associate al idServizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco delle descrizione delle caratteristiche associate al idServizio.<br>
           schema implementation = { @see Caratteristica }</p>
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
    @Path("/caratteristiche-associate-servizio")
    
    @Produces({ "application/json" })
    Response getCaratteristicheServizioForIdServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisci caratteristiche associate al modello di intervento e Pso
     * description = inserimento delle nuove caratteristice associate al modello di intervento e Pso
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elemento inserito<br>
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
    @POST
    @Path("/caratteristiche-associate")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertCaratteristicheForModello( List<CaratteristicheAssociate> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisci caratteristiche associati al servizio e Pso
     * description = inserimento di caratteristiche associati al servizio e Pso
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elemento inserito<br>
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
    @POST
    @Path("/caratteristiche-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertCaratteristicheServizio( List<CaratteristicheServizio> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
