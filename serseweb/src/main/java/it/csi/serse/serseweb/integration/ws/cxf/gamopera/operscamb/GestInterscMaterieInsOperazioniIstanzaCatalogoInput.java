
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
 * <p>Classe Java per gestInterscMaterieInsOperazioniIstanzaCatalogoInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieInsOperazioniIstanzaCatalogoInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="operatoreSF" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}operatoreIstanzaCatalogoDto" minOccurs="0"/&gt;
 *         &lt;element name="operatoreSA" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}operatoreIstanzaCatalogoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="areaTerritoriale" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}areaTerritorialeIstanzaCatalogoDto" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneAti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titoloDomanda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieInsOperazioniIstanzaCatalogoInput", propOrder = {
    "codTipoMateria",
    "codTipoRichiesta",
    "idSportello",
    "idDomanda",
    "operatoreSF",
    "operatoreSA",
    "areaTerritoriale",
    "denominazioneAti",
    "titoloDomanda"
})
public class GestInterscMaterieInsOperazioniIstanzaCatalogoInput {

    @XmlElement(required = true)
    protected String codTipoMateria;
    @XmlElement(required = true)
    protected String codTipoRichiesta;
    protected Long idSportello;
    protected Long idDomanda;
    protected OperatoreIstanzaCatalogoDto operatoreSF;
    @XmlElement(nillable = true)
    protected List<OperatoreIstanzaCatalogoDto> operatoreSA;
    @XmlElement(nillable = true)
    protected List<AreaTerritorialeIstanzaCatalogoDto> areaTerritoriale;
    protected String denominazioneAti;
    protected String titoloDomanda;

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
     * Recupera il valore della proprietà operatoreSF.
     * 
     * @return
     *     possible object is
     *     {@link OperatoreIstanzaCatalogoDto }
     *     
     */
    public OperatoreIstanzaCatalogoDto getOperatoreSF() {
        return operatoreSF;
    }

    /**
     * Imposta il valore della proprietà operatoreSF.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatoreIstanzaCatalogoDto }
     *     
     */
    public void setOperatoreSF(OperatoreIstanzaCatalogoDto value) {
        this.operatoreSF = value;
    }

    /**
     * Gets the value of the operatoreSA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the operatoreSA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperatoreSA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperatoreIstanzaCatalogoDto }
     * 
     * 
     */
    public List<OperatoreIstanzaCatalogoDto> getOperatoreSA() {
        if (operatoreSA == null) {
            operatoreSA = new ArrayList<OperatoreIstanzaCatalogoDto>();
        }
        return this.operatoreSA;
    }

    /**
     * Gets the value of the areaTerritoriale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the areaTerritoriale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAreaTerritoriale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AreaTerritorialeIstanzaCatalogoDto }
     * 
     * 
     */
    public List<AreaTerritorialeIstanzaCatalogoDto> getAreaTerritoriale() {
        if (areaTerritoriale == null) {
            areaTerritoriale = new ArrayList<AreaTerritorialeIstanzaCatalogoDto>();
        }
        return this.areaTerritoriale;
    }

    /**
     * Recupera il valore della proprietà denominazioneAti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneAti() {
        return denominazioneAti;
    }

    /**
     * Imposta il valore della proprietà denominazioneAti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneAti(String value) {
        this.denominazioneAti = value;
    }

    /**
     * Recupera il valore della proprietà titoloDomanda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitoloDomanda() {
        return titoloDomanda;
    }

    /**
     * Imposta il valore della proprietà titoloDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitoloDomanda(String value) {
        this.titoloDomanda = value;
    }

}
