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
import it.csi.serse.serseweb.vo.StatoModelloIntervento;
import it.csi.serse.serseweb.vo.TipoModello;
import java.util.Date;
import jakarta.validation.constraints.*;

public class ModelloIntervento   {
  private Long idModelloIntervento = null;
  private String titolo = null;
  private String descrizione = null;
  private Long idPso = null;
  private TipoModello tipoModello = null;
  private StatoModelloIntervento statoModelloIntervento = null;
  private SoggettoAttuatore soggettoAttuatore = null;
  private Referente referente = null;
  private String codUserInserimento = null;
  private Date dataInserimento = null;
  private String codUserAggiornamento = null;
  private Date dataAggiornamento = null;

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
  
  @JsonProperty("tipoModello")
  public TipoModello getTipoModello() {
    return tipoModello;
  }
  public void setTipoModello(TipoModello tipoModello) {
    this.tipoModello = tipoModello;
  }

  /**
   **/
  
  @JsonProperty("statoModelloIntervento")
  public StatoModelloIntervento getStatoModelloIntervento() {
    return statoModelloIntervento;
  }
  public void setStatoModelloIntervento(StatoModelloIntervento statoModelloIntervento) {
    this.statoModelloIntervento = statoModelloIntervento;
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
    ModelloIntervento modelloIntervento = (ModelloIntervento) o;
    return Objects.equals(idModelloIntervento, modelloIntervento.idModelloIntervento) &&
        Objects.equals(titolo, modelloIntervento.titolo) &&
        Objects.equals(descrizione, modelloIntervento.descrizione) &&
        Objects.equals(idPso, modelloIntervento.idPso) &&
        Objects.equals(tipoModello, modelloIntervento.tipoModello) &&
        Objects.equals(statoModelloIntervento, modelloIntervento.statoModelloIntervento) &&
        Objects.equals(soggettoAttuatore, modelloIntervento.soggettoAttuatore) &&
        Objects.equals(referente, modelloIntervento.referente) &&
        Objects.equals(codUserInserimento, modelloIntervento.codUserInserimento) &&
        Objects.equals(dataInserimento, modelloIntervento.dataInserimento) &&
        Objects.equals(codUserAggiornamento, modelloIntervento.codUserAggiornamento) &&
        Objects.equals(dataAggiornamento, modelloIntervento.dataAggiornamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idModelloIntervento, titolo, descrizione, idPso, tipoModello, statoModelloIntervento, soggettoAttuatore, referente, codUserInserimento, dataInserimento, codUserAggiornamento, dataAggiornamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelloIntervento {\n");
    
    sb.append("    idModelloIntervento: ").append(toIndentedString(idModelloIntervento)).append("\n");
    sb.append("    titolo: ").append(toIndentedString(titolo)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    tipoModello: ").append(toIndentedString(tipoModello)).append("\n");
    sb.append("    statoModelloIntervento: ").append(toIndentedString(statoModelloIntervento)).append("\n");
    sb.append("    soggettoAttuatore: ").append(toIndentedString(soggettoAttuatore)).append("\n");
    sb.append("    referente: ").append(toIndentedString(referente)).append("\n");
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
