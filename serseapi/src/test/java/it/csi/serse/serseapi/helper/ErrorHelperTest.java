package it.csi.serse.serseapi.helper;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import it.csi.serse.serseapi.vo.Errore;


class ErrorHelperTest {

	@Test
	void testCreateErroreWithThreeParameters() {
		int code = 404;
		String errorMessage = "Not Found";
		String messaggioCittadino = "Risorsa non trovata";

		Errore errore = ErrorHelper.createErrore(code, errorMessage, messaggioCittadino);

		assertEquals(code, errore.getCode());
		assertEquals(errorMessage, errore.getErrorMessage());
	}

	@Test
	void testCreateErroreWithTwoParameters() {
		int code = 500;
		String errorMessage = "Internal Server Error";

		Errore errore = ErrorHelper.createErrore(code, errorMessage);

		assertEquals(code, errore.getCode());
		assertEquals(errorMessage, errore.getErrorMessage());
	}
}