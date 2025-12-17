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

public class TipologiaIstitutoScolasticoDTO extends ParentDTO {

	private static final long serialVersionUID = -3505674859663965857L;

	private Long idTipologia;
	private String descrTipologia;

	/**
	 * @return the idTipologia
	 */
	public Long getIdTipologia() {
		return idTipologia;
	}

	/**
	 * @param idTipologia the idTipologia to set
	 */
	public void setIdTipologia(Long idTipologia) {
		this.idTipologia = idTipologia;
	}

	/**
	 * @return the descrTipologia
	 */
	public String getDescrTipologia() {
		return descrTipologia;
	}

	/**
	 * @param descrTipologia the descrTipologia to set
	 */
	public void setDescrTipologia(String descrTipologia) {
		this.descrTipologia = descrTipologia;
	}

}
