
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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per verificaBudgetImpegnoConsumoInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="verificaBudgetImpegnoConsumoInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codOperatoreSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="classificazioneInterventoApprovato" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classificazioneInterventoApprovato" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idSportelloPso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dataRichiesta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="numeroDestinatari" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoPadreMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoInterventoApprovatoPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="durata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codSottoTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="capoFila" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="elencoDestinatari" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}verificaBudgetImpegnoDestinatarioDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="codAreaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subCodiceSede" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificaBudgetImpegnoConsumoInput", propOrder = {
    "codTipoMateria",
    "codOperatoreSoggFinanziato",
    "gruppoOperatoreSoggFinanziato",
    "idInterventoApprovatoMateria",
    "codTipoInterventoApprovato",
    "classificazioneInterventoApprovato",
    "idPso",
    "idSportelloPso",
    "codTipoRichiesta",
    "dataRichiesta",
    "numeroDestinatari",
    "idInterventoApprovatoPadreMateria",
    "codTipoInterventoApprovatoPadre",
    "durata",
    "codTipologiaServizio",
    "codSottoTipologiaServizio",
    "capoFila",
    "elencoDestinatari",
    "codAreaTerritoriale",
    "subCodiceSede",
    "gruppoSoggettoAttuatore",
    "codiceSoggettoAttuatore"
})
public class VerificaBudgetImpegnoConsumoInput {

    @XmlElement(required = true)
    protected String codTipoMateria;
    protected BigDecimal codOperatoreSoggFinanziato;
    protected String gruppoOperatoreSoggFinanziato;
    protected BigDecimal idInterventoApprovatoMateria;
    protected String codTipoInterventoApprovato;
    protected ClassificazioneInterventoApprovato classificazioneInterventoApprovato;
    protected BigDecimal idPso;
    protected BigDecimal idSportelloPso;
    @XmlElement(required = true)
    protected String codTipoRichiesta;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRichiesta;
    protected BigDecimal numeroDestinatari;
    protected BigDecimal idInterventoApprovatoPadreMateria;
    protected String codTipoInterventoApprovatoPadre;
    protected BigDecimal durata;
    protected String codTipologiaServizio;
    protected BigDecimal codSottoTipologiaServizio;
    protected Integer capoFila;
    @XmlElement(nillable = true)
    protected List<VerificaBudgetImpegnoDestinatarioDto> elencoDestinatari;
    protected String codAreaTerritoriale;
    protected BigDecimal subCodiceSede;
    protected String gruppoSoggettoAttuatore;
    protected BigDecimal codiceSoggettoAttuatore;

    /**
     * Recupera il valore della proprietà codTipoMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoMateria() {
        return codTipoMateria;
    }

    /**
     * Imposta il valore della proprietà codTipoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoMateria(String value) {
        this.codTipoMateria = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreSoggFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodOperatoreSoggFinanziato() {
        return codOperatoreSoggFinanziato;
    }

    /**
     * Imposta il valore della proprietà codOperatoreSoggFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodOperatoreSoggFinanziato(BigDecimal value) {
        this.codOperatoreSoggFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreSoggFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreSoggFinanziato() {
        return gruppoOperatoreSoggFinanziato;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreSoggFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreSoggFinanziato(String value) {
        this.gruppoOperatoreSoggFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdInterventoApprovatoMateria() {
        return idInterventoApprovatoMateria;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdInterventoApprovatoMateria(BigDecimal value) {
        this.idInterventoApprovatoMateria = value;
    }

    /**
     * Recupera il valore della proprietà codTipoInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoInterventoApprovato() {
        return codTipoInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà codTipoInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoInterventoApprovato(String value) {
        this.codTipoInterventoApprovato = value;
    }

    /**
     * Recupera il valore della proprietà classificazioneInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link ClassificazioneInterventoApprovato }
     *     
     */
    public ClassificazioneInterventoApprovato getClassificazioneInterventoApprovato() {
        return classificazioneInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà classificazioneInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificazioneInterventoApprovato }
     *     
     */
    public void setClassificazioneInterventoApprovato(ClassificazioneInterventoApprovato value) {
        this.classificazioneInterventoApprovato = value;
    }

