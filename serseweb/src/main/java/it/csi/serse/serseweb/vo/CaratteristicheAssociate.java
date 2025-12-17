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
import it.csi.serse.serseweb.vo.Caratteristica;
import jakarta.validation.constraints.*;

public class CaratteristicheAssociate   {
  private Long idPso = null;
  private Long idModelloDiIntervento = null;
  private String codiceFiscaleUtente = null;
  private Caratteristica caratteristica = null;

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
  
  @JsonProperty("idModelloDiIntervento")
  public Long getIdModelloDiIntervento() {
    return idModelloDiIntervento;
  }
  public void setIdModelloDiIntervento(Long idModelloDiIntervento) {
    this.idModelloDiIntervento = idModelloDiIntervento;
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
  
  @JsonProperty("caratteristica")
  public Caratteristica getCaratteristica() {
    return caratteristica;
  }
  public void setCaratteristica(Caratteristica caratteristica) {
    this.caratteristica = caratteristica;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CaratteristicheAssociate caratteristicheAssociate = (CaratteristicheAssociate) o;
    return Objects.equals(idPso, caratteristicheAssociate.idPso) &&
        Objects.equals(idModelloDiIntervento, caratteristicheAssociate.idModelloDiIntervento) &&
        Objects.equals(codiceFiscaleUtente, caratteristicheAssociate.codiceFiscaleUtente) &&
        Objects.equals(caratteristica, caratteristicheAssociate.caratteristica);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPso, idModelloDiIntervento, codiceFiscaleUtente, caratteristica);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaratteristicheAssociate {\n");
    
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idModelloDiIntervento: ").append(toIndentedString(idModelloDiIntervento)).append("\n");
    sb.append("    codiceFiscaleUtente: ").append(toIndentedString(codiceFiscaleUtente)).append("\n");
    sb.append("    caratteristica: ").append(toIndentedString(caratteristica)).append("\n");
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
