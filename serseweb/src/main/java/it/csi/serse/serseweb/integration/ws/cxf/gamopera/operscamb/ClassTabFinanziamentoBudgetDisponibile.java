
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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per classTabFinanziamentoBudgetDisponibile complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="classTabFinanziamentoBudgetDisponibile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codAreaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFascia" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="asse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="obiettivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="importoStanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoUtilizzato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoResiduo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importiFonte" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}fontiImportiBudgetDisponibile" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classTabFinanziamentoBudgetDisponibile", propOrder = {
    "codAreaTerritoriale",
    "idFascia",
    "asse",
    "obiettivo",
    "attivita",
    "codAzione",
    "importoStanziato",
    "importoUtilizzato",
    "importoResiduo",
    "importiFonte"
})
public class ClassTabFinanziamentoBudgetDisponibile {

    protected String codAreaTerritoriale;
    protected Long idFascia;
    protected String asse;
    protected String obiettivo;
    protected String attivita;
    protected String codAzione;
    protected BigDecimal importoStanziato;
    protected BigDecimal importoUtilizzato;
    protected BigDecimal importoResiduo;
    @XmlElement(nillable = true)
    protected List<FontiImportiBudgetDisponibile> importiFonte;

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
     *     {@link Long }
     *     
     */
    public Long getIdFascia() {
        return idFascia;
    }

    /**
     * Imposta il valore della proprietà idFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFascia(Long value) {
        this.idFascia = value;
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
     * Recupera il valore della proprietà codAzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAzione() {
        return codAzione;
    }

    /**
     * Imposta il valore della proprietà codAzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAzione(String value) {
        this.codAzione = value;
    }

    /**
     * Recupera il valore della proprietà importoStanziato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoStanziato() {
        return importoStanziato;
    }

    /**
     * Imposta il valore della proprietà importoStanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoStanziato(BigDecimal value) {
        this.importoStanziato = value;
    }

    /**
     * Recupera il valore della proprietà importoUtilizzato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoUtilizzato() {
        return importoUtilizzato;
    }

    /**
     * Imposta il valore della proprietà importoUtilizzato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoUtilizzato(BigDecimal value) {
        this.importoUtilizzato = value;
    }

    /**
     * Recupera il valore della proprietà importoResiduo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoResiduo() {
        return importoResiduo;
    }

    /**
     * Imposta il valore della proprietà importoResiduo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoResiduo(BigDecimal value) {
        this.importoResiduo = value;
    }

    /**
     * Gets the value of the importiFonte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the importiFonte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportiFonte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FontiImportiBudgetDisponibile }
     * 
     * 
     */
    public List<FontiImportiBudgetDisponibile> getImportiFonte() {
        if (importiFonte == null) {
            importiFonte = new ArrayList<FontiImportiBudgetDisponibile>();
        }
        return this.importiFonte;
    }

}
