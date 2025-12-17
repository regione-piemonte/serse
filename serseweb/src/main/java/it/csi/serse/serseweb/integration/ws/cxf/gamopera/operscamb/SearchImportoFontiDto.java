
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
 * <p>Classe Java per searchImportoFontiDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="searchImportoFontiDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idFonte" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="quotaFonteApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaFonteAvviato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaFonteConcluso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaFonteDichiarato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaFonteControllato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchImportoFontiDto", propOrder = {
    "idFonte",
    "quotaFonteApprovato",
    "quotaFonteAvviato",
    "quotaFonteConcluso",
    "quotaFonteDichiarato",
    "quotaFonteControllato"
})
public class SearchImportoFontiDto {

    protected Long idFonte;
    protected BigDecimal quotaFonteApprovato;
    protected BigDecimal quotaFonteAvviato;
    protected BigDecimal quotaFonteConcluso;
    protected BigDecimal quotaFonteDichiarato;
    protected BigDecimal quotaFonteControllato;

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
     * Recupera il valore della proprietà quotaFonteApprovato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaFonteApprovato() {
        return quotaFonteApprovato;
    }

    /**
     * Imposta il valore della proprietà quotaFonteApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaFonteApprovato(BigDecimal value) {
        this.quotaFonteApprovato = value;
    }

    /**
     * Recupera il valore della proprietà quotaFonteAvviato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaFonteAvviato() {
        return quotaFonteAvviato;
    }

    /**
     * Imposta il valore della proprietà quotaFonteAvviato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaFonteAvviato(BigDecimal value) {
        this.quotaFonteAvviato = value;
    }

    /**
     * Recupera il valore della proprietà quotaFonteConcluso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaFonteConcluso() {
        return quotaFonteConcluso;
    }

    /**
     * Imposta il valore della proprietà quotaFonteConcluso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaFonteConcluso(BigDecimal value) {
        this.quotaFonteConcluso = value;
    }

    /**
     * Recupera il valore della proprietà quotaFonteDichiarato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaFonteDichiarato() {
        return quotaFonteDichiarato;
    }

    /**
     * Imposta il valore della proprietà quotaFonteDichiarato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaFonteDichiarato(BigDecimal value) {
        this.quotaFonteDichiarato = value;
    }

    /**
     * Recupera il valore della proprietà quotaFonteControllato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaFonteControllato() {
        return quotaFonteControllato;
    }

    /**
     * Imposta il valore della proprietà quotaFonteControllato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaFonteControllato(BigDecimal value) {
        this.quotaFonteControllato = value;
    }

}
