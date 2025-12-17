
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
 * <p>Classe Java per gestInterscMaterieGetBDGTDisponibileSFOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieGetBDGTDisponibileSFOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esito" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}esitoDto" minOccurs="0"/&gt;
 *         &lt;element name="tipologiaBudget" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportelloBudget" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codAnagraficoSoggFin" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}gestInterscMaterieCodAnagraficoSFDto" minOccurs="0"/&gt;
 *         &lt;element name="elencoClassificazioni" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classTabFinanziamentoBudgetDisponibile" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="idSoggFin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieGetBDGTDisponibileSFOutput", propOrder = {
    "esito",
    "tipologiaBudget",
    "idSportello",
    "idSportelloBudget",
    "codAnagraficoSoggFin",
    "elencoClassificazioni",
    "idSoggFin"
})
public class GestInterscMaterieGetBDGTDisponibileSFOutput {

    protected EsitoDto esito;
    protected String tipologiaBudget;
    protected Long idSportello;
    protected Long idSportelloBudget;
    protected GestInterscMaterieCodAnagraficoSFDto codAnagraficoSoggFin;
    @XmlElement(nillable = true)
    protected List<ClassTabFinanziamentoBudgetDisponibile> elencoClassificazioni;
    protected Long idSoggFin;

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link EsitoDto }
     *     
     */
    public EsitoDto getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link EsitoDto }
     *     
     */
    public void setEsito(EsitoDto value) {
        this.esito = value;
    }

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
     * Recupera il valore della proprietà idSportelloBudget.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSportelloBudget() {
        return idSportelloBudget;
    }

    /**
     * Imposta il valore della proprietà idSportelloBudget.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSportelloBudget(Long value) {
        this.idSportelloBudget = value;
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

    /**
     * Gets the value of the elencoClassificazioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoClassificazioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoClassificazioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassTabFinanziamentoBudgetDisponibile }
     * 
     * 
     */
    public List<ClassTabFinanziamentoBudgetDisponibile> getElencoClassificazioni() {
        if (elencoClassificazioni == null) {
            elencoClassificazioni = new ArrayList<ClassTabFinanziamentoBudgetDisponibile>();
        }
        return this.elencoClassificazioni;
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

}
