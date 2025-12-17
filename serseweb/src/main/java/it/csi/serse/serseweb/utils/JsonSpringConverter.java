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

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.csi.serse.serseweb.vo.FilterServizi;
import jakarta.ws.rs.WebApplicationException;

/**
 * Equivalente Spring di : JAX-RS ParamConverter that converts a generic object using an ObjectMapper.
 */
@Component
public class JsonSpringConverter implements Converter<String, FilterServizi> {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public FilterServizi convert(String json) {
        try {
            return mapper.readValue(json, FilterServizi.class);
        } catch (JsonProcessingException e) {
            // Se lancio qualsiasi eccezione che non sia una WebApplicationException, RESTEasy me la
            // trasforma in una NotFoundException 404
            throw new WebApplicationException("Error deserializing JSON", e, 400);
        }
    }
    
}

