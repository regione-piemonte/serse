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

public class StatoModelloInterventoDTO extends ParentDTO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7696125595312365437L;
		
	private Long idStatoModelloDiIntervento = null;
	private String descrStatoModelloDiIntervento = null;
	
	
	/**
	 * @return the descrStatoModelloDiIntervento
	 */
	public String getDescrStatoModelloDiIntervento() {
		return descrStatoModelloDiIntervento;
	}
	/**
	 * @return the idStatoModelloDiIntervento
	 */
	public Long getIdStatoModelloDiIntervento() {
		return idStatoModelloDiIntervento;
	}
	/**
	 * @param idStatoModelloDiIntervento the idStatoModelloDiIntervento to set
	 */
	public void setIdStatoModelloDiIntervento(Long idStatoModelloDiIntervento) {
		this.idStatoModelloDiIntervento = idStatoModelloDiIntervento;
	}
	/**
	 * @param descrStatoModelloDiIntervento the descrStatoModelloDiIntervento to set
	 */
	public void setDescrStatoModelloDiIntervento(String descrStatoModelloDiIntervento) {
		this.descrStatoModelloDiIntervento = descrStatoModelloDiIntervento;
	}
	
	 
	  
}
