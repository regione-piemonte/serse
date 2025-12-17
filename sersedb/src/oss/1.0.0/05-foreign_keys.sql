alter table ext_bdgt_t_pso
  add constraint fk_ext_bdgt_t_tipol_pso_01 foreign key (id_atto_indirizzo, cod_tipol_pso)
  references ext_bdgt_t_tipol_pso (id_atto_indirizzo, cod_tipol_pso)
  on update no action
  on delete no action;

alter table ext_bdgt_t_pso
  add constraint fk_xtra_d_amm_resp_gam_01 foreign key (cod_ar)
  references xtra_d_amm_resp_gam (cod_ar)
  on update no action
  on delete no action;

alter table ext_bdgt_t_pso_sportello
  add constraint fk_ext_bdgt_t_pso_01 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table ext_sispro_d_percorso
  add constraint fk_ext_sispro_d_tipo_istituz_01 foreign key (id_tipo_istituz)
  references ext_sispro_d_tipo_istituz (id_tipo_istituz)
  on update no action
  on delete no action;

alter table ext_sispro_d_tipo_unita
  add constraint fk_ext_sispro_d_grado_scolastico_01 foreign key (id_grado_scolastico)
  references ext_sispro_d_grado_scolastico (id_grado_scolastico)
  on update no action
  on delete no action;

alter table ext_tt_bacino
  add constraint fk_ext_tt_provincia_02 foreign key (prov)
  references ext_tt_provincia (prov)
  on update no action
  on delete no action;

alter table ext_tt_comune
  add constraint fk_ext_tt_bacino_01 foreign key (cod_bacino)
  references ext_tt_bacino (cod_bacino)
  on update no action
  on delete no action;

alter table ext_tt_comune
  add constraint fk_ext_tt_provincia_01 foreign key (prov)
  references ext_tt_provincia (prov)
  on update no action
  on delete no action;

alter table serse_d_cpi
  add constraint fk_ext_tt_comune_08 foreign key (cod_istat_comune)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_d_istituto_scolastico
  add constraint fk_ext_sispro_d_anno_scolastico_01 foreign key (id_anno_scolastico)
  references ext_sispro_d_anno_scolastico (id_anno_scolastico)
  on update no action
  on delete no action;

alter table serse_d_istituto_scolastico
  add constraint fk_ext_sispro_d_percorso_01 foreign key (id_percorso)
  references ext_sispro_d_percorso (id_percorso)
  on update no action
  on delete no action;

alter table serse_d_istituto_scolastico
  add constraint fk_ext_sispro_d_tipo_sezione_01 foreign key (id_tipo_sezione)
  references ext_sispro_d_tipo_sezione (id_tipo_sezione)
  on update no action
  on delete no action;

alter table serse_d_istituto_scolastico
  add constraint fk_ext_sispro_d_tipo_unita_01 foreign key (id_tipo_unita)
  references ext_sispro_d_tipo_unita (id_tipo_unita)
  on update no action
  on delete no action;

alter table serse_d_istituto_scolastico
  add constraint fk_ext_sispro_d_tipologia_01 foreign key (id_tipologia)
  references ext_sispro_d_tipologia (id_tipologia)
  on update no action
  on delete no action;

alter table serse_d_istituto_scolastico
  add constraint fk_ext_tt_comune_09 foreign key (cod_comune_scuola)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_d_periodo_attivazione_servizio
  add constraint fk_ext_bdgt_t_pso_sportello_02 foreign key (num_progr_sportello)
  references ext_bdgt_t_pso_sportello (num_progr_sportello)
  on update no action
  on delete no action;

alter table serse_d_provenienza_luogo
  add constraint fk_serse_r_pso_fonte_dato_04 foreign key (id_pso, id_fonte_dato)
  references serse_r_pso_fonte_dato (id_pso, id_fonte_dato)
  on update no action
  on delete no action;

alter table serse_d_reg_comport_pso_sport
  add constraint fk_ext_bdgt_t_pso_02 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_d_reg_comport_pso_sport
  add constraint fk_ext_bdgt_t_pso_sportello_01 foreign key (num_progr_sportello)
  references ext_bdgt_t_pso_sportello (num_progr_sportello)
  on update no action
  on delete no action;

