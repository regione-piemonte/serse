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

import { ItemHelp } from "../models/item-help.model";



export const Modello_HELP :  ItemHelp[] = [
  { title:"Ricercare modelli",
    descrizione:"Per cercare un modello accedere all'applicativo selezionando un ruolo e uno sportello che permetta di farlo, "+
                "Dopo aver selezionato lo sportello verrà presentata la pagina “HomePage” con in alto le informazioni della pso e "+
                "dello sportello Cliccare sul menu a discesa \"Modello di intervento\" dopo di che selezionare \"Gestione modelli\","+
                " Si può accedere a questa sezione anche dalla barra di navigazione laterale.<br><br>"+
                "<img src='assets/images/Modello_Home_Ricerca.png' alt='Ricerca Modello' class='ok'  /><br><br>"+
                " Una volta arrivati nella pagina si possono compilare tutti i dati per effettuare una ricerca.<br><br>"+
                "<img src='assets/images/Modello_Ricerca.png' alt='Ricerca Modello' class='ok img-fluid' />"
  },

  { title:"Creare un modello",
    descrizione:"Per creare un modello accedere all'applicativo selezionando un ruolo e uno sportello che permetta di farlo."+
                  "Dopo aver selezionato lo sportello verrà presentata la pagina “HomePage” con in alto le informazioni della pso e dello sportello "+
                  "Cliccare sul menu a discesa 'Modello di intervento' dopo di che selezionare 'Nuovo modello', si può accedere a questa sezione anche "+
                  "dalla barra di navigazione laterale <br>"+
                  "<img src='assets/images/Modello_Home.png' alt='Ricerca Modello' class='ok' /><br><br>"+
                  "Una volta arrivati nella pagina si possono compilare tutti i dati obbligatori e procedere con il salvataggio.<br>"+
                  "<img src='assets/images/Modello_Identificativo.png' alt='Ricerca Modello' class='ok' />"

  },

  { title:"Dati correlati",
    descrizione:"Dopo aver salvato il nuovo modello sarà possibile andare a modificare i dati correlati agli enti associati,"+
                " i servizi da erogare, i target destinatari e le caratteristiche del modello premendo sulla tab “Dati Correlati”.<br>"+
                "<img src='assets/images/Modello_Correlati.png' alt='Ricerca Modello' class='ok' />"

  },

  { title:"Target destinatari/caratteristiche",
    descrizione:"Per aggiungere un ente è necessario premere il bottone “AGGIUNGI ENTE”, dopo aver premuto il bottone verrà visualizzata una pagina"+
                " di ricerca che cambierà in base a quali tipi di enti sono associati allo sportello e alla tipologia pso in uso. .<br>"+
                "<img src='assets/images/Modello_TC.png' alt='Ricerca Modello' class='ok' /><br>"

  },

  { title:"Enti",
    descrizione:"Per modificare le caratteristiche o i target destinatari è sufficiente premere il bottone “GESTISCI CARATTERISTICHE” <br>"+
                "  o il bottone “GESTISCI TARGET DESTINATARI” rispettivamente; premendo il bottone apparirà un menù da cui poter selezionare"+
                " le caratteristiche/target destinatari da associare al modello.<br>"+
                "<img src='assets/images/Enti_Ricerca.png' alt='Ricerca Modello' class='ok' /><br>"+
                "In tutto sono tre:<br>"+
                "Ricerca di istituti scolastici in questo caso è necessario valorizzare almeno un filtro. Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra sotto la tabella stess;"+
                "<img src='assets/images/Enti_Tabella.png' alt='Ricerca Modello' class='ok' /><br>"+
                "apparirà una finestra in cui inserire i dati del referente dell'ente e il ruolo.<br>"+
                "<img src='assets/images/Enti_Modale.png' alt='Ricerca Modello' class='ok' /><br>"+
                "Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire tutti i dati relativi all'ente."+
                "<img src='assets/images/Enti_Tabella2.png' alt='Ricerca Modello' class='ok' /><br>"+
                "Ricerca di centri per l'impiego in questo caso non ci sono filtri obbligatori.  Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra"+
                " sotto la tabella stessa, apparirà una finestra in cui inserire i dati del referente dell'ente e il ruolo.Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando "+
                "il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire i dati.<br>"+
                "<br>"+
                "Per ricercare un operatore regionale premere il bottone “CERCA OPERATORE” apparirà una finestra con dei filtri di ricerca è necessario valorizzarne almeno uno, selezionare l'operatore dai risultati e premere conferma;"+
                "<img src='assets/images/Enti_Operatori_Modale.png' alt='Ricerca Modello' class='ok' /><br>"+
                "la finestra si chiuderà tornando alla schermata precedente ma adesso sarà possibile effettuare una ricerca delle sedi dell'operatore selezionato."+
                " Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra sotto la tabella stessa,"+
                " apparirà una finestra in cui inserire i dati del referente dell'ente. Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando"+
                " il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire i dati. Sarà inoltre possibile effettuare la ricerca di"+
                " un operatore diverso da quello selezionato usando il bottone “Modifica Operatore” accanto alla denominazione dell'ente selezionato."

  },

  { title:"Tipologie di servizi associati al modello",
    descrizione:"Se si vogliono aggiungere dei servizi regionali al modello si dove premere il bottone “GESTISCI TIPOLOGIE DI SERVIZI REGIONALI” "+
                "apparirà una finestra in cui selezionare tra i servizi regionali disponibili. è anche possibile associare servizi non regionali premendo"+
                " il bottone “AGGIUNGI TIPOLOGIE DI SERVIZI ESTERNI”.<br>"
  },

  { title:"Pubblicazione",
    descrizione:"Per pubblicare un modello di intervento, il modello dove essere stato salvato e tutti i dati correlati compilati. Premere quindi il pulsante “PUBBLICA”."+
                " Di un modello di intervento pubblico non è possibile modificare l'istanza di candidatura né la tipologia(individuale/di gruppo)."+

                " Gli enti associati al modello pubblico non possono essere modificati né eliminati, sarà possibile cessarli  QUA ICONA    nel caso in cui non siano "+
                " più attivi nel modello (verranno cessati solo per il modello di intervento in uso), un ente cessato non verrà più ereditato dai nuovi interventi che verranno"+
                " associati al modello ma rimarrà per gli interventi già associati. La cessazione di un ente NON è reversibile "+
                "Se vengono aggiunti degli enti o delle tipologie di servizio dopo la pubblicazione del modello di intervento questi verranno ereditati solo"+
                " dai nuovi interventi che si associano al modello pubblicato mentre gli interventi già associati non verranno modificati."+
                "NON è possibile eliminare un modello di intervento pubblicato con degli interventi associati e NON è possibile farlo ritornare in bozza se ci sono interventi associati.<br>"
  },

  { title:"Chiusura",
    descrizione:"La chiusura di un modello è possibile solo se il modello è stato pubblicato premendo nella pagina dei dati identificativi il bottone “CHIUDI MODELLO” "+
                "in basso a sinistra, un modello di intervento chiuso non potrà più essere associato ad interventi nuovi e i dati non sono modificabili."+
                "La chiusura è un'operazione reversibile premendo sul pulsante “ANNULLA CHIUSURA MODELLO” il modello tornerà pubblico.<br>"
  },

  { title:"Eliminazione",
    descrizione:"Per Eliminare un modello occorre prima effettuare una ricerca del modello desiderato, dopo di che cliccare sul pulsante cestino rosso e confermare l'eliminazione."+
                "Attenzione: se il modello è stato associato ad almeno un intervento non sarà possibile eliminarlo.<br><br>"+
                "<img src='assets/images/Modello_Tabella.png' alt='Ricerca Modello' class='ok'  />"
  },

  { title:"Modifica",
    descrizione:"Per Modificare un modello occorre prima effettuare una ricerca del modello desiderato, dopo di che cliccare sul pulsante della matita e sarà possibile modificarlo."+
                "Attenzione: non è possibile modificare un modello chiuso.<br><br>"+
                "<img src='assets/images/Modello_Tabella.png' alt='Ricerca Modello' class='ok'  />"
  },

  { title:"Duplicazione",
    descrizione:"Per duplicare un modello occorre prima effettuare una ricerca del modello desiderato, dopo di che cliccare sul pulsante dei due fogli,"+
                " procedere con la conferma e si atterra nel nuovo modello duplicato.<br><br>"+
                "<img src='assets/images/Modello_Tabella.png' alt='Ricerca Modello' class='ok'  />"
  },

  { title:"Scaricare la ricerca in excel",
    descrizione:"Per scaricare un file exel della ricerca bisogna prima effettuare una ricerca, dopo di che premere sul pulsante sotto a destra della tabella “SCARICA XLS”.<br><br>"+
                "<img src='assets/images/Modello_Tabella.png' alt='Ricerca Modello' class='ok'  />"
  }
]


