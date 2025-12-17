
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
 * <p>Classe Java per concludiEdizioneDestinatariDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="concludiEdizioneDestinatariDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cognomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cfDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idProgetto" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="flgRitirato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataRitiro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="motivazioneRitiro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgUditore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgPagante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgDisabile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orePresenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="oreCreditoFormativo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="oreAssenzaGiustificate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="oreAnteIscrizione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="autoCertReinserito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertApprendista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertTirLav" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertDisabRicond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertAssunzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeratoreMaxOreAssenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="denominatoreMaxOreAssenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="orePrevisteEsame" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="flgAssenzaEsame" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreCommittente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreCommittente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codSedeCommittente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "concludiEdizioneDestinatariDto", propOrder = {
    "cognomeDestinatario",
    "nomeDestinatario",
    "cfDestinatario",
    "idProgetto",
    "flgRitirato",
    "dataRitiro",
    "motivazioneRitiro",
    "flgUditore",
    "flgPagante",
    "flgDisabile",
    "orePresenza",
    "oreCreditoFormativo",
    "oreAssenzaGiustificate",
    "oreAnteIscrizione",
    "autoCertReinserito",
    "autoCertApprendista",
    "autoCertTirLav",
    "autoCertDisabRicond",
    "autoCertAssunzione",
    "numeratoreMaxOreAssenza",
    "denominatoreMaxOreAssenza",
    "orePrevisteEsame",
    "flgAssenzaEsame",
    "gruppoOperatoreCommittente",
    "codOperatoreCommittente",
    "codSedeCommittente"
})
public class ConcludiEdizioneDestinatariDto {

    @XmlElement(required = true)
    protected String cognomeDestinatario;
    @XmlElement(required = true)
    protected String nomeDestinatario;
    @XmlElement(required = true)
    protected String cfDestinatario;
    protected Long idProgetto;
    protected String flgRitirato;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRitiro;
    protected String motivazioneRitiro;
    protected String flgUditore;
    protected String flgPagante;
    protected String flgDisabile;
    protected BigDecimal orePresenza;
    protected BigDecimal oreCreditoFormativo;
    protected BigDecimal oreAssenzaGiustificate;
    protected BigDecimal oreAnteIscrizione;
    protected String autoCertReinserito;
    protected String autoCertApprendista;
    protected String autoCertTirLav;
    protected String autoCertDisabRicond;
    protected String autoCertAssunzione;
    protected BigDecimal numeratoreMaxOreAssenza;
    protected BigDecimal denominatoreMaxOreAssenza;
    protected BigDecimal orePrevisteEsame;
    protected String flgAssenzaEsame;
    protected String gruppoOperatoreCommittente;
    protected Long codOperatoreCommittente;
    protected Long codSedeCommittente;

