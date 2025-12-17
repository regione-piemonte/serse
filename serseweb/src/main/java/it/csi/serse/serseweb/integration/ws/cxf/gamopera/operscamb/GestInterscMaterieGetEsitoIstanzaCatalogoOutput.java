
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
 * <p>Classe Java per gestInterscMaterieGetEsitoIstanzaCatalogoOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieGetEsitoIstanzaCatalogoOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nrTicket" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codStatoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioStatoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codEsito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descEsito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="elencoOperazioni" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}getEsitoIstanzaCatalogoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieGetEsitoIstanzaCatalogoOutput", propOrder = {
    "nrTicket",
    "idSportello",
    "idDomanda",
    "idSoggettoFinanziato",
    "codStatoRichiesta",
    "messaggioStatoRichiesta",
    "codEsito",
    "descEsito",
    "elencoOperazioni"
})
public class GestInterscMaterieGetEsitoIstanzaCatalogoOutput {

    protected Long nrTicket;
    protected Long idSportello;
    protected Long idDomanda;
    protected Long idSoggettoFinanziato;
    protected String codStatoRichiesta;
    protected String messaggioStatoRichiesta;
    protected String codEsito;
    protected String descEsito;
    @XmlElement(nillable = true)
    protected List<GetEsitoIstanzaCatalogoDto> elencoOperazioni;

    /**
     * Recupera il valore della proprietà nrTicket.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNrTicket() {
        return nrTicket;
    }

    /**
     * Imposta il valore della proprietà nrTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNrTicket(Long value) {
        this.nrTicket = value;
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
     * Recupera il valore della proprietà idSoggettoFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSoggettoFinanziato() {
        return idSoggettoFinanziato;
    }

    /**
     * Imposta il valore della proprietà idSoggettoFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSoggettoFinanziato(Long value) {
        this.idSoggettoFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà codStatoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodStatoRichiesta() {
        return codStatoRichiesta;
    }

    /**
     * Imposta il valore della proprietà codStatoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodStatoRichiesta(String value) {
        this.codStatoRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà messaggioStatoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessaggioStatoRichiesta() {
        return messaggioStatoRichiesta;
    }

    /**
     * Imposta il valore della proprietà messaggioStatoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessaggioStatoRichiesta(String value) {
        this.messaggioStatoRichiesta = value;
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
     * Gets the value of the elencoOperazioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoOperazioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoOperazioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetEsitoIstanzaCatalogoDto }
     * 
     * 
     */
    public List<GetEsitoIstanzaCatalogoDto> getElencoOperazioni() {
        if (elencoOperazioni == null) {
            elencoOperazioni = new ArrayList<GetEsitoIstanzaCatalogoDto>();
        }
        return this.elencoOperazioni;
    }

}
