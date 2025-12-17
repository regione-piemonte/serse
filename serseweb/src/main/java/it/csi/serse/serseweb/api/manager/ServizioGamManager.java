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

import static it.csi.serse.serseweb.utils.Constants.ESITO_OK;
import static it.csi.serse.serseweb.utils.Constants.STATO_INCONTRO_CHIUSO;
import static it.csi.serse.serseweb.utils.Constants.STATO_INCONTRO_IN_DEF;
import static it.csi.serse.serseweb.utils.Constants.STATO_SERVIZIO_FINANZIATO;
import static it.csi.serse.serseweb.utils.Constants.STATO_SERVIZIO_IN_DEF;
import static it.csi.serse.serseweb.utils.Constants.TIPO_MATERIA_SERSE;
import static it.csi.serse.serseweb.utils.Constants.TIPO_RICHIESTA_CHIUSURA_SERVIZIO;
import static it.csi.serse.serseweb.utils.Constants.TIPO_RICHIESTA_ELIMINA_INCONTRI;
import static it.csi.serse.serseweb.utils.Constants.TIPO_RICHIESTA_ELIMINA_INCONTRO;
import static it.csi.serse.serseweb.utils.Constants.TIPO_RICHIESTA_EROGAZIONE_ATTIVITA;
import static it.csi.serse.serseweb.utils.Constants.TIPO_RICHIESTA_IMPEGNO_BUDGET_SERVIZIO;
import static it.csi.serse.serseweb.utils.Constants.TIPO_RICHIESTA_MODIFICA_BUGDET;
import static it.csi.serse.serseweb.utils.Constants.TIPO_RICHIESTA_PREVENTIVO_SERVIZIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.csi.serse.serseweb.config.SersewebExceptionHandler;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.IncontriDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.SoggettoAttuatoreDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.SoggettoAttuatoreDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtGmopDAreaTerritorialeDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDRegComportPsoSportDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDServizioRegionaleDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRIncontroDestinatarioServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRServizioFonteDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseRServizioVoceSpesaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTDestinatarioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTIncontroDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioStoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTTokenGamDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRIncontroDestinatarioServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioFonteSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseRServizioVoceSpesaSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTIncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTIncontroSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioStoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamSelector;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultElencoPG;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.ClassificazioneDto;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.DestinatarioSerseDto;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieCalcPreventivoSerseInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieCalcPreventivoSerseOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieCodAnagraficoSFDto;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieConcludiServizioSerseInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieConcludiServizioSerseOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieEliminaServizioIncontriInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieEliminaServizioIncontriOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieGetBDGTDisponibileSFInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieGetBDGTDisponibileSFOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieModificaServizioSerseInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieModificaServizioSerseOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieNuovoIncontroSrvSerseInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieNuovoIncontroSrvSerseOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieNuovoServizioSerseInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieNuovoServizioSerseOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieRiapriIncontroDiServizioInput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.GestInterscMaterieRiapriIncontroDiServizioOutput;
import it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.SedeOccasionaleDto;
import it.csi.serse.serseweb.integration.ws.cxf.helper.OperscambHelper;
import it.csi.serse.serseweb.mapper.GamMapper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.mapper.VoMapper;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.utils.DateUtils;
import it.csi.serse.serseweb.utils.MailUtil;
import it.csi.serse.serseweb.vo.Budget;
import it.csi.serse.serseweb.vo.Classificazione;
import it.csi.serse.serseweb.vo.Errore;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.Incontro;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.Servizio;
import it.csi.serse.serseweb.vo.ServizioGam;
import it.csi.serse.serseweb.vo.ServizioGamChiudiServizio;
import it.csi.serse.serseweb.vo.ServizioGamIncontro;
import it.csi.serse.serseweb.vo.ServizioGamPropostaModifica;
import it.csi.serse.serseweb.vo.ServizioGamRiapriServizio;
import it.csi.serse.serseweb.vo.TokenGam;
import jakarta.ws.rs.core.Response;

@Component
public class ServizioGamManager extends ParentManager {
    @Autowired
    private OperscambHelper operscambHelper;

    @Autowired
    private GenericMapper genericMapper;

    @Autowired
    private GamMapper gamMapper;

    @Autowired
    private MybatisGeneretedDTOMapper mybatisMapper;

    @Autowired
    private ClassificazioniManager classificazioniManager;

    @Autowired
    private SoggettoAttuatoreDAO soggettoAttuatoreDAOCustom;

    @Autowired
    private SerseTTokenGamDAO tokenGamDAOGenerato;

	@Autowired
	private SoggettoAttuatoreDAO soggettoAttuatoreDAO;

    @Autowired
    private SerseDServizioRegionaleDAO servizioRegionaleDAO;

    @Autowired
    private SerseRDestinatarioServizioDAO destinatarioServizioDAO;

    @Autowired
    private SerseTDestinatarioDAO destinatarioDAO;

    @Autowired
    private SerseTIncontroDAO incontroDAO;

    @Autowired
    private IncontriDAO incontroDAOCustom;

    @Autowired
    private SerseTServizioDAO serviziDao;

    @Autowired
    private SerseDRegComportPsoSportDAO serseDRegComportPsoSportDAOGenerato;

    @Autowired
    private ExtGmopDAreaTerritorialeDAO areaTerritorialeDAOGenerato;

    @Autowired
    private SerseRIncontroDestinatarioServizioDAO incontroDestinatarioServizioDAOGenerato;

    @Autowired
    private SerseRDestinatarioServizioDAO destinatarioServizioDAOGenerato;

