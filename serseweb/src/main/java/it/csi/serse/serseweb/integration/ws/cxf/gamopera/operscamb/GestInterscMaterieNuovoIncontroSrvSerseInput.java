
package it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb;

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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestInterscMaterieNuovoIncontroSrvSerseInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieNuovoIncontroSrvSerseInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numeroDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreSF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceOperatoreSF" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="areaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idServizio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idIncontro" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoAttuatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceAttuatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codiceSede" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="sedeOccasionale" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}sedeOccasionaleDto" minOccurs="0"/&gt;
 *         &lt;element name="denomIncontro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dataFine" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="durataPrevista" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="numDestinatariMax" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoDestinatari" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}destinatarioSerseDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dataPrimaRegistrazione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="tkServizio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieNuovoIncontroSrvSerseInput", propOrder = {
    "codiceTipoMateria",
    "codiceTipoRichiesta",
    "idPso",
    "idSportello",
    "numeroDomanda",
    "gruppoOperatoreSF",
    "codiceOperatoreSF",
    "areaTerritoriale",
    "idServizio",
    "idIncontro",
    "gruppoAttuatore",
    "codiceAttuatore",
    "codiceSede",
    "sedeOccasionale",
    "denomIncontro",
    "dataInizio",
    "dataFine",
    "durataPrevista",
    "numDestinatariMax",
    "elencoDestinatari",
    "dataPrimaRegistrazione",
    "tkServizio"
})
public class GestInterscMaterieNuovoIncontroSrvSerseInput {

    protected String codiceTipoMateria;
    protected String codiceTipoRichiesta;
    protected Long idPso;
    protected Long idSportello;
    protected Long numeroDomanda;
    protected String gruppoOperatoreSF;
    protected Long codiceOperatoreSF;
    protected String areaTerritoriale;
    protected Long idServizio;
    protected Long idIncontro;
    protected String gruppoAttuatore;
    protected Long codiceAttuatore;
    protected Long codiceSede;
    protected SedeOccasionaleDto sedeOccasionale;
    protected String denomIncontro;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInizio;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFine;
    protected BigDecimal durataPrevista;
    protected Long numDestinatariMax;
    @XmlElement(nillable = true)
    protected List<DestinatarioSerseDto> elencoDestinatari;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataPrimaRegistrazione;
    protected Long tkServizio;

    /**
     * Recupera il valore della proprietà codiceTipoMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoMateria() {
        return codiceTipoMateria;
    }

    /**
     * Imposta il valore della proprietà codiceTipoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoMateria(String value) {
        this.codiceTipoMateria = value;
    }

    /**
     * Recupera il valore della proprietà codiceTipoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoRichiesta() {
        return codiceTipoRichiesta;
    }

    /**
     * Imposta il valore della proprietà codiceTipoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoRichiesta(String value) {
        this.codiceTipoRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà idPso.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPso() {
        return idPso;
    }

    /**
     * Imposta il valore della proprietà idPso.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPso(Long value) {
        this.idPso = value;
    }

    /**
     * Recupera il valore della proprietà idSportello.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSportello() {
        return idSportello;
    }

    /**
     * Imposta il valore della proprietà idSportello.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSportello(Long value) {
        this.idSportello = value;
    }

    /**
     * Recupera il valore della proprietà numeroDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroDomanda() {
        return numeroDomanda;
    }

    /**
     * Imposta il valore della proprietà numeroDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroDomanda(Long value) {
        this.numeroDomanda = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreSF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreSF() {
        return gruppoOperatoreSF;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreSF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreSF(String value) {
        this.gruppoOperatoreSF = value;
    }

    /**
     * Recupera il valore della proprietà codiceOperatoreSF.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceOperatoreSF() {
        return codiceOperatoreSF;
    }

    /**
     * Imposta il valore della proprietà codiceOperatoreSF.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceOperatoreSF(Long value) {
        this.codiceOperatoreSF = value;
    }

    /**
     * Recupera il valore della proprietà areaTerritoriale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaTerritoriale() {
        return areaTerritoriale;
    }

    /**
     * Imposta il valore della proprietà areaTerritoriale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaTerritoriale(String value) {
        this.areaTerritoriale = value;
    }

    /**
     * Recupera il valore della proprietà idServizio.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdServizio() {
        return idServizio;
    }

    /**
     * Imposta il valore della proprietà idServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdServizio(Long value) {
        this.idServizio = value;
    }

    /**
     * Recupera il valore della proprietà idIncontro.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdIncontro() {
        return idIncontro;
    }

    /**
     * Imposta il valore della proprietà idIncontro.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdIncontro(Long value) {
        this.idIncontro = value;
    }

    /**
     * Recupera il valore della proprietà gruppoAttuatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoAttuatore() {
        return gruppoAttuatore;
    }

    /**
     * Imposta il valore della proprietà gruppoAttuatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoAttuatore(String value) {
        this.gruppoAttuatore = value;
    }

    /**
     * Recupera il valore della proprietà codiceAttuatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceAttuatore() {
        return codiceAttuatore;
    }

    /**
     * Imposta il valore della proprietà codiceAttuatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceAttuatore(Long value) {
        this.codiceAttuatore = value;
    }

    /**
     * Recupera il valore della proprietà codiceSede.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceSede() {
        return codiceSede;
    }

    /**
     * Imposta il valore della proprietà codiceSede.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceSede(Long value) {
        this.codiceSede = value;
    }

    /**
     * Recupera il valore della proprietà sedeOccasionale.
     * 
     * @return
     *     possible object is
     *     {@link SedeOccasionaleDto }
     *     
     */
    public SedeOccasionaleDto getSedeOccasionale() {
        return sedeOccasionale;
    }

