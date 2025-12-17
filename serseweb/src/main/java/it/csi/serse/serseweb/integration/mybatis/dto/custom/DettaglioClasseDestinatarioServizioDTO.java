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

public class DettaglioClasseDestinatarioServizioDTO extends ParentDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Long idPsoClasseDestinatario = null;
    private String descrClasseDestinatario = null;
    private String valoreDatoPeculiare1 = null;

    public Long getIdPsoClasseDestinatario() {
        return idPsoClasseDestinatario;
    }

    public void setIdPsoClasseDestinatario(Long idPsoClasseDestinatario) {
        this.idPsoClasseDestinatario = idPsoClasseDestinatario;
    }

    public String getDescrClasseDestinatario() {
        return descrClasseDestinatario;
    }

    public void setDescrClasseDestinatario(String descrClasseDestinatario) {
        this.descrClasseDestinatario = descrClasseDestinatario;
    }

    public String getValoreDatoPeculiare1() {
        return valoreDatoPeculiare1;
    }

    public void setValoreDatoPeculiare1(String valoreDatoPeculiare1) {
        this.valoreDatoPeculiare1 = valoreDatoPeculiare1;
    }

}