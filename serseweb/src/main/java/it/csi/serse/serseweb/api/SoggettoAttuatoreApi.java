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


import it.csi.serse.serseweb.vo.AreaTerritoriale;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;

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
@Path("/soggetto-attuatore")


public interface SoggettoAttuatoreApi  {
   
    /**
     * summary = elenco di aree territoriali di finanziamento del soggetto attuatore responsabile del servizio
     * description = restituisce l'elendo di aree territoriali di finanziamento del soggetto attuatore responsabile del servizio pasando come dati gruppo_operatore, cod_operatore e model_id
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce l'elenco di aree territoriali<br>
           schema implementation = { @see AreaTerritoriale }</p>
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
    @Path("/aree-territoriali-di-finanziamento")
    
    @Produces({ "application/json" })
    Response getAreeTerritorialiDiFinanziamento( @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore, @NotNull @QueryParam("codOperatore") Long codOperatore, @NotNull @QueryParam("modelId") Integer modelId,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco di aree territoriali di finanziamento del soggetto attuatore responsabile del servizio
     * description = restituisce l'elendo di aree territoriali di finanziamento del soggetto attuatore responsabile del servizio pasando come dati gruppo_operatore, cod_operatore e num_progr_sportello
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce l'elenco di aree territoriali<br>
           schema implementation = { @see AreaTerritoriale }</p>
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
    @Path("/aree-territoriali-di-finanziamento/da-sportello")
    
    @Produces({ "application/json" })
    Response getAreeTerritorialiDiFinanziamentoV2( @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore, @NotNull @QueryParam("codOperatore") Long codOperatore, @NotNull @QueryParam("numProgrSportello") Long numProgrSportello,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce i model_id legati al soggetto attuatore corrente
     * description = restituisce un elenco distinto di model_id, cod_operatore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce i l'elenco di modelId<br>
           schema implementation = { @see SoggettoAttuatore }</p>
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
    @Path("/istanze-candidatura")
    
    @Produces({ "application/json" })
    Response getIstanzeCandidatura( @NotNull @QueryParam("numProgrSportello") Long numProgrSportello, @NotNull @QueryParam("codOperatore") Long codOperatore, @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce i model_id correlati ad interventi legati al soggetto attuatore corrente
     * description = restituisce un elenco distinto di model_id, cod_operatore legati ad un intervento
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce l'elenco di modelId<br>
           schema implementation = { @see SoggettoAttuatore }</p>
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
    @Path("/istanze-candidatura-per-intervento")
    
    @Produces({ "application/json" })
    Response getIstanzeCandidaturaForIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce i model_id legati al soggetto attuatore corrente legati al codice area territoriale selezionato
     * description = restituisce un elenco distinto di model_id, cod_operatore legati al soggetto attuatore corrente legati al codice area territoriale selezionato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce i l'elenco di modelId<br>
           schema implementation = { @see SoggettoAttuatore }</p>
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
    @Path("/istanze-candidatura/da-area-territoriale")
    
    @Produces({ "application/json" })
    Response getIstanzeCandidaturaPerCodAreaTerritoriale( @NotNull @QueryParam("codAreaTerritoriale") String codAreaTerritoriale,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = elenco di soggetti attuatori
     * description = restituisce la lista di soggetti attuatori
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce i l'elenco soggetti attuatori<br>
           schema implementation = { @see SoggettoAttuatore }</p>
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
    @Path("/soggetti-attuatori")
    
    @Produces({ "application/json" })
    Response getSoggettiAttuatori( @QueryParam("numProgrSportello") Long numProgrSportello, @QueryParam("codOperatore") Long codOperatore, @QueryParam("gruppoOperatore") String gruppoOperatore, @QueryParam("modelId") Long modelId,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce un elenco delle descrizioni delle persone giuridiche
     * description = restituisce un elenco di soggetti beneficiari(denominazioni persone giuridiche) dei modelli di intervento a cui il soggetto attuatore è collegato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce i l'elenco di modelId<br>
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
    @Path("/soggetti-beneficiari")
    
    @Produces({ "application/json" })
    Response getSoggettiBeneficiari( @NotNull @QueryParam("numProgrSportello") Integer numProgrSportello, @NotNull @QueryParam("codOperatore") Integer codOperatore, @NotNull @QueryParam("gruppoOperatore") String gruppoOperatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = dati soggetto attuatore competente
     * description = restituisce la denominazione giuridica del soggetto attuatore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce i l'elenco di modelId<br>
           schema implementation = { @see SoggettoAttuatore }</p>
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
    Response getSoggettoAttuatoreForId( @NotNull @QueryParam("idSoggettoAttuatore") Integer idSoggettoAttuatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce il soggetto bebeficiario legato al soggetto attuatore selezionato
     * description = restituisce il soggetto bebeficiario legato al soggetto attuatore
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce il soggetto bebeficiario legato al soggetto attuatore<br>
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
    @Path("/soggetto-beneficiario")
    
    @Produces({ "application/json" })
    Response getSoggettoBeneficiario( @NotNull @QueryParam("idSoggettoAttuatore") Long idSoggettoAttuatore,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce il soggetto bebeficiario legato al soggetto attuatore
     * description = restituisce il soggetto bebeficiario capofila legato all'intervento associato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce il soggetto bebeficiario legato al soggetto attuatore<br>
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
    @Path("/soggetto-beneficiario/intervento-associato")
    
    @Produces({ "application/json" })
    Response getSoggettoBeneficiarioAssociatoIntervento( @NotNull @QueryParam("idIntervento") Long idIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    /**
     * summary = restituisce il soggetto beneficiario capofila
     * description = restituisce il soggetto bebeficiario capofila legato al modello di intervento associato
     * @return Response
     * responses: 
       <ul>
         <li>    
           <p>responseCode = 200, description = restituisce il soggetto bebeficiario legato al soggetto attuatore<br>
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
    @Path("/soggetto-beneficiario/modello-intervento-associato")
    
    @Produces({ "application/json" })
    Response getSoggettoBeneficiarioAssociatoModello( @NotNull @QueryParam("idModelloIntervento") Long idModelloIntervento,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
