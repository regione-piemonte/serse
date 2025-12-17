
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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per erogazioneAttivitaInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="erogazioneAttivitaInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codOperatoreSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="capoFila" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="classificazioneInterventoApprovato" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classificazioneInterventoApprovato" minOccurs="0"/&gt;
 *         &lt;element name="durataAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codFiscDestinatarioAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codSottoTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idSportelloPso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="dataRichiesta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="subCodiceSede" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="cfErogatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtAvvioAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dtTermineAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dtRegistrazioneAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "erogazioneAttivitaInput", propOrder = {
    "codTipoMateria",
    "codTipoRichiesta",
    "codOperatoreSoggFinanziato",
    "gruppoOperatoreSoggFinanziato",
    "capoFila",
    "codOperatoreSA",
    "gruppoOperatoreSA",
    "idAttivitaMateria",
    "codTipoAttivita",
    "classificazioneInterventoApprovato",
    "durataAttivita",
    "codFiscDestinatarioAttivita",
    "idInterventoApprovatoMateria",
    "codTipoInterventoApprovato",
    "codTipologiaServizio",
    "codSottoTipologiaServizio",
    "idPso",
    "idSportelloPso",
    "dataRichiesta",
    "subCodiceSede",
    "cfErogatore",
    "dtAvvioAttivita",
    "dtTermineAttivita",
    "dtRegistrazioneAttivita"
})
public class ErogazioneAttivitaInput {

    @XmlElement(required = true)
    protected String codTipoMateria;
    @XmlElement(required = true)
    protected String codTipoRichiesta;
    protected BigDecimal codOperatoreSoggFinanziato;
    protected String gruppoOperatoreSoggFinanziato;
    protected BigDecimal capoFila;
    protected BigDecimal codOperatoreSA;
    protected String gruppoOperatoreSA;
    protected BigDecimal idAttivitaMateria;
    protected String codTipoAttivita;
    protected ClassificazioneInterventoApprovato classificazioneInterventoApprovato;
    protected BigDecimal durataAttivita;
    protected String codFiscDestinatarioAttivita;
    protected BigDecimal idInterventoApprovatoMateria;
    protected String codTipoInterventoApprovato;
    protected String codTipologiaServizio;
    protected BigDecimal codSottoTipologiaServizio;
    protected BigDecimal idPso;
    protected BigDecimal idSportelloPso;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRichiesta;
    protected BigDecimal subCodiceSede;
    protected String cfErogatore;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtAvvioAttivita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtTermineAttivita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtRegistrazioneAttivita;

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
     * Recupera il valore della proprietà capoFila.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCapoFila() {
        return capoFila;
    }

    /**
     * Imposta il valore della proprietà capoFila.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCapoFila(BigDecimal value) {
        this.capoFila = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreSA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodOperatoreSA() {
        return codOperatoreSA;
    }

    /**
     * Imposta il valore della proprietà codOperatoreSA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodOperatoreSA(BigDecimal value) {
        this.codOperatoreSA = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreSA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreSA() {
        return gruppoOperatoreSA;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreSA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreSA(String value) {
        this.gruppoOperatoreSA = value;
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

    /**
     * Recupera il valore della proprietà codFiscDestinatarioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscDestinatarioAttivita() {
        return codFiscDestinatarioAttivita;
    }

    /**
     * Imposta il valore della proprietà codFiscDestinatarioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscDestinatarioAttivita(String value) {
        this.codFiscDestinatarioAttivita = value;
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
     * Recupera il valore della proprietà cfErogatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfErogatore() {
        return cfErogatore;
    }

    /**
     * Imposta il valore della proprietà cfErogatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfErogatore(String value) {
        this.cfErogatore = value;
    }

    /**
     * Recupera il valore della proprietà dtAvvioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtAvvioAttivita() {
        return dtAvvioAttivita;
    }

    /**
     * Imposta il valore della proprietà dtAvvioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtAvvioAttivita(XMLGregorianCalendar value) {
        this.dtAvvioAttivita = value;
    }

    /**
     * Recupera il valore della proprietà dtTermineAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtTermineAttivita() {
        return dtTermineAttivita;
    }

    /**
     * Imposta il valore della proprietà dtTermineAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtTermineAttivita(XMLGregorianCalendar value) {
        this.dtTermineAttivita = value;
    }

    /**
     * Recupera il valore della proprietà dtRegistrazioneAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtRegistrazioneAttivita() {
        return dtRegistrazioneAttivita;
    }

    /**
     * Imposta il valore della proprietà dtRegistrazioneAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtRegistrazioneAttivita(XMLGregorianCalendar value) {
        this.dtRegistrazioneAttivita = value;
    }

}
