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

public class ComuneDTO extends ParentDTO {

	private static final long serialVersionUID = 2736287567066214286L;

	private String codiceIstatComune;
	private ProvinciaDTO provincia = new ProvinciaDTO();
	private String descrizioneComune;
	private Integer cap;
	private String codiceFiscaleComune;
	private BacinoDTO bacino = new BacinoDTO();

	/**
	 * @return the codiceIstatComune
	 */
	public String getCodiceIstatComune() {
		return codiceIstatComune;
	}

	/**
	 * @param codiceIstatComune the codiceIstatComune to set
	 */
	public void setCodiceIstatComune(String codiceIstatComune) {
		this.codiceIstatComune = codiceIstatComune;
	}

	/**
	 * @return the provincia
	 */
	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the descrizioneComune
	 */
	public String getDescrizioneComune() {
		return descrizioneComune;
	}

	/**
	 * @param descrizioneComune the descrizioneComune to set
	 */
	public void setDescrizioneComune(String descrizioneComune) {
		this.descrizioneComune = descrizioneComune;
	}

	/**
	 * @return the cap
	 */
	public Integer getCap() {
		return cap;
	}

	/**
	 * @param cap the cap to set
	 */
	public void setCap(Integer cap) {
		this.cap = cap;
	}

	/**
	 * @return the codiceFiscaleComune
	 */
	public String getCodiceFiscaleComune() {
		return codiceFiscaleComune;
	}

	/**
	 * @param codiceFiscaleComune the codiceFiscaleComune to set
	 */
	public void setCodiceFiscaleComune(String codiceFiscaleComune) {
		this.codiceFiscaleComune = codiceFiscaleComune;
	}

	public BacinoDTO getBacino() {
		return bacino;
	}

	public void setBacino(BacinoDTO bacino) {
		this.bacino = bacino;
	}
}
