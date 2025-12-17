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

public class ExcelServizioModel {
    private String tipologiaPso;
    private String sportelloRiferimento;
    private String soggettoBeneficiario;
    private String soggettoAttuatoreProprietario;
    private String sedeSoggettoAttuatore;
    private String istanzaCandidatura;
    private Long idServizio;
    private String titoloServizio;
    private String tipologiaServizio;
    private String finalitaServizio;
    private Long idInterventoAssociato;
    private String statoServizio;
    private String durata;
    private Integer numMaxDestinatari;
    private Integer numDestinatariAssociati;
    private String cognomeNomeDestinatario;
    private String codiceFiscaleDestinatario;
    private Integer totIncontriDefiniti;
    private Integer totIncontriChiusi;
    private String entiCoinvolti;
    private String codUserInserimento;
    private String coduserAggiornamento;

    private String valoreCampoAggiuntivo1;

    @Override
    public String toString() {
        return "ExcelServizioModel{" +
                "tipologiaPso='" + tipologiaPso + '\'' +
                ", sportelloRiferimento='" + sportelloRiferimento + '\'' +
                ", soggettoBeneficiario='" + soggettoBeneficiario + '\'' +
                ", soggettoAttuatoreProprietario='" + soggettoAttuatoreProprietario + '\'' +
                ", sedeSoggettoAttuatore='" + sedeSoggettoAttuatore + '\'' +
                ", istanzaCandidatura='" + istanzaCandidatura + '\'' +
                ", idServizio=" + idServizio +
                ", titoloServizio='" + titoloServizio + '\'' +
                ", tipologiaServizio='" + tipologiaServizio + '\'' +
                ", finalitaServizio='" + finalitaServizio + '\'' +
                ", idInterventoAssociato=" + idInterventoAssociato +
                ", statoServizio='" + statoServizio + '\'' +
                ", durata='" + durata + '\'' +
                ", numMaxDestinatari=" + numMaxDestinatari +
                ", numDestinatariAssociati=" + numDestinatariAssociati +
                ", cognomeNomeDestinatario='" + cognomeNomeDestinatario + '\'' +
                ", codiceFiscaleDestinatario='" + codiceFiscaleDestinatario + '\'' +
                ", totIncontriDefiniti=" + totIncontriDefiniti +
                ", totIncontriChiusi=" + totIncontriChiusi +
                ", entiCoinvolti='" + entiCoinvolti + '\'' +
                ", codUserInserimento='" + codUserInserimento + '\'' +
                ", coduserAggiornamento='" + coduserAggiornamento + '\'' +
                ", valoreCampoAggiuntivo1='" + valoreCampoAggiuntivo1 + '\'' +
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

    public String getSedeSoggettoAttuatore() {
        return sedeSoggettoAttuatore;
    }

    public void setSedeSoggettoAttuatore(String sedeSoggettoAttuatore) {
        this.sedeSoggettoAttuatore = sedeSoggettoAttuatore;
    }

    public String getIstanzaCandidatura() {
        return istanzaCandidatura;
    }

    public void setIstanzaCandidatura(String istanzaCandidatura) {
        this.istanzaCandidatura = istanzaCandidatura;
    }

    public Long getIdServizio() {
        return idServizio;
    }

    public void setIdServizio(Long idServizio) {
        this.idServizio = idServizio;
    }

    public String getTitoloServizio() {
        return titoloServizio;
    }

    public void setTitoloServizio(String titoloServizio) {
        this.titoloServizio = titoloServizio;
    }

    public String getTipologiaServizio() {
        return tipologiaServizio;
    }

    public void setTipologiaServizio(String tipologiaServizio) {
        this.tipologiaServizio = tipologiaServizio;
    }

    public String getFinalitaServizio() {
        return finalitaServizio;
    }

    public void setFinalitaServizio(String finalitaServizio) {
        this.finalitaServizio = finalitaServizio;
    }

    public Long getIdInterventoAssociato() {
        return idInterventoAssociato;
    }

    public void setIdInterventoAssociato(Long idInterventoAssociato) {
        this.idInterventoAssociato = idInterventoAssociato;
    }

    public String getStatoServizio() {
        return statoServizio;
    }

    public void setStatoServizio(String statoServizio) {
        this.statoServizio = statoServizio;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public Integer getNumMaxDestinatari() {
        return numMaxDestinatari;
    }

    public void setNumMaxDestinatari(Integer numMaxDestinatari) {
        this.numMaxDestinatari = numMaxDestinatari;
    }

    public Integer getNumDestinatariAssociati() {
        return numDestinatariAssociati;
    }

    public void setNumDestinatariAssociati(Integer numDestinatariAssociati) {
        this.numDestinatariAssociati = numDestinatariAssociati;
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

    public Integer getTotIncontriDefiniti() {
        return totIncontriDefiniti;
    }

    public void setTotIncontriDefiniti(Integer totIncontriDefiniti) {
        this.totIncontriDefiniti = totIncontriDefiniti;
    }

    public Integer getTotIncontriChiusi() {
        return totIncontriChiusi;
    }

    public void setTotIncontriChiusi(Integer totIncontriChiusi) {
        this.totIncontriChiusi = totIncontriChiusi;
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

    public String getValoreCampoAggiuntivo1() {
        return valoreCampoAggiuntivo1;
    }

    public void setValoreCampoAggiuntivo1(String valoreCampoAggiuntivo1) {
        this.valoreCampoAggiuntivo1 = valoreCampoAggiuntivo1;
    }
}
