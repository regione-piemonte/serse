
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

package it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per RequestGetDettaglioAreeTerritoriali complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="RequestGetDettaglioAreeTerritoriali"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idPersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idSede" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="materia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestGetDettaglioAreeTerritoriali", propOrder = {
    "idPersonaGiuridica",
    "idSede",
    "materia"
})
public class RequestGetDettaglioAreeTerritoriali {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idPersonaGiuridica;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer idSede;
    @XmlElement(required = true, nillable = true)
    protected String materia;

    /**
     * Recupera il valore della proprietà idPersonaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPersonaGiuridica() {
        return idPersonaGiuridica;
    }

    /**
     * Imposta il valore della proprietà idPersonaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPersonaGiuridica(Integer value) {
        this.idPersonaGiuridica = value;
    }

    /**
     * Recupera il valore della proprietà idSede.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSede() {
        return idSede;
    }

    /**
     * Imposta il valore della proprietà idSede.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSede(Integer value) {
        this.idSede = value;
    }

    /**
     * Recupera il valore della proprietà materia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Imposta il valore della proprietà materia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMateria(String value) {
        this.materia = value;
    }

}
