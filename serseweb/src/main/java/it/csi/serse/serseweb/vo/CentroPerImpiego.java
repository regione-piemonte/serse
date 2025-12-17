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
import jakarta.validation.constraints.*;

public class CentroPerImpiego   {
  private Long idCpi = null;
  private String codiceCpi = null;
  private String cpi = null;
  private String gruppoOperatore = null;
  private Integer codOperatore = null;
  private String sede = null;
  private String indirizzo = null;
  private String cap = null;
  private Comune comune = null;
  private String telefono = null;
  private String telefono2 = null;
  private String telefono3 = null;
  private String numeroVerde = null;
  private String email = null;
  private String indirizzoWeb = null;

  /**
   **/
  
  @JsonProperty("idCpi")
  public Long getIdCpi() {
    return idCpi;
  }
  public void setIdCpi(Long idCpi) {
    this.idCpi = idCpi;
  }

  /**
   **/
  
  @JsonProperty("codiceCpi")
  public String getCodiceCpi() {
    return codiceCpi;
  }
  public void setCodiceCpi(String codiceCpi) {
    this.codiceCpi = codiceCpi;
  }

  /**
   **/
  
  @JsonProperty("cpi")
  public String getCpi() {
    return cpi;
  }
  public void setCpi(String cpi) {
    this.cpi = cpi;
  }

  /**
   **/
  
  @JsonProperty("gruppoOperatore")
  public String getGruppoOperatore() {
    return gruppoOperatore;
  }
  public void setGruppoOperatore(String gruppoOperatore) {
    this.gruppoOperatore = gruppoOperatore;
  }

  /**
   **/
  
  @JsonProperty("codOperatore")
  public Integer getCodOperatore() {
    return codOperatore;
  }
  public void setCodOperatore(Integer codOperatore) {
    this.codOperatore = codOperatore;
  }

  /**
   **/
  
  @JsonProperty("sede")
  public String getSede() {
    return sede;
  }
  public void setSede(String sede) {
    this.sede = sede;
  }

  /**
   **/
  
  @JsonProperty("indirizzo")
  public String getIndirizzo() {
    return indirizzo;
  }
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  /**
   **/
  
  @JsonProperty("cap")
  public String getCap() {
    return cap;
  }
  public void setCap(String cap) {
    this.cap = cap;
  }

  /**
   **/
  
  @JsonProperty("comune")
  public Comune getComune() {
    return comune;
  }
  public void setComune(Comune comune) {
    this.comune = comune;
  }

  /**
   **/
  
  @JsonProperty("telefono")
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   **/
  
  @JsonProperty("telefono2")
  public String getTelefono2() {
    return telefono2;
  }
  public void setTelefono2(String telefono2) {
    this.telefono2 = telefono2;
  }

  /**
   **/
  
  @JsonProperty("telefono3")
  public String getTelefono3() {
    return telefono3;
  }
  public void setTelefono3(String telefono3) {
    this.telefono3 = telefono3;
  }

  /**
   **/
  
  @JsonProperty("numeroVerde")
  public String getNumeroVerde() {
    return numeroVerde;
  }
  public void setNumeroVerde(String numeroVerde) {
    this.numeroVerde = numeroVerde;
  }

  /**
   **/
  
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   **/
  
  @JsonProperty("indirizzoWeb")
  public String getIndirizzoWeb() {
    return indirizzoWeb;
  }
  public void setIndirizzoWeb(String indirizzoWeb) {
    this.indirizzoWeb = indirizzoWeb;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CentroPerImpiego centroPerImpiego = (CentroPerImpiego) o;
    return Objects.equals(idCpi, centroPerImpiego.idCpi) &&
        Objects.equals(codiceCpi, centroPerImpiego.codiceCpi) &&
        Objects.equals(cpi, centroPerImpiego.cpi) &&
        Objects.equals(gruppoOperatore, centroPerImpiego.gruppoOperatore) &&
        Objects.equals(codOperatore, centroPerImpiego.codOperatore) &&
        Objects.equals(sede, centroPerImpiego.sede) &&
        Objects.equals(indirizzo, centroPerImpiego.indirizzo) &&
        Objects.equals(cap, centroPerImpiego.cap) &&
        Objects.equals(comune, centroPerImpiego.comune) &&
        Objects.equals(telefono, centroPerImpiego.telefono) &&
        Objects.equals(telefono2, centroPerImpiego.telefono2) &&
        Objects.equals(telefono3, centroPerImpiego.telefono3) &&
        Objects.equals(numeroVerde, centroPerImpiego.numeroVerde) &&
        Objects.equals(email, centroPerImpiego.email) &&
        Objects.equals(indirizzoWeb, centroPerImpiego.indirizzoWeb);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCpi, codiceCpi, cpi, gruppoOperatore, codOperatore, sede, indirizzo, cap, comune, telefono, telefono2, telefono3, numeroVerde, email, indirizzoWeb);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CentroPerImpiego {\n");
    
    sb.append("    idCpi: ").append(toIndentedString(idCpi)).append("\n");
    sb.append("    codiceCpi: ").append(toIndentedString(codiceCpi)).append("\n");
    sb.append("    cpi: ").append(toIndentedString(cpi)).append("\n");
    sb.append("    gruppoOperatore: ").append(toIndentedString(gruppoOperatore)).append("\n");
    sb.append("    codOperatore: ").append(toIndentedString(codOperatore)).append("\n");
    sb.append("    sede: ").append(toIndentedString(sede)).append("\n");
    sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
    sb.append("    cap: ").append(toIndentedString(cap)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    telefono2: ").append(toIndentedString(telefono2)).append("\n");
    sb.append("    telefono3: ").append(toIndentedString(telefono3)).append("\n");
    sb.append("    numeroVerde: ").append(toIndentedString(numeroVerde)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    indirizzoWeb: ").append(toIndentedString(indirizzoWeb)).append("\n");
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
