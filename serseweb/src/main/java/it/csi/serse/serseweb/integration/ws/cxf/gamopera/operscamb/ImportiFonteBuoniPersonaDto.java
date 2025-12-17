
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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per importiFonteBuoniPersonaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="importiFonteBuoniPersonaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idFonte" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="importoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoBuoniValidi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoBuoniNONValidi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoMaxSostituibile" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoBuoniSostituiti" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoDisponibileSostituzioni" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importiFonteBuoniPersonaDto", propOrder = {
    "idFonte",
    "importoApprovato",
    "importoBuoniValidi",
    "importoBuoniNONValidi",
    "importoMaxSostituibile",
    "importoBuoniSostituiti",
    "importoDisponibileSostituzioni"
})
public class ImportiFonteBuoniPersonaDto {

    protected Long idFonte;
    protected BigDecimal importoApprovato;
    protected BigDecimal importoBuoniValidi;
    protected BigDecimal importoBuoniNONValidi;
    protected BigDecimal importoMaxSostituibile;
    protected BigDecimal importoBuoniSostituiti;
    protected BigDecimal importoDisponibileSostituzioni;

    /**
     * Recupera il valore della proprietà idFonte.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdFonte() {
        return idFonte;
    }

    /**
     * Imposta il valore della proprietà idFonte.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFonte(Long value) {
        this.idFonte = value;
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
     * Recupera il valore della proprietà importoBuoniValidi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoBuoniValidi() {
        return importoBuoniValidi;
    }

    /**
     * Imposta il valore della proprietà importoBuoniValidi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoBuoniValidi(BigDecimal value) {
        this.importoBuoniValidi = value;
    }

    /**
     * Recupera il valore della proprietà importoBuoniNONValidi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoBuoniNONValidi() {
        return importoBuoniNONValidi;
    }

    /**
     * Imposta il valore della proprietà importoBuoniNONValidi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoBuoniNONValidi(BigDecimal value) {
        this.importoBuoniNONValidi = value;
    }

    /**
     * Recupera il valore della proprietà importoMaxSostituibile.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoMaxSostituibile() {
        return importoMaxSostituibile;
    }

    /**
     * Imposta il valore della proprietà importoMaxSostituibile.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoMaxSostituibile(BigDecimal value) {
        this.importoMaxSostituibile = value;
    }

    /**
     * Recupera il valore della proprietà importoBuoniSostituiti.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoBuoniSostituiti() {
        return importoBuoniSostituiti;
    }

    /**
     * Imposta il valore della proprietà importoBuoniSostituiti.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoBuoniSostituiti(BigDecimal value) {
        this.importoBuoniSostituiti = value;
    }

    /**
     * Recupera il valore della proprietà importoDisponibileSostituzioni.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoDisponibileSostituzioni() {
        return importoDisponibileSostituzioni;
    }

    /**
     * Imposta il valore della proprietà importoDisponibileSostituzioni.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoDisponibileSostituzioni(BigDecimal value) {
        this.importoDisponibileSostituzioni = value;
    }

}
