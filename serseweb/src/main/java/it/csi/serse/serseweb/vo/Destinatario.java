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
import it.csi.serse.serseweb.vo.StatoEstero;
import java.util.Date;
import jakarta.validation.constraints.*;

public class Destinatario   {
  private Long idDestinatario = null;
  private String codiceFiscaleDestinatario = null;
  private String flgForzaturaControlCF = null;
  private String cognomeDestinatario = null;
  private String nomeDestinatario = null;
  private Date dNascita = null;
  private Comune comuneNascita = null;
  private StatoEstero statoEsteroNascita = null;
  private String descrCittaEsteraNascita = null;
  private Comune comuneResidenza = null;
  private String capResidenza = null;
  private StatoEstero statoEsteroResidenza = null;
  private String descrCittaEsteraResidenza = null;
  private String indirizzoResidenza = null;
  private Comune comuneDomicilio = null;
  private String capDomicilio = null;
  private String indDomicilio = null;
  private String recapitoMail = null;
  private String recapitoTelefonico = null;
  private String codCittadinanza = null;
  private String gruppoOperatoreInserimento = null;
  private Long codOperatoreInserimento = null;
  private String gruppoOperatoreAggiornamento = null;
  private Long codOperatoreAggiornamento = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiorn = null;

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
  
  @JsonProperty("codiceFiscaleDestinatario")
  public String getCodiceFiscaleDestinatario() {
    return codiceFiscaleDestinatario;
  }
  public void setCodiceFiscaleDestinatario(String codiceFiscaleDestinatario) {
    this.codiceFiscaleDestinatario = codiceFiscaleDestinatario;
  }

  /**
   **/
  
  @JsonProperty("flgForzaturaControlCF")
  public String getFlgForzaturaControlCF() {
    return flgForzaturaControlCF;
  }
  public void setFlgForzaturaControlCF(String flgForzaturaControlCF) {
    this.flgForzaturaControlCF = flgForzaturaControlCF;
  }

  /**
   **/
  
  @JsonProperty("cognomeDestinatario")
  public String getCognomeDestinatario() {
    return cognomeDestinatario;
  }
  public void setCognomeDestinatario(String cognomeDestinatario) {
    this.cognomeDestinatario = cognomeDestinatario;
  }

  /**
   **/
  
  @JsonProperty("nomeDestinatario")
  public String getNomeDestinatario() {
    return nomeDestinatario;
  }
  public void setNomeDestinatario(String nomeDestinatario) {
    this.nomeDestinatario = nomeDestinatario;
  }

  /**
   **/
  
  @JsonProperty("dNascita")
  public Date getDNascita() {
    return dNascita;
  }
  public void setDNascita(Date dNascita) {
    this.dNascita = dNascita;
  }

  /**
   **/
  
  @JsonProperty("comuneNascita")
  public Comune getComuneNascita() {
    return comuneNascita;
  }
  public void setComuneNascita(Comune comuneNascita) {
    this.comuneNascita = comuneNascita;
  }

  /**
   **/
  
  @JsonProperty("statoEsteroNascita")
  public StatoEstero getStatoEsteroNascita() {
    return statoEsteroNascita;
  }
  public void setStatoEsteroNascita(StatoEstero statoEsteroNascita) {
    this.statoEsteroNascita = statoEsteroNascita;
  }

  /**
   **/
  
  @JsonProperty("descrCittaEsteraNascita")
  public String getDescrCittaEsteraNascita() {
    return descrCittaEsteraNascita;
  }
  public void setDescrCittaEsteraNascita(String descrCittaEsteraNascita) {
    this.descrCittaEsteraNascita = descrCittaEsteraNascita;
  }

  /**
   **/
  
  @JsonProperty("comuneResidenza")
  public Comune getComuneResidenza() {
    return comuneResidenza;
  }
  public void setComuneResidenza(Comune comuneResidenza) {
    this.comuneResidenza = comuneResidenza;
  }

  /**
   **/
  
  @JsonProperty("capResidenza")
  public String getCapResidenza() {
    return capResidenza;
  }
  public void setCapResidenza(String capResidenza) {
    this.capResidenza = capResidenza;
  }

  /**
   **/
  
  @JsonProperty("statoEsteroResidenza")
  public StatoEstero getStatoEsteroResidenza() {
    return statoEsteroResidenza;
  }
  public void setStatoEsteroResidenza(StatoEstero statoEsteroResidenza) {
    this.statoEsteroResidenza = statoEsteroResidenza;
  }

  /**
   **/
  
  @JsonProperty("descrCittaEsteraResidenza")
  public String getDescrCittaEsteraResidenza() {
    return descrCittaEsteraResidenza;
  }
  public void setDescrCittaEsteraResidenza(String descrCittaEsteraResidenza) {
    this.descrCittaEsteraResidenza = descrCittaEsteraResidenza;
  }

