package it.csi.serse.serseapi.api.manager;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.csi.serse.serseapi.api.exception.ErroreGestitoException;
import it.csi.serse.serseapi.integration.mybatis.dao.custom.GestInterscSerseDAO;
import it.csi.serse.serseapi.integration.mybatis.dto.custom.DestinatarioDTO;
import it.csi.serse.serseapi.integration.mybatis.dto.custom.ServiziDestinatarioDTO;
import it.csi.serse.serseapi.integration.mybatis.dao.custom.DestinatariDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dao.SerseRServizioFonteDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dao.SerseRServizioVoceSpesaDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dao.SerseTDestinatarioDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dao.SerseTIncontroDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dao.SerseTServizioStoDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dao.SerseTTokenGamDAO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseRServizioFonteDTO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseRServizioFonteSelector;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseRServizioVoceSpesaDTO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseRServizioVoceSpesaSelector;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseTDestinatarioDTO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseTDestinatarioSelector;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseTIncontroDTO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseTServizioStoDTO;
import it.csi.serse.serseapi.integration.mybatis.generated.dto.SerseTTokenGamDTO;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.AkOperatore;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseapi.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseapi.mapper.VoMapper;
import it.csi.serse.serseapi.utils.Constants;
import it.csi.serse.serseapi.vo.AcquisisciElaborazioneGAMInput;
import it.csi.serse.serseapi.vo.AcquisisciElaborazioneGAMOutput;
import it.csi.serse.serseapi.vo.OutputEsposizioneAnagrafiche;
import it.csi.serse.serseapi.vo.OutputEsposizioneServizi;
import it.csi.serse.serseapi.vo.OutputEsposizioneServiziItem;
import it.csi.serse.serseapi.vo.ServizioFonte;
import it.csi.serse.serseapi.vo.VociSpesaServizio;
import jakarta.ws.rs.core.Response;

@Component
public class GestInterscSerseManager extends ParentManager {

    private static final Logger logger = LoggerFactory.getLogger(Constants.COD_COMPONENTE + ".manager");

    @Autowired
    private SerseTTokenGamDAO serseTTokenGamDAO;

    @Autowired
    private SerseTServizioDAO serseTServizioDAO;

    @Autowired
    private SerseRServizioVoceSpesaDAO serseRServizioVoceSpesaDAO;

    @Autowired
    private SerseRServizioFonteDAO serseRServizioFonteDAO;

    @Autowired
    private SerseTDestinatarioDAO serseTDestinatarioDAO;

    @Autowired
    private SerseTServizioStoDAO serseTServizioStoDAO;

    @Autowired
    private GestInterscSerseDAO gestInterscSerseDAO;

    @Autowired
    private SerseTIncontroDAO serseTIncontroDAO;

    @Autowired
    private DestinatariDAO destinatariDAOcustom;
    
    @Autowired
    private FlaianagpgHelper flaiAnag;

    @Autowired
    private VoMapper voMapper;

