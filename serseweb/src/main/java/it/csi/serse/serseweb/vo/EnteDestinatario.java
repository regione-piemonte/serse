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
import jakarta.validation.constraints.*;

public class EnteDestinatario   {
  private Long idEnteConvoltoServizio = null;
  private String odice1Soggetto = null;
  private String codice2Soggetto = null;
  private String denominazione = null;

  /**
   **/
  
  @JsonProperty("idEnteConvoltoServizio")
  public Long getIdEnteConvoltoServizio() {
    return idEnteConvoltoServizio;
  }
  public void setIdEnteConvoltoServizio(Long idEnteConvoltoServizio) {
    this.idEnteConvoltoServizio = idEnteConvoltoServizio;
  }

  /**
   * codice legato a anagrafica istituti scolastici, e centri per l&#x27;impiego
   **/
  
  @JsonProperty("odice1Soggetto")
  public String getOdice1Soggetto() {
    return odice1Soggetto;
  }
  public void setOdice1Soggetto(String odice1Soggetto) {
    this.odice1Soggetto = odice1Soggetto;
  }

  /**
   * codice legato ad anagrafica regionale operatori da aggiungere al codice 1
   **/
  
  @JsonProperty("codice2Soggetto")
  public String getCodice2Soggetto() {
    return codice2Soggetto;
  }
  public void setCodice2Soggetto(String codice2Soggetto) {
    this.codice2Soggetto = codice2Soggetto;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnteDestinatario enteDestinatario = (EnteDestinatario) o;
    return Objects.equals(idEnteConvoltoServizio, enteDestinatario.idEnteConvoltoServizio) &&
        Objects.equals(odice1Soggetto, enteDestinatario.odice1Soggetto) &&
        Objects.equals(codice2Soggetto, enteDestinatario.codice2Soggetto) &&
        Objects.equals(denominazione, enteDestinatario.denominazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEnteConvoltoServizio, odice1Soggetto, codice2Soggetto, denominazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnteDestinatario {\n");
    
    sb.append("    idEnteConvoltoServizio: ").append(toIndentedString(idEnteConvoltoServizio)).append("\n");
    sb.append("    odice1Soggetto: ").append(toIndentedString(odice1Soggetto)).append("\n");
    sb.append("    codice2Soggetto: ").append(toIndentedString(codice2Soggetto)).append("\n");
    sb.append("    denominazione: ").append(toIndentedString(denominazione)).append("\n");
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
