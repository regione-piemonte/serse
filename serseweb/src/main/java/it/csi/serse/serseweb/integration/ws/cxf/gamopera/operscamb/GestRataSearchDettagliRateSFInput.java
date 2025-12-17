
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
 * <p>Classe Java per gestRataSearchDettagliRateSFInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestRataSearchDettagliRateSFInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chiaveUtenteAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="idAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idRata" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codTipolRata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="progressivoRata" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idOperazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestRataSearchDettagliRateSFInput", propOrder = {
    "chiaveUtenteAutorizzazione",
    "idAutorizzazione",
    "idRata",
    "codTipolRata",
    "progressivoRata",
    "idOperazione"
})
public class GestRataSearchDettagliRateSFInput {

    @XmlElement(nillable = true)
    protected List<String> chiaveUtenteAutorizzazione;
    protected Long idAutorizzazione;
    protected Long idRata;
    protected String codTipolRata;
    protected Long progressivoRata;
    protected Long idOperazione;

    /**
     * Gets the value of the chiaveUtenteAutorizzazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the chiaveUtenteAutorizzazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChiaveUtenteAutorizzazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getChiaveUtenteAutorizzazione() {
        if (chiaveUtenteAutorizzazione == null) {
            chiaveUtenteAutorizzazione = new ArrayList<String>();
        }
        return this.chiaveUtenteAutorizzazione;
    }

    /**
     * Recupera il valore della proprietà idAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAutorizzazione() {
        return idAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà idAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAutorizzazione(Long value) {
        this.idAutorizzazione = value;
    }

    /**
     * Recupera il valore della proprietà idRata.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdRata() {
        return idRata;
    }

    /**
     * Imposta il valore della proprietà idRata.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdRata(Long value) {
        this.idRata = value;
    }

    /**
     * Recupera il valore della proprietà codTipolRata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipolRata() {
        return codTipolRata;
    }

    /**
     * Imposta il valore della proprietà codTipolRata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipolRata(String value) {
        this.codTipolRata = value;
    }

    /**
     * Recupera il valore della proprietà progressivoRata.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProgressivoRata() {
        return progressivoRata;
    }

    /**
     * Imposta il valore della proprietà progressivoRata.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProgressivoRata(Long value) {
        this.progressivoRata = value;
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

}
