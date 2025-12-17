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

public class FonteDato   {
  private Boolean idFonteDato1 = null;
  private Boolean idFonteDato2 = null;
  private Boolean idFonteDato3 = null;

  /**
   **/
  
  @JsonProperty("idFonteDato1")
  public Boolean isIdFonteDato1() {
    return idFonteDato1;
  }
  public void setIdFonteDato1(Boolean idFonteDato1) {
    this.idFonteDato1 = idFonteDato1;
  }

  /**
   **/
  
  @JsonProperty("idFonteDato2")
  public Boolean isIdFonteDato2() {
    return idFonteDato2;
  }
  public void setIdFonteDato2(Boolean idFonteDato2) {
    this.idFonteDato2 = idFonteDato2;
  }

  /**
   **/
  
  @JsonProperty("idFonteDato3")
  public Boolean isIdFonteDato3() {
    return idFonteDato3;
  }
  public void setIdFonteDato3(Boolean idFonteDato3) {
    this.idFonteDato3 = idFonteDato3;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FonteDato fonteDato = (FonteDato) o;
    return Objects.equals(idFonteDato1, fonteDato.idFonteDato1) &&
        Objects.equals(idFonteDato2, fonteDato.idFonteDato2) &&
        Objects.equals(idFonteDato3, fonteDato.idFonteDato3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idFonteDato1, idFonteDato2, idFonteDato3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FonteDato {\n");
    
    sb.append("    idFonteDato1: ").append(toIndentedString(idFonteDato1)).append("\n");
    sb.append("    idFonteDato2: ").append(toIndentedString(idFonteDato2)).append("\n");
    sb.append("    idFonteDato3: ").append(toIndentedString(idFonteDato3)).append("\n");
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
