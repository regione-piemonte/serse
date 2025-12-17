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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class IncontroDTO extends ParentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 617780533246198186L;

	private Long idIncontro = null;
	private String titoloIncontro = null;
	private Long idServizio = null;
	private Date dInizio = null;
	private Date dFine = null;
	private Float durataOre = null;
	private String nomeReferente = null;
	private String cognomeReferente = null;
	private String referenteEmail = null;
	private String referenteTelefono = null;
	private String note = null;
	private LuogoIncontroDTO luogoIncontro = null;
	private StatoIncontroDTO statoIncontro = null;
	private String codUserChiusura = null;
	private Date dChiusura = null;
	private String codUserInserim = null;
	private Date dInserim = null;
	private String codUserAggiorn = null;
	private Date dAggiorn = null;

	public Long getIdIncontro() {
		return idIncontro;
	}

	public void setIdIncontro(Long idIncontro) {
		this.idIncontro = idIncontro;
	}

	public Long getIdServizio() {
		return idServizio;
	}

	public void setIdServizio(Long idServizio) {
		this.idServizio = idServizio;
	}

	public Date getdInizio() {
		return dInizio;
	}

	public void setdInizio(Date dInizio) {
		this.dInizio = dInizio;
	}

	public Date getdFine() {
		return dFine;
	}

	public void setdFine(Date dFine) {
		this.dFine = dFine;
	}

	public Float getDurataOre() {
		return durataOre;
	}

	public void setDurataOre(Float durataOre) {
		this.durataOre = durataOre;
	}

	public String getNomeReferente() {
		return nomeReferente;
	}

	public void setNomeReferente(String nomeReferente) {
		this.nomeReferente = nomeReferente;
	}

	public String getCognomeReferente() {
		return cognomeReferente;
	}

	public void setCognomeReferente(String cognomeReferente) {
		this.cognomeReferente = cognomeReferente;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LuogoIncontroDTO getLuogoIncontro() {
		return luogoIncontro;
	}

	public void setLuogoIncontro(LuogoIncontroDTO luogoIncontro) {
		this.luogoIncontro = luogoIncontro;
	}

	public StatoIncontroDTO getStatoIncontro() {
		return statoIncontro;
	}

	public void setStatoIncontro(StatoIncontroDTO statoIncontro) {
		this.statoIncontro = statoIncontro;
	}

	public String getCodUserInserim() {
		return codUserInserim;
	}

	public void setCodUserInserim(String codUserInserim) {
		this.codUserInserim = codUserInserim;
	}

	public Date getdInserim() {
		return dInserim;
	}

	public void setdInserim(Date dInserim) {
		this.dInserim = dInserim;
	}

	public String getCodUserAggiorn() {
		return codUserAggiorn;
	}

	public void setCodUserAggiorn(String codUserAggiorn) {
		this.codUserAggiorn = codUserAggiorn;
	}

	public Date getdAggiorn() {
		return dAggiorn;
	}

	public void setdAggiorn(Date dAggiorn) {
		this.dAggiorn = dAggiorn;
	}

	public String getTitoloIncontro() {
		return titoloIncontro;
	}

	public void setTitoloIncontro(String titoloIncontro) {
		this.titoloIncontro = titoloIncontro;
	}

	public String getReferenteEmail() {
		return referenteEmail;
	}

	public void setReferenteEmail(String referenteEmail) {
		this.referenteEmail = referenteEmail;
	}

	public String getReferenteTelefono() {
		return referenteTelefono;
	}

	public void setReferenteTelefono(String referenteTelefono) {
		this.referenteTelefono = referenteTelefono;
	}

	public String getCodUserChiusura() {
		return codUserChiusura;
	}

	public void setCodUserChiusura(String codUserChiusura) {
		this.codUserChiusura = codUserChiusura;
	}

	public Date getdChiusura() {
		return dChiusura;
	}

	public void setdChiusura(Date dChiusura) {
		this.dChiusura = dChiusura;
	}
}
