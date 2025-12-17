
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
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per destinatariAttivitaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="destinatariAttivitaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cfDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cognomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idProgetto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="orePresenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="oreAssenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="oreCreditoFormativo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="flgRitirato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgUditore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgAmmissibile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idDestinatario" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dataChiusuraProgetto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="oreAssenzaGiustificate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="flgPagante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgDisabile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oreAnteIscrizione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="autoCertificazioneReinseritoPercorsoStrutt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertificazioneAssuntoApprendista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertificazioneInseritoTirocinioLavoro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertificazioneDisMansioneRicond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="autoCertificazioneAssunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeratoreMaxOreAssenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="denominatoreMaxOreAssenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="orePrevisteEsame" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="flgAssenzaEsame" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTipolContributo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="descrTipolContributo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oreFrequenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoPubblico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoPrivato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="dataRitiro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dataIscrizione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destinatariAttivitaDto", propOrder = {
    "cfDestinatario",
    "cognomeDestinatario",
    "nomeDestinatario",
    "idProgetto",
    "orePresenza",
    "oreAssenza",
    "oreCreditoFormativo",
    "flgRitirato",
    "flgUditore",
    "flgAmmissibile",
    "idDestinatario",
    "idInterventoApprovato",
    "dataChiusuraProgetto",
    "oreAssenzaGiustificate",
    "flgPagante",
    "flgDisabile",
    "oreAnteIscrizione",
    "autoCertificazioneReinseritoPercorsoStrutt",
    "autoCertificazioneAssuntoApprendista",
    "autoCertificazioneInseritoTirocinioLavoro",
    "autoCertificazioneDisMansioneRicond",
    "autoCertificazioneAssunto",
    "numeratoreMaxOreAssenza",
    "denominatoreMaxOreAssenza",
    "orePrevisteEsame",
    "flgAssenzaEsame",
    "idTipolContributo",
    "descrTipolContributo",
    "oreFrequenza",
    "importoPubblico",
    "importoPrivato",
    "dataRitiro",
    "dataIscrizione"
})
public class DestinatariAttivitaDto {

    protected String cfDestinatario;
    protected String cognomeDestinatario;
    protected String nomeDestinatario;
    protected BigDecimal idProgetto;
    protected BigDecimal orePresenza;
    protected BigDecimal oreAssenza;
    protected BigDecimal oreCreditoFormativo;
    protected String flgRitirato;
    protected String flgUditore;
    protected String flgAmmissibile;
    protected BigDecimal idDestinatario;
    @XmlElement(nillable = true)
    protected List<BigDecimal> idInterventoApprovato;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataChiusuraProgetto;
    protected BigDecimal oreAssenzaGiustificate;
    protected String flgPagante;
    protected String flgDisabile;
    protected BigDecimal oreAnteIscrizione;
    protected String autoCertificazioneReinseritoPercorsoStrutt;
    protected String autoCertificazioneAssuntoApprendista;
    protected String autoCertificazioneInseritoTirocinioLavoro;
    protected String autoCertificazioneDisMansioneRicond;
    protected String autoCertificazioneAssunto;
    protected BigDecimal numeratoreMaxOreAssenza;
    protected BigDecimal denominatoreMaxOreAssenza;
    protected BigDecimal orePrevisteEsame;
    protected String flgAssenzaEsame;
    protected Long idTipolContributo;
    protected String descrTipolContributo;
    protected BigDecimal oreFrequenza;
    protected BigDecimal importoPubblico;
    protected BigDecimal importoPrivato;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRitiro;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataIscrizione;

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
     * Recupera il valore della proprietà idProgetto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdProgetto() {
        return idProgetto;
    }

    /**
     * Imposta il valore della proprietà idProgetto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdProgetto(BigDecimal value) {
        this.idProgetto = value;
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
     * Recupera il valore della proprietà oreAssenza.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOreAssenza() {
        return oreAssenza;
    }

    /**
     * Imposta il valore della proprietà oreAssenza.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOreAssenza(BigDecimal value) {
        this.oreAssenza = value;
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
     * Recupera il valore della proprietà flgAmmissibile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgAmmissibile() {
        return flgAmmissibile;
    }

    /**
     * Imposta il valore della proprietà flgAmmissibile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgAmmissibile(String value) {
        this.flgAmmissibile = value;
    }

    /**
     * Recupera il valore della proprietà idDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdDestinatario() {
        return idDestinatario;
    }

    /**
     * Imposta il valore della proprietà idDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdDestinatario(BigDecimal value) {
        this.idDestinatario = value;
    }

    /**
     * Gets the value of the idInterventoApprovato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the idInterventoApprovato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdInterventoApprovato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigDecimal }
     * 
     * 
     */
    public List<BigDecimal> getIdInterventoApprovato() {
        if (idInterventoApprovato == null) {
            idInterventoApprovato = new ArrayList<BigDecimal>();
        }
        return this.idInterventoApprovato;
    }

