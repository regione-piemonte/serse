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
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class VociSpesaServizio   {
  private String codVoceSpesa = null;
  private String naturaSpesa = null;
  private BigDecimal ucs = null;
  private BigDecimal durata = null;
  private Long nrDest = null;
  private BigDecimal importoVS = null;

  /**
   **/
  
  @JsonProperty("codVoceSpesa")
  public String getCodVoceSpesa() {
    return codVoceSpesa;
  }
  public void setCodVoceSpesa(String codVoceSpesa) {
    this.codVoceSpesa = codVoceSpesa;
  }

  /**
   **/
  
  @JsonProperty("naturaSpesa")
  public String getNaturaSpesa() {
    return naturaSpesa;
  }
  public void setNaturaSpesa(String naturaSpesa) {
    this.naturaSpesa = naturaSpesa;
  }

  /**
   **/
  
  @JsonProperty("ucs")
  public BigDecimal getUcs() {
    return ucs;
  }
  public void setUcs(BigDecimal ucs) {
    this.ucs = ucs;
  }

  /**
   **/
  
  @JsonProperty("durata")
  public BigDecimal getDurata() {
    return durata;
  }
  public void setDurata(BigDecimal durata) {
    this.durata = durata;
  }

  /**
   **/
  
  @JsonProperty("nrDest")
  public Long getNrDest() {
    return nrDest;
  }
  public void setNrDest(Long nrDest) {
    this.nrDest = nrDest;
  }

  /**
   **/
  
  @JsonProperty("importoVS")
  public BigDecimal getImportoVS() {
    return importoVS;
  }
  public void setImportoVS(BigDecimal importoVS) {
    this.importoVS = importoVS;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VociSpesaServizio vociSpesaServizio = (VociSpesaServizio) o;
    return Objects.equals(codVoceSpesa, vociSpesaServizio.codVoceSpesa) &&
        Objects.equals(naturaSpesa, vociSpesaServizio.naturaSpesa) &&
        Objects.equals(ucs, vociSpesaServizio.ucs) &&
        Objects.equals(durata, vociSpesaServizio.durata) &&
        Objects.equals(nrDest, vociSpesaServizio.nrDest) &&
        Objects.equals(importoVS, vociSpesaServizio.importoVS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codVoceSpesa, naturaSpesa, ucs, durata, nrDest, importoVS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VociSpesaServizio {\n");
    
    sb.append("    codVoceSpesa: ").append(toIndentedString(codVoceSpesa)).append("\n");
    sb.append("    naturaSpesa: ").append(toIndentedString(naturaSpesa)).append("\n");
    sb.append("    ucs: ").append(toIndentedString(ucs)).append("\n");
    sb.append("    durata: ").append(toIndentedString(durata)).append("\n");
    sb.append("    nrDest: ").append(toIndentedString(nrDest)).append("\n");
    sb.append("    importoVS: ").append(toIndentedString(importoVS)).append("\n");
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
