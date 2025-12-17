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

import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestionePsoDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.PsoDTO;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.AmmResponsabileDto;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.SelItemDto;
import it.csi.serse.serseweb.integration.ws.cxf.helper.CommonHelper;
import it.csi.serse.serseweb.mapper.GamMapper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.vo.PsoRistretto;
import jakarta.ws.rs.core.Response;

@Component
public class PsoManager extends ParentManager {

	@Autowired
	private GenericMapper genericMapper;
	@Autowired
	private GamMapper gamMapper;
	@Autowired
	private GestionePsoDAO psoDao;
	@Autowired
	private CommonHelper gamBudget;

	/*Algoritmo – Valorizza Amministrazione Responsabile e Ciclo Finanziario
	Mettere in relazione le tabelle EXT_BDGT_T_TIPOL_PSO e EXT_BDGT_T_PSO in questo modo:
	EXT_BDGT_T_PSO.cod_tipol_pso = EXT_BDGT_T_TIPOL_PSO.cod_tipo_pso
	EXT_BDGT_T_PSO.id_atto_indirizzo = EXT_BDGT_T_TIPOL_PSO.id_atto_indirizzo
	filtrando però in base alle coppie distinte (id_atto_indirizzo, cod_tipo_pso) 
	recuperate nell’Algoritmo – Ricerca Tipologie PSO di competenza
	Recuperare da EXT_BDGT_T_PSO l’elenco distinto delle coppie (cod_ar, cod_ciclo_finanz) decodificandole in questo modo:
	la descrizione dei cod_ar viene recuperata dal servizio SearcAllAmmResponsabili di GAM (vedi §7.1), 
	la descrizione del cod_ciclo_finanziario dal servizio searchGestCicliFin di GAM (vedi §7.2)
	Popolare la lista di selezione dell’Amministrazione Responsabile e Ciclo Finanziario 
	con l’elenco formato da: “descrizione AR – descrizione ciclo finanziario” ordinato 
	per descrizione AR crescente e descrizione ciclo finanziario crescente (i codici non devono essere visibili)
*/
	public Response getPsoForTipologia(String tipologiaPsoId, Integer idAttoIndirizzo,Integer codOperatore) {
		
		List<String> parametriMancanti = new ArrayList<>();
		if (tipologiaPsoId == null) {
			
			parametriMancanti.add("tipologiaPsoId");
			
		}
		if (idAttoIndirizzo == null) {
			parametriMancanti.add("idAttoIndirizzo");
		}
		
		if(codOperatore==null) {
			parametriMancanti.add("codOperatore");
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<AmmResponsabileDto> gamAmmResp=gamBudget.searchAllAmministrazioniResponsabili(null);
		List<SelItemDto> gamCiclFinanz=gamBudget.searchGestCicliFin(null);
		List<PsoRistretto> psoRis=new ArrayList<>();
		List<PsoDTO> pso = psoDao.getPsoForTipologia(tipologiaPsoId,idAttoIndirizzo,codOperatore);
		
		if (pso.isEmpty()) {
			return Response.ok(pso).build();
		}
		
		//recupero gli oggetti da gam e li inseriscco nell'oggetto da restituire
		pso.stream().forEachOrdered(p -> {
			PsoRistretto tmp = new PsoRistretto();
			for (AmmResponsabileDto dto : gamAmmResp) {
				if (dto.getCodAR().equals(p.getAmministrazioneResponsabile().getCodAr())) {
					tmp.setAmmResponsabili(gamMapper.toVo(dto));
				}
			}

			for (SelItemDto dto : gamCiclFinanz) {
				if (dto.getKey().equals(p.getCodCicloFinanziario())) {
					tmp.setCicliFinanziari(genericMapper.map(dto));
				}
			}
			tmp.setIdPso(p.getIdPso());
			psoRis.add(tmp);
		});
		
		return Response.ok(psoRis).build();
	}

}
