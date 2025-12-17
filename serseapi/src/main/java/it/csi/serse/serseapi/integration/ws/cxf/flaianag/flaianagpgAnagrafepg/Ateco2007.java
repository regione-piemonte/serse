
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Ateco2007 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Ateco2007"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codAteco" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codAtecoNormalizzato" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codCategoria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codClasse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codDivisione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codGruppo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codLivello" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codSezione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codSottoCategoria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrAteco" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrCategoria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrClasse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrDivisione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrGruppo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrSezione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrSottoCategoria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idAteco" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ateco2007", propOrder = {
    "codAteco",
    "codAtecoNormalizzato",
    "codCategoria",
    "codClasse",
    "codDivisione",
    "codGruppo",
    "codLivello",
    "codSezione",
    "codSottoCategoria",
    "descrAteco",
    "descrCategoria",
    "descrClasse",
    "descrDivisione",
    "descrGruppo",
    "descrSezione",
    "descrSottoCategoria",
    "idAteco"
})
public class Ateco2007 {

    @XmlElement(required = true, nillable = true)
    protected String codAteco;
    @XmlElement(required = true, nillable = true)
    protected String codAtecoNormalizzato;
    @XmlElement(required = true, nillable = true)
    protected String codCategoria;
    @XmlElement(required = true, nillable = true)
    protected String codClasse;
    @XmlElement(required = true, nillable = true)
    protected String codDivisione;
    @XmlElement(required = true, nillable = true)
    protected String codGruppo;
    protected int codLivello;
    @XmlElement(required = true, nillable = true)
    protected String codSezione;
    @XmlElement(required = true, nillable = true)
    protected String codSottoCategoria;
    @XmlElement(required = true, nillable = true)
    protected String descrAteco;
    @XmlElement(required = true, nillable = true)
    protected String descrCategoria;
    @XmlElement(required = true, nillable = true)
    protected String descrClasse;
    @XmlElement(required = true, nillable = true)
    protected String descrDivisione;
    @XmlElement(required = true, nillable = true)
    protected String descrGruppo;
    @XmlElement(required = true, nillable = true)
    protected String descrSezione;
    @XmlElement(required = true, nillable = true)
    protected String descrSottoCategoria;
    protected int idAteco;

    /**
     * Recupera il valore della proprietà codAteco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAteco() {
        return codAteco;
    }

    /**
     * Imposta il valore della proprietà codAteco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAteco(String value) {
        this.codAteco = value;
    }

    /**
     * Recupera il valore della proprietà codAtecoNormalizzato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAtecoNormalizzato() {
        return codAtecoNormalizzato;
    }

    /**
     * Imposta il valore della proprietà codAtecoNormalizzato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAtecoNormalizzato(String value) {
        this.codAtecoNormalizzato = value;
    }

    /**
     * Recupera il valore della proprietà codCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCategoria() {
        return codCategoria;
    }

    /**
     * Imposta il valore della proprietà codCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCategoria(String value) {
        this.codCategoria = value;
    }

    /**
     * Recupera il valore della proprietà codClasse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodClasse() {
        return codClasse;
    }

    /**
     * Imposta il valore della proprietà codClasse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodClasse(String value) {
        this.codClasse = value;
    }

    /**
     * Recupera il valore della proprietà codDivisione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDivisione() {
        return codDivisione;
    }

    /**
     * Imposta il valore della proprietà codDivisione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDivisione(String value) {
        this.codDivisione = value;
    }

    /**
     * Recupera il valore della proprietà codGruppo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodGruppo() {
        return codGruppo;
    }

    /**
     * Imposta il valore della proprietà codGruppo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodGruppo(String value) {
        this.codGruppo = value;
    }

    /**
     * Recupera il valore della proprietà codLivello.
     * 
     */
    public int getCodLivello() {
        return codLivello;
    }

    /**
     * Imposta il valore della proprietà codLivello.
     * 
     */
    public void setCodLivello(int value) {
        this.codLivello = value;
    }

    /**
     * Recupera il valore della proprietà codSezione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSezione() {
        return codSezione;
    }

    /**
     * Imposta il valore della proprietà codSezione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSezione(String value) {
        this.codSezione = value;
    }

    /**
     * Recupera il valore della proprietà codSottoCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSottoCategoria() {
        return codSottoCategoria;
    }

    /**
     * Imposta il valore della proprietà codSottoCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSottoCategoria(String value) {
        this.codSottoCategoria = value;
    }

    /**
     * Recupera il valore della proprietà descrAteco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrAteco() {
        return descrAteco;
    }

    /**
     * Imposta il valore della proprietà descrAteco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrAteco(String value) {
        this.descrAteco = value;
    }

    /**
     * Recupera il valore della proprietà descrCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrCategoria() {
        return descrCategoria;
    }

    /**
     * Imposta il valore della proprietà descrCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrCategoria(String value) {
        this.descrCategoria = value;
    }

    /**
     * Recupera il valore della proprietà descrClasse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrClasse() {
        return descrClasse;
    }

    /**
     * Imposta il valore della proprietà descrClasse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrClasse(String value) {
        this.descrClasse = value;
    }

    /**
     * Recupera il valore della proprietà descrDivisione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrDivisione() {
        return descrDivisione;
    }

    /**
     * Imposta il valore della proprietà descrDivisione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrDivisione(String value) {
        this.descrDivisione = value;
    }

    /**
     * Recupera il valore della proprietà descrGruppo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrGruppo() {
        return descrGruppo;
    }

    /**
     * Imposta il valore della proprietà descrGruppo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrGruppo(String value) {
        this.descrGruppo = value;
    }

    /**
     * Recupera il valore della proprietà descrSezione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrSezione() {
        return descrSezione;
    }

    /**
     * Imposta il valore della proprietà descrSezione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrSezione(String value) {
        this.descrSezione = value;
    }

    /**
     * Recupera il valore della proprietà descrSottoCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrSottoCategoria() {
        return descrSottoCategoria;
    }

    /**
     * Imposta il valore della proprietà descrSottoCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrSottoCategoria(String value) {
        this.descrSottoCategoria = value;
    }

    /**
     * Recupera il valore della proprietà idAteco.
     * 
     */
    public int getIdAteco() {
        return idAteco;
    }

    /**
     * Imposta il valore della proprietà idAteco.
     * 
     */
    public void setIdAteco(int value) {
        this.idAteco = value;
    }

}
