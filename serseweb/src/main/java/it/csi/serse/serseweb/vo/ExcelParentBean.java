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

public class ExcelParentBean   {
  private String soggBeneficiario = null;
  private String soggAttuatore = null;
  private Long modelId = null;
  private String entiCoinvolti = null;
  private String cfUtenteInserimento = null;
  private String cfUtenteAggiornamento = null;

  /**
   **/
  
  @JsonProperty("soggBeneficiario")
  public String getSoggBeneficiario() {
    return soggBeneficiario;
  }
  public void setSoggBeneficiario(String soggBeneficiario) {
    this.soggBeneficiario = soggBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("soggAttuatore")
  public String getSoggAttuatore() {
    return soggAttuatore;
  }
  public void setSoggAttuatore(String soggAttuatore) {
    this.soggAttuatore = soggAttuatore;
  }

  /**
   **/
  
  @JsonProperty("modelId")
  public Long getModelId() {
    return modelId;
  }
  public void setModelId(Long modelId) {
    this.modelId = modelId;
  }

  /**
   **/
  
  @JsonProperty("entiCoinvolti")
  public String getEntiCoinvolti() {
    return entiCoinvolti;
  }
  public void setEntiCoinvolti(String entiCoinvolti) {
    this.entiCoinvolti = entiCoinvolti;
  }

  /**
   **/
  
  @JsonProperty("cfUtenteInserimento")
  public String getCfUtenteInserimento() {
    return cfUtenteInserimento;
  }
  public void setCfUtenteInserimento(String cfUtenteInserimento) {
    this.cfUtenteInserimento = cfUtenteInserimento;
  }

  /**
   **/
  
  @JsonProperty("cfUtenteAggiornamento")
  public String getCfUtenteAggiornamento() {
    return cfUtenteAggiornamento;
  }
  public void setCfUtenteAggiornamento(String cfUtenteAggiornamento) {
    this.cfUtenteAggiornamento = cfUtenteAggiornamento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExcelParentBean excelParentBean = (ExcelParentBean) o;
    return Objects.equals(soggBeneficiario, excelParentBean.soggBeneficiario) &&
        Objects.equals(soggAttuatore, excelParentBean.soggAttuatore) &&
        Objects.equals(modelId, excelParentBean.modelId) &&
        Objects.equals(entiCoinvolti, excelParentBean.entiCoinvolti) &&
        Objects.equals(cfUtenteInserimento, excelParentBean.cfUtenteInserimento) &&
        Objects.equals(cfUtenteAggiornamento, excelParentBean.cfUtenteAggiornamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(soggBeneficiario, soggAttuatore, modelId, entiCoinvolti, cfUtenteInserimento, cfUtenteAggiornamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcelParentBean {\n");
    
    sb.append("    soggBeneficiario: ").append(toIndentedString(soggBeneficiario)).append("\n");
    sb.append("    soggAttuatore: ").append(toIndentedString(soggAttuatore)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    entiCoinvolti: ").append(toIndentedString(entiCoinvolti)).append("\n");
    sb.append("    cfUtenteInserimento: ").append(toIndentedString(cfUtenteInserimento)).append("\n");
    sb.append("    cfUtenteAggiornamento: ").append(toIndentedString(cfUtenteAggiornamento)).append("\n");
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
