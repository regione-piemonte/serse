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

import it.csi.serse.serseweb.vo.Comune;

public class CentroPerImpiegoDTO extends ParentDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	
	private static final long serialVersionUID = 2736287567066214286L;
	
	private Long idCpi = null;
	  private String codiceCpi = null;
	  private String cpi = null;
	  private String gruppoOperatore = null;
	  private Integer codOperatore = null;
	  private String sede = null;
	  private String indirizzo = null;
	  private String cap = null;
	  private ComuneDTO comune = null;
	  private String telefono = null;
	  private String telefono2 = null;
	  private String telefono3 = null;
	  private String numeroVerde = null;
	  private String email = null;
	  private String indirizzoWeb = null;
	/**
	 * @return the idCpi
	 */
	public Long getIdCpi() {
		return idCpi;
	}
	/**
	 * @param idCpi the idCpi to set
	 */
	public void setIdCpi(Long idCpi) {
		this.idCpi = idCpi;
	}
	/**
	 * @return the codiceCpi
	 */
	public String getCodiceCpi() {
		return codiceCpi;
	}
	/**
	 * @param codiceCpi the codiceCpi to set
	 */
	public void setCodiceCpi(String codiceCpi) {
		this.codiceCpi = codiceCpi;
	}
	/**
	 * @return the cpi
	 */
	public String getCpi() {
		return cpi;
	}
	/**
	 * @param cpi the cpi to set
	 */
	public void setCpi(String cpi) {
		this.cpi = cpi;
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
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}
	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}
	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}
	/**
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}
	/**
	 * @return the comune
	 */
	public ComuneDTO getComune() {
		return comune;
	}
	/**
	 * @param comune the comune to set
	 */
	public void setComune(ComuneDTO comune) {
		this.comune = comune;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the telefono2
	 */
	public String getTelefono2() {
		return telefono2;
	}
	/**
	 * @param telefono2 the telefono2 to set
	 */
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	/**
	 * @return the telefono3
	 */
	public String getTelefono3() {
		return telefono3;
	}
	/**
	 * @param telefono3 the telefono3 to set
	 */
	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}
	/**
	 * @return the numeroVerde
	 */
	public String getNumeroVerde() {
		return numeroVerde;
	}
	/**
	 * @param numeroVerde the numeroVerde to set
	 */
	public void setNumeroVerde(String numeroVerde) {
		this.numeroVerde = numeroVerde;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the indirizzoWeb
	 */
	public String getIndirizzoWeb() {
		return indirizzoWeb;
	}
	/**
	 * @param indirizzoWeb the indirizzoWeb to set
	 */
	public void setIndirizzoWeb(String indirizzoWeb) {
		this.indirizzoWeb = indirizzoWeb;
	}
	  
	  
}
