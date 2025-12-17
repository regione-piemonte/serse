package it.csi.serse.serseweb.integration.mybatis.dao.custom;

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

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipoModelloDTO;

@Component
@Mapper
public interface TipiModelloDAO extends ParentDAO {
	 List<TipoModelloDTO> getTipiModelloForPso( @Param("idPso") Integer psoId);
}
