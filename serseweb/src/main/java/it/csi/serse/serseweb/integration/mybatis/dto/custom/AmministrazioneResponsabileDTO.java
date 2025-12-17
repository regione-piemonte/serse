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

public class AmministrazioneResponsabileDTO extends ParentDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2440290796690758248L;

	private Integer codAr = null;
	private String descrizione = null;
	private String siglaEnte = null;
	/**
	 * @return the codAr
	 */
	public Integer getCodAr() {
		return codAr;
	}
	/**
	 * @param codAr the codAr to set
	 */
	public void setCodAr(Integer codAr) {
		this.codAr = codAr;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * @return the siglaEnte
	 */
	public String getSiglaEnte() {
		return siglaEnte;
	}
	/**
	 * @param siglaEnte the siglaEnte to set
	 */
	public void setSiglaEnte(String siglaEnte) {
		this.siglaEnte = siglaEnte;
	}

	@Override
	public String toString() {
		return "AmministrazioneResponsabileDTO [codAr=" + codAr + ", descrizione=" + descrizione + ", siglaEnte="
				+ siglaEnte + "]";
	}
	
	

}
