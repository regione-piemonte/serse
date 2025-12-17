package it.csi.serse.serseweb.integration.mybatis.dto.custom;

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

import java.util.Date;

public class EnteCoinvoltoModelloDTO extends ParentDTO {

	private static final long serialVersionUID = 2736287567066214286L;

	private Long idEnteCoinvoltoModello;
	private String denominazione;
	private String denominazioneSedePrincipale;
	private Long idModelloDiIntervento;
	private String descrizioneFonteDato;
	private Long idPso;
	private Long idFonteDato;
	private Long idRuoloEnte;
	private String descrizioneRuoloEnte;
	private String indirizzo;
	private ComuneDTO comune = new ComuneDTO();
	private String codice1Soggetto;
	private String codice2Soggetto;
	private ReferenteDTO referente = new ReferenteDTO();
	private String codUserInserim;
	private Date dInserim;
	private String codUserAggiorn;
	private Date dAggiorn;
	private Date dataCessazione;
	private String codUserCessazione;

	// LV 2025-01 uso questo DTO per evitare join strane, ma carico solo alcuni campi
	private IstitutoScolasticoDTO istitutoScolastico = new IstitutoScolasticoDTO();

	public Date getDateCessazione() {
		return dataCessazione;
	}

	public void setDateCessazione(Date dateCessazione) {
		this.dataCessazione = dateCessazione;
	}

	public String getCodUserCessazione() {
		return codUserCessazione;
	}

	public void setCodUserCessazione(String codUserCessazione) {
		this.codUserCessazione = codUserCessazione;
	}

	/**
	 *
	 * @return
	 */
	public String getDescrizioneRuoloEnte() {
		return descrizioneRuoloEnte;
	}

	/**
	 *
	 * @return
	 */
	public String getDescrizioneFonteDato() {
		return descrizioneFonteDato;
	}

	/**
	 *
	 * @param descrizioneFonteDato
	 */
	public void setDescrizioneFonteDato(String descrizioneFonteDato) {
		this.descrizioneFonteDato = descrizioneFonteDato;
	}

	/**
	 *
	 * @param descrizioneRuoloEnte
	 */
	public void setDescrizioneRuoloEnte(String descrizioneRuoloEnte) {
		this.descrizioneRuoloEnte = descrizioneRuoloEnte;
	}

	/**
	 * @return the idEnteCoinvoltoModello
	 */
	public Long getIdEnteCoinvoltoModello() {
		return idEnteCoinvoltoModello;
	}

	/**
	 * @param idEnteCoinvoltoModello the idEnteCoinvoltoModello to set
	 */
	public void setIdEnteCoinvoltoModello(Long idEnteCoinvoltoModello) {
		this.idEnteCoinvoltoModello = idEnteCoinvoltoModello;
	}

	/**
	 * @return the denominazione
	 */
	public String getDenominazione() {
		return denominazione;
	}

	/**
	 * @param denominazione the denominazione to set
	 */
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	/**
	 * @return the denominazioneSedePrincipale
	 */
	public String getDenominazioneSedePrincipale() {
		return denominazioneSedePrincipale;
	}

	/**
	 * @param denominazioneSedePrincipale the denominazioneSedePrincipale to set
	 */
	public void setDenominazioneSedePrincipale(String denominazioneSedePrincipale) {
		this.denominazioneSedePrincipale = denominazioneSedePrincipale;
	}

	/**
	 * @return the idModelloDiIntervento
	 */
	public Long getIdModelloDiIntervento() {
		return idModelloDiIntervento;
	}

	/**
	 * @param idModelloDiIntervento the idModelloDiIntervento to set
	 */
	public void setIdModelloDiIntervento(Long idModelloDiIntervento) {
		this.idModelloDiIntervento = idModelloDiIntervento;
	}

	/**
	 * @return the idPso
	 */
	public Long getIdPso() {
		return idPso;
	}

	/**
	 * @param idPso the idPso to set
	 */
	public void setIdPso(Long idPso) {
		this.idPso = idPso;
	}

	/**
	 * @return the idFonteDato
	 */
	public Long getIdFonteDato() {
		return idFonteDato;
	}

	/**
	 * @param idFonteDato the idFonteDato to set
	 */
	public void setIdFonteDato(Long idFonteDato) {
		this.idFonteDato = idFonteDato;
	}

	/**
	 * @return the idRuoloEnte
	 */
	public Long getIdRuoloEnte() {
		return idRuoloEnte;
	}

	/**
	 * @param idRuoloEnte the idRuoloEnte to set
	 */
	public void setIdRuoloEnte(Long idRuoloEnte) {
		this.idRuoloEnte = idRuoloEnte;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the comune
	 */
	public ComuneDTO getComune() {
		return comune;
	}

	/**
	 * @param comune the comune to set
	 */
	public void setComune(ComuneDTO comune) {
		this.comune = comune;
	}

	/**
	 * @return the referente
	 */
	public ReferenteDTO getReferente() {
		return referente;
	}

	/**
	 * @param referente the referente to set
	 */
	public void setReferente(ReferenteDTO referente) {
		this.referente = referente;
	}

	/**
	 *
	 * @return
	 */
	public String getCodice1Soggetto() {
		return codice1Soggetto;
	}

	/**
	 *
	 * @param codice1Soggetto
	 */
	public void setCodice1Soggetto(String codice1Soggetto) {
		this.codice1Soggetto = codice1Soggetto;
	}

	/**
	 *
	 * @return
	 */
	public String getCodice2Soggetto() {
		return codice2Soggetto;
	}

	/**
	 *
	 * @param codice2Soggetto
	 */
	public void setCodice2Soggetto(String codice2Soggetto) {
		this.codice2Soggetto = codice2Soggetto;
	}

	/**
	 * @return the codUserInserim
	 */
	public String getCodUserInserim() {
		return codUserInserim;
	}

	/**
	 * @param codUserInserim the codUserInserim to set
	 */
	public void setCodUserInserim(String codUserInserim) {
		this.codUserInserim = codUserInserim;
	}

	/**
	 * @return the dInserim
	 */
	public Date getDInserim() {
		return dInserim;
	}

	/**
	 * @param dInserim the dInserim to set
	 */
	public void setDInserim(Date dInserim) {
		this.dInserim = dInserim;
	}

	/**
	 * @return the codUserAggiorn
	 */
	public String getCodUserAggiorn() {
		return codUserAggiorn;
	}

	/**
	 * @param codUserAggiorn the codUserAggiorn to set
	 */
	public void setCodUserAggiorn(String codUserAggiorn) {
		this.codUserAggiorn = codUserAggiorn;
	}

	/**
	 * @return the dAggiorn
	 */
	public Date getDAggiorn() {
		return dAggiorn;
	}

	/**
	 * @param dAggiorn the dAggiorn to set
	 */
	public void setDAggiorn(Date dAggiorn) {
		this.dAggiorn = dAggiorn;
	}

	public IstitutoScolasticoDTO getIstitutoScolastico() {
		return istitutoScolastico;
	}

	public void setIstitutoScolastico(IstitutoScolasticoDTO istitutoScolastico) {
		this.istitutoScolastico = istitutoScolastico;
	}

}