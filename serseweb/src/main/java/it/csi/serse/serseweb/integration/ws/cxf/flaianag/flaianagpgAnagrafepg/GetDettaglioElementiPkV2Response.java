
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
 *         &lt;element name="getDettaglioElementiPkV2Return" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}ResultDettaglioElementoDtoV2" minOccurs="0"/&gt;
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
    "getDettaglioElementiPkV2Return"
})
@XmlRootElement(name = "getDettaglioElementiPkV2Response")
public class GetDettaglioElementiPkV2Response {

    protected ResultDettaglioElementoDtoV2 getDettaglioElementiPkV2Return;

    /**
     * Recupera il valore della proprietà getDettaglioElementiPkV2Return.
     * 
     * @return
     *     possible object is
     *     {@link ResultDettaglioElementoDtoV2 }
     *     
     */
    public ResultDettaglioElementoDtoV2 getGetDettaglioElementiPkV2Return() {
        return getDettaglioElementiPkV2Return;
    }

    /**
     * Imposta il valore della proprietà getDettaglioElementiPkV2Return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDettaglioElementoDtoV2 }
     *     
     */
    public void setGetDettaglioElementiPkV2Return(ResultDettaglioElementoDtoV2 value) {
        this.getDettaglioElementiPkV2Return = value;
    }

}
