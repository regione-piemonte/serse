package it.csi.serse.serseweb.mapper;

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

import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.AmmResponsabileDto;
import it.csi.serse.serseweb.vo.AmministrazioneResponsabile;
import it.csi.serse.serseweb.vo.ClassTabFinanziamentoBudgetDisponibile;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GamMapper {

    @Mapping(target = "codAr", source = "codAR")
	//metodo per mappare dalla classe AmmResponsabile di gam a AmministrazioneResponsabile generata in questa applicazione
	public AmministrazioneResponsabile toVo(AmmResponsabileDto dto);
	
	public List<AmministrazioneResponsabile> listGamMapToVo(List<AmmResponsabileDto> dtoList);

	public ClassTabFinanziamentoBudgetDisponibile map(
		it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.ClassTabFinanziamentoBudgetDisponibile classTabFinanziamentoBudgetDisponibile);
}
