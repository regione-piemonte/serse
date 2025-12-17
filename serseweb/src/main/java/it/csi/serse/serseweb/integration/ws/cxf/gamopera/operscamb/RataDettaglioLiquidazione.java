
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
import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per rataDettaglioLiquidazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="rataDettaglioLiquidazione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idRata" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttoLiquidazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idFonteGam" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="idAttoAmm" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numeroImpegno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="quotaImportoRataSuImpegno" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="dtQuietanza" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rataDettaglioLiquidazione", propOrder = {
    "idRata",
    "idAttoLiquidazione",
    "idFonteGam",
    "idAttoAmm",
    "numeroImpegno",
    "quotaImportoRataSuImpegno",
    "dtQuietanza"
})
public class RataDettaglioLiquidazione {

    protected Long idRata;
    protected Long idAttoLiquidazione;
    protected BigInteger idFonteGam;
    protected Long idAttoAmm;
    protected Long numeroImpegno;
    protected BigDecimal quotaImportoRataSuImpegno;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtQuietanza;

    /**
     * Recupera il valore della proprietà idRata.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdRata() {
        return idRata;
    }

    /**
     * Imposta il valore della proprietà idRata.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdRata(Long value) {
        this.idRata = value;
    }

    /**
     * Recupera il valore della proprietà idAttoLiquidazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttoLiquidazione() {
        return idAttoLiquidazione;
    }

    /**
     * Imposta il valore della proprietà idAttoLiquidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttoLiquidazione(Long value) {
        this.idAttoLiquidazione = value;
    }

    /**
     * Recupera il valore della proprietà idFonteGam.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdFonteGam() {
        return idFonteGam;
    }

    /**
     * Imposta il valore della proprietà idFonteGam.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdFonteGam(BigInteger value) {
        this.idFonteGam = value;
    }

    /**
     * Recupera il valore della proprietà idAttoAmm.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttoAmm() {
        return idAttoAmm;
    }

    /**
     * Imposta il valore della proprietà idAttoAmm.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttoAmm(Long value) {
        this.idAttoAmm = value;
    }

    /**
     * Recupera il valore della proprietà numeroImpegno.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroImpegno() {
        return numeroImpegno;
    }

    /**
     * Imposta il valore della proprietà numeroImpegno.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroImpegno(Long value) {
        this.numeroImpegno = value;
    }

    /**
     * Recupera il valore della proprietà quotaImportoRataSuImpegno.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaImportoRataSuImpegno() {
        return quotaImportoRataSuImpegno;
    }

    /**
     * Imposta il valore della proprietà quotaImportoRataSuImpegno.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaImportoRataSuImpegno(BigDecimal value) {
        this.quotaImportoRataSuImpegno = value;
    }

    /**
     * Recupera il valore della proprietà dtQuietanza.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtQuietanza() {
        return dtQuietanza;
    }

    /**
     * Imposta il valore della proprietà dtQuietanza.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtQuietanza(XMLGregorianCalendar value) {
        this.dtQuietanza = value;
    }

}
