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
import it.csi.serse.serseweb.vo.DestinatarioServizio;
import jakarta.validation.constraints.*;

public class DestinatarioServizioCaricato   {
  private DestinatarioServizio destinatarioServizio = null;
  private String stato = null;
  private String description = null;

  /**
   **/
  
  @JsonProperty("destinatarioServizio")
  public DestinatarioServizio getDestinatarioServizio() {
    return destinatarioServizio;
  }
  public void setDestinatarioServizio(DestinatarioServizio destinatarioServizio) {
    this.destinatarioServizio = destinatarioServizio;
  }

  /**
   **/
  
  @JsonProperty("stato")
  public String getStato() {
    return stato;
  }
  public void setStato(String stato) {
    this.stato = stato;
  }

  /**
   **/
  
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinatarioServizioCaricato destinatarioServizioCaricato = (DestinatarioServizioCaricato) o;
    return Objects.equals(destinatarioServizio, destinatarioServizioCaricato.destinatarioServizio) &&
        Objects.equals(stato, destinatarioServizioCaricato.stato) &&
        Objects.equals(description, destinatarioServizioCaricato.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinatarioServizio, stato, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinatarioServizioCaricato {\n");
    
    sb.append("    destinatarioServizio: ").append(toIndentedString(destinatarioServizio)).append("\n");
    sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
