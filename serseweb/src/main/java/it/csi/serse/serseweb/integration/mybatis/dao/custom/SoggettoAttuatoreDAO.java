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

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;

@Component
@Mapper
public interface SoggettoAttuatoreDAO extends ParentDAO {

	List<SoggettoAttuatoreDTO> getIstanzeCandidatura(@Param("numProgrSportello") Long numProgrSportello,
			@Param("codOperatore") Long codOperatore, @Param("gruppoOperatore") String gruppoOperatore,
			@Param("soloCapofila") boolean soloCapofila);

	List<SoggettoAttuatoreDTO> getIstanzeCandidaturaPerCodAreaTerritoriale(
			@Param("codAreaTerritoriale") String codAreaTerritoriale);

	SoggettoAttuatoreDTO getSoggettoBeneficiario(@Param("idSoggettoAttuatore") Long idSoggettoAttuatore);

	List<SoggettoAttuatoreDTO> getSoggettiBeneficiari(@Param("numProgrSportello") Long numProgrSportello,
			@Param("codOperatore") Integer codOperatore, @Param("grOperatore") String gruppoOperatore);

	SoggettoAttuatoreDTO getSoggettoAttuatore(@Param("idSoggettoAttuatore") Integer idSoggettoAttuatore);

	List<SoggettoAttuatoreDTO> getSoggettiAttuatori(@Param("numProgrSportello") Long numProgrSportello,
			@Param("codOperatore") Integer codOperatore, @Param("grOperatore") String gruppoOperatore);

	List<SoggettoAttuatoreDTO> getSoggettiAttuatoriRicerca(@Param("numProgrSportello") Long numProgrSportello,
			@Param("codOperatore") Integer codOperatore, @Param("grOperatore") String gruppoOperatore,
			@Param("modelId") Long modelId);
}
