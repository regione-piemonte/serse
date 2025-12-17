create table if not exists ext_bdgt_t_pso
(
   id_pso             integer         not null,
   descrizione        varchar(2000)   not null,
   id_atto_indirizzo  numeric         not null,
   cod_tipol_pso      varchar(6)      not null,
   cod_ar             numeric,
   sigla_ente         varchar(2)      not null,
   cod_ciclo_finanz   varchar(2)      not null
);

alter table ext_bdgt_t_pso
   add constraint pk_ext_bdgt_t_pso
   primary key (id_pso);

create table if not exists ext_bdgt_t_pso_sportello
(
   num_progr_sportello  numeric        not null,
   id_pso               integer        not null,
   descr_sportello      varchar(500)   not null,
   d_inizio             timestamp      not null,
   d_fine               timestamp
);

alter table ext_bdgt_t_pso_sportello
   add constraint pk_ext_bdgt_t_pso_sportello
   primary key (num_progr_sportello);

create index if not exists ie_ext_bdgt_t_pso_sportello_01 ON ext_bdgt_t_pso_sportello USING btree (id_pso);

create table if not exists ext_bdgt_t_tipol_pso
(
   id_atto_indirizzo        numeric         not null,
   cod_tipol_pso            varchar(6)      not null,
   descrizione              varchar(2000)   not null,
   cod_programmazione       numeric(4)      not null,
   cod_classificazione_adi  varchar(6)      not null,
   anno_approv              numeric(4)      not null
);

alter table ext_bdgt_t_tipol_pso
   add constraint pk_ext_bdgt_t_tipol_pso
   primary key (id_atto_indirizzo, cod_tipol_pso);

create unique index ak_ext_bdgt_t_tipol_pso_01 ON ext_bdgt_t_tipol_pso USING btree (cod_programmazione, cod_classificazione_adi, anno_approv, cod_tipol_pso);

create table if not exists ext_gmop_d_area_territoriale
(
   cod_area_territoriale    varchar(2)     not null,
   descr_area_territoriale  varchar(100)   not null,
   d_inizio                 timestamp      not null,
   d_fine                   timestamp
);

alter table ext_gmop_d_area_territoriale
   add constraint pk_ext_gmop_d_area_territoriale
   primary key (cod_area_territoriale);

create table if not exists ext_sispro_d_anno_scolastico
(
   id_anno_scolastico     numeric(3)     not null,
   descr_anno_scolastico  varchar(100)   not null,
   d_inizio_val           timestamp      not null,
   d_fine_val             timestamp      not null
);

alter table ext_sispro_d_anno_scolastico
   add constraint pk_ext_sispro_d_anno_scolastico
   primary key (id_anno_scolastico);

create table if not exists ext_sispro_d_grado_scolastico
(
   id_grado_scolastico     varchar(1)     not null,
   descr_grado_scolastico  varchar(100)   not null
);

alter table ext_sispro_d_grado_scolastico
   add constraint pk_ext_sispro_d_grado_scolastico
   primary key (id_grado_scolastico);

create table if not exists ext_sispro_d_percorso
(
   id_percorso      numeric(2)     not null,
   id_tipo_istituz  numeric(2)     not null,
   descr_percorso   varchar(100)
);

alter table ext_sispro_d_percorso
   add constraint pk_ext_sispro_d_percorso
   primary key (id_percorso);

create table if not exists ext_sispro_d_tipo_istituz
(
   id_tipo_istituz     numeric(2)     not null,
   descr_tipo_istituz  varchar(100)   not null,
   d_inizio_val        timestamp      not null,
   d_fine_val          timestamp
);

alter table ext_sispro_d_tipo_istituz
   add constraint pk_ext_sispro_d_tipo_istituz
   primary key (id_tipo_istituz);

create table if not exists ext_sispro_d_tipo_sezione
(
   id_tipo_sezione     numeric(1)     not null,
   descr_tipo_sezione  varchar(100)   not null
);

alter table ext_sispro_d_tipo_sezione
   add constraint pk_ext_sispro_d_tipo_sezione
   primary key (id_tipo_sezione);

create table if not exists ext_sispro_d_tipo_unita
(
   id_tipo_unita        numeric(2)     not null,
   descr_tipo_unita     varchar(100)   not null,
   id_grado_scolastico  varchar(1)     not null
);

alter table ext_sispro_d_tipo_unita
   add constraint pk_ext_sispro_d_tipo_unita
   primary key (id_tipo_unita);

create table if not exists ext_sispro_d_tipologia
(
   id_tipologia     numeric(1)     not null,
   descr_tipologia  varchar(100)   not null
);

alter table ext_sispro_d_tipologia
   add constraint pk_ext_sispro_d_tipologia
   primary key (id_tipologia);

create table if not exists ext_stati_esteri
(
   cod_stato          numeric(3)    not null,
   descrizione_stato  varchar(30)   not null,
   stato_cod_fiscale  varchar(4),
   sigla_nazione      varchar(2)
);

alter table ext_stati_esteri
   add constraint pk_ext_stati_esteri
   primary key (cod_stato);

create table if not exists ext_tab_cittadinanza
(
   cod_istat_cittadinanza  varchar(3)     not null,
   descr_cittadinanza      varchar(100)   not null,
   cod_nazionalita         varchar(1),
   flg_sett_lav            varchar(1),
   codice                  varchar(3),
   descrizione_precedente  varchar(100),
   d_inizio                timestamp      not null,
   d_fine                  timestamp
);

alter table ext_tab_cittadinanza
   add constraint pk_ext_tab_cittadinanza
   primary key (cod_istat_cittadinanza);

create table if not exists ext_tab_nazionalita
(
   cod_nazionalita  varchar(1)    not null,
   descrizione      varchar(20)   not null
);

alter table ext_tab_nazionalita
   add constraint pk_ext_tab_nazionalita
   primary key (cod_nazionalita);

create table if not exists ext_tt_bacino
(
   cod_bacino   numeric(2)     not null,
   descrizione  varchar(100)   not null,
   prov         char(3)        not null
);

alter table ext_tt_bacino
   add constraint pk_ext_tt_bacino
   primary key (cod_bacino);

comment on table ext_tt_bacino is 'La tabella è stata chiamata TT per uniformità con le tabelle collegate ma corrisponde alla tabella DB_BACINO di FPPROT';

create table if not exists ext_tt_comune
(
   comune       varchar(6)    not null,
   prov         varchar(3)    not null,
   descom       varchar(30)   not null,
   cap          varchar(5),
   codfisc      varchar(4),
   montana      varchar(2),
   ussl         varchar(3),
   zonaalt      varchar(1),
   zonaalts1    varchar(1),
   zonaalts2    varchar(1),
   regagri      varchar(2),
   prov_old     varchar(3),
   comune_old   varchar(6),
   usl_old      varchar(3),
   prov_new     varchar(1),
   popolazione  numeric(10),
   prefisso     varchar(5),
   cod_bacino   numeric(2)
);

alter table ext_tt_comune
   add constraint pk_ext_tt_comune
   primary key (comune);

create index if not exists ie_ext_tt_comune_01 ON ext_tt_comune USING btree (cod_bacino);

create table if not exists ext_tt_provincia
(
   prov     char(3)       not null,
   regione  varchar(2)    not null,
   desprov  varchar(30)   not null,
   sigprov  varchar(2)    not null
);

alter table ext_tt_provincia
   add constraint pk_ext_tt_provincia
   primary key (prov);

create table if not exists serse_d_caratteristica
(
   id_caratteristica     integer        not null,
   descr_caratteristica  varchar(150)   not null
);

alter table serse_d_caratteristica
   add constraint pk_serse_d_caratteristica
   primary key (id_caratteristica);

create table if not exists serse_d_classificazione
(
   id_classificazione      integer         not null,
   id_classificazione_gam  integer         not null,
   livello_1               varchar(10)     not null,
   livello_2               varchar(10),
   livello_3               varchar(10),
   livello_4               varchar(10),
   id_tipo_suddiv_dotfin   numeric(1)      not null,
   descr_classificazione   varchar(1000)   not null
);

alter table serse_d_classificazione
   add constraint pk_serse_d_classificazione
   primary key (id_classificazione);

create unique index ak_serse_d_classificazione_01 ON serse_d_classificazione USING btree (id_classificazione_gam, COALESCE(livello_4, 'NO_LIVELLO'::character varying));

create unique index ak_serse_d_classificazione_02 ON serse_d_classificazione USING btree (livello_1, COALESCE(livello_2, 'NO_LIVELLO'::character varying), COALESCE(livello_3, 'NO_LIVELLO'::character varying), COALESCE(livello_4, 'NO_LIVELLO'::character varying));



