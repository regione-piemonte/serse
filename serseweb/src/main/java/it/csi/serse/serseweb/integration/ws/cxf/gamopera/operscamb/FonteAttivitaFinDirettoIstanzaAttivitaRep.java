
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
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per fonteAttivitaFinDirettoIstanzaAttivitaRep complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="fonteAttivitaFinDirettoIstanzaAttivitaRep"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAttivitaDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parteIterAttuale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idFonteGam" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="percentuale" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="percentualePubblica" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fonteAttivitaFinDirettoIstanzaAttivitaRep", propOrder = {
    "idAttivitaDomanda",
    "parteIterAttuale",
    "idFonteGam",
    "importo",
    "percentuale",
    "percentualePubblica"
})
public class FonteAttivitaFinDirettoIstanzaAttivitaRep {

    protected Long idAttivitaDomanda;
    protected Long parteIterAttuale;
    protected Long idFonteGam;
    protected BigDecimal importo;
    protected BigDecimal percentuale;
    protected BigDecimal percentualePubblica;

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
     * Recupera il valore della proprietà idFonteGam.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdFonteGam() {
        return idFonteGam;
    }

    /**
     * Imposta il valore della proprietà idFonteGam.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFonteGam(Long value) {
        this.idFonteGam = value;
    }

    /**
     * Recupera il valore della proprietà importo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImporto() {
        return importo;
    }

    /**
     * Imposta il valore della proprietà importo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImporto(BigDecimal value) {
        this.importo = value;
    }

    /**
     * Recupera il valore della proprietà percentuale.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentuale() {
        return percentuale;
    }

    /**
     * Imposta il valore della proprietà percentuale.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentuale(BigDecimal value) {
        this.percentuale = value;
    }

    /**
     * Recupera il valore della proprietà percentualePubblica.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentualePubblica() {
        return percentualePubblica;
    }

    /**
     * Imposta il valore della proprietà percentualePubblica.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentualePubblica(BigDecimal value) {
        this.percentualePubblica = value;
    }

}
