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
import it.csi.serse.serseweb.vo.ExcelParentBean;
import jakarta.validation.constraints.*;

public class ExcelInterventiBean extends ExcelParentBean  {
  private Long idIntervento = null;
  private String titoloIntervento = null;
  private String tipologiaIntervento = null;
  private String finalitaIntervento = null;
  private Long idModello = null;
  private String statoIntervento = null;
  private String cognomeNomeReferente = null;
  private String cognomeNomeDestinatario = null;
  private String cfDestinatario = null;
  private String tipologieServiziPrevisti = null;
  private Integer totServiziInclusi = null;
  private Integer totServiziChiusi = null;

  /**
   **/
  
  @JsonProperty("idIntervento")
  public Long getIdIntervento() {
    return idIntervento;
  }
  public void setIdIntervento(Long idIntervento) {
    this.idIntervento = idIntervento;
  }

  /**
   **/
  
  @JsonProperty("titoloIntervento")
  public String getTitoloIntervento() {
    return titoloIntervento;
  }
  public void setTitoloIntervento(String titoloIntervento) {
    this.titoloIntervento = titoloIntervento;
  }

  /**
   **/
  
  @JsonProperty("tipologiaIntervento")
  public String getTipologiaIntervento() {
    return tipologiaIntervento;
  }
  public void setTipologiaIntervento(String tipologiaIntervento) {
    this.tipologiaIntervento = tipologiaIntervento;
  }

  /**
   **/
  
  @JsonProperty("finalitaIntervento")
  public String getFinalitaIntervento() {
    return finalitaIntervento;
  }
  public void setFinalitaIntervento(String finalitaIntervento) {
    this.finalitaIntervento = finalitaIntervento;
  }

  /**
   **/
  
  @JsonProperty("idModello")
  public Long getIdModello() {
    return idModello;
  }
  public void setIdModello(Long idModello) {
    this.idModello = idModello;
  }

  /**
   **/
  
  @JsonProperty("statoIntervento")
  public String getStatoIntervento() {
    return statoIntervento;
  }
  public void setStatoIntervento(String statoIntervento) {
    this.statoIntervento = statoIntervento;
  }

  /**
   **/
  
  @JsonProperty("cognomeNomeReferente")
  public String getCognomeNomeReferente() {
    return cognomeNomeReferente;
  }
  public void setCognomeNomeReferente(String cognomeNomeReferente) {
    this.cognomeNomeReferente = cognomeNomeReferente;
  }

  /**
   **/
  
  @JsonProperty("cognomeNomeDestinatario")
  public String getCognomeNomeDestinatario() {
    return cognomeNomeDestinatario;
  }
  public void setCognomeNomeDestinatario(String cognomeNomeDestinatario) {
    this.cognomeNomeDestinatario = cognomeNomeDestinatario;
  }

  /**
   **/
  
  @JsonProperty("cfDestinatario")
  public String getCfDestinatario() {
    return cfDestinatario;
  }
  public void setCfDestinatario(String cfDestinatario) {
    this.cfDestinatario = cfDestinatario;
  }

  /**
   **/
  
  @JsonProperty("tipologieServiziPrevisti")
  public String getTipologieServiziPrevisti() {
    return tipologieServiziPrevisti;
  }
  public void setTipologieServiziPrevisti(String tipologieServiziPrevisti) {
    this.tipologieServiziPrevisti = tipologieServiziPrevisti;
  }

  /**
   **/
  
  @JsonProperty("totServiziInclusi")
  public Integer getTotServiziInclusi() {
    return totServiziInclusi;
  }
  public void setTotServiziInclusi(Integer totServiziInclusi) {
    this.totServiziInclusi = totServiziInclusi;
  }

  /**
   **/
  
  @JsonProperty("totServiziChiusi")
  public Integer getTotServiziChiusi() {
    return totServiziChiusi;
  }
  public void setTotServiziChiusi(Integer totServiziChiusi) {
    this.totServiziChiusi = totServiziChiusi;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExcelInterventiBean excelInterventiBean = (ExcelInterventiBean) o;
    return Objects.equals(idIntervento, excelInterventiBean.idIntervento) &&
        Objects.equals(titoloIntervento, excelInterventiBean.titoloIntervento) &&
        Objects.equals(tipologiaIntervento, excelInterventiBean.tipologiaIntervento) &&
        Objects.equals(finalitaIntervento, excelInterventiBean.finalitaIntervento) &&
        Objects.equals(idModello, excelInterventiBean.idModello) &&
        Objects.equals(statoIntervento, excelInterventiBean.statoIntervento) &&
        Objects.equals(cognomeNomeReferente, excelInterventiBean.cognomeNomeReferente) &&
        Objects.equals(cognomeNomeDestinatario, excelInterventiBean.cognomeNomeDestinatario) &&
        Objects.equals(cfDestinatario, excelInterventiBean.cfDestinatario) &&
        Objects.equals(tipologieServiziPrevisti, excelInterventiBean.tipologieServiziPrevisti) &&
        Objects.equals(totServiziInclusi, excelInterventiBean.totServiziInclusi) &&
        Objects.equals(totServiziChiusi, excelInterventiBean.totServiziChiusi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIntervento, titoloIntervento, tipologiaIntervento, finalitaIntervento, idModello, statoIntervento, cognomeNomeReferente, cognomeNomeDestinatario, cfDestinatario, tipologieServiziPrevisti, totServiziInclusi, totServiziChiusi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcelInterventiBean {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    titoloIntervento: ").append(toIndentedString(titoloIntervento)).append("\n");
    sb.append("    tipologiaIntervento: ").append(toIndentedString(tipologiaIntervento)).append("\n");
    sb.append("    finalitaIntervento: ").append(toIndentedString(finalitaIntervento)).append("\n");
    sb.append("    idModello: ").append(toIndentedString(idModello)).append("\n");
    sb.append("    statoIntervento: ").append(toIndentedString(statoIntervento)).append("\n");
    sb.append("    cognomeNomeReferente: ").append(toIndentedString(cognomeNomeReferente)).append("\n");
    sb.append("    cognomeNomeDestinatario: ").append(toIndentedString(cognomeNomeDestinatario)).append("\n");
    sb.append("    cfDestinatario: ").append(toIndentedString(cfDestinatario)).append("\n");
    sb.append("    tipologieServiziPrevisti: ").append(toIndentedString(tipologieServiziPrevisti)).append("\n");
    sb.append("    totServiziInclusi: ").append(toIndentedString(totServiziInclusi)).append("\n");
    sb.append("    totServiziChiusi: ").append(toIndentedString(totServiziChiusi)).append("\n");
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
