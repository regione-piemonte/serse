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
import it.csi.serse.serseweb.vo.VoceSpesa;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.validation.constraints.*;

public class ServizioVoceSpesa   {
  private Long idServizio = null;
  private Long idPso = null;
  private VoceSpesa voceSpesa = null;
  private BigDecimal parametroEconomico = null;
  private BigDecimal parametroFisico = null;
  private BigDecimal parametroTemporale = null;
  private BigDecimal importoVoceSpesa = null;
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
  
  @JsonProperty("idPso")
  public Long getIdPso() {
    return idPso;
  }
  public void setIdPso(Long idPso) {
    this.idPso = idPso;
  }

  /**
   **/
  
  @JsonProperty("voceSpesa")
  public VoceSpesa getVoceSpesa() {
    return voceSpesa;
  }
  public void setVoceSpesa(VoceSpesa voceSpesa) {
    this.voceSpesa = voceSpesa;
  }

  /**
   **/
  
  @JsonProperty("parametroEconomico")
  public BigDecimal getParametroEconomico() {
    return parametroEconomico;
  }
  public void setParametroEconomico(BigDecimal parametroEconomico) {
    this.parametroEconomico = parametroEconomico;
  }

  /**
   **/
  
  @JsonProperty("parametroFisico")
  public BigDecimal getParametroFisico() {
    return parametroFisico;
  }
  public void setParametroFisico(BigDecimal parametroFisico) {
    this.parametroFisico = parametroFisico;
  }

  /**
   **/
  
  @JsonProperty("parametroTemporale")
  public BigDecimal getParametroTemporale() {
    return parametroTemporale;
  }
  public void setParametroTemporale(BigDecimal parametroTemporale) {
    this.parametroTemporale = parametroTemporale;
  }

  /**
   **/
  
  @JsonProperty("importoVoceSpesa")
  public BigDecimal getImportoVoceSpesa() {
    return importoVoceSpesa;
  }
  public void setImportoVoceSpesa(BigDecimal importoVoceSpesa) {
    this.importoVoceSpesa = importoVoceSpesa;
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
    ServizioVoceSpesa servizioVoceSpesa = (ServizioVoceSpesa) o;
    return Objects.equals(idServizio, servizioVoceSpesa.idServizio) &&
        Objects.equals(idPso, servizioVoceSpesa.idPso) &&
        Objects.equals(voceSpesa, servizioVoceSpesa.voceSpesa) &&
        Objects.equals(parametroEconomico, servizioVoceSpesa.parametroEconomico) &&
        Objects.equals(parametroFisico, servizioVoceSpesa.parametroFisico) &&
        Objects.equals(parametroTemporale, servizioVoceSpesa.parametroTemporale) &&
        Objects.equals(importoVoceSpesa, servizioVoceSpesa.importoVoceSpesa) &&
        Objects.equals(codUserInserim, servizioVoceSpesa.codUserInserim) &&
        Objects.equals(dInserim, servizioVoceSpesa.dInserim) &&
        Objects.equals(codUserAggiorn, servizioVoceSpesa.codUserAggiorn) &&
        Objects.equals(dAggiorn, servizioVoceSpesa.dAggiorn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizio, idPso, voceSpesa, parametroEconomico, parametroFisico, parametroTemporale, importoVoceSpesa, codUserInserim, dInserim, codUserAggiorn, dAggiorn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServizioVoceSpesa {\n");
    
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    voceSpesa: ").append(toIndentedString(voceSpesa)).append("\n");
    sb.append("    parametroEconomico: ").append(toIndentedString(parametroEconomico)).append("\n");
    sb.append("    parametroFisico: ").append(toIndentedString(parametroFisico)).append("\n");
    sb.append("    parametroTemporale: ").append(toIndentedString(parametroTemporale)).append("\n");
    sb.append("    importoVoceSpesa: ").append(toIndentedString(importoVoceSpesa)).append("\n");
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