    /**
     * Recupera il valore della proprietà cognomeDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognomeDestinatario() {
        return cognomeDestinatario;
    }

    /**
     * Imposta il valore della proprietà cognomeDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognomeDestinatario(String value) {
        this.cognomeDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà nomeDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    /**
     * Imposta il valore della proprietà nomeDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeDestinatario(String value) {
        this.nomeDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà cfDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfDestinatario() {
        return cfDestinatario;
    }

    /**
     * Imposta il valore della proprietà cfDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfDestinatario(String value) {
        this.cfDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà idProgetto.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdProgetto() {
        return idProgetto;
    }

    /**
     * Imposta il valore della proprietà idProgetto.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdProgetto(Long value) {
        this.idProgetto = value;
    }

    /**
     * Recupera il valore della proprietà flgRitirato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgRitirato() {
        return flgRitirato;
    }

    /**
     * Imposta il valore della proprietà flgRitirato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgRitirato(String value) {
        this.flgRitirato = value;
    }

    /**
     * Recupera il valore della proprietà dataRitiro.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRitiro() {
        return dataRitiro;
    }

    /**
     * Imposta il valore della proprietà dataRitiro.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRitiro(XMLGregorianCalendar value) {
        this.dataRitiro = value;
    }

    /**
     * Recupera il valore della proprietà motivazioneRitiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivazioneRitiro() {
        return motivazioneRitiro;
    }

    /**
     * Imposta il valore della proprietà motivazioneRitiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivazioneRitiro(String value) {
        this.motivazioneRitiro = value;
    }

    /**
     * Recupera il valore della proprietà flgUditore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgUditore() {
        return flgUditore;
    }

    /**
     * Imposta il valore della proprietà flgUditore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgUditore(String value) {
        this.flgUditore = value;
    }

    /**
     * Recupera il valore della proprietà flgPagante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgPagante() {
        return flgPagante;
    }

    /**
     * Imposta il valore della proprietà flgPagante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgPagante(String value) {
        this.flgPagante = value;
    }

    /**
     * Recupera il valore della proprietà flgDisabile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgDisabile() {
        return flgDisabile;
    }

    /**
     * Imposta il valore della proprietà flgDisabile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgDisabile(String value) {
        this.flgDisabile = value;
    }

    /**
     * Recupera il valore della proprietà orePresenza.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrePresenza() {
        return orePresenza;
    }

    /**
     * Imposta il valore della proprietà orePresenza.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrePresenza(BigDecimal value) {
        this.orePresenza = value;
    }

    /**
     * Recupera il valore della proprietà oreCreditoFormativo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOreCreditoFormativo() {
        return oreCreditoFormativo;
    }

    /**
     * Imposta il valore della proprietà oreCreditoFormativo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOreCreditoFormativo(BigDecimal value) {
        this.oreCreditoFormativo = value;
    }

    /**
     * Recupera il valore della proprietà oreAssenzaGiustificate.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOreAssenzaGiustificate() {
        return oreAssenzaGiustificate;
    }

    /**
     * Imposta il valore della proprietà oreAssenzaGiustificate.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOreAssenzaGiustificate(BigDecimal value) {
        this.oreAssenzaGiustificate = value;
    }

    /**
     * Recupera il valore della proprietà oreAnteIscrizione.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOreAnteIscrizione() {
        return oreAnteIscrizione;
    }

    /**
     * Imposta il valore della proprietà oreAnteIscrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOreAnteIscrizione(BigDecimal value) {
        this.oreAnteIscrizione = value;
    }

    /**
     * Recupera il valore della proprietà autoCertReinserito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertReinserito() {
        return autoCertReinserito;
    }

    /**
     * Imposta il valore della proprietà autoCertReinserito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertReinserito(String value) {
        this.autoCertReinserito = value;
    }

    /**
     * Recupera il valore della proprietà autoCertApprendista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertApprendista() {
        return autoCertApprendista;
    }

    /**
     * Imposta il valore della proprietà autoCertApprendista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertApprendista(String value) {
        this.autoCertApprendista = value;
    }

    /**
     * Recupera il valore della proprietà autoCertTirLav.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertTirLav() {
        return autoCertTirLav;
    }

    /**
     * Imposta il valore della proprietà autoCertTirLav.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertTirLav(String value) {
        this.autoCertTirLav = value;
    }

    /**
     * Recupera il valore della proprietà autoCertDisabRicond.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertDisabRicond() {
        return autoCertDisabRicond;
    }

    /**
     * Imposta il valore della proprietà autoCertDisabRicond.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertDisabRicond(String value) {
        this.autoCertDisabRicond = value;
    }

    /**
     * Recupera il valore della proprietà autoCertAssunzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertAssunzione() {
        return autoCertAssunzione;
    }

    /**
     * Imposta il valore della proprietà autoCertAssunzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertAssunzione(String value) {
        this.autoCertAssunzione = value;
    }

    /**
     * Recupera il valore della proprietà numeratoreMaxOreAssenza.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumeratoreMaxOreAssenza() {
        return numeratoreMaxOreAssenza;
    }

    /**
     * Imposta il valore della proprietà numeratoreMaxOreAssenza.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumeratoreMaxOreAssenza(BigDecimal value) {
        this.numeratoreMaxOreAssenza = value;
    }

    /**
     * Recupera il valore della proprietà denominatoreMaxOreAssenza.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDenominatoreMaxOreAssenza() {
        return denominatoreMaxOreAssenza;
    }

    /**
     * Imposta il valore della proprietà denominatoreMaxOreAssenza.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDenominatoreMaxOreAssenza(BigDecimal value) {
        this.denominatoreMaxOreAssenza = value;
    }

    /**
     * Recupera il valore della proprietà orePrevisteEsame.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrePrevisteEsame() {
        return orePrevisteEsame;
    }

    /**
     * Imposta il valore della proprietà orePrevisteEsame.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrePrevisteEsame(BigDecimal value) {
        this.orePrevisteEsame = value;
    }

    /**
     * Recupera il valore della proprietà flgAssenzaEsame.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgAssenzaEsame() {
        return flgAssenzaEsame;
    }

    /**
     * Imposta il valore della proprietà flgAssenzaEsame.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgAssenzaEsame(String value) {
        this.flgAssenzaEsame = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreCommittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreCommittente() {
        return gruppoOperatoreCommittente;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreCommittente(String value) {
        this.gruppoOperatoreCommittente = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreCommittente.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatoreCommittente() {
        return codOperatoreCommittente;
    }

    /**
     * Imposta il valore della proprietà codOperatoreCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatoreCommittente(Long value) {
        this.codOperatoreCommittente = value;
    }

    /**
     * Recupera il valore della proprietà codSedeCommittente.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodSedeCommittente() {
        return codSedeCommittente;
    }

    /**
     * Imposta il valore della proprietà codSedeCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodSedeCommittente(Long value) {
        this.codSedeCommittente = value;
    }

}
