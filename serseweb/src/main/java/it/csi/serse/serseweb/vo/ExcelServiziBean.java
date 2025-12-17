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
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class ExcelServiziBean extends ExcelParentBean  {
  private Long idServizio = null;
  private Integer sede = null;
  private String titoloServizio = null;
  private String tipologiaServizio = null;
  private String finalitaServizio = null;
  private Long idIntervento = null;
  private String statoServizio = null;
  private BigDecimal durataOre = null;
  private Integer numMaxDestinatari = null;
  private Integer numDestinatari = null;
  private String cognomeNomeDestinatario = null;
  private String cfDestinatario = null;
  private Integer totIncontriDefiniti = null;
  private Integer totIncontriChiusi = null;
  private String valoreCampoAggiuntivo1 = null;

  /**
   **/
  
  @JsonProperty("idServizio")
  public Long getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(Long idServizio) {
    this.idServizio = idServizio;
  }

  /**
   **/
  
  @JsonProperty("sede")
  public Integer getSede() {
    return sede;
  }
  public void setSede(Integer sede) {
    this.sede = sede;
  }

  /**
   **/
  
  @JsonProperty("titoloServizio")
  public String getTitoloServizio() {
    return titoloServizio;
  }
  public void setTitoloServizio(String titoloServizio) {
    this.titoloServizio = titoloServizio;
  }

  /**
   **/
  
  @JsonProperty("tipologiaServizio")
  public String getTipologiaServizio() {
    return tipologiaServizio;
  }
  public void setTipologiaServizio(String tipologiaServizio) {
    this.tipologiaServizio = tipologiaServizio;
  }

  /**
   **/
  
  @JsonProperty("finalitaServizio")
  public String getFinalitaServizio() {
    return finalitaServizio;
  }
  public void setFinalitaServizio(String finalitaServizio) {
    this.finalitaServizio = finalitaServizio;
  }

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
  
  @JsonProperty("statoServizio")
  public String getStatoServizio() {
    return statoServizio;
  }
  public void setStatoServizio(String statoServizio) {
    this.statoServizio = statoServizio;
  }

  /**
   **/
  
  @JsonProperty("durataOre")
  public BigDecimal getDurataOre() {
    return durataOre;
  }
  public void setDurataOre(BigDecimal durataOre) {
    this.durataOre = durataOre;
  }

  /**
   **/
  
  @JsonProperty("numMaxDestinatari")
  public Integer getNumMaxDestinatari() {
    return numMaxDestinatari;
  }
  public void setNumMaxDestinatari(Integer numMaxDestinatari) {
    this.numMaxDestinatari = numMaxDestinatari;
  }

  /**
   **/
  
  @JsonProperty("numDestinatari")
  public Integer getNumDestinatari() {
    return numDestinatari;
  }
  public void setNumDestinatari(Integer numDestinatari) {
    this.numDestinatari = numDestinatari;
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
  
  @JsonProperty("totIncontriDefiniti")
  public Integer getTotIncontriDefiniti() {
    return totIncontriDefiniti;
  }
  public void setTotIncontriDefiniti(Integer totIncontriDefiniti) {
    this.totIncontriDefiniti = totIncontriDefiniti;
  }

  /**
   **/
  
  @JsonProperty("totIncontriChiusi")
  public Integer getTotIncontriChiusi() {
    return totIncontriChiusi;
  }
  public void setTotIncontriChiusi(Integer totIncontriChiusi) {
    this.totIncontriChiusi = totIncontriChiusi;
  }

  /**
   **/
  
  @JsonProperty("valoreCampoAggiuntivo1")
  public String getValoreCampoAggiuntivo1() {
    return valoreCampoAggiuntivo1;
  }
  public void setValoreCampoAggiuntivo1(String valoreCampoAggiuntivo1) {
    this.valoreCampoAggiuntivo1 = valoreCampoAggiuntivo1;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExcelServiziBean excelServiziBean = (ExcelServiziBean) o;
    return Objects.equals(idServizio, excelServiziBean.idServizio) &&
        Objects.equals(sede, excelServiziBean.sede) &&
        Objects.equals(titoloServizio, excelServiziBean.titoloServizio) &&
        Objects.equals(tipologiaServizio, excelServiziBean.tipologiaServizio) &&
        Objects.equals(finalitaServizio, excelServiziBean.finalitaServizio) &&
        Objects.equals(idIntervento, excelServiziBean.idIntervento) &&
        Objects.equals(statoServizio, excelServiziBean.statoServizio) &&
        Objects.equals(durataOre, excelServiziBean.durataOre) &&
        Objects.equals(numMaxDestinatari, excelServiziBean.numMaxDestinatari) &&
        Objects.equals(numDestinatari, excelServiziBean.numDestinatari) &&
        Objects.equals(cognomeNomeDestinatario, excelServiziBean.cognomeNomeDestinatario) &&
        Objects.equals(cfDestinatario, excelServiziBean.cfDestinatario) &&
        Objects.equals(totIncontriDefiniti, excelServiziBean.totIncontriDefiniti) &&
        Objects.equals(totIncontriChiusi, excelServiziBean.totIncontriChiusi) &&
        Objects.equals(valoreCampoAggiuntivo1, excelServiziBean.valoreCampoAggiuntivo1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizio, sede, titoloServizio, tipologiaServizio, finalitaServizio, idIntervento, statoServizio, durataOre, numMaxDestinatari, numDestinatari, cognomeNomeDestinatario, cfDestinatario, totIncontriDefiniti, totIncontriChiusi, valoreCampoAggiuntivo1);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcelServiziBean {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    sede: ").append(toIndentedString(sede)).append("\n");
    sb.append("    titoloServizio: ").append(toIndentedString(titoloServizio)).append("\n");
    sb.append("    tipologiaServizio: ").append(toIndentedString(tipologiaServizio)).append("\n");
    sb.append("    finalitaServizio: ").append(toIndentedString(finalitaServizio)).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    statoServizio: ").append(toIndentedString(statoServizio)).append("\n");
    sb.append("    durataOre: ").append(toIndentedString(durataOre)).append("\n");
    sb.append("    numMaxDestinatari: ").append(toIndentedString(numMaxDestinatari)).append("\n");
    sb.append("    numDestinatari: ").append(toIndentedString(numDestinatari)).append("\n");
    sb.append("    cognomeNomeDestinatario: ").append(toIndentedString(cognomeNomeDestinatario)).append("\n");
    sb.append("    cfDestinatario: ").append(toIndentedString(cfDestinatario)).append("\n");
    sb.append("    totIncontriDefiniti: ").append(toIndentedString(totIncontriDefiniti)).append("\n");
    sb.append("    totIncontriChiusi: ").append(toIndentedString(totIncontriChiusi)).append("\n");
    sb.append("    valoreCampoAggiuntivo1: ").append(toIndentedString(valoreCampoAggiuntivo1)).append("\n");
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
