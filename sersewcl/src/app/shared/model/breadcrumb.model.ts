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

export interface Breadcrumb {
  label: string,
  url: string,
  active: boolean,
  class: string
}


// export class PianBreadcrumb{
//   private static readonly serseUrl = '/dashboard'

//   private static readonly modelloUrl = `${PianBreadcrumb.serseUrl}/modello`
//   private static readonly ricercaModelloUrl = PianBreadcrumb.modelloUrl+'/gestione'
//   private static readonly nuovoModelloUrl = PianBreadcrumb.modelloUrl+'/nuovo'
//   private static readonly modificaModelloUrl = PianBreadcrumb.modelloUrl+'/form'
//   private static readonly entiModelloUrl = PianBreadcrumb.modelloUrl+'/enti'

//   private static readonly interventoUrl = `${PianBreadcrumb.serseUrl}/intervento`
//   private static readonly ricercaInterventoUrl = PianBreadcrumb.interventoUrl+'/gestione'
//   private static readonly nuovoInterventoUrl = PianBreadcrumb.interventoUrl+'/nuovo'
//   private static readonly modificaInterventoUrl = PianBreadcrumb.interventoUrl+'/form'
//   private static readonly entiInterventoUrl = PianBreadcrumb.interventoUrl+'/enti'
//   private static readonly destinatariInterventoUrl = PianBreadcrumb.interventoUrl+'/destinatari'

//   private static readonly servizioUrl = `${PianBreadcrumb.serseUrl}/servizio`
//   private static readonly ricercaServizioUrl = PianBreadcrumb.servizioUrl+'/gestione'
//   private static readonly modificaServizioUrl = PianBreadcrumb.servizioUrl+'/form'
//   private static readonly entiServizioUrl = PianBreadcrumb.servizioUrl+'/enti'
//   private static readonly destinatariServizioUrl = PianBreadcrumb.servizioUrl+'/destinatari'

//   private static readonly CLASS_A = 'breadcrumb-item active';
//   private static readonly CLASS_NA = 'breadcrumb-item';

//   //##################################################à
//   //-Modello
//   static readonly GESTIONE_MODELLO_A: Breadcrumb = {
//     label:'Ricerca modello',
//     url:PianBreadcrumb.ricercaModelloUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly GESTIONE_MODELLO_NA: Breadcrumb = {
//     label:'Ricerca modello',
//     url:PianBreadcrumb.ricercaModelloUrl,
//     active: false,
//     class: this.CLASS_NA
//   }

//   static readonly MODELLO_NUOVO_A: Breadcrumb = {
//     label:'Modello',
//     url:PianBreadcrumb.nuovoModelloUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly MODELLO_NUOVO_NA: Breadcrumb = {
//     label:'Modello',
//     url:PianBreadcrumb.nuovoModelloUrl,
//     active: false,
//     class: this.CLASS_NA
//   }

//   static readonly MODELLO_FORM_A: Breadcrumb = {
//     label:'Modello form',
//     url:PianBreadcrumb.modificaModelloUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly MODELLO_FORM_NA: Breadcrumb = {
//     label:'Modello form',
//     url:PianBreadcrumb.modificaModelloUrl,
//     active: false,
//     class: this.CLASS_NA
//   }
//   static readonly MODELLO_RC_BC: Breadcrumb[] = [this.GESTIONE_MODELLO_NA, this.MODELLO_FORM_A]


//   static readonly MODELLO_ENTI_A: Breadcrumb = {
//     label:'Enti modello',
//     url:PianBreadcrumb.entiModelloUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly MODELLO_ENTI_RM: Breadcrumb[] = [this.GESTIONE_MODELLO_NA, this.MODELLO_FORM_NA, this.MODELLO_ENTI_A]
//   static readonly MODELLO_ENTI_NM: Breadcrumb[] = [this.MODELLO_NUOVO_NA, this.MODELLO_ENTI_A]


//   //##################################################à
//   //-Intervento
//   static readonly GESTIONE_INTERVENTO_A: Breadcrumb = {
//     label:'Ricerca intervento',
//     url:PianBreadcrumb.ricercaInterventoUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly GESTIONE_INTERVENTO_NA: Breadcrumb = {
//     label:'Ricerca intervento',
//     url:PianBreadcrumb.ricercaInterventoUrl,
//     active: false,
//     class: this.CLASS_NA
//   }


//   static readonly INTERVENTO_NUOVO_A: Breadcrumb = {
//     label:'Intervento',
//     url:PianBreadcrumb.nuovoInterventoUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly INTERVENTO_NUOVO_NA: Breadcrumb = {
//     label:'Intervento',
//     url:PianBreadcrumb.nuovoInterventoUrl,
//     active: false,
//     class: this.CLASS_NA
//   }