    /**
     * Recupera il valore della proprietà dataChiusuraProgetto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataChiusuraProgetto() {
        return dataChiusuraProgetto;
    }

    /**
     * Imposta il valore della proprietà dataChiusuraProgetto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataChiusuraProgetto(XMLGregorianCalendar value) {
        this.dataChiusuraProgetto = value;
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
     * Recupera il valore della proprietà autoCertificazioneReinseritoPercorsoStrutt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertificazioneReinseritoPercorsoStrutt() {
        return autoCertificazioneReinseritoPercorsoStrutt;
    }

    /**
     * Imposta il valore della proprietà autoCertificazioneReinseritoPercorsoStrutt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertificazioneReinseritoPercorsoStrutt(String value) {
        this.autoCertificazioneReinseritoPercorsoStrutt = value;
    }

    /**
     * Recupera il valore della proprietà autoCertificazioneAssuntoApprendista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertificazioneAssuntoApprendista() {
        return autoCertificazioneAssuntoApprendista;
    }

    /**
     * Imposta il valore della proprietà autoCertificazioneAssuntoApprendista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertificazioneAssuntoApprendista(String value) {
        this.autoCertificazioneAssuntoApprendista = value;
    }

    /**
     * Recupera il valore della proprietà autoCertificazioneInseritoTirocinioLavoro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertificazioneInseritoTirocinioLavoro() {
        return autoCertificazioneInseritoTirocinioLavoro;
    }

    /**
     * Imposta il valore della proprietà autoCertificazioneInseritoTirocinioLavoro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertificazioneInseritoTirocinioLavoro(String value) {
        this.autoCertificazioneInseritoTirocinioLavoro = value;
    }

    /**
     * Recupera il valore della proprietà autoCertificazioneDisMansioneRicond.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertificazioneDisMansioneRicond() {
        return autoCertificazioneDisMansioneRicond;
    }

    /**
     * Imposta il valore della proprietà autoCertificazioneDisMansioneRicond.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertificazioneDisMansioneRicond(String value) {
        this.autoCertificazioneDisMansioneRicond = value;
    }

    /**
     * Recupera il valore della proprietà autoCertificazioneAssunto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCertificazioneAssunto() {
        return autoCertificazioneAssunto;
    }

    /**
     * Imposta il valore della proprietà autoCertificazioneAssunto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCertificazioneAssunto(String value) {
        this.autoCertificazioneAssunto = value;
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
     * Recupera il valore della proprietà idTipolContributo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdTipolContributo() {
        return idTipolContributo;
    }

    /**
     * Imposta il valore della proprietà idTipolContributo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdTipolContributo(Long value) {
        this.idTipolContributo = value;
    }

    /**
     * Recupera il valore della proprietà descrTipolContributo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrTipolContributo() {
        return descrTipolContributo;
    }

    /**
     * Imposta il valore della proprietà descrTipolContributo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrTipolContributo(String value) {
        this.descrTipolContributo = value;
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
     * Recupera il valore della proprietà importoPubblico.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoPubblico() {
        return importoPubblico;
    }

    /**
     * Imposta il valore della proprietà importoPubblico.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoPubblico(BigDecimal value) {
        this.importoPubblico = value;
    }

    /**
     * Recupera il valore della proprietà importoPrivato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoPrivato() {
        return importoPrivato;
    }

    /**
     * Imposta il valore della proprietà importoPrivato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoPrivato(BigDecimal value) {
        this.importoPrivato = value;
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
     * Recupera il valore della proprietà dataIscrizione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataIscrizione() {
        return dataIscrizione;
    }

    /**
     * Imposta il valore della proprietà dataIscrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataIscrizione(XMLGregorianCalendar value) {
        this.dataIscrizione = value;
    }

}
