
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
 * <p>Classe Java per edizioneDestinatarioFinDirettoIstanzaAttivitaRep complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="edizioneDestinatarioFinDirettoIstanzaAttivitaRep"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttivitaDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parteIterAttuale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codDestinatario" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="descDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edizioneDestinatarioFinDirettoIstanzaAttivitaRep", propOrder = {
    "idAttivitaDomanda",
    "parteIterAttuale",
    "codDestinatario",
    "descDestinatario"
})
public class EdizioneDestinatarioFinDirettoIstanzaAttivitaRep {

    protected Long idAttivitaDomanda;
    protected Long parteIterAttuale;
    protected Long codDestinatario;
    protected String descDestinatario;

    /**
     * Recupera il valore della proprietà idAttivitaDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivitaDomanda() {
        return idAttivitaDomanda;
    }

    /**
     * Imposta il valore della proprietà idAttivitaDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivitaDomanda(Long value) {
        this.idAttivitaDomanda = value;
    }

    /**
     * Recupera il valore della proprietà parteIterAttuale.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParteIterAttuale() {
        return parteIterAttuale;
    }

    /**
     * Imposta il valore della proprietà parteIterAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParteIterAttuale(Long value) {
        this.parteIterAttuale = value;
    }

    /**
     * Recupera il valore della proprietà codDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodDestinatario() {
        return codDestinatario;
    }

    /**
     * Imposta il valore della proprietà codDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodDestinatario(Long value) {
        this.codDestinatario = value;
    }

    /**
     * Recupera il valore della proprietà descDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescDestinatario() {
        return descDestinatario;
    }

    /**
     * Imposta il valore della proprietà descDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescDestinatario(String value) {
        this.descDestinatario = value;
    }

}
