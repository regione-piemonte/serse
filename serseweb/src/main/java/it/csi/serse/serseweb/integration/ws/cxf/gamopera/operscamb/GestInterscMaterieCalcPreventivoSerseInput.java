
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
 * <p>Classe Java per gestInterscMaterieCalcPreventivoSerseInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieCalcPreventivoSerseInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numeroDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="areaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="classificazionePORServizio" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}classificazioneDto" minOccurs="0"/&gt;
 *         &lt;element name="codTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTipoServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codSottoTipologiaServizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="durata" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="numDestinatari" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="tkServizio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieCalcPreventivoSerseInput", propOrder = {
    "codiceTipoMateria",
    "codiceTipoRichiesta",
    "idPso",
    "idSportello",
    "numeroDomanda",
    "gruppoOperatore",
    "codiceOperatore",
    "areaTerritoriale",
    "classificazionePORServizio",
    "codTipologiaServizio",
    "codTipoServizio",
    "codSottoTipologiaServizio",
    "durata",
    "numDestinatari",
    "tkServizio"
})
public class GestInterscMaterieCalcPreventivoSerseInput {

    protected String codiceTipoMateria;
    protected String codiceTipoRichiesta;
    protected Long idPso;
    protected Long idSportello;
    protected Long numeroDomanda;
    protected String gruppoOperatore;
    protected Long codiceOperatore;
    protected String areaTerritoriale;
    protected ClassificazioneDto classificazionePORServizio;
    protected String codTipologiaServizio;
    protected String codTipoServizio;
    protected String codSottoTipologiaServizio;
    protected BigDecimal durata;
    protected Long numDestinatari;
    protected Long tkServizio;

    /**
     * Recupera il valore della proprietà codiceTipoMateria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoMateria() {
        return codiceTipoMateria;
    }

    /**
     * Imposta il valore della proprietà codiceTipoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoMateria(String value) {
        this.codiceTipoMateria = value;
    }

    /**
     * Recupera il valore della proprietà codiceTipoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoRichiesta() {
        return codiceTipoRichiesta;
    }

    /**
     * Imposta il valore della proprietà codiceTipoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoRichiesta(String value) {
        this.codiceTipoRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà idPso.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPso() {
        return idPso;
    }

    /**
     * Imposta il valore della proprietà idPso.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPso(Long value) {
        this.idPso = value;
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
     * Recupera il valore della proprietà numeroDomanda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroDomanda() {
        return numeroDomanda;
    }

    /**
     * Imposta il valore della proprietà numeroDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroDomanda(Long value) {
        this.numeroDomanda = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatore() {
        return gruppoOperatore;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatore(String value) {
        this.gruppoOperatore = value;
    }

    /**
     * Recupera il valore della proprietà codiceOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceOperatore() {
        return codiceOperatore;
    }

    /**
     * Imposta il valore della proprietà codiceOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceOperatore(Long value) {
        this.codiceOperatore = value;
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
     * Recupera il valore della proprietà classificazionePORServizio.
     * 
     * @return
     *     possible object is
     *     {@link ClassificazioneDto }
     *     
     */
    public ClassificazioneDto getClassificazionePORServizio() {
        return classificazionePORServizio;
    }

    /**
     * Imposta il valore della proprietà classificazionePORServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificazioneDto }
     *     
     */
    public void setClassificazionePORServizio(ClassificazioneDto value) {
        this.classificazionePORServizio = value;
    }

    /**
     * Recupera il valore della proprietà codTipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipologiaServizio() {
        return codTipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà codTipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipologiaServizio(String value) {
        this.codTipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà codTipoServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoServizio() {
        return codTipoServizio;
    }

    /**
     * Imposta il valore della proprietà codTipoServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoServizio(String value) {
        this.codTipoServizio = value;
    }

    /**
     * Recupera il valore della proprietà codSottoTipologiaServizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSottoTipologiaServizio() {
        return codSottoTipologiaServizio;
    }

    /**
     * Imposta il valore della proprietà codSottoTipologiaServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSottoTipologiaServizio(String value) {
        this.codSottoTipologiaServizio = value;
    }

    /**
     * Recupera il valore della proprietà durata.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurata() {
        return durata;
    }

    /**
     * Imposta il valore della proprietà durata.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurata(BigDecimal value) {
        this.durata = value;
    }

    /**
     * Recupera il valore della proprietà numDestinatari.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumDestinatari() {
        return numDestinatari;
    }

    /**
     * Imposta il valore della proprietà numDestinatari.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumDestinatari(Long value) {
        this.numDestinatari = value;
    }

    /**
     * Recupera il valore della proprietà tkServizio.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTkServizio() {
        return tkServizio;
    }

    /**
     * Imposta il valore della proprietà tkServizio.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTkServizio(Long value) {
        this.tkServizio = value;
    }

}
