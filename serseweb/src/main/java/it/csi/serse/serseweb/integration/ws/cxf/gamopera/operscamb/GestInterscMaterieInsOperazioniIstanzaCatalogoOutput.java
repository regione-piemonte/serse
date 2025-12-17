
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
 * <p>Classe Java per gestInterscMaterieInsOperazioniIstanzaCatalogoOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieInsOperazioniIstanzaCatalogoOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codEsitoRicezioneIstanza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioEsitoRicezioneIstanza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nrTicket" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataRicezioneIstanza" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieInsOperazioniIstanzaCatalogoOutput", propOrder = {
    "idSportello",
    "idDomanda",
    "codEsitoRicezioneIstanza",
    "messaggioEsitoRicezioneIstanza",
    "nrTicket",
    "dataRicezioneIstanza"
})
public class GestInterscMaterieInsOperazioniIstanzaCatalogoOutput {

    protected Long idSportello;
    protected Long idDomanda;
    protected String codEsitoRicezioneIstanza;
    protected String messaggioEsitoRicezioneIstanza;
    protected Long nrTicket;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRicezioneIstanza;

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
     * Recupera il valore della proprietà idDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDomanda() {
        return idDomanda;
    }

    /**
     * Imposta il valore della proprietà idDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDomanda(Long value) {
        this.idDomanda = value;
    }

    /**
     * Recupera il valore della proprietà codEsitoRicezioneIstanza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEsitoRicezioneIstanza() {
        return codEsitoRicezioneIstanza;
    }

    /**
     * Imposta il valore della proprietà codEsitoRicezioneIstanza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEsitoRicezioneIstanza(String value) {
        this.codEsitoRicezioneIstanza = value;
    }

    /**
     * Recupera il valore della proprietà messaggioEsitoRicezioneIstanza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessaggioEsitoRicezioneIstanza() {
        return messaggioEsitoRicezioneIstanza;
    }

    /**
     * Imposta il valore della proprietà messaggioEsitoRicezioneIstanza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessaggioEsitoRicezioneIstanza(String value) {
        this.messaggioEsitoRicezioneIstanza = value;
    }

    /**
     * Recupera il valore della proprietà nrTicket.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNrTicket() {
        return nrTicket;
    }

    /**
     * Imposta il valore della proprietà nrTicket.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNrTicket(Long value) {
        this.nrTicket = value;
    }

    /**
     * Recupera il valore della proprietà dataRicezioneIstanza.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRicezioneIstanza() {
        return dataRicezioneIstanza;
    }

    /**
     * Imposta il valore della proprietà dataRicezioneIstanza.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRicezioneIstanza(XMLGregorianCalendar value) {
        this.dataRicezioneIstanza = value;
    }

}
