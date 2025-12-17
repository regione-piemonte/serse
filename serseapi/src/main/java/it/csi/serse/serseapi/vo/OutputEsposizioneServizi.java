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
import it.csi.serse.serseapi.vo.OutputEsposizioneServiziItem;
import it.csi.serse.serseapi.vo.OutputParent;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.*;

public class OutputEsposizioneServizi extends OutputParent  {
  private String codFiscaleDestinatario = null;
  private String cognomeDestinatario = null;
  private String nomeDestinatario = null;
  private Date dataNascitaDestinatario = null;
  private List<OutputEsposizioneServiziItem> items = new ArrayList<OutputEsposizioneServiziItem>();

  /**
   **/
  
  @JsonProperty("codFiscaleDestinatario")
  public String getCodFiscaleDestinatario() {
    return codFiscaleDestinatario;
  }
  public void setCodFiscaleDestinatario(String codFiscaleDestinatario) {
    this.codFiscaleDestinatario = codFiscaleDestinatario;
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
  
  @JsonProperty("dataNascitaDestinatario")
  public Date getDataNascitaDestinatario() {
    return dataNascitaDestinatario;
  }
  public void setDataNascitaDestinatario(Date dataNascitaDestinatario) {
    this.dataNascitaDestinatario = dataNascitaDestinatario;
  }

  /**
   **/
  
  @JsonProperty("items")
  public List<OutputEsposizioneServiziItem> getItems() {
    return items;
  }
  public void setItems(List<OutputEsposizioneServiziItem> items) {
    this.items = items;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutputEsposizioneServizi outputEsposizioneServizi = (OutputEsposizioneServizi) o;
    return Objects.equals(codFiscaleDestinatario, outputEsposizioneServizi.codFiscaleDestinatario) &&
        Objects.equals(cognomeDestinatario, outputEsposizioneServizi.cognomeDestinatario) &&
        Objects.equals(nomeDestinatario, outputEsposizioneServizi.nomeDestinatario) &&
        Objects.equals(dataNascitaDestinatario, outputEsposizioneServizi.dataNascitaDestinatario) &&
        Objects.equals(items, outputEsposizioneServizi.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codFiscaleDestinatario, cognomeDestinatario, nomeDestinatario, dataNascitaDestinatario, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutputEsposizioneServizi {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    codFiscaleDestinatario: ").append(toIndentedString(codFiscaleDestinatario)).append("\n");
    sb.append("    cognomeDestinatario: ").append(toIndentedString(cognomeDestinatario)).append("\n");
    sb.append("    nomeDestinatario: ").append(toIndentedString(nomeDestinatario)).append("\n");
    sb.append("    dataNascitaDestinatario: ").append(toIndentedString(dataNascitaDestinatario)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
