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

/**
 * 
 * @author parci
 *
 */
public class TipoGestioneSportelloDTO extends ParentDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -933929361954462420L;
	private Long idGestione;
	private Long idPso;
	private Integer numSportello;
	private String tipoGestioneSoggettiRt;
	private String flagGestioneModello;
	private String tipoGestioneIntervento;
	private String tipoGestioneServizio;
	
	
	/**
	 * @return the idGestione
	 */
	public Long getIdGestione() {
		return idGestione;
	}
	/**
	 * @param idGestione the idGestione to set
	 */
	public void setIdGestione(Long idGestione) {
		this.idGestione = idGestione;
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
	 * @return the numSportello
	 */
	public Integer getNumSportello() {
		return numSportello;
	}
	/**
	 * @param numSportello the numSportello to set
	 */
	public void setNumSportello(Integer numSportello) {
		this.numSportello = numSportello;
	}
	/**
	 * @return the tipoGestioneSoggettiRt
	 */
	public String getTipoGestioneSoggettiRt() {
		return tipoGestioneSoggettiRt;
	}
	/**
	 * @param tipoGestioneSoggettiRt the tipoGestioneSoggettiRt to set
	 */
	public void setTipoGestioneSoggettiRt(String tipoGestioneSoggettiRt) {
		this.tipoGestioneSoggettiRt = tipoGestioneSoggettiRt;
	}
	/**
	 * @return the flagGestioneModello
	 */
	public String getFlagGestioneModello() {
		return flagGestioneModello;
	}
	/**
	 * @param flagGestioneModello the flagGestioneModello to set
	 */
	public void setFlagGestioneModello(String flagGestioneModello) {
		this.flagGestioneModello = flagGestioneModello;
	}
	/**
	 * @return the tipoGestioneIntervento
	 */
	public String getTipoGestioneIntervento() {
		return tipoGestioneIntervento;
	}
	/**
	 * @param tipoGestioneIntervento the tipoGestioneIntervento to set
	 */
	public void setTipoGestioneIntervento(String tipoGestioneIntervento) {
		this.tipoGestioneIntervento = tipoGestioneIntervento;
	}
	/**
	 * @return the tipoGestioneServizio
	 */
	public String getTipoGestioneServizio() {
		return tipoGestioneServizio;
	}
	/**
	 * @param tipoGestioneServizio the tipoGestioneServizio to set
	 */
	public void setTipoGestioneServizio(String tipoGestioneServizio) {
		this.tipoGestioneServizio = tipoGestioneServizio;
	}

	
}
