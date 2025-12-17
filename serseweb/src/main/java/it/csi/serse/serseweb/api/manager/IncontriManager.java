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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.DestinatariDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.IncontriDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.SportelloMonitoraggioDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.PartecipantiDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtBacinoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtComuneDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDServizioRegionaleDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRIncontroDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTIncontroDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTLuogoIncontroDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTTokenGamDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtBacinoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtBacinoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDSportMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTIncontroSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTLuogoIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamSelector;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.IncontriSomma;
import it.csi.serse.serseweb.vo.Incontro;
import it.csi.serse.serseweb.vo.IncontroDestinatarioServizio;
import it.csi.serse.serseweb.vo.LuogoIncontro;
import it.csi.serse.serseweb.vo.Partecipanti;
import it.csi.serse.serseweb.vo.TestChiudiIncontro;
import jakarta.ws.rs.core.Response;

@Component
public class IncontriManager extends ParentManager{
	@Autowired
	private GenericMapper genericMapper;

	@Autowired
	private VoMapper voMapper;

	@Autowired
	private MybatisGeneretedDTOMapper dtoMapper;

	@Autowired
	private IncontriDAO incontroDAOCustom;

	@Autowired
	private DestinatariDAO destinatariDAOCustom;

	@Autowired
	private SerseTLuogoIncontroDAO luogoIncontroDAOGenerato;

	@Autowired
	private SerseRIncontroDestinatarioServizioDAO incontroDestinatarioServizioDAOGenerato;

	@Autowired
	private SerseTServizioDAO servizioDAOGenerato;

	@Autowired
	private SerseRDestinatarioServizioDAO  destinatarioServizioDAOGenerato;

	@Autowired
	private SerseTTokenGamDAO tokenGamDAOGenerato;

	@Autowired
	private SerseTIncontroDAO incontroDAOGenerato;

	@Autowired
	private SerseDServizioRegionaleDAO servizioRegionaleDAOGenerato;

	@Autowired
	private ExtTtBacinoDAO bacinoDAOGenerato;

	@Autowired
	private ExtTtComuneDAO comuneDAOGenerato;

	@Autowired
	private DestinatariDAO destinatariCustom;

	@Autowired
	private SportelloMonitoraggioDAO sportMonitoraggioCustom;

