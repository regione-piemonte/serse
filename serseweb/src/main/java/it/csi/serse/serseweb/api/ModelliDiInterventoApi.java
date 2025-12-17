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


import it.csi.serse.serseweb.vo.AssociareModelloIntervento;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.FilterModelli;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.InterventiAssociatiModello;
import it.csi.serse.serseweb.vo.ModelloIntervento;
import it.csi.serse.serseweb.vo.ModelloInterventoPageWrapper;
import it.csi.serse.serseweb.vo.ModelloInterventoWrapper;
import it.csi.serse.serseweb.vo.StatoModelloIntervento;
import it.csi.serse.serseweb.vo.TestModelloInterventoModifica;

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
@Path("/modelli-di-intervento")


public interface ModelliDiInterventoApi  {
   
    /**
     * summary = associa modello di intervento
     * description = associa il moddello di intervento al intervento
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
    @PUT
    @Path("/associa-modello-di-intervento")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response associaModelloDiIntervento( AssociareModelloIntervento body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = cambio reversibilita modello
     * description = cambio reversibilita modello
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = reversibilita cambiata<br>
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
    @Path("/reversibilita")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response cambioReversibilita( ModelloIntervento body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = delete modello intervento
     * description = cancellazione di un  modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = il modello di intervento è stato cancellato<br>
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
    @Path("/{idModelloIntervento}")
    
    @Produces({ "application/json" })
    Response deleteModelloInterventoById( @PathParam("idModelloIntervento") Integer idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Disassocia modello intervento
     * description = elimina l'associazione tra un intervento ed un modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = il modello di intervento è stato disassociato<br>
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
    @Path("/disassocia-modello-di-intervento")
    
    @Produces({ "application/json" })
    Response disassociaModelloIntervento( @QueryParam("idIntervento") Long idIntervento, @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = duplica modello intervento
     * description = duplica modello intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo torna il modelloIntervento creato<br>
           schema implementation = { @see ModelloIntervento }</p>
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
    @Path("/duplica-modello-intervento")
    
    @Produces({ "application/json" })
    Response duplicaModelloIntervento( @NotNull @QueryParam("idModelloDiIntervento") Long idModelloDiIntervento, @NotNull @QueryParam("codUserAggiornamento") String codUserAggiornamento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = dati necessari per il file excel
     * description = restituisce il numero di interventi asscociati ad ogni modello
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco delle informazioni aggiuntive necessarie per l'esportazione del file excel<br>
           schema implementation = { @see InterventiAssociatiModello }</p>
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
    @Path("/preparazione-excel")
    
    @Produces({ "application/json" })
    Response getDatiExcelModello( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = interventi legati al modello
     * description = 
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = ok<br>
           schema implementation = { @see ModelloInterventoWrapper }</p>
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
    @Path("/{idModelloIntervento}/interventi")
    
    @Produces({ "application/json" })
    Response getInterventiPerModello( @PathParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ricerca modelli di intervento
     * description = restituisce l'intero elenco di modelli se non si passano parametri, un elenco filtrato altrimenti
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco dei modelli di intervento<br>
           schema implementation = { @see ModelloInterventoPageWrapper }</p>
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
    Response getModelliIntervento( @QueryParam("filter") FilterModelli filter, @QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit, @QueryParam("sort") String sort,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = selziona un modello di intervento tramite id
     * description = restituisce il modello di intervento se presente a db
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce il modello selezionato<br>
           schema implementation = { @see ModelloIntervento }</p>
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
    @Path("/seleziona-modello")
    
    @Produces({ "application/json" })
    Response getModelloDiInterventoById( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = stati modelli di intervento
     * description = restituisce gli stati possibili di un modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco degli stati<br>
           schema implementation = { @see StatoModelloIntervento }</p>
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
    @Path("/stati")
    
    @Produces({ "application/json" })
    Response getStatiModelliIntervento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = inserisci nuovo modello
     * description = inserimento di un nuovo modello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elemento inserito<br>
           schema implementation = { @see ModelloIntervento }</p>
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
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response insertModelloIntervento( ModelloIntervento body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = aggiorna modello
     * description = aggiornamento dati moddello di intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elemento inserito<br>
           schema implementation = { @see ModelloIntervento }</p>
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
    Response updateModelloIntervento( ModelloIntervento body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = verifica campi per modifica
     * description = restituisce null se la modifica è permessa, un oggetto altrimenti
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce null se la modifica è permessa altrimenti un oggetto con i campi che impediscono la modificca<br>
           schema implementation = { @see TestModelloInterventoModifica }</p>
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
    @Path("/test-modifica")
    
    @Produces({ "application/json" })
    Response verificaCampiModelloIntervento( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
