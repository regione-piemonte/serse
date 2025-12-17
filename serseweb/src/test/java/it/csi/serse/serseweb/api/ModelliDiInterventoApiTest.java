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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;

import it.csi.serse.serseweb.vo.ModelloIntervento;
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
class ModelliDiInterventoApiTest extends TestBaseClient{
	
    Client client;

    @BeforeEach
    void setUp() {
        client = ClientBuilder.newBuilder().build();
        client.register(JacksonJsonProvider.class);
    }

	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ModelliDiInterventoApi#deleteModelloInterventoById(java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */

	@Test
	void testDeleteModelloInterventoById() {
        WebTarget modelliIntervento = client.target(ENDPOINT_BASE+"/modelli-di-intervento");
        Response resp= modelliIntervento.queryParam("idModelloIntervento", 1).request().delete();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ModelliDiInterventoApi#getModelliIntervento(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */

	@Test
	void testGetModelliIntervento() {
        WebTarget modelliIntervento = client.target(ENDPOINT_BASE+"/modelli-di-intervento");
        Response resp= modelliIntervento.queryParam("numProgrSportello", 1).queryParam("gruppoOperatore", "gOperatore").queryParam("codOperatore", 1).queryParam("codiceTipoIntervento", 1).queryParam("idStatoIntervento", 1).queryParam("idIntervento", 1).queryParam("modelId", 1).queryParam("idServizioRegionale", 1).queryParam("enteCoinvoltoIntervento", "ente123").queryParam("idSoggettoAttuatore", 1).request().get();

        
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ModelliDiInterventoApi#getModelloDiInterventoById(java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	
	@Test
	void testGetModelloDiInterventoById() {
        WebTarget modelliIntervento = client.target(ENDPOINT_BASE+"/modelli-di-intervento");
        Response resp= modelliIntervento.queryParam("idModelloIntervento", 400).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ModelliDiInterventoApi#getStatiModelliIntervento(javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	
	@Test
	void testGetStatiModelliIntervento() {
        WebTarget modelliIntervento = client.target(ENDPOINT_BASE+"/modelli-di-intervento");
        Response resp= modelliIntervento.queryParam("idModelloIntervento",1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ModelliDiInterventoApi#insertModelloIntervento(javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	
	@Test
	void testInsertModelloIntervento() {
		DatiPerTest datiPerTest = new DatiPerTest();
        WebTarget modelliIntervento = client.target(ENDPOINT_BASE+"/modelli-di-intervento");
        
       
        
        Entity<ModelloIntervento> eModelloIntervento = Entity.json(datiPerTest.datiModelloIntervento());
        
        Response resp= modelliIntervento.request().post(eModelloIntervento);
       
        assertNotNull(resp);
        checkResponse(resp);

	}
	
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ModelliDiInterventoApi#updateModelloIntervento(javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	
	@Test
	void testUpdateModelloIntervento() {
		DatiPerTest datiPerTest = new DatiPerTest();
        WebTarget modelliIntervento = client.target(ENDPOINT_BASE+"/modelli-di-intervento");
        Entity<ModelloIntervento> eModelloIntervento = Entity.json(datiPerTest.datiModelloIntervento());
        
        Response resp= modelliIntervento.request().put(eModelloIntervento);
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ModelliDiInterventoApi#verificaCampiModelloIntervento(javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	
	@Test
	void testVerificaCampiModelloIntervento() {
        WebTarget modelliIntervento = client.target(ENDPOINT_BASE+"/modelli-di-intervento/test-modifica");
        
        
        Response resp= modelliIntervento.request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}

}
