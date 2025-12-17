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

import java.util.Date;

public class IstitutoScolasticoDTO extends ParentDTO {

	private static final long serialVersionUID = -3505674859663965857L;

	private Long idIstitutoScolastico;
	private String codRegionaleScuola;
	private String codRegionaleAutonomia;
	private String codMeccanograficoScuola;
	private String codMeccanograficoAutonomia;
	private String denominazione;
	private ComuneDTO comuneScuola = new ComuneDTO();
	private String indirizzo;
	private String recapitoMail;
	private String recapitoTelefonico;
	private String urlSitoWeb;
	private GradoScolasticoDTO gradoScolastico = new GradoScolasticoDTO();
	private TipologiaIstitutoScolasticoDTO tipologiaIstituto = new TipologiaIstitutoScolasticoDTO();
	private PercorsoScolasticoDTO percorsoScolastico = new PercorsoScolasticoDTO();
	private TipoSezioneDTO tipoSezione = new TipoSezioneDTO();
	private TipoUnitaScolasticaDTO tipoUnita = new TipoUnitaScolasticaDTO();
	private AnnoScolasticoDTO annoScolastico = new AnnoScolasticoDTO();
	private Date dataChiusura;
	private Date dataApertura;
	private Date dataModifica;

	//LV 2025-01 attualmente popolato solo dalla query "Enti Convolti Modello"
	private String denominazioneAutonomia;


	/**
	 * @return the idIstitutoScolastico
	 */
	public Long getIdIstitutoScolastico() {
		return idIstitutoScolastico;
	}

	/**
	 * @param idIstitutoScolastico the idIstitutoScolastico to set
	 */
	public void setIdIstitutoScolastico(Long idIstitutoScolastico) {
		this.idIstitutoScolastico = idIstitutoScolastico;
	}

	/**
	 * @return the codRegionaleScuola
	 */
	public String getCodRegionaleScuola() {
		return codRegionaleScuola;
	}

	/**
	 * @param codRegionaleScuola the codRegionaleScuola to set
	 */
	public void setCodRegionaleScuola(String codRegionaleScuola) {
		this.codRegionaleScuola = codRegionaleScuola;
	}

	/**
	 * @return the codRegionaleAutonomia
	 */
	public String getCodRegionaleAutonomia() {
		return codRegionaleAutonomia;
	}

	/**
	 * @param codRegionaleAutonomia the codRegionaleAutonomia to set
	 */
	public void setCodRegionaleAutonomia(String codRegionaleAutonomia) {
		this.codRegionaleAutonomia = codRegionaleAutonomia;
	}

	/**
	 * @return the codMeccanograficoScuola
	 */
	public String getCodMeccanograficoScuola() {
		return codMeccanograficoScuola;
	}

	/**
	 * @param codMeccanograficoScuola the codMeccanograficoScuola to set
	 */
	public void setCodMeccanograficoScuola(String codMeccanograficoScuola) {
		this.codMeccanograficoScuola = codMeccanograficoScuola;
	}

	/**
	 * @return the codMeccanograficoAutonomia
	 */
	public String getCodMeccanograficoAutonomia() {
		return codMeccanograficoAutonomia;
	}

	/**
	 * @param codMeccanograficoAutonomia the codMeccanograficoAutonomia to set
	 */
	public void setCodMeccanograficoAutonomia(String codMeccanograficoAutonomia) {
		this.codMeccanograficoAutonomia = codMeccanograficoAutonomia;
	}

	/**
	 * @return the denominazione
	 */
	public String getDenominazione() {
		return denominazione;
	}

	/**
	 * @param denominazione the denominazione to set
	 */
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	/**
	 * @return the comuneScuola
	 */
	public ComuneDTO getComuneScuola() {
		return comuneScuola;
	}

