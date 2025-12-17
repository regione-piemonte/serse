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

import it.csi.serse.serseweb.integration.mybatis.generated.dao.*;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.*;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.CaratteristicaDAO;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.CaratteristicheAssociate;
import it.csi.serse.serseweb.vo.CaratteristicheServizio;
import it.csi.serse.serseweb.vo.GenericResponse;
import org.springframework.transaction.annotation.Transactional;


@Component
public class CaratteristicheManager extends ParentManager{

	@Autowired
	private CaratteristicaDAO caratteristicaDao;

	@Autowired
	private SerseRModelloInterventoPsoCaratteristicaDAO modelloPsoCarattDao;

	@Autowired
	private SerseTModelloDiInterventoDAO modelloDiInterventoDAO;

	@Autowired
	private SerseTServizioDAO servizioDAOGenerato;

	@Autowired
	private SerseTInterventoDAO interventoDAOGenerato;

	@Autowired
	private SerseRServizioPsoCaratteristicaDAO servizioPsoCaratteristicaDAOGenerato;

	@Autowired
	private MybatisGeneretedDTOMapper mybatisMapper;

	/*
	 * FPL-SERSE-MOD-CDU-003-V01- Gestione Caratteristiche
	 * 
	 */


	/*
	 * Algoritmo <elenco Caratteristiche associate>
	 * Torna l'elenco dei Caratteristiche associate al modello di intervento e idPso 
	 * nella Tabella serse_r_modello_intervento_pso_caratteristica
	 
	 * dati necessary: idPso, idModelloDiIntervento
	 
	 * dati da restituire:
	 * idCaratteristica  
	 * descrCaratteristica 
	 */

