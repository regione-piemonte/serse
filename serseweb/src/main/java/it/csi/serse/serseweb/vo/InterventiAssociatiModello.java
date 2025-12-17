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

public class InterventiAssociatiModello   {
  private Long idModelloIntervento = null;
  private Integer numInterventiAssociati = null;

  /**
   **/
  
  @JsonProperty("idModelloIntervento")
  public Long getIdModelloIntervento() {
    return idModelloIntervento;
  }
  public void setIdModelloIntervento(Long idModelloIntervento) {
    this.idModelloIntervento = idModelloIntervento;
  }

  /**
   **/
  
  @JsonProperty("numInterventiAssociati")
  public Integer getNumInterventiAssociati() {
    return numInterventiAssociati;
  }
  public void setNumInterventiAssociati(Integer numInterventiAssociati) {
    this.numInterventiAssociati = numInterventiAssociati;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InterventiAssociatiModello interventiAssociatiModello = (InterventiAssociatiModello) o;
    return Objects.equals(idModelloIntervento, interventiAssociatiModello.idModelloIntervento) &&
        Objects.equals(numInterventiAssociati, interventiAssociatiModello.numInterventiAssociati);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idModelloIntervento, numInterventiAssociati);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterventiAssociatiModello {\n");
    
    sb.append("    idModelloIntervento: ").append(toIndentedString(idModelloIntervento)).append("\n");
    sb.append("    numInterventiAssociati: ").append(toIndentedString(numInterventiAssociati)).append("\n");
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