comment on column serse_d_classificazione.id_tipo_suddiv_dotfin is '1=Asse 2=Asse+Obiettivo 3=Asse+Obiettivo+Attivita 4=Asse+Obiettivo+Attivita+Azione';

create table if not exists serse_d_condizione_occupazionale
(
   cod_condizione_occupazionale    varchar(2)     not null,
   descr_condizione_occupazionale  varchar(100)   not null,
   d_inizio                        timestamp      not null,
   d_fine                          char(40)
);

alter table serse_d_condizione_occupazionale
   add constraint pk_serse_d_condizione_occupazionale
   primary key (cod_condizione_occupazionale);

comment on table serse_d_condizione_occupazionale is 'Contiene le possibili condizioni di ingresso nel mercato';

create table if not exists serse_d_cpi
(
   id_cpi            numeric(3)     not null,
   codice_cpi        varchar(11)    not null,
   cpi               varchar(50)    not null,
   gruppo_operatore  varchar(1)     not null,
   cod_operatore     numeric(5)     not null,
   sede              varchar(4)     not null,
   indirizzo         varchar(300)   not null,
   cap               varchar(5)     not null,
   cod_istat_comune  varchar(6)     not null,
   cod_provincia     varchar(3)     not null,
   telefono          varchar(20)    not null,
   telefono_2        varchar(20),
   telefono_3        varchar(20),
   numero_verde      varchar(20),
   email             varchar(60),
   indirizzo_web     varchar(50)
);

alter table serse_d_cpi
   add constraint pk_serse_d_cpi
   primary key (id_cpi);

create index if not exists ie_serse_d_cpi_01 ON serse_d_cpi USING btree (codice_cpi);

create index if not exists ie_serse_d_cpi_02 ON serse_d_cpi USING btree (gruppo_operatore, cod_operatore);



comment on table serse_d_cpi is 'Tavola dei CPI: dati ereditati da SILP';

create table if not exists serse_d_finalita_servizio
(
   cod_finalita_servizio    varchar(1)    not null,
   descr_finalita_servizio  varchar(50)   not null
);

alter table serse_d_finalita_servizio
   add constraint pk_serse_d_finalita_servizio
   primary key (cod_finalita_servizio);

create table if not exists serse_d_fonte_dato
(
   id_fonte_dato     numeric(3)     not null,
   descr_fonte_dato  varchar(150)   not null
);

alter table serse_d_fonte_dato
   add constraint pk_serse_d_fonte_dato
   primary key (id_fonte_dato);

create table if not exists serse_d_istituto_scolastico
(
   id_istituto_scolastico        numeric(10)    not null,
   cod_regionale_scuola          varchar(10)    not null,
   cod_regionale_autonomia       varchar(10),
   cod_meccanografico_scuola     varchar(10),
   cod_meccanografico_autonomia  varchar(10),
   denominazione                 varchar(250)   not null,
   cod_comune_scuola             varchar(6)     not null,
   indirizzo                     varchar(250)   not null,
   recapito_email                varchar(100),
   recapito_telefonico           varchar(100),
   url_sito_web                  varchar(100),
   id_tipologia                  numeric(1),
   id_percorso                   numeric(2),
   id_tipo_sezione               numeric(1),
   id_tipo_unita                 numeric(2),
   id_anno_scolastico            numeric(3),
   d_apertura                    timestamp      not null,
   d_chiusura                    timestamp,
   d_modifica                    timestamp,
   d_inserim_serse               timestamp      not null,
   id_transazione_inserim        numeric(10)    not null,
   d_aggiorn_serse               timestamp,
   id_transazione_aggiorn        numeric(10),
   d_chiusura_serse              timestamp,
   id_transazione_chiusura       numeric(10)
);

alter table serse_d_istituto_scolastico
   add constraint pk_serse_d_istituto_scolastico
   primary key (id_istituto_scolastico);

create unique index ak_serse_d_istituto_scolastico_01 ON serse_d_istituto_scolastico USING btree (cod_regionale_scuola);



comment on column serse_d_istituto_scolastico.id_istituto_scolastico is 'Progressivo univoco che identifica la transazione';
comment on column serse_d_istituto_scolastico.cod_regionale_scuola is 'Codice regionale del punto di erogazione (es.: 0012724373). E'' UNIVOCO';
comment on column serse_d_istituto_scolastico.cod_regionale_autonomia is 'Codice regionale dell''autonomia (es.: 001272A241).';
comment on column serse_d_istituto_scolastico.cod_meccanografico_scuola is 'Codice meccanografico del punto di erogazione (es.: TOPM018018)';
comment on column serse_d_istituto_scolastico.cod_meccanografico_autonomia is 'Codice meccanografico dell''autonomia di riferimento (es.: TOIS01800R)';
comment on column serse_d_istituto_scolastico.denominazione is 'Denominazione dell''Istituto scolastico';
comment on column serse_d_istituto_scolastico.cod_comune_scuola is 'Codice istat del comune';
comment on column serse_d_istituto_scolastico.indirizzo is 'Indirizzo del punto di erogazione';
comment on column serse_d_istituto_scolastico.recapito_email is 'Indirizzo email';
comment on column serse_d_istituto_scolastico.recapito_telefonico is 'Recapito telefonico';
comment on column serse_d_istituto_scolastico.url_sito_web is 'Url del sito di riferimento';
comment on column serse_d_istituto_scolastico.id_tipologia is 'Tipologia istituto (es. NON STATALE PARITARIA)';
comment on column serse_d_istituto_scolastico.id_percorso is 'Detaglio del tipo istituzione (es.: LICEO SCIENTIFICO)';
comment on column serse_d_istituto_scolastico.id_tipo_sezione is 'Tipo sezione (es.: DIURNA)';
comment on column serse_d_istituto_scolastico.id_tipo_unita is 'Tipo unita'' (es.: SEDE CENTRALE)';
comment on column serse_d_istituto_scolastico.id_anno_scolastico is 'Anno scolastico di riferimento (es. 92 corrispondente a 2023/2024)';
comment on column serse_d_istituto_scolastico.d_apertura is 'Data apertura punto di erogazione';
comment on column serse_d_istituto_scolastico.d_chiusura is 'Data chiusura punto di erogazione';
comment on column serse_d_istituto_scolastico.d_modifica is 'Data ultima modifica';

create table if not exists serse_d_livello_istruzione
(
   cod_livello_istruzione    varchar(2)     not null,
   descr_livello_istruzione  varchar(200)   not null,
   d_inizio                  timestamp      not null,
   d_fine                    char(40)
);

alter table serse_d_livello_istruzione
   add constraint pk_serse_d_livello_istruzione
   primary key (cod_livello_istruzione);

comment on table serse_d_livello_istruzione is 'Contiene i valori dei livelli di istruzione';

create table if not exists serse_d_periodo_attivazione_servizio
(
   id_periodo_attivazione_servizio  integer     not null,
   num_progr_sportello              numeric     not null,
   d_inizio_attivazione             timestamp   not null,
   d_fine_attivazione               timestamp   not null
);

alter table serse_d_periodo_attivazione_servizio
   add constraint pk_serse_d_periodo_attivazione_servizio
   primary key (id_periodo_attivazione_servizio);

create index if not exists ie_serse_d_periodo_attivazione_servizio_01 ON serse_d_periodo_attivazione_servizio USING btree (num_progr_sportello);

create table if not exists serse_d_processo_finanziamento
(
   id_processo_finanziamento     integer        not null,
   descr_processo_finanziamento  varchar(100)   not null
);

alter table serse_d_processo_finanziamento
   add constraint pk_serse_d_processo_finanziamento
   primary key (id_processo_finanziamento);

create table if not exists serse_d_provenienza_luogo
(
   id_provenienza_luogo     numeric(2)     not null,
   descr_provenienza_luogo  varchar(250),
   id_pso                   integer,
   id_fonte_dato            numeric(3)
);

alter table serse_d_provenienza_luogo
   add constraint pk_serse_d_provenienza_luogo
   primary key (id_provenienza_luogo);

comment on column serse_d_provenienza_luogo.descr_provenienza_luogo is 'In caso di provenienza da fonte dato, la descrizione è quella della fonte dato stessa';

create table if not exists serse_d_reg_comport_pso_sport
(
   id_reg_comport_pso_sport   integer       not null,
   id_pso                     integer       not null,
   num_progr_sportello        numeric,
   tipo_gestione_soggetti_rt  varchar(1),
   flg_gestione_modello       varchar(1),
   tipo_gestione_intervento   varchar(1),
   tipo_gestione_servizio     varchar(1)    not null,
   id_sistema_gestione_amm    integer       not null,
   id_processo_finanziamento  integer       not null,
   label_dato_peculiare_1     varchar(50),
   label_dato_peculiare_2     varchar(50),
   tipologia_budget_gam       varchar(1),
   label_campo_aggiuntivo_1   varchar(50),
   d_inizio_validita          timestamp not null,
   d_fine_validita            timestamp not null
);