    @Autowired
    private SerseRServizioFonteDAO servizioFonteDao;

    @Autowired
    private SerseRServizioVoceSpesaDAO servizioVoceSpesaDao;

    @Autowired
    IncontriManager incontriManager;

    @Autowired
    SoggettoAttuatoreManager soggAttuatoreManager;

    @Autowired
    TokenGamTransactionManager tokenGamManager;

	@Autowired
	private VoMapper voMapper;

    @Autowired
    private SerseTServizioStoDAO servizioStoDao;

    @Autowired
    private MailUtil mailUtil;

    private static final String KO = "KO";
    private static final String ERR_CHIAMATA_GAM = "Impossibile effettuare la chiamata a GAM";

    /*
     * FPL-SERSE-SER-CDU-028-V01-Gestione Spesa Servizio
     */


    // Algoritmo – Richiesta Preventivo di spesa

    @Transactional
    public Response calcPreventivoSerse(ServizioGam body) {
        Servizio servizio = body.getServizio();

        Classificazione classificacione = classificazioniManager.getClassificazioniForServizio(servizio.getIdServizio()).get(0);
        String tipologiaServizio = null;
        SerseDServizioRegionaleDTO servizioRegionale = servizioRegionaleDAO.selectByPrimaryKey(servizio.getServizioRegionale().getIdServizioRegionale());


        //Algoritmo – Determina tipologia del Servizio
        if(servizioRegionale.getCodFinalitaServizio().equals("I"))
            tipologiaServizio = "01";
        else
            tipologiaServizio = "02";
        
        ClassificazioneDto classificazioneDto = new ClassificazioneDto();

        classificazioneDto.setAsse(classificacione.getLivello1());
        classificazioneDto.setObiettivo(classificacione.getLivello2());
        classificazioneDto.setAttivita(classificacione.getLivello3());
        classificazioneDto.setCodiceAzione(classificacione.getLivello4());
        
        SoggettoAttuatoreDTO soggettoAttuatoreServizio =  soggettoAttuatoreDAOCustom.getSoggettoBeneficiario(body.getServizio().getSoggettoAttuatore().getIdSoggettoAttuatore());

        GestInterscMaterieCalcPreventivoSerseInput input = new GestInterscMaterieCalcPreventivoSerseInput();
        input.setCodiceTipoMateria(TIPO_MATERIA_SERSE);
        input.setCodiceTipoRichiesta(TIPO_RICHIESTA_PREVENTIVO_SERVIZIO);
        input.setIdPso(body.getIdPso());
        input.setIdSportello(body.getNumProgrSportello());
        input.setGruppoOperatore(soggettoAttuatoreServizio.getGruppoOperatore());
        input.setCodiceOperatore(soggettoAttuatoreServizio.getCodOperatore().longValue());
        input.setNumeroDomanda(soggettoAttuatoreServizio.getModelId().longValue());
        input.setAreaTerritoriale(servizio.getAreaTerritoriale().getCodAreaTerritoriale());
        input.setClassificazionePORServizio(classificazioneDto);
        input.setCodTipologiaServizio(tipologiaServizio);
        input.setCodTipoServizio(servizioRegionale.getCodiceServizioRegionale());
        input.setCodSottoTipologiaServizio(null);
        input.setDurata(servizio.getDurataOre());
        input.setNumDestinatari(servizio.getNumMaxDestinatari().longValue());

        SerseTTokenGamDTO tokenGamDTO = tokenGamManager.insertTokenGam(body.getServizio().getIdServizio(), null, TIPO_RICHIESTA_PREVENTIVO_SERVIZIO, input, body.getCodiceFiscaleUtente());

        // N.B. il token non apparirà su DB nel campo xml, pazienza
        input.setTkServizio(tokenGamDTO.getIdTokenGam());

        String codStatoRichiesta = KO;
        String desStatoRichiesta = ERR_CHIAMATA_GAM;
        String tokenElabGam = null;
        try {
            GestInterscMaterieCalcPreventivoSerseOutput output = operscambHelper.gestInterscMaterieCalcPreventivoSerse(input);
            codStatoRichiesta = output.getAsyncResult().getCodiceEsito();
            desStatoRichiesta = output.getAsyncResult().getDescrizioneEsito();
            tokenElabGam = output.getAsyncResult().getToken();

        } catch (Throwable e) {
            // Questo codice è temporaneo. invioEmailErrore deve essere eliminato e i catch devono catturare solo Exceptions, non Throwable.
            invioEmailErrore(e);
            return super.internalServerError();
        } finally {
            try {
                tokenGamManager.updateTokenGamAsync(tokenGamDTO, tokenElabGam, codStatoRichiesta, desStatoRichiesta);
            } catch (Throwable e) {
                invioEmailErrore(e);
            }
        }

        return Response.ok(tokenGamDTO).build();
    }

