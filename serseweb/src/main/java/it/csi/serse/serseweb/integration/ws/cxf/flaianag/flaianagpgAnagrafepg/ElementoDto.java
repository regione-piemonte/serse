
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ElementoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ElementoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codClassificazioneElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codTipoElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codiceGruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="denominazioneElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrTipoElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneClassifElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="superficie" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElementoDto", propOrder = {
    "codClassificazioneElemento",
    "codTipoElemento",
    "codiceGruppoOperatore",
    "codiceOperatore",
    "denominazioneElemento",
    "descrTipoElemento",
    "descrizioneClassifElemento",
    "idElemento",
    "idPersonaGiuridica",
    "superficie"
})
public class ElementoDto {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codClassificazioneElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codTipoElemento;
    @XmlElement(required = true, nillable = true)
    protected String codiceGruppoOperatore;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codiceOperatore;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrTipoElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneClassifElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idPersonaGiuridica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer superficie;

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

}
