package it.csi.serse.serseweb.vo;

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

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import it.csi.serse.serseweb.vo.AreaTerritoriale;
import it.csi.serse.serseweb.vo.Classificazione;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import it.csi.serse.serseweb.vo.StatoServizio;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.validation.constraints.*;

public class Servizio   {
  private Long idServizio = null;
  private String titoloServizio = null;
  private StatoServizio statoServizio = null;
  private SoggettoAttuatore soggettoAttuatore = null;
  private AreaTerritoriale areaTerritoriale = null;
  private Long idIntervento = null;
  private Long idPso = null;
  private ServizioRegionale servizioRegionale = null;
  private Classificazione classificazione = null;
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
  private String codTitoloStudioIgrue = null;
  private String codCondizioneOccupazionaleIgrue = null;
  private String flgDisabilita = null;
  private String flgSvantaggioAbitativo = null;
  private Integer progressivoSede = null;
  private String valoreCampoAggiuntivo1 = null;
  private Long idPsoClasseDestinatario = null;

  /**
   **/
  
  @JsonProperty("idServizio")
  public Long getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(Long idServizio) {
    this.idServizio = idServizio;
  }

  /**
   **/
  
  @JsonProperty("titoloServizio")
  public String getTitoloServizio() {
    return titoloServizio;
  }
  public void setTitoloServizio(String titoloServizio) {
    this.titoloServizio = titoloServizio;
  }

  /**
   **/
  
  @JsonProperty("statoServizio")
  public StatoServizio getStatoServizio() {
    return statoServizio;
  }
  public void setStatoServizio(StatoServizio statoServizio) {
    this.statoServizio = statoServizio;
  }

  /**
   **/
  
