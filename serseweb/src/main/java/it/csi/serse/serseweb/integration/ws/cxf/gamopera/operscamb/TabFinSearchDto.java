
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
 * <p>Classe Java per tabFinSearchDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="tabFinSearchDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idSportelloGam" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idTabFinanziamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codStatoTabFinanziamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrStatoTabFinanziamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idOccorrenzaTabFin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idClassificTabFin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="asse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="obiettivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAzioneGam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codProgrammazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codNaturaFinanziamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFonteGam" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codAreaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFascia" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tabFinSearchDto", propOrder = {
    "idSportelloGam",
    "idTabFinanziamento",
    "codStatoTabFinanziamento",
    "descrStatoTabFinanziamento",
    "idOccorrenzaTabFin",
    "idClassificTabFin",
    "asse",
    "obiettivo",
    "attivita",
    "codAzioneGam",
    "codProgrammazione",
    "codNaturaFinanziamento",
    "idFonteGam",
    "importo",
    "codAreaTerritoriale",
    "idFascia"
})
public class TabFinSearchDto {

    protected BigDecimal idSportelloGam;
    protected BigDecimal idTabFinanziamento;
    protected String codStatoTabFinanziamento;
    protected String descrStatoTabFinanziamento;
    protected BigDecimal idOccorrenzaTabFin;
    protected BigDecimal idClassificTabFin;
    protected String asse;
    protected String obiettivo;
    protected String attivita;
    protected String codAzioneGam;
    protected String codProgrammazione;
    protected String codNaturaFinanziamento;
    protected BigDecimal idFonteGam;
    protected BigDecimal importo;
    protected String codAreaTerritoriale;
    protected BigDecimal idFascia;

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
     * Recupera il valore della proprietà idTabFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdTabFinanziamento() {
        return idTabFinanziamento;
    }

    /**
     * Imposta il valore della proprietà idTabFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdTabFinanziamento(BigDecimal value) {
        this.idTabFinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà codStatoTabFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodStatoTabFinanziamento() {
        return codStatoTabFinanziamento;
    }

    /**
     * Imposta il valore della proprietà codStatoTabFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodStatoTabFinanziamento(String value) {
        this.codStatoTabFinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà descrStatoTabFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrStatoTabFinanziamento() {
        return descrStatoTabFinanziamento;
    }

    /**
     * Imposta il valore della proprietà descrStatoTabFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrStatoTabFinanziamento(String value) {
        this.descrStatoTabFinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà idOccorrenzaTabFin.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdOccorrenzaTabFin() {
        return idOccorrenzaTabFin;
    }

    /**
     * Imposta il valore della proprietà idOccorrenzaTabFin.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdOccorrenzaTabFin(BigDecimal value) {
        this.idOccorrenzaTabFin = value;
    }

    /**
     * Recupera il valore della proprietà idClassificTabFin.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdClassificTabFin() {
        return idClassificTabFin;
    }

    /**
     * Imposta il valore della proprietà idClassificTabFin.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdClassificTabFin(BigDecimal value) {
        this.idClassificTabFin = value;
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
     * Recupera il valore della proprietà codProgrammazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProgrammazione() {
        return codProgrammazione;
    }

    /**
     * Imposta il valore della proprietà codProgrammazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProgrammazione(String value) {
        this.codProgrammazione = value;
    }

    /**
     * Recupera il valore della proprietà codNaturaFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNaturaFinanziamento() {
        return codNaturaFinanziamento;
    }

    /**
     * Imposta il valore della proprietà codNaturaFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNaturaFinanziamento(String value) {
        this.codNaturaFinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà idFonteGam.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdFonteGam() {
        return idFonteGam;
    }

    /**
     * Imposta il valore della proprietà idFonteGam.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdFonteGam(BigDecimal value) {
        this.idFonteGam = value;
    }

    /**
     * Recupera il valore della proprietà importo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImporto() {
        return importo;
    }

    /**
     * Imposta il valore della proprietà importo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImporto(BigDecimal value) {
        this.importo = value;
    }

    /**
     * Recupera il valore della proprietà codAreaTerritoriale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAreaTerritoriale() {
        return codAreaTerritoriale;
    }

    /**
     * Imposta il valore della proprietà codAreaTerritoriale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAreaTerritoriale(String value) {
        this.codAreaTerritoriale = value;
    }

    /**
     * Recupera il valore della proprietà idFascia.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdFascia() {
        return idFascia;
    }

    /**
     * Imposta il valore della proprietà idFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdFascia(BigDecimal value) {
        this.idFascia = value;
    }

}
