
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
 * <p>Classe Java per gestAttivitaGetClassificFromIdAttivitaOutput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestAttivitaGetClassificFromIdAttivitaOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esito" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}esitoDto" minOccurs="0"/&gt;
 *         &lt;element name="idAttivita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="classificazione" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classTabFinanziamento" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestAttivitaGetClassificFromIdAttivitaOutput", propOrder = {
    "esito",
    "idAttivita",
    "classificazione"
})
public class GestAttivitaGetClassificFromIdAttivitaOutput {

    protected EsitoDto esito;
    protected Long idAttivita;
    protected ClassTabFinanziamento classificazione;

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link EsitoDto }
     *     
     */
    public EsitoDto getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link EsitoDto }
     *     
     */
    public void setEsito(EsitoDto value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della proprietà idAttivita.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAttivita() {
        return idAttivita;
    }

    /**
     * Imposta il valore della proprietà idAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAttivita(Long value) {
        this.idAttivita = value;
    }

    /**
     * Recupera il valore della proprietà classificazione.
     * 
     * @return
     *     possible object is
     *     {@link ClassTabFinanziamento }
     *     
     */
    public ClassTabFinanziamento getClassificazione() {
        return classificazione;
    }

    /**
     * Imposta il valore della proprietà classificazione.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassTabFinanziamento }
     *     
     */
    public void setClassificazione(ClassTabFinanziamento value) {
        this.classificazione = value;
    }

}
