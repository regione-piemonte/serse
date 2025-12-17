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
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.InterventiDAO.FilterInterventiSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.InterventiDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.SoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.InterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TestInterventoModificaDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDPeriodoAttivazioneServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDRegComportPsoSportDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDStatoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDTipoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTSoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDPeriodoAttivazioneServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDTipoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSoggettoAttuatoreSelector;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.CambioStatoIntervento;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.FilterInterventi;
import it.csi.serse.serseweb.vo.FilterParent;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.Intervento;
import it.csi.serse.serseweb.vo.InterventoPageWrapper;
import it.csi.serse.serseweb.vo.InterventoWrapper;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.ServiziAssociatiIntervento;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import it.csi.serse.serseweb.vo.TestInterventoModifica;
import jakarta.ws.rs.core.Response;

@Component
public class InterventiManager extends ParentManager{
	@Autowired
	private GenericMapper genericMapper;

	@Autowired
	private MybatisGeneretedDTOMapper myBatisMapper;
	@Autowired
	private InterventiDAO interventiDao;

	@Autowired
	private SoggettoAttuatoreDAO soggettoAttuatoreDAO;

	@Autowired
	private FlaianagpgHelper flaiAnag;

	@Autowired
	private SerseTInterventoDAO interventoDAOGenerato;

	@Autowired
	private SerseTEnteCoinvoltoInterventoDAO enteCoinvoltoInterventoDaoGenerato;

	@Autowired
	private SerseDRegComportPsoSportDAO comportamentoSportelloDAO;

	@Autowired
	private SerseDStatoInterventoDAO statoInterventoDao;

	@Autowired
	private SerseDTipoInterventoDAO tipoInterventoDAOGenerato;

	@Autowired
	private SerseTServizioDAO servizioDAOGenerato;

	@Autowired
	private SerseTSoggettoAttuatoreDAO serseTSoggettoAttuatoreDAOGenerato;

	@Autowired
	private SerseRDestinatarioServizioDAO destinatarioServizioDAOGenerato;

	@Autowired
	private SerseTEnteCoinvoltoServizioDAO enteCoinvoltoServizioDAOGenerato;

	@Autowired
	private SerseDPeriodoAttivazioneServizioDAO serseDPeriodoAttivazioneServizioDAO;

	@Autowired
	private SerseTSoggettoAttuatoreDAO soggettoAttuatoreDAOGenerato;

	@Autowired
	private SoggettoAttuatoreManager soggAttuatoreManager;

	public Response getStatiIntervento(){
		SerseDStatoInterventoSelector selector=new SerseDStatoInterventoSelector();
		List<SerseDStatoInterventoDTO> serseDStatoInterventoDTOList=statoInterventoDao.selectByExample(selector);

		return Response.ok(myBatisMapper.mapListaStatoIntervento(serseDStatoInterventoDTOList)).build();
	}


