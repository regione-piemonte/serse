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
import it.csi.serse.serseweb.vo.AmministrazioneResponsabile;
import it.csi.serse.serseweb.vo.SelItem;
import jakarta.validation.constraints.*;

public class PsoRistretto   {
  private Long idPso = null;
  private AmministrazioneResponsabile ammResponsabili = null;
  private SelItem cicliFinanziari = null;

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
  
  @JsonProperty("ammResponsabili")
  public AmministrazioneResponsabile getAmmResponsabili() {
    return ammResponsabili;
  }
  public void setAmmResponsabili(AmministrazioneResponsabile ammResponsabili) {
    this.ammResponsabili = ammResponsabili;
  }

  /**
   **/
  
  @JsonProperty("cicliFinanziari")
  public SelItem getCicliFinanziari() {
    return cicliFinanziari;
  }
  public void setCicliFinanziari(SelItem cicliFinanziari) {
    this.cicliFinanziari = cicliFinanziari;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PsoRistretto psoRistretto = (PsoRistretto) o;
    return Objects.equals(idPso, psoRistretto.idPso) &&
        Objects.equals(ammResponsabili, psoRistretto.ammResponsabili) &&
        Objects.equals(cicliFinanziari, psoRistretto.cicliFinanziari);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPso, ammResponsabili, cicliFinanziari);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PsoRistretto {\n");
    
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    ammResponsabili: ").append(toIndentedString(ammResponsabili)).append("\n");
    sb.append("    cicliFinanziari: ").append(toIndentedString(cicliFinanziari)).append("\n");
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
