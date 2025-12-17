package it.csi.serse.serseapi.integration.mybatis.dto.custom;

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

import java.util.Date;

public class DestinatarioDTO extends ParentDTO {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -524634973333150774L;

	private Long idDestinatario;
	private String cfDestinatario;
	private String nomeDestinatario;
	private String cognomeDestinatario;
	private Date dataNascita;

	private String codIstatComuneNascita;
	private String descomNascita;
	private String sigprovNascita;
	private Integer codStatoEsteroNascita;
	private String descrizioneStatoEsteroNascita;
	private String descrCittaEsteraNascita;

	private String codIstatComuneResidenza;
	private String descomResidenza;
	private String sigprovResidenza;
	private Integer codStatoEsteroResidenza;
	private String descrizioneStatoEsteroResidenza;
	private String descrCittaEsteraResidenza;
	private String indirizzoResidenza;
	private Integer capResidenza;

	private String codIstatComuneDomicilio;
	private String descomDomicilio;
	private String sigprovDomicilio;
	private String indirizzoDomicilio;
	private Integer capDomicilio;

	private String recapitoEmail;
	private String recapitoTelefonico;
	private String codCittadinanza;
	private String descrCittadinanza;

	public Long getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public String getCfDestinatario() {
		return cfDestinatario;
	}

	public void setCfDestinatario(String cfDestinatario) {
		this.cfDestinatario = cfDestinatario;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getCognomeDestinatario() {
		return cognomeDestinatario;
	}

	public void setCognomeDestinatario(String cognomeDestinatario) {
		this.cognomeDestinatario = cognomeDestinatario;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodIstatComuneNascita() {
		return codIstatComuneNascita;
	}

	public void setCodIstatComuneNascita(String codIstatComuneNascita) {
		this.codIstatComuneNascita = codIstatComuneNascita;
	}

	public String getDescomNascita() {
		return descomNascita;
	}

	public void setDescomNascita(String descomNascita) {
		this.descomNascita = descomNascita;
	}

	public String getSigprovNascita() {
		return sigprovNascita;
	}

	public void setSigprovNascita(String sigprovNascita) {
		this.sigprovNascita = sigprovNascita;
	}

	public Integer getCodStatoEsteroNascita() {
		return codStatoEsteroNascita;
	}

	public void setCodStatoEsteroNascita(Integer codStatoEsteroNascita) {
		this.codStatoEsteroNascita = codStatoEsteroNascita;
	}

	public String getDescrizioneStatoEsteroNascita() {
		return descrizioneStatoEsteroNascita;
	}

	public void setDescrizioneStatoEsteroNascita(String descrizioneStatoEsteroNascita) {
		this.descrizioneStatoEsteroNascita = descrizioneStatoEsteroNascita;
	}

	public String getDescrCittaEsteraNascita() {
		return descrCittaEsteraNascita;
	}

	public void setDescrCittaEsteraNascita(String descrCittaEsteraNascita) {
		this.descrCittaEsteraNascita = descrCittaEsteraNascita;
	}

	public String getCodIstatComuneResidenza() {
		return codIstatComuneResidenza;
	}

	public void setCodIstatComuneResidenza(String codIstatComuneResidenza) {
		this.codIstatComuneResidenza = codIstatComuneResidenza;
	}

	public String getDescomResidenza() {
		return descomResidenza;
	}

	public void setDescomResidenza(String descomResidenza) {
		this.descomResidenza = descomResidenza;
	}

	public String getSigprovResidenza() {
		return sigprovResidenza;
	}

	public void setSigprovResidenza(String sigprovResidenza) {
		this.sigprovResidenza = sigprovResidenza;
	}

	public Integer getCodStatoEsteroResidenza() {
		return codStatoEsteroResidenza;
	}

	public void setCodStatoEsteroResidenza(Integer codStatoEsteroResidenza) {
		this.codStatoEsteroResidenza = codStatoEsteroResidenza;
	}

	public String getDescrizioneStatoEsteroResidenza() {
		return descrizioneStatoEsteroResidenza;
	}

	public void setDescrizioneStatoEsteroResidenza(String descrizioneStatoEsteroResidenza) {
		this.descrizioneStatoEsteroResidenza = descrizioneStatoEsteroResidenza;
	}

	public String getDescrCittaEsteraResidenza() {
		return descrCittaEsteraResidenza;
	}

	public void setDescrCittaEsteraResidenza(String descrCittaEsteraResidenza) {
		this.descrCittaEsteraResidenza = descrCittaEsteraResidenza;
	}

	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}

	public Integer getCapResidenza() {
		return capResidenza;
	}

	public void setCapResidenza(Integer capResidenza) {
		this.capResidenza = capResidenza;
	}

	public String getCodIstatComuneDomicilio() {
		return codIstatComuneDomicilio;
	}

	public void setCodIstatComuneDomicilio(String codIstatComuneDomicilio) {
		this.codIstatComuneDomicilio = codIstatComuneDomicilio;
	}

	public String getDescomDomicilio() {
		return descomDomicilio;
	}

	public void setDescomDomicilio(String descomDomicilio) {
		this.descomDomicilio = descomDomicilio;
	}

	public String getSigprovDomicilio() {
		return sigprovDomicilio;
	}

	public void setSigprovDomicilio(String sigprovDomicilio) {
		this.sigprovDomicilio = sigprovDomicilio;
	}

	public String getIndirizzoDomicilio() {
		return indirizzoDomicilio;
	}

	public void setIndirizzoDomicilio(String indirizzoDomicilio) {
		this.indirizzoDomicilio = indirizzoDomicilio;
	}

	public Integer getCapDomicilio() {
		return capDomicilio;
	}

	public void setCapDomicilio(Integer capDomicilio) {
		this.capDomicilio = capDomicilio;
	}

	public String getRecapitoEmail() {
		return recapitoEmail;
	}

	public void setRecapitoEmail(String recapitoEmail) {
		this.recapitoEmail = recapitoEmail;
	}

	public String getRecapitoTelefonico() {
		return recapitoTelefonico;
	}

	public void setRecapitoTelefonico(String recapitoTelefonico) {
		this.recapitoTelefonico = recapitoTelefonico;
	}

	public String getCodCittadinanza() {
		return codCittadinanza;
	}

	public void setCodCittadinanza(String codCittadinanza) {
		this.codCittadinanza = codCittadinanza;
	}

	public String getDescrCittadinanza() {
		return descrCittadinanza;
	}

	public void setDescrCittadinanza(String descrCittadinanza) {
		this.descrCittadinanza = descrCittadinanza;
	}

}
