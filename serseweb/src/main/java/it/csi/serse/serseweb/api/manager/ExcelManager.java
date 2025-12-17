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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.excel.ExcelExport;
import it.csi.serse.serseweb.helper.XlsUtils;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.DestinatariDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneModelliDiInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneModelliDiInterventoDAO.FilterModelliSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneServiziDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestioneServiziDAO.FilterServiziSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.IncontriDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.InterventiDAO;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.InterventiDAO.FilterInterventiSemplificato;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IncontroDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseDRegComportPsoSportDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoInterventoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoModelloDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTEnteCoinvoltoServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.SerseTServizioDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseDRegComportPsoSportSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTDestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoInterventoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoModelloSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTEnteCoinvoltoServizioSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.SerseTServizioSelector;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.AkOperatore;
import it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseweb.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.model.ExcelInterventoModel;
import it.csi.serse.serseweb.model.ExcelModelloModel;
import it.csi.serse.serseweb.model.ExcelServizioModel;
import it.csi.serse.serseweb.utils.Constants.INPUT_MISSING;
import it.csi.serse.serseweb.vo.ExcelInterventiBean;
import it.csi.serse.serseweb.vo.ExcelIntervento;
import it.csi.serse.serseweb.vo.ExcelModelliBean;
import it.csi.serse.serseweb.vo.ExcelModello;
import it.csi.serse.serseweb.vo.ExcelParentBean;
import it.csi.serse.serseweb.vo.ExcelServiziBean;
import it.csi.serse.serseweb.vo.ExcelServizio;
import it.csi.serse.serseweb.vo.FilterInterventi;
import it.csi.serse.serseweb.vo.FilterModelli;
import it.csi.serse.serseweb.vo.FilterParent;
import it.csi.serse.serseweb.vo.FilterServizi;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.StreamingOutput;

@Component
public class ExcelManager extends ParentManager {

    @Autowired
    private IncontriDAO incontriDAOCustom;

    @Autowired
    private DestinatariDAO destinatariDAOCustom;

    @Autowired
    private SerseTEnteCoinvoltoServizioDAO  enteCoinvoltoServizioDaoGenerato;

    @Autowired
    private SerseTEnteCoinvoltoInterventoDAO enteCoinvoltoInterventoDaoGenerato;

    @Autowired
    private SerseTEnteCoinvoltoModelloDAO enteCoinvoltoModelloDaoGenerato;

    @Autowired
    private GestioneModelliDiInterventoDAO modelliDiInterventoDAO;

    @Autowired
    private GenericMapper genericMapper;

    @Autowired
    private GestioneServiziDAO gestioneServiziDao;

	@Autowired
	private InterventiDAO interventiDao;

    @Autowired
    private SerseTServizioDAO servizioDAOGenerato;

    @Autowired
    private SerseDRegComportPsoSportDAO serseDRegComportPsoSportDAOGenerato;
    
    @Autowired
    XlsUtils xlsUtils;
    
    @Autowired
    FlaianagpgHelper flaianag;

    private ExcelExport excelExport=new ExcelExport();


    //########################################################
    //GESTIONE EXCEL MODELLO
    //########################################################

