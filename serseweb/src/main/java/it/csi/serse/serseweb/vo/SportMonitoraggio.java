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

public class SportMonitoraggio   {
  private Integer idRegComportPsoSport = null;
  private String flgTitoloStudio = null;
  private String flgCondizioneOccupazionale = null;
  private String flgDisabilita = null;
  private String flgSvantaggioAbitativo = null;
  private String codTitoloStudioDefault = null;
  private String codCondizioneOccupazionaleDefault = null;
  private String flgDisabilitaDefault = null;
  private String flgSvantaggioAbitativoDefault = null;

  /**
   **/
  
  @JsonProperty("idRegComportPsoSport")
  public Integer getIdRegComportPsoSport() {
    return idRegComportPsoSport;
  }
  public void setIdRegComportPsoSport(Integer idRegComportPsoSport) {
    this.idRegComportPsoSport = idRegComportPsoSport;
  }

  /**
   **/
  
  @JsonProperty("flgTitoloStudio")
  public String getFlgTitoloStudio() {
    return flgTitoloStudio;
  }
  public void setFlgTitoloStudio(String flgTitoloStudio) {
    this.flgTitoloStudio = flgTitoloStudio;
  }

  /**
   **/
  
  @JsonProperty("flgCondizioneOccupazionale")
  public String getFlgCondizioneOccupazionale() {
    return flgCondizioneOccupazionale;
  }
  public void setFlgCondizioneOccupazionale(String flgCondizioneOccupazionale) {
    this.flgCondizioneOccupazionale = flgCondizioneOccupazionale;
  }

  /**
   **/
  
  @JsonProperty("flgDisabilita")
  public String getFlgDisabilita() {
    return flgDisabilita;
  }
  public void setFlgDisabilita(String flgDisabilita) {
    this.flgDisabilita = flgDisabilita;
  }

  /**
   **/
  
  @JsonProperty("flgSvantaggioAbitativo")
  public String getFlgSvantaggioAbitativo() {
    return flgSvantaggioAbitativo;
  }
  public void setFlgSvantaggioAbitativo(String flgSvantaggioAbitativo) {
    this.flgSvantaggioAbitativo = flgSvantaggioAbitativo;
  }

  /**
   **/
  
  @JsonProperty("codTitoloStudioDefault")
  public String getCodTitoloStudioDefault() {
    return codTitoloStudioDefault;
  }
  public void setCodTitoloStudioDefault(String codTitoloStudioDefault) {
    this.codTitoloStudioDefault = codTitoloStudioDefault;
  }

  /**
   **/
  
  @JsonProperty("codCondizioneOccupazionaleDefault")
  public String getCodCondizioneOccupazionaleDefault() {
    return codCondizioneOccupazionaleDefault;
  }
  public void setCodCondizioneOccupazionaleDefault(String codCondizioneOccupazionaleDefault) {
    this.codCondizioneOccupazionaleDefault = codCondizioneOccupazionaleDefault;
  }

  /**
   **/
  
  @JsonProperty("flgDisabilitaDefault")
  public String getFlgDisabilitaDefault() {
    return flgDisabilitaDefault;
  }
  public void setFlgDisabilitaDefault(String flgDisabilitaDefault) {
    this.flgDisabilitaDefault = flgDisabilitaDefault;
  }

  /**
   **/
  
  @JsonProperty("flgSvantaggioAbitativoDefault")
  public String getFlgSvantaggioAbitativoDefault() {
    return flgSvantaggioAbitativoDefault;
  }
  public void setFlgSvantaggioAbitativoDefault(String flgSvantaggioAbitativoDefault) {
    this.flgSvantaggioAbitativoDefault = flgSvantaggioAbitativoDefault;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SportMonitoraggio sportMonitoraggio = (SportMonitoraggio) o;
    return Objects.equals(idRegComportPsoSport, sportMonitoraggio.idRegComportPsoSport) &&
        Objects.equals(flgTitoloStudio, sportMonitoraggio.flgTitoloStudio) &&
        Objects.equals(flgCondizioneOccupazionale, sportMonitoraggio.flgCondizioneOccupazionale) &&
        Objects.equals(flgDisabilita, sportMonitoraggio.flgDisabilita) &&
        Objects.equals(flgSvantaggioAbitativo, sportMonitoraggio.flgSvantaggioAbitativo) &&
        Objects.equals(codTitoloStudioDefault, sportMonitoraggio.codTitoloStudioDefault) &&
        Objects.equals(codCondizioneOccupazionaleDefault, sportMonitoraggio.codCondizioneOccupazionaleDefault) &&
        Objects.equals(flgDisabilitaDefault, sportMonitoraggio.flgDisabilitaDefault) &&
        Objects.equals(flgSvantaggioAbitativoDefault, sportMonitoraggio.flgSvantaggioAbitativoDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRegComportPsoSport, flgTitoloStudio, flgCondizioneOccupazionale, flgDisabilita, flgSvantaggioAbitativo, codTitoloStudioDefault, codCondizioneOccupazionaleDefault, flgDisabilitaDefault, flgSvantaggioAbitativoDefault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SportMonitoraggio {\n");
    
    sb.append("    idRegComportPsoSport: ").append(toIndentedString(idRegComportPsoSport)).append("\n");
    sb.append("    flgTitoloStudio: ").append(toIndentedString(flgTitoloStudio)).append("\n");
    sb.append("    flgCondizioneOccupazionale: ").append(toIndentedString(flgCondizioneOccupazionale)).append("\n");
    sb.append("    flgDisabilita: ").append(toIndentedString(flgDisabilita)).append("\n");
    sb.append("    flgSvantaggioAbitativo: ").append(toIndentedString(flgSvantaggioAbitativo)).append("\n");
    sb.append("    codTitoloStudioDefault: ").append(toIndentedString(codTitoloStudioDefault)).append("\n");
    sb.append("    codCondizioneOccupazionaleDefault: ").append(toIndentedString(codCondizioneOccupazionaleDefault)).append("\n");
    sb.append("    flgDisabilitaDefault: ").append(toIndentedString(flgDisabilitaDefault)).append("\n");
    sb.append("    flgSvantaggioAbitativoDefault: ").append(toIndentedString(flgSvantaggioAbitativoDefault)).append("\n");
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
