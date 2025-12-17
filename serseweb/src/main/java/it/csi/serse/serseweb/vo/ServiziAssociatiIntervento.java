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

public class ServiziAssociatiIntervento   {
  private Long idIntervento = null;
  private Integer numServiziAssociati = null;
  private Integer numServiziChiusi = null;

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
  
  @JsonProperty("numServiziAssociati")
  public Integer getNumServiziAssociati() {
    return numServiziAssociati;
  }
  public void setNumServiziAssociati(Integer numServiziAssociati) {
    this.numServiziAssociati = numServiziAssociati;
  }

  /**
   **/
  
  @JsonProperty("numServiziChiusi")
  public Integer getNumServiziChiusi() {
    return numServiziChiusi;
  }
  public void setNumServiziChiusi(Integer numServiziChiusi) {
    this.numServiziChiusi = numServiziChiusi;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiziAssociatiIntervento serviziAssociatiIntervento = (ServiziAssociatiIntervento) o;
    return Objects.equals(idIntervento, serviziAssociatiIntervento.idIntervento) &&
        Objects.equals(numServiziAssociati, serviziAssociatiIntervento.numServiziAssociati) &&
        Objects.equals(numServiziChiusi, serviziAssociatiIntervento.numServiziChiusi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIntervento, numServiziAssociati, numServiziChiusi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiziAssociatiIntervento {\n");
    
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    numServiziAssociati: ").append(toIndentedString(numServiziAssociati)).append("\n");
    sb.append("    numServiziChiusi: ").append(toIndentedString(numServiziChiusi)).append("\n");
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
