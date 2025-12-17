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
import it.csi.serse.serseweb.vo.FontiImportiBudgetDisponibile;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class ClassTabFinanziamentoBudgetDisponibile   {
  private String codAreaTerritoriale = null;
  private Long idFascia = null;
  private String asse = null;
  private String obiettivo = null;
  private String attivita = null;
  private String codAzione = null;
  private BigDecimal importoStanziato = null;
  private BigDecimal importoUtilizzato = null;
  private BigDecimal importoResiduo = null;
  private FontiImportiBudgetDisponibile fontiImportiBudgetDisponibile = null;

  /**
   **/
  
  @JsonProperty("codAreaTerritoriale")
  public String getCodAreaTerritoriale() {
    return codAreaTerritoriale;
  }
  public void setCodAreaTerritoriale(String codAreaTerritoriale) {
    this.codAreaTerritoriale = codAreaTerritoriale;
  }

  /**
   **/
  
  @JsonProperty("idFascia")
  public Long getIdFascia() {
    return idFascia;
  }
  public void setIdFascia(Long idFascia) {
    this.idFascia = idFascia;
  }

  /**
   **/
  
  @JsonProperty("asse")
  public String getAsse() {
    return asse;
  }
  public void setAsse(String asse) {
    this.asse = asse;
  }

  /**
   **/
  
  @JsonProperty("obiettivo")
  public String getObiettivo() {
    return obiettivo;
  }
  public void setObiettivo(String obiettivo) {
    this.obiettivo = obiettivo;
  }

  /**
   **/
  
  @JsonProperty("attivita")
  public String getAttivita() {
    return attivita;
  }
  public void setAttivita(String attivita) {
    this.attivita = attivita;
  }

  /**
   **/
  
  @JsonProperty("codAzione")
  public String getCodAzione() {
    return codAzione;
  }
  public void setCodAzione(String codAzione) {
    this.codAzione = codAzione;
  }

  /**
   **/
  
  @JsonProperty("importoStanziato")
  public BigDecimal getImportoStanziato() {
    return importoStanziato;
  }
  public void setImportoStanziato(BigDecimal importoStanziato) {
    this.importoStanziato = importoStanziato;
  }

  /**
   **/
  
  @JsonProperty("importoUtilizzato")
  public BigDecimal getImportoUtilizzato() {
    return importoUtilizzato;
  }
  public void setImportoUtilizzato(BigDecimal importoUtilizzato) {
    this.importoUtilizzato = importoUtilizzato;
  }

  /**
   **/
  
  @JsonProperty("importoResiduo")
  public BigDecimal getImportoResiduo() {
    return importoResiduo;
  }
  public void setImportoResiduo(BigDecimal importoResiduo) {
    this.importoResiduo = importoResiduo;
  }

  /**
   **/
  
  @JsonProperty("fontiImportiBudgetDisponibile")
  public FontiImportiBudgetDisponibile getFontiImportiBudgetDisponibile() {
    return fontiImportiBudgetDisponibile;
  }
  public void setFontiImportiBudgetDisponibile(FontiImportiBudgetDisponibile fontiImportiBudgetDisponibile) {
    this.fontiImportiBudgetDisponibile = fontiImportiBudgetDisponibile;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassTabFinanziamentoBudgetDisponibile classTabFinanziamentoBudgetDisponibile = (ClassTabFinanziamentoBudgetDisponibile) o;
    return Objects.equals(codAreaTerritoriale, classTabFinanziamentoBudgetDisponibile.codAreaTerritoriale) &&
        Objects.equals(idFascia, classTabFinanziamentoBudgetDisponibile.idFascia) &&
        Objects.equals(asse, classTabFinanziamentoBudgetDisponibile.asse) &&
        Objects.equals(obiettivo, classTabFinanziamentoBudgetDisponibile.obiettivo) &&
        Objects.equals(attivita, classTabFinanziamentoBudgetDisponibile.attivita) &&
        Objects.equals(codAzione, classTabFinanziamentoBudgetDisponibile.codAzione) &&
        Objects.equals(importoStanziato, classTabFinanziamentoBudgetDisponibile.importoStanziato) &&
        Objects.equals(importoUtilizzato, classTabFinanziamentoBudgetDisponibile.importoUtilizzato) &&
        Objects.equals(importoResiduo, classTabFinanziamentoBudgetDisponibile.importoResiduo) &&
        Objects.equals(fontiImportiBudgetDisponibile, classTabFinanziamentoBudgetDisponibile.fontiImportiBudgetDisponibile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codAreaTerritoriale, idFascia, asse, obiettivo, attivita, codAzione, importoStanziato, importoUtilizzato, importoResiduo, fontiImportiBudgetDisponibile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassTabFinanziamentoBudgetDisponibile {\n");
    
    sb.append("    codAreaTerritoriale: ").append(toIndentedString(codAreaTerritoriale)).append("\n");
    sb.append("    idFascia: ").append(toIndentedString(idFascia)).append("\n");
    sb.append("    asse: ").append(toIndentedString(asse)).append("\n");
    sb.append("    obiettivo: ").append(toIndentedString(obiettivo)).append("\n");
    sb.append("    attivita: ").append(toIndentedString(attivita)).append("\n");
    sb.append("    codAzione: ").append(toIndentedString(codAzione)).append("\n");
    sb.append("    importoStanziato: ").append(toIndentedString(importoStanziato)).append("\n");
    sb.append("    importoUtilizzato: ").append(toIndentedString(importoUtilizzato)).append("\n");
    sb.append("    importoResiduo: ").append(toIndentedString(importoResiduo)).append("\n");
    sb.append("    fontiImportiBudgetDisponibile: ").append(toIndentedString(fontiImportiBudgetDisponibile)).append("\n");
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
