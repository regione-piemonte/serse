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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dao.custom.IstitutiScolasticiDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.IstitutoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtSisproDGradoScolasticoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtSisproDPercorsoDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtSisproDTipologiaDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDGradoScolasticoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDGradoScolasticoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDPercorsoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDPercorsoSelector;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDTipologiaDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtSisproDTipologiaSelector;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.mapper.MybatisGeneretedDTOMapper;
import it.csi.serse.serseweb.vo.GenericResponse;
import it.csi.serse.serseweb.vo.IstitutoScolasticoWrapper;
import jakarta.ws.rs.core.Response;

@Component
public class IstitutiScolasticiManager extends ParentManager{
    @Autowired
    private GenericMapper genericMapper;

    @Autowired
    private MybatisGeneretedDTOMapper mybatisMapper;

    @Autowired
    private ExtSisproDGradoScolasticoDAO gradoScolasticoDAO;

    @Autowired
    private ExtSisproDPercorsoDAO percorsoDAO;

    @Autowired
    private ExtSisproDTipologiaDAO tipologiaIstitutiDAO;

    @Autowired
    private IstitutiScolasticiDAO istitutiScolasticiDAO;

    public Response getGradiScolastici(){
        ExtSisproDGradoScolasticoSelector selector= new ExtSisproDGradoScolasticoSelector();
        List<ExtSisproDGradoScolasticoDTO> gradoScolasticoDTOList= gradoScolasticoDAO.selectByExample(selector);
        return Response.ok(mybatisMapper.mapListGtadoScolastico(gradoScolasticoDTOList)).build();
    }

    public Response getPercorsiScolastici(){
        ExtSisproDPercorsoSelector selector= new ExtSisproDPercorsoSelector();
        List<ExtSisproDPercorsoDTO> percorsoDTOList= percorsoDAO.selectByExample(selector);

        return Response.ok(mybatisMapper.mapListPercorsi(percorsoDTOList)).build();
    }

    public Response getTipologieIstituti(){
        ExtSisproDTipologiaSelector selector=new ExtSisproDTipologiaSelector();
        List<ExtSisproDTipologiaDTO> tipologiaDTOList= tipologiaIstitutiDAO.selectByExample(selector);

        return Response.ok(mybatisMapper.mapListTipologieIstituti(tipologiaDTOList)).build();
    }

    public Response getIstitutiScolastici(Long idPercorsoScolastico,
                                          String codiceComune,
                                          String codiceProvincia,
                                          String idGradoScolastico,
                                          Long idTipologiaIstituto,
                                          String codiceRegionale,
                                          String codiceMeccanografico,
                                          String denominazioneEnte) {
        List<IstitutoScolasticoWrapper> response = new ArrayList<>();
        String enteCoinvolto;
        if (denominazioneEnte != null) {
            enteCoinvolto = "%" + denominazioneEnte + "%";
        } else {
            enteCoinvolto = null;
        }
        // primo elenco filtrato da db
        List<IstitutoScolasticoDTO> istitutoScolasticoDTOList = istitutiScolasticiDAO.
                getIstitutiScolastici(idPercorsoScolastico
                        , codiceComune
                        , codiceProvincia
                        , idGradoScolastico
                        , idTipologiaIstituto
                        , codiceRegionale
                        , codiceMeccanografico
                        , enteCoinvolto);
        if (istitutoScolasticoDTOList.size() > 100) {
            GenericResponse response100 = new GenericResponse();
            response100.setMessage("" + istitutoScolasticoDTOList.size());
            return Response.ok(response100).build();

        } else {
        // ricavo i dati dell'autonomia cui appartiene ogni istituto
        istitutoScolasticoDTOList.stream().forEach(istituto -> {
            IstitutoScolasticoWrapper tmp = new IstitutoScolasticoWrapper();
            tmp.setIstitutoScolastico(genericMapper.mapListIstituti(istituto));
            IstitutoScolasticoDTO autonomia = istitutiScolasticiDAO.getAutonomiaForIstituto(istituto.getIdIstitutoScolastico());

            if (autonomia != null) {
                tmp.setCodiceRegionaleAutonomia(autonomia.getCodRegionaleAutonomia());
                tmp.setDenominazioneAutonomia(autonomia.getDenominazione());
            }
            response.add(tmp);
        });

            return Response.ok(response).build();
        }
    }
}
