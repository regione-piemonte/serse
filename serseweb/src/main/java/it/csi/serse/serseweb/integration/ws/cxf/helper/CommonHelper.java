package it.csi.serse.serseweb.integration.ws.cxf.helper;

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

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.exception.InternalErrorException;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.AmmResponsabileDto;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.BudgetbilservCommon;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.SelItemDto;
import it.csi.serse.serseweb.utils.Constants;

@Component
public class CommonHelper {

	static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".integration");
	
	@Autowired
    @Qualifier("budgetbilservCommon")
	private BudgetbilservCommon commonSrv;

	public List<AmmResponsabileDto> searchAllAmministrazioniResponsabili(Long codAr) {

		try {
			return commonSrv.searchAllAmmResponsabili(codAr);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public List<SelItemDto> searchGestCicliFin(String flagCicloUnico) {
		try {
			return commonSrv.searchGestCicliFin(flagCicloUnico);
		} catch (

		Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public boolean testResources() throws Exception {

		return commonSrv.testResources();
	}

}
