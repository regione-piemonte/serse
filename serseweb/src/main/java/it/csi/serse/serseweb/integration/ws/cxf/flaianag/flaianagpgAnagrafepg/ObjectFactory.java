
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

package it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg package. 
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

    private final static QName _Fault_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault");
    private final static QName _Fault1_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault1");
    private final static QName _Fault2_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault2");
    private final static QName _Fault3_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault3");
    private final static QName _Fault4_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault4");
    private final static QName _Fault5_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault5");
    private final static QName _Fault6_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault6");
    private final static QName _Fault7_QNAME = new QName("http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault7");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link CSIException }
     * 
     */
    public CSIException createCSIException() {
        return new CSIException();
    }

    /**
     * Create an instance of {@link GetElencoPG }
     * 
     */
    public GetElencoPG createGetElencoPG() {
        return new GetElencoPG();
    }

    /**
     * Create an instance of {@link GetElencoPGResponse }
     * 
     */
    public GetElencoPGResponse createGetElencoPGResponse() {
        return new GetElencoPGResponse();
    }

    /**
     * Create an instance of {@link ResultElencoPG }
     * 
     */
    public ResultElencoPG createResultElencoPG() {
        return new ResultElencoPG();
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
     * Create an instance of {@link InvalidParameterException }
     * 
     */
    public InvalidParameterException createInvalidParameterException() {
        return new InvalidParameterException();
    }

    /**
     * Create an instance of {@link TooManyOccurencesException }
     * 
     */
    public TooManyOccurencesException createTooManyOccurencesException() {
        return new TooManyOccurencesException();
    }

    /**
     * Create an instance of {@link MateriaNotYetSupportedException }
     * 
     */
    public MateriaNotYetSupportedException createMateriaNotYetSupportedException() {
        return new MateriaNotYetSupportedException();
    }

    /**
     * Create an instance of {@link GetElencoPGGCO }
     * 
     */
    public GetElencoPGGCO createGetElencoPGGCO() {
        return new GetElencoPGGCO();
    }

    /**
     * Create an instance of {@link AkOperatore }
     * 
     */
    public AkOperatore createAkOperatore() {
        return new AkOperatore();
    }

    /**
     * Create an instance of {@link GetElencoPGGCOResponse }
     * 
     */
    public GetElencoPGGCOResponse createGetElencoPGGCOResponse() {
        return new GetElencoPGGCOResponse();
    }

    /**
     * Create an instance of {@link GetDettaglioOperatore }
     * 
     */
    public GetDettaglioOperatore createGetDettaglioOperatore() {
        return new GetDettaglioOperatore();
    }

    /**
     * Create an instance of {@link GetDettaglioOperatoreResponse }
     * 
     */
    public GetDettaglioOperatoreResponse createGetDettaglioOperatoreResponse() {
        return new GetDettaglioOperatoreResponse();
    }

    /**
     * Create an instance of {@link ResultDettaglioPersonaGiuridica }
     * 
     */
    public ResultDettaglioPersonaGiuridica createResultDettaglioPersonaGiuridica() {
        return new ResultDettaglioPersonaGiuridica();
    }

    /**
     * Create an instance of {@link GetDettaglioPersonaGiuridica }
     * 
     */
    public GetDettaglioPersonaGiuridica createGetDettaglioPersonaGiuridica() {
        return new GetDettaglioPersonaGiuridica();
    }

    /**
     * Create an instance of {@link GetDettaglioPersonaGiuridicaResponse }
     * 
     */
    public GetDettaglioPersonaGiuridicaResponse createGetDettaglioPersonaGiuridicaResponse() {
        return new GetDettaglioPersonaGiuridicaResponse();
    }

    /**
     * Create an instance of {@link GetElencoTipoElemento }
     * 
     */
    public GetElencoTipoElemento createGetElencoTipoElemento() {
        return new GetElencoTipoElemento();
    }

    /**
     * Create an instance of {@link GetElencoTipoElementoResponse }
     * 
     */
    public GetElencoTipoElementoResponse createGetElencoTipoElementoResponse() {
        return new GetElencoTipoElementoResponse();
    }

    /**
     * Create an instance of {@link ResultElencoTipoElementoDto }
     * 
     */
    public ResultElencoTipoElementoDto createResultElencoTipoElementoDto() {
        return new ResultElencoTipoElementoDto();
    }

    /**
     * Create an instance of {@link AnagrafePgException }
     * 
     */
    public AnagrafePgException createAnagrafePgException() {
        return new AnagrafePgException();
    }

    /**
     * Create an instance of {@link MateriaNotSupportedByOperationException }
     * 
     */
    public MateriaNotSupportedByOperationException createMateriaNotSupportedByOperationException() {
        return new MateriaNotSupportedByOperationException();
    }

    /**
     * Create an instance of {@link GetApplicationMessage }
     * 
     */
    public GetApplicationMessage createGetApplicationMessage() {
        return new GetApplicationMessage();
    }

    /**
     * Create an instance of {@link GetApplicationMessageResponse }
     * 
     */
    public GetApplicationMessageResponse createGetApplicationMessageResponse() {
        return new GetApplicationMessageResponse();
    }

    /**
     * Create an instance of {@link ResultMessage }
     * 
     */
    public ResultMessage createResultMessage() {
        return new ResultMessage();
    }

    /**
     * Create an instance of {@link GetElencoElementiAk }
     * 
     */
    public GetElencoElementiAk createGetElencoElementiAk() {
        return new GetElencoElementiAk();
    }

    /**
     * Create an instance of {@link GetElencoElementiAkResponse }
     * 
     */
    public GetElencoElementiAkResponse createGetElencoElementiAkResponse() {
        return new GetElencoElementiAkResponse();
    }

    /**
     * Create an instance of {@link ResultElencoElementoDto }
     * 
     */
    public ResultElencoElementoDto createResultElencoElementoDto() {
        return new ResultElencoElementoDto();
    }

    /**
     * Create an instance of {@link GetElencoElementiPk }
     * 
     */
    public GetElencoElementiPk createGetElencoElementiPk() {
        return new GetElencoElementiPk();
    }

    /**
     * Create an instance of {@link GetElencoElementiPkResponse }
     * 
     */
    public GetElencoElementiPkResponse createGetElencoElementiPkResponse() {
        return new GetElencoElementiPkResponse();
    }

    /**
     * Create an instance of {@link GetDettaglioElementiAk }
     * 
     */
    public GetDettaglioElementiAk createGetDettaglioElementiAk() {
        return new GetDettaglioElementiAk();
    }

    /**
     * Create an instance of {@link GetDettaglioElementiAkResponse }
     * 
     */
    public GetDettaglioElementiAkResponse createGetDettaglioElementiAkResponse() {
        return new GetDettaglioElementiAkResponse();
    }

    /**
     * Create an instance of {@link ResultDettaglioElementoDto }
     * 
     */
    public ResultDettaglioElementoDto createResultDettaglioElementoDto() {
        return new ResultDettaglioElementoDto();
    }

    /**
     * Create an instance of {@link GetDettaglioElementiPk }
     * 
     */
    public GetDettaglioElementiPk createGetDettaglioElementiPk() {
        return new GetDettaglioElementiPk();
    }

    /**
     * Create an instance of {@link GetDettaglioElementiPkResponse }
     * 
     */
    public GetDettaglioElementiPkResponse createGetDettaglioElementiPkResponse() {
        return new GetDettaglioElementiPkResponse();
    }

    /**
     * Create an instance of {@link GetElencoCodiciSede }
     * 
     */
    public GetElencoCodiciSede createGetElencoCodiciSede() {
        return new GetElencoCodiciSede();
    }

    /**
     * Create an instance of {@link GetElencoCodiciSedeResponse }
     * 
     */
    public GetElencoCodiciSedeResponse createGetElencoCodiciSedeResponse() {
        return new GetElencoCodiciSedeResponse();
    }

    /**
     * Create an instance of {@link EliminaElemento }
     * 
     */
    public EliminaElemento createEliminaElemento() {
        return new EliminaElemento();
    }

    /**
     * Create an instance of {@link EliminaElementoResponse }
     * 
     */
    public EliminaElementoResponse createEliminaElementoResponse() {
        return new EliminaElementoResponse();
    }

    /**
     * Create an instance of {@link ResultEliminaElemento }
     * 
     */
    public ResultEliminaElemento createResultEliminaElemento() {
        return new ResultEliminaElemento();
    }

    /**
     * Create an instance of {@link InserisciElemento }
     * 
     */
    public InserisciElemento createInserisciElemento() {
        return new InserisciElemento();
    }

    /**
     * Create an instance of {@link InserisciElementoDto }
     * 
     */
    public InserisciElementoDto createInserisciElementoDto() {
        return new InserisciElementoDto();
    }

    /**
     * Create an instance of {@link InserisciElementoResponse }
     * 
     */
    public InserisciElementoResponse createInserisciElementoResponse() {
        return new InserisciElementoResponse();
    }

    /**
     * Create an instance of {@link ResultInserisciElemento }
     * 
     */
    public ResultInserisciElemento createResultInserisciElemento() {
        return new ResultInserisciElemento();
    }

    /**
     * Create an instance of {@link AggiornaElemento }
     * 
     */
    public AggiornaElemento createAggiornaElemento() {
        return new AggiornaElemento();
    }

    /**
     * Create an instance of {@link AggiornaElementoDto }
     * 
     */
    public AggiornaElementoDto createAggiornaElementoDto() {
        return new AggiornaElementoDto();
    }

    /**
     * Create an instance of {@link AggiornaElementoResponse }
     * 
     */
    public AggiornaElementoResponse createAggiornaElementoResponse() {
        return new AggiornaElementoResponse();
    }

    /**
     * Create an instance of {@link ResultAggiornaElemento }
     * 
     */
    public ResultAggiornaElemento createResultAggiornaElemento() {
        return new ResultAggiornaElemento();
    }

    /**
     * Create an instance of {@link GetElencoClassificazione }
     * 
     */
    public GetElencoClassificazione createGetElencoClassificazione() {
        return new GetElencoClassificazione();
    }

    /**
     * Create an instance of {@link GetElencoClassificazioneResponse }
     * 
     */
    public GetElencoClassificazioneResponse createGetElencoClassificazioneResponse() {
        return new GetElencoClassificazioneResponse();
    }

    /**
     * Create an instance of {@link ResultClassifElementoArrayDto }
     * 
     */
    public ResultClassifElementoArrayDto createResultClassifElementoArrayDto() {
        return new ResultClassifElementoArrayDto();
    }

    /**
     * Create an instance of {@link GetDatiAteco2007 }
     * 
     */
    public GetDatiAteco2007 createGetDatiAteco2007() {
        return new GetDatiAteco2007();
    }

    /**
     * Create an instance of {@link GetDatiAteco2007Response }
     * 
     */
    public GetDatiAteco2007Response createGetDatiAteco2007Response() {
        return new GetDatiAteco2007Response();
    }

    /**
     * Create an instance of {@link ResultAteco2007 }
     * 
     */
    public ResultAteco2007 createResultAteco2007() {
        return new ResultAteco2007();
    }

    /**
     * Create an instance of {@link GetElencoDettaglioElementiAk }
     * 
     */
    public GetElencoDettaglioElementiAk createGetElencoDettaglioElementiAk() {
        return new GetElencoDettaglioElementiAk();
    }

    /**
     * Create an instance of {@link GetElencoDettaglioElementiAkResponse }
     * 
     */
    public GetElencoDettaglioElementiAkResponse createGetElencoDettaglioElementiAkResponse() {
        return new GetElencoDettaglioElementiAkResponse();
    }

    /**
     * Create an instance of {@link ResultDettaglioElementiDto }
     * 
     */
    public ResultDettaglioElementiDto createResultDettaglioElementiDto() {
        return new ResultDettaglioElementiDto();
    }

    /**
     * Create an instance of {@link GetElencoElementiEstesoAk }
     * 
     */
    public GetElencoElementiEstesoAk createGetElencoElementiEstesoAk() {
        return new GetElencoElementiEstesoAk();
    }

    /**
     * Create an instance of {@link GetElencoElementiEstesoAkResponse }
     * 
     */
    public GetElencoElementiEstesoAkResponse createGetElencoElementiEstesoAkResponse() {
        return new GetElencoElementiEstesoAkResponse();
    }

    /**
     * Create an instance of {@link ResultElencoElementoEstesoDto }
     * 
     */
    public ResultElencoElementoEstesoDto createResultElencoElementoEstesoDto() {
        return new ResultElencoElementoEstesoDto();
    }

    /**
     * Create an instance of {@link GetElencoElementiEstesoPk }
     * 
     */
    public GetElencoElementiEstesoPk createGetElencoElementiEstesoPk() {
        return new GetElencoElementiEstesoPk();
    }

    /**
     * Create an instance of {@link GetElencoElementiEstesoPkResponse }
     * 
     */
    public GetElencoElementiEstesoPkResponse createGetElencoElementiEstesoPkResponse() {
        return new GetElencoElementiEstesoPkResponse();
    }

    /**
     * Create an instance of {@link GestioneFirmatario }
     * 
     */
    public GestioneFirmatario createGestioneFirmatario() {
        return new GestioneFirmatario();
    }

    /**
     * Create an instance of {@link GestioneFirmatarioInput }
     * 
     */
    public GestioneFirmatarioInput createGestioneFirmatarioInput() {
        return new GestioneFirmatarioInput();
    }

    /**
     * Create an instance of {@link GestioneFirmatarioResponse }
     * 
     */
    public GestioneFirmatarioResponse createGestioneFirmatarioResponse() {
        return new GestioneFirmatarioResponse();
    }

    /**
     * Create an instance of {@link GestioneFirmatarioOutput }
     * 
     */
    public GestioneFirmatarioOutput createGestioneFirmatarioOutput() {
        return new GestioneFirmatarioOutput();
    }

    /**
     * Create an instance of {@link GetFunzioneOrganizzativa }
     * 
     */
    public GetFunzioneOrganizzativa createGetFunzioneOrganizzativa() {
        return new GetFunzioneOrganizzativa();
    }

    /**
     * Create an instance of {@link GetFunzioneOrganizzativaResponse }
     * 
     */
    public GetFunzioneOrganizzativaResponse createGetFunzioneOrganizzativaResponse() {
        return new GetFunzioneOrganizzativaResponse();
    }

    /**
     * Create an instance of {@link SelItemDto }
     * 
     */
    public SelItemDto createSelItemDto() {
        return new SelItemDto();
    }

    /**
     * Create an instance of {@link GetTipoGestioneFirma }
     * 
     */
    public GetTipoGestioneFirma createGetTipoGestioneFirma() {
        return new GetTipoGestioneFirma();
    }

    /**
     * Create an instance of {@link GetTipoGestioneFirmaResponse }
     * 
     */
    public GetTipoGestioneFirmaResponse createGetTipoGestioneFirmaResponse() {
        return new GetTipoGestioneFirmaResponse();
    }

    /**
     * Create an instance of {@link GetElencoElementiPkV2 }
     * 
     */
    public GetElencoElementiPkV2 createGetElencoElementiPkV2() {
        return new GetElencoElementiPkV2();
    }

    /**
     * Create an instance of {@link GetElencoElementiPkV2Response }
     * 
     */
    public GetElencoElementiPkV2Response createGetElencoElementiPkV2Response() {
        return new GetElencoElementiPkV2Response();
    }

    /**
     * Create an instance of {@link ResultElencoElementoDtoV2 }
     * 
     */
    public ResultElencoElementoDtoV2 createResultElencoElementoDtoV2() {
        return new ResultElencoElementoDtoV2();
    }

    /**
     * Create an instance of {@link GetDettaglioElementiPkV2 }
     * 
     */
    public GetDettaglioElementiPkV2 createGetDettaglioElementiPkV2() {
        return new GetDettaglioElementiPkV2();
    }

    /**
     * Create an instance of {@link GetDettaglioElementiPkV2Response }
     * 
     */
    public GetDettaglioElementiPkV2Response createGetDettaglioElementiPkV2Response() {
        return new GetDettaglioElementiPkV2Response();
    }

    /**
     * Create an instance of {@link ResultDettaglioElementoDtoV2 }
     * 
     */
    public ResultDettaglioElementoDtoV2 createResultDettaglioElementoDtoV2() {
        return new ResultDettaglioElementoDtoV2();
    }

    /**
     * Create an instance of {@link GetElencoIncarichiPk }
     * 
     */
    public GetElencoIncarichiPk createGetElencoIncarichiPk() {
        return new GetElencoIncarichiPk();
    }

    /**
     * Create an instance of {@link GetElencoIncarichiPkResponse }
     * 
     */
    public GetElencoIncarichiPkResponse createGetElencoIncarichiPkResponse() {
        return new GetElencoIncarichiPkResponse();
    }

    /**
     * Create an instance of {@link ResultGetElencoIncarichi }
     * 
     */
    public ResultGetElencoIncarichi createResultGetElencoIncarichi() {
        return new ResultGetElencoIncarichi();
    }

    /**
     * Create an instance of {@link GetElencoIncarichiAk }
     * 
     */
    public GetElencoIncarichiAk createGetElencoIncarichiAk() {
        return new GetElencoIncarichiAk();
    }

    /**
     * Create an instance of {@link GetElencoIncarichiAkResponse }
     * 
     */
    public GetElencoIncarichiAkResponse createGetElencoIncarichiAkResponse() {
        return new GetElencoIncarichiAkResponse();
    }

    /**
     * Create an instance of {@link GestioneReferenteDDR }
     * 
     */
    public GestioneReferenteDDR createGestioneReferenteDDR() {
        return new GestioneReferenteDDR();
    }

    /**
     * Create an instance of {@link GestioneReferenteDDRInput }
     * 
     */
    public GestioneReferenteDDRInput createGestioneReferenteDDRInput() {
        return new GestioneReferenteDDRInput();
    }

    /**
     * Create an instance of {@link GestioneReferenteDDRResponse }
     * 
     */
    public GestioneReferenteDDRResponse createGestioneReferenteDDRResponse() {
        return new GestioneReferenteDDRResponse();
    }

    /**
     * Create an instance of {@link ResultGestioneReferenteDDR }
     * 
     */
    public ResultGestioneReferenteDDR createResultGestioneReferenteDDR() {
        return new ResultGestioneReferenteDDR();
    }

    /**
     * Create an instance of {@link TipoOperatore }
     * 
     */
    public TipoOperatore createTipoOperatore() {
        return new TipoOperatore();
    }

    /**
     * Create an instance of {@link SintesiOperatore }
     * 
     */
    public SintesiOperatore createSintesiOperatore() {
        return new SintesiOperatore();
    }

    /**
     * Create an instance of {@link AttivitaEconomica }
     * 
     */
    public AttivitaEconomica createAttivitaEconomica() {
        return new AttivitaEconomica();
    }

    /**
     * Create an instance of {@link Comune }
     * 
     */
    public Comune createComune() {
        return new Comune();
    }

    /**
     * Create an instance of {@link StatoEstero }
     * 
     */
    public StatoEstero createStatoEstero() {
        return new StatoEstero();
    }

    /**
     * Create an instance of {@link TipoStrada }
     * 
     */
    public TipoStrada createTipoStrada() {
        return new TipoStrada();
    }

    /**
     * Create an instance of {@link SintesiSede }
     * 
     */
    public SintesiSede createSintesiSede() {
        return new SintesiSede();
    }

    /**
     * Create an instance of {@link SintesiPersonaGiuridica }
     * 
     */
    public SintesiPersonaGiuridica createSintesiPersonaGiuridica() {
        return new SintesiPersonaGiuridica();
    }

    /**
     * Create an instance of {@link ArrayOfSintesiPersonaGiuridica }
     * 
     */
    public ArrayOfSintesiPersonaGiuridica createArrayOfSintesiPersonaGiuridica() {
        return new ArrayOfSintesiPersonaGiuridica();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link Cessazione }
     * 
     */
    public Cessazione createCessazione() {
        return new Cessazione();
    }

    /**
     * Create an instance of {@link RamoAzienda }
     * 
     */
    public RamoAzienda createRamoAzienda() {
        return new RamoAzienda();
    }

    /**
     * Create an instance of {@link Quartiere }
     * 
     */
    public Quartiere createQuartiere() {
        return new Quartiere();
    }

    /**
     * Create an instance of {@link SedeOperatore }
     * 
     */
    public SedeOperatore createSedeOperatore() {
        return new SedeOperatore();
    }

    /**
     * Create an instance of {@link DatiOperatore }
     * 
     */
    public DatiOperatore createDatiOperatore() {
        return new DatiOperatore();
    }

    /**
     * Create an instance of {@link FormaGiuridica }
     * 
     */
    public FormaGiuridica createFormaGiuridica() {
        return new FormaGiuridica();
    }

    /**
     * Create an instance of {@link DettaglioPersonaGiuridica }
     * 
     */
    public DettaglioPersonaGiuridica createDettaglioPersonaGiuridica() {
        return new DettaglioPersonaGiuridica();
    }

    /**
     * Create an instance of {@link ArrayOfSelItemDto }
     * 
     */
    public ArrayOfSelItemDto createArrayOfSelItemDto() {
        return new ArrayOfSelItemDto();
    }

    /**
     * Create an instance of {@link ElementoDto }
     * 
     */
    public ElementoDto createElementoDto() {
        return new ElementoDto();
    }

    /**
     * Create an instance of {@link ArrayOfElementoDto }
     * 
     */
    public ArrayOfElementoDto createArrayOfElementoDto() {
        return new ArrayOfElementoDto();
    }

    /**
     * Create an instance of {@link DettaglioElementoDto }
     * 
     */
    public DettaglioElementoDto createDettaglioElementoDto() {
        return new DettaglioElementoDto();
    }

    /**
     * Create an instance of {@link ClassifElementoDto }
     * 
     */
    public ClassifElementoDto createClassifElementoDto() {
        return new ClassifElementoDto();
    }

    /**
     * Create an instance of {@link ArrayOfClassifElementoDto }
     * 
     */
    public ArrayOfClassifElementoDto createArrayOfClassifElementoDto() {
        return new ArrayOfClassifElementoDto();
    }

    /**
     * Create an instance of {@link Ateco2007 }
     * 
     */
    public Ateco2007 createAteco2007() {
        return new Ateco2007();
    }

    /**
     * Create an instance of {@link ArrayOfAteco2007 }
     * 
     */
    public ArrayOfAteco2007 createArrayOfAteco2007() {
        return new ArrayOfAteco2007();
    }

    /**
     * Create an instance of {@link ArrayOfDettaglioElementoDto }
     * 
     */
    public ArrayOfDettaglioElementoDto createArrayOfDettaglioElementoDto() {
        return new ArrayOfDettaglioElementoDto();
    }

    /**
     * Create an instance of {@link ElementoEstesoDto }
     * 
     */
    public ElementoEstesoDto createElementoEstesoDto() {
        return new ElementoEstesoDto();
    }

    /**
     * Create an instance of {@link ArrayOfElementoEstesoDto }
     * 
     */
    public ArrayOfElementoEstesoDto createArrayOfElementoEstesoDto() {
        return new ArrayOfElementoEstesoDto();
    }

    /**
     * Create an instance of {@link FirmatarioDto }
     * 
     */
    public FirmatarioDto createFirmatarioDto() {
        return new FirmatarioDto();
    }

    /**
     * Create an instance of {@link ElementoDtoV2 }
     * 
     */
    public ElementoDtoV2 createElementoDtoV2() {
        return new ElementoDtoV2();
    }

    /**
     * Create an instance of {@link ArrayOfElementoDtoV2 }
     * 
     */
    public ArrayOfElementoDtoV2 createArrayOfElementoDtoV2() {
        return new ArrayOfElementoDtoV2();
    }

    /**
     * Create an instance of {@link DettaglioElementoDtoV2 }
     * 
     */
    public DettaglioElementoDtoV2 createDettaglioElementoDtoV2() {
        return new DettaglioElementoDtoV2();
    }

    /**
     * Create an instance of {@link IncaricoDto }
     * 
     */
    public IncaricoDto createIncaricoDto() {
        return new IncaricoDto();
    }

    /**
     * Create an instance of {@link ArrayOfIncaricoDto }
     * 
     */
    public ArrayOfIncaricoDto createArrayOfIncaricoDto() {
        return new ArrayOfIncaricoDto();
    }

    /**
     * Create an instance of {@link ReferenteDto }
     * 
     */
    public ReferenteDto createReferenteDto() {
        return new ReferenteDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CSIException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CSIException }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault")
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
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault1")
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
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault2")
    public JAXBElement<UnrecoverableException> createFault2(UnrecoverableException value) {
        return new JAXBElement<UnrecoverableException>(_Fault2_QNAME, UnrecoverableException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidParameterException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidParameterException }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault3")
    public JAXBElement<InvalidParameterException> createFault3(InvalidParameterException value) {
        return new JAXBElement<InvalidParameterException>(_Fault3_QNAME, InvalidParameterException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TooManyOccurencesException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TooManyOccurencesException }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault4")
    public JAXBElement<TooManyOccurencesException> createFault4(TooManyOccurencesException value) {
        return new JAXBElement<TooManyOccurencesException>(_Fault4_QNAME, TooManyOccurencesException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MateriaNotYetSupportedException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MateriaNotYetSupportedException }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault5")
    public JAXBElement<MateriaNotYetSupportedException> createFault5(MateriaNotYetSupportedException value) {
        return new JAXBElement<MateriaNotYetSupportedException>(_Fault5_QNAME, MateriaNotYetSupportedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnagrafePgException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnagrafePgException }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault6")
    public JAXBElement<AnagrafePgException> createFault6(AnagrafePgException value) {
        return new JAXBElement<AnagrafePgException>(_Fault6_QNAME, AnagrafePgException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MateriaNotSupportedByOperationException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MateriaNotSupportedByOperationException }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault7")
    public JAXBElement<MateriaNotSupportedByOperationException> createFault7(MateriaNotSupportedByOperationException value) {
        return new JAXBElement<MateriaNotSupportedByOperationException>(_Fault7_QNAME, MateriaNotSupportedByOperationException.class, null, value);
    }

}
