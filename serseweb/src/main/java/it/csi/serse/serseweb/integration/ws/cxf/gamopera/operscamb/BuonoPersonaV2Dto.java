
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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per buonoPersonaV2Dto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="buonoPersonaV2Dto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBuonoPersona" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tipoBuonoPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="classificazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classificazioneDto" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreAzienda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="denomAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buonoPersonaV2Dto", propOrder = {
    "idBuonoPersona",
    "tipoBuonoPersona",
    "codFiscale",
    "cognome",
    "nome",
    "classificazione",
    "codOperatoreAzienda",
    "gruppoOperatoreAzienda",
    "denomAzienda"
})
public class BuonoPersonaV2Dto {

    protected Long idBuonoPersona;
    protected String tipoBuonoPersona;
    protected String codFiscale;
    protected String cognome;
    protected String nome;
    protected ClassificazioneDto classificazione;
    protected Long codOperatoreAzienda;
    protected String gruppoOperatoreAzienda;
    protected String denomAzienda;

    /**
     * Recupera il valore della proprietà idBuonoPersona.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdBuonoPersona() {
        return idBuonoPersona;
    }

    /**
     * Imposta il valore della proprietà idBuonoPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdBuonoPersona(Long value) {
        this.idBuonoPersona = value;
    }

    /**
     * Recupera il valore della proprietà tipoBuonoPersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoBuonoPersona() {
        return tipoBuonoPersona;
    }

    /**
     * Imposta il valore della proprietà tipoBuonoPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoBuonoPersona(String value) {
        this.tipoBuonoPersona = value;
    }

    /**
     * Recupera il valore della proprietà codFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscale() {
        return codFiscale;
    }

    /**
     * Imposta il valore della proprietà codFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscale(String value) {
        this.codFiscale = value;
    }

    /**
     * Recupera il valore della proprietà cognome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il valore della proprietà cognome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognome(String value) {
        this.cognome = value;
    }

    /**
     * Recupera il valore della proprietà nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il valore della proprietà nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Recupera il valore della proprietà classificazione.
     * 
     * @return
     *     possible object is
     *     {@link ClassificazioneDto }
     *     
     */
    public ClassificazioneDto getClassificazione() {
        return classificazione;
    }

    /**
     * Imposta il valore della proprietà classificazione.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificazioneDto }
     *     
     */
    public void setClassificazione(ClassificazioneDto value) {
        this.classificazione = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreAzienda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatoreAzienda() {
        return codOperatoreAzienda;
    }

    /**
     * Imposta il valore della proprietà codOperatoreAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatoreAzienda(Long value) {
        this.codOperatoreAzienda = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreAzienda() {
        return gruppoOperatoreAzienda;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreAzienda(String value) {
        this.gruppoOperatoreAzienda = value;
    }

    /**
     * Recupera il valore della proprietà denomAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenomAzienda() {
        return denomAzienda;
    }

    /**
     * Imposta il valore della proprietà denomAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenomAzienda(String value) {
        this.denomAzienda = value;
    }

}
