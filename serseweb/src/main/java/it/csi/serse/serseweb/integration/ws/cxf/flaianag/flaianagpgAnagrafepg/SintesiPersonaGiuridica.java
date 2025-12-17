
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
 * <p>Classe Java per SintesiPersonaGiuridica complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="SintesiPersonaGiuridica"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="denominazionePersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="partitaIva" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sintesiOperatore" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}SintesiOperatore"/&gt;
 *         &lt;element name="sintesiSedeLegale" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}SintesiSede"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SintesiPersonaGiuridica", propOrder = {
    "codiceFiscale",
    "denominazionePersonaGiuridica",
    "idPersonaGiuridica",
    "partitaIva",
    "sintesiOperatore",
    "sintesiSedeLegale"
})
public class SintesiPersonaGiuridica {

    @XmlElement(required = true, nillable = true)
    protected String codiceFiscale;
    @XmlElement(required = true, nillable = true)
    protected String denominazionePersonaGiuridica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idPersonaGiuridica;
    @XmlElement(required = true, nillable = true)
    protected String partitaIva;
    @XmlElement(required = true, nillable = true)
    protected SintesiOperatore sintesiOperatore;
    @XmlElement(required = true, nillable = true)
    protected SintesiSede sintesiSedeLegale;

    /**
     * Recupera il valore della proprietà codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della proprietà codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Recupera il valore della proprietà denominazionePersonaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazionePersonaGiuridica() {
        return denominazionePersonaGiuridica;
    }

    /**
     * Imposta il valore della proprietà denominazionePersonaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazionePersonaGiuridica(String value) {
        this.denominazionePersonaGiuridica = value;
    }

    /**
     * Recupera il valore della proprietà idPersonaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPersonaGiuridica() {
        return idPersonaGiuridica;
    }

    /**
     * Imposta il valore della proprietà idPersonaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPersonaGiuridica(Integer value) {
        this.idPersonaGiuridica = value;
    }

    /**
     * Recupera il valore della proprietà partitaIva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartitaIva() {
        return partitaIva;
    }

    /**
     * Imposta il valore della proprietà partitaIva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartitaIva(String value) {
        this.partitaIva = value;
    }

    /**
     * Recupera il valore della proprietà sintesiOperatore.
     * 
     * @return
     *     possible object is
     *     {@link SintesiOperatore }
     *     
     */
    public SintesiOperatore getSintesiOperatore() {
        return sintesiOperatore;
    }

    /**
     * Imposta il valore della proprietà sintesiOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link SintesiOperatore }
     *     
     */
    public void setSintesiOperatore(SintesiOperatore value) {
        this.sintesiOperatore = value;
    }

    /**
     * Recupera il valore della proprietà sintesiSedeLegale.
     * 
     * @return
     *     possible object is
     *     {@link SintesiSede }
     *     
     */
    public SintesiSede getSintesiSedeLegale() {
        return sintesiSedeLegale;
    }

    /**
     * Imposta il valore della proprietà sintesiSedeLegale.
     * 
     * @param value
     *     allowed object is
     *     {@link SintesiSede }
     *     
     */
    public void setSintesiSedeLegale(SintesiSede value) {
        this.sintesiSedeLegale = value;
    }

}
