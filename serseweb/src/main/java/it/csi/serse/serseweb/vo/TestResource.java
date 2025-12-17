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

public class TestResource   {
  private Boolean db = null;
  private Boolean flaianagpgAnagrafepg = null;
  private Boolean flaianagpgAnagrafesedipg = null;
  private Boolean budgetbilservCommon = null;
  private Boolean orchflaiFlaidoorsrv = null;
  private Boolean operservOperscamb = null;

  /**
   **/
  
  @JsonProperty("db")
  public Boolean isDb() {
    return db;
  }
  public void setDb(Boolean db) {
    this.db = db;
  }

  /**
   **/
  
  @JsonProperty("flaianagpgAnagrafepg")
  public Boolean isFlaianagpgAnagrafepg() {
    return flaianagpgAnagrafepg;
  }
  public void setFlaianagpgAnagrafepg(Boolean flaianagpgAnagrafepg) {
    this.flaianagpgAnagrafepg = flaianagpgAnagrafepg;
  }

  /**
   **/
  
  @JsonProperty("flaianagpgAnagrafesedipg")
  public Boolean isFlaianagpgAnagrafesedipg() {
    return flaianagpgAnagrafesedipg;
  }
  public void setFlaianagpgAnagrafesedipg(Boolean flaianagpgAnagrafesedipg) {
    this.flaianagpgAnagrafesedipg = flaianagpgAnagrafesedipg;
  }

  /**
   **/
  
  @JsonProperty("budgetbilservCommon")
  public Boolean isBudgetbilservCommon() {
    return budgetbilservCommon;
  }
  public void setBudgetbilservCommon(Boolean budgetbilservCommon) {
    this.budgetbilservCommon = budgetbilservCommon;
  }

  /**
   **/
  
  @JsonProperty("orchflaiFlaidoorsrv")
  public Boolean isOrchflaiFlaidoorsrv() {
    return orchflaiFlaidoorsrv;
  }
  public void setOrchflaiFlaidoorsrv(Boolean orchflaiFlaidoorsrv) {
    this.orchflaiFlaidoorsrv = orchflaiFlaidoorsrv;
  }

  /**
   **/
  
  @JsonProperty("operservOperscamb")
  public Boolean isOperservOperscamb() {
    return operservOperscamb;
  }
  public void setOperservOperscamb(Boolean operservOperscamb) {
    this.operservOperscamb = operservOperscamb;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestResource testResource = (TestResource) o;
    return Objects.equals(db, testResource.db) &&
        Objects.equals(flaianagpgAnagrafepg, testResource.flaianagpgAnagrafepg) &&
        Objects.equals(flaianagpgAnagrafesedipg, testResource.flaianagpgAnagrafesedipg) &&
        Objects.equals(budgetbilservCommon, testResource.budgetbilservCommon) &&
        Objects.equals(orchflaiFlaidoorsrv, testResource.orchflaiFlaidoorsrv) &&
        Objects.equals(operservOperscamb, testResource.operservOperscamb);
  }

  @Override
  public int hashCode() {
    return Objects.hash(db, flaianagpgAnagrafepg, flaianagpgAnagrafesedipg, budgetbilservCommon, orchflaiFlaidoorsrv, operservOperscamb);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestResource {\n");
    
    sb.append("    db: ").append(toIndentedString(db)).append("\n");
    sb.append("    flaianagpgAnagrafepg: ").append(toIndentedString(flaianagpgAnagrafepg)).append("\n");
    sb.append("    flaianagpgAnagrafesedipg: ").append(toIndentedString(flaianagpgAnagrafesedipg)).append("\n");
    sb.append("    budgetbilservCommon: ").append(toIndentedString(budgetbilservCommon)).append("\n");
    sb.append("    orchflaiFlaidoorsrv: ").append(toIndentedString(orchflaiFlaidoorsrv)).append("\n");
    sb.append("    operservOperscamb: ").append(toIndentedString(operservOperscamb)).append("\n");
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
