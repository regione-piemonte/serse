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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AmministrazioneResponsabileDTOTest {
    AmministrazioneResponsabileDTO amministrazioneResponsabileDTO = new AmministrazioneResponsabileDTO();

    @Test
    void testSetCodAr() throws Exception {
        amministrazioneResponsabileDTO.setCodAr(Integer.valueOf(0));
    }

    @Test
    void testSetDescrizione() throws Exception {
        amministrazioneResponsabileDTO.setDescrizione("descrizione");
    }

    @Test
    void testSetSiglaEnte() throws Exception {
        amministrazioneResponsabileDTO.setSiglaEnte("siglaEnte");
    }


    @Test
    void testToString() throws Exception {
        String result = amministrazioneResponsabileDTO.toString();
        assertEquals("AmministrazioneResponsabileDTO [codAr=null, descrizione=null, siglaEnte=null]", result);
    }
}
