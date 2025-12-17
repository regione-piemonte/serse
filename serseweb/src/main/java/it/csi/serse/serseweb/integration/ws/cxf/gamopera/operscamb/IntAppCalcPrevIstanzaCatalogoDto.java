
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
 * <p>Classe Java per intAppCalcPrevIstanzaCatalogoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="intAppCalcPrevIstanzaCatalogoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="asse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="obiettivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="durata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="numeroDestinatari" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codTipoInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codSottoTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="valEconomicoIntApp" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="elencoVociSpesa" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}vociSpesaCalcPrevIstanzaCatalogoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "intAppCalcPrevIstanzaCatalogoDto", propOrder = {
    "asse",
    "obiettivo",
    "attivita",
    "codAzione",
    "durata",
    "numeroDestinatari",
    "idInterventoApprovatoMateria",
    "codTipoInterventoApprovato",
    "descInterventoApprovato",
    "codTipologiaServizio",
    "codSottoTipologiaServizio",
    "valEconomicoIntApp",
    "elencoVociSpesa"
})
public class IntAppCalcPrevIstanzaCatalogoDto {

    protected String asse;
    protected String obiettivo;
    protected String attivita;
    protected String codAzione;
    protected BigDecimal durata;
    protected Long numeroDestinatari;
    protected Long idInterventoApprovatoMateria;
    protected String codTipoInterventoApprovato;
    protected String descInterventoApprovato;
    protected String codTipologiaServizio;
    protected Long codSottoTipologiaServizio;
    protected BigDecimal valEconomicoIntApp;
    @XmlElement(nillable = true)
    protected List<VociSpesaCalcPrevIstanzaCatalogoDto> elencoVociSpesa;

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
     * Recupera il valore della proprietà durata.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurata() {
        return durata;
    }

    /**
     * Imposta il valore della proprietà durata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurata(BigDecimal value) {
        this.durata = value;
    }

    /**
     * Recupera il valore della proprietà numeroDestinatari.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroDestinatari() {
        return numeroDestinatari;
    }

    /**
     * Imposta il valore della proprietà numeroDestinatari.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroDestinatari(Long value) {
        this.numeroDestinatari = value;
    }

    /**
     * Recupera il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdInterventoApprovatoMateria() {
        return idInterventoApprovatoMateria;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdInterventoApprovatoMateria(Long value) {
        this.idInterventoApprovatoMateria = value;
    }

    /**
     * Recupera il valore della proprietà codTipoInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoInterventoApprovato() {
        return codTipoInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà codTipoInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoInterventoApprovato(String value) {
        this.codTipoInterventoApprovato = value;
    }

    /**
     * Recupera il valore della proprietà descInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescInterventoApprovato() {
        return descInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà descInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescInterventoApprovato(String value) {
        this.descInterventoApprovato = value;
    }

    /**
     * Recupera il valore della proprietà codTipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipologiaServizio() {
        return codTipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà codTipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipologiaServizio(String value) {
        this.codTipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà codSottoTipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodSottoTipologiaServizio() {
        return codSottoTipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà codSottoTipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodSottoTipologiaServizio(Long value) {
        this.codSottoTipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà valEconomicoIntApp.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValEconomicoIntApp() {
        return valEconomicoIntApp;
    }

    /**
     * Imposta il valore della proprietà valEconomicoIntApp.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValEconomicoIntApp(BigDecimal value) {
        this.valEconomicoIntApp = value;
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
     * {@link VociSpesaCalcPrevIstanzaCatalogoDto }
     * 
     * 
     */
    public List<VociSpesaCalcPrevIstanzaCatalogoDto> getElencoVociSpesa() {
        if (elencoVociSpesa == null) {
            elencoVociSpesa = new ArrayList<VociSpesaCalcPrevIstanzaCatalogoDto>();
        }
        return this.elencoVociSpesa;
    }

}
