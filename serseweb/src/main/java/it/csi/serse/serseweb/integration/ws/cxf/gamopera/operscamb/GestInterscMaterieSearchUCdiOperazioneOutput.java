
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
 * <p>Classe Java per gestInterscMaterieSearchUCdiOperazioneOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieSearchUCdiOperazioneOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esito" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}esitoDto" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idOperazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tipoControllo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idDaadr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idUc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codiceUc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flgCampione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codLuogoCTRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrLuogoCTRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codNaturaCTRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrNaturaCTRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoUC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chiaveDDROP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataApprovazioneUC" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dataAnnullamentoUC" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="annoGestione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieSearchUCdiOperazioneOutput", propOrder = {
    "esito",
    "idPso",
    "idOperazione",
    "tipoControllo",
    "idDaadr",
    "idUc",
    "codiceUc",
    "flgCampione",
    "codLuogoCTRL",
    "descrLuogoCTRL",
    "codNaturaCTRL",
    "descrNaturaCTRL",
    "statoUC",
    "chiaveDDROP",
    "dataApprovazioneUC",
    "dataAnnullamentoUC",
    "annoGestione"
})
public class GestInterscMaterieSearchUCdiOperazioneOutput {

    protected EsitoDto esito;
    protected Long idPso;
    protected Long idOperazione;
    protected String tipoControllo;
    protected Long idDaadr;
    protected Long idUc;
    protected String codiceUc;
    protected String flgCampione;
    protected String codLuogoCTRL;
    protected String descrLuogoCTRL;
    protected String codNaturaCTRL;
    protected String descrNaturaCTRL;
    protected String statoUC;
    protected String chiaveDDROP;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataApprovazioneUC;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAnnullamentoUC;
    protected Long annoGestione;

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link EsitoDto }
     *     
     */
    public EsitoDto getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link EsitoDto }
     *     
     */
    public void setEsito(EsitoDto value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della proprietà idPso.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPso() {
        return idPso;
    }

    /**
     * Imposta il valore della proprietà idPso.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPso(Long value) {
        this.idPso = value;
    }

    /**
     * Recupera il valore della proprietà idOperazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdOperazione() {
        return idOperazione;
    }

    /**
     * Imposta il valore della proprietà idOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdOperazione(Long value) {
        this.idOperazione = value;
    }

    /**
     * Recupera il valore della proprietà tipoControllo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoControllo() {
        return tipoControllo;
    }

    /**
     * Imposta il valore della proprietà tipoControllo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoControllo(String value) {
        this.tipoControllo = value;
    }

    /**
     * Recupera il valore della proprietà idDaadr.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDaadr() {
        return idDaadr;
    }

    /**
     * Imposta il valore della proprietà idDaadr.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDaadr(Long value) {
        this.idDaadr = value;
    }

    /**
     * Recupera il valore della proprietà idUc.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdUc() {
        return idUc;
    }

    /**
     * Imposta il valore della proprietà idUc.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdUc(Long value) {
        this.idUc = value;
    }

    /**
     * Recupera il valore della proprietà codiceUc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceUc() {
        return codiceUc;
    }

    /**
     * Imposta il valore della proprietà codiceUc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceUc(String value) {
        this.codiceUc = value;
    }

    /**
     * Recupera il valore della proprietà flgCampione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlgCampione() {
        return flgCampione;
    }

    /**
     * Imposta il valore della proprietà flgCampione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlgCampione(String value) {
        this.flgCampione = value;
    }

    /**
     * Recupera il valore della proprietà codLuogoCTRL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodLuogoCTRL() {
        return codLuogoCTRL;
    }

    /**
     * Imposta il valore della proprietà codLuogoCTRL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodLuogoCTRL(String value) {
        this.codLuogoCTRL = value;
    }

    /**
     * Recupera il valore della proprietà descrLuogoCTRL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrLuogoCTRL() {
        return descrLuogoCTRL;
    }

    /**
     * Imposta il valore della proprietà descrLuogoCTRL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrLuogoCTRL(String value) {
        this.descrLuogoCTRL = value;
    }

    /**
     * Recupera il valore della proprietà codNaturaCTRL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNaturaCTRL() {
        return codNaturaCTRL;
    }

    /**
     * Imposta il valore della proprietà codNaturaCTRL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNaturaCTRL(String value) {
        this.codNaturaCTRL = value;
    }

    /**
     * Recupera il valore della proprietà descrNaturaCTRL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrNaturaCTRL() {
        return descrNaturaCTRL;
    }

    /**
     * Imposta il valore della proprietà descrNaturaCTRL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrNaturaCTRL(String value) {
        this.descrNaturaCTRL = value;
    }

    /**
     * Recupera il valore della proprietà statoUC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoUC() {
        return statoUC;
    }

    /**
     * Imposta il valore della proprietà statoUC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoUC(String value) {
        this.statoUC = value;
    }

    /**
     * Recupera il valore della proprietà chiaveDDROP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChiaveDDROP() {
        return chiaveDDROP;
    }

    /**
     * Imposta il valore della proprietà chiaveDDROP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChiaveDDROP(String value) {
        this.chiaveDDROP = value;
    }

    /**
     * Recupera il valore della proprietà dataApprovazioneUC.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataApprovazioneUC() {
        return dataApprovazioneUC;
    }

    /**
     * Imposta il valore della proprietà dataApprovazioneUC.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataApprovazioneUC(XMLGregorianCalendar value) {
        this.dataApprovazioneUC = value;
    }

    /**
     * Recupera il valore della proprietà dataAnnullamentoUC.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAnnullamentoUC() {
        return dataAnnullamentoUC;
    }

    /**
     * Imposta il valore della proprietà dataAnnullamentoUC.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAnnullamentoUC(XMLGregorianCalendar value) {
        this.dataAnnullamentoUC = value;
    }

    /**
     * Recupera il valore della proprietà annoGestione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnoGestione() {
        return annoGestione;
    }

    /**
     * Imposta il valore della proprietà annoGestione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnoGestione(Long value) {
        this.annoGestione = value;
    }

}