  /**
   **/
  
  @JsonProperty("indirizzoResidenza")
  public String getIndirizzoResidenza() {
    return indirizzoResidenza;
  }
  public void setIndirizzoResidenza(String indirizzoResidenza) {
    this.indirizzoResidenza = indirizzoResidenza;
  }

  /**
   **/
  
  @JsonProperty("comuneDomicilio")
  public Comune getComuneDomicilio() {
    return comuneDomicilio;
  }
  public void setComuneDomicilio(Comune comuneDomicilio) {
    this.comuneDomicilio = comuneDomicilio;
  }

  /**
   **/
  
  @JsonProperty("capDomicilio")
  public String getCapDomicilio() {
    return capDomicilio;
  }
  public void setCapDomicilio(String capDomicilio) {
    this.capDomicilio = capDomicilio;
  }

  /**
   **/
  
  @JsonProperty("indDomicilio")
  public String getIndDomicilio() {
    return indDomicilio;
  }
  public void setIndDomicilio(String indDomicilio) {
    this.indDomicilio = indDomicilio;
  }

  /**
   **/
  
  @JsonProperty("recapitoMail")
  public String getRecapitoMail() {
    return recapitoMail;
  }
  public void setRecapitoMail(String recapitoMail) {
    this.recapitoMail = recapitoMail;
  }

  /**
   **/
  
  @JsonProperty("recapitoTelefonico")
  public String getRecapitoTelefonico() {
    return recapitoTelefonico;
  }
  public void setRecapitoTelefonico(String recapitoTelefonico) {
    this.recapitoTelefonico = recapitoTelefonico;
  }

  /**
   **/
  
  @JsonProperty("codCittadinanza")
  public String getCodCittadinanza() {
    return codCittadinanza;
  }
  public void setCodCittadinanza(String codCittadinanza) {
    this.codCittadinanza = codCittadinanza;
  }

  /**
   **/
  
  @JsonProperty("gruppoOperatoreInserimento")
  public String getGruppoOperatoreInserimento() {
    return gruppoOperatoreInserimento;
  }
  public void setGruppoOperatoreInserimento(String gruppoOperatoreInserimento) {
    this.gruppoOperatoreInserimento = gruppoOperatoreInserimento;
  }

  /**
   **/
  
  @JsonProperty("codOperatoreInserimento")
  public Long getCodOperatoreInserimento() {
    return codOperatoreInserimento;
  }
  public void setCodOperatoreInserimento(Long codOperatoreInserimento) {
    this.codOperatoreInserimento = codOperatoreInserimento;
  }

  /**
   **/
  
  @JsonProperty("gruppoOperatoreAggiornamento")
  public String getGruppoOperatoreAggiornamento() {
    return gruppoOperatoreAggiornamento;
  }
  public void setGruppoOperatoreAggiornamento(String gruppoOperatoreAggiornamento) {
    this.gruppoOperatoreAggiornamento = gruppoOperatoreAggiornamento;
  }

  /**
   **/
  