    public Response exportExcelModelli(List<ExcelModello> body) {
        List<ExcelModelloModel> excelModelli = genericMapper.mapListExcelModello(body);
        List<String> headers = new ArrayList<>();

        headers.add("PSO");
        headers.add("Sportello di riferimento");
        headers.add("Soggetto beneficiario");
        headers.add("Soggetto attuatore proprietario");
        headers.add("Istanza di candidatura");
        headers.add("Identificativo modello");
        headers.add("Titolo modello");
        headers.add("Tipologia modello");
        headers.add("Finalità modello");
        headers.add("Cognome_Nome Referente");
        headers.add("Stato Modello");
        headers.add("Tipologie dei Servizi previsti dal modello");
        headers.add("Previsti Servizi \"esterni\"");
        headers.add("Totale Interventi associati al modello");
        headers.add("Enti coinvolti");
        headers.add("Codice Fiscale Utente Inserimento");
        headers.add("Codice Fiscale Utente Ultima Modifica");

        excelModelli=getInterventiAssociati(excelModelli);
        excelModelli=getTipologieServiziPerModello(excelModelli);
        excelModelli=getEntiPerModello(excelModelli);
        return excelExport.addDataToWorkbook(excelModelli,headers);
    }
    public List<ExcelModelloModel> getEntiPerModello(List<ExcelModelloModel> input){
        List<ExcelModelloModel> output=new ArrayList<>();
        for (ExcelModelloModel excelInput:
                input
        ) {
            SerseTEnteCoinvoltoModelloSelector enteCoinvoltoModelloSelector=new SerseTEnteCoinvoltoModelloSelector();
            SerseTEnteCoinvoltoModelloSelector.Criteria criteria=enteCoinvoltoModelloSelector.createCriteria();
            criteria.andIdModelloDiInterventoEqualTo(excelInput.getIdModello());
            List<SerseTEnteCoinvoltoModelloDTO> enteCoinvoltoModelloDTOS=enteCoinvoltoModelloDaoGenerato.selectByExample(enteCoinvoltoModelloSelector);
            StringBuilder stringBuilder=new StringBuilder();
            for (SerseTEnteCoinvoltoModelloDTO ente:
                    enteCoinvoltoModelloDTOS
                 ) {
                stringBuilder
                        .append(ente.getDenominazione())
                        .append("\n\n");
            }

            excelInput.setEntiCoinvolti(stringBuilder.toString());
            output.add(excelInput);
        }

        return output;
    }

    public List<ExcelModelloModel> getTipologieServiziPerModello(List<ExcelModelloModel> input){
        List<ExcelModelloModel> output=new ArrayList<>();
        for (ExcelModelloModel excelInput:
                input
        ) {
            StringBuilder stringBuilder=new StringBuilder();
            String serviziEsterni="NO";
            List<ServizioModelloDTO> servizioRegionaleDTOList= gestioneServiziDao.getTipologieServiziForModelloIntervento(excelInput.getIdModello());

            for (ServizioModelloDTO servizioAssociato:
                    servizioRegionaleDTOList
                 ) {
                if(servizioAssociato==null){
                    System.out.println(excelInput.getIdModello());
                }else if(servizioAssociato.getServizioRegionale()!=null && (servizioAssociato.getDescrizioneServizioEsterno()==null || servizioAssociato.getDescrizioneServizioEsterno().isEmpty())){
                    stringBuilder
                            .append(servizioAssociato.getServizioRegionale().getCodiceServizioRegionale())
                            .append("-")
                            .append(servizioAssociato.getServizioRegionale().getDescrServizioRegionale())
                            .append("\n\n");
                }else{
                    serviziEsterni="SI";
                }
            }
            excelInput.setTipologieServizi(stringBuilder.toString());
            excelInput.setServiziEsterni(serviziEsterni);
            output.add(excelInput);
        }
        return output;
    }

    public List<ExcelModelloModel> getInterventiAssociati(List<ExcelModelloModel> input){
        List<ExcelModelloModel> output=new ArrayList<>();
        for (ExcelModelloModel excelInput:
                input
             ) {
            excelInput.setTotInterventiAssociati(modelliDiInterventoDAO.getDatiExcelModello(excelInput.getIdModello()));
            output.add(excelInput);
        }
        return output;
    }

    //########################################################
    //GESTIONE EXCEL INTERVENTO
    //########################################################
    public Response exportExcelInterventi(List<ExcelIntervento> body) {
        List<ExcelInterventoModel> excelInterventi = genericMapper.mapListExcelIntevento(body);

        List<String> headers = new ArrayList<>();
        headers.add("PSO");
        headers.add("Sportello di riferimento");
        headers.add("Soggetto beneficiario");
        headers.add("Soggetto attuatore proprietario");
        headers.add("Istanza di candidatura");
        headers.add("Identificativo intervento");
        headers.add("Titolo intervento");
        headers.add("Tipologia intervento");
        headers.add("Finalità intervento");
        headers.add("Identificativo modello di riferimento");
        headers.add("Cognome_Nome Referente");
        headers.add("Stato intervento");
        headers.add("Cognome_Nome Destinatario");
        headers.add("CF Destinatario");
        headers.add("Tipologie dei Servizi previsti dall\"intervento");
        headers.add("Totale servizi inclusi");
        headers.add("Totale servizi chiuso");
        headers.add("Enti coinvolti");
        headers.add("Codice Fiscale Utente Inserimento");
        headers.add("Codice Fiscale Utente Ultima Modifica");

        excelInterventi=getTipologieServiziForInterventi(excelInterventi);
        excelInterventi=getEntiCoinvoltiForInterventi(excelInterventi);
        excelInterventi=getServiziForInterventi(excelInterventi);

        return excelExport.addDataToWorkbook(excelInterventi,headers);
    }

