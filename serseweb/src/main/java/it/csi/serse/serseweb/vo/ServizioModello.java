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
import it.csi.serse.serseweb.vo.Referente;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.validation.constraints.*;

public class ServizioModello   {
  private Long idServizioModello = null;
  private Long idModelloDiIntervento = null;
  private ServizioRegionale servizioRegionale = null;
  private String titoloServizioEsterno = null;
  private String descrizioneServizioEsterno = null;
  private String codFinalitaServizioEsterno = null;
  private String descrFinalitaServizioEsterno = null;
  private String attoreEsterno = null;
  private BigDecimal durataInOre = null;
  private Referente referente = null;
  private Long idDestinatario = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiorn = null;

  /**
   **/
  
  @JsonProperty("idServizioModello")
  public Long getIdServizioModello() {
    return idServizioModello;
  }
  public void setIdServizioModello(Long idServizioModello) {
    this.idServizioModello = idServizioModello;
  }

  /**
   **/
  
  @JsonProperty("idModelloDiIntervento")
  public Long getIdModelloDiIntervento() {
    return idModelloDiIntervento;
  }
  public void setIdModelloDiIntervento(Long idModelloDiIntervento) {
    this.idModelloDiIntervento = idModelloDiIntervento;
  }

  /**
   **/
  
  @JsonProperty("servizioRegionale")
  public ServizioRegionale getServizioRegionale() {
    return servizioRegionale;
  }
  public void setServizioRegionale(ServizioRegionale servizioRegionale) {
    this.servizioRegionale = servizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("titoloServizioEsterno")
  public String getTitoloServizioEsterno() {
    return titoloServizioEsterno;
  }
  public void setTitoloServizioEsterno(String titoloServizioEsterno) {
    this.titoloServizioEsterno = titoloServizioEsterno;
  }

  /**
   **/
  
  @JsonProperty("descrizioneServizioEsterno")
  public String getDescrizioneServizioEsterno() {
    return descrizioneServizioEsterno;
  }
  public void setDescrizioneServizioEsterno(String descrizioneServizioEsterno) {
    this.descrizioneServizioEsterno = descrizioneServizioEsterno;
  }

  /**
   **/
  
  @JsonProperty("codFinalitaServizioEsterno")
  public String getCodFinalitaServizioEsterno() {
    return codFinalitaServizioEsterno;
  }
  public void setCodFinalitaServizioEsterno(String codFinalitaServizioEsterno) {
    this.codFinalitaServizioEsterno = codFinalitaServizioEsterno;
  }

  /**
   **/
  
  @JsonProperty("descrFinalitaServizioEsterno")
  public String getDescrFinalitaServizioEsterno() {
    return descrFinalitaServizioEsterno;
  }
  public void setDescrFinalitaServizioEsterno(String descrFinalitaServizioEsterno) {
    this.descrFinalitaServizioEsterno = descrFinalitaServizioEsterno;
  }

  /**
   **/
  
  @JsonProperty("attoreEsterno")
  public String getAttoreEsterno() {
    return attoreEsterno;
  }
  public void setAttoreEsterno(String attoreEsterno) {
    this.attoreEsterno = attoreEsterno;
  }

  /**
   **/
  
  @JsonProperty("durataInOre")
  public BigDecimal getDurataInOre() {
    return durataInOre;
  }
  public void setDurataInOre(BigDecimal durataInOre) {
    this.durataInOre = durataInOre;
  }

  /**
   **/
  
  @JsonProperty("referente")
  public Referente getReferente() {
    return referente;
  }
  public void setReferente(Referente referente) {
    this.referente = referente;
  }

  /**
   **/
  
  @JsonProperty("idDestinatario")
  public Long getIdDestinatario() {
    return idDestinatario;
  }
  public void setIdDestinatario(Long idDestinatario) {
    this.idDestinatario = idDestinatario;
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
    ServizioModello servizioModello = (ServizioModello) o;
    return Objects.equals(idServizioModello, servizioModello.idServizioModello) &&
        Objects.equals(idModelloDiIntervento, servizioModello.idModelloDiIntervento) &&
        Objects.equals(servizioRegionale, servizioModello.servizioRegionale) &&
        Objects.equals(titoloServizioEsterno, servizioModello.titoloServizioEsterno) &&
        Objects.equals(descrizioneServizioEsterno, servizioModello.descrizioneServizioEsterno) &&
        Objects.equals(codFinalitaServizioEsterno, servizioModello.codFinalitaServizioEsterno) &&
        Objects.equals(descrFinalitaServizioEsterno, servizioModello.descrFinalitaServizioEsterno) &&
        Objects.equals(attoreEsterno, servizioModello.attoreEsterno) &&
        Objects.equals(durataInOre, servizioModello.durataInOre) &&
        Objects.equals(referente, servizioModello.referente) &&
        Objects.equals(idDestinatario, servizioModello.idDestinatario) &&
        Objects.equals(codUserInserim, servizioModello.codUserInserim) &&
        Objects.equals(dInserim, servizioModello.dInserim) &&
        Objects.equals(codUserAggiorn, servizioModello.codUserAggiorn) &&
        Objects.equals(dAggiorn, servizioModello.dAggiorn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizioModello, idModelloDiIntervento, servizioRegionale, titoloServizioEsterno, descrizioneServizioEsterno, codFinalitaServizioEsterno, descrFinalitaServizioEsterno, attoreEsterno, durataInOre, referente, idDestinatario, codUserInserim, dInserim, codUserAggiorn, dAggiorn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServizioModello {\n");
    
    sb.append("    idServizioModello: ").append(toIndentedString(idServizioModello)).append("\n");
    sb.append("    idModelloDiIntervento: ").append(toIndentedString(idModelloDiIntervento)).append("\n");
    sb.append("    servizioRegionale: ").append(toIndentedString(servizioRegionale)).append("\n");
    sb.append("    titoloServizioEsterno: ").append(toIndentedString(titoloServizioEsterno)).append("\n");
    sb.append("    descrizioneServizioEsterno: ").append(toIndentedString(descrizioneServizioEsterno)).append("\n");
    sb.append("    codFinalitaServizioEsterno: ").append(toIndentedString(codFinalitaServizioEsterno)).append("\n");
    sb.append("    descrFinalitaServizioEsterno: ").append(toIndentedString(descrFinalitaServizioEsterno)).append("\n");
    sb.append("    attoreEsterno: ").append(toIndentedString(attoreEsterno)).append("\n");
    sb.append("    durataInOre: ").append(toIndentedString(durataInOre)).append("\n");
    sb.append("    referente: ").append(toIndentedString(referente)).append("\n");
    sb.append("    idDestinatario: ").append(toIndentedString(idDestinatario)).append("\n");
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
