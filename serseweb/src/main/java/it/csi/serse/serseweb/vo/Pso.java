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
import it.csi.serse.serseweb.vo.AmministrazioneResponsabile;
import it.csi.serse.serseweb.vo.TipologiaPso;
import jakarta.validation.constraints.*;

public class Pso   {
  private Long idPso = null;
  private Integer idAttoIndirizzo = null;
  private String descrizione = null;
  private String siglaEnte = null;
  private String codCicloFinanziario = null;
  private TipologiaPso tipologiaPso = null;
  private AmministrazioneResponsabile amministrazioneResponsabile = null;

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
  
  @JsonProperty("idAttoIndirizzo")
  public Integer getIdAttoIndirizzo() {
    return idAttoIndirizzo;
  }
  public void setIdAttoIndirizzo(Integer idAttoIndirizzo) {
    this.idAttoIndirizzo = idAttoIndirizzo;
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
  
  @JsonProperty("siglaEnte")
  public String getSiglaEnte() {
    return siglaEnte;
  }
  public void setSiglaEnte(String siglaEnte) {
    this.siglaEnte = siglaEnte;
  }

  /**
   **/
  
  @JsonProperty("codCicloFinanziario")
  public String getCodCicloFinanziario() {
    return codCicloFinanziario;
  }
  public void setCodCicloFinanziario(String codCicloFinanziario) {
    this.codCicloFinanziario = codCicloFinanziario;
  }

  /**
   **/
  
  @JsonProperty("tipologiaPso")
  public TipologiaPso getTipologiaPso() {
    return tipologiaPso;
  }
  public void setTipologiaPso(TipologiaPso tipologiaPso) {
    this.tipologiaPso = tipologiaPso;
  }

  /**
   **/
  
  @JsonProperty("amministrazioneResponsabile")
  public AmministrazioneResponsabile getAmministrazioneResponsabile() {
    return amministrazioneResponsabile;
  }
  public void setAmministrazioneResponsabile(AmministrazioneResponsabile amministrazioneResponsabile) {
    this.amministrazioneResponsabile = amministrazioneResponsabile;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pso pso = (Pso) o;
    return Objects.equals(idPso, pso.idPso) &&
        Objects.equals(idAttoIndirizzo, pso.idAttoIndirizzo) &&
        Objects.equals(descrizione, pso.descrizione) &&
        Objects.equals(siglaEnte, pso.siglaEnte) &&
        Objects.equals(codCicloFinanziario, pso.codCicloFinanziario) &&
        Objects.equals(tipologiaPso, pso.tipologiaPso) &&
        Objects.equals(amministrazioneResponsabile, pso.amministrazioneResponsabile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPso, idAttoIndirizzo, descrizione, siglaEnte, codCicloFinanziario, tipologiaPso, amministrazioneResponsabile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pso {\n");
    
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idAttoIndirizzo: ").append(toIndentedString(idAttoIndirizzo)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    siglaEnte: ").append(toIndentedString(siglaEnte)).append("\n");
    sb.append("    codCicloFinanziario: ").append(toIndentedString(codCicloFinanziario)).append("\n");
    sb.append("    tipologiaPso: ").append(toIndentedString(tipologiaPso)).append("\n");
    sb.append("    amministrazioneResponsabile: ").append(toIndentedString(amministrazioneResponsabile)).append("\n");
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
