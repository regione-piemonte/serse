/**
 * 
 */
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

import static org.junit.jupiter.api.Assertions.*;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import it.csi.serse.serseweb.vo.ServizioModello;

/**
 * @author Admin
 *
 */
@EnabledIfEnvironmentVariable(
    named = "ENABLE_E2E_TEST",
    matches = ".+",
    disabledReason = "Test e2e disabilitati di default, richiedono il server localhost attivo"
)
class ServiziApiTest extends TestBaseClient{

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ServiziApi#deleteServiziModelloRegionale(java.util.List, java.lang.Integer, java.lang.String, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testDeleteServiziModelloRegionale() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetServizi = client.target(ENDPOINT_BASE+"/servizi/servizi-modello-regionali");
        Response resp= targetServizi.queryParam("idEnteCoinvoltoModello", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ServiziApi#deleteServizioEsterno(java.lang.Integer, java.lang.String, java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testDeleteServizioEsterno() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetServizi = client.target(ENDPOINT_BASE+"/servizi/servizio-modello-esterno");
        Response resp= targetServizi.queryParam("idModelloIntervento", 1).queryParam("idServizioModello", 1).queryParam("codUserAggiornamento", "cod").request().get();

        
        assertNotNull(resp);
        checkResponse(resp);
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ServiziApi#getServiziRegionaliForPso(java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetServiziRegionaliForPso() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetServizi = client.target(ENDPOINT_BASE+"/servizi/ervizi-regionali");
        Response resp= targetServizi.queryParam("idPso", 1).queryParam("idModelloIntervento", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ServiziApi#getServizioEsternoById(java.lang.Integer, java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetServizioEsternoById() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetServizi = client.target(ENDPOINT_BASE+"/servizi/ervizi-regionali");
        Response resp= targetServizi.queryParam("idModelloIntervento", 1).queryParam("idServizioModello", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ServiziApi#getTipologieServiziForModelloIntervento(java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetTipologieServiziForModelloIntervento() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetServizi = client.target(ENDPOINT_BASE+"/servizi/ervizi-regionali");
        Response resp= targetServizi.queryParam("idIntervento", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ServiziApi#insertServiziModelloRegionale(java.util.List, java.lang.Integer, java.lang.String, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testInsertServiziModelloRegionale() {
		DatiPerTest datiPerTest = new DatiPerTest();
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetServizi = client.target(ENDPOINT_BASE+"/servizi/servizi-regionali");
        
        Entity<ServizioModello> eServizioModello = Entity.json(datiPerTest.datiServizioModello());
        Response resp= targetServizi.queryParam("idModelloIntervento", 1).queryParam("codUserAggiornamento", "coduser").request().post(eServizioModello);
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.ServiziApi#updateServiziModelloRegionale(java.util.List, java.lang.Integer, java.lang.String, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testUpdateServiziModelloRegionale() {
		DatiPerTest datiPerTest = new DatiPerTest();
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetServizi = client.target(ENDPOINT_BASE+"/servizi/servizio-modello-esterno");
        
        Entity<ServizioModello> eServizioModello = Entity.json(datiPerTest.datiServizioModello());
        
        Response resp= targetServizi.queryParam("idModelloIntervento", 1).queryParam("codUserAggiornamento", "coduser").request().put(eServizioModello);
       
        assertNotNull(resp);
        checkResponse(resp);
	}

}