    @Transactional
    public Response acquisisciElaborazioneGAM(AcquisisciElaborazioneGAMInput body) {

        logger.info("GestInterscSerseManager::acquisisciElaborazioneGAM2 \n{}", body);

        AcquisisciElaborazioneGAMOutput response;
        String codiceTipoRichiesta = body.getCodTipoRichiesta();
        String codStatoElaborazione = body.getCodStatoElaborazione();

        // controllo parametri obbligatori
        List<String> parametriObbligatori = checkCampiObbligatori(body);
        if (!parametriObbligatori.isEmpty()) {
            return parametriObbligatoriMancanti(parametriObbligatori);
        }

        // controlli preliminari sul token in arrivo e quello presente su SERSE

        // 2025-08 LV il token che riceviamo non è più il token
        // interno di GAM, ma l'id_token generato da serse
        SerseTTokenGamDTO testToken = serseTTokenGamDAO.selectByPrimaryKey(body.getToken());

        response = testToken(testToken, body.getCodTipoRichiesta());
        if (response.getCodiceEsito() != null) {
            logger.error("Chiamata anomala da GAM, codice esito={}", response.getCodiceEsito());
            // sendEmailV2(body, response.getCodiceEsito());
            // non mandiamo email, la manderà GAM
            return Response.ok(response).build();
        }

        SerseTTokenGamDTO serseTTokenGamDTO = initTokenGam(body);
        serseTTokenGamDTO.setdAggiorn(serseTTokenGamDAO.getNow());

        logger.info("GestInterscSerseManager::acquisisciElaborazioneGAM codStatoElaborazione: {}",
                codStatoElaborazione);

        /*
         * controllo lo stato dell'elaborazione se ha avuto successo oppure se è
         * risultato un errore
         */
        if (codStatoElaborazione.equals("IR") || codStatoElaborazione.equals("ET")) {

            // sendEmail(body,codStatoElaborazione);
            serseTTokenGamDAO.updateByPrimaryKey(serseTTokenGamDTO);
            // rispondo ok anche se l'elaborazione non è andata a buon fine perchè
            // sto solo controllando che il risultato dell'elaborazione GAM corrisponda a
            // quanto salvato su SERSE
            response.setCodiceEsito("0");
            response.setDescrizioneEsito("OK");

            return Response.ok().entity(response).build();
        } else {

            logger.info("GestInterscSerseManager::acquisisciElaborazioneGAM codiceTipoRichiesta: {}",
                    codiceTipoRichiesta);

            SerseTServizioDTO serseTServizioDTO = serseTServizioDAO
                    .selectByPrimaryKey(serseTTokenGamDTO.getIdServizio());
            switch (codiceTipoRichiesta) {
                // Richiesta finanziamento, impegno del budget
                case "01":
                    serseTTokenGamDAO.updateByPrimaryKey(serseTTokenGamDTO);
                    saveVoceSpesaServizio(body.getResponseGam().getVociSpesa(), body.getToken());
                    saveFontiServizio(body.getResponseGam().getFontiServizio(), body.getToken());

                    serseTServizioDTO.setdAggiorn(serseTServizioDAO.getNow());
                    serseTServizioDTO.setCodUserAggiorn("GAM");
                    serseTServizioDTO.setIdStatoServizio(22L);

                    serseTServizioDAO.updateByPrimaryKey(serseTServizioDTO);
                    break;
                // richiesta modifica del budget
                case "03":
                    BigDecimal totaleSpesaPrecedente = BigDecimal.ZERO;

                    SerseRServizioVoceSpesaSelector servizioVoceSpesaSelector = new SerseRServizioVoceSpesaSelector();
                    SerseRServizioVoceSpesaSelector.Criteria criteriaVoceSpesa = servizioVoceSpesaSelector
                            .createCriteria();
                    criteriaVoceSpesa.andIdServizioEqualTo(serseTTokenGamDTO.getIdServizio());

                    List<SerseRServizioVoceSpesaDTO> servizioVoceSpesaDTOList = serseRServizioVoceSpesaDAO
                            .selectByExample(servizioVoceSpesaSelector);
                    String tipoVariazione = checkVoceSpesa(servizioVoceSpesaDTOList,
                            body.getResponseGam().getVociSpesa());

                    // voce spesa prima della richiesta
                    for (SerseRServizioVoceSpesaDTO voceSpesa : servizioVoceSpesaDTOList) {
                        totaleSpesaPrecedente = totaleSpesaPrecedente.add(voceSpesa.getImportoVoceSpesa());
                    }

                    /* update della variazione della spesa */
                    serseTTokenGamDTO.setCodTipoVariazioneFinanziamento(tipoVariazione);
                    serseTTokenGamDTO.setImportoFinanziatoPrecedente(totaleSpesaPrecedente);
                    serseTTokenGamDAO.updateByPrimaryKey(serseTTokenGamDTO);

                    saveVoceSpesaServizio(body.getResponseGam().getVociSpesa(), body.getToken());
                    saveFontiServizio(body.getResponseGam().getFontiServizio(), body.getToken());

                    SerseTServizioStoDTO servizioStoDTO = new SerseTServizioStoDTO();
                    servizioStoDTO.setIdServizio(serseTTokenGamDTO.getIdServizio());
                    servizioStoDTO.setPreventivoPrecedente(totaleSpesaPrecedente);
                    servizioStoDTO.setTipoVariazione(tipoVariazione);
                    servizioStoDTO.setUtenteVariazione(serseTTokenGamDTO.getCodUserInserim());
                    servizioStoDTO.setdVariazione(serseTServizioStoDAO.getNow());
                    servizioStoDTO.setIdServizioSto(serseTServizioStoDAO.getNextValIdServizioSto() + 1L);

                    serseTServizioStoDAO.insert(servizioStoDTO);

                    serseTServizioDTO = serseTServizioDAO.selectByPrimaryKey(serseTTokenGamDTO.getIdServizio());
                    serseTServizioDTO.setdAggiorn(serseTServizioDAO.getNow());
                    serseTServizioDTO.setCodUserAggiorn("GAM");
                    serseTServizioDTO.setDurataOre(serseTTokenGamDTO.getDurataOreProposta());
                    serseTServizioDTO.setNumMaxDestinatari(serseTTokenGamDTO.getNumMaxDestinatariProposto());
                    serseTServizioDAO.updateByPrimaryKey(serseTServizioDTO);
                    break;

                // Richiesta di Preventivo
                case "04":
                    serseTTokenGamDAO.updateByPrimaryKey(serseTTokenGamDTO);

                    saveVoceSpesaServizio(body.getResponseGam().getVociSpesa(), body.getToken());

                    break;

                // CodTipoRichiesta = ’08’ (chiusura incontro)
                case "08":
                    serseTTokenGamDAO.updateByPrimaryKey(serseTTokenGamDTO);
                    SerseTIncontroDTO serseTIncontroDTO = serseTIncontroDAO
                            .selectByPrimaryKey(serseTTokenGamDTO.getIdIncontro());
                    serseTIncontroDTO.setIdStatoIncontro(40L);
                    serseTIncontroDTO.setCodUserAggiorn("GAM");
                    serseTIncontroDTO.setdAggiorn(serseTIncontroDAO.getNow());
                    serseTIncontroDAO.updateByPrimaryKey(serseTIncontroDTO);

                    SerseTServizioDTO servizioDTO = serseTServizioDAO
                            .selectByPrimaryKey(serseTIncontroDTO.getIdServizio());
                    if (servizioDTO.getIdStatoServizio().equals(22L)) {
                        servizioDTO.setIdStatoServizio(30L);
                        servizioDTO.setdAggiorn(serseTIncontroDAO.getNow());
                        servizioDTO.setCodUserAggiorn("GAM");
                        serseTServizioDAO.updateByPrimaryKey(servizioDTO);
                    }
                    break;

                default:
                    response.setCodiceEsito("2");
                    response.setDescrizioneEsito(
                            "Il codice tipo richiesta GAM non corrisponde a quello presente in SERSE per il token ricevuto");
                    return Response.ok().entity(response).build();
            }
        }
        response.setCodiceEsito("0");
        response.setDescrizioneEsito("OK");

        return Response.ok().entity(response).build();

    }

