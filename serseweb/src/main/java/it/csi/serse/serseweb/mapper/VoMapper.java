package it.csi.serse.serseweb.mapper;

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

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.ComuniDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.SoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ComuneDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtGmopDAreaTerritorialeDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtStatiEsteriDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtBacinoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtComuneDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtProvinciaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDClassificazioneDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDFinalitaServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDFonteDatoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDProvenienzaLuogoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDServizioRegionaleDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDStatoModelloDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDStatoServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDTipoModelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTSoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtGmopDAreaTerritorialeDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtStatiEsteriDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtBacinoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtProvinciaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDClassificazioneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDFinalitaServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDFonteDatoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDProvenienzaLuogoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDTipoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTLuogoIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.vo.Classificazione;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.DestinatarioServizio;
import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;
import it.csi.serse.serseweb.vo.LuogoIncontro;
import it.csi.serse.serseweb.vo.ModelloIntervento;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import it.csi.serse.serseweb.vo.StatoEstero;

@Component
public class VoMapper {

	@Autowired
	private FlaianagpgHelper flaiAnag;

	@Autowired
	private ExtStatiEsteriDAO statiEsteriDAO;

	@Autowired
	private SerseTSoggettoAttuatoreDAO soggettoAttuatoreDAOGenerato;

	@Autowired
	private SerseDFonteDatoDAO fonteDatoDAOGenerato;

	@Autowired
	private SerseDStatoServizioDAO statoServizioDAOGenerato;

	@Autowired
	private ExtGmopDAreaTerritorialeDAO areaTerritorialeDAOGenerato;

	@Autowired
	private SerseDServizioRegionaleDAO servizioRegionaleDAOGenerato;

	@Autowired
	private SerseDClassificazioneDAO clasificazioneDAOGenerato;

	@Autowired
	private SerseDFinalitaServizioDAO finalitaServizioDAOGenerato;

	@Autowired
	private SerseDTipoModelloDAO tipoModelloDAOGenerato;

	@Autowired
	private SerseDStatoModelloDiInterventoDAO serseDStatoModelloDiInterventoDAOGenerato;

	@Autowired
	private ComuniDAO comuniDao;

	@Autowired
	private SerseDProvenienzaLuogoDAO provenienzaLuogoDAOGenerato;

	@Autowired
	private SoggettoAttuatoreDAO soggettoAttuatoreDAO;

	@Autowired
	private FlaiAnagMapper flaiAnagMapper;

	@Autowired
	private VoMapperInternal voMapperInternal;

	@Autowired
	private MybatisGeneretedDTOMapper mybatisMapper;

	public PersonaGiuridica getSoggettoBeneficiarioServizio(Long idSoggettoAttuatore) {
		PersonaGiuridica soggettoBeneficiario = null;

		SoggettoAttuatoreDTO soggettoFiltrato = soggettoAttuatoreDAO.getSoggettoBeneficiario(idSoggettoAttuatore);
		if (soggettoFiltrato != null) {
			Integer codOperatore = soggettoFiltrato.getCodOperatore();
			String gruppoOperatore = soggettoFiltrato.getGruppoOperatore();
			SintesiPersonaGiuridica ris;
			try {
				ris = flaiAnag.getOperatore(gruppoOperatore, codOperatore);
				if (ris != null)
					soggettoBeneficiario = flaiAnagMapper.toVo(ris);
				return soggettoBeneficiario;
			} catch (Exception e) {
				throw new ErroreConnessioneServizioException(501, e.getMessage());
			}
		}
		return null;
	}

	@Cacheable("comune")
	public Comune tornaComune(String codComune) {
		if (codComune == null)
			return null;
		else {
			ComuneDTO comuneDTO = comuniDao.getComune(codComune);
			return voMapperInternal.toVo(comuneDTO);
		}
	}

	@Cacheable("statoEstero")
	public StatoEstero tornaStatoEstero(Long codStatoStero) {
		if (codStatoStero == null)
			return null;
		else {
			ExtStatiEsteriDTO statoEsteroDTO = statiEsteriDAO.selectByPrimaryKey(codStatoStero);
			return mybatisMapper.toVo(statoEsteroDTO);
		}
	}

	@Cacheable("statoEsteroExt")
	public ExtStatiEsteriDTO getStatoEsteroOrNull(Long codStatoStero) {
		if (codStatoStero == null)
			return null;
		else {
			return statiEsteriDAO.selectByPrimaryKey(codStatoStero);
		}
	}

