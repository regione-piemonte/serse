package it.csi.serse.serseapi.integration.mybatis.dao.custom;

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

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
@Component
@Mapper
public interface ParentDAO {
	
	@Select("select now()")
	Date getNow();
	
	@Select("select nextval('seq_serse_t_modello_di_intervento')")
	Long getNextValIdModelloIntervento();
	
	@Select("select nextval('seq_serse_t_servizio_modello')")
	Long getNextValIdServizioModello();
	
	@Select("select nextval('seq_serse_t_ente_coinvolto_modello')")
	Long getNextValIdEnteCoinvoltoModello();
	
	@Select("select nextval('seq_serse_t_ente_coinvolto_servizio')")
	Long getNextValIdEnteCoinvoltoServizio();
	
	@Select("select nextval('seq_serse_t_ente_coinvolto_intervento')")
	Long getNextValIdEnteCoinvoltoIntervento();
	
	@Select("select nextval('seq_serse_t_intervento')")
	Long getNextValIdIntervento();

	@Select("select nextval('seq_serse_t_destinatario')")
	Long getNextValIdDestinatario();
	
	@Select("select nextval('seq_serse_r_destinatario_servizio')")
	Long getNextValIdDestinatarioServizio();
	
	@Select("select nextval('seq_serse_t_servizio')")
	Long getNextValIdServizio();
	
	@Select("select nextval('seq_serse_t_token_gam')")
	Long getNextValIdTokenGam();

	@Select("select nextval('seq_serse_t_servizio_sto')")
	Long getNextValIdServizioSto();
}
