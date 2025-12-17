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

public class EnteCoinvoltoServizio   {
  private Long idEnteConvoltoServizio = null;
  private Long idEnteCoinvoltoIntervento = null;
  private Long idPso = null;
  private Long idFonteDato = null;
  private String descrizioneFonteDato = null;
  private String denominazione = null;
  private String denominazioneSedePrincipale = null;
  private Long idServizio = null;
  private String indirizzo = null;
  private Comune comune = null;
  private String codice1Soggetto = null;
  private String codice2Soggetto = null;
  private Referente referente = null;
  private String percorso = null;
  private String codMeccanografico = null;
  private String codMeccanograficoAutonomia = null;
  private String autonomia = null;
  private String gradoScolastico = null;
  private String tipologia = null;
  private String codUserInserim = null;
  private Date dInserim = null;
  private String codUserAggiorn = null;
  private Date dAggiornam = null;

  /**
   **/
  
  @JsonProperty("idEnteConvoltoServizio")
  public Long getIdEnteConvoltoServizio() {
    return idEnteConvoltoServizio;
  }
  public void setIdEnteConvoltoServizio(Long idEnteConvoltoServizio) {
    this.idEnteConvoltoServizio = idEnteConvoltoServizio;
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
  
  @JsonProperty("idServizio")
  public Long getIdServizio() {
    return idServizio;
  }
  public void setIdServizio(Long idServizio) {
    this.idServizio = idServizio;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnteCoinvoltoServizio enteCoinvoltoServizio = (EnteCoinvoltoServizio) o;
    return Objects.equals(idEnteConvoltoServizio, enteCoinvoltoServizio.idEnteConvoltoServizio) &&
        Objects.equals(idEnteCoinvoltoIntervento, enteCoinvoltoServizio.idEnteCoinvoltoIntervento) &&
        Objects.equals(idPso, enteCoinvoltoServizio.idPso) &&
        Objects.equals(idFonteDato, enteCoinvoltoServizio.idFonteDato) &&
        Objects.equals(descrizioneFonteDato, enteCoinvoltoServizio.descrizioneFonteDato) &&
        Objects.equals(denominazione, enteCoinvoltoServizio.denominazione) &&
        Objects.equals(denominazioneSedePrincipale, enteCoinvoltoServizio.denominazioneSedePrincipale) &&
        Objects.equals(idServizio, enteCoinvoltoServizio.idServizio) &&
        Objects.equals(indirizzo, enteCoinvoltoServizio.indirizzo) &&
        Objects.equals(comune, enteCoinvoltoServizio.comune) &&
        Objects.equals(codice1Soggetto, enteCoinvoltoServizio.codice1Soggetto) &&
        Objects.equals(codice2Soggetto, enteCoinvoltoServizio.codice2Soggetto) &&
        Objects.equals(referente, enteCoinvoltoServizio.referente) &&
        Objects.equals(percorso, enteCoinvoltoServizio.percorso) &&
        Objects.equals(codMeccanografico, enteCoinvoltoServizio.codMeccanografico) &&
        Objects.equals(codMeccanograficoAutonomia, enteCoinvoltoServizio.codMeccanograficoAutonomia) &&
        Objects.equals(autonomia, enteCoinvoltoServizio.autonomia) &&
        Objects.equals(gradoScolastico, enteCoinvoltoServizio.gradoScolastico) &&
        Objects.equals(tipologia, enteCoinvoltoServizio.tipologia) &&
        Objects.equals(codUserInserim, enteCoinvoltoServizio.codUserInserim) &&
        Objects.equals(dInserim, enteCoinvoltoServizio.dInserim) &&
        Objects.equals(codUserAggiorn, enteCoinvoltoServizio.codUserAggiorn) &&
        Objects.equals(dAggiornam, enteCoinvoltoServizio.dAggiornam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEnteConvoltoServizio, idEnteCoinvoltoIntervento, idPso, idFonteDato, descrizioneFonteDato, denominazione, denominazioneSedePrincipale, idServizio, indirizzo, comune, codice1Soggetto, codice2Soggetto, referente, percorso, codMeccanografico, codMeccanograficoAutonomia, autonomia, gradoScolastico, tipologia, codUserInserim, dInserim, codUserAggiorn, dAggiornam);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnteCoinvoltoServizio {\n");
    
    sb.append("    idEnteConvoltoServizio: ").append(toIndentedString(idEnteConvoltoServizio)).append("\n");
    sb.append("    idEnteCoinvoltoIntervento: ").append(toIndentedString(idEnteCoinvoltoIntervento)).append("\n");
    sb.append("    idPso: ").append(toIndentedString(idPso)).append("\n");
    sb.append("    idFonteDato: ").append(toIndentedString(idFonteDato)).append("\n");
    sb.append("    descrizioneFonteDato: ").append(toIndentedString(descrizioneFonteDato)).append("\n");
    sb.append("    denominazione: ").append(toIndentedString(denominazione)).append("\n");
    sb.append("    denominazioneSedePrincipale: ").append(toIndentedString(denominazioneSedePrincipale)).append("\n");
    sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
    sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
    sb.append("    codice1Soggetto: ").append(toIndentedString(codice1Soggetto)).append("\n");
    sb.append("    codice2Soggetto: ").append(toIndentedString(codice2Soggetto)).append("\n");
    sb.append("    referente: ").append(toIndentedString(referente)).append("\n");
    sb.append("    percorso: ").append(toIndentedString(percorso)).append("\n");
    sb.append("    codMeccanografico: ").append(toIndentedString(codMeccanografico)).append("\n");
    sb.append("    codMeccanograficoAutonomia: ").append(toIndentedString(codMeccanograficoAutonomia)).append("\n");
    sb.append("    autonomia: ").append(toIndentedString(autonomia)).append("\n");
    sb.append("    gradoScolastico: ").append(toIndentedString(gradoScolastico)).append("\n");
    sb.append("    tipologia: ").append(toIndentedString(tipologia)).append("\n");
    sb.append("    codUserInserim: ").append(toIndentedString(codUserInserim)).append("\n");
    sb.append("    dInserim: ").append(toIndentedString(dInserim)).append("\n");
    sb.append("    codUserAggiorn: ").append(toIndentedString(codUserAggiorn)).append("\n");
    sb.append("    dAggiornam: ").append(toIndentedString(dAggiornam)).append("\n");
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