	public Response getCaratteristicheForModello(Long idPso,  Long idModelloDiIntervento) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}
		if(idModelloDiIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}

		if(parametriMancanti.isEmpty()) {
			return Response.ok(caratteristicaDao.getCaratteristicheForModello(idPso, idModelloDiIntervento)).build();
		}else {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
	}

	/*
	 * Algoritmo <gestione TASTO GestioneCaratteristiche>
	 * Torna l'elenco dei Caratteristiche associate al idPso 
	 * nella Tabella serse_r_pso_target_caratteristica
	 
	 * dati necesari: idPso
	 
	 * dati da restituire:
	 * idCaratteristica  
	 * descrCaratteristica 
	 */
	public Response getCaratteristicheForPso(Long idPSo) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPSo==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}

		if(!parametriMancanti.isEmpty()) return parametriObbligatoriMancanti(parametriMancanti);

		return Response.ok(caratteristicaDao.getCaratteristicheForPso(idPSo)).build();

	}

	/*
	 * Algoritmo <gestione TASTO CONFERMA >
	 *  inserirsce i record nella tabella serse_r_modello_intervento_pso_caratteristica
	 *  Se il checkbox è flaggato (= 'V' oppure 'F')
	 *  e viene aggiornata la tabella serse_t_modello_di_intervento
	 *
	 */

	@Transactional
	public Response insertCaratteristicheForModello(List<CaratteristicheAssociate> body) {
		List<String> parametriMancanti= new ArrayList<>();

		if(body.isEmpty()) {
			parametriMancanti.add("Body");
		}
		if(parametriMancanti.isEmpty()) {
			Long idModelloDiIntervento=null;
			String cfUtente = "";
			int intRisp = 0;
			for(CaratteristicheAssociate caratteristicaAssociata:body) {
				idModelloDiIntervento = caratteristicaAssociata.getIdModelloDiIntervento();
				SerseRModelloInterventoPsoCaratteristicaDTO newModelloPsoCaratte = mybatisMapper.map(caratteristicaAssociata);
				newModelloPsoCaratte.setdInizio(caratteristicaDao.getNow());
				intRisp += modelloPsoCarattDao.insert(newModelloPsoCaratte);
				cfUtente = caratteristicaAssociata.getCodiceFiscaleUtente();
			}

			if(intRisp > 0) {
				SerseTModelloDiInterventoSelector selectorModello = new SerseTModelloDiInterventoSelector();
				SerseTModelloDiInterventoSelector.Criteria criteriaModello = selectorModello.createCriteria();
				criteriaModello.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
				List<SerseTModelloDiInterventoDTO> modelloDTO = modelloDiInterventoDAO.selectByExample(selectorModello);

				modelloDTO.get(0).setIdModelloDiIntervento(idModelloDiIntervento);
				modelloDTO.get(0).setCodUserAggiorn(cfUtente);
				modelloDTO.get(0).setdAggiorn(caratteristicaDao.getNow());

				modelloDiInterventoDAO.updateByPrimaryKey(modelloDTO.get(0));
				GenericResponse risposta=new GenericResponse();
				risposta.setMessage(Constants.RISPOSTE_RESPONSE.INSERIMENTO_SUCCES);
				return Response.ok(risposta).build();
			}else {
				return internalServerError();
			}
		}else {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


	}


	/*
	 * Algoritmo <gestione TASTO CONFERMA >
	 *   cancella i record nella tabella serse_r_modello_intervento_pso_caratteristica
	 *  Se il checkbox è flaggato (= 'V' oppure 'F')
	 *  e viene aggiornata la tabella serse_t_modello_di_intervento
	 *
	 */

	@Transactional
	public Response deleteCaratteristicheForModello(List<CaratteristicheAssociate> body) {
		List<String> parametriMancanti= new ArrayList<>();
		if(body.isEmpty()) {
			parametriMancanti.add("Body");
		}
		if(parametriMancanti.isEmpty()) {
			Long idModelloDiIntervento = 0L;
			String cfUtente = "";
			int intRisp = 0;
			for(CaratteristicheAssociate caratteristicaAssociata:body) {
				idModelloDiIntervento = caratteristicaAssociata.getIdModelloDiIntervento();
				cfUtente = caratteristicaAssociata.getCodiceFiscaleUtente();
				SerseRModelloInterventoPsoCaratteristicaSelector selector = new SerseRModelloInterventoPsoCaratteristicaSelector();
				SerseRModelloInterventoPsoCaratteristicaSelector.Criteria criteria = selector.createCriteria();
				criteria.andIdCaratteristicaEqualTo(caratteristicaAssociata.getCaratteristica().getIdCaratteristica());
				criteria.andIdPsoEqualTo(caratteristicaAssociata.getIdPso());
				criteria.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
				intRisp += modelloPsoCarattDao.deleteByExample(selector);
			}


			if(intRisp > 0) {
				SerseTModelloDiInterventoSelector selectorModello = new SerseTModelloDiInterventoSelector();
				SerseTModelloDiInterventoSelector.Criteria criteriaModello = selectorModello.createCriteria();
				criteriaModello.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
				List<SerseTModelloDiInterventoDTO> modelloDTO = modelloDiInterventoDAO.selectByExample(selectorModello);

				modelloDTO.get(0).setIdModelloDiIntervento(idModelloDiIntervento);
				modelloDTO.get(0).setCodUserAggiorn(cfUtente);
				modelloDTO.get(0).setdAggiorn(caratteristicaDao.getNow());

				modelloDiInterventoDAO.updateByPrimaryKey(modelloDTO.get(0));
				GenericResponse risposta=new GenericResponse();
				risposta.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
				return Response.ok(risposta).build();
			}else {
				return internalServerError();
			}
		}else {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


	}

	/*
	 * FPL-SERSE-SER-CDU-018-V01- Gestione Caratteristiche Servizio
	 */

	public Response getCaratteristicheForServizio(Long idPso, Long idServizio, Boolean isModificabile) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}

		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}

		if(isModificabile==null) {
			parametriMancanti.add("isModificabile");
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		if(isModificabile) {
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
			SerseTInterventoDTO interventoDTO = new SerseTInterventoDTO();
			if(servizioDTO.getIdIntervento() != null)
				interventoDTO = interventoDAOGenerato.selectByPrimaryKey(servizioDTO.getIdIntervento());
			if(servizioDTO.getIdIntervento() != null && interventoDTO.getIdModelloDiIntervento() != null) {
				return Response.ok(caratteristicaDao.getCaratteristicheForModelloServizioPso(servizioDTO.getIdPso(), interventoDTO.getIdModelloDiIntervento())).build();
			}
		}
		return Response.ok(caratteristicaDao.getCaratteristicheServizioForPSOServizio(idPso, idServizio)).build();


	}

	public Response getCaratteristicheForIdServizio(Long idServizio) {
		List<String> parametriMancanti= new ArrayList<>();

		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		return Response.ok(caratteristicaDao.getCaratteristicheServizioForIdServizio(idServizio)).build();

	}

	public Response getCaratteristicheForIdIntervento(Long idIntervento) {
		List<String> parametriMancanti= new ArrayList<>();

		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		return Response.ok(caratteristicaDao.getCaratteristicheServizioForIdIntervento(idIntervento)).build();

	}

	@Transactional
	public Response deleteCaratteristicheServizio(List<CaratteristicheServizio> body) {
		int intRisp = 0;
		Long idServizio = null;
		String cf = null;
		for (CaratteristicheServizio caratteristicaServizio: body) {
			SerseRServizioPsoCaratteristicaDTO servizioPsoCaratteristicaDTO = mybatisMapper.map(caratteristicaServizio);
			servizioPsoCaratteristicaDTO.setdInizio(servizioPsoCaratteristicaDAOGenerato.getNow());
			servizioPsoCaratteristicaDTO.setdFine(servizioPsoCaratteristicaDAOGenerato.getNow());
			try {
				intRisp += servizioPsoCaratteristicaDAOGenerato.deleteByPrimaryKey(servizioPsoCaratteristicaDTO);
			} finally {
				idServizio = caratteristicaServizio.getIdServizio();
				cf = caratteristicaServizio.getCodiceFiscaleUtente();
			}

		}
		if(intRisp > 0) {
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);

			servizioDTO.setCodUserAggiorn(cf);
			servizioDTO.setdAggiorn(servizioDAOGenerato.getNow());

			servizioDAOGenerato.updateByPrimaryKey(servizioDTO);
			GenericResponse risposta=new GenericResponse();
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.INSERIMENTO_SUCCES);
			return Response.ok(risposta).build();
		}else {
			return internalServerError();
		}
	}

	@Transactional
	public Response insertCaratteristicheServizio(List<CaratteristicheServizio> body) {
		int intRisp = 0;
		Long idServizio = null;
		String cf = null;
		for (CaratteristicheServizio caratteristicaServizio: body) {
			SerseRServizioPsoCaratteristicaDTO servizioPsoCaratteristicaDTO = mybatisMapper.map(caratteristicaServizio);
			servizioPsoCaratteristicaDTO.setdInizio(servizioPsoCaratteristicaDAOGenerato.getNow());
			servizioPsoCaratteristicaDTO.setdFine(servizioPsoCaratteristicaDAOGenerato.getNow());
			try {
				intRisp += servizioPsoCaratteristicaDAOGenerato.insertSelective(servizioPsoCaratteristicaDTO);
			} finally {
				idServizio = caratteristicaServizio.getIdServizio();
				cf = caratteristicaServizio.getCodiceFiscaleUtente();
			}

		}
		if(intRisp > 0) {
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);

			servizioDTO.setCodUserAggiorn(cf);
			servizioDTO.setdAggiorn(servizioDAOGenerato.getNow());

			servizioDAOGenerato.updateByPrimaryKey(servizioDTO);
			GenericResponse risposta=new GenericResponse();
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.INSERIMENTO_SUCCES);
			return Response.ok(risposta).build();
		}else {
			return internalServerError();
		}
	}

}
