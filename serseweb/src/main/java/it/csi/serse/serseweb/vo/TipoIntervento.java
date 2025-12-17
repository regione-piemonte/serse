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

public class TipoIntervento   {
  private String codTipoIntervento = null;
  private String descrizione = null;
  private String flgProgettazioneIndividuale = null;

  /**
   **/
  
  @JsonProperty("codTipoIntervento")
  public String getCodTipoIntervento() {
    return codTipoIntervento;
  }
  public void setCodTipoIntervento(String codTipoIntervento) {
    this.codTipoIntervento = codTipoIntervento;
  }

  /**
   **/
  
  @JsonProperty("descrizione")
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   **/
  
  @JsonProperty("flgProgettazioneIndividuale")
  public String getFlgProgettazioneIndividuale() {
    return flgProgettazioneIndividuale;
  }
  public void setFlgProgettazioneIndividuale(String flgProgettazioneIndividuale) {
    this.flgProgettazioneIndividuale = flgProgettazioneIndividuale;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipoIntervento tipoIntervento = (TipoIntervento) o;
    return Objects.equals(codTipoIntervento, tipoIntervento.codTipoIntervento) &&
        Objects.equals(descrizione, tipoIntervento.descrizione) &&
        Objects.equals(flgProgettazioneIndividuale, tipoIntervento.flgProgettazioneIndividuale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codTipoIntervento, descrizione, flgProgettazioneIndividuale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipoIntervento {\n");
    
    sb.append("    codTipoIntervento: ").append(toIndentedString(codTipoIntervento)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    flgProgettazioneIndividuale: ").append(toIndentedString(flgProgettazioneIndividuale)).append("\n");
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
