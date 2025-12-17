SET client_min_messages TO ERROR;
SET client_encoding = 'UTF8'; 

create sequence seq_serse_r_destinatario_servizio
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_destinatario
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_ente_coinvolto_intervento
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_ente_coinvolto_modello
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_ente_coinvolto_servizio
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_incontro
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_intervento
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_luogo_incontro
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_modello_di_intervento
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_servizio
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_servizio_modello
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_servizio_sto
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_soggetto_attuatore
       increment by 1
       minvalue 1
       cache 1
       no cycle;

create sequence seq_serse_t_token_gam
       increment by 1
       minvalue 1
       cache 1
       no cycle;

