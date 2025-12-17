create or replace function aggiornadatiistitutiscolastici(pidtransazione numeric)
  returns integer
  language plpgsql
as
$body$
declare

  cur_istituto_attivo cursor for
    select istituto_sispro.*, istituto_serse.id_istituto_scolastico as id_istituto_scolastico_serse
      from sispro_w_punto_erogazione_attivo istituto_sispro
           left join serse_d_istituto_scolastico istituto_serse on istituto_serse.cod_regionale_scuola = istituto_sispro.cod_reg_scuola
     where istituto_sispro.id_transazione = pIdTransazione
    ;

  cur_istituto_chiuso cursor for
    select istituto_sispro.*, istituto_serse.id_istituto_scolastico as id_istituto_scolastico_serse
      from sispro_w_punto_erogazione_chiuso istituto_sispro
           join serse_d_istituto_scolastico istituto_serse on istituto_serse.cod_regionale_scuola = istituto_sispro.cod_reg_scuola
     where istituto_sispro.id_transazione = pIdTransazione
    ;

  dtElab timestamp;
  
  fase                varchar(20);
  transazioneCorrente numeric;
  istitutoCorrente    varchar(100);
  messaggioErrore     varchar(8000);

begin

  select current_timestamp into dtElab;
  
  for istituto_attivo in cur_istituto_attivo loop
  
    transazioneCorrente := istituto_attivo.id_transazione;
    istitutoCorrente := istituto_attivo.cod_reg_scuola;
	
    if istituto_attivo.id_istituto_scolastico_serse is null then
      
      -- nuovo istituto --> inserimento
	  
      fase := 'inserimento';
      
      insert into serse_d_istituto_scolastico
      (
        id_istituto_scolastico,
        cod_regionale_scuola,
        cod_regionale_autonomia,
        cod_meccanografico_scuola,
        cod_meccanografico_autonomia,
        denominazione,
        cod_comune_scuola,
        indirizzo,
        recapito_email,
        recapito_telefonico,
        url_sito_web,
        id_tipologia,
        id_percorso,
        id_tipo_sezione,
        id_tipo_unita,
        id_anno_scolastico,
        d_apertura,
        d_chiusura,
        d_modifica,
        d_inserim_serse,
        id_transazione_inserim
      )
      select coalesce(max(id_istituto_scolastico), 0) + 1,
             istituto_attivo.cod_reg_scuola,
             istituto_attivo.cod_reg_istituz,
             istituto_attivo.cod_scuola,
             istituto_attivo.cod_istituz,
             istituto_attivo.denominazione,
             istituto_attivo.cod_istat_comune,
             istituto_attivo.indirizzo,
             istituto_attivo.email,
             istituto_attivo.telefono,
             istituto_attivo.sito_web,
             istituto_attivo.id_tipologia,
             istituto_attivo.id_percorso,
             istituto_attivo.id_tipo_sezione,
             istituto_attivo.id_tipo_unita,
             istituto_attivo.id_anno_scolastico,
             istituto_attivo.d_apertura,
             istituto_attivo.d_chiusura,
             istituto_attivo.d_modifica,
             dtElab,
             istituto_attivo.id_transazione
        from serse_d_istituto_scolastico
      ;
      
    else -- aggiornamento
      
      fase := 'aggiornamento';
      
      update serse_d_istituto_scolastico
         set cod_regionale_autonomia = istituto_attivo.cod_reg_istituz,
             cod_meccanografico_scuola = istituto_attivo.cod_scuola,
             cod_meccanografico_autonomia = istituto_attivo.cod_istituz,
             denominazione = istituto_attivo.denominazione,
             cod_comune_scuola = istituto_attivo.cod_istat_comune,
             indirizzo = istituto_attivo.indirizzo,
             recapito_email = istituto_attivo.email,
             recapito_telefonico = istituto_attivo.telefono,
             url_sito_web = istituto_attivo.sito_web,
             id_tipologia = istituto_attivo.id_tipologia,
             id_percorso = istituto_attivo.id_percorso,
             id_tipo_sezione = istituto_attivo.id_tipo_sezione,
             id_tipo_unita = istituto_attivo.id_tipo_unita,
             id_anno_scolastico = istituto_attivo.id_anno_scolastico,
             d_apertura = istituto_attivo.d_apertura,
             d_chiusura = istituto_attivo.d_chiusura,
             d_modifica = istituto_attivo.d_modifica,
             d_aggiorn_serse = dtElab,
             id_transazione_aggiorn = istituto_attivo.id_transazione
       where id_istituto_scolastico = istituto_attivo.id_istituto_scolastico_serse;
 
    end if;

  end loop;
  
  for istituto_chiuso in cur_istituto_chiuso loop

    transazioneCorrente := istituto_chiuso.id_transazione;
    fase := 'chiusura';
    istitutoCorrente := istituto_chiuso.cod_reg_scuola;
    
	update serse_d_istituto_scolastico
       set cod_regionale_autonomia = istituto_chiuso.cod_reg_istituz,
           cod_meccanografico_scuola = istituto_chiuso.cod_scuola,
           cod_meccanografico_autonomia = istituto_chiuso.cod_istituz,
           d_chiusura = istituto_chiuso.d_chiusura,
           d_chiusura_serse = dtElab,
           id_transazione_chiusura = istituto_chiuso.id_transazione
     where id_istituto_scolastico = istituto_chiuso.id_istituto_scolastico_serse;

  end loop;
  
  return 0;

exception
  when others then
    messaggioErrore := 'ERRORE nell''elaborazione dell''istituto ' || istitutoCorrente || ' in fase di ' || fase || ' (transazione ' || transazioneCorrente || '). ' || SQLSTATE || ': ' || SQLERRM;
    raise exception '%', messaggioErrore;
  
end;
$body$
  VOLATILE
  COST 100;

create or replace function getmaxidelaborazione()
  returns integer
  language sql
as
$body$
select (coalesce(max(id_transazione), 0)+1)::integer from sispro_w_punto_erogazione_attivo;
$body$
  VOLATILE
  COST 100;

