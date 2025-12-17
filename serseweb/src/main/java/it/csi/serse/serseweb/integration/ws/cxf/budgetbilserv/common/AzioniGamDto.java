
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per AzioniGamDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="AzioniGamDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="asse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="attivita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="azione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codProgrammazione" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="descAzioneGam" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="obiettivo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AzioniGamDto", propOrder = {
    "asse",
    "attivita",
    "azione",
    "codProgrammazione",
    "descAzioneGam",
    "obiettivo"
})
public class AzioniGamDto {

    @XmlElement(required = true, nillable = true)
    protected String asse;
    @XmlElement(required = true, nillable = true)
    protected String attivita;
    @XmlElement(required = true, nillable = true)
    protected String azione;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long codProgrammazione;
    @XmlElement(required = true, nillable = true)
    protected String descAzioneGam;
    @XmlElement(required = true, nillable = true)
    protected String obiettivo;

    /**
     * Recupera il valore della proprietà asse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsse() {
        return asse;
    }

    /**
     * Imposta il valore della proprietà asse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsse(String value) {
        this.asse = value;
    }

    /**
     * Recupera il valore della proprietà attivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttivita() {
        return attivita;
    }

    /**
     * Imposta il valore della proprietà attivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttivita(String value) {
        this.attivita = value;
    }

    /**
     * Recupera il valore della proprietà azione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAzione() {
        return azione;
    }

    /**
     * Imposta il valore della proprietà azione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAzione(String value) {
        this.azione = value;
    }

    /**
     * Recupera il valore della proprietà codProgrammazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodProgrammazione() {
        return codProgrammazione;
    }

    /**
     * Imposta il valore della proprietà codProgrammazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodProgrammazione(Long value) {
        this.codProgrammazione = value;
    }

    /**
     * Recupera il valore della proprietà descAzioneGam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescAzioneGam() {
        return descAzioneGam;
    }

    /**
     * Imposta il valore della proprietà descAzioneGam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescAzioneGam(String value) {
        this.descAzioneGam = value;
    }

    /**
     * Recupera il valore della proprietà obiettivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObiettivo() {
        return obiettivo;
    }

    /**
     * Imposta il valore della proprietà obiettivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObiettivo(String value) {
        this.obiettivo = value;
    }

}
