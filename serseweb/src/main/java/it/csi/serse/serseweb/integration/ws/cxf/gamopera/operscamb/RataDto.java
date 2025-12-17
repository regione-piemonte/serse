
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
 * <p>Classe Java per rataDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="rataDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chiaveUtenteAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSoggFin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="progressivo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="annoGestione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idRata" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codTipolRata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="progressivoRata" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="importoTotaleRata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="flgTipolRata" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="flgRataLiquidata" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoQuotePerFonte" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}quoteFonteRataDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="elencoQuotePerOperazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}quoteFonteOperazioneDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rataDto", propOrder = {
    "chiaveUtenteAutorizzazione",
    "idAutorizzazione",
    "idSoggFin",
    "idSportello",
    "gruppoOperatore",
    "codOperatore",
    "progressivo",
    "annoGestione",
    "idRata",
    "codTipolRata",
    "progressivoRata",
    "importoTotaleRata",
    "flgTipolRata",
    "flgRataLiquidata",
    "elencoQuotePerFonte",
    "elencoQuotePerOperazione"
})
public class RataDto {

    protected String chiaveUtenteAutorizzazione;
    protected Long idAutorizzazione;
    protected Long idSoggFin;
    protected Long idSportello;
    protected String gruppoOperatore;
    protected Long codOperatore;
    protected Long progressivo;
    protected Long annoGestione;
    protected Long idRata;
    protected String codTipolRata;
    protected Long progressivoRata;
    protected BigDecimal importoTotaleRata;
    protected Long flgTipolRata;
    protected Long flgRataLiquidata;
    @XmlElement(nillable = true)
    protected List<QuoteFonteRataDto> elencoQuotePerFonte;
    @XmlElement(nillable = true)
    protected List<QuoteFonteOperazioneDto> elencoQuotePerOperazione;

    /**
     * Recupera il valore della proprietà chiaveUtenteAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChiaveUtenteAutorizzazione() {
        return chiaveUtenteAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà chiaveUtenteAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChiaveUtenteAutorizzazione(String value) {
        this.chiaveUtenteAutorizzazione = value;
    }

    /**
     * Recupera il valore della proprietà idAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAutorizzazione() {
        return idAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà idAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAutorizzazione(Long value) {
        this.idAutorizzazione = value;
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
     * Recupera il valore della proprietà progressivo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProgressivo() {
        return progressivo;
    }

    /**
     * Imposta il valore della proprietà progressivo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProgressivo(Long value) {
        this.progressivo = value;
    }

    /**
     * Recupera il valore della proprietà annoGestione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnoGestione() {
        return annoGestione;
    }

    /**
     * Imposta il valore della proprietà annoGestione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnoGestione(Long value) {
        this.annoGestione = value;
    }

    /**
     * Recupera il valore della proprietà idRata.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdRata() {
        return idRata;
    }

    /**
     * Imposta il valore della proprietà idRata.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdRata(Long value) {
        this.idRata = value;
    }

    /**
     * Recupera il valore della proprietà codTipolRata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipolRata() {
        return codTipolRata;
    }

    /**
     * Imposta il valore della proprietà codTipolRata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipolRata(String value) {
        this.codTipolRata = value;
    }

    /**
     * Recupera il valore della proprietà progressivoRata.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProgressivoRata() {
        return progressivoRata;
    }

    /**
     * Imposta il valore della proprietà progressivoRata.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProgressivoRata(Long value) {
        this.progressivoRata = value;
    }

    /**
     * Recupera il valore della proprietà importoTotaleRata.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoTotaleRata() {
        return importoTotaleRata;
    }

    /**
     * Imposta il valore della proprietà importoTotaleRata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoTotaleRata(BigDecimal value) {
        this.importoTotaleRata = value;
    }

    /**
     * Recupera il valore della proprietà flgTipolRata.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlgTipolRata() {
        return flgTipolRata;
    }

    /**
     * Imposta il valore della proprietà flgTipolRata.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlgTipolRata(Long value) {
        this.flgTipolRata = value;
    }

    /**
     * Recupera il valore della proprietà flgRataLiquidata.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlgRataLiquidata() {
        return flgRataLiquidata;
    }

    /**
     * Imposta il valore della proprietà flgRataLiquidata.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlgRataLiquidata(Long value) {
        this.flgRataLiquidata = value;
    }

    /**
     * Gets the value of the elencoQuotePerFonte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoQuotePerFonte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoQuotePerFonte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuoteFonteRataDto }
     * 
     * 
     */
    public List<QuoteFonteRataDto> getElencoQuotePerFonte() {
        if (elencoQuotePerFonte == null) {
            elencoQuotePerFonte = new ArrayList<QuoteFonteRataDto>();
        }
        return this.elencoQuotePerFonte;
    }

    /**
     * Gets the value of the elencoQuotePerOperazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoQuotePerOperazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoQuotePerOperazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuoteFonteOperazioneDto }
     * 
     * 
     */
    public List<QuoteFonteOperazioneDto> getElencoQuotePerOperazione() {
        if (elencoQuotePerOperazione == null) {
            elencoQuotePerOperazione = new ArrayList<QuoteFonteOperazioneDto>();
        }
        return this.elencoQuotePerOperazione;
    }

}
