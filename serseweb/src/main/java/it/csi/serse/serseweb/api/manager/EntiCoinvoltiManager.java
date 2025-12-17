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
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.csi.serse.serseweb.api.exception.ErroreGestitoException;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneEntiCoinvoltiDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneModelliDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.IstitutiScolasticiDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.EnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.GradoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IstitutoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ModelloInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.PercorsoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipologiaIstitutoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDFonteDatoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDRuoloEnteDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDTipoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRPsoFonteDatoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoModelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDFonteDatoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRuoloEnteDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRuoloEnteSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDTipoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRPsoFonteDatoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRPsoFonteDatoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;
import it.csi.serse.serseweb.vo.EnteCoinvoltoWrapper;
import it.csi.serse.serseweb.vo.EnteDestinatario;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.FonteDato;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.TestEnteCoinvoltoIntervento;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;

@Component
public class EntiCoinvoltiManager extends ParentManager{
	@Autowired
	private VoMapper voMapper;

	@Autowired
	private GestioneEntiCoinvoltiDAO entiCoinvoltiDao;

	@Autowired
	private GenericMapper genericMapper;

	@Autowired
	private MybatisGeneretedDTOMapper mybatisMapper;

	@Autowired
	private SerseTServizioDAO servizioDAOgenerato;

	@Autowired
	private SerseRDestinatarioServizioDAO destinatarioServizioDAO;

	@Autowired
	private SerseTEnteCoinvoltoModelloDAO enteCoinvoltoModelloDaoGenerato;

	@Autowired
	private SerseTEnteCoinvoltoInterventoDAO enteCoinvoltoInterventoDaoGenerato;

	@Autowired
	private SerseTEnteCoinvoltoServizioDAO enteCoinvoltoServizioDaoGenerato;

	@Autowired
	private GestioneModelliDiInterventoDAO gestioneModelliInterventoDao;
	@Autowired
	private IstitutiScolasticiDAO istitutiScolasticiDAO;
	@Autowired
	private SerseRPsoFonteDatoDAO fonteDatoDAO;

	@Autowired
	private SerseDFonteDatoDAO fonteDatoDAOGenerato;

	@Autowired
	private SerseDRuoloEnteDAO ruoloEnteDao;

	@Autowired
	private SerseDTipoInterventoDAO tipoInterventoDAOGenerato;

	@Autowired
	private SerseTInterventoDAO interventoDAOGenerato;


	public Response getRuoliEnte(){

		SerseDRuoloEnteSelector selector= new SerseDRuoloEnteSelector();
		List<SerseDRuoloEnteDTO> ruoloEnteDTOList= ruoloEnteDao.selectByExample(selector);
		return Response.ok(mybatisMapper.mapListRuoloEnte(ruoloEnteDTOList)).build();
	}

	/************************************************************************************
	 * Gestione Enti Coinvolti Modello
	 * ***********************************************************************************/
	public Response getFonteDatoPerPso(Long idPso){
		List<String> parametriMancanti = new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_PSO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		SerseRPsoFonteDatoSelector selector=new SerseRPsoFonteDatoSelector();
		SerseRPsoFonteDatoSelector.Criteria criteria=selector.createCriteria();
		criteria.andIdPsoEqualTo(idPso);
		List<SerseRPsoFonteDatoDTO> fonteDatoDTO= fonteDatoDAO.selectByExample(selector);
		FonteDato fonteDato= new FonteDato();
		fonteDatoDTO.stream().forEach(fonte->{
			if(fonte.getIdFonteDato().equals(1L)){
				fonteDato.setIdFonteDato1(true);
			}
			if(fonte.getIdFonteDato().equals(2L)){
				fonteDato.setIdFonteDato2(true);
			}
			if(fonte.getIdFonteDato().equals(3L)){
				fonteDato.setIdFonteDato3(true);
			}
		});

		return Response.ok(fonteDato).build();
	}

