
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

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per attivitaGestioneDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="attivitaGestioneDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttivita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroOreCorso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dettaglioAttivitaLezioni" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}dettaglioAttivitaLezioni" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dettaglioAttivitaAllievi" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}dettaglioAttivitaAllievi" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attivitaGestioneDto", propOrder = {
    "idAttivita",
    "idAttivitaDomanda",
    "codFiscale",
    "numeroOreCorso",
    "dettaglioAttivitaLezioni",
    "dettaglioAttivitaAllievi"
})
public class AttivitaGestioneDto {

    protected Long idAttivita;
    protected Long idAttivitaDomanda;
    protected String codFiscale;
    protected Long numeroOreCorso;
    @XmlElement(nillable = true)
    protected List<DettaglioAttivitaLezioni> dettaglioAttivitaLezioni;
    @XmlElement(nillable = true)
    protected List<DettaglioAttivitaAllievi> dettaglioAttivitaAllievi;

    /**
     * Recupera il valore della proprietà idAttivita.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivita() {
        return idAttivita;
    }

    /**
     * Imposta il valore della proprietà idAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivita(Long value) {
        this.idAttivita = value;
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
     * Recupera il valore della proprietà numeroOreCorso.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroOreCorso() {
        return numeroOreCorso;
    }

    /**
     * Imposta il valore della proprietà numeroOreCorso.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroOreCorso(Long value) {
        this.numeroOreCorso = value;
    }

    /**
     * Gets the value of the dettaglioAttivitaLezioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the dettaglioAttivitaLezioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettaglioAttivitaLezioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DettaglioAttivitaLezioni }
     * 
     * 
     */
    public List<DettaglioAttivitaLezioni> getDettaglioAttivitaLezioni() {
        if (dettaglioAttivitaLezioni == null) {
            dettaglioAttivitaLezioni = new ArrayList<DettaglioAttivitaLezioni>();
        }
        return this.dettaglioAttivitaLezioni;
    }

    /**
     * Gets the value of the dettaglioAttivitaAllievi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the dettaglioAttivitaAllievi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDettaglioAttivitaAllievi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DettaglioAttivitaAllievi }
     * 
     * 
     */
    public List<DettaglioAttivitaAllievi> getDettaglioAttivitaAllievi() {
        if (dettaglioAttivitaAllievi == null) {
            dettaglioAttivitaAllievi = new ArrayList<DettaglioAttivitaAllievi>();
        }
        return this.dettaglioAttivitaAllievi;
    }

}
