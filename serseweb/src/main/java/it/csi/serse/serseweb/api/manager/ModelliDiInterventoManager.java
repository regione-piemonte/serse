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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneModelliDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneModelliDiInterventoDAO.FilterModelliSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.SoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ModelloInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDPeriodoAttivazioneServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDStatoModelloDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDTipoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRModelloInterventoPsoCaratteristicaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRModelloInterventoPsoTargetDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoModelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTModelloDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioModelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTSoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDPeriodoAttivazioneServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoModelloDiInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDTipoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoCaratteristicaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoCaratteristicaSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoTargetDestinatarioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioModelloSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSoggettoAttuatoreSelector;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.AssociareModelloIntervento;
import it.csi.serse.serseweb.vo.FilterModelli;
import it.csi.serse.serseweb.vo.FilterParent;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.InterventiAssociatiModello;
import it.csi.serse.serseweb.vo.ModelloIntervento;
import it.csi.serse.serseweb.vo.ModelloInterventoPageWrapper;
import it.csi.serse.serseweb.vo.ModelloInterventoWrapper;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.TestModelloInterventoModifica;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@Component
public class ModelliDiInterventoManager extends ParentManager {
	@Autowired
	private GenericMapper genericMapper;

	@Autowired
	private FlaianagpgHelper flaiAnag;

	@Autowired
	private MybatisGeneretedDTOMapper mybatisMapper;

	@Autowired
	private VoMapper voMapper;

	@Autowired
	private SoggettoAttuatoreDAO soggettoAttuatoreDAO;

	@Autowired
	private SerseTInterventoDAO interventoDAOGenerato;

	@Autowired
	private SerseTServizioModelloDAO servizioModelloDAOgenerato;

	@Autowired
	private SerseRModelloInterventoPsoTargetDestinatarioDAO serseRModelloInterventoPsoTargetDestinatarioDAO;

	@Autowired
	private SerseRModelloInterventoPsoCaratteristicaDAO serseRModelloInterventoPsoCaratteristicaDAO;

	@Autowired
	private SerseDStatoModelloDiInterventoDAO statoModelloDaoGenerato;

	@Autowired
	private GestioneModelliDiInterventoDAO gestioneModelliDAO;

	@Autowired
	private SerseTModelloDiInterventoDAO modelloInterventoDaoGenerato;

	@Autowired
	private SerseDTipoInterventoDAO tipoInterventoGenerato;

	@Autowired
	private SerseTEnteCoinvoltoModelloDAO enteCoinvoltoModelloGenerato;

	@Autowired
	private SerseTEnteCoinvoltoInterventoDAO enteCoinvoltoInterventoGenerato;

	@Autowired
	private SerseTSoggettoAttuatoreDAO serseTSoggettoAttuatoreDAOGenerato;

	@Autowired
	private SerseDPeriodoAttivazioneServizioDAO serseDPeriodoAttivazioneServizioDAO;

	@Autowired
	private SoggettoAttuatoreManager soggAttuatoreManager;

	public Response getStatiModelliIntervento() {

		SerseDStatoModelloDiInterventoSelector selector = new SerseDStatoModelloDiInterventoSelector();
		SerseDStatoModelloDiInterventoSelector.Criteria criteri = selector.createCriteria();
		criteri.andIdStatoModelloDiInterventoIsNotNull();
		List<SerseDStatoModelloDiInterventoDTO> stato = statoModelloDaoGenerato.selectByExample(selector);

		return Response.ok(mybatisMapper.mapListStatoModelloIntervento(stato)).build();
	}


	/*
	 * cancellazzione di un modello di intervento
	 */
	public Response deleteModelloInterventoById(Integer idModelloIntervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if (idModelloIntervento == null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
			return parametriObbligatoriMancanti(parametriMancanti);
		}
		return Response.ok(gestioneModelliDAO.deleteModelloIntervento(idModelloIntervento)).build();
	}


