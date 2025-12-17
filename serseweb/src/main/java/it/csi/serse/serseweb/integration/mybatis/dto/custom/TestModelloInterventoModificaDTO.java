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

public class TestModelloInterventoModificaDTO {
	Integer idRModelloTargetDest;
	Integer idRCaratteristica;
	Integer idServizioModello;
	Integer idEnteCoinvolto;
	Integer idIntervento ;

	/**
	 *
	 * @return
	 */
	public Integer getIdIntervento() {
		return idIntervento;
	}

	/**
	 *
	 * @param idIntervento
	 */
	public void setIdIntervento(Integer idIntervento) {
		this.idIntervento = idIntervento;
	}

	/**
	 * @return the idRModelloTargetDest
	 */
	public Integer getIdRModelloTargetDest() {
		return idRModelloTargetDest;
	}
	/**
	 * @param idRModelloTargetDest the idRModelloTargetDest to set
	 */
	public void setIdRModelloTargetDest(Integer idRModelloTargetDest) {
		this.idRModelloTargetDest = idRModelloTargetDest;
	}
	
	/**
	 * @return the idRCaratteristica
	 */
	public Integer getIdRCaratteristica() {
		return idRCaratteristica;
	}
	/**
	 * @param idRCaratteristica the idRCaratteristica to set
	 */
	public void setIdRCaratteristica(Integer idRCaratteristica) {
		this.idRCaratteristica = idRCaratteristica;
	}
	/**
	 * @return the idServizioModello
	 */
	public Integer getIdServizioModello() {
		return idServizioModello;
	}
	/**
	 * @param idServizioModello the idServizioModello to set
	 */
	public void setIdServizioModello(Integer idServizioModello) {
		this.idServizioModello = idServizioModello;
	}
	/**
	 * @return the idEnteCoinvolto
	 */
	public Integer getIdEnteCoinvolto() {
		return idEnteCoinvolto;
	}
	/**
	 * @param idEnteCoinvolto the idEnteCoinvolto to set
	 */
	public void setIdEnteCoinvolto(Integer idEnteCoinvolto) {
		this.idEnteCoinvolto = idEnteCoinvolto;
	}
	
	
}
