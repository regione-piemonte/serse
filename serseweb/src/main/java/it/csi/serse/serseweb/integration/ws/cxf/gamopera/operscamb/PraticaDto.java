
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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per praticaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="praticaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nrDomandaFin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tipoAttoAmm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codArAttoAmm" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numAttoAmm" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataAttoAmm" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="chiaveUtenteAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annoGestione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "praticaDto", propOrder = {
    "nrDomandaFin",
    "tipoAttoAmm",
    "codArAttoAmm",
    "numAttoAmm",
    "dataAttoAmm",
    "chiaveUtenteAutorizzazione",
    "annoGestione"
})
public class PraticaDto {

    protected Long nrDomandaFin;
    protected String tipoAttoAmm;
    protected Long codArAttoAmm;
    protected Long numAttoAmm;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAttoAmm;
    protected String chiaveUtenteAutorizzazione;
    protected Long annoGestione;

    /**
     * Recupera il valore della proprietà nrDomandaFin.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNrDomandaFin() {
        return nrDomandaFin;
    }

    /**
     * Imposta il valore della proprietà nrDomandaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNrDomandaFin(Long value) {
        this.nrDomandaFin = value;
    }

    /**
     * Recupera il valore della proprietà tipoAttoAmm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAttoAmm() {
        return tipoAttoAmm;
    }

    /**
     * Imposta il valore della proprietà tipoAttoAmm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAttoAmm(String value) {
        this.tipoAttoAmm = value;
    }

    /**
     * Recupera il valore della proprietà codArAttoAmm.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodArAttoAmm() {
        return codArAttoAmm;
    }

    /**
     * Imposta il valore della proprietà codArAttoAmm.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodArAttoAmm(Long value) {
        this.codArAttoAmm = value;
    }

    /**
     * Recupera il valore della proprietà numAttoAmm.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumAttoAmm() {
        return numAttoAmm;
    }

    /**
     * Imposta il valore della proprietà numAttoAmm.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumAttoAmm(Long value) {
        this.numAttoAmm = value;
    }

    /**
     * Recupera il valore della proprietà dataAttoAmm.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAttoAmm() {
        return dataAttoAmm;
    }

    /**
     * Imposta il valore della proprietà dataAttoAmm.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAttoAmm(XMLGregorianCalendar value) {
        this.dataAttoAmm = value;
    }

    /**
     * Recupera il valore della proprietà chiaveUtenteAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChiaveUtenteAutorizzazione() {
        return chiaveUtenteAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà chiaveUtenteAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChiaveUtenteAutorizzazione(String value) {
        this.chiaveUtenteAutorizzazione = value;
    }

    /**
     * Recupera il valore della proprietà annoGestione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnoGestione() {
        return annoGestione;
    }

    /**
     * Imposta il valore della proprietà annoGestione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnoGestione(Long value) {
        this.annoGestione = value;
    }

}
