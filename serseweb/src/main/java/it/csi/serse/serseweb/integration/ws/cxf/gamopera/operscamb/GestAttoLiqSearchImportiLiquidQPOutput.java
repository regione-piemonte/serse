
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestAttoLiqSearchImportiLiquidQPOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestAttoLiqSearchImportiLiquidQPOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttoAmm" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="totImportoLiquidatoAtto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="totImportoQuietanziatoAtto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="listaImportiImpegni" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}totaliImportiImpegno" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestAttoLiqSearchImportiLiquidQPOutput", propOrder = {
    "idAttoAmm",
    "totImportoLiquidatoAtto",
    "totImportoQuietanziatoAtto",
    "listaImportiImpegni"
})
public class GestAttoLiqSearchImportiLiquidQPOutput {

    protected Long idAttoAmm;
    protected BigDecimal totImportoLiquidatoAtto;
    protected BigDecimal totImportoQuietanziatoAtto;
    @XmlElement(nillable = true)
    protected List<TotaliImportiImpegno> listaImportiImpegni;

    /**
     * Recupera il valore della proprietà idAttoAmm.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttoAmm() {
        return idAttoAmm;
    }

    /**
     * Imposta il valore della proprietà idAttoAmm.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttoAmm(Long value) {
        this.idAttoAmm = value;
    }

    /**
     * Recupera il valore della proprietà totImportoLiquidatoAtto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotImportoLiquidatoAtto() {
        return totImportoLiquidatoAtto;
    }

    /**
     * Imposta il valore della proprietà totImportoLiquidatoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotImportoLiquidatoAtto(BigDecimal value) {
        this.totImportoLiquidatoAtto = value;
    }

    /**
     * Recupera il valore della proprietà totImportoQuietanziatoAtto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotImportoQuietanziatoAtto() {
        return totImportoQuietanziatoAtto;
    }

    /**
     * Imposta il valore della proprietà totImportoQuietanziatoAtto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotImportoQuietanziatoAtto(BigDecimal value) {
        this.totImportoQuietanziatoAtto = value;
    }

    /**
     * Gets the value of the listaImportiImpegni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listaImportiImpegni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaImportiImpegni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotaliImportiImpegno }
     * 
     * 
     */
    public List<TotaliImportiImpegno> getListaImportiImpegni() {
        if (listaImportiImpegni == null) {
            listaImportiImpegni = new ArrayList<TotaliImportiImpegno>();
        }
        return this.listaImportiImpegni;
    }

}
