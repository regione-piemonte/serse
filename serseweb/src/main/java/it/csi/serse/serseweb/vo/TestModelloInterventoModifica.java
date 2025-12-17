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

public class TestModelloInterventoModifica   {
  private Boolean idRModelloTargetDest = null;
  private Boolean idRCaratteristica = null;
  private Boolean idServizioModello = null;
  private Boolean idEnteCoinvolto = null;
  private Boolean idIntervento = null;

  /**
   **/
  
  @JsonProperty("idRModelloTargetDest")
  public Boolean isIdRModelloTargetDest() {
    return idRModelloTargetDest;
  }
  public void setIdRModelloTargetDest(Boolean idRModelloTargetDest) {
    this.idRModelloTargetDest = idRModelloTargetDest;
  }

  /**
   **/
  
  @JsonProperty("idRCaratteristica")
  public Boolean isIdRCaratteristica() {
    return idRCaratteristica;
  }
  public void setIdRCaratteristica(Boolean idRCaratteristica) {
    this.idRCaratteristica = idRCaratteristica;
  }

  /**
   **/
  
  @JsonProperty("idServizioModello")
  public Boolean isIdServizioModello() {
    return idServizioModello;
  }
  public void setIdServizioModello(Boolean idServizioModello) {
    this.idServizioModello = idServizioModello;
  }

  /**
   **/
  
  @JsonProperty("idEnteCoinvolto")
  public Boolean isIdEnteCoinvolto() {
    return idEnteCoinvolto;
  }
  public void setIdEnteCoinvolto(Boolean idEnteCoinvolto) {
    this.idEnteCoinvolto = idEnteCoinvolto;
  }

  /**
   **/
  
  @JsonProperty("idIntervento")
  public Boolean isIdIntervento() {
    return idIntervento;
  }
  public void setIdIntervento(Boolean idIntervento) {
    this.idIntervento = idIntervento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestModelloInterventoModifica testModelloInterventoModifica = (TestModelloInterventoModifica) o;
    return Objects.equals(idRModelloTargetDest, testModelloInterventoModifica.idRModelloTargetDest) &&
        Objects.equals(idRCaratteristica, testModelloInterventoModifica.idRCaratteristica) &&
        Objects.equals(idServizioModello, testModelloInterventoModifica.idServizioModello) &&
        Objects.equals(idEnteCoinvolto, testModelloInterventoModifica.idEnteCoinvolto) &&
        Objects.equals(idIntervento, testModelloInterventoModifica.idIntervento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRModelloTargetDest, idRCaratteristica, idServizioModello, idEnteCoinvolto, idIntervento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestModelloInterventoModifica {\n");
    
    sb.append("    idRModelloTargetDest: ").append(toIndentedString(idRModelloTargetDest)).append("\n");
    sb.append("    idRCaratteristica: ").append(toIndentedString(idRCaratteristica)).append("\n");
    sb.append("    idServizioModello: ").append(toIndentedString(idServizioModello)).append("\n");
    sb.append("    idEnteCoinvolto: ").append(toIndentedString(idEnteCoinvolto)).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
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
