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
import jakarta.validation.constraints.*;

public class ExcelModello   {
  private String tipolPso = null;
  private String sportello = null;
  private String soggettoBeneficiario = null;
  private String soggettoAttuatore = null;
  private String modelId = null;
  private Long idModello = null;
  private String titolo = null;
  private String tipoModello = null;
  private String finalitaModello = null;
  private String referente = null;
  private String statoModello = null;
  private String codUserInserimento = null;
  private String codUserAggiornamento = null;

  /**
   **/
  
  @JsonProperty("tipolPso")
  public String getTipolPso() {
    return tipolPso;
  }
  public void setTipolPso(String tipolPso) {
    this.tipolPso = tipolPso;
  }

  /**
   **/
  
  @JsonProperty("sportello")
  public String getSportello() {
    return sportello;
  }
  public void setSportello(String sportello) {
    this.sportello = sportello;
  }

  /**
   **/
  
  @JsonProperty("soggettoBeneficiario")
  public String getSoggettoBeneficiario() {
    return soggettoBeneficiario;
  }
  public void setSoggettoBeneficiario(String soggettoBeneficiario) {
    this.soggettoBeneficiario = soggettoBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("soggettoAttuatore")
  public String getSoggettoAttuatore() {
    return soggettoAttuatore;
  }
  public void setSoggettoAttuatore(String soggettoAttuatore) {
    this.soggettoAttuatore = soggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("modelId")
  public String getModelId() {
    return modelId;
  }
  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  /**
   **/
  
  @JsonProperty("idModello")
  public Long getIdModello() {
    return idModello;
  }
  public void setIdModello(Long idModello) {
    this.idModello = idModello;
  }

  /**
   **/
  
  @JsonProperty("titolo")
  public String getTitolo() {
    return titolo;
  }
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  /**
   **/
  
  @JsonProperty("tipoModello")
  public String getTipoModello() {
    return tipoModello;
  }
  public void setTipoModello(String tipoModello) {
    this.tipoModello = tipoModello;
  }

  /**
   **/
  
  @JsonProperty("finalitaModello")
  public String getFinalitaModello() {
    return finalitaModello;
  }
  public void setFinalitaModello(String finalitaModello) {
    this.finalitaModello = finalitaModello;
  }

  /**
   **/
  
  @JsonProperty("referente")
  public String getReferente() {
    return referente;
  }
  public void setReferente(String referente) {
    this.referente = referente;
  }

  /**
   **/
  
  @JsonProperty("statoModello")
  public String getStatoModello() {
    return statoModello;
  }
  public void setStatoModello(String statoModello) {
    this.statoModello = statoModello;
  }

  /**
   **/
  
  @JsonProperty("codUserInserimento")
  public String getCodUserInserimento() {
    return codUserInserimento;
  }
  public void setCodUserInserimento(String codUserInserimento) {
    this.codUserInserimento = codUserInserimento;
  }

  /**
   **/
  
  @JsonProperty("codUserAggiornamento")
  public String getCodUserAggiornamento() {
    return codUserAggiornamento;
  }
  public void setCodUserAggiornamento(String codUserAggiornamento) {
    this.codUserAggiornamento = codUserAggiornamento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExcelModello excelModello = (ExcelModello) o;
    return Objects.equals(tipolPso, excelModello.tipolPso) &&
        Objects.equals(sportello, excelModello.sportello) &&
        Objects.equals(soggettoBeneficiario, excelModello.soggettoBeneficiario) &&
        Objects.equals(soggettoAttuatore, excelModello.soggettoAttuatore) &&
        Objects.equals(modelId, excelModello.modelId) &&
        Objects.equals(idModello, excelModello.idModello) &&
        Objects.equals(titolo, excelModello.titolo) &&
        Objects.equals(tipoModello, excelModello.tipoModello) &&
        Objects.equals(finalitaModello, excelModello.finalitaModello) &&
        Objects.equals(referente, excelModello.referente) &&
        Objects.equals(statoModello, excelModello.statoModello) &&
        Objects.equals(codUserInserimento, excelModello.codUserInserimento) &&
        Objects.equals(codUserAggiornamento, excelModello.codUserAggiornamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipolPso, sportello, soggettoBeneficiario, soggettoAttuatore, modelId, idModello, titolo, tipoModello, finalitaModello, referente, statoModello, codUserInserimento, codUserAggiornamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcelModello {\n");
    
    sb.append("    tipolPso: ").append(toIndentedString(tipolPso)).append("\n");
    sb.append("    sportello: ").append(toIndentedString(sportello)).append("\n");
    sb.append("    soggettoBeneficiario: ").append(toIndentedString(soggettoBeneficiario)).append("\n");
    sb.append("    soggettoAttuatore: ").append(toIndentedString(soggettoAttuatore)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    idModello: ").append(toIndentedString(idModello)).append("\n");
    sb.append("    titolo: ").append(toIndentedString(titolo)).append("\n");
    sb.append("    tipoModello: ").append(toIndentedString(tipoModello)).append("\n");
    sb.append("    finalitaModello: ").append(toIndentedString(finalitaModello)).append("\n");
    sb.append("    referente: ").append(toIndentedString(referente)).append("\n");
    sb.append("    statoModello: ").append(toIndentedString(statoModello)).append("\n");
    sb.append("    codUserInserimento: ").append(toIndentedString(codUserInserimento)).append("\n");
    sb.append("    codUserAggiornamento: ").append(toIndentedString(codUserAggiornamento)).append("\n");
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
