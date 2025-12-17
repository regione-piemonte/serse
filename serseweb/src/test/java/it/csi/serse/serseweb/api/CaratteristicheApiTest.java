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

import java.util.ArrayList;
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

import it.csi.serse.serseweb.vo.CaratteristicheAssociate;
import it.csi.serse.serseweb.vo.TargetDestinatariPerModifica;
import it.csi.serse.serseweb.vo.Caratteristica;


@EnabledIfEnvironmentVariable(
    named = "ENABLE_E2E_TEST",
    matches = ".+",
    disabledReason = "Test e2e disabilitati di default, richiedono il server localhost attivo"
)
class CaratteristicheApiTest extends TestBaseClient {
	
    Client client;

    @BeforeEach
    void setUp() {
        client = ClientBuilder.newBuilder().build();
        client.register(JacksonJsonProvider.class);
    }

	/**
	 * Test method for {@link it.csi.serse.serseweb.api#getCaratteristicheForModello(java.lang.Long, java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetCaratteristicheForModello() {
        WebTarget caratteristicheAssociati = client.target(ENDPOINT_BASE+"/caratteristiche/caratteristiche-associate");
        Response resp= caratteristicheAssociati.queryParam("idPso", 1).queryParam("idModelloIntervento", 3).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api#getCaratteristicheForPso(java.lang.Long, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testGetCaratteristicheForPso() {
        WebTarget caratteristicheAssociati = client.target(ENDPOINT_BASE+"/caratteristiche/caratteristiche-per-pso");
        Response resp= caratteristicheAssociati.queryParam("idPso", 1).request().get();
       
        assertNotNull(resp);
        checkResponse(resp);
	}
	
	/**
	 * Test method for {@link it.csi.serse.serseweb.api#updateElencoTargetDestinatarioForModello(TargetDestinatariPerModifica, javax.ws.rs.core.SecurityContext, javax.ws.rs.core.HttpHeaders, javax.servlet.http.HttpServletRequest)}.
	 */
	@Test
	final void testInsertCaratteristicheForModello() {
        WebTarget target = client.target(ENDPOINT_BASE+"/caratteristiche/caratteristiche-associate");
        
        CaratteristicheAssociate targetCaratteristicheAssociate = new CaratteristicheAssociate();
        Caratteristica targetCaratteristica = new Caratteristica();
        
        targetCaratteristicheAssociate.setCodiceFiscaleUtente("CF dal test");
        targetCaratteristicheAssociate.setIdModelloDiIntervento(4l);
        targetCaratteristicheAssociate.setIdPso(1l);
        
        targetCaratteristica.setIdCaratteristica(3l);
        targetCaratteristica.setDescrCaratteristica("Target Test");
        
        targetCaratteristicheAssociate.setCaratteristica(targetCaratteristica);
        
        List<CaratteristicheAssociate> listaCaratteristicheAssociate  = new ArrayList<>();
        listaCaratteristicheAssociate.add(targetCaratteristicheAssociate);
        
        Entity<List<CaratteristicheAssociate>> eCaratteristicheAssociate =  Entity.json(listaCaratteristicheAssociate);
                
        Response resp= target.request().post(eCaratteristicheAssociate);

        assertNotNull(resp);
        checkResponse(resp);
	}
	
	@Test
	final void testDeleteCaratteristicheForModello() {
		CaratteristicheAssociate targetCaratteristicheAssociate = new CaratteristicheAssociate();
        Caratteristica targetCaratteristica = new Caratteristica();
        
        targetCaratteristicheAssociate.setCodiceFiscaleUtente("CF dal test");
        targetCaratteristicheAssociate.setIdModelloDiIntervento(4l);
        targetCaratteristicheAssociate.setIdPso(1l);
        
        targetCaratteristica.setIdCaratteristica(3l);
        targetCaratteristica.setDescrCaratteristica("Target Test");
        
        targetCaratteristicheAssociate.setCaratteristica(targetCaratteristica);
        
        Entity<CaratteristicheAssociate> eTargetDestinatari =  Entity.json(targetCaratteristicheAssociate);
        
        WebTarget target = client.target(ENDPOINT_BASE+"/caratteristiche/caratteristiche-associate");
        
        Response resp= target.request().delete();
        
        checkResponse(resp);
	}

}
