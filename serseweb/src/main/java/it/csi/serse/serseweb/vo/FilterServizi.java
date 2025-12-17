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
import it.csi.serse.serseweb.vo.CriterioCiStr;
import it.csi.serse.serseweb.vo.CriterioEqBool;
import it.csi.serse.serseweb.vo.CriterioEqInt;
import it.csi.serse.serseweb.vo.CriterioEqLong;
import it.csi.serse.serseweb.vo.CriterioEqStr;
import it.csi.serse.serseweb.vo.FilterParent;
import it.csi.serse.serseweb.vo.FilterServiziSituazioneIncontro;
import jakarta.validation.constraints.*;

public class FilterServizi extends FilterParent  {
  private CriterioEqLong idServizio = null;
  private CriterioEqInt idServizioRegionale = null;
  private CriterioCiStr denominazioneEnte = null;
  private CriterioEqStr codFiscaleDestinatario = null;
  private CriterioEqInt idStatoServizio = null;
  private CriterioEqStr idFinalitaServizio = null;
  private FilterServiziSituazioneIncontro situazioneIncontro = null;
  private CriterioEqInt progressivoSede = null;

  /**
   **/
  
  @JsonProperty("idServizio")
  public CriterioEqLong getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(CriterioEqLong idServizio) {
    this.idServizio = idServizio;
  }

  /**
   **/
  
  @JsonProperty("idServizioRegionale")
  public CriterioEqInt getIdServizioRegionale() {
    return idServizioRegionale;
  }
  public void setIdServizioRegionale(CriterioEqInt idServizioRegionale) {
    this.idServizioRegionale = idServizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("denominazioneEnte")
  public CriterioCiStr getDenominazioneEnte() {
    return denominazioneEnte;
  }
  public void setDenominazioneEnte(CriterioCiStr denominazioneEnte) {
    this.denominazioneEnte = denominazioneEnte;
  }

  /**
   **/
  
  @JsonProperty("codFiscaleDestinatario")
  public CriterioEqStr getCodFiscaleDestinatario() {
    return codFiscaleDestinatario;
  }
  public void setCodFiscaleDestinatario(CriterioEqStr codFiscaleDestinatario) {
    this.codFiscaleDestinatario = codFiscaleDestinatario;
  }

  /**
   **/
  
  @JsonProperty("idStatoServizio")
  public CriterioEqInt getIdStatoServizio() {
    return idStatoServizio;
  }
  public void setIdStatoServizio(CriterioEqInt idStatoServizio) {
    this.idStatoServizio = idStatoServizio;
  }

  /**
   **/
  
  @JsonProperty("idFinalitaServizio")
  public CriterioEqStr getIdFinalitaServizio() {
    return idFinalitaServizio;
  }
  public void setIdFinalitaServizio(CriterioEqStr idFinalitaServizio) {
    this.idFinalitaServizio = idFinalitaServizio;
  }

  /**
   **/
  
  @JsonProperty("situazioneIncontro")
  public FilterServiziSituazioneIncontro getSituazioneIncontro() {
    return situazioneIncontro;
  }
  public void setSituazioneIncontro(FilterServiziSituazioneIncontro situazioneIncontro) {
    this.situazioneIncontro = situazioneIncontro;
  }

  /**
   **/
  
  @JsonProperty("progressivoSede")
  public CriterioEqInt getProgressivoSede() {
    return progressivoSede;
  }
  public void setProgressivoSede(CriterioEqInt progressivoSede) {
    this.progressivoSede = progressivoSede;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterServizi filterServizi = (FilterServizi) o;
    return Objects.equals(idServizio, filterServizi.idServizio) &&
        Objects.equals(idServizioRegionale, filterServizi.idServizioRegionale) &&
        Objects.equals(denominazioneEnte, filterServizi.denominazioneEnte) &&
        Objects.equals(codFiscaleDestinatario, filterServizi.codFiscaleDestinatario) &&
        Objects.equals(idStatoServizio, filterServizi.idStatoServizio) &&
        Objects.equals(idFinalitaServizio, filterServizi.idFinalitaServizio) &&
        Objects.equals(situazioneIncontro, filterServizi.situazioneIncontro) &&
        Objects.equals(progressivoSede, filterServizi.progressivoSede);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizio, idServizioRegionale, denominazioneEnte, codFiscaleDestinatario, idStatoServizio, idFinalitaServizio, situazioneIncontro, progressivoSede);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterServizi {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    idServizioRegionale: ").append(toIndentedString(idServizioRegionale)).append("\n");
    sb.append("    denominazioneEnte: ").append(toIndentedString(denominazioneEnte)).append("\n");
    sb.append("    codFiscaleDestinatario: ").append(toIndentedString(codFiscaleDestinatario)).append("\n");
    sb.append("    idStatoServizio: ").append(toIndentedString(idStatoServizio)).append("\n");
    sb.append("    idFinalitaServizio: ").append(toIndentedString(idFinalitaServizio)).append("\n");
    sb.append("    situazioneIncontro: ").append(toIndentedString(situazioneIncontro)).append("\n");
    sb.append("    progressivoSede: ").append(toIndentedString(progressivoSede)).append("\n");
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
