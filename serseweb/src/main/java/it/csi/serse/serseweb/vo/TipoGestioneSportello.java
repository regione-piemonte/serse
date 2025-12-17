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

public class TipoGestioneSportello   {
  private Long idGestione = null;
  private Long idPso = null;
  private Integer numProgrSportello = null;
  private String tipoGestioneSoggettiRt = null;
  private String flagGestioneModello = null;
  private String tipoGestioneIntervento = null;
  private String tipoGestioneServizio = null;

  /**
   **/
  
  @JsonProperty("idGestione")
  public Long getIdGestione() {
    return idGestione;
  }
  public void setIdGestione(Long idGestione) {
    this.idGestione = idGestione;
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
  
  @JsonProperty("numProgrSportello")
  public Integer getNumProgrSportello() {
    return numProgrSportello;
  }
  public void setNumProgrSportello(Integer numProgrSportello) {
    this.numProgrSportello = numProgrSportello;
  }

  /**
   * todo
   **/
  
  @JsonProperty("tipoGestioneSoggettiRt")
  public String getTipoGestioneSoggettiRt() {
    return tipoGestioneSoggettiRt;
  }
  public void setTipoGestioneSoggettiRt(String tipoGestioneSoggettiRt) {
    this.tipoGestioneSoggettiRt = tipoGestioneSoggettiRt;
  }

  /**
   * todo
   **/
  
  @JsonProperty("flagGestioneModello")
  public String getFlagGestioneModello() {
    return flagGestioneModello;
  }
  public void setFlagGestioneModello(String flagGestioneModello) {
    this.flagGestioneModello = flagGestioneModello;
  }

  /**
   * todo
   **/
  
  @JsonProperty("tipoGestioneIntervento")
  public String getTipoGestioneIntervento() {
    return tipoGestioneIntervento;
  }
  public void setTipoGestioneIntervento(String tipoGestioneIntervento) {
    this.tipoGestioneIntervento = tipoGestioneIntervento;
  }

  /**
   * todo
   **/
  
  @JsonProperty("tipoGestioneServizio")
  public String getTipoGestioneServizio() {
    return tipoGestioneServizio;
  }
  public void setTipoGestioneServizio(String tipoGestioneServizio) {
    this.tipoGestioneServizio = tipoGestioneServizio;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipoGestioneSportello tipoGestioneSportello = (TipoGestioneSportello) o;
    return Objects.equals(idGestione, tipoGestioneSportello.idGestione) &&
        Objects.equals(idPso, tipoGestioneSportello.idPso) &&
        Objects.equals(numProgrSportello, tipoGestioneSportello.numProgrSportello) &&
        Objects.equals(tipoGestioneSoggettiRt, tipoGestioneSportello.tipoGestioneSoggettiRt) &&
        Objects.equals(flagGestioneModello, tipoGestioneSportello.flagGestioneModello) &&
        Objects.equals(tipoGestioneIntervento, tipoGestioneSportello.tipoGestioneIntervento) &&
        Objects.equals(tipoGestioneServizio, tipoGestioneSportello.tipoGestioneServizio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idGestione, idPso, numProgrSportello, tipoGestioneSoggettiRt, flagGestioneModello, tipoGestioneIntervento, tipoGestioneServizio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipoGestioneSportello {\n");
    
    sb.append("    idGestione: ").append(toIndentedString(idGestione)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    numProgrSportello: ").append(toIndentedString(numProgrSportello)).append("\n");
    sb.append("    tipoGestioneSoggettiRt: ").append(toIndentedString(tipoGestioneSoggettiRt)).append("\n");
    sb.append("    flagGestioneModello: ").append(toIndentedString(flagGestioneModello)).append("\n");
    sb.append("    tipoGestioneIntervento: ").append(toIndentedString(tipoGestioneIntervento)).append("\n");
    sb.append("    tipoGestioneServizio: ").append(toIndentedString(tipoGestioneServizio)).append("\n");
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
