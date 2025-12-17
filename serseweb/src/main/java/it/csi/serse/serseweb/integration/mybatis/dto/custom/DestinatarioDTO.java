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
 * @author parci
 *
 */
public class DestinatarioDTO extends ParentDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -524634977133150774L;
	private Integer idDestinatario = null;
	private String cfDestinatario = null;
	private String nomeDestinatario = null;
	private String cognomeDestinatario = null;
	private Date dataNascita = null;
	private String codIstatComuneNascita = null;
	private String codStatoEsteroNasccita = null;
	private String codIstatComuneResidenza = null;
	private String codStatoEsteroResidenza = null;
	private String descrCittaEsteraResidenza = null;
	private String codIstatComuneDomicilio = null;
	private String indResidenza = null;
	private String indDomicilio = null;
	private String recapitoMail = null;
	private String recapitoTelefonico = null;
	private String codCittadinanza = null;
	private String codUserInserimento = null;
	private Date dataInserimento = null;
	private String codUserAggiornamento = null;
	private Date dataAggiornamento = null;

	/**
	 * @return the idDestinatario
	 */
	public Integer getIdDestinatario() {
		return idDestinatario;
	}

	/**
	 * @param idDestinatario the idDestinatario to set
	 */
	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	/**
	 * @return the cfDestinatario
	 */
	public String getCfDestinatario() {
		return cfDestinatario;
	}

	/**
	 * @param cfDestinatario the cfDestinatario to set
	 */
	public void setCfDestinatario(String cfDestinatario) {
		this.cfDestinatario = cfDestinatario;
	}

	/**
	 * @return the nomeDestinatario
	 */
	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	/**
	 * @param nomeDestinatario the nomeDestinatario to set
	 */
	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	/**
	 * @return the cognomeDestinatario
	 */
	public String getCognomeDestinatario() {
		return cognomeDestinatario;
	}

	/**
	 * @param cognomeDestinatario the cognomeDestinatario to set
	 */
	public void setCognomeDestinatario(String cognomeDestinatario) {
		this.cognomeDestinatario = cognomeDestinatario;
	}

	/**
	 * @return the dataNascita
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * @param dataNascita the dataNascita to set
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * @return the codIstatComuneNascita
	 */
	public String getCodIstatComuneNascita() {
		return codIstatComuneNascita;
	}

	/**
	 * @param codIstatComuneNascita the codIstatComuneNascita to set
	 */
	public void setCodIstatComuneNascita(String codIstatComuneNascita) {
		this.codIstatComuneNascita = codIstatComuneNascita;
	}

	/**
	 * @return the codStatoEsteroNasccita
	 */
	public String getCodStatoEsteroNasccita() {
		return codStatoEsteroNasccita;
	}

	/**
	 * @param codStatoEsteroNasccita the codStatoEsteroNasccita to set
	 */
	public void setCodStatoEsteroNasccita(String codStatoEsteroNasccita) {
		this.codStatoEsteroNasccita = codStatoEsteroNasccita;
	}

	/**
	 * @return the codIstatComuneResidenza
	 */
	public String getCodIstatComuneResidenza() {
		return codIstatComuneResidenza;
	}

	/**
	 * @param codIstatComuneResidenza the codIstatComuneResidenza to set
	 */
	public void setCodIstatComuneResidenza(String codIstatComuneResidenza) {
		this.codIstatComuneResidenza = codIstatComuneResidenza;
	}

	/**
	 * @return the codStatoEsteroResidenza
	 */
	public String getCodStatoEsteroResidenza() {
		return codStatoEsteroResidenza;
	}

	/**
	 * @param codStatoEsteroResidenza the codStatoEsteroResidenza to set
	 */
	public void setCodStatoEsteroResidenza(String codStatoEsteroResidenza) {
		this.codStatoEsteroResidenza = codStatoEsteroResidenza;
	}

	/**
	 * @return the descrCittaEsteraResidenza
	 */
	public String getDescrCittaEsteraResidenza() {
		return descrCittaEsteraResidenza;
	}

	/**
	 * @param descrCittaEsteraResidenza the descrCittaEsteraResidenza to set
	 */
	public void setDescrCittaEsteraResidenza(String descrCittaEsteraResidenza) {
		this.descrCittaEsteraResidenza = descrCittaEsteraResidenza;
	}

	/**
	 * @return the codIstatComuneDomicilio
	 */
	public String getCodIstatComuneDomicilio() {
		return codIstatComuneDomicilio;
	}

	/**
	 * @param codIstatComuneDomicilio the codIstatComuneDomicilio to set
	 */
	public void setCodIstatComuneDomicilio(String codIstatComuneDomicilio) {
		this.codIstatComuneDomicilio = codIstatComuneDomicilio;
	}

	/**
	 * @return the indResidenza
	 */
	public String getIndResidenza() {
		return indResidenza;
	}

	/**
	 * @param indResidenza the indResidenza to set
	 */
	public void setIndResidenza(String indResidenza) {
		this.indResidenza = indResidenza;
	}

	/**
	 * @return the indDomicilio
	 */
	public String getIndDomicilio() {
		return indDomicilio;
	}

	/**
	 * @param indDomicilio the indDomicilio to set
	 */
	public void setIndDomicilio(String indDomicilio) {
		this.indDomicilio = indDomicilio;
	}

	/**
	 * @return the recapitoMail
	 */
	public String getRecapitoMail() {
		return recapitoMail;
	}

	/**
	 * @param recapitoMail the recapitoMail to set
	 */
	public void setRecapitoMail(String recapitoMail) {
		this.recapitoMail = recapitoMail;
	}

	/**
	 * @return the recapitoTelefonico
	 */
	public String getRecapitoTelefonico() {
		return recapitoTelefonico;
	}

	/**
	 * @param recapitoTelefonico the recapitoTelefonico to set
	 */
	public void setRecapitoTelefonico(String recapitoTelefonico) {
		this.recapitoTelefonico = recapitoTelefonico;
	}

	/**
	 * @return the codCittadinanza
	 */
	public String getCodCittadinanza() {
		return codCittadinanza;
	}

	/**
	 * @param codCittadinanza the codCittadinanza to set
	 */
	public void setCodCittadinanza(String codCittadinanza) {
		this.codCittadinanza = codCittadinanza;
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

}
