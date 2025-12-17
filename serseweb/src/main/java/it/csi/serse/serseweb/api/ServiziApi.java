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


import it.csi.serse.serseweb.vo.DatiPeculiariWrapper;
import it.csi.serse.serseweb.vo.DettaglioClasseDestinatarioServizio;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.FilterServizi;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.PeriodoAttivazioneVerifica;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.ServizioFonte;
import it.csi.serse.serseweb.vo.ServizioGamChiudiServizio;
import it.csi.serse.serseweb.vo.ServizioGamPropostaModifica;
import it.csi.serse.serseweb.vo.ServizioModello;
import it.csi.serse.serseweb.vo.ServizioPageWrapper;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import it.csi.serse.serseweb.vo.ServizioSto;
import it.csi.serse.serseweb.vo.ServizioVoceSpesa;
import it.csi.serse.serseweb.vo.ServizioWrapper;
import it.csi.serse.serseweb.vo.StatoServizio;
import it.csi.serse.serseweb.vo.TestChiudiServizio;
import it.csi.serse.serseweb.vo.TestGenerico;
import it.csi.serse.serseweb.vo.TestInterventoServizio;
import it.csi.serse.serseweb.vo.TokenGam;

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
@Path("/servizi")


public interface ServiziApi  {
   
    /**
     * summary = Richiesta chiudere intervento
     * description = Richiamare il Servizio GAM - GestInterscMaterie.nuovoIncontroSrvSerse per la richiesta di chiudere un intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione<br>
           schema implementation = { @see Servizio }</p>
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
    @Path("/chiusura")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response chiudiServizio( ServizioGamChiudiServizio body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella i servizi modello associati a servizio regionale passati per parametro
     * description = cancella i servizi modello associati a servizi regionali
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta generica del successo dell'operazione di aggiornamento<br>
           schema implementation = { @see GenericResponse }</p>
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
    @Path("/servizi-modello-regionali")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response deleteServiziModelloRegionale( List<ServizioModello> body, @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella il servizio esterno selezionato
     * description = cancella il servizio esterno selezionato
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
    @Path("/servizio-modello-esterno")
    
    @Produces({ "application/json" })
    Response deleteServizioEsterno( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento, @NotNull @QueryParam("idServizioModello") Long idServizioModello,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cancella il servizio per id
     * description = cancella tutte le informazione correlate dil servizio ed il servizio per id
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta generica del successo dell'operazione cancellare servizio<br>
           schema implementation = { @see GenericResponse }</p>
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
    
    
    @Produces({ "application/json" })
    Response deleteServizioForId( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = classe destinatario associata al servizio
     * description = restituisce la classe associata al servizio selezionato e il valore peculiare 1
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = classe destinatario associata al servizio<br>
           schema implementation = { @see DettaglioClasseDestinatarioServizio }</p>
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
    @Path("/classe-servizio")
    
    @Produces({ "application/json" })
    Response getClasseServizioByIdServzioAndIdPso( @NotNull @QueryParam("idServizio") Long idServizio, @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = torna i dati per il controllo della obbligatorieta ed dati peculiari.
     * description = torna i dati per il controllo della obbligatorieta ed dati peculiari.
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = torna i dati per il controllo della obbligatorieta ed dati peculiari, l'oggetto destinatario e destinatario monitoraggio sara vuoto<br>
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
    @Path("/dati-peculiari/controllo-dati-peculiari")
    
    @Produces({ "application/json" })
    Response getControlloDatiPeculiari( @NotNull @QueryParam("numProgrSportello") Long numProgrSportello, @NotNull @QueryParam("idPso") Long idPso,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce il flg del campo aggiuntivo in base all'id del servizio regionale
     * description = restituisce il flg del campo aggiuntivo in base all'id del servizio regionale
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = torna una stringa con il valore del flg selezionato dall'id servizio regionale<br>
           schema implementation = { @see String }</p>
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
    @Path("/flg-campo-aggiuntivo")
    
    @Produces({ "application/json" })
    Response getFlgCampoAggiuntivoByIdServizioRegionale( @NotNull @QueryParam("idServizioRegionale") Long idServizioRegionale,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce il nome della label per il campo aggiuntivo uno
     * description = restituisce la stringa del nome per la label campo aggiuntivo uno
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = torna una stringa con il nome della label<br>
           schema implementation = { @see String }</p>
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
    @Path("/campo-aggiuntivo")
    
    @Produces({ "application/json" })
    Response getLabelCampoAggiuntivo( @NotNull @QueryParam("idPso") Long idPso, @NotNull @QueryParam("numProgrSportello") Long numProgrSportello,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ricerca servizi
     * description = ricerca servizi con filtri
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = l'elenco dei servizi filtrati se ci sono presenti filtri<br>
           schema implementation = { @see ServizioPageWrapper }</p>
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
    Response getServizi( @QueryParam("filter") FilterServizi filter, @QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit, @QueryParam("sort") String sort,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce tutti i servizi associati ai destinatari
     * description = restituisce tutti i servizi associati ai destinatari
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce la lista dei servizi associati ai destinatari<br>
           schema implementation = { @see ServizioWrapper }</p>
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
    @Path("/destinatari")
    
    @Produces({ "application/json" })
    Response getServiziDestinatari( @NotNull @QueryParam("idDestinatario") Long idDestinatario, @NotNull @QueryParam("numProgrSportello") Long numProgrSportello, @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore, @NotNull @QueryParam("codOperatore") Integer codOperatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = dettagli servizio modello esterno associati al modello intervento
     * description = restituisce i dettagli dei servizi associati al modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi modello esterni<br>
           schema implementation = { @see ServizioModello }</p>
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
    @Path("/servizi-modello-esterno")
    
    @Produces({ "application/json" })
    Response getServiziEsternoForIdModelloIntervento( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco servizifonte per servizio
     * description = restituisce servizifonte per servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi fonte<br>
           schema implementation = { @see ServizioFonte }</p>
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
    @Path("/servizi-fonte")
    
    @Produces({ "application/json" })
    Response getServiziFonti( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = torna elenco servizi per idIntervento selezionato
     * description = restituisce l'elenco dei servizi per il idIntervento passato come parametro
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
    @Path("/id-intervento")
    
    @Produces({ "application/json" })
    Response getServiziForIdIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = servizi regionali per il pso selezionato
     * description = restituisce l'elenco dei servizi regionali per il pso passato come parametro, oppure per il modello di intervento selezionato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi regionali con codice e descrizione<br>
           schema implementation = { @see ServizioRegionale }</p>
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
    @Path("/servizi-regionali")
    
    @Produces({ "application/json" })
    Response getServiziRegionaliForPso( @NotNull @QueryParam("idPso") Long idPso, @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco servizi sto
     * description = restituisce gli servizi sto
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi sto<br>
           schema implementation = { @see ServizioSto }</p>
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
    @Path("/servizio-sto")
    
    @Produces({ "application/json" })
    Response getServiziSto( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco servizi voce spesa per id servizio
     * description = restituisce elenco servizi voce spesa per id servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco servizi voce spesa<br>
           schema implementation = { @see ServizioVoceSpesa }</p>
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
    @Path("/servizi-voce-spesa")
    
    @Produces({ "application/json" })
    Response getServiziVoceSpesa( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = seleziona un servizio tramite id
     * description = restituisce il servizio con l'id passato come parametro
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = servizio selezionato<br>
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
    @Path("/seleziona-servizio")
    
    @Produces({ "application/json" })
    Response getServizioById( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = dettagli servizio modello esterno selezionato
     * description = restituisce i dettagli del servizio selezionato  associato al modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi modello esterni<br>
           schema implementation = { @see ServizioModello }</p>
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
    @Path("/servizio-modello-esterno")
    
    @Produces({ "application/json" })
    Response getServizioEsternoById( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("idServizioModello") Long idServizioModello,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco stati disponibili per i servizi
     * description = restituisce gli stati possibili per un servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi regionali con codice e descrizione<br>
           schema implementation = { @see StatoServizio }</p>
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
    @Path("/stati-servizi")
    
    @Produces({ "application/json" })
    Response getStatiServizi(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = determinare se il Servizio in elaborazione deriva da un Intervento e, nel caso, se questo è di tipo Individuale o meno
     * description = determinare se il Servizio in elaborazione deriva da un Intervento e, nel caso, se questo è di tipo Individuale o meno
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = servizio selezionato<br>
           schema implementation = { @see TestInterventoServizio }</p>
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
    @Path("/servizio-intervento/test-individuale")
    
    @Produces({ "application/json" })
    Response getTestInterventoServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = tipolgie di servizi dell'intervento
     * description = restituisce l'elenco dei servizi disponibili per l'intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi regionali con codice e descrizione o titolo servizio esterno<br>
           schema implementation = { @see ServizioRegionale }</p>
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
    @Path("/tipologie-servizi-intervento")
    
    @Produces({ "application/json" })
    Response getTipologieServiziForIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = tipolgie di servizi del modello
     * description = restituisce l'elenco dei servizi disponibili per il modello
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi regionali con codice e descrizione o titolo servizio esterno<br>
           schema implementation = { @see ServizioModello }</p>
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
    @Path("/tipologie-servizi")
    
    @Produces({ "application/json" })
    Response getTipologieServiziForModelloIntervento( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = tipolgie di servizi dell'intervento
     * description = restituisce la lista tipologia di servizio regionali disponibili per pso con il filtro correspondiente per idIntevento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei servizi regionali con codice e descrizione<br>
           schema implementation = { @see ServizioRegionale }</p>
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
    @Path("/servizi-regionali-per-servizio")
    
    @Produces({ "application/json" })
    Response getTipologieServiziForServizioPso( @NotNull @QueryParam("idPso") Long idPso, @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisce un nuovo servizio modello associato a servizio regionale
     * description = inserisce il nuovo servizio modello associato ad un servizio regionale
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta generica del successo dell'operazione di aggiornamento<br>
           schema implementation = { @see GenericResponse }</p>
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
    @Path("/servizi-modello-regionali")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertServiziModelloRegionale( List<ServizioModello> body, @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = aggiungi nuovo servizio
     * description = inserisce un nuovo servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione di inserimento<br>
           schema implementation = { @see Servizio }</p>
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
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertServizio( Servizio body, @QueryParam("isIndividuale") Boolean isIndividuale,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisci servizio modello esterno
     * description = inserimento di un nuovo servizio modello esterno
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
    @Path("/servizio-modello-esterno")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertServizioModelloEsterno( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento, ServizioModello body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = chiamta gam per la proposta modifica di durata ore e destinatari massimo
     * description = chiamta gam per la proposta modifica di durata ore e destinatari massimo
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del servizio GAM<br>
           schema implementation = { @see TokenGam }</p>
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
    @Path("/servizio-gam-proposta-modifica")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertTokenGam( ServizioGamPropostaModifica body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = aggiunge dati peculiari a un servizio
     * description = modifica un servizio, aggiungendo dati peculiari
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione di aggiornamento, torna quantita di riga modificati<br>
           schema implementation = { @see GenericResponse }</p>
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
    @Path("/dati-peculiari")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response servizioDatiPeculiari( Servizio body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = test chiusura, verifica se esiste almeno un incontro non ancora chiuso e se la sommaDurataIncontri è maggiore di durata ore
     * description = restituisce test se esiste almeno un incontro non ancora chiuso e se la sommaDurataIncontri è maggiore di durata ore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = test se esiste almeno un incontro non ancora chiuso e se la sommaDurataIncontri è maggiore di durata ore<br>
           schema implementation = { @see TestChiudiServizio }</p>
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
    @Path("/chiusura")
    
    @Produces({ "application/json" })
    Response testChiudereServizio( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica servizio modello associato a servizio regionale
     * description = aggiorna il servizio modello associato ad un servizio regionale
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta generica del successo dell'operazione di aggiornamento<br>
           schema implementation = { @see GenericResponse }</p>
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
    @Path("/servizi-modello-regionali")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateServiziModelloRegionale( List<ServizioModello> body, @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = modifica un servizio
     * description = modifica un servizio, valorizare numProgrSportello, codOperatore, idPso, ModelId, codiceFiscaleUtente Se il salvataggio è avvenuto a seguito della modifica della Durata in ore e/o del Numero destinatari
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione di aggiornamento<br>
           schema implementation = { @see Servizio }</p>
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
    Response updateServizio( Servizio body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = aggiorna servizio modello esterno
     * description = aggiornamento di un servizio modello esterno
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elemento aggiornato<br>
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
    @Path("/servizio-modello-esterno")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateServizioModelloEsterno( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento, ServizioModello body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = determina se lo sportello su cui si sta lavorando è attivo
     * description = valuta se il periodo di attivazione dello sportello è valido e quindi si possono inserire nuovi servizi o chiederne il finanziamento/modifica al finanziamento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = torna un valore booleano della verifica<br>
           schema implementation = { @see PeriodoAttivazioneVerifica }</p>
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
    @Path("/verifica-periodo-attivazione-servizio")
    
    @Produces({ "application/json" })
    Response verificaPeriodoAttivazioneServizio( @NotNull @QueryParam("numProgrSportello") Long numProgrSportello,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = verifica se il servizio è associato a un modello di intervento
     * description = restituisce se il servizio è associato a un modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = torna un oggeto TestGenerico con nome isAssociatoAlModelloDiIntervento e un valore booleano<br>
           schema implementation = { @see TestGenerico }</p>
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
    @Path("/target-destinatari-servizio-associato-test")
    
    @Produces({ "application/json" })
    Response verificaServizioAssociatoModelloDiIntervento( @NotNull @QueryParam("idServizio") Long idServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
