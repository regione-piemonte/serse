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

public class VoceSpesaDTO extends ParentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2817212166758651673L;
	
	private String codVoceSpesa = null;
	private String descrVoceSpesa = null;
	private String codNaturaSpesa = null;
	/**
	 * @return the codVoceSpesa
	 */
	public String getCodVoceSpesa() {
		return codVoceSpesa;
	}
	/**
	 * @param codVoceSpesa the codVoceSpesa to set
	 */
	public void setCodVoceSpesa(String codVoceSpesa) {
		this.codVoceSpesa = codVoceSpesa;
	}
	/**
	 * @return the descrVoceSpesa
	 */
	public String getDescrVoceSpesa() {
		return descrVoceSpesa;
	}
	/**
	 * @param descrVoceSpesa the descrVoceSpesa to set
	 */
	public void setDescrVoceSpesa(String descrVoceSpesa) {
		this.descrVoceSpesa = descrVoceSpesa;
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
	
	@Override
	public String toString() {
		return "VoceSpesaDTO [codVoceSpesa=" + codVoceSpesa + ", descrVoceSpesa=" + descrVoceSpesa + ", codNaturaSpesa="
				+ codNaturaSpesa + "]";
	}
	
	
	
	
	
}
