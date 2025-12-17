package it.csi.serse.serseweb.helper;

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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.utils.Constants;

@Component
public class XlsUtils {

	protected static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".business");

	public void exportExcel(String templatePath, OutputStream outputStream, Map<String, Object> model) throws IOException {
        Context context = map2context(model);
        try(InputStream templateStream = XlsUtils.class.getResourceAsStream(templatePath)) {
            LOG.info("Rendering begin");
            
            JxlsHelper jxlsHelper = JxlsHelper.getInstance();
            jxlsHelper.processTemplate(templateStream, outputStream, context);
            LOG.info("Rendering done.");
        }
    }

    public Context map2context(Map<String, Object> model) {
        Context context = new Context();
        if (model != null) {
            for (Entry<String, Object> entry : model.entrySet()) {
                context.putVar(entry.getKey(), entry.getValue());
            }
        }
        return context;
    }
}

