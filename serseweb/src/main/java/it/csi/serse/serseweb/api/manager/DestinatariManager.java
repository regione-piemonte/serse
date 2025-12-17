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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.DestinatariDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.TargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DettaglioClasseDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTabCittadinanzaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDCondizioneOccupazionaleDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDLivelloIstruzioneDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDRegComportPsoSportDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDServizioRegionaleDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDSportMonitoraggioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioMonitoraggioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRModelloInterventoPsoTargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRServizioPsoTargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTModelloDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtStatiEsteriDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDCondizioneOccupazionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDCondizioneOccupazionaleSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDLivelloIstruzioneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDLivelloIstruzioneSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDSportMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioPsoTargetDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.utils.Constants.RISPOSTE_RESPONSE;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.CondizioneOccupazionaleIgrue;
import it.csi.serse.serseweb.vo.DatiPeculiari;
import it.csi.serse.serseweb.vo.DatiPeculiariWrapper;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.DestinatarioServizio;
import it.csi.serse.serseweb.vo.DestinatarioServizioCaricato;
import it.csi.serse.serseweb.vo.DestinatarioServizioMonitoraggio;
import it.csi.serse.serseweb.vo.DestinatariservizioRinumeraBody;
import it.csi.serse.serseweb.vo.DettaglioClasseDestinatarioServizio;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.RegComportPsoSport;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.SportMonitoraggio;
import it.csi.serse.serseweb.vo.TargetDestinatariAssociati;
import it.csi.serse.serseweb.vo.TargetDestinatariServizio;
import it.csi.serse.serseweb.vo.TargetDestinatario;
import it.csi.serse.serseweb.vo.TestDestinatario;
import it.csi.serse.serseweb.vo.TitoloStudioIgrue;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;

@Component
public class DestinatariManager extends ParentManager{
	@Autowired
	private GenericMapper genericMapper;

	@Autowired
	private MybatisGeneretedDTOMapper mybatisMapper;

	@Autowired
	private VoMapper voMapper;

	@Autowired
	private TargetDestinatarioDAO targetDAO;

	@Autowired
	private DestinatariDAO destinatariCustom;

	@Autowired
	private SerseRModelloInterventoPsoTargetDestinatarioDAO modelloPsoTargetDAO;

	@Autowired
	private SerseTModelloDiInterventoDAO modelloDiInterventoDAO;

	@Autowired
	private SerseTDestinatarioDAO destinatarioDAOGenerato;

	@Autowired
	private SerseTServizioDAO servizioDAOGenerato;

	@Autowired
	private SerseRDestinatarioServizioDAO destinatarioServizioDAOGenerato;

	@Autowired
	private SerseRDestinatarioServizioMonitoraggioDAO destinatarioServizioMonitoraggioDAOGenerato;

	@Autowired
	private SerseTInterventoDAO interventoDAOGenerato;

	@Autowired
	private SerseDServizioRegionaleDAO servizioRegionaleDAOGenerato;

	@Autowired
	private SerseTEnteCoinvoltoServizioDAO enteCoinvoltoServizioDAOGenerato;

	@Autowired
	private SerseRServizioPsoTargetDestinatarioDAO servizioPsoTargetDestDAOGenerato;

	@Autowired
	private SerseDRegComportPsoSportDAO serseDRegComportPsoSportDAOGenerato;

	@Autowired
	private SerseDSportMonitoraggioDAO sportMonitoraggioDAOGenerato;

	@Autowired
	private SerseDLivelloIstruzioneDAO livelloIstruzioneDAOGenerato;

