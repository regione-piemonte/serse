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
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class ServizioRegionale   {
  private Long idServizioRegionale = null;
  private Long idPso = null;
  private Long idClassificazione = null;
  private String codiceServizioRegionale = null;
  private String descrServizioRegionale = null;
  private String codFinalitaServizio = null;
  private String descrFinalitaServizio = null;
  private BigDecimal durataInOre = null;
  private Integer oreConsentiteMin = null;
  private Integer oreConsentiteMax = null;
  private String flgCampoAggiuntivoUno = null;

  /**
   **/
  
  @JsonProperty("idServizioRegionale")
  public Long getIdServizioRegionale() {
    return idServizioRegionale;
  }
  public void setIdServizioRegionale(Long idServizioRegionale) {
    this.idServizioRegionale = idServizioRegionale;
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
  
  @JsonProperty("idClassificazione")
  public Long getIdClassificazione() {
    return idClassificazione;
  }
  public void setIdClassificazione(Long idClassificazione) {
    this.idClassificazione = idClassificazione;
  }

  /**
   **/
  
  @JsonProperty("codiceServizioRegionale")
  public String getCodiceServizioRegionale() {
    return codiceServizioRegionale;
  }
  public void setCodiceServizioRegionale(String codiceServizioRegionale) {
    this.codiceServizioRegionale = codiceServizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("descrServizioRegionale")
  public String getDescrServizioRegionale() {
    return descrServizioRegionale;
  }
  public void setDescrServizioRegionale(String descrServizioRegionale) {
    this.descrServizioRegionale = descrServizioRegionale;
  }

  /**
   **/
  
  @JsonProperty("codFinalitaServizio")
  public String getCodFinalitaServizio() {
    return codFinalitaServizio;
  }
  public void setCodFinalitaServizio(String codFinalitaServizio) {
    this.codFinalitaServizio = codFinalitaServizio;
  }

  /**
   **/
  
  @JsonProperty("descrFinalitaServizio")
  public String getDescrFinalitaServizio() {
    return descrFinalitaServizio;
  }
  public void setDescrFinalitaServizio(String descrFinalitaServizio) {
    this.descrFinalitaServizio = descrFinalitaServizio;
  }

  /**
   **/
  
  @JsonProperty("durataInOre")
  public BigDecimal getDurataInOre() {
    return durataInOre;
  }
  public void setDurataInOre(BigDecimal durataInOre) {
    this.durataInOre = durataInOre;
  }

  /**
   **/
  
  @JsonProperty("oreConsentiteMin")
  public Integer getOreConsentiteMin() {
    return oreConsentiteMin;
  }
  public void setOreConsentiteMin(Integer oreConsentiteMin) {
    this.oreConsentiteMin = oreConsentiteMin;
  }

  /**
   **/
  
  @JsonProperty("oreConsentiteMax")
  public Integer getOreConsentiteMax() {
    return oreConsentiteMax;
  }
  public void setOreConsentiteMax(Integer oreConsentiteMax) {
    this.oreConsentiteMax = oreConsentiteMax;
  }

  /**
   **/
  
  @JsonProperty("flgCampoAggiuntivoUno")
  public String getFlgCampoAggiuntivoUno() {
    return flgCampoAggiuntivoUno;
  }
  public void setFlgCampoAggiuntivoUno(String flgCampoAggiuntivoUno) {
    this.flgCampoAggiuntivoUno = flgCampoAggiuntivoUno;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServizioRegionale servizioRegionale = (ServizioRegionale) o;
    return Objects.equals(idServizioRegionale, servizioRegionale.idServizioRegionale) &&
        Objects.equals(idPso, servizioRegionale.idPso) &&
        Objects.equals(idClassificazione, servizioRegionale.idClassificazione) &&
        Objects.equals(codiceServizioRegionale, servizioRegionale.codiceServizioRegionale) &&
        Objects.equals(descrServizioRegionale, servizioRegionale.descrServizioRegionale) &&
        Objects.equals(codFinalitaServizio, servizioRegionale.codFinalitaServizio) &&
        Objects.equals(descrFinalitaServizio, servizioRegionale.descrFinalitaServizio) &&
        Objects.equals(durataInOre, servizioRegionale.durataInOre) &&
        Objects.equals(oreConsentiteMin, servizioRegionale.oreConsentiteMin) &&
        Objects.equals(oreConsentiteMax, servizioRegionale.oreConsentiteMax) &&
        Objects.equals(flgCampoAggiuntivoUno, servizioRegionale.flgCampoAggiuntivoUno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idServizioRegionale, idPso, idClassificazione, codiceServizioRegionale, descrServizioRegionale, codFinalitaServizio, descrFinalitaServizio, durataInOre, oreConsentiteMin, oreConsentiteMax, flgCampoAggiuntivoUno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServizioRegionale {\n");
    
    sb.append("    idServizioRegionale: ").append(toIndentedString(idServizioRegionale)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idClassificazione: ").append(toIndentedString(idClassificazione)).append("\n");
    sb.append("    codiceServizioRegionale: ").append(toIndentedString(codiceServizioRegionale)).append("\n");
    sb.append("    descrServizioRegionale: ").append(toIndentedString(descrServizioRegionale)).append("\n");
    sb.append("    codFinalitaServizio: ").append(toIndentedString(codFinalitaServizio)).append("\n");
    sb.append("    descrFinalitaServizio: ").append(toIndentedString(descrFinalitaServizio)).append("\n");
    sb.append("    durataInOre: ").append(toIndentedString(durataInOre)).append("\n");
    sb.append("    oreConsentiteMin: ").append(toIndentedString(oreConsentiteMin)).append("\n");
    sb.append("    oreConsentiteMax: ").append(toIndentedString(oreConsentiteMax)).append("\n");
    sb.append("    flgCampoAggiuntivoUno: ").append(toIndentedString(flgCampoAggiuntivoUno)).append("\n");
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
