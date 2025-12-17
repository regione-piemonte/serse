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
import it.csi.serse.serseweb.vo.SedeOperatore;
import jakarta.validation.constraints.*;

public class PersonaGiuridica   {
  private Integer codOperatore = null;
  private String gruppoOperatore = null;
  private String denominazione = null;
  private String codiceFiscale = null;
  private String partitaIva = null;
  private Integer codiceBacino = null;
  private SedeOperatore sede = null;

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
  
  @JsonProperty("gruppoOperatore")
  public String getGruppoOperatore() {
    return gruppoOperatore;
  }
  public void setGruppoOperatore(String gruppoOperatore) {
    this.gruppoOperatore = gruppoOperatore;
  }

  /**
   **/
  
  @JsonProperty("denominazione")
  public String getDenominazione() {
    return denominazione;
  }
  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
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
  
  @JsonProperty("partitaIva")
  public String getPartitaIva() {
    return partitaIva;
  }
  public void setPartitaIva(String partitaIva) {
    this.partitaIva = partitaIva;
  }

  /**
   **/
  
  @JsonProperty("codiceBacino")
  public Integer getCodiceBacino() {
    return codiceBacino;
  }
  public void setCodiceBacino(Integer codiceBacino) {
    this.codiceBacino = codiceBacino;
  }

  /**
   **/
  
  @JsonProperty("sede")
  public SedeOperatore getSede() {
    return sede;
  }
  public void setSede(SedeOperatore sede) {
    this.sede = sede;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaGiuridica personaGiuridica = (PersonaGiuridica) o;
    return Objects.equals(codOperatore, personaGiuridica.codOperatore) &&
        Objects.equals(gruppoOperatore, personaGiuridica.gruppoOperatore) &&
        Objects.equals(denominazione, personaGiuridica.denominazione) &&
        Objects.equals(codiceFiscale, personaGiuridica.codiceFiscale) &&
        Objects.equals(partitaIva, personaGiuridica.partitaIva) &&
        Objects.equals(codiceBacino, personaGiuridica.codiceBacino) &&
        Objects.equals(sede, personaGiuridica.sede);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codOperatore, gruppoOperatore, denominazione, codiceFiscale, partitaIva, codiceBacino, sede);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaGiuridica {\n");
    
    sb.append("    codOperatore: ").append(toIndentedString(codOperatore)).append("\n");
    sb.append("    gruppoOperatore: ").append(toIndentedString(gruppoOperatore)).append("\n");
    sb.append("    denominazione: ").append(toIndentedString(denominazione)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    partitaIva: ").append(toIndentedString(partitaIva)).append("\n");
    sb.append("    codiceBacino: ").append(toIndentedString(codiceBacino)).append("\n");
    sb.append("    sede: ").append(toIndentedString(sede)).append("\n");
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
