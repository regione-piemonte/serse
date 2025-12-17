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
import java.math.BigDecimal;
import java.util.Date;

public class IncontroDestinatarioServizioDTO extends ParentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idIncontro = null;
    private Long idDestinatarioServizio = null;
    private Long idEnteCoinvoltoServizio = null;
    private BigDecimal orePresenza = null;
    private String codUserInserimento = null;
    private Date dataInserimento = null;
    private String codUserAggiornamento = null;
    private Date dataAggiornamento = null;

    public Long getIdIncontro() {
        return idIncontro;
    }

    public void setIdIncontro(Long idIncontro) {
        this.idIncontro = idIncontro;
    }

    public Long getIdDestinatarioServizio() {
        return idDestinatarioServizio;
    }

    public void setIdDestinatarioServizio(Long idDestinatarioServizio) {
        this.idDestinatarioServizio = idDestinatarioServizio;
    }

    public Long getIdEnteCoinvoltoServizio() {
        return idEnteCoinvoltoServizio;
    }

    public void setIdEnteCoinvoltoServizio(Long idEnteCoinvoltoServizio) {
        this.idEnteCoinvoltoServizio = idEnteCoinvoltoServizio;
    }

    public BigDecimal getOrePresenza() {
        return orePresenza;
    }

    public void setOrePresenza(BigDecimal orePresenza) {
        this.orePresenza = orePresenza;
    }

    public String getCodUserInserimento() {
        return codUserInserimento;
    }

    public void setCodUserInserimento(String codUserInserimento) {
        this.codUserInserimento = codUserInserimento;
    }

    public Date getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(Date dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public String getCodUserAggiornamento() {
        return codUserAggiornamento;
    }

    public void setCodUserAggiornamento(String codUserAggiornamento) {
        this.codUserAggiornamento = codUserAggiornamento;
    }

    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    public void setDataAggiornamento(Date dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }
}
