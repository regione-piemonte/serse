
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
 * <p>Classe Java per ElementoDtoV2 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ElementoDtoV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="annoInserimento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="annoModifica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codClassificazioneElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codSubCodiceOperatore" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codTipoElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codiceGruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dataInserimento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataModifica" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="denominazioneElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrTipoElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneClassifElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="disponibilita" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="superficie" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ubicazione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElementoDtoV2", propOrder = {
    "annoInserimento",
    "annoModifica",
    "codClassificazioneElemento",
    "codSubCodiceOperatore",
    "codTipoElemento",
    "codiceGruppoOperatore",
    "codiceOperatore",
    "dataInserimento",
    "dataModifica",
    "denominazioneElemento",
    "descrTipoElemento",
    "descrizioneClassifElemento",
    "disponibilita",
    "idElemento",
    "idPersonaGiuridica",
    "superficie",
    "ubicazione"
})
public class ElementoDtoV2 {

    @XmlElement(required = true, nillable = true)
    protected String annoInserimento;
    @XmlElement(required = true, nillable = true)
    protected String annoModifica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codClassificazioneElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codSubCodiceOperatore;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codTipoElemento;
    @XmlElement(required = true, nillable = true)
    protected String codiceGruppoOperatore;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codiceOperatore;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInserimento;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataModifica;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrTipoElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneClassifElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer disponibilita;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idPersonaGiuridica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer superficie;
    @XmlElement(required = true, nillable = true)
    protected String ubicazione;

    /**
     * Recupera il valore della proprietà annoInserimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoInserimento() {
        return annoInserimento;
    }

    /**
     * Imposta il valore della proprietà annoInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoInserimento(String value) {
        this.annoInserimento = value;
    }

    /**
     * Recupera il valore della proprietà annoModifica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoModifica() {
        return annoModifica;
    }

    /**
     * Imposta il valore della proprietà annoModifica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoModifica(String value) {
        this.annoModifica = value;
    }

    /**
     * Recupera il valore della proprietà codClassificazioneElemento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodClassificazioneElemento() {
        return codClassificazioneElemento;
    }

    /**
     * Imposta il valore della proprietà codClassificazioneElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodClassificazioneElemento(Integer value) {
        this.codClassificazioneElemento = value;
    }

    /**
     * Recupera il valore della proprietà codSubCodiceOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodSubCodiceOperatore() {
        return codSubCodiceOperatore;
    }

    /**
     * Imposta il valore della proprietà codSubCodiceOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodSubCodiceOperatore(Integer value) {
        this.codSubCodiceOperatore = value;
    }

    /**
     * Recupera il valore della proprietà codTipoElemento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodTipoElemento() {
        return codTipoElemento;
    }

    /**
     * Imposta il valore della proprietà codTipoElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodTipoElemento(Integer value) {
        this.codTipoElemento = value;
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
     * Recupera il valore della proprietà denominazioneElemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneElemento() {
        return denominazioneElemento;
    }

    /**
     * Imposta il valore della proprietà denominazioneElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneElemento(String value) {
        this.denominazioneElemento = value;
    }

    /**
     * Recupera il valore della proprietà descrTipoElemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrTipoElemento() {
        return descrTipoElemento;
    }

    /**
     * Imposta il valore della proprietà descrTipoElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrTipoElemento(String value) {
        this.descrTipoElemento = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneClassifElemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneClassifElemento() {
        return descrizioneClassifElemento;
    }

    /**
     * Imposta il valore della proprietà descrizioneClassifElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneClassifElemento(String value) {
        this.descrizioneClassifElemento = value;
    }

    /**
     * Recupera il valore della proprietà disponibilita.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDisponibilita() {
        return disponibilita;
    }

    /**
     * Imposta il valore della proprietà disponibilita.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDisponibilita(Integer value) {
        this.disponibilita = value;
    }

    /**
     * Recupera il valore della proprietà idElemento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdElemento() {
        return idElemento;
    }

    /**
     * Imposta il valore della proprietà idElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdElemento(Integer value) {
        this.idElemento = value;
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
     * Recupera il valore della proprietà superficie.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSuperficie() {
        return superficie;
    }

    /**
     * Imposta il valore della proprietà superficie.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSuperficie(Integer value) {
        this.superficie = value;
    }

    /**
     * Recupera il valore della proprietà ubicazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazione() {
        return ubicazione;
    }

    /**
     * Imposta il valore della proprietà ubicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazione(String value) {
        this.ubicazione = value;
    }

}
