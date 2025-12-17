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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;

import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;


@EnabledIfEnvironmentVariable(
    named = "ENABLE_E2E_TEST",
    matches = ".+",
    disabledReason = "Test e2e disabilitati di default, richiedono il server localhost attivo"
)
class EntiCoinvoltiApiTest extends TestBaseClient{
	
    Client client;

    @BeforeEach
    void setUp() {
        client = ClientBuilder.newBuilder().build();
        client.register(JacksonJsonProvider.class);
    }

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.EntitiCoinvoltiApi#getEnteCoinvoltoModelloForId(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetEnteCoinvoltoModelloForId() {
        WebTarget enteCoinvoltoModelloForId = client.target(ENDPOINT_BASE+"/enti-coinvolti/ente-coinvolto-modello");
        Response resp= enteCoinvoltoModelloForId.queryParam("idEnteCoinvoltoModello", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.EntitiCoinvoltiApi#getEntiCoinvoltiForModelloInterventoAndPso(java.lang.Long, java.lang.Long,javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetEntiCoinvoltiForModelloInterventoAndPso() {
        WebTarget enteCoinvoltoModello = client.target(ENDPOINT_BASE+"/enti-coinvolti/ente-coinvolto-modello");
        Response resp= enteCoinvoltoModello.queryParam("idEnteCoinvoltoModello", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.EntitiCoinvoltiApi#deleteEnteCoinvoltoModelloById(java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String,javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testDeleteEnteCoinvoltoModelloById() {
        WebTarget enteCoinvoltoModello = client.target(ENDPOINT_BASE+"/enti-coinvolti/ente-coinvolto-modello");
        Response resp= enteCoinvoltoModello.queryParam("idPso", 1).queryParam("idModelloIntervento", 1).queryParam("idEnteCoinvolto", 1).queryParam("codUserAggiornamento", "codice").request().delete();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.EntitiCoinvoltiApi#updateEnteCoinvoltoModello(EnteCoinvoltoModello, java.lang.String,javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testUpdateEnteCoinvoltoModello() {
		DatiPerTest datiPerTest = new DatiPerTest();
        WebTarget enteCoinvoltoModello = client.target(ENDPOINT_BASE+"/enti-coinvolti/ente-coinvolto-modello");
        
        EnteCoinvoltoModello enteCoinvolto = new EnteCoinvoltoModello();
        
        enteCoinvolto.setCodice1Soggetto("codice1");
        enteCoinvolto.setCodice2Soggetto("codice2");
        enteCoinvolto.setCodUserAggiorn("coduseragg");
        enteCoinvolto.setCodUserInserim("coduserim");
        enteCoinvolto.setComune(datiPerTest.datiComune());
        enteCoinvolto.setDAggiornam(new Date());
        enteCoinvolto.setDenominazione("denominazione");
        enteCoinvolto.setDenominazioneSedePrincipale("denominazioneSede");
        enteCoinvolto.setDInserim(new Date());
        enteCoinvolto.setIdEnteCoinvoltoModello(1l);
        enteCoinvolto.setIdFonteDato(1l);
        enteCoinvolto.setIdModelloDiIntervento(1l);
        enteCoinvolto.setIdPso(1l);
        enteCoinvolto.setIdRuoloEnte(1l);
        enteCoinvolto.setIndirizzo("indirizzo");
        enteCoinvolto.setReferente(datiPerTest.datiReferente());
        
        Entity<EnteCoinvoltoModello> eEnteCoinvolto = Entity.json(enteCoinvolto);
        
        Response resp = enteCoinvoltoModello.request().put(eEnteCoinvolto);
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.EntitiCoinvoltiApi#insertEnteCoinvoltoIntervento(EnteCoinvoltoIntervento, java.lang.String,javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testInsertEnteCoinvoltoIntervento() {
		DatiPerTest datiPerTest = new DatiPerTest();
        WebTarget enteCoinvoltoModello = client.target(ENDPOINT_BASE+"/enti-coinvolti/ente-coinvolto-intervento");
        
        EnteCoinvoltoIntervento enteCoinvoltoIntervento = new EnteCoinvoltoIntervento();
        
        enteCoinvoltoIntervento.setCodice1Soggetto("codice1");
        enteCoinvoltoIntervento.setCodice2Soggetto("codice2");
        enteCoinvoltoIntervento.setCodUserAggiorn("coduseragg");
        enteCoinvoltoIntervento.setCodUserInserim("coduserim");
        enteCoinvoltoIntervento.setComune(datiPerTest.datiComune());
        enteCoinvoltoIntervento.setDAggiornam(new Date());
        enteCoinvoltoIntervento.setDenominazione("denominazione");
        enteCoinvoltoIntervento.setDenominazioneSedePrincipale("denominazioneSede");
        enteCoinvoltoIntervento.setDInserim(new Date());
        enteCoinvoltoIntervento.setIdEnteCoinvoltoModello(1l);
        enteCoinvoltoIntervento.setIdFonteDato(1l);
        enteCoinvoltoIntervento.setIdIntervento(1l);
        enteCoinvoltoIntervento.setIdPso(1l);
        enteCoinvoltoIntervento.setIndirizzo("indirizzo");
        enteCoinvoltoIntervento.setReferente(datiPerTest.datiReferente());
        enteCoinvoltoIntervento.setIdEnteCoinvoltoIntervento(1l);
                
        Entity<EnteCoinvoltoIntervento> eEnteCoinvolto = Entity.json(enteCoinvoltoIntervento);
        
        Response resp = enteCoinvoltoModello.request().post(eEnteCoinvolto);
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.EntitiCoinvoltiApi#insertEnteCoinvoltoServizio(EnteCoinvoltoServizio, java.lang.String,javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testInsertEnteCoinvoltoServizio() {
		DatiPerTest datiPerTest = new DatiPerTest();
        WebTarget enteCoinvoltoModello = client.target(ENDPOINT_BASE+"/enti-coinvolti/ente-coinvolto-servizio");
        
        EnteCoinvoltoServizio enteCoinvoltoServizio = new EnteCoinvoltoServizio();
        
        enteCoinvoltoServizio.setCodice1Soggetto("codice1");
        enteCoinvoltoServizio.setCodice2Soggetto("codice2");
        enteCoinvoltoServizio.setCodUserAggiorn("coduseragg");
        enteCoinvoltoServizio.setCodUserInserim("coduserim");
        enteCoinvoltoServizio.setComune(datiPerTest.datiComune());
        enteCoinvoltoServizio.setDAggiornam(new Date());
        enteCoinvoltoServizio.setDenominazione("denominazione");
        enteCoinvoltoServizio.setDenominazioneSedePrincipale("denominazioneSede");
        enteCoinvoltoServizio.setDInserim(new Date());
        enteCoinvoltoServizio.setIdFonteDato(1l);
        enteCoinvoltoServizio.setIdPso(1l);
        enteCoinvoltoServizio.setIndirizzo("indirizzo");
        enteCoinvoltoServizio.setReferente(datiPerTest.datiReferente());
        enteCoinvoltoServizio.setIdEnteCoinvoltoIntervento(1l);
        enteCoinvoltoServizio.setIdEnteConvoltoServizio(1l);
        enteCoinvoltoServizio.setIdServizio(1l);
                
        Entity<EnteCoinvoltoServizio> eEnteCoinvolto = Entity.json(enteCoinvoltoServizio);
        
        Response resp = enteCoinvoltoModello.request().post(eEnteCoinvolto);
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
}
