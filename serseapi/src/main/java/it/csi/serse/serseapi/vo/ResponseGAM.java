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
import it.csi.serse.serseapi.vo.ServizioFonte;
import it.csi.serse.serseapi.vo.VociSpesaServizio;
import java.util.List;
import jakarta.validation.constraints.*;

public class ResponseGAM   {
  private List<VociSpesaServizio> vociSpesa = new ArrayList<VociSpesaServizio>();
  private List<ServizioFonte> fontiServizio = new ArrayList<ServizioFonte>();

  /**
   **/
  
  @JsonProperty("vociSpesa")
  public List<VociSpesaServizio> getVociSpesa() {
    return vociSpesa;
  }
  public void setVociSpesa(List<VociSpesaServizio> vociSpesa) {
    this.vociSpesa = vociSpesa;
  }

  /**
   **/
  
  @JsonProperty("fontiServizio")
  public List<ServizioFonte> getFontiServizio() {
    return fontiServizio;
  }
  public void setFontiServizio(List<ServizioFonte> fontiServizio) {
    this.fontiServizio = fontiServizio;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseGAM responseGAM = (ResponseGAM) o;
    return Objects.equals(vociSpesa, responseGAM.vociSpesa) &&
        Objects.equals(fontiServizio, responseGAM.fontiServizio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vociSpesa, fontiServizio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseGAM {\n");
    
    sb.append("    vociSpesa: ").append(toIndentedString(vociSpesa)).append("\n");
    sb.append("    fontiServizio: ").append(toIndentedString(fontiServizio)).append("\n");
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
