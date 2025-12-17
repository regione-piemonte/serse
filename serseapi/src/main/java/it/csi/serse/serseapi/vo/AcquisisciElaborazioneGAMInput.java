package it.csi.serse.serseapi.vo;

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
import it.csi.serse.serseapi.vo.ResponseGAM;
import jakarta.validation.constraints.*;

public class AcquisisciElaborazioneGAMInput   {
  private Long token = null;
  private String codTipoRichiesta = null;
  private String codStatoElaborazione = null;
  private String descrStatoElaborazione = null;
  private String codEsito = null;
  private String descrEsito = null;
  private ResponseGAM responseGam = null;

  /**
   **/
  
  @JsonProperty("token")
  public Long getToken() {
    return token;
  }
  public void setToken(Long token) {
    this.token = token;
  }

  /**
   **/
  
  @JsonProperty("codTipoRichiesta")
  public String getCodTipoRichiesta() {
    return codTipoRichiesta;
  }
  public void setCodTipoRichiesta(String codTipoRichiesta) {
    this.codTipoRichiesta = codTipoRichiesta;
  }

  /**
   **/
  
  @JsonProperty("codStatoElaborazione")
  public String getCodStatoElaborazione() {
    return codStatoElaborazione;
  }
  public void setCodStatoElaborazione(String codStatoElaborazione) {
    this.codStatoElaborazione = codStatoElaborazione;
  }

  /**
   **/
  
  @JsonProperty("descrStatoElaborazione")
  public String getDescrStatoElaborazione() {
    return descrStatoElaborazione;
  }
  public void setDescrStatoElaborazione(String descrStatoElaborazione) {
    this.descrStatoElaborazione = descrStatoElaborazione;
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
  
  @JsonProperty("responseGam")
  public ResponseGAM getResponseGam() {
    return responseGam;
  }
  public void setResponseGam(ResponseGAM responseGam) {
    this.responseGam = responseGam;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcquisisciElaborazioneGAMInput acquisisciElaborazioneGAMInput = (AcquisisciElaborazioneGAMInput) o;
    return Objects.equals(token, acquisisciElaborazioneGAMInput.token) &&
        Objects.equals(codTipoRichiesta, acquisisciElaborazioneGAMInput.codTipoRichiesta) &&
        Objects.equals(codStatoElaborazione, acquisisciElaborazioneGAMInput.codStatoElaborazione) &&
        Objects.equals(descrStatoElaborazione, acquisisciElaborazioneGAMInput.descrStatoElaborazione) &&
        Objects.equals(codEsito, acquisisciElaborazioneGAMInput.codEsito) &&
        Objects.equals(descrEsito, acquisisciElaborazioneGAMInput.descrEsito) &&
        Objects.equals(responseGam, acquisisciElaborazioneGAMInput.responseGam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, codTipoRichiesta, codStatoElaborazione, descrStatoElaborazione, codEsito, descrEsito, responseGam);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcquisisciElaborazioneGAMInput {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    codTipoRichiesta: ").append(toIndentedString(codTipoRichiesta)).append("\n");
    sb.append("    codStatoElaborazione: ").append(toIndentedString(codStatoElaborazione)).append("\n");
    sb.append("    descrStatoElaborazione: ").append(toIndentedString(descrStatoElaborazione)).append("\n");
    sb.append("    codEsito: ").append(toIndentedString(codEsito)).append("\n");
    sb.append("    descrEsito: ").append(toIndentedString(descrEsito)).append("\n");
    sb.append("    responseGam: ").append(toIndentedString(responseGam)).append("\n");
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