alter table serse_d_reg_comport_pso_sport
  add constraint fk_serse_d_processo_finanziamento_01 foreign key (id_processo_finanziamento)
  references serse_d_processo_finanziamento (id_processo_finanziamento)
  on update no action
  on delete no action;

alter table serse_d_reg_comport_pso_sport
  add constraint fk_serse_d_sistema_gestione_amm_01 foreign key (id_sistema_gestione_amm)
  references serse_d_sistema_gestione_amm (id_sistema_gestione_amm)
  on update no action
  on delete no action;

alter table serse_d_servizio_regionale
  add constraint fk_ext_bdgt_t_pso_10 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_d_servizio_regionale
  add constraint fk_serse_d_finalita_servizio_01 foreign key (cod_finalita_servizio)
  references serse_d_finalita_servizio (cod_finalita_servizio)
  on update no action
  on delete no action;

alter table serse_d_sport_monitoraggio
  add constraint fk_serse_d_condizione_occupazionale_03 foreign key (cod_condizione_occupazionale_default)
  references serse_d_condizione_occupazionale (cod_condizione_occupazionale)
  on update no action
  on delete no action;

alter table serse_d_sport_monitoraggio
  add constraint fk_serse_d_livello_istruzione_03 foreign key (cod_livello_istruzione_default)
  references serse_d_livello_istruzione (cod_livello_istruzione)
  on update no action
  on delete no action;

alter table serse_d_sport_monitoraggio
  add constraint fk_serse_d_reg_comport_pso_sport_01 foreign key (id_reg_comport_pso_sport)
  references serse_d_reg_comport_pso_sport (id_reg_comport_pso_sport)
  on update no action
  on delete no action;

alter table serse_r_destinatario_servizio
  add constraint fk_serse_t_destinatario_01 foreign key (id_destinatario)
  references serse_t_destinatario (id_destinatario)
  on update no action
  on delete no action;

alter table serse_r_destinatario_servizio
  add constraint fk_serse_t_ente_coinvolto_servizio_02 foreign key (id_ente_convolto_servizio)
  references serse_t_ente_coinvolto_servizio (id_ente_convolto_servizio)
  on update no action
  on delete no action;

alter table serse_r_destinatario_servizio
  add constraint fk_serse_t_servizio_01 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_r_destinatario_servizio 
  add constraint fk_serse_r_pso_classe_destinatario_02 
      foreign key (id_pso_classe_destinatario) 
      references serse_r_pso_classe_destinatario (id_pso_classe_destinatario);

alter table serse_r_destinatario_servizio_monitoraggio
  add constraint fk_serse_d_condizione_occupazionale_01 foreign key (cod_condizione_occupazionale)
  references serse_d_condizione_occupazionale (cod_condizione_occupazionale)
  on update no action
  on delete no action;

alter table serse_r_destinatario_servizio_monitoraggio
  add constraint fk_serse_d_livello_istruzione_01 foreign key (cod_livello_istruzione)
  references serse_d_livello_istruzione (cod_livello_istruzione)
  on update no action
  on delete no action;

alter table serse_r_destinatario_servizio_monitoraggio
  add constraint fk_serse_r_destinatario_servizio_02 foreign key (id_destinatario_servizio)
  references serse_r_destinatario_servizio (id_destinatario_servizio)
  on update no action
  on delete no action;

alter table serse_r_incontro_destinatario_servizio
  add constraint fk_serse_r_destinatario_servizio_01 foreign key (id_destinatario_servizio)
  references serse_r_destinatario_servizio (id_destinatario_servizio)
  on update no action
  on delete no action;

alter table serse_r_incontro_destinatario_servizio
  add constraint fk_serse_t_ente_coinvolto_servizio_01 foreign key (id_ente_convolto_servizio)
  references serse_t_ente_coinvolto_servizio (id_ente_convolto_servizio)
  on update no action
  on delete no action;

