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
import java.util.Date;
import jakarta.validation.constraints.*;

public class AnnoScolastico   {
  private Long idAnnoScolastico = null;
  private String descrAnnoScolastico = null;
  private Date dataInizioVal = null;
  private Date dataFineVal = null;

  /**
   **/
  
  @JsonProperty("idAnnoScolastico")
  public Long getIdAnnoScolastico() {
    return idAnnoScolastico;
  }
  public void setIdAnnoScolastico(Long idAnnoScolastico) {
    this.idAnnoScolastico = idAnnoScolastico;
  }

  /**
   **/
  
  @JsonProperty("descrAnnoScolastico")
  public String getDescrAnnoScolastico() {
    return descrAnnoScolastico;
  }
  public void setDescrAnnoScolastico(String descrAnnoScolastico) {
    this.descrAnnoScolastico = descrAnnoScolastico;
  }

  /**
   **/
  
  @JsonProperty("dataInizioVal")
  public Date getDataInizioVal() {
    return dataInizioVal;
  }
  public void setDataInizioVal(Date dataInizioVal) {
    this.dataInizioVal = dataInizioVal;
  }

  /**
   **/
  
  @JsonProperty("dataFineVal")
  public Date getDataFineVal() {
    return dataFineVal;
  }
  public void setDataFineVal(Date dataFineVal) {
    this.dataFineVal = dataFineVal;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnnoScolastico annoScolastico = (AnnoScolastico) o;
    return Objects.equals(idAnnoScolastico, annoScolastico.idAnnoScolastico) &&
        Objects.equals(descrAnnoScolastico, annoScolastico.descrAnnoScolastico) &&
        Objects.equals(dataInizioVal, annoScolastico.dataInizioVal) &&
        Objects.equals(dataFineVal, annoScolastico.dataFineVal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAnnoScolastico, descrAnnoScolastico, dataInizioVal, dataFineVal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnnoScolastico {\n");
    
    sb.append("    idAnnoScolastico: ").append(toIndentedString(idAnnoScolastico)).append("\n");
    sb.append("    descrAnnoScolastico: ").append(toIndentedString(descrAnnoScolastico)).append("\n");
    sb.append("    dataInizioVal: ").append(toIndentedString(dataInizioVal)).append("\n");
    sb.append("    dataFineVal: ").append(toIndentedString(dataFineVal)).append("\n");
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
