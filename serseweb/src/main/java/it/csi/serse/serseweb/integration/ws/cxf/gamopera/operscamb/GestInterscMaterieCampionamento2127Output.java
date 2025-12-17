
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
 * <p>Classe Java per gestInterscMaterieCampionamento2127Output complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieCampionamento2127Output"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esito" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}esitoDto" minOccurs="0"/&gt;
 *         &lt;element name="idUc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idOperazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tipoControllo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nrAttivitaCampione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="elencoAttivitaAttuazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}attivitaAttuazioneDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="elencoAttivitaGestione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}attivitaGestioneDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieCampionamento2127Output", propOrder = {
    "esito",
    "idUc",
    "idOperazione",
    "tipoControllo",
    "nrAttivitaCampione",
    "tipoAttivita",
    "elencoAttivitaAttuazione",
    "elencoAttivitaGestione"
})
public class GestInterscMaterieCampionamento2127Output {

    protected EsitoDto esito;
    protected Long idUc;
    protected Long idOperazione;
    protected String tipoControllo;
    protected Long nrAttivitaCampione;
    protected String tipoAttivita;
    @XmlElement(nillable = true)
    protected List<AttivitaAttuazioneDto> elencoAttivitaAttuazione;
    @XmlElement(nillable = true)
    protected List<AttivitaGestioneDto> elencoAttivitaGestione;

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
     * Recupera il valore della proprietà idUc.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdUc() {
        return idUc;
    }

    /**
     * Imposta il valore della proprietà idUc.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdUc(Long value) {
        this.idUc = value;
    }

    /**
     * Recupera il valore della proprietà idOperazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdOperazione() {
        return idOperazione;
    }

    /**
     * Imposta il valore della proprietà idOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdOperazione(Long value) {
        this.idOperazione = value;
    }

    /**
     * Recupera il valore della proprietà tipoControllo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoControllo() {
        return tipoControllo;
    }

    /**
     * Imposta il valore della proprietà tipoControllo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoControllo(String value) {
        this.tipoControllo = value;
    }

    /**
     * Recupera il valore della proprietà nrAttivitaCampione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNrAttivitaCampione() {
        return nrAttivitaCampione;
    }

    /**
     * Imposta il valore della proprietà nrAttivitaCampione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNrAttivitaCampione(Long value) {
        this.nrAttivitaCampione = value;
    }

    /**
     * Recupera il valore della proprietà tipoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAttivita() {
        return tipoAttivita;
    }

    /**
     * Imposta il valore della proprietà tipoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAttivita(String value) {
        this.tipoAttivita = value;
    }

    /**
     * Gets the value of the elencoAttivitaAttuazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoAttivitaAttuazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoAttivitaAttuazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttivitaAttuazioneDto }
     * 
     * 
     */
    public List<AttivitaAttuazioneDto> getElencoAttivitaAttuazione() {
        if (elencoAttivitaAttuazione == null) {
            elencoAttivitaAttuazione = new ArrayList<AttivitaAttuazioneDto>();
        }
        return this.elencoAttivitaAttuazione;
    }

    /**
     * Gets the value of the elencoAttivitaGestione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoAttivitaGestione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoAttivitaGestione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttivitaGestioneDto }
     * 
     * 
     */
    public List<AttivitaGestioneDto> getElencoAttivitaGestione() {
        if (elencoAttivitaGestione == null) {
            elencoAttivitaGestione = new ArrayList<AttivitaGestioneDto>();
        }
        return this.elencoAttivitaGestione;
    }

}
