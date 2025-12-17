
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

package it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IncaricoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="IncaricoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codComuneNasc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codFiscaleInserimento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codFiscaleModifica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codFiscaleValidazione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoTitolareEffettivo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceGruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comuneNascita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dataFineIncarico" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataInizioIncarico" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataInserimento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataModifica" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataNascita" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataValidazione" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="denominazioneOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrProvNascita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneIncarico" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneIncaricoPlurale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="genere" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idOperatoreTitolareEffettivo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idTitolareEffettivo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="istatProvNascita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="siglaProvNascita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="statoEsteroNasc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="territorioNascita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IncaricoDto", propOrder = {
    "codComuneNasc",
    "codFiscale",
    "codFiscaleInserimento",
    "codFiscaleModifica",
    "codFiscaleValidazione",
    "codTipoTitolareEffettivo",
    "codiceGruppoOperatore",
    "codiceOperatore",
    "cognome",
    "comuneNascita",
    "dataFineIncarico",
    "dataInizioIncarico",
    "dataInserimento",
    "dataModifica",
    "dataNascita",
    "dataValidazione",
    "denominazioneOperatore",
    "descrProvNascita",
    "descrizioneIncarico",
    "descrizioneIncaricoPlurale",
    "genere",
    "idOperatoreTitolareEffettivo",
    "idPersonaGiuridica",
    "idTitolareEffettivo",
    "istatProvNascita",
    "nome",
    "siglaProvNascita",
    "statoEsteroNasc",
    "territorioNascita"
})
public class IncaricoDto {

    @XmlElement(required = true, nillable = true)
    protected String codComuneNasc;
    @XmlElement(required = true, nillable = true)
    protected String codFiscale;
    @XmlElement(required = true, nillable = true)
    protected String codFiscaleInserimento;
    @XmlElement(required = true, nillable = true)
    protected String codFiscaleModifica;
    @XmlElement(required = true, nillable = true)
    protected String codFiscaleValidazione;
    @XmlElement(required = true, nillable = true)
    protected String codTipoTitolareEffettivo;
    @XmlElement(required = true, nillable = true)
    protected String codiceGruppoOperatore;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codiceOperatore;
    @XmlElement(required = true, nillable = true)
    protected String cognome;
    @XmlElement(required = true, nillable = true)
    protected String comuneNascita;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFineIncarico;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInizioIncarico;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInserimento;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataModifica;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNascita;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataValidazione;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneOperatore;
    @XmlElement(required = true, nillable = true)
    protected String descrProvNascita;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneIncarico;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneIncaricoPlurale;
    @XmlElement(required = true, nillable = true)
    protected String genere;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idOperatoreTitolareEffettivo;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idPersonaGiuridica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idTitolareEffettivo;
    @XmlElement(required = true, nillable = true)
    protected String istatProvNascita;
    @XmlElement(required = true, nillable = true)
    protected String nome;
    @XmlElement(required = true, nillable = true)
    protected String siglaProvNascita;
    @XmlElement(required = true, nillable = true)
    protected String statoEsteroNasc;
    @XmlElement(required = true, nillable = true)
    protected String territorioNascita;

