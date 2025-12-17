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

public class ExcelModelliBean extends ExcelParentBean  {
  private Long idModello = null;
  private String titoloModello = null;
  private String tipologiaModello = null;
  private String finalitaModello = null;
  private String statoModello = null;
  private String cognomeNomeReferente = null;
  private String tipologieServiziPrevisti = null;
  private String previstiServiziEsterni = null;
  private Integer totInterventiAssociati = null;

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
  
  @JsonProperty("titoloModello")
  public String getTitoloModello() {
    return titoloModello;
  }
  public void setTitoloModello(String titoloModello) {
    this.titoloModello = titoloModello;
  }

  /**
   **/
  
  @JsonProperty("tipologiaModello")
  public String getTipologiaModello() {
    return tipologiaModello;
  }
  public void setTipologiaModello(String tipologiaModello) {
    this.tipologiaModello = tipologiaModello;
  }

  /**
   **/
  
  @JsonProperty("finalitaModello")
  public String getFinalitaModello() {
    return finalitaModello;
  }
  public void setFinalitaModello(String finalitaModello) {
    this.finalitaModello = finalitaModello;
  }

  /**
   **/
  
  @JsonProperty("statoModello")
  public String getStatoModello() {
    return statoModello;
  }
  public void setStatoModello(String statoModello) {
    this.statoModello = statoModello;
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
  
  @JsonProperty("tipologieServiziPrevisti")
  public String getTipologieServiziPrevisti() {
    return tipologieServiziPrevisti;
  }
  public void setTipologieServiziPrevisti(String tipologieServiziPrevisti) {
    this.tipologieServiziPrevisti = tipologieServiziPrevisti;
  }

  /**
   **/
  
  @JsonProperty("previstiServiziEsterni")
  public String getPrevistiServiziEsterni() {
    return previstiServiziEsterni;
  }
  public void setPrevistiServiziEsterni(String previstiServiziEsterni) {
    this.previstiServiziEsterni = previstiServiziEsterni;
  }

  /**
   **/
  
  @JsonProperty("totInterventiAssociati")
  public Integer getTotInterventiAssociati() {
    return totInterventiAssociati;
  }
  public void setTotInterventiAssociati(Integer totInterventiAssociati) {
    this.totInterventiAssociati = totInterventiAssociati;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExcelModelliBean excelModelliBean = (ExcelModelliBean) o;
    return Objects.equals(idModello, excelModelliBean.idModello) &&
        Objects.equals(titoloModello, excelModelliBean.titoloModello) &&
        Objects.equals(tipologiaModello, excelModelliBean.tipologiaModello) &&
        Objects.equals(finalitaModello, excelModelliBean.finalitaModello) &&
        Objects.equals(statoModello, excelModelliBean.statoModello) &&
        Objects.equals(cognomeNomeReferente, excelModelliBean.cognomeNomeReferente) &&
        Objects.equals(tipologieServiziPrevisti, excelModelliBean.tipologieServiziPrevisti) &&
        Objects.equals(previstiServiziEsterni, excelModelliBean.previstiServiziEsterni) &&
        Objects.equals(totInterventiAssociati, excelModelliBean.totInterventiAssociati);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idModello, titoloModello, tipologiaModello, finalitaModello, statoModello, cognomeNomeReferente, tipologieServiziPrevisti, previstiServiziEsterni, totInterventiAssociati);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcelModelliBean {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    idModello: ").append(toIndentedString(idModello)).append("\n");
    sb.append("    titoloModello: ").append(toIndentedString(titoloModello)).append("\n");
    sb.append("    tipologiaModello: ").append(toIndentedString(tipologiaModello)).append("\n");
    sb.append("    finalitaModello: ").append(toIndentedString(finalitaModello)).append("\n");
    sb.append("    statoModello: ").append(toIndentedString(statoModello)).append("\n");
    sb.append("    cognomeNomeReferente: ").append(toIndentedString(cognomeNomeReferente)).append("\n");
    sb.append("    tipologieServiziPrevisti: ").append(toIndentedString(tipologieServiziPrevisti)).append("\n");
    sb.append("    previstiServiziEsterni: ").append(toIndentedString(previstiServiziEsterni)).append("\n");
    sb.append("    totInterventiAssociati: ").append(toIndentedString(totInterventiAssociati)).append("\n");
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
