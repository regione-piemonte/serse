package it.csi.serse.serseweb.integration.mybatis.dto.custom;

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

import java.io.Serializable;

public class SportelloMonitoraggioDTO extends ParentDTO implements Serializable {

    private Long idRegComportPsoSport = null;
    private String flgLivelloIstruzione = null;
    private String flgCondizioneOccupazionale = null;
    private String flgDisabilita = null;
    private String flgSvantaggioAbitativo = null;
    private String codLivelloIstruzioneDefault = null;
    private String codCondizioneOccupazionale = null;
    private String flgDisabilitaDefault = null;
    private String flgSvantaggioAbitativoDefault = null;

    public Long getIdRegComportPsoSport() {
        return idRegComportPsoSport;
    }

    public void setIdRegComportPsoSport(Long idRegComportPsoSport) {
        this.idRegComportPsoSport = idRegComportPsoSport;
    }

    public String getFlgLivelloIstruzione() {
        return flgLivelloIstruzione;
    }

    public void setFlgLivelloIstruzione(String flgLivelloIstruzione) {
        this.flgLivelloIstruzione = flgLivelloIstruzione;
    }

    public String getFlgCondizioneOccupzionale() {
        return flgCondizioneOccupazionale;
    }

    public void setFlgCondizioneOccupzionale(String flgCondizioneOccupzionale) {
        this.flgCondizioneOccupazionale = flgCondizioneOccupzionale;
    }

    public String getFlgDisabilita() {
        return flgDisabilita;
    }

    public void setFlgDisabilita(String flgDisabilita) {
        this.flgDisabilita = flgDisabilita;
    }

    public String getFlgSvantaggioAbitativo() {
        return flgSvantaggioAbitativo;
    }

    public void setFlgSvantaggioAbitativo(String flgSvantaggioAbitativo) {
        this.flgSvantaggioAbitativo = flgSvantaggioAbitativo;
    }

    public String getCodLivelloIstruzioneDefault() {
        return codLivelloIstruzioneDefault;
    }

    public void setCodLivelloIstruzioneDefault(String codLivelloIstruzioneDefault) {
        this.codLivelloIstruzioneDefault = codLivelloIstruzioneDefault;
    }

    public String getCodCondizioneOccupazionale() {
        return codCondizioneOccupazionale;
    }

    public void setCodCondizioneOccupazionale(String codCondizioneOccupazionale) {
        this.codCondizioneOccupazionale = codCondizioneOccupazionale;
    }

    public String getFlgDisabilitaDefault() {
        return flgDisabilitaDefault;
    }

    public void setFlgDisabilitaDefault(String flgDisabilitaDefault) {
        this.flgDisabilitaDefault = flgDisabilitaDefault;
    }

    public String getFlgSvantaggioAbitativoDefault() {
        return flgSvantaggioAbitativoDefault;
    }

    public void setFlgSvantaggioAbitativoDefault(String flgSvantaggioAbitativoDefault) {
        this.flgSvantaggioAbitativoDefault = flgSvantaggioAbitativoDefault;
    }
}
