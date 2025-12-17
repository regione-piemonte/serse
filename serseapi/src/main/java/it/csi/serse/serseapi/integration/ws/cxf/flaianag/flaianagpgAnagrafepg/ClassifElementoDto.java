
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
 * <p>Classe Java per ClassifElementoDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ClassifElementoDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codClassificazioneElemento" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descrizioneClassifElemento" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassifElementoDto", propOrder = {
    "codClassificazioneElemento",
    "descrizioneClassifElemento"
})
public class ClassifElementoDto {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codClassificazioneElemento;
    @XmlElement(required = true, nillable = true)
    protected String descrizioneClassifElemento;

    /**
     * Recupera il valore della proprietà codClassificazioneElemento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodClassificazioneElemento() {
        return codClassificazioneElemento;
    }

    /**
     * Imposta il valore della proprietà codClassificazioneElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodClassificazioneElemento(Integer value) {
        this.codClassificazioneElemento = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneClassifElemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneClassifElemento() {
        return descrizioneClassifElemento;
    }

    /**
     * Imposta il valore della proprietà descrizioneClassifElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneClassifElemento(String value) {
        this.descrizioneClassifElemento = value;
    }

}
