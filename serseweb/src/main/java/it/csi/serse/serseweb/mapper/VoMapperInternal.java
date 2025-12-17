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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import it.csi.serse.serseweb.integration.mybatis.dto.custom.ComuneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtGmopDAreaTerritorialeDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtStatiEsteriDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtBacinoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtProvinciaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDFinalitaServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDFonteDatoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDProvenienzaLuogoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDTipoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTLuogoIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.vo.Classificazione;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;
import it.csi.serse.serseweb.vo.LuogoIncontro;
import it.csi.serse.serseweb.vo.ModelloIntervento;
import it.csi.serse.serseweb.vo.ProvenienzaLuogo;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses={MybatisGeneretedDTOMapper.class})
public interface VoMapperInternal {

    @Mapping(target = "codiceIstatComune", source = "c.comune")
    @Mapping(target = "descrizioneComune", source = "c.descom")
    @Mapping(target = "cap", source = "c.cap")
    @Mapping(target = "codiceFiscaleComune", source = "c.codfisc")
    @Mapping(target = "provincia.codiceProvincia", source = "c.prov")
    @Mapping(target = "provincia.descrizioneProvincia", source = "p.desprov")
    @Mapping(target = "provincia.siglaProvincia", source = "p.sigprov")
    @Mapping(target = "provincia.codiceRegione", source = "p.regione")
    @Mapping(target = "bacino.codBacino", source = "c.codBacino")
    @Mapping(target = "bacino.descrizione", source = "b.descrizione")
    @Mapping(target = "bacino.codProv", source = "b.prov")
	// Era anche previsto un fallback nel caso c.codbacino != null ma b = null ....
	public Comune toVo(ExtTtComuneDTO c, ExtTtProvinciaDTO p, ExtTtBacinoDTO b);
    
    public Comune toVo(ComuneDTO comune);

    @Mapping(target = "codFinalitaServizio", source = "source.codFinalitaServizio")
	public ServizioRegionale toVo(SerseDServizioRegionaleDTO source, SerseDFinalitaServizioDTO finalitaServizoDTO);

    @Mapping(target = "codiceFiscaleDestinatario", source = "source.cfDestinatario")
    @Mapping(target = "indDomicilio", source = "source.indirizzoDomicilio")
    @Mapping(target = "recapitoMail", source = "source.recapitoEmail")
	@Mapping(target = "gruppoOperatoreAggiornamento", source = "source.gruppoOperatoreModifica")
	@Mapping(target = "codOperatoreAggiornamento", source = "source.codOperatoreModifica")
    @Mapping(target = "DInserim", source = "source.dInserim")
	@Mapping(target = "DAggiorn", source = "source.dAggiorn")
    @Mapping(target = "DNascita", source = "source.dNascita")
	public Destinatario destinatarioToVo(SerseTDestinatarioDTO source, Comune comuneNascita, ExtStatiEsteriDTO statoEsteroNascita, Comune comuneResidenza, ExtStatiEsteriDTO statoEsteroResidenza, Comune comuneDomicilio);
	// FIXME questo è da riverificare tutto

    @Mapping(target = "statoServizio", source = "statoServizio")
    @Mapping(target = "dataChiusura", source = "source.dChiusuraServizio")
    @Mapping(target = "codTitoloStudioIgrue", source = "source.codLivelloIstruzione")
    @Mapping(target = "codCondizioneOccupazionaleIgrue", source = "source.codCondizioneOccupazionale")
    @Mapping(target = "DInserim", source = "source.dInserim")
    @Mapping(target = "DAggiorn", source = "source.dAggiorn")
    @Mapping(target = "codUserInserim", source = "source.codUserInserim")
    @Mapping(target = "codUserAggiorn", source = "source.codUserAggiorn")
    @Mapping(target = "idPso", source = "source.idPso")
    @Mapping(target = "areaTerritoriale", source = "areaTerritoriale")
    @Mapping(target = "servizioRegionale", source = "servizioRegionale")
    @Mapping(target = "classificazione", source = "classificazione")
	public Servizio servizioToVo(SerseTServizioDTO source, SerseDStatoServizioDTO statoServizio, SoggettoAttuatore soggettoAttuatore, ExtGmopDAreaTerritorialeDTO areaTerritoriale,
		ServizioRegionale servizioRegionale, Classificazione classificazione);

