
package it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common;

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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per SelItemDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="SelItemDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caratteristica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="secondaryKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="secondaryValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelItemDto", propOrder = {
    "caratteristica",
    "key",
    "secondaryKey",
    "secondaryValue",
    "value"
})
public class SelItemDto {

    @XmlElement(required = true, nillable = true)
    protected String caratteristica;
    @XmlElement(required = true, nillable = true)
    protected String key;
    @XmlElement(required = true, nillable = true)
    protected String secondaryKey;
    @XmlElement(required = true, nillable = true)
    protected String secondaryValue;
    @XmlElement(required = true, nillable = true)
    protected String value;

    /**
     * Recupera il valore della proprietà caratteristica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaratteristica() {
        return caratteristica;
    }

    /**
     * Imposta il valore della proprietà caratteristica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaratteristica(String value) {
        this.caratteristica = value;
    }

    /**
     * Recupera il valore della proprietà key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Imposta il valore della proprietà key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Recupera il valore della proprietà secondaryKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryKey() {
        return secondaryKey;
    }

    /**
     * Imposta il valore della proprietà secondaryKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryKey(String value) {
        this.secondaryKey = value;
    }

    /**
     * Recupera il valore della proprietà secondaryValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryValue() {
        return secondaryValue;
    }

    /**
     * Imposta il valore della proprietà secondaryValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryValue(String value) {
        this.secondaryValue = value;
    }

    /**
     * Recupera il valore della proprietà value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Imposta il valore della proprietà value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
