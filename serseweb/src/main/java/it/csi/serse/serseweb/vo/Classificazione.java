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

public class Classificazione   {
  private Long idClassificazione = null;
  private Long idClassificazzioneGam = null;
  private String livello1 = null;
  private String livello2 = null;
  private String livello3 = null;
  private String livello4 = null;
  private Long idTipoSuddivDotfin = null;
  private String descrFinalita = null;

  /**
   **/
  
  @JsonProperty("idClassificazione")
  public Long getIdClassificazione() {
    return idClassificazione;
  }
  public void setIdClassificazione(Long idClassificazione) {
    this.idClassificazione = idClassificazione;
  }

  /**
   **/
  
  @JsonProperty("idClassificazzioneGam")
  public Long getIdClassificazzioneGam() {
    return idClassificazzioneGam;
  }
  public void setIdClassificazzioneGam(Long idClassificazzioneGam) {
    this.idClassificazzioneGam = idClassificazzioneGam;
  }

  /**
   **/
  
  @JsonProperty("livello1")
  public String getLivello1() {
    return livello1;
  }
  public void setLivello1(String livello1) {
    this.livello1 = livello1;
  }

  /**
   **/
  
  @JsonProperty("livello2")
  public String getLivello2() {
    return livello2;
  }
  public void setLivello2(String livello2) {
    this.livello2 = livello2;
  }

  /**
   **/
  
  @JsonProperty("livello3")
  public String getLivello3() {
    return livello3;
  }
  public void setLivello3(String livello3) {
    this.livello3 = livello3;
  }

  /**
   **/
  
  @JsonProperty("livello4")
  public String getLivello4() {
    return livello4;
  }
  public void setLivello4(String livello4) {
    this.livello4 = livello4;
  }

  /**
   **/
  
  @JsonProperty("idTipoSuddivDotfin")
  public Long getIdTipoSuddivDotfin() {
    return idTipoSuddivDotfin;
  }
  public void setIdTipoSuddivDotfin(Long idTipoSuddivDotfin) {
    this.idTipoSuddivDotfin = idTipoSuddivDotfin;
  }

  /**
   **/
  
  @JsonProperty("descrFinalita")
  public String getDescrFinalita() {
    return descrFinalita;
  }
  public void setDescrFinalita(String descrFinalita) {
    this.descrFinalita = descrFinalita;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Classificazione classificazione = (Classificazione) o;
    return Objects.equals(idClassificazione, classificazione.idClassificazione) &&
        Objects.equals(idClassificazzioneGam, classificazione.idClassificazzioneGam) &&
        Objects.equals(livello1, classificazione.livello1) &&
        Objects.equals(livello2, classificazione.livello2) &&
        Objects.equals(livello3, classificazione.livello3) &&
        Objects.equals(livello4, classificazione.livello4) &&
        Objects.equals(idTipoSuddivDotfin, classificazione.idTipoSuddivDotfin) &&
        Objects.equals(descrFinalita, classificazione.descrFinalita);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idClassificazione, idClassificazzioneGam, livello1, livello2, livello3, livello4, idTipoSuddivDotfin, descrFinalita);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Classificazione {\n");
    
    sb.append("    idClassificazione: ").append(toIndentedString(idClassificazione)).append("\n");
    sb.append("    idClassificazzioneGam: ").append(toIndentedString(idClassificazzioneGam)).append("\n");
    sb.append("    livello1: ").append(toIndentedString(livello1)).append("\n");
    sb.append("    livello2: ").append(toIndentedString(livello2)).append("\n");
    sb.append("    livello3: ").append(toIndentedString(livello3)).append("\n");
    sb.append("    livello4: ").append(toIndentedString(livello4)).append("\n");
    sb.append("    idTipoSuddivDotfin: ").append(toIndentedString(idTipoSuddivDotfin)).append("\n");
    sb.append("    descrFinalita: ").append(toIndentedString(descrFinalita)).append("\n");
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