	/**
	 * @param comuneScuola the comuneScuola to set
	 */
	public void setComuneScuola(ComuneDTO comuneScuola) {
		this.comuneScuola = comuneScuola;
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
	 * @return the urlSitoWeb
	 */
	public String getUrlSitoWeb() {
		return urlSitoWeb;
	}

	/**
	 * @param urlSitoWeb the urlSitoWeb to set
	 */
	public void setUrlSitoWeb(String urlSitoWeb) {
		this.urlSitoWeb = urlSitoWeb;
	}

	/**
	 * @return the tipologiaIstituto
	 */
	public TipologiaIstitutoScolasticoDTO getTipologiaIstituto() {
		return tipologiaIstituto;
	}

	/**
	 * @param tipologiaIstituto the tipologiaIstituto to set
	 */
	public void setTipologiaIstituto(TipologiaIstitutoScolasticoDTO tipologiaIstituto) {
		this.tipologiaIstituto = tipologiaIstituto;
	}

	/**
	 * @return the percorsoScolastico
	 */
	public PercorsoScolasticoDTO getPercorsoScolastico() {
		return percorsoScolastico;
	}

	/**
	 * @param percorsoScolastico the percorsoScolastico to set
	 */
	public void setPercorsoScolastico(PercorsoScolasticoDTO percorsoScolastico) {
		this.percorsoScolastico = percorsoScolastico;
	}

	/**
	 * @return the tipoSezione
	 */
	public TipoSezioneDTO getTipoSezione() {
		return tipoSezione;
	}

	/**
	 * @param tipoSezione the tipoSezione to set
	 */
	public void setTipoSezione(TipoSezioneDTO tipoSezione) {
		this.tipoSezione = tipoSezione;
	}

	/**
	 * @return the tipoUnita
	 */
	public TipoUnitaScolasticaDTO getTipoUnita() {
		return tipoUnita;
	}

	/**
	 * @param tipoUnita the tipoUnita to set
	 */
	public void setTipoUnita(TipoUnitaScolasticaDTO tipoUnita) {
		this.tipoUnita = tipoUnita;
	}

	/**
	 * @return the annoScoalastico
	 */
	public AnnoScolasticoDTO getAnnoScolastico() {
		return annoScolastico;
	}

	/**
	 * @param annoScolastico the annoScoalastico to set
	 */
	public void setAnnoScolastico(AnnoScolasticoDTO annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	/**
	 * @return the dataChiusura
	 */
	public Date getDataChiusura() {
		return dataChiusura;
	}

	/**
	 * @param dataChiusura the dataChiusura to set
	 */
	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	/**
	 * @return the dataApertura
	 */
	public Date getDataApertura() {
		return dataApertura;
	}

	/**
	 * @param dataApertura the dataApertura to set
	 */
	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	/**
	 * @return the dataModifica
	 */
	public Date getDataModifica() {
		return dataModifica;
	}

	/**
	 * @param dataModifica the dataModifica to set
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 *
	 * @return
	 */
	public GradoScolasticoDTO getGradoScolastico() {
		return gradoScolastico;
	}

	/**
	 *
	 * @param gradoScolastico
	 */
	public void setGradoScolastico(GradoScolasticoDTO gradoScolastico) {
		this.gradoScolastico = gradoScolastico;
	}

	public String getDenominazioneAutonomia() {
		return denominazioneAutonomia;
	}

	public void setDenominazioneAutonomia(String denominazioneAutonomia) {
		this.denominazioneAutonomia = denominazioneAutonomia;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "IstitutoScolasticoDTO{" +
				"idIstitutoScolastico=" + idIstitutoScolastico +
				", codRegionaleScuola='" + codRegionaleScuola + '\'' +
				", codRegionaleAutonomia='" + codRegionaleAutonomia + '\'' +
				", codMeccanograficoScuola='" + codMeccanograficoScuola + '\'' +
				", codMeccanograficoAutonomia='" + codMeccanograficoAutonomia + '\'' +
				", denominazione='" + denominazione + '\'' +
				", comuneScuola=" + comuneScuola +
				", indirizzo='" + indirizzo + '\'' +
				", recapitoMail='" + recapitoMail + '\'' +
				", recapitoTelefonico='" + recapitoTelefonico + '\'' +
				", urlSitoWeb='" + urlSitoWeb + '\'' +
				", tipologiaIstituto=" + tipologiaIstituto +
				", percorsoScolastico=" + percorsoScolastico +
				", tipoSezione=" + tipoSezione +
				", tipoUnita=" + tipoUnita +
				", annoScolastico=" + annoScolastico +
				", dataChiusura=" + dataChiusura +
				", dataApertura=" + dataApertura +
				", dataModifica=" + dataModifica +
				'}';
	}
}
