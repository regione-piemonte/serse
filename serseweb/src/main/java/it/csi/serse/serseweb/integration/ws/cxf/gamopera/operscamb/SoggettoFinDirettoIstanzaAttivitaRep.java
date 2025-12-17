
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
 * <p>Classe Java per soggettoFinDirettoIstanzaAttivitaRep complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="soggettoFinDirettoIstanzaAttivitaRep"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numeroDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreCapofila" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreCapofila" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoAttuatori" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}attuatoreFinDirettoIstanzaAttivitaRep" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="elencoSedi" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}sedeFinDirettoIstanzaAttivitaRep" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneAti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titoloDomanda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soggettoFinDirettoIstanzaAttivitaRep", propOrder = {
    "idSportello",
    "numeroDomanda",
    "gruppoOperatoreCapofila",
    "codOperatoreCapofila",
    "elencoAttuatori",
    "elencoSedi",
    "denominazioneAti",
    "titoloDomanda"
})
public class SoggettoFinDirettoIstanzaAttivitaRep {

    protected Long idSportello;
    protected Long numeroDomanda;
    protected String gruppoOperatoreCapofila;
    protected Long codOperatoreCapofila;
    @XmlElement(nillable = true)
    protected List<AttuatoreFinDirettoIstanzaAttivitaRep> elencoAttuatori;
    @XmlElement(nillable = true)
    protected List<SedeFinDirettoIstanzaAttivitaRep> elencoSedi;
    protected String denominazioneAti;
    protected String titoloDomanda;

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
     * Recupera il valore della proprietà numeroDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroDomanda() {
        return numeroDomanda;
    }

    /**
     * Imposta il valore della proprietà numeroDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroDomanda(Long value) {
        this.numeroDomanda = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreCapofila.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreCapofila() {
        return gruppoOperatoreCapofila;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreCapofila.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreCapofila(String value) {
        this.gruppoOperatoreCapofila = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreCapofila.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatoreCapofila() {
        return codOperatoreCapofila;
    }

    /**
     * Imposta il valore della proprietà codOperatoreCapofila.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatoreCapofila(Long value) {
        this.codOperatoreCapofila = value;
    }

    /**
     * Gets the value of the elencoAttuatori property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoAttuatori property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoAttuatori().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttuatoreFinDirettoIstanzaAttivitaRep }
     * 
     * 
     */
    public List<AttuatoreFinDirettoIstanzaAttivitaRep> getElencoAttuatori() {
        if (elencoAttuatori == null) {
            elencoAttuatori = new ArrayList<AttuatoreFinDirettoIstanzaAttivitaRep>();
        }
        return this.elencoAttuatori;
    }

    /**
     * Gets the value of the elencoSedi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoSedi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoSedi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SedeFinDirettoIstanzaAttivitaRep }
     * 
     * 
     */
    public List<SedeFinDirettoIstanzaAttivitaRep> getElencoSedi() {
        if (elencoSedi == null) {
            elencoSedi = new ArrayList<SedeFinDirettoIstanzaAttivitaRep>();
        }
        return this.elencoSedi;
    }

    /**
     * Recupera il valore della proprietà denominazioneAti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneAti() {
        return denominazioneAti;
    }

    /**
     * Imposta il valore della proprietà denominazioneAti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneAti(String value) {
        this.denominazioneAti = value;
    }

    /**
     * Recupera il valore della proprietà titoloDomanda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitoloDomanda() {
        return titoloDomanda;
    }

    /**
     * Imposta il valore della proprietà titoloDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitoloDomanda(String value) {
        this.titoloDomanda = value;
    }

}
