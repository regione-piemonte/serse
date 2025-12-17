package it.csi.serse.serseapi.vo;

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
import it.csi.serse.serseapi.vo.OutputEsposizioneAnagraficheItem;
import it.csi.serse.serseapi.vo.OutputParent;
import java.util.Date;
import jakarta.validation.constraints.*;

public class OutputEsposizioneAnagrafiche extends OutputParent  {
  private Long idDestinatarioSerse = null;
  private String codiceFiscale = null;
  private String cognome = null;
  private String nome = null;
  private Date dataNascita = null;
  private String codIstatComuneNascita = null;
  private String descrComuneNascita = null;
  private String siglaProvinciaNascita = null;
  private Integer codStatoEsteroNascita = null;
  private String descrStatoEsteroNascita = null;
  private String descrCittaEsteraNascita = null;
  private String codIstatComuneResidenza = null;
  private String descrComuneResidenza = null;
  private String siglaProvinciaResidenza = null;
  private Integer codStatoEsteroResidenza = null;
  private String descrStatoEsteroResidenza = null;
  private String descrCittaEsteraResidenza = null;
  private String indirizzoResidenza = null;
  private String capResidenza = null;
  private String codIstatComuneDomicilio = null;
  private String descrComuneDomicilio = null;
  private String siglaProvinciaDomicilio = null;
  private String indirizzoDomicilio = null;
  private String capDomicilio = null;
  private String recapitoEmail = null;
  private String recapitoTelefonico = null;
  private String codIstatCittadinanza = null;
  private String descrIstatCittadinanza = null;

  /**
   **/
  
  @JsonProperty("idDestinatarioSerse")
  public Long getIdDestinatarioSerse() {
    return idDestinatarioSerse;
  }
  public void setIdDestinatarioSerse(Long idDestinatarioSerse) {
    this.idDestinatarioSerse = idDestinatarioSerse;
  }

  /**
   **/
  
  @JsonProperty("codiceFiscale")
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  /**
   **/
  
  @JsonProperty("cognome")
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   **/
  
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   **/
  
  @JsonProperty("dataNascita")
  public Date getDataNascita() {
    return dataNascita;
  }
  public void setDataNascita(Date dataNascita) {
    this.dataNascita = dataNascita;
  }

  /**
   **/
  
  @JsonProperty("codIstatComuneNascita")
  public String getCodIstatComuneNascita() {
    return codIstatComuneNascita;
  }
  public void setCodIstatComuneNascita(String codIstatComuneNascita) {
    this.codIstatComuneNascita = codIstatComuneNascita;
  }

  /**
   **/
  
  @JsonProperty("descrComuneNascita")
  public String getDescrComuneNascita() {
    return descrComuneNascita;
  }
  public void setDescrComuneNascita(String descrComuneNascita) {
    this.descrComuneNascita = descrComuneNascita;
  }

  /**
   **/
  
  @JsonProperty("siglaProvinciaNascita")
  public String getSiglaProvinciaNascita() {
    return siglaProvinciaNascita;
  }
  public void setSiglaProvinciaNascita(String siglaProvinciaNascita) {
    this.siglaProvinciaNascita = siglaProvinciaNascita;
  }

  /**
   **/
  
  @JsonProperty("codStatoEsteroNascita")
  public Integer getCodStatoEsteroNascita() {
    return codStatoEsteroNascita;
  }
  public void setCodStatoEsteroNascita(Integer codStatoEsteroNascita) {
    this.codStatoEsteroNascita = codStatoEsteroNascita;
  }

  /**
   **/
  
