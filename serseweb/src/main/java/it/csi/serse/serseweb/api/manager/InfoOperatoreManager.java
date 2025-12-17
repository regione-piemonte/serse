package it.csi.serse.serseweb.api.manager;

/*-
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.exception.ErroreConnessioneServizioException;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTSedeSoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTSoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSedeSoggettoAttuatoreSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTSoggettoAttuatoreSelector;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.DettaglioPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultElencoPG;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.SintesiSede;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgsediHelper;
import it.csi.serse.serseweb.integration.ws.cxf.helper.SecurityHelper;
import it.csi.serse.serseweb.mapper.FlaiAnagMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.SedeOperatore;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Component
public class InfoOperatoreManager extends ParentManager{
	@Autowired
	private SecurityHelper securityHelper;

	@Autowired
	private FlaiAnagMapper flaiAnagMapper;

	@Autowired
	private VoMapper voMapper;

	@Autowired
	private FlaianagpgHelper flaiAnagPg;

	@Autowired
	private FlaianagpgsediHelper flaiAnagPgSedi;

	@Autowired
	private SerseTSoggettoAttuatoreDAO soggettoAttuatoreDAOGenerato;

	@Autowired
	private SerseTSedeSoggettoAttuatoreDAO serseTSedeSoggettoAttuatoreDAOGenerato;

	/*
	 * Nel momento in cui l’utente seleziona il ruolo nella lista “Seleziona un
	 * ruolo” (vedi paragrafo precedente), il sistema richiama il servizio di
	 * FLAIDOOR getInfoPersonaInUseCase passando come parametri l’oggetto identità e
	 * ricevendo in out una lista contenente le informazioni aggiuntive relative ai
	 * ruoli previsti per l’utente che si sta connettendo. Le informazioni
	 * aggiuntive previste nel caso dei ruoli “Responsabile Erogazione Servizi” o
	 * “Operatore Erogazione Servizi” sono, facendo un esempio concreto:
	 * 
	 * <codiceDbOperatore>20013</codiceDbOperatore>
	 * <codiceOperatore>6</codiceOperatore> 
	 * <descrizioneOperatore>B6 - * CNOS-FAP</descrizioneOperatore> 
	 * <gruppoOperatore>B</gruppoOperatore>
	 * 
	 * Il sistema deve filtrare l’elenco di queste Info Aggiuntive in base al
	 * cod_ruolo scelto dall’utente nella prima selezione e visualizzarle nella
	 * lista di selezione “Seleziona un Operatore” secondo questo formato:
	 * “[<gruppoOperatore><codiceOperatore>] - <descrizioneOperatore>”
	 * 
	 * Esempio: “[B6] – CNOS-FAP”
	 * 
	 * ordinando la lista in ordine alfabetico crescente di
	 * gruppoOPeratore||codiceOperatore e descrizioneOperatore
	 * 
	 * L’utente deve selezionare una voce dalla lista e confermare le scelte
	 * mediante il pulsante CONFERMA (vedi interfacce)
	 */

	public Response getInfoOperatoreForRuolo(@NotNull String codRuolo,SecurityContext securityContext,
											 HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		return securityHelper.getInfoOperatoreForRuolo(codRuolo, securityContext, httpHeaders, httpRequest);
	}

	/*
	 * Indicazione Operatore per ruolo Servizio Assistenza Se l’utente ha
	 * selezionato il ruolo “Servizio Assistenza SERSE”, l’applicativo aggiorna la
	 * pagina visualizzando i campi relativo al Gruppo Operatore e Codice Operatore,
	 * come indicato nell’interfaccia al §2.1.2
	 * 
	 * L’utente deve popolare i 2 campi: Gruppo: accettare solo 1 carattere (solo
	 * lettere, niente numeri né simboli) Codice: accettare solo caratteri numerici
	 * per un massimo di 6
	 * 
	 * Alla conferma, tramite apposito pulsante, il sistema effettua il controllo
	 * sui campi inseriti, come indicato sopra. Se quanto inserito non rispetta i
	 * requisiti, visualizzare un messaggio bloccante d’errore: Attenzione: i valori
	 * inseriti non sono corretti
	 * 
	 * e indicare con una “X” la riga dei campi Gruppo e Codice contenente l’errore.
	 * 
	 * Se il controllo va a buon fine, il sistema deve invocare il servizio
	 * FLAIANAG.AnagrafePG.getDettaglioOperatore passando come parametri: in0: ‘FP’
	 * in1: codiceGruppoOperatore: quanto inserito nel campo Gruppo codiceOperatore:
	 * quanto inserito nel campo Codice
	 * 
	 * Se il servizio non restituisce alcun risultato, il sistema visualizza un
	 * messaggio:
	 * 
	 * Nessun Operatore trovato per i parametri indicati
	 * 
	 * Se invece il servizio restituisce un’occorrenza (ad un gruppo e codice
	 * Operatore corrisponderà una ed una sola occorrenza), recuperare dall’output
	 * fornito il tag <denominazionePersonaGiuridica>.
	 */

	public Response getPersonaGiuridicaForRuolo(@NotNull String gruppoOperatore, @NotNull BigDecimal codOperatore) {
		DettaglioPersonaGiuridica ris = flaiAnagPg.getDettaglioOperatore(gruppoOperatore, codOperatore.intValue());
		PersonaGiuridica pg = flaiAnagMapper.toVo(ris);
		return Response.ok(pg).build();
	}

	/**
	 *
	 */
	public Response getElencoSediForOperatore(@NotNull String gruppoOperatore, @NotNull BigDecimal codOperatore,
											  String codiceIstatComune, String codiceProvincia) {
		List<SintesiSede> sintesiSedi = flaiAnagPgSedi.getElencoSediOperatore(gruppoOperatore, codOperatore.intValue(),codiceProvincia, codiceIstatComune, null);
		List<SedeOperatore> elencoSediVo = flaiAnagMapper.toVoListaSedi(sintesiSedi, voMapper);
		return Response.ok(elencoSediVo).build();
	}

	/**
	 *
	 */
	public Response getPersoneGiuridiche(@NotNull String gruppoOperatore, @NotNull BigDecimal codOperatore) {

		SintesiPersonaGiuridica elencoSintesiPersoneGiuridiche;
		try {
			elencoSintesiPersoneGiuridiche = flaiAnagPg.getOperatore(gruppoOperatore, codOperatore.intValue());
		} catch(Exception e) {
			throw  new ErroreConnessioneServizioException(501,e.getMessage());
		}
		PersonaGiuridica vo = flaiAnagMapper.toVo(elencoSintesiPersoneGiuridiche);
		List<PersonaGiuridica> elencoPersoneGiuridiche = List.of(vo);
		return Response.ok(elencoPersoneGiuridiche).build();
	}

	/**
	 *
	 */
	public Response ricercaOperatore(String gruppoOperatore, String codOperatore, String denominazionePersonaGiuridica,
									 String codiceFiscale, String partitaIva) {


		ResultElencoPG elencoSintesiPersoneGiuridiche=flaiAnagPg.getElencoPG(gruppoOperatore,
				codOperatore, denominazionePersonaGiuridica, codiceFiscale, partitaIva);

		List<PersonaGiuridica> elencoPersoneGiuridiche = new ArrayList<>();
		if(elencoSintesiPersoneGiuridiche.getElencoPG() != null) {
			elencoPersoneGiuridiche = flaiAnagMapper.toVoListaPG(elencoSintesiPersoneGiuridiche.getElencoPG().getItem());
		}
		if(elencoPersoneGiuridiche.size() < 100){
			return Response.ok(elencoPersoneGiuridiche).build();
		}else{
			GenericResponse response = new GenericResponse();
			response.setMessage("" + elencoPersoneGiuridiche.size());
			return Response.ok(response).build();
		}
	}

    /*
		CDU 33
	 */
	@Cacheable("elencoSediAutorizzati")
	public List<SedeOperatore> getElencoSediAutorizzati(Long idSoggettoAttuatore){
		List<SedeOperatore> elencoSediVo = new ArrayList<>();

		SerseTSoggettoAttuatoreDTO soggettoAttuatoreDTO = soggettoAttuatoreDAOGenerato.selectByPrimaryKey(idSoggettoAttuatore);

		List<SintesiSede> sintesiSedi = flaiAnagPgSedi.getElencoSediOperatore(soggettoAttuatoreDTO.getGruppoOperatore(),
										soggettoAttuatoreDTO.getCodOperatore().intValue(),null, null, null);
		for (SintesiSede sede: sintesiSedi) {
			SerseTSedeSoggettoAttuatoreSelector serseTSedeSoggettoAttuatoreSelector = new SerseTSedeSoggettoAttuatoreSelector();
			SerseTSedeSoggettoAttuatoreSelector.Criteria serseTSedeSoggettoAttuatoreCriteria = serseTSedeSoggettoAttuatoreSelector.createCriteria();
			serseTSedeSoggettoAttuatoreCriteria.andIdSoggettoAttuatoreEqualTo(soggettoAttuatoreDTO.getIdSoggettoAttuatore());
			serseTSedeSoggettoAttuatoreCriteria.andProgressivoSedeEqualTo(sede.getIdSede().longValue());
			if(!serseTSedeSoggettoAttuatoreDAOGenerato.selectByExample(serseTSedeSoggettoAttuatoreSelector).isEmpty()){
				elencoSediVo.add(flaiAnagMapper.toVo(sede, voMapper));
			}
		}
		return elencoSediVo;
	}

	@Cacheable("elencoSediAutorizzatiCodGruppo")
	public List<SedeOperatore> getElencoSediAutorizzatiCodGruppo(Long numProgrSportello, Long codOperatore,
													  String gruppoOperatore, Long modelId) {
		List<SedeOperatore> elencoSediVo = new ArrayList<>();

		// Crea il selector per il soggetto attuatore
		SerseTSoggettoAttuatoreSelector serseTSoggettoAttuatoreSelector = new SerseTSoggettoAttuatoreSelector();
		SerseTSoggettoAttuatoreSelector.Criteria criteria = serseTSoggettoAttuatoreSelector.createCriteria();
		criteria.andCodOperatoreEqualTo(codOperatore);
		criteria.andGruppoOperatoreEqualTo(gruppoOperatore);
		criteria.andNumProgrSportelloEqualTo(numProgrSportello);
		criteria.andModelIdEqualTo(modelId);

		// Esegui la query per ottenere i risultati
		List<SerseTSoggettoAttuatoreDTO> soggettoAttuatoreDTOList = soggettoAttuatoreDAOGenerato.selectByExample(serseTSoggettoAttuatoreSelector);

		if (soggettoAttuatoreDTOList != null && !soggettoAttuatoreDTOList.isEmpty()) {
			SerseTSoggettoAttuatoreDTO soggettoAttuatoreDTO = soggettoAttuatoreDTOList.get(0);

			List<SintesiSede> sintesiSedi = flaiAnagPgSedi.getElencoSediOperatore(soggettoAttuatoreDTO.getGruppoOperatore(), soggettoAttuatoreDTO.getCodOperatore().intValue(), null, null, null);
			for (SintesiSede sede : sintesiSedi) {
				SerseTSedeSoggettoAttuatoreSelector serseTSedeSoggettoAttuatoreSelector = new SerseTSedeSoggettoAttuatoreSelector();
				SerseTSedeSoggettoAttuatoreSelector.Criteria serseTSedeSoggettoAttuatoreCriteria = serseTSedeSoggettoAttuatoreSelector.createCriteria();
				serseTSedeSoggettoAttuatoreCriteria.andIdSoggettoAttuatoreEqualTo(soggettoAttuatoreDTO.getIdSoggettoAttuatore());
				serseTSedeSoggettoAttuatoreCriteria.andProgressivoSedeEqualTo(sede.getIdSede().longValue());

				if (!serseTSedeSoggettoAttuatoreDAOGenerato.selectByExample(serseTSedeSoggettoAttuatoreSelector).isEmpty()) {
					elencoSediVo.add(flaiAnagMapper.toVo(sede, voMapper));
				}
			}
			elencoSediVo.sort(Comparator.comparing(SedeOperatore::getIdSede));
		}
		return elencoSediVo;
	}
}
