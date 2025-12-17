
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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per searchAttivitaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="searchAttivitaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="statoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descStatoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codClasseAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descClasseAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idOperazione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descBreveTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchAttivitaDto", propOrder = {
    "idInterventoApprovato",
    "idSoggettoFinanziato",
    "idAttivita",
    "idAttivitaMateria",
    "statoAttivita",
    "descStatoAttivita",
    "codTipoAttivita",
    "descTipoAttivita",
    "codClasseAttivita",
    "descClasseAttivita",
    "codOperatoreSA",
    "gruppoOperatoreSA",
    "idOperazione",
    "codTipoMateria",
    "codTipoRichiesta",
    "descBreveTipoAttivita"
})
public class SearchAttivitaDto {

    protected BigDecimal idInterventoApprovato;
    protected BigDecimal idSoggettoFinanziato;
    protected BigDecimal idAttivita;
    protected BigDecimal idAttivitaMateria;
    protected String statoAttivita;
    protected String descStatoAttivita;
    protected String codTipoAttivita;
    protected String descTipoAttivita;
    protected String codClasseAttivita;
    protected String descClasseAttivita;
    protected BigDecimal codOperatoreSA;
    protected String gruppoOperatoreSA;
    protected BigDecimal idOperazione;
    @XmlElement(required = true)
    protected String codTipoMateria;
    @XmlElement(required = true)
    protected String codTipoRichiesta;
    protected String descBreveTipoAttivita;

    /**
     * Recupera il valore della proprietà idInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdInterventoApprovato() {
        return idInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdInterventoApprovato(BigDecimal value) {
        this.idInterventoApprovato = value;
    }

    /**
     * Recupera il valore della proprietà idSoggettoFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdSoggettoFinanziato() {
        return idSoggettoFinanziato;
    }

    /**
     * Imposta il valore della proprietà idSoggettoFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdSoggettoFinanziato(BigDecimal value) {
        this.idSoggettoFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà idAttivita.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdAttivita() {
        return idAttivita;
    }

    /**
     * Imposta il valore della proprietà idAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdAttivita(BigDecimal value) {
        this.idAttivita = value;
    }

    /**
     * Recupera il valore della proprietà idAttivitaMateria.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdAttivitaMateria() {
        return idAttivitaMateria;
    }

    /**
     * Imposta il valore della proprietà idAttivitaMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdAttivitaMateria(BigDecimal value) {
        this.idAttivitaMateria = value;
    }

    /**
     * Recupera il valore della proprietà statoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoAttivita() {
        return statoAttivita;
    }

    /**
     * Imposta il valore della proprietà statoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoAttivita(String value) {
        this.statoAttivita = value;
    }

    /**
     * Recupera il valore della proprietà descStatoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescStatoAttivita() {
        return descStatoAttivita;
    }

    /**
     * Imposta il valore della proprietà descStatoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescStatoAttivita(String value) {
        this.descStatoAttivita = value;
    }

    /**
     * Recupera il valore della proprietà codTipoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoAttivita() {
        return codTipoAttivita;
    }

    /**
     * Imposta il valore della proprietà codTipoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoAttivita(String value) {
        this.codTipoAttivita = value;
    }

    /**
     * Recupera il valore della proprietà descTipoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoAttivita() {
        return descTipoAttivita;
    }

    /**
     * Imposta il valore della proprietà descTipoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoAttivita(String value) {
        this.descTipoAttivita = value;
    }

    /**
     * Recupera il valore della proprietà codClasseAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodClasseAttivita() {
        return codClasseAttivita;
    }

    /**
     * Imposta il valore della proprietà codClasseAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodClasseAttivita(String value) {
        this.codClasseAttivita = value;
    }

    /**
     * Recupera il valore della proprietà descClasseAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescClasseAttivita() {
        return descClasseAttivita;
    }

    /**
     * Imposta il valore della proprietà descClasseAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescClasseAttivita(String value) {
        this.descClasseAttivita = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreSA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodOperatoreSA() {
        return codOperatoreSA;
    }

    /**
     * Imposta il valore della proprietà codOperatoreSA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodOperatoreSA(BigDecimal value) {
        this.codOperatoreSA = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreSA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreSA() {
        return gruppoOperatoreSA;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreSA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreSA(String value) {
        this.gruppoOperatoreSA = value;
    }

    /**
     * Recupera il valore della proprietà idOperazione.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdOperazione() {
        return idOperazione;
    }

    /**
     * Imposta il valore della proprietà idOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdOperazione(BigDecimal value) {
        this.idOperazione = value;
    }

    /**
     * Recupera il valore della proprietà codTipoMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoMateria() {
        return codTipoMateria;
    }

    /**
     * Imposta il valore della proprietà codTipoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoMateria(String value) {
        this.codTipoMateria = value;
    }

    /**
     * Recupera il valore della proprietà codTipoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoRichiesta() {
        return codTipoRichiesta;
    }

    /**
     * Imposta il valore della proprietà codTipoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoRichiesta(String value) {
        this.codTipoRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà descBreveTipoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescBreveTipoAttivita() {
        return descBreveTipoAttivita;
    }

    /**
     * Imposta il valore della proprietà descBreveTipoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescBreveTipoAttivita(String value) {
        this.descBreveTipoAttivita = value;
    }

}
