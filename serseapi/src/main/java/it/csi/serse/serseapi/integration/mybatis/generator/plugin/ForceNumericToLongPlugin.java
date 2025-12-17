package it.csi.serse.serseapi.integration.mybatis.generator.plugin;

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

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

public class ForceNumericToLongPlugin extends PluginAdapter {

	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public void initialized(IntrospectedTable introspectedTable) {

		List<String> toReplace = new ArrayList<String>();
		toReplace.add("java.lang.Short");
		toReplace.add("java.lang.Integer");
		String forceTo = "java.lang.Long";
		
		for (IntrospectedColumn o : introspectedTable.getAllColumns()) {
			if (toReplace.contains(o.getFullyQualifiedJavaType().getFullyQualifiedName())) {
				FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(forceTo);
				o.setFullyQualifiedJavaType(fullyQualifiedJavaType);
			}
		}

	}
}
