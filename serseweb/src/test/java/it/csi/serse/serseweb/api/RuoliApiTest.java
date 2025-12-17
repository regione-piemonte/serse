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
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.Identita;
import it.csi.serse.serseweb.utils.Constants;
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
class RuoliApiTest extends TestBaseClient {

	/**
	 * Test method for {@link it.csi.serse.serseweb.api.RuoliApi#getRuoli(javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetRuoli() {
		Client client = ClientBuilder.newBuilder().build();
        WebTarget pspForTipologia = client.target(ENDPOINT_BASE+"/ruoli");
        
		Identita utenteCollegato = new Identita();
		utenteCollegato.setCognome("Rossi");
		utenteCollegato.setNome("Mario");
		utenteCollegato.setCodFiscale("RSSMRA80A01H501Z");

		Response resp = pspForTipologia
			.request()
			.header(Constants.IRIDE_ATTRIBUTES.ID_REQ_ATTR, utenteCollegato)
			.get();
        
        assertNotNull(resp);
        checkResponse(resp);
	}

}