	public Response insertModelloIntervento(ModelloIntervento modelloIntervento) {
		SerseTModelloDiInterventoDTO modelloInterventoMappato=mybatisMapper.toModelloDIinteventoDTO(modelloIntervento);
		modelloInterventoMappato.setIdModelloDiIntervento(modelloInterventoDaoGenerato.getNextValIdModelloIntervento());
		modelloInterventoMappato.setdInserim(modelloInterventoDaoGenerato.getNow());
		modelloInterventoMappato.setdAggiorn(modelloInterventoDaoGenerato.getNow());

		SerseTSoggettoAttuatoreSelector soggettoAttuatoreSelector=new SerseTSoggettoAttuatoreSelector();
		SerseTSoggettoAttuatoreSelector.Criteria criteria= soggettoAttuatoreSelector.createCriteria();
		criteria.andCodOperatoreEqualTo(modelloIntervento.getSoggettoAttuatore().getCodOperatore().longValue());
		criteria.andNumProgrSportelloEqualTo(modelloIntervento.getSoggettoAttuatore().getNumProgrSportello().longValue());
		criteria.andModelIdEqualTo(modelloIntervento.getSoggettoAttuatore().getModelId().longValue());
		criteria.andGruppoOperatoreEqualTo(modelloIntervento.getSoggettoAttuatore().getGruppoOperatore());

		modelloInterventoMappato.setIdSoggettoAttuatore(serseTSoggettoAttuatoreDAOGenerato.selectByExample(soggettoAttuatoreSelector).get(0).getIdSoggettoAttuatore());

		int intRis=modelloInterventoDaoGenerato.insert(modelloInterventoMappato);

		if (intRis == 1) {
			return getModelloDiInterventoById(modelloInterventoMappato.getIdModelloDiIntervento());
		}
		return null;
	}

	public Response updateModelloIntervento(ModelloIntervento modelloIntervento) {
		SerseTModelloDiInterventoDTO modelloInterventoMappato=mybatisMapper.toModelloDIinteventoDTO(modelloIntervento);
		modelloInterventoMappato.setdAggiorn(modelloInterventoDaoGenerato.getNow());

		SerseTSoggettoAttuatoreSelector soggettoAttuatoreSelector = new SerseTSoggettoAttuatoreSelector();
		SerseTSoggettoAttuatoreSelector.Criteria criteria = soggettoAttuatoreSelector.createCriteria();
		criteria.andCodOperatoreEqualTo(modelloIntervento.getSoggettoAttuatore().getCodOperatore().longValue());
		criteria.andNumProgrSportelloEqualTo(modelloIntervento.getSoggettoAttuatore().getNumProgrSportello().longValue());
		criteria.andModelIdEqualTo(modelloIntervento.getSoggettoAttuatore().getModelId().longValue());
		criteria.andGruppoOperatoreEqualTo(modelloIntervento.getSoggettoAttuatore().getGruppoOperatore());

		modelloInterventoMappato.setIdSoggettoAttuatore(serseTSoggettoAttuatoreDAOGenerato.selectByExample(soggettoAttuatoreSelector).get(0).getIdSoggettoAttuatore());

		int intRis = modelloInterventoDaoGenerato.updateByPrimaryKey(modelloInterventoMappato);
		if (intRis == 1) {
			return getModelloDiInterventoById(modelloIntervento.getIdModelloIntervento());
		}
		return null;
	}

