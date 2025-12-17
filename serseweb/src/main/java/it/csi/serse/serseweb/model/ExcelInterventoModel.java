package it.csi.serse.serseweb.model;

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

public class ExcelInterventoModel {
    private String tipologiaPso;
    private String sportelloRiferimento;
    private String soggettoBeneficiario;
    private String soggettoAttuatoreProprietario;
    private String istanzaCandidatura;
    private Long idIntervento;
    private String titoloIntervento;
    private String tipologiaIntervento;
    private String finalitaIntervento;
    private Long idModelloAssociato;
    private String cognomeNomeReferente;
    private String statoIntervento;
    private String cognomeNomeDestinatario;
    private String codiceFiscaleDestinatario;
    private String tipologieServizi;
    private Integer totServizi;
    private Integer totServiziChiusi;
    private String entiCoinvolti;
    private String codUserInserimento;
    private String coduserAggiornamento;


    @Override
    public String toString() {
        return "ExcelInterventoModel{" +
                "tipologiaPso='" + tipologiaPso + '\'' +
                ", sportelloRiferimento='" + sportelloRiferimento + '\'' +
                ", soggettoBeneficiario='" + soggettoBeneficiario + '\'' +
                ", soggettoAttuatoreProprietario='" + soggettoAttuatoreProprietario + '\'' +
                ", istanzaCandidatura=" + istanzaCandidatura +
                ", idIntervento=" + idIntervento +
                ", titoloIntervento='" + titoloIntervento + '\'' +
                ", tipologiaIntervento='" + tipologiaIntervento + '\'' +
                ", finalitaIntervento='" + finalitaIntervento + '\'' +
                ", idModelloAssociato=" + idModelloAssociato +
                ", cognomeNomeReferente='" + cognomeNomeReferente + '\'' +
                ", statoIntervento='" + statoIntervento + '\'' +
                ", cognomeNomeDestinatario='" + cognomeNomeDestinatario + '\'' +
                ", codiceFiscaleDestinatario='" + codiceFiscaleDestinatario + '\'' +
                ", tipologieServizi='" + tipologieServizi + '\'' +
                ", totServizi=" + totServizi +
                ", totServiziChiusi=" + totServiziChiusi +
                ", entiCoinvolti='" + entiCoinvolti + '\'' +
                ", codUserInserimento='" + codUserInserimento + '\'' +
                ", coduserAggiornamento='" + coduserAggiornamento + '\'' +
                '}';
    }

    public String getTipologiaPso() {
        return tipologiaPso;
    }

    public void setTipologiaPso(String tipologiaPso) {
        this.tipologiaPso = tipologiaPso;
    }

    public String getSportelloRiferimento() {
        return sportelloRiferimento;
    }

    public void setSportelloRiferimento(String sportelloRiferimento) {
        this.sportelloRiferimento = sportelloRiferimento;
    }

    public String getSoggettoBeneficiario() {
        return soggettoBeneficiario;
    }

    public void setSoggettoBeneficiario(String soggettoBeneficiario) {
        this.soggettoBeneficiario = soggettoBeneficiario;
    }

    public String getSoggettoAttuatoreProprietario() {
        return soggettoAttuatoreProprietario;
    }

    public void setSoggettoAttuatoreProprietario(String soggettoAttuatoreProprietario) {
        this.soggettoAttuatoreProprietario = soggettoAttuatoreProprietario;
    }

    public String getIstanzaCandidatura() {
        return istanzaCandidatura;
    }

    public void setIstanzaCandidatura(String istanzaCandidatura) {
        this.istanzaCandidatura = istanzaCandidatura;
    }

    public Long getIdIntervento() {
        return idIntervento;
    }

    public void setIdIntervento(Long idIntervento) {
        this.idIntervento = idIntervento;
    }

    public String getTitoloIntervento() {
        return titoloIntervento;
    }

    public void setTitoloIntervento(String titoloIntervento) {
        this.titoloIntervento = titoloIntervento;
    }

    public String getTipologiaIntervento() {
        return tipologiaIntervento;
    }

    public void setTipologiaIntervento(String tipologiaIntervento) {
        this.tipologiaIntervento = tipologiaIntervento;
    }

    public String getFinalitaIntervento() {
        return finalitaIntervento;
    }

    public void setFinalitaIntervento(String finalitaIntervento) {
        this.finalitaIntervento = finalitaIntervento;
    }

    public Long getIdModelloAssociato() {
        return idModelloAssociato;
    }

    public void setIdModelloAssociato(Long idModelloAssociato) {
        this.idModelloAssociato = idModelloAssociato;
    }

    public String getCognomeNomeReferente() {
        return cognomeNomeReferente;
    }

    public void setCognomeNomeReferente(String cognomeNomeReferente) {
        this.cognomeNomeReferente = cognomeNomeReferente;
    }

    public String getStatoIntervento() {
        return statoIntervento;
    }

    public void setStatoIntervento(String statoIntervento) {
        this.statoIntervento = statoIntervento;
    }

    public String getCognomeNomeDestinatario() {
        return cognomeNomeDestinatario;
    }

    public void setCognomeNomeDestinatario(String cognomeNomeDestinatario) {
        this.cognomeNomeDestinatario = cognomeNomeDestinatario;
    }

    public String getCodiceFiscaleDestinatario() {
        return codiceFiscaleDestinatario;
    }

    public void setCodiceFiscaleDestinatario(String codiceFiscaleDestinatario) {
        this.codiceFiscaleDestinatario = codiceFiscaleDestinatario;
    }

    public String getTipologieServizi() {
        return tipologieServizi;
    }

    public void setTipologieServizi(String tipologieServizi) {
        this.tipologieServizi = tipologieServizi;
    }

    public Integer getTotServizi() {
        return totServizi;
    }

    public void setTotServizi(Integer totServizi) {
        this.totServizi = totServizi;
    }

    public Integer getTotServiziChiusi() {
        return totServiziChiusi;
    }

    public void setTotServiziChiusi(Integer totServiziChiusi) {
        this.totServiziChiusi = totServiziChiusi;
    }

    public String getEntiCoinvolti() {
        return entiCoinvolti;
    }

    public void setEntiCoinvolti(String entiCoinvolti) {
        this.entiCoinvolti = entiCoinvolti;
    }

    public String getCodUserInserimento() {
        return codUserInserimento;
    }

    public void setCodUserInserimento(String codUserInserimento) {
        this.codUserInserimento = codUserInserimento;
    }

    public String getCoduserAggiornamento() {
        return coduserAggiornamento;
    }

    public void setCoduserAggiornamento(String coduserAggiornamento) {
        this.coduserAggiornamento = coduserAggiornamento;
    }
}