    private SerseTTokenGamDTO initTokenGam(AcquisisciElaborazioneGAMInput gamInput) {
        
        // 2025-08 LV il token che riceviamo non è più il token
        // interno di GAM, ma l'id_token generato da serse

        SerseTTokenGamDTO tmpToken = serseTTokenGamDAO.selectByPrimaryKey(gamInput.getToken());

        tmpToken.setCodStatoElaborazione(gamInput.getCodStatoElaborazione());
        tmpToken.setCodEsitoElaborazione(gamInput.getCodEsito());
        tmpToken.setDescrEsitoElaborazione(gamInput.getDescrStatoElaborazione());
        tmpToken.setdElaborazione(serseTTokenGamDAO.getNow());
        try {

            // 2025-02-07 LV salvo l'intero oggetto non solo il campo response
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(gamInput);
            tmpToken.setXmlRispostaElaborazione(json);
        } catch (JsonProcessingException e) {
            logger.error("GestIntersc", e);
            throw new ErroreGestitoException(e.getCause());
        }
        tmpToken.setCodUserAggiorn("GAM");
        tmpToken.setCodUserInserim("GAM");
        return tmpToken;
    }

    private SerseRServizioVoceSpesaDTO initVoceSpesa(VociSpesaServizio gamInput, Long token) {

        SerseTTokenGamDTO tmpToken = serseTTokenGamDAO.selectByPrimaryKey(token);
        SerseTServizioDTO tmpServizio = serseTServizioDAO.selectByPrimaryKey(tmpToken.getIdServizio());
        SerseRServizioVoceSpesaDTO servizioVoceSpesaDTO = new SerseRServizioVoceSpesaDTO();
        servizioVoceSpesaDTO.setIdPso(tmpServizio.getIdPso());
        servizioVoceSpesaDTO.setIdServizio(tmpServizio.getIdServizio());
        servizioVoceSpesaDTO.setCodNaturaSpesa(gamInput.getNaturaSpesa());
        servizioVoceSpesaDTO.setCodVoceSpesa(gamInput.getCodVoceSpesa());
        servizioVoceSpesaDTO.setParametroEconomico(gamInput.getUcs());
        servizioVoceSpesaDTO.setParametroFisico(gamInput.getNrDest());
        servizioVoceSpesaDTO.setParametroTemporale(gamInput.getDurata());
        servizioVoceSpesaDTO.setImportoVoceSpesa(gamInput.getImportoVS());
        servizioVoceSpesaDTO.setCodUserAggiorn("GAM");
        servizioVoceSpesaDTO.setdAggiorn(serseRServizioVoceSpesaDAO.getNow());
        servizioVoceSpesaDTO.setCodUserInserim("GAM");
        servizioVoceSpesaDTO.setdInserim(serseRServizioVoceSpesaDAO.getNow());

        return servizioVoceSpesaDTO;
    }