    @Transactional
    public Response nuovoServizioSerse(ServizioGam body) {
        Servizio servizio = body.getServizio();
        Classificazione classificacione = classificazioniManager.getClassificazioniForServizio(servizio.getIdServizio()).get(0);
        String tipologiaServizio = null;
        SerseDServizioRegionaleDTO servizioRegionale = servizioRegionaleDAO.selectByPrimaryKey(servizio.getServizioRegionale().getIdServizioRegionale());
        SerseRDestinatarioServizioSelector destinatarioServizioSelector = new SerseRDestinatarioServizioSelector();
        SerseRDestinatarioServizioSelector.Criteria destinatarioServizioCriteria = destinatarioServizioSelector.createCriteria();
        destinatarioServizioCriteria.andIdServizioEqualTo(servizio.getIdServizio());
        List<SerseRDestinatarioServizioDTO> destinatarioServizio = destinatarioServizioDAO.selectByExample(destinatarioServizioSelector);

        //Algoritmo – Determina tipologia del Servizio
        if(servizioRegionale.getCodFinalitaServizio().equals("I"))
            tipologiaServizio = "01";
        else
            tipologiaServizio = "02";
        ClassificazioneDto classificazioneDto = new ClassificazioneDto();
        
        classificazioneDto.setAsse(classificacione.getLivello1());
        classificazioneDto.setObiettivo(classificacione.getLivello2());
        classificazioneDto.setAttivita(classificacione.getLivello3());
        classificazioneDto.setCodiceAzione(classificacione.getLivello4());

        SoggettoAttuatoreDTO soggettoAttuatoreServizio =  soggettoAttuatoreDAOCustom.getSoggettoBeneficiario(body.getServizio().getSoggettoAttuatore().getIdSoggettoAttuatore());

        GestInterscMaterieNuovoServizioSerseInput input = new GestInterscMaterieNuovoServizioSerseInput();
        input.setCodiceTipoMateria(TIPO_MATERIA_SERSE);
        input.setCodiceTipoRichiesta(TIPO_RICHIESTA_IMPEGNO_BUDGET_SERVIZIO);
        input.setIdPso(body.getIdPso());
        input.setIdSportello(body.getNumProgrSportello());
        input.setGruppoOperatore(soggettoAttuatoreServizio.getGruppoOperatore());
        input.setCodiceOperatore(soggettoAttuatoreServizio.getCodOperatore().longValue());
        input.setNumeroDomanda(soggettoAttuatoreServizio.getModelId().longValue());
        input.setAreaTerritoriale(servizio.getAreaTerritoriale().getCodAreaTerritoriale());
        input.setClassificazionePORServizio(classificazioneDto);
        input.setIdServizio(servizio.getIdServizio());
        input.setDenomServizio(servizio.getTitoloServizio());
        input.setCodTipologiaServizio(tipologiaServizio);
        input.setCodTipoServizio(servizioRegionale.getCodiceServizioRegionale());
        input.setCodSottoTipologiaServizio(null);
        input.setDurata(servizio.getDurataOre());
        input.setNumDestinatariMax(servizio.getNumMaxDestinatari().longValue());

        if(!destinatarioServizio.isEmpty()) {
            SerseTDestinatarioDTO destinatario = destinatarioDAO.selectByPrimaryKey(destinatarioServizio.get(0).getIdDestinatario());
            DestinatarioSerseDto destinatarioDto = new DestinatarioSerseDto();
            destinatarioDto.setNome(destinatario.getNomeDestinatario());
            destinatarioDto.setCognome(destinatario.getCognomeDestinatario());
            destinatarioDto.setCodFiscale(destinatario.getCfDestinatario());
                       
            input.setDestinatario(destinatarioDto);
        }
        input.setIdOperazione(null);
        input.setIdIntervento(servizio.getIdIntervento());
        input.setCodSedeResponsabile(int2long(servizio.getProgressivoSede()));

        SerseTTokenGamDTO tokenGamDTO = tokenGamManager.insertTokenGam(body.getServizio().getIdServizio(), null, TIPO_RICHIESTA_IMPEGNO_BUDGET_SERVIZIO, input, body.getCodiceFiscaleUtente());

        // N.B. il token non apparirà su DB nel campo xml, pazienza
        input.setTkServizio(tokenGamDTO.getIdTokenGam());

        String codStatoRichiesta = KO;
        String desStatoRichiesta = ERR_CHIAMATA_GAM;
        String tokenElabGam = null;
        try {
            GestInterscMaterieNuovoServizioSerseOutput output = operscambHelper.gestInterscMaterieNuovoServizioSerse(input);
            codStatoRichiesta = output.getAsyncResult().getCodiceEsito();
            desStatoRichiesta = output.getAsyncResult().getDescrizioneEsito();
            tokenElabGam = output.getAsyncResult().getToken();

        } catch (Throwable e) {
            // Questo codice è temporaneo. invioEmailErrore deve essere eliminato e i catch devono catturare solo Exceptions, non Throwable.
            invioEmailErrore(e);
            return super.internalServerError();

        } finally {
            try {
                tokenGamManager.updateTokenGamAsync(tokenGamDTO, tokenElabGam, codStatoRichiesta, desStatoRichiesta);
            } catch (Throwable e) {
                invioEmailErrore(e);
            }
        }
        return Response.ok(tokenGamDTO).build();
    }

    public Response getTokenGamForIdServizio(Long idServizio, String codTipoRichiestaGam) {
        List<String> parametriMancanti = new ArrayList<>();

        if (idServizio == null) {
            parametriMancanti.add(INPUT_MISSING.ID_SERVIZIO);
        }
        if(!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }

        SerseTTokenGamSelector tokenGamSelector = new SerseTTokenGamSelector();
        SerseTTokenGamSelector.Criteria tokenGamCriteria = tokenGamSelector.createCriteria();
        tokenGamCriteria.andIdServizioEqualTo(idServizio);

        if(codTipoRichiestaGam != null)
            tokenGamCriteria.andCodTipoRichiestaGamEqualTo(codTipoRichiestaGam);

        List<SerseTTokenGamDTO> tokenGamDTO =  tokenGamDAOGenerato.selectByExample(tokenGamSelector);
        List<TokenGam> tokenGamVo = mybatisMapper.mapListTokenGam(tokenGamDTO);
        return Response.ok(tokenGamVo).build();

    }

