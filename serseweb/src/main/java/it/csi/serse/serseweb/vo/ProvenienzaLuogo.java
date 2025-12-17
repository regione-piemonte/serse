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

public class ProvenienzaLuogo   {
  private Long idProvenienzaLuogo = null;
  private String descrProvenienzaLuogo = null;
  private Long idPso = null;
  private Long idFonteDato = null;
  private String descrFonteDato = null;

  /**
   **/
  
  @JsonProperty("idProvenienzaLuogo")
  public Long getIdProvenienzaLuogo() {
    return idProvenienzaLuogo;
  }
  public void setIdProvenienzaLuogo(Long idProvenienzaLuogo) {
    this.idProvenienzaLuogo = idProvenienzaLuogo;
  }

  /**
   **/
  
  @JsonProperty("descrProvenienzaLuogo")
  public String getDescrProvenienzaLuogo() {
    return descrProvenienzaLuogo;
  }
  public void setDescrProvenienzaLuogo(String descrProvenienzaLuogo) {
    this.descrProvenienzaLuogo = descrProvenienzaLuogo;
  }

  /**
   **/
  
  @JsonProperty("idPso")
  public Long getIdPso() {
    return idPso;
  }
  public void setIdPso(Long idPso) {
    this.idPso = idPso;
  }

  /**
   **/
  
  @JsonProperty("idFonteDato")
  public Long getIdFonteDato() {
    return idFonteDato;
  }
  public void setIdFonteDato(Long idFonteDato) {
    this.idFonteDato = idFonteDato;
  }

  /**
   **/
  
  @JsonProperty("descrFonteDato")
  public String getDescrFonteDato() {
    return descrFonteDato;
  }
  public void setDescrFonteDato(String descrFonteDato) {
    this.descrFonteDato = descrFonteDato;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvenienzaLuogo provenienzaLuogo = (ProvenienzaLuogo) o;
    return Objects.equals(idProvenienzaLuogo, provenienzaLuogo.idProvenienzaLuogo) &&
        Objects.equals(descrProvenienzaLuogo, provenienzaLuogo.descrProvenienzaLuogo) &&
        Objects.equals(idPso, provenienzaLuogo.idPso) &&
        Objects.equals(idFonteDato, provenienzaLuogo.idFonteDato) &&
        Objects.equals(descrFonteDato, provenienzaLuogo.descrFonteDato);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idProvenienzaLuogo, descrProvenienzaLuogo, idPso, idFonteDato, descrFonteDato);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvenienzaLuogo {\n");
    
    sb.append("    idProvenienzaLuogo: ").append(toIndentedString(idProvenienzaLuogo)).append("\n");
    sb.append("    descrProvenienzaLuogo: ").append(toIndentedString(descrProvenienzaLuogo)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idFonteDato: ").append(toIndentedString(idFonteDato)).append("\n");
    sb.append("    descrFonteDato: ").append(toIndentedString(descrFonteDato)).append("\n");
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
