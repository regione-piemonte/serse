
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
 * <p>Classe Java per searchDettagliAttivitaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="searchDettagliAttivitaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codClasseAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descClasseAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descStatoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codVoceSpesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="importoAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="durataAttivita" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codFiscDestinatarioAttivita" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="idOperazione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="subCodiceSede" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="cfErogatore" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dtAvvioAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dtTermineAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreSA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sottotipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrSottotipServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="descBreveTipoAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgSoppressione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="causaleSoppressione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtSoppressione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchDettagliAttivitaDto", propOrder = {
    "idInterventoApprovato",
    "idSoggettoFinanziato",
    "idAttivita",
    "idAttivitaMateria",
    "codTipoAttivita",
    "descTipoAttivita",
    "codClasseAttivita",
    "descClasseAttivita",
    "statoAttivita",
    "descStatoAttivita",
    "codVoceSpesa",
    "importoAttivita",
    "durataAttivita",
    "codFiscDestinatarioAttivita",
    "idOperazione",
    "codTipoMateria",
    "codTipoRichiesta",
    "subCodiceSede",
    "cfErogatore",
    "dtAvvioAttivita",
    "dtTermineAttivita",
    "codOperatoreSA",
    "gruppoOperatoreSA",
    "tipologiaServizio",
    "sottotipologiaServizio",
    "descrSottotipServizio",
    "idInterventoApprovatoMateria",
    "descBreveTipoAttivita",
    "flgSoppressione",
    "causaleSoppressione",
    "denominazioneAttivita",
    "dtSoppressione"
})
public class SearchDettagliAttivitaDto {

    protected BigDecimal idInterventoApprovato;
    protected BigDecimal idSoggettoFinanziato;
    protected BigDecimal idAttivita;
    protected BigDecimal idAttivitaMateria;
    protected String codTipoAttivita;
    protected String descTipoAttivita;
    protected String codClasseAttivita;
    protected String descClasseAttivita;
    protected String statoAttivita;
    protected String descStatoAttivita;
    protected String codVoceSpesa;
    protected BigDecimal importoAttivita;
    protected BigDecimal durataAttivita;
    @XmlElement(nillable = true)
    protected List<String> codFiscDestinatarioAttivita;
    protected BigDecimal idOperazione;
    @XmlElement(required = true)
    protected String codTipoMateria;
    @XmlElement(required = true)
    protected String codTipoRichiesta;
    protected BigDecimal subCodiceSede;
    @XmlElement(required = true)
    protected String cfErogatore;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtAvvioAttivita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtTermineAttivita;
    protected BigDecimal codOperatoreSA;
    protected String gruppoOperatoreSA;
    protected String tipologiaServizio;
    protected String sottotipologiaServizio;
    protected String descrSottotipServizio;
    protected BigDecimal idInterventoApprovatoMateria;
    protected String descBreveTipoAttivita;
    @XmlElement(required = true)
    protected String flgSoppressione;
    protected String causaleSoppressione;
    protected String denominazioneAttivita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtSoppressione;

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
     * Gets the value of the codFiscDestinatarioAttivita property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the codFiscDestinatarioAttivita property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodFiscDestinatarioAttivita().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCodFiscDestinatarioAttivita() {
        if (codFiscDestinatarioAttivita == null) {
            codFiscDestinatarioAttivita = new ArrayList<String>();
        }
        return this.codFiscDestinatarioAttivita;
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
     * Recupera il valore della proprietà tipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologiaServizio() {
        return tipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà tipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologiaServizio(String value) {
        this.tipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà sottotipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSottotipologiaServizio() {
        return sottotipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà sottotipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSottotipologiaServizio(String value) {
        this.sottotipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà descrSottotipServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrSottotipServizio() {
        return descrSottotipServizio;
    }

    /**
     * Imposta il valore della proprietà descrSottotipServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrSottotipServizio(String value) {
        this.descrSottotipServizio = value;
    }

    /**
     * Recupera il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdInterventoApprovatoMateria() {
        return idInterventoApprovatoMateria;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdInterventoApprovatoMateria(BigDecimal value) {
        this.idInterventoApprovatoMateria = value;
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

    /**
     * Recupera il valore della proprietà flgSoppressione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgSoppressione() {
        return flgSoppressione;
    }

    /**
     * Imposta il valore della proprietà flgSoppressione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgSoppressione(String value) {
        this.flgSoppressione = value;
    }

    /**
     * Recupera il valore della proprietà causaleSoppressione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausaleSoppressione() {
        return causaleSoppressione;
    }

    /**
     * Imposta il valore della proprietà causaleSoppressione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausaleSoppressione(String value) {
        this.causaleSoppressione = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneAttivita() {
        return denominazioneAttivita;
    }

    /**
     * Imposta il valore della proprietà denominazioneAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneAttivita(String value) {
        this.denominazioneAttivita = value;
    }

    /**
     * Recupera il valore della proprietà dtSoppressione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtSoppressione() {
        return dtSoppressione;
    }

    /**
     * Imposta il valore della proprietà dtSoppressione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtSoppressione(XMLGregorianCalendar value) {
        this.dtSoppressione = value;
    }

}
