package it.csi.serse.serseapi.integration.mybatis.generator;

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


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;


import it.csi.serse.serseapi.utils.Constants;


public class MybatisGenerator {
	
	static final String PROJECT_NAME="serseapi";
	
	//private static Logger LOG = LogManager;ory.getLogger(Constants.COD_COMPONENTE + ".tracer");

	private static void generate() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		// SET BASIC CONFIGURATION
		//BasicConfigurator.configure();
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(MybatisGenerator.class.getResourceAsStream("generatorConfig.xml")));
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(reader);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		String classpath = System.getProperty("java.class.path");
		String[] classpathEntries = classpath.split(File.pathSeparator);
		
		//Il target project impostato nel file generatorConfig.xml funziona solo quando si usa il plugin  di eclipse
		//Quando lo si richiama da java necessita di un url assoluta, quindi mi ricavo l'url fisica del progetto e la
		//concateno a quelal relativa impostata su generatorConfig.xml cosÃ¬ funziona sia il lancio da java che quello
		//tramite plugin di eclipse
		
		String targetProjectUrl=classpathEntries[0].substring(0, classpathEntries[0].indexOf(PROJECT_NAME));
		
		//Importo target project per i dto
		config.getContexts().get(0).getJavaModelGeneratorConfiguration().setTargetProject(targetProjectUrl+config.getContexts().get(0).getJavaModelGeneratorConfiguration().getTargetProject());
		//Importo target project per i DAO
		config.getContexts().get(0).getJavaClientGeneratorConfiguration().setTargetProject(targetProjectUrl+config.getContexts().get(0).getJavaClientGeneratorConfiguration().getTargetProject());
		//Importo target project per gli xml
		config.getContexts().get(0).getSqlMapGeneratorConfiguration().setTargetProject(targetProjectUrl+config.getContexts().get(0).getSqlMapGeneratorConfiguration().getTargetProject());
		
		try {
			myBatisGenerator.generate(null);
			
			if (warnings!=null) {
				System.out.println("warnings:");
				for (String warning: warnings) {
					System.out.println(warning);
				}
			}
			
			
		}
		catch(Throwable t) {
			//LOG.error("MybatisGenerator error init:"+t);;
		}
	}

	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		generate();
	}
}

