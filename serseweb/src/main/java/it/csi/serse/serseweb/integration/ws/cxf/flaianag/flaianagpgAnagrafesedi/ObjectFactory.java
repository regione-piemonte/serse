
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

package it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi package. 
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

    private final static QName _Fault_QNAME = new QName("http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault");
    private final static QName _Fault1_QNAME = new QName("http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault1");
    private final static QName _Fault2_QNAME = new QName("http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault2");
    private final static QName _Fault3_QNAME = new QName("http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault3");
    private final static QName _Fault4_QNAME = new QName("http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", "fault4");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi
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
     * Create an instance of {@link GetElencoSediOperatore }
     * 
     */
    public GetElencoSediOperatore createGetElencoSediOperatore() {
        return new GetElencoSediOperatore();
    }

    /**
     * Create an instance of {@link AkOperatore }
     * 
     */
    public AkOperatore createAkOperatore() {
        return new AkOperatore();
    }

    /**
     * Create an instance of {@link GetElencoSediOperatoreResponse }
     * 
     */
    public GetElencoSediOperatoreResponse createGetElencoSediOperatoreResponse() {
        return new GetElencoSediOperatoreResponse();
    }

    /**
     * Create an instance of {@link ResultElencoSedi }
     * 
     */
    public ResultElencoSedi createResultElencoSedi() {
        return new ResultElencoSedi();
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
     * Create an instance of {@link GetElencoSediPersonaGiuridica }
     * 
     */
    public GetElencoSediPersonaGiuridica createGetElencoSediPersonaGiuridica() {
        return new GetElencoSediPersonaGiuridica();
    }

    /**
     * Create an instance of {@link GetElencoSediPersonaGiuridicaResponse }
     * 
     */
    public GetElencoSediPersonaGiuridicaResponse createGetElencoSediPersonaGiuridicaResponse() {
        return new GetElencoSediPersonaGiuridicaResponse();
    }

    /**
     * Create an instance of {@link GetDettaglioSedeOperatore }
     * 
     */
    public GetDettaglioSedeOperatore createGetDettaglioSedeOperatore() {
        return new GetDettaglioSedeOperatore();
    }

    /**
     * Create an instance of {@link GetDettaglioSedeOperatoreResponse }
     * 
     */
    public GetDettaglioSedeOperatoreResponse createGetDettaglioSedeOperatoreResponse() {
        return new GetDettaglioSedeOperatoreResponse();
    }

    /**
     * Create an instance of {@link ResultDettaglioSede }
     * 
     */
    public ResultDettaglioSede createResultDettaglioSede() {
        return new ResultDettaglioSede();
    }

    /**
     * Create an instance of {@link GetDettaglioSedePersonaGiuridica }
     * 
     */
    public GetDettaglioSedePersonaGiuridica createGetDettaglioSedePersonaGiuridica() {
        return new GetDettaglioSedePersonaGiuridica();
    }

    /**
     * Create an instance of {@link GetDettaglioSedePersonaGiuridicaResponse }
     * 
     */
    public GetDettaglioSedePersonaGiuridicaResponse createGetDettaglioSedePersonaGiuridicaResponse() {
        return new GetDettaglioSedePersonaGiuridicaResponse();
    }

    /**
     * Create an instance of {@link GetElencoSediOccasionaliOperatore }
     * 
     */
    public GetElencoSediOccasionaliOperatore createGetElencoSediOccasionaliOperatore() {
        return new GetElencoSediOccasionaliOperatore();
    }

    /**
     * Create an instance of {@link GetElencoSediOccasionaliOperatoreResponse }
     * 
     */
    public GetElencoSediOccasionaliOperatoreResponse createGetElencoSediOccasionaliOperatoreResponse() {
        return new GetElencoSediOccasionaliOperatoreResponse();
    }

    /**
     * Create an instance of {@link ResultElencoSediOccasionali }
     * 
     */
    public ResultElencoSediOccasionali createResultElencoSediOccasionali() {
        return new ResultElencoSediOccasionali();
    }

    /**
     * Create an instance of {@link GetElencoSediOccasionaliPersonaGiuridica }
     * 
     */
    public GetElencoSediOccasionaliPersonaGiuridica createGetElencoSediOccasionaliPersonaGiuridica() {
        return new GetElencoSediOccasionaliPersonaGiuridica();
    }

    /**
     * Create an instance of {@link GetElencoSediOccasionaliPersonaGiuridicaResponse }
     * 
     */
    public GetElencoSediOccasionaliPersonaGiuridicaResponse createGetElencoSediOccasionaliPersonaGiuridicaResponse() {
        return new GetElencoSediOccasionaliPersonaGiuridicaResponse();
    }

    /**
     * Create an instance of {@link GetBacino }
     * 
     */
    public GetBacino createGetBacino() {
        return new GetBacino();
    }

    /**
     * Create an instance of {@link GetBacinoResponse }
     * 
     */
    public GetBacinoResponse createGetBacinoResponse() {
        return new GetBacinoResponse();
    }

    /**
     * Create an instance of {@link ResultBacino }
     * 
     */
    public ResultBacino createResultBacino() {
        return new ResultBacino();
    }

    /**
     * Create an instance of {@link InvalidParameterException2 }
     * 
     */
    public InvalidParameterException2 createInvalidParameterException2() {
        return new InvalidParameterException2();
    }

    /**
     * Create an instance of {@link GetDettaglioAreeTerritorialiPk }
     * 
     */
    public GetDettaglioAreeTerritorialiPk createGetDettaglioAreeTerritorialiPk() {
        return new GetDettaglioAreeTerritorialiPk();
    }

    /**
     * Create an instance of {@link RequestGetDettaglioAreeTerritoriali }
     * 
     */
    public RequestGetDettaglioAreeTerritoriali createRequestGetDettaglioAreeTerritoriali() {
        return new RequestGetDettaglioAreeTerritoriali();
    }

    /**
     * Create an instance of {@link GetDettaglioAreeTerritorialiPkResponse }
     * 
     */
    public GetDettaglioAreeTerritorialiPkResponse createGetDettaglioAreeTerritorialiPkResponse() {
        return new GetDettaglioAreeTerritorialiPkResponse();
    }

    /**
     * Create an instance of {@link ResultDettaglioAreeTerritoriali }
     * 
     */
    public ResultDettaglioAreeTerritoriali createResultDettaglioAreeTerritoriali() {
        return new ResultDettaglioAreeTerritoriali();
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
     * Create an instance of {@link ArrayOfSintesiSede }
     * 
     */
    public ArrayOfSintesiSede createArrayOfSintesiSede() {
        return new ArrayOfSintesiSede();
    }

    /**
     * Create an instance of {@link ResultMessage }
     * 
     */
    public ResultMessage createResultMessage() {
        return new ResultMessage();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link AttivitaEconomica }
     * 
     */
    public AttivitaEconomica createAttivitaEconomica() {
        return new AttivitaEconomica();
    }

    /**
     * Create an instance of {@link Cessazione }
     * 
     */
    public Cessazione createCessazione() {
        return new Cessazione();
    }

    /**
     * Create an instance of {@link Quartiere }
     * 
     */
    public Quartiere createQuartiere() {
        return new Quartiere();
    }

    /**
     * Create an instance of {@link DettaglioSedeOperatore }
     * 
     */
    public DettaglioSedeOperatore createDettaglioSedeOperatore() {
        return new DettaglioSedeOperatore();
    }

    /**
     * Create an instance of {@link DettaglioSede }
     * 
     */
    public DettaglioSede createDettaglioSede() {
        return new DettaglioSede();
    }

    /**
     * Create an instance of {@link SintesiSedeOccasionale }
     * 
     */
    public SintesiSedeOccasionale createSintesiSedeOccasionale() {
        return new SintesiSedeOccasionale();
    }

    /**
     * Create an instance of {@link ArrayOfSintesiSedeOccasionale }
     * 
     */
    public ArrayOfSintesiSedeOccasionale createArrayOfSintesiSedeOccasionale() {
        return new ArrayOfSintesiSedeOccasionale();
    }

    /**
     * Create an instance of {@link Bacino }
     * 
     */
    public Bacino createBacino() {
        return new Bacino();
    }

    /**
     * Create an instance of {@link ArrayOfBacino }
     * 
     */
    public ArrayOfBacino createArrayOfBacino() {
        return new ArrayOfBacino();
    }

    /**
     * Create an instance of {@link DettaglioAreaTerritoriale }
     * 
     */
    public DettaglioAreaTerritoriale createDettaglioAreaTerritoriale() {
        return new DettaglioAreaTerritoriale();
    }

    /**
     * Create an instance of {@link ArrayOfDettaglioAreaTerritoriale }
     * 
     */
    public ArrayOfDettaglioAreaTerritoriale createArrayOfDettaglioAreaTerritoriale() {
        return new ArrayOfDettaglioAreaTerritoriale();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CSIException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CSIException }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault")
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
    @XmlElementDecl(namespace = "http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault1")
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
    @XmlElementDecl(namespace = "http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault2")
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
    @XmlElementDecl(namespace = "http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault3")
    public JAXBElement<InvalidParameterException> createFault3(InvalidParameterException value) {
        return new JAXBElement<InvalidParameterException>(_Fault3_QNAME, InvalidParameterException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidParameterException2 }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidParameterException2 }{@code >}
     */
    @XmlElementDecl(namespace = "http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/", name = "fault4")
    public JAXBElement<InvalidParameterException2> createFault4(InvalidParameterException2 value) {
        return new JAXBElement<InvalidParameterException2>(_Fault4_QNAME, InvalidParameterException2 .class, null, value);
    }

}