alter table serse_d_reg_comport_pso_sport
   add constraint pk_serse_d_reg_comport_pso_sport
   primary key (id_reg_comport_pso_sport);

create unique index ak_serse_d_reg_comport_pso_sport_01 ON serse_d_reg_comport_pso_sport USING btree (id_pso, COALESCE(num_progr_sportello, (0)::numeric));



comment on column serse_d_reg_comport_pso_sport.tipo_gestione_soggetti_rt is 'Può assumere i seguenti valori - null (= non prevede la gestione del RT) - 1 (= prevede la gestione FACOLTATIVA del RT) - 2 (= prevede la gestione OBBLIGATORIA del RT)';
comment on column serse_d_reg_comport_pso_sport.flg_gestione_modello is 'Può valere S (se è prevista la gestione del modello) o null (se non è prevista)';
comment on column serse_d_reg_comport_pso_sport.tipo_gestione_intervento is 'null - non prevede la gestione dell''intervento 0 - prevede la gestione dell''intervento senza la gestione del modello 1 - prevede la gestione dell''intervento con aggancio facoltativo ad un modello 2 - prevede la gestione dell''intervento con aggancio obbligatorio ad un modello  se 0 o null, flg_gestione_modello deve essere null se 1 o 2, deve esserci flg_gestione_modello is not null';
comment on column serse_d_reg_comport_pso_sport.tipo_gestione_servizio is '0 - prevede la gestione del servizio senza la gestione dell''intervento  1 - prevede la gestione del servizio con aggancio facoltativo ad un intervento  2 - prevede la gestione del servizio con aggancio obbligatorio ad un intervento   se 0, flg_gestione_intervento deve essere null se 1 o 2, deve esserci flg_gestione_intervento is not null';
comment on column serse_d_reg_comport_pso_sport.id_sistema_gestione_amm is 'Identificativo del Sistema di Gestione Amministrativo coinvolto nella pso/sportello';
comment on column serse_d_reg_comport_pso_sport.id_processo_finanziamento is 'Identificativo del processo di finanziamento utilizzato';
comment on column serse_d_reg_comport_pso_sport.label_dato_peculiare_1 is 'Etichetta da visualizzare per il dato_peculiare_1';
comment on column serse_d_reg_comport_pso_sport.label_dato_peculiare_2 is 'Etichetta da visualizzare per il dato_peculiare_2';
comment on column serse_d_reg_comport_pso_sport.tipologia_budget_gam is 'Tipologia di budget utilizzata nella verifica della disponibilitÃ  economica residua in GAM';
comment on column serse_d_reg_comport_pso_sport.label_campo_aggiuntivo_1 is 'Etichetta da visualizzare per il campo_aggiuntivo_1';
comment on column serse_d_reg_comport_pso_sport.d_inizio_validita is 'Data di inizio validita'' per l''inserimento di servizi e incontri';
comment on column serse_d_reg_comport_pso_sport.d_fine_validita is 'Data di fine validita'' per l''inserimento di servizi e incontri';

create table if not exists serse_d_ruolo_ente
(
   id_ruolo_ente     numeric(2)     not null,
   descr_ruolo_ente  varchar(100)   not null,
   d_inizio          timestamp      not null,
   d_fine            timestamp
);

alter table serse_d_ruolo_ente
   add constraint pk_serse_d_ruolo_ente
   primary key (id_ruolo_ente);

create table if not exists serse_d_servizio_regionale
(
   id_servizio_regionale      integer        not null,
   id_pso                     integer        not null,
   codice_servizio_regionale  varchar(6)     not null,
   descr_servizio_regionale   varchar(100)   not null,
   cod_finalita_servizio      varchar(1)     not null,
   durata_in_ore              numeric(4,1),
   ore_consentite_min         numeric(4,1),
   ore_consentite_max         numeric(4,1),
   flg_campo_aggiuntivo_1     varchar(1)
);

alter table serse_d_servizio_regionale
   add constraint pk_serse_d_servizio_regionale
   primary key (id_servizio_regionale);

create index if not exists ie_serse_d_servizio_regionale_01 ON serse_d_servizio_regionale USING btree (id_pso);



comment on column serse_d_servizio_regionale.flg_campo_aggiuntivo_1 is 'Se = null, il campo non e'' visibile; se ''V'', va rilevato ed e'' facoltativo; se ''O'' va rilevato ed e'' obbligatorio';

create table if not exists serse_d_sistema_gestione_amm
(
   id_sistema_gestione_amm  integer       not null,
   descr_sistema_gestione   varchar(50)   not null
);

alter table serse_d_sistema_gestione_amm
   add constraint pk_serse_d_sistema_gestione_amm
   primary key (id_sistema_gestione_amm);

create table if not exists serse_d_sport_monitoraggio
(
   id_reg_comport_pso_sport              integer      not null,
   flg_livello_istruzione                varchar(1),
   flg_condizione_occupazionale          varchar(1),
   flg_disabilita                        varchar(1),
   flg_svantaggio_abitativo              varchar(1),
   cod_livello_istruzione_default        varchar(2),
   cod_condizione_occupazionale_default  varchar(2),
   flg_disabilita_default                varchar(1),
   flg_svantaggio_abitativo_default      varchar(1)
);

alter table serse_d_sport_monitoraggio
   add constraint pk_serse_d_sport_monitoraggio
   primary key (id_reg_comport_pso_sport);

comment on column serse_d_sport_monitoraggio.flg_livello_istruzione is 'Se = null, il dato di monitoraggio non va rilevato; se ''V'', va rilevato ed è facoltativo; se ''O'' va rilevato ed è obbligatorio';
comment on column serse_d_sport_monitoraggio.flg_condizione_occupazionale is 'Se = null, il dato di monitoraggio non va rilevato; se ''V'', va rilevato ed è facoltativo; se ''O'' va rilevato ed è obbligatorio';
comment on column serse_d_sport_monitoraggio.flg_disabilita is 'Se = null, il dato di monitoraggio non va rilevato; se ''V'', va rilevato ed è facoltativo; se ''O'' va rilevato ed è obbligatorio';
comment on column serse_d_sport_monitoraggio.flg_svantaggio_abitativo is 'Se = null, il dato di monitoraggio non va rilevato; se ''V'', va rilevato ed è facoltativo; se ''O'' va rilevato ed è obbligatorio';
comment on column serse_d_sport_monitoraggio.flg_disabilita_default is 'Valori possibili ''S'' o ''N''';
comment on column serse_d_sport_monitoraggio.flg_svantaggio_abitativo_default is 'Valori possibili ''S'' o ''N''';

create table if not exists serse_d_stato_incontro
(
   id_stato_incontro     numeric(3)     not null,
   descr_stato_incontro  varchar(150)   not null
);

alter table serse_d_stato_incontro
   add constraint pk_serse_d_stato_incontro
   primary key (id_stato_incontro);

create table if not exists serse_d_stato_intervento
(
   id_stato_intervento     numeric(3)     not null,
   descr_stato_intervento  varchar(150)   not null
);

alter table serse_d_stato_intervento
   add constraint pk_serse_d_stato_intervento
   primary key (id_stato_intervento);

create table if not exists serse_d_stato_modello_di_intervento
(
   id_stato_modello_di_intervento     numeric(3)     not null,
   descr_stato_modello_di_intervento  varchar(150)   not null
);

alter table serse_d_stato_modello_di_intervento
   add constraint pk_serse_d_stato_modello_di_intervento
   primary key (id_stato_modello_di_intervento);

create table if not exists serse_d_stato_servizio
(
   id_stato_servizio     numeric(3)     not null,
   descr_stato_servizio  varchar(150)   not null
);

alter table serse_d_stato_servizio
   add constraint pk_serse_d_stato_servizio
   primary key (id_stato_servizio);

create table if not exists serse_d_target_destinatario
(
   id_target_destinatario     integer        not null,
   descr_target_destinatario  varchar(150)   not null
);

alter table serse_d_target_destinatario
   add constraint pk_serse_d_target_destinatario
   primary key (id_target_destinatario);

create table if not exists serse_d_tipo_intervento
(
   cod_tipo_intervento            varchar(2)     not null,
   descr_tipo_intervento          varchar(200)   not null,
   flg_progettazione_individuale  varchar(1)
);

alter table serse_d_tipo_intervento
   add constraint pk_serse_d_tipo_intervento
   primary key (cod_tipo_intervento);

create table if not exists serse_d_tipo_modello
(
   cod_tipo_modello               varchar(2)     not null,
   descr_tipo_modello             varchar(200)   not null,
   flg_progettazione_individuale  varchar(1),
   flg_modello_standard           char(40)
);