    /**
     * Imposta il valore della proprietà sedeOccasionale.
     * 
     * @param value
     *     allowed object is
     *     {@link SedeOccasionaleDto }
     *     
     */
    public void setSedeOccasionale(SedeOccasionaleDto value) {
        this.sedeOccasionale = value;
    }

    /**
     * Recupera il valore della proprietà denomIncontro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenomIncontro() {
        return denomIncontro;
    }

    /**
     * Imposta il valore della proprietà denomIncontro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenomIncontro(String value) {
        this.denomIncontro = value;
    }

    /**
     * Recupera il valore della proprietà dataInizio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizio() {
        return dataInizio;
    }

    /**
     * Imposta il valore della proprietà dataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizio(XMLGregorianCalendar value) {
        this.dataInizio = value;
    }

    /**
     * Recupera il valore della proprietà dataFine.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFine() {
        return dataFine;
    }

    /**
     * Imposta il valore della proprietà dataFine.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFine(XMLGregorianCalendar value) {
        this.dataFine = value;
    }

    /**
     * Recupera il valore della proprietà durataPrevista.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurataPrevista() {
        return durataPrevista;
    }

    /**
     * Imposta il valore della proprietà durataPrevista.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurataPrevista(BigDecimal value) {
        this.durataPrevista = value;
    }

    /**
     * Recupera il valore della proprietà numDestinatariMax.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumDestinatariMax() {
        return numDestinatariMax;
    }

    /**
     * Imposta il valore della proprietà numDestinatariMax.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumDestinatariMax(Long value) {
        this.numDestinatariMax = value;
    }

    /**
     * Gets the value of the elencoDestinatari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoDestinatari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoDestinatari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DestinatarioSerseDto }
     * 
     * 
     */
    public List<DestinatarioSerseDto> getElencoDestinatari() {
        if (elencoDestinatari == null) {
            elencoDestinatari = new ArrayList<DestinatarioSerseDto>();
        }
        return this.elencoDestinatari;
    }

    /**
     * Recupera il valore della proprietà dataPrimaRegistrazione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataPrimaRegistrazione() {
        return dataPrimaRegistrazione;
    }

    /**
     * Imposta il valore della proprietà dataPrimaRegistrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataPrimaRegistrazione(XMLGregorianCalendar value) {
        this.dataPrimaRegistrazione = value;
    }

    /**
     * Recupera il valore della proprietà tkServizio.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTkServizio() {
        return tkServizio;
    }

    /**
     * Imposta il valore della proprietà tkServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTkServizio(Long value) {
        this.tkServizio = value;
    }

}
