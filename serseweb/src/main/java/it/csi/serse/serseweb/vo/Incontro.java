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
import it.csi.serse.serseweb.vo.LuogoIncontro;
import it.csi.serse.serseweb.vo.StatoIncontro;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.validation.constraints.*;

public class Incontro   {
  private Long idIncontro = null;
  private String titoloIncontro = null;
  private Long idServizio = null;
  private Date dInizio = null;
  private Date dFine = null;
  private BigDecimal durataOre = null;
  private String nomeReferente = null;
  private String cognomeReferente = null;
  private String referenteEmail = null;
  private String referenteTelefono = null;
  private String note = null;
  private LuogoIncontro luogoIncontro = null;
  private StatoIncontro statoIncontro = null;
  private String codUserChiusura = null;
  private Date dChiusura = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiorn = null;

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
  
  @JsonProperty("titoloIncontro")
  public String getTitoloIncontro() {
    return titoloIncontro;
  }
  public void setTitoloIncontro(String titoloIncontro) {
    this.titoloIncontro = titoloIncontro;
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
  
  @JsonProperty("dInizio")
  public Date getDInizio() {
    return dInizio;
  }
  public void setDInizio(Date dInizio) {
    this.dInizio = dInizio;
  }

  /**
   **/
  
  @JsonProperty("dFine")
  public Date getDFine() {
    return dFine;
  }
  public void setDFine(Date dFine) {
    this.dFine = dFine;
  }

  /**
   **/
  
  @JsonProperty("durataOre")
  public BigDecimal getDurataOre() {
    return durataOre;
  }
  public void setDurataOre(BigDecimal durataOre) {
    this.durataOre = durataOre;
  }

  /**
   **/
  
  @JsonProperty("nomeReferente")
  public String getNomeReferente() {
    return nomeReferente;
  }
  public void setNomeReferente(String nomeReferente) {
    this.nomeReferente = nomeReferente;
  }

  /**
   **/
  
  @JsonProperty("cognomeReferente")
  public String getCognomeReferente() {
    return cognomeReferente;
  }
  public void setCognomeReferente(String cognomeReferente) {
    this.cognomeReferente = cognomeReferente;
  }

  /**
   **/
  
  @JsonProperty("referenteEmail")
  public String getReferenteEmail() {
    return referenteEmail;
  }
  public void setReferenteEmail(String referenteEmail) {
    this.referenteEmail = referenteEmail;
  }

  /**
   **/
  
  @JsonProperty("referenteTelefono")
  public String getReferenteTelefono() {
    return referenteTelefono;
  }
  public void setReferenteTelefono(String referenteTelefono) {
    this.referenteTelefono = referenteTelefono;
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
  
  @JsonProperty("luogoIncontro")
  public LuogoIncontro getLuogoIncontro() {
    return luogoIncontro;
  }
  public void setLuogoIncontro(LuogoIncontro luogoIncontro) {
    this.luogoIncontro = luogoIncontro;
  }

  /**
   **/
  
  @JsonProperty("statoIncontro")
  public StatoIncontro getStatoIncontro() {
    return statoIncontro;
  }
  public void setStatoIncontro(StatoIncontro statoIncontro) {
    this.statoIncontro = statoIncontro;
  }

  /**
   **/
  
  @JsonProperty("codUserChiusura")
  public String getCodUserChiusura() {
    return codUserChiusura;
  }
  public void setCodUserChiusura(String codUserChiusura) {
    this.codUserChiusura = codUserChiusura;
  }

  /**
   **/
  
  @JsonProperty("dChiusura")
  public Date getDChiusura() {
    return dChiusura;
  }
  public void setDChiusura(Date dChiusura) {
    this.dChiusura = dChiusura;
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
    Incontro incontro = (Incontro) o;
    return Objects.equals(idIncontro, incontro.idIncontro) &&
        Objects.equals(titoloIncontro, incontro.titoloIncontro) &&
        Objects.equals(idServizio, incontro.idServizio) &&
        Objects.equals(dInizio, incontro.dInizio) &&
        Objects.equals(dFine, incontro.dFine) &&
        Objects.equals(durataOre, incontro.durataOre) &&
        Objects.equals(nomeReferente, incontro.nomeReferente) &&
        Objects.equals(cognomeReferente, incontro.cognomeReferente) &&
        Objects.equals(referenteEmail, incontro.referenteEmail) &&
        Objects.equals(referenteTelefono, incontro.referenteTelefono) &&
        Objects.equals(note, incontro.note) &&
        Objects.equals(luogoIncontro, incontro.luogoIncontro) &&
        Objects.equals(statoIncontro, incontro.statoIncontro) &&
        Objects.equals(codUserChiusura, incontro.codUserChiusura) &&
        Objects.equals(dChiusura, incontro.dChiusura) &&
        Objects.equals(codUserInserim, incontro.codUserInserim) &&
        Objects.equals(dInserim, incontro.dInserim) &&
        Objects.equals(codUserAggiorn, incontro.codUserAggiorn) &&
        Objects.equals(dAggiorn, incontro.dAggiorn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIncontro, titoloIncontro, idServizio, dInizio, dFine, durataOre, nomeReferente, cognomeReferente, referenteEmail, referenteTelefono, note, luogoIncontro, statoIncontro, codUserChiusura, dChiusura, codUserInserim, dInserim, codUserAggiorn, dAggiorn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Incontro {\n");
    
    sb.append("    idIncontro: ").append(toIndentedString(idIncontro)).append("\n");
    sb.append("    titoloIncontro: ").append(toIndentedString(titoloIncontro)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    dInizio: ").append(toIndentedString(dInizio)).append("\n");
    sb.append("    dFine: ").append(toIndentedString(dFine)).append("\n");
    sb.append("    durataOre: ").append(toIndentedString(durataOre)).append("\n");
    sb.append("    nomeReferente: ").append(toIndentedString(nomeReferente)).append("\n");
    sb.append("    cognomeReferente: ").append(toIndentedString(cognomeReferente)).append("\n");
    sb.append("    referenteEmail: ").append(toIndentedString(referenteEmail)).append("\n");
    sb.append("    referenteTelefono: ").append(toIndentedString(referenteTelefono)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    luogoIncontro: ").append(toIndentedString(luogoIncontro)).append("\n");
    sb.append("    statoIncontro: ").append(toIndentedString(statoIncontro)).append("\n");
    sb.append("    codUserChiusura: ").append(toIndentedString(codUserChiusura)).append("\n");
    sb.append("    dChiusura: ").append(toIndentedString(dChiusura)).append("\n");
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
