
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

package it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per GestioneReferenteDDRInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="GestioneReferenteDDRInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="referente" type="{http://anagrafepg.interfacecsi.flaianagpg.flaianag.csi.it/}ReferenteDto"/&gt;
 *         &lt;element name="tipoGestione" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GestioneReferenteDDRInput", propOrder = {
    "referente",
    "tipoGestione"
})
public class GestioneReferenteDDRInput {

    @XmlElement(required = true, nillable = true)
    protected ReferenteDto referente;
    @XmlElement(required = true, nillable = true)
    protected String tipoGestione;

    /**
     * Recupera il valore della proprietà referente.
     * 
     * @return
     *     possible object is
     *     {@link ReferenteDto }
     *     
     */
    public ReferenteDto getReferente() {
        return referente;
    }

    /**
     * Imposta il valore della proprietà referente.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenteDto }
     *     
     */
    public void setReferente(ReferenteDto value) {
        this.referente = value;
    }

    /**
     * Recupera il valore della proprietà tipoGestione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoGestione() {
        return tipoGestione;
    }

    /**
     * Imposta il valore della proprietà tipoGestione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoGestione(String value) {
        this.tipoGestione = value;
    }

}
