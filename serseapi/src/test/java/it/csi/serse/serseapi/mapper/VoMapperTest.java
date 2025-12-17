package it.csi.serse.serseapi.mapper;

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

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import it.csi.serse.serseapi.integration.mybatis.dto.custom.DestinatarioDTO;
import it.csi.serse.serseapi.integration.mybatis.dto.custom.ServiziDestinatarioDTO;
import it.csi.serse.serseapi.vo.OutputEsposizioneAnagrafiche;
import it.csi.serse.serseapi.vo.OutputEsposizioneServiziItem;

class VoMapperTest {

    private VoMapper voMapper = Mappers.getMapper(VoMapper.class);

    @Test
    void testUpdateMapping() {
        DestinatarioDTO source = new DestinatarioDTO();
        source.setIdDestinatario(1L);
        source.setCfDestinatario("ABCDEF12G34H567I");
        source.setCognomeDestinatario("Rossi");
        source.setNomeDestinatario("Mario");
        source.setDescomNascita("Roma");
        source.setSigprovNascita("RM");
        source.setDescrizioneStatoEsteroNascita("Italia");
        source.setDescomResidenza("Milano");
        source.setSigprovResidenza("MI");
        source.setDescrizioneStatoEsteroResidenza("Italia");
        source.setDescomDomicilio("Torino");
        source.setSigprovDomicilio("TO");
        source.setCodCittadinanza("IT");
        source.setDescrCittadinanza("Italiana");

        OutputEsposizioneAnagrafiche target = new OutputEsposizioneAnagrafiche();

        voMapper.updateMapping(target, source);

        assertEquals(source.getIdDestinatario(), target.getIdDestinatarioSerse());
        assertEquals(source.getCfDestinatario(), target.getCodiceFiscale());
        assertEquals(source.getCognomeDestinatario(), target.getCognome());
        assertEquals(source.getNomeDestinatario(), target.getNome());
        assertEquals(source.getDescomNascita(), target.getDescrComuneNascita());
        assertEquals(source.getSigprovNascita(), target.getSiglaProvinciaNascita());
        assertEquals(source.getDescrizioneStatoEsteroNascita(), target.getDescrStatoEsteroNascita());
        assertEquals(source.getDescomResidenza(), target.getDescrComuneResidenza());
        assertEquals(source.getSigprovResidenza(), target.getSiglaProvinciaResidenza());
        assertEquals(source.getDescrizioneStatoEsteroResidenza(), target.getDescrStatoEsteroResidenza());
        assertEquals(source.getDescomDomicilio(), target.getDescrComuneDomicilio());
        assertEquals(source.getSigprovDomicilio(), target.getSiglaProvinciaDomicilio());
        assertEquals(source.getCodCittadinanza(), target.getCodIstatCittadinanza());
        assertEquals(source.getDescrCittadinanza(), target.getDescrIstatCittadinanza());
    }

    @Test
    void testMap() {
        ServiziDestinatarioDTO source = new ServiziDestinatarioDTO();
        source.setIdServizio(1L);
        source.setIdServizioRegionale(22);
        source.setGruppoOperatore("B");
        source.setCodOperatore(6);
        source.setDescrStatoServizio("Attivo");
        source.setGruppoBeneficiario("C");
        source.setCodBeneficiario(7);

        OutputEsposizioneServiziItem result = voMapper.map(source);

        assertEquals(source.getIdServizio(), result.getIdServizioSerse());
        assertEquals(source.getIdServizioRegionale(), result.getCodServizioRegionale());
        assertEquals(source.getGruppoOperatore(), result.getGruppoSoggettoAttuatore());
        assertEquals(source.getCodOperatore(), result.getCodiceSoggettoAttuatore());
        assertEquals(source.getDescrStatoServizio(), result.getStatoServizio());
        assertEquals(source.getGruppoBeneficiario(), result.getGruppoSoggettoBeneficiario());
        assertEquals(source.getCodBeneficiario(), result.getCodiceSoggettoBeneficiario());
    }

    @Test
    void testMapServizi() {
        ServiziDestinatarioDTO dto1 = new ServiziDestinatarioDTO();
        dto1.setIdServizio(1L);
        dto1.setIdServizioRegionale(22);

        ServiziDestinatarioDTO dto2 = new ServiziDestinatarioDTO();
        dto2.setIdServizio(2L);
        dto2.setIdServizioRegionale(23);

        List<ServiziDestinatarioDTO> sourceList = List.of(dto1, dto2);

        List<OutputEsposizioneServiziItem> resultList = voMapper.mapServizi(sourceList);

        assertEquals(2, resultList.size());
        assertEquals(dto1.getIdServizio(), resultList.get(0).getIdServizioSerse());
        assertEquals(dto2.getIdServizio(), resultList.get(1).getIdServizioSerse());
    }
}