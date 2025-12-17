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
import it.csi.serse.serseweb.vo.AnnoScolastico;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.GradoScolastico;
import it.csi.serse.serseweb.vo.PercorsoScolastico;
import it.csi.serse.serseweb.vo.TipoSezione;
import it.csi.serse.serseweb.vo.TipoUnitaScolastica;
import it.csi.serse.serseweb.vo.TipologiaIstitutoScolastico;
import java.util.Date;
import jakarta.validation.constraints.*;

public class IstitutoScolastico   {
  private Long idIstitutoScolastico = null;
  private String codRegionaleScuola = null;
  private String codRegionaleAutonomia = null;
  private String codMeccanograficoScuola = null;
  private String codMeccanograficoAutonomia = null;
  private String denominazione = null;
  private Comune comuneScuola = null;
  private String indirizzo = null;
  private String recapitoMail = null;
  private String recapitoTelefonico = null;
  private String urlSitoWeb = null;
  private GradoScolastico gradoScolastico = null;
  private TipologiaIstitutoScolastico tipologiaIstituto = null;
  private PercorsoScolastico percorsoScolastico = null;
  private TipoSezione tipoSezione = null;
  private TipoUnitaScolastica tipoUnita = null;
  private AnnoScolastico annoScolastico = null;
  private Date dataChiusura = null;
  private Date dataApertura = null;
  private Date dataModifica = null;

  /**
   **/
  
  @JsonProperty("idIstitutoScolastico")
  public Long getIdIstitutoScolastico() {
    return idIstitutoScolastico;
  }
  public void setIdIstitutoScolastico(Long idIstitutoScolastico) {
    this.idIstitutoScolastico = idIstitutoScolastico;
  }

  /**
   **/
  
  @JsonProperty("codRegionaleScuola")
  public String getCodRegionaleScuola() {
    return codRegionaleScuola;
  }
  public void setCodRegionaleScuola(String codRegionaleScuola) {
    this.codRegionaleScuola = codRegionaleScuola;
  }

  /**
   **/
  
  @JsonProperty("codRegionaleAutonomia")
  public String getCodRegionaleAutonomia() {
    return codRegionaleAutonomia;
  }
  public void setCodRegionaleAutonomia(String codRegionaleAutonomia) {
    this.codRegionaleAutonomia = codRegionaleAutonomia;
  }

  /**
   **/
  
  @JsonProperty("codMeccanograficoScuola")
  public String getCodMeccanograficoScuola() {
    return codMeccanograficoScuola;
  }
  public void setCodMeccanograficoScuola(String codMeccanograficoScuola) {
    this.codMeccanograficoScuola = codMeccanograficoScuola;
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
  
  @JsonProperty("denominazione")
  public String getDenominazione() {
    return denominazione;
  }
  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
  }

  /**
   **/
  
