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

public class RegComportPsoSport   {
  private Long idRegComportPsoSport = null;
  private Long idPso = null;
  private Long numProgrSportello = null;
  private String tipoGestioneSoggettiRt = null;
  private String flgGestioneModello = null;
  private String tipoGestioneIntervento = null;
  private String tipoGestioneServizio = null;
  private Long idSistemaGestioneAmm = null;
  private Long idProcessoFinanziamento = null;
  private String labelDatoPeculiare1 = null;
  private String labelDatoPeculiare2 = null;
  private String tipologiaBudgetGam = null;
  private String labelCampoAggiuntivoUno = null;

  /**
   **/
  
  @JsonProperty("idRegComportPsoSport")
  public Long getIdRegComportPsoSport() {
    return idRegComportPsoSport;
  }
  public void setIdRegComportPsoSport(Long idRegComportPsoSport) {
    this.idRegComportPsoSport = idRegComportPsoSport;
  }

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
  
  @JsonProperty("numProgrSportello")
  public Long getNumProgrSportello() {
    return numProgrSportello;
  }
  public void setNumProgrSportello(Long numProgrSportello) {
    this.numProgrSportello = numProgrSportello;
  }

  /**
   **/
  
  @JsonProperty("tipoGestioneSoggettiRt")
  public String getTipoGestioneSoggettiRt() {
    return tipoGestioneSoggettiRt;
  }
  public void setTipoGestioneSoggettiRt(String tipoGestioneSoggettiRt) {
    this.tipoGestioneSoggettiRt = tipoGestioneSoggettiRt;
  }

  /**
   **/
  
  @JsonProperty("flgGestioneModello")
  public String getFlgGestioneModello() {
    return flgGestioneModello;
  }
  public void setFlgGestioneModello(String flgGestioneModello) {
    this.flgGestioneModello = flgGestioneModello;
  }

  /**
   **/
  
  @JsonProperty("tipoGestioneIntervento")
  public String getTipoGestioneIntervento() {
    return tipoGestioneIntervento;
  }
  public void setTipoGestioneIntervento(String tipoGestioneIntervento) {
    this.tipoGestioneIntervento = tipoGestioneIntervento;
  }

  /**
   **/
  
  @JsonProperty("tipoGestioneServizio")
  public String getTipoGestioneServizio() {
    return tipoGestioneServizio;
  }
  public void setTipoGestioneServizio(String tipoGestioneServizio) {
    this.tipoGestioneServizio = tipoGestioneServizio;
  }

  /**
   **/
  
  @JsonProperty("idSistemaGestioneAmm")
  public Long getIdSistemaGestioneAmm() {
    return idSistemaGestioneAmm;
  }
  public void setIdSistemaGestioneAmm(Long idSistemaGestioneAmm) {
    this.idSistemaGestioneAmm = idSistemaGestioneAmm;
  }

  /**
   **/
  
  @JsonProperty("idProcessoFinanziamento")
  public Long getIdProcessoFinanziamento() {
    return idProcessoFinanziamento;
  }
  public void setIdProcessoFinanziamento(Long idProcessoFinanziamento) {
    this.idProcessoFinanziamento = idProcessoFinanziamento;
  }

  /**
   **/
  
  @JsonProperty("labelDatoPeculiare1")
  public String getLabelDatoPeculiare1() {
    return labelDatoPeculiare1;
  }
  public void setLabelDatoPeculiare1(String labelDatoPeculiare1) {
    this.labelDatoPeculiare1 = labelDatoPeculiare1;
  }

  /**
   **/
  
  @JsonProperty("labelDatoPeculiare2")
  public String getLabelDatoPeculiare2() {
    return labelDatoPeculiare2;
  }
  public void setLabelDatoPeculiare2(String labelDatoPeculiare2) {
    this.labelDatoPeculiare2 = labelDatoPeculiare2;
  }

  /**
   **/
  