  @JsonProperty("descrStatoEsteroNascita")
  public String getDescrStatoEsteroNascita() {
    return descrStatoEsteroNascita;
  }
  public void setDescrStatoEsteroNascita(String descrStatoEsteroNascita) {
    this.descrStatoEsteroNascita = descrStatoEsteroNascita;
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
  
  @JsonProperty("codIstatComuneResidenza")
  public String getCodIstatComuneResidenza() {
    return codIstatComuneResidenza;
  }
  public void setCodIstatComuneResidenza(String codIstatComuneResidenza) {
    this.codIstatComuneResidenza = codIstatComuneResidenza;
  }

  /**
   **/
  
  @JsonProperty("descrComuneResidenza")
  public String getDescrComuneResidenza() {
    return descrComuneResidenza;
  }
  public void setDescrComuneResidenza(String descrComuneResidenza) {
    this.descrComuneResidenza = descrComuneResidenza;
  }

  /**
   **/
  
  @JsonProperty("siglaProvinciaResidenza")
  public String getSiglaProvinciaResidenza() {
    return siglaProvinciaResidenza;
  }
  public void setSiglaProvinciaResidenza(String siglaProvinciaResidenza) {
    this.siglaProvinciaResidenza = siglaProvinciaResidenza;
  }

  /**
   **/
  
  @JsonProperty("codStatoEsteroResidenza")
  public Integer getCodStatoEsteroResidenza() {
    return codStatoEsteroResidenza;
  }
  public void setCodStatoEsteroResidenza(Integer codStatoEsteroResidenza) {
    this.codStatoEsteroResidenza = codStatoEsteroResidenza;
  }

  /**
   **/
  
  @JsonProperty("descrStatoEsteroResidenza")
  public String getDescrStatoEsteroResidenza() {
    return descrStatoEsteroResidenza;
  }
  public void setDescrStatoEsteroResidenza(String descrStatoEsteroResidenza) {
    this.descrStatoEsteroResidenza = descrStatoEsteroResidenza;
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
  
  @JsonProperty("capResidenza")
  public String getCapResidenza() {
    return capResidenza;
  }
  public void setCapResidenza(String capResidenza) {
    this.capResidenza = capResidenza;
  }

  /**
   **/
  
  @JsonProperty("codIstatComuneDomicilio")
  public String getCodIstatComuneDomicilio() {
    return codIstatComuneDomicilio;
  }
  public void setCodIstatComuneDomicilio(String codIstatComuneDomicilio) {
    this.codIstatComuneDomicilio = codIstatComuneDomicilio;
  }

  /**
   **/
  
  @JsonProperty("descrComuneDomicilio")
  public String getDescrComuneDomicilio() {
    return descrComuneDomicilio;
  }
  public void setDescrComuneDomicilio(String descrComuneDomicilio) {
    this.descrComuneDomicilio = descrComuneDomicilio;
  }

  /**
   **/
  
  @JsonProperty("siglaProvinciaDomicilio")
  public String getSiglaProvinciaDomicilio() {
    return siglaProvinciaDomicilio;
  }
  public void setSiglaProvinciaDomicilio(String siglaProvinciaDomicilio) {
    this.siglaProvinciaDomicilio = siglaProvinciaDomicilio;
  }

  /**
   **/
  
  @JsonProperty("indirizzoDomicilio")
  public String getIndirizzoDomicilio() {
    return indirizzoDomicilio;
  }
  public void setIndirizzoDomicilio(String indirizzoDomicilio) {
    this.indirizzoDomicilio = indirizzoDomicilio;
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
  
  @JsonProperty("recapitoEmail")
  public String getRecapitoEmail() {
    return recapitoEmail;
  }
  public void setRecapitoEmail(String recapitoEmail) {
    this.recapitoEmail = recapitoEmail;
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
  
  @JsonProperty("codIstatCittadinanza")
  public String getCodIstatCittadinanza() {
    return codIstatCittadinanza;
  }
  public void setCodIstatCittadinanza(String codIstatCittadinanza) {
    this.codIstatCittadinanza = codIstatCittadinanza;
  }

  /**
   **/
  
  @JsonProperty("descrIstatCittadinanza")
  public String getDescrIstatCittadinanza() {
    return descrIstatCittadinanza;
  }
  public void setDescrIstatCittadinanza(String descrIstatCittadinanza) {
    this.descrIstatCittadinanza = descrIstatCittadinanza;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutputEsposizioneAnagrafiche outputEsposizioneAnagrafiche = (OutputEsposizioneAnagrafiche) o;
    return Objects.equals(idDestinatarioSerse, outputEsposizioneAnagrafiche.idDestinatarioSerse) &&
        Objects.equals(codiceFiscale, outputEsposizioneAnagrafiche.codiceFiscale) &&
        Objects.equals(cognome, outputEsposizioneAnagrafiche.cognome) &&
        Objects.equals(nome, outputEsposizioneAnagrafiche.nome) &&
        Objects.equals(dataNascita, outputEsposizioneAnagrafiche.dataNascita) &&
        Objects.equals(codIstatComuneNascita, outputEsposizioneAnagrafiche.codIstatComuneNascita) &&
        Objects.equals(descrComuneNascita, outputEsposizioneAnagrafiche.descrComuneNascita) &&
        Objects.equals(siglaProvinciaNascita, outputEsposizioneAnagrafiche.siglaProvinciaNascita) &&
        Objects.equals(codStatoEsteroNascita, outputEsposizioneAnagrafiche.codStatoEsteroNascita) &&
        Objects.equals(descrStatoEsteroNascita, outputEsposizioneAnagrafiche.descrStatoEsteroNascita) &&
        Objects.equals(descrCittaEsteraNascita, outputEsposizioneAnagrafiche.descrCittaEsteraNascita) &&
        Objects.equals(codIstatComuneResidenza, outputEsposizioneAnagrafiche.codIstatComuneResidenza) &&
        Objects.equals(descrComuneResidenza, outputEsposizioneAnagrafiche.descrComuneResidenza) &&
        Objects.equals(siglaProvinciaResidenza, outputEsposizioneAnagrafiche.siglaProvinciaResidenza) &&
        Objects.equals(codStatoEsteroResidenza, outputEsposizioneAnagrafiche.codStatoEsteroResidenza) &&
        Objects.equals(descrStatoEsteroResidenza, outputEsposizioneAnagrafiche.descrStatoEsteroResidenza) &&
        Objects.equals(descrCittaEsteraResidenza, outputEsposizioneAnagrafiche.descrCittaEsteraResidenza) &&
        Objects.equals(indirizzoResidenza, outputEsposizioneAnagrafiche.indirizzoResidenza) &&
        Objects.equals(capResidenza, outputEsposizioneAnagrafiche.capResidenza) &&
        Objects.equals(codIstatComuneDomicilio, outputEsposizioneAnagrafiche.codIstatComuneDomicilio) &&
        Objects.equals(descrComuneDomicilio, outputEsposizioneAnagrafiche.descrComuneDomicilio) &&
        Objects.equals(siglaProvinciaDomicilio, outputEsposizioneAnagrafiche.siglaProvinciaDomicilio) &&
        Objects.equals(indirizzoDomicilio, outputEsposizioneAnagrafiche.indirizzoDomicilio) &&
        Objects.equals(capDomicilio, outputEsposizioneAnagrafiche.capDomicilio) &&
        Objects.equals(recapitoEmail, outputEsposizioneAnagrafiche.recapitoEmail) &&
        Objects.equals(recapitoTelefonico, outputEsposizioneAnagrafiche.recapitoTelefonico) &&
        Objects.equals(codIstatCittadinanza, outputEsposizioneAnagrafiche.codIstatCittadinanza) &&
        Objects.equals(descrIstatCittadinanza, outputEsposizioneAnagrafiche.descrIstatCittadinanza);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDestinatarioSerse, codiceFiscale, cognome, nome, dataNascita, codIstatComuneNascita, descrComuneNascita, siglaProvinciaNascita, codStatoEsteroNascita, descrStatoEsteroNascita, descrCittaEsteraNascita, codIstatComuneResidenza, descrComuneResidenza, siglaProvinciaResidenza, codStatoEsteroResidenza, descrStatoEsteroResidenza, descrCittaEsteraResidenza, indirizzoResidenza, capResidenza, codIstatComuneDomicilio, descrComuneDomicilio, siglaProvinciaDomicilio, indirizzoDomicilio, capDomicilio, recapitoEmail, recapitoTelefonico, codIstatCittadinanza, descrIstatCittadinanza);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutputEsposizioneAnagrafiche {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    idDestinatarioSerse: ").append(toIndentedString(idDestinatarioSerse)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    dataNascita: ").append(toIndentedString(dataNascita)).append("\n");
    sb.append("    codIstatComuneNascita: ").append(toIndentedString(codIstatComuneNascita)).append("\n");
    sb.append("    descrComuneNascita: ").append(toIndentedString(descrComuneNascita)).append("\n");
    sb.append("    siglaProvinciaNascita: ").append(toIndentedString(siglaProvinciaNascita)).append("\n");
    sb.append("    codStatoEsteroNascita: ").append(toIndentedString(codStatoEsteroNascita)).append("\n");
    sb.append("    descrStatoEsteroNascita: ").append(toIndentedString(descrStatoEsteroNascita)).append("\n");
    sb.append("    descrCittaEsteraNascita: ").append(toIndentedString(descrCittaEsteraNascita)).append("\n");
    sb.append("    codIstatComuneResidenza: ").append(toIndentedString(codIstatComuneResidenza)).append("\n");
    sb.append("    descrComuneResidenza: ").append(toIndentedString(descrComuneResidenza)).append("\n");
    sb.append("    siglaProvinciaResidenza: ").append(toIndentedString(siglaProvinciaResidenza)).append("\n");
    sb.append("    codStatoEsteroResidenza: ").append(toIndentedString(codStatoEsteroResidenza)).append("\n");
    sb.append("    descrStatoEsteroResidenza: ").append(toIndentedString(descrStatoEsteroResidenza)).append("\n");
    sb.append("    descrCittaEsteraResidenza: ").append(toIndentedString(descrCittaEsteraResidenza)).append("\n");
    sb.append("    indirizzoResidenza: ").append(toIndentedString(indirizzoResidenza)).append("\n");
    sb.append("    capResidenza: ").append(toIndentedString(capResidenza)).append("\n");
    sb.append("    codIstatComuneDomicilio: ").append(toIndentedString(codIstatComuneDomicilio)).append("\n");
    sb.append("    descrComuneDomicilio: ").append(toIndentedString(descrComuneDomicilio)).append("\n");
    sb.append("    siglaProvinciaDomicilio: ").append(toIndentedString(siglaProvinciaDomicilio)).append("\n");
    sb.append("    indirizzoDomicilio: ").append(toIndentedString(indirizzoDomicilio)).append("\n");
    sb.append("    capDomicilio: ").append(toIndentedString(capDomicilio)).append("\n");
    sb.append("    recapitoEmail: ").append(toIndentedString(recapitoEmail)).append("\n");
    sb.append("    recapitoTelefonico: ").append(toIndentedString(recapitoTelefonico)).append("\n");
    sb.append("    codIstatCittadinanza: ").append(toIndentedString(codIstatCittadinanza)).append("\n");
    sb.append("    descrIstatCittadinanza: ").append(toIndentedString(descrIstatCittadinanza)).append("\n");
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