    private SerseRServizioFonteDTO initServizioFonte(ServizioFonte gamInput, Long token) {
        SerseTTokenGamDTO tmpToken = serseTTokenGamDAO.selectByPrimaryKey(token);

        SerseRServizioFonteDTO serseRServizioFonteDTO = new SerseRServizioFonteDTO();
        serseRServizioFonteDTO.setIdServizio(tmpToken.getIdServizio());
        serseRServizioFonteDTO.setIdFonte(gamInput.getIdFonte());
        serseRServizioFonteDTO.setDescrFonte(gamInput.getDescrFonte());
        serseRServizioFonteDTO.setPercFonte(gamInput.getPercFonte());
        serseRServizioFonteDTO.setImportoFonte(gamInput.getImportoFonte());
        serseRServizioFonteDTO.setCodTipologiaFonte(gamInput.getTipologiaFonte());
        serseRServizioFonteDTO.setdAggiorn(serseRServizioFonteDAO.getNow());
        serseRServizioFonteDTO.setCodUserAggiorn("GAM");
        serseRServizioFonteDTO.setdInserim(serseRServizioFonteDAO.getNow());
        serseRServizioFonteDTO.setCodUserInserim("GAM");
        return serseRServizioFonteDTO;
    }

    private List<String> checkCampiObbligatori(AcquisisciElaborazioneGAMInput input) {
        List<String> parametriMancanti = new ArrayList<>();
        if (input.getToken() == null) {
            parametriMancanti.add("token");
        }
        if (input.getCodEsito() == null) {
            parametriMancanti.add("codEsito");
        }
        if (input.getDescrEsito() == null) {
            parametriMancanti.add("descrEsito");
        }
        if (input.getCodStatoElaborazione() == null) {
            parametriMancanti.add("codStatoElaborazione");
        }
        if (input.getDescrStatoElaborazione() == null) {
            parametriMancanti.add("descrStatoElaborazione");
        }
        return parametriMancanti;
    }

