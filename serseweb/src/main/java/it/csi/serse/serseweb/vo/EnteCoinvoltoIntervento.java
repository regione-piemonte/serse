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
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.Referente;
import java.util.Date;
import jakarta.validation.constraints.*;

public class EnteCoinvoltoIntervento   {
  private Long idEnteCoinvoltoModello = null;
  private Long idEnteCoinvoltoIntervento = null;
  private Long idPso = null;
  private Long idFonteDato = null;
  private String descrizioneFonteDato = null;
  private String denominazione = null;
  private String denominazioneSedePrincipale = null;
  private Long idIntervento = null;
  private String indirizzo = null;
  private Comune comune = null;
  private String codice1Soggetto = null;
  private String codice2Soggetto = null;
  private Referente referente = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiornam = null;
  private String percorso = null;
  private String codMeccanografico = null;
  private String codMeccanograficoAutonomia = null;
  private String autonomia = null;
  private String gradoScolastico = null;
  private String tipologia = null;

  /**
   **/
  
  @JsonProperty("idEnteCoinvoltoModello")
  public Long getIdEnteCoinvoltoModello() {
    return idEnteCoinvoltoModello;
  }
  public void setIdEnteCoinvoltoModello(Long idEnteCoinvoltoModello) {
    this.idEnteCoinvoltoModello = idEnteCoinvoltoModello;
  }

  /**
   **/
  
  @JsonProperty("idEnteCoinvoltoIntervento")
  public Long getIdEnteCoinvoltoIntervento() {
    return idEnteCoinvoltoIntervento;
  }
  public void setIdEnteCoinvoltoIntervento(Long idEnteCoinvoltoIntervento) {
    this.idEnteCoinvoltoIntervento = idEnteCoinvoltoIntervento;
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
  
  @JsonProperty("idFonteDato")
  public Long getIdFonteDato() {
    return idFonteDato;
  }
  public void setIdFonteDato(Long idFonteDato) {
    this.idFonteDato = idFonteDato;
  }

  /**
   **/
  
  @JsonProperty("descrizioneFonteDato")
  public String getDescrizioneFonteDato() {
    return descrizioneFonteDato;
  }
  public void setDescrizioneFonteDato(String descrizioneFonteDato) {
    this.descrizioneFonteDato = descrizioneFonteDato;
  }

  /**
   **/
  
  @JsonProperty("denominazione")
  public String getDenominazione() {
    return denominazione;
  }
  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
  }

  /**
   **/
  