	/**
	 *
	 */
	public Response getTipologieInterventoForPso(Long idPso) {
		List<String> parametriMancanti=new ArrayList<>();
		if(idPso==null) {
			parametriMancanti.add(INPUT_MISSING.ID_PSO);
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<TipoInterventoDTO> tipiIntervento=interventiDao.getTipologieInterventoForPso(idPso);
		if(tipiIntervento!=null && !tipiIntervento.isEmpty()) {
			return Response.ok(genericMapper.mapListTipiIntervento(tipiIntervento)).build();
		}
		return Response.ok(tipiIntervento).build();
	}

	/**

	 */
	@Transactional
	public Response deleteInterventoById(Long idIntervento) {
		List<String> parametriMancanti=new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add("idIntervento");

		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		SerseTEnteCoinvoltoInterventoSelector enteCoinInterSelector = new SerseTEnteCoinvoltoInterventoSelector();
		SerseTEnteCoinvoltoInterventoSelector.Criteria enteCoinInterCriteria = enteCoinInterSelector.createCriteria();
		enteCoinInterCriteria.andIdInterventoEqualTo(idIntervento);
		List<SerseTEnteCoinvoltoInterventoDTO> entiCoinvoloInterventoDTO = enteCoinvoltoInterventoDaoGenerato.selectByExample(enteCoinInterSelector);
		for (SerseTEnteCoinvoltoInterventoDTO serseTEnteCoinvoltoInterventoDTO : entiCoinvoloInterventoDTO) {
			enteCoinvoltoInterventoDaoGenerato.deleteByPrimaryKey(serseTEnteCoinvoltoInterventoDTO.getIdEnteCoinvoltoIntervento());
		}

		int risDelete = 0;
		try {
			risDelete = interventoDAOGenerato.deleteByPrimaryKey(idIntervento);
		}catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}
		GenericResponse risposta=new GenericResponse();

		if(risDelete==1) {
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.CANCELLATO_SUCCES);
			return Response.ok(risposta).build();
		}
		Errore errore = new Errore();
		errore.setCode(1);
		errore.setErrorMessage("errore di cancellazione");
		return Response.ok(errore).build();
	}

	//Per fare sentire meglio a sonar
	private TestInterventoModifica testIntervento(List<TestInterventoModificaDTO> interventoTest){
		TestInterventoModifica interventoTestBoolean= new TestInterventoModifica();
		if(!(interventoTest!=null && !interventoTest.isEmpty()))
			return interventoTestBoolean;

		for (TestInterventoModificaDTO test: interventoTest) {
			if (test == null)
				continue;
			if (test.getIdModelloIntervento() != null)
				interventoTestBoolean.setIdModelloIntervento(true);
			if (test.getIdDestinatario() != null)
				interventoTestBoolean.setIdDestinatario(true);
			if (test.getIdEnteCoinvoltoIntervento() != null)
				interventoTestBoolean.setIdEnteCoinvoltoIntervento(true);
			if (test.getIdServizio() != null)
				interventoTestBoolean.setIsServizioAssociato(true);
		}


		return interventoTestBoolean;
	}

	/**
	 *
	 */
	public Response verificaCampiIntervento(Long idIntervento, Long numProgrSportello) {
		List<String> parametriMancanti=new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}
		if(numProgrSportello==null){
			parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		List<TestInterventoModificaDTO> interventoTest=interventiDao.verificaCampiIntervento(idIntervento);

		TestInterventoModifica interventoTestBoolean= testIntervento(interventoTest);

		SerseDRegComportPsoSportSelector comportPsoSportSelector=new SerseDRegComportPsoSportSelector();
		SerseDRegComportPsoSportSelector.Criteria criteria= comportPsoSportSelector.createCriteria();
		criteria.andNumProgrSportelloEqualTo(numProgrSportello);
		SerseDRegComportPsoSportDTO rgSport= comportamentoSportelloDAO.selectByExample(comportPsoSportSelector).get(0);

		if(rgSport!=null && rgSport.getTipoGestioneIntervento()!=null)
			interventoTestBoolean.setTipoGestioneIntervento(rgSport.getTipoGestioneIntervento());
		return Response.ok(interventoTestBoolean).build();
	}

	/**
	 *
	 */
	public Response selectIntervento(Long idIntervento){
		List<String> parametriMancanti=new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}


		InterventoDTO interventoDTO=getInterventoById(idIntervento);
		if(interventoDTO!=null) {
			Integer codOperatoreSoggettoAttuatore = interventoDTO.getSoggettoAttuatore().getCodOperatore();
			String gruppoOperatoreSoggettoAttuatore = interventoDTO.getSoggettoAttuatore().getGruppoOperatore();
			SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatoreSoggettoAttuatore, codOperatoreSoggettoAttuatore);
			try {
				if (operatore != null) {
					interventoDTO.getSoggettoAttuatore().setDenominazioneGiuridica(operatore.getDenominazionePersonaGiuridica());
					return Response.ok(genericMapper.map(interventoDTO)).build();
				}
			} catch (Exception e) {
				throw new ErroreConnessioneServizioException(501, e.getMessage());
			}

		}
		return Response.ok(interventoDTO).build();
	}

	/**
	 *
	 */
	public InterventoDTO getInterventoById(Long idIntervento){
		InterventoDTO interventoDTO=interventiDao.getInterventoById(idIntervento);
		if (interventoDTO != null) {
			Integer codOperatoreSoggettoAttuatore = interventoDTO.getSoggettoAttuatore().getCodOperatore();
			String gruppoOperatoreSoggettoAttuatore = interventoDTO.getSoggettoAttuatore().getGruppoOperatore();
			SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatoreSoggettoAttuatore, codOperatoreSoggettoAttuatore);
			try {
				if (operatore != null) {
					interventoDTO.getSoggettoAttuatore().setDenominazioneGiuridica(operatore.getDenominazionePersonaGiuridica());
				}
			} catch (Exception e) {
				throw new ErroreConnessioneServizioException(501, e.getMessage());
			}
		}
		return interventoDTO;
	}

	/**
	 *
	 */
	public Response insertIntervento(Intervento intervento){
		SerseTInterventoDTO interventoMappato= myBatisMapper.toSerseTIntervento(intervento);
		interventoMappato.setIdIntervento(interventoDAOGenerato.getNextValIdIntervento());
		interventoMappato.setdInserim(interventoDAOGenerato.getNow());
		interventoMappato.setdAggiorn(interventoDAOGenerato.getNow());


		SerseTSoggettoAttuatoreSelector soggettoAttuatoreSelector=new SerseTSoggettoAttuatoreSelector();
		SerseTSoggettoAttuatoreSelector.Criteria criteria= soggettoAttuatoreSelector.createCriteria();
		criteria.andCodOperatoreEqualTo(intervento.getSoggettoAttuatore().getCodOperatore().longValue());
		criteria.andNumProgrSportelloEqualTo(intervento.getSoggettoAttuatore().getNumProgrSportello().longValue());
		criteria.andModelIdEqualTo(intervento.getSoggettoAttuatore().getModelId().longValue());
		criteria.andGruppoOperatoreEqualTo(intervento.getSoggettoAttuatore().getGruppoOperatore());

		interventoMappato.setIdSoggettoAttuatore(serseTSoggettoAttuatoreDAOGenerato.selectByExample(soggettoAttuatoreSelector).get(0).getIdSoggettoAttuatore());

		int result=interventoDAOGenerato.insert(interventoMappato);
		if (result==1){
			Long idIntervento=interventoMappato.getIdIntervento();

			Intervento interventoInserito = genericMapper.map(getInterventoById(idIntervento));

			return Response.ok(interventoInserito).build();
		}
		return null;
	}

	public Response updateIntervento(Intervento intervento){
		SerseTInterventoDTO interventoMappato= myBatisMapper.toSerseTIntervento(intervento);
		interventoMappato.setdAggiorn(interventoDAOGenerato.getNow());

		SerseTSoggettoAttuatoreSelector soggettoAttuatoreSelector=new SerseTSoggettoAttuatoreSelector();
		SerseTSoggettoAttuatoreSelector.Criteria criteria= soggettoAttuatoreSelector.createCriteria();
		criteria.andCodOperatoreEqualTo(intervento.getSoggettoAttuatore().getCodOperatore().longValue());
		criteria.andNumProgrSportelloEqualTo(intervento.getSoggettoAttuatore().getNumProgrSportello().longValue());
		criteria.andModelIdEqualTo(intervento.getSoggettoAttuatore().getModelId().longValue());
		criteria.andGruppoOperatoreEqualTo(intervento.getSoggettoAttuatore().getGruppoOperatore());

		interventoMappato.setIdSoggettoAttuatore(serseTSoggettoAttuatoreDAOGenerato.selectByExample(soggettoAttuatoreSelector).get(0).getIdSoggettoAttuatore());

		int result=interventoDAOGenerato.updateByPrimaryKey(interventoMappato);

		if(result==1){
			Long idIntervento=interventoMappato.getIdIntervento();
			Intervento interventoAggiornato = genericMapper.map(getInterventoById(idIntervento));
			return Response.ok(interventoAggiornato).build();
		}
		return null;
	}


	/**
	 * RICERCA INTERVENTI
	 */
	public Response getInterventi(FilterInterventi filter, Integer offset, Integer limit, String sort){
		/*gestione errori sui parametri*/

        List<String> parametriMancanti = chkParametriMancanti(filter);
        if (!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        if (!chkFiltroSoggettoBeneficiario(filter)) {
            return parametriObbligatoriMancantiIncongruenti("codOperatoreSoggettoBeneficiario e "
            + "gruppoOperatoreSoggettoBeneficiario devono essere entrambi null o entrambi valorizzati");
        }

        // per i Filter, abbiamo usato il formato CSI che è più generale ma effettivamente pesante...
        FilterInterventiSemplificato filtroSemplificato = genericMapper.map(filter);

		/*estraggo le denominazioni giuridiche una sola volta per ridurre il numero di chiamate esterne*/
		List<SoggettoAttuatoreDTO> soggettiAttuatori= soggettoAttuatoreDAO.getSoggettiAttuatori(
			filter.getNumProgrSportello().getEq(), filter.getCodOperatore().getEq(),
			filter.getGruppoOperatore().getEq());
		Map<String,PersonaGiuridica> soggettiDenominazione = soggAttuatoreManager.getDenominazioniGiuridiche(soggettiAttuatori);

		/*estraggo la data di fine sportello*/
		SerseDPeriodoAttivazioneServizioSelector selectorSportello= new SerseDPeriodoAttivazioneServizioSelector();
		SerseDPeriodoAttivazioneServizioSelector.Criteria criteriaSportello= selectorSportello.createCriteria();
		criteriaSportello.andNumProgrSportelloEqualTo(filter.getNumProgrSportello().getEq());
		Date dFine=serseDPeriodoAttivazioneServizioDAO.selectByExample(selectorSportello).get(0).getdFineAttivazione();

		/*estraggo la tipologia di sportello*/
		SerseDRegComportPsoSportSelector selectorComportamento= new SerseDRegComportPsoSportSelector();
		SerseDRegComportPsoSportSelector.Criteria criteriaComportamneto=selectorComportamento.createCriteria();
		criteriaComportamneto.andNumProgrSportelloEqualTo(filter.getNumProgrSportello().getEq());
		String flgTipoGestioneIntervento = comportamentoSportelloDAO.selectByExample(selectorComportamento).get(0).getTipoGestioneIntervento();

		/*primo elenco filtrato da db*/
		List<InterventoDTO> elencoInterventi = interventiDao.getInterventi(filtroSemplificato, offset, limit, new SortBean(sort));
		Long count = interventiDao.countInterventi(filtroSemplificato);

		List<InterventoWrapper> elencoInterventiWrapper= new ArrayList<>();
		elencoInterventi.forEach(intervento->{

			InterventoWrapper tmpInterventoWrapper = new InterventoWrapper();

			/*carico i dati di intervento, sportello e destinatario*/
			tmpInterventoWrapper = getInterventoWrappato(intervento);
			tmpInterventoWrapper.setSportelloDfine(dFine);
			tmpInterventoWrapper.setSportelloFlgTipoGestioneIntervento(flgTipoGestioneIntervento);
			String grpCodSB = intervento.getGruppoBeneficiario() + intervento.getCodiceBeneficiario();
			PersonaGiuridica tmpSoggettoBeneficiario=soggettiDenominazione.get(grpCodSB);

			tmpInterventoWrapper.setSoggettoBeneficiario(tmpSoggettoBeneficiario);

			/*estraggo la denominazione giuridica del soggetto attuatore*/
			Integer codOperatoreSoggettoAttuatore = intervento.getSoggettoAttuatore().getCodOperatore();
			String gruppoOperatoreSoggettoAttuatore = intervento.getSoggettoAttuatore().getGruppoOperatore();
			String grpCod = gruppoOperatoreSoggettoAttuatore + codOperatoreSoggettoAttuatore;
			tmpInterventoWrapper.setDenominazioneSoggettoAttuatore(soggettiDenominazione.get(grpCod).getDenominazione());

			/*Controllo se il soggetto attuatore è proprietario dell'intervento*/
			tmpInterventoWrapper.setIsProprietario(codOperatoreSoggettoAttuatore.equals(filter.getCodOperatore().getEq()) &&
					gruppoOperatoreSoggettoAttuatore.equals(filter.getGruppoOperatore().getEq()));

			elencoInterventiWrapper.add(tmpInterventoWrapper);
		});

		InterventoPageWrapper elencoInterventiPageWrapper = new InterventoPageWrapper();
		elencoInterventiPageWrapper.setCount(count);
		elencoInterventiPageWrapper.setItems(elencoInterventiWrapper);

		return Response.ok(elencoInterventiPageWrapper).build();
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

	/*metodo per caricare i dati nell'oggetto da restiutuire*/

	/**
	 *
	 */
	private InterventoWrapper getInterventoWrappato(InterventoDTO intervento){
		InterventoWrapper tmpInterventoWrapper= new InterventoWrapper();
		tmpInterventoWrapper.setIntervento(genericMapper.map(intervento));

		/*controllo se è associato ad un servizio*/
		tmpInterventoWrapper.setIsAssociatoServizio(intervento.getNumServizi() > 0);

		/*carico i dati del destinatario se flg tipo intervento è individuale*/
		if(tmpInterventoWrapper.getIntervento().getTipoIntervento().getFlgProgettazioneIndividuale()!=null
				&& intervento.getIdDestinatario()!=null) {
			DestinatarioDTO destinatarioDTOTmp = intervento.getDestinatario();
			Destinatario destinatarioTmp=new Destinatario();
			destinatarioTmp.setNomeDestinatario(destinatarioDTOTmp.getNomeDestinatario());
			destinatarioTmp.setCognomeDestinatario(destinatarioDTOTmp.getCognomeDestinatario());
			destinatarioTmp.setCodiceFiscaleDestinatario(destinatarioDTOTmp.getCfDestinatario());
			tmpInterventoWrapper.setDestinatario(destinatarioTmp);
		}
		return tmpInterventoWrapper;
	}

	/*
	 * FPL-SERSE-INT-CDU-024-V01-Inserimento e aggiornamento Servizio (con spesa)
	 */

	public Response updateStatoIntervento(CambioStatoIntervento body) {
		//SerseTInterventoDAO interventoDAOGenerato
		SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(body.getIdIntervento());
		GenericResponse risposta=new GenericResponse();
		if(body.getIdStatoIntervento() != null && body.getIdStatoIntervento().equals(20L)) {

			SerseDTipoInterventoDTO tipoIntervento = tipoInterventoDAOGenerato.selectByPrimaryKey(intervento.getCodTipoIntervento());
			if(tipoIntervento.getFlgProgettazioneIndividuale() != null && tipoIntervento.getFlgProgettazioneIndividuale().equals("S")) {
				if(intervento.getIdDestinatario() != null) {
					intervento.setIdStatoIntervento(20L);
					interventoDAOGenerato.updateByPrimaryKey(intervento);
					risposta.setMessage(Constants.RISPOSTE_RESPONSE.MODIFICA_SUCCES);
				}else {
					risposta.setMessage("Attenzione: non è possibile attivare l’Intervento perché non è stato indicato il Destinatario.");
				}
			}
		}

		if(body.getIdStatoIntervento() != null && body.getIdStatoIntervento().equals(10L)) {
			SerseTServizioSelector servizioSelector = new SerseTServizioSelector();
			SerseTServizioSelector.Criteria servizioCriteria = servizioSelector.createCriteria();
			servizioCriteria.andIdInterventoEqualTo(intervento.getIdIntervento());
			List<SerseTServizioDTO> servizio = servizioDAOGenerato.selectByExample(servizioSelector);

			if(!servizio.isEmpty()) {
				intervento.setIdStatoIntervento(10L);
				interventoDAOGenerato.updateByPrimaryKey(intervento);
				risposta.setMessage(Constants.RISPOSTE_RESPONSE.MODIFICA_SUCCES);
			}else {
				risposta.setMessage("Attenzione: non è possibile disattivare l’Intervento perché sono presenti dei Sevizi correlati.");
			}

		}


		return Response.ok(risposta).build();


	}

    public Response testChiusuraIntervento(Long idIntervento) {

		boolean chkServizi= true;
		SerseTServizioSelector servizioSelector=new SerseTServizioSelector();
		SerseTServizioSelector.Criteria criteria=servizioSelector.createCriteria();
		criteria.andIdInterventoEqualTo(idIntervento);

		List<SerseTServizioDTO> listServizi= servizioDAOGenerato.selectByExample(servizioSelector);

		if(listServizi.isEmpty()){
			return Response.ok(chkServizi).build();
		}else{
			for (SerseTServizioDTO ser:
					listServizi) {
				if (!ser.getIdStatoServizio().equals(40L)) {
					chkServizi = false;
					break;
				}
			}
		}
		return Response.ok(chkServizi).build();
    }

	public Response getServiziAssociatiIntervento(Long idIntervento){
		ServiziAssociatiIntervento serviziAssociatiIntervento=new ServiziAssociatiIntervento();

		SerseTServizioSelector selector=new SerseTServizioSelector();
		SerseTServizioSelector.Criteria criteria= selector.createCriteria();
		criteria.andIdInterventoEqualTo(idIntervento);
		List<SerseTServizioDTO> serseTServizioList=servizioDAOGenerato.selectByExample(selector);

		serviziAssociatiIntervento.setIdIntervento(idIntervento);
		serviziAssociatiIntervento.setNumServiziAssociati(serseTServizioList.size());

		int i=0;
		for (SerseTServizioDTO s: serseTServizioList) {
			if(s.getIdStatoServizio().equals(40L)){
				i++;
			}
		}
		serviziAssociatiIntervento.setNumServiziChiusi(i);
		return Response.ok(serviziAssociatiIntervento).build();
	}



    /*
		FLP-SERSE-INT-CDU 012-V03 Duplica_Intervento
	 */
	@Transactional
	public Response duplicaIntervento(Long idIntervento, String codUserAggiornamento){
		List<String> parametriMancanti=new ArrayList<>();
		if(idIntervento==null) {
			parametriMancanti.add(INPUT_MISSING.ID_INTERVENTO);
		}
		if(codUserAggiornamento==null){
			parametriMancanti.add(INPUT_MISSING.COD_USER_AGGIORNAMENTO);
		}
		if(!parametriMancanti.isEmpty()) {
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		Date adesso = interventoDAOGenerato.getNow();
		SerseTInterventoDTO interventoDTO = interventoDAOGenerato.selectByPrimaryKey(idIntervento);
		SerseTInterventoDTO interventoDuplicato = myBatisMapper.clonazione(interventoDTO);
		interventoDuplicato.setIdIntervento(interventoDAOGenerato.getNextValIdIntervento());
		if(interventoDTO.getIdStatoIntervento()==40L)
			interventoDuplicato.setIdStatoIntervento(20L);

		if(!interventoDTO.getCodTipoIntervento().equals("PI"))
			interventoDuplicato.setIdDestinatario(null);

		interventoDuplicato.setCodUserInserim(codUserAggiornamento);
		interventoDuplicato.setCodUserAggiorn(codUserAggiornamento);
		interventoDuplicato.setdAggiorn(adesso);
		interventoDuplicato.setdInserim(adesso);

		interventoDAOGenerato.insert(interventoDuplicato);

		Long idInterventoNuovo = interventoDuplicato.getIdIntervento();

		SerseTEnteCoinvoltoInterventoSelector enteCoinvoltoInterventoSelector = new SerseTEnteCoinvoltoInterventoSelector();
		SerseTEnteCoinvoltoInterventoSelector.Criteria enteCoinvoltoInterventoCriteria = enteCoinvoltoInterventoSelector.createCriteria();
		enteCoinvoltoInterventoCriteria.andIdInterventoEqualTo(interventoDTO.getIdIntervento());
		
		List<SerseTEnteCoinvoltoInterventoDTO> enteCoinvoltoInterventoDTOS = enteCoinvoltoInterventoDaoGenerato.selectByExample(enteCoinvoltoInterventoSelector);
		List<SerseTEnteCoinvoltoInterventoDTO> enteCoinvoltoInterventoDTOSDuplicato = new ArrayList<>();
		for (SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento: enteCoinvoltoInterventoDTOS) {
			enteCoinvoltoIntervento.setIdEnteCoinvoltoIntervento(enteCoinvoltoInterventoDaoGenerato.getNextValIdEnteCoinvoltoIntervento());
			enteCoinvoltoIntervento.setIdIntervento(idInterventoNuovo);
			enteCoinvoltoIntervento.setCodUserInserim(codUserAggiornamento);
			enteCoinvoltoIntervento.setCodUserAggiorn(codUserAggiornamento);
			enteCoinvoltoIntervento.setdAggiorn(adesso);
			enteCoinvoltoIntervento.setdInserim(adesso);

			enteCoinvoltoInterventoDaoGenerato.insert(enteCoinvoltoIntervento);

			enteCoinvoltoInterventoDTOSDuplicato.add(enteCoinvoltoIntervento);
		}

		SerseTServizioSelector servizioSelector = new SerseTServizioSelector();
		SerseTServizioSelector.Criteria servizioCriteria = servizioSelector.createCriteria();
		servizioCriteria.andIdInterventoEqualTo(idIntervento);

		List<SerseTServizioDTO> serseTServizioDTOS = servizioDAOGenerato.selectByExample(servizioSelector);
		duplicaServizio(serseTServizioDTOS, codUserAggiornamento, adesso, idInterventoNuovo, enteCoinvoltoInterventoDTOSDuplicato);

		InterventoDTO interventoDTO1= interventiDao.getInterventoById(interventoDuplicato.getIdIntervento());

		//sarebbe poi da spostare questo in un metodo a parte
		SoggettoAttuatore soggettoAttuatore = myBatisMapper.map(soggettoAttuatoreDAOGenerato.selectByPrimaryKey(interventoDTO1.getSoggettoAttuatore().getIdSoggettoAttuatore()));
		Integer codOperatoreSoggettoAttuatore = soggettoAttuatore.getCodOperatore();
		String gruppoOperatoreSoggettoAttuatore = soggettoAttuatore.getGruppoOperatore();
		try {
			SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatoreSoggettoAttuatore, codOperatoreSoggettoAttuatore);
			if (operatore != null) {	
				soggettoAttuatore.setDenominazioneGiuridica(operatore.getDenominazionePersonaGiuridica());

			}
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}

		Intervento intervento = genericMapper.map(interventoDTO1);
		intervento.setSoggettoAttuatore(soggettoAttuatore);
		return Response.ok(intervento).build();
	}

	private void duplicaServizio(List<SerseTServizioDTO> serseTServizioDTOS, String codUserAggiornamento, Date adesso, Long idIntervento, List<SerseTEnteCoinvoltoInterventoDTO> enteCoinvoltoInterventoDTOSDuplicato){
		for (SerseTServizioDTO servizio: serseTServizioDTOS) {
			Long idServizioOld = servizio.getIdServizio();
			servizio.setIdServizio(servizioDAOGenerato.getNextValIdServizio());
			servizio.setIdIntervento(idIntervento);
			servizio.setIdStatoServizio(10L);
			servizio.setdInserim(adesso);
			servizio.setdAggiorn(adesso);
			servizio.setCodUserInserim(codUserAggiornamento);
			servizio.setCodUserAggiorn(codUserAggiornamento);
			servizioDAOGenerato.insert(servizio);

			SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
			SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria = destinatarioServizioSelector.createCriteria();
			destinatarioServizioCriteria.andIdServizioEqualTo(idServizioOld);

			List<SerseRDestinatarioServizioDTO> destinatarioServizioDTOS = destinatarioServizioDAOGenerato.selectByExample(destinatarioServizioSelector);

			Long idServizioDuplicato = servizio.getIdServizio();

			duplicaEnteCoinvoltoServizioEDestinatarioServizio(idServizioDuplicato, enteCoinvoltoInterventoDTOSDuplicato, codUserAggiornamento, adesso, destinatarioServizioDTOS);
		}
	}

	private void duplicaEnteCoinvoltoServizioEDestinatarioServizio(Long idServizio, List<SerseTEnteCoinvoltoInterventoDTO> entiCoinvoltiIntervento, String codUserAggiornamento, Date adesso, List<SerseRDestinatarioServizioDTO> destinatarioServizioDTOS){

		for (SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoInterventoDTO : entiCoinvoltiIntervento) {
			SerseTEnteCoinvoltoServizioDTO ecServizio = new SerseTEnteCoinvoltoServizioDTO();
			ecServizio.setIdEnteConvoltoServizio(enteCoinvoltoServizioDAOGenerato.getNextValIdEnteCoinvoltoServizio());
			ecServizio.setIdServizio(idServizio);
			ecServizio.setIdEnteCoinvoltoIntervento(enteCoinvoltoInterventoDTO.getIdEnteCoinvoltoIntervento());
			ecServizio.setCodUserInserim(codUserAggiornamento);
			ecServizio.setCodUserAggiorn(codUserAggiornamento);
			ecServizio.setdInserim(adesso);
			ecServizio.setdAggiorn(adesso);
			enteCoinvoltoServizioDAOGenerato.insert(ecServizio);
		}

		for (SerseRDestinatarioServizioDTO destinatarioServizio: destinatarioServizioDTOS) {
			destinatarioServizio.setIdDestinatarioServizio(destinatarioServizioDAOGenerato.getNextValIdDestinatarioServizio());
			destinatarioServizio.setNumerazioneDestinatario(destinatarioServizioDAOGenerato.getNextNumerazioneDestinatario(idServizio));
			destinatarioServizio.setIdServizio(idServizio);
			destinatarioServizio.setCodUserInserim(codUserAggiornamento);
			destinatarioServizio.setCodUserAggiorn(codUserAggiornamento);
			destinatarioServizio.setdInserim(adesso);
			destinatarioServizio.setdAggiorn(adesso);
			destinatarioServizioDAOGenerato.insert(destinatarioServizio);
		}
	}


    public Response getInterventiPerModello(Long idModelloIntervento) {
        List<InterventoDTO> interventi = interventiDao.getInterventiPerModello(idModelloIntervento);
		List<Intervento> interventiList = genericMapper.mapListaInterventi(interventi);

		// manca denominazione giuridica
		List<SoggettoAttuatoreDTO> soggettiAttuatori = interventi.stream().map(InterventoDTO::getSoggettoAttuatore).collect(Collectors.toList());
		Map<String, PersonaGiuridica> soggettiDenominazione = soggAttuatoreManager.getDenominazioniGiuridiche(soggettiAttuatori);
		for (Intervento intervento: interventiList) {
			SoggettoAttuatore soggettoAttuatore = intervento.getSoggettoAttuatore();
			String gruppoOperatore = soggettoAttuatore.getGruppoOperatore();
			Integer codOperatore = soggettoAttuatore.getCodOperatore();
			String key = gruppoOperatore + codOperatore;
			PersonaGiuridica personaGiuridica = soggettiDenominazione.get(key);
			if (personaGiuridica != null) {
				soggettoAttuatore.setDenominazioneGiuridica(personaGiuridica.getDenominazione());
			}
		}
		
		return Response.ok(interventiList).build();
    }
}
