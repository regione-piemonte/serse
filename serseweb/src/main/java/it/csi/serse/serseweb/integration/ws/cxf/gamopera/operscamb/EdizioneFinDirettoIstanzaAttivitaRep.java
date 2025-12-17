
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
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per edizioneFinDirettoIstanzaAttivitaRep complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="edizioneFinDirettoIstanzaAttivitaRep"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="progressivoEdizione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idPso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idSportello" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dtInserimentoRepertorio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="numeroDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idAttivitaDomanda" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ripartizioneIter" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parteIterAttuale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="annoGestione" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="denomAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatore" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="subCodiceOpe" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="sedeOccCod" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="gruppoOperatoreCapofila" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOperatoreCapofila" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="durataTotOreIter" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="durataOreParteIterAttuale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="oreStage" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="oreFad" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="asse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="obiettivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAreaTerr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codAreaTerrFinanziamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numAllievi" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idPercorso" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="codTipoOrario" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="descTipoOrario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codPrcfTipoCertificazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descTipoCertificazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="elencoVociSpesaAttivita" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}voceSpesaAttivitaFinDirettoIstanzaAttivitaRep" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="elencoFontiAttivita" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}fonteAttivitaFinDirettoIstanzaAttivitaRep" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="elencoEdizioniDestinatari" type="{http://operscambserv.interfacews.operserv.gamopera.csi.it/}edizioneDestinatarioFinDirettoIstanzaAttivitaRep" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edizioneFinDirettoIstanzaAttivitaRep", propOrder = {
    "progressivoEdizione",
    "idPso",
    "idSportello",
    "dtInserimentoRepertorio",
    "numeroDomanda",
    "idAttivitaDomanda",
    "ripartizioneIter",
    "parteIterAttuale",
    "annoGestione",
    "denomAttivita",
    "gruppoOperatore",
    "codOperatore",
    "subCodiceOpe",
    "sedeOccCod",
    "gruppoOperatoreCapofila",
    "codOperatoreCapofila",
    "durataTotOreIter",
    "durataOreParteIterAttuale",
    "oreStage",
    "oreFad",
    "asse",
    "obiettivo",
    "attivita",
    "codAzione",
    "codAreaTerr",
    "codAreaTerrFinanziamento",
    "numAllievi",
    "idPercorso",
    "codTipoOrario",
    "descTipoOrario",
    "codPrcfTipoCertificazione",
    "descTipoCertificazione",
    "elencoVociSpesaAttivita",
    "elencoFontiAttivita",
    "elencoEdizioniDestinatari"
})
public class EdizioneFinDirettoIstanzaAttivitaRep {

    protected Long progressivoEdizione;
    protected Long idPso;
    protected Long idSportello;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtInserimentoRepertorio;
    protected Long numeroDomanda;
    protected Long idAttivitaDomanda;
    protected Long ripartizioneIter;
    protected Long parteIterAttuale;
    protected Long annoGestione;
    protected String denomAttivita;
    protected String gruppoOperatore;
    protected Long codOperatore;
    protected Long subCodiceOpe;
    protected Long sedeOccCod;
    protected String gruppoOperatoreCapofila;
    protected Long codOperatoreCapofila;
    protected Long durataTotOreIter;
    protected Long durataOreParteIterAttuale;
    protected Long oreStage;
    protected Long oreFad;
    protected String asse;
    protected String obiettivo;
    protected String attivita;
    protected String codAzione;
    protected String codAreaTerr;
    protected String codAreaTerrFinanziamento;
    protected Long numAllievi;
    protected Long idPercorso;
    protected Long codTipoOrario;
    protected String descTipoOrario;
    protected String codPrcfTipoCertificazione;
    protected String descTipoCertificazione;
    @XmlElement(nillable = true)
    protected List<VoceSpesaAttivitaFinDirettoIstanzaAttivitaRep> elencoVociSpesaAttivita;
    @XmlElement(nillable = true)
    protected List<FonteAttivitaFinDirettoIstanzaAttivitaRep> elencoFontiAttivita;
    @XmlElement(nillable = true)
    protected List<EdizioneDestinatarioFinDirettoIstanzaAttivitaRep> elencoEdizioniDestinatari;

