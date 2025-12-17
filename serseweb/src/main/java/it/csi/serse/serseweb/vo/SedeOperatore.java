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
import it.csi.serse.serseweb.vo.Comune;
import jakarta.validation.constraints.*;

public class SedeOperatore   {
  private Integer idSede = null;
  private String denominazioneSede = null;
  private String indirizzoSede = null;
  private Comune comune = null;

  /**
   **/
  
  @JsonProperty("idSede")
  public Integer getIdSede() {
    return idSede;
  }
  public void setIdSede(Integer idSede) {
    this.idSede = idSede;
  }

  /**
   **/
  
  @JsonProperty("denominazioneSede")
  public String getDenominazioneSede() {
    return denominazioneSede;
  }
  public void setDenominazioneSede(String denominazioneSede) {
    this.denominazioneSede = denominazioneSede;
  }

  /**
   **/
  
  @JsonProperty("indirizzoSede")
  public String getIndirizzoSede() {
    return indirizzoSede;
  }
  public void setIndirizzoSede(String indirizzoSede) {
    this.indirizzoSede = indirizzoSede;
  }

  /**
   **/
  
  @JsonProperty("comune")
  public Comune getComune() {
    return comune;
  }
  public void setComune(Comune comune) {
    this.comune = comune;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SedeOperatore sedeOperatore = (SedeOperatore) o;
    return Objects.equals(idSede, sedeOperatore.idSede) &&
        Objects.equals(denominazioneSede, sedeOperatore.denominazioneSede) &&
        Objects.equals(indirizzoSede, sedeOperatore.indirizzoSede) &&
        Objects.equals(comune, sedeOperatore.comune);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idSede, denominazioneSede, indirizzoSede, comune);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SedeOperatore {\n");
    
    sb.append("    idSede: ").append(toIndentedString(idSede)).append("\n");
    sb.append("    denominazioneSede: ").append(toIndentedString(denominazioneSede)).append("\n");
    sb.append("    indirizzoSede: ").append(toIndentedString(indirizzoSede)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
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
