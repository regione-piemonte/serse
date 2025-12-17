package it.csi.serse.serseapi.api.manager;

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

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseapi.integration.mybatis.dao.custom.ParentDAO;
import it.csi.serse.serseapi.utils.Constants;

@Component
public class TestResourcesSerseManager extends ParentManager {

	private static final Logger logger = LoggerFactory.getLogger(Constants.COD_COMPONENTE + ".manager");

	@Autowired
	private ParentDAO parentDAO;

	public boolean testResources() {

		logger.info("TestResourcesManager testResources");
		try {
			Date now=parentDAO.getNow();
			logger.info("TestResourcesManager testResources date:"+now);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
