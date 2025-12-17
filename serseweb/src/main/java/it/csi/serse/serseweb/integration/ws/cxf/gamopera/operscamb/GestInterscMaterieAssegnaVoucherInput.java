
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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gestInterscMaterieAssegnaVoucherInput complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gestInterscMaterieAssegnaVoucherInput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codTipoMateria" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codTipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idDomandaVoucher" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idInterventoApprovatoMateria" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoVoucher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="asse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="obiettivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="azione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAreaTerritoriale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gruppoSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idDomandaSoggettoFinanziato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreAzienda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codCorRna" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataAttribuzioneCodCorRna" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="codiceVisura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codCorsoCatalogo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denominazioneCorsoCatalogo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="durataCorso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="quotaPubblicaProposta" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="quotaPrivataProposta" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="percentualeCofinanziamentoPrivato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestInterscMaterieAssegnaVoucherInput", propOrder = {
    "codTipoMateria",
    "codTipoRichiesta",
    "idDomandaVoucher",
    "idInterventoApprovatoMateria",
    "idSportello",
    "codFiscale",
    "cognome",
    "nome",
    "tipoVoucher",
    "asse",
    "obiettivo",
    "attivita",
    "azione",
    "codAreaTerritoriale",
    "gruppoSoggettoFinanziato",
    "codiceSoggettoFinanziato",
    "idDomandaSoggettoFinanziato",
    "denominazioneAzienda",
    "gruppoOperatoreAzienda",
    "codOperatoreAzienda",
    "codCorRna",
    "dataAttribuzioneCodCorRna",
    "codiceVisura",
    "codCorsoCatalogo",
    "denominazioneCorsoCatalogo",
    "durataCorso",
    "quotaPubblicaProposta",
    "quotaPrivataProposta",
    "percentualeCofinanziamentoPrivato"
})
public class GestInterscMaterieAssegnaVoucherInput {

    @XmlElement(required = true)
    protected String codTipoMateria;
    protected String codTipoRichiesta;
    protected Long idDomandaVoucher;
    protected Long idInterventoApprovatoMateria;
    protected Long idSportello;
    protected String codFiscale;
    protected String cognome;
    protected String nome;
    protected String tipoVoucher;
    protected String asse;
    protected String obiettivo;
    protected String attivita;
    protected String azione;
    protected String codAreaTerritoriale;
    protected String gruppoSoggettoFinanziato;
    protected Long codiceSoggettoFinanziato;
    protected Long idDomandaSoggettoFinanziato;
    protected String denominazioneAzienda;
    protected String gruppoOperatoreAzienda;
    protected Long codOperatoreAzienda;
    protected Long codCorRna;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAttribuzioneCodCorRna;
    protected String codiceVisura;
    protected Long codCorsoCatalogo;
    protected String denominazioneCorsoCatalogo;
    protected Long durataCorso;
    protected BigDecimal quotaPubblicaProposta;
    protected BigDecimal quotaPrivataProposta;
    protected Long percentualeCofinanziamentoPrivato;

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
     * Recupera il valore della proprietà idDomandaVoucher.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDomandaVoucher() {
        return idDomandaVoucher;
    }

