
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
 * <p>Classe Java per materieSearchFontiTabFinDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="materieSearchFontiTabFinDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idFonte" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="priorita" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="progressivoAssociazione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="percentualeRipartizione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="descFonte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descCopertura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descFonteBreve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codCopertura" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "materieSearchFontiTabFinDto", propOrder = {
    "idFonte",
    "priorita",
    "progressivoAssociazione",
    "percentualeRipartizione",
    "descFonte",
    "descCopertura",
    "descFonteBreve",
    "codCopertura"
})
public class MaterieSearchFontiTabFinDto {

    protected Long idFonte;
    protected Long priorita;
    protected Long progressivoAssociazione;
    protected BigDecimal percentualeRipartizione;
    protected String descFonte;
    protected String descCopertura;
    protected String descFonteBreve;
    protected Long codCopertura;

    /**
     * Recupera il valore della proprietà idFonte.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdFonte() {
        return idFonte;
    }

    /**
     * Imposta il valore della proprietà idFonte.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFonte(Long value) {
        this.idFonte = value;
    }

    /**
     * Recupera il valore della proprietà priorita.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriorita() {
        return priorita;
    }

    /**
     * Imposta il valore della proprietà priorita.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriorita(Long value) {
        this.priorita = value;
    }

    /**
     * Recupera il valore della proprietà progressivoAssociazione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProgressivoAssociazione() {
        return progressivoAssociazione;
    }

    /**
     * Imposta il valore della proprietà progressivoAssociazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProgressivoAssociazione(Long value) {
        this.progressivoAssociazione = value;
    }

    /**
     * Recupera il valore della proprietà percentualeRipartizione.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentualeRipartizione() {
        return percentualeRipartizione;
    }

    /**
     * Imposta il valore della proprietà percentualeRipartizione.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentualeRipartizione(BigDecimal value) {
        this.percentualeRipartizione = value;
    }

    /**
     * Recupera il valore della proprietà descFonte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescFonte() {
        return descFonte;
    }

    /**
     * Imposta il valore della proprietà descFonte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescFonte(String value) {
        this.descFonte = value;
    }

    /**
     * Recupera il valore della proprietà descCopertura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescCopertura() {
        return descCopertura;
    }

    /**
     * Imposta il valore della proprietà descCopertura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescCopertura(String value) {
        this.descCopertura = value;
    }

    /**
     * Recupera il valore della proprietà descFonteBreve.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescFonteBreve() {
        return descFonteBreve;
    }

    /**
     * Imposta il valore della proprietà descFonteBreve.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescFonteBreve(String value) {
        this.descFonteBreve = value;
    }

    /**
     * Recupera il valore della proprietà codCopertura.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodCopertura() {
        return codCopertura;
    }

    /**
     * Imposta il valore della proprietà codCopertura.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodCopertura(Long value) {
        this.codCopertura = value;
    }

}
