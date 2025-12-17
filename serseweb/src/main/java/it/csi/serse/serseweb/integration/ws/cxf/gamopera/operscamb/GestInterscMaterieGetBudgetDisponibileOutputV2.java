
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
 * <p>Classe Java per gestInterscMaterieGetBudgetDisponibileOutputV2 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieGetBudgetDisponibileOutputV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipologiaBudget" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoOperazioni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idTabFinanziamento" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoClassificazioni" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classTabFinanziamentoBudgetDisponibile" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="esito" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}esitoDto" minOccurs="0"/&gt;
 *         &lt;element name="flagTabFinConsolidata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieGetBudgetDisponibileOutputV2", propOrder = {
    "tipologiaBudget",
    "statoOperazioni",
    "idSportello",
    "idTabFinanziamento",
    "elencoClassificazioni",
    "esito",
    "flagTabFinConsolidata"
})
public class GestInterscMaterieGetBudgetDisponibileOutputV2 {

    protected String tipologiaBudget;
    protected String statoOperazioni;
    protected Long idSportello;
    protected Long idTabFinanziamento;
    @XmlElement(nillable = true)
    protected List<ClassTabFinanziamentoBudgetDisponibile> elencoClassificazioni;
    protected EsitoDto esito;
    protected String flagTabFinConsolidata;

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
     * Recupera il valore della proprietà statoOperazioni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoOperazioni() {
        return statoOperazioni;
    }

    /**
     * Imposta il valore della proprietà statoOperazioni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoOperazioni(String value) {
        this.statoOperazioni = value;
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
     * Recupera il valore della proprietà idTabFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdTabFinanziamento() {
        return idTabFinanziamento;
    }

    /**
     * Imposta il valore della proprietà idTabFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdTabFinanziamento(Long value) {
        this.idTabFinanziamento = value;
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
     * Recupera il valore della proprietà flagTabFinConsolidata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagTabFinConsolidata() {
        return flagTabFinConsolidata;
    }

    /**
     * Imposta il valore della proprietà flagTabFinConsolidata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagTabFinConsolidata(String value) {
        this.flagTabFinConsolidata = value;
    }

}
