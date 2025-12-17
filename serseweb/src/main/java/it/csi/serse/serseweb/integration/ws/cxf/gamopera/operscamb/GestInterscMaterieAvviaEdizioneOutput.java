
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
 * <p>Classe Java per gestInterscMaterieAvviaEdizioneOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieAvviaEdizioneOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codMessaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoControlloBudget" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreEconomicoAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="budgetInizialeInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="budgetResiduoInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieAvviaEdizioneOutput", propOrder = {
    "codMessaggioRisposta",
    "messaggioRisposta",
    "esitoControlloBudget",
    "valoreEconomicoAttivita",
    "budgetInizialeInterventoApprovato",
    "budgetResiduoInterventoApprovato"
})
public class GestInterscMaterieAvviaEdizioneOutput {

    protected String codMessaggioRisposta;
    protected String messaggioRisposta;
    protected String esitoControlloBudget;
    protected BigDecimal valoreEconomicoAttivita;
    protected BigDecimal budgetInizialeInterventoApprovato;
    protected BigDecimal budgetResiduoInterventoApprovato;

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
     * Recupera il valore della proprietà esitoControlloBudget.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoControlloBudget() {
        return esitoControlloBudget;
    }

    /**
     * Imposta il valore della proprietà esitoControlloBudget.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoControlloBudget(String value) {
        this.esitoControlloBudget = value;
    }

    /**
     * Recupera il valore della proprietà valoreEconomicoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValoreEconomicoAttivita() {
        return valoreEconomicoAttivita;
    }

    /**
     * Imposta il valore della proprietà valoreEconomicoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValoreEconomicoAttivita(BigDecimal value) {
        this.valoreEconomicoAttivita = value;
    }

    /**
     * Recupera il valore della proprietà budgetInizialeInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBudgetInizialeInterventoApprovato() {
        return budgetInizialeInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà budgetInizialeInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBudgetInizialeInterventoApprovato(BigDecimal value) {
        this.budgetInizialeInterventoApprovato = value;
    }

    /**
     * Recupera il valore della proprietà budgetResiduoInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBudgetResiduoInterventoApprovato() {
        return budgetResiduoInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà budgetResiduoInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBudgetResiduoInterventoApprovato(BigDecimal value) {
        this.budgetResiduoInterventoApprovato = value;
    }

}
