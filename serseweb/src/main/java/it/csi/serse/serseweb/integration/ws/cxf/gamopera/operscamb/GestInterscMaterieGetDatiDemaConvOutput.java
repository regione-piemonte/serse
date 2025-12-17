
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
 * <p>Classe Java per gestInterscMaterieGetDatiDemaConvOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieGetDatiDemaConvOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esito" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}esitoDto" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codOperatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoDatiAggiuntivi" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}datoAggiuntivoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieGetDatiDemaConvOutput", propOrder = {
    "esito",
    "idPso",
    "idSportello",
    "codOperatore",
    "gruppoOperatore",
    "numDomanda",
    "elencoDatiAggiuntivi"
})
public class GestInterscMaterieGetDatiDemaConvOutput {

    protected EsitoDto esito;
    protected Long idPso;
    protected Long idSportello;
    protected Long codOperatore;
    protected String gruppoOperatore;
    protected Long numDomanda;
    @XmlElement(nillable = true)
    protected List<DatoAggiuntivoDto> elencoDatiAggiuntivi;

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
     * Recupera il valore della proprietà codOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatore() {
        return codOperatore;
    }

    /**
     * Imposta il valore della proprietà codOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatore(Long value) {
        this.codOperatore = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatore() {
        return gruppoOperatore;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatore(String value) {
        this.gruppoOperatore = value;
    }

    /**
     * Recupera il valore della proprietà numDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumDomanda() {
        return numDomanda;
    }

    /**
     * Imposta il valore della proprietà numDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumDomanda(Long value) {
        this.numDomanda = value;
    }

    /**
     * Gets the value of the elencoDatiAggiuntivi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoDatiAggiuntivi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoDatiAggiuntivi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatoAggiuntivoDto }
     * 
     * 
     */
    public List<DatoAggiuntivoDto> getElencoDatiAggiuntivi() {
        if (elencoDatiAggiuntivi == null) {
            elencoDatiAggiuntivi = new ArrayList<DatoAggiuntivoDto>();
        }
        return this.elencoDatiAggiuntivi;
    }

}
