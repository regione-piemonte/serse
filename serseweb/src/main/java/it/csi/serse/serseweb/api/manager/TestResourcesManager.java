/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.serse.serseweb.api.manager;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.ParentDAO;
import it.csi.serse.serseweb.integration.ws.cxf.helper.CommonHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgsediHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.OperscambHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.SecurityHelper;
import it.csi.serse.serseweb.vo.TestResource;
import jakarta.ws.rs.core.Response;

@Component
public class TestResourcesManager extends ParentManager{
		
	@Autowired
	private ParentDAO parentDAO;
	
	@Autowired
	private CommonHelper commonHelper;
	
	@Autowired
	private FlaianagpgHelper flaianagpgHelper;
	
	@Autowired
	private SecurityHelper securityHelper;
	
	@Autowired
	private FlaianagpgsediHelper flaianagpgsediHelper;
	
	@Autowired
	private OperscambHelper operscambHelper;
	
	
	public Response testResources() {
		
		LOG.info("TestResourcesManager testResources");
		
		TestResource test=new TestResource();
		
		/*
		 * Verifico che si riesca ad agganciare il servizio di BudgetbilservCommon
		 */
		try {
			test.setOperservOperscamb(operscambHelper.testResources());
		}catch (Exception e) {
			test.setOperservOperscamb(false);
		}
		
		/*
		 * Verifico che si riesca ad agganciare il servizio di OperscambHelper
		 */
		try {
			test.setBudgetbilservCommon(commonHelper.testResources());
		}catch (Exception e) {
			test.setBudgetbilservCommon(false);
		}
		
		/*
		 * Verifico che si riesca ad agganciare il servizio di FlaianagpgAnagrafepg
		 */
		try {
			test.setFlaianagpgAnagrafepg(flaianagpgHelper.testResources());
		}catch (Exception e) {
			test.setFlaianagpgAnagrafepg(false);
		}
		
		/*
		 * Verifico che si riesca ad agganciare il servizio di FlaianagpgAnagrafesedipg
		 */
		try {
			test.setFlaianagpgAnagrafesedipg(flaianagpgsediHelper.testResources());
		}catch (Exception e) {
			test.setFlaianagpgAnagrafesedipg(false);
		}
		
		/*
		 * Verifico che si riesca ad agganciare il servizio di OrchflaiFlaidoorsrv
		 */
		try {
			test.setOrchflaiFlaidoorsrv(securityHelper.testResources());
		}catch (Exception e) {
			test.setOrchflaiFlaidoorsrv(false);
		}
		
		/*
		 * Verifico che si riesca ad eseguire una query sul db
		 */
		try {
			parentDAO.getNow();
			test.setDb(true);
		}catch (Exception e) {
			test.setDb(false);
		}
		
		return Response.ok(test).build();
		
	}
}