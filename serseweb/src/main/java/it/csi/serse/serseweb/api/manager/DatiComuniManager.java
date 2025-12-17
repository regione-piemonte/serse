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

import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtStatiEsteriDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTabCittadinanzaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtComuneDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtProvinciaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtStatiEsteriDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtStatiEsteriSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTabCittadinanzaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTabCittadinanzaSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtProvinciaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtProvinciaSelector;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.vo.Cittadinanza;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.ComuneRistretto;
import it.csi.serse.serseweb.vo.ProvinciaRistretto;
import it.csi.serse.serseweb.vo.StatoEstero;
import jakarta.ws.rs.core.Response;


@Component
public class DatiComuniManager extends ParentManager{
	@Autowired
	GenericMapper genericMapper;

	@Autowired
	VoMapper voMapper;

	@Autowired
	MybatisGeneretedDTOMapper mybatisMapper;

	@Autowired
	ExtTtComuneDAO comuneDAO;

	@Autowired
	ExtTtProvinciaDAO provinciaDAO;

	@Autowired
	ExtStatiEsteriDAO statiEsteriDAO;

	@Autowired
	ExtTabCittadinanzaDAO cittadinanzaDAO;

	public Response getComuniPerProvincia(String prov) {
		List<String> parametriMancanti= new ArrayList<>();
		if(prov==null) {
			parametriMancanti.add("provincia");
		}
		if(parametriMancanti.isEmpty()) {
			ExtTtComuneSelector selectorComune = new ExtTtComuneSelector();
			selectorComune.setOrderByClause("descom");
			ExtTtComuneSelector.Criteria criteriaComune = selectorComune.createCriteria();
			criteriaComune.andProvEqualTo(prov);
			List<ExtTtComuneDTO> listaComune = comuneDAO.selectByExample(selectorComune);
			List<ComuneRistretto> comuneList = mybatisMapper.mapListaComuni(listaComune);

			return Response.ok(comuneList).build();
		}else {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
	}

	public Response getInfoComuni(List<Comune> body) {
		List<Comune> comuni = new ArrayList<>();
		for(Comune comune: body) {
			comuni.add(voMapper.tornaComune(comune.getCodiceIstatComune()));
		}

		return Response.ok(comuni).build();
	}


	public Response getProvinciePerRegione(String regione) {
		List<String> parametriMancanti= new ArrayList<>();
		if(regione==null) {
			parametriMancanti.add("regione");
		}
		ExtTtProvinciaSelector selectorProvincia = new ExtTtProvinciaSelector();
		selectorProvincia.setOrderByClause("desprov");
		ExtTtProvinciaSelector.Criteria criteriaProvinci = selectorProvincia.createCriteria();

		if(parametriMancanti.isEmpty()) {

			criteriaProvinci.andRegioneEqualTo(regione);

		}else {
			criteriaProvinci.andRegioneIsNotNull();
		}

		List<ExtTtProvinciaDTO> listaProvincia = provinciaDAO.selectByExample(selectorProvincia);
		List<ProvinciaRistretto> provinciaList = mybatisMapper.mapListaProvince(listaProvincia);

		return Response.ok(provinciaList).build();
	}


	public Response getCittadinanze() {
		ExtTabCittadinanzaSelector selectorCittadinanza = new ExtTabCittadinanzaSelector();
		ExtTabCittadinanzaSelector.Criteria criteriaCittadinanza = selectorCittadinanza.createCriteria();
		criteriaCittadinanza.andCodIstatCittadinanzaIsNotNull();
		selectorCittadinanza.setOrderByClause("descr_cittadinanza");
		List<ExtTabCittadinanzaDTO> listaCittadinanza = cittadinanzaDAO.selectByExample(selectorCittadinanza);
		List<Cittadinanza> cittadinanzaList = mybatisMapper.mapListCittadinanza(listaCittadinanza);

		return Response.ok(cittadinanzaList).build();
	}

	public Response getStatiEsteri() {
		ExtStatiEsteriSelector selectorStatiEsteri = new ExtStatiEsteriSelector();
		selectorStatiEsteri.setOrderByClause("descrizione_stato");
		ExtStatiEsteriSelector.Criteria criteriaStatiEsteri = selectorStatiEsteri.createCriteria();
		criteriaStatiEsteri.andCodStatoIsNotNull();
		List<ExtStatiEsteriDTO> listaStatiEsteri = statiEsteriDAO.selectByExample(selectorStatiEsteri);
		List<StatoEstero> statiEsteriList = mybatisMapper.mapListaStatiEsteri(listaStatiEsteri);
		return Response.ok(statiEsteriList).build();
	}

	public Response getInfoStatiEsteri(List<StatoEstero> body) {
		List<StatoEstero> statiEsteriList = new ArrayList<>();
		for(StatoEstero statoEstero: body) {
			statiEsteriList.add(voMapper.tornaStatoEstero(statoEstero.getCodStato()));
		}
		return Response.ok(statiEsteriList).build();
	}

}
