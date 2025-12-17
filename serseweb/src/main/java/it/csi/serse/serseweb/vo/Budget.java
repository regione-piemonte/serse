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
import it.csi.serse.serseweb.vo.AreaTerritoriale;
import it.csi.serse.serseweb.vo.ClassTabFinanziamentoBudgetDisponibile;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class Budget   {
  private Long istanza = null;
  private String codEsito = null;
  private String descrEsito = null;
  private SoggettoAttuatore soggettoAttuatore = null;
  private AreaTerritoriale areaTerritoriale = null;
  private Long fascia = null;
  private ClassTabFinanziamentoBudgetDisponibile classificazioneFinanziamento = null;
  private Long idFonte = null;
  private String descrFonte = null;
  private BigDecimal stanziato = null;
  private BigDecimal finanziato = null;
  private BigDecimal residuo = null;

  /**
   * model_id, identificativo dell’istanza
   **/
  
  @JsonProperty("istanza")
  public Long getIstanza() {
    return istanza;
  }
  public void setIstanza(Long istanza) {
    this.istanza = istanza;
  }

  /**
   **/
  
  @JsonProperty("codEsito")
  public String getCodEsito() {
    return codEsito;
  }
  public void setCodEsito(String codEsito) {
    this.codEsito = codEsito;
  }

  /**
   **/
  
  @JsonProperty("descrEsito")
  public String getDescrEsito() {
    return descrEsito;
  }
  public void setDescrEsito(String descrEsito) {
    this.descrEsito = descrEsito;
  }

  /**
   **/
  
  @JsonProperty("soggettoAttuatore")
  public SoggettoAttuatore getSoggettoAttuatore() {
    return soggettoAttuatore;
  }
  public void setSoggettoAttuatore(SoggettoAttuatore soggettoAttuatore) {
    this.soggettoAttuatore = soggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("areaTerritoriale")
  public AreaTerritoriale getAreaTerritoriale() {
    return areaTerritoriale;
  }
  public void setAreaTerritoriale(AreaTerritoriale areaTerritoriale) {
    this.areaTerritoriale = areaTerritoriale;
  }

  /**
   * identificativo fascia indicato
   **/
  
  @JsonProperty("fascia")
  public Long getFascia() {
    return fascia;
  }
  public void setFascia(Long fascia) {
    this.fascia = fascia;
  }

  /**
   **/
  
  @JsonProperty("classificazioneFinanziamento")
  public ClassTabFinanziamentoBudgetDisponibile getClassificazioneFinanziamento() {
    return classificazioneFinanziamento;
  }
  public void setClassificazioneFinanziamento(ClassTabFinanziamentoBudgetDisponibile classificazioneFinanziamento) {
    this.classificazioneFinanziamento = classificazioneFinanziamento;
  }

  /**
   **/
  
  @JsonProperty("idFonte")
  public Long getIdFonte() {
    return idFonte;
  }
  public void setIdFonte(Long idFonte) {
    this.idFonte = idFonte;
  }

  /**
   **/
  
  @JsonProperty("descrFonte")
  public String getDescrFonte() {
    return descrFonte;
  }
  public void setDescrFonte(String descrFonte) {
    this.descrFonte = descrFonte;
  }

  /**
   **/
  
  @JsonProperty("stanziato")
  public BigDecimal getStanziato() {
    return stanziato;
  }
  public void setStanziato(BigDecimal stanziato) {
    this.stanziato = stanziato;
  }

  /**
   **/
  
  @JsonProperty("finanziato")
  public BigDecimal getFinanziato() {
    return finanziato;
  }
  public void setFinanziato(BigDecimal finanziato) {
    this.finanziato = finanziato;
  }

  /**
   **/
  
  @JsonProperty("residuo")
  public BigDecimal getResiduo() {
    return residuo;
  }
  public void setResiduo(BigDecimal residuo) {
    this.residuo = residuo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Budget budget = (Budget) o;
    return Objects.equals(istanza, budget.istanza) &&
        Objects.equals(codEsito, budget.codEsito) &&
        Objects.equals(descrEsito, budget.descrEsito) &&
        Objects.equals(soggettoAttuatore, budget.soggettoAttuatore) &&
        Objects.equals(areaTerritoriale, budget.areaTerritoriale) &&
        Objects.equals(fascia, budget.fascia) &&
        Objects.equals(classificazioneFinanziamento, budget.classificazioneFinanziamento) &&
        Objects.equals(idFonte, budget.idFonte) &&
        Objects.equals(descrFonte, budget.descrFonte) &&
        Objects.equals(stanziato, budget.stanziato) &&
        Objects.equals(finanziato, budget.finanziato) &&
        Objects.equals(residuo, budget.residuo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(istanza, codEsito, descrEsito, soggettoAttuatore, areaTerritoriale, fascia, classificazioneFinanziamento, idFonte, descrFonte, stanziato, finanziato, residuo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Budget {\n");
    
    sb.append("    istanza: ").append(toIndentedString(istanza)).append("\n");
    sb.append("    codEsito: ").append(toIndentedString(codEsito)).append("\n");
    sb.append("    descrEsito: ").append(toIndentedString(descrEsito)).append("\n");
    sb.append("    soggettoAttuatore: ").append(toIndentedString(soggettoAttuatore)).append("\n");
    sb.append("    areaTerritoriale: ").append(toIndentedString(areaTerritoriale)).append("\n");
    sb.append("    fascia: ").append(toIndentedString(fascia)).append("\n");
    sb.append("    classificazioneFinanziamento: ").append(toIndentedString(classificazioneFinanziamento)).append("\n");
    sb.append("    idFonte: ").append(toIndentedString(idFonte)).append("\n");
    sb.append("    descrFonte: ").append(toIndentedString(descrFonte)).append("\n");
    sb.append("    stanziato: ").append(toIndentedString(stanziato)).append("\n");
    sb.append("    finanziato: ").append(toIndentedString(finanziato)).append("\n");
    sb.append("    residuo: ").append(toIndentedString(residuo)).append("\n");
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
