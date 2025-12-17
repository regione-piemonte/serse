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
import it.csi.serse.serseweb.vo.TargetDestinatario;
import jakarta.validation.constraints.*;

public class TargetDestinatariServizio   {
  private Long idPso = null;
  private Long idServizio = null;
  private String codiceFiscaleUtente = null;
  private TargetDestinatario targetdestinatario = null;

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
  
  @JsonProperty("idServizio")
  public Long getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(Long idServizio) {
    this.idServizio = idServizio;
  }

  /**
   **/
  
  @JsonProperty("codiceFiscaleUtente")
  public String getCodiceFiscaleUtente() {
    return codiceFiscaleUtente;
  }
  public void setCodiceFiscaleUtente(String codiceFiscaleUtente) {
    this.codiceFiscaleUtente = codiceFiscaleUtente;
  }

  /**
   **/
  
  @JsonProperty("targetdestinatario")
  public TargetDestinatario getTargetdestinatario() {
    return targetdestinatario;
  }
  public void setTargetdestinatario(TargetDestinatario targetdestinatario) {
    this.targetdestinatario = targetdestinatario;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TargetDestinatariServizio targetDestinatariServizio = (TargetDestinatariServizio) o;
    return Objects.equals(idPso, targetDestinatariServizio.idPso) &&
        Objects.equals(idServizio, targetDestinatariServizio.idServizio) &&
        Objects.equals(codiceFiscaleUtente, targetDestinatariServizio.codiceFiscaleUtente) &&
        Objects.equals(targetdestinatario, targetDestinatariServizio.targetdestinatario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPso, idServizio, codiceFiscaleUtente, targetdestinatario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TargetDestinatariServizio {\n");
    
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    codiceFiscaleUtente: ").append(toIndentedString(codiceFiscaleUtente)).append("\n");
    sb.append("    targetdestinatario: ").append(toIndentedString(targetdestinatario)).append("\n");
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
