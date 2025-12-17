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

public class Bacino   {
  private Long codBacino = null;
  private String descrizione = null;
  private String codProv = null;

  /**
   **/
  
  @JsonProperty("codBacino")
  public Long getCodBacino() {
    return codBacino;
  }
  public void setCodBacino(Long codBacino) {
    this.codBacino = codBacino;
  }

  /**
   **/
  
  @JsonProperty("descrizione")
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   **/
  
  @JsonProperty("codProv")
  public String getCodProv() {
    return codProv;
  }
  public void setCodProv(String codProv) {
    this.codProv = codProv;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bacino bacino = (Bacino) o;
    return Objects.equals(codBacino, bacino.codBacino) &&
        Objects.equals(descrizione, bacino.descrizione) &&
        Objects.equals(codProv, bacino.codProv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codBacino, descrizione, codProv);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bacino {\n");
    
    sb.append("    codBacino: ").append(toIndentedString(codBacino)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    codProv: ").append(toIndentedString(codProv)).append("\n");
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
