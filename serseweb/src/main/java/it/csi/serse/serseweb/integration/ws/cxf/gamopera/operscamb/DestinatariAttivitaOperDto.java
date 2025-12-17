
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
 * <p>Classe Java per destinatariAttivitaOperDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="destinatariAttivitaOperDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idoperazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttivita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="listDestinatari" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}destinatariAttivitaDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destinatariAttivitaOperDto", propOrder = {
    "idoperazione",
    "idSoggettoFinanziato",
    "idInterventoApprovato",
    "idAttivita",
    "listDestinatari"
})
public class DestinatariAttivitaOperDto {

    protected Long idoperazione;
    protected Long idSoggettoFinanziato;
    protected Long idInterventoApprovato;
    protected Long idAttivita;
    @XmlElement(nillable = true)
    protected List<DestinatariAttivitaDto> listDestinatari;

    /**
     * Recupera il valore della proprietà idoperazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdoperazione() {
        return idoperazione;
    }

    /**
     * Imposta il valore della proprietà idoperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdoperazione(Long value) {
        this.idoperazione = value;
    }

    /**
     * Recupera il valore della proprietà idSoggettoFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdSoggettoFinanziato() {
        return idSoggettoFinanziato;
    }

    /**
     * Imposta il valore della proprietà idSoggettoFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdSoggettoFinanziato(Long value) {
        this.idSoggettoFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà idInterventoApprovato.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdInterventoApprovato() {
        return idInterventoApprovato;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdInterventoApprovato(Long value) {
        this.idInterventoApprovato = value;
    }

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
     * Gets the value of the listDestinatari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listDestinatari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListDestinatari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DestinatariAttivitaDto }
     * 
     * 
     */
    public List<DestinatariAttivitaDto> getListDestinatari() {
        if (listDestinatari == null) {
            listDestinatari = new ArrayList<DestinatariAttivitaDto>();
        }
        return this.listDestinatari;
    }

}
