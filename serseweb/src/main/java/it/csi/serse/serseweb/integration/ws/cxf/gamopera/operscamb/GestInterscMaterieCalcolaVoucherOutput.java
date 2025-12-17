
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
 * <p>Classe Java per gestInterscMaterieCalcolaVoucherOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieCalcolaVoucherOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quotaPubblicaCalcolata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaPrivataCalcolata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codMessaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieCalcolaVoucherOutput", propOrder = {
    "idSportello",
    "codFiscale",
    "quotaPubblicaCalcolata",
    "quotaPrivataCalcolata",
    "codMessaggioRisposta",
    "messaggioRisposta"
})
public class GestInterscMaterieCalcolaVoucherOutput {

    protected Long idSportello;
    protected String codFiscale;
    protected BigDecimal quotaPubblicaCalcolata;
    protected BigDecimal quotaPrivataCalcolata;
    protected String codMessaggioRisposta;
    protected String messaggioRisposta;

    /**
     * Recupera il valore della proprietà idSportello.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSportello() {
        return idSportello;
    }

    /**
     * Imposta il valore della proprietà idSportello.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSportello(Long value) {
        this.idSportello = value;
    }

    /**
     * Recupera il valore della proprietà codFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscale() {
        return codFiscale;
    }

    /**
     * Imposta il valore della proprietà codFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscale(String value) {
        this.codFiscale = value;
    }

    /**
     * Recupera il valore della proprietà quotaPubblicaCalcolata.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPubblicaCalcolata() {
        return quotaPubblicaCalcolata;
    }

    /**
     * Imposta il valore della proprietà quotaPubblicaCalcolata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPubblicaCalcolata(BigDecimal value) {
        this.quotaPubblicaCalcolata = value;
    }

    /**
     * Recupera il valore della proprietà quotaPrivataCalcolata.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPrivataCalcolata() {
        return quotaPrivataCalcolata;
    }

    /**
     * Imposta il valore della proprietà quotaPrivataCalcolata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPrivataCalcolata(BigDecimal value) {
        this.quotaPrivataCalcolata = value;
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

}
