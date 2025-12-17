
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
 * <p>Classe Java per verificaBudgetImpegnoDestinatarioDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="verificaBudgetImpegnoDestinatarioDto"&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificaBudgetImpegnoDestinatarioDto", propOrder = {
    "cognomeDestinatario",
    "nomeDestinatario",
    "codFiscDestinatario",
    "identificativoProgetto",
    "orePresenza",
    "oreAssenza",
    "oreCreditoFormativo",
    "flgRitirato",
    "flgUditore"
})
public class VerificaBudgetImpegnoDestinatarioDto {

    protected String cognomeDestinatario;
    protected String nomeDestinatario;
    protected String codFiscDestinatario;
    protected BigDecimal identificativoProgetto;
    protected BigDecimal orePresenza;
    protected BigDecimal oreAssenza;
    protected BigDecimal oreCreditoFormativo;
    protected String flgRitirato;
    protected String flgUditore;

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

}
