/**
 * @license
 *
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

import { IconsSettings } from "./icons-settings";

//##########--HOME--#############
export const HOME_ITEM = {
  icon: IconsSettings.HOME_ICON,
  label: "Home",
  path: "/home/3",
  isSubSection: false
};

//##########--MODELLI--#############
export const MODELLO_ITEM = {
  icon: IconsSettings.MODELLI_ICON_N,
  label: "Modelli di intervento",
  path: "/dashboard/modello/gestione",
  isSubSection: false
};
  export const MODELLO_GEST_ITEM = {
    label: "Gestione modelli",
    path: "/dashboard/modello/gestione",
    isSubSection: true
  };
  export const MODELLO_NEW_ITEM = {
    label: "Nuovo modello",
    path: "/dashboard/modello/nuovo",
    isSubSection: true
  };

//##########--INTERVENTI--#############
export const INTERVENTO_ITEM = {
  icon: IconsSettings.INTERVENTI_ICON_N,
  label: "Interventi",
  path: "/dashboard/intervento/gestione",
  isSubSection: false
};
  export const INTERVENTO_GEST_ITEM = {
    label: "Gestione interventi",
    path: "/dashboard/intervento/gestione",
    isSubSection: true
  };
  export const INTERVENTO_NEW_ITEM = {
    label: "Nuovo intervento",
    path: "/dashboard/intervento/nuovo",
    isSubSection: true
  };

//##########--SERVIZI--#############
export const SERVIZI_ITEM = {
  icon: IconsSettings.SERVIZI_ICON_N,
  label: "Servizi",
  path: "/dashboard/servizio/gestione",
  isSubSection: false
};
  export const SERVIZI_GEST_ITEM = {
    label: "Gestione servizi",
    path: "/dashboard/servizio/gestione",
    isSubSection: true
  };
  export const SERVIZI_NEW_ITEM = {
    label: "Nuovo servizio",
    path: "/dashboard/servizio/nuovo",
    isSubSection: true
  };

//##########--SERVIZI--#############
export const STRUMENTI_ITEM = {
  icon: IconsSettings.STRUMENTI_ICON_N,
  label: "Funzioni trasversali",
  path: "/dashboard/strumenti/gestione",
  isSubSection: false
};

export const VERIFICA_BUDGET = {
  label: "Verifica budget",
  path: "/dashboard/strumenti/verifica/budget",
  isSubSection: true
};
export const VERIFICA_SERVIZI_DESTINATARIO = {
  label: "Verifica servizi per destinatario",
  path: "/dashboard/strumenti/verifica/servizi_destinatario",
  isSubSection: true
};
