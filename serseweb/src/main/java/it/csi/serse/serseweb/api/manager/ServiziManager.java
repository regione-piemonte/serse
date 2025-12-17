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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneModelliDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneServiziDAO.FilterServiziSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneServiziDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.SoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DettaglioClasseDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ModelloInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioVoceSpesaDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtBdgtTPsoSportelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDFinalitaServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDPeriodoAttivazioneServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDRegComportPsoSportDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDServizioRegionaleDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDSportMonitoraggioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDStatoServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDTipoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioMonitoraggioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRIncontroDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRModelloInterventoPsoCaratteristicaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRModelloInterventoPsoTargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRPsoClasseDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRServizioFonteDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRServizioPsoCaratteristicaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRServizioPsoTargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRServizioVoceSpesaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTIncontroDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTLuogoIncontroDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioModelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioStoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTSoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTTokenGamDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtBdgtTPsoSportelloSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDPeriodoAttivazioneServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDPeriodoAttivazioneServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDSportMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDTipoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioMonitoraggioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoCaratteristicaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoCaratteristicaSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRPsoClasseDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioFonteDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioFonteSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioPsoCaratteristicaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioPsoCaratteristicaSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioPsoTargetDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioPsoTargetDestinatarioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioVoceSpesaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioVoceSpesaSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTIncontroSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioModelloSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioStoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioStoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSoggettoAttuatoreSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamSelector;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.DatiPeculiariWrapper;
import it.csi.serse.serseweb.vo.DettaglioClasseDestinatarioServizio;
import it.csi.serse.serseweb.vo.FilterParent;
import it.csi.serse.serseweb.vo.FilterServizi;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.PeriodoAttivazioneVerifica;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.ServizioModello;
import it.csi.serse.serseweb.vo.ServizioPageWrapper;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import it.csi.serse.serseweb.vo.ServizioVoceSpesa;
import it.csi.serse.serseweb.vo.ServizioWrapper;
import it.csi.serse.serseweb.vo.SportMonitoraggio;
import it.csi.serse.serseweb.vo.TestChiudiServizio;
import it.csi.serse.serseweb.vo.TestGenerico;
import it.csi.serse.serseweb.vo.TestInterventoServizio;
import jakarta.ws.rs.core.Response;

@Component
public class ServiziManager extends ParentManager {

	@Autowired
	private GenericMapper genericMapper;

	@Autowired
	private VoMapper voMapper;

	@Autowired
	private MybatisGeneretedDTOMapper mybatisDtoMapper;

	@Autowired
	private GestioneServiziDAO gestioneServiziDao;

	@Autowired
	private SoggettoAttuatoreDAO soggettoAttuatoreDAO;

	@Autowired
	private FlaianagpgHelper flaiAnag;

	@Autowired
	private SoggettoAttuatoreManager soggAttuatoreManager;


	/*DAO generati*/
	@Autowired
	private SerseDStatoServizioDAO statoServizioDAOGenerato;
	@Autowired
	private SerseDServizioRegionaleDAO servizioRegionaleDAO;

	@Autowired
	private SerseDFinalitaServizioDAO finalitaServizioDAO;

	@Autowired
	private SerseTServizioModelloDAO servizioModelloDAO;

	@Autowired
	private GestioneModelliDiInterventoDAO gestioneModelliDao;

	@Autowired
	private SerseTEnteCoinvoltoServizioDAO enteCoinvoltoServizioDAOGenerato;

	@Autowired
	private SerseTEnteCoinvoltoInterventoDAO enteCoinvoltoInterventoDAOGenerato;

	@Autowired
	private SerseRDestinatarioServizioDAO destinatarioServizioDAOGenerato;

	@Autowired
	private SerseRIncontroDestinatarioServizioDAO incontroDestinatarioServizioDAOGenerato;

	@Autowired
	private SerseTServizioDAO servizioDAOGenerato;

	@Autowired
	private SerseRServizioPsoCaratteristicaDAO servizioPsoCaratteristicaDAOGenerato;

	@Autowired
	private SerseRServizioPsoTargetDestinatarioDAO servizioPsoTargetDestinatarioDAOGenerato;

	@Autowired
	private SerseRServizioVoceSpesaDAO servizioVoceSpesaDAOGenerato;

	@Autowired
	private SerseTIncontroDAO incontroDAOGenerato;

	@Autowired
	private SerseTLuogoIncontroDAO luogoIncontroDAOGenerato;

	@Autowired
	private ExtBdgtTPsoSportelloDAO sportelloDaoGenerato;

	@Autowired
	private SerseTInterventoDAO interventoDAOGenerato;

	@Autowired
	private SerseDTipoInterventoDAO tipoInterventoDAOGenerato;

	@Autowired
	private SerseTTokenGamDAO tokenGamDAOGenerato;

	@Autowired
	private SerseRModelloInterventoPsoTargetDestinatarioDAO modInterventoPTDestDAOGenerato;

	@Autowired
	private SerseRServizioPsoTargetDestinatarioDAO servizioPTDestDAOGenerato;

	@Autowired
	private SerseRModelloInterventoPsoCaratteristicaDAO modInterventoPCarattDAOGenerato;

	@Autowired
	private SerseRServizioPsoCaratteristicaDAO servizioPsoCarattDAOGenerato;

	@Autowired
	private SerseRServizioFonteDAO servizioFonteDAOGenerato;

	@Autowired
	private SerseTSoggettoAttuatoreDAO serseTSoggettoAttuatoreDAOGenerato;

	@Autowired
	private SerseDPeriodoAttivazioneServizioDAO periodoAttivazioneServizioDAOGenerato;

	@Autowired
	private SerseTServizioStoDAO servizioStoDAOGenerato;

	@Autowired
	private SerseDRegComportPsoSportDAO serseDRegComportPsoSportDAOGenerato;

	@Autowired
	private SerseDSportMonitoraggioDAO sportMonitoraggioDAOGenerato;

	@Autowired
	private SerseTSoggettoAttuatoreDAO soggettoAttuatoreDAOGenerato;

	@Autowired
	private SerseTDestinatarioDAO destinatarioDaoGenerato;

	@Autowired
	private SerseRDestinatarioServizioMonitoraggioDAO destinatarioServizioMonitoraggioDAOGenerato;

	@Autowired
	private SerseRPsoClasseDestinatarioDAO psoClasseDestinatarioDAOGenerato;