  @JsonProperty("comuneScuola")
  public Comune getComuneScuola() {
    return comuneScuola;
  }
  public void setComuneScuola(Comune comuneScuola) {
    this.comuneScuola = comuneScuola;
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
  
  @JsonProperty("recapitoMail")
  public String getRecapitoMail() {
    return recapitoMail;
  }
  public void setRecapitoMail(String recapitoMail) {
    this.recapitoMail = recapitoMail;
  }

  /**
   **/
  
  @JsonProperty("recapitoTelefonico")
  public String getRecapitoTelefonico() {
    return recapitoTelefonico;
  }
  public void setRecapitoTelefonico(String recapitoTelefonico) {
    this.recapitoTelefonico = recapitoTelefonico;
  }

  /**
   **/
  
  @JsonProperty("urlSitoWeb")
  public String getUrlSitoWeb() {
    return urlSitoWeb;
  }
  public void setUrlSitoWeb(String urlSitoWeb) {
    this.urlSitoWeb = urlSitoWeb;
  }

  /**
   **/
  
  @JsonProperty("gradoScolastico")
  public GradoScolastico getGradoScolastico() {
    return gradoScolastico;
  }
  public void setGradoScolastico(GradoScolastico gradoScolastico) {
    this.gradoScolastico = gradoScolastico;
  }

  /**
   **/
  
  @JsonProperty("tipologiaIstituto")
  public TipologiaIstitutoScolastico getTipologiaIstituto() {
    return tipologiaIstituto;
  }
  public void setTipologiaIstituto(TipologiaIstitutoScolastico tipologiaIstituto) {
    this.tipologiaIstituto = tipologiaIstituto;
  }

  /**
   **/
  
  @JsonProperty("percorsoScolastico")
  public PercorsoScolastico getPercorsoScolastico() {
    return percorsoScolastico;
  }
  public void setPercorsoScolastico(PercorsoScolastico percorsoScolastico) {
    this.percorsoScolastico = percorsoScolastico;
  }

  /**
   **/
  
  @JsonProperty("tipoSezione")
  public TipoSezione getTipoSezione() {
    return tipoSezione;
  }
  public void setTipoSezione(TipoSezione tipoSezione) {
    this.tipoSezione = tipoSezione;
  }

  /**
   **/
  
  @JsonProperty("tipoUnita")
  public TipoUnitaScolastica getTipoUnita() {
    return tipoUnita;
  }
  public void setTipoUnita(TipoUnitaScolastica tipoUnita) {
    this.tipoUnita = tipoUnita;
  }

  /**
   **/
  
  @JsonProperty("annoScolastico")
  public AnnoScolastico getAnnoScolastico() {
    return annoScolastico;
  }
  public void setAnnoScolastico(AnnoScolastico annoScolastico) {
    this.annoScolastico = annoScolastico;
  }

  /**
   **/
  
  @JsonProperty("dataChiusura")
  public Date getDataChiusura() {
    return dataChiusura;
  }
  public void setDataChiusura(Date dataChiusura) {
    this.dataChiusura = dataChiusura;
  }

  /**
   **/
  
  @JsonProperty("dataApertura")
  public Date getDataApertura() {
    return dataApertura;
  }
  public void setDataApertura(Date dataApertura) {
    this.dataApertura = dataApertura;
  }

  /**
   **/
  
  @JsonProperty("dataModifica")
  public Date getDataModifica() {
    return dataModifica;
  }
  public void setDataModifica(Date dataModifica) {
    this.dataModifica = dataModifica;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IstitutoScolastico istitutoScolastico = (IstitutoScolastico) o;
    return Objects.equals(idIstitutoScolastico, istitutoScolastico.idIstitutoScolastico) &&
        Objects.equals(codRegionaleScuola, istitutoScolastico.codRegionaleScuola) &&
        Objects.equals(codRegionaleAutonomia, istitutoScolastico.codRegionaleAutonomia) &&
        Objects.equals(codMeccanograficoScuola, istitutoScolastico.codMeccanograficoScuola) &&
        Objects.equals(codMeccanograficoAutonomia, istitutoScolastico.codMeccanograficoAutonomia) &&
        Objects.equals(denominazione, istitutoScolastico.denominazione) &&
        Objects.equals(comuneScuola, istitutoScolastico.comuneScuola) &&
        Objects.equals(indirizzo, istitutoScolastico.indirizzo) &&
        Objects.equals(recapitoMail, istitutoScolastico.recapitoMail) &&
        Objects.equals(recapitoTelefonico, istitutoScolastico.recapitoTelefonico) &&
        Objects.equals(urlSitoWeb, istitutoScolastico.urlSitoWeb) &&
        Objects.equals(gradoScolastico, istitutoScolastico.gradoScolastico) &&
        Objects.equals(tipologiaIstituto, istitutoScolastico.tipologiaIstituto) &&
        Objects.equals(percorsoScolastico, istitutoScolastico.percorsoScolastico) &&
        Objects.equals(tipoSezione, istitutoScolastico.tipoSezione) &&
        Objects.equals(tipoUnita, istitutoScolastico.tipoUnita) &&
        Objects.equals(annoScolastico, istitutoScolastico.annoScolastico) &&
        Objects.equals(dataChiusura, istitutoScolastico.dataChiusura) &&
        Objects.equals(dataApertura, istitutoScolastico.dataApertura) &&
        Objects.equals(dataModifica, istitutoScolastico.dataModifica);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIstitutoScolastico, codRegionaleScuola, codRegionaleAutonomia, codMeccanograficoScuola, codMeccanograficoAutonomia, denominazione, comuneScuola, indirizzo, recapitoMail, recapitoTelefonico, urlSitoWeb, gradoScolastico, tipologiaIstituto, percorsoScolastico, tipoSezione, tipoUnita, annoScolastico, dataChiusura, dataApertura, dataModifica);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IstitutoScolastico {\n");
    
    sb.append("    idIstitutoScolastico: ").append(toIndentedString(idIstitutoScolastico)).append("\n");
    sb.append("    codRegionaleScuola: ").append(toIndentedString(codRegionaleScuola)).append("\n");
    sb.append("    codRegionaleAutonomia: ").append(toIndentedString(codRegionaleAutonomia)).append("\n");
    sb.append("    codMeccanograficoScuola: ").append(toIndentedString(codMeccanograficoScuola)).append("\n");
    sb.append("    codMeccanograficoAutonomia: ").append(toIndentedString(codMeccanograficoAutonomia)).append("\n");
    sb.append("    denominazione: ").append(toIndentedString(denominazione)).append("\n");
    sb.append("    comuneScuola: ").append(toIndentedString(comuneScuola)).append("\n");
    sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
    sb.append("    recapitoMail: ").append(toIndentedString(recapitoMail)).append("\n");
    sb.append("    recapitoTelefonico: ").append(toIndentedString(recapitoTelefonico)).append("\n");
    sb.append("    urlSitoWeb: ").append(toIndentedString(urlSitoWeb)).append("\n");
    sb.append("    gradoScolastico: ").append(toIndentedString(gradoScolastico)).append("\n");
    sb.append("    tipologiaIstituto: ").append(toIndentedString(tipologiaIstituto)).append("\n");
    sb.append("    percorsoScolastico: ").append(toIndentedString(percorsoScolastico)).append("\n");
    sb.append("    tipoSezione: ").append(toIndentedString(tipoSezione)).append("\n");
    sb.append("    tipoUnita: ").append(toIndentedString(tipoUnita)).append("\n");
    sb.append("    annoScolastico: ").append(toIndentedString(annoScolastico)).append("\n");
    sb.append("    dataChiusura: ").append(toIndentedString(dataChiusura)).append("\n");
    sb.append("    dataApertura: ").append(toIndentedString(dataApertura)).append("\n");
    sb.append("    dataModifica: ").append(toIndentedString(dataModifica)).append("\n");
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
