
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
 * <p>Classe Java per DettaglioPersonaGiuridica complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioPersonaGiuridica"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attivitaEconomica" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}AttivitaEconomica"/&gt;
 *         &lt;element name="datiOperatore" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}DatiOperatore"/&gt;
 *         &lt;element name="formaGiuridica" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}FormaGiuridica"/&gt;
 *         &lt;element name="sintesiPG" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}SintesiPersonaGiuridica"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioPersonaGiuridica", propOrder = {
    "attivitaEconomica",
    "datiOperatore",
    "formaGiuridica",
    "sintesiPG"
})
public class DettaglioPersonaGiuridica {

    @XmlElement(required = true, nillable = true)
    protected AttivitaEconomica attivitaEconomica;
    @XmlElement(required = true, nillable = true)
    protected DatiOperatore datiOperatore;
    @XmlElement(required = true, nillable = true)
    protected FormaGiuridica formaGiuridica;
    @XmlElement(required = true, nillable = true)
    protected SintesiPersonaGiuridica sintesiPG;

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
     * Recupera il valore della proprietà datiOperatore.
     * 
     * @return
     *     possible object is
     *     {@link DatiOperatore }
     *     
     */
    public DatiOperatore getDatiOperatore() {
        return datiOperatore;
    }

    /**
     * Imposta il valore della proprietà datiOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiOperatore }
     *     
     */
    public void setDatiOperatore(DatiOperatore value) {
        this.datiOperatore = value;
    }

    /**
     * Recupera il valore della proprietà formaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link FormaGiuridica }
     *     
     */
    public FormaGiuridica getFormaGiuridica() {
        return formaGiuridica;
    }

    /**
     * Imposta il valore della proprietà formaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link FormaGiuridica }
     *     
     */
    public void setFormaGiuridica(FormaGiuridica value) {
        this.formaGiuridica = value;
    }

    /**
     * Recupera il valore della proprietà sintesiPG.
     * 
     * @return
     *     possible object is
     *     {@link SintesiPersonaGiuridica }
     *     
     */
    public SintesiPersonaGiuridica getSintesiPG() {
        return sintesiPG;
    }

    /**
     * Imposta il valore della proprietà sintesiPG.
     * 
     * @param value
     *     allowed object is
     *     {@link SintesiPersonaGiuridica }
     *     
     */
    public void setSintesiPG(SintesiPersonaGiuridica value) {
        this.sintesiPG = value;
    }

}
