# Prodotto SERSE

Sistema per l'erogazione di servizi individuali e di gruppo.

Tra le principali funzionalità dell'applicativo:

* Creazione e gestione di _servizi_, individuali o per piccoli gruppi
* Creazione e gestione di _interventi_ (gruppi di servizi)
* Creazione e gestione di _modelli di intervento_, per agevolare la creazione degli interventi

L'applicativo è una applicazione web con architettura a microservizi, composto di
una componente di frontend (`sersewcl`) e una di backend (`serseweb`).

Per l'autenticazione e la profilazione degli utenti, l'applicazione è integrata con servizi trasversali del sistema informativo regionale (rispettivamente **Shibboleth** e **Flaidoor**).

La gestione amministrativa dei servizi individuali è demandata a un altro applicativo, che nel sistema informativo regionale è **GAM Opera**.
Sono previste numerose chiamate ai webservice di GAM Opera (es. richiesta di finanziamento, chiusura di attività erogate).
Le chiamate sono asincrone, e ci si aspetta che GAM Opera fornisca un feedback al termine dell'operazione tramite un meccanismo di _callback_:
deve invocare un opportuno servizio sulla componente `serseapi`.


## Componenti applicative


| Componente | Descrizione | Tecnologia |
| ---------- | ----------- | ---------- |
| SerseWCl | Frontend | Angular 14 |
| SerseWeb | Backend | Java 17, Spring Boot 3 |
| SerseAPI | Servizi per terze parti | Java 17, Spring Boot 3 |
| SerseDB | Base dati | PostgreSQL 14+ |

## Prerequisiti

* PostgreSQL 14+
* Utenza con privilegi per la creazione degli oggetti DB
* Node 16+ (per lo sviluppo del frontend in Angular)
* JDK 17, Maven 3.11+ (per lo sviluppo delle componenti Java)
* Apache 2.4+

Per l'utilizzo dell'applicativo in altro contesto (non regionale),
occorre avere a disposizione servizi analoghi a quelli regionali o integrare moduli opportuni che svolgano analoghe funzionalità.

## Build

* Creare i pacchetti jar per le componenti `serseweb` e `serseapi`:

        mvn package
        
* Creare i file HTML+CSS+JS compilati per la componente `serseweb`:

        npm run build


## Deploy

### Database
Creare lo schema del DB tramite gli script presenti nella componente `sersedb`.

### Componenti Java
L'infrastruttura deve provvedere all'esecuzione e all'avvio
delle due applicazioni Java mediante:

            java -jar run serseweb-xxx.jar
            java -jar run serseapi-xxx.jar

### Componente Angular
Deployare i file compilati su server Apache


## License
Software rilasciato con licenza EUPL 1.2

© Copyright Regione Piemonte – 2025
