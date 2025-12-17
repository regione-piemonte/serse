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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.AkOperatore;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.DettaglioPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.FlaianagpgAnagrafepg;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultDettaglioPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultElencoPG;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.FLAIANAG;

@Component
public class FlaianagpgHelper {
	
	static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".integration");
	
	@Autowired
    @Qualifier("flaianagpgAnagrafepg")
	private FlaianagpgAnagrafepg anagrafepgSrv;

	@Autowired
	CacheManager cacheManager;

	/**
	 * Ricerca operatori, filtrando per singolo gruppo/codice operatore
	 */
	@Cacheable("sintesiOperatore")
	public SintesiPersonaGiuridica getOperatore(String gruppoOperatore, Integer codiceOperatore) {
		List<AkOperatore> operatori = new ArrayList<>();
		AkOperatore operatore = new AkOperatore();
		operatore.setCodiceGruppoOperatore(gruppoOperatore);
		operatore.setCodiceOperatore(codiceOperatore);
		operatori.add(operatore);
		try {
			return getElencoPGGCO(operatori).get(0);
		} catch(NullPointerException|IndexOutOfBoundsException exc) {
			return null;
		}
	}

	public SintesiPersonaGiuridica searchInCache(String gruppoOperatore, Integer codiceOperatore) {
		Cache.ValueWrapper wrapper = cacheManager.getCache("sintesiOperatore").get(new SimpleKey(gruppoOperatore, codiceOperatore));
		if (wrapper != null)  {
			return (SintesiPersonaGiuridica) wrapper.get();
		}
		return null;
	}

	public void addToCache(String gruppoOperatore, Integer codiceOperatore, SintesiPersonaGiuridica value) {
		if (value != null) {
			cacheManager.getCache("sintesiOperatore").put(new SimpleKey(gruppoOperatore, codiceOperatore), value);
		}
	}

	/**
	 * Ricerca operatori con gruppo/codice in un elenco  dato.
	 * Anche se questo metodo non è annotato con Cacheable, utilizza internamente la Cache.
	 */
	protected List<SintesiPersonaGiuridica> getElencoPGGCO(List<AkOperatore> operatori) {
		List<SintesiPersonaGiuridica> result = new ArrayList<>();
		List<AkOperatore> missing = new ArrayList<>();

		// Prima cerco in cache
		for (AkOperatore op: operatori) {
			SintesiPersonaGiuridica value = searchInCache(op.getCodiceGruppoOperatore(), op.getCodiceOperatore());
			if (value != null) {
				result.add(value);
			} else {
				missing.add(op);
			}
		}

		// Chiamo il servizio solo per i mancanti, e li aggiungo alla cache
		if (!missing.isEmpty()) {
			ResultElencoPG elencoPG = null;
			try {
				elencoPG = anagrafepgSrv.getElencoPGGCO(FLAIANAG.COD_MATERIA_FP, operatori, null);
			} catch (Exception e) {
				throw new ErroreConnessioneServizioException(501, e.getMessage());
			}
			try {
				for(SintesiPersonaGiuridica op: elencoPG.getElencoPG().getItem()) {
					result.add(op);
					addToCache(op.getSintesiOperatore().getOperatore().getCodiceGruppoOperatore(),
						op.getSintesiOperatore().getOperatore().getCodiceOperatore(), op);
				}
			} catch(NullPointerException e) {
				// ok, non ci sono risultati
			}
		}

		return result;
	}

	/**
	 * Dettagli singolo operatore
	 */
	@Cacheable("dettaglioOperatore")
	public DettaglioPersonaGiuridica getDettaglioOperatore(String gruppoOperatore, Integer codiceOperatore){
		ResultDettaglioPersonaGiuridica result = null;
		try {

			AkOperatore operatore = new AkOperatore();
			operatore.setCodiceGruppoOperatore(gruppoOperatore);
			operatore.setCodiceOperatore(codiceOperatore.intValue());

			result = anagrafepgSrv.getDettaglioOperatore(FLAIANAG.COD_MATERIA_FP, operatore);
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}
		return result != null ? result.getDettaglioPersonaGiuridica() : null;
	}

	/**
	 * Ricerca operatori con filtri vari
	 */
	@Cacheable("elencoPG")
	public ResultElencoPG getElencoPG(String gruppoOperatore, String codOperatore, String denominazionePersonaGiuridica,
			String codiceFiscale, String partitaIva){
		try {
			return anagrafepgSrv.getElencoPG(FLAIANAG.COD_MATERIA_FP, denominazionePersonaGiuridica, 
					codiceFiscale, partitaIva, gruppoOperatore, null, codOperatore, null);
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}
	}

	/**
	 * Restituisce l'elenco degli operatori, cercandoli uno per uno prima in cache e poi eventualmente (solo i mancanti) da flaianag.
	 * @return una mappa con chiavi es. B6
	 */
	public Map<String, SintesiPersonaGiuridica> getDenominazioniOperatori(List<AkOperatore> operatori) {
		Map<String, SintesiPersonaGiuridica> result = new HashMap<>();
		List<SintesiPersonaGiuridica> response = getElencoPGGCO(operatori);
		for (SintesiPersonaGiuridica pg : response) {				
			String key = pg.getSintesiOperatore().getOperatore().getCodiceGruppoOperatore() + pg.getSintesiOperatore().getOperatore().getCodiceOperatore();
			result.put(key, pg);
		}
		return result;
	}
	
	public boolean testResources() throws Exception {
		return anagrafepgSrv.testResources();
	}
}
