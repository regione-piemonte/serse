
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
import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestInterscMaterieIscriviAllievoAEdizioneAvviataInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieIscriviAllievoAEdizioneAvviataInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="classeAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSede" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="dataAvvioAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dataTermineAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="flagAllievoPagante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flagDisabile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gruppoSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSoggettoAttuatore" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="dataNascita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="codiceComuneNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceProvinciaNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceStatoEsteroNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cittaEsteraNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceCittadinanza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="datatInizioFrequenza" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="oreFrequenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idTipologiaContributo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieIscriviAllievoAEdizioneAvviataInput", propOrder = {
    "codTipoMateria",
    "codTipoRichiesta",
    "idInterventoApprovatoMateria",
    "idAttivitaMateria",
    "denominazioneAttivita",
    "classeAttivita",
    "codiceSede",
    "dataAvvioAttivita",
    "dataTermineAttivita",
    "flagAllievoPagante",
    "flagDisabile",
    "cognome",
    "nome",
    "codFiscale",
    "gruppoSoggettoAttuatore",
    "codiceSoggettoAttuatore",
    "dataNascita",
    "codiceComuneNascita",
    "codiceProvinciaNascita",
    "codiceStatoEsteroNascita",
    "cittaEsteraNascita",
    "codiceCittadinanza",
    "datatInizioFrequenza",
    "oreFrequenza",
    "idTipologiaContributo"
})
public class GestInterscMaterieIscriviAllievoAEdizioneAvviataInput {

    @XmlElement(required = true)
    protected String codTipoMateria;
    protected String codTipoRichiesta;
    protected Long idInterventoApprovatoMateria;
    protected Long idAttivitaMateria;
    protected String denominazioneAttivita;
    protected String classeAttivita;
    protected BigInteger codiceSede;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAvvioAttivita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataTermineAttivita;
    protected String flagAllievoPagante;
    protected String flagDisabile;
    protected String cognome;
    protected String nome;
    protected String codFiscale;
    protected String gruppoSoggettoAttuatore;
    protected BigInteger codiceSoggettoAttuatore;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNascita;
    protected String codiceComuneNascita;
    protected String codiceProvinciaNascita;
    protected String codiceStatoEsteroNascita;
    protected String cittaEsteraNascita;
    protected String codiceCittadinanza;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datatInizioFrequenza;
    protected BigDecimal oreFrequenza;
    protected Long idTipologiaContributo;

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
     * Recupera il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdInterventoApprovatoMateria() {
        return idInterventoApprovatoMateria;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdInterventoApprovatoMateria(Long value) {
        this.idInterventoApprovatoMateria = value;
    }

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
     * Recupera il valore della proprietà classeAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasseAttivita() {
        return classeAttivita;
    }

    /**
     * Imposta il valore della proprietà classeAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasseAttivita(String value) {
        this.classeAttivita = value;
    }

    /**
     * Recupera il valore della proprietà codiceSede.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodiceSede() {
        return codiceSede;
    }

    /**
     * Imposta il valore della proprietà codiceSede.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodiceSede(BigInteger value) {
        this.codiceSede = value;
    }

    /**
     * Recupera il valore della proprietà dataAvvioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAvvioAttivita() {
        return dataAvvioAttivita;
    }

    /**
     * Imposta il valore della proprietà dataAvvioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAvvioAttivita(XMLGregorianCalendar value) {
        this.dataAvvioAttivita = value;
    }

    /**
     * Recupera il valore della proprietà dataTermineAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataTermineAttivita() {
        return dataTermineAttivita;
    }

    /**
     * Imposta il valore della proprietà dataTermineAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataTermineAttivita(XMLGregorianCalendar value) {
        this.dataTermineAttivita = value;
    }

    /**
     * Recupera il valore della proprietà flagAllievoPagante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagAllievoPagante() {
        return flagAllievoPagante;
    }

    /**
     * Imposta il valore della proprietà flagAllievoPagante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagAllievoPagante(String value) {
        this.flagAllievoPagante = value;
    }

    /**
     * Recupera il valore della proprietà flagDisabile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagDisabile() {
        return flagDisabile;
    }

    /**
     * Imposta il valore della proprietà flagDisabile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagDisabile(String value) {
        this.flagDisabile = value;
    }

    /**
     * Recupera il valore della proprietà cognome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il valore della proprietà cognome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognome(String value) {
        this.cognome = value;
    }

    /**
     * Recupera il valore della proprietà nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il valore della proprietà nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Recupera il valore della proprietà codFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscale() {
        return codFiscale;
    }

    /**
     * Imposta il valore della proprietà codFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscale(String value) {
        this.codFiscale = value;
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
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodiceSoggettoAttuatore() {
        return codiceSoggettoAttuatore;
    }

    /**
     * Imposta il valore della proprietà codiceSoggettoAttuatore.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodiceSoggettoAttuatore(BigInteger value) {
        this.codiceSoggettoAttuatore = value;
    }

    /**
     * Recupera il valore della proprietà dataNascita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta il valore della proprietà dataNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNascita(XMLGregorianCalendar value) {
        this.dataNascita = value;
    }

    /**
     * Recupera il valore della proprietà codiceComuneNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceComuneNascita() {
        return codiceComuneNascita;
    }

    /**
     * Imposta il valore della proprietà codiceComuneNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceComuneNascita(String value) {
        this.codiceComuneNascita = value;
    }

    /**
     * Recupera il valore della proprietà codiceProvinciaNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceProvinciaNascita() {
        return codiceProvinciaNascita;
    }

    /**
     * Imposta il valore della proprietà codiceProvinciaNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceProvinciaNascita(String value) {
        this.codiceProvinciaNascita = value;
    }

    /**
     * Recupera il valore della proprietà codiceStatoEsteroNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceStatoEsteroNascita() {
        return codiceStatoEsteroNascita;
    }

    /**
     * Imposta il valore della proprietà codiceStatoEsteroNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceStatoEsteroNascita(String value) {
        this.codiceStatoEsteroNascita = value;
    }

    /**
     * Recupera il valore della proprietà cittaEsteraNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCittaEsteraNascita() {
        return cittaEsteraNascita;
    }

    /**
     * Imposta il valore della proprietà cittaEsteraNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCittaEsteraNascita(String value) {
        this.cittaEsteraNascita = value;
    }

    /**
     * Recupera il valore della proprietà codiceCittadinanza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCittadinanza() {
        return codiceCittadinanza;
    }

    /**
     * Imposta il valore della proprietà codiceCittadinanza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCittadinanza(String value) {
        this.codiceCittadinanza = value;
    }

    /**
     * Recupera il valore della proprietà datatInizioFrequenza.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatatInizioFrequenza() {
        return datatInizioFrequenza;
    }

    /**
     * Imposta il valore della proprietà datatInizioFrequenza.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatatInizioFrequenza(XMLGregorianCalendar value) {
        this.datatInizioFrequenza = value;
    }

    /**
     * Recupera il valore della proprietà oreFrequenza.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOreFrequenza() {
        return oreFrequenza;
    }

    /**
     * Imposta il valore della proprietà oreFrequenza.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOreFrequenza(BigDecimal value) {
        this.oreFrequenza = value;
    }

    /**
     * Recupera il valore della proprietà idTipologiaContributo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdTipologiaContributo() {
        return idTipologiaContributo;
    }

    /**
     * Imposta il valore della proprietà idTipologiaContributo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdTipologiaContributo(Long value) {
        this.idTipologiaContributo = value;
    }

}
