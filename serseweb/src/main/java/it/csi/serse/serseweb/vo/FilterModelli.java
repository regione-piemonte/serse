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
import it.csi.serse.serseweb.vo.CriterioCiStr;
import it.csi.serse.serseweb.vo.CriterioEqBool;
import it.csi.serse.serseweb.vo.CriterioEqInt;
import it.csi.serse.serseweb.vo.CriterioEqLong;
import it.csi.serse.serseweb.vo.CriterioEqStr;
import it.csi.serse.serseweb.vo.FilterParent;
import jakarta.validation.constraints.*;

public class FilterModelli extends FilterParent  {
  private CriterioEqStr codiceTipoModello = null;
  private CriterioEqInt idStatoModelloIntervento = null;
  private CriterioEqLong idModelloIntervento = null;
  private CriterioEqInt idServizioRegionale = null;
  private CriterioCiStr enteCoinvolto = null;

  /**
   **/
  
  @JsonProperty("codiceTipoModello")
  public CriterioEqStr getCodiceTipoModello() {
    return codiceTipoModello;
  }
  public void setCodiceTipoModello(CriterioEqStr codiceTipoModello) {
    this.codiceTipoModello = codiceTipoModello;
  }

  /**
   **/
  
  @JsonProperty("idStatoModelloIntervento")
  public CriterioEqInt getIdStatoModelloIntervento() {
    return idStatoModelloIntervento;
  }
  public void setIdStatoModelloIntervento(CriterioEqInt idStatoModelloIntervento) {
    this.idStatoModelloIntervento = idStatoModelloIntervento;
  }

  /**
   **/
  
  @JsonProperty("idModelloIntervento")
  public CriterioEqLong getIdModelloIntervento() {
    return idModelloIntervento;
  }
  public void setIdModelloIntervento(CriterioEqLong idModelloIntervento) {
    this.idModelloIntervento = idModelloIntervento;
  }

  /**
   **/
  
  @JsonProperty("idServizioRegionale")
  public CriterioEqInt getIdServizioRegionale() {
    return idServizioRegionale;
  }
  public void setIdServizioRegionale(CriterioEqInt idServizioRegionale) {
    this.idServizioRegionale = idServizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("enteCoinvolto")
  public CriterioCiStr getEnteCoinvolto() {
    return enteCoinvolto;
  }
  public void setEnteCoinvolto(CriterioCiStr enteCoinvolto) {
    this.enteCoinvolto = enteCoinvolto;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterModelli filterModelli = (FilterModelli) o;
    return Objects.equals(codiceTipoModello, filterModelli.codiceTipoModello) &&
        Objects.equals(idStatoModelloIntervento, filterModelli.idStatoModelloIntervento) &&
        Objects.equals(idModelloIntervento, filterModelli.idModelloIntervento) &&
        Objects.equals(idServizioRegionale, filterModelli.idServizioRegionale) &&
        Objects.equals(enteCoinvolto, filterModelli.enteCoinvolto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiceTipoModello, idStatoModelloIntervento, idModelloIntervento, idServizioRegionale, enteCoinvolto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterModelli {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    codiceTipoModello: ").append(toIndentedString(codiceTipoModello)).append("\n");
    sb.append("    idStatoModelloIntervento: ").append(toIndentedString(idStatoModelloIntervento)).append("\n");
    sb.append("    idModelloIntervento: ").append(toIndentedString(idModelloIntervento)).append("\n");
    sb.append("    idServizioRegionale: ").append(toIndentedString(idServizioRegionale)).append("\n");
    sb.append("    enteCoinvolto: ").append(toIndentedString(enteCoinvolto)).append("\n");
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