    /**
     * Controlli preliminari sul token
     * Se ci sono errori, setta il codiceEsito e la DescrizioneEsito nella risposta
     * @param testToken lista di token, eventualmente vuota, non nulla
     */
    private AcquisisciElaborazioneGAMOutput testToken(SerseTTokenGamDTO testToken, String codTipoRichiesta) {
        AcquisisciElaborazioneGAMOutput response = new AcquisisciElaborazioneGAMOutput();
        if (testToken == null) {
            response.setCodiceEsito("1");
            response.setDescrizioneEsito(
                    "L'identificativo token ricevuto in ingresso non è presente nel sistema SERSE");

        } else if (!testToken.getCodTipoRichiestaGam().equals(codTipoRichiesta)) {
            logger.info("GestInterscSerseManager::testToken codTipoRichiesta: {}", codTipoRichiesta);
            logger.info("GestInterscSerseManager::testToken getCodTipoRichiestaGam: {}",
                    testToken.getCodTipoRichiestaGam());
            response.setCodiceEsito("2");
            response.setDescrizioneEsito(
                    "Il codice tipo richiesta GAM non corrisponde a quello presente in SERSE per il token ricevuto");

        }
        return response;
    }

    private String checkVoceSpesa(List<SerseRServizioVoceSpesaDTO> servizioVoceSpesaDTOList,
            List<VociSpesaServizio> vociSpesa) {
        BigDecimal totaleSpesaPrecedente = new BigDecimal(0);
        BigDecimal totaleSpesaAttuale = new BigDecimal(0);
        String tipoVariazione = "";
        // voce spesa prima della richiesta
        for (SerseRServizioVoceSpesaDTO voceSpesa : servizioVoceSpesaDTOList) {
            totaleSpesaPrecedente = totaleSpesaPrecedente.add(voceSpesa.getImportoVoceSpesa());
        }
        // voce spesa dopo la richiesta
        for (VociSpesaServizio voceSpesa : vociSpesa) {
            totaleSpesaAttuale = totaleSpesaAttuale.add(voceSpesa.getImportoVS());
        }

        if (totaleSpesaPrecedente.equals(totaleSpesaAttuale)) {
            tipoVariazione = "I";

        } else if (totaleSpesaPrecedente.compareTo(totaleSpesaAttuale) > 0) {
            tipoVariazione = "R";

        } else {
            tipoVariazione = "A";

        }
        return tipoVariazione;
    }

    private void saveVoceSpesaServizio(List<VociSpesaServizio> vociSpesaServizioList, Long token) {
        List<SerseRServizioVoceSpesaDTO> voceSpesaDto = new ArrayList<>();
        SerseTTokenGamDTO tmpToken = serseTTokenGamDAO.selectByPrimaryKey(token);

        SerseRServizioVoceSpesaSelector selector = new SerseRServizioVoceSpesaSelector();
        SerseRServizioVoceSpesaSelector.Criteria criteria = selector.createCriteria();
        criteria.andIdServizioEqualTo(tmpToken.getIdServizio());
        serseRServizioVoceSpesaDAO.deleteByExample(selector);

        for (VociSpesaServizio voceSpesa : vociSpesaServizioList) {
            SerseRServizioVoceSpesaDTO servizioVoceSpesaDTO = initVoceSpesa(voceSpesa, token);
            voceSpesaDto.add(servizioVoceSpesaDTO);
        }
        if (!voceSpesaDto.isEmpty()) {
            gestInterscSerseDAO.saveVoceSpesaServizio(voceSpesaDto);
        }
    }

    private void saveFontiServizio(List<ServizioFonte> fontiServizio, Long token) {
        List<SerseRServizioFonteDTO> servizioFonteDTOS = new ArrayList<>();

        SerseTTokenGamDTO tmpToken = serseTTokenGamDAO.selectByPrimaryKey(token);

        SerseRServizioFonteSelector selector = new SerseRServizioFonteSelector();
        SerseRServizioFonteSelector.Criteria criteria = selector.createCriteria();
        criteria.andIdServizioEqualTo(tmpToken.getIdServizio());
        serseRServizioFonteDAO.deleteByExample(selector);

        for (ServizioFonte fonteServizio : fontiServizio) {
            SerseRServizioFonteDTO serseRServizioFonteDTO = initServizioFonte(fonteServizio, token);
            servizioFonteDTOS.add(serseRServizioFonteDTO);
        }
        if (!servizioFonteDTOS.isEmpty()) {
            gestInterscSerseDAO.saveServiziFonte(servizioFonteDTOS);
        }
    }

