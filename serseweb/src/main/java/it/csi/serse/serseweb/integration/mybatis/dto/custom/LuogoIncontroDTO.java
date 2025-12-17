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
import java.util.Date;

public class LuogoIncontroDTO extends ParentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idLuogoIncontro = null;
    private ProvenienzaLuogoDTO provenienzaLuogo = null;
    private String denominazioneLuogo = null;
    private String indirizzoLuogo = null;
    private ComuneDTO comuneIncontro = null;
    private String note = null;
    private String codUserInserim = null;
    private Date dInserim = null;
    private String codUserAggiorn = null;
    private Date dAggiorn = null;

    public Long getIdLuogoIncontro() {
        return idLuogoIncontro;
    }

    public void setIdLuogoIncontro(Long idLuogoIncontro) {
        this.idLuogoIncontro = idLuogoIncontro;
    }

    public ProvenienzaLuogoDTO getProvenienzaLuogo() {
        return provenienzaLuogo;
    }

    public void setProvenienzaLuogo(ProvenienzaLuogoDTO provenienzaLuogo) {
        this.provenienzaLuogo = provenienzaLuogo;
    }

    public String getDenominazioneLuogo() {
        return denominazioneLuogo;
    }

    public void setDenominazioneLuogo(String denominazioneLuogo) {
        this.denominazioneLuogo = denominazioneLuogo;
    }

    public String getIndirizzoLuogo() {
        return indirizzoLuogo;
    }

    public void setIndirizzoLuogo(String indirizzoLuogo) {
        this.indirizzoLuogo = indirizzoLuogo;
    }

    public ComuneDTO getComuneIncontro() {
        return comuneIncontro;
    }

    public void setComuneIncontro(ComuneDTO comuneIncontro) {
        this.comuneIncontro = comuneIncontro;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCodUserInserim() {
        return codUserInserim;
    }

    public void setCodUserInserim(String codUserInserim) {
        this.codUserInserim = codUserInserim;
    }

    public Date getdInserim() {
        return dInserim;
    }

    public void setdInserim(Date dInserim) {
        this.dInserim = dInserim;
    }

    public String getCodUserAggiorn() {
        return codUserAggiorn;
    }

    public void setCodUserAggiorn(String codUserAggiorn) {
        this.codUserAggiorn = codUserAggiorn;
    }

    public Date getdAggiorn() {
        return dAggiorn;
    }

    public void setdAggiorn(Date dAggiorn) {
        this.dAggiorn = dAggiorn;
    }
}
