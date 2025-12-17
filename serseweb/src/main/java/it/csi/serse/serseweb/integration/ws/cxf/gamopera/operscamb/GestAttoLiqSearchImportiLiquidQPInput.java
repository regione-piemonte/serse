
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
 * <p>Classe Java per gestAttoLiqSearchImportiLiquidQPInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestAttoLiqSearchImportiLiquidQPInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttoIndirizzo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codCicloFinanz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPsoGam" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="listaIdAttoAmm" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestAttoLiqSearchImportiLiquidQPInput", propOrder = {
    "idAttoIndirizzo",
    "codCicloFinanz",
    "idPsoGam",
    "listaIdAttoAmm"
})
public class GestAttoLiqSearchImportiLiquidQPInput {

    protected Long idAttoIndirizzo;
    protected String codCicloFinanz;
    protected Long idPsoGam;
    @XmlElement(type = Long.class)
    protected List<Long> listaIdAttoAmm;

    /**
     * Recupera il valore della proprietà idAttoIndirizzo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttoIndirizzo() {
        return idAttoIndirizzo;
    }

    /**
     * Imposta il valore della proprietà idAttoIndirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttoIndirizzo(Long value) {
        this.idAttoIndirizzo = value;
    }

    /**
     * Recupera il valore della proprietà codCicloFinanz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCicloFinanz() {
        return codCicloFinanz;
    }

    /**
     * Imposta il valore della proprietà codCicloFinanz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCicloFinanz(String value) {
        this.codCicloFinanz = value;
    }

    /**
     * Recupera il valore della proprietà idPsoGam.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPsoGam() {
        return idPsoGam;
    }

    /**
     * Imposta il valore della proprietà idPsoGam.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPsoGam(Long value) {
        this.idPsoGam = value;
    }

    /**
     * Gets the value of the listaIdAttoAmm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listaIdAttoAmm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaIdAttoAmm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getListaIdAttoAmm() {
        if (listaIdAttoAmm == null) {
            listaIdAttoAmm = new ArrayList<Long>();
        }
        return this.listaIdAttoAmm;
    }

}
