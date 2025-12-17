
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
 * <p>Classe Java per gestInterscMaterieGetBDGTDisponibileSFInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieGetBDGTDisponibileSFInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipologiaBudget" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSoggFin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codAnagraficoSoggFin" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}gestInterscMaterieCodAnagraficoSFDto" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieGetBDGTDisponibileSFInput", propOrder = {
    "tipologiaBudget",
    "idPso",
    "idSportello",
    "idSoggFin",
    "codAnagraficoSoggFin"
})
public class GestInterscMaterieGetBDGTDisponibileSFInput {

    protected String tipologiaBudget;
    protected Long idPso;
    protected Long idSportello;
    protected Long idSoggFin;
    protected GestInterscMaterieCodAnagraficoSFDto codAnagraficoSoggFin;

    /**
     * Recupera il valore della proprietà tipologiaBudget.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologiaBudget() {
        return tipologiaBudget;
    }

    /**
     * Imposta il valore della proprietà tipologiaBudget.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologiaBudget(String value) {
        this.tipologiaBudget = value;
    }

    /**
     * Recupera il valore della proprietà idPso.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPso() {
        return idPso;
    }

    /**
     * Imposta il valore della proprietà idPso.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPso(Long value) {
        this.idPso = value;
    }

    /**
     * Recupera il valore della proprietà idSportello.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSportello() {
        return idSportello;
    }

    /**
     * Imposta il valore della proprietà idSportello.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSportello(Long value) {
        this.idSportello = value;
    }

    /**
     * Recupera il valore della proprietà idSoggFin.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSoggFin() {
        return idSoggFin;
    }

    /**
     * Imposta il valore della proprietà idSoggFin.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSoggFin(Long value) {
        this.idSoggFin = value;
    }

    /**
     * Recupera il valore della proprietà codAnagraficoSoggFin.
     * 
     * @return
     *     possible object is
     *     {@link GestInterscMaterieCodAnagraficoSFDto }
     *     
     */
    public GestInterscMaterieCodAnagraficoSFDto getCodAnagraficoSoggFin() {
        return codAnagraficoSoggFin;
    }

    /**
     * Imposta il valore della proprietà codAnagraficoSoggFin.
     * 
     * @param value
     *     allowed object is
     *     {@link GestInterscMaterieCodAnagraficoSFDto }
     *     
     */
    public void setCodAnagraficoSoggFin(GestInterscMaterieCodAnagraficoSFDto value) {
        this.codAnagraficoSoggFin = value;
    }

}
