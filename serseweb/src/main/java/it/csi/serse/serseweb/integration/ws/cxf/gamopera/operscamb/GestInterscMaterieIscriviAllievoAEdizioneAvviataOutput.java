
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
 * <p>Classe Java per gestInterscMaterieIscriviAllievoAEdizioneAvviataOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieIscriviAllievoAEdizioneAvviataOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codMessaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioRisposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="elencoFonti" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}fonteDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="datiAggiornatiAllievo" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}datiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto" minOccurs="0"/&gt;
 *         &lt;element name="elencoVociSpesa" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}voceSpesaAllievoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieIscriviAllievoAEdizioneAvviataOutput", propOrder = {
    "idInterventoApprovatoMateria",
    "idAttivitaMateria",
    "codMessaggioRisposta",
    "messaggioRisposta",
    "elencoFonti",
    "datiAggiornatiAllievo",
    "elencoVociSpesa"
})
public class GestInterscMaterieIscriviAllievoAEdizioneAvviataOutput {

    protected Long idInterventoApprovatoMateria;
    protected Long idAttivitaMateria;
    protected String codMessaggioRisposta;
    protected String messaggioRisposta;
    @XmlElement(nillable = true)
    protected List<FonteDto> elencoFonti;
    protected DatiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto datiAggiornatiAllievo;
    @XmlElement(nillable = true)
    protected List<VoceSpesaAllievoDto> elencoVociSpesa;

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
     * Recupera il valore della proprietà codMessaggioRisposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMessaggioRisposta() {
        return codMessaggioRisposta;
    }

    /**
     * Imposta il valore della proprietà codMessaggioRisposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMessaggioRisposta(String value) {
        this.codMessaggioRisposta = value;
    }

    /**
     * Recupera il valore della proprietà messaggioRisposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessaggioRisposta() {
        return messaggioRisposta;
    }

    /**
     * Imposta il valore della proprietà messaggioRisposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessaggioRisposta(String value) {
        this.messaggioRisposta = value;
    }

    /**
     * Gets the value of the elencoFonti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoFonti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoFonti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FonteDto }
     * 
     * 
     */
    public List<FonteDto> getElencoFonti() {
        if (elencoFonti == null) {
            elencoFonti = new ArrayList<FonteDto>();
        }
        return this.elencoFonti;
    }

    /**
     * Recupera il valore della proprietà datiAggiornatiAllievo.
     * 
     * @return
     *     possible object is
     *     {@link DatiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto }
     *     
     */
    public DatiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto getDatiAggiornatiAllievo() {
        return datiAggiornatiAllievo;
    }

    /**
     * Imposta il valore della proprietà datiAggiornatiAllievo.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto }
     *     
     */
    public void setDatiAggiornatiAllievo(DatiAggiornatiAllievoIscriviAllievoAEdizioneAvviataDto value) {
        this.datiAggiornatiAllievo = value;
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
     * {@link VoceSpesaAllievoDto }
     * 
     * 
     */
    public List<VoceSpesaAllievoDto> getElencoVociSpesa() {
        if (elencoVociSpesa == null) {
            elencoVociSpesa = new ArrayList<VoceSpesaAllievoDto>();
        }
        return this.elencoVociSpesa;
    }

}
