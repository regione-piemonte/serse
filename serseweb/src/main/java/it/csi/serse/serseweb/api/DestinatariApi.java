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


import it.csi.serse.serseweb.vo.ClasseDestinatario;
import it.csi.serse.serseweb.vo.CondizioneOccupazionaleIgrue;
import it.csi.serse.serseweb.vo.DatiPeculiari;
import it.csi.serse.serseweb.vo.DatiPeculiariWrapper;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.DestinatarioServizio;
import it.csi.serse.serseweb.vo.DestinatarioServizioCaricato;
import it.csi.serse.serseweb.vo.DestinatariservizioRinumeraBody;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.Incontro;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.TargetDestinatariAssociati;
import it.csi.serse.serseweb.vo.TargetDestinatariServizio;
import it.csi.serse.serseweb.vo.TargetDestinatario;
import it.csi.serse.serseweb.vo.TestDestinatario;
import it.csi.serse.serseweb.vo.TitoloStudioIgrue;

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
@Path("/destinatari")


public interface DestinatariApi  {
   
    /**
     * summary = associa un record destinatario a intervento
     * description = associa un record destinatario a intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = associazione effettuata con successo<br>
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
    @Path("/associa-destinatario-intervento")
    
    @Produces({ "application/json" })
    Response associaDestinatarioIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento, @NotNull @QueryParam("idDestinatario") Long idDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = associa un record destinatario a servizio
     * description = associa un record destinatario a servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = associazione effettuato con successo<br>
           schema implementation = { @see DestinatarioServizio }</p>
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
    @Path("/associa-destinatario-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response associaDestinatarioServizio( @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento, List<Destinatario> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce ed associa un elenco di destinatari a servizio
     * description = inserisce ed associa un elenco di destinatari a servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = associazione effettuato con successo<br>
           schema implementation = { @see DestinatarioServizioCaricato }</p>
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
    @Path("/carica-destinatari-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response caricaDestinatariServizio( @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento, List<Destinatario> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella il target destinatario associato al modello di intervento e Pso
     * description = cancella il target destinatario associato al modello di intervento e Pso
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = il target destinatario è stato cancellato correttamente<br>
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
    @Path("/target-destinatario-associati")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response deleteTargetDestinatarioForModello( List<TargetDestinatariAssociati> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella il target destinatario associato al servizio e Pso
     * description = cancella il target destinatario associato al servizio e Pso
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = il target destinatario associato al servizio è stato cancellato correttamente<br>
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
    @Path("/target-destinatari-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response deleteTargetDestinatarioServizio( List<TargetDestinatariServizio> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Cancella associazione di un record destinatario a servizio
     * description = Cancella associazione di record destinatario a servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = cancelazione avvenuta con successo se è andata a buon fine oppure attenzione non è possibile eliminare l’associazione..<br>
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
    @Path("/associa-destinatario-servizio")
    
    @Produces({ "application/json" })
    Response disassociaDestinatarioServizio( @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("idDestinatario") Long idDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = torna elenco delle classi destinatario con dt.fine uguale a null
     * description = torna elenco di ClasseDestinatarioDTO
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce elenco delle classi destinatario<br>
           schema implementation = { @see ClasseDestinatario }</p>
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
    @Path("/classi-destinatario")
    
    @Produces({ "application/json" })
    Response getClassiDestinatario( @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = torna elenco dei condizione occupazionale igrue.
     * description = torna elenco dei condizione occupazionale igrue.
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce  elenco dei condizione occupazionale igrue.<br>
           schema implementation = { @see CondizioneOccupazionaleIgrue }</p>
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
    @Path("/condizione-occupazionale-igrue")
    
    @Produces({ "application/json" })
    Response getCondizioneOccupazionaleIgrue(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ricerca destinatari
     * description = restituisce l'elenco dei destinatari cercato, cerca con almeno un parametro inserito tra nome, conogme, codice fiscale, data di nascita
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari<br>
           schema implementation = { @see Destinatario }</p>
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
    @Path("/ricerca")
    
    @Produces({ "application/json" })
    Response getDestinatariDaRicerca( @QueryParam("nome") String nome, @QueryParam("cognome") String cognome, @QueryParam("codiceFiscaleDestinatario") String codiceFiscaleDestinatario, @QueryParam("dataDiNascita") String dataDiNascita,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco destinatari associati ai Servizi associati a un intervento.
     * description = lenco destinatari associati ai Servizi associati a un intervento.
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari<br>
           schema implementation = { @see Destinatario }</p>
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
    @Path("/destinatario-servizio-intervento")
    
    @Produces({ "application/json" })
    Response getDestinatariIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = destinatari associati al servizio della tabella serse_r_destinatario_servizio
     * description = destinatari associati al servizio della tabella serse_r_destinatario_servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari della tabella serse_r_destinatario_servizio<br>
           schema implementation = { @see DestinatarioServizio }</p>
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
    @Path("/destinatari-servizi-servizio")
    
    @Produces({ "application/json" })
    Response getDestinatariServiziServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = dettaglio destinatario
     * description = dettagli del destinatario
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari<br>
           schema implementation = { @see Destinatario }</p>
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
    Response getDestinatarioForId( @NotNull @QueryParam("idDestinatario") Long idDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco destinatario non associati al Servizio in elaborazione.
     * description = dettagli del destinatario collegato all'intervento che non risultano già associati al Servizio in elaborazione.
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari<br>
           schema implementation = { @see Destinatario }</p>
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
    @Path("/destinatario-intervento-servizio")
    
    @Produces({ "application/json" })
    Response getDestinatarioForIdServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco destinatario associati al Servizio in elaborazione.
     * description = dettagli del destinatario  associati al Servizio in elaborazione.
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari<br>
           schema implementation = { @see Destinatario }</p>
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
    @Path("/destinatario-servizio")
    
    @Produces({ "application/json" })
    Response getDestinatarioServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = destinatario associati al Servizio in elaborazione ed dati peculiari.
     * description = destinatario  associati al Servizio in elaborazione ed dati peculiari.
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari<br>
           schema implementation = { @see DatiPeculiariWrapper }</p>
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
    @Path("/destinatario-servizio/dati-peculiari")
    
    @Produces({ "application/json" })
    Response getDestinatarioServizioDatiPeculiari( @NotNull @QueryParam("idDestinatario") Long idDestinatario, @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("numProgrSportello") Long numProgrSportello, @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = destinatario associati al Servizio in elaborazione ed dati peculiari.
     * description = destinatario  associati al Servizio in elaborazione ed dati peculiari.
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei destinatari<br>
           schema implementation = { @see DatiPeculiariWrapper }</p>
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
    @Path("/destinatario-servizio/destinatari-dati-peculiari-mancanti")
    
    @Produces({ "application/json" })
    Response getDestinatarioServizioDatiPeculiariMancanti( @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("numProgrSportello") Long numProgrSportello, @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = target destinatario associati al modello di intervento
     * description = elenco dei target destinatari associati al modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco delle descrizione di target Destinatario associati il modello di intervento.<br>
           schema implementation = { @see TargetDestinatario }</p>
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
    @Path("/target-destinatario-associati")
    
    @Produces({ "application/json" })
    Response getElencoTargetDestinatariForModello( @NotNull @QueryParam("idPso") Long idPso, @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco degli incontri associati al destinatario
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco degli incontri associati<br>
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
    @Path("/incontri")
    
    @Produces({ "application/json" })
    Response getIncontriForDestinatario( @NotNull @QueryParam("idDestinatario") Long idDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco servizi associati al destinatario
     * description = torna l'elenco servizi associati al destinatario
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi<br>
           schema implementation = { @see Servizio }</p>
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
    @Path("/servizi")
    
    @Produces({ "application/json" })
    Response getServiziForIdDestinatario( @NotNull @QueryParam("idDestinatario") Long idDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco servizi associati al destinatario filtrato per idIntervento
     * description = torna l'elenco servizi associati al destinatario filtrato per idIntervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi<br>
           schema implementation = { @see Servizio }</p>
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
    @Path("/servizi-intervento")
    
    @Produces({ "application/json" })
    Response getServiziForIdDestinatarioIdIntervento( @NotNull @QueryParam("idDestinatario") Long idDestinatario, @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco target destinatari associati ai servizi associati al idIntervento
     * description = restituisce l'elenco delle descrizioni e id dei target destinatari associati ai servizi associati al idIntervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei target destinatari<br>
           schema implementation = { @see TargetDestinatario }</p>
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
    @Path("/target-destinatari-servizio-associato-intervento")
    
    @Produces({ "application/json" })
    Response getTargetDestinatariForIdIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco target destinatari associati al idservizio
     * description = restituisce l'elenco delle descrizioni e id dei target destinatari associati al servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei target destinatari<br>
           schema implementation = { @see TargetDestinatario }</p>
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
    @Path("/target-destinatari-servizio-associato")
    
    @Produces({ "application/json" })
    Response getTargetDestinatariForIdServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco target destinatari per pso
     * description = restituisce l'elenco di descrizioni e id dei target destinatari
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei target destinatari<br>
           schema implementation = { @see TargetDestinatario }</p>
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
    @Path("/target-destinatari")
    
    @Produces({ "application/json" })
    Response getTargetDestinatariForPso( @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco target destinatari associati al servizio
     * description = restituisce l'elenco delle descrizioni e id dei target destinatari associati al servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei target destinatari<br>
           schema implementation = { @see TargetDestinatario }</p>
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
    @Path("/target-destinatari-servizio")
    
    @Produces({ "application/json" })
    Response getTargetDestinatariForServizio( @NotNull @QueryParam("idPso") Long idPso, @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("isModificabile") Boolean isModificabile,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = torna elenco dei titoli studio igrue.
     * description = torna elenco dei titoli studio igrue
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce elenco dei titoli studio igrue<br>
           schema implementation = { @see TitoloStudioIgrue }</p>
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
    @Path("/titoli-studio-igrue")
    
    @Produces({ "application/json" })
    Response getTitoliStudioIgrue(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce un nuovo record in destinatario da intervento
     * description = inserisce un nuovo record in destinatario da intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
           schema implementation = { @see Destinatario }</p>
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
    @Path("/destinatario-intervento")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertDestinatarioIntervento( Destinatario body, @NotNull @QueryParam("idIntervento") Long idIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce un nuovo record in destinatario da servizio
     * description = inserisce un nuovo record in destinatario da servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
           schema implementation = { @see Destinatario }</p>
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
    @Path("/destinatario-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertDestinatarioServizio( Destinatario body, @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisci target destinatario associati al modello di intervento e Pso
     * description = inserimento di un nuovo target destinatario associati al modello di intervento e Pso
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
    @Path("/target-destinatario-associati")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertTargetDestinatarioForModello( List<TargetDestinatariAssociati> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisci target destinatario associati al servizio e Pso
     * description = inserimento di un nuovo target destinatario associati al servizio e Pso
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
    @Path("/target-destinatari-servizio")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertTargetDestinatarioServizio( List<TargetDestinatariServizio> body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = riassegna i numeri nella tabella serse_r_destinatario_servizio
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = ok<br>
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
    @Path("/destinatari-servizio/rinumera")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response rinumeraDestinatariServizio( DestinatariservizioRinumeraBody body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = salva il dato peculiare in destinatario servizio e destinatario servizio monitoraggio
     * description = salva il dato peculiare in destinatario servizio e destinatario servizio monitoraggio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
           schema implementation = { @see DatiPeculiari }</p>
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
    @Path("/destinatario-servizio/dati-peculiari")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response salvaDatiPeculiari( DatiPeculiari body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Verifica esistenza Codice Fiscale in anagrafica.
     * description = restituisce isCodiceFiscaleInAnagrafica
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce se codice fiscle e presente nella anagrafica oppure no<br>
           schema implementation = { @see TestDestinatario }</p>
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
    @Path("/test-codice-fiscale")
    
    @Produces({ "application/json" })
    Response testCodiceFiscale( @QueryParam("codiceFiscaleDestinatario") String codiceFiscaleDestinatario,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Verifica numero massimo di destinatari associaibiliad un servizio.
     * description = restituisce raggiuntoNumeroMassimoDestinatariAssociabili
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce raggiuntoNumeroMassimoDestinatariAssociabili<br>
           schema implementation = { @see TestDestinatario }</p>
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
    @Path("/test-max-destinatari-associabili")
    
    @Produces({ "application/json" })
    Response testMaxDestinatariAssociabili( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica un record in destinatario
     * description = modifica un record in destinatario
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = inserimento effettuato con successo<br>
           schema implementation = { @see Destinatario }</p>
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
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateDestinatario( Destinatario body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