	public Response getTipologieServiziForModelloIntervento(Long idModellointervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if(idModellointervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<ServizioModelloDTO> elencoServizi=gestioneServiziDao.getTipologieServiziForModelloIntervento(idModellointervento);

		if(elencoServizi.isEmpty()|| elencoServizi.get(0)==null  ) {
			elencoServizi.clear();
			return  Response.ok(elencoServizi).build() ;
		}

		return Response.ok(genericMapper.mapListServizioModello(elencoServizi)).build();
	}

	public Response getTipologieServiziForIntervento(Long idIntervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<ServizioRegionaleDTO> elencoServizi=gestioneServiziDao.getTipologieServiziForIntervento(idIntervento);
		if(elencoServizi!=null &&  !elencoServizi.isEmpty() && elencoServizi.get(0)!=null ) {
			return Response.ok(genericMapper.mapListServiziRegionali(elencoServizi)).build();
		}else if(elencoServizi!=null){
			elencoServizi.clear();
		}
		return Response.ok(elencoServizi).build();
	}


	/* ********************************************************************************************************
	 * Gestione Servizi Esterni
	 * **********************************************************************************************************/

	public Response getServiziEsternoForIdModelloIntervento(Long idModelloIntervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if(idModelloIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<ServizioModelloDTO> result= gestioneServiziDao.getServiziEsternoForIdModelloIntervento(idModelloIntervento);

		if(result==null || result.isEmpty()) {

			return Response.ok(result).build();
		}else {
			return Response.ok(genericMapper.mapListServizioModello(result)).build();
		}
	}

	public Response getServizioEsternoById( Long idServizioModello ) {
		ServizioModelloDTO servizioEsterno=gestioneServiziDao.getServizioEsternoById(idServizioModello);
		if(servizioEsterno==null) {
			return Response.ok(servizioEsterno).build();
		}
		ServizioModello response=genericMapper.map(servizioEsterno);

		return Response.ok(response).build();
	}

	/**
	 *
	 * @return se la chiamata va a buon fine un oggetto GenericResponse null altrimenti
	 */
	@Transactional
	public Response deleteServizioEsterno(Long idModelloIntervento,
										  String codUserAggiornamento,Long idServizioModello) {

		//controllo che i parametri obbligatori ci siano tutti
		List<String> parametriMancanti = new ArrayList<>();
		if(idModelloIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(idServizioModello==null) {
			parametriMancanti.add("idServizioModello");
		}
		if(codUserAggiornamento==null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		int risDelete=gestioneServiziDao.deleteServizioModelloById(idServizioModello);

		if(risDelete==1) {
			//se la delete è andata a buon fine aggiorno la data di aggiornamento

			ModelloInterventoDTO modelloTmp=gestioneModelliDao.getModelloDiInterventoById(idModelloIntervento);
			modelloTmp.setCodUserAggiornamento(codUserAggiornamento);
			modelloTmp.setDataAggiornamento(gestioneModelliDao.getNow());
			Integer risUpdate=gestioneModelliDao.updateModelloIntervento(modelloTmp);
			if(risUpdate==1) {
				//se l'update è andato a buon fine rispondo success

				GenericResponse success=new GenericResponse();
				success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
				return Response.ok(success).build();
			}else{
				//se l'aggiornamento non è avvenuto ritorno errore
				return internalServerError();
			}
		}
		//se la delete non è riuscita rispondo null
		return null;
	}

	@Transactional
	public Response insertServizioEsterno(ServizioModello servizioModello,
										  Long idModelloIntervento, String codUserAggiornamento) {
		//controllo che i parametri obbligatori ci siano tutti
		List<String> parametriMancanti = new ArrayList<>();
		if(idModelloIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(codUserAggiornamento==null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


		ServizioModelloDTO servizioModelloMappato= genericMapper.map(servizioModello);
		servizioModelloMappato.setAttoreEsterno(servizioModello.getAttoreEsterno());
		servizioModelloMappato.setIdServizioModello(gestioneServiziDao.getNextValIdServizioModello());
		servizioModelloMappato.setDInserim(gestioneServiziDao.getNow());
		servizioModelloMappato.setDAggiorn(gestioneServiziDao.getNow());
		int risInsert=gestioneServiziDao.insertServiziModelloEsterno(servizioModelloMappato);
		if(risInsert==1) {
			ModelloInterventoDTO modelloTmp=gestioneModelliDao.getModelloDiInterventoById(idModelloIntervento);
			modelloTmp.setCodUserAggiornamento(codUserAggiornamento);
			modelloTmp.setDataAggiornamento(gestioneModelliDao.getNow());
			Integer risUpdate=gestioneModelliDao.updateModelloIntervento(modelloTmp);
			if(risUpdate==1) {
				//restituisco l'oggetto che ho inserito
				ServizioModello servizioInserito= genericMapper.
						map(gestioneServiziDao.getServizioEsternoById
								( servizioModelloMappato.getIdServizioModello()));
				return Response.ok(servizioInserito).build();
			}

		}
		return null;
	}


	@Transactional
	public Response updateServizioEsterno(ServizioModello servizioModello,
										  Long idModelloIntervento, String codUserAggiornamento) {
		//controllo che i parametri obbligatori ci siano tutti
		List<String> parametriMancanti = new ArrayList<>();
		if(idModelloIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(codUserAggiornamento==null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTServizioModelloDTO servizioModelloMappato= mybatisDtoMapper.toServizioModelloDTO(servizioModello);
		servizioModelloMappato.setdAggiorn(gestioneServiziDao.getNow());
		servizioModelloMappato.setCodUserAggiorn(codUserAggiornamento);
		servizioModelloMappato.setdInserim(servizioModello.getDInserim());
		servizioModelloMappato.setRiferimentoAttoreEsterno(servizioModello.getAttoreEsterno());
		servizioModelloMappato.setReferenteNome(servizioModello.getReferente().getReferenteNome());
		servizioModelloMappato.setReferenteCognome(servizioModello.getReferente().getReferenteCognome());
		servizioModelloMappato.setReferenteTelefono(servizioModello.getReferente().getReferenteTelefono());
		servizioModelloMappato.setReferenteEmail(servizioModello.getReferente().getReferenteEmail());

		int ris=servizioModelloDAO.updateByPrimaryKey(servizioModelloMappato);
		if(ris==1) {
			ModelloInterventoDTO modelloTmp=gestioneModelliDao.getModelloDiInterventoById(idModelloIntervento);
			modelloTmp.setCodUserAggiornamento(codUserAggiornamento);
			modelloTmp.setDataAggiornamento(gestioneModelliDao.getNow());
			Integer risUpdate=gestioneModelliDao.updateModelloIntervento(modelloTmp);
			if(risUpdate==1) {
				//restituisco l'oggetto che ho inserito
				ServizioModello servizioInserito= genericMapper.
						map(gestioneServiziDao.getServizioEsternoById
								(servizioModelloMappato.getIdServizioModello()));
				return Response.ok(servizioInserito).build();
			}

		}
		return null;
	}
	/* ********************************************************************************************************
	 * Gestione Servizi Regionali
	 * **********************************************************************************************************/


	public Response getServiziRegionaliForPso(Long idPso, Long idModelloIntervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if (idPso == null) {
			parametriMancanti.add("idPso");
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


		// si usano i criteria di mybatis metodi autogenerati a partire dai campi
		// dell'oggetto che fungono da semplici filtri

		List<ServizioRegionaleDTO> elencoServiziFiltrati=null;
		List<ServizioRegionaleDTO> elencoServiziRegionali=gestioneServiziDao.getServiziRegionaliForPso(idPso);

		if(idModelloIntervento!=null) {
			ModelloInterventoDTO modelloInterventoAssociato= gestioneModelliDao.getModelloDiInterventoById(idModelloIntervento);

			if(modelloInterventoAssociato.getTipoModello().getFlgProgettazioneIndividuale()!=null &&
					modelloInterventoAssociato.getTipoModello().getFlgProgettazioneIndividuale().equals("S")) {
				elencoServiziFiltrati= elencoServiziRegionali.stream().filter(servizioRegionale->servizioRegionale.getCodFinalitaServizio().equals("I")).collect(Collectors.toList());
				return Response.ok(genericMapper.mapListServiziRegionali(elencoServiziFiltrati)).build();
			}
		}
		return Response.ok(genericMapper.mapListServiziRegionali(elencoServiziRegionali)).build();

	}

	@Transactional
	public Response deleteServiziModelloRegionale(List<ServizioModello> serviziModelloRegionali,Long idModelloIntervento,
												  String codUserAggiornamento) {
		List<String> parametriMancanti = new ArrayList<>();

		if(idModelloIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(codUserAggiornamento==null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		serviziModelloRegionali.stream().forEachOrdered(modelloDaEliminare->{
			Long tmpIdServizioModello=modelloDaEliminare.getIdServizioModello();
			Long tmpIdServizioRegionale=modelloDaEliminare.getServizioRegionale().getIdServizioRegionale();
			gestioneServiziDao.deleteServiziModelloRegionale(tmpIdServizioModello, idModelloIntervento, tmpIdServizioRegionale);
		});

		//aggiorno il codicce fiscale dell'aggiornamento e il timestamp del modello di intervento su cui l'utente sta lavorando
		ModelloInterventoDTO modelloTmp=gestioneModelliDao.getModelloDiInterventoById(idModelloIntervento);
		modelloTmp.setCodUserAggiornamento(codUserAggiornamento);
		modelloTmp.setDataAggiornamento(gestioneModelliDao.getNow());
		Integer risUpdate=gestioneModelliDao.updateModelloIntervento(modelloTmp);

		if(risUpdate==1) {
			//se l'update è andato a buon fine rispondo success

			GenericResponse success=new GenericResponse();
			success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
			return Response.ok(success).build();
		}
		return null;
	}

	@Transactional
	public Response insertServiziModelloRegionale(List<ServizioModello> serviziModelloRegionali,Long idModelloIntervento,
												  String codUserAggiornamento) {

		List<String> parametriMancanti = new ArrayList<>();
		List<ServizioModello> serviziInseriti= new ArrayList<>();
		if(idModelloIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(codUserAggiornamento==null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		serviziModelloRegionali.stream().forEach(servizioModello->{
			ServizioModelloDTO servizioMappato= genericMapper.map(servizioModello);
			servizioMappato.setCodUserAggiorn(codUserAggiornamento);
			servizioMappato.setCodUserInserim(codUserAggiornamento);
			servizioMappato.setDAggiorn(gestioneServiziDao.getNow());
			servizioMappato.setDInserim(gestioneServiziDao.getNow());
			servizioMappato.setIdServizioModello(gestioneServiziDao.getNextValIdServizioModello());
			gestioneServiziDao.insertServiziModelloRegionale(servizioMappato);
			serviziInseriti.add(genericMapper.map(servizioMappato));
		});

		//aggiorno il codicce fiscale dell'aggiornamento e il timestamp del modello di intervento su cui l'utente sta lavorando
		ModelloInterventoDTO modelloTmp=gestioneModelliDao.getModelloDiInterventoById(idModelloIntervento);
		modelloTmp.setCodUserAggiornamento(codUserAggiornamento);
		modelloTmp.setDataAggiornamento(gestioneModelliDao.getNow());
		Integer risUpdate=gestioneModelliDao.updateModelloIntervento(modelloTmp);

		if(risUpdate==1) {
			//se l'update è andato a buon fine restituisco l'elenco di oggetti inseriti
			return Response.ok(serviziInseriti).build();
		}
		return null;
	}

	@Transactional
	public Response updateServiziModelloRegionale(List<ServizioModello> serviziModelloRegionali, Long idModelloIntervento,
												  String codUserAggiornamento) {
		List<String> parametriMancanti = new ArrayList<>();
		List<ServizioModello> serviziAggiornati= new ArrayList<>();
		if(idModelloIntervento == null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(codUserAggiornamento == null) {
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		serviziModelloRegionali.stream().forEach(servizioModello->{
			ServizioModelloDTO servizioMappato= genericMapper.map(servizioModello);
			servizioMappato.setDAggiorn(gestioneServiziDao.getNow());
			servizioMappato.setCodUserAggiorn(codUserAggiornamento);
			servizioMappato.setIdModelloDiIntervento(idModelloIntervento);
			gestioneServiziDao.updateServiziModelloRegionale(servizioMappato);
			serviziAggiornati.add(genericMapper.map(servizioMappato));
		});
		//aggiorno il codicce fiscale dell'aggiornamento e il timestamp del modello di intervento su cui l'utente sta lavorando
		ModelloInterventoDTO modelloTmp=gestioneModelliDao.getModelloDiInterventoById(idModelloIntervento);
		modelloTmp.setCodUserAggiornamento(codUserAggiornamento);
		modelloTmp.setDataAggiornamento(gestioneModelliDao.getNow());
		Integer risUpdate=gestioneModelliDao.updateModelloIntervento(modelloTmp);

		if(risUpdate == 1) {
			//se l'update è andato a buon fine restituisco gli oggetti aggiornati
			return Response.ok(serviziAggiornati).build();
		}

		return null;
	}

	/*
	 * FPL-SERSE-INT-CDU-022-V01-Gestione Servizi associati ad Intervento
	 */

	@Transactional
	public Response deleteServizioForId(Long idServizio) {
		List<String> parametriMancanti = new ArrayList<>();
		if(idServizio==null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTTokenGamSelector tokenGamSelector = new SerseTTokenGamSelector();
		SerseTTokenGamSelector.Criteria tokenGamCriteria = tokenGamSelector.createCriteria();
		tokenGamCriteria.andIdServizioEqualTo(idServizio);
		for (SerseTTokenGamDTO tokenGAM: tokenGamDAOGenerato.selectByExample(tokenGamSelector)) {
			tokenGamDAOGenerato.deleteByPrimaryKey(tokenGAM.getIdTokenGam());
		}

		SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria = destinatarioServizioSelector.createCriteria();
		destinatarioServizioCriteria.andIdServizioEqualTo(idServizio);
		List<SerseRDestinatarioServizioDTO> destinatariServiziDTO = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
		for (SerseRDestinatarioServizioDTO destinatarioServizioDTO : destinatariServiziDTO) {
			SerseRIncontroDestinatarioServizioSelector incontroDestinatarioServizioSelector = new SerseRIncontroDestinatarioServizioSelector();
			SerseRIncontroDestinatarioServizioSelector.Criteria incontroDestinatarioServizioCriteria = incontroDestinatarioServizioSelector.createCriteria();
			incontroDestinatarioServizioCriteria.andIdDestinatarioServizioEqualTo(destinatarioServizioDTO.getIdDestinatarioServizio());
			List<SerseRIncontroDestinatarioServizioDTO> incontriDestinatariServiziDTO = incontroDestinatarioServizioDAOGenerato.selectByExample(incontroDestinatarioServizioSelector);
			for (SerseRIncontroDestinatarioServizioDTO incontroDestinatarioServizio : incontriDestinatariServiziDTO) {
				incontroDestinatarioServizioDAOGenerato.deleteByPrimaryKey(incontroDestinatarioServizio);
			}
			SerseRDestinatarioServizioMonitoraggioSelector servizioMonitoraggioSelector=new SerseRDestinatarioServizioMonitoraggioSelector();
			SerseRDestinatarioServizioMonitoraggioSelector.Criteria destinatarioMonitoraggioCriteria= servizioMonitoraggioSelector.createCriteria();
			destinatarioMonitoraggioCriteria.andIdDestinatarioServizioEqualTo(destinatarioServizioDTO.getIdDestinatarioServizio());
			destinatarioServizioMonitoraggioDAOGenerato.deleteByExample(servizioMonitoraggioSelector);

			destinatarioServizioDAOGenerato.deleteByPrimaryKey(destinatarioServizioDTO.getIdDestinatarioServizio());
		}

		SerseTEnteCoinvoltoServizioSelector enteCoinvoltoServizioSelector = new SerseTEnteCoinvoltoServizioSelector();
		SerseTEnteCoinvoltoServizioSelector.Criteria enteCoinvoltoServizioCriteria = enteCoinvoltoServizioSelector.createCriteria();
		enteCoinvoltoServizioCriteria.andIdServizioEqualTo(idServizio);
		List<SerseTEnteCoinvoltoServizioDTO> entiCoinvoltiServizioDTO = enteCoinvoltoServizioDAOGenerato.selectByExample(enteCoinvoltoServizioSelector);
		for (SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizioDTO : entiCoinvoltiServizioDTO) {
			enteCoinvoltoServizioDAOGenerato.deleteByPrimaryKey(enteCoinvoltoServizioDTO.getIdEnteConvoltoServizio());
		}

		SerseRServizioPsoCaratteristicaSelector serviziPsoCaratteristicaSelector = new SerseRServizioPsoCaratteristicaSelector();
		SerseRServizioPsoCaratteristicaSelector.Criteria serviziPsoCaratteristicaCriteria = serviziPsoCaratteristicaSelector.createCriteria();
		serviziPsoCaratteristicaCriteria.andIdServizioEqualTo(idServizio);

		List<SerseRServizioPsoCaratteristicaDTO> serviziPsoCaratteristicaDTO = servizioPsoCaratteristicaDAOGenerato.selectByExample(serviziPsoCaratteristicaSelector);
		for (SerseRServizioPsoCaratteristicaDTO servizioPsoCaratteristicaDTO : serviziPsoCaratteristicaDTO) {
			servizioPsoCaratteristicaDAOGenerato.deleteByPrimaryKey(servizioPsoCaratteristicaDTO);
		}

		SerseRServizioPsoTargetDestinatarioSelector servizioPsoTargetDestinatarioSelector = new SerseRServizioPsoTargetDestinatarioSelector();
		SerseRServizioPsoTargetDestinatarioSelector.Criteria servizioPsoTargetDestinatarioCriteria = servizioPsoTargetDestinatarioSelector.createCriteria();
		servizioPsoTargetDestinatarioCriteria.andIdServizioEqualTo(idServizio);
		List<SerseRServizioPsoTargetDestinatarioDTO> serviziPsoTargetDestinatarioDTO = servizioPsoTargetDestinatarioDAOGenerato.selectByExample(servizioPsoTargetDestinatarioSelector);
		for (SerseRServizioPsoTargetDestinatarioDTO servizioPsoTargetDestinatarioDTO : serviziPsoTargetDestinatarioDTO) {
			servizioPsoTargetDestinatarioDAOGenerato.deleteByPrimaryKey(servizioPsoTargetDestinatarioDTO);
		}

		SerseRServizioVoceSpesaSelector servizioVoceSpesaSelector = new SerseRServizioVoceSpesaSelector();
		SerseRServizioVoceSpesaSelector.Criteria servizioVoceSpesaCriteria = servizioVoceSpesaSelector.createCriteria();
		servizioVoceSpesaCriteria.andIdServizioEqualTo(idServizio);
		List<SerseRServizioVoceSpesaDTO> serviziVoceSpesaDTO = servizioVoceSpesaDAOGenerato.selectByExample(servizioVoceSpesaSelector);
		for (SerseRServizioVoceSpesaDTO servizioVoceSpesaDTO : serviziVoceSpesaDTO) {
			servizioVoceSpesaDAOGenerato.deleteByPrimaryKey(servizioVoceSpesaDTO);
		}

		SerseTIncontroSelector serseTIncontroSelector = new SerseTIncontroSelector();
		SerseTIncontroSelector.Criteria serseTIncontroCriteria = serseTIncontroSelector.createCriteria();
		serseTIncontroCriteria.andIdServizioEqualTo(idServizio);
		List<SerseTIncontroDTO> incontriDTO = incontroDAOGenerato.selectByExample(serseTIncontroSelector);
		for (SerseTIncontroDTO incontroDTO : incontriDTO) {

			// Questa delete sui token serve perchè ci sono casi con idIncontro valorizzato e idServizio=null
			tokenGamSelector = new SerseTTokenGamSelector();
			tokenGamCriteria = tokenGamSelector.createCriteria();
			tokenGamCriteria.andIdIncontroEqualTo(incontroDTO.getIdIncontro());
			for (SerseTTokenGamDTO tokenGAM: tokenGamDAOGenerato.selectByExample(tokenGamSelector)) {
				tokenGamDAOGenerato.deleteByPrimaryKey(tokenGAM.getIdTokenGam());
			}

			incontroDAOGenerato.deleteByPrimaryKey(incontroDTO.getIdIncontro());
			luogoIncontroDAOGenerato.deleteByPrimaryKey(incontroDTO.getIdLuogoIncontro());
		}

		SerseRServizioFonteSelector servizioFonteSelector = new SerseRServizioFonteSelector();
		SerseRServizioFonteSelector.Criteria servizioFonteCriteria = servizioFonteSelector.createCriteria();
		servizioFonteCriteria.andIdServizioEqualTo(idServizio);
		List<SerseRServizioFonteDTO> serviziFontiDTO = servizioFonteDAOGenerato.selectByExample(servizioFonteSelector);
		for (SerseRServizioFonteDTO serviziFonteDTO : serviziFontiDTO) {
			servizioFonteDAOGenerato.deleteByPrimaryKey(serviziFonteDTO);
		}

		int risp = servizioDAOGenerato.deleteByPrimaryKey(idServizio);
		GenericResponse success=new GenericResponse();

		if(risp == 1)
			success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
		else
			success.setMessage("error");

		return Response.ok(success).build();
	}

	/*
	 * Algoritmo Ricerca Servizi da visualizzare
	 */
	public Response getServiziForIdIntervento(Long idIntervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<Servizio> serviziVo = new ArrayList<>();
		SerseTServizioSelector servizioSelector = new SerseTServizioSelector();
		SerseTServizioSelector.Criteria servizioCriteria = servizioSelector.createCriteria();
		servizioCriteria.andIdInterventoEqualTo(idIntervento);

		List<SerseTServizioDTO> serviziDTO = servizioDAOGenerato.selectByExample(servizioSelector);
		for (SerseTServizioDTO serseTServizioDTO : serviziDTO) {
			serviziVo.add(voMapper.servizioToVo(serseTServizioDTO));
		}

		return Response.ok(serviziVo).build();
	}


	/* ***********************************************************************************
	 * Gestione Servizi per Dashboard Servizi (cdu 23)
	 * ***********************************************************************************/


	public Response getStatiServizio(){
		SerseDStatoServizioSelector selector=new SerseDStatoServizioSelector();
		List<SerseDStatoServizioDTO> statoServizioDTOList= statoServizioDAOGenerato.selectByExample(selector);
		return Response.ok(mybatisDtoMapper.mapListStatoServizio(statoServizioDTOList)).build();
	}

	public Response getServizioById(Long idServizio){
		ServizioDTO servizioDTO = gestioneServiziDao.getServizioById(idServizio);
		if (servizioDTO != null) {
			Integer codOperatoreSoggettoAttuatore = servizioDTO.getSoggettoAttuatore().getCodOperatore();
			String gruppoOperatoreSoggettoAttuatore = servizioDTO.getSoggettoAttuatore().getGruppoOperatore();
			try {
				SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatoreSoggettoAttuatore, codOperatoreSoggettoAttuatore);
				if (operatore != null) {
					servizioDTO.getSoggettoAttuatore().setDenominazioneGiuridica(
							operatore.getDenominazionePersonaGiuridica());
					Servizio servizioVo = genericMapper.map(servizioDTO);

					if (servizioVo.getAreaTerritoriale() != null)
						servizioVo.getAreaTerritoriale()
								.setDescrAreaTerritoriale(servizioDTO.getAreaTerritoriale().getDesrAreaTerritoriale());
					return Response.ok(servizioVo).build();
				}
			} catch (Exception e) {
				throw new ErroreConnessioneServizioException(501, e.getMessage());
			}
		}

		return Response.ok(servizioDTO).build();
	}

	/**
	 * Ricerca servizi
	 */
	public Response getServizi(FilterServizi filter, Integer offset, Integer limit, String sort) {

		/* situazioneIncontro:
		 * cfr. criteri-ricerca.component.html
		 * 0 = Tutti
		 * 1 = Almeno un incontro non concluso
		 * 2 = Tutti incontri chiusi
		 */

		 List<String> parametriMancanti = chkParametriMancanti(filter);
		 if (!parametriMancanti.isEmpty()) {
			 return parametriObbligatoriMancanti(parametriMancanti);
		 }
		 if (!chkFiltroSoggettoBeneficiario(filter)) {
			 return parametriObbligatoriMancantiIncongruenti("codOperatoreSoggettoBeneficiario e "
			 + "gruppoOperatoreSoggettoBeneficiario devono essere entrambi null o entrambi valorizzati");
		 }

        // per i Filter, abbiamo usato il formato CSI che è più generale ma effettivamente pesante...
        FilterServiziSemplificato filtroSemplificato = genericMapper.map(filter);

		/*estraggo le denominazioni giuridiche una sola volta per ridurre il numero di chiamate esterne*/
		List<SoggettoAttuatoreDTO> soggettiAttuatori = soggettoAttuatoreDAO.getSoggettiAttuatori(
			filter.getNumProgrSportello().getEq(), filter.getCodOperatore().getEq(),
			filter.getGruppoOperatore().getEq());
		Map<String, PersonaGiuridica> soggettiDenominazione = soggAttuatoreManager.getDenominazioniGiuridiche(soggettiAttuatori);

		/*estraggo la data di fine sportello*/
		ExtBdgtTPsoSportelloSelector selectorSportello = new ExtBdgtTPsoSportelloSelector();
		ExtBdgtTPsoSportelloSelector.Criteria criteriaSportello = selectorSportello.createCriteria();
		criteriaSportello.andNumProgrSportelloEqualTo(filtroSemplificato.getNumProgrSportello());
		Date dFine = sportelloDaoGenerato.selectByExample(selectorSportello).get(0).getdFine();


		/*primo elenco filtrato da db*/
		List<ServizioDTO> servizioDTOList = gestioneServiziDao.getServizi(filtroSemplificato,
			offset, limit, new SortBean(sort));
		Long count = gestioneServiziDao.countServizi(filtroSemplificato);

		List<ServizioWrapper> servizioWrapperList= new ArrayList<>();

		servizioDTOList.forEach(servizioDTO -> {
			ServizioWrapper servizioWrapper = getServizioWrapper(servizioDTO);
			servizioWrapper.setSportelloDfine(dFine);
			String grpCodSB = servizioDTO.getGruppoBeneficiario() + servizioDTO.getCodiceBeneficiario();
			PersonaGiuridica tmpSoggettoBeneficiario = soggettiDenominazione.get(grpCodSB);
			servizioWrapper.setSoggettoBeneficiario(tmpSoggettoBeneficiario);

			/*estraggo la denominazione giuridica del soggetto attuatore*/
			Integer codOperatoreSoggettoAttuatore = servizioDTO.getSoggettoAttuatore().getCodOperatore();
			String gruppoOperatoreSoggettoAttuatore = servizioDTO.getSoggettoAttuatore().getGruppoOperatore(); 
			String grpCod = gruppoOperatoreSoggettoAttuatore + codOperatoreSoggettoAttuatore;
			servizioWrapper.setDenominazioneSoggettoAttuatore(soggettiDenominazione.get(grpCod).getDenominazione());

			/*Controllo se il soggetto attuatore è proprietario del servizio*/
			servizioWrapper.setIsProprietario(codOperatoreSoggettoAttuatore.equals(filtroSemplificato.getCodOperatore()) && gruppoOperatoreSoggettoAttuatore.equals(filtroSemplificato.getGruppoOperatore()));

			servizioWrapperList.add(servizioWrapper);
		});

		ServizioPageWrapper servizioPageWrapper = new ServizioPageWrapper();
		servizioPageWrapper.setCount(count);
		servizioPageWrapper.setItems(servizioWrapperList);

		return Response.ok(servizioPageWrapper).build();
	}

	/**
	 * Crea un oggetto ServizioWrapper, popolan i campio servizio e destinatario
	 */
	private ServizioWrapper getServizioWrapper(ServizioDTO servizio){

		ServizioWrapper tmp = new ServizioWrapper();
		tmp.setServizio(genericMapper.map(servizio));

		/*se il servizio è individuale estraggo i dati del destinatario*/
		if (servizio.getServizioRegionale().getCodFinalitaServizio().equals("I")) {
			DestinatarioDTO destinatarioDTO = servizio.getDestinatarioServizioIndividuale();
			if (destinatarioDTO != null) {
				tmp.setDestinatario(genericMapper.map(destinatarioDTO));
				tmp.getDestinatario().setCodiceFiscaleDestinatario(destinatarioDTO.getCfDestinatario());
			}
		}else{
			tmp.setDestinatario(null);
		}

		return tmp;
	}

    /**
	 * Controlla i parametri obbligatori
	 * @return lista dei parametri mancanti
	 */
    private List<String> chkParametriMancanti(FilterParent filter) {
        List<String> parametriMancanti = new ArrayList<>();
        if (filter.getNumProgrSportello() == null || filter.getNumProgrSportello().getEq() == null) {
            parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
        }
        if (filter.getGruppoOperatore() == null || StringUtils.isBlank(filter.getGruppoOperatore().getEq())) {
            parametriMancanti.add(INPUT_MISSING.GRUPPO_OPERATORE);
        }
        if (filter.getCodOperatore() == null || filter.getCodOperatore().getEq() == null) {
            parametriMancanti.add(INPUT_MISSING.COD_OPERATORE);
        }
        return parametriMancanti;
    }

    private boolean chkFiltroSoggettoBeneficiario(FilterParent filter) {
        boolean isBlankGruppoOpBen = filter.getGruppoOpBeneficiario() == null || StringUtils.isBlank(filter.getGruppoOpBeneficiario().getEq());
        boolean isBlankCodOpBen = filter.getCodOpBeneficiario() == null || filter.getCodOpBeneficiario().getEq() == null;
        return (isBlankCodOpBen && isBlankGruppoOpBen) || (!isBlankCodOpBen && !isBlankGruppoOpBen);
    }

	/*
	 * FPL-SERSE-INT-CDU-024-V01-Inserimento e aggiornamento Servizio (con spesa)
	 */

	/*
	 * Algoritmo – Lista tipologia di Servizio
	 */
	public Response getTipologieServiziForServizioPso(Long idIntervento, Long idPso) {
		List<String> parametriMancanti = new ArrayList<>();

		if (idPso == null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseDServizioRegionaleSelector servizioRegionaleSelector = new SerseDServizioRegionaleSelector();
		SerseDServizioRegionaleSelector.Criteria servizioRegionaleCriteria = servizioRegionaleSelector.createCriteria();
		servizioRegionaleCriteria.andIdPsoEqualTo(idPso);
		List<SerseDServizioRegionaleDTO> serviziRegionaleDTO;
		List<ServizioRegionale> serviziRegionale = new ArrayList<>();
		if(idIntervento != null) {
			SerseTInterventoDTO interventoDTO = interventoDAOGenerato.selectByPrimaryKey(idIntervento);
			SerseDTipoInterventoDTO tipoIntervento = tipoInterventoDAOGenerato.selectByPrimaryKey(interventoDTO.getCodTipoIntervento());
			if(tipoIntervento.getFlgProgettazioneIndividuale() != null && tipoIntervento.getFlgProgettazioneIndividuale().equals("S"))
				servizioRegionaleCriteria.andCodFinalitaServizioEqualTo("I");
			if(interventoDTO.getIdModelloDiIntervento() != null) {
				SerseTServizioModelloSelector servizioModelloSelector = new SerseTServizioModelloSelector();
				SerseTServizioModelloSelector.Criteria servizioModelloCriteria = servizioModelloSelector.createCriteria();
				servizioModelloCriteria.andIdModelloDiInterventoEqualTo(interventoDTO.getIdModelloDiIntervento());
				List<SerseTServizioModelloDTO> serseTServizioModelloDTOS = servizioModelloDAO.selectByExample(servizioModelloSelector);
				serseTServizioModelloDTOS.forEach(serseTServizioModelloDTO -> {
					if(serseTServizioModelloDTO.getIdServizioRegionale()!=null) {
						serviziRegionale.add(voMapper.servizioRegionaleToVo(servizioRegionaleDAO.selectByPrimaryKey(serseTServizioModelloDTO.getIdServizioRegionale())));
					}
				});

				return Response.ok(serviziRegionale).build();
			}
		}

		serviziRegionaleDTO = servizioRegionaleDAO.selectByExample(servizioRegionaleSelector);
		serviziRegionaleDTO.forEach(servizioRegionaleDTO->
				serviziRegionale.add(voMapper.servizioRegionaleToVo(servizioRegionaleDTO))
		);
		return Response.ok(serviziRegionale).build();
	}

	@Transactional
	public Response insertServizio(Servizio body) {
		Date adesso = servizioDAOGenerato.getNow();
		SerseTServizioDTO servizioDTO = mybatisDtoMapper.toServizioDTO(body);
		servizioDTO.setIdServizio(servizioDAOGenerato.getNextValIdServizio());
		servizioDTO.setdInserim(adesso);
		servizioDTO.setdAggiorn(adesso);

		SerseTSoggettoAttuatoreSelector soggettoAttuatoreSelector=new SerseTSoggettoAttuatoreSelector();
		SerseTSoggettoAttuatoreSelector.Criteria criteria= soggettoAttuatoreSelector.createCriteria();
		criteria.andCodOperatoreEqualTo(body.getSoggettoAttuatore().getCodOperatore().longValue());
		criteria.andNumProgrSportelloEqualTo(body.getSoggettoAttuatore().getNumProgrSportello().longValue());
		criteria.andModelIdEqualTo(body.getSoggettoAttuatore().getModelId().longValue());
		criteria.andGruppoOperatoreEqualTo(body.getSoggettoAttuatore().getGruppoOperatore());

		servizioDTO.setIdSoggettoAttuatore(serseTSoggettoAttuatoreDAOGenerato.selectByExample(soggettoAttuatoreSelector).get(0).getIdSoggettoAttuatore());

		int ris = servizioDAOGenerato.insert(servizioDTO);
		if(ris != 1)
			return null;

		if(body.getIdIntervento() == null)
			return Response.ok(voMapper.servizioToVo(servizioDTO)).build();

		SerseTEnteCoinvoltoInterventoSelector ecInterventoSelector = new SerseTEnteCoinvoltoInterventoSelector();
		SerseTEnteCoinvoltoInterventoSelector.Criteria ecInterventoCriteria = ecInterventoSelector.createCriteria();
		ecInterventoCriteria.andIdInterventoEqualTo(body.getIdIntervento());
		List<SerseTEnteCoinvoltoInterventoDTO> entiCoinvoltiIntervento = enteCoinvoltoInterventoDAOGenerato.selectByExample(ecInterventoSelector);
		SerseTEnteCoinvoltoServizioDTO ecServizio = new SerseTEnteCoinvoltoServizioDTO();
		for (SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoInterventoDTO : entiCoinvoltiIntervento) {
			ecServizio.setIdEnteConvoltoServizio(enteCoinvoltoServizioDAOGenerato.getNextValIdEnteCoinvoltoServizio());
			ecServizio.setIdServizio(servizioDTO.getIdServizio());
			ecServizio.setIdEnteCoinvoltoIntervento(enteCoinvoltoInterventoDTO.getIdEnteCoinvoltoIntervento());
			ecServizio.setCodUserInserim(body.getCodUserInserim());
			ecServizio.setCodUserAggiorn(body.getCodUserAggiorn());
			ecServizio.setdInserim(adesso);
			ecServizio.setdAggiorn(adesso);
			ris += enteCoinvoltoServizioDAOGenerato.insert(ecServizio);
		}
		SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(body.getIdIntervento());

		if(intervento.getCodTipoIntervento().equals("PI")){
			SerseRDestinatarioServizioDTO destinatarioServizioDTO = new SerseRDestinatarioServizioDTO();
			destinatarioServizioDTO.setIdDestinatarioServizio(destinatarioServizioDAOGenerato.getNextValIdDestinatarioServizio());
			destinatarioServizioDTO.setIdDestinatario(intervento.getIdDestinatario());
			destinatarioServizioDTO.setNumerazioneDestinatario(1L);
			destinatarioServizioDTO.setIdServizio(servizioDTO.getIdServizio());
			destinatarioServizioDTO.setdAggiorn(adesso);
			destinatarioServizioDTO.setdInserim(adesso);
			destinatarioServizioDTO.setCodUserInserim(body.getCodUserInserim());
			destinatarioServizioDTO.setCodUserAggiorn(body.getCodUserAggiorn());
			destinatarioServizioDAOGenerato.insert(destinatarioServizioDTO);
		}


		if(intervento.getIdModelloDiIntervento() == null)
			return Response.ok(voMapper.servizioToVo(servizioDTO)).build();

		SerseRModelloInterventoPsoTargetDestinatarioSelector modIntPTDSelector = new SerseRModelloInterventoPsoTargetDestinatarioSelector();
		SerseRModelloInterventoPsoTargetDestinatarioSelector.Criteria modIntPTDCriteria = modIntPTDSelector.createCriteria();

		modIntPTDCriteria.andIdModelloDiInterventoEqualTo(intervento.getIdModelloDiIntervento());

		List<SerseRModelloInterventoPsoTargetDestinatarioDTO> modIntPTDDTO = modInterventoPTDestDAOGenerato.selectByExample(modIntPTDSelector);
		for (SerseRModelloInterventoPsoTargetDestinatarioDTO serseRModelloInterventoPsoTargetDestinatarioDTO : modIntPTDDTO) {
			SerseRServizioPsoTargetDestinatarioDTO servizioTDDTO = new SerseRServizioPsoTargetDestinatarioDTO();
			servizioTDDTO.setIdServizio(servizioDTO.getIdServizio());
			servizioTDDTO.setIdPso(serseRModelloInterventoPsoTargetDestinatarioDTO.getIdPso());
			servizioTDDTO.setIdTargetDestinatario(serseRModelloInterventoPsoTargetDestinatarioDTO.getIdTargetDestinatario());
			servizioTDDTO.setCodUserInserim(body.getCodUserInserim());
			servizioTDDTO.setdInserim(adesso);
			servizioTDDTO.setCodUserAggiorn(body.getCodUserAggiorn());
			servizioTDDTO.setdAggiorn(adesso);
			servizioPTDestDAOGenerato.insert(servizioTDDTO);
		}

		SerseRModelloInterventoPsoCaratteristicaSelector modIntPsoCarattSelector = new SerseRModelloInterventoPsoCaratteristicaSelector();
		SerseRModelloInterventoPsoCaratteristicaSelector.Criteria modIntPsoCarattCriteria = modIntPsoCarattSelector.createCriteria();
		modIntPsoCarattCriteria.andIdModelloDiInterventoEqualTo(intervento.getIdModelloDiIntervento());
		List<SerseRModelloInterventoPsoCaratteristicaDTO> modIntPsoCarattDTO = modInterventoPCarattDAOGenerato.selectByExample(modIntPsoCarattSelector);
		for (SerseRModelloInterventoPsoCaratteristicaDTO modelloInterventoPsoCaratteristicaDTO : modIntPsoCarattDTO) {
			SerseRServizioPsoCaratteristicaDTO servizioPsoCarattDTO = new SerseRServizioPsoCaratteristicaDTO();
			servizioPsoCarattDTO.setIdServizio(servizioDTO.getIdServizio());
			servizioPsoCarattDTO.setIdPso(modelloInterventoPsoCaratteristicaDTO.getIdPso());
			servizioPsoCarattDTO.setIdCaratteristica(modelloInterventoPsoCaratteristicaDTO.getIdCaratteristica());
			servizioPsoCarattDTO.setdInizio(servizioPsoCarattDAOGenerato.getNow());
			servizioPsoCarattDTO.setdFine(null);
			servizioPsoCarattDAOGenerato.insert(servizioPsoCarattDTO);
		}


		return Response.ok(voMapper.servizioToVo(servizioDTO)).build();


	}

	@Transactional
	public Response updateServizio(Servizio body) {
		SerseTServizioDTO servizioDTO = mybatisDtoMapper.toServizioDTO(body);
		servizioDTO.setdAggiorn(servizioDAOGenerato.getNow());
		//servizioDTO.setValoreCampoAggiuntivo1(body.getValoreCampoAggiuntivo1());

		SerseTSoggettoAttuatoreSelector soggettoAttuatoreSelector = new SerseTSoggettoAttuatoreSelector();
		SerseTSoggettoAttuatoreSelector.Criteria criteria = soggettoAttuatoreSelector.createCriteria();

		criteria.andCodOperatoreEqualTo(body.getSoggettoAttuatore().getCodOperatore().longValue());
		criteria.andNumProgrSportelloEqualTo(body.getSoggettoAttuatore().getNumProgrSportello().longValue());
		criteria.andModelIdEqualTo(body.getSoggettoAttuatore().getModelId().longValue());
		criteria.andGruppoOperatoreEqualTo(body.getSoggettoAttuatore().getGruppoOperatore());

		servizioDTO.setIdSoggettoAttuatore(serseTSoggettoAttuatoreDAOGenerato.selectByExample(soggettoAttuatoreSelector).get(0).getIdSoggettoAttuatore());

		// alcuni campi NON devono essere aggiornati da frontend
		SerseTServizioDTO servizioDTOOld = servizioDAOGenerato.selectByPrimaryKey(servizioDTO.getIdServizio());
		servizioDTO.setdInserim(servizioDTOOld.getdInserim());
		servizioDTO.setCodUserInserim(servizioDTOOld.getCodUserInserim());
		servizioDTO.setIdStatoServizio(servizioDTOOld.getIdStatoServizio());

		int ris = servizioDAOGenerato.updateByPrimaryKey(servizioDTO);
		if(ris == 1) {
			return Response.ok(voMapper.servizioToVo(servizioDTO)).build();
		}
		return null;
	}

	public Response verificaPeriodoAttivazioneServizio(Long numProgrSportello) {
		List<String> parametriMancanti = new ArrayList<>();

		if (numProgrSportello == null) {
			parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseDPeriodoAttivazioneServizioSelector periodoAttServizioSelector = new SerseDPeriodoAttivazioneServizioSelector();
		SerseDPeriodoAttivazioneServizioSelector.Criteria periodoAttServizioCriteria = periodoAttServizioSelector.createCriteria();
		periodoAttServizioCriteria.andNumProgrSportelloEqualTo(numProgrSportello);
		periodoAttServizioCriteria.andDInizioAttivazioneLessThan(periodoAttivazioneServizioDAOGenerato.getNow());
		periodoAttServizioCriteria.andDFineAttivazioneGreaterThan(periodoAttivazioneServizioDAOGenerato.getNow());
		List<SerseDPeriodoAttivazioneServizioDTO> periodoAttivazioneServizioDTOList = periodoAttivazioneServizioDAOGenerato.selectByExample(periodoAttServizioSelector);
		PeriodoAttivazioneVerifica periodoAttivazioneVerifica = new PeriodoAttivazioneVerifica();
		periodoAttivazioneVerifica.setValido(!periodoAttivazioneServizioDTOList.isEmpty());


		return Response.ok(periodoAttivazioneVerifica).build();
	}

	//verifica prima di chiudere un servizio
	public Response testChiudereServizio(Long idServizio){
		List<String> parametriMancanti = new ArrayList<>();

		if (idServizio == null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		TestChiudiServizio testChiudiServizio = new TestChiudiServizio();

		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);

		SerseTIncontroSelector incontroSelector = new SerseTIncontroSelector();
		SerseTIncontroSelector.Criteria incontroCriteria = incontroSelector.createCriteria();
		incontroCriteria.andIdServizioEqualTo(idServizio);

		//confronto somma ore incontri con durata ore
		List<SerseTIncontroDTO> incontriDTO = incontroDAOGenerato.selectByExample(incontroSelector);
		BigDecimal somma = new BigDecimal(0);
		for (SerseTIncontroDTO incontroDTO : incontriDTO) {
			somma = somma.add(incontroDTO.getDurataOre());
		}
		BigDecimal durataOre = servizioDTO.getDurataOre();

		somma = durataOre.subtract(somma).setScale(2);
		testChiudiServizio.setSommaDurataIncontriConfrontoDiDurataOre(somma);

		incontroCriteria.andIdStatoIncontroNotEqualTo(40L);
		List<SerseTIncontroDTO> incontroDTOS = incontroDAOGenerato.selectByExample(incontroSelector);
		testChiudiServizio.setEsisteIncontroNonChiuso(!incontroDTOS.isEmpty());

		return  Response.ok(testChiudiServizio).build();
	}

	/*
	 * FPL-SERSE-SER-CDU-028-V01-Gestione Spesa Servizio
	 */
	public Response getServiziFonti(Long idServizio) {

		SerseRServizioFonteSelector servizioFonteSelector = new SerseRServizioFonteSelector();
		SerseRServizioFonteSelector.Criteria servizioFonteCriteria = servizioFonteSelector.createCriteria();
		servizioFonteCriteria.andIdServizioEqualTo(idServizio);
		return Response.ok(mybatisDtoMapper.mapListServizioFonte(servizioFonteDAOGenerato.selectByExample(servizioFonteSelector))).build();
	}

	public Response getServiziVoceSpesa(Long idServizio) {
		List<ServizioVoceSpesaDTO> data = gestioneServiziDao.getServiziVoceSpesa(idServizio);
		List<ServizioVoceSpesa> result = genericMapper.mapListVoceSpesa(data);
		return Response.ok(result).build();

	}

	public Response getServiziSto(Long idServizio) {
		List<String> parametriMancanti = new ArrayList<>();

		if (idServizio == null) {
			parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		SerseTServizioStoSelector serseTServizioStoSelector = new SerseTServizioStoSelector();
		serseTServizioStoSelector.setOrderByClause("d_variazione");
		SerseTServizioStoSelector.Criteria serseTServizioStoCriteria = serseTServizioStoSelector.createCriteria();
		serseTServizioStoCriteria.andIdServizioEqualTo(idServizio);

		List<SerseTServizioStoDTO> serseTServizioStoDTO = servizioStoDAOGenerato.selectByExample(serseTServizioStoSelector);
		return Response.ok(serseTServizioStoDTO).build();
	}

	// FPL-SERSE-SER-CDU-026-V01-Gestione Destinatari Servizio
	public Response getTestInterventoServizio(Long idServizio) {
		TestInterventoServizio testInterventoServizio = new TestInterventoServizio();
		testInterventoServizio.setServizioDerivaDaIntervento(false);
		testInterventoServizio.setInterventoDiTipoIndividuale(false);
		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
		if(servizioDTO.getIdIntervento() != null) {
			testInterventoServizio.setServizioDerivaDaIntervento(true);
			SerseTInterventoDTO interventoDTO = interventoDAOGenerato.selectByPrimaryKey(servizioDTO.getIdIntervento());
			SerseDTipoInterventoDTO tipoIntervento = tipoInterventoDAOGenerato.selectByPrimaryKey(interventoDTO.getCodTipoIntervento());
			if (tipoIntervento.getFlgProgettazioneIndividuale() != null && tipoIntervento.getFlgProgettazioneIndividuale().equals("S"))
				testInterventoServizio.setInterventoDiTipoIndividuale(true);
		}

		return Response.ok(testInterventoServizio).build();
	}


	// CDU 17 e 18 verifica servizio associato a un MDI
	public Response verificaServizioAssociatoModelloDiIntervento(Long idServizio){
		List<String> parametriMancanti= new ArrayList<>();
		if(idServizio==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		TestGenerico testGenerico = new TestGenerico();
		testGenerico.setNome("isAssociatoAlModelloDiIntervento");

		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(idServizio);
		SerseTInterventoDTO interventoDTO = new SerseTInterventoDTO();
		if(servizioDTO.getIdIntervento() != null)
			interventoDTO = interventoDAOGenerato.selectByPrimaryKey(servizioDTO.getIdIntervento());
		testGenerico.setValore(servizioDTO.getIdIntervento() != null && interventoDTO.getIdModelloDiIntervento() != null);
		return Response.ok(testGenerico).build();
	}

	//1.1.0 ID 270 dati peculiari da servizio
	@Transactional
	public Response servizioDatiPeculiari(Servizio body){
		String codUserAggiorn = body.getCodUserAggiorn();
		Date adesso = servizioDAOGenerato.getNow();

		SerseTServizioDTO servizioDTO = servizioDAOGenerato.selectByPrimaryKey(body.getIdServizio());
		servizioDTO.setdAggiorn(adesso);
		servizioDTO.setIdPsoClasseDestinatario(body.getIdPsoClasseDestinatario());
		servizioDTO.setValoreDatoPeculiare1(body.getValoreDatoPeculiare1());
		servizioDTO.setValoreDatoPeculiare2(body.getValoreDatoPeculiare2());
		servizioDTO.setCodLivelloIstruzione(body.getCodTitoloStudioIgrue());
		servizioDTO.setCodCondizioneOccupazionale(body.getCodCondizioneOccupazionaleIgrue());
		servizioDTO.setFlgDisabilita(body.getFlgDisabilita());
		servizioDTO.setFlgSvantaggioAbitativo(body.getFlgSvantaggioAbitativo());
		servizioDTO.setCodUserAggiorn(codUserAggiorn);

		GenericResponse risposta = new GenericResponse();

		if (servizioDAOGenerato.updateByPrimaryKey(servizioDTO) == 0){
			risposta.setMessage("errore");
			return Response.ok(risposta).build();
		}

		Integer risp  = 0;
		SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
		SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria = destinatarioServizioSelector.createCriteria();
		destinatarioServizioCriteria.andIdServizioEqualTo(servizioDTO.getIdServizio());


		List<SerseRDestinatarioServizioDTO>  destinatarioServizioDTOList = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);
		for (SerseRDestinatarioServizioDTO destinatarioServizioDTO: destinatarioServizioDTOList ) {
			risp += insertDatiPeculiariDestinatario(destinatarioServizioDTO, adesso, codUserAggiorn, body);
		}
		risposta.setMessage(risp.toString());
		return Response.ok(risposta).build();
	}

	//aggiungi dati peculiare se non ci sono per destinatari ereditati dal servizio
	private int insertDatiPeculiariDestinatario(SerseRDestinatarioServizioDTO destinatarioServizioDTO, Date adesso, String codUserAggiorn, Servizio servizio){
		boolean flgSalvare = false;
		int risp = 0;
		if(servizio.getValoreDatoPeculiare1() != null && destinatarioServizioDTO.getValoreDatoPeculiare1()==null){
			flgSalvare=true;
			destinatarioServizioDTO.setValoreDatoPeculiare1(servizio.getValoreDatoPeculiare1());
		}
		if(servizio.getValoreDatoPeculiare2() != null && destinatarioServizioDTO.getValoreDatoPeculiare2()==null){
			flgSalvare=true;
			destinatarioServizioDTO.setValoreDatoPeculiare2(servizio.getValoreDatoPeculiare2());
		}
		if(servizio.getIdPsoClasseDestinatario()!= null && destinatarioServizioDTO.getIdPsoClasseDestinatario()==null){
			flgSalvare=true;
			destinatarioServizioDTO.setIdPsoClasseDestinatario(servizio.getIdPsoClasseDestinatario());
		}

		if(flgSalvare){
			risp = destinatarioServizioDAOGenerato.updateByPrimaryKey(destinatarioServizioDTO);
		}

		SerseRDestinatarioServizioMonitoraggioDTO destinatarioServizioMonitoraggioDTO = destinatarioServizioMonitoraggioDAOGenerato.selectByPrimaryKey(destinatarioServizioDTO.getIdDestinatarioServizio());
		String codCittadinanza= destinatarioDaoGenerato.selectByPrimaryKey(destinatarioServizioDTO.getIdDestinatario()).getCodCittadinanza();

		if(destinatarioServizioMonitoraggioDTO == null){
			SerseRDestinatarioServizioMonitoraggioDTO serseRDestinatarioServizioMonitoraggioDTO = new SerseRDestinatarioServizioMonitoraggioDTO();
			serseRDestinatarioServizioMonitoraggioDTO.setIdDestinatarioServizio(destinatarioServizioDTO.getIdDestinatarioServizio());
			serseRDestinatarioServizioMonitoraggioDTO.setdAggiorn(adesso);
			serseRDestinatarioServizioMonitoraggioDTO.setdInserim(adesso);
			serseRDestinatarioServizioMonitoraggioDTO.setCodCittadinanza(codCittadinanza);
			serseRDestinatarioServizioMonitoraggioDTO.setCodUserAggiorn(servizio.getCodUserAggiorn());
			serseRDestinatarioServizioMonitoraggioDTO.setCodUserInserim(servizio.getCodUserAggiorn());
			serseRDestinatarioServizioMonitoraggioDTO.setCodCondizioneOccupazionale(servizio.getCodCondizioneOccupazionaleIgrue());
			serseRDestinatarioServizioMonitoraggioDTO.setCodLivelloIstruzione(servizio.getCodTitoloStudioIgrue());
			serseRDestinatarioServizioMonitoraggioDTO.setFlgDisabilita(servizio.getFlgDisabilita());
			serseRDestinatarioServizioMonitoraggioDTO.setFlgSvantaggioAbitativo(servizio.getFlgSvantaggioAbitativo());
			risp = destinatarioServizioMonitoraggioDAOGenerato.insert(serseRDestinatarioServizioMonitoraggioDTO);
			return risp;
		}

		// se si deve scrivere i dati mancanti ... domandare

		return risp;
	}

	//controllo dati peculiari per num sportello ed idpso
	public Response getControlloDatiPeculiari(Long numProgrSportello, Long idPso){
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


		SerseDRegComportPsoSportSelector regComportPsoSportSelector = new SerseDRegComportPsoSportSelector();
		SerseDRegComportPsoSportSelector.Criteria regComportPsoSportCriteria = regComportPsoSportSelector.createCriteria();
		regComportPsoSportCriteria.andIdPsoEqualTo(idPso);
		regComportPsoSportCriteria.andNumProgrSportelloEqualTo(numProgrSportello);
		List<SerseDRegComportPsoSportDTO> regComportPsoSportDTOS = serseDRegComportPsoSportDAOGenerato.selectByExample(regComportPsoSportSelector);
		datiPeculiariWrapper.setRegComportPsoSport(mybatisDtoMapper.map(regComportPsoSportDTOS.get(0)));

		SportMonitoraggio sportMonitoraggio = null;

		if(!regComportPsoSportDTOS.isEmpty()) {
			SerseDSportMonitoraggioDTO sportMonitoraggioDTO = sportMonitoraggioDAOGenerato.selectByPrimaryKey(regComportPsoSportDTOS.get(0).getIdRegComportPsoSport());
			if(sportMonitoraggioDTO != null) {
				sportMonitoraggio = mybatisDtoMapper.map(sportMonitoraggioDTO);
			}
		}
		datiPeculiariWrapper.setSportMonitoraggio(sportMonitoraggio);
		return  Response.ok(datiPeculiariWrapper).build();
	}

	public Response getLabelCampoAggiuntivo(Long idPso, Long numProgrSportello){
		SerseDRegComportPsoSportSelector regComportPsoSportSelector = new SerseDRegComportPsoSportSelector();
		SerseDRegComportPsoSportSelector.Criteria regComportPsoSportCriteria = regComportPsoSportSelector.createCriteria();
		regComportPsoSportCriteria.andIdPsoEqualTo(idPso);
		regComportPsoSportCriteria.andNumProgrSportelloEqualTo(numProgrSportello);
		List<SerseDRegComportPsoSportDTO> regComportPsoSportDTOS = serseDRegComportPsoSportDAOGenerato.selectByExample(regComportPsoSportSelector);
		return Response.ok(regComportPsoSportDTOS.get(0)).build();
	}

	public Response getFlgCampoAggiuntivoByIdServizioRegionale(Long idServizioRegionale){
		return Response.ok(servizioRegionaleDAO.selectByPrimaryKey(idServizioRegionale)).build();
	}

	public Response getServiziDestinatari(Long idDestinatario,Long numProgrSportello, String gruppoOperatore, Integer codOperatore){
		List<ServizioDTO> servizioDTOList= gestioneServiziDao.getServiziDestinatari(idDestinatario);

		/*estraggo le denominazioni giuridiche una sola volta per ridurre il numero di chiamate esterne*/
		List<SoggettoAttuatoreDTO> soggettiAttuatori= soggettoAttuatoreDAO.getSoggettiAttuatori(numProgrSportello,codOperatore,gruppoOperatore);
		Map<String,PersonaGiuridica> soggettiDenominazione = soggAttuatoreManager.getDenominazioniGiuridiche(soggettiAttuatori);

		List<ServizioWrapper> servizioWrapperList= new ArrayList<>();

		servizioDTOList.forEach(servizioDTO -> {
			ServizioWrapper servizioWrapper= new ServizioWrapper();
			servizioDTO.getServizioRegionale().setCodiceServizioRegionale(servizioRegionaleDAO.selectByPrimaryKey(servizioDTO.getServizioRegionale().getIdServizioRegionale()).getCodiceServizioRegionale());
			servizioDTO.getStatoServizio().setDescrStatoServizio(statoServizioDAOGenerato.selectByPrimaryKey(servizioDTO.getStatoServizio().getIdStatoServizio()).getDescrStatoServizio());
			servizioDTO.getServizioRegionale().setDescrFinalitaServizio(finalitaServizioDAO.selectByPrimaryKey(servizioRegionaleDAO.selectByPrimaryKey(servizioDTO.getServizioRegionale().getIdServizioRegionale()).getCodFinalitaServizio()).getDescrFinalitaServizio());
			servizioDTO.getSoggettoAttuatore().setGruppoOperatore(soggettoAttuatoreDAOGenerato.selectByPrimaryKey(servizioDTO.getSoggettoAttuatore().getIdSoggettoAttuatore()).getGruppoOperatore());
			servizioDTO.getSoggettoAttuatore().setCodOperatore(Math.toIntExact(soggettoAttuatoreDAOGenerato.selectByPrimaryKey(servizioDTO.getSoggettoAttuatore().getIdSoggettoAttuatore()).getCodOperatore()));
			servizioWrapper.setServizio(genericMapper.map(servizioDTO));
			String grpCod=servizioWrapper.getServizio().getSoggettoAttuatore().getGruppoOperatore() + servizioWrapper.getServizio().getSoggettoAttuatore().getCodOperatore();
			servizioWrapper.setDenominazioneSoggettoAttuatore(soggettiDenominazione.get(grpCod).getDenominazione());
			servizioWrapper.setSportelloDfine(null);
			SoggettoAttuatoreDTO soggettoFiltrato= soggettoAttuatoreDAO.getSoggettoBeneficiario(servizioDTO.getSoggettoAttuatore().getIdSoggettoAttuatore());
			String grpCodSB=soggettoFiltrato.getGruppoOperatore()+soggettoFiltrato.getCodOperatore();
			PersonaGiuridica tmpSoggettoBeneficiario=soggettiDenominazione.get(grpCodSB);
			servizioWrapper.setSoggettoBeneficiario(tmpSoggettoBeneficiario);
			servizioWrapperList.add(servizioWrapper);
		});
		return Response.ok(servizioWrapperList).build();
	}
	
	public Response getClasseServizioByIdServzioAndIdPso(Long idServizio, Long idPso) {
		DettaglioClasseDestinatarioServizioDTO data = gestioneServiziDao.getClasseServizioByIdServzioAndIdPso(idServizio, idPso);
		DettaglioClasseDestinatarioServizio result = genericMapper.map(data);
		return Response.ok(result).build();
	}
}

