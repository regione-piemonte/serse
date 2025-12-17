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

/**
 * 
 * @author parci
 *
 */
public class ReferenteDTO extends ParentDTO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2326238402642423847L;
	private String referenteNome = null;
	private String referenteCognome = null;
	private String referenteEmail = null;
	private String referenteTelefono = null;
	
	/**
	 * @return the referenteNome
	 */
	public String getReferenteNome() {
		return referenteNome;
	}
	/**
	 * @param referenteNome the referenteNome to set
	 */
	public void setReferenteNome(String referenteNome) {
		this.referenteNome = referenteNome;
	}
	/**
	 * @return the referenteCognome
	 */
	public String getReferenteCognome() {
		return referenteCognome;
	}
	/**
	 * @param referenteCognome the referenteCognome to set
	 */
	public void setReferenteCognome(String referenteCognome) {
		this.referenteCognome = referenteCognome;
	}
	/**
	 * @return the referenteEmail
	 */
	public String getReferenteEmail() {
		return referenteEmail;
	}
	/**
	 * @param referenteEmail the referenteEmail to set
	 */
	public void setReferenteEmail(String referenteEmail) {
		this.referenteEmail = referenteEmail;
	}
	/**
	 * @return the referenteTelefono
	 */
	public String getReferenteTelefono() {
		return referenteTelefono;
	}
	/**
	 * @param referenteTelefono the referenteTelefono to set
	 */
	public void setReferenteTelefono(String referenteTelefono) {
		this.referenteTelefono = referenteTelefono;
	}
	
	

}
