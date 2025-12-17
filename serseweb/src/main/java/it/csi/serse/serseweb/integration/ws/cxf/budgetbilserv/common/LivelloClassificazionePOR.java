
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
 * <p>Classe Java per LivelloClassificazionePOR complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="LivelloClassificazionePOR"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codProgrammazione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descLivello1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descLivello2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descLivello3" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descLivello4" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivelloClassificazionePOR", propOrder = {
    "codProgrammazione",
    "descLivello1",
    "descLivello2",
    "descLivello3",
    "descLivello4"
})
public class LivelloClassificazionePOR {

    @XmlElement(required = true, nillable = true)
    protected String codProgrammazione;
    @XmlElement(required = true, nillable = true)
    protected String descLivello1;
    @XmlElement(required = true, nillable = true)
    protected String descLivello2;
    @XmlElement(required = true, nillable = true)
    protected String descLivello3;
    @XmlElement(required = true, nillable = true)
    protected String descLivello4;

    /**
     * Recupera il valore della proprietà codProgrammazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProgrammazione() {
        return codProgrammazione;
    }

    /**
     * Imposta il valore della proprietà codProgrammazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProgrammazione(String value) {
        this.codProgrammazione = value;
    }

    /**
     * Recupera il valore della proprietà descLivello1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLivello1() {
        return descLivello1;
    }

    /**
     * Imposta il valore della proprietà descLivello1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLivello1(String value) {
        this.descLivello1 = value;
    }

    /**
     * Recupera il valore della proprietà descLivello2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLivello2() {
        return descLivello2;
    }

    /**
     * Imposta il valore della proprietà descLivello2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLivello2(String value) {
        this.descLivello2 = value;
    }

    /**
     * Recupera il valore della proprietà descLivello3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLivello3() {
        return descLivello3;
    }

    /**
     * Imposta il valore della proprietà descLivello3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLivello3(String value) {
        this.descLivello3 = value;
    }

    /**
     * Recupera il valore della proprietà descLivello4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLivello4() {
        return descLivello4;
    }

    /**
     * Imposta il valore della proprietà descLivello4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLivello4(String value) {
        this.descLivello4 = value;
    }

}
