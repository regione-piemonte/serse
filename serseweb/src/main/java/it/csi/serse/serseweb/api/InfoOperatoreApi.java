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


import java.math.BigDecimal;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.InfoOperatore;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.SedeOperatore;

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
@Path("/info-operatore")


public interface InfoOperatoreApi  {
   
    /**
     * summary = ricerca sedi da flaiAnag
     * description = informazioni sedi dell'operatore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = successo<br>
           schema implementation = { @see SedeOperatore }</p>
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
    @Path("/elenco-sedi-autorizzati")
    
    @Produces({ "application/json" })
    Response getElencoSediAutorizzati( @QueryParam("idSoggettoAttuatore") Long idSoggettoAttuatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ricerca sedi da flaiAnag
     * description = informazioni sedi dell'operatore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = successo<br>
           schema implementation = { @see SedeOperatore }</p>
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
    @Path("/elenco-sedi-autorizzati-codgruppo")
    
    @Produces({ "application/json" })
    Response getElencoSediAutorizzatiCodGruppo( @QueryParam("numProgrSportello") Long numProgrSportello, @QueryParam("codOperatore") Long codOperatore, @QueryParam("gruppoOperatore") String gruppoOperatore, @QueryParam("modelId") Long modelId,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ricerca sedi da flaiAnag
     * description = informazioni sedi dell'operatore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = successo<br>
           schema implementation = { @see SedeOperatore }</p>
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
    @Path("/elenco-sedi")
    
    @Produces({ "application/json" })
    Response getElencoSediForOperatore( @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore, @NotNull @QueryParam("codOperatore") BigDecimal codOperatore, @QueryParam("codiceIstatComune") String codiceIstatComune, @QueryParam("codiceProvincia") String codiceProvincia,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = informazioni operatori per ruolo indicato
     * description = restituisce un elenco di operatori in base al ruolo scelto
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = successo<br>
           schema implementation = { @see InfoOperatore }</p>
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
    Response getInfoOperatoreForRuolo( @NotNull @QueryParam("codRuolo") String codRuolo,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ricerca operatore da flaiAnag
     * description = informazioni ruolo Servizio Assistenza SERSE
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = trovato operatore<br>
           schema implementation = { @see PersonaGiuridica }</p>
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
    @Path("/persona-giuridica")
    
    @Produces({ "application/json", "text/plain" })
    Response getPersonaGiuridicaForRuolo( @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore, @NotNull @QueryParam("codOperatore") BigDecimal codOperatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = ricerca operatore da flaiAnag
     * description = ricerca delle informazioni di uno o più operatori, se l'elenco restituito supera i 100 elementi restituisco errore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = successo<br>
           schema implementation = { @see SedeOperatore }</p>
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
    @Path("/ricerca-operatore")
    
    @Produces({ "application/json" })
    Response ricercaOperatore( @QueryParam("gruppoOperatore") String gruppoOperatore, @QueryParam("codOperatore") String codOperatore, @QueryParam("denominazionePersonaGiuridica") String denominazionePersonaGiuridica, @QueryParam("codiceFiscale") String codiceFiscale, @QueryParam("partitaIva") String partitaIva,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
