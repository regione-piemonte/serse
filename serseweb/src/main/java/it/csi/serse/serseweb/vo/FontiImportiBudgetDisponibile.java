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
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class FontiImportiBudgetDisponibile   {
  private Long idFonte = null;
  private Long idOccorrenzaTabellaFinanziamento = null;
  private BigDecimal importoStanziatoFonte = null;
  private BigDecimal importoUtilizzatoFonte = null;
  private BigDecimal importoResiduoFonte = null;

  /**
   **/
  
  @JsonProperty("idFonte")
  public Long getIdFonte() {
    return idFonte;
  }
  public void setIdFonte(Long idFonte) {
    this.idFonte = idFonte;
  }

  /**
   **/
  
  @JsonProperty("idOccorrenzaTabellaFinanziamento")
  public Long getIdOccorrenzaTabellaFinanziamento() {
    return idOccorrenzaTabellaFinanziamento;
  }
  public void setIdOccorrenzaTabellaFinanziamento(Long idOccorrenzaTabellaFinanziamento) {
    this.idOccorrenzaTabellaFinanziamento = idOccorrenzaTabellaFinanziamento;
  }

  /**
   **/
  
  @JsonProperty("importoStanziatoFonte")
  public BigDecimal getImportoStanziatoFonte() {
    return importoStanziatoFonte;
  }
  public void setImportoStanziatoFonte(BigDecimal importoStanziatoFonte) {
    this.importoStanziatoFonte = importoStanziatoFonte;
  }

  /**
   **/
  
  @JsonProperty("importoUtilizzatoFonte")
  public BigDecimal getImportoUtilizzatoFonte() {
    return importoUtilizzatoFonte;
  }
  public void setImportoUtilizzatoFonte(BigDecimal importoUtilizzatoFonte) {
    this.importoUtilizzatoFonte = importoUtilizzatoFonte;
  }

  /**
   **/
  
  @JsonProperty("importoResiduoFonte")
  public BigDecimal getImportoResiduoFonte() {
    return importoResiduoFonte;
  }
  public void setImportoResiduoFonte(BigDecimal importoResiduoFonte) {
    this.importoResiduoFonte = importoResiduoFonte;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FontiImportiBudgetDisponibile fontiImportiBudgetDisponibile = (FontiImportiBudgetDisponibile) o;
    return Objects.equals(idFonte, fontiImportiBudgetDisponibile.idFonte) &&
        Objects.equals(idOccorrenzaTabellaFinanziamento, fontiImportiBudgetDisponibile.idOccorrenzaTabellaFinanziamento) &&
        Objects.equals(importoStanziatoFonte, fontiImportiBudgetDisponibile.importoStanziatoFonte) &&
        Objects.equals(importoUtilizzatoFonte, fontiImportiBudgetDisponibile.importoUtilizzatoFonte) &&
        Objects.equals(importoResiduoFonte, fontiImportiBudgetDisponibile.importoResiduoFonte);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idFonte, idOccorrenzaTabellaFinanziamento, importoStanziatoFonte, importoUtilizzatoFonte, importoResiduoFonte);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FontiImportiBudgetDisponibile {\n");
    
    sb.append("    idFonte: ").append(toIndentedString(idFonte)).append("\n");
    sb.append("    idOccorrenzaTabellaFinanziamento: ").append(toIndentedString(idOccorrenzaTabellaFinanziamento)).append("\n");
    sb.append("    importoStanziatoFonte: ").append(toIndentedString(importoStanziatoFonte)).append("\n");
    sb.append("    importoUtilizzatoFonte: ").append(toIndentedString(importoUtilizzatoFonte)).append("\n");
    sb.append("    importoResiduoFonte: ").append(toIndentedString(importoResiduoFonte)).append("\n");
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
