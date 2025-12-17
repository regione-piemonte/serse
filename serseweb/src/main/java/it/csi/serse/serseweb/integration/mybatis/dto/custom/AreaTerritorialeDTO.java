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

public class AreaTerritorialeDTO extends ParentDTO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3505674859663965857L;
    private String codAreaTerritoriale = null;
    private String desrAreaTerritoriale = null;
	/**
	 * @return the codAreaTerritoriale
	 */
	public String getCodAreaTerritoriale() {
		return codAreaTerritoriale;
	}
	/**
	 * @param codAreaTerritoriale the codAreaTerritoriale to set
	 */
	public void setCodAreaTerritoriale(String codAreaTerritoriale) {
		this.codAreaTerritoriale = codAreaTerritoriale;
	}
	/**
	 * @return the desrAreaTerritoriale
	 */
	public String getDesrAreaTerritoriale() {
		return desrAreaTerritoriale;
	}
	/**
	 * @param desrAreaTerritoriale the desrAreaTerritoriale to set
	 */
	public void setDesrAreaTerritoriale(String desrAreaTerritoriale) {
		this.desrAreaTerritoriale = desrAreaTerritoriale;
	}
    
    
}
