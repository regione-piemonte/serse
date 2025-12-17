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

export class IconsSettings{
  static ICON_URL = "../serseweb/assets/icons/";

  private static ICONF_MENU_HOME = "home.svg";

  private static ICONF_MENU_MDI = "modelli_menu.svg";
  private static ICONF_MENU_INT = "interventi_menu.svg";
  private static ICONF_MENU_SER = "servizi_menu.svg";
  private static ICONF_MENU_STR = "strumenti_menu.svg";

  private static ICONF_MENU_DOWNR = "downRow.svg";
  private static ICONF_SEARCH_LENTE = "lente.svg";

  private static ICONF_NAV_MDI = "modelli_nav.svg";
  private static ICONF_NAV_INT = "interventi_nav.svg";
  private static ICONF_NAV_SER = "servizi_nav.svg";
  private static ICONF_NAV_STR = "strumenti_nav.svg";


  static HOME_ICON = "home";
  static MODELLI_ICON_N = "modelli-icon-n";
  static INTERVENTI_ICON_N = "interventi-icon-n";
  static SERVIZI_ICON_N = "servizi-icon-n";
  static STRUMENTI_ICON_N = "strumenti-icon-n";
  static MODELLI_ICON = "modelli-icon";
  static INTERVENTI_ICON = "interventi-icon";
  static SERVIZI_ICON = "servizi-icon";
  static STRUMENTI_ICON = "strumenti-icon";
  static DOWNR_ICON = "down-row-icon";
  static LENTE_ICON = "lente-icon";


  static DUP_ICON = "file_copy";
  static PEN_ICON = "edit";
  static EYE_ICON = "visibility";
  static TRS_ICON = "delete_forever";
  static SWP_ICON = "swap_horizontal_circle";
  static DATI_CORR_ICON="description";
  static LINK_ICON= "link";
  static SAVE_ICON= "save";
  static SERV_CORR_ICON="reorder"
  static CESSAZIONE_ENTE_ICON="remove_circle"
  static UPLOAD_ICON="cloud_upload"
  static get iconHOME(){
    return this.ICON_URL+this.ICONF_MENU_HOME;
  }

  static get menuIconMDI(){
    return this.ICON_URL+this.ICONF_MENU_MDI;
  }
  static get menuIconINT(){
    return this.ICON_URL+this.ICONF_MENU_INT;
  }
  static get menuIconSER(){
    return this.ICON_URL+this.ICONF_MENU_SER;
  }
  static get menuIconSTR(){
    return this.ICON_URL+this.ICONF_MENU_STR;
  }

  static get menuIconDOWNR(){
    return this.ICON_URL+this.ICONF_MENU_DOWNR;
  }


  static get navIconMDI(){
    return this.ICON_URL+this.ICONF_NAV_MDI;
  }
  static get navIconINT(){
    return this.ICON_URL+this.ICONF_NAV_INT;
  }
  static get navIconSER(){
    return this.ICON_URL+this.ICONF_NAV_SER;
  }
  static get navIconSTR(){
    return this.ICON_URL+this.ICONF_NAV_STR;
  }


  static get searchIcon(){
    return this.ICON_URL+this.ICONF_SEARCH_LENTE;
  }

}
