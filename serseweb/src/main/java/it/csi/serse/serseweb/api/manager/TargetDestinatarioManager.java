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
import java.util.Date;
import java.util.List;

import jakarta.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.TargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRModelloInterventoPsoTargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTModelloDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoSelector;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.TargetDestinatariPerModifica;
import it.csi.serse.serseweb.vo.TargetDestinatarioFlaggato;

@Component
public class TargetDestinatarioManager extends ParentManager{
	
	@Autowired
	TargetDestinatarioDAO targetDAO;
	
	@Autowired
	SerseRModelloInterventoPsoTargetDestinatarioDAO modelloPsoTargetDAO;
	
	@Autowired
	SerseTModelloDiInterventoDAO modelloDiInterventoDAO;
	
	/*
	 * FPL-SERSE-MOD-CDU-002-V01-  Gestione Target Destinatari Modello
	 */
	
	
	/*
	 * Algoritmo <elenco Td associati>
	 * Torna l'elenco dei target destinatari associati al modello di intervento e idPso 
	 * nella Tabella serse_r_modello_intervento_pso_target_destinatario
	 
	 * dati necesari: idPso, idModelloDiIntervento
	 
	 * dati da restituire:
	 * idTargetDestinatario  
	 * descrDestinatario
	 */
	public Response getElencoTargetDestinatariForModello(Long idPso, Long idModelloDiIntervento) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}
		if(idModelloDiIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		
		if(parametriMancanti.isEmpty()) {
			return Response.ok(targetDAO.getElencoTargetDestinatariForModello(idPso, idModelloDiIntervento)).build();
		}else {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		
		
	}
	
	/*
	 * Algoritmo <gestione TASTO GestioneTargetDestinatari>
	 * Torna l'elenco dei target destinatari associati al idPso 
	 * nella Tabella serse_r_pso_target_destinatario

	 * dati necesari: idPso
	 
	 * dati da restituire:
	 * idTargetDestinatario  
	 * descrDestinatario
	 */
	public Response getElencoTargetDestinatariForPSO(Long idPso) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}
		
		if(parametriMancanti.isEmpty()) {
			return Response.ok(targetDAO.getElencoTargetDestinatariForPSO(idPso)).build();
		}else {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		
		
	}
	
	
	/*
	 * Algoritmo <gestione TASTO CONFERMA >
	 *  inserirsce o cancella i record nella tabella serse_r_modello_intervento_pso_target_destinatario
	 *  Se il checkbox è flaggato (= 'V' oppuere 'F')
	 *  e viene aggiornata la tabella serse_t_modello_di_intervento
	 * 
	 *  dati necesari: Json 
	 *    - { INPUT_MISSING.ID_PSO: 0, INPUT_MISSING.ID_MODELLO_INTERVENTO: 0, "targetdestinatari": [ {"idTargetDestinatario": 0, "isFlaggato": "string" }  ]}
	 *   
	 *  a restituire: (nume row modificati o Success) domanda scrita
	 */
	
	@Transactional
	public Response modificaElencoTargetDestinatarioForModello(TargetDestinatariPerModifica body) {
		List<String> parametriMancanti= validate(body);
		
		if (!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		
		Long idPso = body.getIdPso().longValue();
		Long idModelloDiIntervento = body.getIdModelloDiIntervento().longValue();
		int rowInserito = 0, rowCancellato = 0;
		
		// Percorre i Targetdestinatari per cercare di inserire o cancellare a seconda se sono flaggato o no
		for (TargetDestinatarioFlaggato TargetDestinatario : body.getTargetdestinatari()) {
			Long idTargetDestinatario = TargetDestinatario.getIdTargetDestinatario().longValue();
			
			
			SerseRModelloInterventoPsoTargetDestinatarioSelector selector = new SerseRModelloInterventoPsoTargetDestinatarioSelector();
			SerseRModelloInterventoPsoTargetDestinatarioSelector.Criteria criteria = selector.createCriteria();
			criteria.andIdPsoEqualTo(idPso);
			criteria.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);				
			criteria.andIdTargetDestinatarioEqualTo(idTargetDestinatario);
			List<SerseRModelloInterventoPsoTargetDestinatarioDTO> trovato = modelloPsoTargetDAO.selectByExample(selector);
			
			if(TargetDestinatario.getIsFlaggato().equals("V")) {
				if(trovato.isEmpty()) {
					SerseRModelloInterventoPsoTargetDestinatarioDTO newModelloPsoTarget = new SerseRModelloInterventoPsoTargetDestinatarioDTO();
					newModelloPsoTarget.setdInizio(new Date());
					newModelloPsoTarget.setIdPso(idPso);
					newModelloPsoTarget.setIdModelloDiIntervento(idModelloDiIntervento);
					newModelloPsoTarget.setIdTargetDestinatario(idTargetDestinatario);
					newModelloPsoTarget.setdFine(new Date());
					
					modelloPsoTargetDAO.insert(newModelloPsoTarget);
					rowInserito++;
				}
			}else {
				if(!trovato.isEmpty()) {
					modelloPsoTargetDAO.deleteByExample(selector);
					rowCancellato++;
				}
			}
		}
		
		if((rowCancellato + rowInserito) > 0) {
			
			
			SerseTModelloDiInterventoSelector selectorModello = new SerseTModelloDiInterventoSelector();
			SerseTModelloDiInterventoSelector.Criteria criteriaModello = selectorModello.createCriteria();
			criteriaModello.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
			List<SerseTModelloDiInterventoDTO> modelloDTO = modelloDiInterventoDAO.selectByExample(selectorModello);
			
			modelloDTO.get(0).setIdModelloDiIntervento(idModelloDiIntervento);
			modelloDTO.get(0).setCodUserAggiorn("2");
			modelloDTO.get(0).setdAggiorn(new Date());
			
			modelloDiInterventoDAO.updateByPrimaryKey(modelloDTO.get(0)); 
		}
		return Response.ok("fatto" + (rowCancellato + rowInserito)).build();
		
	}
	
	private List<String> validate(TargetDestinatariPerModifica body){
		List<String> parametriMancanti= new ArrayList<>();
		if(body.getIdPso()==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}
		if(body.getIdModelloDiIntervento()==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		
		if(body.getIdModelloDiIntervento()==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		
		if(body.getTargetdestinatari().isEmpty()){
			parametriMancanti.add("TargetDestinatari");
		}
		return parametriMancanti;
	}
	
}
