package it.csi.serse.serseapi.vo;

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
import jakarta.validation.constraints.*;

public class OutputEsposizioneServiziItem   {
  private Long idServizioSerse = null;
  private String titoloServizio = null;
  private Integer codServizioRegionale = null;
  private String descrServizioRegionale = null;
  private String codFinalitaServizio = null;
  private String descrFinalitaServizio = null;
  private String gruppoSoggettoAttuatore = null;
  private Integer codiceSoggettoAttuatore = null;
  private String denominazioneSoggettoAttuatore = null;
  private String gruppoSoggettoBeneficiario = null;
  private Integer codiceSoggettoBeneficiario = null;
  private String denominazioneSoggettoBeneficiario = null;
  private String statoServizio = null;

  /**
   **/
  
  @JsonProperty("idServizioSerse")
  public Long getIdServizioSerse() {
    return idServizioSerse;
  }
  public void setIdServizioSerse(Long idServizioSerse) {
    this.idServizioSerse = idServizioSerse;
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
  
  @JsonProperty("codServizioRegionale")
  public Integer getCodServizioRegionale() {
    return codServizioRegionale;
  }
  public void setCodServizioRegionale(Integer codServizioRegionale) {
    this.codServizioRegionale = codServizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("descrServizioRegionale")
  public String getDescrServizioRegionale() {
    return descrServizioRegionale;
  }
  public void setDescrServizioRegionale(String descrServizioRegionale) {
    this.descrServizioRegionale = descrServizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("codFinalitaServizio")
  public String getCodFinalitaServizio() {
    return codFinalitaServizio;
  }
  public void setCodFinalitaServizio(String codFinalitaServizio) {
    this.codFinalitaServizio = codFinalitaServizio;
  }

  /**
   **/
  
  @JsonProperty("descrFinalitaServizio")
  public String getDescrFinalitaServizio() {
    return descrFinalitaServizio;
  }
  public void setDescrFinalitaServizio(String descrFinalitaServizio) {
    this.descrFinalitaServizio = descrFinalitaServizio;
  }

  /**
   **/
  
  @JsonProperty("gruppoSoggettoAttuatore")
  public String getGruppoSoggettoAttuatore() {
    return gruppoSoggettoAttuatore;
  }
  public void setGruppoSoggettoAttuatore(String gruppoSoggettoAttuatore) {
    this.gruppoSoggettoAttuatore = gruppoSoggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("codiceSoggettoAttuatore")
  public Integer getCodiceSoggettoAttuatore() {
    return codiceSoggettoAttuatore;
  }
  public void setCodiceSoggettoAttuatore(Integer codiceSoggettoAttuatore) {
    this.codiceSoggettoAttuatore = codiceSoggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("denominazioneSoggettoAttuatore")
  public String getDenominazioneSoggettoAttuatore() {
    return denominazioneSoggettoAttuatore;
  }
  public void setDenominazioneSoggettoAttuatore(String denominazioneSoggettoAttuatore) {
    this.denominazioneSoggettoAttuatore = denominazioneSoggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("gruppoSoggettoBeneficiario")
  public String getGruppoSoggettoBeneficiario() {
    return gruppoSoggettoBeneficiario;
  }
  public void setGruppoSoggettoBeneficiario(String gruppoSoggettoBeneficiario) {
    this.gruppoSoggettoBeneficiario = gruppoSoggettoBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("codiceSoggettoBeneficiario")
  public Integer getCodiceSoggettoBeneficiario() {
    return codiceSoggettoBeneficiario;
  }
  public void setCodiceSoggettoBeneficiario(Integer codiceSoggettoBeneficiario) {
    this.codiceSoggettoBeneficiario = codiceSoggettoBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("denominazioneSoggettoBeneficiario")
  public String getDenominazioneSoggettoBeneficiario() {
    return denominazioneSoggettoBeneficiario;
  }
  public void setDenominazioneSoggettoBeneficiario(String denominazioneSoggettoBeneficiario) {
    this.denominazioneSoggettoBeneficiario = denominazioneSoggettoBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("statoServizio")
  public String getStatoServizio() {
    return statoServizio;
  }
  public void setStatoServizio(String statoServizio) {
    this.statoServizio = statoServizio;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutputEsposizioneServiziItem outputEsposizioneServiziItem = (OutputEsposizioneServiziItem) o;
    return Objects.equals(idServizioSerse, outputEsposizioneServiziItem.idServizioSerse) &&
        Objects.equals(titoloServizio, outputEsposizioneServiziItem.titoloServizio) &&
        Objects.equals(codServizioRegionale, outputEsposizioneServiziItem.codServizioRegionale) &&
        Objects.equals(descrServizioRegionale, outputEsposizioneServiziItem.descrServizioRegionale) &&
        Objects.equals(codFinalitaServizio, outputEsposizioneServiziItem.codFinalitaServizio) &&
        Objects.equals(descrFinalitaServizio, outputEsposizioneServiziItem.descrFinalitaServizio) &&
        Objects.equals(gruppoSoggettoAttuatore, outputEsposizioneServiziItem.gruppoSoggettoAttuatore) &&
        Objects.equals(codiceSoggettoAttuatore, outputEsposizioneServiziItem.codiceSoggettoAttuatore) &&
        Objects.equals(denominazioneSoggettoAttuatore, outputEsposizioneServiziItem.denominazioneSoggettoAttuatore) &&
        Objects.equals(gruppoSoggettoBeneficiario, outputEsposizioneServiziItem.gruppoSoggettoBeneficiario) &&
        Objects.equals(codiceSoggettoBeneficiario, outputEsposizioneServiziItem.codiceSoggettoBeneficiario) &&
        Objects.equals(denominazioneSoggettoBeneficiario, outputEsposizioneServiziItem.denominazioneSoggettoBeneficiario) &&
        Objects.equals(statoServizio, outputEsposizioneServiziItem.statoServizio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizioSerse, titoloServizio, codServizioRegionale, descrServizioRegionale, codFinalitaServizio, descrFinalitaServizio, gruppoSoggettoAttuatore, codiceSoggettoAttuatore, denominazioneSoggettoAttuatore, gruppoSoggettoBeneficiario, codiceSoggettoBeneficiario, denominazioneSoggettoBeneficiario, statoServizio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutputEsposizioneServiziItem {\n");
    
    sb.append("    idServizioSerse: ").append(toIndentedString(idServizioSerse)).append("\n");
    sb.append("    titoloServizio: ").append(toIndentedString(titoloServizio)).append("\n");
    sb.append("    codServizioRegionale: ").append(toIndentedString(codServizioRegionale)).append("\n");
    sb.append("    descrServizioRegionale: ").append(toIndentedString(descrServizioRegionale)).append("\n");
    sb.append("    codFinalitaServizio: ").append(toIndentedString(codFinalitaServizio)).append("\n");
    sb.append("    descrFinalitaServizio: ").append(toIndentedString(descrFinalitaServizio)).append("\n");
    sb.append("    gruppoSoggettoAttuatore: ").append(toIndentedString(gruppoSoggettoAttuatore)).append("\n");
    sb.append("    codiceSoggettoAttuatore: ").append(toIndentedString(codiceSoggettoAttuatore)).append("\n");
    sb.append("    denominazioneSoggettoAttuatore: ").append(toIndentedString(denominazioneSoggettoAttuatore)).append("\n");
    sb.append("    gruppoSoggettoBeneficiario: ").append(toIndentedString(gruppoSoggettoBeneficiario)).append("\n");
    sb.append("    codiceSoggettoBeneficiario: ").append(toIndentedString(codiceSoggettoBeneficiario)).append("\n");
    sb.append("    denominazioneSoggettoBeneficiario: ").append(toIndentedString(denominazioneSoggettoBeneficiario)).append("\n");
    sb.append("    statoServizio: ").append(toIndentedString(statoServizio)).append("\n");
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
