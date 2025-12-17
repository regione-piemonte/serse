
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

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="in0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in1" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="in2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="in3" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="in4" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "in0",
    "in1",
    "in2",
    "in3",
    "in4"
})
@XmlRootElement(name = "searchAttoApprov")
public class SearchAttoApprov {

    protected String in0;
    protected long in1;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar in2;
    protected long in3;
    protected Long in4;

    /**
     * Recupera il valore della proprietà in0.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIn0() {
        return in0;
    }

    /**
     * Imposta il valore della proprietà in0.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIn0(String value) {
        this.in0 = value;
    }

    /**
     * Recupera il valore della proprietà in1.
     * 
     */
    public long getIn1() {
        return in1;
    }

    /**
     * Imposta il valore della proprietà in1.
     * 
     */
    public void setIn1(long value) {
        this.in1 = value;
    }

    /**
     * Recupera il valore della proprietà in2.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIn2() {
        return in2;
    }

    /**
     * Imposta il valore della proprietà in2.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIn2(XMLGregorianCalendar value) {
        this.in2 = value;
    }

    /**
     * Recupera il valore della proprietà in3.
     * 
     */
    public long getIn3() {
        return in3;
    }

    /**
     * Imposta il valore della proprietà in3.
     * 
     */
    public void setIn3(long value) {
        this.in3 = value;
    }

    /**
     * Recupera il valore della proprietà in4.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIn4() {
        return in4;
    }

    /**
     * Imposta il valore della proprietà in4.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIn4(Long value) {
        this.in4 = value;
    }

}