    public Response esposizioneAnagraficaDestinatario(String cfDestinatario) {
        OutputEsposizioneAnagrafiche response = new OutputEsposizioneAnagrafiche();
        Response.Status httpStatusCode;

        if (StringUtils.isBlank(cfDestinatario)) {
            httpStatusCode = Response.Status.BAD_REQUEST;
            response.setCodiceEsito("PM");
            response.setDescrizioneEsito("Parametri mancanti");

        } else if (cfDestinatario.trim().length() != 16) {
            httpStatusCode = Response.Status.BAD_REQUEST;
            response.setCodiceEsito("PI");
            response.setDescrizioneEsito("Parametro non corretto: il codice fiscale inserito non è di 16 caratteri");

        } else {
            cfDestinatario = cfDestinatario.trim().toUpperCase();
            try {
                List<DestinatarioDTO> data = destinatariDAOcustom.getAnagraficheDestinatario(cfDestinatario);

                if (!data.isEmpty()) {
                    httpStatusCode = Response.Status.OK;
                    response.setCodiceEsito("OK");
                    response.setDescrizioneEsito("Estrazione terminata correttamente");
                    voMapper.updateMapping(response, data.get(0));
                    // N.B. constraint su DB -> viene estratto un unico record

                } else {
                    httpStatusCode = Response.Status.NOT_FOUND;
                    response.setCodiceEsito("UT");
                    response.setDescrizioneEsito("Il CF non è presente in SERSE");
                }

            } catch(Exception e) {
                logger.error("Eccezione non gestita", e);
                httpStatusCode = Response.Status.INTERNAL_SERVER_ERROR;
                response.setCodiceEsito("ET");
                response.setDescrizioneEsito("Errore tecnico, contattare l'assistenza");
            }
        }

        return Response.status(httpStatusCode).entity(response).build();
    }

    public Response esposizioneServiziDestinatario(String cfDestinatario) {
        OutputEsposizioneServizi response = new OutputEsposizioneServizi();
        Response.Status httpStatusCode;

        if (StringUtils.isBlank(cfDestinatario)) {
            httpStatusCode = Response.Status.BAD_REQUEST;
            response.setCodiceEsito("PM");
            response.setDescrizioneEsito("Parametri mancanti");

        } else if (cfDestinatario.trim().length() != 16) {
            httpStatusCode = Response.Status.BAD_REQUEST;
            response.setCodiceEsito("PI");
            response.setDescrizioneEsito("Parametro non corretto: il codice fiscale inserito non è di 16 caratteri");

        } else {
            cfDestinatario = cfDestinatario.trim().toUpperCase();
            try {
                List<SerseTDestinatarioDTO> destinatari = getDestinatario(cfDestinatario);

                if (destinatari.isEmpty()) {
                    httpStatusCode = Response.Status.NOT_FOUND;
                    response.setCodiceEsito("UT");
                    response.setDescrizioneEsito("Il CF non è presente in SERSE");
                } else {

                    // N.B. constraint su DB ci permette di dire che c'è un unico destinatario a parità di CF

                    response.setCodFiscaleDestinatario(destinatari.get(0).getCfDestinatario());
                    response.setNomeDestinatario(destinatari.get(0).getNomeDestinatario());
                    response.setCognomeDestinatario(destinatari.get(0).getCognomeDestinatario());
                    response.setDataNascitaDestinatario(destinatari.get(0).getdNascita());

                    List<ServiziDestinatarioDTO> data = destinatariDAOcustom.getServiziDestinatario(cfDestinatario);

                    if (!data.isEmpty()) {
                        httpStatusCode = Response.Status.OK;
                        response.setCodiceEsito("OK");
                        response.setDescrizioneEsito("Estrazione terminata correttamente");
                        List<OutputEsposizioneServiziItem> list = voMapper.mapServizi(data);
                        popolaDenominazioni(list);
                        response.setItems(list);

                    } else {
                        httpStatusCode = Response.Status.NOT_FOUND;
                        response.setCodiceEsito("ND");
                        response.setDescrizioneEsito("Nessun Servizio presente per il Destinatario indicato");
                    }
                }

            } catch(Exception e) {
                logger.error("Eccezione non gestita", e);
                httpStatusCode = Response.Status.INTERNAL_SERVER_ERROR;
                response.setCodiceEsito("ET");
                response.setDescrizioneEsito("Errore tecnico, contattare l'assistenza");
            }
        }

        return Response.status(httpStatusCode).entity(response).build();
    }

