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
import it.csi.serse.serseweb.vo.Pso;
import java.util.Date;
import jakarta.validation.constraints.*;

public class Sportello   {
  private Integer numProgrSportello = null;
  private Pso pso = null;
  private String descrizioneSportello = null;
  private Date dataInizio = null;
  private Date dataFine = null;

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
   **/
  
  @JsonProperty("pso")
  public Pso getPso() {
    return pso;
  }
  public void setPso(Pso pso) {
    this.pso = pso;
  }

  /**
   **/
  
  @JsonProperty("descrizioneSportello")
  public String getDescrizioneSportello() {
    return descrizioneSportello;
  }
  public void setDescrizioneSportello(String descrizioneSportello) {
    this.descrizioneSportello = descrizioneSportello;
  }

  /**
   **/
  
  @JsonProperty("dataInizio")
  public Date getDataInizio() {
    return dataInizio;
  }
  public void setDataInizio(Date dataInizio) {
    this.dataInizio = dataInizio;
  }

  /**
   **/
  
  @JsonProperty("dataFine")
  public Date getDataFine() {
    return dataFine;
  }
  public void setDataFine(Date dataFine) {
    this.dataFine = dataFine;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sportello sportello = (Sportello) o;
    return Objects.equals(numProgrSportello, sportello.numProgrSportello) &&
        Objects.equals(pso, sportello.pso) &&
        Objects.equals(descrizioneSportello, sportello.descrizioneSportello) &&
        Objects.equals(dataInizio, sportello.dataInizio) &&
        Objects.equals(dataFine, sportello.dataFine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numProgrSportello, pso, descrizioneSportello, dataInizio, dataFine);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sportello {\n");
    
    sb.append("    numProgrSportello: ").append(toIndentedString(numProgrSportello)).append("\n");
    sb.append("    pso: ").append(toIndentedString(pso)).append("\n");
    sb.append("    descrizioneSportello: ").append(toIndentedString(descrizioneSportello)).append("\n");
    sb.append("    dataInizio: ").append(toIndentedString(dataInizio)).append("\n");
    sb.append("    dataFine: ").append(toIndentedString(dataFine)).append("\n");
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