//=====================================================================================================================================================================================================
//=====================================================================================================================================================================================================
//=====================================================================================================================================================================================================

export const Intervento_HELP :  ItemHelp[] = [
  { title:"Ricercare intervento",
    descrizione:"Per ricercare un intervento accedere all'applicativo selezionando un ruolo e uno sportello che permetta di farlo, "+
                "Dopo aver selezionato lo sportello verrà presentata la pagina “HomePage” con in alto le informazioni della pso e "+
                "dello sportello Cliccare sul menu a discesa \"Interventi\" dopo di che selezionare \"Gestione interventi\","+
                " Si può accedere a questa sezione anche dalla barra di navigazione laterale.<br><br>"+
                "<img src='assets/images/Intervento_Home_Ricerca.png' alt='Intervento' class='ok' /><br><br>"+
                " Una volta arrivati nella pagina si possono compilare tutti i dati per effettuare una ricerca.<br><br>"+
                "<img src='assets/images/Intervento_Ricerca.png' alt='Intervento' class='ok'  />"
  },

  { title:"Creazione",
    descrizione:"Per creare un intervento accedere all'applicativo selezionando un ruolo e uno sportello che permetta di farlo, "+
                "Dopo aver selezionato lo sportello verrà presentata la pagina “HomePage” con in alto le informazioni della pso e "+
                "dello sportello Cliccare sul menu a discesa \"Intervento\" dopo di che selezionare \"Nuovo Intervento\",<br><br>"+
                "<img src='assets/images/Intervento_Home.png' alt='Ricerca Modello' class='ok' /><br><br>"+
                "Si può accedere a questa sezione anche dalla barra di navigazione laterale. "+
                "Una volta premuto il pulsante si verrà indirizzati alla pagina di creazione dell'intervento.<br>"+
                "<img src='assets/images/Intervento_Identificativo.png' alt='Ricerca Modello' class='ok' /><br>"+
                "Per la creazione senza associazione del modello è necessaria la sola compilazione dei dati obbligatori, sarà comunque possibile associare un modello in seguito."
  },

  { title:"Associare/Disassociare un modello di intervento",
    descrizione:"Per creare un intervento già associato ad un modello oltre ai dati obbligatori premere il bottone “ASSOCIA MODELLO DI INTERVENTO”"+
                "(il bottone è utilizzabile solo dopo aver selezionato la candidatura e la tipologia di intervento), apparirà una finestra che permette di"+
                " ricercare tra i modelli pubblicati con la stessa istanza e tipologia selezionate.<br>"+
                "<img src='assets/images/Intervento_Ass_Modello.png' alt='Ricerca Modello' class='ok' /><br>"+
                "dopo aver selezionato il modello da associare e confermato l'intervento in creazione erediterà i dati del referente, se l'intervento NON"+
                " è individuale eredita anche gli enti associati al modello con ruolo destinatario di interventi."+
                "E' possibile disassociare il modello premendo sull'icona a forma di cestino, questo non elimina il modello ma solo l'associazione con l'2intervento."+
                "E' possibile associare/disassociare modelli di intervento solo se l'intervento è in bozza."

  },

  { title:"Dati correlati",
    descrizione:"<strong>NON si possono aggiungere enti ad un intervento se:</strong>:<br>"+
                "l'intervento non è in bozza<br>"+
                "l'intervento è individuale ed è già presente un ente<br>"+
                "se l'intervento è associato ad un modello con enti con ruolo destinatario di intervento<br>"

  },

  { title:"Enti",
    descrizione:"Per modificare le caratteristiche o i target destinatari è sufficiente premere il bottone “GESTISCI CARATTERISTICHE” <br>"+
                "  o il bottone “GESTISCI TARGET DESTINATARI” rispettivamente; premendo il bottone apparirà un menù da cui poter selezionare"+
                " le caratteristiche/target destinatari da associare al modello.<br>"+
                "<img src='assets/images/Enti_Ricerca.png' alt='Ricerca Modello' class='ok' /><br>"+
                "In tutto sono tre:<br>"+
                "Ricerca di istituti scolastici in questo caso è necessario valorizzare almeno un filtro. Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra sotto la tabella stess;"+
                "<img src='assets/images/Enti_Tabella.png' alt='Ricerca Modello' class='ok' /><br>"+
                "apparirà una finestra in cui inserire i dati del referente dell'ente e il ruolo.<br>"+
                "<img src='assets/images/Enti_Modale.png' alt='Ricerca Modello' class='ok' /><br>"+
                "Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire tutti i dati relativi all'ente."+
                "<img src='assets/images/Enti_Tabella2.png' alt='Ricerca Modello' class='ok' /><br>"+
                "Ricerca di centri per l'impiego in questo caso non ci sono filtri obbligatori.  Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra"+
                " sotto la tabella stessa, apparirà una finestra in cui inserire i dati del referente dell'ente e il ruolo.Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando "+
                "il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire i dati.<br>"+
                "<br>"+
                "Per ricercare un operatore regionale premere il bottone “CERCA OPERATORE” apparirà una finestra con dei filtri di ricerca è necessario valorizzarne almeno uno, selezionare l'operatore dai risultati e premere conferma;"+
                "<img src='assets/images/Enti_Operatori_Modale.png' alt='Ricerca Modello' class='ok' /><br>"+
                "la finestra si chiuderà tornando alla schermata precedente ma adesso sarà possibile effettuare una ricerca delle sedi dell'operatore selezionato."+
                " Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra sotto la tabella stessa,"+
                " apparirà una finestra in cui inserire i dati del referente dell'ente. Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando"+
                " il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire i dati. Sarà inoltre possibile effettuare la ricerca di"+
                " un operatore diverso da quello selezionato usando il bottone “Modifica Operatore” accanto alla denominazione dell'ente selezionato."

  },

  { title:"Destinari di Intervento",
    descrizione:"se l'intervento è di tipo individuale si potrà aggiungere un destinatario premendo sul bottone “AGGIUNGI DESTINATARIO” si verrà indirizzati alla pagina di ricerca dei destinatari.<br>"+
                "<img src='assets/images/Destinatari_Ricerca.png' alt='Ricerca Modello' class='ok' /><br>"+
                "è obbligatorio almeno un filtro dopodichè dalla pagina dei risultati è possibile selezionare il destinatario da associare e aggiungerlo usando il pulsante in basso a destra"+
                " “AGGIUNGI DESTINATARIO SELEZIONATO” , se il destinatario  non è presente si può aggiungerlo usando il pulsante in basso a sinistra “AGGIUNGI NUOVO DESTINATARIO” si apre una finestra"+
                "<img src='assets/images/Destinatari_Modale.png' alt='Ricerca Modello' class='ok' /><br>"+
                "se si annulla l'operazione i dati già inseriti saranno persi."+
                "Una volta aggiunto il destinatario si verrà reindirizzati di nuovo alla pagina dati corretlati di un intervento e sarà presente"+
                " il destinatario, non sarà possile eliminare l'associazione tra destinatario ed intervento ma solo cambiare il destinatario se si desidera tramite l'icona QUI ICONA"+
                "se l'intervento non è individuale non sarà possibile associare destinatari direttamente all'intervento ma si vedranno i destinatari dei servizi associati."
  },

  { title:"Associare Servizi",
    descrizione:"se l'intervento è attivo è possibile associare dei servizi all'intervento premendo sul bottone “AGGIUNGI SERVIZIO”"+
                " si viene indirizzati alla pagina di creazione di un servizio. sulla pagina dei servizi dell'intervento è presente anche l'elenco dei servizi associati all'intervento."
  },

  { title:"Attivazione",
    descrizione:"L'attivazione è possibile dagli interventi in bozza, se un intervento è di tipo individuale è obbligatorio inserire il destinatario prima dell'attivazione."+
                "L'attivazione è reversibile solo se non ci sono servizi collegati all'intervento."
  },

  { title:"Chiusura",
    descrizione:"La chiusura dell'intervento è possibile solo se l'intervento è attivo e tutti i servizi ad esso collegati sono chiusi."+
                " L'azione di chiusura è reversibile."+
                "Un'intervento chiuso non è modificabile."
  },


  { title:"Eliminazione",
    descrizione:"Per Eliminare un intervento occorre prima effettuare una ricerca dell'intervento desiderato, dopo di che cliccare sul pulsante cestino rosso e confermare l'eliminazione."+
                "Attenzione: se l'intervento è associato ad almeno un servizio o se l'intervento è nello stato di chiuso non sarà possibile eliminarlo.<br><br>"+
                "<img src='assets/images/Intervento_Tabella.png' alt='Intervento' class='ok'  />"
  },

  { title:"Modifica",
    descrizione:"Per Modificare un intervento occorre prima effettuare una ricerca del intervento desiderato, dopo di che cliccare sul pulsante della matita e sarà possibile modificarlo."+
                "Attenzione: non è possibile modificare un intervento chiuso.<br><br>"+
                "<img src='assets/images/Intervento_Tabella.png' alt='Intervento' class='ok'  />"
  },

  { title:"Duplicazione",
    descrizione:"Per duplicare un intervento occorre prima effettuare una ricerca del intervento desiderato, dopo di che cliccare sul pulsante dei due fogli,"+
                " procedere con la conferma e si atterra nel nuovo intervento duplicato.<br><br>"+
                "<img src='assets/images/Intervento_Tabella.png' alt='Intervento' class='ok'  />"
  },

  { title:"Scaricare la ricerca in excel",
    descrizione:"Per scaricare un file exel della ricerca bisogna prima effettuare una ricerca, dopo di che premere sul pulsante sotto a destra della tabella “SCARICA XLS”.<br><br>"+
                "<img src='assets/images/Intervento_Tabella.png' alt='Intervento' class='ok'  />"
  }
]



