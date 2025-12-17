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

public class ServizioRegionaleDTO extends ParentDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1923519635348170648L;
	
	private Long idServizioRegionale = null;
	private Long idPso = null;
	private Long idClassificazione = null;
	private String codiceServizioRegionale = null;
	private String descrServizioRegionale = null;
	private String codFinalitaServizio = null;
	private String descrFinalitaServizio = null;
	private BigDecimal durataInOre = null;
	private Integer oreConsentiteMin = null;
	private Integer oreConsentiteMax = null;
	
	/**
	 * @return the idServizioRegionale
	 */
	public Long getIdServizioRegionale() {
		return idServizioRegionale;
	}
	/**
	 * @param idServizioRegionale the idServizioRegionale to set
	 */
	public void setIdServizioRegionale(Long idServizioRegionale) {
		this.idServizioRegionale = idServizioRegionale;
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
	 * @return the idClassificazione
	 */
	public Long getIdClassificazione() {
		return idClassificazione;
	}
	/**
	 * @param idClassificazione the idClassificazione to set
	 */
	public void setIdClassificazione(Long idClassificazione) {
		this.idClassificazione = idClassificazione;
	}
	/**
	 * @return the codiceServizioRegionale
	 */
	public String getCodiceServizioRegionale() {
		return codiceServizioRegionale;
	}
	/**
	 * @param codiceServizioRegionale the codiceServizioRegionale to set
	 */
	public void setCodiceServizioRegionale(String codiceServizioRegionale) {
		this.codiceServizioRegionale = codiceServizioRegionale;
	}
	/**
	 * @return the descrServizioRegionale
	 */
	public String getDescrServizioRegionale() {
		return descrServizioRegionale;
	}
	/**
	 * @param descrServizioRegionale the descrServizioRegionale to set
	 */
	public void setDescrServizioRegionale(String descrServizioRegionale) {
		this.descrServizioRegionale = descrServizioRegionale;
	}
	/**
	 * @return the codFinalitaServizio
	 */
	public String getCodFinalitaServizio() {
		return codFinalitaServizio;
	}
	/**
	 * @param codFinalitaServizio the codFinalitaServizio to set
	 */
	public void setCodFinalitaServizio(String codFinalitaServizio) {
		this.codFinalitaServizio = codFinalitaServizio;
	}
	/**
	 * @return the durataInOre
	 */
	public BigDecimal getDurataInOre() {
		return durataInOre;
	}
	/**
	 * @param durataInOre the durataInOre to set
	 */
	public void setDurataInOre(BigDecimal durataInOre) {
		this.durataInOre = durataInOre;
	}
	/**
	 * @return the oreConsentiteMin
	 */
	public Integer getOreConsentiteMin() {
		return oreConsentiteMin;
	}
	/**
	 * @param oreConsentiteMin the oreConsentiteMin to set
	 */
	public void setOreConsentiteMin(Integer oreConsentiteMin) {
		this.oreConsentiteMin = oreConsentiteMin;
	}
	/**
	 * @return the oreConsentiteMax
	 */
	public Integer getOreConsentiteMax() {
		return oreConsentiteMax;
	}
	/**
	 * @param oreConsentiteMax the oreConsentiteMax to set
	 */
	public void setOreConsentiteMax(Integer oreConsentiteMax) {
		this.oreConsentiteMax = oreConsentiteMax;
	}
	/**
	 * @return the descrFinalitaServizio
	 */
	public String getDescrFinalitaServizio() {
		return descrFinalitaServizio;
	}
	/**
	 * @param descrFinalitaServizio the descrFinalitaServizio to set
	 */
	public void setDescrFinalitaServizio(String descrFinalitaServizio) {
		this.descrFinalitaServizio = descrFinalitaServizio;
	}

	@Override
	public String toString() {
		return "ServizioRegionaleDTO{" +
				"idServizioRegionale=" + idServizioRegionale +
				", idPso=" + idPso +
				", idClassificazione=" + idClassificazione +
				", codiceServizioRegionale='" + codiceServizioRegionale + '\'' +
				", descrServizioRegionale='" + descrServizioRegionale + '\'' +
				", codFinalitaServizio='" + codFinalitaServizio + '\'' +
				", descrFinalitaServizio='" + descrFinalitaServizio + '\'' +
				", durataInOre=" + durataInOre +
				", oreConsentiteMin=" + oreConsentiteMin +
				", oreConsentiteMax=" + oreConsentiteMax +
				'}';
	}
}
