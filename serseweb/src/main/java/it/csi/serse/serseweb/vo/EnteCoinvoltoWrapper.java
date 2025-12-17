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
import it.csi.serse.serseweb.vo.EnteCoinvoltoIntervento;
import it.csi.serse.serseweb.vo.EnteCoinvoltoModello;
import it.csi.serse.serseweb.vo.EnteCoinvoltoServizio;
import jakarta.validation.constraints.*;

public class EnteCoinvoltoWrapper   {
  private EnteCoinvoltoModello enteCoinvoltoModello = null;
  private EnteCoinvoltoIntervento enteCoinvoltoIntervento = null;
  private EnteCoinvoltoServizio enteCoinvoltoServizio = null;

  /**
   **/
  
  @JsonProperty("enteCoinvoltoModello")
  public EnteCoinvoltoModello getEnteCoinvoltoModello() {
    return enteCoinvoltoModello;
  }
  public void setEnteCoinvoltoModello(EnteCoinvoltoModello enteCoinvoltoModello) {
    this.enteCoinvoltoModello = enteCoinvoltoModello;
  }

  /**
   **/
  
  @JsonProperty("enteCoinvoltoIntervento")
  public EnteCoinvoltoIntervento getEnteCoinvoltoIntervento() {
    return enteCoinvoltoIntervento;
  }
  public void setEnteCoinvoltoIntervento(EnteCoinvoltoIntervento enteCoinvoltoIntervento) {
    this.enteCoinvoltoIntervento = enteCoinvoltoIntervento;
  }

  /**
   **/
  
  @JsonProperty("enteCoinvoltoServizio")
  public EnteCoinvoltoServizio getEnteCoinvoltoServizio() {
    return enteCoinvoltoServizio;
  }
  public void setEnteCoinvoltoServizio(EnteCoinvoltoServizio enteCoinvoltoServizio) {
    this.enteCoinvoltoServizio = enteCoinvoltoServizio;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnteCoinvoltoWrapper enteCoinvoltoWrapper = (EnteCoinvoltoWrapper) o;
    return Objects.equals(enteCoinvoltoModello, enteCoinvoltoWrapper.enteCoinvoltoModello) &&
        Objects.equals(enteCoinvoltoIntervento, enteCoinvoltoWrapper.enteCoinvoltoIntervento) &&
        Objects.equals(enteCoinvoltoServizio, enteCoinvoltoWrapper.enteCoinvoltoServizio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enteCoinvoltoModello, enteCoinvoltoIntervento, enteCoinvoltoServizio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnteCoinvoltoWrapper {\n");
    
    sb.append("    enteCoinvoltoModello: ").append(toIndentedString(enteCoinvoltoModello)).append("\n");
    sb.append("    enteCoinvoltoIntervento: ").append(toIndentedString(enteCoinvoltoIntervento)).append("\n");
    sb.append("    enteCoinvoltoServizio: ").append(toIndentedString(enteCoinvoltoServizio)).append("\n");
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