	public ServizioRegionale tornaServizioRegionale(Long idServizioRegionale) {
		if (idServizioRegionale == null)
			return null;
		else {
			SerseDServizioRegionaleDTO servizioRegionaleDTO = servizioRegionaleDAOGenerato
					.selectByPrimaryKey(idServizioRegionale);
			SerseDFinalitaServizioDTO finalitaServizoDTO = finalitaServizioDAOGenerato
					.selectByPrimaryKey(servizioRegionaleDTO.getCodFinalitaServizio());
			return voMapperInternal.toVo(servizioRegionaleDTO, finalitaServizoDTO);
		}
	}

	public ServizioRegionale servizioRegionaleToVo(SerseDServizioRegionaleDTO servizioRegionaleDTO) {
		SerseDFinalitaServizioDTO finalitaServizoDTO = finalitaServizioDAOGenerato
				.selectByPrimaryKey(servizioRegionaleDTO.getCodFinalitaServizio());
		return voMapperInternal.toVo(servizioRegionaleDTO, finalitaServizoDTO);

	}

	public Classificazione tornaClasificazione(Long idClassificazione) {
		if (idClassificazione == null)
			return null;
		else {
			SerseDClassificazioneDTO classificazioneDTO = clasificazioneDAOGenerato
					.selectByPrimaryKey(idClassificazione);
			return mybatisMapper.toVo(classificazioneDTO);
		}
	}

	/**
	 * Recupera da database comune di nascita, stato di nascita, etc...
	 */
	public Destinatario destinatarioToVo(SerseTDestinatarioDTO destinatarioDto) {

		Comune comuneNascita = tornaComune(destinatarioDto.getCodIstatComuneNascita());
		ExtStatiEsteriDTO statoEsteroNascita = getStatoEsteroOrNull(destinatarioDto.getCodStatoEsteroNascita());
		Comune comuneResidenza = tornaComune(destinatarioDto.getCodIstatComuneResidenza());
		ExtStatiEsteriDTO statoEsteroResidenza = getStatoEsteroOrNull(destinatarioDto.getCodStatoEsteroResidenza());
		Comune comuneDomicilio = tornaComune(destinatarioDto.getCodIstatComuneDomicilio());

		return voMapperInternal.destinatarioToVo(destinatarioDto, comuneNascita, statoEsteroNascita, comuneResidenza,
				statoEsteroResidenza, comuneDomicilio);
	}

	/**
	 * Questa variante  NON recupera comuni e stati da database, ma da Map data
	 */
    public Destinatario destinatarioToVo(SerseTDestinatarioDTO destinatarioDto, Map<String,Comune> comuni,
            Map<Long, ExtStatiEsteriDTO> statiEsteri) {

				Comune comuneNascita = comuni.get(destinatarioDto.getCodIstatComuneNascita());
				Comune comuneResidenza = comuni.get(destinatarioDto.getCodIstatComuneResidenza());
				Comune comuneDomicilio = comuni.get(destinatarioDto.getCodIstatComuneDomicilio());

				ExtStatiEsteriDTO statoEsteroNascita = statiEsteri.get(destinatarioDto.getCodStatoEsteroNascita());
				ExtStatiEsteriDTO statoEsteroResidenza = statiEsteri.get(destinatarioDto.getCodStatoEsteroResidenza());
		
				return voMapperInternal.destinatarioToVo(destinatarioDto, comuneNascita, statoEsteroNascita, comuneResidenza,
						statoEsteroResidenza, comuneDomicilio);
    }

	public DestinatarioServizio destinatariServizioToVo(SerseRDestinatarioServizioDTO destinatarioServiziDTO) {
		return mybatisMapper.destinatariServizioToVo(destinatarioServiziDTO);
	}

	public Servizio servizioToVo(SerseTServizioDTO servizioDTO) {
		SerseDStatoServizioDTO statoServizio = statoServizioDAOGenerato
				.selectByPrimaryKey(servizioDTO.getIdStatoServizio());

		SoggettoAttuatore soggettoAttuatore = mybatisMapper
				.toVo(soggettoAttuatoreDAOGenerato.selectByPrimaryKey(servizioDTO.getIdSoggettoAttuatore()));
		Integer codOperatoreSoggettoAttuatore = soggettoAttuatore.getCodOperatore();
		String gruppoOperatoreSoggettoAttuatore = soggettoAttuatore.getGruppoOperatore();

		try {
			SintesiPersonaGiuridica ris = flaiAnag.getOperatore(gruppoOperatoreSoggettoAttuatore, codOperatoreSoggettoAttuatore);
			if (ris != null && StringUtils.isNotBlank(ris.getDenominazionePersonaGiuridica())) {
				soggettoAttuatore.setDenominazioneGiuridica(ris.getDenominazionePersonaGiuridica());
			}
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}

		ExtGmopDAreaTerritorialeDTO areaTerritoriale = null;
		if (servizioDTO.getCodAreaTerritorialeFinanziamento() != null) {
			areaTerritoriale = areaTerritorialeDAOGenerato
					.selectByPrimaryKey(servizioDTO.getCodAreaTerritorialeFinanziamento());
		}

		ServizioRegionale servizioRegionale = tornaServizioRegionale(servizioDTO.getIdServizioRegionale());

		Classificazione classificazione = tornaClasificazione(servizioDTO.getIdClassificazione());

		return voMapperInternal.servizioToVo(servizioDTO, statoServizio, soggettoAttuatore, areaTerritoriale,
				servizioRegionale, classificazione);
	}

