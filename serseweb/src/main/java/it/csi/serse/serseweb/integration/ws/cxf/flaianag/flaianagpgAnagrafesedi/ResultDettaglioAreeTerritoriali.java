
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

package it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ResultDettaglioAreeTerritoriali complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ResultDettaglioAreeTerritoriali"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dettaglioAreeTerritoriali" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}ArrayOfDettaglioAreaTerritoriale"/&gt;
 *         &lt;element name="resultMessage" type="{http://anagrafesedipg.interfacecsi.flaianagpg.flaianag.csi.it/}ResultMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultDettaglioAreeTerritoriali", propOrder = {
    "dettaglioAreeTerritoriali",
    "resultMessage"
})
public class ResultDettaglioAreeTerritoriali {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfDettaglioAreaTerritoriale dettaglioAreeTerritoriali;
    @XmlElement(required = true, nillable = true)
    protected ResultMessage resultMessage;

    /**
     * Recupera il valore della proprietà dettaglioAreeTerritoriali.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDettaglioAreaTerritoriale }
     *     
     */
    public ArrayOfDettaglioAreaTerritoriale getDettaglioAreeTerritoriali() {
        return dettaglioAreeTerritoriali;
    }

    /**
     * Imposta il valore della proprietà dettaglioAreeTerritoriali.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDettaglioAreaTerritoriale }
     *     
     */
    public void setDettaglioAreeTerritoriali(ArrayOfDettaglioAreaTerritoriale value) {
        this.dettaglioAreeTerritoriali = value;
    }

    /**
     * Recupera il valore della proprietà resultMessage.
     * 
     * @return
     *     possible object is
     *     {@link ResultMessage }
     *     
     */
    public ResultMessage getResultMessage() {
        return resultMessage;
    }

    /**
     * Imposta il valore della proprietà resultMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultMessage }
     *     
     */
    public void setResultMessage(ResultMessage value) {
        this.resultMessage = value;
    }

}
