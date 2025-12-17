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
import it.csi.serse.serseweb.vo.CriterioEqBool;
import it.csi.serse.serseweb.vo.CriterioEqInt;
import it.csi.serse.serseweb.vo.CriterioEqLong;
import it.csi.serse.serseweb.vo.CriterioEqStr;
import jakarta.validation.constraints.*;

public class FilterParent   {
  private CriterioEqLong numProgrSportello = null;
  private CriterioEqStr gruppoOperatore = null;
  private CriterioEqInt codOperatore = null;
  private CriterioEqStr gruppoOpBeneficiario = null;
  private CriterioEqInt codOpBeneficiario = null;
  private CriterioEqBool isProprietario = null;
  private CriterioEqLong modelId = null;

  /**
   **/
  
  @JsonProperty("numProgrSportello")
  @NotNull
  public CriterioEqLong getNumProgrSportello() {
    return numProgrSportello;
  }
  public void setNumProgrSportello(CriterioEqLong numProgrSportello) {
    this.numProgrSportello = numProgrSportello;
  }

  /**
   **/
  
  @JsonProperty("gruppoOperatore")
  @NotNull
  public CriterioEqStr getGruppoOperatore() {
    return gruppoOperatore;
  }
  public void setGruppoOperatore(CriterioEqStr gruppoOperatore) {
    this.gruppoOperatore = gruppoOperatore;
  }

  /**
   **/
  
  @JsonProperty("codOperatore")
  @NotNull
  public CriterioEqInt getCodOperatore() {
    return codOperatore;
  }
  public void setCodOperatore(CriterioEqInt codOperatore) {
    this.codOperatore = codOperatore;
  }

  /**
   **/
  
  @JsonProperty("gruppoOpBeneficiario")
  public CriterioEqStr getGruppoOpBeneficiario() {
    return gruppoOpBeneficiario;
  }
  public void setGruppoOpBeneficiario(CriterioEqStr gruppoOpBeneficiario) {
    this.gruppoOpBeneficiario = gruppoOpBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("codOpBeneficiario")
  public CriterioEqInt getCodOpBeneficiario() {
    return codOpBeneficiario;
  }
  public void setCodOpBeneficiario(CriterioEqInt codOpBeneficiario) {
    this.codOpBeneficiario = codOpBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("isProprietario")
  public CriterioEqBool getIsProprietario() {
    return isProprietario;
  }
  public void setIsProprietario(CriterioEqBool isProprietario) {
    this.isProprietario = isProprietario;
  }

  /**
   **/
  
  @JsonProperty("modelId")
  public CriterioEqLong getModelId() {
    return modelId;
  }
  public void setModelId(CriterioEqLong modelId) {
    this.modelId = modelId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterParent filterParent = (FilterParent) o;
    return Objects.equals(numProgrSportello, filterParent.numProgrSportello) &&
        Objects.equals(gruppoOperatore, filterParent.gruppoOperatore) &&
        Objects.equals(codOperatore, filterParent.codOperatore) &&
        Objects.equals(gruppoOpBeneficiario, filterParent.gruppoOpBeneficiario) &&
        Objects.equals(codOpBeneficiario, filterParent.codOpBeneficiario) &&
        Objects.equals(isProprietario, filterParent.isProprietario) &&
        Objects.equals(modelId, filterParent.modelId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numProgrSportello, gruppoOperatore, codOperatore, gruppoOpBeneficiario, codOpBeneficiario, isProprietario, modelId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterParent {\n");
    
    sb.append("    numProgrSportello: ").append(toIndentedString(numProgrSportello)).append("\n");
    sb.append("    gruppoOperatore: ").append(toIndentedString(gruppoOperatore)).append("\n");
    sb.append("    codOperatore: ").append(toIndentedString(codOperatore)).append("\n");
    sb.append("    gruppoOpBeneficiario: ").append(toIndentedString(gruppoOpBeneficiario)).append("\n");
    sb.append("    codOpBeneficiario: ").append(toIndentedString(codOpBeneficiario)).append("\n");
    sb.append("    isProprietario: ").append(toIndentedString(isProprietario)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
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
