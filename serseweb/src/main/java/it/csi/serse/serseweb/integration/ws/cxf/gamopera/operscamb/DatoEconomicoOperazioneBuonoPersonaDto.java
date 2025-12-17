
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
 * <p>Classe Java per datoEconomicoOperazioneBuonoPersonaDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="datoEconomicoOperazioneBuonoPersonaDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idOperazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="areaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idFascia" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="classificazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classificazioneDto" minOccurs="0"/&gt;
 *         &lt;element name="elencoImportiPerFonti" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}importiFonteBuoniPersonaDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datoEconomicoOperazioneBuonoPersonaDto", propOrder = {
    "idOperazione",
    "areaTerritoriale",
    "idFascia",
    "classificazione",
    "elencoImportiPerFonti"
})
public class DatoEconomicoOperazioneBuonoPersonaDto {

    protected Long idOperazione;
    protected String areaTerritoriale;
    protected Long idFascia;
    protected ClassificazioneDto classificazione;
    @XmlElement(nillable = true)
    protected List<ImportiFonteBuoniPersonaDto> elencoImportiPerFonti;

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
     * Gets the value of the elencoImportiPerFonti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoImportiPerFonti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoImportiPerFonti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportiFonteBuoniPersonaDto }
     * 
     * 
     */
    public List<ImportiFonteBuoniPersonaDto> getElencoImportiPerFonti() {
        if (elencoImportiPerFonti == null) {
            elencoImportiPerFonti = new ArrayList<ImportiFonteBuoniPersonaDto>();
        }
        return this.elencoImportiPerFonti;
    }

}