  @JsonProperty("codOperatoreAggiornamento")
  public Long getCodOperatoreAggiornamento() {
    return codOperatoreAggiornamento;
  }
  public void setCodOperatoreAggiornamento(Long codOperatoreAggiornamento) {
    this.codOperatoreAggiornamento = codOperatoreAggiornamento;
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
    Destinatario destinatario = (Destinatario) o;
    return Objects.equals(idDestinatario, destinatario.idDestinatario) &&
        Objects.equals(codiceFiscaleDestinatario, destinatario.codiceFiscaleDestinatario) &&
        Objects.equals(flgForzaturaControlCF, destinatario.flgForzaturaControlCF) &&
        Objects.equals(cognomeDestinatario, destinatario.cognomeDestinatario) &&
        Objects.equals(nomeDestinatario, destinatario.nomeDestinatario) &&
        Objects.equals(dNascita, destinatario.dNascita) &&
        Objects.equals(comuneNascita, destinatario.comuneNascita) &&
        Objects.equals(statoEsteroNascita, destinatario.statoEsteroNascita) &&
        Objects.equals(descrCittaEsteraNascita, destinatario.descrCittaEsteraNascita) &&
        Objects.equals(comuneResidenza, destinatario.comuneResidenza) &&
        Objects.equals(capResidenza, destinatario.capResidenza) &&
        Objects.equals(statoEsteroResidenza, destinatario.statoEsteroResidenza) &&
        Objects.equals(descrCittaEsteraResidenza, destinatario.descrCittaEsteraResidenza) &&
        Objects.equals(indirizzoResidenza, destinatario.indirizzoResidenza) &&
        Objects.equals(comuneDomicilio, destinatario.comuneDomicilio) &&
        Objects.equals(capDomicilio, destinatario.capDomicilio) &&
        Objects.equals(indDomicilio, destinatario.indDomicilio) &&
        Objects.equals(recapitoMail, destinatario.recapitoMail) &&
        Objects.equals(recapitoTelefonico, destinatario.recapitoTelefonico) &&
        Objects.equals(codCittadinanza, destinatario.codCittadinanza) &&
        Objects.equals(gruppoOperatoreInserimento, destinatario.gruppoOperatoreInserimento) &&
        Objects.equals(codOperatoreInserimento, destinatario.codOperatoreInserimento) &&
        Objects.equals(gruppoOperatoreAggiornamento, destinatario.gruppoOperatoreAggiornamento) &&
        Objects.equals(codOperatoreAggiornamento, destinatario.codOperatoreAggiornamento) &&
        Objects.equals(codUserInserim, destinatario.codUserInserim) &&
        Objects.equals(dInserim, destinatario.dInserim) &&
        Objects.equals(codUserAggiorn, destinatario.codUserAggiorn) &&
        Objects.equals(dAggiorn, destinatario.dAggiorn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDestinatario, codiceFiscaleDestinatario, flgForzaturaControlCF, cognomeDestinatario, nomeDestinatario, dNascita, comuneNascita, statoEsteroNascita, descrCittaEsteraNascita, comuneResidenza, capResidenza, statoEsteroResidenza, descrCittaEsteraResidenza, indirizzoResidenza, comuneDomicilio, capDomicilio, indDomicilio, recapitoMail, recapitoTelefonico, codCittadinanza, gruppoOperatoreInserimento, codOperatoreInserimento, gruppoOperatoreAggiornamento, codOperatoreAggiornamento, codUserInserim, dInserim, codUserAggiorn, dAggiorn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Destinatario {\n");
    
    sb.append("    idDestinatario: ").append(toIndentedString(idDestinatario)).append("\n");
    sb.append("    codiceFiscaleDestinatario: ").append(toIndentedString(codiceFiscaleDestinatario)).append("\n");
    sb.append("    flgForzaturaControlCF: ").append(toIndentedString(flgForzaturaControlCF)).append("\n");
    sb.append("    cognomeDestinatario: ").append(toIndentedString(cognomeDestinatario)).append("\n");
    sb.append("    nomeDestinatario: ").append(toIndentedString(nomeDestinatario)).append("\n");
    sb.append("    dNascita: ").append(toIndentedString(dNascita)).append("\n");
    sb.append("    comuneNascita: ").append(toIndentedString(comuneNascita)).append("\n");
    sb.append("    statoEsteroNascita: ").append(toIndentedString(statoEsteroNascita)).append("\n");
    sb.append("    descrCittaEsteraNascita: ").append(toIndentedString(descrCittaEsteraNascita)).append("\n");
    sb.append("    comuneResidenza: ").append(toIndentedString(comuneResidenza)).append("\n");
    sb.append("    capResidenza: ").append(toIndentedString(capResidenza)).append("\n");
    sb.append("    statoEsteroResidenza: ").append(toIndentedString(statoEsteroResidenza)).append("\n");
    sb.append("    descrCittaEsteraResidenza: ").append(toIndentedString(descrCittaEsteraResidenza)).append("\n");
    sb.append("    indirizzoResidenza: ").append(toIndentedString(indirizzoResidenza)).append("\n");
    sb.append("    comuneDomicilio: ").append(toIndentedString(comuneDomicilio)).append("\n");
    sb.append("    capDomicilio: ").append(toIndentedString(capDomicilio)).append("\n");
    sb.append("    indDomicilio: ").append(toIndentedString(indDomicilio)).append("\n");
    sb.append("    recapitoMail: ").append(toIndentedString(recapitoMail)).append("\n");
    sb.append("    recapitoTelefonico: ").append(toIndentedString(recapitoTelefonico)).append("\n");
    sb.append("    codCittadinanza: ").append(toIndentedString(codCittadinanza)).append("\n");
    sb.append("    gruppoOperatoreInserimento: ").append(toIndentedString(gruppoOperatoreInserimento)).append("\n");
    sb.append("    codOperatoreInserimento: ").append(toIndentedString(codOperatoreInserimento)).append("\n");
    sb.append("    gruppoOperatoreAggiornamento: ").append(toIndentedString(gruppoOperatoreAggiornamento)).append("\n");
    sb.append("    codOperatoreAggiornamento: ").append(toIndentedString(codOperatoreAggiornamento)).append("\n");
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
