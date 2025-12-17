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

import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.FlaianagpgAnagrafesedipg;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.BudgetbilservCommon;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.FlaianagpgAnagrafepg;
import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.OrchflaiFlaidoorsrv;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.Operscambserv;

@Configuration
public class JsxwsProxyFactory {	 
	 	@Value("${securityHelper.url}")
		private String securityHelperUrl;
	 	@Value("${commonHelper.url}")
		private String commonHelperUrl;
	 	@Value("${flaianagpgHelper.url}")
		private String flaianagpgHelperUrl;
	 	@Value("${operscambHelper.url}")
		private String operscambHelperUrl;
	 	@Value("${flaianagpgsediHelper.url}")
		private String flaianagpgsediHelperUrl;
	 	
	    /**
	     * Factory del servizio per orchflaiFlaidoorsrv tramite client CXF.
	     * 
	     * @return
	     */
	    @Bean(name = "orchflaiFlaidoorsrv")
	    public OrchflaiFlaidoorsrv orchflaiFlaidoorsrv() {

	    	// Factory con Metodo poprietario di CXF. Questa Factory consente di settare interceptor.
	    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    	factory.setAddress(securityHelperUrl);
	    	factory.setServiceClass(OrchflaiFlaidoorsrv.class);
	    	factory.getInInterceptors().add(new LoggingInInterceptor());
	    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
	    	return (OrchflaiFlaidoorsrv) factory.create();
	    	
	    }
	    
	    /**
	     * Factory del servizio per budgetbilservCommon tramite client CXF.
	     * 
	     * @return
	     */
	    @Bean(name = "budgetbilservCommon")
	    public BudgetbilservCommon budgetbilservCommon() {

	    	// Factory con Metodo poprietario di CXF. Questa Factory consente di settare interceptor.
	    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    	factory.setAddress(commonHelperUrl);
	    	factory.setServiceClass(BudgetbilservCommon.class);
	    	factory.getInInterceptors().add(new LoggingInInterceptor());
	    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
	    	return (BudgetbilservCommon) factory.create();
	    	
	    }
	    
	    /**
	     * Factory del servizio per operscambserv tramite client CXF.
	     * 
	     * @return
	     */
	    @Bean(name = "operscambserv")
	    public Operscambserv operscambserv() {

	    	// Factory con Metodo poprietario di CXF. Questa Factory consente di settare interceptor.
	    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    	factory.setAddress(operscambHelperUrl);
	    	factory.setServiceClass(Operscambserv.class);
	    	factory.getInInterceptors().add(new LoggingInInterceptor());
	    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
	    	return (Operscambserv) factory.create();
	    }
	    
	    /**
	     * Factory del servizio per flaianagpgAnagrafepg tramite client CXF.
	     * 
	     * @return
	     */
	    @Bean(name = "flaianagpgAnagrafepg")
	    public FlaianagpgAnagrafepg flaianagpgAnagrafepg() {

	    	// Factory con Metodo poprietario di CXF. Questa Factory consente di settare interceptor.
	    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    	factory.setAddress(flaianagpgHelperUrl);
	    	factory.setServiceClass(FlaianagpgAnagrafepg.class);
	    	factory.getInInterceptors().add(new LoggingInInterceptor());
	    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
	    	return (FlaianagpgAnagrafepg) factory.create();
	    }
	    
	    /**
	     * Factory del servizio per flaianagpgAnagrafesedipg tramite client CXF.
	     * 
	     * @return
	     */
	    @Bean(name = "flaianagpgAnagrafesedipg")
	    public FlaianagpgAnagrafesedipg flaianagpgAnagrafesedipg() {

	    	// Factory con Metodo poprietario di CXF. Questa Factory consente di settare interceptor.
	    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    	factory.setAddress(flaianagpgsediHelperUrl);
	    	factory.setServiceClass(FlaianagpgAnagrafesedipg.class);
	    	factory.getInInterceptors().add(new LoggingInInterceptor());
	    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
	    	return (FlaianagpgAnagrafesedipg) factory.create();
	    }
}
