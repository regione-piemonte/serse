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
import it.csi.serse.serseweb.vo.Destinatario;
import java.util.Date;
import jakarta.validation.constraints.*;

public class DestinatarioServizio   {
  private Long idDestinatarioServizio = null;
  private Long idServizio = null;
  private Destinatario destinatario = null;
  private Long idEnteCoinvoltoServizio = null;
  private Long numerazioneDestinatario = null;
  private String valoreDatoPeculiare1 = null;
  private String valoreDatoPeculiare2 = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiornam = null;
  private Long idPsoClasseDestinatario = null;

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
  
  @JsonProperty("idServizio")
  public Long getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(Long idServizio) {
    this.idServizio = idServizio;
  }

  /**
   **/
  
  @JsonProperty("destinatario")
  public Destinatario getDestinatario() {
    return destinatario;
  }
  public void setDestinatario(Destinatario destinatario) {
    this.destinatario = destinatario;
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
  
  @JsonProperty("numerazioneDestinatario")
  public Long getNumerazioneDestinatario() {
    return numerazioneDestinatario;
  }
  public void setNumerazioneDestinatario(Long numerazioneDestinatario) {
    this.numerazioneDestinatario = numerazioneDestinatario;
  }

  /**
   **/
  
  @JsonProperty("valoreDatoPeculiare1")
  public String getValoreDatoPeculiare1() {
    return valoreDatoPeculiare1;
  }
  public void setValoreDatoPeculiare1(String valoreDatoPeculiare1) {
    this.valoreDatoPeculiare1 = valoreDatoPeculiare1;
  }

  /**
   **/
  
  @JsonProperty("valoreDatoPeculiare2")
  public String getValoreDatoPeculiare2() {
    return valoreDatoPeculiare2;
  }
  public void setValoreDatoPeculiare2(String valoreDatoPeculiare2) {
    this.valoreDatoPeculiare2 = valoreDatoPeculiare2;
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
  
  @JsonProperty("dAggiornam")
  public Date getDAggiornam() {
    return dAggiornam;
  }
  public void setDAggiornam(Date dAggiornam) {
    this.dAggiornam = dAggiornam;
  }

  /**
   **/
  
  @JsonProperty("idPsoClasseDestinatario")
  public Long getIdPsoClasseDestinatario() {
    return idPsoClasseDestinatario;
  }
  public void setIdPsoClasseDestinatario(Long idPsoClasseDestinatario) {
    this.idPsoClasseDestinatario = idPsoClasseDestinatario;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinatarioServizio destinatarioServizio = (DestinatarioServizio) o;
    return Objects.equals(idDestinatarioServizio, destinatarioServizio.idDestinatarioServizio) &&
        Objects.equals(idServizio, destinatarioServizio.idServizio) &&
        Objects.equals(destinatario, destinatarioServizio.destinatario) &&
        Objects.equals(idEnteCoinvoltoServizio, destinatarioServizio.idEnteCoinvoltoServizio) &&
        Objects.equals(numerazioneDestinatario, destinatarioServizio.numerazioneDestinatario) &&
        Objects.equals(valoreDatoPeculiare1, destinatarioServizio.valoreDatoPeculiare1) &&
        Objects.equals(valoreDatoPeculiare2, destinatarioServizio.valoreDatoPeculiare2) &&
        Objects.equals(codUserInserim, destinatarioServizio.codUserInserim) &&
        Objects.equals(dInserim, destinatarioServizio.dInserim) &&
        Objects.equals(codUserAggiorn, destinatarioServizio.codUserAggiorn) &&
        Objects.equals(dAggiornam, destinatarioServizio.dAggiornam) &&
        Objects.equals(idPsoClasseDestinatario, destinatarioServizio.idPsoClasseDestinatario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDestinatarioServizio, idServizio, destinatario, idEnteCoinvoltoServizio, numerazioneDestinatario, valoreDatoPeculiare1, valoreDatoPeculiare2, codUserInserim, dInserim, codUserAggiorn, dAggiornam, idPsoClasseDestinatario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinatarioServizio {\n");
    
    sb.append("    idDestinatarioServizio: ").append(toIndentedString(idDestinatarioServizio)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    destinatario: ").append(toIndentedString(destinatario)).append("\n");
    sb.append("    idEnteCoinvoltoServizio: ").append(toIndentedString(idEnteCoinvoltoServizio)).append("\n");
    sb.append("    numerazioneDestinatario: ").append(toIndentedString(numerazioneDestinatario)).append("\n");
    sb.append("    valoreDatoPeculiare1: ").append(toIndentedString(valoreDatoPeculiare1)).append("\n");
    sb.append("    valoreDatoPeculiare2: ").append(toIndentedString(valoreDatoPeculiare2)).append("\n");
    sb.append("    codUserInserim: ").append(toIndentedString(codUserInserim)).append("\n");
    sb.append("    dInserim: ").append(toIndentedString(dInserim)).append("\n");
    sb.append("    codUserAggiorn: ").append(toIndentedString(codUserAggiorn)).append("\n");
    sb.append("    dAggiornam: ").append(toIndentedString(dAggiornam)).append("\n");
    sb.append("    idPsoClasseDestinatario: ").append(toIndentedString(idPsoClasseDestinatario)).append("\n");
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
