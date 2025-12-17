
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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per committenteDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="committenteDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="gruppoSoggettoCommittente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSoggettoCommittente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codiceDimensioneCommittente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSedeCommittente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneCommittente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codFiscPIvaCommittente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numDestinatari" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="quotaPubblica" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaPrivata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="percentualeCofinanziamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codiceCor" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataAssegnazioneCor" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="flagPresenzaSvantaggiati" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrDimensioneCommittente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idCommittente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "committenteDto", propOrder = {
    "gruppoSoggettoCommittente",
    "codiceSoggettoCommittente",
    "codiceDimensioneCommittente",
    "codiceSedeCommittente",
    "denominazioneCommittente",
    "codFiscPIvaCommittente",
    "numDestinatari",
    "quotaPubblica",
    "quotaPrivata",
    "percentualeCofinanziamento",
    "codiceCor",
    "dataAssegnazioneCor",
    "flagPresenzaSvantaggiati",
    "descrDimensioneCommittente",
    "idCommittente"
})
public class CommittenteDto {

    protected String gruppoSoggettoCommittente;
    protected Long codiceSoggettoCommittente;
    protected String codiceDimensioneCommittente;
    protected Long codiceSedeCommittente;
    protected String denominazioneCommittente;
    protected String codFiscPIvaCommittente;
    protected Long numDestinatari;
    protected BigDecimal quotaPubblica;
    protected BigDecimal quotaPrivata;
    protected BigDecimal percentualeCofinanziamento;
    protected Long codiceCor;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAssegnazioneCor;
    protected String flagPresenzaSvantaggiati;
    protected String descrDimensioneCommittente;
    protected Long idCommittente;

    /**
     * Recupera il valore della proprietà gruppoSoggettoCommittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoSoggettoCommittente() {
        return gruppoSoggettoCommittente;
    }

    /**
     * Imposta il valore della proprietà gruppoSoggettoCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoSoggettoCommittente(String value) {
        this.gruppoSoggettoCommittente = value;
    }

    /**
     * Recupera il valore della proprietà codiceSoggettoCommittente.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceSoggettoCommittente() {
        return codiceSoggettoCommittente;
    }

    /**
     * Imposta il valore della proprietà codiceSoggettoCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceSoggettoCommittente(Long value) {
        this.codiceSoggettoCommittente = value;
    }

    /**
     * Recupera il valore della proprietà codiceDimensioneCommittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDimensioneCommittente() {
        return codiceDimensioneCommittente;
    }

    /**
     * Imposta il valore della proprietà codiceDimensioneCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDimensioneCommittente(String value) {
        this.codiceDimensioneCommittente = value;
    }

    /**
     * Recupera il valore della proprietà codiceSedeCommittente.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceSedeCommittente() {
        return codiceSedeCommittente;
    }

    /**
     * Imposta il valore della proprietà codiceSedeCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceSedeCommittente(Long value) {
        this.codiceSedeCommittente = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneCommittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneCommittente() {
        return denominazioneCommittente;
    }

    /**
     * Imposta il valore della proprietà denominazioneCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneCommittente(String value) {
        this.denominazioneCommittente = value;
    }

    /**
     * Recupera il valore della proprietà codFiscPIvaCommittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscPIvaCommittente() {
        return codFiscPIvaCommittente;
    }

    /**
     * Imposta il valore della proprietà codFiscPIvaCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscPIvaCommittente(String value) {
        this.codFiscPIvaCommittente = value;
    }

    /**
     * Recupera il valore della proprietà numDestinatari.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumDestinatari() {
        return numDestinatari;
    }

    /**
     * Imposta il valore della proprietà numDestinatari.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumDestinatari(Long value) {
        this.numDestinatari = value;
    }

    /**
     * Recupera il valore della proprietà quotaPubblica.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPubblica() {
        return quotaPubblica;
    }

    /**
     * Imposta il valore della proprietà quotaPubblica.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPubblica(BigDecimal value) {
        this.quotaPubblica = value;
    }

    /**
     * Recupera il valore della proprietà quotaPrivata.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPrivata() {
        return quotaPrivata;
    }

    /**
     * Imposta il valore della proprietà quotaPrivata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPrivata(BigDecimal value) {
        this.quotaPrivata = value;
    }

    /**
     * Recupera il valore della proprietà percentualeCofinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentualeCofinanziamento() {
        return percentualeCofinanziamento;
    }

    /**
     * Imposta il valore della proprietà percentualeCofinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentualeCofinanziamento(BigDecimal value) {
        this.percentualeCofinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà codiceCor.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceCor() {
        return codiceCor;
    }

    /**
     * Imposta il valore della proprietà codiceCor.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceCor(Long value) {
        this.codiceCor = value;
    }

    /**
     * Recupera il valore della proprietà dataAssegnazioneCor.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAssegnazioneCor() {
        return dataAssegnazioneCor;
    }

    /**
     * Imposta il valore della proprietà dataAssegnazioneCor.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAssegnazioneCor(XMLGregorianCalendar value) {
        this.dataAssegnazioneCor = value;
    }

    /**
     * Recupera il valore della proprietà flagPresenzaSvantaggiati.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagPresenzaSvantaggiati() {
        return flagPresenzaSvantaggiati;
    }

    /**
     * Imposta il valore della proprietà flagPresenzaSvantaggiati.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagPresenzaSvantaggiati(String value) {
        this.flagPresenzaSvantaggiati = value;
    }

    /**
     * Recupera il valore della proprietà descrDimensioneCommittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrDimensioneCommittente() {
        return descrDimensioneCommittente;
    }

    /**
     * Imposta il valore della proprietà descrDimensioneCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrDimensioneCommittente(String value) {
        this.descrDimensioneCommittente = value;
    }

    /**
     * Recupera il valore della proprietà idCommittente.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdCommittente() {
        return idCommittente;
    }

    /**
     * Imposta il valore della proprietà idCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdCommittente(Long value) {
        this.idCommittente = value;
    }

}
