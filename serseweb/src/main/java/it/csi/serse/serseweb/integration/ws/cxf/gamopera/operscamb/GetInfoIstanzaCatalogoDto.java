
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
 * <p>Classe Java per getInfoIstanzaCatalogoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getInfoIstanzaCatalogoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codEsito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descEsito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoIterAutorizzazioneOperazioni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="elencoDetAutorizzazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}infoIstanzaCatalogoDatiAttoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInfoIstanzaCatalogoDto", propOrder = {
    "idSportello",
    "idDomanda",
    "codEsito",
    "descEsito",
    "statoIterAutorizzazioneOperazioni",
    "elencoDetAutorizzazione"
})
public class GetInfoIstanzaCatalogoDto {

    protected Long idSportello;
    protected Long idDomanda;
    protected String codEsito;
    protected String descEsito;
    protected String statoIterAutorizzazioneOperazioni;
    @XmlElement(nillable = true)
    protected List<InfoIstanzaCatalogoDatiAttoDto> elencoDetAutorizzazione;

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
     * Recupera il valore della proprietà idDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDomanda() {
        return idDomanda;
    }

    /**
     * Imposta il valore della proprietà idDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDomanda(Long value) {
        this.idDomanda = value;
    }

    /**
     * Recupera il valore della proprietà codEsito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEsito() {
        return codEsito;
    }

    /**
     * Imposta il valore della proprietà codEsito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEsito(String value) {
        this.codEsito = value;
    }

    /**
     * Recupera il valore della proprietà descEsito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEsito() {
        return descEsito;
    }

    /**
     * Imposta il valore della proprietà descEsito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEsito(String value) {
        this.descEsito = value;
    }

    /**
     * Recupera il valore della proprietà statoIterAutorizzazioneOperazioni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoIterAutorizzazioneOperazioni() {
        return statoIterAutorizzazioneOperazioni;
    }

    /**
     * Imposta il valore della proprietà statoIterAutorizzazioneOperazioni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoIterAutorizzazioneOperazioni(String value) {
        this.statoIterAutorizzazioneOperazioni = value;
    }

    /**
     * Gets the value of the elencoDetAutorizzazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoDetAutorizzazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoDetAutorizzazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfoIstanzaCatalogoDatiAttoDto }
     * 
     * 
     */
    public List<InfoIstanzaCatalogoDatiAttoDto> getElencoDetAutorizzazione() {
        if (elencoDetAutorizzazione == null) {
            elencoDetAutorizzazione = new ArrayList<InfoIstanzaCatalogoDatiAttoDto>();
        }
        return this.elencoDetAutorizzazione;
    }

}