    /**
     * Recupera il valore della proprietà progressivoEdizione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProgressivoEdizione() {
        return progressivoEdizione;
    }

    /**
     * Imposta il valore della proprietà progressivoEdizione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProgressivoEdizione(Long value) {
        this.progressivoEdizione = value;
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
     * Recupera il valore della proprietà dtInserimentoRepertorio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtInserimentoRepertorio() {
        return dtInserimentoRepertorio;
    }

    /**
     * Imposta il valore della proprietà dtInserimentoRepertorio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtInserimentoRepertorio(XMLGregorianCalendar value) {
        this.dtInserimentoRepertorio = value;
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
     * Recupera il valore della proprietà ripartizioneIter.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRipartizioneIter() {
        return ripartizioneIter;
    }

    /**
     * Imposta il valore della proprietà ripartizioneIter.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRipartizioneIter(Long value) {
        this.ripartizioneIter = value;
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
     * Recupera il valore della proprietà annoGestione.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAnnoGestione() {
        return annoGestione;
    }

    /**
     * Imposta il valore della proprietà annoGestione.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAnnoGestione(Long value) {
        this.annoGestione = value;
    }

    /**
     * Recupera il valore della proprietà denomAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenomAttivita() {
        return denomAttivita;
    }

    /**
     * Imposta il valore della proprietà denomAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenomAttivita(String value) {
        this.denomAttivita = value;
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
     * Recupera il valore della proprietà codOperatore.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatore() {
        return codOperatore;
    }

    /**
     * Imposta il valore della proprietà codOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatore(Long value) {
        this.codOperatore = value;
    }

    /**
     * Recupera il valore della proprietà subCodiceOpe.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubCodiceOpe() {
        return subCodiceOpe;
    }

    /**
     * Imposta il valore della proprietà subCodiceOpe.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubCodiceOpe(Long value) {
        this.subCodiceOpe = value;
    }

    /**
     * Recupera il valore della proprietà sedeOccCod.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSedeOccCod() {
        return sedeOccCod;
    }

    /**
     * Imposta il valore della proprietà sedeOccCod.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSedeOccCod(Long value) {
        this.sedeOccCod = value;
    }

    /**
     * Recupera il valore della proprietà gruppoOperatoreCapofila.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoOperatoreCapofila() {
        return gruppoOperatoreCapofila;
    }

    /**
     * Imposta il valore della proprietà gruppoOperatoreCapofila.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoOperatoreCapofila(String value) {
        this.gruppoOperatoreCapofila = value;
    }

    /**
     * Recupera il valore della proprietà codOperatoreCapofila.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodOperatoreCapofila() {
        return codOperatoreCapofila;
    }

    /**
     * Imposta il valore della proprietà codOperatoreCapofila.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodOperatoreCapofila(Long value) {
        this.codOperatoreCapofila = value;
    }

    /**
     * Recupera il valore della proprietà durataTotOreIter.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDurataTotOreIter() {
        return durataTotOreIter;
    }

    /**
     * Imposta il valore della proprietà durataTotOreIter.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDurataTotOreIter(Long value) {
        this.durataTotOreIter = value;
    }

    /**
     * Recupera il valore della proprietà durataOreParteIterAttuale.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDurataOreParteIterAttuale() {
        return durataOreParteIterAttuale;
    }

    /**
     * Imposta il valore della proprietà durataOreParteIterAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDurataOreParteIterAttuale(Long value) {
        this.durataOreParteIterAttuale = value;
    }

    /**
     * Recupera il valore della proprietà oreStage.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOreStage() {
        return oreStage;
    }

    /**
     * Imposta il valore della proprietà oreStage.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOreStage(Long value) {
        this.oreStage = value;
    }

    /**
     * Recupera il valore della proprietà oreFad.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOreFad() {
        return oreFad;
    }

    /**
     * Imposta il valore della proprietà oreFad.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOreFad(Long value) {
        this.oreFad = value;
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
     * Recupera il valore della proprietà codAzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAzione() {
        return codAzione;
    }

    /**
     * Imposta il valore della proprietà codAzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAzione(String value) {
        this.codAzione = value;
    }

    /**
     * Recupera il valore della proprietà codAreaTerr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAreaTerr() {
        return codAreaTerr;
    }

    /**
     * Imposta il valore della proprietà codAreaTerr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAreaTerr(String value) {
        this.codAreaTerr = value;
    }

    /**
     * Recupera il valore della proprietà codAreaTerrFinanziamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAreaTerrFinanziamento() {
        return codAreaTerrFinanziamento;
    }

    /**
     * Imposta il valore della proprietà codAreaTerrFinanziamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAreaTerrFinanziamento(String value) {
        this.codAreaTerrFinanziamento = value;
    }

    /**
     * Recupera il valore della proprietà numAllievi.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumAllievi() {
        return numAllievi;
    }

    /**
     * Imposta il valore della proprietà numAllievi.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumAllievi(Long value) {
        this.numAllievi = value;
    }

    /**
     * Recupera il valore della proprietà idPercorso.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPercorso() {
        return idPercorso;
    }

    /**
     * Imposta il valore della proprietà idPercorso.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPercorso(Long value) {
        this.idPercorso = value;
    }

    /**
     * Recupera il valore della proprietà codTipoOrario.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodTipoOrario() {
        return codTipoOrario;
    }

    /**
     * Imposta il valore della proprietà codTipoOrario.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodTipoOrario(Long value) {
        this.codTipoOrario = value;
    }

    /**
     * Recupera il valore della proprietà descTipoOrario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoOrario() {
        return descTipoOrario;
    }

    /**
     * Imposta il valore della proprietà descTipoOrario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoOrario(String value) {
        this.descTipoOrario = value;
    }

    /**
     * Recupera il valore della proprietà codPrcfTipoCertificazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPrcfTipoCertificazione() {
        return codPrcfTipoCertificazione;
    }

    /**
     * Imposta il valore della proprietà codPrcfTipoCertificazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPrcfTipoCertificazione(String value) {
        this.codPrcfTipoCertificazione = value;
    }

    /**
     * Recupera il valore della proprietà descTipoCertificazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoCertificazione() {
        return descTipoCertificazione;
    }

    /**
     * Imposta il valore della proprietà descTipoCertificazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoCertificazione(String value) {
        this.descTipoCertificazione = value;
    }

    /**
     * Gets the value of the elencoVociSpesaAttivita property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoVociSpesaAttivita property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoVociSpesaAttivita().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoceSpesaAttivitaFinDirettoIstanzaAttivitaRep }
     * 
     * 
     */
    public List<VoceSpesaAttivitaFinDirettoIstanzaAttivitaRep> getElencoVociSpesaAttivita() {
        if (elencoVociSpesaAttivita == null) {
            elencoVociSpesaAttivita = new ArrayList<VoceSpesaAttivitaFinDirettoIstanzaAttivitaRep>();
        }
        return this.elencoVociSpesaAttivita;
    }

    /**
     * Gets the value of the elencoFontiAttivita property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoFontiAttivita property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoFontiAttivita().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FonteAttivitaFinDirettoIstanzaAttivitaRep }
     * 
     * 
     */
    public List<FonteAttivitaFinDirettoIstanzaAttivitaRep> getElencoFontiAttivita() {
        if (elencoFontiAttivita == null) {
            elencoFontiAttivita = new ArrayList<FonteAttivitaFinDirettoIstanzaAttivitaRep>();
        }
        return this.elencoFontiAttivita;
    }

    /**
     * Gets the value of the elencoEdizioniDestinatari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elencoEdizioniDestinatari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoEdizioniDestinatari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EdizioneDestinatarioFinDirettoIstanzaAttivitaRep }
     * 
     * 
     */
    public List<EdizioneDestinatarioFinDirettoIstanzaAttivitaRep> getElencoEdizioniDestinatari() {
        if (elencoEdizioniDestinatari == null) {
            elencoEdizioniDestinatari = new ArrayList<EdizioneDestinatarioFinDirettoIstanzaAttivitaRep>();
        }
        return this.elencoEdizioniDestinatari;
    }

}
