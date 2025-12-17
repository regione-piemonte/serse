/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.serse.serseapi.api.manager;

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

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.springframework.http.HttpStatus;

import it.csi.serse.serseapi.helper.ErrorHelper;
import it.csi.serse.serseapi.provider.SerseApiExceptionHandler;
import it.csi.serse.serseapi.vo.GenericResponse;

public abstract class ParentManager {

	public static String NO_RESULT = "Nessun risultato trovato per l'input: ";
	public static String PARAMETRO_OBBLIGATORIO_MANCANTE = "Parametri obbligatori mancanti: ";

	public static String MSG_NESSUNA_TIPOLOGIA_DISPONIBILE_PER_UTENTE = "nessun pso disponibile per l'utente ";
	public static String MSG_PARAMETRO_OBBLIGATORIO_NON_VALIDO = "l'id passato non è corretto";

	public Response internalServerError() {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(ErrorHelper
				.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), SerseApiExceptionHandler.MSG_UNEXPECTED_ERROR))
				.build();
	}

	public Response parametriObbligatoriMancantiIncongruenti(String msg) {
		return parametriObbligatoriMancantiIncongruenti(HttpStatus.BAD_REQUEST.value(), msg);
	}

	public Response parametriObbligatoriMancantiIncongruenti(int code, String msg) {
		return Response.serverError().entity(ErrorHelper.createErrore(code, msg)).status(Status.BAD_REQUEST).build();
	}

	public Response conflictException(String msg) {
		return conflictException(HttpStatus.CONFLICT.value(), msg);
	}

	public Response conflictException(int code, String msg) {
		return Response.serverError().entity(ErrorHelper.createErrore(code, msg)).status(Status.CONFLICT).build();
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
				.status(Status.BAD_REQUEST).build();
	}

	public Response noResoultFound(String msg) {
		return Response.serverError().entity(ErrorHelper.createErrore(HttpStatus.NOT_FOUND.value(), NO_RESULT + msg))
				.status(Status.NOT_FOUND).build();
	}

	public Response responseOK() {
		GenericResponse genericResponse = new GenericResponse();

		genericResponse.setMessage("OK");

		return Response.ok(genericResponse).build();
	}

}
