
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
 * <p>Classe Java per attivitaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="attivitaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annoFormativo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codiceSede" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="classificazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classificazioneDto" minOccurs="0"/&gt;
 *         &lt;element name="elencoVociSpesa" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}voceSpesaDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="elencoFonti" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}fonteDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ripartizioneIter" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parteIterAttuale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoCommittenti" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}committenteDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="numDestinatariAttivita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="durataAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attivitaDto", propOrder = {
    "idAttivitaMateria",
    "denominazioneAttivita",
    "annoFormativo",
    "gruppoSoggettoAttuatore",
    "codiceSoggettoAttuatore",
    "codiceSede",
    "classificazione",
    "elencoVociSpesa",
    "elencoFonti",
    "ripartizioneIter",
    "parteIterAttuale",
    "elencoCommittenti",
    "numDestinatariAttivita",
    "durataAttivita"
})
public class AttivitaDto {

    protected Long idAttivitaMateria;
    protected String denominazioneAttivita;
    protected Long annoFormativo;
    protected String gruppoSoggettoAttuatore;
    protected Long codiceSoggettoAttuatore;
    protected Long codiceSede;
    protected ClassificazioneDto classificazione;
    @XmlElement(nillable = true)
    protected List<VoceSpesaDto> elencoVociSpesa;
    @XmlElement(nillable = true)
    protected List<FonteDto> elencoFonti;
    protected Long ripartizioneIter;
    protected Long parteIterAttuale;
    @XmlElement(nillable = true)
    protected List<CommittenteDto> elencoCommittenti;
    protected Long numDestinatariAttivita;
    protected BigDecimal durataAttivita;

    /**
     * Recupera il valore della proprietà idAttivitaMateria.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivitaMateria() {
        return idAttivitaMateria;
    }

    /**
     * Imposta il valore della proprietà idAttivitaMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivitaMateria(Long value) {
        this.idAttivitaMateria = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneAttivita() {
        return denominazioneAttivita;
    }

    /**
     * Imposta il valore della proprietà denominazioneAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneAttivita(String value) {
        this.denominazioneAttivita = value;
    }

    /**
     * Recupera il valore della proprietà annoFormativo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnoFormativo() {
        return annoFormativo;
    }

    /**
     * Imposta il valore della proprietà annoFormativo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnoFormativo(Long value) {
        this.annoFormativo = value;
    }

    /**
     * Recupera il valore della proprietà gruppoSoggettoAttuatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoSoggettoAttuatore() {
        return gruppoSoggettoAttuatore;
    }

    /**
     * Imposta il valore della proprietà gruppoSoggettoAttuatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoSoggettoAttuatore(String value) {
        this.gruppoSoggettoAttuatore = value;
    }

    /**
     * Recupera il valore della proprietà codiceSoggettoAttuatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceSoggettoAttuatore() {
        return codiceSoggettoAttuatore;
    }

    /**
     * Imposta il valore della proprietà codiceSoggettoAttuatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceSoggettoAttuatore(Long value) {
        this.codiceSoggettoAttuatore = value;
    }

    /**
     * Recupera il valore della proprietà codiceSede.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceSede() {
        return codiceSede;
    }

    /**
     * Imposta il valore della proprietà codiceSede.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceSede(Long value) {
        this.codiceSede = value;
    }

    /**
     * Recupera il valore della proprietà classificazione.
     * 
     * @return
     *     possible object is
     *     {@link ClassificazioneDto }
     *     
     */
    public ClassificazioneDto getClassificazione() {
        return classificazione;
    }

    /**
     * Imposta il valore della proprietà classificazione.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificazioneDto }
     *     
     */
    public void setClassificazione(ClassificazioneDto value) {
        this.classificazione = value;
    }

    /**
     * Gets the value of the elencoVociSpesa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoVociSpesa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoVociSpesa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoceSpesaDto }
     * 
     * 
     */
    public List<VoceSpesaDto> getElencoVociSpesa() {
        if (elencoVociSpesa == null) {
            elencoVociSpesa = new ArrayList<VoceSpesaDto>();
        }
        return this.elencoVociSpesa;
    }

    /**
     * Gets the value of the elencoFonti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoFonti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoFonti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FonteDto }
     * 
     * 
     */
    public List<FonteDto> getElencoFonti() {
        if (elencoFonti == null) {
            elencoFonti = new ArrayList<FonteDto>();
        }
        return this.elencoFonti;
    }

    /**
     * Recupera il valore della proprietà ripartizioneIter.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRipartizioneIter() {
        return ripartizioneIter;
    }

    /**
     * Imposta il valore della proprietà ripartizioneIter.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRipartizioneIter(Long value) {
        this.ripartizioneIter = value;
    }

    /**
     * Recupera il valore della proprietà parteIterAttuale.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParteIterAttuale() {
        return parteIterAttuale;
    }

    /**
     * Imposta il valore della proprietà parteIterAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParteIterAttuale(Long value) {
        this.parteIterAttuale = value;
    }

    /**
     * Gets the value of the elencoCommittenti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoCommittenti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoCommittenti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommittenteDto }
     * 
     * 
     */
    public List<CommittenteDto> getElencoCommittenti() {
        if (elencoCommittenti == null) {
            elencoCommittenti = new ArrayList<CommittenteDto>();
        }
        return this.elencoCommittenti;
    }

    /**
     * Recupera il valore della proprietà numDestinatariAttivita.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumDestinatariAttivita() {
        return numDestinatariAttivita;
    }

    /**
     * Imposta il valore della proprietà numDestinatariAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumDestinatariAttivita(Long value) {
        this.numDestinatariAttivita = value;
    }

    /**
     * Recupera il valore della proprietà durataAttivita.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurataAttivita() {
        return durataAttivita;
    }

    /**
     * Imposta il valore della proprietà durataAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurataAttivita(BigDecimal value) {
        this.durataAttivita = value;
    }

}
