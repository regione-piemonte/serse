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

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import it.csi.serse.serseapi.integration.mybatis.dto.custom.DestinatarioDTO;
import it.csi.serse.serseapi.integration.mybatis.dto.custom.ServiziDestinatarioDTO;
import it.csi.serse.serseapi.vo.OutputEsposizioneAnagrafiche;
import it.csi.serse.serseapi.vo.OutputEsposizioneServiziItem;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VoMapper {
    
    @Mapping(target = "idDestinatarioSerse", source = "idDestinatario")
    @Mapping(target = "codiceFiscale", source = "cfDestinatario")
    @Mapping(target = "cognome", source = "cognomeDestinatario")
    @Mapping(target = "nome", source = "nomeDestinatario")
    @Mapping(target = "descrComuneNascita", source = "descomNascita")
    @Mapping(target = "siglaProvinciaNascita", source = "sigprovNascita")
    @Mapping(target = "descrStatoEsteroNascita", source = "descrizioneStatoEsteroNascita")
    @Mapping(target = "descrComuneResidenza", source = "descomResidenza")
    @Mapping(target = "siglaProvinciaResidenza", source = "sigprovResidenza")
    @Mapping(target = "descrStatoEsteroResidenza", source = "descrizioneStatoEsteroResidenza")
    @Mapping(target = "descrComuneDomicilio", source = "descomDomicilio")
    @Mapping(target = "siglaProvinciaDomicilio", source = "sigprovDomicilio")
    @Mapping(target = "codIstatCittadinanza", source = "codCittadinanza")
    @Mapping(target = "descrIstatCittadinanza", source = "descrCittadinanza")
    void updateMapping(@MappingTarget OutputEsposizioneAnagrafiche target, DestinatarioDTO source);

    @Mapping(target = "idServizioSerse", source = "idServizio")
    @Mapping(target = "codServizioRegionale", source = "idServizioRegionale")
    @Mapping(target = "gruppoSoggettoAttuatore", source = "gruppoOperatore")
    @Mapping(target = "codiceSoggettoAttuatore", source = "codOperatore")
    @Mapping(target = "statoServizio", source = "descrStatoServizio")
    @Mapping(target = "gruppoSoggettoBeneficiario", source = "gruppoBeneficiario")
    @Mapping(target = "codiceSoggettoBeneficiario", source = "codBeneficiario")
    @Mapping(target = "denominazioneSoggettoAttuatore", ignore = true)
    @Mapping(target = "denominazioneSoggettoBeneficiario", ignore = true)
    OutputEsposizioneServiziItem map(ServiziDestinatarioDTO source);

    List<OutputEsposizioneServiziItem> mapServizi(List<ServiziDestinatarioDTO> data);
}
