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

public class ServizioFonte   {
  private Long idServizio = null;
  private Long idFonte = null;
  private String descrFonte = null;
  private String codTipologiaFonte = null;
  private BigDecimal importoFonte = null;
  private BigDecimal percFonte = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiorn = null;

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
  
  @JsonProperty("idFonte")
  public Long getIdFonte() {
    return idFonte;
  }
  public void setIdFonte(Long idFonte) {
    this.idFonte = idFonte;
  }

  /**
   **/
  
  @JsonProperty("descrFonte")
  public String getDescrFonte() {
    return descrFonte;
  }
  public void setDescrFonte(String descrFonte) {
    this.descrFonte = descrFonte;
  }

  /**
   **/
  
  @JsonProperty("codTipologiaFonte")
  public String getCodTipologiaFonte() {
    return codTipologiaFonte;
  }
  public void setCodTipologiaFonte(String codTipologiaFonte) {
    this.codTipologiaFonte = codTipologiaFonte;
  }

  /**
   **/
  
  @JsonProperty("importoFonte")
  public BigDecimal getImportoFonte() {
    return importoFonte;
  }
  public void setImportoFonte(BigDecimal importoFonte) {
    this.importoFonte = importoFonte;
  }

  /**
   **/
  
  @JsonProperty("percFonte")
  public BigDecimal getPercFonte() {
    return percFonte;
  }
  public void setPercFonte(BigDecimal percFonte) {
    this.percFonte = percFonte;
  }

  /**
   **/
  
  @JsonProperty("codUserInserim")
  public String getCodUserInserim() {
    return codUserInserim;
  }
  public void setCodUserInserim(String codUserInserim) {
    this.codUserInserim = codUserInserim;
  }

  /**
   **/
  
  @JsonProperty("dInserim")
  public Date getDInserim() {
    return dInserim;
  }
  public void setDInserim(Date dInserim) {
    this.dInserim = dInserim;
  }

  /**
   **/
  
  @JsonProperty("codUserAggiorn")
  public String getCodUserAggiorn() {
    return codUserAggiorn;
  }
  public void setCodUserAggiorn(String codUserAggiorn) {
    this.codUserAggiorn = codUserAggiorn;
  }

  /**
   **/
  
  @JsonProperty("dAggiorn")
  public Date getDAggiorn() {
    return dAggiorn;
  }
  public void setDAggiorn(Date dAggiorn) {
    this.dAggiorn = dAggiorn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServizioFonte servizioFonte = (ServizioFonte) o;
    return Objects.equals(idServizio, servizioFonte.idServizio) &&
        Objects.equals(idFonte, servizioFonte.idFonte) &&
        Objects.equals(descrFonte, servizioFonte.descrFonte) &&
        Objects.equals(codTipologiaFonte, servizioFonte.codTipologiaFonte) &&
        Objects.equals(importoFonte, servizioFonte.importoFonte) &&
        Objects.equals(percFonte, servizioFonte.percFonte) &&
        Objects.equals(codUserInserim, servizioFonte.codUserInserim) &&
        Objects.equals(dInserim, servizioFonte.dInserim) &&
        Objects.equals(codUserAggiorn, servizioFonte.codUserAggiorn) &&
        Objects.equals(dAggiorn, servizioFonte.dAggiorn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizio, idFonte, descrFonte, codTipologiaFonte, importoFonte, percFonte, codUserInserim, dInserim, codUserAggiorn, dAggiorn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServizioFonte {\n");
    
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    idFonte: ").append(toIndentedString(idFonte)).append("\n");
    sb.append("    descrFonte: ").append(toIndentedString(descrFonte)).append("\n");
    sb.append("    codTipologiaFonte: ").append(toIndentedString(codTipologiaFonte)).append("\n");
    sb.append("    importoFonte: ").append(toIndentedString(importoFonte)).append("\n");
    sb.append("    percFonte: ").append(toIndentedString(percFonte)).append("\n");
    sb.append("    codUserInserim: ").append(toIndentedString(codUserInserim)).append("\n");
    sb.append("    dInserim: ").append(toIndentedString(dInserim)).append("\n");
    sb.append("    codUserAggiorn: ").append(toIndentedString(codUserAggiorn)).append("\n");
    sb.append("    dAggiorn: ").append(toIndentedString(dAggiorn)).append("\n");
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
