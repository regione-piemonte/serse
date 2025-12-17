
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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per areaTerritorialeIstanzaCatalogoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="areaTerritorialeIstanzaCatalogoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codAreaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="importoTotAreaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="importiAreaClassificazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}importoAreaClassificazioneIstanzaCatalogoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="intAppIstanzaCatalogo" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}intAppIstanzaCatalogoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "areaTerritorialeIstanzaCatalogoDto", propOrder = {
    "codAreaTerritoriale",
    "importoTotAreaTerritoriale",
    "importiAreaClassificazione",
    "intAppIstanzaCatalogo"
})
public class AreaTerritorialeIstanzaCatalogoDto {

    @XmlElement(required = true)
    protected String codAreaTerritoriale;
    protected BigDecimal importoTotAreaTerritoriale;
    @XmlElement(nillable = true)
    protected List<ImportoAreaClassificazioneIstanzaCatalogoDto> importiAreaClassificazione;
    @XmlElement(nillable = true)
    protected List<IntAppIstanzaCatalogoDto> intAppIstanzaCatalogo;

    /**
     * Recupera il valore della proprietà codAreaTerritoriale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAreaTerritoriale() {
        return codAreaTerritoriale;
    }

    /**
     * Imposta il valore della proprietà codAreaTerritoriale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAreaTerritoriale(String value) {
        this.codAreaTerritoriale = value;
    }

    /**
     * Recupera il valore della proprietà importoTotAreaTerritoriale.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoTotAreaTerritoriale() {
        return importoTotAreaTerritoriale;
    }

    /**
     * Imposta il valore della proprietà importoTotAreaTerritoriale.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoTotAreaTerritoriale(BigDecimal value) {
        this.importoTotAreaTerritoriale = value;
    }

    /**
     * Gets the value of the importiAreaClassificazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the importiAreaClassificazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportiAreaClassificazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportoAreaClassificazioneIstanzaCatalogoDto }
     * 
     * 
     */
    public List<ImportoAreaClassificazioneIstanzaCatalogoDto> getImportiAreaClassificazione() {
        if (importiAreaClassificazione == null) {
            importiAreaClassificazione = new ArrayList<ImportoAreaClassificazioneIstanzaCatalogoDto>();
        }
        return this.importiAreaClassificazione;
    }

    /**
     * Gets the value of the intAppIstanzaCatalogo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the intAppIstanzaCatalogo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntAppIstanzaCatalogo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntAppIstanzaCatalogoDto }
     * 
     * 
     */
    public List<IntAppIstanzaCatalogoDto> getIntAppIstanzaCatalogo() {
        if (intAppIstanzaCatalogo == null) {
            intAppIstanzaCatalogo = new ArrayList<IntAppIstanzaCatalogoDto>();
        }
        return this.intAppIstanzaCatalogo;
    }

}
