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
import java.util.Date;
import jakarta.validation.constraints.*;

public class ServizioGamChiudiServizio   {
  private Long numProgrSportello = null;
  private Long codOperatore = null;
  private String gruppoOperatore = null;
  private Long idPso = null;
  private String codiceFiscaleUtente = null;
  private Date dataChiusuraServizio = null;
  private Long idServizio = null;

  /**
   **/
  
  @JsonProperty("numProgrSportello")
  public Long getNumProgrSportello() {
    return numProgrSportello;
  }
  public void setNumProgrSportello(Long numProgrSportello) {
    this.numProgrSportello = numProgrSportello;
  }

  /**
   **/
  
  @JsonProperty("codOperatore")
  public Long getCodOperatore() {
    return codOperatore;
  }
  public void setCodOperatore(Long codOperatore) {
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
  
  @JsonProperty("idPso")
  public Long getIdPso() {
    return idPso;
  }
  public void setIdPso(Long idPso) {
    this.idPso = idPso;
  }

  /**
   **/
  
  @JsonProperty("codiceFiscaleUtente")
  public String getCodiceFiscaleUtente() {
    return codiceFiscaleUtente;
  }
  public void setCodiceFiscaleUtente(String codiceFiscaleUtente) {
    this.codiceFiscaleUtente = codiceFiscaleUtente;
  }

  /**
   **/
  
  @JsonProperty("dataChiusuraServizio")
  public Date getDataChiusuraServizio() {
    return dataChiusuraServizio;
  }
  public void setDataChiusuraServizio(Date dataChiusuraServizio) {
    this.dataChiusuraServizio = dataChiusuraServizio;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServizioGamChiudiServizio servizioGamChiudiServizio = (ServizioGamChiudiServizio) o;
    return Objects.equals(numProgrSportello, servizioGamChiudiServizio.numProgrSportello) &&
        Objects.equals(codOperatore, servizioGamChiudiServizio.codOperatore) &&
        Objects.equals(gruppoOperatore, servizioGamChiudiServizio.gruppoOperatore) &&
        Objects.equals(idPso, servizioGamChiudiServizio.idPso) &&
        Objects.equals(codiceFiscaleUtente, servizioGamChiudiServizio.codiceFiscaleUtente) &&
        Objects.equals(dataChiusuraServizio, servizioGamChiudiServizio.dataChiusuraServizio) &&
        Objects.equals(idServizio, servizioGamChiudiServizio.idServizio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numProgrSportello, codOperatore, gruppoOperatore, idPso, codiceFiscaleUtente, dataChiusuraServizio, idServizio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServizioGamChiudiServizio {\n");
    
    sb.append("    numProgrSportello: ").append(toIndentedString(numProgrSportello)).append("\n");
    sb.append("    codOperatore: ").append(toIndentedString(codOperatore)).append("\n");
    sb.append("    gruppoOperatore: ").append(toIndentedString(gruppoOperatore)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    codiceFiscaleUtente: ").append(toIndentedString(codiceFiscaleUtente)).append("\n");
    sb.append("    dataChiusuraServizio: ").append(toIndentedString(dataChiusuraServizio)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
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
