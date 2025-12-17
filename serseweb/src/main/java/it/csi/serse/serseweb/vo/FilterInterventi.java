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

public class FilterInterventi extends FilterParent  {
  private CriterioEqStr codiceFiscaleDestinatario = null;
  private CriterioEqStr codiceTipoIntervento = null;
  private CriterioEqInt idStatoIntervento = null;
  private CriterioEqLong idIntervento = null;
  private CriterioEqLong idServizio = null;
  private CriterioCiStr denominazionEnteCoinvolto = null;

  /**
   **/
  
  @JsonProperty("codiceFiscaleDestinatario")
  public CriterioEqStr getCodiceFiscaleDestinatario() {
    return codiceFiscaleDestinatario;
  }
  public void setCodiceFiscaleDestinatario(CriterioEqStr codiceFiscaleDestinatario) {
    this.codiceFiscaleDestinatario = codiceFiscaleDestinatario;
  }

  /**
   **/
  
  @JsonProperty("codiceTipoIntervento")
  public CriterioEqStr getCodiceTipoIntervento() {
    return codiceTipoIntervento;
  }
  public void setCodiceTipoIntervento(CriterioEqStr codiceTipoIntervento) {
    this.codiceTipoIntervento = codiceTipoIntervento;
  }

  /**
   **/
  
  @JsonProperty("idStatoIntervento")
  public CriterioEqInt getIdStatoIntervento() {
    return idStatoIntervento;
  }
  public void setIdStatoIntervento(CriterioEqInt idStatoIntervento) {
    this.idStatoIntervento = idStatoIntervento;
  }

  /**
   **/
  
  @JsonProperty("idIntervento")
  public CriterioEqLong getIdIntervento() {
    return idIntervento;
  }
  public void setIdIntervento(CriterioEqLong idIntervento) {
    this.idIntervento = idIntervento;
  }

  /**
   **/
  
  @JsonProperty("idServizio")
  public CriterioEqLong getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(CriterioEqLong idServizio) {
    this.idServizio = idServizio;
  }

  /**
   **/
  
  @JsonProperty("denominazionEnteCoinvolto")
  public CriterioCiStr getDenominazionEnteCoinvolto() {
    return denominazionEnteCoinvolto;
  }
  public void setDenominazionEnteCoinvolto(CriterioCiStr denominazionEnteCoinvolto) {
    this.denominazionEnteCoinvolto = denominazionEnteCoinvolto;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterInterventi filterInterventi = (FilterInterventi) o;
    return Objects.equals(codiceFiscaleDestinatario, filterInterventi.codiceFiscaleDestinatario) &&
        Objects.equals(codiceTipoIntervento, filterInterventi.codiceTipoIntervento) &&
        Objects.equals(idStatoIntervento, filterInterventi.idStatoIntervento) &&
        Objects.equals(idIntervento, filterInterventi.idIntervento) &&
        Objects.equals(idServizio, filterInterventi.idServizio) &&
        Objects.equals(denominazionEnteCoinvolto, filterInterventi.denominazionEnteCoinvolto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiceFiscaleDestinatario, codiceTipoIntervento, idStatoIntervento, idIntervento, idServizio, denominazionEnteCoinvolto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterInterventi {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    codiceFiscaleDestinatario: ").append(toIndentedString(codiceFiscaleDestinatario)).append("\n");
    sb.append("    codiceTipoIntervento: ").append(toIndentedString(codiceTipoIntervento)).append("\n");
    sb.append("    idStatoIntervento: ").append(toIndentedString(idStatoIntervento)).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    denominazionEnteCoinvolto: ").append(toIndentedString(denominazionEnteCoinvolto)).append("\n");
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
