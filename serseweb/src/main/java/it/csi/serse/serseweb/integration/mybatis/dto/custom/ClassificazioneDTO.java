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

public class ClassificazioneDTO extends ParentDTO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3505674859663965857L;
    
    private Long idClassificazione = null;
    private Long idClassificazzioneGam = null;
    private String livello1 = null;
    private String livello2 = null;
    private String livello3 = null;
    private String livello4 = null;
    private Long idTipoSuddivDotfin = null;
    private String descrFinalita = null;
	/**
	 * @return the idClassificazione
	 */
	public Long getIdClassificazione() {
		return idClassificazione;
	}
	/**
	 * @param idClassificazione the idClassificazione to set
	 */
	public void setIdClassificazione(Long idClassificazione) {
		this.idClassificazione = idClassificazione;
	}
	/**
	 * @return the idClassificazzioneGam
	 */
	public Long getIdClassificazzioneGam() {
		return idClassificazzioneGam;
	}
	/**
	 * @param idClassificazzioneGam the idClassificazzioneGam to set
	 */
	public void setIdClassificazzioneGam(Long idClassificazzioneGam) {
		this.idClassificazzioneGam = idClassificazzioneGam;
	}
	/**
	 * @return the livello1
	 */
	public String getLivello1() {
		return livello1;
	}
	/**
	 * @param livello1 the livello1 to set
	 */
	public void setLivello1(String livello1) {
		this.livello1 = livello1;
	}
	/**
	 * @return the livello2
	 */
	public String getLivello2() {
		return livello2;
	}
	/**
	 * @param livello2 the livello2 to set
	 */
	public void setLivello2(String livello2) {
		this.livello2 = livello2;
	}
	/**
	 * @return the livello3
	 */
	public String getLivello3() {
		return livello3;
	}
	/**
	 * @param livello3 the livello3 to set
	 */
	public void setLivello3(String livello3) {
		this.livello3 = livello3;
	}
	/**
	 * @return the livello4
	 */
	public String getLivello4() {
		return livello4;
	}
	/**
	 * @param livello4 the livello4 to set
	 */
	public void setLivello4(String livello4) {
		this.livello4 = livello4;
	}
	/**
	 * @return the idTipoSuddivDotfin
	 */
	public Long getIdTipoSuddivDotfin() {
		return idTipoSuddivDotfin;
	}
	/**
	 * @param idTipoSuddivDotfin the idTipoSuddivDotfin to set
	 */
	public void setIdTipoSuddivDotfin(Long idTipoSuddivDotfin) {
		this.idTipoSuddivDotfin = idTipoSuddivDotfin;
	}
	/**
	 * @return the descrFinalita
	 */
	public String getDescrFinalita() {
		return descrFinalita;
	}
	/**
	 * @param descrFinalita the descrFinalita to set
	 */
	public void setDescrFinalita(String descrFinalita) {
		this.descrFinalita = descrFinalita;
	}
    
    
}
