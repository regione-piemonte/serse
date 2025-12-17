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
public class PsoDTO extends ParentDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3752891954794960696L;
	private Long idPso = null;
	private Long idAttoIndirizzo = null;
	private String descrizione = null;
	private String siglaEnte = null;
	private String codCicloFinanziario = null;
	private TipologiaPsoDTO tipologiaPso = null;
	private AmministrazioneResponsabileDTO amministrazioneResponsabile = null;
	
	/**
	 * @return the idPso
	 */
	public Long getIdPso() {
		return idPso;
	}
	/**
	 * @param idPso the idPso to set
	 */
	public void setIdPso(Long idPso) {
		this.idPso = idPso;
	}
	/**
	 * @return the idAttoIndirizzo
	 */
	public Long getIdAttoIndirizzo() {
		return idAttoIndirizzo;
	}
	/**
	 * @param idAttoIndirizzo the idAttoIndirizzo to set
	 */
		
	public void setIdAttoIndirizzo(Long idAttoIndirizzo) {
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
	/**
	 * @return the codCicloFinanziario
	 */
	public String getCodCicloFinanziario() {
		return codCicloFinanziario;
	}
	/**
	 * @param codCicloFinanziario the codCicloFinanziario to set
	 */
	public void setCodCicloFinanziario(String codCicloFinanziario) {
		this.codCicloFinanziario = codCicloFinanziario;
	}
	/**
	 * @return the tipologiaPso
	 */
	public TipologiaPsoDTO getTipologiaPso() {
		return tipologiaPso;
	}
	/**
	 * @param tipologiaPso the tipologiaPso to set
	 */
	public void setTipologiaPso(TipologiaPsoDTO tipologiaPso) {
		this.tipologiaPso = tipologiaPso;
	}
	/**
	 * @return the amministrazioneResponsabile
	 */
	public AmministrazioneResponsabileDTO getAmministrazioneResponsabile() {
		return amministrazioneResponsabile;
	}
	/**
	 * @param amministrazioneResponsabile the amministrazioneResponsabile to set
	 */
	public void setAmministrazioneResponsabile(AmministrazioneResponsabileDTO amministrazioneResponsabile) {
		this.amministrazioneResponsabile = amministrazioneResponsabile;
	}


}
