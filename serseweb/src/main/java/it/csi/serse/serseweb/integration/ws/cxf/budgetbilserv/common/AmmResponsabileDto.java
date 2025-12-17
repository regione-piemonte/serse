
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

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per AmmResponsabileDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="AmmResponsabileDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caratteristicaAmminis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codAR" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codFiscEnte" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceIstat" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="dataFineValidita" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataInizioValidita" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="descrizione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="gruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="siglaEnte" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoAmministrazione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmmResponsabileDto", propOrder = {
    "caratteristicaAmminis",
    "codAR",
    "codFiscEnte",
    "codiceIstat",
    "codiceOperatore",
    "dataFineValidita",
    "dataInizioValidita",
    "descrizione",
    "gruppoOperatore",
    "siglaEnte",
    "tipoAmministrazione"
})
public class AmmResponsabileDto {

    @XmlElement(required = true, nillable = true)
    protected String caratteristicaAmminis;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codAR;
    @XmlElement(required = true, nillable = true)
    protected String codFiscEnte;
    @XmlElement(required = true, nillable = true)
    protected String codiceIstat;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long codiceOperatore;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFineValidita;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInizioValidita;
    @XmlElement(required = true, nillable = true)
    protected String descrizione;
    @XmlElement(required = true, nillable = true)
    protected String gruppoOperatore;
    @XmlElement(required = true, nillable = true)
    protected String siglaEnte;
    @XmlElement(required = true, nillable = true)
    protected String tipoAmministrazione;

    /**
     * Recupera il valore della proprietà caratteristicaAmminis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaratteristicaAmminis() {
        return caratteristicaAmminis;
    }

    /**
     * Imposta il valore della proprietà caratteristicaAmminis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaratteristicaAmminis(String value) {
        this.caratteristicaAmminis = value;
    }

    /**
     * Recupera il valore della proprietà codAR.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodAR() {
        return codAR;
    }

    /**
     * Imposta il valore della proprietà codAR.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodAR(Integer value) {
        this.codAR = value;
    }

    /**
     * Recupera il valore della proprietà codFiscEnte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscEnte() {
        return codFiscEnte;
    }

    /**
     * Imposta il valore della proprietà codFiscEnte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscEnte(String value) {
        this.codFiscEnte = value;
    }

    /**
     * Recupera il valore della proprietà codiceIstat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceIstat() {
        return codiceIstat;
    }

    /**
     * Imposta il valore della proprietà codiceIstat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceIstat(String value) {
        this.codiceIstat = value;
    }

    /**
     * Recupera il valore della proprietà codiceOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceOperatore() {
        return codiceOperatore;
    }

    /**
     * Imposta il valore della proprietà codiceOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceOperatore(Long value) {
        this.codiceOperatore = value;
    }

    /**
     * Recupera il valore della proprietà dataFineValidita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFineValidita() {
        return dataFineValidita;
    }

    /**
     * Imposta il valore della proprietà dataFineValidita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFineValidita(XMLGregorianCalendar value) {
        this.dataFineValidita = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioValidita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizioValidita() {
        return dataInizioValidita;
    }

    /**
     * Imposta il valore della proprietà dataInizioValidita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizioValidita(XMLGregorianCalendar value) {
        this.dataInizioValidita = value;
    }

    /**
     * Recupera il valore della proprietà descrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta il valore della proprietà descrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizione(String value) {
        this.descrizione = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatore() {
        return gruppoOperatore;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatore(String value) {
        this.gruppoOperatore = value;
    }

    /**
     * Recupera il valore della proprietà siglaEnte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaEnte() {
        return siglaEnte;
    }

    /**
     * Imposta il valore della proprietà siglaEnte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaEnte(String value) {
        this.siglaEnte = value;
    }

    /**
     * Recupera il valore della proprietà tipoAmministrazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAmministrazione() {
        return tipoAmministrazione;
    }

    /**
     * Imposta il valore della proprietà tipoAmministrazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAmministrazione(String value) {
        this.tipoAmministrazione = value;
    }

}