alter table serse_d_tipo_modello
   add constraint pk_serse_d_tipo_modello
   primary key (cod_tipo_modello);

create table if not exists serse_d_tipo_richiesta_gam
(
   cod_tipo_richiesta_gam  varchar(2)     not null,
   nome_servizio           varchar(50)    not null,
   descr_servizio          varchar(500)   not null,
   link_funzionalita       varchar(200)
);

alter table serse_d_tipo_richiesta_gam
   add constraint pk_serse_d_tipo_richiesta_gam
   primary key (cod_tipo_richiesta_gam);

comment on column serse_d_tipo_richiesta_gam.link_funzionalita is 'Link logico alla funzionalita'' interessata dalla richiesta per visualizzarne l''esito';

create table if not exists serse_d_voce_spesa
(
   cod_voce_spesa    varchar(4)     not null,
   descr_voce_spesa  varchar(200)   not null,
   cod_natura_spesa  varchar(2)     not null
);

alter table serse_d_voce_spesa
   add constraint pk_serse_d_voce_spesa
   primary key (cod_voce_spesa);

comment on column serse_d_voce_spesa.cod_natura_spesa is 'Può valere ''PB'' (Pubblica) o ''PR'' (Privata)';

create table if not exists serse_r_destinatario_servizio
(
   id_destinatario_servizio   integer        not null,
   id_servizio                integer        not null,
   id_destinatario            integer        not null,
   id_ente_convolto_servizio  integer,
   valore_dato_peculiare_1    varchar(500),
   valore_dato_peculiare_2    varchar(500),
   cod_user_inserim           varchar(16)    not null,
   d_inserim                  timestamp      not null,
   cod_user_aggiorn           varchar(16)    not null,
   d_aggiorn                  timestamp      not null,
   numerazione_destinatario   numeric(3)     not null
);

alter table serse_r_destinatario_servizio
   add constraint pk_serse_r_destinatario_servizio
   primary key (id_destinatario_servizio);

create unique index ak_serse_r_destinatario_servizio_01 ON serse_r_destinatario_servizio USING btree (id_servizio, id_destinatario);

create index if not exists ie_serse_r_destinatario_servizio_01 ON serse_r_destinatario_servizio USING btree (id_destinatario);

create index if not exists ie_serse_r_destinatario_servizio_02 ON serse_r_destinatario_servizio USING btree (id_ente_convolto_servizio);



comment on column serse_r_destinatario_servizio.valore_dato_peculiare_1 is 'Valore del dato_peculiare_1 corrispondente al campo spacificato in serse_d_reg_comport_pso_sport.label_dato_peculiare_1';
comment on column serse_r_destinatario_servizio.valore_dato_peculiare_2 is 'Valore del dato_peculiare_2 corrispondente al campo spacificato in serse_d_reg_comport_pso_sport.label_dato_peculiare_2';
comment on column serse_r_destinatario_servizio.numerazione_destinatario is 'Numero identificativo del destinatario all''interno del Servizio';

create table if not exists serse_r_destinatario_servizio_monitoraggio
(
   id_destinatario_servizio      integer       not null,
   cod_livello_istruzione        varchar(2),
   cod_condizione_occupazionale  varchar(2),
   flg_disabilita                varchar(1),
   flg_svantaggio_abitativo      varchar(1),
   cod_user_inserim              varchar(16)   not null,
   d_inserim                     timestamp     not null,
   cod_user_aggiorn              varchar(16)   not null,
   d_aggiorn                     timestamp     not null,
   cod_cittadinanza              varchar(3)    not null
);

alter table serse_r_destinatario_servizio_monitoraggio
   add constraint pk_serse_r_destinatario_servizio_monitoraggio
   primary key (id_destinatario_servizio);

create table if not exists serse_r_incontro_destinatario_servizio
(
   id_incontro                integer        not null,
   id_destinatario_servizio   integer        not null,
   id_ente_convolto_servizio  integer,
   ore_presenza               numeric(4,1),
   cod_user_inserim           varchar(16)    not null,
   d_inserim                  timestamp      not null,
   cod_user_aggiorn           varchar(16)    not null,
   d_aggiorn                  timestamp      not null
);

alter table serse_r_incontro_destinatario_servizio
   add constraint pk_serse_r_incontro_destinatario_servizio
   primary key (id_incontro, id_destinatario_servizio);

create index if not exists ie_serse_r_incontro_destinatario_servizio_01 ON serse_r_incontro_destinatario_servizio USING btree (id_destinatario_servizio);

create index if not exists ie_serse_r_incontro_destinatario_servizio_02 ON serse_r_incontro_destinatario_servizio USING btree (id_ente_convolto_servizio);

create table if not exists serse_r_modello_intervento_pso_caratteristica
(
   id_modello_di_intervento  integer     not null,
   id_pso                    integer     not null,
   id_caratteristica         integer     not null,
   d_inizio                  timestamp   not null,
   d_fine                    timestamp
);

alter table serse_r_modello_intervento_pso_caratteristica
   add constraint pk_serse_r_modello_intervento_pso_caratteristica
   primary key (id_modello_di_intervento, id_pso, id_caratteristica);

create index if not exists ie_serse_r_modello_intervento_pso_caratteristica_01 ON serse_r_modello_intervento_pso_caratteristica USING btree (id_pso, id_caratteristica);

create table if not exists serse_r_modello_intervento_pso_target_destinatario
(
   id_modello_di_intervento  integer     not null,
   id_pso                    integer     not null,
   id_target_destinatario    integer     not null,
   d_inizio                  timestamp   not null,
   d_fine                    timestamp
);

alter table serse_r_modello_intervento_pso_target_destinatario
   add constraint pk_serse_r_modello_intervento_pso_target_destinatario
   primary key (id_modello_di_intervento, id_pso, id_target_destinatario);

create index if not exists ie_serse_r_modello_intervento_pso_target_destinatario_01 ON serse_r_modello_intervento_pso_target_destinatario USING btree (id_pso, id_target_destinatario);

create table if not exists serse_r_pso_caratteristica
(
   id_pso             integer     not null,
   id_caratteristica  integer     not null,
   d_inizio           timestamp   not null,
   d_fine             timestamp
);

alter table serse_r_pso_caratteristica
   add constraint pk_serse_r_pso_caratteristica
   primary key (id_pso, id_caratteristica);

create index if not exists ie_serse_r_pso_caratteristica_01 ON serse_r_pso_caratteristica USING btree (id_caratteristica);

create table if not exists serse_r_pso_classif_servizio_regionale
(
   id_pso                 integer     not null,
   id_classificazione     integer     not null,
   id_servizio_regionale  integer     not null,
   d_inizio               timestamp   not null,
   d_fine                 timestamp
);

alter table serse_r_pso_classif_servizio_regionale
   add constraint pk_serse_r_pso_classif_servizio_regionale
   primary key (id_pso, id_classificazione, id_servizio_regionale);

create table if not exists serse_r_pso_classificazione
(
   id_pso              integer     not null,
   id_classificazione  integer     not null,
   d_inizio            timestamp   not null,
   d_fine              timestamp
);

alter table serse_r_pso_classificazione
   add constraint pk_serse_r_pso_classificazione
   primary key (id_pso, id_classificazione);

create index if not exists ie_serse_r_pso_classificazione_01 ON serse_r_pso_classificazione USING btree (id_classificazione);

create table if not exists serse_r_pso_fonte_dato
(
   id_pso         integer      not null,
   id_fonte_dato  numeric(3)   not null,
   d_inizio       timestamp    not null,
   d_fine         timestamp
);

alter table serse_r_pso_fonte_dato
   add constraint pk_serse_r_pso_fonte_dato
   primary key (id_pso, id_fonte_dato);

create table if not exists serse_r_pso_target_destinatario
(
   id_pso                  integer     not null,
   id_target_destinatario  integer     not null,
   d_inizio                timestamp   not null,
   d_fine                  timestamp
);

alter table serse_r_pso_target_destinatario
   add constraint pk_serse_r_pso_target_destinatario
   primary key (id_pso, id_target_destinatario);

create index if not exists ie_serse_r_pso_target_destinatario_01 ON serse_r_pso_target_destinatario USING btree (id_target_destinatario);

create table if not exists serse_r_pso_tipo_intervento
(
   id_pso               integer      not null,
   cod_tipo_intervento  varchar(2)   not null,
   d_inizio             timestamp    not null,
   d_fine               timestamp
);

alter table serse_r_pso_tipo_intervento
   add constraint pk_serse_r_pso_tipo_intervento
   primary key (id_pso, cod_tipo_intervento);

create index if not exists ie_serse_r_pso_tipo_intervento_01 ON serse_r_pso_tipo_intervento USING btree (cod_tipo_intervento);

