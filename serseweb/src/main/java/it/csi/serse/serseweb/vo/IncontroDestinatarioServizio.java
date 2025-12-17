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

public class IncontroDestinatarioServizio   {
  private Long idIncontro = null;
  private Long idDestinatarioServizio = null;
  private Long idEnteCoinvoltoServizio = null;
  private BigDecimal orePresenza = null;
  private String codUserInserimento = null;
  private Date dataInserimento = null;
  private String codUserAggiornamento = null;
  private Date dataAggiornamento = null;

  /**
   **/
  
  @JsonProperty("idIncontro")
  public Long getIdIncontro() {
    return idIncontro;
  }
  public void setIdIncontro(Long idIncontro) {
    this.idIncontro = idIncontro;
  }

  /**
   **/
  
  @JsonProperty("idDestinatarioServizio")
  public Long getIdDestinatarioServizio() {
    return idDestinatarioServizio;
  }
  public void setIdDestinatarioServizio(Long idDestinatarioServizio) {
    this.idDestinatarioServizio = idDestinatarioServizio;
  }

  /**
   **/
  
  @JsonProperty("idEnteCoinvoltoServizio")
  public Long getIdEnteCoinvoltoServizio() {
    return idEnteCoinvoltoServizio;
  }
  public void setIdEnteCoinvoltoServizio(Long idEnteCoinvoltoServizio) {
    this.idEnteCoinvoltoServizio = idEnteCoinvoltoServizio;
  }

  /**
   **/
  
  @JsonProperty("orePresenza")
  public BigDecimal getOrePresenza() {
    return orePresenza;
  }
  public void setOrePresenza(BigDecimal orePresenza) {
    this.orePresenza = orePresenza;
  }

  /**
   **/
  
  @JsonProperty("codUserInserimento")
  public String getCodUserInserimento() {
    return codUserInserimento;
  }
  public void setCodUserInserimento(String codUserInserimento) {
    this.codUserInserimento = codUserInserimento;
  }

  /**
   **/
  
  @JsonProperty("dataInserimento")
  public Date getDataInserimento() {
    return dataInserimento;
  }
  public void setDataInserimento(Date dataInserimento) {
    this.dataInserimento = dataInserimento;
  }

  /**
   **/
  
  @JsonProperty("codUserAggiornamento")
  public String getCodUserAggiornamento() {
    return codUserAggiornamento;
  }
  public void setCodUserAggiornamento(String codUserAggiornamento) {
    this.codUserAggiornamento = codUserAggiornamento;
  }

  /**
   **/
  
  @JsonProperty("dataAggiornamento")
  public Date getDataAggiornamento() {
    return dataAggiornamento;
  }
  public void setDataAggiornamento(Date dataAggiornamento) {
    this.dataAggiornamento = dataAggiornamento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncontroDestinatarioServizio incontroDestinatarioServizio = (IncontroDestinatarioServizio) o;
    return Objects.equals(idIncontro, incontroDestinatarioServizio.idIncontro) &&
        Objects.equals(idDestinatarioServizio, incontroDestinatarioServizio.idDestinatarioServizio) &&
        Objects.equals(idEnteCoinvoltoServizio, incontroDestinatarioServizio.idEnteCoinvoltoServizio) &&
        Objects.equals(orePresenza, incontroDestinatarioServizio.orePresenza) &&
        Objects.equals(codUserInserimento, incontroDestinatarioServizio.codUserInserimento) &&
        Objects.equals(dataInserimento, incontroDestinatarioServizio.dataInserimento) &&
        Objects.equals(codUserAggiornamento, incontroDestinatarioServizio.codUserAggiornamento) &&
        Objects.equals(dataAggiornamento, incontroDestinatarioServizio.dataAggiornamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIncontro, idDestinatarioServizio, idEnteCoinvoltoServizio, orePresenza, codUserInserimento, dataInserimento, codUserAggiornamento, dataAggiornamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IncontroDestinatarioServizio {\n");
    
    sb.append("    idIncontro: ").append(toIndentedString(idIncontro)).append("\n");
    sb.append("    idDestinatarioServizio: ").append(toIndentedString(idDestinatarioServizio)).append("\n");
    sb.append("    idEnteCoinvoltoServizio: ").append(toIndentedString(idEnteCoinvoltoServizio)).append("\n");
    sb.append("    orePresenza: ").append(toIndentedString(orePresenza)).append("\n");
    sb.append("    codUserInserimento: ").append(toIndentedString(codUserInserimento)).append("\n");
    sb.append("    dataInserimento: ").append(toIndentedString(dataInserimento)).append("\n");
    sb.append("    codUserAggiornamento: ").append(toIndentedString(codUserAggiornamento)).append("\n");
    sb.append("    dataAggiornamento: ").append(toIndentedString(dataAggiornamento)).append("\n");
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
