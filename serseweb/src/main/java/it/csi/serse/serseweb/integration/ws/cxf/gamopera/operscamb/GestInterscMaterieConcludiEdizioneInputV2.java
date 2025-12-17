
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
 * <p>Classe Java per gestInterscMaterieConcludiEdizioneInputV2 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieConcludiEdizioneInputV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataFineAttivita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="durata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="numeriDestinatari" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoDestinatari" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}concludiEdizioneDestinatariDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="codClasse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annoGestione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieConcludiEdizioneInputV2", propOrder = {
    "codTipoMateria",
    "codTipoRichiesta",
    "idAttivitaMateria",
    "idPso",
    "idSportello",
    "dataFineAttivita",
    "durata",
    "numeriDestinatari",
    "elencoDestinatari",
    "codClasse",
    "annoGestione",
    "token"
})
public class GestInterscMaterieConcludiEdizioneInputV2 {

    @XmlElement(required = true)
    protected String codTipoMateria;
    protected String codTipoRichiesta;
    protected Long idAttivitaMateria;
    protected Long idPso;
    protected Long idSportello;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFineAttivita;
    protected BigDecimal durata;
    protected Long numeriDestinatari;
    @XmlElement(nillable = true)
    protected List<ConcludiEdizioneDestinatariDto> elencoDestinatari;
    protected String codClasse;
    protected Long annoGestione;
    protected String token;

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
     * Recupera il valore della proprietà dataFineAttivita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFineAttivita() {
        return dataFineAttivita;
    }

    /**
     * Imposta il valore della proprietà dataFineAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFineAttivita(XMLGregorianCalendar value) {
        this.dataFineAttivita = value;
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
     * Recupera il valore della proprietà numeriDestinatari.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeriDestinatari() {
        return numeriDestinatari;
    }

    /**
     * Imposta il valore della proprietà numeriDestinatari.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeriDestinatari(Long value) {
        this.numeriDestinatari = value;
    }

    /**
     * Gets the value of the elencoDestinatari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoDestinatari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoDestinatari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConcludiEdizioneDestinatariDto }
     * 
     * 
     */
    public List<ConcludiEdizioneDestinatariDto> getElencoDestinatari() {
        if (elencoDestinatari == null) {
            elencoDestinatari = new ArrayList<ConcludiEdizioneDestinatariDto>();
        }
        return this.elencoDestinatari;
    }

    /**
     * Recupera il valore della proprietà codClasse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodClasse() {
        return codClasse;
    }

    /**
     * Imposta il valore della proprietà codClasse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodClasse(String value) {
        this.codClasse = value;
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

    /**
     * Recupera il valore della proprietà token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Imposta il valore della proprietà token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
