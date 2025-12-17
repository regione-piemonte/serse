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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseweb.api.exception.InternalErrorException;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.AreeTerritorialiDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.SoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTModelloDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTSoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.AkOperatore;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.mapper.FlaiAnagMapper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.AreaTerritoriale;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;

@Component
public class SoggettoAttuatoreManager extends ParentManager {
	@Autowired
	private GenericMapper genericMapper;
	
	@Autowired
	private MybatisGeneretedDTOMapper mybatisMapper;
	
	@Autowired
	private FlaiAnagMapper flaiAnagMapper;
	
	@Autowired
	private FlaianagpgHelper flaiAnag;
	
	@Autowired
	private SoggettoAttuatoreDAO soggettoAttuatoreDao;
	
	@Autowired
	private AreeTerritorialiDAO areeTerritorialiDao;
	
	@Autowired
	private SerseTModelloDiInterventoDAO modelloInterventoDAOGenerato;
	
	@Autowired
	private SerseTInterventoDAO interventoDAOGenerato;
	
	@Autowired
	private SerseTSoggettoAttuatoreDAO soggettoAttuatoreDaoGenerato;
	
	/*
	 * entrambi usati per popolare le tendine dei filtri di ricerca, e successivamente per valorizzare i campi per eventuale modifica
	 * */
	public Response getIstanzeCandidatura(Long numProgrSportello,Long codOperatore, String gruppoOperatore) {

		List<String> parametriMancanti = new ArrayList<>();
		if (numProgrSportello == null) {
			parametriMancanti.add("numProgrSportello");
		}
		
		if (codOperatore == null) {
			parametriMancanti.add("codOperatore");
		}
		
		if(gruppoOperatore==null) {
			parametriMancanti.add("gruppoOperatore");
		}
		
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<SoggettoAttuatoreDTO> soElenco=soggettoAttuatoreDao.getIstanzeCandidatura(numProgrSportello, codOperatore, gruppoOperatore, false);
		if (soElenco != null) {
			Map<String, PersonaGiuridica> mapDenominazioni = getDenominazioniGiuridiche(soElenco);
			for(SoggettoAttuatoreDTO soggettoAttuatoreDTO:soElenco){
				String key = soggettoAttuatoreDTO.getGruppoOperatore() + soggettoAttuatoreDTO.getCodOperatore();
				try {
					soggettoAttuatoreDTO.setDenominazioneGiuridica(mapDenominazioni.get(key).getDenominazione());
				} catch (Exception e) {

					throw new InternalErrorException(e);
				}
			}

			return Response.ok(genericMapper.mapListSoggettiAttuatori(soElenco)).build();
		}
		
		return Response.ok(soElenco).build();
	}

