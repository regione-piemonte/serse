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

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;

import it.csi.serse.serseweb.vo.TargetDestinatariAssociati;
import it.csi.serse.serseweb.vo.TargetDestinatariPerModifica;
import it.csi.serse.serseweb.vo.TargetDestinatario;


@EnabledIfEnvironmentVariable(
    named = "ENABLE_E2E_TEST",
    matches = ".+",
    disabledReason = "Test e2e disabilitati di default, richiedono il server localhost attivo"
)
class TargetDestinatariTest extends TestBaseClient{
	
    Client client;

    @BeforeEach
    void setUp() {
        client = ClientBuilder.newBuilder().build();
        client.register(JacksonJsonProvider.class);
    }

	/**
	 * Test method for {@link it.csi.serse.serseweb.api#getElencoTargetDestinatariForModello(java.lang.Long, java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetElencoTargetDestinatariForModello() {
        WebTarget targetDestinatarioAssociati = client.target(ENDPOINT_BASE+"/destinatari/target-destinatario-associati");
        Response resp = targetDestinatarioAssociati
            .queryParam("idPso", 1)
            .queryParam("idModelloIntervento", 3)
            .request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api#getElencoTargetDestinatariForPSO(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetElencoTargetDestinatariForPSO() {
        WebTarget targetDestinatari = client.target(ENDPOINT_BASE+"/destinatari/target-destinatari");
        Response resp= targetDestinatari.queryParam("idPso", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api#insertTargetDestinatarioForModello(TargetDestinatariPerModifica, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testInsertTargetDestinatarioForModello() {

        WebTarget target = client.target(ENDPOINT_BASE+"/destinatari/target-destinatario-associati");
        
        TargetDestinatariAssociati targetDestinatarioAssociati = new TargetDestinatariAssociati();
        TargetDestinatario targetDestinatario = new TargetDestinatario();
        
        targetDestinatarioAssociati.setCodiceFiscaleUtente("CF dal test");
        targetDestinatarioAssociati.setIdModelloDiIntervento(4l);
        targetDestinatarioAssociati.setIdPso(1l);
        
        targetDestinatario.setIdTargetDestinatario(1l);
        targetDestinatario.setDescrDestinatario("Target Test");
        
        targetDestinatarioAssociati.setTargetdestinatario(targetDestinatario);
        
        Entity<List<TargetDestinatariAssociati>> eTargetDestinatari =  Entity.json(List.of(targetDestinatarioAssociati));
        
        Response resp= target.request().post(eTargetDestinatari);
        
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api#deleteTargetDestinatarioForModello(TargetDestinatariPerModifica, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testDeleteTargetDestinatarioForModello() {
        
        TargetDestinatariAssociati targetDestinatarioAssociati = new TargetDestinatariAssociati();
        TargetDestinatario targetDestinatario = new TargetDestinatario();
        
        targetDestinatarioAssociati.setCodiceFiscaleUtente("CF dal test");
        targetDestinatarioAssociati.setIdModelloDiIntervento(4l);
        targetDestinatarioAssociati.setIdPso(1l);
        
        targetDestinatario.setIdTargetDestinatario(1l);
        targetDestinatario.setDescrDestinatario("Target Test");
        
        targetDestinatarioAssociati.setTargetdestinatario(targetDestinatario);
        
        Entity<TargetDestinatariAssociati> eTargetDestinatari =  Entity.json(targetDestinatarioAssociati);
        WebTarget target = client.target(ENDPOINT_BASE+"/destinatari/target-destinatario-associati");
        
        Response resp= target.request().delete();
        
        checkResponse(resp);
	}
	
	
}
