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
import java.util.Date;
import jakarta.validation.constraints.*;

public class TokenGam   {
  private Long idTokenGam = null;
  private Long idServizio = null;
  private Long idIncontro = null;
  private String xmlRichiesta = null;
  private String codTipoRichiestaGam = null;
  private Long idTokenElabGam = null;
  private String codStatoRichiesta = null;
  private String descrStatoRichiesta = null;
  private Date dInvioRichiesta = null;
  private String utenteInvioRichiesta = null;
  private BigDecimal durataOreProposta = null;
  private Long numMaxDestinatariProposto = null;
  private String codStatoElaborazione = null;
  private String codEsitoElaborazione = null;
  private String descrEsitoElaborazione = null;
  private Date dElaborazione = null;
  private String xmlRispostaElaborazione = null;
  private BigDecimal importoFinanziatoPrecedente = null;
  private String codTipoVariazioneFinanziamento = null;
  private Date dVisualizzazioneNotifica = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiorn = null;

  /**
   **/
  
  @JsonProperty("idTokenGam")
  public Long getIdTokenGam() {
    return idTokenGam;
  }
  public void setIdTokenGam(Long idTokenGam) {
    this.idTokenGam = idTokenGam;
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
  
  @JsonProperty("idIncontro")
  public Long getIdIncontro() {
    return idIncontro;
  }
  public void setIdIncontro(Long idIncontro) {
    this.idIncontro = idIncontro;
  }

  /**
   **/
  
  @JsonProperty("xmlRichiesta")
  public String getXmlRichiesta() {
    return xmlRichiesta;
  }
  public void setXmlRichiesta(String xmlRichiesta) {
    this.xmlRichiesta = xmlRichiesta;
  }

  /**
   **/
  
  @JsonProperty("codTipoRichiestaGam")
  public String getCodTipoRichiestaGam() {
    return codTipoRichiestaGam;
  }
  public void setCodTipoRichiestaGam(String codTipoRichiestaGam) {
    this.codTipoRichiestaGam = codTipoRichiestaGam;
  }

  /**
   **/
  
  @JsonProperty("idTokenElabGam")
  public Long getIdTokenElabGam() {
    return idTokenElabGam;
  }
  public void setIdTokenElabGam(Long idTokenElabGam) {
    this.idTokenElabGam = idTokenElabGam;
  }

  /**
   **/
  
  @JsonProperty("codStatoRichiesta")
  public String getCodStatoRichiesta() {
    return codStatoRichiesta;
  }
  public void setCodStatoRichiesta(String codStatoRichiesta) {
    this.codStatoRichiesta = codStatoRichiesta;
  }

  /**
   **/
  
  @JsonProperty("descrStatoRichiesta")
  public String getDescrStatoRichiesta() {
    return descrStatoRichiesta;
  }
  public void setDescrStatoRichiesta(String descrStatoRichiesta) {
    this.descrStatoRichiesta = descrStatoRichiesta;
  }

  /**
   **/
  
  @JsonProperty("dInvioRichiesta")
  public Date getDInvioRichiesta() {
    return dInvioRichiesta;
  }
  public void setDInvioRichiesta(Date dInvioRichiesta) {
    this.dInvioRichiesta = dInvioRichiesta;
  }

  /**
   **/
  
  @JsonProperty("utenteInvioRichiesta")
  public String getUtenteInvioRichiesta() {
    return utenteInvioRichiesta;
  }
  public void setUtenteInvioRichiesta(String utenteInvioRichiesta) {
    this.utenteInvioRichiesta = utenteInvioRichiesta;
  }

  /**
   **/
  
  @JsonProperty("durataOreProposta")
  public BigDecimal getDurataOreProposta() {
    return durataOreProposta;
  }
  public void setDurataOreProposta(BigDecimal durataOreProposta) {
    this.durataOreProposta = durataOreProposta;
  }

  /**
   **/
  
  @JsonProperty("numMaxDestinatariProposto")
  public Long getNumMaxDestinatariProposto() {
    return numMaxDestinatariProposto;
  }
  public void setNumMaxDestinatariProposto(Long numMaxDestinatariProposto) {
    this.numMaxDestinatariProposto = numMaxDestinatariProposto;
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
  
  @JsonProperty("codEsitoElaborazione")
  public String getCodEsitoElaborazione() {
    return codEsitoElaborazione;
  }
  public void setCodEsitoElaborazione(String codEsitoElaborazione) {
    this.codEsitoElaborazione = codEsitoElaborazione;
  }

  /**
   **/
  
  @JsonProperty("descrEsitoElaborazione")
  public String getDescrEsitoElaborazione() {
    return descrEsitoElaborazione;
  }
  public void setDescrEsitoElaborazione(String descrEsitoElaborazione) {
    this.descrEsitoElaborazione = descrEsitoElaborazione;
  }

  /**
   **/
  
  @JsonProperty("dElaborazione")
  public Date getDElaborazione() {
    return dElaborazione;
  }
  public void setDElaborazione(Date dElaborazione) {
    this.dElaborazione = dElaborazione;
  }

  /**
   **/
  
  @JsonProperty("xmlRispostaElaborazione")
  public String getXmlRispostaElaborazione() {
    return xmlRispostaElaborazione;
  }
  public void setXmlRispostaElaborazione(String xmlRispostaElaborazione) {
    this.xmlRispostaElaborazione = xmlRispostaElaborazione;
  }

  /**
   **/
  
  @JsonProperty("importoFinanziatoPrecedente")
  public BigDecimal getImportoFinanziatoPrecedente() {
    return importoFinanziatoPrecedente;
  }
  public void setImportoFinanziatoPrecedente(BigDecimal importoFinanziatoPrecedente) {
    this.importoFinanziatoPrecedente = importoFinanziatoPrecedente;
  }

  /**
   **/
  
  @JsonProperty("codTipoVariazioneFinanziamento")
  public String getCodTipoVariazioneFinanziamento() {
    return codTipoVariazioneFinanziamento;
  }
  public void setCodTipoVariazioneFinanziamento(String codTipoVariazioneFinanziamento) {
    this.codTipoVariazioneFinanziamento = codTipoVariazioneFinanziamento;
  }

  /**
   **/
  
  @JsonProperty("dVisualizzazioneNotifica")
  public Date getDVisualizzazioneNotifica() {
    return dVisualizzazioneNotifica;
  }
  public void setDVisualizzazioneNotifica(Date dVisualizzazioneNotifica) {
    this.dVisualizzazioneNotifica = dVisualizzazioneNotifica;
  }

  /**
   **/
  
  @JsonProperty("codUserInserim")
  public String getCodUserInserim() {
    return codUserInserim;
  }
  public void setCodUserInserim(String codUserInserim) {
    this.codUserInserim = codUserInserim;
  }

  /**
   **/
  
  @JsonProperty("dInserim")
  public Date getDInserim() {
    return dInserim;
  }
  public void setDInserim(Date dInserim) {
    this.dInserim = dInserim;
  }

  /**
   **/
  
  @JsonProperty("codUserAggiorn")
  public String getCodUserAggiorn() {
    return codUserAggiorn;
  }
  public void setCodUserAggiorn(String codUserAggiorn) {
    this.codUserAggiorn = codUserAggiorn;
  }

  /**
   **/
  
  @JsonProperty("dAggiorn")
  public Date getDAggiorn() {
    return dAggiorn;
  }
  public void setDAggiorn(Date dAggiorn) {
    this.dAggiorn = dAggiorn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenGam tokenGam = (TokenGam) o;
    return Objects.equals(idTokenGam, tokenGam.idTokenGam) &&
        Objects.equals(idServizio, tokenGam.idServizio) &&
        Objects.equals(idIncontro, tokenGam.idIncontro) &&
        Objects.equals(xmlRichiesta, tokenGam.xmlRichiesta) &&
        Objects.equals(codTipoRichiestaGam, tokenGam.codTipoRichiestaGam) &&
        Objects.equals(idTokenElabGam, tokenGam.idTokenElabGam) &&
        Objects.equals(codStatoRichiesta, tokenGam.codStatoRichiesta) &&
        Objects.equals(descrStatoRichiesta, tokenGam.descrStatoRichiesta) &&
        Objects.equals(dInvioRichiesta, tokenGam.dInvioRichiesta) &&
        Objects.equals(utenteInvioRichiesta, tokenGam.utenteInvioRichiesta) &&
        Objects.equals(durataOreProposta, tokenGam.durataOreProposta) &&
        Objects.equals(numMaxDestinatariProposto, tokenGam.numMaxDestinatariProposto) &&
        Objects.equals(codStatoElaborazione, tokenGam.codStatoElaborazione) &&
        Objects.equals(codEsitoElaborazione, tokenGam.codEsitoElaborazione) &&
        Objects.equals(descrEsitoElaborazione, tokenGam.descrEsitoElaborazione) &&
        Objects.equals(dElaborazione, tokenGam.dElaborazione) &&
        Objects.equals(xmlRispostaElaborazione, tokenGam.xmlRispostaElaborazione) &&
        Objects.equals(importoFinanziatoPrecedente, tokenGam.importoFinanziatoPrecedente) &&
        Objects.equals(codTipoVariazioneFinanziamento, tokenGam.codTipoVariazioneFinanziamento) &&
        Objects.equals(dVisualizzazioneNotifica, tokenGam.dVisualizzazioneNotifica) &&
        Objects.equals(codUserInserim, tokenGam.codUserInserim) &&
        Objects.equals(dInserim, tokenGam.dInserim) &&
        Objects.equals(codUserAggiorn, tokenGam.codUserAggiorn) &&
        Objects.equals(dAggiorn, tokenGam.dAggiorn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTokenGam, idServizio, idIncontro, xmlRichiesta, codTipoRichiestaGam, idTokenElabGam, codStatoRichiesta, descrStatoRichiesta, dInvioRichiesta, utenteInvioRichiesta, durataOreProposta, numMaxDestinatariProposto, codStatoElaborazione, codEsitoElaborazione, descrEsitoElaborazione, dElaborazione, xmlRispostaElaborazione, importoFinanziatoPrecedente, codTipoVariazioneFinanziamento, dVisualizzazioneNotifica, codUserInserim, dInserim, codUserAggiorn, dAggiorn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenGam {\n");
    
    sb.append("    idTokenGam: ").append(toIndentedString(idTokenGam)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    idIncontro: ").append(toIndentedString(idIncontro)).append("\n");
    sb.append("    xmlRichiesta: ").append(toIndentedString(xmlRichiesta)).append("\n");
    sb.append("    codTipoRichiestaGam: ").append(toIndentedString(codTipoRichiestaGam)).append("\n");
    sb.append("    idTokenElabGam: ").append(toIndentedString(idTokenElabGam)).append("\n");
    sb.append("    codStatoRichiesta: ").append(toIndentedString(codStatoRichiesta)).append("\n");
    sb.append("    descrStatoRichiesta: ").append(toIndentedString(descrStatoRichiesta)).append("\n");
    sb.append("    dInvioRichiesta: ").append(toIndentedString(dInvioRichiesta)).append("\n");
    sb.append("    utenteInvioRichiesta: ").append(toIndentedString(utenteInvioRichiesta)).append("\n");
    sb.append("    durataOreProposta: ").append(toIndentedString(durataOreProposta)).append("\n");
    sb.append("    numMaxDestinatariProposto: ").append(toIndentedString(numMaxDestinatariProposto)).append("\n");
    sb.append("    codStatoElaborazione: ").append(toIndentedString(codStatoElaborazione)).append("\n");
    sb.append("    codEsitoElaborazione: ").append(toIndentedString(codEsitoElaborazione)).append("\n");
    sb.append("    descrEsitoElaborazione: ").append(toIndentedString(descrEsitoElaborazione)).append("\n");
    sb.append("    dElaborazione: ").append(toIndentedString(dElaborazione)).append("\n");
    sb.append("    xmlRispostaElaborazione: ").append(toIndentedString(xmlRispostaElaborazione)).append("\n");
    sb.append("    importoFinanziatoPrecedente: ").append(toIndentedString(importoFinanziatoPrecedente)).append("\n");
    sb.append("    codTipoVariazioneFinanziamento: ").append(toIndentedString(codTipoVariazioneFinanziamento)).append("\n");
    sb.append("    dVisualizzazioneNotifica: ").append(toIndentedString(dVisualizzazioneNotifica)).append("\n");
    sb.append("    codUserInserim: ").append(toIndentedString(codUserInserim)).append("\n");
    sb.append("    dInserim: ").append(toIndentedString(dInserim)).append("\n");
    sb.append("    codUserAggiorn: ").append(toIndentedString(codUserAggiorn)).append("\n");
    sb.append("    dAggiorn: ").append(toIndentedString(dAggiorn)).append("\n");
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
