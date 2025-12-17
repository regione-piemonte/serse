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

import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleDTO;

/**
 * 
 * @author parci
 *
 */
public class ServizioModelloDTO extends ParentDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1923519635348170648L;
	private Long idServizioModello = null;
	private Long idModelloDiIntervento = null;
	private ServizioRegionaleDTO servizioRegionale = null;
	private String titoloServizioEsterno = null;
	private String attoreEsterno = null;
	private String descrizioneServizioEsterno = null;
	private String codFinalitaServizioEsterno = null;
	private String descrFinalitaServizioEsterno = null;
	private BigDecimal durataInOre = null;
	private ReferenteDTO referente = null;
	private Long idDestinatario = null;
	private String codUserInserim = null;
	private Date dInserim = null;
	private String codUserAggiorn = null;
	private Date dAggiorn = null;

	/**
	 *
	 * @return
	 */
	public String getAttoreEsterno() {
		return attoreEsterno;
	}

	/**
	 *
	 * @param attoreEsterno
	 */
	public void setAttoreEsterno(String attoreEsterno) {
		this.attoreEsterno = attoreEsterno;
	}



	/**
	 * @return the idServizioModello
	 */
	public Long getIdServizioModello() {
		return idServizioModello;
	}
	/**
	 * @param idServizioModello the idServizioModello to set
	 */
	public void setIdServizioModello(Long idServizioModello) {
		this.idServizioModello = idServizioModello;
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
	 * @return the servizioRegionale
	 */
	public ServizioRegionaleDTO getServizioRegionale() {
		return servizioRegionale;
	}
	/**
	 * @param servizioRegionale the servizioRegionale to set
	 */
	public void setServizioRegionale(ServizioRegionaleDTO servizioRegionale) {
		this.servizioRegionale = servizioRegionale;
	}
	/**
	 * @return the titoloServizioEsterno
	 */
	public String getTitoloServizioEsterno() {
		return titoloServizioEsterno;
	}
	/**
	 * @param titoloServizioEsterno the titoloServizioEsterno to set
	 */
	public void setTitoloServizioEsterno(String titoloServizioEsterno) {
		this.titoloServizioEsterno = titoloServizioEsterno;
	}
	/**
	 * @return the descrizioneServizioEsterno
	 */
	public String getDescrizioneServizioEsterno() {
		return descrizioneServizioEsterno;
	}
	/**
	 * @param descrizioneServizioEsterno the descrizioneServizioEsterno to set
	 */
	public void setDescrizioneServizioEsterno(String descrizioneServizioEsterno) {
		this.descrizioneServizioEsterno = descrizioneServizioEsterno;
	}
	/**
	 * @return the codFinalitaServizioEsterno
	 */
	public String getCodFinalitaServizioEsterno() {
		return codFinalitaServizioEsterno;
	}
	/**
	 * @param codFinalitaServizioEsterno the codFinalitaServizioEsterno to set
	 */
	public void setCodFinalitaServizioEsterno(String codFinalitaServizioEsterno) {
		this.codFinalitaServizioEsterno = codFinalitaServizioEsterno;
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
	 * @return the idDestinatario
	 */
	public Long getIdDestinatario() {
		return idDestinatario;
	}
	/**
	 * @param idDestinatario the idDestinatario to set
	 */
	public void setIdDestinatario(Long idDestinatario) {
		this.idDestinatario = idDestinatario;
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
	 * @return the descrFinalitaServizioEsterno
	 */
	public String getDescrFinalitaServizioEsterno() {
		return descrFinalitaServizioEsterno;
	}
	/**
	 * @param descrFinalitaServizioEsterno the descrFinalitaServizioEsterno to set
	 */
	public void setDescrFinalitaServizioEsterno(String descrFinalitaServizioEsterno) {
		this.descrFinalitaServizioEsterno = descrFinalitaServizioEsterno;
	}
	@Override
	public String toString() {
		return "ServizioModelloDTO [idServizioModello=" + idServizioModello + ", idModelloDiIntervento="
				+ idModelloDiIntervento + ", servizioRegionale=" + servizioRegionale + ", titoloServizioEsterno="
				+ titoloServizioEsterno + ", descrizioneServizioEsterno=" + descrizioneServizioEsterno
				+ ", codFinalitaServizioEsterno=" + codFinalitaServizioEsterno + ", durataInOre=" + durataInOre
				+ ", referente=" + referente + ", idDestinatario=" + idDestinatario + ", codUserInserim="
				+ codUserInserim + ", dInserim=" + dInserim + ", codUserAggiorn=" + codUserAggiorn + ", dAggiorn="
				+ dAggiorn + "]";
	}
	
	
	
}
