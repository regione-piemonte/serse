package it.csi.serse.serseapi.config;

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

import java.net.MalformedURLException;

import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.FlaianagpgAnagrafepg;

@Configuration
public class JsxwsProxyFactory {

	@Value("${flaianagpgHelper.url}")
	private String flaianagpgHelperUrl;

	/**
	 * Factory del servizio per flaianagpgAnagrafepg tramite client CXF.
	 * 
	 * @return
	 */
	@Bean(name = "flaianagpgAnagrafepg")
	public FlaianagpgAnagrafepg flaianagpgAnagrafepg() {

		// Factory con Metodo poprietario di CXF. Questa Factory consente di settare
		// interceptor.
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(flaianagpgHelperUrl);
		factory.setServiceClass(FlaianagpgAnagrafepg.class);
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		return (FlaianagpgAnagrafepg) factory.create();
	}
}
