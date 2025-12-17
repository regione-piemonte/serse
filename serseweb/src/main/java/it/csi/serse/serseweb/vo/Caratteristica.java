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

public class Caratteristica   {
  private Long idCaratteristica = null;
  private String descrCaratteristica = null;

  /**
   **/
  
  @JsonProperty("idCaratteristica")
  public Long getIdCaratteristica() {
    return idCaratteristica;
  }
  public void setIdCaratteristica(Long idCaratteristica) {
    this.idCaratteristica = idCaratteristica;
  }

  /**
   **/
  
  @JsonProperty("descrCaratteristica")
  public String getDescrCaratteristica() {
    return descrCaratteristica;
  }
  public void setDescrCaratteristica(String descrCaratteristica) {
    this.descrCaratteristica = descrCaratteristica;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Caratteristica caratteristica = (Caratteristica) o;
    return Objects.equals(idCaratteristica, caratteristica.idCaratteristica) &&
        Objects.equals(descrCaratteristica, caratteristica.descrCaratteristica);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCaratteristica, descrCaratteristica);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Caratteristica {\n");
    
    sb.append("    idCaratteristica: ").append(toIndentedString(idCaratteristica)).append("\n");
    sb.append("    descrCaratteristica: ").append(toIndentedString(descrCaratteristica)).append("\n");
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
