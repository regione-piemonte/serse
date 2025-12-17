
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
 * <p>Classe Java per vociSpesaDatoEconomico complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="vociSpesaDatoEconomico"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codMessaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codVoceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreEconomico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valoreEconomicoUnitario" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="sogliaTemporaleMin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="sogliaTemporaleMax" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="sogliaDestinatariMin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="sogliaDestinatariMax" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="nrDestinatariInclusi" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="unitaTemporaliIncluse" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="nrDestinatariEccedenti" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="unitaTemporaliEccedenti" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="descrizioneVoceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flagBackOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vociSpesaDatoEconomico", propOrder = {
    "codMessaggioRisposta",
    "messaggioRisposta",
    "codVoceSpesa",
    "valoreEconomico",
    "valoreEconomicoUnitario",
    "sogliaTemporaleMin",
    "sogliaTemporaleMax",
    "sogliaDestinatariMin",
    "sogliaDestinatariMax",
    "nrDestinatariInclusi",
    "unitaTemporaliIncluse",
    "nrDestinatariEccedenti",
    "unitaTemporaliEccedenti",
    "descrizioneVoceSpesa",
    "flagBackOffice"
})
public class VociSpesaDatoEconomico {

    protected String codMessaggioRisposta;
    protected String messaggioRisposta;
    protected String codVoceSpesa;
    protected BigDecimal valoreEconomico;
    protected BigDecimal valoreEconomicoUnitario;
    protected Long sogliaTemporaleMin;
    protected Long sogliaTemporaleMax;
    protected Long sogliaDestinatariMin;
    protected Long sogliaDestinatariMax;
    protected Long nrDestinatariInclusi;
    protected BigDecimal unitaTemporaliIncluse;
    protected Long nrDestinatariEccedenti;
    protected BigDecimal unitaTemporaliEccedenti;
    protected String descrizioneVoceSpesa;
    protected String flagBackOffice;

    /**
     * Recupera il valore della proprietà codMessaggioRisposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMessaggioRisposta() {
        return codMessaggioRisposta;
    }

    /**
     * Imposta il valore della proprietà codMessaggioRisposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMessaggioRisposta(String value) {
        this.codMessaggioRisposta = value;
    }

    /**
     * Recupera il valore della proprietà messaggioRisposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessaggioRisposta() {
        return messaggioRisposta;
    }

    /**
     * Imposta il valore della proprietà messaggioRisposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessaggioRisposta(String value) {
        this.messaggioRisposta = value;
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
     * Recupera il valore della proprietà valoreEconomico.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValoreEconomico() {
        return valoreEconomico;
    }

    /**
     * Imposta il valore della proprietà valoreEconomico.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValoreEconomico(BigDecimal value) {
        this.valoreEconomico = value;
    }

    /**
     * Recupera il valore della proprietà valoreEconomicoUnitario.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValoreEconomicoUnitario() {
        return valoreEconomicoUnitario;
    }

    /**
     * Imposta il valore della proprietà valoreEconomicoUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValoreEconomicoUnitario(BigDecimal value) {
        this.valoreEconomicoUnitario = value;
    }

    /**
     * Recupera il valore della proprietà sogliaTemporaleMin.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSogliaTemporaleMin() {
        return sogliaTemporaleMin;
    }

    /**
     * Imposta il valore della proprietà sogliaTemporaleMin.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSogliaTemporaleMin(Long value) {
        this.sogliaTemporaleMin = value;
    }

    /**
     * Recupera il valore della proprietà sogliaTemporaleMax.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSogliaTemporaleMax() {
        return sogliaTemporaleMax;
    }

    /**
     * Imposta il valore della proprietà sogliaTemporaleMax.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSogliaTemporaleMax(Long value) {
        this.sogliaTemporaleMax = value;
    }

    /**
     * Recupera il valore della proprietà sogliaDestinatariMin.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSogliaDestinatariMin() {
        return sogliaDestinatariMin;
    }

    /**
     * Imposta il valore della proprietà sogliaDestinatariMin.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSogliaDestinatariMin(Long value) {
        this.sogliaDestinatariMin = value;
    }

    /**
     * Recupera il valore della proprietà sogliaDestinatariMax.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSogliaDestinatariMax() {
        return sogliaDestinatariMax;
    }

    /**
     * Imposta il valore della proprietà sogliaDestinatariMax.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSogliaDestinatariMax(Long value) {
        this.sogliaDestinatariMax = value;
    }

    /**
     * Recupera il valore della proprietà nrDestinatariInclusi.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNrDestinatariInclusi() {
        return nrDestinatariInclusi;
    }

    /**
     * Imposta il valore della proprietà nrDestinatariInclusi.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNrDestinatariInclusi(Long value) {
        this.nrDestinatariInclusi = value;
    }

    /**
     * Recupera il valore della proprietà unitaTemporaliIncluse.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitaTemporaliIncluse() {
        return unitaTemporaliIncluse;
    }

    /**
     * Imposta il valore della proprietà unitaTemporaliIncluse.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitaTemporaliIncluse(BigDecimal value) {
        this.unitaTemporaliIncluse = value;
    }

    /**
     * Recupera il valore della proprietà nrDestinatariEccedenti.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNrDestinatariEccedenti() {
        return nrDestinatariEccedenti;
    }

    /**
     * Imposta il valore della proprietà nrDestinatariEccedenti.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNrDestinatariEccedenti(Long value) {
        this.nrDestinatariEccedenti = value;
    }

    /**
     * Recupera il valore della proprietà unitaTemporaliEccedenti.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitaTemporaliEccedenti() {
        return unitaTemporaliEccedenti;
    }

    /**
     * Imposta il valore della proprietà unitaTemporaliEccedenti.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitaTemporaliEccedenti(BigDecimal value) {
        this.unitaTemporaliEccedenti = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneVoceSpesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneVoceSpesa() {
        return descrizioneVoceSpesa;
    }

    /**
     * Imposta il valore della proprietà descrizioneVoceSpesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneVoceSpesa(String value) {
        this.descrizioneVoceSpesa = value;
    }

    /**
     * Recupera il valore della proprietà flagBackOffice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagBackOffice() {
        return flagBackOffice;
    }

    /**
     * Imposta il valore della proprietà flagBackOffice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagBackOffice(String value) {
        this.flagBackOffice = value;
    }

}
