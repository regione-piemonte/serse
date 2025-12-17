
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per searchImportoFontiAttivitaDtoV2 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="searchImportoFontiAttivitaDtoV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttivita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="importoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoAvviato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoConcluso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoDichiarato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoControllato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="elencoFonti" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}searchImportoFontiDtoV2" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="importoImpegnato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchImportoFontiAttivitaDtoV2", propOrder = {
    "idAttivita",
    "importoApprovato",
    "importoAvviato",
    "importoConcluso",
    "importoDichiarato",
    "importoControllato",
    "elencoFonti",
    "importoImpegnato"
})
public class SearchImportoFontiAttivitaDtoV2 {

    protected Long idAttivita;
    protected BigDecimal importoApprovato;
    protected BigDecimal importoAvviato;
    protected BigDecimal importoConcluso;
    protected BigDecimal importoDichiarato;
    protected BigDecimal importoControllato;
    @XmlElement(nillable = true)
    protected List<SearchImportoFontiDtoV2> elencoFonti;
    protected BigDecimal importoImpegnato;

    /**
     * Recupera il valore della proprietà idAttivita.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivita() {
        return idAttivita;
    }

    /**
     * Imposta il valore della proprietà idAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivita(Long value) {
        this.idAttivita = value;
    }

    /**
     * Recupera il valore della proprietà importoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoApprovato() {
        return importoApprovato;
    }

    /**
     * Imposta il valore della proprietà importoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoApprovato(BigDecimal value) {
        this.importoApprovato = value;
    }

    /**
     * Recupera il valore della proprietà importoAvviato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoAvviato() {
        return importoAvviato;
    }

    /**
     * Imposta il valore della proprietà importoAvviato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoAvviato(BigDecimal value) {
        this.importoAvviato = value;
    }

    /**
     * Recupera il valore della proprietà importoConcluso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoConcluso() {
        return importoConcluso;
    }

    /**
     * Imposta il valore della proprietà importoConcluso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoConcluso(BigDecimal value) {
        this.importoConcluso = value;
    }

    /**
     * Recupera il valore della proprietà importoDichiarato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoDichiarato() {
        return importoDichiarato;
    }

    /**
     * Imposta il valore della proprietà importoDichiarato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoDichiarato(BigDecimal value) {
        this.importoDichiarato = value;
    }

    /**
     * Recupera il valore della proprietà importoControllato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoControllato() {
        return importoControllato;
    }

    /**
     * Imposta il valore della proprietà importoControllato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoControllato(BigDecimal value) {
        this.importoControllato = value;
    }

    /**
     * Gets the value of the elencoFonti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoFonti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoFonti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchImportoFontiDtoV2 }
     * 
     * 
     */
    public List<SearchImportoFontiDtoV2> getElencoFonti() {
        if (elencoFonti == null) {
            elencoFonti = new ArrayList<SearchImportoFontiDtoV2>();
        }
        return this.elencoFonti;
    }

    /**
     * Recupera il valore della proprietà importoImpegnato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoImpegnato() {
        return importoImpegnato;
    }

    /**
     * Imposta il valore della proprietà importoImpegnato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoImpegnato(BigDecimal value) {
        this.importoImpegnato = value;
    }

}