    /**
     * Recupera il valore della proprietà idPso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdPso() {
        return idPso;
    }

    /**
     * Imposta il valore della proprietà idPso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdPso(BigDecimal value) {
        this.idPso = value;
    }

    /**
     * Recupera il valore della proprietà idSportelloPso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdSportelloPso() {
        return idSportelloPso;
    }

    /**
     * Imposta il valore della proprietà idSportelloPso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdSportelloPso(BigDecimal value) {
        this.idSportelloPso = value;
    }

    /**
     * Recupera il valore della proprietà codTipoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoRichiesta() {
        return codTipoRichiesta;
    }

    /**
     * Imposta il valore della proprietà codTipoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoRichiesta(String value) {
        this.codTipoRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà dataRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRichiesta() {
        return dataRichiesta;
    }

    /**
     * Imposta il valore della proprietà dataRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRichiesta(XMLGregorianCalendar value) {
        this.dataRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà numeroDestinatari.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumeroDestinatari() {
        return numeroDestinatari;
    }

    /**
     * Imposta il valore della proprietà numeroDestinatari.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumeroDestinatari(BigDecimal value) {
        this.numeroDestinatari = value;
    }

    /**
     * Recupera il valore della proprietà idInterventoApprovatoPadreMateria.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdInterventoApprovatoPadreMateria() {
        return idInterventoApprovatoPadreMateria;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovatoPadreMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdInterventoApprovatoPadreMateria(BigDecimal value) {
        this.idInterventoApprovatoPadreMateria = value;
    }

    /**
     * Recupera il valore della proprietà codTipoInterventoApprovatoPadre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoInterventoApprovatoPadre() {
        return codTipoInterventoApprovatoPadre;
    }

    /**
     * Imposta il valore della proprietà codTipoInterventoApprovatoPadre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoInterventoApprovatoPadre(String value) {
        this.codTipoInterventoApprovatoPadre = value;
    }

    /**
     * Recupera il valore della proprietà durata.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurata() {
        return durata;
    }

    /**
     * Imposta il valore della proprietà durata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurata(BigDecimal value) {
        this.durata = value;
    }

    /**
     * Recupera il valore della proprietà codTipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipologiaServizio() {
        return codTipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà codTipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipologiaServizio(String value) {
        this.codTipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà codSottoTipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodSottoTipologiaServizio() {
        return codSottoTipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà codSottoTipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodSottoTipologiaServizio(BigDecimal value) {
        this.codSottoTipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà capoFila.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapoFila() {
        return capoFila;
    }

    /**
     * Imposta il valore della proprietà capoFila.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapoFila(Integer value) {
        this.capoFila = value;
    }

    /**
     * Gets the value of the elencoDestinatari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoDestinatari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoDestinatari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VerificaBudgetImpegnoDestinatarioDto }
     * 
     * 
     */
    public List<VerificaBudgetImpegnoDestinatarioDto> getElencoDestinatari() {
        if (elencoDestinatari == null) {
            elencoDestinatari = new ArrayList<VerificaBudgetImpegnoDestinatarioDto>();
        }
        return this.elencoDestinatari;
    }

    /**
     * Recupera il valore della proprietà codAreaTerritoriale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAreaTerritoriale() {
        return codAreaTerritoriale;
    }

    /**
     * Imposta il valore della proprietà codAreaTerritoriale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAreaTerritoriale(String value) {
        this.codAreaTerritoriale = value;
    }

    /**
     * Recupera il valore della proprietà subCodiceSede.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubCodiceSede() {
        return subCodiceSede;
    }

    /**
     * Imposta il valore della proprietà subCodiceSede.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubCodiceSede(BigDecimal value) {
        this.subCodiceSede = value;
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
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodiceSoggettoAttuatore() {
        return codiceSoggettoAttuatore;
    }

    /**
     * Imposta il valore della proprietà codiceSoggettoAttuatore.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodiceSoggettoAttuatore(BigDecimal value) {
        this.codiceSoggettoAttuatore = value;
    }

}
