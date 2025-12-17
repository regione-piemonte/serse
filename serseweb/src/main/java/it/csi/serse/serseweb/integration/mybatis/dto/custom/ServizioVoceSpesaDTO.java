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

public class ServizioVoceSpesaDTO  extends ParentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idServizio = null;
	private Long idPso = null;
	private VoceSpesaDTO voceSpesa = null;
	private String codNaturaSpesa = null;
	private BigDecimal parametroEconomico = null;
	private BigDecimal parametroFisico = null;
	private BigDecimal parametroTemporale = null;
	private BigDecimal importoVoceSpesa = null;
	private String codUserInserim = null;
	private Date dInserim = null;
	private String codUserAggiorn = null;
	private Date dAggiorn = null;
	/**
	 * @return the idServizio
	 */
	public Long getIdServizio() {
		return idServizio;
	}
	/**
	 * @param idServizio the idServizio to set
	 */
	public void setIdServizio(Long idServizio) {
		this.idServizio = idServizio;
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
	 * @return the voceSpesa
	 */
	public VoceSpesaDTO getVoceSpesa() {
		return voceSpesa;
	}
	/**
	 * @param voceSpesa the voceSpesa to set
	 */
	public void setVoceSpesa(VoceSpesaDTO voceSpesa) {
		this.voceSpesa = voceSpesa;
	}
	
	/**
	 * @return the codNaturaSpesa
	 */
	public String getCodNaturaSpesa() {
		return codNaturaSpesa;
	}
	/**
	 * @param codNaturaSpesa the codNaturaSpesa to set
	 */
	public void setCodNaturaSpesa(String codNaturaSpesa) {
		this.codNaturaSpesa = codNaturaSpesa;
	}
	/**
	 * @return the parametroEconomico
	 */
	public BigDecimal getParametroEconomico() {
		return parametroEconomico;
	}
	/**
	 * @param parametroEconomico the parametroEconomico to set
	 */
	public void setParametroEconomico(BigDecimal parametroEconomico) {
		this.parametroEconomico = parametroEconomico;
	}
	/**
	 * @return the parametroFisico
	 */
	public BigDecimal getParametroFisico() {
		return parametroFisico;
	}
	/**
	 * @param parametroFisico the parametroFisico to set
	 */
	public void setParametroFisico(BigDecimal parametroFisico) {
		this.parametroFisico = parametroFisico;
	}
	/**
	 * @return the parametroTemporale
	 */
	public BigDecimal getParametroTemporale() {
		return parametroTemporale;
	}
	/**
	 * @param parametroTemporale the parametroTemporale to set
	 */
	public void setParametroTemporale(BigDecimal parametroTemporale) {
		this.parametroTemporale = parametroTemporale;
	}
	
	
	/**
	 * @return the importoVoceSpesa
	 */
	public BigDecimal getImportoVoceSpesa() {
		return importoVoceSpesa;
	}
	/**
	 * @param importoVoceSpesa the importoVoceSpesa to set
	 */
	public void setImportoVoceSpesa(BigDecimal importoVoceSpesa) {
		this.importoVoceSpesa = importoVoceSpesa;
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
	public Date getdInserim() {
		return dInserim;
	}
	/**
	 * @param dInserim the dInserim to set
	 */
	public void setdInserim(Date dInserim) {
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
	public Date getdAggiorn() {
		return dAggiorn;
	}
	/**
	 * @param dAggiorn the dAggiorn to set
	 */
	public void setdAggiorn(Date dAggiorn) {
		this.dAggiorn = dAggiorn;
	}
	@Override
	public String toString() {
		return "ServizioVoceSpesaDTO [idServizio=" + idServizio + ", idPso=" + idPso + ", voceSpesa=" + voceSpesa
				+ ", codNaturaSpesa=" + codNaturaSpesa + ", parametroEconomico=" + parametroEconomico
				+ ", parametroFisico=" + parametroFisico + ", parametroTemporale=" + parametroTemporale
				+ ", importoVoceSpesa=" + importoVoceSpesa + ", codUserInserim=" + codUserInserim + ", dInserim="
				+ dInserim + ", codUserAggiorn=" + codUserAggiorn + ", dAggiorn=" + dAggiorn + "]";
	}

	
	
	
	
}
