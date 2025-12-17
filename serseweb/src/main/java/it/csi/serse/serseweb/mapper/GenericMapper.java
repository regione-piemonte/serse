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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneModelliDiInterventoDAO.FilterModelliSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneServiziDAO.FilterServiziSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.InterventiDAO.FilterInterventiSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.AreaTerritorialeDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.CentroPerImpiegoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ClassificazioneDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DettaglioClasseDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.EnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IncontroDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.InterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IstitutoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.LuogoIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ModelloInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioVoceSpesaDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SportelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipoGestioneSportelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipologiaPsoDTO;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.SelItemDto;
import it.csi.serse.serseweb.model.ExcelInterventoModel;
import it.csi.serse.serseweb.model.ExcelModelloModel;
import it.csi.serse.serseweb.model.ExcelServizioModel;
import it.csi.serse.serseweb.model.Utente;
import it.csi.serse.serseweb.vo.AreaTerritoriale;
import it.csi.serse.serseweb.vo.CentroPerImpiego;
import it.csi.serse.serseweb.vo.Classificazione;
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.DettaglioClasseDestinatarioServizio;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.ExcelIntervento;
import it.csi.serse.serseweb.vo.ExcelModello;
import it.csi.serse.serseweb.vo.ExcelServizio;
import it.csi.serse.serseweb.vo.FilterInterventi;
import it.csi.serse.serseweb.vo.FilterModelli;
import it.csi.serse.serseweb.vo.FilterServizi;
import it.csi.serse.serseweb.vo.Incontro;
import it.csi.serse.serseweb.vo.IncontroDestinatarioServizio;
import it.csi.serse.serseweb.vo.Intervento;
import it.csi.serse.serseweb.vo.IstitutoScolastico;
import it.csi.serse.serseweb.vo.LuogoIncontro;
import it.csi.serse.serseweb.vo.ModelloIntervento;
import it.csi.serse.serseweb.vo.SelItem;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.ServizioModello;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import it.csi.serse.serseweb.vo.ServizioVoceSpesa;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import it.csi.serse.serseweb.vo.Sportello;
import it.csi.serse.serseweb.vo.TipoGestioneSportello;
import it.csi.serse.serseweb.vo.TipoIntervento;
import it.csi.serse.serseweb.vo.TipoModello;
import it.csi.serse.serseweb.vo.TipologiaPso;
import it.csi.serse.serseweb.vo.UserInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenericMapper {

    UserInfo map(Utente source);

    @Mapping(target = "descrAreaTerritoriale", source = "desrAreaTerritoriale")
    AreaTerritoriale map(AreaTerritorialeDTO source);

    List<AreaTerritoriale> mapListAreaTerritoriale(List<AreaTerritorialeDTO> source);

    ServizioModello map(ServizioModelloDTO source);

    ServizioModelloDTO map(ServizioModello source);

    List<ServizioModello> mapListServizioModello(List<ServizioModelloDTO> source);

    ServizioRegionale map(ServizioRegionaleDTO source);

    ServizioRegionaleDTO map(ServizioRegionale source);

    List<ServizioRegionale> mapListServiziRegionali(List<ServizioRegionaleDTO> source);

    Servizio map(ServizioDTO source);

    Destinatario map(DestinatarioDTO source);

    Classificazione map(ClassificazioneDTO source);

    List<Classificazione> mapListClassificazione(List<ClassificazioneDTO> source);

    @Mapping(target = "seccondaryValue", source = "secondaryValue")
    SelItem map(SelItemDto source);

    IncontroDestinatarioServizio map(IncontroDestinatarioServizioDTO source);

    CentroPerImpiego map(CentroPerImpiegoDTO source);

    List<CentroPerImpiego> mapListCentriImpiego(List<CentroPerImpiegoDTO> source);

    @Mapping(target = "DInserim", source = "dInserim")
    @Mapping(target = "DAggiorn", source = "dAggiorn")
    LuogoIncontro map(LuogoIncontroDTO source);

    @Mapping(target = "DInserim", source = "dInserim")
    @Mapping(target = "DAggiorn", source = "dAggiorn")
    @Mapping(target = "DChiusura", source = "dChiusura")
    @Mapping(target = "DFine", source = "dFine")
    @Mapping(target = "DInizio", source = "dInizio")
    Incontro map(IncontroDTO source);

    List<Incontro> mapListIncontri(List<IncontroDTO> source);

    SoggettoAttuatore map(SoggettoAttuatoreDTO source);

    List<SoggettoAttuatore> mapListSoggettiAttuatori(List<SoggettoAttuatoreDTO> source);

    @Mapping(target = "DCessazione", source = "dateCessazione")
    @Mapping(target = "DAggiornam", source = "DAggiorn")
    EnteCoinvoltoModello map(EnteCoinvoltoModelloDTO source);

    TipoIntervento map(TipoInterventoDTO source);

    List<TipoIntervento> mapListTipiIntervento(List<TipoInterventoDTO> source);

    Intervento map(InterventoDTO source);

    List<Intervento> mapListaInterventi(List<InterventoDTO> source);

    IstitutoScolastico mapListIstituti(IstitutoScolasticoDTO source);

    ModelloIntervento map(ModelloInterventoDTO source);

    List<ModelloIntervento> mapListaModelliIntervento(List<ModelloInterventoDTO> source);

    Sportello map(SportelloDTO source);

    List<Sportello> mapListSportelli(List<SportelloDTO> source);

    @Mapping(target = "numProgrSportello", source = "numSportello")
    TipoGestioneSportello map(TipoGestioneSportelloDTO source);

    TipoModello map(TipoModelloDTO source);

    List<TipoModello> mapListTipoModello(List<TipoModelloDTO> source);

    TipologiaPso map(TipologiaPsoDTO source);

    List<TipologiaPso> mapListTipologiePso(List<TipologiaPsoDTO> source);

    @Mapping(target = "DInserim", source = "dInserim")
    @Mapping(target = "DAggiorn", source = "dAggiorn")
    ServizioVoceSpesa map(ServizioVoceSpesaDTO source);

    List<ServizioVoceSpesa> mapListVoceSpesa(List<ServizioVoceSpesaDTO> source);

    @Mapping(target = "tipologiaPso", source = "tipolPso")
    @Mapping(target = "sportelloRiferimento", source = "sportello")
    @Mapping(target = "soggettoAttuatoreProprietario", source = "soggettoAttuatore")
    @Mapping(target = "istanzaCandidatura", source = "modelId")
    @Mapping(target = "titoloModello", source = "titolo")
    @Mapping(target = "tipologiaModello", source = "tipoModello")
    @Mapping(target = "cognomeNomeReferente", source = "referente")
    @Mapping(target = "coduserAggiornamento", source = "codUserAggiornamento")
    ExcelModelloModel map(ExcelModello source);

    List<ExcelModelloModel> mapListExcelModello(List<ExcelModello> source);

    @Mapping(target = "tipologiaPso", source = "tipolPso")
    @Mapping(target = "sportelloRiferimento", source = "sportello")
    @Mapping(target = "soggettoAttuatoreProprietario", source = "soggettoAttuatore")
    @Mapping(target = "istanzaCandidatura", source = "modelId")
    @Mapping(target = "titoloIntervento", source = "titolo")
    @Mapping(target = "tipologiaIntervento", source = "tipoIntervento")
    @Mapping(target = "cognomeNomeReferente", source = "referente")
    @Mapping(target = "codiceFiscaleDestinatario", source = "CFDestinatario")
    @Mapping(target = "cognomeNomeDestinatario", source = "cognNomeDesctinatario")
    @Mapping(target = "coduserAggiornamento", source = "codUserAggiornamento")
    ExcelInterventoModel map(ExcelIntervento source);

    List<ExcelInterventoModel> mapListExcelIntevento(List<ExcelIntervento> source);

    @Mapping(target = "tipologiaPso", source = "tipolPso")
    @Mapping(target = "sportelloRiferimento", source = "sportello")
    @Mapping(target = "soggettoAttuatoreProprietario", source = "soggettoAttuatore")
    @Mapping(target = "istanzaCandidatura", source = "modelId")
    @Mapping(target = "titoloServizio", source = "titolo")
    @Mapping(target = "codiceFiscaleDestinatario", source = "CFDestinatario")
    @Mapping(target = "cognomeNomeDestinatario", source = "cognNomeDesctinatario")
    @Mapping(target = "coduserAggiornamento", source = "codUserAggiornamento")
    @Mapping(target = "sedeSoggettoAttuatore", source = "progressivoSede")
    ExcelServizioModel map(ExcelServizio source);

    List<ExcelServizioModel> mapListExcelServizio(List<ExcelServizio> source);

    @Mapping(target = "gruppoOperatore", source = "gruppoOperatore.eq")
    @Mapping(target = "numProgrSportello", source = "numProgrSportello.eq")
    @Mapping(target = "codOperatore", source = "codOperatore.eq")
    @Mapping(target = "isProprietario", source = "isProprietario.eq")
    @Mapping(target = "modelId", source = "modelId.eq")
    @Mapping(target = "gruppoOpBeneficiario", source = "gruppoOpBeneficiario.eq")
    @Mapping(target = "codOpBeneficiario", source = "codOpBeneficiario.eq")
    @Mapping(target = "idServizio", source = "idServizio.eq")
    @Mapping(target = "progressivoSede", source = "progressivoSede.eq")
    @Mapping(target = "situazioneIncontro", source = "situazioneIncontro.eq")
    @Mapping(target = "idServizioRegionale", source = "idServizioRegionale.eq")
    @Mapping(target = "denominazioneEnte", source = "denominazioneEnte.ci")
    @Mapping(target = "codFiscaleDestinatario", source = "codFiscaleDestinatario.eq")
    @Mapping(target = "idFinalitaServizio", source = "idFinalitaServizio.eq")
    @Mapping(target = "idStatoServizio", source = "idStatoServizio.eq")
    FilterServiziSemplificato map(FilterServizi filter);

    @Mapping(target = "gruppoOperatore", source = "gruppoOperatore.eq")
    @Mapping(target = "numProgrSportello", source = "numProgrSportello.eq")
    @Mapping(target = "codOperatore", source = "codOperatore.eq")
    @Mapping(target = "isProprietario", source = "isProprietario.eq")
    @Mapping(target = "modelId", source = "modelId.eq")
    @Mapping(target = "gruppoOpBeneficiario", source = "gruppoOpBeneficiario.eq")
    @Mapping(target = "codOpBeneficiario", source = "codOpBeneficiario.eq")
    @Mapping(target = "codiceTipoModello", source = "codiceTipoModello.eq")
    @Mapping(target = "enteCoinvolto", source = "enteCoinvolto.ci")
    @Mapping(target = "idModelloIntervento", source = "idModelloIntervento.eq")
    @Mapping(target = "idServizioRegionale", source = "idServizioRegionale.eq")
    @Mapping(target = "idStatoModelloIntervento", source = "idStatoModelloIntervento.eq")
    FilterModelliSemplificato map(FilterModelli filter);

    @Mapping(target = "gruppoOperatore", source = "gruppoOperatore.eq")
    @Mapping(target = "numProgrSportello", source = "numProgrSportello.eq")
    @Mapping(target = "codOperatore", source = "codOperatore.eq")
    @Mapping(target = "isProprietario", source = "isProprietario.eq")
    @Mapping(target = "modelId", source = "modelId.eq")
    @Mapping(target = "gruppoOpBeneficiario", source = "gruppoOpBeneficiario.eq")
    @Mapping(target = "codOpBeneficiario", source = "codOpBeneficiario.eq")
    @Mapping(target = "denominazionEnteCoinvolto", source = "denominazionEnteCoinvolto.ci")
    @Mapping(target = "codiceFiscaleDestinatario", source = "codiceFiscaleDestinatario.eq")
    @Mapping(target = "codiceTipoIntervento", source = "codiceTipoIntervento.eq")
    @Mapping(target = "idIntervento", source = "idIntervento.eq")
    @Mapping(target = "idStatoIntervento", source = "idStatoIntervento.eq")
    @Mapping(target = "idServizio", source = "idServizio.eq")
    FilterInterventiSemplificato map(FilterInterventi filter);

    DettaglioClasseDestinatarioServizio map(DettaglioClasseDestinatarioServizioDTO source);
}
