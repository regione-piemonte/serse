
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
 * <p>Classe Java per DettaglioElementoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DettaglioElementoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codClassificazioneElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codFiscaleUtenteInserimento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codiceGruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codiceSedeUbicazione" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="denominazioneElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrTipoElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descrizioneClassifElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="disponibilita" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="elencoUtilizzoSede" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="superficie" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ubicazione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ubicazioneCodiceComune" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ubicazioneCodiceProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ubicazioneDenominazioneComune" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ubicazioneIndirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ubicazioneLuogo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ubicazioneSiglaProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="utilizzatoTutteSedi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioElementoDto", propOrder = {
    "codClassificazioneElemento",
    "codFiscaleUtenteInserimento",
    "codTipoElemento",
    "codiceGruppoOperatore",
    "codiceOperatore",
    "codiceSedeUbicazione",
    "denominazioneElemento",
    "descrElemento",
    "descrTipoElemento",
    "descrizioneClassifElemento",
    "disponibilita",
    "elencoUtilizzoSede",
    "idElemento",
    "idPersonaGiuridica",
    "superficie",
    "ubicazione",
    "ubicazioneCodiceComune",
    "ubicazioneCodiceProvincia",
    "ubicazioneDenominazioneComune",
    "ubicazioneIndirizzo",
    "ubicazioneLuogo",
    "ubicazioneSiglaProvincia",
    "utilizzatoTutteSedi"
})
public class DettaglioElementoDto {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codClassificazioneElemento;
    @XmlElement(required = true, nillable = true)
    protected String codFiscaleUtenteInserimento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codTipoElemento;
    @XmlElement(required = true, nillable = true)
    protected String codiceGruppoOperatore;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codiceOperatore;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codiceSedeUbicazione;
    @XmlElement(required = true, nillable = true)
    protected String denominazioneElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrTipoElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneClassifElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer disponibilita;
    @XmlElement(required = true, nillable = true)
    protected String elencoUtilizzoSede;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idElemento;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idPersonaGiuridica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer superficie;
    @XmlElement(required = true, nillable = true)
    protected String ubicazione;
    @XmlElement(required = true, nillable = true)
    protected String ubicazioneCodiceComune;
    @XmlElement(required = true, nillable = true)
    protected String ubicazioneCodiceProvincia;
    @XmlElement(required = true, nillable = true)
    protected String ubicazioneDenominazioneComune;
    @XmlElement(required = true, nillable = true)
    protected String ubicazioneIndirizzo;
    @XmlElement(required = true, nillable = true)
    protected String ubicazioneLuogo;
    @XmlElement(required = true, nillable = true)
    protected String ubicazioneSiglaProvincia;
    @XmlElement(required = true, nillable = true)
    protected String utilizzatoTutteSedi;

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
     * Recupera il valore della proprietà codFiscaleUtenteInserimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscaleUtenteInserimento() {
        return codFiscaleUtenteInserimento;
    }

    /**
     * Imposta il valore della proprietà codFiscaleUtenteInserimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscaleUtenteInserimento(String value) {
        this.codFiscaleUtenteInserimento = value;
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
     * Recupera il valore della proprietà codiceSedeUbicazione.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodiceSedeUbicazione() {
        return codiceSedeUbicazione;
    }

    /**
     * Imposta il valore della proprietà codiceSedeUbicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodiceSedeUbicazione(Integer value) {
        this.codiceSedeUbicazione = value;
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
     * Recupera il valore della proprietà descrElemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrElemento() {
        return descrElemento;
    }

    /**
     * Imposta il valore della proprietà descrElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrElemento(String value) {
        this.descrElemento = value;
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
     * Recupera il valore della proprietà elencoUtilizzoSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElencoUtilizzoSede() {
        return elencoUtilizzoSede;
    }

    /**
     * Imposta il valore della proprietà elencoUtilizzoSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElencoUtilizzoSede(String value) {
        this.elencoUtilizzoSede = value;
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

    /**
     * Recupera il valore della proprietà ubicazioneCodiceComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazioneCodiceComune() {
        return ubicazioneCodiceComune;
    }

    /**
     * Imposta il valore della proprietà ubicazioneCodiceComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazioneCodiceComune(String value) {
        this.ubicazioneCodiceComune = value;
    }

    /**
     * Recupera il valore della proprietà ubicazioneCodiceProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazioneCodiceProvincia() {
        return ubicazioneCodiceProvincia;
    }

    /**
     * Imposta il valore della proprietà ubicazioneCodiceProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazioneCodiceProvincia(String value) {
        this.ubicazioneCodiceProvincia = value;
    }

    /**
     * Recupera il valore della proprietà ubicazioneDenominazioneComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazioneDenominazioneComune() {
        return ubicazioneDenominazioneComune;
    }

    /**
     * Imposta il valore della proprietà ubicazioneDenominazioneComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazioneDenominazioneComune(String value) {
        this.ubicazioneDenominazioneComune = value;
    }

    /**
     * Recupera il valore della proprietà ubicazioneIndirizzo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazioneIndirizzo() {
        return ubicazioneIndirizzo;
    }

    /**
     * Imposta il valore della proprietà ubicazioneIndirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazioneIndirizzo(String value) {
        this.ubicazioneIndirizzo = value;
    }

    /**
     * Recupera il valore della proprietà ubicazioneLuogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazioneLuogo() {
        return ubicazioneLuogo;
    }

    /**
     * Imposta il valore della proprietà ubicazioneLuogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazioneLuogo(String value) {
        this.ubicazioneLuogo = value;
    }

    /**
     * Recupera il valore della proprietà ubicazioneSiglaProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicazioneSiglaProvincia() {
        return ubicazioneSiglaProvincia;
    }

    /**
     * Imposta il valore della proprietà ubicazioneSiglaProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicazioneSiglaProvincia(String value) {
        this.ubicazioneSiglaProvincia = value;
    }

    /**
     * Recupera il valore della proprietà utilizzatoTutteSedi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtilizzatoTutteSedi() {
        return utilizzatoTutteSedi;
    }

    /**
     * Imposta il valore della proprietà utilizzatoTutteSedi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtilizzatoTutteSedi(String value) {
        this.utilizzatoTutteSedi = value;
    }

}
