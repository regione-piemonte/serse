
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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per buonoSostitutivoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="buonoSostitutivoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBuonoPersona" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tipoBuonoPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="areaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFascia" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="classificazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classificazioneDto" minOccurs="0"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idCorsoACatalogo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denomCorsoACatalogo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="durataCorsoACatalogo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoAziendaRich" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAziendaRich" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denomAziendaRich" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codCorRNA" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataAttribuzioneCorRNA" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="codVisura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annoFormativo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="elencoVociSpesa" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}voceSpesaBuonoPersona" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buonoSostitutivoDto", propOrder = {
    "idBuonoPersona",
    "tipoBuonoPersona",
    "areaTerritoriale",
    "idFascia",
    "classificazione",
    "codFiscale",
    "cognome",
    "nome",
    "idCorsoACatalogo",
    "denomCorsoACatalogo",
    "durataCorsoACatalogo",
    "gruppoAziendaRich",
    "codAziendaRich",
    "denomAziendaRich",
    "codCorRNA",
    "dataAttribuzioneCorRNA",
    "codVisura",
    "annoFormativo",
    "elencoVociSpesa"
})
public class BuonoSostitutivoDto {

    protected Long idBuonoPersona;
    protected String tipoBuonoPersona;
    protected String areaTerritoriale;
    protected Long idFascia;
    protected ClassificazioneDto classificazione;
    protected String codFiscale;
    protected String cognome;
    protected String nome;
    protected Long idCorsoACatalogo;
    protected String denomCorsoACatalogo;
    protected Long durataCorsoACatalogo;
    protected String gruppoAziendaRich;
    protected Long codAziendaRich;
    protected String denomAziendaRich;
    protected Long codCorRNA;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAttribuzioneCorRNA;
    protected String codVisura;
    protected Long annoFormativo;
    @XmlElement(nillable = true)
    protected List<VoceSpesaBuonoPersona> elencoVociSpesa;

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
     * Recupera il valore della proprietà areaTerritoriale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaTerritoriale() {
        return areaTerritoriale;
    }

    /**
     * Imposta il valore della proprietà areaTerritoriale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaTerritoriale(String value) {
        this.areaTerritoriale = value;
    }

    /**
     * Recupera il valore della proprietà idFascia.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdFascia() {
        return idFascia;
    }

    /**
     * Imposta il valore della proprietà idFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFascia(Long value) {
        this.idFascia = value;
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
     * Recupera il valore della proprietà idCorsoACatalogo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdCorsoACatalogo() {
        return idCorsoACatalogo;
    }

    /**
     * Imposta il valore della proprietà idCorsoACatalogo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdCorsoACatalogo(Long value) {
        this.idCorsoACatalogo = value;
    }

    /**
     * Recupera il valore della proprietà denomCorsoACatalogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenomCorsoACatalogo() {
        return denomCorsoACatalogo;
    }

    /**
     * Imposta il valore della proprietà denomCorsoACatalogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenomCorsoACatalogo(String value) {
        this.denomCorsoACatalogo = value;
    }

    /**
     * Recupera il valore della proprietà durataCorsoACatalogo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDurataCorsoACatalogo() {
        return durataCorsoACatalogo;
    }

    /**
     * Imposta il valore della proprietà durataCorsoACatalogo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDurataCorsoACatalogo(Long value) {
        this.durataCorsoACatalogo = value;
    }

    /**
     * Recupera il valore della proprietà gruppoAziendaRich.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoAziendaRich() {
        return gruppoAziendaRich;
    }

    /**
     * Imposta il valore della proprietà gruppoAziendaRich.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoAziendaRich(String value) {
        this.gruppoAziendaRich = value;
    }

    /**
     * Recupera il valore della proprietà codAziendaRich.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodAziendaRich() {
        return codAziendaRich;
    }

    /**
     * Imposta il valore della proprietà codAziendaRich.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodAziendaRich(Long value) {
        this.codAziendaRich = value;
    }

    /**
     * Recupera il valore della proprietà denomAziendaRich.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenomAziendaRich() {
        return denomAziendaRich;
    }

    /**
     * Imposta il valore della proprietà denomAziendaRich.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenomAziendaRich(String value) {
        this.denomAziendaRich = value;
    }

    /**
     * Recupera il valore della proprietà codCorRNA.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodCorRNA() {
        return codCorRNA;
    }

    /**
     * Imposta il valore della proprietà codCorRNA.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodCorRNA(Long value) {
        this.codCorRNA = value;
    }

    /**
     * Recupera il valore della proprietà dataAttribuzioneCorRNA.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAttribuzioneCorRNA() {
        return dataAttribuzioneCorRNA;
    }

    /**
     * Imposta il valore della proprietà dataAttribuzioneCorRNA.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAttribuzioneCorRNA(XMLGregorianCalendar value) {
        this.dataAttribuzioneCorRNA = value;
    }

    /**
     * Recupera il valore della proprietà codVisura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVisura() {
        return codVisura;
    }

    /**
     * Imposta il valore della proprietà codVisura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVisura(String value) {
        this.codVisura = value;
    }

    /**
     * Recupera il valore della proprietà annoFormativo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnoFormativo() {
        return annoFormativo;
    }

    /**
     * Imposta il valore della proprietà annoFormativo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnoFormativo(Long value) {
        this.annoFormativo = value;
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
     * {@link VoceSpesaBuonoPersona }
     * 
     * 
     */
    public List<VoceSpesaBuonoPersona> getElencoVociSpesa() {
        if (elencoVociSpesa == null) {
            elencoVociSpesa = new ArrayList<VoceSpesaBuonoPersona>();
        }
        return this.elencoVociSpesa;
    }

}