	public Response getEntiCoinvoltiForModelloIntervento( Long idModelloIntervento) {
		List<String> parametriMancanti = new ArrayList<>();

		if(idModelloIntervento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<EnteCoinvoltoModelloDTO> listaEnti= entiCoinvoltiDao.getEntiCoinvoltiForModelloInterventoV2( idModelloIntervento);

		// TODO quello che segue potrebbe farlo un mapper? 
		List<EnteCoinvoltoModello> enteCoinvoltoModellos = new ArrayList<>();
		for (EnteCoinvoltoModelloDTO enteDto: listaEnti) {
			EnteCoinvoltoModello ente = genericMapper.map(enteDto);
			if (ente.getIdFonteDato() != null && ente.getIdFonteDato() == 1L) {

				IstitutoScolasticoDTO istituto = enteDto.getIstitutoScolastico();
				if (istituto != null) {
					ente.setCodMeccanografico(istituto.getCodMeccanograficoScuola());
					ente.setCodMeccanograficoAutonomia(istituto.getCodMeccanograficoAutonomia());
					ente.setPercorso(istituto.getPercorsoScolastico().getDescrPercorso());
					ente.setTipologia(istituto.getTipologiaIstituto().getDescrTipologia());
					ente.setGradoScolastico(istituto.getGradoScolastico().getDescrGradoScolastico());
					ente.setAutonomia(istituto.getCodRegionaleAutonomia() + " - " + istituto.getDenominazioneAutonomia());
				}
			}
			enteCoinvoltoModellos.add(ente);
		}
		return Response.ok(enteCoinvoltoModellos).build();
	}

	public Response getEnteCoinvoltoModelloForId(Long idEnteCoinvoltoModello){
		List<String> parametriMancanti = new ArrayList<>();
		if(idEnteCoinvoltoModello==null) {
			parametriMancanti.add("idEnteCoinvoltoModello");
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		EnteCoinvoltoModelloDTO enteSelezionato= entiCoinvoltiDao.getEnteCoinvoltoModelloForId(idEnteCoinvoltoModello);

		if(enteSelezionato!=null) {
			EnteCoinvoltoModello enteCoinvoltoModello = genericMapper.map(enteSelezionato);
			return Response.ok(enteCoinvoltoModello).build();
		}
		return Response.ok(enteSelezionato).build();
	}

	@Transactional
	public Response deleteEnteCoinvoltoModelloById(Long idEnteCoinvolto,Long idModelloIntervento,
												   String codUserAggiornamento) {

		List<String> parametriMancanti = new ArrayList<>();


		if(idModelloIntervento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_MODELLO_INTERVENTO);
		}
		if(idEnteCoinvolto==null) {
			parametriMancanti.add("idEnteCoinvolto");
		}
		if(codUserAggiornamento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		/*
		 * cancellazione tramite mybatis
		 * */
		SerseTEnteCoinvoltoModelloSelector selector= new SerseTEnteCoinvoltoModelloSelector();
		SerseTEnteCoinvoltoModelloSelector.Criteria criteria= selector.createCriteria();

		criteria.andIdEnteCoinvoltoModelloEqualTo(idEnteCoinvolto);
		criteria.andIdModelloDiInterventoEqualTo(idModelloIntervento);
		int risDelete=0;
		try {
			risDelete = enteCoinvoltoModelloDaoGenerato.deleteByExample(selector);
		}catch(Exception sqlException){
			Errore error=new Errore();
			error.setErrorMessage(sqlException.getMessage());
			error.setCode(500);
			return  Response.serverError().entity(error).build();
		}
		if(risDelete!=0) {
			ModelloInterventoDTO modelloTmp= gestioneModelliInterventoDao.getModelloDiInterventoById(idModelloIntervento);
			modelloTmp.setCodUserAggiornamento(codUserAggiornamento);
			modelloTmp.setDataInserimento(gestioneModelliInterventoDao.getNow());
			int risUpdate=gestioneModelliInterventoDao.updateModelloIntervento(modelloTmp);

			if(risUpdate!=0) {
				GenericResponse success=new GenericResponse();
				success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
				return Response.ok(success).build();
			}
		}

		return null;

	}

	@Transactional
	public Response updateEnteCoinvoltoModello(EnteCoinvoltoModello enteCoinvolto) {
		/*
		 * update dell'ente coinvolto tramite mybatis
		 * */
		SerseTEnteCoinvoltoModelloDTO enteMappato = mybatisMapper.map(enteCoinvolto);
		if(enteMappato.getIdFonteDato()==null){
			enteMappato.setIdPso(null);
		}
		enteMappato.setdAggiorn(enteCoinvoltoModelloDaoGenerato.getNow());
		int risUpdate=enteCoinvoltoModelloDaoGenerato.updateByPrimaryKey(enteMappato);

		/*
		 * aggiorniamo il modello di intevento
		 * */
		if(risUpdate!=0) {
			ModelloInterventoDTO modelloTmp= gestioneModelliInterventoDao.getModelloDiInterventoById(enteCoinvolto.getIdModelloDiIntervento());
			modelloTmp.setCodUserAggiornamento(enteCoinvolto.getCodUserInserim());
			modelloTmp.setDataInserimento(gestioneModelliInterventoDao.getNow());
			int risUpdateModello=gestioneModelliInterventoDao.updateModelloIntervento(modelloTmp);

			if(risUpdateModello!=0) {
				EnteCoinvoltoModello enteAggiornato = genericMapper.map(entiCoinvoltiDao.
						getEnteCoinvoltoModelloForId(enteCoinvolto.getIdEnteCoinvoltoModello()));
				return Response.ok(enteAggiornato).build();
			}
		}


		return null;
	}

	@Transactional
	public Response insertEnteCoinvoltoModello(EnteCoinvoltoModello enteCoinvolto) {

		SerseTEnteCoinvoltoModelloDTO enteMappato = mybatisMapper.map(enteCoinvolto);

		enteMappato.setIdEnteCoinvoltoModello(enteCoinvoltoModelloDaoGenerato.getNextValIdEnteCoinvoltoModello());
		enteMappato.setCodIstatComune(enteCoinvolto.getComune().getCodiceIstatComune());
		if(enteMappato.getIdFonteDato()==null){
			enteMappato.setIdPso(null);
		}
		if(enteCoinvolto.getReferente()!=null) {
			if(enteCoinvolto.getReferente().getReferenteNome()!=null)
				enteMappato.setReferenteNome(enteCoinvolto.getReferente().getReferenteNome());

			if(enteCoinvolto.getReferente().getReferenteCognome()!=null)
				enteMappato.setReferenteCognome(enteCoinvolto.getReferente().getReferenteCognome());

			if(enteCoinvolto.getReferente().getReferenteEmail()!=null)
				enteMappato.setReferenteEmail(enteCoinvolto.getReferente().getReferenteEmail());

			if(enteCoinvolto.getReferente().getReferenteTelefono()!=null)
				enteMappato.setReferenteTelefono(enteCoinvolto.getReferente().getReferenteTelefono());
		}
		enteMappato.setdInserim(enteCoinvoltoModelloDaoGenerato.getNow());
		enteMappato.setdAggiorn(enteCoinvoltoModelloDaoGenerato.getNow());
		enteMappato.setCodUserAggiorn(enteCoinvolto.getCodUserInserim());
		int risInserim=enteCoinvoltoModelloDaoGenerato.insert(enteMappato);

		if(risInserim==1) {
			EnteCoinvoltoModello enteInserito = genericMapper.map(entiCoinvoltiDao.
					getEnteCoinvoltoModelloForId(enteMappato.getIdEnteCoinvoltoModello()));
			return Response.ok(enteInserito).build();
		}

		return null;
	}

	/************************************************************************************
	 * Gestione Enti Coinvolti Intervento
	 * ***********************************************************************************/

	public Response insertEnteCoinvoltoIntervento(EnteCoinvoltoIntervento enteCoinvolto) {

		SerseTEnteCoinvoltoInterventoDTO enteMappato = mybatisMapper.map(enteCoinvolto);
		enteMappato.setIdEnteCoinvoltoIntervento(enteCoinvoltoInterventoDaoGenerato.getNextValIdEnteCoinvoltoIntervento());
		if(enteMappato.getIdFonteDato()==null){
			enteMappato.setIdPso(null);
		}

		enteMappato.setdInserim(enteCoinvoltoInterventoDaoGenerato.getNow());
		enteMappato.setdAggiorn(enteCoinvoltoInterventoDaoGenerato.getNow());

		int risInserim = enteCoinvoltoInterventoDaoGenerato.insert(enteMappato);

		if(risInserim==1) {
			GenericResponse success=new GenericResponse();
			success.setMessage(Constants.RISPOSTE_RESPONSE.INSERIMENTO_SUCCES);
			return Response.ok(success).build();
		}

		return null;
	}


	/************************************************************************************
	 * Gestione Enti Coinvolti Servizio
	 * ***********************************************************************************/
	@Transactional
	public Response insertEnteCoinvoltoServizio(EnteCoinvoltoServizio enteCoinvolto) {

		Long idEnteCoinvoltoServizio=enteCoinvoltoServizioDaoGenerato.getNextValIdEnteCoinvoltoServizio();
		SerseTEnteCoinvoltoServizioDTO enteMappato = mybatisMapper.map(enteCoinvolto);
		enteMappato.setIdEnteConvoltoServizio(idEnteCoinvoltoServizio);

		SerseTServizioDTO servizioDTO= servizioDAOgenerato.selectByPrimaryKey(enteCoinvolto.getIdServizio());

		if(enteMappato.getIdFonteDato()==null){
			enteMappato.setIdPso(null);
		}

		enteMappato.setdInserim(enteCoinvoltoServizioDaoGenerato.getNow());
		enteMappato.setdAggiorn(enteCoinvoltoServizioDaoGenerato.getNow());

		int risInserim=enteCoinvoltoServizioDaoGenerato.insert(enteMappato);

		if(servizioDTO.getNumMaxDestinatari().equals(1L)){
			SerseRDestinatarioServizioSelector destinatarioServizioSelector=new SerseRDestinatarioServizioSelector();
			SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria= destinatarioServizioSelector.createCriteria();

			destinatarioServizioCriteria.andIdServizioEqualTo(enteCoinvolto.getIdServizio());
			List<SerseRDestinatarioServizioDTO> destinatarioServizioDTOList=destinatarioServizioDAO.selectByExample(destinatarioServizioSelector);


			if(!destinatarioServizioDTOList.isEmpty()){
				SerseRDestinatarioServizioDTO tmp= destinatarioServizioDTOList.get(0);
				tmp.setIdEnteConvoltoServizio(idEnteCoinvoltoServizio);
				destinatarioServizioDAO.updateByPrimaryKey(tmp);
			}
		}
		if(risInserim==1) {
			GenericResponse success=new GenericResponse();
			success.setMessage(Constants.RISPOSTE_RESPONSE.INSERIMENTO_SUCCES);
			return Response.ok(success).build();
		}

		return null;
	}

	public Response getEntiCoinvoltiForIdServizio(Long idServizio) {
		List<String> parametriMancanti = new ArrayList<>();

		if(idServizio==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTEnteCoinvoltoServizioSelector enteCoinvoltoSelector = new SerseTEnteCoinvoltoServizioSelector();
		SerseTEnteCoinvoltoServizioSelector.Criteria enteCoinvoltoCriteria = enteCoinvoltoSelector.createCriteria();
		enteCoinvoltoCriteria.andIdServizioEqualTo(idServizio);


		List<SerseTEnteCoinvoltoServizioDTO> entiSelezionato= enteCoinvoltoServizioDaoGenerato.selectByExample(enteCoinvoltoSelector);
		List<EnteCoinvoltoWrapper> entiCoinvolti =  new ArrayList<>();

		for (SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizioDTO : entiSelezionato) {
			EnteCoinvoltoWrapper enteWrapper = new EnteCoinvoltoWrapper();
			EnteCoinvoltoServizio enteCoinvoltoServizio = voMapper.toVoEnteCoinvoltoServizio(enteCoinvoltoServizioDTO);
			if(enteCoinvoltoServizioDTO.getIdEnteCoinvoltoIntervento()!=null ) {
				SerseTEnteCoinvoltoInterventoDTO serseTEnteCoinvoltoInterventoDTO = enteCoinvoltoInterventoDaoGenerato.selectByPrimaryKey(
						enteCoinvoltoServizioDTO.getIdEnteCoinvoltoIntervento());
				if (serseTEnteCoinvoltoInterventoDTO.getIdEnteCoinvoltoModello() != null) {
					SerseTEnteCoinvoltoModelloDTO serseTEnteCoinvoltoModelloDto = enteCoinvoltoModelloDaoGenerato.selectByPrimaryKey(
							serseTEnteCoinvoltoInterventoDTO.getIdEnteCoinvoltoModello());

					EnteCoinvoltoModello enteCoinvoltoModello = voMapper.toVoEnteCoinvoltoModello(
							serseTEnteCoinvoltoModelloDto);
					if (enteCoinvoltoModello.getIdFonteDato() != null && enteCoinvoltoModello.getIdFonteDato() == 1L) {
						getIstitutoScolasticoFonteDato1(enteCoinvoltoModello);
					}
					enteWrapper.setEnteCoinvoltoModello(enteCoinvoltoModello);
				}
				EnteCoinvoltoIntervento enteCoinvoltoIntervento = voMapper.toVoEnteCoinvoltoIntervento(
						serseTEnteCoinvoltoInterventoDTO);
				if (enteCoinvoltoIntervento.getIdFonteDato() != null && enteCoinvoltoIntervento.getIdFonteDato() == 1L) {
					getEntiCoinvoltiFonteDato1(enteCoinvoltoIntervento);
				}
				enteWrapper.setEnteCoinvoltoIntervento(enteCoinvoltoIntervento);
			}

			if (enteCoinvoltoServizio.getIdFonteDato() != null && enteCoinvoltoServizio.getIdFonteDato() == 1L) {
				getIstitutoFonteDato1(enteCoinvoltoServizio);
			}
			enteWrapper.setEnteCoinvoltoServizio(enteCoinvoltoServizio);

			if(enteWrapper.getEnteCoinvoltoServizio()!=null
					|| enteWrapper.getEnteCoinvoltoIntervento()!=null
					|| enteWrapper.getEnteCoinvoltoModello()!=null){
				entiCoinvolti.add(enteWrapper);
			}

		}
		return Response.ok(entiCoinvolti).build();
	}

	private void getIstitutoScolasticoFonteDato1(EnteCoinvoltoModello enteCoinvoltoModello) {
		IstitutoScolasticoDTO istituto = istitutiScolasticiDAO.getIstitutiScolastici(null, null, null,
				null, null, enteCoinvoltoModello.getCodice1Soggetto(), null, null).stream().findFirst().orElse(null);

		if (istituto != null) {
			enteCoinvoltoModello.setCodMeccanografico(istituto.getCodMeccanograficoScuola());
			enteCoinvoltoModello.setCodMeccanograficoAutonomia(istituto.getCodMeccanograficoAutonomia());
			enteCoinvoltoModello.setPercorso(Optional.ofNullable(istituto.getPercorsoScolastico()).map(
					PercorsoScolasticoDTO::getDescrPercorso).orElse(null));
			enteCoinvoltoModello.setTipologia(Optional.ofNullable(istituto.getTipologiaIstituto()).map(
					TipologiaIstitutoScolasticoDTO::getDescrTipologia).orElse(null));
			enteCoinvoltoModello.setGradoScolastico(
					Optional.ofNullable(istituto.getGradoScolastico()).map(GradoScolasticoDTO::getDescrGradoScolastico).orElse(null));
			IstitutoScolasticoDTO autonomia = istitutiScolasticiDAO.getAutonomiaForIstituto(istituto.getIdIstitutoScolastico());
			if (autonomia != null) {
				enteCoinvoltoModello.setAutonomia(autonomia.getCodRegionaleAutonomia()+" - "+ autonomia.getDenominazione());
			}
		}
	}

	private void getIstitutoFonteDato1(EnteCoinvoltoServizio enteCoinvoltoServizio) {
		IstitutoScolasticoDTO istituto = istitutiScolasticiDAO.getIstitutiScolastici(
						null, null, null, null, null, enteCoinvoltoServizio.getCodice1Soggetto(), null, null)
				.stream()
				.findFirst()
				.orElse(null);

		if (istituto != null) {
			enteCoinvoltoServizio.setCodMeccanografico(istituto.getCodMeccanograficoScuola());
			enteCoinvoltoServizio.setCodMeccanograficoAutonomia(istituto.getCodMeccanograficoAutonomia());
			enteCoinvoltoServizio.setPercorso(Optional.ofNullable(istituto.getPercorsoScolastico())
					.map(PercorsoScolasticoDTO::getDescrPercorso)
					.orElse(null));
			enteCoinvoltoServizio.setTipologia(Optional.ofNullable(istituto.getTipologiaIstituto())
					.map(TipologiaIstitutoScolasticoDTO::getDescrTipologia)
					.orElse(null));
			enteCoinvoltoServizio.setGradoScolastico(Optional.ofNullable(istituto.getGradoScolastico())
					.map(GradoScolasticoDTO::getDescrGradoScolastico)
					.orElse(null));
			IstitutoScolasticoDTO autonomia = istitutiScolasticiDAO.getAutonomiaForIstituto(istituto.getIdIstitutoScolastico());
			if (autonomia != null) {
				enteCoinvoltoServizio.setAutonomia(autonomia.getCodRegionaleAutonomia()+" - "+ autonomia.getDenominazione());
			}
		}
	}

	private void getEntiCoinvoltiFonteDato1(EnteCoinvoltoIntervento enteCoinvoltoIntervento) {
		IstitutoScolasticoDTO istituto = istitutiScolasticiDAO.getIstitutiScolastici(null, null, null, null,
				null, enteCoinvoltoIntervento.getCodice1Soggetto(), null, null).stream().findFirst().orElse(
				null);

		if (istituto != null) {
			enteCoinvoltoIntervento.setCodMeccanografico(istituto.getCodMeccanograficoScuola());
			enteCoinvoltoIntervento.setCodMeccanograficoAutonomia(istituto.getCodMeccanograficoAutonomia());
			enteCoinvoltoIntervento.setPercorso(Optional.ofNullable(istituto.getPercorsoScolastico()).map(
					PercorsoScolasticoDTO::getDescrPercorso).orElse(null));
			enteCoinvoltoIntervento.setTipologia(Optional.ofNullable(istituto.getTipologiaIstituto()).map(
					TipologiaIstitutoScolasticoDTO::getDescrTipologia).orElse(null));
			enteCoinvoltoIntervento.setGradoScolastico(
					Optional.ofNullable(istituto.getGradoScolastico()).map(GradoScolasticoDTO::getDescrGradoScolastico).orElse(null));
			IstitutoScolasticoDTO autonomia = istitutiScolasticiDAO.getAutonomiaForIstituto(istituto.getIdIstitutoScolastico());
			if (autonomia != null) {
				enteCoinvoltoIntervento.setAutonomia(autonomia.getCodRegionaleAutonomia()+" - "+ autonomia.getDenominazione());
			}
		}
	}

	@Transactional
	public Response updateEnteCoinvoltoServizio(EnteCoinvoltoServizio body, String codUserAggiorn) {
		List<String> parametriMancanti = new ArrayList<>();
		if(codUserAggiorn==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		int risp = 0;

		SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizio = enteCoinvoltoServizioDaoGenerato.selectByPrimaryKey(body.getIdEnteConvoltoServizio());
		if(body.getIdFonteDato()==null){
			enteCoinvoltoServizio.setIdPso(null);
			
			enteCoinvoltoServizio.setDenominazione(body.getDenominazione());
			enteCoinvoltoServizio.setDenominazioneSedePrincipale(body.getDenominazioneSedePrincipale());
			enteCoinvoltoServizio.setCodIstatComune(body.getComune().getCodiceIstatComune());
			enteCoinvoltoServizio.setIndirizzo(body.getIndirizzo());
			enteCoinvoltoServizio.setReferenteNome(body.getReferente().getReferenteNome());
			enteCoinvoltoServizio.setReferenteCognome(body.getReferente().getReferenteCognome());
			enteCoinvoltoServizio.setReferenteEmail(body.getReferente().getReferenteEmail());
			enteCoinvoltoServizio.setReferenteTelefono(body.getReferente().getReferenteTelefono());
			enteCoinvoltoServizio.setCodUserAggiorn(codUserAggiorn);
			enteCoinvoltoServizio.setdAggiorn(enteCoinvoltoInterventoDaoGenerato.getNow());

			risp = enteCoinvoltoServizioDaoGenerato.updateByPrimaryKey(enteCoinvoltoServizio);

			if(risp != 0) {
				SerseTServizioDTO servizioDTO = servizioDAOgenerato.selectByPrimaryKey(body.getIdServizio());
				servizioDTO.setCodUserAggiorn(codUserAggiorn);
				servizioDTO.setdAggiorn(servizioDAOgenerato.getNow());

				risp += servizioDAOgenerato.updateByPrimaryKey(servizioDTO);
			}


		}else {
			enteCoinvoltoServizio.setReferenteNome(body.getReferente().getReferenteNome());
			enteCoinvoltoServizio.setReferenteCognome(body.getReferente().getReferenteCognome());
			enteCoinvoltoServizio.setReferenteEmail(body.getReferente().getReferenteEmail());
			enteCoinvoltoServizio.setReferenteTelefono(body.getReferente().getReferenteTelefono());
			enteCoinvoltoServizio.setCodUserAggiorn(codUserAggiorn);
			enteCoinvoltoServizio.setdAggiorn(enteCoinvoltoInterventoDaoGenerato.getNow());

			risp = enteCoinvoltoServizioDaoGenerato.updateByPrimaryKey(enteCoinvoltoServizio);
		}

		GenericResponse success=new GenericResponse();
		if(risp !=0)
			success.setMessage(Constants.RISPOSTE_RESPONSE.MODIFICA_SUCCES);
		return Response.ok(success).build();
	}

	@Transactional
	public Response deleteEntiCoinvoltiServizio(String codUserAggiornamento, Long idEnteCoinvoltoServizio, Long idEnteCoinvoltoIntervento, Long idEnteCoinvoltoModello, Long idServizio, Long idIntervento) {
		/*
		 * Algoritmo Gestione Icona <Cancella>
		 *
		 */
		List<String> parametriMancanti = new ArrayList<>();

		if(codUserAggiornamento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


		int risp;

        if (idEnteCoinvoltoServizio != null && idEnteCoinvoltoIntervento == null && idEnteCoinvoltoModello == null && idServizio == null && idIntervento == null) {
            // caso 1: cancellazione per enteCoinvoltoServizio
            SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizioDTO = enteCoinvoltoServizioDaoGenerato.selectByPrimaryKey(idEnteCoinvoltoServizio);
            idServizio = enteCoinvoltoServizioDTO.getIdServizio();

            risp = enteCoinvoltoServizioDaoGenerato.deleteByPrimaryKey(idEnteCoinvoltoServizio);
        } else if (idEnteCoinvoltoIntervento != null && idServizio != null && idEnteCoinvoltoServizio == null && idEnteCoinvoltoModello == null && idIntervento == null) {
            // caso 2: cancellazione per enteCoinvoltoIntervento
            SerseTEnteCoinvoltoServizioSelector enteInterventoSelector = new SerseTEnteCoinvoltoServizioSelector();
            SerseTEnteCoinvoltoServizioSelector.Criteria enteInterventoCriteria = enteInterventoSelector.createCriteria();
            enteInterventoCriteria.andIdEnteCoinvoltoInterventoEqualTo(idEnteCoinvoltoIntervento).andIdServizioEqualTo(idServizio);
            List<SerseTEnteCoinvoltoServizioDTO> enteCoinvoltoServizioDTOList = enteCoinvoltoServizioDaoGenerato.selectByExample(enteInterventoSelector);

            risp = enteCoinvoltoServizioDaoGenerato.deleteByPrimaryKey(enteCoinvoltoServizioDTOList.get(0).getIdEnteConvoltoServizio());
        } else if (idEnteCoinvoltoModello != null && idIntervento != null && idServizio != null && idEnteCoinvoltoServizio == null && idEnteCoinvoltoIntervento == null) {
            // caso 3: cancellazione per enteCoinvoltoModello
            SerseTEnteCoinvoltoInterventoSelector enteModelloSelector = new SerseTEnteCoinvoltoInterventoSelector();
            SerseTEnteCoinvoltoInterventoSelector.Criteria enteModelloCriteria = enteModelloSelector.createCriteria();
            enteModelloCriteria.andIdEnteCoinvoltoModelloEqualTo(idEnteCoinvoltoModello).andIdInterventoEqualTo(idIntervento);
            List<SerseTEnteCoinvoltoInterventoDTO> enteCoinvoltoInterventoDTOList = enteCoinvoltoInterventoDaoGenerato.selectByExample(enteModelloSelector);

            SerseTEnteCoinvoltoServizioSelector enteInterventoSelector = new SerseTEnteCoinvoltoServizioSelector();
            SerseTEnteCoinvoltoServizioSelector.Criteria enteInterventoCriteria = enteInterventoSelector.createCriteria();
            enteInterventoCriteria.andIdEnteCoinvoltoInterventoEqualTo(enteCoinvoltoInterventoDTOList.get(0).getIdEnteCoinvoltoIntervento()).andIdServizioEqualTo(idServizio);
            List<SerseTEnteCoinvoltoServizioDTO> enteCoinvoltoServizioDTOList = enteCoinvoltoServizioDaoGenerato.selectByExample(enteInterventoSelector);

            risp = enteCoinvoltoServizioDaoGenerato.deleteByPrimaryKey(enteCoinvoltoServizioDTOList.get(0).getIdEnteConvoltoServizio());
        }else return parametriObbligatoriMancantiIncongruenti("Combinazione di parametri non valida");

		if(risp != 0 && idServizio != null) {
			SerseTServizioDTO servizioDTO = servizioDAOgenerato.selectByPrimaryKey(idServizio);
			servizioDTO.setCodUserAggiorn(codUserAggiornamento);
			servizioDTO.setdAggiorn(interventoDAOGenerato.getNow());
			risp += servizioDAOgenerato.updateByPrimaryKey(servizioDTO);
		}

		GenericResponse success=new GenericResponse();
		if(risp != 0)
			success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);

		return Response.ok(success).build();
	}

	public Response getEnteCoinvoltoServizioForId(Long idEnteCoinvoltoServizio) {
		SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizioDTO = enteCoinvoltoServizioDaoGenerato.selectByPrimaryKey(idEnteCoinvoltoServizio);
		EnteCoinvoltoServizio enteCoinvolto = mybatisMapper.map(enteCoinvoltoServizioDTO);
		SerseDFonteDatoDTO fonteDato = fonteDatoDAOGenerato.selectByPrimaryKey(enteCoinvoltoServizioDTO.getIdFonteDato());

		if(fonteDato!=null){
			enteCoinvolto.setDescrizioneFonteDato(fonteDato.getDescrFonteDato());
		}
		enteCoinvolto.setComune(voMapper.tornaComune(enteCoinvoltoServizioDTO.getCodIstatComune()));

		return Response.ok(enteCoinvolto).build();
	}

	/************************************************************************************
	 * Gestione Enti Coinvolti Intervento
	 * FPL-SERSE-INT-CDU-019-V01-Gestione Enti Coinvolti Intervento
	 * ***********************************************************************************/


	public Response verificaPerAggiungiEntiCoinvoltiIntervento(Long idIntervento) {
		/*
		 * Algoritmo Aggiungi Ente Coinvolto
		 *
		 */
		List<String> parametriMancanti = new ArrayList<>();

		if(idIntervento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_INTERVENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(idIntervento);
		SerseDTipoInterventoDTO tipoIntervento = tipoInterventoDAOGenerato.selectByPrimaryKey(intervento.getCodTipoIntervento());

		SerseTEnteCoinvoltoInterventoSelector selectorECIntervento = new SerseTEnteCoinvoltoInterventoSelector();
		SerseTEnteCoinvoltoInterventoSelector.Criteria criteriaECIntervento = selectorECIntervento.createCriteria();
		criteriaECIntervento.andIdInterventoEqualTo(idIntervento);


		boolean controllaAggiungi = true;
		if(tipoIntervento.getFlgProgettazioneIndividuale() == null && intervento.getIdModelloDiIntervento() != null) {
			SerseTEnteCoinvoltoModelloSelector selectorECModello = new SerseTEnteCoinvoltoModelloSelector();
			SerseTEnteCoinvoltoModelloSelector.Criteria criteriaECModello = selectorECModello.createCriteria();
			criteriaECModello.andIdModelloDiInterventoEqualTo(intervento.getIdModelloDiIntervento());
			criteriaECModello.andIdRuoloEnteEqualTo(1L);
			criteriaECModello.andDCessazioneIsNull();
			List<SerseTEnteCoinvoltoModelloDTO> enteCoinvoltoModello = enteCoinvoltoModelloDaoGenerato.selectByExample(selectorECModello);
			if(!enteCoinvoltoModello.isEmpty())
				controllaAggiungi=false;
		}

		TestEnteCoinvoltoIntervento returnTest = new TestEnteCoinvoltoIntervento();


		returnTest.setIsInterventoAssociatoAdModello(!controllaAggiungi);

		return Response.ok(returnTest).build();


	}


	@Transactional
	public Response deleteEntiCoinvoltiIntervento(Long idEnteCoinvoltoIntervento, String codUserAggiornamento) {
		/*
		 * Algoritmo Gestione Icona <Cancella>
		 *
		 */
		List<String> parametriMancanti = new ArrayList<>();

		if(idEnteCoinvoltoIntervento==null) {
			parametriMancanti.add("idEnteCoinvoltoIntervento");
		}

		if(codUserAggiornamento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


		int risp = 0;

		SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento = enteCoinvoltoInterventoDaoGenerato.selectByPrimaryKey(idEnteCoinvoltoIntervento);
		
		// Get per capire se l'ente e' associato ad un servizio
		SerseTEnteCoinvoltoServizioSelector enteCoinvoltoServizioSelector = new SerseTEnteCoinvoltoServizioSelector();
		SerseTEnteCoinvoltoServizioSelector.Criteria enteCoinvoltoServizioCriteria = enteCoinvoltoServizioSelector.createCriteria();
		enteCoinvoltoServizioCriteria.andIdEnteCoinvoltoInterventoEqualTo(enteCoinvoltoIntervento.getIdEnteCoinvoltoIntervento());
		List<SerseTEnteCoinvoltoServizioDTO> enteCoinvoltoServizioDTO = enteCoinvoltoServizioDaoGenerato.selectByExample(enteCoinvoltoServizioSelector);
		
		// Se la lista contiene almeno un record vuol dire che l'ente e' associato ad un servizio 
		// quindi non e' possibile eliminarlo
		if (enteCoinvoltoServizioDTO.size() > 0) {
			throw new ErroreGestitoException("L'Ente Coinvolto selezionato non può essere eliminato perché è già associato ad almeno un Servizio");
		}
		// Se supera il controllo elimino l'ente dall'intervento
		risp = enteCoinvoltoInterventoDaoGenerato.deleteByPrimaryKey(idEnteCoinvoltoIntervento);

		if(risp != 0) {
			SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(enteCoinvoltoIntervento.getIdIntervento());
			intervento.setCodUserAggiorn(codUserAggiornamento);
			intervento.setdAggiorn(interventoDAOGenerato.getNow());
			risp += interventoDAOGenerato.updateByPrimaryKey(intervento);
		}


		GenericResponse success=new GenericResponse();
		if(risp != 0)
			success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);

		return Response.ok(success).build();
	}


	public Response getEntiCoinvoltiForIntervento(Long idIntervento) {
		List<String> parametriMancanti = new ArrayList<>();

		if(idIntervento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_INTERVENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTEnteCoinvoltoInterventoSelector enteCoinvoltoSelector = new SerseTEnteCoinvoltoInterventoSelector();
		SerseTEnteCoinvoltoInterventoSelector.Criteria enteCoinvoltoCriteria = enteCoinvoltoSelector.createCriteria();
		enteCoinvoltoCriteria.andIdInterventoEqualTo(idIntervento);

		List<SerseTEnteCoinvoltoInterventoDTO> entiSelezionato= enteCoinvoltoInterventoDaoGenerato.selectByExample(enteCoinvoltoSelector);
		List<EnteCoinvoltoWrapper> entiCoinvolti =  new ArrayList<>();

		for (SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoInterventoDTO : entiSelezionato) {
			EnteCoinvoltoWrapper enteWrapper= new EnteCoinvoltoWrapper();
			EnteCoinvoltoIntervento enteCoinvoltoIntervento = voMapper.toVoEnteCoinvoltoIntervento(enteCoinvoltoInterventoDTO);
			if(enteCoinvoltoInterventoDTO.getIdEnteCoinvoltoModello()!=null ){
				SerseTEnteCoinvoltoModelloDTO serseTEnteCoinvoltoModelloDTO= enteCoinvoltoModelloDaoGenerato.selectByPrimaryKey(enteCoinvoltoInterventoDTO.getIdEnteCoinvoltoModello());
				EnteCoinvoltoModello enteCoinvoltoModello= voMapper.toVoEnteCoinvoltoModello(serseTEnteCoinvoltoModelloDTO);
				enteWrapper.setEnteCoinvoltoModello(enteCoinvoltoModello);
			}
			if (enteCoinvoltoIntervento.getIdFonteDato() != null && enteCoinvoltoIntervento.getIdFonteDato() == 1L) {
				getEntiCoinvoltiFonteDato1(enteCoinvoltoIntervento);
			}
			enteWrapper.setEnteCoinvoltoIntervento(enteCoinvoltoIntervento);

			if(enteWrapper.getEnteCoinvoltoServizio()!=null
					|| enteWrapper.getEnteCoinvoltoIntervento()!=null
					|| enteWrapper.getEnteCoinvoltoModello()!=null){
				entiCoinvolti.add(enteWrapper);
			}
		}
		return Response.ok(entiCoinvolti).build();

	}

	public Response getEnteCoinvoltoInterventoForId(@NotNull Long idEnteCoinvoltoIntervento) {
		SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento = enteCoinvoltoInterventoDaoGenerato.selectByPrimaryKey(idEnteCoinvoltoIntervento);
		EnteCoinvoltoIntervento enteCoinvolto = mybatisMapper.map(enteCoinvoltoIntervento);
		SerseDFonteDatoDTO fonteDato = fonteDatoDAOGenerato.selectByPrimaryKey(enteCoinvoltoIntervento.getIdFonteDato());
		
		if(fonteDato!=null){
			enteCoinvolto.setDescrizioneFonteDato(fonteDato.getDescrFonteDato());
		}
		enteCoinvolto.setComune(voMapper.tornaComune(enteCoinvoltoIntervento.getCodIstatComune()));


		return Response.ok(enteCoinvolto).build();
	}

	@Transactional
	public Response updateEnteCoinvoltoIntervento(EnteCoinvoltoIntervento body, String codUserAggiorn) {
		List<String> parametriMancanti = new ArrayList<>();
		if(codUserAggiorn==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		int risp = 0;
		SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento = enteCoinvoltoInterventoDaoGenerato.selectByPrimaryKey(body.getIdEnteCoinvoltoIntervento());

		if(enteCoinvoltoIntervento.getIdFonteDato() == null) {

			enteCoinvoltoIntervento.setDenominazione(body.getDenominazione());
			enteCoinvoltoIntervento.setDenominazioneSedePrincipale(body.getDenominazioneSedePrincipale());
			enteCoinvoltoIntervento.setCodIstatComune(body.getComune().getCodiceIstatComune());
			enteCoinvoltoIntervento.setIndirizzo(body.getIndirizzo());
			enteCoinvoltoIntervento.setReferenteNome(body.getReferente().getReferenteNome());
			enteCoinvoltoIntervento.setReferenteCognome(body.getReferente().getReferenteCognome());
			enteCoinvoltoIntervento.setReferenteEmail(body.getReferente().getReferenteEmail());
			enteCoinvoltoIntervento.setReferenteTelefono(body.getReferente().getReferenteTelefono());
			enteCoinvoltoIntervento.setCodUserAggiorn(codUserAggiorn);
			enteCoinvoltoIntervento.setdAggiorn(enteCoinvoltoInterventoDaoGenerato.getNow());

			risp = enteCoinvoltoInterventoDaoGenerato.updateByPrimaryKey(enteCoinvoltoIntervento);

			if(risp != 0) {
				SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(body.getIdIntervento());
				intervento.setCodUserAggiorn(codUserAggiorn);
				intervento.setdAggiorn(interventoDAOGenerato.getNow());

				risp += interventoDAOGenerato.updateByPrimaryKey(intervento);
			}


		}else {
			enteCoinvoltoIntervento.setReferenteNome(body.getReferente().getReferenteNome());
			enteCoinvoltoIntervento.setReferenteCognome(body.getReferente().getReferenteCognome());
			enteCoinvoltoIntervento.setReferenteEmail(body.getReferente().getReferenteEmail());
			enteCoinvoltoIntervento.setReferenteTelefono(body.getReferente().getReferenteTelefono());
			enteCoinvoltoIntervento.setCodUserAggiorn(codUserAggiorn);
			enteCoinvoltoIntervento.setdAggiorn(enteCoinvoltoInterventoDaoGenerato.getNow());

			risp = enteCoinvoltoInterventoDaoGenerato.updateByPrimaryKey(enteCoinvoltoIntervento);
		}

		GenericResponse success=new GenericResponse();
		if(risp !=0)
			success.setMessage("Modifica salvata correttamente");


		return Response.ok(success).build();

	}

	/*
        FPL-SERSE-SER-CDU-026-V01-Gestione Destinatari Servizio

        Algoritmo Lista Enti Destinatario
     */
	public Response getEntiDestinatariForIdServizio(Long idServizio) {
		List<String> parametriMancanti = new ArrayList<>();

		if(idServizio==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_SERVIZIO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTEnteCoinvoltoServizioSelector enteCoinvoltoSelector = new SerseTEnteCoinvoltoServizioSelector();
		SerseTEnteCoinvoltoServizioSelector.Criteria enteCoinvoltoCriteria = enteCoinvoltoSelector.createCriteria();
		enteCoinvoltoCriteria.andIdServizioEqualTo(idServizio);


		List<SerseTEnteCoinvoltoServizioDTO> entiSelezionato= enteCoinvoltoServizioDaoGenerato.selectByExample(enteCoinvoltoSelector);
		List<EnteDestinatario> entiDestinatario = new ArrayList<>();

		for (SerseTEnteCoinvoltoServizioDTO enteSelezionato: entiSelezionato) {
			EnteDestinatario enteDestinatario = new EnteDestinatario();
			enteDestinatario.setIdEnteConvoltoServizio(enteSelezionato.getIdEnteConvoltoServizio());
			if(enteSelezionato.getIdEnteCoinvoltoIntervento() == null){
				enteDestinatario.setOdice1Soggetto(enteSelezionato.getCodice1Soggetto());
				enteDestinatario.setCodice2Soggetto(enteSelezionato.getCodice2Soggetto());
				enteDestinatario.setDenominazione(enteSelezionato.getDenominazione());
			}else {
				SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento = enteCoinvoltoInterventoDaoGenerato.selectByPrimaryKey(enteSelezionato.getIdEnteCoinvoltoIntervento());
				if(enteCoinvoltoIntervento.getIdEnteCoinvoltoModello() == null){
					enteDestinatario.setOdice1Soggetto(enteCoinvoltoIntervento.getCodice1Soggetto());
					enteDestinatario.setCodice2Soggetto(enteCoinvoltoIntervento.getCodice2Soggetto());
					enteDestinatario.setDenominazione(enteCoinvoltoIntervento.getDenominazione());
				}else {
					EnteCoinvoltoModelloDTO enteSCoinvoltoModello= entiCoinvoltiDao.getEnteCoinvoltoModelloForId(enteCoinvoltoIntervento.getIdEnteCoinvoltoModello());
					enteDestinatario.setOdice1Soggetto(enteSCoinvoltoModello.getCodice1Soggetto());
					enteDestinatario.setCodice2Soggetto(enteSCoinvoltoModello.getCodice2Soggetto());
					enteDestinatario.setDenominazione(enteSCoinvoltoModello.getDenominazione());
				}
			}
			entiDestinatario.add(enteDestinatario);
		}
		return Response.ok(entiDestinatario).build();
	}
	// 1.1.0 priorita 1 ID 260 cessare un ente coinvolto modello
	public Response cessareEnteCoinvoltoModello(EnteCoinvoltoModello enteCoinvoltoModello){
		SerseTEnteCoinvoltoModelloDTO enteCoinvoltoModelloDTO = enteCoinvoltoModelloDaoGenerato.selectByPrimaryKey(enteCoinvoltoModello.getIdEnteCoinvoltoModello());
		enteCoinvoltoModelloDTO.setdCessazione(enteCoinvoltoModelloDaoGenerato.getNow());
		enteCoinvoltoModelloDTO.setCodUserCessazione(enteCoinvoltoModello.getCodUserCessazione());

		GenericResponse risposta = new GenericResponse();
		if(enteCoinvoltoModelloDaoGenerato.updateByPrimaryKey(enteCoinvoltoModelloDTO) ==0 )
			risposta.setMessage("Errore");
		else
			risposta.setMessage("Cessazione effettuata con successo");

		return Response.ok(risposta).build();
	}


	@Transactional
	public Response deleteEntiCoinvoltiInterventoModello(Long idEnteCoinvoltoModello, Long idIntervento, String codUserAggiornamento) {
		/*
		 * Algoritmo Gestione Icona <Cancella>
		 *
		 */
		List<String> parametriMancanti = new ArrayList<>();

		if(idEnteCoinvoltoModello==null) {
			parametriMancanti.add("idEnteCoinvoltoModello");
		}

		if(idIntervento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.ID_INTERVENTO);
		}

		if(codUserAggiornamento==null) {
			parametriMancanti.add(Constants.INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}

		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


		int risp = 0;

		// Get dell'ente coinvolto nell'intervento tramite modello
		SerseTEnteCoinvoltoInterventoSelector enteModelloSelector = new SerseTEnteCoinvoltoInterventoSelector();
		SerseTEnteCoinvoltoInterventoSelector.Criteria enteModelloCriteria = enteModelloSelector.createCriteria();
		enteModelloCriteria.andIdEnteCoinvoltoModelloEqualTo(idEnteCoinvoltoModello).andIdInterventoEqualTo(idIntervento);
		List<SerseTEnteCoinvoltoInterventoDTO> enteCoinvoltoInterventoModello = enteCoinvoltoInterventoDaoGenerato.selectByExample(enteModelloSelector);

		// Get per capire se l'ente e' associato ad un servizio
		SerseTEnteCoinvoltoServizioSelector enteCoinvoltoServizioSelector = new SerseTEnteCoinvoltoServizioSelector();
		SerseTEnteCoinvoltoServizioSelector.Criteria enteCoinvoltoServizioCriteria = enteCoinvoltoServizioSelector.createCriteria();
		enteCoinvoltoServizioCriteria.andIdEnteCoinvoltoInterventoEqualTo(enteCoinvoltoInterventoModello.get(0).getIdEnteCoinvoltoIntervento());
		List<SerseTEnteCoinvoltoServizioDTO> enteCoinvoltoServizioDTO = enteCoinvoltoServizioDaoGenerato.selectByExample(enteCoinvoltoServizioSelector);

		// Se la lista contiene almeno un record vuol dire che l'ente e' associato ad un servizio 
		// quindi non e' possibile eliminarlo
		if (enteCoinvoltoServizioDTO.size() > 0) {
			throw new ErroreGestitoException("L'Ente Coinvolto selezionato non può essere eliminato perché è già associato ad almeno un Servizio");
		}
		// Se supera il controllo elimino l'ente dall'intervento
		risp = enteCoinvoltoInterventoDaoGenerato.deleteByPrimaryKey(enteCoinvoltoInterventoModello.get(0).getIdEnteCoinvoltoIntervento());
		if(risp != 0) {
			SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(enteCoinvoltoInterventoModello.get(0).getIdIntervento());
			intervento.setCodUserAggiorn(codUserAggiornamento);
			intervento.setdAggiorn(interventoDAOGenerato.getNow());
			risp += interventoDAOGenerato.updateByPrimaryKey(intervento);
		}


		GenericResponse success=new GenericResponse();
		if(risp != 0)
			success.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
		return Response.ok(success).build();
	}
}