alter table serse_r_incontro_destinatario_servizio
  add constraint fk_serse_t_incontro_01 foreign key (id_incontro)
  references serse_t_incontro (id_incontro)
  on update no action
  on delete no action;

alter table serse_r_modello_intervento_pso_caratteristica
  add constraint fk_serse_r_pso_caratteristica_03 foreign key (id_pso, id_caratteristica)
  references serse_r_pso_caratteristica (id_pso, id_caratteristica)
  on update no action
  on delete no action;

alter table serse_r_modello_intervento_pso_caratteristica
  add constraint fk_serse_t_modello_di_intervento_03 foreign key (id_modello_di_intervento)
  references serse_t_modello_di_intervento (id_modello_di_intervento)
  on update no action
  on delete no action;

alter table serse_r_modello_intervento_pso_target_destinatario
  add constraint fk_serse_r_pso_target_destinatario_03 foreign key (id_pso, id_target_destinatario)
  references serse_r_pso_target_destinatario (id_pso, id_target_destinatario)
  on update no action
  on delete no action;

alter table serse_r_modello_intervento_pso_target_destinatario
  add constraint fk_serse_t_modello_di_intervento_02 foreign key (id_modello_di_intervento)
  references serse_t_modello_di_intervento (id_modello_di_intervento)
  on update no action
  on delete no action;

alter table serse_r_pso_caratteristica
  add constraint fk_ext_bdgt_t_pso_06 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_r_pso_caratteristica
  add constraint fk_serse_d_caratteristica_01 foreign key (id_caratteristica)
  references serse_d_caratteristica (id_caratteristica)
  on update no action
  on delete no action;

alter table serse_r_pso_classe_destinatario 
  add constraint fk_ext_bdgt_t_pso_11 
      foreign key (id_pso) 
      references ext_bdgt_t_pso (id_pso);

alter table serse_r_pso_classe_destinatario 
  add constraint fk_serse_d_classe_destinatario_01 
      foreign key (id_classe_destinatario) 
      references serse_d_classe_destinatario (id_classe_destinatario);

alter table serse_r_pso_classif_servizio_regionale
  add constraint fk_serse_d_servizio_regionale_03 foreign key (id_servizio_regionale)
  references serse_d_servizio_regionale (id_servizio_regionale)
  on update no action
  on delete no action;

alter table serse_r_pso_classif_servizio_regionale
  add constraint fk_serse_r_pso_classificazione_01 foreign key (id_pso, id_classificazione)
  references serse_r_pso_classificazione (id_pso, id_classificazione)
  on update no action
  on delete no action;

alter table serse_r_pso_classificazione
  add constraint fk_ext_bdgt_t_pso_07 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_r_pso_classificazione
  add constraint fk_serse_d_classificazione_01 foreign key (id_classificazione)
  references serse_d_classificazione (id_classificazione)
  on update no action
  on delete no action;

alter table serse_r_pso_fonte_dato
  add constraint fk_ext_bdgt_t_pso_08 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_r_pso_fonte_dato
  add constraint fk_serse_d_fonte_dato_01 foreign key (id_fonte_dato)
  references serse_d_fonte_dato (id_fonte_dato)
  on update no action
  on delete no action;

alter table serse_r_pso_target_destinatario
  add constraint fk_ext_bdgt_t_pso_05 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_r_pso_target_destinatario
  add constraint fk_serse_d_target_destinatario_01 foreign key (id_target_destinatario)
  references serse_d_target_destinatario (id_target_destinatario)
  on update no action
  on delete no action;

alter table serse_r_pso_tipo_intervento
  add constraint fk_ext_bdgt_t_pso_04 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_r_pso_tipo_intervento
  add constraint fk_serse_d_tipo_intervento_01 foreign key (cod_tipo_intervento)
  references serse_d_tipo_intervento (cod_tipo_intervento)
  on update no action
  on delete no action;

alter table serse_r_pso_tipo_modello
  add constraint fk_ext_bdgt_t_pso_03 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_r_pso_tipo_modello
  add constraint fk_serse_d_tipo_modello_01 foreign key (cod_tipo_modello)
  references serse_d_tipo_modello (cod_tipo_modello)
  on update no action
  on delete no action;