    /**
     * Carica tutti i record con dato c.f. (non è detto sia unico)
     * PRE: cfDestinatario != null
     */
    private List<SerseTDestinatarioDTO> getDestinatario(String cfDestinatario) {
        SerseTDestinatarioSelector selector = new SerseTDestinatarioSelector();
        SerseTDestinatarioSelector.Criteria criteria = selector.createCriteria();
        criteria.andCfDestinatarioEqualTo(cfDestinatario.trim().toUpperCase());
        return serseTDestinatarioDAO.selectByExample(selector);
    }

    /**
     * Popola le denominazioni di soggetto attuatore e soggetto beneficiario, prendendole da flaianag
     */
    void popolaDenominazioni(List<OutputEsposizioneServiziItem> list) {

        // primo, creo la lista delle chiavi (AK) degli operatori che mi servono
        List<AkOperatore> listAk = new ArrayList<>();
        Set<String> setOperatori = new HashSet<>();
        for (OutputEsposizioneServiziItem item: list) {
            addAkIfNotPresent(listAk, setOperatori, item.getGruppoSoggettoAttuatore(), item.getCodiceSoggettoAttuatore());
            addAkIfNotPresent(listAk, setOperatori, item.getGruppoSoggettoBeneficiario(), item.getCodiceSoggettoBeneficiario());
        }
        setOperatori.clear();

        // secondo, invoco flaianag
        List<SintesiPersonaGiuridica> listPg = flaiAnag.getElencoPGGCO(listAk);

        // terzo, mi creo una Map con le denominazioni
        Map<String, String> mapDenominazioni = toMapDenominazioni(listPg);

        // quarto, popolo le denominazioni a partire dalla Map
        for (OutputEsposizioneServiziItem item: list) {
            String grpCodSoggAttuatore = item.getGruppoSoggettoAttuatore() + item.getCodiceSoggettoAttuatore();
            if (mapDenominazioni.containsKey(grpCodSoggAttuatore)) {
                item.setDenominazioneSoggettoAttuatore(mapDenominazioni.get(grpCodSoggAttuatore));
            }
            String grpCodSoggBeneficiario = item.getGruppoSoggettoBeneficiario() + item.getCodiceSoggettoBeneficiario();
            if (mapDenominazioni.containsKey(grpCodSoggBeneficiario)) {
                item.setDenominazioneSoggettoBeneficiario(mapDenominazioni.get(grpCodSoggBeneficiario));
            }
        }
    }

    /**
     * Aggiunge la nuova AK alla lista, a meno che sia già presente in setOperatori, o che sia blank
     */
    private void addAkIfNotPresent(List<AkOperatore> listAk, Set<String> setOperatori, String grp, Integer cod) {
        if (StringUtils.isNotBlank(grp)) {
            String key = grp + cod;
            if (!setOperatori.contains(key)) {
                AkOperatore ak = new AkOperatore();
                ak.setCodiceGruppoOperatore(grp);
                ak.setCodiceOperatore(cod);
                listAk.add(ak);
                setOperatori.add(key);
            }
        }
    }

    /**
     * Estrae dalla lista solamente le denominazioni degli operatori
     * @return una mappa del tipo {B5:descrizione1,B6:descrizione2,...}
     */
    private Map<String, String> toMapDenominazioni(List<SintesiPersonaGiuridica> listPg) {
        Map<String, String> map = new HashMap<>();
        for (SintesiPersonaGiuridica item : listPg) {
            String key = item.getSintesiOperatore().getOperatore().getCodiceGruppoOperatore() + item.getSintesiOperatore().getOperatore().getCodiceOperatore();
            map.put(key, item.getDenominazionePersonaGiuridica());
        }
        return map;
    }
}
