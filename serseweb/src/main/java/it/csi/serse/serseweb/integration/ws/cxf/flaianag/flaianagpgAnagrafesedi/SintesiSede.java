
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
 * <p>Classe Java per SintesiSede complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="SintesiSede"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="civicoSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceBacino" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comune" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}Comune"/&gt;
 *         &lt;element name="denominazioneBacino" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="denominazioneSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idSede" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="indirizzoSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="operatore" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}AkOperatore"/&gt;
 *         &lt;element name="statoEstero" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}StatoEstero"/&gt;
 *         &lt;element name="tipoSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "SintesiSede", propOrder = {
    "civicoSede",
    "codiceBacino",
    "codiceFiscale",
    "comune",
    "denominazioneBacino",
    "denominazioneSede",
    "idPersonaGiuridica",
    "idSede",
    "indirizzoSede",
    "operatore",
    "statoEstero",
    "tipoSede",
    "tipoStrada"
})
public class SintesiSede {

    @XmlElement(required = true, nillable = true)
    protected String civicoSede;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codiceBacino;
    @XmlElement(required = true, nillable = true)
    protected String codiceFiscale;
    @XmlElement(required = true, nillable = true)
    protected Comune comune;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneBacino;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneSede;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idPersonaGiuridica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idSede;
    @XmlElement(required = true, nillable = true)
    protected String indirizzoSede;
    @XmlElement(required = true, nillable = true)
    protected AkOperatore operatore;
    @XmlElement(required = true, nillable = true)
    protected StatoEstero statoEstero;
    @XmlElement(required = true, nillable = true)
    protected String tipoSede;
    @XmlElement(required = true, nillable = true)
    protected TipoStrada tipoStrada;

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
     * Recupera il valore della proprietà idSede.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSede() {
        return idSede;
    }

    /**
     * Imposta il valore della proprietà idSede.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSede(Integer value) {
        this.idSede = value;
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
     * Recupera il valore della proprietà operatore.
     * 
     * @return
     *     possible object is
     *     {@link AkOperatore }
     *     
     */
    public AkOperatore getOperatore() {
        return operatore;
    }

    /**
     * Imposta il valore della proprietà operatore.
     * 
     * @param value
     *     allowed object is
     *     {@link AkOperatore }
     *     
     */
    public void setOperatore(AkOperatore value) {
        this.operatore = value;
    }

    /**
     * Recupera il valore della proprietà statoEstero.
     * 
     * @return
     *     possible object is
     *     {@link StatoEstero }
     *     
     */
    public StatoEstero getStatoEstero() {
        return statoEstero;
    }

    /**
     * Imposta il valore della proprietà statoEstero.
     * 
     * @param value
     *     allowed object is
     *     {@link StatoEstero }
     *     
     */
    public void setStatoEstero(StatoEstero value) {
        this.statoEstero = value;
    }

    /**
     * Recupera il valore della proprietà tipoSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSede() {
        return tipoSede;
    }

    /**
     * Imposta il valore della proprietà tipoSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSede(String value) {
        this.tipoSede = value;
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