  @JsonProperty("tipologiaBudgetGam")
  public String getTipologiaBudgetGam() {
    return tipologiaBudgetGam;
  }
  public void setTipologiaBudgetGam(String tipologiaBudgetGam) {
    this.tipologiaBudgetGam = tipologiaBudgetGam;
  }

  /**
   **/
  
  @JsonProperty("labelCampoAggiuntivoUno")
  public String getLabelCampoAggiuntivoUno() {
    return labelCampoAggiuntivoUno;
  }
  public void setLabelCampoAggiuntivoUno(String labelCampoAggiuntivoUno) {
    this.labelCampoAggiuntivoUno = labelCampoAggiuntivoUno;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegComportPsoSport regComportPsoSport = (RegComportPsoSport) o;
    return Objects.equals(idRegComportPsoSport, regComportPsoSport.idRegComportPsoSport) &&
        Objects.equals(idPso, regComportPsoSport.idPso) &&
        Objects.equals(numProgrSportello, regComportPsoSport.numProgrSportello) &&
        Objects.equals(tipoGestioneSoggettiRt, regComportPsoSport.tipoGestioneSoggettiRt) &&
        Objects.equals(flgGestioneModello, regComportPsoSport.flgGestioneModello) &&
        Objects.equals(tipoGestioneIntervento, regComportPsoSport.tipoGestioneIntervento) &&
        Objects.equals(tipoGestioneServizio, regComportPsoSport.tipoGestioneServizio) &&
        Objects.equals(idSistemaGestioneAmm, regComportPsoSport.idSistemaGestioneAmm) &&
        Objects.equals(idProcessoFinanziamento, regComportPsoSport.idProcessoFinanziamento) &&
        Objects.equals(labelDatoPeculiare1, regComportPsoSport.labelDatoPeculiare1) &&
        Objects.equals(labelDatoPeculiare2, regComportPsoSport.labelDatoPeculiare2) &&
        Objects.equals(tipologiaBudgetGam, regComportPsoSport.tipologiaBudgetGam) &&
        Objects.equals(labelCampoAggiuntivoUno, regComportPsoSport.labelCampoAggiuntivoUno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRegComportPsoSport, idPso, numProgrSportello, tipoGestioneSoggettiRt, flgGestioneModello, tipoGestioneIntervento, tipoGestioneServizio, idSistemaGestioneAmm, idProcessoFinanziamento, labelDatoPeculiare1, labelDatoPeculiare2, tipologiaBudgetGam, labelCampoAggiuntivoUno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegComportPsoSport {\n");
    
    sb.append("    idRegComportPsoSport: ").append(toIndentedString(idRegComportPsoSport)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    numProgrSportello: ").append(toIndentedString(numProgrSportello)).append("\n");
    sb.append("    tipoGestioneSoggettiRt: ").append(toIndentedString(tipoGestioneSoggettiRt)).append("\n");
    sb.append("    flgGestioneModello: ").append(toIndentedString(flgGestioneModello)).append("\n");
    sb.append("    tipoGestioneIntervento: ").append(toIndentedString(tipoGestioneIntervento)).append("\n");
    sb.append("    tipoGestioneServizio: ").append(toIndentedString(tipoGestioneServizio)).append("\n");
    sb.append("    idSistemaGestioneAmm: ").append(toIndentedString(idSistemaGestioneAmm)).append("\n");
    sb.append("    idProcessoFinanziamento: ").append(toIndentedString(idProcessoFinanziamento)).append("\n");
    sb.append("    labelDatoPeculiare1: ").append(toIndentedString(labelDatoPeculiare1)).append("\n");
    sb.append("    labelDatoPeculiare2: ").append(toIndentedString(labelDatoPeculiare2)).append("\n");
    sb.append("    tipologiaBudgetGam: ").append(toIndentedString(tipologiaBudgetGam)).append("\n");
    sb.append("    labelCampoAggiuntivoUno: ").append(toIndentedString(labelCampoAggiuntivoUno)).append("\n");
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
