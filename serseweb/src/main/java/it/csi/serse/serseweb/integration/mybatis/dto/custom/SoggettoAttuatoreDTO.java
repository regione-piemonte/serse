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
import java.util.Date;

/**
 * 
 * @author parci
 *
 */
public class SoggettoAttuatoreDTO extends ParentDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4314592549328474223L;
	
	private Long idSoggettoAttuatore = null;
	private Integer numProgrSportello = null;
	private String gruppoOperatore = null;
	private Integer modelId = null;
	private Integer codOperatore = null;
	private String denominazioneGiuridica= null;
	private String flgCapofila = null;
	private String descrAreaTerritoriale = null;
	private Date dataInserimento = null;
	private String codUserInserimento = null;
	private Date dataAggiornamento = null;
	private String codUserAggiornamento = null;

	public String getDescrAreaTerritoriale() {
		return descrAreaTerritoriale;
	}

	public void setDescrAreaTerritoriale(String descrAreaTerritoriale) {
		this.descrAreaTerritoriale = descrAreaTerritoriale;
	}

	/**
	 *
	 * @return
	 */
	public String getDenominazioneGiuridica() {
		return denominazioneGiuridica;
	}

	/**
	 *
	 * @param denominazioneGiuridica
	 */
	public void setDenominazioneGiuridica(String denominazioneGiuridica) {
		this.denominazioneGiuridica = denominazioneGiuridica;
	}

	/**
	 * @return the idSoggettoAttuatore
	 */
	public Long getIdSoggettoAttuatore() {
		return idSoggettoAttuatore;
	}

	/**
	 * @return the numProgrSportello
	 */
	public Integer getNumProgrSportello() {
		return numProgrSportello;
	}

	/**
	 * @param numProgrSportello the numProgrSportello to set
	 */
	public void setNumProgrSportello(Integer numProgrSportello) {
		this.numProgrSportello = numProgrSportello;
	}

	/**
	 * @param idSoggettoAttuatore the idSoggettoAttuatore to set
	 */
	public void setIdSoggettoAttuatore(Long idSoggettoAttuatore) {
		this.idSoggettoAttuatore = idSoggettoAttuatore;
	}

	/**
	 * @return the gruppoOperatore
	 */
	public String getGruppoOperatore() {
		return gruppoOperatore;
	}
	/**
	 * @param gruppoOperatore the gruppoOperatore to set
	 */
	public void setGruppoOperatore(String gruppoOperatore) {
		this.gruppoOperatore = gruppoOperatore;
	}
	/**
	 * @return the modelId
	 */
	public Integer getModelId() {
		return modelId;
	}
	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	/**
	 * @return the codOperatore
	 */
	public Integer getCodOperatore() {
		return codOperatore;
	}
	/**
	 * @param codOperatore the codOperatore to set
	 */
	public void setCodOperatore(Integer codOperatore) {
		this.codOperatore = codOperatore;
	}
	/**
	 * @return the flgCapofila
	 */
	public String getFlgCapofila() {
		return flgCapofila;
	}
	/**
	 * @param flgCapofila the flgCapofila to set
	 */
	public void setFlgCapofila(String flgCapofila) {
		this.flgCapofila = flgCapofila;
	}
	/**
	 * @return the dataInserimento
	 */
	public Date getDataInserimento() {
		return dataInserimento;
	}
	/**
	 * @param dataInserimento the dataInserimento to set
	 */
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	/**
	 * @return the codUserInserimento
	 */
	public String getCodUserInserimento() {
		return codUserInserimento;
	}
	/**
	 * @param codUserInserimento the codUserInserimento to set
	 */
	public void setCodUserInserimento(String codUserInserimento) {
		this.codUserInserimento = codUserInserimento;
	}
	/**
	 * @return the dataAggiornamento
	 */
	public Date getDataAggiornamento() {
		return dataAggiornamento;
	}
	/**
	 * @param dataAggiornamento the dataAggiornamento to set
	 */
	public void setDataAggiornamento(Date dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}
	/**
	 * @return the codUserAggiornamento
	 */
	public String getCodUserAggiornamento() {
		return codUserAggiornamento;
	}
	/**
	 * @param codUserAggiornamento the codUserAggiornamento to set
	 */
	public void setCodUserAggiornamento(String codUserAggiornamento) {
		this.codUserAggiornamento = codUserAggiornamento;
	}
}