    public List<ExcelInterventoModel> getServiziForInterventi(List<ExcelInterventoModel> input) {
        List<ExcelInterventoModel> output= new ArrayList<>();

        for (ExcelInterventoModel excelInput:
                input
        ) {



            SerseTServizioSelector selector=new SerseTServizioSelector();
            SerseTServizioSelector.Criteria criteria= selector.createCriteria();
            criteria.andIdInterventoEqualTo(excelInput.getIdIntervento());
            List<SerseTServizioDTO> serseTServizioList=servizioDAOGenerato.selectByExample(selector);

            Integer numServiziAssociati= serseTServizioList.size();
            Integer numServiziChiusi=0;

            for (SerseTServizioDTO s: serseTServizioList) {
                if(s.getIdStatoServizio().equals(40L)){
                   numServiziChiusi++;
                }
            }
            excelInput.setTotServizi(numServiziAssociati);
            excelInput.setTotServiziChiusi(numServiziChiusi);
            output.add(excelInput);
        }
        return output;
    }

    public List<ExcelInterventoModel> getEntiCoinvoltiForInterventi(List<ExcelInterventoModel> input) {
        List<ExcelInterventoModel> output= new ArrayList<>();

        for (ExcelInterventoModel excelInput:
                input
        ) {
            StringBuilder stringBuilder=new StringBuilder();
            SerseTEnteCoinvoltoInterventoSelector enteCoinvoltoInterventoSelector= new SerseTEnteCoinvoltoInterventoSelector();
            SerseTEnteCoinvoltoInterventoSelector.Criteria criteriaIntervento= enteCoinvoltoInterventoSelector.createCriteria();
            criteriaIntervento.andIdInterventoEqualTo(excelInput.getIdIntervento());
            List<SerseTEnteCoinvoltoInterventoDTO> enteCoinvoltoInterventoDTOS = enteCoinvoltoInterventoDaoGenerato.selectByExample(enteCoinvoltoInterventoSelector);

            for (SerseTEnteCoinvoltoInterventoDTO serseTEnteCoinvoltoInterventoDTO:
                    enteCoinvoltoInterventoDTOS
                 ) {

                if(serseTEnteCoinvoltoInterventoDTO!=null && serseTEnteCoinvoltoInterventoDTO.getDenominazione()!=null ) {
                    stringBuilder.append("-");
                    stringBuilder.append(serseTEnteCoinvoltoInterventoDTO.getDenominazione());
                    stringBuilder.append("\n\n");
                }else if(serseTEnteCoinvoltoInterventoDTO!=null && serseTEnteCoinvoltoInterventoDTO.getIdEnteCoinvoltoModello()!=null){
                    SerseTEnteCoinvoltoModelloDTO serseTEnteCoinvoltoModelloDto= enteCoinvoltoModelloDaoGenerato.selectByPrimaryKey(serseTEnteCoinvoltoInterventoDTO.getIdEnteCoinvoltoModello());
                    stringBuilder.append("-");
                    stringBuilder.append(serseTEnteCoinvoltoModelloDto.getDenominazione());
                    stringBuilder.append("\n\n");

                }
            }
            excelInput.setEntiCoinvolti(stringBuilder.toString());
            output.add(excelInput);

        }
        return output;
    }
    public List<ExcelInterventoModel> getTipologieServiziForInterventi(List<ExcelInterventoModel> input) {
        List<ExcelInterventoModel> output= new ArrayList<>();
        for (ExcelInterventoModel excelInput:
                input
             ) {
            StringBuilder stringBuilder=new StringBuilder();
            List<ServizioRegionaleDTO> elencoTipologieServizi=gestioneServiziDao.getTipologieServiziForIntervento(excelInput.getIdIntervento());
            if(elencoTipologieServizi!= null && !elencoTipologieServizi.isEmpty()){
                for (ServizioRegionaleDTO sr:
                        elencoTipologieServizi
                     ) {
                    if(sr!=null)
                    {
                        stringBuilder.append(sr.getCodiceServizioRegionale())
                                .append("-")
                                .append(sr.getDescrServizioRegionale())
                                .append("\n\n");
                    }
                }
            }
            excelInput.setTipologieServizi(stringBuilder.toString());
            output.add(excelInput);
        }
        
        return output;
    }



