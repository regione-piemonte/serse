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

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;
import it.csi.serse.serseweb.vo.FilterInterventi;
import it.csi.serse.serseweb.vo.FilterModelli;
import it.csi.serse.serseweb.vo.FilterServizi;

/**
 * Questa classe serve per accettare parametri di tipo complesso (es. FilterServizi) negli endpoint
 */
@Provider
public class JsonConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        
        if (rawType.equals(FilterServizi.class) || rawType.equals(FilterInterventi.class) || rawType.equals(FilterModelli.class))
            return new JsonConverter<>(rawType);
        
        return null;
    }
    
}
