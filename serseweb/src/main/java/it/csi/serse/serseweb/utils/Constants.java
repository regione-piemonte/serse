package it.csi.serse.serseweb.utils;

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

import java.util.Map;
import java.util.HashMap;

public class Constants {

	public static final String COD_COMPONENTE = "serseweb";
	
	public static final int MAX_LOG_LENGTH = 5000;

	public static class IRIDE_ATTRIBUTES {
		public static final String COMPONENT_NAME = "serseweb";
		public static final String USERINFO_REQ_ATTR = "appDatacurrentUser";
		public static final String ID_REQ_ATTR = "iride2_id";
	}
	
	public static class FLAIANAG {
		public static final String COD_MATERIA_FP = "FP";
	}

	public static class CODE_ERROR {
		public static final int ERRORE_SQL = 1;
		public static final int ERRORE_PARAMETRO_MALFORMED = 2;
		public static final int ERRORE_PARAMETRO_OBLIGATORIO = 3;
	}

	public static class LOGGING {
		public static final String LOGGER_NAME = "serseweb";
		public static final int MAX_LOG_LENGTH = 5000;
	}

	public static final class TipoProtocollazione {
		public static final String DOM_ESP = "DOM_ESP";
	}

	public static Map<String, String> RUOLI_MAP = new HashMap<>();
	
	public static class INPUT_MISSING {
		public static final String ID_MODELLO_INTERVENTO="idModelloIntervento";
		public static final String COD_USER_AGGIORNAMENTO="codUserAggiornamento";
		public static final String ID_PSO="idPso";
		public static final String ID_INTERVENTO="idIntervento";
		public static final String NUM_PROGR_SPORTELLO="numProgrSportello";
		public static final String GRUPPO_OPERATORE="gruppoOperatore";
		public static final String COD_OPERATORE="codOperatore";
		public static final String ID_SERVIZIO="idServizio";
		public static final String ID_DESTINATARIO="idDestinatario";
		public static final String ID_INCONTRO="idIncontro";
		public static final String ID_DESTINATARIO_SERVIZIO="idDestinatarioServizio";
	}

	public static class RISPOSTE_RESPONSE {
		public static final String INSERIMENTO_SUCCES="inserimento avvenuto con successo";
		public static final String MODIFICA_SUCCES="modifica avvenuta con successo";
		public static final String CANCELLATO_SUCCES="cancellazione avvenuta con successo";
		public static final String ASSOCIATO_SUCCES="associato con successo";
		public static final String DISASSOCIATO_SUCCES="disassociato con successo";
		public static final String ERRORE="errore";
		public static final String PRESA_CARICO="Presa in carico";
	}

	public static final String TIPO_MATERIA_SERSE = "06";

    public static final String TIPO_RICHIESTA_IMPEGNO_BUDGET_SERVIZIO = "01";
    public static final String TIPO_RICHIESTA_ELIMINA_INCONTRI = "02";
    public static final String TIPO_RICHIESTA_MODIFICA_BUGDET = "03";
    public static final String TIPO_RICHIESTA_PREVENTIVO_SERVIZIO = "04";
    public static final String TIPO_RICHIESTA_EROGAZIONE_ATTIVITA = "08";
    public static final String TIPO_RICHIESTA_ELIMINA_INCONTRO = "09";
    public static final String TIPO_RICHIESTA_CHIUSURA_SERVIZIO = "10";

    public static final String ESITO_OK = "SOAE00014";

    public static final long STATO_SERVIZIO_IN_DEF = 10L;
    public static final long STATO_SERVIZIO_FINANZIATO = 22L;
    public static final long STATO_SERVIZIO_AVVIATO = 10L;
    public static final long STATO_SERVIZIO_CHIUSO = 40L;

    public static final long STATO_INCONTRO_IN_DEF = 10L;
    public static final long STATO_INCONTRO_CHIUSO = 40L;
}
