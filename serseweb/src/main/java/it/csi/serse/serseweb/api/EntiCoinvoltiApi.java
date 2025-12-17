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


import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;
import it.csi.serse.serseweb.vo.EnteCoinvoltoWrapper;
import it.csi.serse.serseweb.vo.EnteDestinatario;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.FonteDato;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.RuoloEnte;
import it.csi.serse.serseweb.vo.TestEnteCoinvoltoIntervento;

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
@Path("/enti-coinvolti")


public interface EntiCoinvoltiApi  {
   
    /**
     * summary = modifica ente coinvolto modello
     * description = prende un oggetto EnteCoinvoltoModello per cessare l'ente
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = aggiornamento effettuato con successo<br>
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
    @PUT
    @Path("/ente-coinvolto-modello/cessare")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response cessareEnteCoinvoltoModello( EnteCoinvoltoModello body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella l'ente coinvolto selezionato
     * description = cancella l'ente coinvolto modello selezionato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = l'ente è stato cancellato correttamente<br>
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
    @Path("/ente-coinvolto-modello")
    
    @Produces({ "application/json" })
    Response deleteEnteCoinvoltoModelloById( @NotNull @QueryParam("idEnteCoinvolto") Long idEnteCoinvolto, @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella ente coinvolto per intervento
     * description = cancella l'ente coinvolto intervento selezionato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = l'ente coinvolto intervento è stato cancellato<br>
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
    @Path("/ente-coinvolto-intervento")
    
    @Produces({ "application/json" })
    Response deleteEntiCoinvoltiIntervento( @NotNull @QueryParam("idEnteCoinvoltoIntervento") Long idEnteCoinvoltoIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella ente coinvolto per intervento che arriva da un modello
     * description = cancella l'ente coinvolto intervento selezionato che arriva da un modello
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = l'ente coinvolto intervento da modello è stato cancellato<br>
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
    @Path("/ente-coinvolto-intervento-modello")
    
    @Produces({ "application/json" })
    Response deleteEntiCoinvoltiInterventoModello( @NotNull @QueryParam("idEnteCoinvoltoModello") Long idEnteCoinvoltoModello, @NotNull @QueryParam("idIntervento") Long idIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella ente coinvolto servizio (per servizio, intervento o modello)
     * description = cancella un ente coinvolto in base ai parametri passati
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = l'ente coinvolto servizio è stato cancellato<br>
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
    @Path("/ente-coinvolto-servizio")
    
    @Produces({ "application/json" })
    Response deleteEntiCoinvoltiServizio( @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento, @QueryParam("idEnteCoinvoltoServizio") Long idEnteCoinvoltoServizio, @QueryParam("idEnteCoinvoltoIntervento") Long idEnteCoinvoltoIntervento, @QueryParam("idEnteCoinvoltoModello") Long idEnteCoinvoltoModello, @QueryParam("idServizio") Long idServizio, @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = enti coinvolti intervento per id
     * description = prende come parametro idEnteCoinvoltoIntervento per ricercare l' ente coinvolto intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see EnteCoinvoltoIntervento }</p>
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
    @Path("/ente-coinvolto-intervento")
    
    @Produces({ "application/json" })
    Response getEnteCoinvoltoInterventoForId( @NotNull @QueryParam("idEnteCoinvoltoIntervento") Long idEnteCoinvoltoIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ente coinvolto per id
     * description = restituisce l'ente coinvolto modello selezionato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see EnteCoinvoltoModello }</p>
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
    @Path("/ente-coinvolto-modello")
    
    @Produces({ "application/json" })
    Response getEnteCoinvoltoModelloForId( @NotNull @QueryParam("idEnteCoinvoltoModello") Long idEnteCoinvoltoModello,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ente coinvolto servizio per id
     * description = prende come parametro idEnteCoinvoltoServizio per ricercare l'ente coinvolto servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see EnteCoinvoltoServizio }</p>
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
    @Path("/ente-coinvolto-servizio")
    
    @Produces({ "application/json" })
    Response getEnteCoinvoltoServizioForId( @NotNull @QueryParam("idEnteCoinvoltoServizio") Long idEnteCoinvoltoServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = enti coinvolti per id intervento
     * description = prende come parametro idIntervento per cercare gli enti coinvolti legati all' intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see EnteCoinvoltoIntervento }</p>
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
    @Path("/enti-coinvolti-intervento")
    
    @Produces({ "application/json" })
    Response getEntiCoinvoltiForIdIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = enti coinvolti per id servizio
     * description = prende come parametro idServizio per cercare gli enti coinvolti legati al servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see EnteCoinvoltoWrapper }</p>
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
    @Path("/enti-coinvolti-servizio")
    
    @Produces({ "application/json" })
    Response getEntiCoinvoltiForIdServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = enti coinvolti per modello di intervento
     * description = prende i parametri idPso e idModelloIntervento per ricercare gli enti coinvolti con il modello
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see EnteCoinvoltoModello }</p>
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
    @Path("/enti-coinvolti-modello")
    
    @Produces({ "application/json" })
    Response getEntiCoinvoltiForModelloIntervento( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = enti destinatari per id servizio
     * description = prende come parametro idServizio per cercare su enti coinvolti legati al servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see EnteDestinatario }</p>
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
    @Path("/enti-destinatari")
    
    @Produces({ "application/json" })
    Response getEntiDestinatariForIdServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = fonte dato per pso
     * description = prende i parametri idPso per vedere se ci sono enti da fonte dato coinvolti
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see FonteDato }</p>
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
    @Path("/id-fonte-dato")
    
    @Produces({ "application/json" })
    Response getFonteDatoPerPso( @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = lista ruoli ente
     * description = elenco dei ruoli per enti coinvolti
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = OK<br>
           schema implementation = { @see RuoloEnte }</p>
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
    @Path("/ruolo-ente")
    
    @Produces({ "application/json" })
    Response getRuoliEnte(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce un nuovo ente coinvolto per intervento
     * description = prende un oggetto EnteCoinvoltoIntervento da inserire nel db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
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
    @Path("/ente-coinvolto-intervento")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertEnteCoinvoltoIntervento( EnteCoinvoltoIntervento body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserimento nuovo ente coinvolto modello
     * description = prende un oggetto EnteCoinvoltoModello da inserire nel db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
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
    @Path("/ente-coinvolto-modello")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertEnteCoinvoltoModello( EnteCoinvoltoModello body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce un nuovo ente coinvolto servizio
     * description = prende un oggetto EnteCoinvoltoServizio da inserire nel db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
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
    @Path("/ente-coinvolto-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertEnteCoinvoltoServizio( EnteCoinvoltoServizio body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica ente coinvolto modello
     * description = prende un oggetto EnteCoinvoltoModello per aggiornare il db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = aggiornamento effettuato con successo<br>
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
    @PUT
    @Path("/ente-coinvolto-modello")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateEnteCoinvoltoModello( EnteCoinvoltoModello body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica un ente coinvolto per intervento
     * description = prende un oggetto EnteCoinvoltoIntervento da modificare a db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
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
    @PUT
    @Path("/ente-coinvolto-intervento")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updatetEnteCoinvoltoIntervento( EnteCoinvoltoIntervento body, @NotNull @QueryParam("codUserAggiorn") String codUserAggiorn,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica un ente coinvolto per intervento
     * description = prende un oggetto EnteCoinvoltoServizio da modificare a db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
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
    @PUT
    @Path("/ente-coinvolto-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updatetEnteCoinvoltoServizio( EnteCoinvoltoServizio body, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = verifica paramtri per bottone aggiungi ente
     * description = prende i parametri idIntervento per verificare se il bottone AGGIUNGI nel riquadro degli enti coinvolti per l’Intervento permette di aggiungerne uno nuovo
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = torna come risposta ( isVisibleAggiungiEnteCoinvolto, isInterventoAssociatoAdModello)<br>
           schema implementation = { @see TestEnteCoinvoltoIntervento }</p>
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
    @Path("/ente-coinvolto-intervento/verifica-aggiungi")
    
    @Produces({ "application/json" })
    Response verificaPerAggiungiEntiCoinvoltiIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