create table if not exists serse_r_pso_tipo_modello
(
   id_pso            integer      not null,
   cod_tipo_modello  varchar(2)   not null,
   d_inizio          timestamp    not null,
   d_fine            timestamp
);

alter table serse_r_pso_tipo_modello
   add constraint pk_serse_r_pso_tipo_modello
   primary key (id_pso, cod_tipo_modello);

create index if not exists ie_serse_r_pso_tipo_modello_01 ON serse_r_pso_tipo_modello USING btree (cod_tipo_modello);

create table if not exists serse_r_pso_voce_spesa
(
   id_pso          integer      not null,
   cod_voce_spesa  varchar(4)   not null,
   d_inizio        timestamp    not null,
   d_fine          timestamp
);

alter table serse_r_pso_voce_spesa
   add constraint pk_serse_r_pso_voce_spesa
   primary key (id_pso, cod_voce_spesa);

create table if not exists serse_r_servizio_fonte
(
   id_servizio          integer         not null,
   id_fonte             integer         not null,
   descr_fonte          varchar(100)    not null,
   cod_tipologia_fonte  varchar(2)      not null,
   importo_fonte        numeric(13,2)   not null,
   perc_fonte           numeric(8,5)    not null,
   cod_user_inserim     varchar(16)     not null,
   d_inserim            timestamp       not null,
   cod_user_aggiorn     varchar(16)     not null,
   d_aggiorn            timestamp       not null
);

alter table serse_r_servizio_fonte
   add constraint pk_serse_r_servizio_fonte
   primary key (id_servizio, id_fonte);

comment on column serse_r_servizio_fonte.cod_tipologia_fonte is 'Puo'' valere ''PB'' (Pubblica) o ''PR'' (Privata)';

create table if not exists serse_r_servizio_pso_caratteristica
(
   id_servizio        integer     not null,
   id_pso             integer     not null,
   id_caratteristica  integer     not null,
   d_inizio           timestamp   not null,
   d_fine             timestamp
);

alter table serse_r_servizio_pso_caratteristica
   add constraint pk_serse_r_servizio_pso_caratteristica
   primary key (id_servizio, id_pso, id_caratteristica);

create table if not exists serse_r_servizio_pso_target_destinatario
(
   id_servizio             integer       not null,
   id_pso                  integer       not null,
   id_target_destinatario  integer       not null,
   cod_user_inserim        varchar(16)   not null,
   d_inserim               timestamp     not null,
   cod_user_aggiorn        varchar(16)   not null,
   d_aggiorn               timestamp     not null
);

alter table serse_r_servizio_pso_target_destinatario
   add constraint pk_serse_r_servizio_pso_target_destinatario
   primary key (id_servizio, id_pso, id_target_destinatario);

create table if not exists serse_r_servizio_voce_spesa
(
   id_servizio          integer         not null,
   id_pso               integer         not null,
   cod_voce_spesa       varchar(4)      not null,
   cod_natura_spesa     varchar(2)      not null,
   parametro_economico  numeric(11,2),
   parametro_fisico     numeric(3),
   parametro_temporale  numeric(7,2),
   importo_voce_spesa   numeric(13,2),
   cod_user_inserim     varchar(16)     not null,
   d_inserim            timestamp       not null,
   cod_user_aggiorn     varchar(16)     not null,
   d_aggiorn            timestamp       not null
);

alter table serse_r_servizio_voce_spesa
   add constraint pk_serse_r_servizio_voce_spesa
   primary key (id_servizio, id_pso, cod_voce_spesa);

create index if not exists ie_serse_r_servizio_voce_spesa_01 ON serse_r_servizio_voce_spesa USING btree (id_pso, cod_voce_spesa);



comment on column serse_r_servizio_voce_spesa.cod_natura_spesa is 'Puo'' valere ''PB'' (Pubblica) o ''PR'' (Privata)';

create table if not exists serse_t_destinatario
(
   id_destinatario               integer        not null,
   cf_destinatario               varchar(16),
   flg_forzatura_ctrl_cf         varchar(1),
   cognome_destinatario          varchar(100),
   nome_destinatario             varchar(100),
   d_nascita                     timestamp      not null,
   cod_istat_comune_nascita      varchar(6),
   cod_stato_estero_nascita      numeric(3),
   descr_citta_estera_nascita    varchar(100),
   cod_istat_comune_residenza    varchar(6),
   cod_stato_estero_residenza    numeric(3),
   descr_citta_estera_residenza  varchar(100),
   indirizzo_residenza           varchar(100),
   cap_residenza                 numeric(5),
   cod_istat_comune_domicilio    varchar(6),
   indirizzo_domicilio           varchar(100),
   cap_domicilio                 numeric(5),
   recapito_email                varchar(100),
   recapito_telefonico           varchar(50),
   cod_cittadinanza              varchar(3),
   gruppo_operatore_inserimento  varchar(1)     not null,
   cod_operatore_inserimento     numeric(5)     not null,
   gruppo_operatore_modifica     varchar(1)     not null,
   cod_operatore_modifica        numeric(5)     not null,
   cod_user_inserim              varchar(16)    not null,
   d_inserim                     timestamp      not null,
   cod_user_aggiorn              varchar(16)    not null,
   d_aggiorn                     timestamp      not null
);

alter table serse_t_destinatario
   add constraint pk_serse_t_destinatario
   primary key (id_destinatario);

create unique index ak_serse_t_destinatario_01 ON serse_t_destinatario USING btree (cf_destinatario);

create index if not exists ie_serse_t_destinatario_02 ON serse_t_destinatario USING btree (gruppo_operatore_inserimento, cod_operatore_inserimento);

create index if not exists ie_serse_t_destinatario_03 ON serse_t_destinatario USING btree (gruppo_operatore_modifica, cod_operatore_modifica);



comment on column serse_t_destinatario.flg_forzatura_ctrl_cf is 'Se = ''S'' indica che l''utente ha forzato il controllo di congruenza sul codice fiscale';
comment on column serse_t_destinatario.gruppo_operatore_inserimento is 'Gruppo dell''Operatore a cui appartiene l''utente che ha inserito l''Anagrafica';
comment on column serse_t_destinatario.cod_operatore_inserimento is 'Codice dell''Operatore a cui appartiene l''utente che ha inserito l''Anagrafica';
comment on column serse_t_destinatario.gruppo_operatore_modifica is 'Gruppo dell''Operatore a cui appartiene l''utente che ha modificato l''Anagrafica';
comment on column serse_t_destinatario.cod_operatore_modifica is 'Codice dell''Operatore a cui appartiene l''utente che ha modificato l''Anagrafica';

create table if not exists serse_t_destinatario_bck20250326
(
   id_destinatario               integer,
   cf_destinatario               varchar(16),
   flg_forzatura_ctrl_cf         varchar(1),
   cognome_destinatario          varchar(100),
   nome_destinatario             varchar(100),
   d_nascita                     timestamp,
   cod_istat_comune_nascita      varchar(6),
   cod_stato_estero_nascita      numeric(3),
   descr_citta_estera_nascita    varchar(100),
   cod_istat_comune_residenza    varchar(6),
   cod_stato_estero_residenza    numeric(3),
   descr_citta_estera_residenza  varchar(100),
   indirizzo_residenza           varchar(100),
   cap_residenza                 numeric(5),
   cod_istat_comune_domicilio    varchar(6),
   indirizzo_domicilio           varchar(100),
   cap_domicilio                 numeric(5),
   recapito_email                varchar(100),
   recapito_telefonico           varchar(50),
   cod_cittadinanza              varchar(3),
   gruppo_operatore_inserimento  varchar(1),
   cod_operatore_inserimento     numeric(5),
   gruppo_operatore_modifica     varchar(1),
   cod_operatore_modifica        numeric(5),
   cod_user_inserim              varchar(16),
   d_inserim                     timestamp,
   cod_user_aggiorn              varchar(16),
   d_aggiorn                     timestamp
);

create table if not exists serse_t_ente_coinvolto_intervento
(
   id_ente_coinvolto_intervento   integer        not null,
   id_intervento                  integer        not null,
   id_pso                         integer,
   id_fonte_dato                  numeric(3),
   id_ente_coinvolto_modello      integer,
   denominazione                  varchar(250),
   denominazione_sede_principale  varchar(250),
   codice_1_soggetto              varchar(20),
   codice_2_soggetto              varchar(20),
   indirizzo                      varchar(100),
   cod_istat_comune               varchar(6),
   referente_nome                 varchar(100),
   referente_cognome              varchar(100),
   referente_email                varchar(100),
   referente_telefono             varchar(50),
   cod_user_inserim               varchar(16)    not null,
   d_inserim                      timestamp      not null,
   cod_user_aggiorn               varchar(16)    not null,
   d_aggiorn                      timestamp      not null
);

alter table serse_t_ente_coinvolto_intervento
   add constraint pk_serse_t_ente_coinvolto_intervento
   primary key (id_ente_coinvolto_intervento);

