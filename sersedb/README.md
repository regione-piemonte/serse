
# Prodotto
SERSE - Sistema di ERogazione dei SErvizi

# Descrizione del prodotto
Serse è lo strumento ad uso dei “soggetti attuatori”, ossia dei soggetti deputati all’erogazione dei servizi oggetto di finanziamento, nell’ambito delle candidature in cui sono coinvolti in qualità di Beneficiari o di eventuali Componenti del Raggruppamento Temporaneo, per l’erogazione dei servizi individuali e di gruppo.
Il sistema Serse è stato realizzato nel corso del 2023 ed utilizzato per le necessità specifiche del contesto Orientamento. Nasce però come strumento trasversale alle materie “Istruzione, Formazione e Lavoro” aventi processi con obiettivi analoghi.

Serse è un sistema:  
* «generalizzato» alle esigenze della direzione committente; 
* «integrato» ad altre componenti applicative coinvolte all’assolvimento delle diverse fasi del processo finalizzate alla presentazione delle istanze, alla gestione delle risorse economiche e al monitoraggio.  

## Principali funzionalità del sistema
   
### Attivazione soggetti attuatori autorizzati  
Previsto un processo automatico per l’“attivazione” - all’uso delle funzionalità del sistema - dei soggetti attuatori (presentatori, capofila, componenti in Raggruppamento temporaneo) coinvolti in istanze presentate a fronte di un bando e per le quali è stata comunicata al Sistema di Erogazione Servizi - da parte del sistema di Gestione Amministrativa - formale autorizzazione al finanziamento.   
    
### Gestione Modelli di intervento  
I Modelli di Intervento rappresentano e formalizzano la progettazione, da parte dei soggetti attuatori, dell’offerta di servizi erogabile sul territorio per i contesti definiti dal bando (in eventuale collaborazione con Enti coinvolti, ad es. scuole, cpi, altri soggetti).  
Tale macro-programmazione potrà poi essere concretamente attuata attraverso la definizione e gestione di specifici interventi e/o servizi, rivolti ai soggetti destinatari individuati.  
   
### Gestione Interventi   
L’intervento identifica l’attuazione strutturata di uno o più servizi, individuali o di gruppo, rivolti ad uno specifico destinatario o ad un insieme – solitamente omogeneo - di destinatari (es. Percorso di orientamento per gli allievi di un Istituto Scolastico, Percorso individuale per “Mario Rossi”).    
In un’ottica di maggiore flessibilità e generalizzazione del sistema, a seconda del processo previsto dal Bando di interesse, la gestione degli Interventi potrà essere opzionalmente condizionata ai contenuti definiti in un Modello di riferimento (“Gestione Modelli di intervento”).  
  	 
### Gestione Servizi   
I servizi rappresentano l’erogazione delle azioni regionali a uno o più destinatari.  
In un’ottica di maggiore flessibilità e generalizzazione del sistema, a seconda del processo previsto dal Bando di interesse, la gestione dei servizi individuali o di gruppo potrà essere o meno vincolata alla preventiva definizione di uno specifico intervento (“Gestione Interventi”).  
    
### Verifica del budget  
Sono previste funzioni utili a consultare, nell’ambito di un bando, lo stato corrente del “budget” competente ad un soggetto beneficiario (es. assegnato, finanziato, residuo).  
  	  
### Esposizione dati a sistemi esterni  
Sono stati realizzati specifici servizi di cooperazione applicativa che consentano l’esposizione a sistemi esterni autorizzati:  
* dei dati anagrafici dei Destinatari gestiti nel sistema;   
* dei servizi di gruppo e/o individuali eventualmente somministrati ad uno specifico Destinatario (CF).  
 
### Ruolo in sola lettura per Amministrazione Responsabile 
Per permettere ai referenti regionali dei bandi gestiti su SERSE di accedere al sistema e verificare l’operato degli utenti, e per poter fornire loro un’assistenza migliore riguardo l’iter amministrativo, è stato configurato un ruolo apposito con accesso in sola lettura su tutte le pagine dell’applicativo. Ogni singola pagina e ogni funzionalità del sistema è stata configurata per poter essere visualizzata da questo ruolo, escludendo tutte le azioni attive previste per gli altri ruoli. L’intervento di configurazione è stato capillare su tutte le pagine del sistema e sui singoli pulsanti in esse contenuti per diversificare il comportamento in base al ruolo dell’utente connesso. Per il dettaglio delle attività di configurazione, si faccia riferimento all’apposito paragrafo descrittivo delle attività previste. 



ATTENZIONE: QUANTO SEGUE DEV'ESSERE SPOSTATO NEL README DELLA COMPONENTE DB



# Descrizione della componente
SERSEDB è la componente DB del prodotto SERSE.\
Il DBMS di riferimento è PostgreSQL.\
Tramite gli script qui presenti viene creato e popolato lo schema dati usato dalle altre componenti.\
Questa componente include:
- script DDL per la creazione delle sequence;
- script DDL per la creazione dello schema dati;
- script DML per il popolamento iniziale del DB;
- script DDL per la definizione dei vincoli (check + foreign key);
- script DDL per la creazione delle functions PL/pgSQL

Si fa presente che nello script DML per il popolamento iniziale del DB non sono presenti le insert per alcune tabelle necessarie per il funzionamento del sistema ma strettamente collegate ad altri applicativi (GAM, SISPRO) o alla Regione Piemonte o dipendenti dal contesto operativo (specifici bandi).
Oltre alle tabelle previste nello script, vanno popolate anche le seguenti:
- ext_bdgt_t_pso
- ext_bdgt_t_pso_sportello
- ext_bdgt_t_tipol_pso
- ext_gmop_d_area_territoriale
- ext_tt_bacino
- serse_d_classificazione
- serse_d_cpi
- serse_d_istituto_scolastico
- serse_d_periodo_attivazione_servizio
- serse_d_reg_comport_pso_sport
- serse_d_servizio_regionale
- serse_d_sistema_gestione_amm
- serse_d_sport_monitoraggio
- serse_d_tipo_richiesta_gam
- serse_r_pso_classe_destinatario

# Configurazioni iniziali
Definire utente "serse" su una istanza DBMS PostgreSQL (versione 12 o superiore) proprietario dello schema.

# Getting Started
Una volta prelevata e portata in locale dal repository la componente ("git clone"), predisporsi per poter eseguire gli script nella sequenza indicata nel seguito.

# Prerequisiti di sistema
DBMS nella versione indicata, utente con permessi adeguati ad eseguire istruzioni di creazione tabelle.

# Installazione
Lanciare tutti gli script nella sequenza indicata dal prefisso del nome del file:

    01-sequences.sql
    02-tables.sql
    03-data.sql
    04-cheks.sql
    05-foreign_keys.sql
    06-functions.sql


# Versioning
Per il versionamento del software si usa la tecnica Semantic Versioning (http://semver.org).

# Authors
Fare riferimento a quanto riportato nel file AUTHORS.txt.

# Copyrights

© Copyright Regione Piemonte – 2025 

© Copyright CSI-Piemonte – 2025 

Vedere anche il file Copyrights.txt .

# License
Il prodotto software è sottoposto alla licenza EUPL-1.2 o versioni successive.\
SPDX-License-Identifier: EUPL-1.2-or-later.\
Vedere il file EUPL v1_2 IT-LICENSE.txt per i dettagli.
