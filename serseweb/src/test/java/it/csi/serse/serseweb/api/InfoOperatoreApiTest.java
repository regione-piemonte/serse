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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

/**
 * @author parci
 *
 */
@EnabledIfEnvironmentVariable(
    named = "ENABLE_E2E_TEST",
    matches = ".+",
    disabledReason = "Test e2e disabilitati di default, richiedono il server localhost attivo"
)
class InfoOperatoreApiTest extends TestBaseClient{

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.InfoOperatoreApi#getInfoOperatoreForRuolo(java.lang.String, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetInfoOperatoreForRuolo() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget infoOperatore = client.target(ENDPOINT_BASE+"/info-operatore");
        Response resp= infoOperatore.queryParam("codRuolo", "c123").request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.InfoOperatoreApi#getPersonaGiuridicaForRuolo(java.lang.String, java.math.BigDecimal, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetPersonaGiuridicaForRuolo() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget infoOperatore = client.target(ENDPOINT_BASE+"/info-operatore/persona-giuridica");
        Response resp= infoOperatore.queryParam("gruppoOperatore", "gO123").queryParam("codOperatore", 1.23).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.InfoOperatoreApi#getElencoSediForOperatore(java.lang.String, java.math.BigDecimal, java.lang.String, java.lang.String, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetElencoSediForOperatore() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget infoOperatore = client.target(ENDPOINT_BASE+"/info-operatore/elenco-sedi");
        Response resp= infoOperatore.queryParam("gruppoOperatore", "gO123").queryParam("codOperatore", 1.23).queryParam("codiceIstatComune", "ci123").queryParam("codiceProvincia", "cp234").request().get();

        
        assertNotNull(resp);
        checkResponse(resp);
	}

	@Test
	final void testRicercaOperatore() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget infoOperatore = client.target(ENDPOINT_BASE+"/info-operatore/ricerca-operatore");
        Response resp = infoOperatore
			.queryParam("gruppoOperatore", "B")
			.queryParam("codOperatore", 1)
			.request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	
	}
}
