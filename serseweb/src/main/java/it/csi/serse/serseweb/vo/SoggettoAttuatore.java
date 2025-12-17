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
import java.util.Date;
import jakarta.validation.constraints.*;

public class SoggettoAttuatore   {
  private Long idSoggettoAttuatore = null;
  private Integer numProgrSportello = null;
  private String gruppoOperatore = null;
  private Integer modelId = null;
  private Integer codOperatore = null;
  private String denominazioneGiuridica = null;
  private String flgCapofila = null;
  private Date dataInserimento = null;
  private String descrAreaTerritoriale = null;
  private String codUserInserimento = null;
  private Date dataAggiornamento = null;
  private String codUserAggiornamento = null;

  /**
   **/
  
  @JsonProperty("idSoggettoAttuatore")
  public Long getIdSoggettoAttuatore() {
    return idSoggettoAttuatore;
  }
  public void setIdSoggettoAttuatore(Long idSoggettoAttuatore) {
    this.idSoggettoAttuatore = idSoggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("numProgrSportello")
  public Integer getNumProgrSportello() {
    return numProgrSportello;
  }
  public void setNumProgrSportello(Integer numProgrSportello) {
    this.numProgrSportello = numProgrSportello;
  }

  /**
   **/
  
  @JsonProperty("gruppoOperatore")
  public String getGruppoOperatore() {
    return gruppoOperatore;
  }
  public void setGruppoOperatore(String gruppoOperatore) {
    this.gruppoOperatore = gruppoOperatore;
  }

  /**
   **/
  
  @JsonProperty("modelId")
  public Integer getModelId() {
    return modelId;
  }
  public void setModelId(Integer modelId) {
    this.modelId = modelId;
  }

  /**
   **/
  
  @JsonProperty("codOperatore")
  public Integer getCodOperatore() {
    return codOperatore;
  }
  public void setCodOperatore(Integer codOperatore) {
    this.codOperatore = codOperatore;
  }

  /**
   **/
  
  @JsonProperty("denominazioneGiuridica")
  public String getDenominazioneGiuridica() {
    return denominazioneGiuridica;
  }
  public void setDenominazioneGiuridica(String denominazioneGiuridica) {
    this.denominazioneGiuridica = denominazioneGiuridica;
  }

  /**
   **/
  
  @JsonProperty("flgCapofila")
  public String getFlgCapofila() {
    return flgCapofila;
  }
  public void setFlgCapofila(String flgCapofila) {
    this.flgCapofila = flgCapofila;
  }

  /**
   **/
  
  @JsonProperty("dataInserimento")
  public Date getDataInserimento() {
    return dataInserimento;
  }
  public void setDataInserimento(Date dataInserimento) {
    this.dataInserimento = dataInserimento;
  }

  /**
   **/
  
  @JsonProperty("descrAreaTerritoriale")
  public String getDescrAreaTerritoriale() {
    return descrAreaTerritoriale;
  }
  public void setDescrAreaTerritoriale(String descrAreaTerritoriale) {
    this.descrAreaTerritoriale = descrAreaTerritoriale;
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
  
  @JsonProperty("dataAggiornamento")
  public Date getDataAggiornamento() {
    return dataAggiornamento;
  }
  public void setDataAggiornamento(Date dataAggiornamento) {
    this.dataAggiornamento = dataAggiornamento;
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
    SoggettoAttuatore soggettoAttuatore = (SoggettoAttuatore) o;
    return Objects.equals(idSoggettoAttuatore, soggettoAttuatore.idSoggettoAttuatore) &&
        Objects.equals(numProgrSportello, soggettoAttuatore.numProgrSportello) &&
        Objects.equals(gruppoOperatore, soggettoAttuatore.gruppoOperatore) &&
        Objects.equals(modelId, soggettoAttuatore.modelId) &&
        Objects.equals(codOperatore, soggettoAttuatore.codOperatore) &&
        Objects.equals(denominazioneGiuridica, soggettoAttuatore.denominazioneGiuridica) &&
        Objects.equals(flgCapofila, soggettoAttuatore.flgCapofila) &&
        Objects.equals(dataInserimento, soggettoAttuatore.dataInserimento) &&
        Objects.equals(descrAreaTerritoriale, soggettoAttuatore.descrAreaTerritoriale) &&
        Objects.equals(codUserInserimento, soggettoAttuatore.codUserInserimento) &&
        Objects.equals(dataAggiornamento, soggettoAttuatore.dataAggiornamento) &&
        Objects.equals(codUserAggiornamento, soggettoAttuatore.codUserAggiornamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idSoggettoAttuatore, numProgrSportello, gruppoOperatore, modelId, codOperatore, denominazioneGiuridica, flgCapofila, dataInserimento, descrAreaTerritoriale, codUserInserimento, dataAggiornamento, codUserAggiornamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoggettoAttuatore {\n");
    
    sb.append("    idSoggettoAttuatore: ").append(toIndentedString(idSoggettoAttuatore)).append("\n");
    sb.append("    numProgrSportello: ").append(toIndentedString(numProgrSportello)).append("\n");
    sb.append("    gruppoOperatore: ").append(toIndentedString(gruppoOperatore)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    codOperatore: ").append(toIndentedString(codOperatore)).append("\n");
    sb.append("    denominazioneGiuridica: ").append(toIndentedString(denominazioneGiuridica)).append("\n");
    sb.append("    flgCapofila: ").append(toIndentedString(flgCapofila)).append("\n");
    sb.append("    dataInserimento: ").append(toIndentedString(dataInserimento)).append("\n");
    sb.append("    descrAreaTerritoriale: ").append(toIndentedString(descrAreaTerritoriale)).append("\n");
    sb.append("    codUserInserimento: ").append(toIndentedString(codUserInserimento)).append("\n");
    sb.append("    dataAggiornamento: ").append(toIndentedString(dataAggiornamento)).append("\n");
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