alter table serse_r_pso_voce_spesa
  add constraint fk_ext_bdgt_t_pso_09 foreign key (id_pso)
  references ext_bdgt_t_pso (id_pso)
  on update no action
  on delete no action;

alter table serse_r_pso_voce_spesa
  add constraint fk_serse_d_voce_spesa_01 foreign key (cod_voce_spesa)
  references serse_d_voce_spesa (cod_voce_spesa)
  on update no action
  on delete no action;

alter table serse_r_servizio_fonte
  add constraint fk_serse_t_servizio_09 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_r_servizio_pso_caratteristica
  add constraint fk_serse_r_pso_caratteristica_02 foreign key (id_pso, id_caratteristica)
  references serse_r_pso_caratteristica (id_pso, id_caratteristica)
  on update no action
  on delete no action;

alter table serse_r_servizio_pso_caratteristica
  add constraint fk_serse_t_servizio_06 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_r_servizio_pso_target_destinatario
  add constraint fk_serse_r_pso_target_destinatario_02 foreign key (id_pso, id_target_destinatario)
  references serse_r_pso_target_destinatario (id_pso, id_target_destinatario)
  on update no action
  on delete no action;

alter table serse_r_servizio_pso_target_destinatario
  add constraint fk_serse_t_servizio_07 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_r_servizio_voce_spesa
  add constraint fk_serse_r_pso_voce_spesa_0 foreign key (id_pso, cod_voce_spesa)
  references serse_r_pso_voce_spesa (id_pso, cod_voce_spesa)
  on update no action
  on delete no action;

alter table serse_r_servizio_voce_spesa
  add constraint fk_serse_t_servizio_03 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_t_destinatario
  add constraint fk_ext_stati_esteri_01 foreign key (cod_stato_estero_nascita)
  references ext_stati_esteri (cod_stato)
  on update no action
  on delete no action;

alter table serse_t_destinatario
  add constraint fk_ext_stati_esteri_02 foreign key (cod_stato_estero_residenza)
  references ext_stati_esteri (cod_stato)
  on update no action
  on delete no action;

alter table serse_t_destinatario
  add constraint fk_ext_tab_cittadinanza_01 foreign key (cod_cittadinanza)
  references ext_tab_cittadinanza (cod_istat_cittadinanza)
  on update no action
  on delete no action;

alter table serse_t_destinatario
  add constraint fk_ext_tt_comune_04 foreign key (cod_istat_comune_nascita)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_t_destinatario
  add constraint fk_ext_tt_comune_05 foreign key (cod_istat_comune_residenza)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_t_destinatario
  add constraint fk_ext_tt_comune_06 foreign key (cod_istat_comune_domicilio)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_intervento
  add constraint fk_ext_tt_comune_02 foreign key (cod_istat_comune)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_intervento
  add constraint fk_serse_r_pso_fonte_dato_02 foreign key (id_pso, id_fonte_dato)
  references serse_r_pso_fonte_dato (id_pso, id_fonte_dato)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_intervento
  add constraint fk_serse_t_ente_coinvolto_modello_01 foreign key (id_ente_coinvolto_modello)
  references serse_t_ente_coinvolto_modello (id_ente_coinvolto_modello)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_intervento
  add constraint fk_serse_t_intervento_02 foreign key (id_intervento)
  references serse_t_intervento (id_intervento)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_modello
  add constraint fk_ext_tt_comune_01 foreign key (cod_istat_comune)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_modello
  add constraint fk_serse_d_ruolo_ente_0 foreign key (id_ruolo_ente)
  references serse_d_ruolo_ente (id_ruolo_ente)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_modello
  add constraint fk_serse_r_pso_fonte_dato_01 foreign key (id_pso, id_fonte_dato)
  references serse_r_pso_fonte_dato (id_pso, id_fonte_dato)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_modello
  add constraint fk_serse_t_modello_di_intervento_04 foreign key (id_modello_di_intervento)
  references serse_t_modello_di_intervento (id_modello_di_intervento)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_servizio
  add constraint fk_ext_tt_comune_03 foreign key (cod_istat_comune)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_servizio
  add constraint fk_serse_r_pso_fonte_dato_03 foreign key (id_pso, id_fonte_dato)
  references serse_r_pso_fonte_dato (id_pso, id_fonte_dato)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_servizio
  add constraint fk_serse_t_ente_coinvolto_intervento_01 foreign key (id_ente_coinvolto_intervento)
  references serse_t_ente_coinvolto_intervento (id_ente_coinvolto_intervento)
  on update no action
  on delete no action;