//=====================================================================================================================================================================================================
//=====================================================================================================================================================================================================
//=====================================================================================================================================================================================================

export const Servizio_HELP :  ItemHelp[] = [
  { title:"Ricercare servizio",
    descrizione:"Per ricercare un servizio accedere all'applicativo selezionando un ruolo e uno sportello che permetta di farlo, "+
                "Dopo aver selezionato lo sportello verrà presentata la pagina “HomePage” con in alto le informazioni della pso e "+
                "dello sportello premere sul menu a discesa \"Servizi\" dopo di che selezionare \"Gestione servizi\","+
                " Si può accedere a questa sezione anche dalla barra di navigazione laterale.<br><br>"+
                "<img src='assets/images/Servizio_Home_Ricerca.png' alt='Intervento' class='ok' /><br><br>"+
                " Una volta arrivati nella pagina si possono compilare tutti i dati per effettuare una ricerca.<br><br>"+
                "<img src='assets/images/Servizio_Ricerca.png' alt='Intervento' class='ok'  />"
  },

  { title:"Creazione",
    descrizione:"Per creare un servizio accedere all'applicativo selezionando un ruolo e uno sportello che permetta di farlo "+
                "(Attenzione lo sportello non deve essere chiuso), Dopo aver selezionato lo sportello verrà presentata la pagina “HomePage” "+
                "con in alto le informazioni della pso e dello sportello Cliccare sul menu a discesa \"Servizio\" dopo di che selezionare \"Nuovo servizio\""+
                ", Si può accedere a questa sezione anche dalla barra di navigazione laterale. Questo permette di creare un servizio separato dall'intervento,"+

                " nel caso si volesse creare un servizio associato ad un intervento, bisogna partire dall'intervento desiderato, che deve essere attivo, per poi"+
                " andare nella tab Servizio e procede con il click su “CREA SERVIZIO”<br><br>"+

                "<img src='assets/images/Servizio_Home.png' alt='Servizio' class='ok' /><br><br>"+
                "Si può accedere a questa sezione anche dalla barra di navigazione laterale. "+
                "Una volta premuto il pulsante si verrà indirizzati alla pagina di creazione dell'intervento.<br>"+
                "<img src='assets/images/Servizio_Identificativo.png' alt='Servizio' class='ok' /><br>"
  },

  { title:"Target destinatari/caratteristiche",
    descrizione:"Per modificare le caratteristiche o i target destinatari è sufficiente premere il bottone “GESTISCI CARATTERISTICHE” "+
                "o il bottone “GESTISCI TARGET DESTINATARI” rispettivamente;<br>"+
                "Premendo il bottone apparirà un menù da cui poter selezionare le caratteristiche/target destinatari da associare al servizio.<br>"+
                "Attenzione: Se il servizio deriva da un intervento che a sua volta è associato ad un modello, si potranno selezionare solo quelli presenti nel modello<br>"+
                "<img src='assets/images/Servizio_Correlati.png' alt='Ricerca Modello' class='ok' /><br>"

  },

  { title:"Enti",
    descrizione:"Per aggiungere un ente è necessario premere il bottone “AGGIUNGI ENTE”, dopo aver premuto il bottone verrà visualizzata"+
                " una pagina di ricerca che cambierà in base a quali tipi di enti sono associati allo sportello e alla tipologia pso in uso. "+
                "Se l'intervento ha già degli enti assocciati allora non sarà possibile associarne degli altri.<br>"+
                "<img src='assets/images/Enti_Ricerca.png' alt='Ricerca Modello' class='ok' /><br>"+
                "In tutto sono tre:<br>"+
                "Ricerca di istituti scolastici in questo caso è necessario valorizzare almeno un filtro. Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra sotto la tabella stess;"+
                "<img src='assets/images/Enti_Tabella.png' alt='Ricerca Modello' class='ok' /><br>"+
                "apparirà una finestra in cui inserire i dati del referente dell'ente e il ruolo.<br>"+
                "<img src='assets/images/Enti_Modale.png' alt='Ricerca Modello' class='ok' /><br>"+
                "Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire tutti i dati relativi all'ente."+
                "<img src='assets/images/Enti_Tabella2.png' alt='Ricerca Modello' class='ok' /><br>"+
                "Ricerca di centri per l'impiego in questo caso non ci sono filtri obbligatori.  Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra"+
                " sotto la tabella stessa, apparirà una finestra in cui inserire i dati del referente dell'ente e il ruolo.Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando "+
                "il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire i dati.<br>"+
                "<br>"+
                "Per ricercare un operatore regionale premere il bottone “CERCA OPERATORE” apparirà una finestra con dei filtri di ricerca è necessario valorizzarne almeno uno, selezionare l'operatore dai risultati e premere conferma;"+
                "<img src='assets/images/Enti_Operatori_Modale.png' alt='Ricerca Modello' class='ok' /><br>"+
                "la finestra si chiuderà tornando alla schermata precedente ma adesso sarà possibile effettuare una ricerca delle sedi dell'operatore selezionato."+
                " Selezionare nella tabella dei risultati che apparirà l'ente scelto e premere il bottone “AGGIUNGI ENTE SELEZIONATO” in basso a destra sotto la tabella stessa,"+
                " apparirà una finestra in cui inserire i dati del referente dell'ente. Se invece non doveste aver trovato l'ente sarà possibile inserirne uno nuovo usando"+
                " il bottone in basso a sinistra “AGGIUNGI NUOVO ENTE” che farà apparire una finestra in cui inserire i dati. Sarà inoltre possibile effettuare la ricerca di"+
                " un operatore diverso da quello selezionato usando il bottone “Modifica Operatore” accanto alla denominazione dell'ente selezionato."

  },

  { title:"Dati Peculiari Servizio",
    descrizione:"Se si vogliono aggiungere dei dati peculiari al servizio in modo che tutti i destinatari abbiano gli stessi dati peculiari; "+
                "accedere al servizio in modifica o dopo il primo salvataggio, cliccare sulla tabl destinatari , dopo di che nella sezione "+
                "“ Dati peculiari servizio” cliccare sul pulsante “MODIFICA”, che farà comparire una finestra con la possibilità di inserire "+
                "i dati desiderati. un volta completato cliccare sul pulsante conferma, per salvare i dati peculiari del servizio <br>"+

                "<img src='assets/images/Servizio_Destinatari.png' alt='Ricerca Modello' class='ok' /><br>"
  },

  { title:"Destinari di Servizio",
    descrizione:"Se si vogliono associare, modificare o dissociare  dei destinatari dal servizio in modo che tutti i destinatari abbiano gli stessi dati peculiari; "+
                "accedere al servizio in modifica o dopo il primo salvataggio, cliccare sulla tab destinatari , dopo di che nella sezione “ Destinatari servizio” premere "+
                "sul pulsante “AGGIUNGI DESTINATARI” nel caso si volesse aggiungere dei destinatari dal sistema, altrimenti nel caso si abbia un file excel compilato procedere con “AGGIUNGERE DESTINATARI DA FILE” <br><br>"+
                "<img src='assets/images/Servizio_Destinatari.png' alt='Servizio' class='ok' /><br>"+

                "1 Una volta cliccato sul pulsante “AGGIUNGI DESTINATARI” si avranno 2 casistiche a seconda del servizio se è o meno derivato da un intervento, nel caso lo fosse: "+
                "Avremmo una pagina con 2 tab: una “RICERCA DESTINATARI IN INTERVENTO” che ci andrà ad illustrare i vari destinatari associate agli altri servizi derivati dallo stesso intervento, "+
                "la seconda “RICERCA DESTINATARI DA ANAGRAFICA” che ci andrà ad illustrare i vari destinatari presenti nel sistema, tramite una ricerca <br><br>"+

                "Nel primo caso basta selezionare i destinatari desiderati e cliccare sul Pulsante “AGGIUNGI DESTINATARI SELEZIONATI” ,Una volta completata l'associazione si verrà notificati con un messaggio di completa procedura.<br><br>"+
                "<img src='assets/images/Destinatari_Da_Intervento.png' alt='Servizio' class='ok' /><br>"+

                "Se ci troviamo nel secondo caso invece, bisogna effettuare una ricerca, inserendo almeno un dato per filtrare i destinatari. Dopo di che basta selezionare "+
                "il destinatario desiderato e procedere con il click sul pulsante ”AGGIUNGI DESTINATARIO SELEZIONATO”. Ci comparire una finestra di conferma che ci permetterà "+
                "o di restare nella pagina o di tornare al servizio sul quale si sta lavorando.<br>"+
                "<img src='assets/images/Destinatari_Ricerca.png' alt='Servizio' class='ok' /><br>"
  },

  { title:"Calcolo preventivo e Richiesta finanziamento",
    descrizione:"Se si vuole calcolare un preventivo o richiedere un finanziamento, accedere ad un servizio salvato. Cliccare sul pulsante desiderato.<br>.<br>"+
                "<img src='assets/images/Servizio_Spesa.png' alt='Servizio' class='ok' /><br>"+

                "Una volta richiesto il calcolo o il finanziamento, non sarà più possibile chiederne altri finchè non arriva la risposta del servizio, "+
                "per poter controllare se è arrivata la risposta è possibile cliccare sul pulsante aggiorna per aggiornare la schermata in caso di risposta.<br>"+
                "<img src='assets/images/Servizio_Spesa2.png' alt='Servizio' class='ok' /><br>"+
                "<img src='assets/images/Servizio_Spesa3.png' alt='Servizio' class='ok' /><br>"+
                "Attenzione: una volta finanziato il servizio, non sarà più possibile modificare i dati identificativi del Servizio. Si portà per chiedere una proposta modifica dei destinatari e della durata.<br>"
  },


  { title:"Chiusura",
    descrizione:"la chiusura di un servizio è possibile se sono presenti incontri quest'ultimi devono essere tutti conclusi."
  },


  { title:"Eliminazione",
    descrizione:"Per Eliminare un servizio occorre prima effettuare una ricerca del servizio desiderato, dopo di che cliccare sul pulsante cestino rosso e confermare l'eliminazione."+
                "Attenzione: se il servizio è associato ad almeno un servizio o se l'intervento è nello stato di chiuso non sarà possibile eliminarlo.<br><br>"+
                "<img src='assets/images/Servizio_Tabella.png' alt='Servizio' class='ok'  />"
  },

  { title:"Modifica",
    descrizione:"Per Modificare un intervento occorre prima effettuare una ricerca del intervento desiderato, dopo di che cliccare sul pulsante della matita e sarà possibile modificarlo."+
                "Attenzione: non è possibile modificare un intervento chiuso.<br><br>"+
                "<img src='assets/images/Servizio_Tabella.png' alt='Servizio' class='ok'  />"
  },

  { title:"Duplicazione",
    descrizione:"Per duplicare un intervento occorre prima effettuare una ricerca del intervento desiderato, dopo di che cliccare sul pulsante dei due fogli,"+
                " procedere con la conferma e si atterra nel nuovo intervento duplicato.<br><br>"+
                "<img src='assets/images/Servizio_Tabella.png' alt='Servizio' class='ok'  />"
  },

  { title:"Scaricare la ricerca in excel",
    descrizione:"Per scaricare un file exel della ricerca bisogna prima effettuare una ricerca, dopo di che premere sul pulsante sotto a destra della tabella “SCARICA XLS”.<br><br>"+
                "<img src='assets/images/Servizio_Tabella.png' alt='Servizio' class='ok'  />"
  },
  { title:"Creazione Incontro",
    descrizione:"Per creare un incontro, è possibile aggiungere incontri ad un servizio solo se si è proprietari "+
                "del servizio e se il servizio e lo sportello non sono chiusi. Premendo il bottone “AGGIUNGI INCONTRO” "+
                "si viene reindirizzati alla pagina di creazione dell'incontro.<br>"+

                "<img src='assets/images/Incontro_Identificativo.png' alt='Incontro' class='ok' /><br><br>"+
                "I dati del referente sono quelli del  referente del servizio ma si possono modificare."+
                "Dopo aver inserito tutti i dati obbligatori e salvato diventa possibile aggiungere partecipanti e selezionare il luogo dell'incontro.<br>"
  },

  { title:"Partecipanti Incontro",
    descrizione:"dopo aver premuto il pulsante “AGGIUNGI PARTECIPANTI” all'interno della pagina PARTECIPANTI di un "+
                "incontro appare una finestra con l'elenco di destinatari associati al servizio tra cui scegliere i partecipanti all'incontro.<br>"+
                "Da questa pagina è possibile gestire le presenze dei partecipanti <br>"+
                "<img src='assets/images/Incontro_Partecipanti.png' alt='Ricerca Modello' class='ok' /><br>"+
                "se è necessario modificare le ore di partecipazione o la presenza premere l'icona matita per attivare la modifica.<br>"+
                "<img src='assets/images/Incontro_Partecipanti2.png' alt='Ricerca Modello' class='ok' /><br>"+
                "dopo aver effettuato la modifica confermare premendo l'icona.<br>"

  },

  { title:"Luogo Incontro",
    descrizione:"Se nessun luogo è stato ancora selezionato sarà possibile aggiungerlo, ogni incontro può avere un solo luogo indicato. "+
                "All'interno della pagina  LUOGO di un incontro premendo il bottone “AGGIUNGI LUOGO” si vieni indirizzati alla sezione di "+
                "selezione del luogo..<br>"+

                "<img src='assets/images/Incontro_Luogo.png' alt='Incontro' class='ok' /><br>"+

                "è possibile selezionare il luogo tra:<br>"+
                "l'elenco degli enti associati al servizio<br>"+
                "l'elenco delle sedi del soggetto attuatore competente<br>"+
                "l'anagrafica regionale operatori(il meccanismo di ricerca e selezione è uguale a quello presente nella ricerca degli "+
                "enti da anagrafica regionale operatori)<br>"+
                "centri per l'impiego(il meccanismo di ricerca e selezione è uguale a quello presente nella ricerca degli enti da centri per l'impiego)<br>"+
                "aggiungerne uno nuovo non presente tra quelli precedentemente indicati<br>"+

                "dopo aver effettuato la ricerca e selezionato il luogo desiderato appare la finestra <br>"+

                "<img src='assets/images/Incontro_Luogo2.png' alt='Incontro' class='ok' /><br>"+

                "in cui sono presenti i dati relativi al luogo al salvataggio si viene reindirizzati nuovamente alla sezione di creazione/modifica di un incontro."

  },

  { title:"Chiusura Incontro",
    descrizione:"la chiusura di un incontro è  possibile se:<br>"+
                "la data indicata come termine dell'incontro è precedente alla data odierna<br>"+
                "è presente almeno un partecipante<br>"+
                "è segnalato il luogo dove è avvenuto<br>"+
                "il servizio a cui l'incontro è associato è finanziato/avviato<br>"+
                "La chiusura di un incontro non è reversibile"
  },
]