	public Response verificaCampiModelloIntervento(Long idModelloIntervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if (idModelloIntervento == null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		TestModelloInterventoModifica modelloInterventoBoolean = new TestModelloInterventoModifica();

		/*target destinatario*/
		SerseRModelloInterventoPsoTargetDestinatarioSelector selectorTd= new SerseRModelloInterventoPsoTargetDestinatarioSelector();
		SerseRModelloInterventoPsoTargetDestinatarioSelector.Criteria criteriTd= selectorTd.createCriteria();
		criteriTd.andIdModelloDiInterventoEqualTo(idModelloIntervento);
		if (!serseRModelloInterventoPsoTargetDestinatarioDAO.selectByExample(selectorTd).isEmpty()) {
			modelloInterventoBoolean.setIdRModelloTargetDest(true);
		}

		/*caratteristiche*/
		SerseRModelloInterventoPsoCaratteristicaSelector selectorCar= new SerseRModelloInterventoPsoCaratteristicaSelector();
		SerseRModelloInterventoPsoCaratteristicaSelector.Criteria criteriaCar= selectorCar.createCriteria();
		criteriaCar.andIdModelloDiInterventoEqualTo(idModelloIntervento);
		if (!serseRModelloInterventoPsoCaratteristicaDAO.selectByExample(selectorCar).isEmpty()) {
			modelloInterventoBoolean.setIdRCaratteristica(true);
		}

		/*enti coinvolti*/
		SerseTEnteCoinvoltoModelloSelector selectorEc = new SerseTEnteCoinvoltoModelloSelector();
		SerseTEnteCoinvoltoModelloSelector.Criteria criteriaEc = selectorEc.createCriteria();
		criteriaEc.andIdModelloDiInterventoEqualTo(idModelloIntervento);
		if (!enteCoinvoltoModelloGenerato.selectByExample(selectorEc).isEmpty()) {
			modelloInterventoBoolean.setIdEnteCoinvolto(true);
		}

		/*servizi modello*/
		SerseTServizioModelloSelector selectorSerMod = new SerseTServizioModelloSelector();
		SerseTServizioModelloSelector.Criteria criteriaSerMod = selectorSerMod.createCriteria();
		criteriaSerMod.andIdModelloDiInterventoEqualTo(idModelloIntervento);
		if (!servizioModelloDAOgenerato.selectByExample(selectorSerMod).isEmpty()) {
			modelloInterventoBoolean.setIdServizioModello(true);
		}

		/*interventi*/
		SerseTInterventoSelector selectorInt=new SerseTInterventoSelector();
		SerseTInterventoSelector.Criteria criteriaInt= selectorInt.createCriteria();
		criteriaInt.andIdModelloDiInterventoEqualTo(idModelloIntervento);
		if (!interventoDAOGenerato.selectByExample(selectorInt).isEmpty()) {
			modelloInterventoBoolean.setIdIntervento(true);
		}
		return Response.ok(modelloInterventoBoolean).build();
	}

	public Response getModelloDiInterventoById(Long idModelloIntervento) {
		List<String> parametriMancanti = new ArrayList<>();
		if (idModelloIntervento == null) {
			parametriMancanti.add(INPUT_MISSING.ID_MODELLO_INTERVENTO);
			return parametriObbligatoriMancanti(parametriMancanti);
		}

		ModelloInterventoDTO modelloIntervento=gestioneModelliDAO.getModelloDiInterventoById(idModelloIntervento);
		if (modelloIntervento != null) {
			Integer codOperatoreSoggettoAttuatore = modelloIntervento.getSoggettoAttuatore().getCodOperatore();
			String gruppoOperatoreSoggettoAttuatore = modelloIntervento.getSoggettoAttuatore().getGruppoOperatore();
			try {
				SintesiPersonaGiuridica operatore = flaiAnag.getOperatore(gruppoOperatoreSoggettoAttuatore, codOperatoreSoggettoAttuatore);
				if (operatore != null) {
					modelloIntervento.getSoggettoAttuatore().setDenominazioneGiuridica(operatore.getDenominazionePersonaGiuridica());
					return Response.ok(genericMapper.map(modelloIntervento)).build();
				}
			} catch (Exception e) {
				throw new ErroreConnessioneServizioException(501, e.getMessage());
			}
		}
		return Response.ok(modelloIntervento).build();
	}

	/*
	 *  FPL-SERSE-INT-CDU-011-V03-Inserisci e modifica Dati identificativi Intervento
	 *  Algoritmo – Associa Modello di Intervento
	 *
	 * @return Generic Response
	 */
	@Transactional
	public Response associaModelloDiIntervento(AssociareModelloIntervento body) {

		SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(body.getIdIntervento());

		/*Paso 2
		 * Se l’Intervento NON è di tipo Individuale, cioè se flg_progettazione_individuale è = NULL,
		 *  campo della SERSE_D_TIPO_INTERVENTO a cui accedere per cod_tipo_intervento = SERSE_T_INTERVENTO.cod_tipo_intervento
		 */
		SerseDTipoInterventoDTO tipoIntervento = tipoInterventoGenerato.selectByPrimaryKey(intervento.getCodTipoIntervento());
		if (tipoIntervento.getFlgProgettazioneIndividuale() == null) {
			SerseTEnteCoinvoltoModelloSelector selectorEnteCoinvoltoModello = new SerseTEnteCoinvoltoModelloSelector();
			SerseTEnteCoinvoltoModelloSelector.Criteria criteriaEnteCoinvoltoModello = selectorEnteCoinvoltoModello.createCriteria();
			criteriaEnteCoinvoltoModello.andIdModelloDiInterventoEqualTo(body.getIdModelloIntervento());
			criteriaEnteCoinvoltoModello.andIdRuoloEnteEqualTo(1L);
			criteriaEnteCoinvoltoModello.andDCessazioneIsNull();

			List<SerseTEnteCoinvoltoModelloDTO> entiCoinvoltiModello = enteCoinvoltoModelloGenerato.selectByExample(selectorEnteCoinvoltoModello);

			/*
			 * se il Modello selezionato prevede Enti con ruolo 1, eliminare tutti gli enti già eventualmente associati
			 * all’intervento Accedere alla SERSE_T_ENTE_COINVOLTO_MODELLO con 
			 * id_modello_di_intervento = <idModello_selezionato>: se esistono record il cui id_ruolo_ente è = 1, 
			 * allora eliminare tutti gli eventuali record presenti nella SERSE_T_ENTE_COINVOLTO_INTERVENTO a cui 
			 * accedere per id_intervento = <idIntervento_selezionato>
			 * 
			 */
			if (!entiCoinvoltiModello.isEmpty()) {
				SerseTEnteCoinvoltoInterventoSelector selectorEnteCoinvoltoIntervento = new SerseTEnteCoinvoltoInterventoSelector();
				SerseTEnteCoinvoltoInterventoSelector.Criteria criteriaEnteCoinvoltoIntervento = selectorEnteCoinvoltoIntervento.createCriteria();
				criteriaEnteCoinvoltoIntervento.andIdInterventoEqualTo(body.getIdIntervento());

				List<SerseTEnteCoinvoltoInterventoDTO> entiCoinvoltoIntervento = enteCoinvoltoInterventoGenerato.selectByExample(selectorEnteCoinvoltoIntervento);

				for (SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento: entiCoinvoltoIntervento) {
					enteCoinvoltoInterventoGenerato.deleteByPrimaryKey(enteCoinvoltoIntervento.getIdEnteCoinvoltoIntervento());
				}


			} else {
                /*
				 * •	se il Modello selezionato non prevede Enti con ruolo 1, eliminare tutti gli eventuali enti 
				 * già precedentemente associati all’intervento derivati “originariamente” dal Modello precedente
				 * Accedere alla SERSE_T_ENTE_COINVOLTO_INTERVENTO per:
				•	id_intervento = <idIntervento_selezionato>
				•	id_ente_coinvolto_modello valorizzato (indica che l’Ente associato deriva dal modello precedentemente 
				associato all’Intervento)
				ed eliminare i record individuate
				 */

				SerseTEnteCoinvoltoInterventoSelector selectorEnteCoinvoltoIntervento = new SerseTEnteCoinvoltoInterventoSelector();
				SerseTEnteCoinvoltoInterventoSelector.Criteria criteriaEnteCoinvoltoIntervento = selectorEnteCoinvoltoIntervento.createCriteria();
				criteriaEnteCoinvoltoIntervento.andIdInterventoEqualTo(body.getIdIntervento());
				criteriaEnteCoinvoltoIntervento.andIdEnteCoinvoltoModelloIsNotNull();

				List<SerseTEnteCoinvoltoInterventoDTO> entiCoinvoltoIntervento = enteCoinvoltoInterventoGenerato.selectByExample(selectorEnteCoinvoltoIntervento);

				for (SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento: entiCoinvoltoIntervento) {
					enteCoinvoltoInterventoGenerato.deleteByPrimaryKey(enteCoinvoltoIntervento.getIdEnteCoinvoltoIntervento());
				}
			}

            /*
			 * popolare automaticamente gli Ente/i Intervento, uno per ogni Ente non cessato incluso nel Modello 
			 * tra quelli dichiarati con ruolo 1, ossia coinvolti nei servizi. L’occorrenza creata a fronte dell’intervento 
			 * deve fare riferimento all’ente “originario” (FK), il quale manterrà la competenza “gerarchica” del dato 
			 * anagrafico, compresi i riferimenti indicati
			 * Ricavare tutti i record della SERSE_T_ENTE_COINVOLTO_MODELLO accedendo per:
				id_modello_di_intervento = <idModello_selezionato>
				id_ruolo_ente = 1
				d_cessazione is null
			 * 
			 */

			for (SerseTEnteCoinvoltoModelloDTO enteCoinvoltiModello: entiCoinvoltiModello) {
				/*
				 * e per ognuno di questi record inserire un occorrenza nella SERSE_T_ENTE_COINVOLTO_INTERVENTO 
				 * con questi dati:
				 * 
				 */
				SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento = new SerseTEnteCoinvoltoInterventoDTO();
				enteCoinvoltoIntervento.setIdEnteCoinvoltoIntervento(enteCoinvoltoInterventoGenerato.getNextValIdEnteCoinvoltoIntervento());
				enteCoinvoltoIntervento.setIdIntervento(body.getIdIntervento());
				enteCoinvoltoIntervento.setIdPso(enteCoinvoltiModello.getIdPso());
				enteCoinvoltoIntervento.setIdFonteDato(enteCoinvoltiModello.getIdFonteDato());
				enteCoinvoltoIntervento.setIdEnteCoinvoltoModello(enteCoinvoltiModello.getIdEnteCoinvoltoModello());
				enteCoinvoltoIntervento.setCodUserInserim(body.getCodFiscaleUtente());
				enteCoinvoltoIntervento.setdInserim(enteCoinvoltoInterventoGenerato.getNow());
				enteCoinvoltoIntervento.setCodUserAggiorn(body.getCodFiscaleUtente());
				enteCoinvoltoIntervento.setdAggiorn(enteCoinvoltoInterventoGenerato.getNow());

				enteCoinvoltoInterventoGenerato.insert(enteCoinvoltoIntervento);
			}
		}

		intervento.setIdModelloDiIntervento(body.getIdModelloIntervento());
		interventoDAOGenerato.updateByPrimaryKey(intervento);

		GenericResponse risposta = new GenericResponse();
		risposta.setMessage("Modello di Intervento Associato");
		return Response.ok(risposta).build();
	}


	/*
	 *  FPL-SERSE-INT-CDU-011-V03-Inserisci e modifica Dati identificativi Intervento
	 *  Algoritmo – Associa Modello di Intervento
	 *
	 * @return '200': description: il modello di intervento è stato disassociato
	 */
	@Transactional
	public Response disassociaModelloIntervento(Long idIntervento, Long idModelloIntervento) {
        /*
		 * Se l’Intervento NON è di tipo Individuale, cioè se flg_progettazione_individuale è != ‘S’,
		 * campo della SERSE_D_TIPO_INTERVENTO a cui accedere per 
		 * cod_tipo_intervento = SERSE_T_INTERVENTO.cod_tipo_intervento, 
		 * allora accedere alla SERSE_T_ENTE_COINVOLTO_INTERVENTO per:
			•   id_intervento = <idIntervento>
			•   id_ente_coinvolto_modello valorizzato (indica che l’Ente associato deriva dal modello precedentemente 
			associato all’Intervento)
			ed eliminare i record individuati.
		 * 
		 */
		int risp = 0;
		SerseTInterventoDTO intervento = interventoDAOGenerato.selectByPrimaryKey(idIntervento);
		SerseDTipoInterventoDTO tipoIntervento = tipoInterventoGenerato.selectByPrimaryKey(intervento.getCodTipoIntervento());
		if (tipoIntervento.getFlgProgettazioneIndividuale() == null) {
			SerseTEnteCoinvoltoInterventoSelector selectorEnteCoinvoltoIntervento = new SerseTEnteCoinvoltoInterventoSelector();
			SerseTEnteCoinvoltoInterventoSelector.Criteria criteriaEnteCoinvoltoIntervento = selectorEnteCoinvoltoIntervento.createCriteria();
			criteriaEnteCoinvoltoIntervento.andIdInterventoEqualTo(idIntervento);
			criteriaEnteCoinvoltoIntervento.andIdEnteCoinvoltoModelloIsNotNull();
			List<SerseTEnteCoinvoltoInterventoDTO> entiCoinvoltoIntervento = enteCoinvoltoInterventoGenerato.selectByExample(selectorEnteCoinvoltoIntervento);

			for (SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento: entiCoinvoltoIntervento) {
				enteCoinvoltoInterventoGenerato.deleteByPrimaryKey(enteCoinvoltoIntervento.getIdEnteCoinvoltoIntervento());
			}
		}

		intervento.setIdModelloDiIntervento(null);
		risp = interventoDAOGenerato.updateByPrimaryKey(intervento);

		GenericResponse risposta = new GenericResponse();
		if (risp != 0)
			risposta.setMessage("Il modello di intervento è stato disassociato");
		else
			risposta.setMessage("errore in disassociare");
		return Response.ok(risposta).build();
	}

	/**
	 * Ricerca modelli di intervento
	 */
	public Response getModelliIntervento(FilterModelli filter, Integer offset, Integer limit, String sort) {

        List<String> parametriMancanti = chkParametriMancanti(filter);
        if (!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        if (!chkFiltroSoggettoBeneficiario(filter)) {
            return parametriObbligatoriMancantiIncongruenti("codOperatoreSoggettoBeneficiario e "
            + "gruppoOperatoreSoggettoBeneficiario devono essere entrambi null o entrambi valorizzati");
        }

        // per i Filter, abbiamo usato il formato CSI che è più generale ma effettivamente pesante...
        FilterModelliSemplificato filtroSemplificato = genericMapper.map(filter);

		/*estraggo le denominazioni giuridiche una sola volta per ridurre il numero di chiamate esterne*/
		List<SoggettoAttuatoreDTO> soggettiAttuatori = soggettoAttuatoreDAO.getSoggettiAttuatori(
				filter.getNumProgrSportello().getEq(), filter.getCodOperatore().getEq(),
				filter.getGruppoOperatore().getEq());
		Map<String,PersonaGiuridica> soggettiDenominazione = soggAttuatoreManager.getDenominazioniGiuridiche(soggettiAttuatori);

		/*estraggo la data di fine sportello*/
		SerseDPeriodoAttivazioneServizioSelector selectorSportello = new SerseDPeriodoAttivazioneServizioSelector();
		SerseDPeriodoAttivazioneServizioSelector.Criteria criteriaSportello = selectorSportello.createCriteria();
		criteriaSportello.andNumProgrSportelloEqualTo(filter.getNumProgrSportello().getEq());
		Date dFine = serseDPeriodoAttivazioneServizioDAO.selectByExample(selectorSportello).get(0).getdFineAttivazione();

		/*lista iniziale*/
		List<ModelloInterventoDTO> elencoModelli = gestioneModelliDAO.getModelliIntervento(filtroSemplificato,
			offset, limit, new SortBean(sort));
		Long count = gestioneModelliDAO.countModelliIntervento(filtroSemplificato);

		List<ModelloInterventoWrapper> elencoModelliWrappati = new ArrayList<>();

		elencoModelli.forEach(modelloIntervento-> {

			ModelloInterventoWrapper tmpModelloInterventoWrappato = getModelloWrappato(modelloIntervento);
			tmpModelloInterventoWrappato.setSportelloDfine(dFine);
			String grpCodSB = modelloIntervento.getGruppoBeneficiario() + modelloIntervento.getCodiceBeneficiario();
			PersonaGiuridica tmpSoggettoBeneficiario = soggettiDenominazione.get(grpCodSB);

			tmpModelloInterventoWrappato.setSoggettoBeneficiario(tmpSoggettoBeneficiario);

			/*estraggo la denominazione giuridica del soggetto attuatore*/
			Integer codOperatoreSoggettoAttuatore = modelloIntervento.getSoggettoAttuatore().getCodOperatore();
			String gruppoOperatoreSoggettoAttuatore = modelloIntervento.getSoggettoAttuatore().getGruppoOperatore();
			String grpCod = gruppoOperatoreSoggettoAttuatore + codOperatoreSoggettoAttuatore;

			/*Controllo se il soggetto attuatore è proprietario del modello intervento*/
			tmpModelloInterventoWrappato.setIsProprietario(codOperatoreSoggettoAttuatore.equals(filter.getCodOperatore().getEq()) &&
			gruppoOperatoreSoggettoAttuatore.equals(filter.getGruppoOperatore().getEq()));

			if (soggettiDenominazione.get(grpCod) != null) {
				tmpModelloInterventoWrappato.setDenominazioneSoggettoAttuatore(soggettiDenominazione.get(grpCod).getDenominazione());
				tmpModelloInterventoWrappato.getModelloIntervento().getSoggettoAttuatore().setDenominazioneGiuridica(soggettiDenominazione.get(grpCod).getDenominazione());
			} else {
				LOG.error("ERRORE NEL REPERIMENTO DELLA DESCRIZIONE !?! grpCod={}", grpCod);
			}

			elencoModelliWrappati.add(tmpModelloInterventoWrappato);
		});

		ModelloInterventoPageWrapper modelliInterventoPageWrapper = new ModelloInterventoPageWrapper();
		modelliInterventoPageWrapper.setCount(count);
		modelliInterventoPageWrapper.setItems(elencoModelliWrappati);

		return Response.ok(modelliInterventoPageWrapper).build();
	}

	private ModelloInterventoWrapper getModelloWrappato(ModelloInterventoDTO modelloIntervento){
		ModelloInterventoWrapper tmpModelloInterventoWrappato = new ModelloInterventoWrapper();
		tmpModelloInterventoWrappato.setModelloIntervento(genericMapper.map(modelloIntervento));

	 	/*Controllo se ci sono Interventi Associati al modello*/
		tmpModelloInterventoWrappato.setIsAssociatoAdIntervento(modelloIntervento.getNumInterventi() > 0);
		return tmpModelloInterventoWrappato;
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

	//FPL-SERSE-MOD-CDU Ricerca Modello di Intervento
	@Transactional
	public Response duplicaModelloIntervento(Long idModelloDiIntervento, String codiceUser) {
		int risp = 0;
		Date dNow = modelloInterventoDaoGenerato.getNow();

		//Duplica ModelloIntervento
		SerseTModelloDiInterventoDTO modelloDiInterventoDTO = modelloInterventoDaoGenerato.selectByPrimaryKey(idModelloDiIntervento);
		modelloDiInterventoDTO.setIdModelloDiIntervento(modelloInterventoDaoGenerato.getNextValIdModelloIntervento());
		modelloDiInterventoDTO.setIdStatoModelloDiIntervento(10L);
		modelloDiInterventoDTO.setdAggiorn(dNow);
		modelloDiInterventoDTO.setdInserim(dNow);
		modelloDiInterventoDTO.setCodUserInserim(codiceUser);
		modelloDiInterventoDTO.setCodUserAggiorn(codiceUser);

		risp += modelloInterventoDaoGenerato.insert(modelloDiInterventoDTO);

		Long idModelloDiInterventoNuovo = modelloDiInterventoDTO.getIdModelloDiIntervento();

		//Duplica ModelloInterventoPsoTargetDestinatarioDAO serseRModelloInterventoPsoTargetDestinatarioDAO
		SerseRModelloInterventoPsoTargetDestinatarioSelector modelloInterventoPsoTargetDestinatarioSelector = new SerseRModelloInterventoPsoTargetDestinatarioSelector();
		SerseRModelloInterventoPsoTargetDestinatarioSelector.Criteria modelloInterventoPsoTargetDestinatarioCriteria = modelloInterventoPsoTargetDestinatarioSelector.createCriteria();
		modelloInterventoPsoTargetDestinatarioCriteria.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
		List<SerseRModelloInterventoPsoTargetDestinatarioDTO> modelloInterventoPsoTargetDestinatarioDTOS = serseRModelloInterventoPsoTargetDestinatarioDAO.selectByExample(modelloInterventoPsoTargetDestinatarioSelector);
		for (SerseRModelloInterventoPsoTargetDestinatarioDTO modelloInterventoPsoTargetDestinatarioDTO: modelloInterventoPsoTargetDestinatarioDTOS) {
			modelloInterventoPsoTargetDestinatarioDTO.setIdModelloDiIntervento(idModelloDiInterventoNuovo);
			risp += serseRModelloInterventoPsoTargetDestinatarioDAO.insert(modelloInterventoPsoTargetDestinatarioDTO);
		}

		// Duplica ModelloInterventoPsoCaratteristicaDAO
		SerseRModelloInterventoPsoCaratteristicaSelector modelloInterventoPsoCaratteristicaSelector = new SerseRModelloInterventoPsoCaratteristicaSelector();
		SerseRModelloInterventoPsoCaratteristicaSelector.Criteria modelloInterventoPsoCaratteristicaCriteria = modelloInterventoPsoCaratteristicaSelector.createCriteria();
		modelloInterventoPsoCaratteristicaCriteria.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
		List<SerseRModelloInterventoPsoCaratteristicaDTO> modelloInterventoPsoCaratteristicaDTOS = serseRModelloInterventoPsoCaratteristicaDAO.selectByExample(modelloInterventoPsoCaratteristicaSelector);
		for (SerseRModelloInterventoPsoCaratteristicaDTO modelloInterventoPsoCaratteristicaDTO: modelloInterventoPsoCaratteristicaDTOS) {
			modelloInterventoPsoCaratteristicaDTO.setIdModelloDiIntervento(idModelloDiInterventoNuovo);
			risp += serseRModelloInterventoPsoCaratteristicaDAO.insert(modelloInterventoPsoCaratteristicaDTO);
		}

		// Duplica SerseTEnteCoinvoltoModelloDAO
		SerseTEnteCoinvoltoModelloSelector enteCoinvoltoModelloSelector = new SerseTEnteCoinvoltoModelloSelector();
		SerseTEnteCoinvoltoModelloSelector.Criteria enteCoinvoltoModelloCriteria = enteCoinvoltoModelloSelector.createCriteria();
		enteCoinvoltoModelloCriteria.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
		enteCoinvoltoModelloCriteria.andDCessazioneIsNull();
		List<SerseTEnteCoinvoltoModelloDTO> enteCoinvoltoModelloDTOS = enteCoinvoltoModelloGenerato.selectByExample(enteCoinvoltoModelloSelector);
		for (SerseTEnteCoinvoltoModelloDTO enteCoinvoltoModelloDTO: enteCoinvoltoModelloDTOS) {
			enteCoinvoltoModelloDTO.setIdEnteCoinvoltoModello(enteCoinvoltoModelloGenerato.getNextValIdEnteCoinvoltoModello());
			enteCoinvoltoModelloDTO.setIdModelloDiIntervento(idModelloDiInterventoNuovo);
			enteCoinvoltoModelloDTO.setdAggiorn(dNow);
			enteCoinvoltoModelloDTO.setdInserim(dNow);
			enteCoinvoltoModelloDTO.setCodUserInserim(codiceUser);
			enteCoinvoltoModelloDTO.setCodUserAggiorn(codiceUser);

			risp += enteCoinvoltoModelloGenerato.insert(enteCoinvoltoModelloDTO);
		}

		//Duplica SerseTServizioModelloDAO servizioModelloDAOgenerato
		SerseTServizioModelloSelector serseTServizioModelloSelector = new SerseTServizioModelloSelector();
		SerseTServizioModelloSelector.Criteria serseTServizioModelloCriteria = serseTServizioModelloSelector.createCriteria();
		serseTServizioModelloCriteria.andIdModelloDiInterventoEqualTo(idModelloDiIntervento);
		List<SerseTServizioModelloDTO> serseTServizioModelloDTOS = servizioModelloDAOgenerato.selectByExample(serseTServizioModelloSelector);
		for (SerseTServizioModelloDTO serseTServizioModelloDTO: serseTServizioModelloDTOS) {
			serseTServizioModelloDTO.setIdServizioModello(servizioModelloDAOgenerato.getNextValIdServizioModello());
			serseTServizioModelloDTO.setIdModelloDiIntervento(idModelloDiInterventoNuovo);
			serseTServizioModelloDTO.setdAggiorn(dNow);
			serseTServizioModelloDTO.setdInserim(dNow);
			serseTServizioModelloDTO.setCodUserInserim(codiceUser);
			serseTServizioModelloDTO.setCodUserAggiorn(codiceUser);

			risp += servizioModelloDAOgenerato.insert(serseTServizioModelloDTO);
		}

		return Response.ok(voMapper.toVoModelloIntervento(modelloDiInterventoDTO)).build();
	}

	public Response getDatiExcelModello(Long idModelloIntervento){
		if (idModelloIntervento == null) {
			List<String> parametro = new ArrayList<>();
			parametro.add("idModelloIntervento");
			return parametriObbligatoriMancanti(parametro);
		}

		InterventiAssociatiModello tmp = new InterventiAssociatiModello();
		tmp.setIdModelloIntervento(idModelloIntervento);
		tmp.setNumInterventiAssociati(gestioneModelliDAO.getDatiExcelModello(idModelloIntervento));

		return Response.ok(tmp).build();
	}

	// 1.1.0 ID 257 reversibilita alla chiusura del modello d'intervento
	public Response cambioReversibilita(ModelloIntervento modelloIntervento) {
		int risp = 0;
		SerseTModelloDiInterventoDTO serseTModelloDiInterventoDTO = mybatisMapper.toModelloDIinteventoDTO(modelloIntervento);
		serseTModelloDiInterventoDTO.setdAggiorn(modelloInterventoDaoGenerato.getNow());

		risp = modelloInterventoDaoGenerato.updateByPrimaryKey(serseTModelloDiInterventoDTO);

		GenericResponse risposta=new GenericResponse();
		if(risp != 0)
			risposta.setMessage(Constants.RISPOSTE_RESPONSE.MODIFICA_SUCCES);
		else
			risposta.setMessage("errore");
		return Response.ok(risposta).build();
	}
}