	public EnteCoinvoltoModello toVoEnteCoinvoltoModello(SerseTEnteCoinvoltoModelloDTO enteCoinvoltoModello) {
		SerseDFonteDatoDTO fonteDato = fonteDatoDAOGenerato.selectByPrimaryKey(enteCoinvoltoModello.getIdFonteDato());
		Comune comune = tornaComune(enteCoinvoltoModello.getCodIstatComune());
		return voMapperInternal.toVoEnteCoinvoltoModello(enteCoinvoltoModello, fonteDato, comune);
	}

	public EnteCoinvoltoIntervento toVoEnteCoinvoltoIntervento(
			SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento) {
		SerseDFonteDatoDTO fonteDato = fonteDatoDAOGenerato
				.selectByPrimaryKey(enteCoinvoltoIntervento.getIdFonteDato());
		Comune comune = tornaComune(enteCoinvoltoIntervento.getCodIstatComune());
		return voMapperInternal.toVoEnteCoinvoltoIntervento(enteCoinvoltoIntervento, fonteDato, comune);
	}

	public EnteCoinvoltoServizio toVoEnteCoinvoltoServizio(SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizio) {
		SerseDFonteDatoDTO fonteDato = fonteDatoDAOGenerato.selectByPrimaryKey(enteCoinvoltoServizio.getIdFonteDato());
		Comune comune = tornaComune(enteCoinvoltoServizio.getCodIstatComune());
		return voMapperInternal.toVoEnteCoinvoltoServizio(enteCoinvoltoServizio, fonteDato, comune);
	}

	public ModelloIntervento toVoModelloIntervento(SerseTModelloDiInterventoDTO modelloDiInterventoDTO) {

		SerseDTipoModelloDTO tipoModelloDTO = tipoModelloDAOGenerato
				.selectByPrimaryKey(modelloDiInterventoDTO.getCodTipoModello());

		SerseDStatoModelloDiInterventoDTO statoModelloDiInterventoDTO = serseDStatoModelloDiInterventoDAOGenerato
				.selectByPrimaryKey(modelloDiInterventoDTO.getIdStatoModelloDiIntervento());

		SoggettoAttuatore soggettoAttuatore = mybatisMapper
				.toVo(soggettoAttuatoreDAOGenerato.selectByPrimaryKey(modelloDiInterventoDTO.getIdSoggettoAttuatore()));
		Integer codOperatoreSoggettoAttuatore = soggettoAttuatore.getCodOperatore();
		String gruppoOperatoreSoggettoAttuatore = soggettoAttuatore.getGruppoOperatore();
		SintesiPersonaGiuridica ris;
		try {
			ris = flaiAnag.getOperatore(gruppoOperatoreSoggettoAttuatore, codOperatoreSoggettoAttuatore);
			if (ris != null) {
				soggettoAttuatore.setDenominazioneGiuridica(ris.getDenominazionePersonaGiuridica());

			}
		} catch (Exception e) {
			throw new ErroreConnessioneServizioException(501, e.getMessage());
		}

		return voMapperInternal.toVoModelloIntervento(modelloDiInterventoDTO, tipoModelloDTO,
				statoModelloDiInterventoDTO, soggettoAttuatore);
	}

	public LuogoIncontro toVoLuogoIncontro(SerseTLuogoIncontroDTO luogoIncontroDTO) {
		Comune comune = tornaComune(luogoIncontroDTO.getCodIstatComuneIncontro());
		SerseDFonteDatoDTO fonteDatoDTO = null;
		SerseDProvenienzaLuogoDTO provenienzaLuogoDTO = provenienzaLuogoDAOGenerato
				.selectByPrimaryKey(luogoIncontroDTO.getIdProvenienzaLuogo());
		if (provenienzaLuogoDTO != null && provenienzaLuogoDTO.getIdFonteDato() != null) {
			fonteDatoDTO = fonteDatoDAOGenerato.selectByPrimaryKey(provenienzaLuogoDTO.getIdFonteDato());
		}

		return voMapperInternal.toVoLuogoIncontro(luogoIncontroDTO, comune, provenienzaLuogoDTO, fonteDatoDTO);
	}

}
