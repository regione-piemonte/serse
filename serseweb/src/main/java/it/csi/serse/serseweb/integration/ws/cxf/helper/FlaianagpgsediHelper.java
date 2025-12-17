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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.AkOperatore;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.FlaianagpgAnagrafesedipg;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.ResultElencoSedi;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.SintesiSede;
import it.csi.serse.serseweb.api.exception.InternalErrorException;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.FLAIANAG;

@Component
public class FlaianagpgsediHelper {
	
	static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".integration");
	
	@Autowired
    @Qualifier("flaianagpgAnagrafesedipg")
	private FlaianagpgAnagrafesedipg flaianagpgAnagrafesedipg;

	/**
	 * Invoca il servizio flaianag
	 * 
	 * @param gruppoOp
	 * @param codOp
	 * @param codProvincia
	 * @param codComune
	 * @param codiceBacino
	 * @return
	 */
	@Cacheable("elencoSediOperatore")
	public List<SintesiSede> getElencoSediOperatore(String gruppoOp, Integer codOp, String codProvincia, String codComune, Integer codiceBacino){

		AkOperatore akOperatore = new AkOperatore();
		akOperatore.setCodiceGruppoOperatore(gruppoOp);
		akOperatore.setCodiceOperatore(codOp);

		ResultElencoSedi elencoSedi = null;
		try {
			elencoSedi = flaianagpgAnagrafesedipg.getElencoSediOperatore(FLAIANAG.COD_MATERIA_FP, akOperatore, codProvincia, codComune, codiceBacino);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}

		List<SintesiSede> elencoSediList;
		try {
			elencoSediList = elencoSedi.getElencoSedi().getItem();
		} catch(NullPointerException e) {
			elencoSediList = new ArrayList<>();
		}
		return elencoSediList;
	}

	public boolean testResources() throws Exception {
		return flaianagpgAnagrafesedipg.testResources();
	}
}
