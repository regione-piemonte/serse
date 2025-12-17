
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per processAsyncInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="processAsyncInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idSemaforo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codiceOggetto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceStatoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processAsyncInput", propOrder = {
    "codiceTipoMateria",
    "codiceTipoRichiesta",
    "idSemaforo",
    "codiceOggetto",
    "codiceStatoRichiesta"
})
public class ProcessAsyncInput {

    protected String codiceTipoMateria;
    protected String codiceTipoRichiesta;
    protected Long idSemaforo;
    protected String codiceOggetto;
    protected String codiceStatoRichiesta;

    /**
     * Recupera il valore della proprietà codiceTipoMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoMateria() {
        return codiceTipoMateria;
    }

    /**
     * Imposta il valore della proprietà codiceTipoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoMateria(String value) {
        this.codiceTipoMateria = value;
    }

    /**
     * Recupera il valore della proprietà codiceTipoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoRichiesta() {
        return codiceTipoRichiesta;
    }

    /**
     * Imposta il valore della proprietà codiceTipoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoRichiesta(String value) {
        this.codiceTipoRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà idSemaforo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSemaforo() {
        return idSemaforo;
    }

    /**
     * Imposta il valore della proprietà idSemaforo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSemaforo(Long value) {
        this.idSemaforo = value;
    }

    /**
     * Recupera il valore della proprietà codiceOggetto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceOggetto() {
        return codiceOggetto;
    }

    /**
     * Imposta il valore della proprietà codiceOggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceOggetto(String value) {
        this.codiceOggetto = value;
    }

    /**
     * Recupera il valore della proprietà codiceStatoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceStatoRichiesta() {
        return codiceStatoRichiesta;
    }

    /**
     * Imposta il valore della proprietà codiceStatoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceStatoRichiesta(String value) {
        this.codiceStatoRichiesta = value;
    }

}
