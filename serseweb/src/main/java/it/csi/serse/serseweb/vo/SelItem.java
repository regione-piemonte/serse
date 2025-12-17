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

public class SelItem   {
  private String key = null;
  private String value = null;
  private String secondaryKey = null;
  private String seccondaryValue = null;
  private String caratteristica = null;

  /**
   **/
  
  @JsonProperty("key")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  /**
   **/
  
  @JsonProperty("value")
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  /**
   **/
  
  @JsonProperty("secondaryKey")
  public String getSecondaryKey() {
    return secondaryKey;
  }
  public void setSecondaryKey(String secondaryKey) {
    this.secondaryKey = secondaryKey;
  }

  /**
   **/
  
  @JsonProperty("seccondaryValue")
  public String getSeccondaryValue() {
    return seccondaryValue;
  }
  public void setSeccondaryValue(String seccondaryValue) {
    this.seccondaryValue = seccondaryValue;
  }

  /**
   **/
  
  @JsonProperty("caratteristica")
  public String getCaratteristica() {
    return caratteristica;
  }
  public void setCaratteristica(String caratteristica) {
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
    SelItem selItem = (SelItem) o;
    return Objects.equals(key, selItem.key) &&
        Objects.equals(value, selItem.value) &&
        Objects.equals(secondaryKey, selItem.secondaryKey) &&
        Objects.equals(seccondaryValue, selItem.seccondaryValue) &&
        Objects.equals(caratteristica, selItem.caratteristica);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value, secondaryKey, seccondaryValue, caratteristica);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelItem {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    secondaryKey: ").append(toIndentedString(secondaryKey)).append("\n");
    sb.append("    seccondaryValue: ").append(toIndentedString(seccondaryValue)).append("\n");
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
