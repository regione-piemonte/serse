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

public class ProvenienzaLuogoDTO extends ParentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idProvenienzaLuogo = null;
    private String descrProvenienzaLuogo = null;
    private Long idPso = null;
    private Long idFonteDato = null;
    private String descrFonteDato = null;

    public Long getIdProvenienzaLuogo() {
        return idProvenienzaLuogo;
    }

    public void setIdProvenienzaLuogo(Long idProvenienzaLuogo) {
        this.idProvenienzaLuogo = idProvenienzaLuogo;
    }

    public String getDescrProvenienzaLuogo() {
        return descrProvenienzaLuogo;
    }

    public void setDescrProvenienzaLuogo(String descrProvenienzaLuogo) {
        this.descrProvenienzaLuogo = descrProvenienzaLuogo;
    }

    public Long getIdPso() {
        return idPso;
    }

    public void setIdPso(Long idPso) {
        this.idPso = idPso;
    }

    public Long getIdFonteDato() {
        return idFonteDato;
    }

    public void setIdFonteDato(Long idFonteDato) {
        this.idFonteDato = idFonteDato;
    }

    public String getDescrFonteDato() {
        return descrFonteDato;
    }

    public void setDescrFonteDato(String descrFonteDato) {
        this.descrFonteDato = descrFonteDato;
    }
}