	@Autowired
	private SerseDCondizioneOccupazionaleDAO condizioneOccupazionaleDAOGenerato;
	@Autowired
	private ExtTabCittadinanzaDAO cittadinanzaDAO;


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
		}

		return parametriObbligatoriMancanti(parametriMancanti);


	}

	/*
	 * Algoritmo <gestione TASTO CONFERMA >
	 *  inserirsce i record nella tabella serse_r_modello_intervento_pso_target_destinatario
	 *  Se il checkbox è flaggato (= 'V' oppuere 'F')
	 *  e viene aggiornata la tabella serse_t_modello_di_intervento
	*/

	@Transactional
	public Response insertTargetDestinatarioForModello(List<TargetDestinatariAssociati> body) {
		List<String> parametriMancanti= new ArrayList<>();

		if(body.isEmpty()) {
			parametriMancanti.add("Body");
		}
		if(parametriMancanti.isEmpty()) {
			Long idModelloDiIntervento = 0L;
			String cfUtente = "";
			int intRisp = 0;

			for(TargetDestinatariAssociati targetDestinatariAssociato:body) {
				idModelloDiIntervento = targetDestinatariAssociato.getIdModelloDiIntervento();
				cfUtente = targetDestinatariAssociato.getCodiceFiscaleUtente();
				SerseRModelloInterventoPsoTargetDestinatarioDTO newModelloPsoTarget = new SerseRModelloInterventoPsoTargetDestinatarioDTO();
				newModelloPsoTarget.setdInizio(targetDAO.getNow());
				newModelloPsoTarget.setIdPso(targetDestinatariAssociato.getIdPso());
				newModelloPsoTarget.setIdModelloDiIntervento(idModelloDiIntervento);
				newModelloPsoTarget.setIdTargetDestinatario(targetDestinatariAssociato.getTargetdestinatario().getIdTargetDestinatario());
				intRisp += modelloPsoTargetDAO.insert(newModelloPsoTarget);
			}

			if(intRisp > 0) {
				SerseTModelloDiInterventoSelector selectorModello = new SerseTModelloDiInterventoSelector();
				SerseTModelloDiInterventoSelector.Criteria criteriaModello = selectorModello.createCriteria();
				criteriaModello.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
				List<SerseTModelloDiInterventoDTO> modelloDTO = modelloDiInterventoDAO.selectByExample(selectorModello);

				modelloDTO.get(0).setIdModelloDiIntervento(idModelloDiIntervento);
				modelloDTO.get(0).setCodUserAggiorn(cfUtente);
				modelloDTO.get(0).setdAggiorn(targetDAO.getNow());

				intRisp += modelloDiInterventoDAO.updateByPrimaryKey(modelloDTO.get(0));
				GenericResponse risposta=new GenericResponse();
				if(intRisp != 0)
					risposta.setMessage("inserimento avvenuto con successo ");
				else
					risposta.setMessage("error");
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
	 *  cancella i record nella tabella serse_r_modello_intervento_pso_target_destinatario
	 *  Se il checkbox è flaggato (= 'V' oppuere 'F')
	 *  e viene aggiornata la tabella serse_t_modello_di_intervento
	 *
	 *  dati necesari: Json
	 *
	 */
	@Transactional
	public Response deleteTargetDestinatarioForModello(List<TargetDestinatariAssociati> body) {
		List<String> parametriMancanti= new ArrayList<>();

		if(body.isEmpty()) {
			parametriMancanti.add("Body");
		}
		if(parametriMancanti.isEmpty()) {
			Long idModelloDiIntervento = 0L;
			String cfUtente = "";
			int intRisp = 0;
			for(TargetDestinatariAssociati targetDestinatariAssociato:body) {
				idModelloDiIntervento = targetDestinatariAssociato.getIdModelloDiIntervento();
				TargetDestinatario targetDestinatario = targetDestinatariAssociato.getTargetdestinatario();
				SerseRModelloInterventoPsoTargetDestinatarioSelector selector = new SerseRModelloInterventoPsoTargetDestinatarioSelector();
				SerseRModelloInterventoPsoTargetDestinatarioSelector.Criteria criteria = selector.createCriteria();
				criteria.andIdPsoEqualTo(targetDestinatariAssociato.getIdPso());
				criteria.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
				criteria.andIdTargetDestinatarioEqualTo(targetDestinatario.getIdTargetDestinatario());


				intRisp += modelloPsoTargetDAO.deleteByExample(selector);

				cfUtente = targetDestinatariAssociato.getCodiceFiscaleUtente();
			}


			if(intRisp > 0) {
				SerseTModelloDiInterventoSelector selectorModello = new SerseTModelloDiInterventoSelector();
				SerseTModelloDiInterventoSelector.Criteria criteriaModello = selectorModello.createCriteria();
				criteriaModello.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
				List<SerseTModelloDiInterventoDTO> modelloDTO = modelloDiInterventoDAO.selectByExample(selectorModello);

				modelloDTO.get(0).setIdModelloDiIntervento(idModelloDiIntervento);
				modelloDTO.get(0).setCodUserAggiorn(cfUtente);
				modelloDTO.get(0).setdAggiorn(targetDAO.getNow());

				modelloDiInterventoDAO.updateByPrimaryKey(modelloDTO.get(0));
				GenericResponse risposta=new GenericResponse();
				risposta.setMessage("cancellazione avvenuta con successo ");
				return Response.ok(risposta).build();
			}else {
				return internalServerError();
			}
		}else {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
	}

	/*
	 *
	 * Gestione Destinatari
	 *
	 * */

	public Response getDestinatarioForId( Long idDestinatario) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idDestinatario==null) {
			parametriMancanti.add("idDestinatario");
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		/*
		 * uso il dao generato per ricavare i dati
		 * */
		SerseTDestinatarioDTO result=destinatarioDAOGenerato.selectByPrimaryKey(idDestinatario);

		if(result!=null) {

			Destinatario destinatario=voMapper.destinatarioToVo(result);
			/*
			 * verifico se il destinatario è nato in italia o all'estero e valorizzo i campi di conseguenza
			 * */

			return Response.ok(destinatario).build();
		}
		return null;
	}

	/*
	 * FPL-SERSE-TRA-CDU-016-V02
	 *  Gestione Anagrafe Destinatari
	 */

	public Response getDestinatariDaRicerca(String nome, String cognome, String codiceFiscaleDestinatario,
											String dataDiNascita) {

		List<String> parametriMancanti= new ArrayList<>();
		if(nome==null) {
			parametriMancanti.add("nome");
		}
		if(cognome==null) {
			parametriMancanti.add("cognome");
		}
		if(codiceFiscaleDestinatario==null) {
			parametriMancanti.add("codiceFiscaleDestinatario");
		}
		if(dataDiNascita==null) {
			parametriMancanti.add("dataDiNascita");
		}
		if(parametriMancanti.size() == 4) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<Destinatario> destinatari = new ArrayList<>();

		SerseTDestinatarioSelector selectorDestinatario = new SerseTDestinatarioSelector();
		SerseTDestinatarioSelector.Criteria criteriaDestinatario = selectorDestinatario.createCriteria();

		if(codiceFiscaleDestinatario!=null) {
			criteriaDestinatario.andCfDestinatarioEqualTo(codiceFiscaleDestinatario);
		}
		if(nome!=null) {
			criteriaDestinatario.andNomeDestinatarioLikeInsensitive("%" + nome + "%");
		}
		if(cognome!=null) {
			criteriaDestinatario.andCognomeDestinatarioLikeInsensitive("%" + cognome + "%");
		}

		if(dataDiNascita!=null) {
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(dataDiNascita);
			} catch (ParseException e) {
				Errore error=new Errore();
				error.setErrorMessage(e.getMessage());
				error.setCode(500);
				return  Response.serverError().entity(error).build();
			}
			criteriaDestinatario.andDNascitaEqualTo(date);
		}

		List<SerseTDestinatarioDTO> destinatariDTO = destinatarioDAOGenerato.selectByExample(selectorDestinatario);

		Map<String, Comune> comuni = getComuni(destinatariDTO);
		Map<Long, ExtStatiEsteriDTO> statiEsteri = getStatiEsteri(destinatariDTO);
		
		for (SerseTDestinatarioDTO destinatarioDTO: destinatariDTO) {
			destinatari.add(voMapper.destinatarioToVo(destinatarioDTO, comuni, statiEsteri));
		}

		return Response.ok(destinatari).build();
	}

	private Map<String, Comune> getComuni(List<SerseTDestinatarioDTO> destinatariDTO) {
		Set<String> codiciComuni = new HashSet<>();
		for (SerseTDestinatarioDTO x: destinatariDTO) {
			codiciComuni.add(x.getCodIstatComuneNascita());
			codiciComuni.add(x.getCodIstatComuneResidenza());
			codiciComuni.add(x.getCodIstatComuneDomicilio());
		}
		codiciComuni.remove(null);
		Map<String, Comune> map = new HashMap<>();
		for (String x: codiciComuni) {
			map.put(x, voMapper.tornaComune(x));
		}
		return map;
	}

	private Map<Long, ExtStatiEsteriDTO> getStatiEsteri(List<SerseTDestinatarioDTO> destinatariDTO) {
		Set<Long> codiciStati = new HashSet<>();
		for (SerseTDestinatarioDTO x: destinatariDTO) {
			codiciStati.add(x.getCodStatoEsteroNascita());
			codiciStati.add(x.getCodStatoEsteroResidenza());
		}
		codiciStati.remove(null);
		Map<Long, ExtStatiEsteriDTO> map = new HashMap<>();
		for (Long x: codiciStati) {
			map.put(x, voMapper.getStatoEsteroOrNull(x));
		}
		return map;
	}

	/*
    Algoritmo Elenco Destinatari Intervento
     */
	public Response getDestinatarioForIdServizio(Long idServizio) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<SerseTDestinatarioDTO> destinatariDTO= destinatariCustom.getDestinatarioForIdServizio(idServizio);
		List<Destinatario> destinatari = new ArrayList<>();
		for (SerseTDestinatarioDTO destinatarioDTO : destinatariDTO) {
			destinatari.add(voMapper.destinatarioToVo(destinatarioDTO));
		}

		return Response.ok(destinatari).build();
	}

	/*
	 * Algoritmo Inserimento nuovo Destinatario
	 * Verifica esistenza Codice Fiscale in anagrafica.
	 */

	public Response testCodiceFiscale(String codiceFiscaleDestinatario) {
		List<String> parametriMancanti= new ArrayList<>();
		if(codiceFiscaleDestinatario==null) {
			parametriMancanti.add("codiceFiscaleDestinatario");
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTDestinatarioSelector selectorDestinatario = new SerseTDestinatarioSelector();
		SerseTDestinatarioSelector.Criteria criteriaDestinatario = selectorDestinatario.createCriteria();
		criteriaDestinatario.andCfDestinatarioEqualTo(codiceFiscaleDestinatario);

		List<SerseTDestinatarioDTO> result=destinatarioDAOGenerato.selectByExample(selectorDestinatario);
		TestDestinatario testDesti = new TestDestinatario();

		testDesti.setIsCodiceFiscaleInAnagrafica(!result.isEmpty());


		return Response.ok(testDesti).build();
	}


	/*
	 * Salvataggio dei dati della Scheda Anagrafica Nuovo Destinatario
	 */
	private Destinatario insertDestinatario(Destinatario body) {

		SerseTDestinatarioDTO destinatarioMappato = mybatisMapper.toSerseTDestinatarioDTO(body);
		destinatarioMappato.setIdDestinatario(destinatarioDAOGenerato.getNextValIdDestinatario());
		destinatarioMappato.setdAggiorn(destinatarioDAOGenerato.getNow());
		destinatarioMappato.setdInserim(destinatarioDAOGenerato.getNow());
		int intRisp = destinatarioDAOGenerato.insert(destinatarioMappato);

		if(intRisp == 1) {
			return voMapper.destinatarioToVo(destinatarioMappato);
		}
		return  null;
	}

	/*
	 * Salvataggio dei dati della Scheda Anagrafica modifica Destinatario
	 */
	public Response updateDestinatario(Destinatario body) {
		SerseTDestinatarioDTO destinatarioMappato = mybatisMapper.toSerseTDestinatarioDTO(body);
		destinatarioMappato.setdAggiorn(destinatarioDAOGenerato.getNow());
		int intRisp = destinatarioDAOGenerato.updateByPrimaryKey(destinatarioMappato);

		if(intRisp == 1) {
			return Response.ok(voMapper.destinatarioToVo(destinatarioMappato)).build();
		}
		return  null;
	}

	/*
	 * Algoritmo recupero Ente coinvolto per Servizio Individuale

	 */
	private Long tornaIdEnteCoinvoltoPerServizioIndividuale(Long idServizio) {
		Long idEnteCoinvoltoServizio = null;

		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
		SerseDServizioRegionaleDTO servizioRegionale = servizioRegionaleDAOGenerato.selectByPrimaryKey(servizioDTO.getIdServizioRegionale());
		if(servizioRegionale.getCodFinalitaServizio().equals("I")) {
			//enteCoinvoltoServizioDAOGenerato
			SerseTEnteCoinvoltoServizioSelector enteCoinvoltoServizioSelector = new SerseTEnteCoinvoltoServizioSelector();
			SerseTEnteCoinvoltoServizioSelector.Criteria enteCoinvoltoServizioCriteria = enteCoinvoltoServizioSelector.createCriteria();
			enteCoinvoltoServizioCriteria.andIdServizioEqualTo(idServizio);

			List<SerseTEnteCoinvoltoServizioDTO> entiCoinvoltoServizioDTO = enteCoinvoltoServizioDAOGenerato.selectByExample(enteCoinvoltoServizioSelector);

			if(!entiCoinvoltoServizioDTO.isEmpty())
				idEnteCoinvoltoServizio = entiCoinvoltoServizioDTO.get(0).getIdEnteConvoltoServizio();


		}


		return idEnteCoinvoltoServizio;
	}

	/*
	 * Salvataggio dei dati della Scheda Anagrafica Nuovo Destinatario-Intervento
	 */
	@Transactional
	public Response insertDestinatarioIntervento(Destinatario body, Long idIntervento, String codUserAggiornamento) {
		Destinatario destinatarioSalvato = insertDestinatario(body);
		if(destinatarioSalvato != null) {

			SerseTInterventoDTO interventoDTO = interventoDAOGenerato.selectByPrimaryKey(idIntervento);
			interventoDTO.setIdDestinatario(destinatarioSalvato.getIdDestinatario());
			interventoDTO.setCodUserAggiorn(codUserAggiornamento);
			interventoDTO.setdAggiorn(interventoDAOGenerato.getNow());
			interventoDAOGenerato.updateByPrimaryKey(interventoDTO);

			return Response.ok(destinatarioSalvato).build();
		}

		return null;
	}

	/*
	 * Algoritmo verifica numero massimo destinatari associabili
	 */
	public Response testMaxDestinatariAssociabili(Long idServizio) {

		//
		//
		SerseRDestinatarioServizioSelector servizioSelector = new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria criteriaSelector = servizioSelector.createCriteria();

		criteriaSelector.andIdServizioEqualTo(idServizio);

		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
		List<SerseRDestinatarioServizioDTO> destinatarioServizio = destinatarioServizioDAOGenerato.selectByExample(servizioSelector);

		TestDestinatario risposta = new TestDestinatario();

		risposta.setRaggiuntoNumeroMassimoDestinatariAssociabili(destinatarioServizio.size() == servizioDTO.getNumMaxDestinatari());

		return Response.ok(risposta).build();
	}


	public Response associaDestinatarioIntervento(Long idIntervento,String codUserAggiornamento, Long idDestinatario) {
		SerseTInterventoDTO interventoDTO = interventoDAOGenerato.selectByPrimaryKey(idIntervento);
		interventoDTO.setIdDestinatario(idDestinatario);
		interventoDTO.setCodUserAggiorn(codUserAggiornamento);
		interventoDTO.setdAggiorn(interventoDAOGenerato.getNow());
		int risp = interventoDAOGenerato.updateByPrimaryKey(interventoDTO);
		GenericResponse risposta=new GenericResponse();
		if(risp == 1)
			risposta.setMessage(RISPOSTE_RESPONSE.ASSOCIATO_SUCCES);
		else
			risposta.setMessage("error");


		return Response.ok(risposta).build();
	}


	/*
	 * Salvataggio dei dati della Scheda Anagrafica Nuovo Destinatario-Servizio
	 */
	@Transactional
	public Response insertDestinatarioServizio(Destinatario body, Long idServizio, String codUserAggiornamento) {
		Destinatario destinatarioSalvato = insertDestinatario(body);
		if(destinatarioSalvato != null) {
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
			SerseRDestinatarioServizioDTO destinatarioServizioDTO = new SerseRDestinatarioServizioDTO();
			Long idDestinatarioServizio = destinatarioServizioDAOGenerato.getNextValIdDestinatarioServizio();
			Long numerazioneDestinatario = destinatarioServizioDAOGenerato.getNextNumerazioneDestinatario(idServizio);
			destinatarioServizioDTO.setIdDestinatarioServizio(idDestinatarioServizio);
			destinatarioServizioDTO.setNumerazioneDestinatario(numerazioneDestinatario);
			destinatarioServizioDTO.setIdServizio(idServizio);
			destinatarioServizioDTO.setIdDestinatario(destinatarioSalvato.getIdDestinatario());
			destinatarioServizioDTO.setCodUserInserim(codUserAggiornamento);
			destinatarioServizioDTO.setCodUserAggiorn(codUserAggiornamento);
			destinatarioServizioDTO.setdInserim(destinatarioServizioDAOGenerato.getNow());
			destinatarioServizioDTO.setdAggiorn(destinatarioServizioDAOGenerato.getNow());
			destinatarioServizioDTO.setIdPsoClasseDestinatario(servizioDTO.getIdPsoClasseDestinatario());
			destinatarioServizioDTO.setValoreDatoPeculiare1(servizioDTO.getValoreDatoPeculiare1());
			destinatarioServizioDTO.setValoreDatoPeculiare2(servizioDTO.getValoreDatoPeculiare2());
			destinatarioServizioDTO.setIdEnteConvoltoServizio(tornaIdEnteCoinvoltoPerServizioIndividuale(idServizio));

			int risp = destinatarioServizioDAOGenerato.insert(destinatarioServizioDTO);

			SerseRDestinatarioServizioMonitoraggioDTO serseRDestinatarioServizioMonitoraggioDTO = new SerseRDestinatarioServizioMonitoraggioDTO();
			serseRDestinatarioServizioMonitoraggioDTO.setIdDestinatarioServizio(destinatarioServizioDTO.getIdDestinatarioServizio());
			serseRDestinatarioServizioMonitoraggioDTO.setdAggiorn(destinatarioServizioDAOGenerato.getNow());
			serseRDestinatarioServizioMonitoraggioDTO.setdInserim(destinatarioServizioDAOGenerato.getNow());
			serseRDestinatarioServizioMonitoraggioDTO.setCodUserAggiorn(servizioDTO.getCodUserAggiorn());
			serseRDestinatarioServizioMonitoraggioDTO.setCodUserInserim(servizioDTO.getCodUserAggiorn());
			serseRDestinatarioServizioMonitoraggioDTO.setCodCittadinanza(body.getCodCittadinanza());
			serseRDestinatarioServizioMonitoraggioDTO.setCodCondizioneOccupazionale(servizioDTO.getCodCondizioneOccupazionale());
			serseRDestinatarioServizioMonitoraggioDTO.setCodLivelloIstruzione(servizioDTO.getCodLivelloIstruzione());
			serseRDestinatarioServizioMonitoraggioDTO.setFlgDisabilita(servizioDTO.getFlgDisabilita());
			serseRDestinatarioServizioMonitoraggioDTO.setFlgSvantaggioAbitativo(servizioDTO.getFlgSvantaggioAbitativo());
			destinatarioServizioMonitoraggioDAOGenerato.insert(serseRDestinatarioServizioMonitoraggioDTO);

			if(risp == 1)
				return Response.ok(destinatarioSalvato).build();
		}

		return null;
	}

	@Transactional
	public Response associaDestinatarioServizio(Long idServizio,String codUserAggiornamento, List<Destinatario> destinatari) {
		List<String> parametriMancanti= new ArrayList<>();
		if(destinatari.isEmpty()) {
			parametriMancanti.add(INPUT_MISSING.ID_DESTINATARIO);
		}

		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}

		if(codUserAggiornamento==null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		int risp = 0;

		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
		List<DestinatarioServizio> destinatarioServizioList = new ArrayList<>();
		for (Destinatario destinatario: destinatari) {
			SerseRDestinatarioServizioDTO destinatarioServizio = new SerseRDestinatarioServizioDTO();
			destinatarioServizio.setIdDestinatarioServizio(destinatarioServizioDAOGenerato.getNextValIdDestinatarioServizio());
			destinatarioServizio.setNumerazioneDestinatario(destinatarioServizioDAOGenerato.getNextNumerazioneDestinatario(idServizio));
			destinatarioServizio.setIdServizio(idServizio);
			destinatarioServizio.setIdDestinatario(destinatario.getIdDestinatario());
			destinatarioServizio.setCodUserInserim(codUserAggiornamento);
			destinatarioServizio.setdInserim(destinatarioServizioDAOGenerato.getNow());
			destinatarioServizio.setCodUserAggiorn(codUserAggiornamento);
			destinatarioServizio.setdAggiorn(destinatarioServizio.getdInserim());
			// ****** Aggiunto  - 1.1.0 ID 270 dati peculiari da servizio
			destinatarioServizio.setValoreDatoPeculiare1(servizioDTO.getValoreDatoPeculiare1());
			destinatarioServizio.setValoreDatoPeculiare2(servizioDTO.getValoreDatoPeculiare2());
			// **
			destinatarioServizio.setIdPsoClasseDestinatario(servizioDTO.getIdPsoClasseDestinatario());
			risp += destinatarioServizioDAOGenerato.insert(destinatarioServizio);

			DestinatarioServizio destinatarioServizioVo = mybatisMapper.map(destinatarioServizio);
			destinatarioServizioVo.setDestinatario(destinatario);
			destinatarioServizioVo.setDInserim(destinatarioServizio.getdInserim());
			destinatarioServizioList.add(destinatarioServizioVo);

			// ****** Aggiunto  - 1.1.0 ID 270 dati peculiari da servizio
			SerseRDestinatarioServizioMonitoraggioDTO serseRDestinatarioServizioMonitoraggioDTO = new SerseRDestinatarioServizioMonitoraggioDTO();
			serseRDestinatarioServizioMonitoraggioDTO.setIdDestinatarioServizio(destinatarioServizio.getIdDestinatarioServizio());
			serseRDestinatarioServizioMonitoraggioDTO.setdAggiorn(destinatarioServizioDAOGenerato.getNow());
			serseRDestinatarioServizioMonitoraggioDTO.setdInserim(destinatarioServizioDAOGenerato.getNow());
			serseRDestinatarioServizioMonitoraggioDTO.setCodUserAggiorn(servizioDTO.getCodUserAggiorn());
			serseRDestinatarioServizioMonitoraggioDTO.setCodUserInserim(servizioDTO.getCodUserAggiorn());
			serseRDestinatarioServizioMonitoraggioDTO.setCodCittadinanza(destinatario.getCodCittadinanza());
			serseRDestinatarioServizioMonitoraggioDTO.setCodCondizioneOccupazionale(servizioDTO.getCodCondizioneOccupazionale());
			serseRDestinatarioServizioMonitoraggioDTO.setCodLivelloIstruzione(servizioDTO.getCodLivelloIstruzione());
			serseRDestinatarioServizioMonitoraggioDTO.setFlgDisabilita(servizioDTO.getFlgDisabilita());
			serseRDestinatarioServizioMonitoraggioDTO.setFlgSvantaggioAbitativo(servizioDTO.getFlgSvantaggioAbitativo());
			destinatarioServizioMonitoraggioDAOGenerato.insert(serseRDestinatarioServizioMonitoraggioDTO);
			// **
		}

		GenericResponse risposta=new GenericResponse();
		if(risp > 0)
			return Response.ok(destinatarioServizioList).build();
		else
			risposta.setMessage(RISPOSTE_RESPONSE.ERRORE);


		return Response.ok(risposta).build();
	}
	/**
	Caricamento dati da excel
	 */
	@Transactional
	public Response caricaDestinatariServizio(Long idServizio,String codUserAggiornamento, List<Destinatario> destinatari) {
		List<String> parametriMancanti= new ArrayList<>();
		if(destinatari.isEmpty()) {
			parametriMancanti.add(INPUT_MISSING.ID_DESTINATARIO);
		}

		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}

		if(codUserAggiornamento==null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		int risp = 0;
		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
		List<DestinatarioServizioCaricato> destinatarioServizioList = new ArrayList<>();
		for (Destinatario destinatario: destinatari) {

			destinatario.setCodUserInserim(codUserAggiornamento);
			DestinatarioServizioCaricato destinatarioServizioCaricato = verificaInserisceDestinatario(destinatario,idServizio);

			SerseRDestinatarioServizioDTO destinatarioServizio = new SerseRDestinatarioServizioDTO();
			if((destinatarioServizioCaricato.getStato().equals("200") || destinatarioServizioCaricato.getStato().equals("210"))) {

				destinatarioServizio.setIdDestinatarioServizio(destinatarioServizioDAOGenerato.getNextValIdDestinatarioServizio());
				destinatarioServizio.setIdServizio(idServizio);
				//task 2025 #12 inizio aggiungo il numero destinatario serivio che andra inserito 
				destinatarioServizio.setNumerazioneDestinatario(destinatarioServizioDAOGenerato.getNextNumerazioneDestinatario(idServizio));
				//task 2025 #12 fine
				destinatarioServizio.setIdDestinatario(destinatarioServizioCaricato.getDestinatarioServizio().getDestinatario().getIdDestinatario());
				destinatarioServizio.setCodUserInserim(codUserAggiornamento);
				destinatarioServizio.setdInserim(destinatarioServizioDAOGenerato.getNow());
				destinatarioServizio.setCodUserAggiorn(codUserAggiornamento);
				destinatarioServizio.setdAggiorn(destinatarioServizio.getdInserim());
				// ****** Aggiunto  - 1.1.0 ID 270 dati peculiari da servizio
				destinatarioServizio.setValoreDatoPeculiare1(servizioDTO.getValoreDatoPeculiare1());
				destinatarioServizio.setValoreDatoPeculiare2(servizioDTO.getValoreDatoPeculiare2());
				// **
				destinatarioServizio.setIdPsoClasseDestinatario(servizioDTO.getIdPsoClasseDestinatario());
				risp += destinatarioServizioDAOGenerato.insert(destinatarioServizio);

				// ****** Aggiunto  - 1.1.0 ID 270 dati peculiari da servizio
				SerseRDestinatarioServizioMonitoraggioDTO serseRDestinatarioServizioMonitoraggioDTO = new SerseRDestinatarioServizioMonitoraggioDTO();
				serseRDestinatarioServizioMonitoraggioDTO.setIdDestinatarioServizio(destinatarioServizio.getIdDestinatarioServizio());
				serseRDestinatarioServizioMonitoraggioDTO.setdAggiorn(destinatarioServizioDAOGenerato.getNow());
				serseRDestinatarioServizioMonitoraggioDTO.setdInserim(destinatarioServizioDAOGenerato.getNow());
				serseRDestinatarioServizioMonitoraggioDTO.setCodCittadinanza(destinatario.getCodCittadinanza());
				serseRDestinatarioServizioMonitoraggioDTO.setCodUserAggiorn(servizioDTO.getCodUserAggiorn());
				serseRDestinatarioServizioMonitoraggioDTO.setCodUserInserim(servizioDTO.getCodUserAggiorn());
				serseRDestinatarioServizioMonitoraggioDTO.setCodCondizioneOccupazionale(servizioDTO.getCodCondizioneOccupazionale());
				serseRDestinatarioServizioMonitoraggioDTO.setCodLivelloIstruzione(servizioDTO.getCodLivelloIstruzione());
				serseRDestinatarioServizioMonitoraggioDTO.setFlgDisabilita(servizioDTO.getFlgDisabilita());
				serseRDestinatarioServizioMonitoraggioDTO.setFlgSvantaggioAbitativo(servizioDTO.getFlgSvantaggioAbitativo());
				destinatarioServizioMonitoraggioDAOGenerato.insert(serseRDestinatarioServizioMonitoraggioDTO);
				// **
			}

			DestinatarioServizio destinatarioServizioVo = mybatisMapper.map(destinatarioServizio);

			destinatarioServizioVo.setDestinatario(destinatarioServizioCaricato.getDestinatarioServizio().getDestinatario());
			destinatarioServizioCaricato.setDestinatarioServizio(destinatarioServizioVo);
			destinatarioServizioList.add(destinatarioServizioCaricato);
		}
		return Response.ok(destinatarioServizioList).build();
	}

	private DestinatarioServizioCaricato verificaInserisceDestinatario(Destinatario destinatario , Long idServizio){
		DestinatarioServizioCaricato destinatarioServizioCaricato = new DestinatarioServizioCaricato();
		destinatarioServizioCaricato.setDestinatarioServizio(new DestinatarioServizio());
		if(codiceFiscaleDiversoDati(destinatario)){
			destinatario.setIdDestinatario(0L);
			SerseTDestinatarioDTO destinatarioDTO = mybatisMapper.toSerseTDestinatarioDTO(destinatario);
			destinatarioServizioCaricato.getDestinatarioServizio().setDestinatario(voMapper.destinatarioToVo(destinatarioDTO));
			destinatarioServizioCaricato.setStato("400");
			destinatarioServizioCaricato.setDescription("Esiste già un destinatario con stessi dati anagrafici e diverso CF");
			return destinatarioServizioCaricato;
		}
		String msg = controlliFormali(destinatario);
		if(msg != null){
			destinatario.setIdDestinatario(0L);
			destinatarioServizioCaricato.getDestinatarioServizio().setDestinatario(destinatario);
			destinatarioServizioCaricato.setStato("400");
			destinatarioServizioCaricato.setDescription(msg);
			return destinatarioServizioCaricato;
		}

		SerseTDestinatarioSelector destinatarioSelector = new SerseTDestinatarioSelector();
		SerseTDestinatarioSelector.Criteria destinatarioCriteria = destinatarioSelector.createCriteria();
		destinatarioCriteria.andCfDestinatarioEqualTo(destinatario.getCodiceFiscaleDestinatario());
		List<SerseTDestinatarioDTO> destinatarioDTOS = destinatarioDAOGenerato.selectByExample(destinatarioSelector);

		if(destinatarioDTOS.isEmpty()){
			destinatario.setIdDestinatario(destinatarioDAOGenerato.getNextValIdDestinatario());
			destinatario.setDInserim(destinatarioDAOGenerato.getNow());
			destinatario.setDAggiorn(destinatario.getDInserim());
			destinatario.setCodUserAggiorn(destinatario.getCodUserInserim());
			SerseTDestinatarioDTO destinatarioDTO = mybatisMapper.toSerseTDestinatarioDTO(destinatario);

			int risp = destinatarioDAOGenerato.insert(destinatarioDTO);
			if(risp == 1){
				destinatarioServizioCaricato.getDestinatarioServizio().setDestinatario(voMapper.destinatarioToVo(destinatarioDTO));
				destinatarioServizioCaricato.setStato("200");
			}else{
				destinatario.setIdDestinatario(0L);
				destinatarioServizioCaricato.getDestinatarioServizio().setDestinatario(voMapper.destinatarioToVo(destinatarioDTO));
				destinatarioServizioCaricato.setStato("401");
			}

		}else{
			destinatario.setIdDestinatario(destinatarioDTOS.get(0).getIdDestinatario());
			destinatario.setDInserim(destinatarioDTOS.get(0).getdInserim());
			SerseTDestinatarioDTO destTmp=destinatarioDTOS.get(0);

			int ris = aggiornaDatiAnagrafica(destinatario, destTmp);
			if(ris==1) {
				destinatarioServizioCaricato.getDestinatarioServizio().setDestinatario(voMapper.destinatarioToVo(destinatarioDTOS.get(0)));
				destinatarioServizioCaricato.setStato("210");
			}else{
				destinatario.setIdDestinatario(0L);
				destinatarioServizioCaricato.getDestinatarioServizio().setDestinatario(voMapper.destinatarioToVo(destinatarioDTOS.get(0)));
				destinatarioServizioCaricato.setStato("401");
			}
		}

		SerseRDestinatarioServizioSelector destinatarioServizioSelector=new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria criteria=destinatarioServizioSelector.createCriteria();

		criteria.andIdDestinatarioEqualTo(destinatario.getIdDestinatario());
		criteria.andIdServizioEqualTo(idServizio);
		List<SerseRDestinatarioServizioDTO> destinatarioServizioDTOList= destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
		if(!destinatarioServizioDTOList.isEmpty()){
			destinatarioServizioCaricato.setStato("201");
			destinatarioServizioCaricato.setDescription("il destinatario è già associato al servizio i dati sono stati aggiornati");
			
			aggiornaDatiAnagrafica(destinatario,destinatarioDTOS.get(0));
		}
		return destinatarioServizioCaricato;
	}
	
	// 2025-02 LV
	// prevengo eccezioni dovute a errori formali
	// anche perchè è difficile intercettare le eccezioni SQL, vengono date solo alla chiusura della transazione
	String controlliFormali(Destinatario destinatario) {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotBlank(destinatario.getCodiceFiscaleDestinatario()) && destinatario.getCodiceFiscaleDestinatario().length() > 16) {
			sb.append("CF troppo lungo ");
		}
		if (destinatario.getCodiceFiscaleDestinatario() != null && !destinatario.getCodiceFiscaleDestinatario().matches("^\\S*$")) {
			sb.append("CF non deve contenere spazi ");
		}
		if (StringUtils.isNotBlank(destinatario.getCapDomicilio())) {
			destinatario.setCapDomicilio(destinatario.getCapDomicilio().trim());
			if (!StringUtils.isNumeric(destinatario.getCapDomicilio())) {
				sb.append("CAP Domicilio non numerico ");
			} else if (Long.valueOf(destinatario.getCapDomicilio()) > 99999) {
				sb.append("CAP Domicilio troppo  lungo");
			}
		}
		if (StringUtils.isNotBlank(destinatario.getCapResidenza())) {
			destinatario.setCapResidenza(destinatario.getCapResidenza().trim());
			if (!StringUtils.isNumeric(destinatario.getCapResidenza())) {
				sb.append("CAP Residenza non numerico ");
			} else if (Long.valueOf(destinatario.getCapResidenza()) > 99999) {
				sb.append("CAP Residenza troppo  lungo");
			}
		}
		if (StringUtils.isNotBlank(destinatario.getCognomeDestinatario()) && destinatario.getCognomeDestinatario().length() > 100) {
			sb.append("Cognome troppo lungo ");
		}
		if (StringUtils.isNotBlank(destinatario.getNomeDestinatario()) && destinatario.getNomeDestinatario().length() > 100) {
			sb.append("Nome troppo lungo ");
		}
		if (destinatario.getComuneNascita() != null) {
			if ("undefined".equalsIgnoreCase(destinatario.getComuneNascita().getCodiceIstatComune())) {
				sb.append("Comune nascita non riconosciuto ");
			} else if (StringUtils.isNotBlank(destinatario.getComuneNascita().getCodiceIstatComune()) && destinatario.getComuneNascita().getCodiceIstatComune().length() > 6) {
				sb.append("Codice istat comune nascita troppo lungo ");
			}
		}
		if (destinatario.getComuneResidenza() != null) {
			if ("undefined".equalsIgnoreCase(destinatario.getComuneResidenza().getCodiceIstatComune())) {
				sb.append("Comune residenza non riconosciuto ");
			} else if (StringUtils.isNotBlank(destinatario.getComuneResidenza().getCodiceIstatComune()) && destinatario.getComuneResidenza().getCodiceIstatComune().length() > 6) {
				sb.append("Codice istat comune residenza troppo lungo ");
			}
		}
		if (destinatario.getComuneDomicilio() != null) {
			if ("undefined".equalsIgnoreCase(destinatario.getComuneDomicilio().getCodiceIstatComune())) {
				sb.append("Comune domicilio non riconosciuto ");
			} else if (StringUtils.isNotBlank(destinatario.getComuneDomicilio().getCodiceIstatComune()) && destinatario.getComuneDomicilio().getCodiceIstatComune().length() > 6) {
				sb.append("Codice istat comune domicilio troppo lungo ");
			}
		}
		if (StringUtils.isNotBlank(destinatario.getDescrCittaEsteraNascita()) && destinatario.getDescrCittaEsteraNascita().length() > 100) {
			sb.append("Descrizione città estera nascita troppo lunga ");
		}
		if (StringUtils.isNotBlank(destinatario.getDescrCittaEsteraResidenza()) && destinatario.getDescrCittaEsteraResidenza().length() > 100) {
			sb.append("Descrizione città estera residenza troppo lunga ");
		}
		if (StringUtils.isNotBlank(destinatario.getIndirizzoResidenza()) && destinatario.getIndirizzoResidenza().length() > 100) {
			sb.append("Indirizzo residenza troppo lungo ");
		}
		if (StringUtils.isNotBlank(destinatario.getIndDomicilio()) && destinatario.getIndDomicilio().length() > 100) {
			sb.append("Indirizzo domicilio troppo lungo ");
		}
		if (StringUtils.isNotBlank(destinatario.getRecapitoMail()) && destinatario.getRecapitoMail().length() > 100) {
			sb.append("Recapito email troppo lungo ");
		}
		if (StringUtils.isNotBlank(destinatario.getRecapitoTelefonico()) && destinatario.getRecapitoTelefonico().length() > 50) {
			sb.append("Recapito telefonico troppo lungo ");
		}
		if (StringUtils.isBlank(destinatario.getRecapitoMail()) && StringUtils.isBlank(destinatario.getRecapitoTelefonico())) {
			sb.append("Almeno un recapito deve essere valorizzato ");
		}
		if (StringUtils.isNotBlank(destinatario.getCodCittadinanza()) && destinatario.getCodCittadinanza().length() > 3) {
			sb.append("Codice cittadinanza troppo lungo ");
		}
		return sb.isEmpty() ? null : sb.toString();
	}

	private int aggiornaDatiAnagrafica(Destinatario destinatario,SerseTDestinatarioDTO destTmp){
		if(destinatario.getRecapitoMail()!=null){
			destTmp.setRecapitoEmail(destinatario.getRecapitoMail());
		}
		if(destinatario.getRecapitoTelefonico()!=null){
			destTmp.setRecapitoTelefonico(destinatario.getRecapitoTelefonico());
		}
		if(destinatario.getIndDomicilio()!=null) {
			destTmp.setIndirizzoDomicilio(destinatario.getIndDomicilio());
		}
		if(destinatario.getComuneDomicilio()!=null && destinatario.getComuneDomicilio().getCodiceIstatComune()!=null) {
			destTmp.setCodIstatComuneDomicilio(destinatario.getComuneDomicilio().getCodiceIstatComune());
		}
		if(destinatario.getCapDomicilio()!=null) {
			Long capTmp = Long.parseLong(destinatario.getCapDomicilio());
			destTmp.setCapDomicilio(capTmp);
		}
		if(destinatario.getCapResidenza()!=null) {
			destTmp.setCapResidenza(Long.parseLong(destinatario.getCapResidenza()));
		}
		destTmp.setIndirizzoResidenza(destinatario.getIndirizzoResidenza());
		if(destinatario.getComuneResidenza()!=null) {
			destTmp.setCodIstatComuneResidenza(destinatario.getComuneResidenza().getCodiceIstatComune());
		}
		if(destinatario.getStatoEsteroResidenza()!=null){
			destTmp.setCodStatoEsteroResidenza(destinatario.getStatoEsteroResidenza().getCodStato());
			destTmp.setDescrCittaEsteraResidenza(destinatario.getDescrCittaEsteraResidenza());
			destTmp.setIndirizzoResidenza(null);
			destTmp.setCodIstatComuneResidenza(null);
			//destTmp.setCapResidenza(null);
		}else {
			destTmp.setCodStatoEsteroResidenza(null);
			destTmp.setDescrCittaEsteraResidenza(null);
		}
		destTmp.setCodCittadinanza(destinatario.getCodCittadinanza());
		return destinatarioDAOGenerato.updateByPrimaryKey(destTmp);
	}

	//verifica se i dati a caricare esiste in DB con codice fiscale diverso
	private boolean codiceFiscaleDiversoDati(Destinatario destinatario){
		boolean risp = false;
		SerseTDestinatarioSelector destinatarioSelector = new SerseTDestinatarioSelector();
		SerseTDestinatarioSelector.Criteria destinatarioCriteria = destinatarioSelector.createCriteria();
		destinatarioCriteria.andCfDestinatarioNotEqualTo(destinatario.getCodiceFiscaleDestinatario());
		destinatarioCriteria.andNomeDestinatarioEqualTo(destinatario.getNomeDestinatario());
		destinatarioCriteria.andCognomeDestinatarioEqualTo(destinatario.getCognomeDestinatario());
		destinatarioCriteria.andDNascitaEqualTo(destinatario.getDNascita());
		if(destinatario.getComuneNascita()!=null){
			destinatarioCriteria.andCodIstatComuneNascitaEqualTo(destinatario.getComuneNascita().getCodiceIstatComune());
		}
		if(destinatario.getStatoEsteroNascita()!=null){
			destinatarioCriteria.andCodStatoEsteroNascitaEqualTo(destinatario.getStatoEsteroNascita().getCodStato());
		}

		List<SerseTDestinatarioDTO> destinatarioDTOS = destinatarioDAOGenerato.selectByExample(destinatarioSelector);

		if(!destinatarioDTOS.isEmpty()){
			risp = true;
		}

		return risp;
	}

	public Response getIncontriForDestinatario(Long idDestinatario){
		List<IncontroDTO> incontroDTOList= destinatariCustom.getIncontriForDestinatario(idDestinatario);
		if(incontroDTOList.isEmpty()){
			return Response.ok(incontroDTOList).build();

		}
		return Response.ok(genericMapper.mapListIncontri(incontroDTOList)).build();
	}
	/*
	 * FPL-SERSE-SER-CDU-017-V01-
	 * Gestione Target Destinatari Servizio

	 */

	public Response getTargetDestinatariForIdServizio(Long idServizio){
		List<String> parametriMancanti= new ArrayList<>();
		if(idServizio==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		return Response.ok(targetDAO.getElencoTargetDestinatariForIdServizio(idServizio)).build();
	}

	public Response getTargetDestinatariForIdIntervento(Long idIntervento){
		List<String> parametriMancanti= new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		return Response.ok(targetDAO.getElencoTargetDestinatariForIdIntervento(idIntervento)).build();
	}


	public Response getElencoTargetDestinatariForPSOServizio(Long idPso, Long idServizio, Boolean isModificabile ) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}

		if(idServizio==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_SERVIZIO);
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
				return Response.ok(targetDAO.getElencoTargetDestinatariForModelloServizioPso(idPso, interventoDTO.getIdModelloDiIntervento())).build();
			}
		}
		return Response.ok(targetDAO.getElencoTargetDestinatariForPSOServizio(idPso, idServizio)).build();


	}

	@Transactional
	public Response deleteTargetDestinatarioServizio(List<TargetDestinatariServizio> body) {
		int intRisp = 0;
		Long idServizio = null;
		String cf = null;
		for(TargetDestinatariServizio targetDestinatarioServizio:body) {
			SerseRServizioPsoTargetDestinatarioDTO servizioPsoTargetDestinatarioDTO = new SerseRServizioPsoTargetDestinatarioDTO();
			servizioPsoTargetDestinatarioDTO.setIdServizio(targetDestinatarioServizio.getIdServizio());
			servizioPsoTargetDestinatarioDTO.setIdPso(targetDestinatarioServizio.getIdPso());
			servizioPsoTargetDestinatarioDTO.setIdTargetDestinatario(targetDestinatarioServizio.getTargetdestinatario().getIdTargetDestinatario());
			try {
				intRisp += servizioPsoTargetDestDAOGenerato.deleteByPrimaryKey(servizioPsoTargetDestinatarioDTO);
			} finally {
				idServizio = targetDestinatarioServizio.getIdServizio();
				cf = targetDestinatarioServizio.getCodiceFiscaleUtente();
			}
		}

		if(intRisp > 0) {
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);

			servizioDTO.setCodUserAggiorn(cf);
			servizioDTO.setdAggiorn(servizioDAOGenerato.getNow());

			servizioDAOGenerato.updateByPrimaryKey(servizioDTO);
			GenericResponse risposta=new GenericResponse();
			risposta.setMessage(RISPOSTE_RESPONSE.INSERIMENTO_SUCCES);
			return Response.ok(risposta).build();
		}else {
			return internalServerError();
		}
	}

	@Transactional
	public Response insertTargetDestinatarioServizio(List<TargetDestinatariServizio> body) {
		int intRisp = 0;
		Long idServizio = null;
		String cf = null;
		for(TargetDestinatariServizio targetDestinatarioServizio:body) {
			SerseRServizioPsoTargetDestinatarioDTO servizioPsoTargetDestinatarioDTO = new SerseRServizioPsoTargetDestinatarioDTO();
			servizioPsoTargetDestinatarioDTO.setIdServizio(targetDestinatarioServizio.getIdServizio());
			servizioPsoTargetDestinatarioDTO.setIdPso(targetDestinatarioServizio.getIdPso());
			servizioPsoTargetDestinatarioDTO.setIdTargetDestinatario(targetDestinatarioServizio.getTargetdestinatario().getIdTargetDestinatario());
			servizioPsoTargetDestinatarioDTO.setCodUserInserim(targetDestinatarioServizio.getCodiceFiscaleUtente());
			servizioPsoTargetDestinatarioDTO.setdInserim(servizioPsoTargetDestDAOGenerato.getNow());
			servizioPsoTargetDestinatarioDTO.setCodUserAggiorn(targetDestinatarioServizio.getCodiceFiscaleUtente());
			servizioPsoTargetDestinatarioDTO.setdAggiorn(servizioPsoTargetDestDAOGenerato.getNow());
			try {
				intRisp += servizioPsoTargetDestDAOGenerato.insert(servizioPsoTargetDestinatarioDTO);
			} finally {
				idServizio = targetDestinatarioServizio.getIdServizio();
				cf = targetDestinatarioServizio.getCodiceFiscaleUtente();
			}


		}

		if(intRisp > 0) {
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);

			servizioDTO.setCodUserAggiorn(cf);
			servizioDTO.setdAggiorn(servizioDAOGenerato.getNow());

			servizioDAOGenerato.updateByPrimaryKey(servizioDTO);
			GenericResponse risposta=new GenericResponse();
			risposta.setMessage(RISPOSTE_RESPONSE.INSERIMENTO_SUCCES);
			return Response.ok(risposta).build();
		}else {
			return internalServerError();
		}

	}

    /*
        FPL-SERSE-SER-CDU-026-V01-Gestione Destinatari Servizio
     */
    public Response getDestinatarioServizio(Long idServizio) {
        List<String> parametriMancanti= new ArrayList<>();
        if(idServizio==null) {
            parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
        }
        if(!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        List<SerseTDestinatarioDTO> destinatariDTO= destinatariCustom.getDestinatarioServizio(idServizio);
        List<Destinatario> destinatari = new ArrayList<>();
        for (SerseTDestinatarioDTO destinatarioDTO : destinatariDTO) {
            destinatari.add(voMapper.destinatarioToVo(destinatarioDTO));
        }

        return Response.ok(destinatari).build();
    }

	public Response getDestinatariServiziServizio(Long idServizio){
		List<String> parametriMancanti= new ArrayList<>();
		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
		destinatarioServizioSelector.setOrderByClause("d_inserim,numerazione_destinatario");
		SerseRDestinatarioServizioSelector.Criteria destinatarioCriteria = destinatarioServizioSelector.createCriteria();
		destinatarioCriteria.andIdServizioEqualTo(idServizio);

		List<SerseRDestinatarioServizioDTO>  destinatariServizioDTO = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
		List<DestinatarioServizio> destinatariServizi = new ArrayList<>();
		for(SerseRDestinatarioServizioDTO destinatarioServizi: destinatariServizioDTO) {
			destinatariServizi.add(voMapper.destinatariServizioToVo(destinatarioServizi));
		}
		return Response.ok(destinatariServizi).build();
	}


    @Transactional
    public Response disassociaDestinatarioServizio(Long idServizio, Long idDestinatario) {
        List<String> parametriMancanti= new ArrayList<>();

        if(idServizio==null) {
            parametriMancanti.add(Constants.INPUT_MISSING.ID_SERVIZIO);
        }

        if(idDestinatario==null) {
            parametriMancanti.add(INPUT_MISSING.ID_DESTINATARIO);
        }

        if(!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        List<SerseRIncontroDestinatarioServizioDTO> incontriDestinatarioServizioDTO = destinatariCustom.getIncontroDestinatarioServizio(idServizio, idDestinatario);
        GenericResponse risposta=new GenericResponse();
        if(!incontriDestinatarioServizioDTO.isEmpty()){
            risposta.setMessage("Attenzione: non è possibile eliminare l’associazione perché il destinatario è coinvolto in almeno un incontro relativo al servizio");
            return Response.ok(risposta).build();
        }

        SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
        SerseRDestinatarioServizioSelector.Criteria destinatarioCriteria = destinatarioServizioSelector.createCriteria();
        destinatarioCriteria.andIdDestinatarioEqualTo(idDestinatario);
        destinatarioCriteria.andIdServizioEqualTo(idServizio);

        List<SerseRDestinatarioServizioDTO>  destinatariServizioDTO = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
        int risp = 0;
        for (SerseRDestinatarioServizioDTO destinatarioServizioDTO: destinatariServizioDTO) {
            risp += destinatarioServizioMonitoraggioDAOGenerato.deleteByPrimaryKey(destinatarioServizioDTO.getIdDestinatarioServizio());
            risp += destinatarioServizioDAOGenerato.deleteByPrimaryKey(destinatarioServizioDTO.getIdDestinatarioServizio());
        }

        if (risp == 0){
            return null;
        }else{
            risposta.setMessage(RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
        }

        return Response.ok(risposta).build();
    }

    @Transactional
    public Response salvaDatiPeculiari(DatiPeculiari body) {

        SerseRDestinatarioServizioDTO destinatarioServizioDTOperSalvare = mybatisMapper.map(body.getDestinatarioServizio());

        SerseRDestinatarioServizioMonitoraggioDTO destinatarioServizioMonitoraggioDTOperSalvare = mybatisMapper.map(body.getDestinatarioServizioMonitoraggio());

        SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
        SerseRDestinatarioServizioSelector.Criteria destinatarioCriteria = destinatarioServizioSelector.createCriteria();
        destinatarioCriteria.andIdDestinatarioEqualTo(body.getDestinatarioServizio().getDestinatario().getIdDestinatario());
        destinatarioCriteria.andIdServizioEqualTo(body.getDestinatarioServizio().getIdServizio());
        List<SerseRDestinatarioServizioDTO>  destinatariServizioDTO = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);

        int risp = 0;

        if(destinatariServizioDTO.isEmpty()){
            destinatarioServizioDTOperSalvare.setIdDestinatarioServizio(destinatarioServizioDAOGenerato.getNextValIdDestinatarioServizio());
			destinatarioServizioDTOperSalvare.setNumerazioneDestinatario(destinatarioServizioDAOGenerato.getNextNumerazioneDestinatario(body.getDestinatarioServizio().getIdServizio()));
            destinatarioServizioDTOperSalvare.setdInserim(destinatarioServizioDAOGenerato.getNow());
            destinatarioServizioDTOperSalvare.setdAggiorn(destinatarioServizioDTOperSalvare.getdInserim());
            risp += destinatarioServizioDAOGenerato.insert(destinatarioServizioDTOperSalvare);

            destinatarioServizioMonitoraggioDTOperSalvare.setIdDestinatarioServizio(destinatarioServizioDTOperSalvare.getIdDestinatarioServizio());
            destinatarioServizioMonitoraggioDTOperSalvare.setdInserim(destinatarioServizioDAOGenerato.getNow());
            destinatarioServizioMonitoraggioDTOperSalvare.setdAggiorn(destinatarioServizioDTOperSalvare.getdInserim());
			destinatarioServizioMonitoraggioDTOperSalvare.setCodCittadinanza(body.getDestinatarioServizioMonitoraggio().getCodiceCitadinanza());
            risp += destinatarioServizioMonitoraggioDAOGenerato.insert(destinatarioServizioMonitoraggioDTOperSalvare);

        } else {
            destinatarioServizioDTOperSalvare.setIdDestinatarioServizio(destinatariServizioDTO.get(0).getIdDestinatarioServizio());
			destinatarioServizioDTOperSalvare.setNumerazioneDestinatario(destinatariServizioDTO.get(0).getNumerazioneDestinatario());
			destinatarioServizioDTOperSalvare.setdInserim(body.getDestinatarioServizio().getDInserim());
			destinatarioServizioDTOperSalvare.setCodUserInserim(body.getDestinatarioServizio().getCodUserInserim());
            destinatarioServizioDTOperSalvare.setdAggiorn(destinatarioServizioDAOGenerato.getNow());
            risp += destinatarioServizioDAOGenerato.updateByPrimaryKey(destinatarioServizioDTOperSalvare);

            SerseRDestinatarioServizioMonitoraggioDTO destinatarioServizioMonitoraggioDTO = destinatarioServizioMonitoraggioDAOGenerato.selectByPrimaryKey(destinatarioServizioDTOperSalvare.getIdDestinatarioServizio());
            if(destinatarioServizioMonitoraggioDTO == null){
                destinatarioServizioMonitoraggioDTOperSalvare.setIdDestinatarioServizio(destinatarioServizioDTOperSalvare.getIdDestinatarioServizio());
                destinatarioServizioMonitoraggioDTOperSalvare.setdInserim(destinatarioServizioDAOGenerato.getNow());
                destinatarioServizioMonitoraggioDTOperSalvare.setdAggiorn(destinatarioServizioDTOperSalvare.getdInserim());
				destinatarioServizioMonitoraggioDTOperSalvare.setCodCittadinanza(body.getDestinatarioServizioMonitoraggio().getCodiceCitadinanza());
				risp += destinatarioServizioMonitoraggioDAOGenerato.insert(destinatarioServizioMonitoraggioDTOperSalvare);
            }else {
                destinatarioServizioMonitoraggioDTOperSalvare.setIdDestinatarioServizio(destinatarioServizioDTOperSalvare.getIdDestinatarioServizio());
                destinatarioServizioMonitoraggioDTOperSalvare.setdInserim(destinatarioServizioMonitoraggioDTO.getdInserim());
                destinatarioServizioMonitoraggioDTOperSalvare.setdAggiorn(destinatarioDAOGenerato.getNow());
				destinatarioServizioMonitoraggioDTOperSalvare.setCodCittadinanza(body.getDestinatarioServizioMonitoraggio().getCodiceCitadinanza());
				risp += destinatarioServizioMonitoraggioDAOGenerato.updateByPrimaryKey(destinatarioServizioMonitoraggioDTOperSalvare);
            }

        }
        GenericResponse risposta=new GenericResponse();
        if(risp == 2){
            risposta.setMessage(RISPOSTE_RESPONSE.MODIFICA_SUCCES);
        }else{
            risposta.setMessage(RISPOSTE_RESPONSE.ERRORE);
        }

        return Response.ok(risposta).build();
    }

    public Response getDestinatarioServizioDatiPeculiari(Long idDestinatario, Long idServizio, Long numProgrSportello, Long idPso) {
        List<String> parametriMancanti = new ArrayList<>();
        if (idPso == null) {
            parametriMancanti.add(INPUT_MISSING.ID_PSO);
        }

        if (numProgrSportello == null) {
            parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
        }
        if(!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        DatiPeculiariWrapper datiPeculiariWrapper = new DatiPeculiariWrapper();
        DestinatarioServizio destinatarioServizio = new DestinatarioServizio();
        DestinatarioServizioMonitoraggio destinatarioServizioMonitoraggio = new DestinatarioServizioMonitoraggio();

        if (idDestinatario != null) {
            SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
            SerseRDestinatarioServizioSelector.Criteria destinatarioCriteria = destinatarioServizioSelector.createCriteria();
            destinatarioCriteria.andIdDestinatarioEqualTo(idDestinatario);
            destinatarioCriteria.andIdServizioEqualTo(idServizio);
            List<SerseRDestinatarioServizioDTO>  destinatariServizioDTO = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
			if(!destinatariServizioDTO.isEmpty() ) {
				destinatarioServizio = mybatisMapper.map(destinatariServizioDTO.get(0));
				destinatarioServizio.setDestinatario(voMapper.destinatarioToVo(destinatarioDAOGenerato.selectByPrimaryKey(idDestinatario)));
				SerseRDestinatarioServizioMonitoraggioDTO destinatarioServizioMonitoraggioDTO = destinatarioServizioMonitoraggioDAOGenerato.selectByPrimaryKey(destinatariServizioDTO.get(0).getIdDestinatarioServizio());

				if (destinatarioServizioMonitoraggioDTO != null) {
					destinatarioServizioMonitoraggio = mybatisMapper.map(destinatarioServizioMonitoraggioDTO);
				}
			}
        }

        SerseDRegComportPsoSportSelector regComportPsoSportSelector = new SerseDRegComportPsoSportSelector();
        SerseDRegComportPsoSportSelector.Criteria regComportPsoSportCriteria = regComportPsoSportSelector.createCriteria();
        regComportPsoSportCriteria.andIdPsoEqualTo(idPso);
        regComportPsoSportCriteria.andNumProgrSportelloEqualTo(numProgrSportello);
        List<SerseDRegComportPsoSportDTO> regComportPsoSportDTOS = serseDRegComportPsoSportDAOGenerato.selectByExample(regComportPsoSportSelector);

        RegComportPsoSport regComportPsoSport = new RegComportPsoSport();
        SportMonitoraggio sportMonitoraggio = new SportMonitoraggio();
        if(!regComportPsoSportDTOS.isEmpty()) {
            regComportPsoSport = mybatisMapper.map(regComportPsoSportDTOS.get(0));

            SerseDSportMonitoraggioDTO sportMonitoraggioDTO = sportMonitoraggioDAOGenerato.selectByPrimaryKey(regComportPsoSportDTOS.get(0).getIdRegComportPsoSport());
            if(sportMonitoraggioDTO != null){
				sportMonitoraggio = mybatisMapper.map(sportMonitoraggioDTO);
			}

        }

		DettaglioClasseDestinatarioServizio dettaglioClasse = getDettaglioClasseServizioForDestinatario(idServizio, idPso, idDestinatario);

		datiPeculiariWrapper.setDettaglioClasseDestinatario(dettaglioClasse);
        datiPeculiariWrapper.setDestinatarioServizio(destinatarioServizio);
        datiPeculiariWrapper.setDestinatarioServizioMonitoraggio(destinatarioServizioMonitoraggio);
        datiPeculiariWrapper.setRegComportPsoSport(regComportPsoSport);
        datiPeculiariWrapper.setSportMonitoraggio(sportMonitoraggio);
        return Response.ok(datiPeculiariWrapper).build();
    }


    public Response getCondizioneOccupazionaleIgrue() { 
		SerseDCondizioneOccupazionaleSelector occupazionaleSelector = new SerseDCondizioneOccupazionaleSelector();
		occupazionaleSelector.setOrderByClause("descr_condizione_occupazionale");
        List<SerseDCondizioneOccupazionaleDTO> condizioneOccupazionaleDTOS = condizioneOccupazionaleDAOGenerato.selectByExample(occupazionaleSelector);
		// TODO usare mapper
		List<CondizioneOccupazionaleIgrue> condizioneOccupazionaleIgrues = new ArrayList<>();
		for (SerseDCondizioneOccupazionaleDTO condizioneOccupazionaleDTO: condizioneOccupazionaleDTOS) {
			CondizioneOccupazionaleIgrue condizioneOccupazionaleVO= new CondizioneOccupazionaleIgrue();
			condizioneOccupazionaleVO.setCodCondizioneOccupazionaleIgrue(condizioneOccupazionaleDTO.getCodCondizioneOccupazionale());
			condizioneOccupazionaleVO.setDescrCondizioneOccupazionaleIgrue(condizioneOccupazionaleDTO.getDescrCondizioneOccupazionale());
			condizioneOccupazionaleIgrues.add(condizioneOccupazionaleVO);
		}
		return Response.ok(condizioneOccupazionaleIgrues).build();
    }

    public Response getTitoliStudioIgrue() {
		SerseDLivelloIstruzioneSelector livelloIstruzioneSelector = new SerseDLivelloIstruzioneSelector();
		livelloIstruzioneSelector.setOrderByClause("descr_livello_istruzione");
		List<SerseDLivelloIstruzioneDTO> serseDLivelloIstruzioneDTOList = livelloIstruzioneDAOGenerato.selectByExample(livelloIstruzioneSelector);
		// TODO usare mapper
        List<TitoloStudioIgrue> titoloStudioIgrueList = new ArrayList<>();
		for (SerseDLivelloIstruzioneDTO serseDLivelloIstruzioneDTO: serseDLivelloIstruzioneDTOList) {
			TitoloStudioIgrue titoloStudioIgrue = new TitoloStudioIgrue();
			titoloStudioIgrue.setCodTitoloStudioIgrue(serseDLivelloIstruzioneDTO.getCodLivelloIstruzione());
			titoloStudioIgrue.setDescrTitoloStudioIgrue(serseDLivelloIstruzioneDTO.getDescrLivelloIstruzione());

			titoloStudioIgrueList.add(titoloStudioIgrue);
		}
        return Response.ok(titoloStudioIgrueList).build();
    }

	public Response getClassiDestinatario(Long idPso) {
		List<String> parametriMancanti= new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		} 

		if(!parametriMancanti.isEmpty()) return parametriObbligatoriMancanti(parametriMancanti);

		return Response.ok(destinatariCustom.getClassiDestinatario(idPso)).build();

	}


    /*
        FPL-SERSE-SER-CDU-039-V01-Verifica Servizi per Destinatario (ricerca, elenco, dettaglio)
     */
    public Response getServiziForIdDestinatario(Long idDestinatario){
		List<String> parametriMancanti = new ArrayList<>();

		if (idDestinatario == null) {
			parametriMancanti.add(INPUT_MISSING.ID_DESTINATARIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<Servizio> servizioVoS = new ArrayList<>();
		SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria = destinatarioServizioSelector.createCriteria();
		destinatarioServizioCriteria.andIdDestinatarioEqualTo(idDestinatario);
		List<SerseRDestinatarioServizioDTO> destinatarioServizioDTOS = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
		destinatarioServizioDTOS.forEach(destinatarioServizioDTO->{
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(destinatarioServizioDTO.getIdServizio());
			servizioVoS.add(voMapper.servizioToVo(servizioDTO));
		});
		return Response.ok(servizioVoS).build();
    }

	public Response getServiziForIdDestinatarioIdIntervento(Long idDestinatario, Long idIntervento){
		List<String> parametriMancanti = new ArrayList<>();

		if (idDestinatario == null) {
			parametriMancanti.add(INPUT_MISSING.ID_DESTINATARIO);
		}

		if (idIntervento == null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<Servizio> servizioVoS = new ArrayList<>();
		SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria = destinatarioServizioSelector.createCriteria();
		destinatarioServizioCriteria.andIdDestinatarioEqualTo(idDestinatario);
		List<SerseRDestinatarioServizioDTO> destinatarioServizioDTOS = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
		destinatarioServizioDTOS.forEach(destinatarioServizioDTO->{
			SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(destinatarioServizioDTO.getIdServizio());
			if(servizioDTO.getIdIntervento() != null && servizioDTO.getIdIntervento().equals(idIntervento))
				servizioVoS.add(voMapper.servizioToVo(servizioDTO));
		});
		return Response.ok(servizioVoS).build();
	}

    /*
		FPL-SERSE-INT-CDU-037-V04-elenco destinatari presenti nei servizi associati all'intervento
	 */

	public Response getDestinatariIntervento(Long idIntervento){
		List<String> parametriMancanti= new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<SerseTDestinatarioDTO> destinatariDTO= destinatariCustom.getDestinatariIntervento(idIntervento);
		List<Destinatario> destinatari = new ArrayList<>();
		for (SerseTDestinatarioDTO destinatarioDTO : destinatariDTO) {
			destinatari.add(voMapper.destinatarioToVo(destinatarioDTO));
		}

		return Response.ok(destinatari).build();
	}

	public Response getDestinatarioServizioDatiPeculiariMancanti(Long idServizio, Long numProgrSportello, Long idPso){
		List<String> parametriMancanti = new ArrayList<>();

		if (idPso == null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}

		if (numProgrSportello == null) {
			parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<Destinatario> destinatarioList= new ArrayList<>();

		SerseDRegComportPsoSportSelector regComportPsoSportSelector = new SerseDRegComportPsoSportSelector();
		SerseDRegComportPsoSportSelector.Criteria regComportPsoSportCriteria = regComportPsoSportSelector.createCriteria();
		regComportPsoSportCriteria.andIdPsoEqualTo(idPso);
		regComportPsoSportCriteria.andNumProgrSportelloEqualTo(numProgrSportello);
		List<SerseDRegComportPsoSportDTO> regComportPsoSportDTOS = serseDRegComportPsoSportDAOGenerato.selectByExample(regComportPsoSportSelector);

		SportMonitoraggio sportMonitoraggio = null;

		if(!regComportPsoSportDTOS.isEmpty()) {
			SerseDSportMonitoraggioDTO sportMonitoraggioDTO = sportMonitoraggioDAOGenerato.selectByPrimaryKey(regComportPsoSportDTOS.get(0).getIdRegComportPsoSport());
			if(sportMonitoraggioDTO != null) {
				sportMonitoraggio = mybatisMapper.map(sportMonitoraggioDTO);
			}
		}
		if(sportMonitoraggio!=null && !verificaSportelloMonitoraggio(sportMonitoraggio) ){
			return Response.ok(destinatarioList).build();
		}
		SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria destinatarioCriteria = destinatarioServizioSelector.createCriteria();
		destinatarioCriteria.andIdServizioEqualTo(idServizio);
		List<SerseRDestinatarioServizioDTO>  destinatarioServizioDTOS = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);

		for (SerseRDestinatarioServizioDTO destinatarioServizioDTO: destinatarioServizioDTOS) {
			DestinatarioServizio destinatarioServizio = mybatisMapper.map(destinatarioServizioDTO);
			destinatarioServizio.setDestinatario(voMapper.destinatarioToVo(destinatarioDAOGenerato.selectByPrimaryKey(destinatarioServizioDTO.getIdDestinatario())));
			SerseRDestinatarioServizioMonitoraggioDTO destinatarioServizioMonitoraggioDTO = destinatarioServizioMonitoraggioDAOGenerato.selectByPrimaryKey(destinatarioServizioDTO.getIdDestinatarioServizio());

			if (destinatarioServizioMonitoraggioDTO == null ) {

				destinatarioList.add(destinatarioServizio.getDestinatario());
			}else {
				if(verificaDatiPeculiariWrapper(destinatarioServizioMonitoraggioDTO, sportMonitoraggio)){
					destinatarioList.add(destinatarioServizio.getDestinatario());
				}
			}
		}

		return Response.ok(destinatarioList).build();
	}

	private boolean verificaDatiPeculiariWrapper(SerseRDestinatarioServizioMonitoraggioDTO destinatarioServizioMonitoraggioDTO, SportMonitoraggio sportMonitoraggio){
		if(sportMonitoraggio==null)
			return false;
		if(destinatarioServizioMonitoraggioDTO.getCodLivelloIstruzione()==null && sportMonitoraggio.getFlgTitoloStudio().equals("O"))
			return true;
		if(destinatarioServizioMonitoraggioDTO.getCodCondizioneOccupazionale()==null && sportMonitoraggio.getFlgCondizioneOccupazionale().equals("O"))
			return true;
		if(destinatarioServizioMonitoraggioDTO.getFlgSvantaggioAbitativo()==null && sportMonitoraggio.getFlgSvantaggioAbitativo().equals("O"))
			return true;
		return destinatarioServizioMonitoraggioDTO.getFlgDisabilita() == null && sportMonitoraggio.getFlgDisabilita().equals("O");
	}

	private boolean verificaSportelloMonitoraggio(SportMonitoraggio sportMonitoraggio){
		if(sportMonitoraggio.getFlgTitoloStudio()!=null &&  sportMonitoraggio.getFlgTitoloStudio().equals("O")){
			return true;
		}
		if(sportMonitoraggio.getFlgCondizioneOccupazionale()!=null &&  sportMonitoraggio.getFlgCondizioneOccupazionale().equals("O")) {
			return true;
		}
		if( sportMonitoraggio.getFlgSvantaggioAbitativo()!=null && sportMonitoraggio.getFlgSvantaggioAbitativo().equals("O")){
			return true;
		}
		return( sportMonitoraggio.getFlgDisabilita()!=null && sportMonitoraggio.getFlgDisabilita().equals("O"));
	}

    public Response rinumeraDestinatariServizio(DestinatariservizioRinumeraBody body) {
		int updated = destinatariCustom.rinumeraDestinatari(body.getIdServizio());
		if (updated == 0) {
			return noResoultFound("Servizio non esistente, o senza destinatari");
		}
		return Response.ok().build();
    }

	/** Get per il dettaglio della classe destinatario selezionata nel destinatario */ 
	private DettaglioClasseDestinatarioServizio getDettaglioClasseServizioForDestinatario(Long idServizio, Long idPso, Long idDestinatarioServizio){
		DettaglioClasseDestinatarioServizioDTO dettaglioDTO = destinatariCustom.getDettaglioClasseServizioForDestinatario(idServizio, idPso, idDestinatarioServizio);
		DettaglioClasseDestinatarioServizio dettaglio = genericMapper.map(dettaglioDTO);
		return dettaglio;
	}
}
