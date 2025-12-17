
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
 * <p>Classe Java per fontiImportiBudgetDisponibile complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="fontiImportiBudgetDisponibile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idFonte" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idOccorrenzaTabellaFinanziamento" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="importoStanziatoFonte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoUtilizzatoFonte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoResiduoFonte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fontiImportiBudgetDisponibile", propOrder = {
    "idFonte",
    "idOccorrenzaTabellaFinanziamento",
    "importoStanziatoFonte",
    "importoUtilizzatoFonte",
    "importoResiduoFonte"
})
public class FontiImportiBudgetDisponibile {

    protected Long idFonte;
    protected Long idOccorrenzaTabellaFinanziamento;
    protected BigDecimal importoStanziatoFonte;
    protected BigDecimal importoUtilizzatoFonte;
    protected BigDecimal importoResiduoFonte;

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
     * Recupera il valore della proprietà idOccorrenzaTabellaFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdOccorrenzaTabellaFinanziamento() {
        return idOccorrenzaTabellaFinanziamento;
    }

    /**
     * Imposta il valore della proprietà idOccorrenzaTabellaFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdOccorrenzaTabellaFinanziamento(Long value) {
        this.idOccorrenzaTabellaFinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà importoStanziatoFonte.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoStanziatoFonte() {
        return importoStanziatoFonte;
    }

    /**
     * Imposta il valore della proprietà importoStanziatoFonte.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoStanziatoFonte(BigDecimal value) {
        this.importoStanziatoFonte = value;
    }

    /**
     * Recupera il valore della proprietà importoUtilizzatoFonte.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoUtilizzatoFonte() {
        return importoUtilizzatoFonte;
    }

    /**
     * Imposta il valore della proprietà importoUtilizzatoFonte.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoUtilizzatoFonte(BigDecimal value) {
        this.importoUtilizzatoFonte = value;
    }

    /**
     * Recupera il valore della proprietà importoResiduoFonte.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoResiduoFonte() {
        return importoResiduoFonte;
    }

    /**
     * Imposta il valore della proprietà importoResiduoFonte.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoResiduoFonte(BigDecimal value) {
        this.importoResiduoFonte = value;
    }

}