	public Response getSommaDurateOre(Long idServizio) {
		List<String> parametriMancanti = new ArrayList<>();

		if (idServizio == null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTIncontroSelector incontroSelector = new SerseTIncontroSelector();
		SerseTIncontroSelector.Criteria incontroCriteria = incontroSelector.createCriteria();

		incontroCriteria.andIdServizioEqualTo(idServizio);
		List<SerseTIncontroDTO> incontriDTO = incontroDAOGenerato.selectByExample(incontroSelector);
		BigDecimal somma = new BigDecimal(0);
		for (SerseTIncontroDTO incontroDTO : incontriDTO) {
			somma = somma.add(incontroDTO.getDurataOre());
		}
		somma = somma.setScale(2);
		IncontriSomma incontriSomma = new IncontriSomma();
		incontriSomma.setSommaIncontri(somma);
		return Response.ok(incontriSomma).build();
	}

    /*
		FPL-SERSE-SER-CDU-029-V01-Gestione Incontri Servizio

	 */

	//Incontri associati al Servizio
	public Response getIncontriForIdServizio(Long idServizio) {
		List<String> parametriMancanti = new ArrayList<>();
		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		return Response.ok(incontroDAOCustom.getIncontriForIdServizio(idServizio)).build();
	}

	//Algoritmo Cancella Incontro
	@Transactional
	public Response deleteIncontro(Long idIncontro) {
		List<String> parametriMancanti = new ArrayList<>();

		if (idIncontro == null) {
			parametriMancanti.add(INPUT_MISSING.ID_INCONTRO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		int risp = 0;

		SerseTIncontroDTO incontro = incontroDAOGenerato.selectByPrimaryKey(idIncontro);

		SerseRIncontroDestinatarioServizioSelector incontroDestinatarioServizioSelector = new SerseRIncontroDestinatarioServizioSelector();
		SerseRIncontroDestinatarioServizioSelector.Criteria incontroDestinatarioServizioCriteria = incontroDestinatarioServizioSelector.createCriteria();
		incontroDestinatarioServizioCriteria.andIdIncontroEqualTo(idIncontro);
		List<SerseRIncontroDestinatarioServizioDTO> incontroDestinatarioServizioDTOS = incontroDestinatarioServizioDAOGenerato.selectByExample(incontroDestinatarioServizioSelector);

		if(incontro == null) {
			Errore error = new Errore();
			error.setErrorMessage("idIncontro non esistente per cancellare");
			error.setCode(501);
			return Response.serverError().entity(error).build();
		}
		try {
			for (SerseRIncontroDestinatarioServizioDTO incontroDestinatarioServizioDTO: incontroDestinatarioServizioDTOS) {
				risp += incontroDestinatarioServizioDAOGenerato.deleteByPrimaryKey(incontroDestinatarioServizioDTO);
			}

			SerseTTokenGamSelector tokenGamSelector = new SerseTTokenGamSelector();
			SerseTTokenGamSelector.Criteria tokenGamCriteria = tokenGamSelector.createCriteria();
			tokenGamCriteria.andIdIncontroEqualTo(idIncontro);
			for (SerseTTokenGamDTO tokenGAM: tokenGamDAOGenerato.selectByExample(tokenGamSelector)) {
				risp += tokenGamDAOGenerato.deleteByPrimaryKey(tokenGAM.getIdTokenGam());
			}

			risp += incontroDAOGenerato.deleteByPrimaryKey(idIncontro);
			risp += luogoIncontroDAOGenerato.deleteByPrimaryKey(incontro.getIdLuogoIncontro());

		}catch(Exception sqlException){
			Errore error=new Errore();
			error.setErrorMessage(sqlException.getMessage());
			error.setCode(500);
			return  Response.serverError().entity(error).build();
		}

		if(risp!=0) {
			GenericResponse success=new GenericResponse();
			success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
			return Response.ok(success).build();
		}

		return null;
	}

    /*
	FPL-SERSE-SER-CDU-030-V01-Inserimento e aggiornamento Incontro
	 */

	public Response getIncontroForId(Long idIncontro){
		List<String> parametriMancanti = new ArrayList<>();

		if (idIncontro == null) {
			parametriMancanti.add(INPUT_MISSING.ID_INCONTRO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		return Response.ok(incontroDAOCustom.getIncontriForId(idIncontro)).build();
	}


	//Algoritmo – Salva dati identificativi Incontro
	@Transactional
	public Response insertIncontro(Incontro incontro){
		SerseTIncontroDTO incontroDTO = dtoMapper.toSerseTIncontroDTO(incontro);

		incontroDTO.setIdIncontro(incontroDAOGenerato.getNextValIdIncontro());
		incontroDTO.setdInserim(incontroDAOGenerato.getNow());
		incontroDTO.setdAggiorn(incontroDAOGenerato.getNow());

		if(incontroDAOGenerato.insert(incontroDTO)!=1)
			return null;

		incontro.setIdIncontro(incontroDTO.getIdIncontro());
		incontro.setDChiusura(incontroDTO.getdChiusura());
		incontro.setDAggiorn(incontroDTO.getdAggiorn());
		incontro.setDInserim(incontroDTO.getdInserim());
		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(incontro.getIdServizio());
		SerseDServizioRegionaleDTO serseDServizioRegionaleDTO = servizioRegionaleDAOGenerato.selectByPrimaryKey(servizioDTO.getIdServizioRegionale());

		if(!serseDServizioRegionaleDTO.getCodFinalitaServizio().equals("I"))
			return Response.ok(incontro).build();

		SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria = destinatarioServizioSelector.createCriteria();
		destinatarioServizioCriteria.andIdServizioEqualTo(incontro.getIdServizio());

		List<SerseRDestinatarioServizioDTO> destinatarioServizioDTO =  destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);

		SerseRIncontroDestinatarioServizioDTO incontroDestinatarioServizioDTO = new SerseRIncontroDestinatarioServizioDTO();

		incontroDestinatarioServizioDTO.setIdIncontro(incontro.getIdIncontro());
		incontroDestinatarioServizioDTO.setOrePresenza(incontro.getDurataOre());
		incontroDestinatarioServizioDTO.setIdDestinatarioServizio(destinatarioServizioDTO.get(0).getIdDestinatarioServizio());
		incontroDestinatarioServizioDTO.setIdEnteConvoltoServizio(destinatarioServizioDTO.get(0).getIdEnteConvoltoServizio());
		incontroDestinatarioServizioDTO.setCodUserAggiorn(incontro.getCodUserAggiorn());
		incontroDestinatarioServizioDTO.setCodUserInserim(incontro.getCodUserInserim());
		incontroDestinatarioServizioDTO.setdAggiorn(incontroDestinatarioServizioDAOGenerato.getNow());
		incontroDestinatarioServizioDTO.setdInserim(incontroDestinatarioServizioDTO.getdAggiorn());

		incontroDestinatarioServizioDAOGenerato.insert(incontroDestinatarioServizioDTO);


		return Response.ok(incontro).build();
	}


	//Algoritmo – Salva dati identificativi Incontro
	public Response updateIncontro(Incontro incontro){
		SerseTIncontroDTO incontroDTO = dtoMapper.toSerseTIncontroDTO(incontro);

		incontroDTO.setdAggiorn(incontroDAOGenerato.getNow());

		if(incontroDAOGenerato.updateByPrimaryKey(incontroDTO)!=1)
			return null;

		incontro.setIdIncontro(incontroDTO.getIdIncontro());
		incontro.setDChiusura(incontroDTO.getdChiusura());
		incontro.setDAggiorn(incontroDTO.getdAggiorn());
		incontro.setDInserim(incontroDTO.getdInserim());

		return Response.ok(incontro).build();
	}


	/*
	 * FPL-SERSE-TRA-CDU-030-V01-Inserimento e aggiornamento Incontro
	 */

	//Algoritmo – Chiudi Incontro

	public Response testChiudereIncontro(Long idIncontro, Long idSportello, Long idServizio){
		TestChiudiIncontro testChiudiIncontro = new TestChiudiIncontro();

		IncontroDTO incontro = incontroDAOCustom.getIncontriForId(idIncontro);

		testChiudiIncontro.setDataFinePosterioreAllaAttuale(incontro.getdFine().after(incontroDAOCustom.getNow()));

		SerseRIncontroDestinatarioServizioSelector incontroDestinatarioServizioSelector = new SerseRIncontroDestinatarioServizioSelector();
		SerseRIncontroDestinatarioServizioSelector.Criteria incontroDestinatarioServizioCriteria = incontroDestinatarioServizioSelector.createCriteria();

		incontroDestinatarioServizioCriteria.andIdIncontroEqualTo(idIncontro);

		List<SerseRIncontroDestinatarioServizioDTO> incontroDestinatarioServizioDTOS = incontroDestinatarioServizioDAOGenerato.selectByExample(incontroDestinatarioServizioSelector);
		testChiudiIncontro.setParticipantiPresenti(incontroDestinatarioServizioDTOS.size());
		testChiudiIncontro.setDestinatarioSenzaOreErogate(false);

		for (SerseRIncontroDestinatarioServizioDTO incontroDestinatarioServizioDTO: incontroDestinatarioServizioDTOS) {
			if(incontroDestinatarioServizioDTO.getOrePresenza() == null){
				testChiudiIncontro.setDestinatarioSenzaOreErogate(true);
				break;
			}
		}
		List<SerseRDestinatarioServizioMonitoraggioDTO> destinatariDTO = destinatariCustom.getElencoPartecipantiIncontro(idServizio,idIncontro);
		List<SerseDSportMonitoraggioDTO> monitoraggio = sportMonitoraggioCustom.getSportelloMonitoraggio(idSportello);
		boolean check = false;
		for (SerseRDestinatarioServizioMonitoraggioDTO destinatarioDTO : destinatariDTO) {
			if(destinatarioDTO != null){
				if(monitoraggio.get(0).getFlgLivelloIstruzione().equals("O")){
					if(destinatarioDTO.getCodLivelloIstruzione() == null) check = true;
				}
				if(monitoraggio.get(0).getFlgCondizioneOccupazionale().equals("O")){
					if(destinatarioDTO.getCodCondizioneOccupazionale() == null) check = true;
				}
				if(monitoraggio.get(0).getFlgDisabilita().equals("O")){
					if(destinatarioDTO.getFlgDisabilita() == null) check = true;
				}
				if(monitoraggio.get(0).getFlgSvantaggioAbitativo().equals("O")){
					if(destinatarioDTO.getFlgSvantaggioAbitativo() == null) check = true;
				}
			}
		}

		testChiudiIncontro.setDatiMonitoraggioPartecipantiNonCompilati(check);
		return Response.ok(testChiudiIncontro).build();
	}

    /*
		FPL-SERSE-SER-CDU-034-V01-Elenco Destinatari associati ad Incontro
	 */

	public Response deleteIncontroDestinatarioServizio(Long idIncontro, Long idDestinatarioServizio){
		List<String> parametriMancanti = new ArrayList<>();

		if (idIncontro == null) {
			parametriMancanti.add(INPUT_MISSING.ID_INCONTRO);
		}

		if (idDestinatarioServizio == null) {
			parametriMancanti.add(INPUT_MISSING.ID_DESTINATARIO_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseRIncontroDestinatarioServizioSelector incontroDestinatarioServizioSelector = new SerseRIncontroDestinatarioServizioSelector();
		SerseRIncontroDestinatarioServizioSelector.Criteria incontroDestinatarioServizioCriteria = incontroDestinatarioServizioSelector.createCriteria();
		incontroDestinatarioServizioCriteria.andIdIncontroEqualTo(idIncontro);
		incontroDestinatarioServizioCriteria.andIdDestinatarioServizioEqualTo(idDestinatarioServizio);

		List<SerseRIncontroDestinatarioServizioDTO> incontroDestinatarioServizioDTO = incontroDestinatarioServizioDAOGenerato.selectByExample(incontroDestinatarioServizioSelector);
		GenericResponse risposta=new GenericResponse();

		if(incontroDestinatarioServizioDTO.isEmpty()){
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.ERRORE);
			return Response.ok(risposta).build();
		}

		if(incontroDestinatarioServizioDAOGenerato.deleteByPrimaryKey(incontroDestinatarioServizioDTO.get(0)) == 1)
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
		else
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.ERRORE);

		return Response.ok(risposta).build();
	}

	//Algoritmo Lista Destinatari Partecipanti
	public Response getDestinatarioForIdIncontro(Long idIncontro){
		List<Partecipanti> partecipantiVoS = new ArrayList<>();

		List<PartecipantiDTO> partecipantiDTOS = destinatariDAOCustom.getPartecipantiForIdIncontro(idIncontro);


		for (PartecipantiDTO participanteDTO: partecipantiDTOS) {
			Partecipanti participanteVo = new Partecipanti();
			participanteVo.setDestinatario(voMapper.destinatarioToVo(participanteDTO.getDestinatario()));
			participanteVo.setIncontroDestinatarioServizio(genericMapper.map(participanteDTO.getIncontroDestinatarioServizio()));
			participanteVo.setIdDestinatarioServizio(participanteDTO.getIdDestinatarioServizio());
			participanteVo.setNumerazioneDestinatario(participanteDTO.getNumerazioneDestinatario());
			participanteVo.setDtInserimentoDestinatarioServizio(participanteDTO.getDtInserimentoDestinatarioServizio());
			partecipantiVoS.add(participanteVo);
		}


		return Response.ok(partecipantiVoS).build();
	}

	//Algoritmo Aggiungi Partecipanti
	public Response getDestinatarioForIdIServizio(Long idServizio){
		List<Partecipanti> partecipantiVoS = new ArrayList<>();

		List<PartecipantiDTO> partecipantiDTOS = destinatariDAOCustom.getPartecipantiForIdServizio(idServizio);

		for (PartecipantiDTO participanteDTO: partecipantiDTOS) {
			Partecipanti participanteVo = new Partecipanti();
			participanteVo.setDestinatario(voMapper.destinatarioToVo(participanteDTO.getDestinatario()));
			participanteVo.setIncontroDestinatarioServizio(genericMapper.map(participanteDTO.getIncontroDestinatarioServizio()));
			participanteVo.setIdDestinatarioServizio(participanteDTO.getIdDestinatarioServizio());
			participanteVo.setNumerazioneDestinatario(participanteDTO.getNumerazioneDestinatario());
			participanteVo.setDtInserimentoDestinatarioServizio(participanteDTO.getDtInserimentoDestinatarioServizio());
			partecipantiVoS.add(participanteVo);
		}


		return Response.ok(partecipantiVoS).build();
	}

	//Algoritmo Conferma Aggiungi Partecipanti
	@Transactional
	public Response associaDestinatariIncontro(List<IncontroDestinatarioServizio> body){
		for (IncontroDestinatarioServizio incontroDestinatarioServizioVo: body) {
			SerseRIncontroDestinatarioServizioDTO incontroDestinatarioServizioDTO = dtoMapper.map(incontroDestinatarioServizioVo);
			incontroDestinatarioServizioDTO.setdInserim(incontroDestinatarioServizioDAOGenerato.getNow());
			incontroDestinatarioServizioDTO.setdAggiorn(incontroDestinatarioServizioDAOGenerato.getNow());

			try {
				incontroDestinatarioServizioDAOGenerato.insert(incontroDestinatarioServizioDTO);
			}catch(Exception sqlException){
				Errore error=new Errore();
				error.setErrorMessage(sqlException.getMessage());
				error.setCode(500);
				return  Response.serverError().entity(error).build();
			}
		}
		GenericResponse risposta=new GenericResponse();
		risposta.setMessage(Constants.RISPOSTE_RESPONSE.ASSOCIATO_SUCCES);

		return Response.ok(risposta).build();
	}

	public Response modificaDestinatariIncontro(IncontroDestinatarioServizio incontroDestinatarioServizioVo){
		SerseRIncontroDestinatarioServizioDTO incontroDestinatarioServizioDTO = dtoMapper.map(incontroDestinatarioServizioVo);
		incontroDestinatarioServizioDTO.setdAggiorn(incontroDestinatarioServizioDAOGenerato.getNow());

		try {
			incontroDestinatarioServizioDAOGenerato.updateByPrimaryKey(incontroDestinatarioServizioDTO);
		}catch(Exception sqlException){
			Errore error=new Errore();
			error.setErrorMessage(sqlException.getMessage());
			error.setCode(500);
			return  Response.serverError().entity(error).build();
		}

		GenericResponse risposta=new GenericResponse();
		risposta.setMessage(Constants.RISPOSTE_RESPONSE.MODIFICA_SUCCES);

		return Response.ok(risposta).build();
	}

    /*
		FPL-SERSE-SER-CDU-033-V01-Gestione Luogo Incontro
	 */

	public Response getBaciniForCodProvincia(String codProvincia){
		List<String> parametriMancanti = new ArrayList<>();

		if (codProvincia == null) {
			parametriMancanti.add("codProvincia");
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		ExtTtBacinoSelector bacinoSelector = new ExtTtBacinoSelector();
		ExtTtBacinoSelector.Criteria bacinoCriteria = bacinoSelector.createCriteria();
		bacinoCriteria.andProvEqualTo(codProvincia);

		List<ExtTtBacinoDTO> baciniDTO = bacinoDAOGenerato.selectByExample(bacinoSelector);

		return Response.ok(dtoMapper.mapListBacino(baciniDTO)).build();
	}

	public Response getComune(String codComune){
		List<String> parametriMancanti = new ArrayList<>();

		if (codComune == null) {
			parametriMancanti.add("codComune");
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		return Response.ok(voMapper.tornaComune(codComune)).build();
	}

	public Response geComuneForBacino(Long codBacino){
		ExtTtComuneSelector comuneSelector = new ExtTtComuneSelector();
		ExtTtComuneSelector.Criteria comuneCriteria = comuneSelector.createCriteria();
		comuneCriteria.andCodBacinoEqualTo(codBacino);

		List<ExtTtComuneDTO> comuneDTOS = comuneDAOGenerato.selectByExample(comuneSelector);
		List<Comune> comuni = new ArrayList<>();
		for (ExtTtComuneDTO comuneDTO: comuneDTOS) {
			comuni.add(voMapper.tornaComune(comuneDTO.getComune()));
		}

		return Response.ok(comuni).build();
	}

	@Transactional
	public Response deleteLuogoIncontro(Long idIncontro){
		List<String> parametriMancanti = new ArrayList<>();

		if (idIncontro == null) {
			parametriMancanti.add(INPUT_MISSING.ID_INCONTRO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		SerseTIncontroDTO incontroDTO = incontroDAOGenerato.selectByPrimaryKey(idIncontro);
		if(incontroDTO.getIdLuogoIncontro() != null){
			Long idLuogoIncontro = incontroDTO.getIdLuogoIncontro();
			incontroDTO.setIdLuogoIncontro(null);

			incontroDAOGenerato.updateByPrimaryKey(incontroDTO);

			luogoIncontroDAOGenerato.deleteByPrimaryKey(idLuogoIncontro);

			GenericResponse risposta=new GenericResponse();
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);

			return Response.ok(risposta).build();
		}

		return null;
	}

	public Response updateLuogoIncontro(LuogoIncontro body){
		SerseTLuogoIncontroDTO luogoIncontroDTO = dtoMapper.toLuogoIncontroDTO(body);
		luogoIncontroDTO.setdAggiorn(luogoIncontroDAOGenerato.getNow());
		luogoIncontroDAOGenerato.updateByPrimaryKey(luogoIncontroDTO);

		return Response.ok(voMapper.toVoLuogoIncontro(luogoIncontroDTO)).build();
	}


	public Response insertLuogoIncontro(LuogoIncontro body, Long idIncontro){
		SerseTLuogoIncontroDTO luogoIncontroDTO = dtoMapper.toLuogoIncontroDTO(body);
		luogoIncontroDTO.setIdLuogoIncontro(luogoIncontroDAOGenerato.getNextValIdLuogoIncontro());
		luogoIncontroDTO.setdAggiorn(luogoIncontroDAOGenerato.getNow());
		luogoIncontroDTO.setdInserim(luogoIncontroDTO.getdAggiorn());
		luogoIncontroDAOGenerato.insert(luogoIncontroDTO);

		SerseTIncontroDTO incontroDTO = incontroDAOGenerato.selectByPrimaryKey(idIncontro);

		incontroDTO.setIdLuogoIncontro(luogoIncontroDTO.getIdLuogoIncontro());
		incontroDAOGenerato.updateByPrimaryKey(incontroDTO);

		return Response.ok(voMapper.toVoLuogoIncontro(luogoIncontroDTO)).build();
	}

	public Response getLuogoIncontroForId(Long idLuogoIncontro){
		List<String> parametriMancanti = new ArrayList<>();

		if (idLuogoIncontro == null) {
			parametriMancanti.add("idLuogoIncontro");
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		SerseTLuogoIncontroDTO luogoIncontroDTO = luogoIncontroDAOGenerato.selectByPrimaryKey(idLuogoIncontro);

		return Response.ok(voMapper.toVoLuogoIncontro(luogoIncontroDTO)).build();
	}


}
