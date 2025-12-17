
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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestAttivitaInsertAttivitaInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestAttivitaInsertAttivitaInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idOperazione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codClasseAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codVoceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="importoAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="durataAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="subCodiceSede" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="cfErogatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dtAvvioAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dtTermineAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="elencoCodFiscDestinatarioAttivita" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="utente" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}utenteDto" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestAttivitaInsertAttivitaInput", propOrder = {
    "idInterventoApprovato",
    "idSoggettoFinanziato",
    "gruppoOperatoreSA",
    "codOperatoreSA",
    "idOperazione",
    "idAttivitaMateria",
    "codTipoAttivita",
    "codClasseAttivita",
    "statoAttivita",
    "codVoceSpesa",
    "importoAttivita",
    "durataAttivita",
    "subCodiceSede",
    "cfErogatore",
    "dtAvvioAttivita",
    "dtTermineAttivita",
    "elencoCodFiscDestinatarioAttivita",
    "utente"
})
public class GestAttivitaInsertAttivitaInput {

    protected BigDecimal idInterventoApprovato;
    protected BigDecimal idSoggettoFinanziato;
    protected String gruppoOperatoreSA;
    protected BigDecimal codOperatoreSA;
    protected BigDecimal idOperazione;
    protected BigDecimal idAttivitaMateria;
    protected String codTipoAttivita;
    protected String codClasseAttivita;
    protected String statoAttivita;
    protected String codVoceSpesa;
    protected BigDecimal importoAttivita;
    protected BigDecimal durataAttivita;
    protected BigDecimal subCodiceSede;
    @XmlElement(required = true)
    protected String cfErogatore;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtAvvioAttivita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtTermineAttivita;
    @XmlElement(nillable = true)
    protected List<String> elencoCodFiscDestinatarioAttivita;
    protected UtenteDto utente;

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
     * Recupera il valore della proprietà codVoceSpesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVoceSpesa() {
        return codVoceSpesa;
    }

    /**
     * Imposta il valore della proprietà codVoceSpesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVoceSpesa(String value) {
        this.codVoceSpesa = value;
    }

    /**
     * Recupera il valore della proprietà importoAttivita.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoAttivita() {
        return importoAttivita;
    }

    /**
     * Imposta il valore della proprietà importoAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoAttivita(BigDecimal value) {
        this.importoAttivita = value;
    }

    /**
     * Recupera il valore della proprietà durataAttivita.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurataAttivita() {
        return durataAttivita;
    }

    /**
     * Imposta il valore della proprietà durataAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurataAttivita(BigDecimal value) {
        this.durataAttivita = value;
    }

    /**
     * Recupera il valore della proprietà subCodiceSede.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubCodiceSede() {
        return subCodiceSede;
    }

    /**
     * Imposta il valore della proprietà subCodiceSede.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubCodiceSede(BigDecimal value) {
        this.subCodiceSede = value;
    }

    /**
     * Recupera il valore della proprietà cfErogatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfErogatore() {
        return cfErogatore;
    }

    /**
     * Imposta il valore della proprietà cfErogatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfErogatore(String value) {
        this.cfErogatore = value;
    }

    /**
     * Recupera il valore della proprietà dtAvvioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtAvvioAttivita() {
        return dtAvvioAttivita;
    }

    /**
     * Imposta il valore della proprietà dtAvvioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtAvvioAttivita(XMLGregorianCalendar value) {
        this.dtAvvioAttivita = value;
    }

    /**
     * Recupera il valore della proprietà dtTermineAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtTermineAttivita() {
        return dtTermineAttivita;
    }

    /**
     * Imposta il valore della proprietà dtTermineAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtTermineAttivita(XMLGregorianCalendar value) {
        this.dtTermineAttivita = value;
    }

    /**
     * Gets the value of the elencoCodFiscDestinatarioAttivita property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoCodFiscDestinatarioAttivita property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoCodFiscDestinatarioAttivita().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getElencoCodFiscDestinatarioAttivita() {
        if (elencoCodFiscDestinatarioAttivita == null) {
            elencoCodFiscDestinatarioAttivita = new ArrayList<String>();
        }
        return this.elencoCodFiscDestinatarioAttivita;
    }

    /**
     * Recupera il valore della proprietà utente.
     * 
     * @return
     *     possible object is
     *     {@link UtenteDto }
     *     
     */
    public UtenteDto getUtente() {
        return utente;
    }

    /**
     * Imposta il valore della proprietà utente.
     * 
     * @param value
     *     allowed object is
     *     {@link UtenteDto }
     *     
     */
    public void setUtente(UtenteDto value) {
        this.utente = value;
    }

}
