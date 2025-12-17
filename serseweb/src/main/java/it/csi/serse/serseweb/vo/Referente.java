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

public class Referente   {
  private String referenteNome = null;
  private String referenteCognome = null;
  private String referenteEmail = null;
  private String referenteTelefono = null;

  /**
   **/
  
  @JsonProperty("referenteNome")
  public String getReferenteNome() {
    return referenteNome;
  }
  public void setReferenteNome(String referenteNome) {
    this.referenteNome = referenteNome;
  }

  /**
   **/
  
  @JsonProperty("referenteCognome")
  public String getReferenteCognome() {
    return referenteCognome;
  }
  public void setReferenteCognome(String referenteCognome) {
    this.referenteCognome = referenteCognome;
  }

  /**
   **/
  
  @JsonProperty("referenteEmail")
  public String getReferenteEmail() {
    return referenteEmail;
  }
  public void setReferenteEmail(String referenteEmail) {
    this.referenteEmail = referenteEmail;
  }

  /**
   **/
  
  @JsonProperty("referenteTelefono")
  public String getReferenteTelefono() {
    return referenteTelefono;
  }
  public void setReferenteTelefono(String referenteTelefono) {
    this.referenteTelefono = referenteTelefono;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Referente referente = (Referente) o;
    return Objects.equals(referenteNome, referente.referenteNome) &&
        Objects.equals(referenteCognome, referente.referenteCognome) &&
        Objects.equals(referenteEmail, referente.referenteEmail) &&
        Objects.equals(referenteTelefono, referente.referenteTelefono);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referenteNome, referenteCognome, referenteEmail, referenteTelefono);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Referente {\n");
    
    sb.append("    referenteNome: ").append(toIndentedString(referenteNome)).append("\n");
    sb.append("    referenteCognome: ").append(toIndentedString(referenteCognome)).append("\n");
    sb.append("    referenteEmail: ").append(toIndentedString(referenteEmail)).append("\n");
    sb.append("    referenteTelefono: ").append(toIndentedString(referenteTelefono)).append("\n");
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
