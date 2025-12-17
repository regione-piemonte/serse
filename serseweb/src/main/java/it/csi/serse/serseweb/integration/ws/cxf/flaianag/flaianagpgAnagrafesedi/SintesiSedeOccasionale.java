
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per SintesiSedeOccasionale complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="SintesiSedeOccasionale"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="capSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cessazione" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}Cessazione"/&gt;
 *         &lt;element name="civicoSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceBacino" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="comune" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}Comune"/&gt;
 *         &lt;element name="denominazioneBacino" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="denominazioneSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idSedeOccasionale" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="indirizzoSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoStrada" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}TipoStrada"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SintesiSedeOccasionale", propOrder = {
    "capSede",
    "cessazione",
    "civicoSede",
    "codiceBacino",
    "comune",
    "denominazioneBacino",
    "denominazioneSede",
    "fax",
    "idSedeOccasionale",
    "indirizzoSede",
    "telefono",
    "tipoStrada"
})
public class SintesiSedeOccasionale {

    @XmlElement(required = true, nillable = true)
    protected String capSede;
    @XmlElement(required = true, nillable = true)
    protected Cessazione cessazione;
    @XmlElement(required = true, nillable = true)
    protected String civicoSede;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codiceBacino;
    @XmlElement(required = true, nillable = true)
    protected Comune comune;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneBacino;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneSede;
    @XmlElement(required = true, nillable = true)
    protected String fax;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idSedeOccasionale;
    @XmlElement(required = true, nillable = true)
    protected String indirizzoSede;
    @XmlElement(required = true, nillable = true)
    protected String telefono;
    @XmlElement(required = true, nillable = true)
    protected TipoStrada tipoStrada;

    /**
     * Recupera il valore della proprietà capSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapSede() {
        return capSede;
    }

    /**
     * Imposta il valore della proprietà capSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapSede(String value) {
        this.capSede = value;
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
     * Recupera il valore della proprietà civicoSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCivicoSede() {
        return civicoSede;
    }

    /**
     * Imposta il valore della proprietà civicoSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCivicoSede(String value) {
        this.civicoSede = value;
    }

    /**
     * Recupera il valore della proprietà codiceBacino.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodiceBacino() {
        return codiceBacino;
    }

    /**
     * Imposta il valore della proprietà codiceBacino.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodiceBacino(Integer value) {
        this.codiceBacino = value;
    }

    /**
     * Recupera il valore della proprietà comune.
     * 
     * @return
     *     possible object is
     *     {@link Comune }
     *     
     */
    public Comune getComune() {
        return comune;
    }

    /**
     * Imposta il valore della proprietà comune.
     * 
     * @param value
     *     allowed object is
     *     {@link Comune }
     *     
     */
    public void setComune(Comune value) {
        this.comune = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneBacino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneBacino() {
        return denominazioneBacino;
    }

    /**
     * Imposta il valore della proprietà denominazioneBacino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneBacino(String value) {
        this.denominazioneBacino = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneSede() {
        return denominazioneSede;
    }

    /**
     * Imposta il valore della proprietà denominazioneSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneSede(String value) {
        this.denominazioneSede = value;
    }

    /**
     * Recupera il valore della proprietà fax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Imposta il valore della proprietà fax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Recupera il valore della proprietà idSedeOccasionale.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSedeOccasionale() {
        return idSedeOccasionale;
    }

    /**
     * Imposta il valore della proprietà idSedeOccasionale.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSedeOccasionale(Integer value) {
        this.idSedeOccasionale = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzoSede() {
        return indirizzoSede;
    }

    /**
     * Imposta il valore della proprietà indirizzoSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzoSede(String value) {
        this.indirizzoSede = value;
    }

    /**
     * Recupera il valore della proprietà telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Imposta il valore della proprietà telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Recupera il valore della proprietà tipoStrada.
     * 
     * @return
     *     possible object is
     *     {@link TipoStrada }
     *     
     */
    public TipoStrada getTipoStrada() {
        return tipoStrada;
    }

    /**
     * Imposta il valore della proprietà tipoStrada.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoStrada }
     *     
     */
    public void setTipoStrada(TipoStrada value) {
        this.tipoStrada = value;
    }

}