    /**
     * Recupera il valore della proprietà codComuneNasc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComuneNasc() {
        return codComuneNasc;
    }

    /**
     * Imposta il valore della proprietà codComuneNasc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComuneNasc(String value) {
        this.codComuneNasc = value;
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
     * Recupera il valore della proprietà codFiscaleInserimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscaleInserimento() {
        return codFiscaleInserimento;
    }

    /**
     * Imposta il valore della proprietà codFiscaleInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscaleInserimento(String value) {
        this.codFiscaleInserimento = value;
    }

    /**
     * Recupera il valore della proprietà codFiscaleModifica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscaleModifica() {
        return codFiscaleModifica;
    }

    /**
     * Imposta il valore della proprietà codFiscaleModifica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscaleModifica(String value) {
        this.codFiscaleModifica = value;
    }

    /**
     * Recupera il valore della proprietà codFiscaleValidazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscaleValidazione() {
        return codFiscaleValidazione;
    }

    /**
     * Imposta il valore della proprietà codFiscaleValidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscaleValidazione(String value) {
        this.codFiscaleValidazione = value;
    }

    /**
     * Recupera il valore della proprietà codTipoTitolareEffettivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoTitolareEffettivo() {
        return codTipoTitolareEffettivo;
    }

    /**
     * Imposta il valore della proprietà codTipoTitolareEffettivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoTitolareEffettivo(String value) {
        this.codTipoTitolareEffettivo = value;
    }

    /**
     * Recupera il valore della proprietà codiceGruppoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceGruppoOperatore() {
        return codiceGruppoOperatore;
    }

    /**
     * Imposta il valore della proprietà codiceGruppoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceGruppoOperatore(String value) {
        this.codiceGruppoOperatore = value;
    }

    /**
     * Recupera il valore della proprietà codiceOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodiceOperatore() {
        return codiceOperatore;
    }

    /**
     * Imposta il valore della proprietà codiceOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodiceOperatore(Integer value) {
        this.codiceOperatore = value;
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
     * Recupera il valore della proprietà comuneNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuneNascita() {
        return comuneNascita;
    }

    /**
     * Imposta il valore della proprietà comuneNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuneNascita(String value) {
        this.comuneNascita = value;
    }

    /**
     * Recupera il valore della proprietà dataFineIncarico.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFineIncarico() {
        return dataFineIncarico;
    }

    /**
     * Imposta il valore della proprietà dataFineIncarico.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFineIncarico(XMLGregorianCalendar value) {
        this.dataFineIncarico = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioIncarico.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizioIncarico() {
        return dataInizioIncarico;
    }

    /**
     * Imposta il valore della proprietà dataInizioIncarico.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizioIncarico(XMLGregorianCalendar value) {
        this.dataInizioIncarico = value;
    }

    /**
     * Recupera il valore della proprietà dataInserimento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInserimento() {
        return dataInserimento;
    }

    /**
     * Imposta il valore della proprietà dataInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInserimento(XMLGregorianCalendar value) {
        this.dataInserimento = value;
    }

    /**
     * Recupera il valore della proprietà dataModifica.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataModifica() {
        return dataModifica;
    }

    /**
     * Imposta il valore della proprietà dataModifica.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataModifica(XMLGregorianCalendar value) {
        this.dataModifica = value;
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
     * Recupera il valore della proprietà dataValidazione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataValidazione() {
        return dataValidazione;
    }

    /**
     * Imposta il valore della proprietà dataValidazione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataValidazione(XMLGregorianCalendar value) {
        this.dataValidazione = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneOperatore() {
        return denominazioneOperatore;
    }

    /**
     * Imposta il valore della proprietà denominazioneOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneOperatore(String value) {
        this.denominazioneOperatore = value;
    }

    /**
     * Recupera il valore della proprietà descrProvNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrProvNascita() {
        return descrProvNascita;
    }

    /**
     * Imposta il valore della proprietà descrProvNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrProvNascita(String value) {
        this.descrProvNascita = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneIncarico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneIncarico() {
        return descrizioneIncarico;
    }

    /**
     * Imposta il valore della proprietà descrizioneIncarico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneIncarico(String value) {
        this.descrizioneIncarico = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneIncaricoPlurale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneIncaricoPlurale() {
        return descrizioneIncaricoPlurale;
    }

    /**
     * Imposta il valore della proprietà descrizioneIncaricoPlurale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneIncaricoPlurale(String value) {
        this.descrizioneIncaricoPlurale = value;
    }

    /**
     * Recupera il valore della proprietà genere.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenere() {
        return genere;
    }

    /**
     * Imposta il valore della proprietà genere.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenere(String value) {
        this.genere = value;
    }

    /**
     * Recupera il valore della proprietà idOperatoreTitolareEffettivo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOperatoreTitolareEffettivo() {
        return idOperatoreTitolareEffettivo;
    }

    /**
     * Imposta il valore della proprietà idOperatoreTitolareEffettivo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOperatoreTitolareEffettivo(Integer value) {
        this.idOperatoreTitolareEffettivo = value;
    }

    /**
     * Recupera il valore della proprietà idPersonaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPersonaGiuridica() {
        return idPersonaGiuridica;
    }

    /**
     * Imposta il valore della proprietà idPersonaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPersonaGiuridica(Integer value) {
        this.idPersonaGiuridica = value;
    }

    /**
     * Recupera il valore della proprietà idTitolareEffettivo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTitolareEffettivo() {
        return idTitolareEffettivo;
    }

    /**
     * Imposta il valore della proprietà idTitolareEffettivo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTitolareEffettivo(Integer value) {
        this.idTitolareEffettivo = value;
    }

    /**
     * Recupera il valore della proprietà istatProvNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIstatProvNascita() {
        return istatProvNascita;
    }

    /**
     * Imposta il valore della proprietà istatProvNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIstatProvNascita(String value) {
        this.istatProvNascita = value;
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
     * Recupera il valore della proprietà siglaProvNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvNascita() {
        return siglaProvNascita;
    }

    /**
     * Imposta il valore della proprietà siglaProvNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvNascita(String value) {
        this.siglaProvNascita = value;
    }

    /**
     * Recupera il valore della proprietà statoEsteroNasc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoEsteroNasc() {
        return statoEsteroNasc;
    }

    /**
     * Imposta il valore della proprietà statoEsteroNasc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoEsteroNasc(String value) {
        this.statoEsteroNasc = value;
    }

    /**
     * Recupera il valore della proprietà territorioNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerritorioNascita() {
        return territorioNascita;
    }

    /**
     * Imposta il valore della proprietà territorioNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerritorioNascita(String value) {
        this.territorioNascita = value;
    }

}
