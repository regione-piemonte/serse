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

public class TestInterventoModificaDTO extends ParentDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7696125595312365437L;
	
	private Long idModelloIntervento = null;
	private Long idDestinatario = null;
	private Long idEnteCoinvoltoIntervento = null;
	private Long idServizio;
	private Integer tipoGestioneIntervento = null;

	/**
	 *
	 * @return
	 */
	public Long getIdServizio() {
		return idServizio;
	}

	/**
	 *
	 * @param idServizio
	 */
	public void setIdServizio(Long idServizio) {
		this.idServizio = idServizio;
	}

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
	 * @return the idEnteCoinvoltoIntervento
	 */
	public Long getIdEnteCoinvoltoIntervento() {
		return idEnteCoinvoltoIntervento;
	}
	/**
	 * @param idEnteCoinvoltoIntervento the idEnteCoinvoltoIntervento to set
	 */
	public void setIdEnteCoinvoltoIntervento(Long idEnteCoinvoltoIntervento) {
		this.idEnteCoinvoltoIntervento = idEnteCoinvoltoIntervento;
	}
	/**
	 * @return the tipoGestioneIntervento
	 */
	public Integer getTipoGestioneIntervento() {
		return tipoGestioneIntervento;
	}
	/**
	 * @param tipoGestioneIntervento the tipoGestioneIntervento to set
	 */
	public void setTipoGestioneIntervento(Integer tipoGestioneIntervento) {
		this.tipoGestioneIntervento = tipoGestioneIntervento;
	}
}
