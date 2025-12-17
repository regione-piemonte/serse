package it.csi.serse.serseweb.api.manager;

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

/**
 * Immutable sort bean for sorting data.
 * 
 * Le linee guida CSI dicono che l'ordinamento deve essere nel formato
 * +field1,-field2,... noi prevediamo un'unica colonna di ordinamento
 */
public class SortBean {

    private String property;
    private boolean asc = true;

    /**
     * Costruttore.
     *
     * @param sort il primo carattere può essere '+' o '-' per indicare la direzione
     *             (opzionale), poi il nome della proprietà
     */
    public SortBean(String sort) {
        if (sort != null && !sort.isEmpty()) {
            if (sort.startsWith("+")) {
                this.property = sort.substring(1);
            } else if (sort.startsWith("-")) {
                this.property = sort.substring(1);
                this.asc = false;
            } else {
                this.property = sort;
            }
        }
    }

    public String getProperty() {
        return property;
    }

    public boolean isAsc() {
        return asc;
    }

    @Override
    public String toString() {
        return "SortBean [property=" + property + ", asc=" + asc + "]";
    }
}
