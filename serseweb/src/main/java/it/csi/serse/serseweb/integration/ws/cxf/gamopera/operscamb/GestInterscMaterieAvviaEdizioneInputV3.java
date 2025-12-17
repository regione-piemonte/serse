
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
 * <p>Classe Java per gestInterscMaterieAvviaEdizioneInputV3 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieAvviaEdizioneInputV3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idSportelloPso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idDomanda" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codiceSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codSede" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codAreaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFascia" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codClasseAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="classificazionePOR" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classTabFinanziamento" minOccurs="0"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dataPresuntaFineAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="durataPrevista" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="numeroDestinatari" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="elencoDestinatari" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}destinatarioAvviaEdizioneDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="annoGestione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieAvviaEdizioneInputV3", propOrder = {
    "codTipoMateria",
    "idInterventoApprovatoMateria",
    "idAttivitaMateria",
    "denominazioneAttivita",
    "idPso",
    "idSportelloPso",
    "codSoggFinanziato",
    "gruppoSoggFinanziato",
    "idDomanda",
    "codiceSoggettoAttuatore",
    "gruppoSoggettoAttuatore",
    "codSede",
    "codAreaTerritoriale",
    "idFascia",
    "codClasseAttivita",
    "codTipoAttivita",
    "classificazionePOR",
    "codTipoRichiesta",
    "dataInizioAttivita",
    "dataPresuntaFineAttivita",
    "durataPrevista",
    "numeroDestinatari",
    "elencoDestinatari",
    "annoGestione"
})
public class GestInterscMaterieAvviaEdizioneInputV3 {

    @XmlElement(required = true)
    protected String codTipoMateria;
    protected BigDecimal idInterventoApprovatoMateria;
    protected BigDecimal idAttivitaMateria;
    protected String denominazioneAttivita;
    protected BigDecimal idPso;
    protected BigDecimal idSportelloPso;
    protected BigDecimal codSoggFinanziato;
    protected String gruppoSoggFinanziato;
    protected BigDecimal idDomanda;
    protected BigDecimal codiceSoggettoAttuatore;
    protected String gruppoSoggettoAttuatore;
    protected BigDecimal codSede;
    protected String codAreaTerritoriale;
    protected BigDecimal idFascia;
    protected String codClasseAttivita;
    protected String codTipoAttivita;
    protected ClassTabFinanziamento classificazionePOR;
    protected String codTipoRichiesta;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInizioAttivita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataPresuntaFineAttivita;
    protected BigDecimal durataPrevista;
    protected BigDecimal numeroDestinatari;
    @XmlElement(nillable = true)
    protected List<DestinatarioAvviaEdizioneDto> elencoDestinatari;
    protected Long annoGestione;

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
     * Recupera il valore della proprietà idAttivitaMateria.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdAttivitaMateria() {
        return idAttivitaMateria;
    }

    /**
     * Imposta il valore della proprietà idAttivitaMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdAttivitaMateria(BigDecimal value) {
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
     * Recupera il valore della proprietà codSoggFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodSoggFinanziato() {
        return codSoggFinanziato;
    }

    /**
     * Imposta il valore della proprietà codSoggFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodSoggFinanziato(BigDecimal value) {
        this.codSoggFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà gruppoSoggFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoSoggFinanziato() {
        return gruppoSoggFinanziato;
    }

    /**
     * Imposta il valore della proprietà gruppoSoggFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoSoggFinanziato(String value) {
        this.gruppoSoggFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà idDomanda.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdDomanda() {
        return idDomanda;
    }

    /**
     * Imposta il valore della proprietà idDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdDomanda(BigDecimal value) {
        this.idDomanda = value;
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
     * Recupera il valore della proprietà codSede.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodSede() {
        return codSede;
    }

    /**
     * Imposta il valore della proprietà codSede.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodSede(BigDecimal value) {
        this.codSede = value;
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
     * Recupera il valore della proprietà idFascia.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdFascia() {
        return idFascia;
    }

    /**
     * Imposta il valore della proprietà idFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdFascia(BigDecimal value) {
        this.idFascia = value;
    }

    /**
     * Recupera il valore della proprietà codClasseAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodClasseAttivita() {
        return codClasseAttivita;
    }

    /**
     * Imposta il valore della proprietà codClasseAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodClasseAttivita(String value) {
        this.codClasseAttivita = value;
    }

    /**
     * Recupera il valore della proprietà codTipoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoAttivita() {
        return codTipoAttivita;
    }

    /**
     * Imposta il valore della proprietà codTipoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoAttivita(String value) {
        this.codTipoAttivita = value;
    }

    /**
     * Recupera il valore della proprietà classificazionePOR.
     * 
     * @return
     *     possible object is
     *     {@link ClassTabFinanziamento }
     *     
     */
    public ClassTabFinanziamento getClassificazionePOR() {
        return classificazionePOR;
    }

    /**
     * Imposta il valore della proprietà classificazionePOR.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassTabFinanziamento }
     *     
     */
    public void setClassificazionePOR(ClassTabFinanziamento value) {
        this.classificazionePOR = value;
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
     * Recupera il valore della proprietà dataInizioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizioAttivita() {
        return dataInizioAttivita;
    }

    /**
     * Imposta il valore della proprietà dataInizioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizioAttivita(XMLGregorianCalendar value) {
        this.dataInizioAttivita = value;
    }

    /**
     * Recupera il valore della proprietà dataPresuntaFineAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataPresuntaFineAttivita() {
        return dataPresuntaFineAttivita;
    }

    /**
     * Imposta il valore della proprietà dataPresuntaFineAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataPresuntaFineAttivita(XMLGregorianCalendar value) {
        this.dataPresuntaFineAttivita = value;
    }

    /**
     * Recupera il valore della proprietà durataPrevista.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurataPrevista() {
        return durataPrevista;
    }

    /**
     * Imposta il valore della proprietà durataPrevista.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurataPrevista(BigDecimal value) {
        this.durataPrevista = value;
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
     * {@link DestinatarioAvviaEdizioneDto }
     * 
     * 
     */
    public List<DestinatarioAvviaEdizioneDto> getElencoDestinatari() {
        if (elencoDestinatari == null) {
            elencoDestinatari = new ArrayList<DestinatarioAvviaEdizioneDto>();
        }
        return this.elencoDestinatari;
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

}
