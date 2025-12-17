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
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.IncontroDestinatarioServizio;
import java.util.Date;
import jakarta.validation.constraints.*;

public class Partecipanti   {
  private Destinatario destinatario = null;
  private IncontroDestinatarioServizio incontroDestinatarioServizio = null;
  private Long idDestinatarioServizio = null;
  private Long numerazioneDestinatario = null;
  private Date dtInserimentoDestinatarioServizio = null;

  /**
   **/
  
  @JsonProperty("destinatario")
  public Destinatario getDestinatario() {
    return destinatario;
  }
  public void setDestinatario(Destinatario destinatario) {
    this.destinatario = destinatario;
  }

  /**
   **/
  
  @JsonProperty("incontroDestinatarioServizio")
  public IncontroDestinatarioServizio getIncontroDestinatarioServizio() {
    return incontroDestinatarioServizio;
  }
  public void setIncontroDestinatarioServizio(IncontroDestinatarioServizio incontroDestinatarioServizio) {
    this.incontroDestinatarioServizio = incontroDestinatarioServizio;
  }

  /**
   **/
  
  @JsonProperty("idDestinatarioServizio")
  public Long getIdDestinatarioServizio() {
    return idDestinatarioServizio;
  }
  public void setIdDestinatarioServizio(Long idDestinatarioServizio) {
    this.idDestinatarioServizio = idDestinatarioServizio;
  }

  /**
   **/
  
  @JsonProperty("numerazioneDestinatario")
  public Long getNumerazioneDestinatario() {
    return numerazioneDestinatario;
  }
  public void setNumerazioneDestinatario(Long numerazioneDestinatario) {
    this.numerazioneDestinatario = numerazioneDestinatario;
  }

  /**
   **/
  
  @JsonProperty("dtInserimentoDestinatarioServizio")
  public Date getDtInserimentoDestinatarioServizio() {
    return dtInserimentoDestinatarioServizio;
  }
  public void setDtInserimentoDestinatarioServizio(Date dtInserimentoDestinatarioServizio) {
    this.dtInserimentoDestinatarioServizio = dtInserimentoDestinatarioServizio;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Partecipanti partecipanti = (Partecipanti) o;
    return Objects.equals(destinatario, partecipanti.destinatario) &&
        Objects.equals(incontroDestinatarioServizio, partecipanti.incontroDestinatarioServizio) &&
        Objects.equals(idDestinatarioServizio, partecipanti.idDestinatarioServizio) &&
        Objects.equals(numerazioneDestinatario, partecipanti.numerazioneDestinatario) &&
        Objects.equals(dtInserimentoDestinatarioServizio, partecipanti.dtInserimentoDestinatarioServizio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinatario, incontroDestinatarioServizio, idDestinatarioServizio, numerazioneDestinatario, dtInserimentoDestinatarioServizio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Partecipanti {\n");
    
    sb.append("    destinatario: ").append(toIndentedString(destinatario)).append("\n");
    sb.append("    incontroDestinatarioServizio: ").append(toIndentedString(incontroDestinatarioServizio)).append("\n");
    sb.append("    idDestinatarioServizio: ").append(toIndentedString(idDestinatarioServizio)).append("\n");
    sb.append("    numerazioneDestinatario: ").append(toIndentedString(numerazioneDestinatario)).append("\n");
    sb.append("    dtInserimentoDestinatarioServizio: ").append(toIndentedString(dtInserimentoDestinatarioServizio)).append("\n");
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
