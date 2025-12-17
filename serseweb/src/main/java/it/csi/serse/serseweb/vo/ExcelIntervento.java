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

public class ExcelIntervento   {
  private String tipolPso = null;
  private String sportello = null;
  private String soggettoBeneficiario = null;
  private String soggettoAttuatore = null;
  private String modelId = null;
  private Long idIntervento = null;
  private String titolo = null;
  private String tipoIntervento = null;
  private String finalitaIntervento = null;
  private Long idModelloAssociato = null;
  private String referente = null;
  private String statoIntervento = null;
  private String cognNomeDesctinatario = null;
  private String cFDestinatario = null;
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
  
  @JsonProperty("idIntervento")
  public Long getIdIntervento() {
    return idIntervento;
  }
  public void setIdIntervento(Long idIntervento) {
    this.idIntervento = idIntervento;
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
  
  @JsonProperty("tipoIntervento")
  public String getTipoIntervento() {
    return tipoIntervento;
  }
  public void setTipoIntervento(String tipoIntervento) {
    this.tipoIntervento = tipoIntervento;
  }

  /**
   **/
  
  @JsonProperty("finalitaIntervento")
  public String getFinalitaIntervento() {
    return finalitaIntervento;
  }
  public void setFinalitaIntervento(String finalitaIntervento) {
    this.finalitaIntervento = finalitaIntervento;
  }

  /**
   **/
  
  @JsonProperty("idModelloAssociato")
  public Long getIdModelloAssociato() {
    return idModelloAssociato;
  }
  public void setIdModelloAssociato(Long idModelloAssociato) {
    this.idModelloAssociato = idModelloAssociato;
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
  
  @JsonProperty("statoIntervento")
  public String getStatoIntervento() {
    return statoIntervento;
  }
  public void setStatoIntervento(String statoIntervento) {
    this.statoIntervento = statoIntervento;
  }

  /**
   **/
  
  @JsonProperty("cognNomeDesctinatario")
  public String getCognNomeDesctinatario() {
    return cognNomeDesctinatario;
  }
  public void setCognNomeDesctinatario(String cognNomeDesctinatario) {
    this.cognNomeDesctinatario = cognNomeDesctinatario;
  }

  /**
   **/
  
  @JsonProperty("cFDestinatario")
  public String getCFDestinatario() {
    return cFDestinatario;
  }
  public void setCFDestinatario(String cFDestinatario) {
    this.cFDestinatario = cFDestinatario;
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
    ExcelIntervento excelIntervento = (ExcelIntervento) o;
    return Objects.equals(tipolPso, excelIntervento.tipolPso) &&
        Objects.equals(sportello, excelIntervento.sportello) &&
        Objects.equals(soggettoBeneficiario, excelIntervento.soggettoBeneficiario) &&
        Objects.equals(soggettoAttuatore, excelIntervento.soggettoAttuatore) &&
        Objects.equals(modelId, excelIntervento.modelId) &&
        Objects.equals(idIntervento, excelIntervento.idIntervento) &&
        Objects.equals(titolo, excelIntervento.titolo) &&
        Objects.equals(tipoIntervento, excelIntervento.tipoIntervento) &&
        Objects.equals(finalitaIntervento, excelIntervento.finalitaIntervento) &&
        Objects.equals(idModelloAssociato, excelIntervento.idModelloAssociato) &&
        Objects.equals(referente, excelIntervento.referente) &&
        Objects.equals(statoIntervento, excelIntervento.statoIntervento) &&
        Objects.equals(cognNomeDesctinatario, excelIntervento.cognNomeDesctinatario) &&
        Objects.equals(cFDestinatario, excelIntervento.cFDestinatario) &&
        Objects.equals(codUserInserimento, excelIntervento.codUserInserimento) &&
        Objects.equals(codUserAggiornamento, excelIntervento.codUserAggiornamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipolPso, sportello, soggettoBeneficiario, soggettoAttuatore, modelId, idIntervento, titolo, tipoIntervento, finalitaIntervento, idModelloAssociato, referente, statoIntervento, cognNomeDesctinatario, cFDestinatario, codUserInserimento, codUserAggiornamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcelIntervento {\n");
    
    sb.append("    tipolPso: ").append(toIndentedString(tipolPso)).append("\n");
    sb.append("    sportello: ").append(toIndentedString(sportello)).append("\n");
    sb.append("    soggettoBeneficiario: ").append(toIndentedString(soggettoBeneficiario)).append("\n");
    sb.append("    soggettoAttuatore: ").append(toIndentedString(soggettoAttuatore)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    titolo: ").append(toIndentedString(titolo)).append("\n");
    sb.append("    tipoIntervento: ").append(toIndentedString(tipoIntervento)).append("\n");
    sb.append("    finalitaIntervento: ").append(toIndentedString(finalitaIntervento)).append("\n");
    sb.append("    idModelloAssociato: ").append(toIndentedString(idModelloAssociato)).append("\n");
    sb.append("    referente: ").append(toIndentedString(referente)).append("\n");
    sb.append("    statoIntervento: ").append(toIndentedString(statoIntervento)).append("\n");
    sb.append("    cognNomeDesctinatario: ").append(toIndentedString(cognNomeDesctinatario)).append("\n");
    sb.append("    cFDestinatario: ").append(toIndentedString(cFDestinatario)).append("\n");
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
