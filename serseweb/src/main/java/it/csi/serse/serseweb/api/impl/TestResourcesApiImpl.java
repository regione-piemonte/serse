package it.csi.serse.serseweb.api.impl;

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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import it.csi.serse.serseweb.vo.TestVersione;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.TestResourcesApi;
import it.csi.serse.serseweb.api.manager.TestResourcesManager;
import it.csi.serse.serseweb.api.parent.ParentOverWebApi;
import it.csi.serse.serseweb.utils.Constants;

@Component
public class TestResourcesApiImpl extends ParentOverWebApi implements TestResourcesApi {

	@Autowired
	private TestResourcesManager testResourcesManager;

	@Value("${release.version.dev}")
	private String versioneDev;

	@Value("${release.version.test}")
	private String versioneTest;

	@Value("${release.version.prod}")
	private String versioneProd;
		
	private static Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".impl");
	
	
	@Override
	public Response testResources(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		LOG.info("TestResourcesApiImpl testResources");
		return testResourcesManager.testResources();
	}

	@Override
	public Response testVersione(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		TestVersione testVersione = new TestVersione();
		testVersione.setVersioneDev(versioneDev);
		testVersione.setVersioneTest(versioneTest);
		testVersione.setVersioneProd(versioneProd);
		return Response.ok(testVersione).build();
	}


}
