

#collegamento al server remoto
da powershell lanciare il seguente comando (cambiare porta se necessario) sostituendi:
   xxxxx: sostituire con la propria matricola 
   ipDB: sostituire l'indirizzo ip del DB  
   ipMP: sostituire l'indirizzo ip della macchina ponte
ssh -L 5555:ipDB:5432 xxxxx@ipMP

configurazioni appliction.properties datasource

spring.datasource.url=jdbc:postgresql://127.0.0.1:5555/SERSE_DV?currentSchema=serse
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=serse
spring.datasource.password=###########

#per lanciare il progetto

per lanciare l'applicazione lanciare SerseWebApplication come java application
il path dell'applicazione è /serseweb/api si puo modificare dal file JaxrsApplication

#struttura dei package

#package generati tramite swagger generator del csi:

it.csi.serse.serseweb.api:  
		contiene i path e le interfacce per l'esposizione dei servizi

it.csi.serse.serseweb.vo:    
		contiene gli oggetti che vengono usati in risposta alle chiamate

#package che contengono la logica implementativa:

it.csi.serse.serseweb.api.impl:   
		contiene l'implementazione delle interfacce api richiama i manager per le chiamate

it.csi.serse.serseweb..api.manager:    
		contiene i file in cui vengono gestite le chiamate ai dao, e gestiti mapping ed errori

it.csi.serse.serseweb.integration.mybatis.dao/dto:    
		packages contenenti interfacce e modelli generati dal generatore di mybatis, sono tutte mappature speculari al database 
		
it.csi.serse.serseweb.integration.mybatis.dao/dto.custom:     
		packages contenenti interfacce e modelli personalizzati per strutture dati e query più complesse
		
nella cartella resources nel percorso it.csi.serse.serseweb.integration.mybatis.dao/dto.custom ci sono i file xml che mappano le interfacce dao per fare le chiamate a database

Per rigenerare le classi CXF/GAM dovrebbe bastare eliminarle e rilanciare la build
Oppure:
	mvn org.apache.cxf:cxf-codegen-plugin:wsdl2java

Per rigenerare i bean mybatis devi modificare il generatorConfig.xml, metti la posizione del driver postgresql locale,
la password di db, e il nome della/e tabella/e da rigenerare, poi lanci da IDE MybatisGenerator.generate()

Per generare le header dei file lanciare

    mvn process-sources