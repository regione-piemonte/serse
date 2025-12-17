
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
 * <p>Classe Java per gestAttivitaGetDatoEconomicoOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestAttivitaGetDatoEconomicoOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codMessaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDestTot" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="durataTot" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importoTot" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="elencoVociSpesa" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}vociSpesaDatoEconomico" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestAttivitaGetDatoEconomicoOutput", propOrder = {
    "codMessaggioRisposta",
    "messaggioRisposta",
    "numeroDestTot",
    "durataTot",
    "importoTot",
    "elencoVociSpesa"
})
public class GestAttivitaGetDatoEconomicoOutput {

    protected String codMessaggioRisposta;
    protected String messaggioRisposta;
    protected Long numeroDestTot;
    protected BigDecimal durataTot;
    protected BigDecimal importoTot;
    @XmlElement(nillable = true)
    protected List<VociSpesaDatoEconomico> elencoVociSpesa;

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
     * Recupera il valore della proprietà numeroDestTot.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroDestTot() {
        return numeroDestTot;
    }

    /**
     * Imposta il valore della proprietà numeroDestTot.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroDestTot(Long value) {
        this.numeroDestTot = value;
    }

    /**
     * Recupera il valore della proprietà durataTot.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurataTot() {
        return durataTot;
    }

    /**
     * Imposta il valore della proprietà durataTot.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurataTot(BigDecimal value) {
        this.durataTot = value;
    }

    /**
     * Recupera il valore della proprietà importoTot.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoTot() {
        return importoTot;
    }

    /**
     * Imposta il valore della proprietà importoTot.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoTot(BigDecimal value) {
        this.importoTot = value;
    }

    /**
     * Gets the value of the elencoVociSpesa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoVociSpesa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoVociSpesa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VociSpesaDatoEconomico }
     * 
     * 
     */
    public List<VociSpesaDatoEconomico> getElencoVociSpesa() {
        if (elencoVociSpesa == null) {
            elencoVociSpesa = new ArrayList<VociSpesaDatoEconomico>();
        }
        return this.elencoVociSpesa;
    }

}
