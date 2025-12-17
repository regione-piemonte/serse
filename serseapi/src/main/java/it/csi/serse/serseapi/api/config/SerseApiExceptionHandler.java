package it.csi.serse.serseapi.api.config;

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

import it.csi.serse.serseapi.api.exception.ErroreGestitoException;
import it.csi.serse.serseapi.api.exception.ErroreIntegritaDatiException;
import it.csi.serse.serseapi.helper.ErrorHelper;
import org.springframework.http.HttpStatus;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SerseApiExceptionHandler  implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException exception) {
        if(exception instanceof ErroreIntegritaDatiException){
            return handleDataIntegrityViolation((ErroreIntegritaDatiException) exception);
        }
        if(exception instanceof ErroreGestitoException){
            return handleErrore((ErroreGestitoException) exception);
        }
        return handleGenericError(exception);
    }

    private Response handleDataIntegrityViolation( ErroreIntegritaDatiException exception){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorHelper.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage())).build();
    }

    private Response handleGenericError(RuntimeException exception){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorHelper.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), "si è verificato un errore bloccante con il server")).build();
    }

    private Response handleErrore(ErroreGestitoException exception){
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorHelper.createErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage())).build();
    }
}
