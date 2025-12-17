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

public class TestInterventoModifica   {
  private Boolean idModelloIntervento = null;
  private Boolean idDestinatario = null;
  private Boolean idEnteCoinvoltoIntervento = null;
  private String tipoGestioneIntervento = null;
  private Boolean isServizioAssociato = null;

  /**
   **/
  
  @JsonProperty("idModelloIntervento")
  public Boolean isIdModelloIntervento() {
    return idModelloIntervento;
  }
  public void setIdModelloIntervento(Boolean idModelloIntervento) {
    this.idModelloIntervento = idModelloIntervento;
  }

  /**
   **/
  
  @JsonProperty("idDestinatario")
  public Boolean isIdDestinatario() {
    return idDestinatario;
  }
  public void setIdDestinatario(Boolean idDestinatario) {
    this.idDestinatario = idDestinatario;
  }

  /**
   **/
  
  @JsonProperty("idEnteCoinvoltoIntervento")
  public Boolean isIdEnteCoinvoltoIntervento() {
    return idEnteCoinvoltoIntervento;
  }
  public void setIdEnteCoinvoltoIntervento(Boolean idEnteCoinvoltoIntervento) {
    this.idEnteCoinvoltoIntervento = idEnteCoinvoltoIntervento;
  }

  /**
   **/
  
  @JsonProperty("tipoGestioneIntervento")
  public String getTipoGestioneIntervento() {
    return tipoGestioneIntervento;
  }
  public void setTipoGestioneIntervento(String tipoGestioneIntervento) {
    this.tipoGestioneIntervento = tipoGestioneIntervento;
  }

  /**
   **/
  
  @JsonProperty("isServizioAssociato")
  public Boolean isIsServizioAssociato() {
    return isServizioAssociato;
  }
  public void setIsServizioAssociato(Boolean isServizioAssociato) {
    this.isServizioAssociato = isServizioAssociato;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestInterventoModifica testInterventoModifica = (TestInterventoModifica) o;
    return Objects.equals(idModelloIntervento, testInterventoModifica.idModelloIntervento) &&
        Objects.equals(idDestinatario, testInterventoModifica.idDestinatario) &&
        Objects.equals(idEnteCoinvoltoIntervento, testInterventoModifica.idEnteCoinvoltoIntervento) &&
        Objects.equals(tipoGestioneIntervento, testInterventoModifica.tipoGestioneIntervento) &&
        Objects.equals(isServizioAssociato, testInterventoModifica.isServizioAssociato);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idModelloIntervento, idDestinatario, idEnteCoinvoltoIntervento, tipoGestioneIntervento, isServizioAssociato);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestInterventoModifica {\n");
    
    sb.append("    idModelloIntervento: ").append(toIndentedString(idModelloIntervento)).append("\n");
    sb.append("    idDestinatario: ").append(toIndentedString(idDestinatario)).append("\n");
    sb.append("    idEnteCoinvoltoIntervento: ").append(toIndentedString(idEnteCoinvoltoIntervento)).append("\n");
    sb.append("    tipoGestioneIntervento: ").append(toIndentedString(tipoGestioneIntervento)).append("\n");
    sb.append("    isServizioAssociato: ").append(toIndentedString(isServizioAssociato)).append("\n");
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
