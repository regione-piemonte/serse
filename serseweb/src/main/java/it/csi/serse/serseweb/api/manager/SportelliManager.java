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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneSportelloDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SportelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipoGestioneSportelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtBdgtTPsoSportelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtBdgtTPsoSportelloSelector;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.vo.Sportello;
import jakarta.ws.rs.core.Response;

@Component
public class SportelliManager extends ParentManager{
	@Autowired
	private GenericMapper mapper;

	@Autowired
	private MybatisGeneretedDTOMapper mybatisMapper;
	
	@Autowired
	private GestioneSportelloDAO sportellodao;
	
	@Autowired
	private ExtBdgtTPsoSportelloDAO sportelloDaoGenerato;
	/*Algoritmo – Valorizza lista Sportelli
		Mettere in relazione le tabelle EXT_BDGT_T_PSO e EXT_BDGT_T_PSO_SPORTELLO in questo modo:
		EXT_BDGT_T_PSO_SPORTELLO.id_pso = EXT_BDGT_T_PSO.id_pso
		(EXT_BDGT_T_PSO.id_atto_indirizzo, EXT_BDGT_T_PSO.cod_tipol_pso) 
		= <elenco ricavato dall’Algoritmo – Ricerca Tipologie PSO di competenza)
		(EXT_BDGT_T_PSO.cod_ar, EXT_BDGT_T_PSO.cod_ciclo_finanziario) 
		= <elenco ricavato dall’Algoritmo – Valorizza Amministrazione Responsabile e Ciclo Finanziario)
		Popolare la lista di selezione degli Sportelli con l’elenco ricavato al passo precedente, visualizzando:
		“<data_inizio> - <data_fine> - <descr_sportello>”
		ordinandolo per:
		<data_inizio> decrescente (il più recente visualizzato in alto)
		<data_fine> decrescente
		<descr_sportello> crescente alfabeticamment
		
		*/
	public Response getSportelliForPso(Integer idPso, Integer codOperatore, String gruppoOperatore) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add("idPso");
		}
		if(codOperatore==null) {
			parametriMancanti.add("codOperatore");
		}
		if(gruppoOperatore==null) {
			parametriMancanti.add("gruppoOperatore");
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<SportelloDTO> sportelli=sportellodao.getSportelliForPso(idPso,codOperatore,gruppoOperatore);
		if(!sportelli.isEmpty()) {
		return Response.ok(mapper.mapListSportelli(sportelli)).build();
		}else {
			return noResoultFound("nessuno sportello presente per i parametri selezionati");
		}
	};
	
	/* Restituisce i flag che descrivono lo sportello:
	 *  
	 * Se il campo flg_gestione_modello è = NULL, non visualizzare nella Home Page la macro-funzione “Modelli di intervento”; 
	 * la pagina diventa quella indicata dall’interfaccia Home Page con gestione Interventi e Servizi
		e il menu laterale diventa quello indicato nell’interfaccia Menu laterale con gestione Interventi e Servizi
		
		Se il campo flg_gestione_modello e tipo_gestione_intervento sono = NULL, la pagina diventa quella indicata 
		dall’interfaccia Home Page solo Servizi.
		e il menu laterale diventa quello indicato nell’interfaccia Menu laterale solo Servizi
		
		Se entrambi i campi flg_gestione_modello = ‘S’ e tipo_ gestione_intervento è NOT NULL, 
		visualizzare la Home page completa, come nell’interfaccia Home Page completa
		e il menu laterale diventa quello indicato nell’interfaccia Menu laterale completo
	 * */
	public Response getGestioniSportello(Integer sportelloNumProg) {
		if(sportelloNumProg==null) {
			List<String> parametriMancanti= new ArrayList<>();
			parametriMancanti.add("numProgrSportello");
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		TipoGestioneSportelloDTO dto=sportellodao.getGestioniSportello(sportelloNumProg);
		if(dto==null) {
			return noResoultFound("nessuno sportello presente con questo id");
		}
		return Response.ok(mapper.map(dto)).build();
	}
	
	public Sportello getSportelloForNumProgr(Integer numProgrSportello) {
		
		ExtBdgtTPsoSportelloSelector selector= new ExtBdgtTPsoSportelloSelector();
		ExtBdgtTPsoSportelloSelector.Criteria criteria= selector.createCriteria();
		criteria.andNumProgrSportelloEqualTo(numProgrSportello.longValue());
		return mybatisMapper.map(sportelloDaoGenerato.selectByExample(selector).get(0));
	}
}
