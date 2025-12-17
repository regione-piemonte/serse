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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import it.csi.serse.serseweb.vo.TargetDestinatarioFlaggato;
import java.util.List;
import jakarta.validation.constraints.*;

public class TargetDestinatariPerModifica   {
  private Integer idPso = null;
  private Integer idModelloDiIntervento = null;
  private List<TargetDestinatarioFlaggato> targetdestinatari = new ArrayList<TargetDestinatarioFlaggato>();

  /**
   **/
  
  @JsonProperty("idPso")
  public Integer getIdPso() {
    return idPso;
  }
  public void setIdPso(Integer idPso) {
    this.idPso = idPso;
  }

  /**
   **/
  
  @JsonProperty("idModelloDiIntervento")
  public Integer getIdModelloDiIntervento() {
    return idModelloDiIntervento;
  }
  public void setIdModelloDiIntervento(Integer idModelloDiIntervento) {
    this.idModelloDiIntervento = idModelloDiIntervento;
  }

  /**
   **/
  
  @JsonProperty("targetdestinatari")
  public List<TargetDestinatarioFlaggato> getTargetdestinatari() {
    return targetdestinatari;
  }
  public void setTargetdestinatari(List<TargetDestinatarioFlaggato> targetdestinatari) {
    this.targetdestinatari = targetdestinatari;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TargetDestinatariPerModifica targetDestinatariPerModifica = (TargetDestinatariPerModifica) o;
    return Objects.equals(idPso, targetDestinatariPerModifica.idPso) &&
        Objects.equals(idModelloDiIntervento, targetDestinatariPerModifica.idModelloDiIntervento) &&
        Objects.equals(targetdestinatari, targetDestinatariPerModifica.targetdestinatari);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPso, idModelloDiIntervento, targetdestinatari);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TargetDestinatariPerModifica {\n");
    
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idModelloDiIntervento: ").append(toIndentedString(idModelloDiIntervento)).append("\n");
    sb.append("    targetdestinatari: ").append(toIndentedString(targetdestinatari)).append("\n");
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