    //#####################################################
    // GESTIONE EXCEL SERVIZI
    //#####################################################
    public Response exportExcelServizi(List<ExcelServizio> body) {
        List<ExcelServizioModel> excelServizi = genericMapper.mapListExcelServizio(body);
        List<String> headers = new ArrayList<>();

        headers.add("PSO");
        headers.add("Sportello di riferimento");
        headers.add("Soggetto beneficiario");
        headers.add("Soggetto attuatore proprietario");
        headers.add("Sede soggetto attuatore");
        headers.add("Istanza di candidatura");
        headers.add("Identificativo servizio");
        headers.add("Titolo servizio");
        headers.add("Tipologia servizio");
        headers.add("Finalità servizio");
        headers.add("Identificativo Intervento di riferimento");
        headers.add("Stato servizio");
        headers.add("Durata");
        headers.add("Numero massimo destinatari previsti");
        headers.add("Numero anagrafiche destinatari associate");
        headers.add("Cognome_Nome Destinatario");
        headers.add("CF Destinatario");
        headers.add("Totale incontri definiti");
        headers.add("Totale incontri chiusi");
        headers.add("Enti coinvolti");
        headers.add("Codice Fiscale Utente Inserimento");
        headers.add("Codice Fiscale Utente Ultima Modifica");
        SerseDRegComportPsoSportSelector serseDRegComportPsoSportSelector = new SerseDRegComportPsoSportSelector();
        SerseDRegComportPsoSportSelector.Criteria criteria = serseDRegComportPsoSportSelector.createCriteria();
        criteria.andIdRegComportPsoSportIsNotNull();
        List<SerseDRegComportPsoSportDTO> serseDRegComportPsoSportDTOS = serseDRegComportPsoSportDAOGenerato.selectByExample(serseDRegComportPsoSportSelector);
        headers.add(serseDRegComportPsoSportDTOS.get(0).getLabelCampoAggiuntivo1());

        excelServizi= getIncontriForServizio(excelServizi);
        excelServizi= getDestinatarioServizio(excelServizi);
        excelServizi= getEntiCoinvoltiServizio(excelServizi);

        return excelExport.addDataToWorkbook(excelServizi,headers);
    }
    
    public List<ExcelServizioModel> getIncontriForServizio(List<ExcelServizioModel> input){
        List<ExcelServizioModel> output=new ArrayList<>();

        for (ExcelServizioModel inputServ:
                input
             ) {
            ExcelServizioModel tmp=inputServ;
            Integer totIncontri=0;
            Integer totIncontriChiusi=0;
            List<IncontroDTO> incontroDTOList= incontriDAOCustom.getIncontriForIdServizio(inputServ.getIdServizio());
            totIncontri=incontroDTOList.size();
            if(totIncontri>0){
                for (IncontroDTO incontro:
                        incontroDTOList
                     ) {
                    if(incontro.getStatoIncontro().getIdStatoIncontro().equals(40L)){
                        totIncontriChiusi++;
                    }
                }
            }
            tmp.setTotIncontriDefiniti(totIncontri);
            tmp.setTotIncontriChiusi(totIncontriChiusi);
            output.add(tmp);
        }

        return output;
    }

