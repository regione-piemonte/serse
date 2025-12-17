
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
 * <p>Classe Java per DettaglioSedeOperatore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioSedeOperatore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cessazione" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}Cessazione"/&gt;
 *         &lt;element name="cittaEstera" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="indirizzoAlternativo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroVerde" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="orarioApertura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="quartiere" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}Quartiere"/&gt;
 *         &lt;element name="sitoWeb" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioSedeOperatore", propOrder = {
    "cessazione",
    "cittaEstera",
    "email",
    "indirizzoAlternativo",
    "numeroVerde",
    "orarioApertura",
    "quartiere",
    "sitoWeb"
})
public class DettaglioSedeOperatore {

    @XmlElement(required = true, nillable = true)
    protected Cessazione cessazione;
    @XmlElement(required = true, nillable = true)
    protected String cittaEstera;
    @XmlElement(required = true, nillable = true)
    protected String email;
    @XmlElement(required = true, nillable = true)
    protected String indirizzoAlternativo;
    @XmlElement(required = true, nillable = true)
    protected String numeroVerde;
    @XmlElement(required = true, nillable = true)
    protected String orarioApertura;
    @XmlElement(required = true, nillable = true)
    protected Quartiere quartiere;
    @XmlElement(required = true, nillable = true)
    protected String sitoWeb;

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
     * Recupera il valore della proprietà cittaEstera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCittaEstera() {
        return cittaEstera;
    }

    /**
     * Imposta il valore della proprietà cittaEstera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCittaEstera(String value) {
        this.cittaEstera = value;
    }

    /**
     * Recupera il valore della proprietà email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il valore della proprietà email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoAlternativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzoAlternativo() {
        return indirizzoAlternativo;
    }

    /**
     * Imposta il valore della proprietà indirizzoAlternativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzoAlternativo(String value) {
        this.indirizzoAlternativo = value;
    }

    /**
     * Recupera il valore della proprietà numeroVerde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroVerde() {
        return numeroVerde;
    }

    /**
     * Imposta il valore della proprietà numeroVerde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroVerde(String value) {
        this.numeroVerde = value;
    }

    /**
     * Recupera il valore della proprietà orarioApertura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrarioApertura() {
        return orarioApertura;
    }

    /**
     * Imposta il valore della proprietà orarioApertura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrarioApertura(String value) {
        this.orarioApertura = value;
    }

    /**
     * Recupera il valore della proprietà quartiere.
     * 
     * @return
     *     possible object is
     *     {@link Quartiere }
     *     
     */
    public Quartiere getQuartiere() {
        return quartiere;
    }

    /**
     * Imposta il valore della proprietà quartiere.
     * 
     * @param value
     *     allowed object is
     *     {@link Quartiere }
     *     
     */
    public void setQuartiere(Quartiere value) {
        this.quartiere = value;
    }

    /**
     * Recupera il valore della proprietà sitoWeb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSitoWeb() {
        return sitoWeb;
    }

    /**
     * Imposta il valore della proprietà sitoWeb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSitoWeb(String value) {
        this.sitoWeb = value;
    }

}
