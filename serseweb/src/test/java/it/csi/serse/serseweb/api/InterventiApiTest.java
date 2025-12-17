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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;


@EnabledIfEnvironmentVariable(
    named = "ENABLE_E2E_TEST",
    matches = ".+",
    disabledReason = "Test e2e disabilitati di default, richiedono il server localhost attivo"
)
class InterventiApiTest extends TestBaseClient{

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.InterventiApi#getInterventi(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.Integer, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	final void testGetInterventi() throws UnsupportedEncodingException {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget interventi = client.target(ENDPOINT_BASE+"/interventi");

		String filter = "{\"numProgrSportello\":{\"eq\":919},\"gruppoOperatore\":{\"eq\":\"B\"},\"codOperatore\":{\"eq\":6},\"codiceTipoIntervento\":{\"eq\":1},\"idStatoIntervento\":{\"eq\":1}}";
        Response resp= interventi
			.queryParam("filter", URLEncoder.encode(filter, "UTF-8"))
			.request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.InterventiApi#getTipologieInterventoForPso(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	final void testGetTipologieInterventoForPso() throws UnsupportedEncodingException {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget interventi = client.target(ENDPOINT_BASE+"/interventi");
        //Response resp= interventi.queryParam("idPso", 1).request().get();
       
		String filter = "{\"idPso\":{\"eq\":1}}";
        Response resp= interventi
			.queryParam("filter", URLEncoder.encode(filter, "UTF-8"))
			.request().get();

        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api.InterventiApi#deleteInterventoById(java.lang.Long, java.lang.Long,javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testDeleteInterventoById() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget interventi = client.target(ENDPOINT_BASE+"/interventi");
        Response resp = interventi.queryParam("idIntervento", 1).queryParam("idModelloIntervento", 1).request().delete();
       
        assertNotNull(resp);
        checkResponse(resp);
	}

}