    public List<ExcelServizioModel> getDestinatarioServizio(List<ExcelServizioModel> input){
        List<ExcelServizioModel> output=new ArrayList<>();
        for (ExcelServizioModel inputServ:
                input
        ) {
            ExcelServizioModel tmp=inputServ;
            Integer numDestinatari=0;
            if((inputServ.getCodiceFiscaleDestinatario()==null || inputServ.getCodiceFiscaleDestinatario().isEmpty()) && inputServ.getNumMaxDestinatari()>1) {
                List<SerseTDestinatarioDTO> destinatariDTOList = destinatariDAOCustom.getDestinatarioServizio(inputServ.getIdServizio());
                numDestinatari=destinatariDTOList.size();
            }else if(inputServ.getCodiceFiscaleDestinatario()!=null && !inputServ.getCodiceFiscaleDestinatario().isEmpty()) {
                numDestinatari=1;
            }
            tmp.setNumDestinatariAssociati(numDestinatari);
            output.add(tmp);
        }
        return output;
    }

    public List<ExcelServizioModel> getEntiCoinvoltiServizio(List<ExcelServizioModel> input){
        List<ExcelServizioModel> output=new ArrayList<>();

        for (ExcelServizioModel inputServ:
                input
        ) {
        StringBuilder entiCoinvoltiString=new StringBuilder();
        ExcelServizioModel tmp=inputServ;
        SerseTEnteCoinvoltoServizioSelector enteCoinvoltoSelector = new SerseTEnteCoinvoltoServizioSelector();
        SerseTEnteCoinvoltoServizioSelector.Criteria enteCoinvoltoCriteria = enteCoinvoltoSelector.createCriteria();
        enteCoinvoltoCriteria.andIdServizioEqualTo(inputServ.getIdServizio());

        List<SerseTEnteCoinvoltoServizioDTO> entiSelezionato= enteCoinvoltoServizioDaoGenerato.selectByExample(enteCoinvoltoSelector);

            for (SerseTEnteCoinvoltoServizioDTO enteCoinvoltoServizioDTO : entiSelezionato) {
                 if(enteCoinvoltoServizioDTO.getDenominazione()!=null){
                    entiCoinvoltiString.append("-");
                    entiCoinvoltiString.append(enteCoinvoltoServizioDTO.getDenominazione());
                    entiCoinvoltiString.append("\n\n");
                }else{
                    SerseTEnteCoinvoltoInterventoDTO serseTEnteCoinvoltoInterventoDTO= enteCoinvoltoInterventoDaoGenerato.
                            selectByPrimaryKey(enteCoinvoltoServizioDTO.getIdEnteCoinvoltoIntervento());
                    if(serseTEnteCoinvoltoInterventoDTO.getDenominazione()!=null ) {
                        entiCoinvoltiString.append("-");
                        entiCoinvoltiString.append(serseTEnteCoinvoltoInterventoDTO.getDenominazione());
                        entiCoinvoltiString.append("\n\n");
                    }else{
                        SerseTEnteCoinvoltoModelloDTO serseTEnteCoinvoltoModelloDto= enteCoinvoltoModelloDaoGenerato.selectByPrimaryKey(serseTEnteCoinvoltoInterventoDTO.getIdEnteCoinvoltoModello());
                        entiCoinvoltiString.append("-");
                        entiCoinvoltiString.append(serseTEnteCoinvoltoModelloDto.getDenominazione());
                        entiCoinvoltiString.append("\n\n");

                    }
                }
            }
            tmp.setEntiCoinvolti(entiCoinvoltiString.toString());
            output.add(tmp);
        }
        return output;
    }

    // ====== V2 =======================================================================

