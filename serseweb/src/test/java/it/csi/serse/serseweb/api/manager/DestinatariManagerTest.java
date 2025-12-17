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

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.csi.serse.serseweb.vo.Destinatario;

class DestinatariManagerTest {
    
    DestinatariManager destinatariManager = new DestinatariManager();

    @Test
    void testControlliFormali() {
        Destinatario destinatario = new Destinatario();
        String result;

        destinatario.setCapResidenza("12A45");
        result = destinatariManager.controlliFormali(destinatario);
        assertTrue(result.contains("CAP Residenza non numerico"));

        destinatario.setCapResidenza("123456");
        result = destinatariManager.controlliFormali(destinatario);
        assertTrue(result.contains("CAP Residenza troppo  lungo"));

        destinatario.setCodiceFiscaleDestinatario("1234512345123451234512345");
        result = destinatariManager.controlliFormali(destinatario);
        assertTrue(result.contains("CF troppo lungo"));

        destinatario.setCodiceFiscaleDestinatario("123 123");
        result = destinatariManager.controlliFormali(destinatario);
        assertTrue(result.contains("CF non deve contenere spazi"));

        destinatario.setCodCittadinanza("12345678");
        result = destinatariManager.controlliFormali(destinatario);
        assertTrue(result.contains("Codice cittadinanza troppo lungo"));
    }
}
