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
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.ProvenienzaLuogo;
import java.util.Date;
import jakarta.validation.constraints.*;

public class LuogoIncontro   {
  private Long idLuogoIncontro = null;
  private ProvenienzaLuogo provenienzaLuogo = null;
  private String denominazioneLuogo = null;
  private String indirizzoLuogo = null;
  private Comune comuneIncontro = null;
  private String note = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiorn = null;

  /**
   **/
  
  @JsonProperty("idLuogoIncontro")
  public Long getIdLuogoIncontro() {
    return idLuogoIncontro;
  }
  public void setIdLuogoIncontro(Long idLuogoIncontro) {
    this.idLuogoIncontro = idLuogoIncontro;
  }

  /**
   **/
  
  @JsonProperty("provenienzaLuogo")
  public ProvenienzaLuogo getProvenienzaLuogo() {
    return provenienzaLuogo;
  }
  public void setProvenienzaLuogo(ProvenienzaLuogo provenienzaLuogo) {
    this.provenienzaLuogo = provenienzaLuogo;
  }

  /**
   **/
  
  @JsonProperty("denominazioneLuogo")
  public String getDenominazioneLuogo() {
    return denominazioneLuogo;
  }
  public void setDenominazioneLuogo(String denominazioneLuogo) {
    this.denominazioneLuogo = denominazioneLuogo;
  }

  /**
   **/
  
  @JsonProperty("indirizzoLuogo")
  public String getIndirizzoLuogo() {
    return indirizzoLuogo;
  }
  public void setIndirizzoLuogo(String indirizzoLuogo) {
    this.indirizzoLuogo = indirizzoLuogo;
  }

  /**
   **/
  
  @JsonProperty("comuneIncontro")
  public Comune getComuneIncontro() {
    return comuneIncontro;
  }
  public void setComuneIncontro(Comune comuneIncontro) {
    this.comuneIncontro = comuneIncontro;
  }

  /**
   **/
  
  @JsonProperty("note")
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
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
    LuogoIncontro luogoIncontro = (LuogoIncontro) o;
    return Objects.equals(idLuogoIncontro, luogoIncontro.idLuogoIncontro) &&
        Objects.equals(provenienzaLuogo, luogoIncontro.provenienzaLuogo) &&
        Objects.equals(denominazioneLuogo, luogoIncontro.denominazioneLuogo) &&
        Objects.equals(indirizzoLuogo, luogoIncontro.indirizzoLuogo) &&
        Objects.equals(comuneIncontro, luogoIncontro.comuneIncontro) &&
        Objects.equals(note, luogoIncontro.note) &&
        Objects.equals(codUserInserim, luogoIncontro.codUserInserim) &&
        Objects.equals(dInserim, luogoIncontro.dInserim) &&
        Objects.equals(codUserAggiorn, luogoIncontro.codUserAggiorn) &&
        Objects.equals(dAggiorn, luogoIncontro.dAggiorn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idLuogoIncontro, provenienzaLuogo, denominazioneLuogo, indirizzoLuogo, comuneIncontro, note, codUserInserim, dInserim, codUserAggiorn, dAggiorn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LuogoIncontro {\n");
    
    sb.append("    idLuogoIncontro: ").append(toIndentedString(idLuogoIncontro)).append("\n");
    sb.append("    provenienzaLuogo: ").append(toIndentedString(provenienzaLuogo)).append("\n");
    sb.append("    denominazioneLuogo: ").append(toIndentedString(denominazioneLuogo)).append("\n");
    sb.append("    indirizzoLuogo: ").append(toIndentedString(indirizzoLuogo)).append("\n");
    sb.append("    comuneIncontro: ").append(toIndentedString(comuneIncontro)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
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