    /*
     * FPL-SERSE-TRA-CDU-031-V01-Verifica Budget
     */
    private boolean verificaParametriMancanti(Long numProgrSportello, Long codOperatore, Long idPso, String gruppoOperatore){
        boolean risposta = false;
        List<String> parametriMancanti = new ArrayList<>();

        if (numProgrSportello == null) {
            parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
        }

        if (codOperatore == null) {
            parametriMancanti.add(INPUT_MISSING.COD_OPERATORE);
        }

        if (idPso == null) {
            parametriMancanti.add(INPUT_MISSING.ID_PSO);
        }

        if (gruppoOperatore == null) {
            parametriMancanti.add(INPUT_MISSING.GRUPPO_OPERATORE);
        }
        if(!parametriMancanti.isEmpty()) {
            risposta = true;
        }
        return  risposta;
    }

    @Transactional
    public Response getBudgetForSoggetto(Long numProgrSportello, Long codOperatore, Long idPso, String gruppoOperatore) {
        List<String> parametriMancanti = new ArrayList<>();

        if(verificaParametriMancanti(numProgrSportello, codOperatore, idPso, gruppoOperatore)) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }

        List<SoggettoAttuatoreDTO> soggettoAttuatoreDTOS  = soggettoAttuatoreDAOCustom.getIstanzeCandidatura(numProgrSportello, codOperatore, gruppoOperatore, true);
        if(soggettoAttuatoreDTOS.isEmpty())
            return Response.ok("soggettoAttuatore non trovato").build();
        List<Budget> budgets = new ArrayList<>();

        SerseDRegComportPsoSportSelector regComportPsoSportSelector = new SerseDRegComportPsoSportSelector();
        SerseDRegComportPsoSportSelector.Criteria regComportPsoSportCriteria = regComportPsoSportSelector.createCriteria();
        regComportPsoSportCriteria.andIdPsoEqualTo(idPso);
        regComportPsoSportCriteria.andNumProgrSportelloEqualTo(numProgrSportello);
        List<SerseDRegComportPsoSportDTO> regComportPsoSportDTOS = serseDRegComportPsoSportDAOGenerato.selectByExample(regComportPsoSportSelector);
        String tipologiaBudgetGam = "";
        if(!regComportPsoSportDTOS.isEmpty())
            tipologiaBudgetGam = regComportPsoSportDTOS.get(0).getTipologiaBudgetGam();

        Map<String,PersonaGiuridica> mapDenominazioni = soggAttuatoreManager.getDenominazioniGiuridiche(soggettoAttuatoreDTOS);

        for (SoggettoAttuatoreDTO soggettoAttuatore: soggettoAttuatoreDTOS) {
            Budget budget = new Budget();
            ResultElencoPG ris;

            GestInterscMaterieGetBDGTDisponibileSFInput input = new GestInterscMaterieGetBDGTDisponibileSFInput();
            input.setTipologiaBudget(tipologiaBudgetGam);
            input.setIdPso(idPso);
            input.setIdSportello(numProgrSportello);
            input.setIdSoggFin(null);

            GestInterscMaterieCodAnagraficoSFDto codAnagrafico = new GestInterscMaterieCodAnagraficoSFDto();
            codAnagrafico.setGruppoOperatore(soggettoAttuatore.getGruppoOperatore());
            codAnagrafico.setCodOperatore(soggettoAttuatore.getCodOperatore().longValue());
            codAnagrafico.setNumDomanda(soggettoAttuatore.getModelId().longValue());
            codAnagrafico.setAnnoGestione(0L);

            input.setCodAnagraficoSoggFin(codAnagrafico);
            try{
                GestInterscMaterieGetBDGTDisponibileSFOutput output = operscambHelper.gestInterscMaterieGetBDGTDisponibileSF(input);
                List<it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.ClassTabFinanziamentoBudgetDisponibile> elenco=output.getElencoClassificazioni();
                List<it.csi.serse.serseweb.integration.ws.cxf.gamopera.operscamb.FontiImportiBudgetDisponibile> importi = elenco.get(0).getImportiFonte();

                budget.setCodEsito(output.getEsito().getCodice());
                budget.setDescrEsito(output.getEsito().getDescrizione());
                if(output.getEsito().getCodice().equals(ESITO_OK)){
                    budget.setIstanza(soggettoAttuatore.getModelId().longValue());
                    budget.setSoggettoAttuatore(genericMapper.map(soggettoAttuatore));

                    PersonaGiuridica pg = mapDenominazioni.get(soggettoAttuatore.getGruppoOperatore() + soggettoAttuatore.getCodOperatore());
                    budget.getSoggettoAttuatore().setDenominazioneGiuridica(pg.getDenominazione());

                    budget.setClassificazioneFinanziamento(gamMapper.map(output.getElencoClassificazioni().get(0)));

                    budget.setAreaTerritoriale(mybatisMapper.map(areaTerritorialeDAOGenerato.selectByPrimaryKey(output.getElencoClassificazioni().get(0).getCodAreaTerritoriale())));
                    budget.setFascia(budget.getClassificazioneFinanziamento().getIdFascia());

                    budget.getClassificazioneFinanziamento().setImportoResiduo(importi.get(0).getImportoResiduoFonte());
                    budget.getClassificazioneFinanziamento().setImportoStanziato(importi.get(0).getImportoStanziatoFonte());
                    budget.getClassificazioneFinanziamento().setImportoUtilizzato(importi.get(0).getImportoUtilizzatoFonte());
                    budget.setIdFonte(importi.get(0).getIdFonte());

                    budget.setStanziato(importi.get(0).getImportoStanziatoFonte());
                    budget.setFinanziato(importi.get(0).getImportoUtilizzatoFonte());
                    budget.setResiduo(importi.get(0).getImportoResiduoFonte());
                }

            } catch (Exception e) {
                budget.setCodEsito("00");
                budget.setDescrEsito(SersewebExceptionHandler.MSG_UNEXPECTED_ERROR);
            }
            budgets.add(budget);
        }