//=====================================================================================================================================================================================================
//=====================================================================================================================================================================================================
//=====================================================================================================================================================================================================

export const Incontro_HELP :  ItemHelp[] = [

  { title:"Creazione Incontro",
    descrizione:"Per creare un incontro, è possibile aggiungere incontri ad un servizio solo se si è proprietari "+
                "del servizio e se il servizio e lo sportello non sono chiusi. Premendo il bottone “AGGIUNGI INCONTRO” "+
                "si viene reindirizzati alla pagina di creazione dell'incontro.<br>"+

                "<img src='assets/images/Incontro_Identificativo.png' alt='Incontro' class='ok' /><br><br>"+
                "I dati del referente sono quelli del  referente del servizio ma si possono modificare."+
                "Dopo aver inserito tutti i dati obbligatori e salvato diventa possibile aggiungere partecipanti e selezionare il luogo dell'incontro.<br>"
  },

  { title:"Partecipanti Incontro",
    descrizione:"dopo aver premuto il pulsante “AGGIUNGI PARTECIPANTI” all'interno della pagina PARTECIPANTI di un "+
                "incontro appare una finestra con l'elenco di destinatari associati al servizio tra cui scegliere i partecipanti all'incontro.<br>"+
                "Da questa pagina è possibile gestire le presenze dei partecipanti <br>"+
                "<img src='assets/images/Incontro_Partecipanti.png' alt='Ricerca Modello' class='ok' /><br>"+
                "se è necessario modificare le ore di partecipazione o la presenza premere l'icona matita per attivare la modifica.<br>"+
                "<img src='assets/images/Incontro_Partecipanti2.png' alt='Ricerca Modello' class='ok' /><br>"+
                "dopo aver effettuato la modifica confermare premendo l'icona.<br>"

  },

  { title:"Luogo Incontro",
    descrizione:"Se nessun luogo è stato ancora selezionato sarà possibile aggiungerlo, ogni incontro può avere un solo luogo indicato. "+
                "All'interno della pagina  LUOGO di un incontro premendo il bottone “AGGIUNGI LUOGO” si vieni indirizzati alla sezione di "+
                "selezione del luogo..<br>"+

                "<img src='assets/images/Incontro_Luogo.png' alt='Incontro' class='ok' /><br>"+

                "è possibile selezionare il luogo tra:<br>"+
                "l'elenco degli enti associati al servizio<br>"+
                "l'elenco delle sedi del soggetto attuatore competente<br>"+
                "l'anagrafica regionale operatori(il meccanismo di ricerca e selezione è uguale a quello presente nella ricerca degli "+
                "enti da anagrafica regionale operatori)<br>"+
                "centri per l'impiego(il meccanismo di ricerca e selezione è uguale a quello presente nella ricerca degli enti da centri per l'impiego)<br>"+
                "aggiungerne uno nuovo non presente tra quelli precedentemente indicati<br>"+

                "dopo aver effettuato la ricerca e selezionato il luogo desiderato appare la finestra <br>"+

                "<img src='assets/images/Incontro_Luogo2.png' alt='Incontro' class='ok' /><br>"+

                "in cui sono presenti i dati relativi al luogo al salvataggio si viene reindirizzati nuovamente alla sezione di creazione/modifica di un incontro."

  },

  { title:"Chiusura Incontro",
    descrizione:"la chiusura di un incontro è  possibile se:<br>"+
                "la data indicata come termine dell'incontro è precedente alla data odierna<br>"+
                "è presente almeno un partecipante<br>"+
                "è segnalato il luogo dove è avvenuto<br>"+
                "il servizio a cui l'incontro è associato è finanziato/avviato<br>"+
                "La chiusura di un incontro non è reversibile"
  },

]

