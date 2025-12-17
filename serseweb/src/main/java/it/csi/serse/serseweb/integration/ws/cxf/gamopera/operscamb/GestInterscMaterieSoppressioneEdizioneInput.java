
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

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestInterscMaterieSoppressioneEdizioneInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieSoppressioneEdizioneInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codMateria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idPSO" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoAzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dtSoppressione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="codSoppressione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="motivazioneSoppressione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annualita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="funzionario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieSoppressioneEdizioneInput", propOrder = {
    "codMateria",
    "idAttivitaMateria",
    "idPSO",
    "codTipoRichiesta",
    "tipoAzione",
    "dtSoppressione",
    "codSoppressione",
    "motivazioneSoppressione",
    "annualita",
    "funzionario"
})
public class GestInterscMaterieSoppressioneEdizioneInput {

    protected String codMateria;
    protected Long idAttivitaMateria;
    protected Long idPSO;
    protected String codTipoRichiesta;
    protected String tipoAzione;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtSoppressione;
    protected Long codSoppressione;
    protected String motivazioneSoppressione;
    protected Long annualita;
    protected String funzionario;

    /**
     * Recupera il valore della proprietà codMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMateria() {
        return codMateria;
    }

    /**
     * Imposta il valore della proprietà codMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMateria(String value) {
        this.codMateria = value;
    }

    /**
     * Recupera il valore della proprietà idAttivitaMateria.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivitaMateria() {
        return idAttivitaMateria;
    }

    /**
     * Imposta il valore della proprietà idAttivitaMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivitaMateria(Long value) {
        this.idAttivitaMateria = value;
    }

    /**
     * Recupera il valore della proprietà idPSO.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPSO() {
        return idPSO;
    }

    /**
     * Imposta il valore della proprietà idPSO.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPSO(Long value) {
        this.idPSO = value;
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
     * Recupera il valore della proprietà tipoAzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAzione() {
        return tipoAzione;
    }

    /**
     * Imposta il valore della proprietà tipoAzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAzione(String value) {
        this.tipoAzione = value;
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

    /**
     * Recupera il valore della proprietà codSoppressione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodSoppressione() {
        return codSoppressione;
    }

    /**
     * Imposta il valore della proprietà codSoppressione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodSoppressione(Long value) {
        this.codSoppressione = value;
    }

    /**
     * Recupera il valore della proprietà motivazioneSoppressione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivazioneSoppressione() {
        return motivazioneSoppressione;
    }

    /**
     * Imposta il valore della proprietà motivazioneSoppressione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivazioneSoppressione(String value) {
        this.motivazioneSoppressione = value;
    }

    /**
     * Recupera il valore della proprietà annualita.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnualita() {
        return annualita;
    }

    /**
     * Imposta il valore della proprietà annualita.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnualita(Long value) {
        this.annualita = value;
    }

    /**
     * Recupera il valore della proprietà funzionario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunzionario() {
        return funzionario;
    }

    /**
     * Imposta il valore della proprietà funzionario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunzionario(String value) {
        this.funzionario = value;
    }

}
