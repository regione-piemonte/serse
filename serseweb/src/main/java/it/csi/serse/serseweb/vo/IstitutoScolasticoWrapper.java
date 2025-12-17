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
import it.csi.serse.serseweb.vo.IstitutoScolastico;
import jakarta.validation.constraints.*;

public class IstitutoScolasticoWrapper   {
  private IstitutoScolastico istitutoScolastico = null;
  private String codiceRegionaleAutonomia = null;
  private String denominazioneAutonomia = null;

  /**
   **/
  
  @JsonProperty("istitutoScolastico")
  public IstitutoScolastico getIstitutoScolastico() {
    return istitutoScolastico;
  }
  public void setIstitutoScolastico(IstitutoScolastico istitutoScolastico) {
    this.istitutoScolastico = istitutoScolastico;
  }

  /**
   **/
  
  @JsonProperty("codiceRegionaleAutonomia")
  public String getCodiceRegionaleAutonomia() {
    return codiceRegionaleAutonomia;
  }
  public void setCodiceRegionaleAutonomia(String codiceRegionaleAutonomia) {
    this.codiceRegionaleAutonomia = codiceRegionaleAutonomia;
  }

  /**
   **/
  
  @JsonProperty("denominazioneAutonomia")
  public String getDenominazioneAutonomia() {
    return denominazioneAutonomia;
  }
  public void setDenominazioneAutonomia(String denominazioneAutonomia) {
    this.denominazioneAutonomia = denominazioneAutonomia;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IstitutoScolasticoWrapper istitutoScolasticoWrapper = (IstitutoScolasticoWrapper) o;
    return Objects.equals(istitutoScolastico, istitutoScolasticoWrapper.istitutoScolastico) &&
        Objects.equals(codiceRegionaleAutonomia, istitutoScolasticoWrapper.codiceRegionaleAutonomia) &&
        Objects.equals(denominazioneAutonomia, istitutoScolasticoWrapper.denominazioneAutonomia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(istitutoScolastico, codiceRegionaleAutonomia, denominazioneAutonomia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IstitutoScolasticoWrapper {\n");
    
    sb.append("    istitutoScolastico: ").append(toIndentedString(istitutoScolastico)).append("\n");
    sb.append("    codiceRegionaleAutonomia: ").append(toIndentedString(codiceRegionaleAutonomia)).append("\n");
    sb.append("    denominazioneAutonomia: ").append(toIndentedString(denominazioneAutonomia)).append("\n");
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
