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
public class TipoModelloDTO extends ParentDTO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4614234956942515242L;
	private String codTipoModello = null;
	private String descrizione = null;
	private String flgProgettazioneIndividuale = null;
	private String flgModelloStandard = null;
	/**
	 * @return the codTipoModello
	 */
	public String getCodTipoModello() {
		return codTipoModello;
	}
	/**
	 * @param codTipoModello the codTipoModello to set
	 */
	public void setCodTipoModello(String codTipoModello) {
		this.codTipoModello = codTipoModello;
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
	 * @return the flgProgettazioneIndividuale
	 */
	public String getFlgProgettazioneIndividuale() {
		return flgProgettazioneIndividuale;
	}
	/**
	 * @param flgProgettazioneIndividuale the flgProgettazioneIndividuale to set
	 */
	public void setFlgProgettazioneIndividuale(String flgProgettazioneIndividuale) {
		this.flgProgettazioneIndividuale = flgProgettazioneIndividuale;
	}
	/**
	 * @return the flgModelloStandard
	 */
	public String getFlgModelloStandard() {
		return flgModelloStandard;
	}
	/**
	 * @param flgModelloStandard the flgModelloStandard to set
	 */
	public void setFlgModelloStandard(String flgModelloStandard) {
		this.flgModelloStandard = flgModelloStandard;
	}
	@Override
	public String toString() {
		return "TipoModelloDTO [codTipoModello=" + codTipoModello + ", descrizione=" + descrizione
				+ ", flgProgettazioneIndividuale=" + flgProgettazioneIndividuale + ", flgModelloStandard="
				+ flgModelloStandard + "]";
	}
	
	
	
}
