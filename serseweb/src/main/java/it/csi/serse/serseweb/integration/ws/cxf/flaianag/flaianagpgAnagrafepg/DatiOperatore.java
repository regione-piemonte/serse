
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DatiOperatore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiOperatore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="annoCCIAA" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cessazione" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}Cessazione"/&gt;
 *         &lt;element name="codiceSisa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="matricolaINPS" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroRegistroDitte" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="provinciaCCIAA" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ramoAzienda" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}RamoAzienda"/&gt;
 *         &lt;element name="sedeLegale" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}SedeOperatore"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiOperatore", propOrder = {
    "annoCCIAA",
    "cessazione",
    "codiceSisa",
    "matricolaINPS",
    "numeroRegistroDitte",
    "provinciaCCIAA",
    "ramoAzienda",
    "sedeLegale"
})
public class DatiOperatore {

    @XmlElement(required = true, nillable = true)
    protected String annoCCIAA;
    @XmlElement(required = true, nillable = true)
    protected Cessazione cessazione;
    @XmlElement(required = true, nillable = true)
    protected String codiceSisa;
    @XmlElement(required = true, nillable = true)
    protected String matricolaINPS;
    @XmlElement(required = true, nillable = true)
    protected String numeroRegistroDitte;
    @XmlElement(required = true, nillable = true)
    protected String provinciaCCIAA;
    @XmlElement(required = true, nillable = true)
    protected RamoAzienda ramoAzienda;
    @XmlElement(required = true, nillable = true)
    protected SedeOperatore sedeLegale;

    /**
     * Recupera il valore della proprietà annoCCIAA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoCCIAA() {
        return annoCCIAA;
    }

    /**
     * Imposta il valore della proprietà annoCCIAA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoCCIAA(String value) {
        this.annoCCIAA = value;
    }

    /**
     * Recupera il valore della proprietà cessazione.
     * 
     * @return
     *     possible object is
     *     {@link Cessazione }
     *     
     */
    public Cessazione getCessazione() {
        return cessazione;
    }

    /**
     * Imposta il valore della proprietà cessazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Cessazione }
     *     
     */
    public void setCessazione(Cessazione value) {
        this.cessazione = value;
    }

    /**
     * Recupera il valore della proprietà codiceSisa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSisa() {
        return codiceSisa;
    }

    /**
     * Imposta il valore della proprietà codiceSisa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSisa(String value) {
        this.codiceSisa = value;
    }

    /**
     * Recupera il valore della proprietà matricolaINPS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaINPS() {
        return matricolaINPS;
    }

    /**
     * Imposta il valore della proprietà matricolaINPS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaINPS(String value) {
        this.matricolaINPS = value;
    }

    /**
     * Recupera il valore della proprietà numeroRegistroDitte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroRegistroDitte() {
        return numeroRegistroDitte;
    }

    /**
     * Imposta il valore della proprietà numeroRegistroDitte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroRegistroDitte(String value) {
        this.numeroRegistroDitte = value;
    }

    /**
     * Recupera il valore della proprietà provinciaCCIAA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinciaCCIAA() {
        return provinciaCCIAA;
    }

    /**
     * Imposta il valore della proprietà provinciaCCIAA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinciaCCIAA(String value) {
        this.provinciaCCIAA = value;
    }

    /**
     * Recupera il valore della proprietà ramoAzienda.
     * 
     * @return
     *     possible object is
     *     {@link RamoAzienda }
     *     
     */
    public RamoAzienda getRamoAzienda() {
        return ramoAzienda;
    }

    /**
     * Imposta il valore della proprietà ramoAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link RamoAzienda }
     *     
     */
    public void setRamoAzienda(RamoAzienda value) {
        this.ramoAzienda = value;
    }

    /**
     * Recupera il valore della proprietà sedeLegale.
     * 
     * @return
     *     possible object is
     *     {@link SedeOperatore }
     *     
     */
    public SedeOperatore getSedeLegale() {
        return sedeLegale;
    }

    /**
     * Imposta il valore della proprietà sedeLegale.
     * 
     * @param value
     *     allowed object is
     *     {@link SedeOperatore }
     *     
     */
    public void setSedeLegale(SedeOperatore value) {
        this.sedeLegale = value;
    }

}
