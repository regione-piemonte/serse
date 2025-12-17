
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

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestInterscMaterieRitiraAllievoV2Input complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieRitiraAllievoV2Input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataRitiro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="codiceRitiro" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="motivazioneRitiro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flagAllievoPagante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceChiamante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="salvaDatiDB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieRitiraAllievoV2Input", propOrder = {
    "codiceMateria",
    "codiceTipoRichiesta",
    "idInterventoApprovatoMateria",
    "idAttivitaMateria",
    "dataRitiro",
    "codiceRitiro",
    "motivazioneRitiro",
    "flagAllievoPagante",
    "codFiscale",
    "codiceChiamante",
    "salvaDatiDB"
})
public class GestInterscMaterieRitiraAllievoV2Input {

    @XmlElement(required = true)
    protected String codiceMateria;
    protected String codiceTipoRichiesta;
    protected Long idInterventoApprovatoMateria;
    protected Long idAttivitaMateria;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRitiro;
    protected Long codiceRitiro;
    protected String motivazioneRitiro;
    protected String flagAllievoPagante;
    protected String codFiscale;
    protected String codiceChiamante;
    protected String salvaDatiDB;

    /**
     * Recupera il valore della proprietà codiceMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceMateria() {
        return codiceMateria;
    }

    /**
     * Imposta il valore della proprietà codiceMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceMateria(String value) {
        this.codiceMateria = value;
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
     * Recupera il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdInterventoApprovatoMateria() {
        return idInterventoApprovatoMateria;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdInterventoApprovatoMateria(Long value) {
        this.idInterventoApprovatoMateria = value;
    }

    /**
     * Recupera il valore della proprietà idAttivitaMateria.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivitaMateria() {
        return idAttivitaMateria;
    }

    /**
     * Imposta il valore della proprietà idAttivitaMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivitaMateria(Long value) {
        this.idAttivitaMateria = value;
    }

    /**
     * Recupera il valore della proprietà dataRitiro.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRitiro() {
        return dataRitiro;
    }

    /**
     * Imposta il valore della proprietà dataRitiro.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRitiro(XMLGregorianCalendar value) {
        this.dataRitiro = value;
    }

    /**
     * Recupera il valore della proprietà codiceRitiro.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceRitiro() {
        return codiceRitiro;
    }

    /**
     * Imposta il valore della proprietà codiceRitiro.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceRitiro(Long value) {
        this.codiceRitiro = value;
    }

    /**
     * Recupera il valore della proprietà motivazioneRitiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivazioneRitiro() {
        return motivazioneRitiro;
    }

    /**
     * Imposta il valore della proprietà motivazioneRitiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivazioneRitiro(String value) {
        this.motivazioneRitiro = value;
    }

    /**
     * Recupera il valore della proprietà flagAllievoPagante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagAllievoPagante() {
        return flagAllievoPagante;
    }

    /**
     * Imposta il valore della proprietà flagAllievoPagante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagAllievoPagante(String value) {
        this.flagAllievoPagante = value;
    }

    /**
     * Recupera il valore della proprietà codFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscale() {
        return codFiscale;
    }

    /**
     * Imposta il valore della proprietà codFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscale(String value) {
        this.codFiscale = value;
    }

    /**
     * Recupera il valore della proprietà codiceChiamante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceChiamante() {
        return codiceChiamante;
    }

    /**
     * Imposta il valore della proprietà codiceChiamante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceChiamante(String value) {
        this.codiceChiamante = value;
    }

    /**
     * Recupera il valore della proprietà salvaDatiDB.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalvaDatiDB() {
        return salvaDatiDB;
    }

    /**
     * Imposta il valore della proprietà salvaDatiDB.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalvaDatiDB(String value) {
        this.salvaDatiDB = value;
    }

}