  @JsonProperty("denominazioneSedePrincipale")
  public String getDenominazioneSedePrincipale() {
    return denominazioneSedePrincipale;
  }
  public void setDenominazioneSedePrincipale(String denominazioneSedePrincipale) {
    this.denominazioneSedePrincipale = denominazioneSedePrincipale;
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
  
  @JsonProperty("indirizzo")
  public String getIndirizzo() {
    return indirizzo;
  }
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  /**
   **/
  
  @JsonProperty("comune")
  public Comune getComune() {
    return comune;
  }
  public void setComune(Comune comune) {
    this.comune = comune;
  }

  /**
   * codice legato a anagrafica istituti scolastici, e centri per l&#x27;impiego
   **/
  
  @JsonProperty("codice1Soggetto")
  public String getCodice1Soggetto() {
    return codice1Soggetto;
  }
  public void setCodice1Soggetto(String codice1Soggetto) {
    this.codice1Soggetto = codice1Soggetto;
  }

  /**
   * codice legato ad anagrafica regionale operatori da aggiungere al codice 1
   **/
  
  @JsonProperty("codice2Soggetto")
  public String getCodice2Soggetto() {
    return codice2Soggetto;
  }
  public void setCodice2Soggetto(String codice2Soggetto) {
    this.codice2Soggetto = codice2Soggetto;
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
  
  @JsonProperty("dAggiornam")
  public Date getDAggiornam() {
    return dAggiornam;
  }
  public void setDAggiornam(Date dAggiornam) {
    this.dAggiornam = dAggiornam;
  }

  /**
   **/
  
  @JsonProperty("percorso")
  public String getPercorso() {
    return percorso;
  }
  public void setPercorso(String percorso) {
    this.percorso = percorso;
  }

  /**
   **/
  
  @JsonProperty("codMeccanografico")
  public String getCodMeccanografico() {
    return codMeccanografico;
  }
  public void setCodMeccanografico(String codMeccanografico) {
    this.codMeccanografico = codMeccanografico;
  }

  /**
   **/
  
  @JsonProperty("codMeccanograficoAutonomia")
  public String getCodMeccanograficoAutonomia() {
    return codMeccanograficoAutonomia;
  }
  public void setCodMeccanograficoAutonomia(String codMeccanograficoAutonomia) {
    this.codMeccanograficoAutonomia = codMeccanograficoAutonomia;
  }

  /**
   **/
  
  @JsonProperty("autonomia")
  public String getAutonomia() {
    return autonomia;
  }
  public void setAutonomia(String autonomia) {
    this.autonomia = autonomia;
  }

  /**
   **/
  
  @JsonProperty("gradoScolastico")
  public String getGradoScolastico() {
    return gradoScolastico;
  }
  public void setGradoScolastico(String gradoScolastico) {
    this.gradoScolastico = gradoScolastico;
  }

  /**
   **/
  
  @JsonProperty("tipologia")
  public String getTipologia() {
    return tipologia;
  }
  public void setTipologia(String tipologia) {
    this.tipologia = tipologia;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnteCoinvoltoIntervento enteCoinvoltoIntervento = (EnteCoinvoltoIntervento) o;
    return Objects.equals(idEnteCoinvoltoModello, enteCoinvoltoIntervento.idEnteCoinvoltoModello) &&
        Objects.equals(idEnteCoinvoltoIntervento, enteCoinvoltoIntervento.idEnteCoinvoltoIntervento) &&
        Objects.equals(idPso, enteCoinvoltoIntervento.idPso) &&
        Objects.equals(idFonteDato, enteCoinvoltoIntervento.idFonteDato) &&
        Objects.equals(descrizioneFonteDato, enteCoinvoltoIntervento.descrizioneFonteDato) &&
        Objects.equals(denominazione, enteCoinvoltoIntervento.denominazione) &&
        Objects.equals(denominazioneSedePrincipale, enteCoinvoltoIntervento.denominazioneSedePrincipale) &&
        Objects.equals(idIntervento, enteCoinvoltoIntervento.idIntervento) &&
        Objects.equals(indirizzo, enteCoinvoltoIntervento.indirizzo) &&
        Objects.equals(comune, enteCoinvoltoIntervento.comune) &&
        Objects.equals(codice1Soggetto, enteCoinvoltoIntervento.codice1Soggetto) &&
        Objects.equals(codice2Soggetto, enteCoinvoltoIntervento.codice2Soggetto) &&
        Objects.equals(referente, enteCoinvoltoIntervento.referente) &&
        Objects.equals(codUserInserim, enteCoinvoltoIntervento.codUserInserim) &&
        Objects.equals(dInserim, enteCoinvoltoIntervento.dInserim) &&
        Objects.equals(codUserAggiorn, enteCoinvoltoIntervento.codUserAggiorn) &&
        Objects.equals(dAggiornam, enteCoinvoltoIntervento.dAggiornam) &&
        Objects.equals(percorso, enteCoinvoltoIntervento.percorso) &&
        Objects.equals(codMeccanografico, enteCoinvoltoIntervento.codMeccanografico) &&
        Objects.equals(codMeccanograficoAutonomia, enteCoinvoltoIntervento.codMeccanograficoAutonomia) &&
        Objects.equals(autonomia, enteCoinvoltoIntervento.autonomia) &&
        Objects.equals(gradoScolastico, enteCoinvoltoIntervento.gradoScolastico) &&
        Objects.equals(tipologia, enteCoinvoltoIntervento.tipologia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEnteCoinvoltoModello, idEnteCoinvoltoIntervento, idPso, idFonteDato, descrizioneFonteDato, denominazione, denominazioneSedePrincipale, idIntervento, indirizzo, comune, codice1Soggetto, codice2Soggetto, referente, codUserInserim, dInserim, codUserAggiorn, dAggiornam, percorso, codMeccanografico, codMeccanograficoAutonomia, autonomia, gradoScolastico, tipologia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnteCoinvoltoIntervento {\n");
    
    sb.append("    idEnteCoinvoltoModello: ").append(toIndentedString(idEnteCoinvoltoModello)).append("\n");
    sb.append("    idEnteCoinvoltoIntervento: ").append(toIndentedString(idEnteCoinvoltoIntervento)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idFonteDato: ").append(toIndentedString(idFonteDato)).append("\n");
    sb.append("    descrizioneFonteDato: ").append(toIndentedString(descrizioneFonteDato)).append("\n");
    sb.append("    denominazione: ").append(toIndentedString(denominazione)).append("\n");
    sb.append("    denominazioneSedePrincipale: ").append(toIndentedString(denominazioneSedePrincipale)).append("\n");
    sb.append("    idIntervento: ").append(toIndentedString(idIntervento)).append("\n");
    sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
    sb.append("    codice1Soggetto: ").append(toIndentedString(codice1Soggetto)).append("\n");
    sb.append("    codice2Soggetto: ").append(toIndentedString(codice2Soggetto)).append("\n");
    sb.append("    referente: ").append(toIndentedString(referente)).append("\n");
    sb.append("    codUserInserim: ").append(toIndentedString(codUserInserim)).append("\n");
    sb.append("    dInserim: ").append(toIndentedString(dInserim)).append("\n");
    sb.append("    codUserAggiorn: ").append(toIndentedString(codUserAggiorn)).append("\n");
    sb.append("    dAggiornam: ").append(toIndentedString(dAggiornam)).append("\n");
    sb.append("    percorso: ").append(toIndentedString(percorso)).append("\n");
    sb.append("    codMeccanografico: ").append(toIndentedString(codMeccanografico)).append("\n");
    sb.append("    codMeccanograficoAutonomia: ").append(toIndentedString(codMeccanograficoAutonomia)).append("\n");
    sb.append("    autonomia: ").append(toIndentedString(autonomia)).append("\n");
    sb.append("    gradoScolastico: ").append(toIndentedString(gradoScolastico)).append("\n");
    sb.append("    tipologia: ").append(toIndentedString(tipologia)).append("\n");
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