	@Mapping(target="idFonteDato", source="enteCoinvoltoModello.idFonteDato")
	@Mapping(target="descrizioneFonteDato", source="fonteDato.descrFonteDato")
    @Mapping(target = "DAggiornam", source = "enteCoinvoltoModello.dAggiorn")
    @Mapping(target = "DInserim", source = "enteCoinvoltoModello.dInserim")
    @Mapping(target = "DCessazione", source = "enteCoinvoltoModello.dCessazione")
	@Mapping(target="referente", source="enteCoinvoltoModello")
	@Mapping(target="comune", source="comune")
	public EnteCoinvoltoModello toVoEnteCoinvoltoModello(SerseTEnteCoinvoltoModelloDTO enteCoinvoltoModello, SerseDFonteDatoDTO fonteDato, Comune comune);

	@Mapping(target="idFonteDato", source="enteCoinvoltoIntervento.idFonteDato")
	@Mapping(target="descrizioneFonteDato", source="fonteDato.descrFonteDato")
    @Mapping(target = "DAggiornam", source = "enteCoinvoltoIntervento.dAggiorn")
    @Mapping(target = "DInserim", source = "enteCoinvoltoIntervento.dInserim")
	@Mapping(target="referente", source="enteCoinvoltoIntervento")
	@Mapping(target="comune", source="comune")
	public EnteCoinvoltoIntervento toVoEnteCoinvoltoIntervento(SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento, SerseDFonteDatoDTO fonteDato, Comune comune);

	@Mapping(target="idFonteDato", source="enteCoinvoltoServizio.idFonteDato")
	@Mapping(target="descrizioneFonteDato", source="fonteDato.descrFonteDato")
    @Mapping(target = "DAggiornam", source = "enteCoinvoltoServizio.dAggiorn")
    @Mapping(target = "DInserim", source = "enteCoinvoltoServizio.dInserim")
	@Mapping(target="referente", source="enteCoinvoltoServizio")
	@Mapping(target="comune", source="comune")
	public EnteCoinvoltoServizio toVoEnteCoinvoltoServizio(SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizio, SerseDFonteDatoDTO fonteDato, Comune comune);

	@Mapping(target="idModelloIntervento", source="source.idModelloDiIntervento")
	@Mapping(target="titolo", source="source.titoloModelloDiIntervento")
	@Mapping(target="descrizione", source="source.descrSinteticaModelloDiIntervento")
    @Mapping(target = "codUserInserimento", source = "source.codUserInserim")
    @Mapping(target = "codUserAggiornamento", source = "source.codUserAggiorn")
    @Mapping(target = "dataInserimento", source = "source.dInserim")
	@Mapping(target = "dataAggiornamento", source = "source.dAggiorn")
    @Mapping(target="referente", source="source")
    @Mapping(target="tipoModello", source="tipoModello")
	@Mapping(target="statoModelloIntervento", source="statoModelloDiIntervento")
	@Mapping(target="soggettoAttuatore", source="soggettoAttuatore")
	public ModelloIntervento toVoModelloIntervento(SerseTModelloDiInterventoDTO source, SerseDTipoModelloDTO tipoModello, SerseDStatoModelloDiInterventoDTO statoModelloDiIntervento, SoggettoAttuatore soggettoAttuatore);

    @Mapping(target = "idFonteDato", source = "source.idFonteDato")
    @Mapping(target = "descrFonteDato", source = "fonteDatoDTO.descrFonteDato")
	public ProvenienzaLuogo toVo(SerseDProvenienzaLuogoDTO source, SerseDFonteDatoDTO fonteDatoDTO);

    @Mapping(target = "comuneIncontro", source = "comune")
    @Mapping(target = "DAggiorn", source = "source.dAggiorn")
    @Mapping(target = "DInserim", source = "source.dInserim")
    @Mapping(target = "provenienzaLuogo", source = "provenienzaLuogo")
    @Mapping(target = "provenienzaLuogo.descrFonteDato", source = "fonteDatoDTO.descrFonteDato")
	public LuogoIncontro toVoLuogoIncontro(SerseTLuogoIncontroDTO source, Comune comune, SerseDProvenienzaLuogoDTO provenienzaLuogo, SerseDFonteDatoDTO fonteDatoDTO);

}