create index if not exists ie_serse_t_ente_coinvolto_intervento_01 ON serse_t_ente_coinvolto_intervento USING btree (id_intervento);

create index if not exists ie_serse_t_ente_coinvolto_intervento_02 ON serse_t_ente_coinvolto_intervento USING btree (id_pso, id_fonte_dato);

create index if not exists ie_serse_t_ente_coinvolto_intervento_03 ON serse_t_ente_coinvolto_intervento USING btree (id_ente_coinvolto_modello);

create index if not exists ie_serse_t_ente_coinvolto_intervento_04 ON serse_t_ente_coinvolto_intervento USING btree (cod_istat_comune);

create table if not exists serse_t_ente_coinvolto_modello
(
   id_ente_coinvolto_modello      integer        not null,
   denominazione                  varchar(250)   not null,
   denominazione_sede_principale  varchar(250),
   id_pso                         integer,
   id_fonte_dato                  numeric(3),
   codice_1_soggetto              varchar(20),
   codice_2_soggetto              varchar(20),
   id_ruolo_ente                  numeric(2)     not null,
   indirizzo                      varchar(100)   not null,
   cod_istat_comune               varchar(6)     not null,
   referente_nome                 varchar(100),
   referente_cognome              varchar(100),
   referente_email                varchar(100),
   referente_telefono             varchar(50),
   id_modello_di_intervento       integer        not null,
   d_cessazione                   timestamp,
   cod_user_cessazione            varchar(16),
   cod_user_inserim               varchar(16)    not null,
   d_inserim                      timestamp      not null,
   cod_user_aggiorn               varchar(16)    not null,
   d_aggiorn                      timestamp      not null
);

alter table serse_t_ente_coinvolto_modello
   add constraint pk_serse_t_ente_coinvolto_modello
   primary key (id_ente_coinvolto_modello);

create index if not exists ie_serse_t_ente_coinvolto_modello_01 ON serse_t_ente_coinvolto_modello USING btree (id_pso, id_fonte_dato);

create index if not exists ie_serse_t_ente_coinvolto_modello_02 ON serse_t_ente_coinvolto_modello USING btree (id_ruolo_ente);

create index if not exists ie_serse_t_ente_coinvolto_modello_03 ON serse_t_ente_coinvolto_modello USING btree (cod_istat_comune);

create index if not exists ie_serse_t_ente_coinvolto_modello_04 ON serse_t_ente_coinvolto_modello USING btree (id_modello_di_intervento);

create table if not exists serse_t_ente_coinvolto_servizio
(
   id_ente_convolto_servizio      integer        not null,
   id_servizio                    integer        not null,
   id_pso                         integer,
   id_fonte_dato                  numeric(3),
   id_ente_coinvolto_intervento   integer,
   denominazione                  varchar(250),
   denominazione_sede_principale  varchar(250),
   codice_1_soggetto              varchar(20),
   codice_2_soggetto              varchar(20),
   indirizzo                      varchar(100),
   cod_istat_comune               varchar(6),
   referente_nome                 varchar(100),
   referente_cognome              varchar(100),
   referente_email                varchar(100),
   referente_telefono             varchar(50),
   cod_user_inserim               varchar(16)    not null,
   d_inserim                      timestamp      not null,
   cod_user_aggiorn               varchar(16)    not null,
   d_aggiorn                      timestamp      not null
);

alter table serse_t_ente_coinvolto_servizio
   add constraint pk_serse_t_ente_coinvolto_servizio
   primary key (id_ente_convolto_servizio);

create index if not exists ie_serse_t_ente_coinvolto_servizio_01 ON serse_t_ente_coinvolto_servizio USING btree (id_servizio);

create index if not exists ie_serse_t_ente_coinvolto_servizio_02 ON serse_t_ente_coinvolto_servizio USING btree (id_pso, id_fonte_dato);

create index if not exists ie_serse_t_ente_coinvolto_servizio_03 ON serse_t_ente_coinvolto_servizio USING btree (id_ente_coinvolto_intervento);

create index if not exists ie_serse_t_ente_coinvolto_servizio_04 ON serse_t_ente_coinvolto_servizio USING btree (cod_istat_comune);

create table if not exists serse_t_incontro
(
   id_incontro         integer         not null,
   titolo_incontro     varchar(250)    not null,
   id_servizio         integer         not null,
   d_inizio            timestamp       not null,
   d_fine              timestamp       not null,
   durata_ore          numeric(4,1),
   referente_nome      varchar(100)    not null,
   referente_cognome   varchar(100)    not null,
   referente_email     varchar(100)    not null,
   referente_telefono  varchar(50)     not null,
   note                varchar(4000),
   id_luogo_incontro   integer,
   id_stato_incontro   numeric(3)      DEFAULT 10 not null,
   cod_user_chiusura   varchar(16),
   d_chiusura          timestamp,
   cod_user_inserim    varchar(16)     not null,
   d_inserim           timestamp       not null,
   cod_user_aggiorn    varchar(16)     not null,
   d_aggiorn           timestamp       not null
);

alter table serse_t_incontro
   add constraint pk_serse_t_incontro
   primary key (id_incontro);

create index if not exists ie_serse_t_incontro_01 ON serse_t_incontro USING btree (id_servizio);

create index if not exists ie_serse_t_incontro_02 ON serse_t_incontro USING btree (id_luogo_incontro);

create index if not exists ie_serse_t_incontro_03 ON serse_t_incontro USING btree (id_stato_incontro);



comment on column serse_t_incontro.cod_user_chiusura is 'CF della persona che ha effettuato la chiusura dell''incontro per conto del soggetto attuatore proprietario del servizio.';
comment on column serse_t_incontro.d_chiusura is 'Data di chiusura dell''incontro';

create table if not exists serse_t_intervento
(
   id_intervento               integer         not null,
   titolo_intervento           varchar(100)    not null,
   descr_sintetica_intervento  varchar(2000),
   id_pso                      integer         not null,
   cod_tipo_intervento         varchar(2)      not null,
   id_stato_intervento         numeric(3)      not null,
   id_soggetto_attuatore       integer         not null,
   id_modello_di_intervento    integer,
   referente_nome              varchar(100),
   referente_cognome           varchar(100),
   referente_email             varchar(100),
   referente_telefono          varchar(50),
   id_destinatario             integer,
   cod_user_inserim            varchar(16)     not null,
   d_inserim                   timestamp       not null,
   cod_user_aggiorn            varchar(16)     not null,
   d_aggiorn                   timestamp       not null
);

alter table serse_t_intervento
   add constraint pk_serse_t_intervento
   primary key (id_intervento);

create index if not exists ie_serse_t_intervento_01 ON serse_t_intervento USING btree (id_pso, cod_tipo_intervento);

create index if not exists ie_serse_t_intervento_02 ON serse_t_intervento USING btree (id_soggetto_attuatore);

create index if not exists ie_serse_t_intervento_03 ON serse_t_intervento USING btree (id_modello_di_intervento);

create index if not exists ie_serse_t_intervento_04 ON serse_t_intervento USING btree (id_destinatario);

create table if not exists serse_t_luogo_incontro
(
   id_luogo_incontro          integer         not null,
   id_provenienza_luogo       numeric(2),
   denominazione_luogo        varchar(250)    not null,
   indirizzo_luogo            varchar(100)    not null,
   cod_istat_comune_incontro  varchar(6)      not null,
   note                       varchar(4000),
   cod_user_inserim           varchar(16)     not null,
   d_inserim                  timestamp       not null,
   cod_user_aggiorn           varchar(16)     not null,
   d_aggiorn                  timestamp       not null
);

alter table serse_t_luogo_incontro
   add constraint pk_serse_t_luogo_incontro
   primary key (id_luogo_incontro);

create index if not exists ie_serse_t_luogo_incontro_01 ON serse_t_luogo_incontro USING btree (cod_istat_comune_incontro);

create table if not exists serse_t_modello_di_intervento
(
   id_modello_di_intervento               integer         not null,
   titolo_modello_di_intervento           varchar(100)    not null,
   descr_sintetica_modello_di_intervento  varchar(2000),
   id_pso                                 integer         not null,
   cod_tipo_modello                       varchar(2)      not null,
   id_stato_modello_di_intervento         numeric(3)      not null,
   id_soggetto_attuatore                  integer         not null,
   referente_nome                         varchar(100),
   referente_cognome                      varchar(100),
   referente_email                        varchar(100),
   referente_telefono                     varchar(50),
   cod_user_inserim                       varchar(16)     not null,
   d_inserim                              timestamp       not null,
   cod_user_aggiorn                       varchar(16)     not null,
   d_aggiorn                              timestamp       not null
);

