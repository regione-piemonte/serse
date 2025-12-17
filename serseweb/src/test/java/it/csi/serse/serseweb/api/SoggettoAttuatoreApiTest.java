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
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

/**
 * @author admin
 *
 */
@EnabledIfEnvironmentVariable(
    named = "ENABLE_E2E_TEST",
    matches = ".+",
    disabledReason = "Test e2e disabilitati di default, richiedono il server localhost attivo"
)
class SoggettoAttuatoreApiTest extends TestBaseClient{

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.SoggettoAttuatoreApi#getIstanzeCandidatura(java.lang.Long, java.lang.Long, java.lang.String, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetIstanzeCandidatura() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetSoggettoAttuatore = client.target(ENDPOINT_BASE+"/soggetto-attuatore/istanze-candidatura");
        Response resp= targetSoggettoAttuatore.queryParam("numProgrSportello", 1).queryParam("codOperatore", 1).queryParam("gruppoOperatore", "gope").request().get();

        
        assertNotNull(resp);
        checkResponse(resp);
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.SoggettoAttuatoreApi#getIstanzeCandidaturaForIntervento(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetIstanzeCandidaturaForIntervento() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetSoggettoAttuatore = client.target(ENDPOINT_BASE+"/soggetto-attuatore/istanze-candidatura-per-intervento");
        Response resp= targetSoggettoAttuatore.queryParam("idIntervento", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.SoggettoAttuatoreApi#getSoggettiBeneficiari(java.lang.Integer, java.lang.Integer, java.lang.String, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetSoggettiBeneficiari() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetSoggettoAttuatore = client.target(ENDPOINT_BASE+"/soggetto-attuatore/soggetti-beneficiari");
        Response resp= targetSoggettoAttuatore.queryParam("numProgrSportello", 1).queryParam("codOperatore", 1).queryParam("gruppoOperatore", "grOp").request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.SoggettoAttuatoreApi#getSoggettoAttuatoreForId(java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetSoggettoAttuatoreForId() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetSoggettoAttuatore = client.target(ENDPOINT_BASE+"/soggetto-attuatore");
        Response resp= targetSoggettoAttuatore.queryParam("idSoggettoAttuatore", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.SoggettoAttuatoreApi#getSoggettoBeneficiario(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetSoggettoBeneficiario() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetSoggettoAttuatore = client.target(ENDPOINT_BASE+"/soggetto-attuatore/soggetto-beneficiario");
        Response resp= targetSoggettoAttuatore.queryParam("idSoggettoAttuatore", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.SoggettoAttuatoreApi#getSoggettoBeneficiarioAssociatoIntervento(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetSoggettoBeneficiarioAssociatoIntervento() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetSoggettoAttuatore = client.target(ENDPOINT_BASE+"/soggetto-attuatore/soggetto-beneficiario/intervento-associato");
        Response resp= targetSoggettoAttuatore.queryParam("idIntervento", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.SoggettoAttuatoreApi#getSoggettoBeneficiarioAssociatoModello(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	void testGetSoggettoBeneficiarioAssociatoModello() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget targetSoggettoAttuatore = client.target(ENDPOINT_BASE+"/soggetto-attuatore/soggetto-beneficiario/modello-intervento-associato");
        Response resp= targetSoggettoAttuatore.queryParam("idModelloIntervento", 400).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}

}