        return Response.ok(budgets).build();
    }

    /*
     * FPL-SERSE-TRA-CDU-030-V01-Inserimento e aggiornamento Incontro
     */

    //Chiusura incontro
    @Transactional
    public Response nuovoIncontroSerse(ServizioGamIncontro body){
        try {
            Servizio servizio = body.getServizio();
            Incontro incontro = body.getIncontro();

            Date now = incontroDAO.getNow();
            
            // in questa fase aggiorno solamente utente/data chiusura incontro
            SerseTIncontroDTO incontroDTO = incontroDAO.selectByPrimaryKey(incontro.getIdIncontro());
            incontroDTO.setCodUserChiusura(body.getIncontro().getCodUserChiusura());
            incontroDTO.setdChiusura(now);
            incontroDTO.setdAggiorn(now);
            incontroDAO.updateByPrimaryKey(incontroDTO);
    
            SedeOccasionaleDto sedeOccasionale = new SedeOccasionaleDto();
            sedeOccasionale.setComune(incontro.getLuogoIncontro().getComuneIncontro().getDescrizioneComune());
            sedeOccasionale.setProvincia(incontro.getLuogoIncontro().getComuneIncontro().getProvincia().getSiglaProvincia());
            sedeOccasionale.setIndirizzo(incontro.getLuogoIncontro().getIndirizzoLuogo());
            sedeOccasionale.setPresso(incontro.getLuogoIncontro().getDenominazioneLuogo());
            GestInterscMaterieNuovoIncontroSrvSerseInput input = new GestInterscMaterieNuovoIncontroSrvSerseInput();
    
            SerseRIncontroDestinatarioServizioSelector incontroDestinatarioServizioSelector = new SerseRIncontroDestinatarioServizioSelector();
            SerseRIncontroDestinatarioServizioSelector.Criteria incontroDestinatarioServizioCriteria = incontroDestinatarioServizioSelector.createCriteria();
            incontroDestinatarioServizioCriteria.andIdIncontroEqualTo(incontro.getIdIncontro());
    
    
            List<SerseRIncontroDestinatarioServizioDTO> incontroDestinatarioServizioDTOS = incontroDestinatarioServizioDAOGenerato.selectByExample(incontroDestinatarioServizioSelector);
            Integer numDestinatario = incontroDestinatarioServizioDTOS.size();
    
            List<DestinatarioSerseDto> destinatarioSerseDtoSIn = new ArrayList<>();
    
            for (SerseRIncontroDestinatarioServizioDTO incontroDestinatarioServizioDTO: incontroDestinatarioServizioDTOS) {
                SerseRDestinatarioServizioDTO destinatarioServizioDTO = destinatarioServizioDAOGenerato.selectByPrimaryKey(incontroDestinatarioServizioDTO.getIdDestinatarioServizio());
                SerseTDestinatarioDTO destinatarioDTO = destinatarioDAO.selectByPrimaryKey(destinatarioServizioDTO.getIdDestinatario());
    
                DestinatarioSerseDto destinatarioIn = new DestinatarioSerseDto();
                destinatarioIn.setOreFrequenza(incontroDestinatarioServizioDTO.getOrePresenza());
                destinatarioIn.setNome(destinatarioDTO.getNomeDestinatario());
                destinatarioIn.setCognome(destinatarioDTO.getCognomeDestinatario());
                destinatarioIn.setCodFiscale(destinatarioDTO.getCfDestinatario());
    
                destinatarioSerseDtoSIn.add(destinatarioIn);
    
    
            }
            SoggettoAttuatoreDTO soggettoAttuatoreServizio =  soggettoAttuatoreDAOCustom.getSoggettoBeneficiario(servizio.getSoggettoAttuatore().getIdSoggettoAttuatore());
    
            input.setCodiceTipoMateria(TIPO_MATERIA_SERSE);
            input.setCodiceTipoRichiesta(TIPO_RICHIESTA_EROGAZIONE_ATTIVITA);
            input.setIdPso(body.getIdPso());
            input.setIdSportello(body.getNumProgrSportello());
            input.setGruppoOperatoreSF(soggettoAttuatoreServizio.getGruppoOperatore());
            input.setCodiceOperatoreSF(soggettoAttuatoreServizio.getCodOperatore().longValue());
            input.setNumeroDomanda(soggettoAttuatoreServizio.getModelId().longValue());
            input.setAreaTerritoriale(servizio.getAreaTerritoriale().getCodAreaTerritoriale());
            input.setIdServizio(servizio.getIdServizio());
            input.setIdIncontro(incontro.getIdIncontro());
            input.setGruppoAttuatore(body.getGruppoOperatore());
            input.setCodiceAttuatore(body.getCodOperatore());
            input.setCodiceSede(null);
            input.setSedeOccasionale(sedeOccasionale);
            input.setDenomIncontro(incontro.getTitoloIncontro());
    
            input.setDataInizio(DateUtils.getXmlGregorianCalendarDate(incontro.getDInizio()));
            input.setDataFine(DateUtils.getXmlGregorianCalendarDate(incontro.getDFine()));
    
            input.setDurataPrevista(incontro.getDurataOre());
            input.setNumDestinatariMax(numDestinatario.longValue());
    
            input.getElencoDestinatari().addAll(destinatarioSerseDtoSIn);
        
            input.setDataPrimaRegistrazione(DateUtils.getXmlGregorianCalendarDate(incontro.getDInserim()));

            SerseTTokenGamDTO tokenGamDTO = tokenGamManager.insertTokenGam(body.getServizio().getIdServizio(), incontro.getIdIncontro(), TIPO_RICHIESTA_EROGAZIONE_ATTIVITA, input, body.getCodiceFiscaleUtente());

            // N.B. il token non apparirà su DB nel campo xml, pazienza
            input.setTkServizio(tokenGamDTO.getIdTokenGam());

            String codStatoRichiesta = KO;
            String desStatoRichiesta = ERR_CHIAMATA_GAM;
            String tokenElabGam = null;
            try {
                GestInterscMaterieNuovoIncontroSrvSerseOutput output = operscambHelper.gestInterscMaterieNuovoIncontroSrvSerse(input);
                codStatoRichiesta = output.getAsyncResult().getCodiceEsito();
                desStatoRichiesta = output.getAsyncResult().getDescrizioneEsito();
                tokenElabGam = output.getAsyncResult().getToken();
                
            } catch (Throwable e) {
                // Questo codice è temporaneo. invioEmailErrore deve essere eliminato e i catch devono catturare solo Exceptions, non Throwable.
                invioEmailErrore(e);
                return super.internalServerError();
            } finally {
                try {
                    tokenGamManager.updateTokenGamAsync(tokenGamDTO, tokenElabGam, codStatoRichiesta, desStatoRichiesta);
                } catch (Throwable e) {
                    invioEmailErrore(e);
                }
            }

            return Response.ok(tokenGamDTO).build();

        } catch (Exception e) {
            return super.internalServerError();
        }
    }

    public Response getTokenGamForIdIncontro(Long idIncontro, String codTipoRichiestaGam){
        List<String> parametriMancanti = new ArrayList<>();

        if (idIncontro == null) {
            parametriMancanti.add(INPUT_MISSING.ID_INCONTRO);
        }
        if(!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }

        SerseTTokenGamSelector tokenGamSelector = new SerseTTokenGamSelector();
        SerseTTokenGamSelector.Criteria tokenGamCriteria = tokenGamSelector.createCriteria();
        tokenGamCriteria.andIdIncontroEqualTo(idIncontro);

        if(codTipoRichiestaGam != null)
            tokenGamCriteria.andCodTipoRichiestaGamEqualTo(codTipoRichiestaGam);

        List<SerseTTokenGamDTO> tokenGamDTO =  tokenGamDAOGenerato.selectByExample(tokenGamSelector);
        List<TokenGam> tokenGamVo = mybatisMapper.mapListTokenGam(tokenGamDTO);
        return Response.ok(tokenGamVo).build();
    }

    public Long int2long(Integer x) {
        return x != null ? x.longValue() : null;
    }

    public Response riapriIncontroSerse(ServizioGamIncontro body) {
        try {
            Servizio servizio = body.getServizio();
            Incontro incontro = body.getIncontro();
            
            GestInterscMaterieRiapriIncontroDiServizioInput input = new GestInterscMaterieRiapriIncontroDiServizioInput();
            input.setCodTipoMateria(TIPO_MATERIA_SERSE);
            input.setCodTipoRichiesta(TIPO_RICHIESTA_ELIMINA_INCONTRO);
            input.setIdentificativoServizio (servizio.getIdServizio());
            input.setIdentificativoIncontro(incontro.getIdIncontro());

            SerseTTokenGamDTO tokenGamDTO = tokenGamManager.insertTokenGam(body.getServizio().getIdServizio(), incontro.getIdIncontro(), TIPO_RICHIESTA_ELIMINA_INCONTRO, input, body.getCodiceFiscaleUtente());

            String codStatoRichiesta = KO;
            String desStatoRichiesta = ERR_CHIAMATA_GAM;
            GestInterscMaterieRiapriIncontroDiServizioOutput output = null;
            try {

                output = operscambHelper.gestInterscMaterieRiapriIncontroDiServizio(input);

                codStatoRichiesta = output.getEsito().getCodice();
                desStatoRichiesta = output.getEsito().getDescrizione();

            } finally {
                tokenGamManager.updateTokenGamSync(tokenGamDTO, codStatoRichiesta, desStatoRichiesta, output);
            }

            if (ESITO_OK.equals(output.getEsito().getCodice())) {
                doRiapriIncontro(incontro.getIdIncontro(), servizio.getIdServizio());
            } else {
                Errore error = new Errore();
                error.setErrorMessage(output.getEsito().getDescrizione());
                error.setCode(400);
                return  Response.status(400).entity(error).build();
            }

            return Response.ok().build();

        } catch (Exception e) {
            return super.internalServerError();
        }
    }

    protected void doRiapriIncontro(long idIncontro, long idServizio) {
        // riapertura dell'incontro
        SerseTIncontroSelector incontroSelector = new SerseTIncontroSelector();
        SerseTIncontroSelector.Criteria incontroCriteria = incontroSelector.createCriteria();
        incontroCriteria.andIdIncontroEqualTo(idIncontro);
        SerseTIncontroDTO incontroDb = incontroDAO.selectByExample(incontroSelector).get(0);

        incontroDb.setIdStatoIncontro(STATO_INCONTRO_IN_DEF);
        incontroDb.setCodUserAggiorn("GAM");
        incontroDb.setdAggiorn(incontroDAO.getNow());
        incontroDb.setCodUserChiusura(null);
        incontroDb.setdChiusura(null);

        incontroDAO.updateByPrimaryKey(incontroDb);

        // ora, se ci sono altri incontri chiusi il servizio resta Avviato, 
        // se invece questo era l'unico incontro chiuso, il servizio deve tornare in Finanziato
        incontroSelector = new SerseTIncontroSelector();
        incontroCriteria = incontroSelector.createCriteria();
        incontroCriteria.andIdServizioEqualTo(idServizio);
        incontroCriteria.andIdStatoIncontroEqualTo(STATO_INCONTRO_CHIUSO);
        List<SerseTIncontroDTO> incontri = incontroDAO.selectByExample(incontroSelector);
        if (incontri.isEmpty()) {
            SerseTServizioDTO s = serviziDao.selectByPrimaryKey(idServizio);
            s.setIdStatoServizio(STATO_SERVIZIO_FINANZIATO);
            serviziDao.updateByPrimaryKey(s);
        }
    }

    public Response riportaServizioInDefinizione(ServizioGamRiapriServizio body) {

        try {
            
            Long idServizio = body.getIdServizio();

            GestInterscMaterieEliminaServizioIncontriInput input = new GestInterscMaterieEliminaServizioIncontriInput();
            input.setCodTipoMateria(TIPO_MATERIA_SERSE);
            input.setCodTipoRichiesta(TIPO_RICHIESTA_ELIMINA_INCONTRI);
            input.setIdentificativoServizio (idServizio);

            SerseTTokenGamDTO tokenGamDTO = tokenGamManager.insertTokenGam(idServizio, null, TIPO_RICHIESTA_ELIMINA_INCONTRI, input, body.getCodiceFiscaleUtente());

            String codStatoRichiesta = KO;
            String desStatoRichiesta = ERR_CHIAMATA_GAM;
            GestInterscMaterieEliminaServizioIncontriOutput output = null;

            try {
                output = operscambHelper.gestInterscMaterieEliminaServizioIncontri(input);
                codStatoRichiesta = output.getEsito().getCodice();
                desStatoRichiesta = output.getEsito().getDescrizione();

            } finally {
                tokenGamManager.updateTokenGamSync(tokenGamDTO, codStatoRichiesta, desStatoRichiesta, output);
            }

            if (ESITO_OK.equals(output.getEsito().getCodice())) {
                doRiapriServizio(idServizio);
            } else {
                Errore error = new Errore();
                error.setErrorMessage(output.getEsito().getDescrizione());
                error.setCode(400);
                return  Response.status(400).entity(error).build();
            }

            return Response.ok().build();

        }catch (Exception e) {
            return super.internalServerError();
        }
    }

    private void doRiapriServizio(long idServizio) {

        // aggiornamento stato servizio
        SerseTServizioDTO svc = serviziDao.selectByPrimaryKey(idServizio);
        svc.setIdStatoServizio(STATO_SERVIZIO_IN_DEF);
        svc.setCodUserAggiorn("GAM");
        svc.setdAggiorn(serviziDao.getNow());
        serviziDao.updateByPrimaryKey(svc);

        // riapertura di tutti gli incontri
        incontroDAOCustom.riapriIncontri(idServizio);

        // eliminazione eventuali record collegati
        SerseRServizioFonteSelector selectorFonte = new SerseRServizioFonteSelector();
        selectorFonte.createCriteria().andIdServizioEqualTo(idServizio);
        servizioFonteDao.deleteByExample(selectorFonte);

        SerseRServizioVoceSpesaSelector selectorVoce = new SerseRServizioVoceSpesaSelector();
        selectorVoce.createCriteria().andIdServizioEqualTo(idServizio);
        servizioVoceSpesaDao.deleteByExample(selectorVoce);


        //aggiungo delete dello storico di quella domanda
        SerseTServizioStoSelector selectorStorioco = new SerseTServizioStoSelector();
        selectorStorioco.createCriteria().andIdServizioEqualTo(idServizio);
        servizioStoDao.deleteByExample(selectorStorioco);
    }

	//Chiamata GAM per la chiusura del servizio
	public Response chiudiServizio(ServizioGamChiudiServizio body){
		try {
			SerseTServizioDTO servizioDTO = serviziDao.selectByPrimaryKey(body.getIdServizio());
			Servizio servizio = voMapper.servizioToVo(servizioDTO);
			GestInterscMaterieConcludiServizioSerseInput input = new GestInterscMaterieConcludiServizioSerseInput();

			SoggettoAttuatoreDTO soggettoAttuatoreServizio =  soggettoAttuatoreDAO.getSoggettoBeneficiario(servizio.getSoggettoAttuatore().getIdSoggettoAttuatore());

			input.setCodiceTipoMateria(TIPO_MATERIA_SERSE);
			input.setCodiceTipoRichiesta(TIPO_RICHIESTA_CHIUSURA_SERVIZIO);
			input.setIdPso(body.getIdPso());
			input.setIdSportello(body.getNumProgrSportello());
			input.setNumeroDomanda(soggettoAttuatoreServizio.getModelId().longValue());
			input.setGruppoOperatore(soggettoAttuatoreServizio.getGruppoOperatore());
			input.setCodiceOperatore(soggettoAttuatoreServizio.getCodOperatore().longValue());
			input.setAreaTerritoriale(servizio.getAreaTerritoriale().getCodAreaTerritoriale());
			input.setIdServizio(servizio.getIdServizio());
			
			input.setDataChiusuraServizio(DateUtils.getXmlGregorianCalendarDate(body.getDataChiusuraServizio()));

            SerseTTokenGamDTO tokenGamDTO = tokenGamManager.insertTokenGam(body.getIdServizio(), null, TIPO_RICHIESTA_CHIUSURA_SERVIZIO, input, body.getCodiceFiscaleUtente());

            String codStatoRichiesta = KO;
            String desStatoRichiesta = ERR_CHIAMATA_GAM;
            GestInterscMaterieConcludiServizioSerseOutput output = null;
            try {
                output = operscambHelper.gestInterscMaterieConcludiServizioSerse(input);
                codStatoRichiesta = output.getEsito().getCodice();
                desStatoRichiesta = output.getEsito().getDescrizione();
            } finally {
                tokenGamManager.updateTokenGamSync(tokenGamDTO, codStatoRichiesta, desStatoRichiesta, output);
            }

			if(!output.getEsito().getCodice().equals(ESITO_OK)){

				Errore error=new Errore();
				error.setErrorMessage(output.getEsito().getCodice() + " - " + output.getEsito().getDescrizione());
				error.setCode(501);
				return  Response.ok().entity(error).build();
			}

			servizioDTO.setIdStatoServizio(40L);
			servizioDTO.setdChiusuraServizio(body.getDataChiusuraServizio());
			servizioDTO.setCodUserAggiorn(body.getCodiceFiscaleUtente());
			servizioDTO.setdAggiorn(serviziDao.getNow());
			serviziDao.updateByPrimaryKey(servizioDTO);

			return  Response.ok(voMapper.servizioToVo(servizioDTO)).build();

		} catch (Exception e) {
            return super.internalServerError();
		}
	}

	@Transactional
	public Response insertTokenGam(ServizioGamPropostaModifica body) {
		SoggettoAttuatoreDTO soggettoAttuatoreServizio =  soggettoAttuatoreDAO.getSoggettoBeneficiario(body.getServizio().getSoggettoAttuatore().getIdSoggettoAttuatore());

		GestInterscMaterieModificaServizioSerseInput input = new GestInterscMaterieModificaServizioSerseInput();
		input.setCodiceTipoMateria(TIPO_MATERIA_SERSE);
		input.setCodiceTipoRichiesta(TIPO_RICHIESTA_MODIFICA_BUGDET);
		input.setIdPso(body.getIdPso());
		input.setIdSportello(body.getNumProgrSportello());
		input.setNumeroDomanda(soggettoAttuatoreServizio.getModelId().longValue());
		input.setGruppoOperatore(soggettoAttuatoreServizio.getGruppoOperatore());
		input.setCodiceOperatore(soggettoAttuatoreServizio.getCodOperatore().longValue());
		input.setAreaTerritoriale(body.getServizio().getAreaTerritoriale().getCodAreaTerritoriale());
		input.setIdServizio(body.getServizio().getIdServizio());
		input.setDurata(body.getDurataOreProposta());
		input.setNumDestinatariMax(body.getNumMaxDestinatariProposto());

        SerseTTokenGamDTO tokenGamDTO = tokenGamManager.insertTokenGam(body.getServizio().getIdServizio(), null, TIPO_RICHIESTA_MODIFICA_BUGDET,
            input, body.getCodiceFiscaleUtente(), body.getDurataOreProposta(), body.getNumMaxDestinatariProposto());

        // N.B. il token non apparirà su DB nel campo xml, pazienza
        input.setTkServizio(tokenGamDTO.getIdTokenGam());

		try {

            GestInterscMaterieModificaServizioSerseOutput modificaServizioOuput;
            String codStatoRichiesta = KO;
            String desStatoRichiesta = ERR_CHIAMATA_GAM;
            String tokenElabGam = null;
            try {
                modificaServizioOuput = operscambHelper.gestInterscMaterieGetEsitoServizioSerse(input);
                codStatoRichiesta = modificaServizioOuput.getAsyncResult().getCodiceEsito();
                desStatoRichiesta = modificaServizioOuput.getAsyncResult().getDescrizioneEsito();
                tokenElabGam = modificaServizioOuput.getAsyncResult().getToken();

            } catch (Throwable e) {
                // Questo codice è temporaneo. invioEmailErrore deve essere eliminato e i catch devono catturare solo Exceptions, non Throwable.
                invioEmailErrore(e);
                return super.internalServerError();
            } finally {
                try {
                    tokenGamManager.updateTokenGamAsync(tokenGamDTO, tokenElabGam, codStatoRichiesta, desStatoRichiesta);
                } catch (Throwable e) {
                    invioEmailErrore(e);
                }
            }
			if(modificaServizioOuput.getAsyncResult().getCodiceEsito() != null ) {
				return Response.ok(tokenGamDTO).build();
			}
			GenericResponse responseNegativa= new GenericResponse();
			responseNegativa.setMessage(modificaServizioOuput.getAsyncResult().getCodiceEsito() + " - " + modificaServizioOuput.getAsyncResult().getDescrizioneEsito() + modificaServizioOuput.getAsyncResult().getToken());
			return Response.ok(responseNegativa).build();

		} catch (Exception e) {
            return super.internalServerError();
		}
	}

    public void invioEmailErrore(Throwable t) {
        try {
            String msg = t.toString() + "\r\nStacktrace:\r\n" + Arrays.toString(t.getStackTrace());
            LOG.error("Sto per inviare un'email di errore: {}", msg);
            // mail rimossa piergiorgio.chiriotti@consulenti.csi.it,
            mailUtil.sendMail("luca.vercelli@consulenti.csi.it",
                mailUtil.getMailAssistenza(), "[serse] Eccezione in comunicazione con GAM", msg);
        } catch (Throwable w) {
            LOG.error("Eccezione nell'invio dell'email", w);
        }
    }
}
