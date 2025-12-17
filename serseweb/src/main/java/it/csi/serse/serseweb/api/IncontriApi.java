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


import it.csi.serse.serseweb.vo.Bacino;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.IncontriSomma;
import it.csi.serse.serseweb.vo.Incontro;
import it.csi.serse.serseweb.vo.IncontroDestinatarioServizio;
import it.csi.serse.serseweb.vo.LuogoIncontro;
import it.csi.serse.serseweb.vo.Partecipanti;
import it.csi.serse.serseweb.vo.TestChiudiIncontro;

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
@Path("/incontri")


public interface IncontriApi  {
   
    /**
     * summary = associa destinatari al incontro
     * description = associa destinatari al incontro
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elementi associati<br>
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
    @Path("/incontro-destinatario-servizio/associa-destinatari-incontro")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response associaDestinatariIncontro( List<IncontroDestinatarioServizio> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella Incontro
     * description = cancella Incontro per id
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = luogo incontro è stato cancellato<br>
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
    @Path("/incontro")
    
    @Produces({ "application/json" })
    Response deleteIncontro( @NotNull @QueryParam("idIncontro") Long idIncontro,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella associazione Destinatario - Incontro
     * description = cancella associazione Destinatario - Incontro
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
    @Path("/incontro-destinatario-servizio")
    
    @Produces({ "application/json" })
    Response deleteIncontroDestinatarioServizio( @NotNull @QueryParam("idIncontro") Long idIncontro, @NotNull @QueryParam("idDestinatarioServizio") Long idDestinatarioServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella luogo uncontro
     * description = cancella luogo incontro per id
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = luogo incontro è stato cancellato<br>
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
    @Path("/luogo-incontro")
    
    @Produces({ "application/json" })
    Response deleteLuogoIncontro( @NotNull @QueryParam("idIncontro") Long idIncontro,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco comune selezionato tramite codBacino
     * description = elenco comune selezionato tramite codBacino
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco comune selezionato tramite codBacino<br>
           schema implementation = { @see Comune }</p>
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
    @Path("/luogo-incontro/comuni-bacino")
    
    @Produces({ "application/json" })
    Response geComuneForBacino( @NotNull @QueryParam("codBacino") Long codBacino,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco di bacini selezionato tramite codice provincia
     * description = elenco di bacini selezionato tramite codice provincia
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco di bacini trovati tramite codice provincia<br>
           schema implementation = { @see Bacino }</p>
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
    @Path("/luogo-incontro/bacini-provincia")
    
    @Produces({ "application/json" })
    Response getBaciniForCodProvincia( @NotNull @QueryParam("codProvincia") String codProvincia,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = comune selezionato per il codice comune
     * description = comune selezionato per il codice comune
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = comune selezionato per il codice comune<br>
           schema implementation = { @see Comune }</p>
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
    @Path("/luogo-incontro/comune")
    
    @Produces({ "application/json" })
    Response getComune( @NotNull @QueryParam("codComune") String codComune,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = torna la lista dei destinatari associati al servizio
     * description = torna la lista dei destinatari associati al servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = lista partecipanti<br>
           schema implementation = { @see Partecipanti }</p>
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
    @Path("/incontro-destinatario-servizio/idservizio")
    
    @Produces({ "application/json" })
    Response getDestinatarioForIdIServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = torna la lista dei destinatari partecipanti al incontro
     * description = torna la lista desi destinatari partecipanti al incontro
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = lista partecipanti<br>
           schema implementation = { @see Partecipanti }</p>
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
    @Path("/incontro-destinatario-servizio")
    
    @Produces({ "application/json" })
    Response getDestinatarioForIdIncontro( @NotNull @QueryParam("idIncontro") Long idIncontro,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = incontri associati al servizio
     * description = incontri associati al Servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco degli incontri<br>
           schema implementation = { @see Incontro }</p>
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
    
    
    @Produces({ "application/json" })
    Response getIncontriForIdServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = seleziona incontro tramite id
     * description = incontri selezionato tramite id
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = incontro trovato tramite id<br>
           schema implementation = { @see Incontro }</p>
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
    @Path("/incontro")
    
    @Produces({ "application/json" })
    Response getIncontroForId( @NotNull @QueryParam("idIncontro") Long idIncontro,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = seleziona luogo incontro tramite id
     * description = luogo incontri selezionato tramite id
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = luogo incontro trovato tramite id<br>
           schema implementation = { @see LuogoIncontro }</p>
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
    @Path("/luogo-incontro")
    
    @Produces({ "application/json" })
    Response getLuogoIncontroForId( @NotNull @QueryParam("idLuogoIncontro") Long idLuogoIncontro,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = somma delle ore durate previste negli incontri inseriti a fronte del servizio
     * description = restituisce la somma delle durate previste negli incontri inseriti a fronte del servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = somma delle ore durate<br>
           schema implementation = { @see IncontriSomma }</p>
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
    @Path("/somma-durate-ore")
    
    @Produces({ "application/json" })
    Response getSommaDurateOre( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce un nuovo incontro
     * description = prende un oggetto incontro da inserire nel db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
           schema implementation = { @see Incontro }</p>
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
    @Path("/incontro")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertIncontro( Incontro body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce un nuovo luogo incontro
     * description = prende un oggetto luogo incontro da inserire nel db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
           schema implementation = { @see LuogoIncontro }</p>
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
    @Path("/luogo-incontro")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertLuogoIncontro( LuogoIncontro body, @NotNull @QueryParam("idIncontro") Long idIncontro,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica destinatari al incontro
     * description = modifica destinatari associato al incontro
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elementi associati<br>
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
    @Path("/incontro-destinatario-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response modificaDestinatariIncontro( IncontroDestinatarioServizio body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = verifica della data fine e destinatari ore presenza
     * description = restituisce test sulla data fine e destinatari ore presenza
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = test della data fine confrontata con la attuale e test se dei partecipanti all’incontro sono indicate le ore erogate<br>
           schema implementation = { @see TestChiudiIncontro }</p>
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
    @Path("/test-chiusura")
    
    @Produces({ "application/json" })
    Response testChiudereIncontro( @NotNull @QueryParam("idIncontro") Long idIncontro, @NotNull @QueryParam("idSportello") Long idSportello, @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica un incontro
     * description = prende un oggetto incontro da aggiornare
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = aggiornamento effettuato con successo<br>
           schema implementation = { @see Incontro }</p>
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
    @Path("/incontro")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateIncontro( Incontro body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica un luogo incontro
     * description = prende un oggetto luogo incontro da aggiornare
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = aggiornamento effettuato con successo<br>
           schema implementation = { @see LuogoIncontro }</p>
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
    @Path("/luogo-incontro")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateLuogoIncontro( LuogoIncontro body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
