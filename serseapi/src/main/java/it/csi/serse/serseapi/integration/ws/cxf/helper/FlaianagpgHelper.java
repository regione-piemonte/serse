package it.csi.serse.serseapi.integration.ws.cxf.helper;

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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.csi.serse.serseapi.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.AkOperatore;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.DettaglioPersonaGiuridica;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.FlaianagpgAnagrafepg;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultDettaglioPersonaGiuridica;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultElencoPG;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseapi.utils.Constants;
import it.csi.serse.serseapi.utils.Constants.FLAIANAG;

@Component
public class FlaianagpgHelper {

	static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".integration");

	@Autowired
	@Qualifier("flaianagpgAnagrafepg")
	private FlaianagpgAnagrafepg anagrafepgSrv;

	public List<SintesiPersonaGiuridica> getElencoPGGCO(String gruppoOperatore, Integer codiceOperatore) {
		List<AkOperatore> operatori = new ArrayList<>();
		AkOperatore operatore = new AkOperatore();
		operatore.setCodiceGruppoOperatore(gruppoOperatore);
		operatore.setCodiceOperatore(codiceOperatore);
		operatori.add(operatore);
		return getElencoPGGCO(operatori);
	}

	public List<SintesiPersonaGiuridica> getElencoPGGCO(List<AkOperatore> operatori) {
		ResultElencoPG elencoPG = null;
		try {
			elencoPG = anagrafepgSrv.getElencoPGGCO(FLAIANAG.COD_MATERIA_FP, operatori, null);
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}
		try {
			return elencoPG.getElencoPG().getItem();
		} catch(NullPointerException e) {
			return new ArrayList<>();
		}
	}

	public DettaglioPersonaGiuridica getDettaglioOperatore(String gruppoOperatore, BigDecimal codiceOperatore) {
		ResultDettaglioPersonaGiuridica result = null;
		try {

			AkOperatore operatore = new AkOperatore();
			operatore.setCodiceGruppoOperatore(gruppoOperatore);
			operatore.setCodiceOperatore(codiceOperatore.intValue());

			result = anagrafepgSrv.getDettaglioOperatore(FLAIANAG.COD_MATERIA_FP, operatore);
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}

		try {
			return result.getDettaglioPersonaGiuridica();
		} catch (NullPointerException e) {
			return null;
		}
	}

	public boolean testResources() throws Exception {
		return anagrafepgSrv.testResources();
	}

	public ResultElencoPG getElencoPG(String gruppoOperatore, String codOperatore, String denominazionePersonaGiuridica,
			String codiceFiscale, String partitaIva) {
		try {
			return anagrafepgSrv.getElencoPG("FP", denominazionePersonaGiuridica,
					codiceFiscale, partitaIva, gruppoOperatore, null, codOperatore, null);
		} catch (Exception e) {

			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}

	}
}
