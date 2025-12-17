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

public class DestinatarioServizioMonitoraggio   {
  private Long idDestinatarioServizio = null;
  private String codTitoloStudioIgrue = null;
  private String codCondizioneOccupazionaleIgrue = null;
  private String flgDisabilita = null;
  private String flgSvantaggioAbitativo = null;
  private String codiceCitadinanza = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiornam = null;

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
  
  @JsonProperty("codTitoloStudioIgrue")
  public String getCodTitoloStudioIgrue() {
    return codTitoloStudioIgrue;
  }
  public void setCodTitoloStudioIgrue(String codTitoloStudioIgrue) {
    this.codTitoloStudioIgrue = codTitoloStudioIgrue;
  }

  /**
   **/
  
  @JsonProperty("codCondizioneOccupazionaleIgrue")
  public String getCodCondizioneOccupazionaleIgrue() {
    return codCondizioneOccupazionaleIgrue;
  }
  public void setCodCondizioneOccupazionaleIgrue(String codCondizioneOccupazionaleIgrue) {
    this.codCondizioneOccupazionaleIgrue = codCondizioneOccupazionaleIgrue;
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
  
  @JsonProperty("codiceCitadinanza")
  public String getCodiceCitadinanza() {
    return codiceCitadinanza;
  }
  public void setCodiceCitadinanza(String codiceCitadinanza) {
    this.codiceCitadinanza = codiceCitadinanza;
  }

  /**
   **/
  
  @JsonProperty("codUserInserim")
  public String getCodUserInserim() {
    return codUserInserim;
  }
  public void setCodUserInserim(String codUserInserim) {
    this.codUserInserim = codUserInserim;
  }

  /**
   **/
  
  @JsonProperty("dInserim")
  public Date getDInserim() {
    return dInserim;
  }
  public void setDInserim(Date dInserim) {
    this.dInserim = dInserim;
  }

  /**
   **/
  
  @JsonProperty("codUserAggiorn")
  public String getCodUserAggiorn() {
    return codUserAggiorn;
  }
  public void setCodUserAggiorn(String codUserAggiorn) {
    this.codUserAggiorn = codUserAggiorn;
  }

  /**
   **/
  
  @JsonProperty("dAggiornam")
  public Date getDAggiornam() {
    return dAggiornam;
  }
  public void setDAggiornam(Date dAggiornam) {
    this.dAggiornam = dAggiornam;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinatarioServizioMonitoraggio destinatarioServizioMonitoraggio = (DestinatarioServizioMonitoraggio) o;
    return Objects.equals(idDestinatarioServizio, destinatarioServizioMonitoraggio.idDestinatarioServizio) &&
        Objects.equals(codTitoloStudioIgrue, destinatarioServizioMonitoraggio.codTitoloStudioIgrue) &&
        Objects.equals(codCondizioneOccupazionaleIgrue, destinatarioServizioMonitoraggio.codCondizioneOccupazionaleIgrue) &&
        Objects.equals(flgDisabilita, destinatarioServizioMonitoraggio.flgDisabilita) &&
        Objects.equals(flgSvantaggioAbitativo, destinatarioServizioMonitoraggio.flgSvantaggioAbitativo) &&
        Objects.equals(codiceCitadinanza, destinatarioServizioMonitoraggio.codiceCitadinanza) &&
        Objects.equals(codUserInserim, destinatarioServizioMonitoraggio.codUserInserim) &&
        Objects.equals(dInserim, destinatarioServizioMonitoraggio.dInserim) &&
        Objects.equals(codUserAggiorn, destinatarioServizioMonitoraggio.codUserAggiorn) &&
        Objects.equals(dAggiornam, destinatarioServizioMonitoraggio.dAggiornam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDestinatarioServizio, codTitoloStudioIgrue, codCondizioneOccupazionaleIgrue, flgDisabilita, flgSvantaggioAbitativo, codiceCitadinanza, codUserInserim, dInserim, codUserAggiorn, dAggiornam);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinatarioServizioMonitoraggio {\n");
    
    sb.append("    idDestinatarioServizio: ").append(toIndentedString(idDestinatarioServizio)).append("\n");
    sb.append("    codTitoloStudioIgrue: ").append(toIndentedString(codTitoloStudioIgrue)).append("\n");
    sb.append("    codCondizioneOccupazionaleIgrue: ").append(toIndentedString(codCondizioneOccupazionaleIgrue)).append("\n");
    sb.append("    flgDisabilita: ").append(toIndentedString(flgDisabilita)).append("\n");
    sb.append("    flgSvantaggioAbitativo: ").append(toIndentedString(flgSvantaggioAbitativo)).append("\n");
    sb.append("    codiceCitadinanza: ").append(toIndentedString(codiceCitadinanza)).append("\n");
    sb.append("    codUserInserim: ").append(toIndentedString(codUserInserim)).append("\n");
    sb.append("    dInserim: ").append(toIndentedString(dInserim)).append("\n");
    sb.append("    codUserAggiorn: ").append(toIndentedString(codUserAggiorn)).append("\n");
    sb.append("    dAggiornam: ").append(toIndentedString(dAggiornam)).append("\n");
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