alter table serse_t_ente_coinvolto_servizio
  add constraint fk_serse_t_servizio_05 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_t_incontro
  add constraint fk_serse_d_stato_incontro_01 foreign key (id_stato_incontro)
  references serse_d_stato_incontro (id_stato_incontro)
  on update no action
  on delete no action;

alter table serse_t_incontro
  add constraint fk_serse_t_luogo_incontro_01 foreign key (id_luogo_incontro)
  references serse_t_luogo_incontro (id_luogo_incontro)
  on update no action
  on delete no action;

alter table serse_t_incontro
  add constraint fk_serse_t_servizio_02 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_t_intervento
  add constraint fk_serse_d_stato_intervento_01 foreign key (id_stato_intervento)
  references serse_d_stato_intervento (id_stato_intervento)
  on update no action
  on delete no action;

alter table serse_t_intervento
  add constraint fk_serse_r_pso_tipo_intervento_01 foreign key (id_pso, cod_tipo_intervento)
  references serse_r_pso_tipo_intervento (id_pso, cod_tipo_intervento)
  on update no action
  on delete no action;

alter table serse_t_intervento
  add constraint fk_serse_t_destinatario_02 foreign key (id_destinatario)
  references serse_t_destinatario (id_destinatario)
  on update no action
  on delete no action;

alter table serse_t_intervento
  add constraint fk_serse_t_modello_di_intervento_01 foreign key (id_modello_di_intervento)
  references serse_t_modello_di_intervento (id_modello_di_intervento)
  on update no action
  on delete no action;

alter table serse_t_intervento
  add constraint fk_serse_t_soggetto_attuatore_02 foreign key (id_soggetto_attuatore)
  references serse_t_soggetto_attuatore (id_soggetto_attuatore)
  on update no action
  on delete no action;

alter table serse_t_luogo_incontro
  add constraint fk_ext_tt_comune_07 foreign key (cod_istat_comune_incontro)
  references ext_tt_comune (comune)
  on update no action
  on delete no action;

alter table serse_t_luogo_incontro
  add constraint fk_serse_d_provenienza_luogo_01 foreign key (id_provenienza_luogo)
  references serse_d_provenienza_luogo (id_provenienza_luogo)
  on update no action
  on delete no action;

alter table serse_t_modello_di_intervento
  add constraint fk_serse_d_stato_modello_di_intervento_01 foreign key (id_stato_modello_di_intervento)
  references serse_d_stato_modello_di_intervento (id_stato_modello_di_intervento)
  on update no action
  on delete no action;

alter table serse_t_modello_di_intervento
  add constraint fk_serse_r_pso_tipo_modello_01 foreign key (id_pso, cod_tipo_modello)
  references serse_r_pso_tipo_modello (id_pso, cod_tipo_modello)
  on update no action
  on delete no action;

alter table serse_t_modello_di_intervento
  add constraint fk_serse_t_soggetto_attuatore_03 foreign key (id_soggetto_attuatore)
  references serse_t_soggetto_attuatore (id_soggetto_attuatore)
  on update no action
  on delete no action;

alter table serse_t_sede_soggetto_attuatore
  add constraint fk_ext_bdgt_d_area_territoriale_01 foreign key (cod_area_territoriale_appartenenza)
  references ext_gmop_d_area_territoriale (cod_area_territoriale)
  on update no action
  on delete no action;

alter table serse_t_sede_soggetto_attuatore
  add constraint fk_ext_bdgt_d_area_territoriale_02 foreign key (cod_area_territoriale_finanziamento)
  references ext_gmop_d_area_territoriale (cod_area_territoriale)
  on update no action
  on delete no action;

