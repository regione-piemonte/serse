
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
 * <p>Classe Java per domandaInserimentoACatalogoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="domandaInserimentoACatalogoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificativoPSO" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="identificativoSportelloPSO" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreCapofila" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceOperatoreCapofila" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codiceAreaTerritorialeFinanziamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificativoFascia" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numeroDomandaInserimentoACatalogo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoAttivita" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}attivitaDto" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "domandaInserimentoACatalogoDto", propOrder = {
    "identificativoPSO",
    "identificativoSportelloPSO",
    "gruppoOperatoreCapofila",
    "codiceOperatoreCapofila",
    "codiceAreaTerritorialeFinanziamento",
    "identificativoFascia",
    "numeroDomandaInserimentoACatalogo",
    "elencoAttivita",
    "denominazioneAti",
    "titoloDomanda"
})
public class DomandaInserimentoACatalogoDto {

    protected Long identificativoPSO;
    protected Long identificativoSportelloPSO;
    protected String gruppoOperatoreCapofila;
    protected Long codiceOperatoreCapofila;
    protected String codiceAreaTerritorialeFinanziamento;
    protected Long identificativoFascia;
    protected Long numeroDomandaInserimentoACatalogo;
    @XmlElement(nillable = true)
    protected List<AttivitaDto> elencoAttivita;
    protected String denominazioneAti;
    protected String titoloDomanda;

    /**
     * Recupera il valore della proprietà identificativoPSO.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdentificativoPSO() {
        return identificativoPSO;
    }

    /**
     * Imposta il valore della proprietà identificativoPSO.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdentificativoPSO(Long value) {
        this.identificativoPSO = value;
    }

    /**
     * Recupera il valore della proprietà identificativoSportelloPSO.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdentificativoSportelloPSO() {
        return identificativoSportelloPSO;
    }

    /**
     * Imposta il valore della proprietà identificativoSportelloPSO.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdentificativoSportelloPSO(Long value) {
        this.identificativoSportelloPSO = value;
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
     * Recupera il valore della proprietà codiceOperatoreCapofila.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceOperatoreCapofila() {
        return codiceOperatoreCapofila;
    }

    /**
     * Imposta il valore della proprietà codiceOperatoreCapofila.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceOperatoreCapofila(Long value) {
        this.codiceOperatoreCapofila = value;
    }

    /**
     * Recupera il valore della proprietà codiceAreaTerritorialeFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAreaTerritorialeFinanziamento() {
        return codiceAreaTerritorialeFinanziamento;
    }

    /**
     * Imposta il valore della proprietà codiceAreaTerritorialeFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAreaTerritorialeFinanziamento(String value) {
        this.codiceAreaTerritorialeFinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà identificativoFascia.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdentificativoFascia() {
        return identificativoFascia;
    }

    /**
     * Imposta il valore della proprietà identificativoFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdentificativoFascia(Long value) {
        this.identificativoFascia = value;
    }

    /**
     * Recupera il valore della proprietà numeroDomandaInserimentoACatalogo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroDomandaInserimentoACatalogo() {
        return numeroDomandaInserimentoACatalogo;
    }

    /**
     * Imposta il valore della proprietà numeroDomandaInserimentoACatalogo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroDomandaInserimentoACatalogo(Long value) {
        this.numeroDomandaInserimentoACatalogo = value;
    }

    /**
     * Gets the value of the elencoAttivita property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoAttivita property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoAttivita().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttivitaDto }
     * 
     * 
     */
    public List<AttivitaDto> getElencoAttivita() {
        if (elencoAttivita == null) {
            elencoAttivita = new ArrayList<AttivitaDto>();
        }
        return this.elencoAttivita;
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
