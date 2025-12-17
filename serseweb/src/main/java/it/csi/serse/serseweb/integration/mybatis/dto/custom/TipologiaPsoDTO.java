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
public class TipologiaPsoDTO extends ParentDTO implements Serializable {

	
	private String tipologiaPsoId = null;
	private Integer idAttoIndirizzo = null;
	private String descrizione = null;
	private Integer codProgrammazione = null;
	private String codClassificazioneAdi = null;
	private Integer annoApprovazione = null;
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8557426782383021411L;

	/**
	 * @return the tipologiaPsoId
	 */
	public String getTipologiaPsoId() {
		return tipologiaPsoId;
	}

	/**
	 * @param tipologiaPsoId the tipologiaPsoId to set
	 */
	public void setTipologiaPsoId(String tipologiaPsoId) {
		this.tipologiaPsoId = tipologiaPsoId;
	}

	/**
	 * @return the idAttoIndirizzo
	 */
	public Integer getIdAttoIndirizzo() {
		return idAttoIndirizzo;
	}

	/**
	 * @param idAttoIndirizzo the idAttoIndirizzo to set
	 */
	public void setIdAttoIndirizzo(Integer idAttoIndirizzo) {
		this.idAttoIndirizzo = idAttoIndirizzo;
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
	 * @return the codProgrammazione
	 */
	public Integer getCodProgrammazione() {
		return codProgrammazione;
	}

	/**
	 * @param codProgrammazione the codProgrammazione to set
	 */
	public void setCodProgrammazione(Integer codProgrammazione) {
		this.codProgrammazione = codProgrammazione;
	}

	/**
	 * @return the codClassificazioneAdi
	 */
	public String getCodClassificazioneAdi() {
		return codClassificazioneAdi;
	}

	/**
	 * @param codClassificazioneAdi the codClassificazioneAdi to set
	 */
	public void setCodClassificazioneAdi(String codClassificazioneAdi) {
		this.codClassificazioneAdi = codClassificazioneAdi;
	}

	/**
	 * @return the annoApprovazione
	 */
	public Integer getAnnoApprovazione() {
		return annoApprovazione;
	}

	/**
	 * @param annoApprovazione the annoApprovazione to set
	 */
	public void setAnnoApprovazione(Integer annoApprovazione) {
		this.annoApprovazione = annoApprovazione;
	}

	

}
