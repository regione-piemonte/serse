/**********************************************
 * CSI PIEMONTE 
 **********************************************/
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

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import it.csi.serse.serseweb.helper.ErrorHelper;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtComuneDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneDTO;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.config.SersewebExceptionHandler;
import it.csi.serse.serseweb.vo.GenericResponse;

/**
 * Classe astratta che contiene metodi / costanti di utilità per i vari manager
 */
public abstract class ParentManager {
	@Autowired
	private ExtTtComuneDAO comuneDao;

	protected static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".business");
	
	// public static String NO_RESULT=
	public static final String PARAMETRO_OBBLIGATORIO_MANCANTE = "Parametri obbligatori mancanti: ";
	public static final String MSG_NESSUNA_TIPOLOGIA_DISPONIBILE_PER_UTENTE = "Nessun Avviso disponibile per l’utente collegato";
	public static final String MSG_PARAMETRO_OBBLIGATORIO_NON_VALIDO = "l'id passato non è corretto";

	public Response internalServerError() {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(ErrorHelper
				.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), SersewebExceptionHandler.MSG_UNEXPECTED_ERROR))
				.build();
	}

	public Response parametriObbligatoriMancantiIncongruenti(String msg) {
		return parametriObbligatoriMancantiIncongruenti(HttpStatus.BAD_REQUEST.value(), msg);
	}

	public Response parametriObbligatoriMancantiIncongruenti(int code, String msg) {
		return Response.serverError().entity(ErrorHelper.createErrore(code, msg))
				.type(MediaType.APPLICATION_JSON)
				.status(Status.BAD_REQUEST).build();
	}

	public Response conflictException(String msg) {
		return conflictException(HttpStatus.CONFLICT.value(), msg);
	}

	public Response conflictException(int code, String msg) {
		return Response.serverError().entity(ErrorHelper.createErrore(code, msg))
				.type(MediaType.APPLICATION_JSON)
				.status(Status.CONFLICT).build();
	}

	public Response parametriObbligatoriMancanti(List<String> inputList) {
		StringBuilder sb = new StringBuilder(PARAMETRO_OBBLIGATORIO_MANCANTE);
		boolean first = true;
		for (String input : inputList) {
			if (!first)
				sb.append(", ");
			first = false;
			sb.append(input);
		}
		return Response.serverError().entity(ErrorHelper.createErrore(HttpStatus.BAD_REQUEST.value(), sb.toString()))
				.type(MediaType.APPLICATION_JSON)
				.status(Status.BAD_REQUEST).build();
	}

	public Response noResoultFound(String msg) {
		return Response.serverError().entity(ErrorHelper.createErrore(HttpStatus.NOT_FOUND.value(), msg))
				.type(MediaType.APPLICATION_JSON)
				.status(Status.NOT_FOUND).build();
	}

	public Response responseOK() {
		GenericResponse genericResponse = new GenericResponse();

		genericResponse.setMessage("OK");

		return Response.ok(genericResponse).build();
	}
	
	public ExtTtComuneDTO getComuneByCodIstat(String codIstatComune) {
		return comuneDao.selectByPrimaryKey(codIstatComune);
	}

}
