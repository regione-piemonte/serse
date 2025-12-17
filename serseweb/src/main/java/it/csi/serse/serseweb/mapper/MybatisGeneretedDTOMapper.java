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

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtBdgtTPsoSportelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtGmopDAreaTerritorialeDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDGradoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDPercorsoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDTipologiaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtStatiEsteriDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTabCittadinanzaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtBacinoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtProvinciaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDClassificazioneDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRuoloEnteDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDSportMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDStatoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDTipoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioMonitoraggioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRModelloInterventoPsoCaratteristicaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioFonteDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioPsoCaratteristicaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTLuogoIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTModelloDiInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamDTO;
import it.csi.serse.serseweb.vo.AreaTerritoriale;
import it.csi.serse.serseweb.vo.Bacino;
import it.csi.serse.serseweb.vo.CaratteristicheAssociate;
import it.csi.serse.serseweb.vo.CaratteristicheServizio;
import it.csi.serse.serseweb.vo.Cittadinanza;
import it.csi.serse.serseweb.vo.Classificazione;
import it.csi.serse.serseweb.vo.ComuneRistretto;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.DestinatarioServizio;
import it.csi.serse.serseweb.vo.DestinatarioServizioMonitoraggio;
import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;
import it.csi.serse.serseweb.vo.GradoScolastico;
import it.csi.serse.serseweb.vo.Incontro;
import it.csi.serse.serseweb.vo.IncontroDestinatarioServizio;
import it.csi.serse.serseweb.vo.Intervento;
import it.csi.serse.serseweb.vo.LuogoIncontro;
import it.csi.serse.serseweb.vo.ModelloIntervento;
import it.csi.serse.serseweb.vo.PercorsoScolastico;
import it.csi.serse.serseweb.vo.ProvinciaRistretto;
import it.csi.serse.serseweb.vo.Referente;
import it.csi.serse.serseweb.vo.RegComportPsoSport;
import it.csi.serse.serseweb.vo.RuoloEnte;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.ServizioFonte;
import it.csi.serse.serseweb.vo.ServizioModello;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import it.csi.serse.serseweb.vo.SportMonitoraggio;
import it.csi.serse.serseweb.vo.Sportello;
import it.csi.serse.serseweb.vo.StatoEstero;
import it.csi.serse.serseweb.vo.StatoIntervento;
import it.csi.serse.serseweb.vo.StatoModelloIntervento;
import it.csi.serse.serseweb.vo.StatoServizio;
import it.csi.serse.serseweb.vo.TipoModello;
import it.csi.serse.serseweb.vo.TipologiaIstitutoScolastico;
import it.csi.serse.serseweb.vo.TokenGam;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MybatisGeneretedDTOMapper {

    /*
     * 
     * Mapper Per Modello Di Intervento
     * 
     */
    @Mapping(target = "codTipoModello", source = "tipoModello.codTipoModello")
    @Mapping(target = "codUserAggiorn", source = "codUserAggiornamento")
    @Mapping(target = "codUserInserim", source = "codUserInserimento")
    @Mapping(target = "dAggiorn", source = "dataAggiornamento")
    @Mapping(target = "dInserim", source = "dataInserimento")
    @Mapping(target = "descrSinteticaModelloDiIntervento", source = "descrizione")
    @Mapping(target = "idSoggettoAttuatore", source = "soggettoAttuatore.idSoggettoAttuatore")
    @Mapping(target = "titoloModelloDiIntervento", source = "titolo")
    @Mapping(target = "referenteNome", source = "referente.referenteNome")
    @Mapping(target = "referenteCognome", source = "referente.referenteCognome")
    @Mapping(target = "referenteEmail", source = "referente.referenteEmail")
    @Mapping(target = "referenteTelefono", source = "referente.referenteTelefono")
    @Mapping(target = "idModelloDiIntervento", source = "idModelloIntervento")
    @Mapping(target = "idStatoModelloDiIntervento", source = "statoModelloIntervento.idStatoModelloDiIntervento")
    SerseTModelloDiInterventoDTO toModelloDIinteventoDTO(ModelloIntervento modelloVo);

    /*
     * 
     * Mapper per Servizio Modello
     * 
     */
    @Mapping(target = "referenteNome", source = "referente.referenteNome")
    @Mapping(target = "referenteCognome", source = "referente.referenteCognome")
    @Mapping(target = "referenteEmail", source = "referente.referenteEmail")
    @Mapping(target = "referenteTelefono", source = "referente.referenteTelefono")
    @Mapping(target = "idServizioRegionale", source = "servizioRegionale.idServizioRegionale")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiorn")
    SerseTServizioModelloDTO toServizioModelloDTO(ServizioModello modelloVo);

    /*
     * Mapper per Incontro
     */
    @Mapping(target = "referenteNome", source = "nomeReferente")
    @Mapping(target = "referenteCognome", source = "cognomeReferente")
    @Mapping(target = "idLuogoIncontro", source = "luogoIncontro.idLuogoIncontro")
    @Mapping(target = "idStatoIncontro", source = "statoIncontro.idStatoIncontro")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiorn")
    @Mapping(target = "dChiusura", source = "DChiusura")
    @Mapping(target = "dInizio", source = "DInizio")
    @Mapping(target = "dFine", source = "DFine")
    SerseTIncontroDTO toSerseTIncontroDTO(Incontro incontro);

    /*
     * 
     * Mapper Per Destinatario
     * 
     */
    @Mapping(target = "cfDestinatario", source = "codiceFiscaleDestinatario")
    @Mapping(target = "recapitoEmail", source = "recapitoMail")
    @Mapping(target = "codIstatComuneNascita", source = "comuneNascita.codiceIstatComune")
    @Mapping(target = "codStatoEsteroNascita", source = "statoEsteroNascita.codStato")
    @Mapping(target = "codIstatComuneResidenza", source = "comuneResidenza.codiceIstatComune")
    @Mapping(target = "codStatoEsteroResidenza", source = "statoEsteroResidenza.codStato")
    @Mapping(target = "codOperatoreModifica", source = "codOperatoreAggiornamento")
    @Mapping(target = "gruppoOperatoreModifica", source = "gruppoOperatoreAggiornamento")
    @Mapping(target = "codIstatComuneDomicilio", source = "comuneDomicilio.codiceIstatComune")
    @Mapping(target = "indirizzoDomicilio", source = "indDomicilio")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiorn")
    @Mapping(target = "dNascita", source = "DNascita")
    SerseTDestinatarioDTO toSerseTDestinatarioDTO(Destinatario destinatario);

    @BeforeMapping
    default void beforeMapping(Destinatario source, @MappingTarget SerseTDestinatarioDTO dest) {
        if ("".equals(source.getCapDomicilio())) {
            source.setCapDomicilio(null);
        }
        if ("".equals(source.getCapResidenza())) {
            source.setCapResidenza(null);
        }
    }

    /*
     * 
     * Mapper Per Intervento
     * 
     */
    @Mapping(target = "referenteNome", source = "referente.referenteNome")
    @Mapping(target = "referenteCognome", source = "referente.referenteCognome")
    @Mapping(target = "referenteEmail", source = "referente.referenteEmail")
    @Mapping(target = "referenteTelefono", source = "referente.referenteTelefono")
    @Mapping(target = "codTipoIntervento", source = "tipoIntervento.codTipoIntervento")
    @Mapping(target = "idSoggettoAttuatore", source = "soggettoAttuatore.idSoggettoAttuatore")
    @Mapping(target = "idStatoIntervento", source = "statoIntervento.idStatoIntervento")
    @Mapping(target = "titoloIntervento", source = "titolo")
    @Mapping(target = "descrSinteticaIntervento", source = "descrizione")
    @Mapping(target = "idModelloDiIntervento", source = "idModelloIntervento")
    @Mapping(target = "codUserAggiorn", source = "codUserAggiornamento")
    @Mapping(target = "codUserInserim", source = "codUserInserimento")
    @Mapping(target = "dInserim", source = "dataInserimento")
    @Mapping(target = "dAggiorn", source = "dataAggiornamento")
    SerseTInterventoDTO toSerseTIntervento(Intervento intervento);

    /*
     * 
     * Mapper per Servizio
     * 
     */
    @Mapping(target = "codLivelloIstruzione", source = "codTitoloStudioIgrue")
    @Mapping(target = "codCondizioneOccupazionale", source = "codCondizioneOccupazionaleIgrue")
    @Mapping(target = "idStatoServizio", source = "statoServizio.idStatoServizio")
    @Mapping(target = "idSoggettoAttuatore", source = "soggettoAttuatore.idSoggettoAttuatore")
    @Mapping(target = "codAreaTerritorialeFinanziamento", source = "areaTerritoriale.codAreaTerritoriale")
    @Mapping(target = "idServizioRegionale", source = "servizioRegionale.idServizioRegionale")
    @Mapping(target = "idClassificazione", source = "classificazione.idClassificazione")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiorn")
    @Mapping(target = "dChiusuraServizio", source = "dataChiusura")
    SerseTServizioDTO toServizioDTO(Servizio servizioVo);

    /*
     * Mapper per Luogo incontro
     */
    @Mapping(target = "idProvenienzaLuogo", source = "provenienzaLuogo.idProvenienzaLuogo")
    @Mapping(target = "codIstatComuneIncontro", source = "comuneIncontro.codiceIstatComune")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiorn")
    SerseTLuogoIncontroDTO toLuogoIncontroDTO(LuogoIncontro luogoIncontro);

    @Mapping(target = "DInserim", source = "dInserim")
    @Mapping(target = "DAggiorn", source = "dAggiorn")
    ServizioFonte map(SerseRServizioFonteDTO source);

    List<ServizioFonte> mapListServizioFonte(List<SerseRServizioFonteDTO> source);

    @Mapping(target = "labelCampoAggiuntivoUno", source = "labelCampoAggiuntivo1")
    RegComportPsoSport map(SerseDRegComportPsoSportDTO source);

    StatoServizio map(SerseDStatoServizioDTO source);

    List<StatoServizio> mapListStatoServizio(List<SerseDStatoServizioDTO> source);

    @Mapping(target = "codTitoloStudioDefault", source = "codLivelloIstruzioneDefault")
    @Mapping(target = "flgTitoloStudio", source = "flgLivelloIstruzione")
    SportMonitoraggio map(SerseDSportMonitoraggioDTO source);

    @Mapping(target = "codUserAggiorn", source = "codUserAggiornamento")
    @Mapping(target = "codUserInserim", source = "codUserInserimento")
    @Mapping(target = "dAggiorn", source = "dataAggiornamento")
    @Mapping(target = "dInserim", source = "dataInserimento")
    @Mapping(target = "idEnteConvoltoServizio", source = "idEnteCoinvoltoServizio")
    SerseRIncontroDestinatarioServizioDTO map(IncontroDestinatarioServizio source);
    
    @Mapping(target = "DInserim", source = "dInserim")
    @Mapping(target = "DAggiornam", source = "dAggiorn")
    @Mapping(target = "idEnteCoinvoltoServizio", source = "idEnteConvoltoServizio")
    DestinatarioServizio map(SerseRDestinatarioServizioDTO source);

    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiornam")
    @Mapping(target = "idEnteConvoltoServizio", source = "idEnteCoinvoltoServizio")
    @Mapping(target = "idDestinatario", source = "destinatario.idDestinatario")
    SerseRDestinatarioServizioDTO map(DestinatarioServizio source);

    @Mapping(target = "codTitoloStudioIgrue", source = "codLivelloIstruzione")
    @Mapping(target = "codCondizioneOccupazionaleIgrue", source = "codCondizioneOccupazionale")
    @Mapping(target = "codiceCitadinanza", source = "codCittadinanza")
    @Mapping(target = "DInserim", source = "dInserim")
    @Mapping(target = "DAggiornam", source = "dAggiorn")
    DestinatarioServizioMonitoraggio map(SerseRDestinatarioServizioMonitoraggioDTO source);

    @Mapping(target = "codLivelloIstruzione", source = "codTitoloStudioIgrue")
    @Mapping(target = "codCondizioneOccupazionale", source = "codCondizioneOccupazionaleIgrue")
    @Mapping(target = "codCittadinanza", source = "codiceCitadinanza")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiornam")
    SerseRDestinatarioServizioMonitoraggioDTO map(DestinatarioServizioMonitoraggio source);

    @Mapping(target = "DInserim", source = "dUserInserim")
    @Mapping(target = "DAggiorn", source = "dAggiorn")
    @Mapping(target = "DInvioRichiesta", source = "dInvioRichiesta")
    @Mapping(target = "DElaborazione", source = "dElaborazione")
    @Mapping(target = "DVisualizzazioneNotifica", source = "dVisualizzazioneNotifica")
    TokenGam map(SerseTTokenGamDTO serseTTokenGamDTO);

    List<TokenGam> mapListTokenGam(List<SerseTTokenGamDTO> serseTTokenGamDTO);

    RuoloEnte map(SerseDRuoloEnteDTO source);

    List<RuoloEnte> mapListRuoloEnte(List<SerseDRuoloEnteDTO> source);

    @Mapping(target = "codIstatComune", source = "comune.codiceIstatComune")
    @Mapping(target = "referenteNome", source = "referente.referenteNome")
    @Mapping(target = "referenteCognome", source = "referente.referenteCognome")
    @Mapping(target = "referenteEmail", source = "referente.referenteEmail")
    @Mapping(target = "referenteTelefono", source = "referente.referenteTelefono")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiornam")
    @Mapping(target = "dCessazione", source = "DCessazione")
    SerseTEnteCoinvoltoModelloDTO map(EnteCoinvoltoModello source);

    @Mapping(target = "codIstatComune", source = "comune.codiceIstatComune")
    @Mapping(target = "referenteNome", source = "referente.referenteNome")
    @Mapping(target = "referenteCognome", source = "referente.referenteCognome")
    @Mapping(target = "referenteEmail", source = "referente.referenteEmail")
    @Mapping(target = "referenteTelefono", source = "referente.referenteTelefono")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiornam")
    SerseTEnteCoinvoltoInterventoDTO map(EnteCoinvoltoIntervento source);

    @Mapping(target = "codIstatComune", source = "comune.codiceIstatComune")
    @Mapping(target = "referenteNome", source = "referente.referenteNome")
    @Mapping(target = "referenteCognome", source = "referente.referenteCognome")
    @Mapping(target = "referenteEmail", source = "referente.referenteEmail")
    @Mapping(target = "referenteTelefono", source = "referente.referenteTelefono")
    @Mapping(target = "dInserim", source = "DInserim")
    @Mapping(target = "dAggiorn", source = "DAggiornam")
    SerseTEnteCoinvoltoServizioDTO map(EnteCoinvoltoServizio source);

    @InheritInverseConfiguration
    EnteCoinvoltoServizio map(SerseTEnteCoinvoltoServizioDTO source);

    @InheritInverseConfiguration
    EnteCoinvoltoIntervento map(SerseTEnteCoinvoltoInterventoDTO source);

    Bacino map(ExtTtBacinoDTO source);

    List<Bacino> mapListBacino(List<ExtTtBacinoDTO> source);

    SerseTInterventoDTO clonazione(SerseTInterventoDTO source);

    StatoIntervento map(SerseDStatoInterventoDTO source);

    List<StatoIntervento> mapListaStatoIntervento(List<SerseDStatoInterventoDTO> source);

    @Mapping(target = "codUserAggiornamento", source = "codUserAggiorn")
    @Mapping(target = "codUserInserimento", source = "codUserInserim")
    @Mapping(target = "dataAggiornamento", source = "dAggiorn")
    @Mapping(target = "dataInserimento", source = "dInserim")
    SoggettoAttuatore map(SerseTSoggettoAttuatoreDTO source);

    GradoScolastico map(ExtSisproDGradoScolasticoDTO source);

    List<GradoScolastico> mapListGtadoScolastico(List<ExtSisproDGradoScolasticoDTO> source);

    PercorsoScolastico map(ExtSisproDPercorsoDTO source);

    List<PercorsoScolastico> mapListPercorsi(List<ExtSisproDPercorsoDTO> source);

    TipologiaIstitutoScolastico map(ExtSisproDTipologiaDTO source);

    List<TipologiaIstitutoScolastico> mapListTipologieIstituti(List<ExtSisproDTipologiaDTO> source);

    StatoModelloIntervento map(SerseDStatoModelloDiInterventoDTO source);

    List<StatoModelloIntervento> mapListStatoModelloIntervento(List<SerseDStatoModelloDiInterventoDTO> source);

    @Mapping(target = "dataFine", source = "dFine")
    @Mapping(target = "dataInizio", source = "dInizio")
    @Mapping(target = "descrizioneSportello", source = "descrSportello")
    Sportello map(ExtBdgtTPsoSportelloDTO source);

    List<Sportello> mapListaSportelli(List<ExtBdgtTPsoSportelloDTO> source);

    AreaTerritoriale map(ExtGmopDAreaTerritorialeDTO selectByPrimaryKey);

    List<AreaTerritoriale> mapListAreaTerritoriale(List<ExtGmopDAreaTerritorialeDTO> areaTerritorialeFor);
    
    @Mapping(target = "idCaratteristica", source = "caratteristica.idCaratteristica")
    SerseRModelloInterventoPsoCaratteristicaDTO map(CaratteristicheAssociate source);
    
    @Mapping(target = "idCaratteristica", source = "caratteristica.idCaratteristica")
    SerseRServizioPsoCaratteristicaDTO map(CaratteristicheServizio source);

    @Mapping(target = "codiceCittadinanza", source = "codIstatCittadinanza")
    @Mapping(target = "descrizione", source = "descrCittadinanza")
    @Mapping(target = "codiceNazionalita", source = "codNazionalita")
    @Mapping(target = "codiceCittadinanzaOld", source = "codice")
    Cittadinanza map(ExtTabCittadinanzaDTO source);

    List<Cittadinanza> mapListCittadinanza(List<ExtTabCittadinanzaDTO> source);

    @Mapping(target = "decrizioneStato", source = "descrizioneStato")
	StatoEstero toVo(ExtStatiEsteriDTO source);
    
	List<StatoEstero> mapListaStatiEsteri(List<ExtStatiEsteriDTO> source);

    @Mapping(target = "idClassificazzioneGam", source = "idClassificazioneGam")
    @Mapping(target = "descrFinalita", source = "descrClassificazione")
	Classificazione toVo(SerseDClassificazioneDTO source);

	public Referente toVo(SerseTEnteCoinvoltoModelloDTO enteCoinvoltoModello);
	public Referente toVo(SerseTEnteCoinvoltoInterventoDTO enteCoinvoltoIntervento);
	public Referente toVo(SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizio);

	@Mapping(target="descrizione", source="descrTipoModello")
	public TipoModello toVo(SerseDTipoModelloDTO tipoModelloDTO);

	public SoggettoAttuatore toVo(SerseTSoggettoAttuatoreDTO source);

    @Mapping(target = "DAggiornam", source = "dAggiorn")
    @Mapping(target = "DInserim", source = "dInserim")
    @Mapping(target = "destinatario.idDestinatario", source = "idDestinatario")
	public DestinatarioServizio destinatariServizioToVo(SerseRDestinatarioServizioDTO destinatarioServiziDTO);

    @Mapping(target = "codiceIstatComune", source = "comune")
    @Mapping(target = "descrizione", source = "descom")
    @Mapping(target = "codiceFiscaleComune", source = "codfisc")
    public ComuneRistretto map(ExtTtComuneDTO source);

    public List<ComuneRistretto> mapListaComuni(List<ExtTtComuneDTO> source);

    @Mapping(target = "codiceProvincia", source = "prov")
    @Mapping(target = "descrizione", source = "desprov")
    public ProvinciaRistretto map(ExtTtProvinciaDTO source);

    public List<ProvinciaRistretto> mapListaProvince(List<ExtTtProvinciaDTO> source);
}
