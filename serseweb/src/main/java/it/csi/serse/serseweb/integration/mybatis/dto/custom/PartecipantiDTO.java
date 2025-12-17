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

import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioDTO;

import java.io.Serializable;

import java.util.Date;

public class PartecipantiDTO extends ParentDTO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7696125595312365439L;

    SerseTDestinatarioDTO destinatario = null;
    IncontroDestinatarioServizioDTO incontroDestinatarioServizio = null;
    private Long idDestinatarioServizio = null;
    private Long numerazioneDestinatario = null;
    private Date dtInserimentoDestinatarioServizio = null;

    public SerseTDestinatarioDTO getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(SerseTDestinatarioDTO destinatario) {
        this.destinatario = destinatario;
    }

    public IncontroDestinatarioServizioDTO getIncontroDestinatarioServizio() {
        return incontroDestinatarioServizio;
    }

    public void setIncontroDestinatarioServizio(IncontroDestinatarioServizioDTO incontroDestinatarioServizio) {
        this.incontroDestinatarioServizio = incontroDestinatarioServizio;
    }
    public Long getIdDestinatarioServizio() {
        return idDestinatarioServizio;
    }

    public void setIdDestinatarioServizio(Long idDestinatarioServizio) {
        this.idDestinatarioServizio = idDestinatarioServizio;
    }

    public Long getNumerazioneDestinatario() {
        return numerazioneDestinatario;
    }

    public void setNumerazioneDestinatario(Long numerazioneDestinatario) {
        this.numerazioneDestinatario = numerazioneDestinatario;
    }

    public Date getDtInserimentoDestinatarioServizio() {
        return dtInserimentoDestinatarioServizio;
    }

    public void setDtInserimentoDestinatarioServizio(Date dtInserimentoDestinatarioServizio) {
        this.dtInserimentoDestinatarioServizio = dtInserimentoDestinatarioServizio;
    }

    

    
}
