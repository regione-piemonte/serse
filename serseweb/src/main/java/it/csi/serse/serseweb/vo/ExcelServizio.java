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

public class ExcelServizio   {
  private String tipolPso = null;
  private String sportello = null;
  private String soggettoBeneficiario = null;
  private String soggettoAttuatore = null;
  private String progressivoSede = null;
  private String modelId = null;
  private Long idServizio = null;
  private String titolo = null;
  private String tipologiaServizio = null;
  private String finalitaServizio = null;
  private Long idIntervento = null;
  private String statoServizio = null;
  private String durata = null;
  private Integer numMaxDestinatari = null;
  private Integer numeroDestinatariAssociati = null;
  private String cognNomeDesctinatario = null;
  private String cFDestinatario = null;
  private String codUserInserimento = null;
  private String codUserAggiornamento = null;
  private String valoreCampoAggiuntivo1 = null;

  /**
   **/
  
  @JsonProperty("tipolPso")
  public String getTipolPso() {
    return tipolPso;
  }
  public void setTipolPso(String tipolPso) {
    this.tipolPso = tipolPso;
  }

  /**
   **/
  
  @JsonProperty("sportello")
  public String getSportello() {
    return sportello;
  }
  public void setSportello(String sportello) {
    this.sportello = sportello;
  }

  /**
   **/
  
  @JsonProperty("soggettoBeneficiario")
  public String getSoggettoBeneficiario() {
    return soggettoBeneficiario;
  }
  public void setSoggettoBeneficiario(String soggettoBeneficiario) {
    this.soggettoBeneficiario = soggettoBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("soggettoAttuatore")
  public String getSoggettoAttuatore() {
    return soggettoAttuatore;
  }
  public void setSoggettoAttuatore(String soggettoAttuatore) {
    this.soggettoAttuatore = soggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("progressivoSede")
  public String getProgressivoSede() {
    return progressivoSede;
  }
  public void setProgressivoSede(String progressivoSede) {
    this.progressivoSede = progressivoSede;
  }

  /**
   **/
  
  @JsonProperty("modelId")
  public String getModelId() {
    return modelId;
  }
  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

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
  
  @JsonProperty("titolo")
  public String getTitolo() {
    return titolo;
  }
  public void setTitolo(String titolo) {
    this.titolo = titolo;
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
  
  @JsonProperty("durata")
  public String getDurata() {
    return durata;
  }
  public void setDurata(String durata) {
    this.durata = durata;
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
  
  @JsonProperty("numeroDestinatariAssociati")
  public Integer getNumeroDestinatariAssociati() {
    return numeroDestinatariAssociati;
  }
  public void setNumeroDestinatariAssociati(Integer numeroDestinatariAssociati) {
    this.numeroDestinatariAssociati = numeroDestinatariAssociati;
  }

  /**
   **/
  
  @JsonProperty("cognNomeDesctinatario")
  public String getCognNomeDesctinatario() {
    return cognNomeDesctinatario;
  }
  public void setCognNomeDesctinatario(String cognNomeDesctinatario) {
    this.cognNomeDesctinatario = cognNomeDesctinatario;
  }

  /**
   **/
  
  @JsonProperty("cFDestinatario")
  public String getCFDestinatario() {
    return cFDestinatario;
  }
  public void setCFDestinatario(String cFDestinatario) {
    this.cFDestinatario = cFDestinatario;
  }

  /**
   **/
  
  @JsonProperty("codUserInserimento")
  public String getCodUserInserimento() {
    return codUserInserimento;
  }
  public void setCodUserInserimento(String codUserInserimento) {
    this.codUserInserimento = codUserInserimento;
  }

  /**
   **/
  
  @JsonProperty("codUserAggiornamento")
  public String getCodUserAggiornamento() {
    return codUserAggiornamento;
  }
  public void setCodUserAggiornamento(String codUserAggiornamento) {
    this.codUserAggiornamento = codUserAggiornamento;
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
    ExcelServizio excelServizio = (ExcelServizio) o;
    return Objects.equals(tipolPso, excelServizio.tipolPso) &&
        Objects.equals(sportello, excelServizio.sportello) &&
        Objects.equals(soggettoBeneficiario, excelServizio.soggettoBeneficiario) &&
        Objects.equals(soggettoAttuatore, excelServizio.soggettoAttuatore) &&
        Objects.equals(progressivoSede, excelServizio.progressivoSede) &&
        Objects.equals(modelId, excelServizio.modelId) &&
        Objects.equals(idServizio, excelServizio.idServizio) &&
        Objects.equals(titolo, excelServizio.titolo) &&
        Objects.equals(tipologiaServizio, excelServizio.tipologiaServizio) &&
        Objects.equals(finalitaServizio, excelServizio.finalitaServizio) &&
        Objects.equals(idIntervento, excelServizio.idIntervento) &&
        Objects.equals(statoServizio, excelServizio.statoServizio) &&
        Objects.equals(durata, excelServizio.durata) &&
        Objects.equals(numMaxDestinatari, excelServizio.numMaxDestinatari) &&
        Objects.equals(numeroDestinatariAssociati, excelServizio.numeroDestinatariAssociati) &&
        Objects.equals(cognNomeDesctinatario, excelServizio.cognNomeDesctinatario) &&
        Objects.equals(cFDestinatario, excelServizio.cFDestinatario) &&
        Objects.equals(codUserInserimento, excelServizio.codUserInserimento) &&
        Objects.equals(codUserAggiornamento, excelServizio.codUserAggiornamento) &&
        Objects.equals(valoreCampoAggiuntivo1, excelServizio.valoreCampoAggiuntivo1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipolPso, sportello, soggettoBeneficiario, soggettoAttuatore, progressivoSede, modelId, idServizio, titolo, tipologiaServizio, finalitaServizio, idIntervento, statoServizio, durata, numMaxDestinatari, numeroDestinatariAssociati, cognNomeDesctinatario, cFDestinatario, codUserInserimento, codUserAggiornamento, valoreCampoAggiuntivo1);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcelServizio {\n");
    
    sb.append("    tipolPso: ").append(toIndentedString(tipolPso)).append("\n");
    sb.append("    sportello: ").append(toIndentedString(sportello)).append("\n");
    sb.append("    soggettoBeneficiario: ").append(toIndentedString(soggettoBeneficiario)).append("\n");
    sb.append("    soggettoAttuatore: ").append(toIndentedString(soggettoAttuatore)).append("\n");
    sb.append("    progressivoSede: ").append(toIndentedString(progressivoSede)).append("\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    titolo: ").append(toIndentedString(titolo)).append("\n");
    sb.append("    tipologiaServizio: ").append(toIndentedString(tipologiaServizio)).append("\n");
    sb.append("    finalitaServizio: ").append(toIndentedString(finalitaServizio)).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    statoServizio: ").append(toIndentedString(statoServizio)).append("\n");
    sb.append("    durata: ").append(toIndentedString(durata)).append("\n");
    sb.append("    numMaxDestinatari: ").append(toIndentedString(numMaxDestinatari)).append("\n");
    sb.append("    numeroDestinatariAssociati: ").append(toIndentedString(numeroDestinatariAssociati)).append("\n");
    sb.append("    cognNomeDesctinatario: ").append(toIndentedString(cognNomeDesctinatario)).append("\n");
    sb.append("    cFDestinatario: ").append(toIndentedString(cFDestinatario)).append("\n");
    sb.append("    codUserInserimento: ").append(toIndentedString(codUserInserimento)).append("\n");
    sb.append("    codUserAggiornamento: ").append(toIndentedString(codUserAggiornamento)).append("\n");
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
