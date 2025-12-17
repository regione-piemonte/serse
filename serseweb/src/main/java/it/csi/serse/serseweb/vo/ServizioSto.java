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
import java.math.BigDecimal;
import java.util.Date;
import jakarta.validation.constraints.*;

public class ServizioSto   {
  private Long idServizioSto = null;
  private Long idServizio = null;
  private String tipoVariazione = null;
  private String utenteVariazione = null;
  private Date dVariazione = null;
  private BigDecimal preventivoPrecedente = null;

  /**
   **/
  
  @JsonProperty("idServizioSto")
  public Long getIdServizioSto() {
    return idServizioSto;
  }
  public void setIdServizioSto(Long idServizioSto) {
    this.idServizioSto = idServizioSto;
  }

  /**
   **/
  
  @JsonProperty("idServizio")
  public Long getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(Long idServizio) {
    this.idServizio = idServizio;
  }

  /**
   **/
  
  @JsonProperty("tipoVariazione")
  public String getTipoVariazione() {
    return tipoVariazione;
  }
  public void setTipoVariazione(String tipoVariazione) {
    this.tipoVariazione = tipoVariazione;
  }

  /**
   **/
  
  @JsonProperty("utenteVariazione")
  public String getUtenteVariazione() {
    return utenteVariazione;
  }
  public void setUtenteVariazione(String utenteVariazione) {
    this.utenteVariazione = utenteVariazione;
  }

  /**
   **/
  
  @JsonProperty("dVariazione")
  public Date getDVariazione() {
    return dVariazione;
  }
  public void setDVariazione(Date dVariazione) {
    this.dVariazione = dVariazione;
  }

  /**
   **/
  
  @JsonProperty("preventivoPrecedente")
  public BigDecimal getPreventivoPrecedente() {
    return preventivoPrecedente;
  }
  public void setPreventivoPrecedente(BigDecimal preventivoPrecedente) {
    this.preventivoPrecedente = preventivoPrecedente;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServizioSto servizioSto = (ServizioSto) o;
    return Objects.equals(idServizioSto, servizioSto.idServizioSto) &&
        Objects.equals(idServizio, servizioSto.idServizio) &&
        Objects.equals(tipoVariazione, servizioSto.tipoVariazione) &&
        Objects.equals(utenteVariazione, servizioSto.utenteVariazione) &&
        Objects.equals(dVariazione, servizioSto.dVariazione) &&
        Objects.equals(preventivoPrecedente, servizioSto.preventivoPrecedente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizioSto, idServizio, tipoVariazione, utenteVariazione, dVariazione, preventivoPrecedente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServizioSto {\n");
    
    sb.append("    idServizioSto: ").append(toIndentedString(idServizioSto)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    tipoVariazione: ").append(toIndentedString(tipoVariazione)).append("\n");
    sb.append("    utenteVariazione: ").append(toIndentedString(utenteVariazione)).append("\n");
    sb.append("    dVariazione: ").append(toIndentedString(dVariazione)).append("\n");
    sb.append("    preventivoPrecedente: ").append(toIndentedString(preventivoPrecedente)).append("\n");
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
