package it.csi.serse.serseweb.api.manager;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.CentriPerImpiegoDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.CentroPerImpiegoDTO;
import it.csi.serse.serseweb.mapper.GenericMapper;
import jakarta.ws.rs.core.Response;

@Component
public class CentriPerImpiegoManager extends ParentManager {
	
	@Autowired
	private CentriPerImpiegoDAO centriPerImpiegoDAO;
	
	@Autowired
	private GenericMapper genericMapper;
	
	public Response getCentriPerImpiego(String codIstatComune, String codProvincia) {
		List<CentroPerImpiegoDTO> centriPerImpiego=centriPerImpiegoDAO.getCentriPerImpiego(codIstatComune, codProvincia);
		if(centriPerImpiego!=null) {
			return Response.ok(genericMapper.mapListCentriImpiego(centriPerImpiego)).build();
		}
		return Response.ok(centriPerImpiego).build();
	}
}
