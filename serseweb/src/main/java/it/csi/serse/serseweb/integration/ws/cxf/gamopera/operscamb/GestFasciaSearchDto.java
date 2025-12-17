
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestFasciaSearchDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestFasciaSearchDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idFascia" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codFascia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descFascia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestFasciaSearchDto", propOrder = {
    "idFascia",
    "codFascia",
    "descFascia"
})
public class GestFasciaSearchDto {

    protected Long idFascia;
    protected String codFascia;
    protected String descFascia;

    /**
     * Recupera il valore della proprietà idFascia.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdFascia() {
        return idFascia;
    }

    /**
     * Imposta il valore della proprietà idFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFascia(Long value) {
        this.idFascia = value;
    }

    /**
     * Recupera il valore della proprietà codFascia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFascia() {
        return codFascia;
    }

    /**
     * Imposta il valore della proprietà codFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFascia(String value) {
        this.codFascia = value;
    }

    /**
     * Recupera il valore della proprietà descFascia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescFascia() {
        return descFascia;
    }

    /**
     * Imposta il valore della proprietà descFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescFascia(String value) {
        this.descFascia = value;
    }

}
