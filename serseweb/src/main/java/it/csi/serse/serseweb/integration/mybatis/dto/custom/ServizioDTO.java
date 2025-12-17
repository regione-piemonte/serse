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
import java.math.BigDecimal;
import java.util.Date;

public class ServizioDTO extends ParentDTO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1923519635348170648L;
    private Long idServizio = null;
    private String titoloServizio = null;
    private StatoServizioDTO statoServizio = null;
    private SoggettoAttuatoreDTO soggettoAttuatore = null;
    private AreaTerritorialeDTO areaTerritoriale = null;
    private Long idIntervento = null;
    private Long idPso = null;
    private ServizioRegionaleDTO servizioRegionale = null;
    private ClassificazioneDTO classificazione = null;
	private String referenteNome = null;
	private String referenteCognome = null;
	private String referenteEmail = null;
	private String referenteTelefono = null;
    private BigDecimal durataOre = null;
	private Date dataChiusura = null;
    private Integer numMaxDestinatari = null;
    private String codUserInserim = null;
    private Date dInserim = null;
    private String codUserAggiorn = null;
    private Date dAggiorn = null;
	private String valoreDatoPeculiare1 = null;
	private String valoreDatoPeculiare2 = null;
	private String valoreCampoAggiuntivo1 = null;
	private String codTitoloStudioIgrue = null;
	private String codCondizioneOccupazionaleIgrue = null;
	private String flgDisabilita = null;
	private String flgSvantaggioAbitativo = null;
	private Integer progressivoSede = null;
	private String gruppoBeneficiario = null;
	private Long codiceBeneficiario = null;
	private DestinatarioDTO destinatarioServizioIndividuale = null;

	public String getValoreDatoPeculiare1() {
		return valoreDatoPeculiare1;
	}

	public void setValoreDatoPeculiare1(String valoreDatoPeculiare1) {
		this.valoreDatoPeculiare1 = valoreDatoPeculiare1;
	}

	public String getValoreDatoPeculiare2() {
		return valoreDatoPeculiare2;
	}

	public void setValoreDatoPeculiare2(String valoreDatoPeculiare2) {
		this.valoreDatoPeculiare2 = valoreDatoPeculiare2;
	}

	public String getCodTitoloStudioIgrue() {
		return codTitoloStudioIgrue;
	}

	public void setCodTitoloStudioIgrue(String codTitoloStudioIgrue) {
		this.codTitoloStudioIgrue = codTitoloStudioIgrue;
	}

	public String getCodCondizioneOccupazionaleIgrue() {
		return codCondizioneOccupazionaleIgrue;
	}

	public void setCodCondizioneOccupazionaleIgrue(String codCondizioneOccupazionaleIgrue) {
		this.codCondizioneOccupazionaleIgrue = codCondizioneOccupazionaleIgrue;
	}

	public String getFlgDisabilita() {
		return flgDisabilita;
	}

	public void setFlgDisabilita(String flgDisabilita) {
		this.flgDisabilita = flgDisabilita;
	}

	public String getFlgSvantaggioAbitativo() {
		return flgSvantaggioAbitativo;
	}

	public void setFlgSvantaggioAbitativo(String flgSvantaggioAbitativo) {
		this.flgSvantaggioAbitativo = flgSvantaggioAbitativo;
	}

	/**
	 * @return the idServizio
	 */
	public Long getIdServizio() {
		return idServizio;
	}
	/**
	 * @param idServizio the idServizio to set
	 */
	public void setIdServizio(Long idServizio) {
		this.idServizio = idServizio;
	}
	/**
	 * @return the titoloServizio
	 */
	public String getTitoloServizio() {
		return titoloServizio;
	}
	/**
	 * @param titoloServizio the titoloServizio to set
	 */
	public void setTitoloServizio(String titoloServizio) {
		this.titoloServizio = titoloServizio;
	}
	/**
	 * @return the statoServizio
	 */
	public StatoServizioDTO getStatoServizio() {
		return statoServizio;
	}
	/**
	 * @param statoServizio the statoServizio to set
	 */
	public void setStatoServizio(StatoServizioDTO statoServizio) {
		this.statoServizio = statoServizio;
	}
	/**
	 * @return the soggettoAttuatore
	 */
	public SoggettoAttuatoreDTO getSoggettoAttuatore() {
		return soggettoAttuatore;
	}
	/**
	 * @param soggettoAttuatore the soggettoAttuatore to set
	 */
	public void setSoggettoAttuatore(SoggettoAttuatoreDTO soggettoAttuatore) {
		this.soggettoAttuatore = soggettoAttuatore;
	}
	/**
	 * @return the areaTerritoriale
	 */
	public AreaTerritorialeDTO getAreaTerritoriale() {
		return areaTerritoriale;
	}
	/**
	 * @param areaTerritoriale the areaTerritoriale to set
	 */
	public void setAreaTerritoriale(AreaTerritorialeDTO areaTerritoriale) {
		this.areaTerritoriale = areaTerritoriale;
	}
	/**
	 * @return the idIntervento
	 */
	public Long getIdIntervento() {
		return idIntervento;
	}
	/**
	 * @param idIntervento the idIntervento to set
	 */
	public void setIdIntervento(Long idIntervento) {
		this.idIntervento = idIntervento;
	}
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
	 * @return the servizioRegionale
	 */
	public ServizioRegionaleDTO getServizioRegionale() {
		return servizioRegionale;
	}
	/**
	 * @param servizioRegionale the servizioRegionale to set
	 */
	public void setServizioRegionale(ServizioRegionaleDTO servizioRegionale) {
		this.servizioRegionale = servizioRegionale;
	}
	/**
	 * @return the idClassificazione
	 */
	public ClassificazioneDTO getClassificazione() {
		return classificazione;
	}
	/**
	 * @param classificazione the idClassificazione to set
	 */
	public void setClassificazione(ClassificazioneDTO classificazione) {
		this.classificazione = classificazione;
	}

	public String getReferenteNome() {
		return referenteNome;
	}

	public void setReferenteNome(String referenteNome) {
		this.referenteNome = referenteNome;
	}

	public String getValoreCampoAggiuntivo1() {
		return valoreCampoAggiuntivo1;
	}

	public void setValoreCampoAggiuntivo1(String valoreCampoAggiuntivo1) {
		this.valoreCampoAggiuntivo1 = valoreCampoAggiuntivo1;
	}

	public String getReferenteCognome() {
		return referenteCognome;
	}

	public void setReferenteCognome(String referenteCognome) {
		this.referenteCognome = referenteCognome;
	}

	public String getReferenteEmail() {
		return referenteEmail;
	}

	public void setReferenteEmail(String referenteEmail) {
		this.referenteEmail = referenteEmail;
	}

	public String getReferenteTelefono() {
		return referenteTelefono;
	}

	public void setReferenteTelefono(String referenteTelefono) {
		this.referenteTelefono = referenteTelefono;
	}

	/**
	 * @return the durataOre
	 */
	public BigDecimal getDurataOre() {
		return durataOre;
	}
	/**
	 * @param durataOre the durataOre to set
	 */
	public void setDurataOre(BigDecimal durataOre) {
		this.durataOre = durataOre;
	}
	/**
	 * @return the numMaxDestinatari
	 */
	public Integer getNumMaxDestinatari() {
		return numMaxDestinatari;
	}
	/**
	 * @param numMaxDestinatari the numMaxDestinatari to set
	 */
	public void setNumMaxDestinatari(Integer numMaxDestinatari) {
		this.numMaxDestinatari = numMaxDestinatari;
	}
	/**
	 * @return the codUserInserim
	 */
	public String getCodUserInserim() {
		return codUserInserim;
	}
	/**
	 * @param codUserInserim the codUserInserim to set
	 */
	public void setCodUserInserim(String codUserInserim) {
		this.codUserInserim = codUserInserim;
	}
	/**
	 * @return the dInserim
	 */
	public Date getDInserim() {
		return dInserim;
	}
	/**
	 * @param dInserim the dInserim to set
	 */
	public void setDInserim(Date dInserim) {
		this.dInserim = dInserim;
	}
	/**
	 * @return the codUserAggiorn
	 */
	public String getCodUserAggiorn() {
		return codUserAggiorn;
	}
	/**
	 * @param codUserAggiorn the codUserAggiorn to set
	 */
	public void setCodUserAggiorn(String codUserAggiorn) {
		this.codUserAggiorn = codUserAggiorn;
	}
	/**
	 * @return the dAggiornam
	 */
	public Date getDAggiorn() {
		return dAggiorn;
	}
	/**
	 * @param dAggiorn the dAggiornam to set
	 */
	public void setDAggiorn(Date dAggiorn) {
		this.dAggiorn = dAggiorn;
	}

	public Date getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	public Integer getProgressivoSede() {
		return progressivoSede;
	}

	public void setProgressivoSede(Integer progressivoSede) {
		this.progressivoSede = progressivoSede;
	}

	public String getGruppoBeneficiario() {
		return gruppoBeneficiario;
	}

	public void setGruppoBeneficiario(String gruppoBeneficiario) {
		this.gruppoBeneficiario = gruppoBeneficiario;
	}

	public Long getCodiceBeneficiario() {
		return codiceBeneficiario;
	}

	public void setCodiceBeneficiario(Long codiceBeneficiario) {
		this.codiceBeneficiario = codiceBeneficiario;
	}

	public DestinatarioDTO getDestinatarioServizioIndividuale() {
		return destinatarioServizioIndividuale;
	}

	public void setDestinatarioServizioIndividuale(DestinatarioDTO destinatario) {
		this.destinatarioServizioIndividuale = destinatario;
	}

	@Override
	public String toString() {
		return "ServizioDTO{" +
				"idServizio=" + idServizio +
				", titoloServizio='" + titoloServizio + '\'' +
				", statoServizio=" + statoServizio +
				", soggettoAttuatore=" + soggettoAttuatore +
				", areaTerritoriale=" + areaTerritoriale +
				", idIntervento=" + idIntervento +
				", idPso=" + idPso +
				", servizioRegionale=" + servizioRegionale +
				", classificazione=" + classificazione +
				", referenteNome='" + referenteNome + '\'' +
				", referenteCognome='" + referenteCognome + '\'' +
				", referenteEmail='" + referenteEmail + '\'' +
				", referenteTelefono='" + referenteTelefono + '\'' +
				", durataOre=" + durataOre +
				", dataChiusura=" + dataChiusura +
				", numMaxDestinatari=" + numMaxDestinatari +
				", codUserInserim='" + codUserInserim + '\'' +
				", dInserim=" + dInserim +
				", codUserAggiorn='" + codUserAggiorn + '\'' +
				", dAggiorn=" + dAggiorn +
				", valoreDatoPeculiare1='" + valoreDatoPeculiare1 + '\'' +
				", valoreDatoPeculiare2='" + valoreDatoPeculiare2 + '\'' +
				", valoreCampoAggiuntivo1='" + valoreCampoAggiuntivo1 + '\'' +
				", codTitoloStudioIgrue='" + codTitoloStudioIgrue + '\'' +
				", codCondizioneOccupazionaleIgrue='" + codCondizioneOccupazionaleIgrue + '\'' +
				", flgDisabilita='" + flgDisabilita + '\'' +
				", flgSvantaggioAbitativo='" + flgSvantaggioAbitativo + '\'' +
				", progressivoSede=" + progressivoSede +
				'}';
	}
}
