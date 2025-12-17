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
public class SportelloDTO extends ParentDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7696125595312365437L;
	private Integer numProgrSportello = null;
	private PsoDTO pso = null;
	private String descrizioneSportello = null;
	private Date dataInizio = null;
	private Date dataFine = null;

	/**
	 * @return the numProgrSportello
	 */
	public Integer getNumProgrSportello() {
		return numProgrSportello;
	}

	/**
	 * @param numProgrSportello the numProgrSportello to set
	 */
	public void setNumProgrSportello(Integer numProgrSportello) {
		this.numProgrSportello = numProgrSportello;
	}

	/**
	 * @return the pso
	 */
	public PsoDTO getPso() {
		return pso;
	}

	/**
	 * @param pso the pso to set
	 */
	public void setPso(PsoDTO pso) {
		this.pso = pso;
	}

	/**
	 * @return the descrizioneSportello
	 */
	public String getDescrizioneSportello() {
		return descrizioneSportello;
	}

	/**
	 * @param descrizioneSportello the descrizioneSportello to set
	 */
	public void setDescrizioneSportello(String descrizioneSportello) {
		this.descrizioneSportello = descrizioneSportello;
	}

	/**
	 * @return the dataInizio
	 */
	public Date getDataInizio() {
		return dataInizio;
	}

	/**
	 * @param dataInizio the dataInizio to set
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	/**
	 * @return the dataFine
	 */
	public Date getDataFine() {
		return dataFine;
	}

	/**
	 * @param dataFine the dataFine to set
	 */
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}