  @JsonProperty("soggettoAttuatore")
  public SoggettoAttuatore getSoggettoAttuatore() {
    return soggettoAttuatore;
  }
  public void setSoggettoAttuatore(SoggettoAttuatore soggettoAttuatore) {
    this.soggettoAttuatore = soggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("areaTerritoriale")
  public AreaTerritoriale getAreaTerritoriale() {
    return areaTerritoriale;
  }
  public void setAreaTerritoriale(AreaTerritoriale areaTerritoriale) {
    this.areaTerritoriale = areaTerritoriale;
  }

  /**
   **/
  
  @JsonProperty("idIntervento")
  public Long getIdIntervento() {
    return idIntervento;
  }
  public void setIdIntervento(Long idIntervento) {
    this.idIntervento = idIntervento;
  }

  /**
   **/
  
  @JsonProperty("idPso")
  public Long getIdPso() {
    return idPso;
  }
  public void setIdPso(Long idPso) {
    this.idPso = idPso;
  }

  /**
   **/
  
  @JsonProperty("servizioRegionale")
  public ServizioRegionale getServizioRegionale() {
    return servizioRegionale;
  }
  public void setServizioRegionale(ServizioRegionale servizioRegionale) {
    this.servizioRegionale = servizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("classificazione")
  public Classificazione getClassificazione() {
    return classificazione;
  }
  public void setClassificazione(Classificazione classificazione) {
    this.classificazione = classificazione;
  }

  /**
   **/
  
  @JsonProperty("referenteNome")
  public String getReferenteNome() {
    return referenteNome;
  }
  public void setReferenteNome(String referenteNome) {
    this.referenteNome = referenteNome;
  }

  /**
   **/
  
  @JsonProperty("referenteCognome")
  public String getReferenteCognome() {
    return referenteCognome;
  }
  public void setReferenteCognome(String referenteCognome) {
    this.referenteCognome = referenteCognome;
  }

  /**
   **/
  
  @JsonProperty("referenteEmail")
  public String getReferenteEmail() {
    return referenteEmail;
  }
  public void setReferenteEmail(String referenteEmail) {
    this.referenteEmail = referenteEmail;
  }

  /**
   **/
  
  @JsonProperty("referenteTelefono")
  public String getReferenteTelefono() {
    return referenteTelefono;
  }
  public void setReferenteTelefono(String referenteTelefono) {
    this.referenteTelefono = referenteTelefono;
  }

  /**
   **/
  
  @JsonProperty("durataOre")
  public BigDecimal getDurataOre() {
    return durataOre;
  }
  public void setDurataOre(BigDecimal durataOre) {
    this.durataOre = durataOre;
  }

  /**
   **/
  
  @JsonProperty("dataChiusura")
  public Date getDataChiusura() {
    return dataChiusura;
  }
  public void setDataChiusura(Date dataChiusura) {
    this.dataChiusura = dataChiusura;
  }

  /**
   **/
  
  @JsonProperty("numMaxDestinatari")
  public Integer getNumMaxDestinatari() {
    return numMaxDestinatari;
  }
  public void setNumMaxDestinatari(Integer numMaxDestinatari) {
    this.numMaxDestinatari = numMaxDestinatari;
  }

  /**
   **/
  
  @JsonProperty("codUserInserim")
  public String getCodUserInserim() {
    return codUserInserim;
  }
  public void setCodUserInserim(String codUserInserim) {
    this.codUserInserim = codUserInserim;
  }

  /**
   **/
  
  @JsonProperty("dInserim")
  public Date getDInserim() {
    return dInserim;
  }
  public void setDInserim(Date dInserim) {
    this.dInserim = dInserim;
  }

  /**
   **/
  
  @JsonProperty("codUserAggiorn")
  public String getCodUserAggiorn() {
    return codUserAggiorn;
  }
  public void setCodUserAggiorn(String codUserAggiorn) {
    this.codUserAggiorn = codUserAggiorn;
  }

  /**
   **/
  
  @JsonProperty("dAggiorn")
  public Date getDAggiorn() {
    return dAggiorn;
  }
  public void setDAggiorn(Date dAggiorn) {
    this.dAggiorn = dAggiorn;
  }

  /**
   **/
  
  @JsonProperty("valoreDatoPeculiare1")
  public String getValoreDatoPeculiare1() {
    return valoreDatoPeculiare1;
  }
  public void setValoreDatoPeculiare1(String valoreDatoPeculiare1) {
    this.valoreDatoPeculiare1 = valoreDatoPeculiare1;
  }

  /**
   **/
  
  @JsonProperty("valoreDatoPeculiare2")
  public String getValoreDatoPeculiare2() {
    return valoreDatoPeculiare2;
  }
  public void setValoreDatoPeculiare2(String valoreDatoPeculiare2) {
    this.valoreDatoPeculiare2 = valoreDatoPeculiare2;
  }

  /**
   **/
  
  @JsonProperty("codTitoloStudioIgrue")
  public String getCodTitoloStudioIgrue() {
    return codTitoloStudioIgrue;
  }
  public void setCodTitoloStudioIgrue(String codTitoloStudioIgrue) {
    this.codTitoloStudioIgrue = codTitoloStudioIgrue;
  }

  /**
   **/
  
  @JsonProperty("codCondizioneOccupazionaleIgrue")
  public String getCodCondizioneOccupazionaleIgrue() {
    return codCondizioneOccupazionaleIgrue;
  }
  public void setCodCondizioneOccupazionaleIgrue(String codCondizioneOccupazionaleIgrue) {
    this.codCondizioneOccupazionaleIgrue = codCondizioneOccupazionaleIgrue;
  }

  /**
   **/
  
  @JsonProperty("flgDisabilita")
  public String getFlgDisabilita() {
    return flgDisabilita;
  }
  public void setFlgDisabilita(String flgDisabilita) {
    this.flgDisabilita = flgDisabilita;
  }

  /**
   **/
  
  @JsonProperty("flgSvantaggioAbitativo")
  public String getFlgSvantaggioAbitativo() {
    return flgSvantaggioAbitativo;
  }
  public void setFlgSvantaggioAbitativo(String flgSvantaggioAbitativo) {
    this.flgSvantaggioAbitativo = flgSvantaggioAbitativo;
  }

  /**
   **/
  
  @JsonProperty("progressivoSede")
  public Integer getProgressivoSede() {
    return progressivoSede;
  }
  public void setProgressivoSede(Integer progressivoSede) {
    this.progressivoSede = progressivoSede;
  }

  /**
   **/
  
  @JsonProperty("valoreCampoAggiuntivo1")
  public String getValoreCampoAggiuntivo1() {
    return valoreCampoAggiuntivo1;
  }
  public void setValoreCampoAggiuntivo1(String valoreCampoAggiuntivo1) {
    this.valoreCampoAggiuntivo1 = valoreCampoAggiuntivo1;
  }

  /**
   **/
  
  @JsonProperty("idPsoClasseDestinatario")
  public Long getIdPsoClasseDestinatario() {
    return idPsoClasseDestinatario;
  }
  public void setIdPsoClasseDestinatario(Long idPsoClasseDestinatario) {
    this.idPsoClasseDestinatario = idPsoClasseDestinatario;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Servizio servizio = (Servizio) o;
    return Objects.equals(idServizio, servizio.idServizio) &&
        Objects.equals(titoloServizio, servizio.titoloServizio) &&
        Objects.equals(statoServizio, servizio.statoServizio) &&
        Objects.equals(soggettoAttuatore, servizio.soggettoAttuatore) &&
        Objects.equals(areaTerritoriale, servizio.areaTerritoriale) &&
        Objects.equals(idIntervento, servizio.idIntervento) &&
        Objects.equals(idPso, servizio.idPso) &&
        Objects.equals(servizioRegionale, servizio.servizioRegionale) &&
        Objects.equals(classificazione, servizio.classificazione) &&
        Objects.equals(referenteNome, servizio.referenteNome) &&
        Objects.equals(referenteCognome, servizio.referenteCognome) &&
        Objects.equals(referenteEmail, servizio.referenteEmail) &&
        Objects.equals(referenteTelefono, servizio.referenteTelefono) &&
        Objects.equals(durataOre, servizio.durataOre) &&
        Objects.equals(dataChiusura, servizio.dataChiusura) &&
        Objects.equals(numMaxDestinatari, servizio.numMaxDestinatari) &&
        Objects.equals(codUserInserim, servizio.codUserInserim) &&
        Objects.equals(dInserim, servizio.dInserim) &&
        Objects.equals(codUserAggiorn, servizio.codUserAggiorn) &&
        Objects.equals(dAggiorn, servizio.dAggiorn) &&
        Objects.equals(valoreDatoPeculiare1, servizio.valoreDatoPeculiare1) &&
        Objects.equals(valoreDatoPeculiare2, servizio.valoreDatoPeculiare2) &&
        Objects.equals(codTitoloStudioIgrue, servizio.codTitoloStudioIgrue) &&
        Objects.equals(codCondizioneOccupazionaleIgrue, servizio.codCondizioneOccupazionaleIgrue) &&
        Objects.equals(flgDisabilita, servizio.flgDisabilita) &&
        Objects.equals(flgSvantaggioAbitativo, servizio.flgSvantaggioAbitativo) &&
        Objects.equals(progressivoSede, servizio.progressivoSede) &&
        Objects.equals(valoreCampoAggiuntivo1, servizio.valoreCampoAggiuntivo1) &&
        Objects.equals(idPsoClasseDestinatario, servizio.idPsoClasseDestinatario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizio, titoloServizio, statoServizio, soggettoAttuatore, areaTerritoriale, idIntervento, idPso, servizioRegionale, classificazione, referenteNome, referenteCognome, referenteEmail, referenteTelefono, durataOre, dataChiusura, numMaxDestinatari, codUserInserim, dInserim, codUserAggiorn, dAggiorn, valoreDatoPeculiare1, valoreDatoPeculiare2, codTitoloStudioIgrue, codCondizioneOccupazionaleIgrue, flgDisabilita, flgSvantaggioAbitativo, progressivoSede, valoreCampoAggiuntivo1, idPsoClasseDestinatario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Servizio {\n");
    
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    titoloServizio: ").append(toIndentedString(titoloServizio)).append("\n");
    sb.append("    statoServizio: ").append(toIndentedString(statoServizio)).append("\n");
    sb.append("    soggettoAttuatore: ").append(toIndentedString(soggettoAttuatore)).append("\n");
    sb.append("    areaTerritoriale: ").append(toIndentedString(areaTerritoriale)).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    servizioRegionale: ").append(toIndentedString(servizioRegionale)).append("\n");
    sb.append("    classificazione: ").append(toIndentedString(classificazione)).append("\n");
    sb.append("    referenteNome: ").append(toIndentedString(referenteNome)).append("\n");
    sb.append("    referenteCognome: ").append(toIndentedString(referenteCognome)).append("\n");
    sb.append("    referenteEmail: ").append(toIndentedString(referenteEmail)).append("\n");
    sb.append("    referenteTelefono: ").append(toIndentedString(referenteTelefono)).append("\n");
    sb.append("    durataOre: ").append(toIndentedString(durataOre)).append("\n");
    sb.append("    dataChiusura: ").append(toIndentedString(dataChiusura)).append("\n");
    sb.append("    numMaxDestinatari: ").append(toIndentedString(numMaxDestinatari)).append("\n");
    sb.append("    codUserInserim: ").append(toIndentedString(codUserInserim)).append("\n");
    sb.append("    dInserim: ").append(toIndentedString(dInserim)).append("\n");
    sb.append("    codUserAggiorn: ").append(toIndentedString(codUserAggiorn)).append("\n");
    sb.append("    dAggiorn: ").append(toIndentedString(dAggiorn)).append("\n");
    sb.append("    valoreDatoPeculiare1: ").append(toIndentedString(valoreDatoPeculiare1)).append("\n");
    sb.append("    valoreDatoPeculiare2: ").append(toIndentedString(valoreDatoPeculiare2)).append("\n");
    sb.append("    codTitoloStudioIgrue: ").append(toIndentedString(codTitoloStudioIgrue)).append("\n");
    sb.append("    codCondizioneOccupazionaleIgrue: ").append(toIndentedString(codCondizioneOccupazionaleIgrue)).append("\n");
    sb.append("    flgDisabilita: ").append(toIndentedString(flgDisabilita)).append("\n");
    sb.append("    flgSvantaggioAbitativo: ").append(toIndentedString(flgSvantaggioAbitativo)).append("\n");
    sb.append("    progressivoSede: ").append(toIndentedString(progressivoSede)).append("\n");
    sb.append("    valoreCampoAggiuntivo1: ").append(toIndentedString(valoreCampoAggiuntivo1)).append("\n");
    sb.append("    idPsoClasseDestinatario: ").append(toIndentedString(idPsoClasseDestinatario)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
