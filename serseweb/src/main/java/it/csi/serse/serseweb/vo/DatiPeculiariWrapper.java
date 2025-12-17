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
import it.csi.serse.serseweb.vo.DestinatarioServizio;
import it.csi.serse.serseweb.vo.DestinatarioServizioMonitoraggio;
import it.csi.serse.serseweb.vo.DettaglioClasseDestinatarioServizio;
import it.csi.serse.serseweb.vo.RegComportPsoSport;
import it.csi.serse.serseweb.vo.SportMonitoraggio;
import jakarta.validation.constraints.*;

public class DatiPeculiariWrapper   {
  private DestinatarioServizio destinatarioServizio = null;
  private DestinatarioServizioMonitoraggio destinatarioServizioMonitoraggio = null;
  private RegComportPsoSport regComportPsoSport = null;
  private SportMonitoraggio sportMonitoraggio = null;
  private DettaglioClasseDestinatarioServizio dettaglioClasseDestinatario = null;

  /**
   **/
  
  @JsonProperty("destinatarioServizio")
  public DestinatarioServizio getDestinatarioServizio() {
    return destinatarioServizio;
  }
  public void setDestinatarioServizio(DestinatarioServizio destinatarioServizio) {
    this.destinatarioServizio = destinatarioServizio;
  }

  /**
   **/
  
  @JsonProperty("destinatarioServizioMonitoraggio")
  public DestinatarioServizioMonitoraggio getDestinatarioServizioMonitoraggio() {
    return destinatarioServizioMonitoraggio;
  }
  public void setDestinatarioServizioMonitoraggio(DestinatarioServizioMonitoraggio destinatarioServizioMonitoraggio) {
    this.destinatarioServizioMonitoraggio = destinatarioServizioMonitoraggio;
  }

  /**
   **/
  
  @JsonProperty("regComportPsoSport")
  public RegComportPsoSport getRegComportPsoSport() {
    return regComportPsoSport;
  }
  public void setRegComportPsoSport(RegComportPsoSport regComportPsoSport) {
    this.regComportPsoSport = regComportPsoSport;
  }

  /**
   **/
  
  @JsonProperty("sportMonitoraggio")
  public SportMonitoraggio getSportMonitoraggio() {
    return sportMonitoraggio;
  }
  public void setSportMonitoraggio(SportMonitoraggio sportMonitoraggio) {
    this.sportMonitoraggio = sportMonitoraggio;
  }

  /**
   **/
  
  @JsonProperty("dettaglioClasseDestinatario")
  public DettaglioClasseDestinatarioServizio getDettaglioClasseDestinatario() {
    return dettaglioClasseDestinatario;
  }
  public void setDettaglioClasseDestinatario(DettaglioClasseDestinatarioServizio dettaglioClasseDestinatario) {
    this.dettaglioClasseDestinatario = dettaglioClasseDestinatario;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatiPeculiariWrapper datiPeculiariWrapper = (DatiPeculiariWrapper) o;
    return Objects.equals(destinatarioServizio, datiPeculiariWrapper.destinatarioServizio) &&
        Objects.equals(destinatarioServizioMonitoraggio, datiPeculiariWrapper.destinatarioServizioMonitoraggio) &&
        Objects.equals(regComportPsoSport, datiPeculiariWrapper.regComportPsoSport) &&
        Objects.equals(sportMonitoraggio, datiPeculiariWrapper.sportMonitoraggio) &&
        Objects.equals(dettaglioClasseDestinatario, datiPeculiariWrapper.dettaglioClasseDestinatario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinatarioServizio, destinatarioServizioMonitoraggio, regComportPsoSport, sportMonitoraggio, dettaglioClasseDestinatario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatiPeculiariWrapper {\n");
    
    sb.append("    destinatarioServizio: ").append(toIndentedString(destinatarioServizio)).append("\n");
    sb.append("    destinatarioServizioMonitoraggio: ").append(toIndentedString(destinatarioServizioMonitoraggio)).append("\n");
    sb.append("    regComportPsoSport: ").append(toIndentedString(regComportPsoSport)).append("\n");
    sb.append("    sportMonitoraggio: ").append(toIndentedString(sportMonitoraggio)).append("\n");
    sb.append("    dettaglioClasseDestinatario: ").append(toIndentedString(dettaglioClasseDestinatario)).append("\n");
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
