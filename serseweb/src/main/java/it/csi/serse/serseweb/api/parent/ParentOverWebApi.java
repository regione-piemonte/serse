/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.serse.serseweb.api.parent;

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

import jakarta.ws.rs.core.Response;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.csi.serse.serseweb.vo.GenericResponse;
public abstract class ParentOverWebApi extends SpringBeanAutowiringSupport {
	public Response responseOK() {
		GenericResponse genericResponse=new GenericResponse();
		
		genericResponse.setMessage("OK");
		
		return Response.ok(genericResponse).build();
    }
}