export const Caricamento_Excel_HELP : ItemHelp[]=[
  {
    title:"Copiare i dati da un file excel al file per il caricamento",
    descrizione:
      "Questa voce della guida ha lo scopo di illustrare come risolvere il problema di un file excel che pur essendo compilato risulta non funzionante, la procedura non funzionerà comunque se i dati  sono incompleti.<br>"+
      "Per copiare correttamente i dati da un file excel non valido ad uno valido selezionare tutte le celle con i dati che si vogliono importare,<br> "+
      "<strong> NON tutta la riga, solo le celle</strong><br><br> " +
      "aprire un file per il caricamento dati di cui siete certi che la struttura non sia stata modificata, posizionarsi sulla prima cella libera in alto a sinistra e fare click col destro<br><br>"+

      "<img src='assets/images/casella-corretta.png' alt='casella in alto a destra' class='ok' /><br><br><br>"+

      "Selezionare l'opzione incolla speciale e dal menù che si aprirà selezionare l'opzione incolla valori <br><br><br>"+
      "<img src='assets/images/opzione-incolla-speciale.png' alt='opzione incolla speciale' class='vertical-image' /><br>"

  },
 /* {
    title:"Formati e vincoli dei dati",
    descrizione:
      "In questa voce illustriamo i vincoli dei dati edi formati corretti in base agli errori più comuni che abbiamo riscontrato:"+
      "Limiti sul numero di caratteri:" +
      "<ul>"+
        "<li>Tutti gli indirizzi possono avere al massimo 100 caratteri</li>"+
        "<li>Il recapito mail può avere al massimo 100 caratteri</li>"+
        "<li>Il recapito telefonico può avere al massimo 50 caratteri</li>"+
      "</ul>"

  }*/

]

export const ARRAY_HELP = [Modello_HELP, Intervento_HELP, Servizio_HELP, Incontro_HELP, Caricamento_Excel_HELP ]

