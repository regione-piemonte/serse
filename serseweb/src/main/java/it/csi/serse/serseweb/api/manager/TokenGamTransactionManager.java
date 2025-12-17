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

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTTokenGamDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTTokenGamDTO;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.utils.JsonUtils;

@Component
public class TokenGamTransactionManager extends ParentManager {

    @Autowired
    private SerseTTokenGamDAO tokenGamDAOGenerato;

    /**
     * Crea un record nella <code>serse_t_token_gam</code>. Questo metodo deve
     * essere chiamato
     * prima di ogni chiamata a GAM.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SerseTTokenGamDTO insertTokenGam(Long idServizio, Long idIncontro, String tipoRichiesta, Object input,
            String cfUtenteCollegato) {
        SerseTTokenGamDTO tokenGamDTO = new SerseTTokenGamDTO();
        insertTokenGamCommon(tokenGamDTO, idServizio, idIncontro, tipoRichiesta, input, cfUtenteCollegato);
        return tokenGamDTO;
    }

    /**
     * Crea un record nella <code>serse_t_token_gam</code> (variante con più parametri). Questo metodo deve essere chiamato
     * prima di ogni chiamata a GAM.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SerseTTokenGamDTO insertTokenGam(Long idServizio, Long idIncontro, String tipoRichiesta, Object input,
            String cfUtenteCollegato, BigDecimal durataOreProposta, Long numMaxDestinatariProposto) {
        SerseTTokenGamDTO tokenGamDTO = new SerseTTokenGamDTO();
        tokenGamDTO.setDurataOreProposta(durataOreProposta);
        tokenGamDTO.setNumMaxDestinatariProposto(numMaxDestinatariProposto);
        insertTokenGamCommon(tokenGamDTO, idServizio, idIncontro, tipoRichiesta, input, cfUtenteCollegato);
        return tokenGamDTO;
    }

    private void insertTokenGamCommon(SerseTTokenGamDTO tokenGamDTO, Long idServizio, Long idIncontro, String tipoRichiesta,
            Object input, String cfUtenteCollegato) {

        tokenGamDTO.setIdTokenGam(tokenGamDAOGenerato.getNextValIdTokenGam());
        tokenGamDTO.setIdServizio(idServizio);
        tokenGamDTO.setIdIncontro(idIncontro);
        tokenGamDTO.setCodTipoRichiestaGam(tipoRichiesta);
        tokenGamDTO.setCodStatoRichiesta("-"); // campo not null
        tokenGamDTO.setDescrStatoRichiesta("-"); // campo not null
        tokenGamDTO.setdInvioRichiesta(tokenGamDAOGenerato.getNow());
        tokenGamDTO.setUtenteInvioRichiesta(cfUtenteCollegato);
        tokenGamDTO.setCodUserInserim(cfUtenteCollegato);
        tokenGamDTO.setCodUserAggiorn(cfUtenteCollegato);
        tokenGamDTO.setdUserInserim(tokenGamDAOGenerato.getNow());
        tokenGamDTO.setdAggiorn(tokenGamDAOGenerato.getNow());

        try {
            String xml = JsonUtils.convertObjectToJson(input);
            tokenGamDTO.setXmlRichiesta(xml);
        } catch (IOException e) {
            LOG.error("Eccezione nella generazione dell'XML input", e);
            tokenGamDTO.setXmlRispostaElaborazione("-"); // campo not null
        }

        tokenGamDAOGenerato.insert(tokenGamDTO);
    }

    /**
     * Aggiorna un record nella <code>serse_t_token_gam</code>. Questo metodo deve
     * essere
     * chiamato dopo ogni chiamata asincrona a GAM, dentro un
     * <code>finally</code>.<br/>
     * Nel caso delle chiamate asincrone, non ci interessa salvare l'output della
     * richiesta. Invece ci interessa il tokenElabGam (identificativo staccato da
     * GAM).
     * L'output verrà salvato successivamente da serseapi.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SerseTTokenGamDTO updateTokenGamAsync(SerseTTokenGamDTO tokenGamDTO, String tokenElabGam,
            String codStatoRichiesta, String desStatoRichiesta) {

        if (tokenElabGam != null)
            tokenGamDTO.setIdTokenElabGam(Long.parseLong(tokenElabGam));
        tokenGamDTO.setCodStatoRichiesta(codStatoRichiesta);
        if (!codStatoRichiesta.equals("PC"))
            tokenGamDTO.setDescrStatoRichiesta(desStatoRichiesta);
        else
            tokenGamDTO.setDescrStatoRichiesta(Constants.RISPOSTE_RESPONSE.PRESA_CARICO);
        tokenGamDTO.setdAggiorn(tokenGamDAOGenerato.getNow());

        tokenGamDAOGenerato.updateByPrimaryKey(tokenGamDTO);
        return tokenGamDTO;
    }

    /**
     * Aggiorna un record nella <code>serse_t_token_gam</code>. Questo metodo deve
     * essere
     * chiamato dopo ogni chiamata sincrona a GAM, dentro un
     * <code>finally</code>.<br/>
     * Nel caso delle chiamate sincrone, non viene staccato alcun tokenElabGam,
     * salviamo l'intero output.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SerseTTokenGamDTO updateTokenGamSync(SerseTTokenGamDTO tokenGamDTO, String codStatoRichiesta,
            String desStatoRichiesta, Object output) {

        tokenGamDTO.setCodStatoRichiesta(codStatoRichiesta);
        tokenGamDTO.setDescrStatoRichiesta(desStatoRichiesta);
        tokenGamDTO.setCodStatoElaborazione("-");
        tokenGamDTO.setCodEsitoElaborazione("-");
        tokenGamDTO.setDescrEsitoElaborazione("-");
        tokenGamDTO.setdElaborazione(tokenGamDAOGenerato.getNow());
        tokenGamDTO.setdAggiorn(tokenGamDAOGenerato.getNow());

        try {
            String xml = JsonUtils.convertObjectToJson(output);
            tokenGamDTO.setXmlRispostaElaborazione(xml);
        } catch (IOException e) {
            LOG.error("Eccezione nella generazione dell'XML output", e);
        }

        tokenGamDAOGenerato.updateByPrimaryKey(tokenGamDTO);
        return tokenGamDTO;
    }
}
