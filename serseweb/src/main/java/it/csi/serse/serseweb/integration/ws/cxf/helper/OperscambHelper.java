package it.csi.serse.serseweb.integration.ws.cxf.helper;

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

import java.lang.Exception;
import java.net.URL;

import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.*;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.exception.InternalErrorException;
import it.csi.serse.serseweb.utils.Constants;

@Component
public class OperscambHelper {
	
	static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".integration");

	
	@Autowired
    @Qualifier("operscambserv")
	private Operscambserv operscambserv;


	public boolean testResources() throws Exception {

		return operscambserv.testResources("");
	}
	
	public GestInterscMaterieModificaServizioSerseOutput gestInterscMaterieGetEsitoServizioSerse(GestInterscMaterieModificaServizioSerseInput input) throws Exception {

		try {
			//String json=it.csi.serse.serseweb.utils.JsonUtils.convertObjectToJson(input);
			return operscambserv.gestInterscMaterieModificaServizioSerse(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public GestInterscMaterieCalcPreventivoSerseOutput gestInterscMaterieCalcPreventivoSerse(GestInterscMaterieCalcPreventivoSerseInput input)throws Exception {
		try{
			return operscambserv.gestInterscMaterieCalcPreventivoSerse(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public GestInterscMaterieNuovoServizioSerseOutput gestInterscMaterieNuovoServizioSerse(GestInterscMaterieNuovoServizioSerseInput input) throws Exception {
		try{
			return operscambserv.gestInterscMaterieNuovoServizioSerse(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public GestInterscMaterieGetBDGTDisponibileSFOutput  gestInterscMaterieGetBDGTDisponibileSF(GestInterscMaterieGetBDGTDisponibileSFInput input) {
		try{
			return operscambserv.gestInterscMaterieGetBDGTDisponibileSF(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public GestInterscMaterieNuovoIncontroSrvSerseOutput gestInterscMaterieNuovoIncontroSrvSerse(GestInterscMaterieNuovoIncontroSrvSerseInput input){
		try{
			return operscambserv.gestInterscMaterieNuovoIncontroSrvSerse(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public GestInterscMaterieConcludiServizioSerseOutput gestInterscMaterieConcludiServizioSerse(GestInterscMaterieConcludiServizioSerseInput input){
		try{
			return operscambserv.gestInterscMaterieConcludiServizioSerse(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public GestInterscMaterieEliminaServizioIncontriOutput gestInterscMaterieEliminaServizioIncontri(GestInterscMaterieEliminaServizioIncontriInput input){
		try{
			return operscambserv.gestInterscMaterieEliminaServizioIncontri(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

	public GestInterscMaterieRiapriIncontroDiServizioOutput gestInterscMaterieRiapriIncontroDiServizio(GestInterscMaterieRiapriIncontroDiServizioInput input){
		try{
			return operscambserv.gestInterscMaterieRiapriIncontroDiServizio(input);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

}
