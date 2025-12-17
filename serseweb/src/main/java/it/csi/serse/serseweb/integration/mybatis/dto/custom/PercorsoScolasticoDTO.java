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

public class PercorsoScolasticoDTO extends ParentDTO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3505674859663965857L;
    private Long idPercorso = null;
    private Long idTipoIstituz = null;
    private String descrPercorso = null;
	/**
	 * @return the idPercorso
	 */
	public Long getIdPercorso() {
		return idPercorso;
	}
	/**
	 * @param idPercorso the idPercorso to set
	 */
	public void setIdPercorso(Long idPercorso) {
		this.idPercorso = idPercorso;
	}
	/**
	 * @return the idTipoIstituz
	 */
	public Long getIdTipoIstituz() {
		return idTipoIstituz;
	}
	/**
	 * @param idTipoIstituz the idTipoIstituz to set
	 */
	public void setIdTipoIstituz(Long idTipoIstituz) {
		this.idTipoIstituz = idTipoIstituz;
	}
	/**
	 * @return the descrPercorso
	 */
	public String getDescrPercorso() {
		return descrPercorso;
	}
	/**
	 * @param descrPercorso the descrPercorso to set
	 */
	public void setDescrPercorso(String descrPercorso) {
		this.descrPercorso = descrPercorso;
	}
    
    
}