    public Response exportExcelServiziV2(FilterServizi filter, String descrizionePso, String descrizioneSportello) {
        
        // cfr. ServiziManager.getServizi

        List<String> parametriMancanti = chkParametriMancanti(filter);
        if (!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        if (!chkFiltroSoggettoBeneficiario(filter)) {
            return parametriObbligatoriMancantiIncongruenti("codOperatoreSoggettoBeneficiario e "
            + "gruppoOperatoreSoggettoBeneficiario devono essere entrambi null o entrambi valorizzati");
        }

        // per i Filter, abbiamo usato il formato CSI che è più generale ma effettivamente pesante...
        FilterServiziSemplificato filtroSemplificato = genericMapper.map(filter);

        List<ExcelServiziBean> listaRecordExcel = gestioneServiziDao.getServiziExcel(filtroSemplificato);
        
        fixDenominazioniSoggetti(listaRecordExcel);

        StreamingOutput stream = new StreamingOutput() {

            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                Map<String, Object> model = new HashMap<>();
                model.put("servizi", listaRecordExcel);
                model.put("labelCampoAgg1", getLabelCampoAggiuntivo1());
                model.put("descrizionePso", descrizionePso);
                model.put("descrizioneSportello", descrizioneSportello);
                xlsUtils.exportExcel("/templates/elenco_servizi.xlsx", outputStream, model);
            }
        };

        ResponseBuilder response = Response.ok(stream);
        response.header("Content-Disposition", "attachment; filename=\"elenco_servizi.xlsx\"");
        return response.build();
    }

    public Response exportExcelInterventiV2(FilterInterventi filter, String descrizionePso, String descrizioneSportello) {
        
        // cfr. InterventiManager.getInterventi

        List<String> parametriMancanti = chkParametriMancanti(filter);
        if (!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        if (!chkFiltroSoggettoBeneficiario(filter)) {
            return parametriObbligatoriMancantiIncongruenti("codOperatoreSoggettoBeneficiario e "
            + "gruppoOperatoreSoggettoBeneficiario devono essere entrambi null o entrambi valorizzati");
        }

        // per i Filter, abbiamo usato il formato CSI che è più generale ma effettivamente pesante...
        FilterInterventiSemplificato filtroSemplificato = genericMapper.map(filter);

        List<ExcelInterventiBean> listaRecordExcel = interventiDao.getInterventiExcel(filtroSemplificato);
        
        fixDenominazioniSoggetti(listaRecordExcel);

        StreamingOutput stream = new StreamingOutput() {

            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                Map<String, Object> model = new HashMap<>();
                model.put("interventi", listaRecordExcel);
                model.put("descrizionePso", descrizionePso);
                model.put("descrizioneSportello", descrizioneSportello);
                xlsUtils.exportExcel("/templates/elenco_interventi.xlsx", outputStream, model);
            }
        };

        ResponseBuilder response = Response.ok(stream);
        response.header("Content-Disposition", "attachment; filename=\"elenco_interventi.xlsx\"");
        return response.build();
    }

    public Response exportExcelModelliV2(FilterModelli filter, String descrizionePso, String descrizioneSportello) {
        
        // cfr. ModelliDiInterventoManager.getModelliIntervento

        List<String> parametriMancanti = chkParametriMancanti(filter);
        if (!parametriMancanti.isEmpty()) {
            return parametriObbligatoriMancanti(parametriMancanti);
        }
        if (!chkFiltroSoggettoBeneficiario(filter)) {
            return parametriObbligatoriMancantiIncongruenti("codOperatoreSoggettoBeneficiario e "
            + "gruppoOperatoreSoggettoBeneficiario devono essere entrambi null o entrambi valorizzati");
        }

        // per i Filter, abbiamo usato il formato CSI che è più generale ma effettivamente pesante...
        FilterModelliSemplificato filtroSemplificato = genericMapper.map(filter);

        List<ExcelModelliBean> listaRecordExcel = modelliDiInterventoDAO.getModelliExcel(filtroSemplificato);
        
        fixDenominazioniSoggetti(listaRecordExcel);

        StreamingOutput stream = new StreamingOutput() {

            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                Map<String, Object> model = new HashMap<>();
                model.put("modelli", listaRecordExcel);
                model.put("descrizionePso", descrizionePso);
                model.put("descrizioneSportello", descrizioneSportello);
                xlsUtils.exportExcel("/templates/elenco_modelli_di_intervento.xlsx", outputStream, model);
            }
        };

