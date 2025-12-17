
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

package it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per SintesiOperatore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="SintesiOperatore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operatore" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}AkOperatore"/&gt;
 *         &lt;element name="tipoOperatore" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}TipoOperatore"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SintesiOperatore", propOrder = {
    "operatore",
    "tipoOperatore"
})
public class SintesiOperatore {

    @XmlElement(required = true, nillable = true)
    protected AkOperatore operatore;
    @XmlElement(required = true, nillable = true)
    protected TipoOperatore tipoOperatore;

    /**
     * Recupera il valore della proprietà operatore.
     * 
     * @return
     *     possible object is
     *     {@link AkOperatore }
     *     
     */
    public AkOperatore getOperatore() {
        return operatore;
    }

    /**
     * Imposta il valore della proprietà operatore.
     * 
     * @param value
     *     allowed object is
     *     {@link AkOperatore }
     *     
     */
    public void setOperatore(AkOperatore value) {
        this.operatore = value;
    }

    /**
     * Recupera il valore della proprietà tipoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link TipoOperatore }
     *     
     */
    public TipoOperatore getTipoOperatore() {
        return tipoOperatore;
    }

    /**
     * Imposta il valore della proprietà tipoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoOperatore }
     *     
     */
    public void setTipoOperatore(TipoOperatore value) {
        this.tipoOperatore = value;
    }

}
