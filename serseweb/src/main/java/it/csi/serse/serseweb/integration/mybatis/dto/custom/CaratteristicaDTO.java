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

public class CaratteristicaDTO extends ParentDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7696125595312365437L;
	
	private Long idCaratteristica = null;
	private String descrCaratteristica = null;
	
	
	/**
	 * @return the idCaratteristica
	 */
	public Long getIdCaratteristica() {
		return idCaratteristica;
	}
	
	/**
	 * @param idCaratteristica the idCaratteristica to set
	 */
	public void setIdCaratteristica(Long idCaratteristica) {
		this.idCaratteristica = idCaratteristica;
	}
	
	/**
	 * @return the descrCaratteristica
	 */
	public String getDescrCaratteristica() {
		return descrCaratteristica;
	}
	
	/**
	 * @param descrCaratteristica the descrCaratteristica to set
	 */
	public void setDescrCaratteristica(String descrCaratteristica) {
		this.descrCaratteristica = descrCaratteristica;
	}
	
	
}
