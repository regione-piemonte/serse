
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

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestAttivitaSearchDestinatariAttivitaOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestAttivitaSearchDestinatariAttivitaOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nrOccorrenzerestituite" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="listOperazioni" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}destinatariAttivitaOperDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestAttivitaSearchDestinatariAttivitaOutput", propOrder = {
    "nrOccorrenzerestituite",
    "listOperazioni"
})
public class GestAttivitaSearchDestinatariAttivitaOutput {

    protected Long nrOccorrenzerestituite;
    @XmlElement(nillable = true)
    protected List<DestinatariAttivitaOperDto> listOperazioni;

    /**
     * Recupera il valore della proprietà nrOccorrenzerestituite.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNrOccorrenzerestituite() {
        return nrOccorrenzerestituite;
    }

    /**
     * Imposta il valore della proprietà nrOccorrenzerestituite.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNrOccorrenzerestituite(Long value) {
        this.nrOccorrenzerestituite = value;
    }

    /**
     * Gets the value of the listOperazioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listOperazioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOperazioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DestinatariAttivitaOperDto }
     * 
     * 
     */
    public List<DestinatariAttivitaOperDto> getListOperazioni() {
        if (listOperazioni == null) {
            listOperazioni = new ArrayList<DestinatariAttivitaOperDto>();
        }
        return this.listOperazioni;
    }

}
