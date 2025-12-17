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

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.ClassificazioniDAO;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.Classificazione;
import it.csi.serse.serseweb.mapper.GenericMapper;

@Component
public class ClassificazioniManager extends ParentManager{
	@Autowired
	private GenericMapper genericMapper;
	
	@Autowired
	private ClassificazioniDAO classificazioniDao;
	
	
	public Response getClassificazioniForPsoServizioRegionale(Long idPso,  Long idServizioRegionale) {
		List<String> parametriMancanti = new ArrayList<>();

		if (idServizioRegionale == null) {
			parametriMancanti.add("idServizioRegionale");
		}
		if (idPso == null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		
		
		return Response.ok(genericMapper.mapListClassificazione(classificazioniDao.getClassificazioniForPsoServizioRegionale(idPso, idServizioRegionale))).build();
	}
	
	public List<Classificazione> getClassificazioniForServizio(Long idServizio) {
		
		return genericMapper.mapListClassificazione(classificazioniDao.getClassificazioniForServizio(idServizio));
		
	}
}
