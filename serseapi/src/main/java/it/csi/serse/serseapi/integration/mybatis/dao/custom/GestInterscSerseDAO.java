package it.csi.serse.serseapi.integration.mybatis.dao.custom;

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

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseRServizioFonteDTO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseRServizioVoceSpesaDTO;

@Mapper
@Component
public interface GestInterscSerseDAO extends ParentDAO {

    void updateVociSpesa(@Param("vociSpesa") List<SerseRServizioVoceSpesaDTO> voceSpesaDto)
            throws DataIntegrityViolationException;

    void updateServizioFonte(@Param("serviziFonte") List<SerseRServizioFonteDTO> servizioFonte)
            throws DataIntegrityViolationException;

    void saveVoceSpesaServizio(@Param("vociSpesa") List<SerseRServizioVoceSpesaDTO> vociSpesa);

    void saveServiziFonte(@Param("serviziFonte") List<SerseRServizioFonteDTO> servizioFonte);
}
