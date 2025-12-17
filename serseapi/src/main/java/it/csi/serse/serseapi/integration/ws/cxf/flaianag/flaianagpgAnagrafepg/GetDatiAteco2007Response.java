
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

package it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="getDatiAteco2007Return" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}ResultAteco2007" minOccurs="0"/&gt;
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
    "getDatiAteco2007Return"
})
@XmlRootElement(name = "getDatiAteco2007Response")
public class GetDatiAteco2007Response {

    protected ResultAteco2007 getDatiAteco2007Return;

    /**
     * Recupera il valore della proprietà getDatiAteco2007Return.
     * 
     * @return
     *     possible object is
     *     {@link ResultAteco2007 }
     *     
     */
    public ResultAteco2007 getGetDatiAteco2007Return() {
        return getDatiAteco2007Return;
    }

    /**
     * Imposta il valore della proprietà getDatiAteco2007Return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultAteco2007 }
     *     
     */
    public void setGetDatiAteco2007Return(ResultAteco2007 value) {
        this.getDatiAteco2007Return = value;
    }

}
