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
import it.csi.serse.serseweb.vo.Destinatario;
import it.csi.serse.serseweb.vo.Intervento;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import java.util.Date;
import jakarta.validation.constraints.*;

public class InterventoWrapper   {
  private Intervento intervento = null;
  private String denominazioneSoggettoAttuatore = null;
  private PersonaGiuridica soggettoBeneficiario = null;
  private Destinatario destinatario = null;
  private Boolean isAssociatoServizio = null;
  private Boolean isProprietario = null;
  private Date sportelloDfine = null;
  private String sportelloFlgTipoGestioneIntervento = null;

  /**
   **/
  
  @JsonProperty("intervento")
  public Intervento getIntervento() {
    return intervento;
  }
  public void setIntervento(Intervento intervento) {
    this.intervento = intervento;
  }

  /**
   **/
  
  @JsonProperty("denominazioneSoggettoAttuatore")
  public String getDenominazioneSoggettoAttuatore() {
    return denominazioneSoggettoAttuatore;
  }
  public void setDenominazioneSoggettoAttuatore(String denominazioneSoggettoAttuatore) {
    this.denominazioneSoggettoAttuatore = denominazioneSoggettoAttuatore;
  }

  /**
   **/
  
  @JsonProperty("soggettoBeneficiario")
  public PersonaGiuridica getSoggettoBeneficiario() {
    return soggettoBeneficiario;
  }
  public void setSoggettoBeneficiario(PersonaGiuridica soggettoBeneficiario) {
    this.soggettoBeneficiario = soggettoBeneficiario;
  }

  /**
   **/
  
  @JsonProperty("destinatario")
  public Destinatario getDestinatario() {
    return destinatario;
  }
  public void setDestinatario(Destinatario destinatario) {
    this.destinatario = destinatario;
  }

  /**
   **/
  
  @JsonProperty("isAssociatoServizio")
  public Boolean isIsAssociatoServizio() {
    return isAssociatoServizio;
  }
  public void setIsAssociatoServizio(Boolean isAssociatoServizio) {
    this.isAssociatoServizio = isAssociatoServizio;
  }

  /**
   **/
  
  @JsonProperty("isProprietario")
  public Boolean isIsProprietario() {
    return isProprietario;
  }
  public void setIsProprietario(Boolean isProprietario) {
    this.isProprietario = isProprietario;
  }

  /**
   **/
  
  @JsonProperty("sportelloDfine")
  public Date getSportelloDfine() {
    return sportelloDfine;
  }
  public void setSportelloDfine(Date sportelloDfine) {
    this.sportelloDfine = sportelloDfine;
  }

  /**
   **/
  
  @JsonProperty("sportelloFlgTipoGestioneIntervento")
  public String getSportelloFlgTipoGestioneIntervento() {
    return sportelloFlgTipoGestioneIntervento;
  }
  public void setSportelloFlgTipoGestioneIntervento(String sportelloFlgTipoGestioneIntervento) {
    this.sportelloFlgTipoGestioneIntervento = sportelloFlgTipoGestioneIntervento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InterventoWrapper interventoWrapper = (InterventoWrapper) o;
    return Objects.equals(intervento, interventoWrapper.intervento) &&
        Objects.equals(denominazioneSoggettoAttuatore, interventoWrapper.denominazioneSoggettoAttuatore) &&
        Objects.equals(soggettoBeneficiario, interventoWrapper.soggettoBeneficiario) &&
        Objects.equals(destinatario, interventoWrapper.destinatario) &&
        Objects.equals(isAssociatoServizio, interventoWrapper.isAssociatoServizio) &&
        Objects.equals(isProprietario, interventoWrapper.isProprietario) &&
        Objects.equals(sportelloDfine, interventoWrapper.sportelloDfine) &&
        Objects.equals(sportelloFlgTipoGestioneIntervento, interventoWrapper.sportelloFlgTipoGestioneIntervento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intervento, denominazioneSoggettoAttuatore, soggettoBeneficiario, destinatario, isAssociatoServizio, isProprietario, sportelloDfine, sportelloFlgTipoGestioneIntervento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterventoWrapper {\n");
    
    sb.append("    intervento: ").append(toIndentedString(intervento)).append("\n");
    sb.append("    denominazioneSoggettoAttuatore: ").append(toIndentedString(denominazioneSoggettoAttuatore)).append("\n");
    sb.append("    soggettoBeneficiario: ").append(toIndentedString(soggettoBeneficiario)).append("\n");
    sb.append("    destinatario: ").append(toIndentedString(destinatario)).append("\n");
    sb.append("    isAssociatoServizio: ").append(toIndentedString(isAssociatoServizio)).append("\n");
    sb.append("    isProprietario: ").append(toIndentedString(isProprietario)).append("\n");
    sb.append("    sportelloDfine: ").append(toIndentedString(sportelloDfine)).append("\n");
    sb.append("    sportelloFlgTipoGestioneIntervento: ").append(toIndentedString(sportelloFlgTipoGestioneIntervento)).append("\n");
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
