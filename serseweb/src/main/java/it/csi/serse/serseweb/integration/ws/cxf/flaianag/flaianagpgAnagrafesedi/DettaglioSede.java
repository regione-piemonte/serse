
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
 * <p>Classe Java per DettaglioSede complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioSede"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attivitaEconomica" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}AttivitaEconomica"/&gt;
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datiGenerali" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}SintesiSede"/&gt;
 *         &lt;element name="dettaglioSedeOperatore" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}DettaglioSedeOperatore"/&gt;
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "DettaglioSede", propOrder = {
    "attivitaEconomica",
    "cap",
    "datiGenerali",
    "dettaglioSedeOperatore",
    "fax",
    "telefono",
    "tipoStrada"
})
public class DettaglioSede {

    @XmlElement(required = true, nillable = true)
    protected AttivitaEconomica attivitaEconomica;
    @XmlElement(required = true, nillable = true)
    protected String cap;
    @XmlElement(required = true, nillable = true)
    protected SintesiSede datiGenerali;
    @XmlElement(required = true, nillable = true)
    protected DettaglioSedeOperatore dettaglioSedeOperatore;
    @XmlElement(required = true, nillable = true)
    protected String fax;
    @XmlElement(required = true, nillable = true)
    protected String telefono;
    @XmlElement(required = true, nillable = true)
    protected TipoStrada tipoStrada;

    /**
     * Recupera il valore della proprietà attivitaEconomica.
     * 
     * @return
     *     possible object is
     *     {@link AttivitaEconomica }
     *     
     */
    public AttivitaEconomica getAttivitaEconomica() {
        return attivitaEconomica;
    }

    /**
     * Imposta il valore della proprietà attivitaEconomica.
     * 
     * @param value
     *     allowed object is
     *     {@link AttivitaEconomica }
     *     
     */
    public void setAttivitaEconomica(AttivitaEconomica value) {
        this.attivitaEconomica = value;
    }

    /**
     * Recupera il valore della proprietà cap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCap() {
        return cap;
    }

    /**
     * Imposta il valore della proprietà cap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCap(String value) {
        this.cap = value;
    }

    /**
     * Recupera il valore della proprietà datiGenerali.
     * 
     * @return
     *     possible object is
     *     {@link SintesiSede }
     *     
     */
    public SintesiSede getDatiGenerali() {
        return datiGenerali;
    }

    /**
     * Imposta il valore della proprietà datiGenerali.
     * 
     * @param value
     *     allowed object is
     *     {@link SintesiSede }
     *     
     */
    public void setDatiGenerali(SintesiSede value) {
        this.datiGenerali = value;
    }

    /**
     * Recupera il valore della proprietà dettaglioSedeOperatore.
     * 
     * @return
     *     possible object is
     *     {@link DettaglioSedeOperatore }
     *     
     */
    public DettaglioSedeOperatore getDettaglioSedeOperatore() {
        return dettaglioSedeOperatore;
    }

    /**
     * Imposta il valore della proprietà dettaglioSedeOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link DettaglioSedeOperatore }
     *     
     */
    public void setDettaglioSedeOperatore(DettaglioSedeOperatore value) {
        this.dettaglioSedeOperatore = value;
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