        ResponseBuilder response = Response.ok(stream);
        response.header("Content-Disposition", "attachment; filename=\"elenco_modelli_di_intervento.xlsx\"");
        return response.build();
    }

    /**
	 * Controlla i parametri obbligatori
	 * @return lista dei parametri mancanti
	 */
    private List<String> chkParametriMancanti(FilterParent filter) {
        List<String> parametriMancanti = new ArrayList<>();
        if (filter.getNumProgrSportello() == null || filter.getNumProgrSportello().getEq() == null) {
            parametriMancanti.add(INPUT_MISSING.NUM_PROGR_SPORTELLO);
        }
        if (filter.getGruppoOperatore() == null || StringUtils.isBlank(filter.getGruppoOperatore().getEq())) {
            parametriMancanti.add(INPUT_MISSING.GRUPPO_OPERATORE);
        }
        if (filter.getCodOperatore() == null || filter.getCodOperatore().getEq() == null) {
            parametriMancanti.add(INPUT_MISSING.COD_OPERATORE);
        }
        return parametriMancanti;
    }

    private boolean chkFiltroSoggettoBeneficiario(FilterParent filter) {
        boolean isBlankGruppoOpBen = filter.getGruppoOpBeneficiario() == null || StringUtils.isBlank(filter.getGruppoOpBeneficiario().getEq());
        boolean isBlankCodOpBen = filter.getCodOpBeneficiario() == null || filter.getCodOpBeneficiario().getEq() == null;
        return (isBlankCodOpBen && isBlankGruppoOpBen) || (!isBlankCodOpBen && !isBlankGruppoOpBen);
    }

    private String getLabelCampoAggiuntivo1() {
        SerseDRegComportPsoSportSelector serseDRegComportPsoSportSelector = new SerseDRegComportPsoSportSelector();
        SerseDRegComportPsoSportSelector.Criteria criteria = serseDRegComportPsoSportSelector.createCriteria();
        criteria.andIdRegComportPsoSportIsNotNull();
        List<SerseDRegComportPsoSportDTO> serseDRegComportPsoSportDTOS = serseDRegComportPsoSportDAOGenerato.selectByExample(serseDRegComportPsoSportSelector);
        return serseDRegComportPsoSportDTOS.get(0).getLabelCampoAggiuntivo1();
    }

    /**
     * Aggiunge le denominazioni operatori prese da Flaianag
     * Sostituisce in-place i valori di soggAttuatore e soggBeneficiario
     */
    private void fixDenominazioniSoggetti(List<? extends ExcelParentBean> listaRecordExcel) {
        List<AkOperatore> operatori = getOperatori(listaRecordExcel);
        Map<String, SintesiPersonaGiuridica> soggettiDenominazione = flaianag.getDenominazioniOperatori(operatori);
        for (ExcelParentBean servizio : listaRecordExcel) {
            if (soggettiDenominazione.containsKey(servizio.getSoggAttuatore())) {
                String denominazione = soggettiDenominazione.get(servizio.getSoggAttuatore()).getDenominazionePersonaGiuridica();
                servizio.setSoggAttuatore(servizio.getSoggAttuatore() + " - " + denominazione);
            }
            if (soggettiDenominazione.containsKey(servizio.getSoggBeneficiario())) {
                String denominazione = soggettiDenominazione.get(servizio.getSoggBeneficiario()).getDenominazionePersonaGiuridica();
                servizio.setSoggBeneficiario(servizio.getSoggBeneficiario() + " - " + denominazione);
            }
        }
    }

    static final Pattern REGEX_GRP_COD = Pattern.compile("(?<=\\D)(?=\\d)");

    /**
     * Estrae le chiavi di tutti i soggetti operatore presenti nei record, come richieste da Flaianag
     */
    private List<AkOperatore> getOperatori(List<? extends ExcelParentBean> listaRecordExcel) {

        Set<String> operatori = new HashSet<>();
        listaRecordExcel.forEach(servizio -> {
            operatori.add(servizio.getSoggAttuatore());
            operatori.add(servizio.getSoggBeneficiario());
        });
        return operatori.stream()
            .filter(x -> x != null)
            .map(x -> {
                AkOperatore operatore = new AkOperatore();
                String[] parts = REGEX_GRP_COD.split(x);
                operatore.setCodiceGruppoOperatore(parts[0]);
                operatore.setCodiceOperatore(Integer.parseInt(parts[1]));
                return operatore;
            }).toList();
    }
}
