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
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.Servizio;
import java.util.Date;
import jakarta.validation.constraints.*;

public class ServizioWrapper   {
  private Servizio servizio = null;
  private Destinatario destinatario = null;
  private String denominazioneSoggettoAttuatore = null;
  private PersonaGiuridica soggettoBeneficiario = null;
  private Date sportelloDfine = null;
  private Boolean isProprietario = null;

  /**
   **/
  
  @JsonProperty("servizio")
  public Servizio getServizio() {
    return servizio;
  }
  public void setServizio(Servizio servizio) {
    this.servizio = servizio;
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
  
  @JsonProperty("sportelloDfine")
  public Date getSportelloDfine() {
    return sportelloDfine;
  }
  public void setSportelloDfine(Date sportelloDfine) {
    this.sportelloDfine = sportelloDfine;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServizioWrapper servizioWrapper = (ServizioWrapper) o;
    return Objects.equals(servizio, servizioWrapper.servizio) &&
        Objects.equals(destinatario, servizioWrapper.destinatario) &&
        Objects.equals(denominazioneSoggettoAttuatore, servizioWrapper.denominazioneSoggettoAttuatore) &&
        Objects.equals(soggettoBeneficiario, servizioWrapper.soggettoBeneficiario) &&
        Objects.equals(sportelloDfine, servizioWrapper.sportelloDfine) &&
        Objects.equals(isProprietario, servizioWrapper.isProprietario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(servizio, destinatario, denominazioneSoggettoAttuatore, soggettoBeneficiario, sportelloDfine, isProprietario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServizioWrapper {\n");
    
    sb.append("    servizio: ").append(toIndentedString(servizio)).append("\n");
    sb.append("    destinatario: ").append(toIndentedString(destinatario)).append("\n");
    sb.append("    denominazioneSoggettoAttuatore: ").append(toIndentedString(denominazioneSoggettoAttuatore)).append("\n");
    sb.append("    soggettoBeneficiario: ").append(toIndentedString(soggettoBeneficiario)).append("\n");
    sb.append("    sportelloDfine: ").append(toIndentedString(sportelloDfine)).append("\n");
    sb.append("    isProprietario: ").append(toIndentedString(isProprietario)).append("\n");
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
