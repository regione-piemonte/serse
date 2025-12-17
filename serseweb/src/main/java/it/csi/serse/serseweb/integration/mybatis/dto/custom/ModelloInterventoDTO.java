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
import java.util.Date;

/**
 * 
 * @author parci
 *
 */
public class ModelloInterventoDTO extends ParentDTO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3505674859663965857L;
	private Long idModelloIntervento = null;
	private String titolo = null;
	private String descrizione = null;
	private Long idPso = null;
	private TipoModelloDTO tipoModello = null;
	private StatoModelloInterventoDTO statoModelloIntervento = null;
	private SoggettoAttuatoreDTO soggettoAttuatore = null;
	private ReferenteDTO referente = null;
	private String gruppoBeneficiario = null;
	private Long codiceBeneficiario = null;
	private Integer numInterventi = null;
	private String codUserInserimento = null;
	private Date dataInserimento = null;
	private String codUserAggiornamento = null;
	private Date dataAggiornamento = null;

	/**
	 * @return the idModelloIntervento
	 */
	public Long getIdModelloIntervento() {
		return idModelloIntervento;
	}
	/**
	 * @param idModelloIntervento the idModelloIntervento to set
	 */
	public void setIdModelloIntervento(Long idModelloIntervento) {
		this.idModelloIntervento = idModelloIntervento;
	}
	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
	 * @return the tipoModello
	 */
	public TipoModelloDTO getTipoModello() {
		return tipoModello;
	}
	/**
	 * @param tipoModello the tipoModello to set
	 */
	public void setTipoModello(TipoModelloDTO tipoModello) {
		this.tipoModello = tipoModello;
	}
		
	/**
	 * @return the soggettoAttuatore
	 */
	public SoggettoAttuatoreDTO getSoggettoAttuatore() {
		return soggettoAttuatore;
	}
	/**
	 * @return the statoModelloIntervento
	 */
	public StatoModelloInterventoDTO getStatoModelloIntervento() {
		return statoModelloIntervento;
	}
	/**
	 * @param statoModelloIntervento the statoModelloIntervento to set
	 */
	public void setStatoModelloIntervento(StatoModelloInterventoDTO statoModelloIntervento) {
		this.statoModelloIntervento = statoModelloIntervento;
	}
	/**
	 * @param soggettoAttuatore the soggettoAttuatore to set
	 */
	public void setSoggettoAttuatore(SoggettoAttuatoreDTO soggettoAttuatore) {
		this.soggettoAttuatore = soggettoAttuatore;
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
	public String getGruppoBeneficiario() {
		return gruppoBeneficiario;
	}
	public void setGruppoBeneficiario(String gruppoBeneficiario) {
		this.gruppoBeneficiario = gruppoBeneficiario;
	}
	public Long getCodiceBeneficiario() {
		return codiceBeneficiario;
	}
	public void setCodiceBeneficiario(Long codiceBeneficiario) {
		this.codiceBeneficiario = codiceBeneficiario;
	}
	public Integer getNumInterventi() {
		return numInterventi;
	}
	public void setNumInterventi(Integer numInterventi) {
		this.numInterventi = numInterventi;
	}
	/**
	 * @return the codUserInserimento
	 */
	public String getCodUserInserimento() {
		return codUserInserimento;
	}
	/**
	 * @param codUserInserimento the codUserInserimento to set
	 */
	public void setCodUserInserimento(String codUserInserimento) {
		this.codUserInserimento = codUserInserimento;
	}
	/**
	 * @return the dataInserimento
	 */
	public Date getDataInserimento() {
		return dataInserimento;
	}
	/**
	 * @param dataInserimento the dataInserimento to set
	 */
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	/**
	 * @return the codUserAggiornamento
	 */
	public String getCodUserAggiornamento() {
		return codUserAggiornamento;
	}
	/**
	 * @param codUserAggiornamento the codUserAggiornamento to set
	 */
	public void setCodUserAggiornamento(String codUserAggiornamento) {
		this.codUserAggiornamento = codUserAggiornamento;
	}
	/**
	 * @return the dataAggiornamento
	 */
	public Date getDataAggiornamento() {
		return dataAggiornamento;
	}
	/**
	 * @param dataAggiornamento the dataAggiornamento to set
	 */
	public void setDataAggiornamento(Date dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}
	@Override
	public String toString() {
		return "ModelloInterventoDTO [idModelloIntervento=" + idModelloIntervento + ", titolo=" + titolo
				+ ", descrizione=" + descrizione + ", idPso=" + idPso + ", tipoModello=" + tipoModello
				+ ", statoModelloIntervento=" + statoModelloIntervento + ", soggettoAttuatore=" + soggettoAttuatore
				+ ", referente=" + referente + ", codUserInserimento=" + codUserInserimento + ", dataInserimento="
				+ dataInserimento + ", codUserAggiornamento=" + codUserAggiornamento + ", dataAggiornamento="
				+ dataAggiornamento + "]";
	}
	

}
