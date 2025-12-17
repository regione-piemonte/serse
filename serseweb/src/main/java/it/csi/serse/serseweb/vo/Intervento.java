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
import it.csi.serse.serseweb.vo.Referente;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import it.csi.serse.serseweb.vo.StatoIntervento;
import it.csi.serse.serseweb.vo.TipoIntervento;
import java.util.Date;
import jakarta.validation.constraints.*;

public class Intervento   {
  private Long idIntervento = null;
  private String titolo = null;
  private String descrizione = null;
  private Long idPso = null;
  private Long idModelloIntervento = null;
  private TipoIntervento tipoIntervento = null;
  private StatoIntervento statoIntervento = null;
  private SoggettoAttuatore soggettoAttuatore = null;
  private Referente referente = null;
  private Long idDestinatario = null;
  private String codUserInserimento = null;
  private Date dataInserimento = null;
  private String codUserAggiornamento = null;
  private Date dataAggiornamento = null;

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
  
  @JsonProperty("titolo")
  public String getTitolo() {
    return titolo;
  }
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  /**
   **/
  
  @JsonProperty("descrizione")
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
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
  
  @JsonProperty("idModelloIntervento")
  public Long getIdModelloIntervento() {
    return idModelloIntervento;
  }
  public void setIdModelloIntervento(Long idModelloIntervento) {
    this.idModelloIntervento = idModelloIntervento;
  }

  /**
   **/
  
  @JsonProperty("tipoIntervento")
  public TipoIntervento getTipoIntervento() {
    return tipoIntervento;
  }
  public void setTipoIntervento(TipoIntervento tipoIntervento) {
    this.tipoIntervento = tipoIntervento;
  }

  /**
   **/
  
  @JsonProperty("statoIntervento")
  public StatoIntervento getStatoIntervento() {
    return statoIntervento;
  }
  public void setStatoIntervento(StatoIntervento statoIntervento) {
    this.statoIntervento = statoIntervento;
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
  
  @JsonProperty("referente")
  public Referente getReferente() {
    return referente;
  }
  public void setReferente(Referente referente) {
    this.referente = referente;
  }

  /**
   **/
  
  @JsonProperty("idDestinatario")
  public Long getIdDestinatario() {
    return idDestinatario;
  }
  public void setIdDestinatario(Long idDestinatario) {
    this.idDestinatario = idDestinatario;
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
  
  @JsonProperty("dataInserimento")
  public Date getDataInserimento() {
    return dataInserimento;
  }
  public void setDataInserimento(Date dataInserimento) {
    this.dataInserimento = dataInserimento;
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
  
  @JsonProperty("dataAggiornamento")
  public Date getDataAggiornamento() {
    return dataAggiornamento;
  }
  public void setDataAggiornamento(Date dataAggiornamento) {
    this.dataAggiornamento = dataAggiornamento;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Intervento intervento = (Intervento) o;
    return Objects.equals(idIntervento, intervento.idIntervento) &&
        Objects.equals(titolo, intervento.titolo) &&
        Objects.equals(descrizione, intervento.descrizione) &&
        Objects.equals(idPso, intervento.idPso) &&
        Objects.equals(idModelloIntervento, intervento.idModelloIntervento) &&
        Objects.equals(tipoIntervento, intervento.tipoIntervento) &&
        Objects.equals(statoIntervento, intervento.statoIntervento) &&
        Objects.equals(soggettoAttuatore, intervento.soggettoAttuatore) &&
        Objects.equals(referente, intervento.referente) &&
        Objects.equals(idDestinatario, intervento.idDestinatario) &&
        Objects.equals(codUserInserimento, intervento.codUserInserimento) &&
        Objects.equals(dataInserimento, intervento.dataInserimento) &&
        Objects.equals(codUserAggiornamento, intervento.codUserAggiornamento) &&
        Objects.equals(dataAggiornamento, intervento.dataAggiornamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIntervento, titolo, descrizione, idPso, idModelloIntervento, tipoIntervento, statoIntervento, soggettoAttuatore, referente, idDestinatario, codUserInserimento, dataInserimento, codUserAggiornamento, dataAggiornamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Intervento {\n");
    
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    titolo: ").append(toIndentedString(titolo)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idModelloIntervento: ").append(toIndentedString(idModelloIntervento)).append("\n");
    sb.append("    tipoIntervento: ").append(toIndentedString(tipoIntervento)).append("\n");
    sb.append("    statoIntervento: ").append(toIndentedString(statoIntervento)).append("\n");
    sb.append("    soggettoAttuatore: ").append(toIndentedString(soggettoAttuatore)).append("\n");
    sb.append("    referente: ").append(toIndentedString(referente)).append("\n");
    sb.append("    idDestinatario: ").append(toIndentedString(idDestinatario)).append("\n");
    sb.append("    codUserInserimento: ").append(toIndentedString(codUserInserimento)).append("\n");
    sb.append("    dataInserimento: ").append(toIndentedString(dataInserimento)).append("\n");
    sb.append("    codUserAggiornamento: ").append(toIndentedString(codUserAggiornamento)).append("\n");
    sb.append("    dataAggiornamento: ").append(toIndentedString(dataAggiornamento)).append("\n");
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
