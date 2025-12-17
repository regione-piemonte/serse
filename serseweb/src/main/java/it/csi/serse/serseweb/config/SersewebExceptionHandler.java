package it.csi.serse.serseweb.config;

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

import jakarta.ws.rs.NotAllowedException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;

import it.csi.serse.serseweb.api.exception.ErroreGestitoException;
import it.csi.serse.serseweb.api.exception.InternalErrorException;
import it.csi.serse.serseweb.api.exception.UtenteNonAbilitatoException;
import it.csi.serse.serseweb.helper.ErrorHelper;



@Provider
public class SersewebExceptionHandler implements ExceptionMapper<RuntimeException>{
	
	public static final String MSG_ERROR = "Attenzione si e' verificato un problema bloccante con il server";
	public static final String MSG_BAD_REQUEST = "Attenzione la richiesta inviata non e' corretta";
	public static final String MSG_DB_ERROR = "Attenzione si e' verificato un errore nell'accesso alla base dati";
	public static final String MSG_UNEXPECTED_ERROR = "Attenzione si e' verificato un errore inaspettato";
	public static final String MSG_FORBIDDEN_USER = "Utente non autorizzato a questa funzionalita'";
	public static final String MSG_CONNECTION_SERVICE_ERROR="Il servizio esterno non risponde ";
	
	
	public Response toResponse(RuntimeException exception) {
		if (exception instanceof NotFoundException) {
			return handleNotFoundException((NotFoundException) exception);
		}
		if (exception instanceof NotAllowedException) {
			return handleNotAllowedException((NotAllowedException) exception);
		}
		if (exception instanceof DataAccessException) {
			return handleDataAccessException((DataAccessException) exception);
		}
		if (exception instanceof BadSqlGrammarException) {
			return handleBadSqlGrammarException((BadSqlGrammarException) exception);
		}
		if (exception instanceof ErroreGestitoException) {
			return handleErroreGestitoException((ErroreGestitoException) exception);
		}
		if (exception instanceof UtenteNonAbilitatoException) {
			return handleUtenteNonAbilitatoException((UtenteNonAbilitatoException) exception);
		}
		if (exception instanceof InternalErrorException) {
			return handleGenericException(exception);
		}
		if(exception instanceof ErroreConnessioneServizioException){
			return handleErroreConnessioneServizio((ErroreConnessioneServizioException) exception);
		}
		return handleGenericException(exception);

	}

	private Response handleNotFoundException(NotFoundException exception) {
		return Response.status(Status.BAD_REQUEST)
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(HttpStatus.BAD_REQUEST.value(),exception.getMessage(), MSG_BAD_REQUEST))
		.build();
	}
	
	private Response handleNotAllowedException(NotAllowedException exception) {
		return Response.status(Status.METHOD_NOT_ALLOWED)
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage()))
		.build();
	}
	
	private Response handleDataAccessException(DataAccessException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR)
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), MSG_ERROR))
		.build();
	}
	
	private Response handleBadSqlGrammarException(BadSqlGrammarException exception) {
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), MSG_ERROR))
		.build();
	}
	
	
	private Response handleErroreGestitoException(ErroreGestitoException exception) {
		return Response.status(HttpStatus.BAD_REQUEST.value())
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(HttpStatus.BAD_REQUEST.value(), exception.getMessage()))
		.build();
	}

	private Response handleUtenteNonAbilitatoException(UtenteNonAbilitatoException exception) {
		return Response.status(HttpStatus.FORBIDDEN.value())
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(HttpStatus.FORBIDDEN.value(), MSG_FORBIDDEN_USER))
		.build();
	}

	private Response handleGenericException(RuntimeException exception) {
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), MSG_UNEXPECTED_ERROR))
		.build();
	}

	private Response handleErroreConnessioneServizio(ErroreConnessioneServizioException exception){
		return Response.status(exception.getStatus())
		.type(MediaType.APPLICATION_JSON)
		.entity(ErrorHelper.createErrore(exception.getStatus(),MSG_CONNECTION_SERVICE_ERROR,MSG_CONNECTION_SERVICE_ERROR))
		.build();
	}
}