alter table serse_t_sede_soggetto_attuatore
  add constraint fk_serse_t_soggetto_attuatore_01 foreign key (id_soggetto_attuatore)
  references serse_t_soggetto_attuatore (id_soggetto_attuatore)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_ext_bdgt_d_area_territoriale_03 foreign key (cod_area_territoriale_finanziamento)
  references ext_gmop_d_area_territoriale (cod_area_territoriale)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_d_condizione_occupazionale_02 foreign key (cod_condizione_occupazionale)
  references serse_d_condizione_occupazionale (cod_condizione_occupazionale)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_d_livello_istruzione_02 foreign key (cod_livello_istruzione)
  references serse_d_livello_istruzione (cod_livello_istruzione)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_d_servizio_regionale_01 foreign key (id_servizio_regionale)
  references serse_d_servizio_regionale (id_servizio_regionale)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_d_stato_servizio_01 foreign key (id_stato_servizio)
  references serse_d_stato_servizio (id_stato_servizio)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_r_pso_classif_servizio_regionale_01 foreign key (id_pso, id_classificazione, id_servizio_regionale)
  references serse_r_pso_classif_servizio_regionale (id_pso, id_classificazione, id_servizio_regionale)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_r_pso_classificazione_02 foreign key (id_pso, id_classificazione)
  references serse_r_pso_classificazione (id_pso, id_classificazione)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_t_intervento_01 foreign key (id_intervento)
  references serse_t_intervento (id_intervento)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_t_sede_soggetto_attuatore_01 foreign key (id_soggetto_attuatore, progressivo_sede)
  references serse_t_sede_soggetto_attuatore (id_soggetto_attuatore, progressivo_sede)
  on update no action
  on delete no action;

alter table serse_t_servizio
  add constraint fk_serse_t_soggetto_attuatore_04 foreign key (id_soggetto_attuatore)
  references serse_t_soggetto_attuatore (id_soggetto_attuatore)
  on update no action
  on delete no action;

alter table serse_t_servizio 
  add constraint fk_serse_r_pso_classe_destinatario_01 
      foreign key (id_pso_classe_destinatario) 
      references serse_r_pso_classe_destinatario (id_pso_classe_destinatario);

alter table serse_t_servizio_modello
  add constraint fk_serse_d_finalita_servizio_02 foreign key (cod_finalita_servizio_esterno)
  references serse_d_finalita_servizio (cod_finalita_servizio)
  on update no action
  on delete no action;

alter table serse_t_servizio_modello
  add constraint fk_serse_d_servizio_regionale_02 foreign key (id_servizio_regionale)
  references serse_d_servizio_regionale (id_servizio_regionale)
  on update no action
  on delete no action;

alter table serse_t_servizio_modello
  add constraint fk_serse_t_modello_di_intervento_05 foreign key (id_modello_di_intervento)
  references serse_t_modello_di_intervento (id_modello_di_intervento)
  on update no action
  on delete no action;

alter table serse_t_servizio_sto
  add constraint fk_serse_t_servizio_04 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;

alter table serse_t_soggetto_attuatore
  add constraint fk_ext_bdgt_t_pso_sportello_03 foreign key (num_progr_sportello)
  references ext_bdgt_t_pso_sportello (num_progr_sportello)
  on update no action
  on delete no action;

alter table serse_t_token_gam
  add constraint fk_serse_d_tipo_richiesta_gam_01 foreign key (cod_tipo_richiesta_gam)
  references serse_d_tipo_richiesta_gam (cod_tipo_richiesta_gam)
  on update no action
  on delete no action;

alter table serse_t_token_gam
  add constraint fk_serse_t_incontro_02 foreign key (id_incontro)
  references serse_t_incontro (id_incontro)
  on update no action
  on delete no action;

alter table serse_t_token_gam
  add constraint fk_serse_t_servizio_08 foreign key (id_servizio)
  references serse_t_servizio (id_servizio)
  on update no action
  on delete no action;
