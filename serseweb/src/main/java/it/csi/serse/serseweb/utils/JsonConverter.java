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

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JAX-RS ParamConverter that converts a generic object using an ObjectMapper.
 */
public class JsonConverter<T> implements ParamConverter<T> {

    Class<T> clazz;
    ObjectMapper mapper = new ObjectMapper();

    public JsonConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T fromString(String json) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            // Se lancio qualsiasi eccezione che non sia una WebApplicationException, RESTEasy me la
            // trasforma in una NotFoundException 404
            throw new WebApplicationException("Error deserializing JSON", e, 400);
        }
    }

    @Override
    public String toString(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new WebApplicationException("Error serializing JSON", e, 400);
        }
    }
    
}