	public Response getSoggettoBeneficiario(Long idSoggettoAttuatore) {
		List<String> parametriMancanti = new ArrayList<>();
		PersonaGiuridica soggettoBeneficiario= null;
		if (idSoggettoAttuatore == null) {
			parametriMancanti.add("idSoggettoAttuatore");
		}
				
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SoggettoAttuatoreDTO soggettoFiltrato = soggettoAttuatoreDao.getSoggettoBeneficiario(idSoggettoAttuatore);
		
		if (soggettoFiltrato != null) {
			Integer codOperatore = soggettoFiltrato.getCodOperatore();
			String gruppoOperatore = soggettoFiltrato.getGruppoOperatore();
			SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatore, codOperatore);
			try {
				soggettoBeneficiario = flaiAnagMapper.toVo(operatore);
				return Response.ok(soggettoBeneficiario).build();
			} catch (Exception e) {				
				throw new InternalErrorException(e);
			}
		}
		return Response.ok(soggettoBeneficiario).build();
	}

	public Response getSoggettiBeneficiari(Integer numProgrSportello,Integer codOperatore, String gruppoOperatore) {

		List<String> parametriMancanti = new ArrayList<>();
		List<PersonaGiuridica> soggettiBeneficiari=new ArrayList<>();
		
		if (numProgrSportello == null) {
			parametriMancanti.add(Constants.INPUT_MISSING.NUM_PROGR_SPORTELLO);
			numProgrSportello=0;
		}
		
		if (codOperatore == null) {
			parametriMancanti.add(Constants.INPUT_MISSING.COD_OPERATORE);
		}
		
		if(gruppoOperatore==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.GRUPPO_OPERATORE);
		}
		
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<SoggettoAttuatoreDTO> elencoSoggettiAttuatori = soggettoAttuatoreDao.getSoggettiBeneficiari(numProgrSportello.longValue(), codOperatore, gruppoOperatore);
		Map<String, PersonaGiuridica> mapDenominazioni = getDenominazioniGiuridiche(elencoSoggettiAttuatori);
		elencoSoggettiAttuatori.forEach(sa->{
			PersonaGiuridica pg = mapDenominazioni.get(sa.getGruppoOperatore() + sa.getCodOperatore());
			if(pg != null){
				soggettiBeneficiari.add(pg);
			}
		});
		return Response.ok(soggettiBeneficiari).build();
	}

	public Response getSoggettoAttuatore(Integer idSoggettoAttuatore ) {
		List<String> parametriMancanti = new ArrayList<>();
		
		SoggettoAttuatoreDTO soggettoAttuatore= soggettoAttuatoreDao.getSoggettoAttuatore(idSoggettoAttuatore);
		
		if (idSoggettoAttuatore == null) {
			parametriMancanti.add("idSoggettoAttuatore");
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		
		if (soggettoAttuatore != null) {
			Integer codOperatore = soggettoAttuatore.getCodOperatore();
			String gruppoOperatore = soggettoAttuatore.getGruppoOperatore();
			SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatore, codOperatore);
			PersonaGiuridica pg = flaiAnagMapper.toVo(operatore);
			return Response.ok(pg).build();
		
		}
		return null;
	}
	 
	public Response getSoggettoBeneficiarioAssociatoModello(@NotNull Long idModelloIntervento){
		SerseTModelloDiInterventoDTO dto=modelloInterventoDAOGenerato.selectByPrimaryKey(idModelloIntervento);
		if (dto != null) {
			return getSoggettoBeneficiario(dto.getIdSoggettoAttuatore());
		} else {
			return super.noResoultFound(Long.toString(idModelloIntervento));
		}
	}
	
	
	
	/*
	 * 
	 * 
	 * --------------------------INTERVENTI--------------------------------------
	 * 
	 * 
	 * */
	
	
	
	
	/**
	 * 
	 * @param idIntervento
	 * @return
	 */
	public Response getIstanzeCandidaturaForIntervento(Long idIntervento) {
		SerseTInterventoDTO interventoDto=interventoDAOGenerato.selectByPrimaryKey(idIntervento);
		if(interventoDto!=null && interventoDto.getIdSoggettoAttuatore()!=null) {
			SerseTSoggettoAttuatoreDTO soggettoAttuatoreDto=soggettoAttuatoreDaoGenerato.selectByPrimaryKey(interventoDto.getIdSoggettoAttuatore());
			return getIstanzeCandidatura(soggettoAttuatoreDto.getNumProgrSportello(), soggettoAttuatoreDto.getCodOperatore(), soggettoAttuatoreDto.getGruppoOperatore());
		}
		return null;
	}

	/**
	 * 
	 * @param idIntervento
	 * @return
	 */
	public Response getSoggettoBeneficiarioAssociatoIntervento(@NotNull Long idIntervento){
		SerseTInterventoDTO interventoDto=interventoDAOGenerato.selectByPrimaryKey(idIntervento);
		
		return getSoggettoBeneficiario(interventoDto.getIdSoggettoAttuatore());
	}

	/*
	 * FPL-SERSE-INT-CDU-024-V01-Inserimento e aggiornamento Servizio (con spesa)
	 */
	
	//public Response getIstanzeCandidatura(Long numProgrSportello,Long codOperatore, String gruppoOperatore)
	//Algoritmo – Lista Aree territoriali
	public Response getAreeTerritorialiDiFinanziamento(String gruppoOperatore,  Long codOperatore, Integer modelId) {
		List<String> parametriMancanti = new ArrayList<>();

		if (modelId == null) {
			parametriMancanti.add("modelId");
		}
		if (gruppoOperatore == null) {
			parametriMancanti.add(INPUT_MISSING.GRUPPO_OPERATORE);
		}

		if(codOperatore==null) {
			parametriMancanti.add(INPUT_MISSING.COD_OPERATORE);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		
		List<AreaTerritoriale> at= mybatisMapper.mapListAreaTerritoriale(areeTerritorialiDao.getAreaTerritorialeFor(gruppoOperatore, codOperatore, modelId));
		
		return Response.ok(at).build();
	}

	/*
            Evolutiva richiesta 20/10/2023  inserimento dell'area territoriale in ricerca e in inserimento
            fare in modo che nelle ricerche compaia anche il menù della scelta dell’area territoriale affinché
            sia possibile sceglierla e nel caso venga scelta questa influenzi (filtri) rispetto ai due menù
            istanza di candidatura
         */
	public Response getIstanzeCandidaturaPerCodAreaTerritoriale(String codAreaTerritoriale) {

		List<String> parametriMancanti = new ArrayList<>();
		if (codAreaTerritoriale == null) {
			parametriMancanti.add("codAreaTerritoriale");
		}


		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<SoggettoAttuatoreDTO> soElenco=soggettoAttuatoreDao.getIstanzeCandidaturaPerCodAreaTerritoriale(codAreaTerritoriale);
		if(soElenco!=null) {
			for(SoggettoAttuatoreDTO soggettoAttuatoreDTO:soElenco){
				Integer codOperatoreso = soggettoAttuatoreDTO.getCodOperatore();
				String gruppoOperatoreso = soggettoAttuatoreDTO.getGruppoOperatore();
				SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatoreso, codOperatoreso);
				if (operatore != null) {
					soggettoAttuatoreDTO.setDenominazioneGiuridica(operatore.getDenominazionePersonaGiuridica());
				}
			}
			return Response.ok(genericMapper.mapListSoggettiAttuatori(soElenco)).build();
		}

		return Response.ok(soElenco).build();
	}

	public Response getAreeTerritorialiDiFinanziamentoV2(String gruppoOperatore,  Long codOperatore, Long numProgrSportello) {
		List<String> parametriMancanti = new ArrayList<>();

		if (numProgrSportello == null) {
			parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
		}
		if (gruppoOperatore == null) {
			parametriMancanti.add(INPUT_MISSING.GRUPPO_OPERATORE);
		}

		if(codOperatore==null) {
			parametriMancanti.add(INPUT_MISSING.COD_OPERATORE);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		List<AreaTerritoriale> at= mybatisMapper.mapListAreaTerritoriale(areeTerritorialiDao.getAreaTerritorialeForNumSportello(gruppoOperatore, codOperatore, numProgrSportello));

		return Response.ok(at).build();
	}

	public Response getSoggettiAttuatori(Long numProgrSportello, Long codOperatore, String gruppoOperatore, Long modelId) {
		List<SoggettoAttuatoreDTO> saList =  soggettoAttuatoreDao.getSoggettiAttuatoriRicerca(numProgrSportello,codOperatore.intValue(),gruppoOperatore,modelId);
		Map<String,PersonaGiuridica> mapDenominazioni = getDenominazioniGiuridiche(saList);
		saList.forEach(e-> {
			String key = e.getGruppoOperatore() + e.getCodOperatore();
			if (mapDenominazioni.containsKey(key)) {
				e.setDenominazioneGiuridica(mapDenominazioni.get(key).getDenominazione());
			} else {
				e.setDenominazioneGiuridica("Denominazione non trovata");
			}
		});
		return Response.ok(saList).build();
	}

	public Map<String,PersonaGiuridica> getDenominazioniGiuridiche(List<SoggettoAttuatoreDTO> soggettiBeneficiari){

		// creo la lista deglioperatori, come se la aspetta flaianag
		List<AkOperatore> operatori = new ArrayList<>();
		for (int i = 0; i < soggettiBeneficiari.size(); i++) {
			AkOperatore tmp = new AkOperatore();
			tmp.setCodiceOperatore(soggettiBeneficiari.get(i).getCodOperatore());
			tmp.setCodiceGruppoOperatore(soggettiBeneficiari.get(i).getGruppoOperatore());
			operatori.add(tmp);
		}

		// restituisco la mappa degli oggetti nel formato di flaianag
		Map<String, SintesiPersonaGiuridica> ris;
		try {
			ris = flaiAnag.getDenominazioniOperatori(operatori);
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}

		// converto la mappa degli oggetti nei relativi vo
		Map<String, PersonaGiuridica> soggettiDenominazione = new HashMap<>();
		for (Map.Entry<String, SintesiPersonaGiuridica> entry: ris.entrySet()) {
			soggettiDenominazione.put(entry.getKey(), flaiAnagMapper.toVo(entry.getValue()));
		}

		return soggettiDenominazione;
	}

}
