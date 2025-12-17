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

public class ProvinciaDTO extends ParentDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2736287567066214286L;
	
	private String codiceProvincia = null;
	private String codiceRegione = null;
	private String descrizioneProvincia = null;
	private String siglaProvincia = null;
	/**
	 * @return the codiceProvincia
	 */
	public String getCodiceProvincia() {
		return codiceProvincia;
	}
	/**
	 * @param codiceProvincia the codiceProvincia to set
	 */
	public void setCodiceProvincia(String codiceProvincia) {
		this.codiceProvincia = codiceProvincia;
	}
	/**
	 * @return the codiceRegione
	 */
	public String getCodiceRegione() {
		return codiceRegione;
	}
	/**
	 * @param codiceRegione the codiceRegione to set
	 */
	public void setCodiceRegione(String codiceRegione) {
		this.codiceRegione = codiceRegione;
	}
	/**
	 * @return the descrizioneProvincia
	 */
	public String getDescrizioneProvincia() {
		return descrizioneProvincia;
	}
	/**
	 * @param descrizioneProvincia the descrizioneProvincia to set
	 */
	public void setDescrizioneProvincia(String descrizioneProvincia) {
		this.descrizioneProvincia = descrizioneProvincia;
	}
	/**
	 * @return the siglaProvincia
	 */
	public String getSiglaProvincia() {
		return siglaProvincia;
	}
	/**
	 * @param siglaProvincia the siglaProvincia to set
	 */
	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}
	
	
}
