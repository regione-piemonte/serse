
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

package it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per FirmatarioDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="FirmatarioDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cittaResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codFiscFirmatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codFunzioneOrganizzativa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoGestioneFirma" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dataNascita" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="descFunzioneOrganizzativa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descTipoFirma" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="gruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="indirizzoResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="luogoNascita" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirmatarioDto", propOrder = {
    "cittaResidenza",
    "codFiscFirmatario",
    "codFunzioneOrganizzativa",
    "codTipoGestioneFirma",
    "codiceOperatore",
    "cognome",
    "dataNascita",
    "descFunzioneOrganizzativa",
    "descTipoFirma",
    "gruppoOperatore",
    "idPersonaGiuridica",
    "indirizzoResidenza",
    "luogoNascita",
    "nome"
})
public class FirmatarioDto {

    @XmlElement(required = true, nillable = true)
    protected String cittaResidenza;
    @XmlElement(required = true, nillable = true)
    protected String codFiscFirmatario;
    @XmlElement(required = true, nillable = true)
    protected String codFunzioneOrganizzativa;
    @XmlElement(required = true, nillable = true)
    protected String codTipoGestioneFirma;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long codiceOperatore;
    @XmlElement(required = true, nillable = true)
    protected String cognome;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNascita;
    @XmlElement(required = true, nillable = true)
    protected String descFunzioneOrganizzativa;
    @XmlElement(required = true, nillable = true)
    protected String descTipoFirma;
    @XmlElement(required = true, nillable = true)
    protected String gruppoOperatore;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long idPersonaGiuridica;
    @XmlElement(required = true, nillable = true)
    protected String indirizzoResidenza;
    @XmlElement(required = true, nillable = true)
    protected String luogoNascita;
    @XmlElement(required = true, nillable = true)
    protected String nome;

    /**
     * Recupera il valore della proprietà cittaResidenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCittaResidenza() {
        return cittaResidenza;
    }

    /**
     * Imposta il valore della proprietà cittaResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCittaResidenza(String value) {
        this.cittaResidenza = value;
    }

    /**
     * Recupera il valore della proprietà codFiscFirmatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscFirmatario() {
        return codFiscFirmatario;
    }

    /**
     * Imposta il valore della proprietà codFiscFirmatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscFirmatario(String value) {
        this.codFiscFirmatario = value;
    }

    /**
     * Recupera il valore della proprietà codFunzioneOrganizzativa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFunzioneOrganizzativa() {
        return codFunzioneOrganizzativa;
    }

    /**
     * Imposta il valore della proprietà codFunzioneOrganizzativa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFunzioneOrganizzativa(String value) {
        this.codFunzioneOrganizzativa = value;
    }

    /**
     * Recupera il valore della proprietà codTipoGestioneFirma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoGestioneFirma() {
        return codTipoGestioneFirma;
    }

    /**
     * Imposta il valore della proprietà codTipoGestioneFirma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoGestioneFirma(String value) {
        this.codTipoGestioneFirma = value;
    }

    /**
     * Recupera il valore della proprietà codiceOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceOperatore() {
        return codiceOperatore;
    }

    /**
     * Imposta il valore della proprietà codiceOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceOperatore(Long value) {
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
     * Recupera il valore della proprietà descFunzioneOrganizzativa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescFunzioneOrganizzativa() {
        return descFunzioneOrganizzativa;
    }

    /**
     * Imposta il valore della proprietà descFunzioneOrganizzativa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescFunzioneOrganizzativa(String value) {
        this.descFunzioneOrganizzativa = value;
    }

    /**
     * Recupera il valore della proprietà descTipoFirma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoFirma() {
        return descTipoFirma;
    }

    /**
     * Imposta il valore della proprietà descTipoFirma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoFirma(String value) {
        this.descTipoFirma = value;
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
     * Recupera il valore della proprietà idPersonaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPersonaGiuridica() {
        return idPersonaGiuridica;
    }

    /**
     * Imposta il valore della proprietà idPersonaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPersonaGiuridica(Long value) {
        this.idPersonaGiuridica = value;
    }

    /**
     * Recupera il valore della proprietà indirizzoResidenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    /**
     * Imposta il valore della proprietà indirizzoResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzoResidenza(String value) {
        this.indirizzoResidenza = value;
    }

    /**
     * Recupera il valore della proprietà luogoNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLuogoNascita() {
        return luogoNascita;
    }

    /**
     * Imposta il valore della proprietà luogoNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLuogoNascita(String value) {
        this.luogoNascita = value;
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

}
