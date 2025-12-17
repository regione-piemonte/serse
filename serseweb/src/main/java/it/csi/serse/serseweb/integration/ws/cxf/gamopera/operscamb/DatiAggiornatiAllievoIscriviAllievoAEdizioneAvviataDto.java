
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
 * <p>Classe Java per datiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="datiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTipologiaContributo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="oreFrequenzaDest" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaPubblicaDest" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaPrivataDest" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto", propOrder = {
    "idTipologiaContributo",
    "oreFrequenzaDest",
    "quotaPubblicaDest",
    "quotaPrivataDest"
})
public class DatiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto {

    protected Long idTipologiaContributo;
    protected BigDecimal oreFrequenzaDest;
    protected BigDecimal quotaPubblicaDest;
    protected BigDecimal quotaPrivataDest;

    /**
     * Recupera il valore della proprietà idTipologiaContributo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdTipologiaContributo() {
        return idTipologiaContributo;
    }

    /**
     * Imposta il valore della proprietà idTipologiaContributo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdTipologiaContributo(Long value) {
        this.idTipologiaContributo = value;
    }

    /**
     * Recupera il valore della proprietà oreFrequenzaDest.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOreFrequenzaDest() {
        return oreFrequenzaDest;
    }

    /**
     * Imposta il valore della proprietà oreFrequenzaDest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOreFrequenzaDest(BigDecimal value) {
        this.oreFrequenzaDest = value;
    }

    /**
     * Recupera il valore della proprietà quotaPubblicaDest.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPubblicaDest() {
        return quotaPubblicaDest;
    }

    /**
     * Imposta il valore della proprietà quotaPubblicaDest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPubblicaDest(BigDecimal value) {
        this.quotaPubblicaDest = value;
    }

    /**
     * Recupera il valore della proprietà quotaPrivataDest.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPrivataDest() {
        return quotaPrivataDest;
    }

    /**
     * Imposta il valore della proprietà quotaPrivataDest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPrivataDest(BigDecimal value) {
        this.quotaPrivataDest = value;
    }

}
