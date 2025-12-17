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

public class TipologiaPso   {
  private String tipologiaPsoId = null;
  private Integer idAttoIndirizzo = null;
  private String descrizione = null;
  private Integer codProgrammazione = null;
  private String codClassificazioneAdi = null;
  private Integer annoApprovazione = null;

  /**
   **/
  
  @JsonProperty("tipologiaPsoId")
  public String getTipologiaPsoId() {
    return tipologiaPsoId;
  }
  public void setTipologiaPsoId(String tipologiaPsoId) {
    this.tipologiaPsoId = tipologiaPsoId;
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
  
  @JsonProperty("codProgrammazione")
  public Integer getCodProgrammazione() {
    return codProgrammazione;
  }
  public void setCodProgrammazione(Integer codProgrammazione) {
    this.codProgrammazione = codProgrammazione;
  }

  /**
   **/
  
  @JsonProperty("codClassificazioneAdi")
  public String getCodClassificazioneAdi() {
    return codClassificazioneAdi;
  }
  public void setCodClassificazioneAdi(String codClassificazioneAdi) {
    this.codClassificazioneAdi = codClassificazioneAdi;
  }

  /**
   **/
  
  @JsonProperty("annoApprovazione")
  public Integer getAnnoApprovazione() {
    return annoApprovazione;
  }
  public void setAnnoApprovazione(Integer annoApprovazione) {
    this.annoApprovazione = annoApprovazione;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipologiaPso tipologiaPso = (TipologiaPso) o;
    return Objects.equals(tipologiaPsoId, tipologiaPso.tipologiaPsoId) &&
        Objects.equals(idAttoIndirizzo, tipologiaPso.idAttoIndirizzo) &&
        Objects.equals(descrizione, tipologiaPso.descrizione) &&
        Objects.equals(codProgrammazione, tipologiaPso.codProgrammazione) &&
        Objects.equals(codClassificazioneAdi, tipologiaPso.codClassificazioneAdi) &&
        Objects.equals(annoApprovazione, tipologiaPso.annoApprovazione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipologiaPsoId, idAttoIndirizzo, descrizione, codProgrammazione, codClassificazioneAdi, annoApprovazione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipologiaPso {\n");
    
    sb.append("    tipologiaPsoId: ").append(toIndentedString(tipologiaPsoId)).append("\n");
    sb.append("    idAttoIndirizzo: ").append(toIndentedString(idAttoIndirizzo)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    codProgrammazione: ").append(toIndentedString(codProgrammazione)).append("\n");
    sb.append("    codClassificazioneAdi: ").append(toIndentedString(codClassificazioneAdi)).append("\n");
    sb.append("    annoApprovazione: ").append(toIndentedString(annoApprovazione)).append("\n");
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