alter table serse_t_modello_di_intervento
   add constraint pk_serse_t_modello_di_intervento
   primary key (id_modello_di_intervento);

create index if not exists ie_serse_t_modello_di_intervento_01 ON serse_t_modello_di_intervento USING btree (id_pso, cod_tipo_modello);

create index if not exists ie_serse_t_modello_di_intervento_02 ON serse_t_modello_di_intervento USING btree (id_stato_modello_di_intervento);

create index if not exists ie_serse_t_modello_di_intervento_03 ON serse_t_modello_di_intervento USING btree (id_soggetto_attuatore);

create table if not exists serse_t_sede_soggetto_attuatore
(
   id_soggetto_attuatore                integer      not null,
   progressivo_sede                     numeric(3)   not null,
   cod_area_territoriale_appartenenza   varchar(2)   not null,
   cod_area_territoriale_finanziamento  varchar(2)   not null
);

alter table serse_t_sede_soggetto_attuatore
   add constraint pk_serse_t_sede_soggetto_attuatore
   primary key (id_soggetto_attuatore, progressivo_sede);

create table if not exists serse_t_servizio
(
   id_servizio                          integer        not null,
   titolo_servizio                      varchar(100)   not null,
   id_stato_servizio                    numeric(3)     not null,
   id_soggetto_attuatore                integer        not null,
   cod_area_territoriale_finanziamento  varchar(2),
   id_intervento                        integer,
   id_servizio_regionale                integer        not null,
   id_pso                               integer,
   id_classificazione                   integer,
   referente_nome                       varchar(100),
   referente_cognome                    varchar(100),
   referente_email                      varchar(100),
   referente_telefono                   varchar(50),
   durata_ore                           numeric(4,1),
   num_max_destinatari                  integer,
   d_chiusura_servizio                  timestamp,
   cod_user_inserim                     varchar(16)    not null,
   d_inserim                            timestamp      not null,
   cod_user_aggiorn                     varchar(16)    not null,
   d_aggiorn                            timestamp      not null,
   valore_dato_peculiare_1              varchar(500),
   valore_dato_peculiare_2              varchar(500),
   cod_livello_istruzione               varchar(2),
   cod_condizione_occupazionale         varchar(2),
   flg_disabilita                       varchar(1),
   flg_svantaggio_abitativo             varchar(1),
   progressivo_sede                     numeric(3),
   valore_campo_aggiuntivo_1            varchar(500)
);

alter table serse_t_servizio
   add constraint pk_serse_t_servizio
   primary key (id_servizio);

create index if not exists ie_serse_t_servizio_01 ON serse_t_servizio USING btree (id_pso, id_classificazione);

create index if not exists ie_serse_t_servizio_02 ON serse_t_servizio USING btree (id_stato_servizio);

create index if not exists ie_serse_t_servizio_03 ON serse_t_servizio USING btree (id_soggetto_attuatore);

create index if not exists ie_serse_t_servizio_04 ON serse_t_servizio USING btree (id_intervento);

create index if not exists ie_serse_t_servizio_05 ON serse_t_servizio USING btree (id_servizio_regionale);



comment on column serse_t_servizio.cod_area_territoriale_finanziamento is 'Area territoriale competente al servizio, selezionata tra le aree territoriali di finanziamento a cui afferiscono le sedi del soggetto attuatore responsabile del servizio, nell''ambito dell''istanza di candidatura selezionata';
comment on column serse_t_servizio.valore_dato_peculiare_1 is 'Valore del dato_peculiare_1 corrispondente al campo spacificato in serse_d_reg_comport_pso_sport.label_dato_peculiare_1';
comment on column serse_t_servizio.valore_dato_peculiare_2 is 'Valore del dato_peculiare_2 corrispondente al campo spacificato in serse_d_reg_comport_pso_sport.label_dato_peculiare_2';
comment on column serse_t_servizio.valore_campo_aggiuntivo_1 is 'Valore del campo_aggiuntivo_1 corrispondente al campo specificato in serse_d_reg_comport_pso_sport.label_campo_aggiuntivo_1';

create table if not exists serse_t_servizio_modello
(
   id_servizio_modello            integer         not null,
   id_modello_di_intervento       integer         not null,
   id_servizio_regionale          integer,
   titolo_servizio_esterno        varchar(100),
   descrizione_servizio_esterno   varchar(2000),
   cod_finalita_servizio_esterno  varchar(1),
   durata_in_ore                  numeric(4,1),
   riferimento_attore_esterno     varchar(250),
   referente_nome                 varchar(100),
   referente_cognome              varchar(100),
   referente_email                varchar(100),
   referente_telefono             varchar(50),
   cod_user_inserim               varchar(16)     not null,
   d_inserim                      timestamp       not null,
   cod_user_aggiorn               varchar(16)     not null,
   d_aggiorn                      timestamp       not null
);

alter table serse_t_servizio_modello
   add constraint pk_serse_t_servizio_modello
   primary key (id_servizio_modello);

create index if not exists ie_serse_t_servizio_modello_01 ON serse_t_servizio_modello USING btree (id_modello_di_intervento);

create index if not exists ie_serse_t_servizio_modello_02 ON serse_t_servizio_modello USING btree (id_servizio_regionale);

create index if not exists ie_serse_t_servizio_modello_03 ON serse_t_servizio_modello USING btree (cod_finalita_servizio_esterno);



comment on column serse_t_servizio_modello.riferimento_attore_esterno is 'Attore esterno di riferimento per la Tipologia di Servizio Esterno agganciato al Modello';

create table if not exists serse_t_servizio_sto
(
   id_servizio_sto        integer         not null,
   id_servizio            integer         not null,
   tipo_variazione        varchar(1)      not null,
   utente_variazione      varchar(16)     not null,
   d_variazione           timestamp       not null,
   preventivo_precedente  numeric(13,2)   not null
);

alter table serse_t_servizio_sto
   add constraint pk_serse_t_servizio_sto
   primary key (id_servizio_sto);

create index if not exists ie_serse_t_servizio_sto_01 ON serse_t_servizio_sto USING btree (id_servizio);



comment on column serse_t_servizio_sto.tipo_variazione is 'Può valere ''A'' (Aumento) o ''R'' (Riduzione) o ''I'' (Invariata)';

create table if not exists serse_t_soggetto_attuatore
(
   id_soggetto_attuatore  integer       not null,
   model_id               numeric(9)    not null,
   num_progr_sportello    numeric       not null,
   gruppo_operatore       varchar(1)    not null,
   cod_operatore          numeric(5)    not null,
   flg_capofila           varchar(1),
   cod_user_inserim       varchar(16)   not null,
   d_inserim              timestamp     not null,
   cod_user_aggiorn       varchar(16)   not null,
   d_aggiorn              timestamp     not null
);

alter table serse_t_soggetto_attuatore
   add constraint pk_serse_t_soggetto_attuatore
   primary key (id_soggetto_attuatore);

alter table serse_t_soggetto_attuatore
   add constraint ak_serse_t_soggetto_attuatore_01 UNIQUE (model_id, flg_capofila);

create index if not exists ie_serse_t_soggetto_attuatore_01 ON serse_t_soggetto_attuatore USING btree (model_id);

create index if not exists ie_serse_t_soggetto_attuatore_02 ON serse_t_soggetto_attuatore USING btree (num_progr_sportello);

create index if not exists ie_serse_t_soggetto_attuatore_03 ON serse_t_soggetto_attuatore USING btree (gruppo_operatore, cod_operatore);

create table if not exists serse_t_token_gam
(
   id_token_gam                       integer         not null,
   id_servizio                        integer,
   id_incontro                        integer,
   xml_richiesta                      text            not null,
   cod_tipo_richiesta_gam             varchar(2)      not null,
   id_token_elab_gam                  integer,
   cod_stato_richiesta                varchar(20)     not null,
   descr_stato_richiesta              varchar(500)    not null,
   d_invio_richiesta                  timestamp       not null,
   utente_invio_richiesta             varchar(16)     not null,
   durata_ore_proposta                numeric(4,1),
   num_max_destinatari_proposto       integer,
   cod_stato_elaborazione             varchar(2),
   cod_esito_elaborazione             varchar(20),
   descr_esito_elaborazione           varchar(500),
   d_elaborazione                     timestamp,
   xml_risposta_elaborazione          text,
   importo_finanziato_precedente      numeric(13,2),
   cod_tipo_variazione_finanziamento  varchar(1),
   d_visualizzazione_notifica         timestamp,
   cod_user_inserim                   varchar(16)     not null,
   d_user_inserim                     timestamp       not null,
   cod_user_aggiorn                   varchar(16)     not null,
   d_aggiorn                          timestamp       not null
);

alter table serse_t_token_gam
   add constraint pk_serse_t_token_gam
   primary key (id_token_gam);

