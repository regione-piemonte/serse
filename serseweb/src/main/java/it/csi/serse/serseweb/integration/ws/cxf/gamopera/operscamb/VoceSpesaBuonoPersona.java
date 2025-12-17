
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
 * <p>Classe Java per voceSpesaBuonoPersona complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="voceSpesaBuonoPersona"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codVoceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="spesaPE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="spesaPF" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="spesaPT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="spesaTotale" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voceSpesaBuonoPersona", propOrder = {
    "codVoceSpesa",
    "spesaPE",
    "spesaPF",
    "spesaPT",
    "spesaTotale"
})
public class VoceSpesaBuonoPersona {

    protected String codVoceSpesa;
    protected BigDecimal spesaPE;
    protected BigDecimal spesaPF;
    protected BigDecimal spesaPT;
    protected BigDecimal spesaTotale;

    /**
     * Recupera il valore della proprietà codVoceSpesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVoceSpesa() {
        return codVoceSpesa;
    }

    /**
     * Imposta il valore della proprietà codVoceSpesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVoceSpesa(String value) {
        this.codVoceSpesa = value;
    }

    /**
     * Recupera il valore della proprietà spesaPE.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpesaPE() {
        return spesaPE;
    }

    /**
     * Imposta il valore della proprietà spesaPE.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpesaPE(BigDecimal value) {
        this.spesaPE = value;
    }

    /**
     * Recupera il valore della proprietà spesaPF.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpesaPF() {
        return spesaPF;
    }

    /**
     * Imposta il valore della proprietà spesaPF.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpesaPF(BigDecimal value) {
        this.spesaPF = value;
    }

    /**
     * Recupera il valore della proprietà spesaPT.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpesaPT() {
        return spesaPT;
    }

    /**
     * Imposta il valore della proprietà spesaPT.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpesaPT(BigDecimal value) {
        this.spesaPT = value;
    }

    /**
     * Recupera il valore della proprietà spesaTotale.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpesaTotale() {
        return spesaTotale;
    }

    /**
     * Imposta il valore della proprietà spesaTotale.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpesaTotale(BigDecimal value) {
        this.spesaTotale = value;
    }

}
