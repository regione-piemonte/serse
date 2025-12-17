
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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestAttivitaGetDatoEconomicoInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestAttivitaGetDatoEconomicoInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idPSO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idSportelloGam" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="asse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="obiettivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAzioneGam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codRegola" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codSottoTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codVoceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annualita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numeroDestinatari" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="durataPrevista" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="unitaDurata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestAttivitaGetDatoEconomicoInput", propOrder = {
    "idPSO",
    "idSportelloGam",
    "asse",
    "obiettivo",
    "attivita",
    "codAzioneGam",
    "codTipo",
    "codRegola",
    "codTipologiaServizio",
    "codSottoTipologiaServizio",
    "codVoceSpesa",
    "annualita",
    "numeroDestinatari",
    "durataPrevista",
    "unitaDurata"
})
public class GestAttivitaGetDatoEconomicoInput {

    protected BigDecimal idPSO;
    protected BigDecimal idSportelloGam;
    protected String asse;
    protected String obiettivo;
    protected String attivita;
    protected String codAzioneGam;
    protected String codTipo;
    protected String codRegola;
    protected String codTipologiaServizio;
    protected BigDecimal codSottoTipologiaServizio;
    protected String codVoceSpesa;
    protected Long annualita;
    protected Long numeroDestinatari;
    protected BigDecimal durataPrevista;
    protected String unitaDurata;

    /**
     * Recupera il valore della proprietà idPSO.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdPSO() {
        return idPSO;
    }

    /**
     * Imposta il valore della proprietà idPSO.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdPSO(BigDecimal value) {
        this.idPSO = value;
    }

    /**
     * Recupera il valore della proprietà idSportelloGam.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdSportelloGam() {
        return idSportelloGam;
    }

    /**
     * Imposta il valore della proprietà idSportelloGam.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdSportelloGam(BigDecimal value) {
        this.idSportelloGam = value;
    }

    /**
     * Recupera il valore della proprietà asse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsse() {
        return asse;
    }

    /**
     * Imposta il valore della proprietà asse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsse(String value) {
        this.asse = value;
    }

    /**
     * Recupera il valore della proprietà obiettivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObiettivo() {
        return obiettivo;
    }

    /**
     * Imposta il valore della proprietà obiettivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObiettivo(String value) {
        this.obiettivo = value;
    }

    /**
     * Recupera il valore della proprietà attivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttivita() {
        return attivita;
    }

    /**
     * Imposta il valore della proprietà attivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttivita(String value) {
        this.attivita = value;
    }

    /**
     * Recupera il valore della proprietà codAzioneGam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAzioneGam() {
        return codAzioneGam;
    }

    /**
     * Imposta il valore della proprietà codAzioneGam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAzioneGam(String value) {
        this.codAzioneGam = value;
    }

    /**
     * Recupera il valore della proprietà codTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipo() {
        return codTipo;
    }

    /**
     * Imposta il valore della proprietà codTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipo(String value) {
        this.codTipo = value;
    }

    /**
     * Recupera il valore della proprietà codRegola.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRegola() {
        return codRegola;
    }

    /**
     * Imposta il valore della proprietà codRegola.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRegola(String value) {
        this.codRegola = value;
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
     * Recupera il valore della proprietà codVoceSpesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVoceSpesa() {
        return codVoceSpesa;
    }

    /**
     * Imposta il valore della proprietà codVoceSpesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVoceSpesa(String value) {
        this.codVoceSpesa = value;
    }

    /**
     * Recupera il valore della proprietà annualita.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnualita() {
        return annualita;
    }

    /**
     * Imposta il valore della proprietà annualita.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnualita(Long value) {
        this.annualita = value;
    }

    /**
     * Recupera il valore della proprietà numeroDestinatari.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroDestinatari() {
        return numeroDestinatari;
    }

    /**
     * Imposta il valore della proprietà numeroDestinatari.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroDestinatari(Long value) {
        this.numeroDestinatari = value;
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
     * Recupera il valore della proprietà unitaDurata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitaDurata() {
        return unitaDurata;
    }

    /**
     * Imposta il valore della proprietà unitaDurata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitaDurata(String value) {
        this.unitaDurata = value;
    }

}
