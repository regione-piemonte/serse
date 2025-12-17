package it.csi.serse.serseapi.integration.mybatis.dto.custom;

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

public class ServiziDestinatarioDTO extends ParentDTO {

	private static final long serialVersionUID = 114634973333150774L;

	private Long idDestinatario;
	private String cfDestinatario;
	private String nomeDestinatario;
	private String cognomeDestinatario;
	private Date dataNascita;

	private Long idServizio;
	private String titoloServizio;
	private String descrStatoServizio;
	private Integer idServizioRegionale;
	private String descrServizioRegionale;
	private String codFinalitaServizio;
	private String descrFinalitaServizio;
	private String gruppoOperatore;
	private Integer codOperatore;
	private String gruppoBeneficiario;
	private Integer codBeneficiario;

	public Long getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public String getCfDestinatario() {
		return cfDestinatario;
	}

	public void setCfDestinatario(String cfDestinatario) {
		this.cfDestinatario = cfDestinatario;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getCognomeDestinatario() {
		return cognomeDestinatario;
	}

	public void setCognomeDestinatario(String cognomeDestinatario) {
		this.cognomeDestinatario = cognomeDestinatario;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Long getIdServizio() {
		return idServizio;
	}

	public void setIdServizio(Long idServizio) {
		this.idServizio = idServizio;
	}

	public String getTitoloServizio() {
		return titoloServizio;
	}

	public void setTitoloServizio(String titoloServizio) {
		this.titoloServizio = titoloServizio;
	}

	public Integer getIdServizioRegionale() {
		return idServizioRegionale;
	}

	public void setIdServizioRegionale(Integer idServizioRegionale) {
		this.idServizioRegionale = idServizioRegionale;
	}

	public String getDescrServizioRegionale() {
		return descrServizioRegionale;
	}

	public void setDescrServizioRegionale(String descrServizioRegionale) {
		this.descrServizioRegionale = descrServizioRegionale;
	}

	public String getCodFinalitaServizio() {
		return codFinalitaServizio;
	}

	public void setCodFinalitaServizio(String codFinalitaServizio) {
		this.codFinalitaServizio = codFinalitaServizio;
	}

	public String getDescrFinalitaServizio() {
		return descrFinalitaServizio;
	}

	public void setDescrFinalitaServizio(String descrFinalitaServizio) {
		this.descrFinalitaServizio = descrFinalitaServizio;
	}

	public String getGruppoOperatore() {
		return gruppoOperatore;
	}

	public void setGruppoOperatore(String gruppoOperatore) {
		this.gruppoOperatore = gruppoOperatore;
	}

	public Integer getCodOperatore() {
		return codOperatore;
	}

	public void setCodOperatore(Integer codOperatore) {
		this.codOperatore = codOperatore;
	}

	public String getDescrStatoServizio() {
		return descrStatoServizio;
	}

	public void setDescrStatoServizio(String descrStatoServizio) {
		this.descrStatoServizio = descrStatoServizio;
	}

	public String getGruppoBeneficiario() {
		return gruppoBeneficiario;
	}

	public void setGruppoBeneficiario(String gruppoBeneficiario) {
		this.gruppoBeneficiario = gruppoBeneficiario;
	}

	public Integer getCodBeneficiario() {
		return codBeneficiario;
	}

	public void setCodBeneficiario(Integer codBeneficiario) {
		this.codBeneficiario = codBeneficiario;
	}

}
