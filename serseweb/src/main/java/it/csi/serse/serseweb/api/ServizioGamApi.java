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


import it.csi.serse.serseweb.vo.Budget;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.ServizioGam;
import it.csi.serse.serseweb.vo.ServizioGamIncontro;
import it.csi.serse.serseweb.vo.ServizioGamRiapriServizio;
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
@Path("/servizio-gam")


public interface ServizioGamApi  {
   
    /**
     * summary = Richiesta Preventivo di spesa
     * description = Richiama il Servizio GAM - GestInterscMaterie.calcPreventivoSerse per la richiesta del Preventivo di spesa
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione<br>
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
    @Path("/calc-preventivo-serse")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response calcPreventivoSerse( ServizioGam body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce i budget disponibile per soggetto
     * description = restituisce i dati delle richieste ai servizi GAM in token gam
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco in token gam per idservizio<br>
           schema implementation = { @see Budget }</p>
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
    @Path("/budget-disponibile-per-soggetto")
    
    @Produces({ "application/json" })
    Response getBudgetForSoggetto( @NotNull @QueryParam("numProgrSportello") Long numProgrSportello, @NotNull @QueryParam("codOperatore") Long codOperatore, @NotNull @QueryParam("idPso") Long idPso, @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce l'elenco in token gam per idincontro
     * description = restituisce i dati delle richieste ai servizi GAM in token gam
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco in token gam per inconcontro<br>
           schema implementation = { @see TokenGam }</p>
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
    @Path("/token-gam-incontro")
    
    @Produces({ "application/json" })
    Response getTokenGamForIdIncontro( @NotNull @QueryParam("idIncontro") Long idIncontro, @QueryParam("codTipoRichiestaGam") String codTipoRichiestaGam,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce l'elenco in token gam per idservizio
     * description = restituisce i dati delle richieste ai servizi GAM in token gam
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = elenco in token gam per idservizio<br>
           schema implementation = { @see TokenGam }</p>
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
    @Path("/token-gam-servizio")
    
    @Produces({ "application/json" })
    Response getTokenGamForIdServizio( @NotNull @QueryParam("idServizio") Long idServizio, @QueryParam("codTipoRichiestaGam") String codTipoRichiestaGam,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Richiesta chiudere intervento
     * description = Richiama il Servizio GAM - GestInterscMaterie.nuovoIncontroSrvSerse per la richiesta di chiudere un intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione<br>
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
    @Path("/nuovo-incontro-serse")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response nuovoIncontroSerse( ServizioGamIncontro body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Richiesta Finanziamento Servizio
     * description = Richiamare il Servizio GAM - GestInterscMaterie.nuovoServizioSerse per la richiesta finanziamento Servizio
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione<br>
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
    @Path("/nuovo-servizio-serse")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response nuovoServizioSerse( ServizioGam body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Richiesta riapertura intervento chiuso
     * description = Richiama il Servizio GAM - GestInterscMaterie.RiapriIncontroDiServizio per la richiesta di riaprire un intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione<br>
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
    @Path("/riapri-incontro-serse")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response riapriIncontroSerse( ServizioGamIncontro body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = Richiesta riapertura servizio
     * description = Richiama il Servizio GAM - GestInterscMaterie.EliminaServizioIncontri per la richiesta di eliminare tutti gli incontri
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = risposta del successo dell'operazione<br>
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
    @Path("/riporta-servizio-in-definizione")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response riportaServizioInDefinizione( ServizioGamRiapriServizio body,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
