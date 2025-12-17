
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
 * <p>Classe Java per destinatarioAvviaEdizioneDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="destinatarioAvviaEdizioneDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cognomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nomeDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codFiscDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificativoProgetto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="orePresenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="oreAssenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="oreCreditoFormativo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="flgRitirato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgUditore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgPagante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreCommittente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreCommittente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codSedeCommittente" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codTipologiaContributo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="oreFrequenza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoPubblico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoPrivato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destinatarioAvviaEdizioneDto", propOrder = {
    "cognomeDestinatario",
    "nomeDestinatario",
    "codFiscDestinatario",
    "identificativoProgetto",
    "orePresenza",
    "oreAssenza",
    "oreCreditoFormativo",
    "flgRitirato",
    "flgUditore",
    "flgPagante",
    "gruppoOperatoreCommittente",
    "codOperatoreCommittente",
    "codSedeCommittente",
    "codTipologiaContributo",
    "oreFrequenza",
    "importoPubblico",
    "importoPrivato"
})
public class DestinatarioAvviaEdizioneDto {

    protected String cognomeDestinatario;
    protected String nomeDestinatario;
    protected String codFiscDestinatario;
    protected BigDecimal identificativoProgetto;
    protected BigDecimal orePresenza;
    protected BigDecimal oreAssenza;
    protected BigDecimal oreCreditoFormativo;
    protected String flgRitirato;
    protected String flgUditore;
    protected String flgPagante;
    protected String gruppoOperatoreCommittente;
    protected Long codOperatoreCommittente;
    protected Long codSedeCommittente;
    protected Long codTipologiaContributo;
    protected BigDecimal oreFrequenza;
    protected BigDecimal importoPubblico;
    protected BigDecimal importoPrivato;

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
     * Recupera il valore della proprietà codFiscDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscDestinatario() {
        return codFiscDestinatario;
    }

    /**
     * Imposta il valore della proprietà codFiscDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscDestinatario(String value) {
        this.codFiscDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà identificativoProgetto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdentificativoProgetto() {
        return identificativoProgetto;
    }

    /**
     * Imposta il valore della proprietà identificativoProgetto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdentificativoProgetto(BigDecimal value) {
        this.identificativoProgetto = value;
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

    /**
     * Recupera il valore della proprietà codTipologiaContributo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodTipologiaContributo() {
        return codTipologiaContributo;
    }

    /**
     * Imposta il valore della proprietà codTipologiaContributo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodTipologiaContributo(Long value) {
        this.codTipologiaContributo = value;
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

}