//   static readonly INTERVENTO_FORM_A: Breadcrumb = {
//     label:'Intervento form',
//     url:PianBreadcrumb.modificaInterventoUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly INTERVENTO_FORM_NA: Breadcrumb = {
//     label:'Intervento form',
//     url:PianBreadcrumb.modificaInterventoUrl,
//     active: false,
//     class: this.CLASS_NA
//   }
//   static readonly INTERVENTO_RC_BC: Breadcrumb[] = [this.GESTIONE_INTERVENTO_NA, this.INTERVENTO_FORM_A]


//   static readonly INTERVENTO_ENTI_A: Breadcrumb = {
//     label:'Enti intervento',
//     url:PianBreadcrumb.entiInterventoUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly INTERVENTO_ENTI_RI: Breadcrumb[] = [this.GESTIONE_INTERVENTO_NA, this.INTERVENTO_FORM_NA, this.INTERVENTO_ENTI_A]
//   static readonly INTERVENTO_ENTI_NI: Breadcrumb[] = [this.INTERVENTO_NUOVO_NA, this.INTERVENTO_ENTI_A]


//   static readonly INTERVENTO_DESTINATARI_A: Breadcrumb = {
//     label:'Destinatari intervento',
//     url:PianBreadcrumb.destinatariInterventoUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly INTERVENTO_DESTINATARI_RI: Breadcrumb[] = [this.GESTIONE_INTERVENTO_NA, this.INTERVENTO_FORM_NA, this.INTERVENTO_DESTINATARI_A]
//   static readonly INTERVENTO_DESTINATARI_NI: Breadcrumb[] = [this.INTERVENTO_NUOVO_NA, this.INTERVENTO_DESTINATARI_A]


//   //##################################################à
//   //-Servizio
//   static readonly GESTIONE_SERVIZIO_A: Breadcrumb = {
//     label:'Ricerca servizio',
//     url:PianBreadcrumb.ricercaServizioUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly GESTIONE_SERVIZIO_NA: Breadcrumb = {
//     label:'Ricerca servizio',
//     url:PianBreadcrumb.ricercaServizioUrl,
//     active: false,
//     class: this.CLASS_NA
//   }

//   static readonly SERVIZIO_FORM_A: Breadcrumb = {
//     label:'Servizio form',
//     url:PianBreadcrumb.modificaServizioUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly SERVIZIO_FORM_NA: Breadcrumb = {
//     label:'Servizio form',
//     url:PianBreadcrumb.modificaServizioUrl,
//     active: false,
//     class: this.CLASS_NA
//   }
//   static readonly SERVIZIO_RC_BC: Breadcrumb[] = [this.GESTIONE_SERVIZIO_NA, this.SERVIZIO_FORM_A]

//   static readonly SERVIZIO_ENTI_A: Breadcrumb = {
//     label:'Enti servizio',
//     url:PianBreadcrumb.entiServizioUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly SERVIZIO_ENTI_BC: Breadcrumb[] = [this.GESTIONE_SERVIZIO_NA, this.SERVIZIO_FORM_NA, this.SERVIZIO_ENTI_A]

//   static readonly SERVIZIO_DESTINATARI_A: Breadcrumb = {
//     label:'Destinatari servizio',
//     url:PianBreadcrumb.destinatariServizioUrl,
//     active: true,
//     class: this.CLASS_A
//   }
//   static readonly SERVIZIO_DESTINATARI_BC: Breadcrumb[] = [this.GESTIONE_SERVIZIO_NA, this.SERVIZIO_FORM_NA, this.SERVIZIO_DESTINATARI_A]






















//   // //-COMMESSA
//   // static readonly COMMESSE_A: Breadcrumb = {
//   //   label:'Commesse',
//   //   url:PianBreadcrumb.commUrl,
//   //   active: true,
//   //   class: this.CLASS_A
//   // }
//   // static readonly COMMESSE_NA: Breadcrumb = {
//   //   label:'Commesse',
//   //   url:PianBreadcrumb.commUrl,
//   //   active: false,
//   //   class: this.CLASS_NA
//   // }
//   // static readonly COMMESSE_BC: Breadcrumb[] = [this.CLIENTI_NA, this.COMMESSE_A]


//   // //-ATTIVITA'
//   // static readonly ATTIVITA_A: Breadcrumb = {
//   //   label:'Attivita',
//   //   url:PianBreadcrumb.attiUrl,
//   //   active: true,
//   //   class: this.CLASS_A
//   // }
//   // static readonly ATTIVITA_NA: Breadcrumb = {
//   //   label:'Attivita',
//   //   url:PianBreadcrumb.attiUrl,
//   //   active: false,
//   //   class: this.CLASS_NA
//   // }
//   // static readonly ATTIVITA_BC: Breadcrumb[] = [this.CLIENTI_NA, this.COMMESSE_NA, this.ATTIVITA_A]


// }


