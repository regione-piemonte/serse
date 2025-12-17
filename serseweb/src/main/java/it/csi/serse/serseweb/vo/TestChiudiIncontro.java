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

public class TestChiudiIncontro   {
  private Boolean dataFinePosterioreAllaAttuale = null;
  private Boolean destinatarioSenzaOreErogate = null;
  private Integer participantiPresenti = null;
  private Boolean datiMonitoraggioPartecipantiNonCompilati = null;

  /**
   * se torna true non si puo chiudere l&#x27;incontro
   **/
  
  @JsonProperty("dataFinePosterioreAllaAttuale")
  public Boolean isDataFinePosterioreAllaAttuale() {
    return dataFinePosterioreAllaAttuale;
  }
  public void setDataFinePosterioreAllaAttuale(Boolean dataFinePosterioreAllaAttuale) {
    this.dataFinePosterioreAllaAttuale = dataFinePosterioreAllaAttuale;
  }

  /**
   * se torna true non si puo chiudere l&#x27;incontro
   **/
  
  @JsonProperty("destinatarioSenzaOreErogate")
  public Boolean isDestinatarioSenzaOreErogate() {
    return destinatarioSenzaOreErogate;
  }
  public void setDestinatarioSenzaOreErogate(Boolean destinatarioSenzaOreErogate) {
    this.destinatarioSenzaOreErogate = destinatarioSenzaOreErogate;
  }

  /**
   * torna numeri di participanti
   **/
  
  @JsonProperty("participantiPresenti")
  public Integer getParticipantiPresenti() {
    return participantiPresenti;
  }
  public void setParticipantiPresenti(Integer participantiPresenti) {
    this.participantiPresenti = participantiPresenti;
  }

  /**
   * se torna true non si può chiudere l&#x27;incontro
   **/
  
  @JsonProperty("datiMonitoraggioPartecipantiNonCompilati")
  public Boolean isDatiMonitoraggioPartecipantiNonCompilati() {
    return datiMonitoraggioPartecipantiNonCompilati;
  }
  public void setDatiMonitoraggioPartecipantiNonCompilati(Boolean datiMonitoraggioPartecipantiNonCompilati) {
    this.datiMonitoraggioPartecipantiNonCompilati = datiMonitoraggioPartecipantiNonCompilati;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestChiudiIncontro testChiudiIncontro = (TestChiudiIncontro) o;
    return Objects.equals(dataFinePosterioreAllaAttuale, testChiudiIncontro.dataFinePosterioreAllaAttuale) &&
        Objects.equals(destinatarioSenzaOreErogate, testChiudiIncontro.destinatarioSenzaOreErogate) &&
        Objects.equals(participantiPresenti, testChiudiIncontro.participantiPresenti) &&
        Objects.equals(datiMonitoraggioPartecipantiNonCompilati, testChiudiIncontro.datiMonitoraggioPartecipantiNonCompilati);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataFinePosterioreAllaAttuale, destinatarioSenzaOreErogate, participantiPresenti, datiMonitoraggioPartecipantiNonCompilati);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestChiudiIncontro {\n");
    
    sb.append("    dataFinePosterioreAllaAttuale: ").append(toIndentedString(dataFinePosterioreAllaAttuale)).append("\n");
    sb.append("    destinatarioSenzaOreErogate: ").append(toIndentedString(destinatarioSenzaOreErogate)).append("\n");
    sb.append("    participantiPresenti: ").append(toIndentedString(participantiPresenti)).append("\n");
    sb.append("    datiMonitoraggioPartecipantiNonCompilati: ").append(toIndentedString(datiMonitoraggioPartecipantiNonCompilati)).append("\n");
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