create index if not exists ie_serse_t_token_gam_01 ON serse_t_token_gam USING btree (id_servizio);

create index if not exists ie_serse_t_token_gam_02 ON serse_t_token_gam USING btree (id_incontro);



comment on column serse_t_token_gam.id_token_elab_gam is 'Identificativo del token restituito dal sistema GAM a seguito della chiamata del Servizio';
comment on column serse_t_token_gam.cod_tipo_variazione_finanziamento is 'Vale ''A'' per Aumento, ''R'' per Riduzione o ''I'' per Invariata';
comment on column serse_t_token_gam.d_visualizzazione_notifica is 'Data e ora in cui l''utente ha dichiarato di aver visualizzato la notifica, per non mostrarla piu'' negli accessi successivi';

create table if not exists sispro_w_punto_erogazione_attivo
(
   id_transazione       numeric(10)    not null,
   cod_reg_scuola       varchar(10)    not null,
   data_transazione     timestamp      not null,
   cod_reg_istituz      varchar(10),
   cod_scuola           varchar(10),
   cod_istituz          varchar(10),
   id_scuola            numeric(10)    not null,
   id_scuola_origine    numeric(10),
   denominazione        varchar(250)   not null,
   cod_istat_provincia  varchar(3)     not null,
   cod_istat_comune     varchar(6)     not null,
   indirizzo            varchar(250)   not null,
   cap                  varchar(5),
   frazione             varchar(100),
   localita             varchar(100),
   email                varchar(100),
   telefono             varchar(100),
   fax                  varchar(100),
   sito_web             varchar(100),
   id_grado_scolastico  varchar(1),
   id_tipologia         numeric(1),
   id_tipo_istituz      numeric(1),
   id_percorso          numeric(2),
   id_tipo_sezione      numeric(1),
   id_tipo_unita        numeric(2),
   d_apertura           timestamp      not null,
   d_chiusura           timestamp,
   d_modifica           timestamp,
   flag_aperta          varchar(1),
   id_anno_scolastico   numeric(3)
);

alter table sispro_w_punto_erogazione_attivo
   add constraint pk_sispro_w_punto_erogazione_attivo
   primary key (id_transazione, cod_reg_scuola);

comment on column sispro_w_punto_erogazione_attivo.id_transazione is 'Progressivo univoco che identifica la transazione';
comment on column sispro_w_punto_erogazione_attivo.cod_reg_scuola is 'Codice regionale del punto di erogazione (es.: 0012724373). Identifica univocamente la scuola';
comment on column sispro_w_punto_erogazione_attivo.data_transazione is 'Data di comunicazione dei punti di erogazione';
comment on column sispro_w_punto_erogazione_attivo.cod_reg_istituz is 'Codice regionale dell''autonomia (es.: 001272A241).';
comment on column sispro_w_punto_erogazione_attivo.cod_scuola is 'Codice meccanografico del punto di erogazione (es.: TOPM018018)';
comment on column sispro_w_punto_erogazione_attivo.cod_istituz is 'Codice meccanografico dell''autonomia di riferimento (es.: TOIS01800R)';
comment on column sispro_w_punto_erogazione_attivo.id_scuola is 'Id informatico del punto di erogazione';
comment on column sispro_w_punto_erogazione_attivo.id_scuola_origine is 'Id informatico del punto di erogazione nell''anno scolastico precedente';
comment on column sispro_w_punto_erogazione_attivo.denominazione is 'Denominazione dell''Istituto scolastico';
comment on column sispro_w_punto_erogazione_attivo.cod_istat_provincia is 'Codice istat della provincia';
comment on column sispro_w_punto_erogazione_attivo.cod_istat_comune is 'Codice istat del comune';
comment on column sispro_w_punto_erogazione_attivo.indirizzo is 'Indirizzo del punto di erogazione';
comment on column sispro_w_punto_erogazione_attivo.cap is 'Codice di avviamento postale';
comment on column sispro_w_punto_erogazione_attivo.frazione is 'Frazione';
comment on column sispro_w_punto_erogazione_attivo.localita is 'Localita''';
comment on column sispro_w_punto_erogazione_attivo.email is 'Indirizzo email';
comment on column sispro_w_punto_erogazione_attivo.telefono is 'Recapito telefonico';
comment on column sispro_w_punto_erogazione_attivo.fax is 'Fax';
comment on column sispro_w_punto_erogazione_attivo.sito_web is 'Url del sito di riferimento';
comment on column sispro_w_punto_erogazione_attivo.id_grado_scolastico is 'Grado scolastico istituto (es. SECONDARIA II GRADO)';
comment on column sispro_w_punto_erogazione_attivo.id_tipologia is 'Tipologia istituto (es. NON STATALE PARITARIA)';
comment on column sispro_w_punto_erogazione_attivo.id_tipo_istituz is 'Tipo istituzione (es.: LICEO)';
comment on column sispro_w_punto_erogazione_attivo.id_percorso is 'Detaglio del tipo istituzione (es.: LICEO SCIENTIFICO)';
comment on column sispro_w_punto_erogazione_attivo.id_tipo_sezione is 'Tipo sezione (es.: DIURNA)';
comment on column sispro_w_punto_erogazione_attivo.id_tipo_unita is 'Tipo unita'' (es.: SEDE CENTRALE)';
comment on column sispro_w_punto_erogazione_attivo.d_apertura is 'Data apertura punto di erogazione';
comment on column sispro_w_punto_erogazione_attivo.d_chiusura is 'Data chiusura punto di erogazione';
comment on column sispro_w_punto_erogazione_attivo.d_modifica is 'Data ultima modifica';
comment on column sispro_w_punto_erogazione_attivo.id_anno_scolastico is 'Anno scolastico di riferimento (es. 92 corrispondente a 2023/2024)';

create table if not exists sispro_w_punto_erogazione_chiuso
(
   id_transazione    numeric(10)   not null,
   cod_reg_scuola    varchar(10)   not null,
   data_transazione  timestamp     not null,
   cod_reg_istituz   varchar(10),
   cod_scuola        varchar(10),
   cod_istituz       varchar(10),
   id_scuola         numeric(10)   not null,
   d_chiusura        timestamp
);

alter table sispro_w_punto_erogazione_chiuso
   add constraint pk_sispro_w_punto_erogazione_chiuso
   primary key (id_transazione, cod_reg_scuola);

comment on column sispro_w_punto_erogazione_chiuso.id_transazione is 'Progressivo univoco che identifica la transazione';
comment on column sispro_w_punto_erogazione_chiuso.cod_reg_scuola is 'Codice regionale del punto di erogazione (es.: 0012724373). Identifica univocamente la scuola';
comment on column sispro_w_punto_erogazione_chiuso.data_transazione is 'Data di comunicazione dei punti di erogazione';
comment on column sispro_w_punto_erogazione_chiuso.cod_reg_istituz is 'Codice regionale dell''autonomia (es.: 001272A241).';
comment on column sispro_w_punto_erogazione_chiuso.cod_scuola is 'Codice meccanografico del punto di erogazione (es.: TOPM018018)';
comment on column sispro_w_punto_erogazione_chiuso.cod_istituz is 'Codice meccanografico dell''autonomia di riferimento (es.: TOIS01800R)';
comment on column sispro_w_punto_erogazione_chiuso.id_scuola is 'Id informatico del punto di erogazione';
comment on column sispro_w_punto_erogazione_chiuso.d_chiusura is 'Data chiusura punto di erogazione';

create table if not exists xtra_d_amm_resp_gam
(
   cod_ar       numeric       not null,
   descrizione  varchar(50)   not null,
   sigla_ente   varchar(40)
);

alter table xtra_d_amm_resp_gam
   add constraint pk_xtra_d_amm_resp_gam
   primary key (cod_ar);

/* --------------------------------- */
/* Modifiche per classe_destinatario */
/* --------------------------------- */

create table serse_d_classe_destinatario (
    id_classe_destinatario numeric(3)  not null,
    descr_classe_destinatario character varying(100)  not null,
    d_inizio timestamp  not null,
    d_fine timestamp,
    constraint pk_serse_d_classe_destinatario primary key (id_classe_destinatario)
);

create table serse_r_pso_classe_destinatario (
    id_pso_classe_destinatario numeric(3)  not null,
    id_pso integer  not null,
    id_classe_destinatario numeric(3)  not null,
    d_inizio timestamp  not null,
    d_fine timestamp,
    constraint pk_serse_r_pso_classe_destinatario primary key (id_pso_classe_destinatario)
);

create unique index ak_serse_r_pso_classe_destinatario_01 on serse_r_pso_classe_destinatario(id_pso, id_classe_destinatario);

alter table serse_t_servizio add id_pso_classe_destinatario NUMERIC(3);

alter table serse_r_destinatario_servizio add id_pso_classe_destinatario NUMERIC(3);

