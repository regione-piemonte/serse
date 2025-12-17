
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
 * <p>Classe Java per verificaBudgetImpegnoConsumoOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="verificaBudgetImpegnoConsumoOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="importoInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codMessaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="budgetInizialeSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="budgetResiduoSoggFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="destinatariEsclusi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="unitaTemporaliEscluse" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificaBudgetImpegnoConsumoOutput", propOrder = {
    "importoInterventoApprovato",
    "codMessaggioRisposta",
    "messaggioRisposta",
    "budgetInizialeSoggFinanziato",
    "budgetResiduoSoggFinanziato",
    "destinatariEsclusi",
    "unitaTemporaliEscluse"
})
public class VerificaBudgetImpegnoConsumoOutput {

    protected BigDecimal importoInterventoApprovato;
    protected String codMessaggioRisposta;
    protected String messaggioRisposta;
    protected BigDecimal budgetInizialeSoggFinanziato;
    protected BigDecimal budgetResiduoSoggFinanziato;
    protected BigDecimal destinatariEsclusi;
    protected BigDecimal unitaTemporaliEscluse;

    /**
     * Recupera il valore della proprietà importoInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoInterventoApprovato() {
        return importoInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà importoInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoInterventoApprovato(BigDecimal value) {
        this.importoInterventoApprovato = value;
    }

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
     * Recupera il valore della proprietà budgetInizialeSoggFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBudgetInizialeSoggFinanziato() {
        return budgetInizialeSoggFinanziato;
    }

    /**
     * Imposta il valore della proprietà budgetInizialeSoggFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBudgetInizialeSoggFinanziato(BigDecimal value) {
        this.budgetInizialeSoggFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà budgetResiduoSoggFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBudgetResiduoSoggFinanziato() {
        return budgetResiduoSoggFinanziato;
    }

    /**
     * Imposta il valore della proprietà budgetResiduoSoggFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBudgetResiduoSoggFinanziato(BigDecimal value) {
        this.budgetResiduoSoggFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà destinatariEsclusi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDestinatariEsclusi() {
        return destinatariEsclusi;
    }

    /**
     * Imposta il valore della proprietà destinatariEsclusi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDestinatariEsclusi(BigDecimal value) {
        this.destinatariEsclusi = value;
    }

    /**
     * Recupera il valore della proprietà unitaTemporaliEscluse.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitaTemporaliEscluse() {
        return unitaTemporaliEscluse;
    }

    /**
     * Imposta il valore della proprietà unitaTemporaliEscluse.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitaTemporaliEscluse(BigDecimal value) {
        this.unitaTemporaliEscluse = value;
    }

}