    /**
     * Imposta il valore della proprietà idDomandaVoucher.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDomandaVoucher(Long value) {
        this.idDomandaVoucher = value;
    }

    /**
     * Recupera il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdInterventoApprovatoMateria() {
        return idInterventoApprovatoMateria;
    }

    /**
     * Imposta il valore della proprietà idInterventoApprovatoMateria.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdInterventoApprovatoMateria(Long value) {
        this.idInterventoApprovatoMateria = value;
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
     * Recupera il valore della proprietà codFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscale() {
        return codFiscale;
    }

    /**
     * Imposta il valore della proprietà codFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscale(String value) {
        this.codFiscale = value;
    }

    /**
     * Recupera il valore della proprietà cognome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il valore della proprietà cognome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognome(String value) {
        this.cognome = value;
    }

    /**
     * Recupera il valore della proprietà nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il valore della proprietà nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Recupera il valore della proprietà tipoVoucher.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoVoucher() {
        return tipoVoucher;
    }

    /**
     * Imposta il valore della proprietà tipoVoucher.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoVoucher(String value) {
        this.tipoVoucher = value;
    }

    /**
     * Recupera il valore della proprietà asse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsse() {
        return asse;
    }

    /**
     * Imposta il valore della proprietà asse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsse(String value) {
        this.asse = value;
    }

    /**
     * Recupera il valore della proprietà obiettivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObiettivo() {
        return obiettivo;
    }

    /**
     * Imposta il valore della proprietà obiettivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObiettivo(String value) {
        this.obiettivo = value;
    }

    /**
     * Recupera il valore della proprietà attivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttivita() {
        return attivita;
    }

    /**
     * Imposta il valore della proprietà attivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttivita(String value) {
        this.attivita = value;
    }

    /**
     * Recupera il valore della proprietà azione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAzione() {
        return azione;
    }

    /**
     * Imposta il valore della proprietà azione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAzione(String value) {
        this.azione = value;
    }

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
     * Recupera il valore della proprietà gruppoSoggettoFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoSoggettoFinanziato() {
        return gruppoSoggettoFinanziato;
    }

    /**
     * Imposta il valore della proprietà gruppoSoggettoFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoSoggettoFinanziato(String value) {
        this.gruppoSoggettoFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà codiceSoggettoFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodiceSoggettoFinanziato() {
        return codiceSoggettoFinanziato;
    }

    /**
     * Imposta il valore della proprietà codiceSoggettoFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodiceSoggettoFinanziato(Long value) {
        this.codiceSoggettoFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà idDomandaSoggettoFinanziato.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDomandaSoggettoFinanziato() {
        return idDomandaSoggettoFinanziato;
    }

    /**
     * Imposta il valore della proprietà idDomandaSoggettoFinanziato.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDomandaSoggettoFinanziato(Long value) {
        this.idDomandaSoggettoFinanziato = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneAzienda() {
        return denominazioneAzienda;
    }

    /**
     * Imposta il valore della proprietà denominazioneAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneAzienda(String value) {
        this.denominazioneAzienda = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreAzienda() {
        return gruppoOperatoreAzienda;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreAzienda(String value) {
        this.gruppoOperatoreAzienda = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreAzienda.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatoreAzienda() {
        return codOperatoreAzienda;
    }

    /**
     * Imposta il valore della proprietà codOperatoreAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatoreAzienda(Long value) {
        this.codOperatoreAzienda = value;
    }

    /**
     * Recupera il valore della proprietà codCorRna.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodCorRna() {
        return codCorRna;
    }

    /**
     * Imposta il valore della proprietà codCorRna.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodCorRna(Long value) {
        this.codCorRna = value;
    }

    /**
     * Recupera il valore della proprietà dataAttribuzioneCodCorRna.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAttribuzioneCodCorRna() {
        return dataAttribuzioneCodCorRna;
    }

    /**
     * Imposta il valore della proprietà dataAttribuzioneCodCorRna.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAttribuzioneCodCorRna(XMLGregorianCalendar value) {
        this.dataAttribuzioneCodCorRna = value;
    }

    /**
     * Recupera il valore della proprietà codiceVisura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceVisura() {
        return codiceVisura;
    }

    /**
     * Imposta il valore della proprietà codiceVisura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceVisura(String value) {
        this.codiceVisura = value;
    }

    /**
     * Recupera il valore della proprietà codCorsoCatalogo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodCorsoCatalogo() {
        return codCorsoCatalogo;
    }

    /**
     * Imposta il valore della proprietà codCorsoCatalogo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodCorsoCatalogo(Long value) {
        this.codCorsoCatalogo = value;
    }

    /**
     * Recupera il valore della proprietà denominazioneCorsoCatalogo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneCorsoCatalogo() {
        return denominazioneCorsoCatalogo;
    }

    /**
     * Imposta il valore della proprietà denominazioneCorsoCatalogo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneCorsoCatalogo(String value) {
        this.denominazioneCorsoCatalogo = value;
    }

    /**
     * Recupera il valore della proprietà durataCorso.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDurataCorso() {
        return durataCorso;
    }

    /**
     * Imposta il valore della proprietà durataCorso.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDurataCorso(Long value) {
        this.durataCorso = value;
    }

    /**
     * Recupera il valore della proprietà quotaPubblicaProposta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPubblicaProposta() {
        return quotaPubblicaProposta;
    }

    /**
     * Imposta il valore della proprietà quotaPubblicaProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPubblicaProposta(BigDecimal value) {
        this.quotaPubblicaProposta = value;
    }

    /**
     * Recupera il valore della proprietà quotaPrivataProposta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuotaPrivataProposta() {
        return quotaPrivataProposta;
    }

    /**
     * Imposta il valore della proprietà quotaPrivataProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuotaPrivataProposta(BigDecimal value) {
        this.quotaPrivataProposta = value;
    }

    /**
     * Recupera il valore della proprietà percentualeCofinanziamentoPrivato.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPercentualeCofinanziamentoPrivato() {
        return percentualeCofinanziamentoPrivato;
    }

    /**
     * Imposta il valore della proprietà percentualeCofinanziamentoPrivato.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPercentualeCofinanziamentoPrivato(Long value) {
        this.percentualeCofinanziamentoPrivato = value;
    }

}
