
package it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common;

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

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault_QNAME = new QName("http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", "fault");
    private final static QName _Fault1_QNAME = new QName("http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", "fault1");
    private final static QName _Fault2_QNAME = new QName("http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", "fault2");
    private final static QName _Fault3_QNAME = new QName("http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", "fault3");
    private final static QName _Fault4_QNAME = new QName("http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", "fault4");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPrimaryKey }
     * 
     */
    public GetPrimaryKey createGetPrimaryKey() {
        return new GetPrimaryKey();
    }

    /**
     * Create an instance of {@link GetPrimaryKeyResponse }
     * 
     */
    public GetPrimaryKeyResponse createGetPrimaryKeyResponse() {
        return new GetPrimaryKeyResponse();
    }

    /**
     * Create an instance of {@link CSIException }
     * 
     */
    public CSIException createCSIException() {
        return new CSIException();
    }

    /**
     * Create an instance of {@link SystemException }
     * 
     */
    public SystemException createSystemException() {
        return new SystemException();
    }

    /**
     * Create an instance of {@link UnrecoverableException }
     * 
     */
    public UnrecoverableException createUnrecoverableException() {
        return new UnrecoverableException();
    }

    /**
     * Create an instance of {@link CommonException }
     * 
     */
    public CommonException createCommonException() {
        return new CommonException();
    }

    /**
     * Create an instance of {@link InvalidParameterCommonException }
     * 
     */
    public InvalidParameterCommonException createInvalidParameterCommonException() {
        return new InvalidParameterCommonException();
    }

    /**
     * Create an instance of {@link SearchGestClassiADI }
     * 
     */
    public SearchGestClassiADI createSearchGestClassiADI() {
        return new SearchGestClassiADI();
    }

    /**
     * Create an instance of {@link SearchGestClassiADIResponse }
     * 
     */
    public SearchGestClassiADIResponse createSearchGestClassiADIResponse() {
        return new SearchGestClassiADIResponse();
    }

    /**
     * Create an instance of {@link SelItemDto }
     * 
     */
    public SelItemDto createSelItemDto() {
        return new SelItemDto();
    }

    /**
     * Create an instance of {@link TestResources }
     * 
     */
    public TestResources createTestResources() {
        return new TestResources();
    }

    /**
     * Create an instance of {@link TestResourcesResponse }
     * 
     */
    public TestResourcesResponse createTestResourcesResponse() {
        return new TestResourcesResponse();
    }

    /**
     * Create an instance of {@link SearchComboGestClassiADI }
     * 
     */
    public SearchComboGestClassiADI createSearchComboGestClassiADI() {
        return new SearchComboGestClassiADI();
    }

    /**
     * Create an instance of {@link SearchComboGestClassiADIResponse }
     * 
     */
    public SearchComboGestClassiADIResponse createSearchComboGestClassiADIResponse() {
        return new SearchComboGestClassiADIResponse();
    }

    /**
     * Create an instance of {@link SearchGestProgrammazione }
     * 
     */
    public SearchGestProgrammazione createSearchGestProgrammazione() {
        return new SearchGestProgrammazione();
    }

    /**
     * Create an instance of {@link SearchGestProgrammazioneResponse }
     * 
     */
    public SearchGestProgrammazioneResponse createSearchGestProgrammazioneResponse() {
        return new SearchGestProgrammazioneResponse();
    }

    /**
     * Create an instance of {@link SearchAllAmmResponsabili }
     * 
     */
    public SearchAllAmmResponsabili createSearchAllAmmResponsabili() {
        return new SearchAllAmmResponsabili();
    }

    /**
     * Create an instance of {@link SearchAllAmmResponsabiliResponse }
     * 
     */
    public SearchAllAmmResponsabiliResponse createSearchAllAmmResponsabiliResponse() {
        return new SearchAllAmmResponsabiliResponse();
    }

    /**
     * Create an instance of {@link AmmResponsabileDto }
     * 
     */
    public AmmResponsabileDto createAmmResponsabileDto() {
        return new AmmResponsabileDto();
    }

    /**
     * Create an instance of {@link SearchOriginiFonti }
     * 
     */
    public SearchOriginiFonti createSearchOriginiFonti() {
        return new SearchOriginiFonti();
    }

    /**
     * Create an instance of {@link SearchOriginiFontiResponse }
     * 
     */
    public SearchOriginiFontiResponse createSearchOriginiFontiResponse() {
        return new SearchOriginiFontiResponse();
    }

    /**
     * Create an instance of {@link SearchGestAmmResp }
     * 
     */
    public SearchGestAmmResp createSearchGestAmmResp() {
        return new SearchGestAmmResp();
    }

    /**
     * Create an instance of {@link SearchGestAmmRespResponse }
     * 
     */
    public SearchGestAmmRespResponse createSearchGestAmmRespResponse() {
        return new SearchGestAmmRespResponse();
    }

    /**
     * Create an instance of {@link SearchGestFonte }
     * 
     */
    public SearchGestFonte createSearchGestFonte() {
        return new SearchGestFonte();
    }

    /**
     * Create an instance of {@link SearchGestFonteResponse }
     * 
     */
    public SearchGestFonteResponse createSearchGestFonteResponse() {
        return new SearchGestFonteResponse();
    }

    /**
     * Create an instance of {@link SearchClassificazioniGAM }
     * 
     */
    public SearchClassificazioniGAM createSearchClassificazioniGAM() {
        return new SearchClassificazioniGAM();
    }

    /**
     * Create an instance of {@link SearchClassificazioniGAMResponse }
     * 
     */
    public SearchClassificazioniGAMResponse createSearchClassificazioniGAMResponse() {
        return new SearchClassificazioniGAMResponse();
    }

    /**
     * Create an instance of {@link SearchAzioniGAM }
     * 
     */
    public SearchAzioniGAM createSearchAzioniGAM() {
        return new SearchAzioniGAM();
    }

    /**
     * Create an instance of {@link SearchAzioniGAMResponse }
     * 
     */
    public SearchAzioniGAMResponse createSearchAzioniGAMResponse() {
        return new SearchAzioniGAMResponse();
    }

    /**
     * Create an instance of {@link AzioniGamDto }
     * 
     */
    public AzioniGamDto createAzioniGamDto() {
        return new AzioniGamDto();
    }

    /**
     * Create an instance of {@link SearchGestOrigini }
     * 
     */
    public SearchGestOrigini createSearchGestOrigini() {
        return new SearchGestOrigini();
    }

    /**
     * Create an instance of {@link SearchGestOriginiResponse }
     * 
     */
    public SearchGestOriginiResponse createSearchGestOriginiResponse() {
        return new SearchGestOriginiResponse();
    }

    /**
     * Create an instance of {@link SearchGestAnnoEser }
     * 
     */
    public SearchGestAnnoEser createSearchGestAnnoEser() {
        return new SearchGestAnnoEser();
    }

    /**
     * Create an instance of {@link SearchGestAnnoEserResponse }
     * 
     */
    public SearchGestAnnoEserResponse createSearchGestAnnoEserResponse() {
        return new SearchGestAnnoEserResponse();
    }

    /**
     * Create an instance of {@link SearchGestDirezioni }
     * 
     */
    public SearchGestDirezioni createSearchGestDirezioni() {
        return new SearchGestDirezioni();
    }

    /**
     * Create an instance of {@link SearchGestDirezioniResponse }
     * 
     */
    public SearchGestDirezioniResponse createSearchGestDirezioniResponse() {
        return new SearchGestDirezioniResponse();
    }

    /**
     * Create an instance of {@link GetDocumento }
     * 
     */
    public GetDocumento createGetDocumento() {
        return new GetDocumento();
    }

    /**
     * Create an instance of {@link GetDocumentoResponse }
     * 
     */
    public GetDocumentoResponse createGetDocumentoResponse() {
        return new GetDocumentoResponse();
    }

    /**
     * Create an instance of {@link SearchGestTipoDetermina }
     * 
     */
    public SearchGestTipoDetermina createSearchGestTipoDetermina() {
        return new SearchGestTipoDetermina();
    }

    /**
     * Create an instance of {@link SearchGestTipoDeterminaResponse }
     * 
     */
    public SearchGestTipoDeterminaResponse createSearchGestTipoDeterminaResponse() {
        return new SearchGestTipoDeterminaResponse();
    }

    /**
     * Create an instance of {@link SearchGestMateria }
     * 
     */
    public SearchGestMateria createSearchGestMateria() {
        return new SearchGestMateria();
    }

    /**
     * Create an instance of {@link SearchGestMateriaResponse }
     * 
     */
    public SearchGestMateriaResponse createSearchGestMateriaResponse() {
        return new SearchGestMateriaResponse();
    }

    /**
     * Create an instance of {@link SearchGestCicliFin }
     * 
     */
    public SearchGestCicliFin createSearchGestCicliFin() {
        return new SearchGestCicliFin();
    }

    /**
     * Create an instance of {@link SearchGestCicliFinResponse }
     * 
     */
    public SearchGestCicliFinResponse createSearchGestCicliFinResponse() {
        return new SearchGestCicliFinResponse();
    }

    /**
     * Create an instance of {@link SearchGestTipiAzioni }
     * 
     */
    public SearchGestTipiAzioni createSearchGestTipiAzioni() {
        return new SearchGestTipiAzioni();
    }

    /**
     * Create an instance of {@link SearchGestTipiAzioniResponse }
     * 
     */
    public SearchGestTipiAzioniResponse createSearchGestTipiAzioniResponse() {
        return new SearchGestTipiAzioniResponse();
    }

    /**
     * Create an instance of {@link SearchGestAffidamento }
     * 
     */
    public SearchGestAffidamento createSearchGestAffidamento() {
        return new SearchGestAffidamento();
    }

    /**
     * Create an instance of {@link SearchGestAffidamentoResponse }
     * 
     */
    public SearchGestAffidamentoResponse createSearchGestAffidamentoResponse() {
        return new SearchGestAffidamentoResponse();
    }

    /**
     * Create an instance of {@link SearchAttoApprov }
     * 
     */
    public SearchAttoApprov createSearchAttoApprov() {
        return new SearchAttoApprov();
    }

    /**
     * Create an instance of {@link SearchAttoApprovResponse }
     * 
     */
    public SearchAttoApprovResponse createSearchAttoApprovResponse() {
        return new SearchAttoApprovResponse();
    }

    /**
     * Create an instance of {@link AttoAmmApprovazioneDto }
     * 
     */
    public AttoAmmApprovazioneDto createAttoAmmApprovazioneDto() {
        return new AttoAmmApprovazioneDto();
    }

    /**
     * Create an instance of {@link SearchGestTipolDocumenti }
     * 
     */
    public SearchGestTipolDocumenti createSearchGestTipolDocumenti() {
        return new SearchGestTipolDocumenti();
    }

    /**
     * Create an instance of {@link SearchGestTipolDocumentiResponse }
     * 
     */
    public SearchGestTipolDocumentiResponse createSearchGestTipolDocumentiResponse() {
        return new SearchGestTipolDocumentiResponse();
    }

    /**
     * Create an instance of {@link SearchGestFonteByFonte }
     * 
     */
    public SearchGestFonteByFonte createSearchGestFonteByFonte() {
        return new SearchGestFonteByFonte();
    }

    /**
     * Create an instance of {@link SearchGestFonteByFonteResponse }
     * 
     */
    public SearchGestFonteByFonteResponse createSearchGestFonteByFonteResponse() {
        return new SearchGestFonteByFonteResponse();
    }

    /**
     * Create an instance of {@link SearchTipiAttiAmm }
     * 
     */
    public SearchTipiAttiAmm createSearchTipiAttiAmm() {
        return new SearchTipiAttiAmm();
    }

    /**
     * Create an instance of {@link SearchTipiAttiAmmResponse }
     * 
     */
    public SearchTipiAttiAmmResponse createSearchTipiAttiAmmResponse() {
        return new SearchTipiAttiAmmResponse();
    }

    /**
     * Create an instance of {@link VerificaCollegamentoImpegno }
     * 
     */
    public VerificaCollegamentoImpegno createVerificaCollegamentoImpegno() {
        return new VerificaCollegamentoImpegno();
    }

    /**
     * Create an instance of {@link VerificaCollegamentoImpegnoResponse }
     * 
     */
    public VerificaCollegamentoImpegnoResponse createVerificaCollegamentoImpegnoResponse() {
        return new VerificaCollegamentoImpegnoResponse();
    }

    /**
     * Create an instance of {@link SearchGestAffidamentoV2 }
     * 
     */
    public SearchGestAffidamentoV2 createSearchGestAffidamentoV2() {
        return new SearchGestAffidamentoV2();
    }

    /**
     * Create an instance of {@link SearchGestAffidamentoV2Response }
     * 
     */
    public SearchGestAffidamentoV2Response createSearchGestAffidamentoV2Response() {
        return new SearchGestAffidamentoV2Response();
    }

    /**
     * Create an instance of {@link SearchGestMotAssCig }
     * 
     */
    public SearchGestMotAssCig createSearchGestMotAssCig() {
        return new SearchGestMotAssCig();
    }

    /**
     * Create an instance of {@link SearchGestMotAssCigResponse }
     * 
     */
    public SearchGestMotAssCigResponse createSearchGestMotAssCigResponse() {
        return new SearchGestMotAssCigResponse();
    }

    /**
     * Create an instance of {@link SearchGestTipoAggiudicaz }
     * 
     */
    public SearchGestTipoAggiudicaz createSearchGestTipoAggiudicaz() {
        return new SearchGestTipoAggiudicaz();
    }

    /**
     * Create an instance of {@link SearchGestTipoAggiudicazResponse }
     * 
     */
    public SearchGestTipoAggiudicazResponse createSearchGestTipoAggiudicazResponse() {
        return new SearchGestTipoAggiudicazResponse();
    }

    /**
     * Create an instance of {@link SearchGestTipoSportello }
     * 
     */
    public SearchGestTipoSportello createSearchGestTipoSportello() {
        return new SearchGestTipoSportello();
    }

    /**
     * Create an instance of {@link SearchGestTipoSportelloResponse }
     * 
     */
    public SearchGestTipoSportelloResponse createSearchGestTipoSportelloResponse() {
        return new SearchGestTipoSportelloResponse();
    }

    /**
     * Create an instance of {@link SearchGestModPresentIstanza }
     * 
     */
    public SearchGestModPresentIstanza createSearchGestModPresentIstanza() {
        return new SearchGestModPresentIstanza();
    }

    /**
     * Create an instance of {@link SearchGestModPresentIstanzaResponse }
     * 
     */
    public SearchGestModPresentIstanzaResponse createSearchGestModPresentIstanzaResponse() {
        return new SearchGestModPresentIstanzaResponse();
    }

    /**
     * Create an instance of {@link GetElencoTipologieSpesa }
     * 
     */
    public GetElencoTipologieSpesa createGetElencoTipologieSpesa() {
        return new GetElencoTipologieSpesa();
    }

    /**
     * Create an instance of {@link GetElencoTipologieSpesaResponse }
     * 
     */
    public GetElencoTipologieSpesaResponse createGetElencoTipologieSpesaResponse() {
        return new GetElencoTipologieSpesaResponse();
    }

    /**
     * Create an instance of {@link GetElencoTipiProcedimento }
     * 
     */
    public GetElencoTipiProcedimento createGetElencoTipiProcedimento() {
        return new GetElencoTipiProcedimento();
    }

    /**
     * Create an instance of {@link GetElencoTipiProcedimentoResponse }
     * 
     */
    public GetElencoTipiProcedimentoResponse createGetElencoTipiProcedimentoResponse() {
        return new GetElencoTipiProcedimentoResponse();
    }

    /**
     * Create an instance of {@link GetElencoRegolamentiByTipoProcedimento }
     * 
     */
    public GetElencoRegolamentiByTipoProcedimento createGetElencoRegolamentiByTipoProcedimento() {
        return new GetElencoRegolamentiByTipoProcedimento();
    }

    /**
     * Create an instance of {@link GetElencoRegolamentiByTipoProcedimentoResponse }
     * 
     */
    public GetElencoRegolamentiByTipoProcedimentoResponse createGetElencoRegolamentiByTipoProcedimentoResponse() {
        return new GetElencoRegolamentiByTipoProcedimentoResponse();
    }

    /**
     * Create an instance of {@link GetElencoObiettiviByRegolamento }
     * 
     */
    public GetElencoObiettiviByRegolamento createGetElencoObiettiviByRegolamento() {
        return new GetElencoObiettiviByRegolamento();
    }

    /**
     * Create an instance of {@link GetElencoObiettiviByRegolamentoResponse }
     * 
     */
    public GetElencoObiettiviByRegolamentoResponse createGetElencoObiettiviByRegolamentoResponse() {
        return new GetElencoObiettiviByRegolamentoResponse();
    }

    /**
     * Create an instance of {@link GetElencoSettoriByTipoProcedimentoCodRegolamento }
     * 
     */
    public GetElencoSettoriByTipoProcedimentoCodRegolamento createGetElencoSettoriByTipoProcedimentoCodRegolamento() {
        return new GetElencoSettoriByTipoProcedimentoCodRegolamento();
    }

    /**
     * Create an instance of {@link GetElencoSettoriByTipoProcedimentoCodRegolamentoResponse }
     * 
     */
    public GetElencoSettoriByTipoProcedimentoCodRegolamentoResponse createGetElencoSettoriByTipoProcedimentoCodRegolamentoResponse() {
        return new GetElencoSettoriByTipoProcedimentoCodRegolamentoResponse();
    }

    /**
     * Create an instance of {@link GetElencoTipiSIEG }
     * 
     */
    public GetElencoTipiSIEG createGetElencoTipiSIEG() {
        return new GetElencoTipiSIEG();
    }

    /**
     * Create an instance of {@link GetElencoTipiSIEGResponse }
     * 
     */
    public GetElencoTipiSIEGResponse createGetElencoTipiSIEGResponse() {
        return new GetElencoTipiSIEGResponse();
    }

    /**
     * Create an instance of {@link GetElencoTipiStrumentiAiuto }
     * 
     */
    public GetElencoTipiStrumentiAiuto createGetElencoTipiStrumentiAiuto() {
        return new GetElencoTipiStrumentiAiuto();
    }

    /**
     * Create an instance of {@link GetElencoTipiStrumentiAiutoResponse }
     * 
     */
    public GetElencoTipiStrumentiAiutoResponse createGetElencoTipiStrumentiAiutoResponse() {
        return new GetElencoTipiStrumentiAiutoResponse();
    }

    /**
     * Create an instance of {@link GetElencoCodiciATECOSecondoLivello }
     * 
     */
    public GetElencoCodiciATECOSecondoLivello createGetElencoCodiciATECOSecondoLivello() {
        return new GetElencoCodiciATECOSecondoLivello();
    }

    /**
     * Create an instance of {@link GetElencoCodiciATECOSecondoLivelloResponse }
     * 
     */
    public GetElencoCodiciATECOSecondoLivelloResponse createGetElencoCodiciATECOSecondoLivelloResponse() {
        return new GetElencoCodiciATECOSecondoLivelloResponse();
    }

    /**
     * Create an instance of {@link InfoBilancioGestAmmResp }
     * 
     */
    public InfoBilancioGestAmmResp createInfoBilancioGestAmmResp() {
        return new InfoBilancioGestAmmResp();
    }

    /**
     * Create an instance of {@link InfoBilancioGestAmmRespResponse }
     * 
     */
    public InfoBilancioGestAmmRespResponse createInfoBilancioGestAmmRespResponse() {
        return new InfoBilancioGestAmmRespResponse();
    }

    /**
     * Create an instance of {@link SearchGestDirezioniOI }
     * 
     */
    public SearchGestDirezioniOI createSearchGestDirezioniOI() {
        return new SearchGestDirezioniOI();
    }

    /**
     * Create an instance of {@link SearchGestDirezioniOIResponse }
     * 
     */
    public SearchGestDirezioniOIResponse createSearchGestDirezioniOIResponse() {
        return new SearchGestDirezioniOIResponse();
    }

    /**
     * Create an instance of {@link SearchGestFonteOI }
     * 
     */
    public SearchGestFonteOI createSearchGestFonteOI() {
        return new SearchGestFonteOI();
    }

    /**
     * Create an instance of {@link SearchGestFonteOIResponse }
     * 
     */
    public SearchGestFonteOIResponse createSearchGestFonteOIResponse() {
        return new SearchGestFonteOIResponse();
    }

    /**
     * Create an instance of {@link GetLivelliGestProgrammazione }
     * 
     */
    public GetLivelliGestProgrammazione createGetLivelliGestProgrammazione() {
        return new GetLivelliGestProgrammazione();
    }

    /**
     * Create an instance of {@link GetLivelliGestProgrammazioneResponse }
     * 
     */
    public GetLivelliGestProgrammazioneResponse createGetLivelliGestProgrammazioneResponse() {
        return new GetLivelliGestProgrammazioneResponse();
    }

    /**
     * Create an instance of {@link LivelloClassificazionePOR }
     * 
     */
    public LivelloClassificazionePOR createLivelloClassificazionePOR() {
        return new LivelloClassificazionePOR();
    }

    /**
     * Create an instance of {@link SearchComboV2GestClassiADI }
     * 
     */
    public SearchComboV2GestClassiADI createSearchComboV2GestClassiADI() {
        return new SearchComboV2GestClassiADI();
    }

    /**
     * Create an instance of {@link SearchComboV2GestClassiADIResponse }
     * 
     */
    public SearchComboV2GestClassiADIResponse createSearchComboV2GestClassiADIResponse() {
        return new SearchComboV2GestClassiADIResponse();
    }

    /**
     * Create an instance of {@link SearchGestAffidamentoV3 }
     * 
     */
    public SearchGestAffidamentoV3 createSearchGestAffidamentoV3() {
        return new SearchGestAffidamentoV3();
    }

    /**
     * Create an instance of {@link SearchGestAffidamentoV3Response }
     * 
     */
    public SearchGestAffidamentoV3Response createSearchGestAffidamentoV3Response() {
        return new SearchGestAffidamentoV3Response();
    }

    /**
     * Create an instance of {@link SearchGestTipoAggiudicaz2127 }
     * 
     */
    public SearchGestTipoAggiudicaz2127 createSearchGestTipoAggiudicaz2127() {
        return new SearchGestTipoAggiudicaz2127();
    }

    /**
     * Create an instance of {@link SearchGestTipoAggiudicaz2127Response }
     * 
     */
    public SearchGestTipoAggiudicaz2127Response createSearchGestTipoAggiudicaz2127Response() {
        return new SearchGestTipoAggiudicaz2127Response();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CSIException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CSIException }{@code >}
     */
    @XmlElementDecl(namespace = "http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", name = "fault")
    public JAXBElement<CSIException> createFault(CSIException value) {
        return new JAXBElement<CSIException>(_Fault_QNAME, CSIException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SystemException }{@code >}
     */
    @XmlElementDecl(namespace = "http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", name = "fault1")
    public JAXBElement<SystemException> createFault1(SystemException value) {
        return new JAXBElement<SystemException>(_Fault1_QNAME, SystemException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnrecoverableException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnrecoverableException }{@code >}
     */
    @XmlElementDecl(namespace = "http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", name = "fault2")
    public JAXBElement<UnrecoverableException> createFault2(UnrecoverableException value) {
        return new JAXBElement<UnrecoverableException>(_Fault2_QNAME, UnrecoverableException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CommonException }{@code >}
     */
    @XmlElementDecl(namespace = "http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", name = "fault3")
    public JAXBElement<CommonException> createFault3(CommonException value) {
        return new JAXBElement<CommonException>(_Fault3_QNAME, CommonException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidParameterCommonException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidParameterCommonException }{@code >}
     */
    @XmlElementDecl(namespace = "http://common.interfacecsi.budgetbilserv.gambudget.csi.it/", name = "fault4")
    public JAXBElement<InvalidParameterCommonException> createFault4(InvalidParameterCommonException value) {
        return new JAXBElement<InvalidParameterCommonException>(_Fault4_QNAME, InvalidParameterCommonException.class, null, value);
    }

}
