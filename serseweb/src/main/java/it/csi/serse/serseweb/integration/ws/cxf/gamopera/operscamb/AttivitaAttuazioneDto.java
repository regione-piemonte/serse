
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
 * <p>Classe Java per attivitaAttuazioneDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="attivitaAttuazioneDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttivitaFP" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="statoAvanzamento" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codSedeOperatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="flagSedeOccasionale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attivitaAttuazioneDto", propOrder = {
    "idAttivitaFP",
    "idAttivitaDomanda",
    "statoAvanzamento",
    "gruppoOperatore",
    "codOperatore",
    "codSedeOperatore",
    "flagSedeOccasionale"
})
public class AttivitaAttuazioneDto {

    protected Long idAttivitaFP;
    protected Long idAttivitaDomanda;
    protected Long statoAvanzamento;
    protected String gruppoOperatore;
    protected Long codOperatore;
    protected Long codSedeOperatore;
    protected String flagSedeOccasionale;

    /**
     * Recupera il valore della proprietà idAttivitaFP.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivitaFP() {
        return idAttivitaFP;
    }

    /**
     * Imposta il valore della proprietà idAttivitaFP.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivitaFP(Long value) {
        this.idAttivitaFP = value;
    }

    /**
     * Recupera il valore della proprietà idAttivitaDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivitaDomanda() {
        return idAttivitaDomanda;
    }

    /**
     * Imposta il valore della proprietà idAttivitaDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivitaDomanda(Long value) {
        this.idAttivitaDomanda = value;
    }

    /**
     * Recupera il valore della proprietà statoAvanzamento.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStatoAvanzamento() {
        return statoAvanzamento;
    }

    /**
     * Imposta il valore della proprietà statoAvanzamento.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStatoAvanzamento(Long value) {
        this.statoAvanzamento = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatore() {
        return gruppoOperatore;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatore(String value) {
        this.gruppoOperatore = value;
    }

    /**
     * Recupera il valore della proprietà codOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatore() {
        return codOperatore;
    }

    /**
     * Imposta il valore della proprietà codOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatore(Long value) {
        this.codOperatore = value;
    }

    /**
     * Recupera il valore della proprietà codSedeOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodSedeOperatore() {
        return codSedeOperatore;
    }

    /**
     * Imposta il valore della proprietà codSedeOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodSedeOperatore(Long value) {
        this.codSedeOperatore = value;
    }

    /**
     * Recupera il valore della proprietà flagSedeOccasionale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagSedeOccasionale() {
        return flagSedeOccasionale;
    }

    /**
     * Imposta il valore della proprietà flagSedeOccasionale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagSedeOccasionale(String value) {
        this.flagSedeOccasionale = value;
    }

}
