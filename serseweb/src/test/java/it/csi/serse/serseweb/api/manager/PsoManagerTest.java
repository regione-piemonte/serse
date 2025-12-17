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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.csi.serse.serseweb.api.exception.InternalErrorException;
import it.csi.serse.serseweb.integration.mybatis.dao.custom.GestionePsoDAO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.PsoDTO;
import it.csi.serse.serseweb.integration.mybatis.generated.dao.ExtTtComuneDAO;
import it.csi.serse.serseweb.integration.mybatis.generated.dto.ExtTtComuneDTO;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.AmmResponsabileDto;
import it.csi.serse.serseweb.integration.ws.cxf.budgetbilserv.common.SelItemDto;
import it.csi.serse.serseweb.integration.ws.cxf.helper.CommonHelper;
import it.csi.serse.serseweb.mapper.GamMapper;
import it.csi.serse.serseweb.mapper.GenericMapper;
import it.csi.serse.serseweb.vo.AmministrazioneResponsabile;
import it.csi.serse.serseweb.vo.Errore;
import jakarta.ws.rs.core.Response;

@ExtendWith(SpringExtension.class)
class PsoManagerTest {
    @Mock
    GenericMapper genericMapper;
    @Mock
    GamMapper gamMapper;
    @Mock
    GestionePsoDAO psoDao;
    @Mock
    CommonHelper gamBudget;
    @Mock
    ExtTtComuneDAO comuneDao;
    @InjectMocks
    PsoManager psoManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPsoForTipologia() {
        AmministrazioneResponsabile amTmp=new AmministrazioneResponsabile();
        amTmp.setCodAr(1);
        amTmp.setDescrizione("prova");
        amTmp.setSiglaEnte("PR");
        when(gamMapper.toVo(any())).thenThrow(new InternalErrorException("ahahaha"));
        when(psoDao.getPsoForTipologia(anyString(), anyInt(), anyInt())).thenReturn(Arrays.<PsoDTO>asList(new PsoDTO()));
        when(gamBudget.searchAllAmministrazioniResponsabili(anyLong())).thenReturn(Arrays.<AmmResponsabileDto>asList(new AmmResponsabileDto()));
        when(gamBudget.searchGestCicliFin(anyString())).thenReturn(Arrays.<SelItemDto>asList(new SelItemDto()));

        Response result = psoManager.getPsoForTipologia("tipologiaPsoId", Integer.valueOf(0), Integer.valueOf(0));
        assertTrue(result.getEntity() instanceof List<?>);
        List<PsoDTO> psoList = (List<PsoDTO>) result.getEntity();

        assertEquals(1, psoList.size());
    }

    @Test
    void testInternalServerError() {
        Response result = psoManager.internalServerError();

        assertNotNull(result.getEntity());
        assertTrue(result.getEntity() instanceof Errore);
        assertEquals(500, result.getStatus());
    }

    @Test
    void testParametriObbligatoriMancantiIncongruenti() {
        Response result = psoManager.parametriObbligatoriMancantiIncongruenti("msg");

        assertNotNull(result.getEntity());
        assertTrue(result.getEntity() instanceof Errore);
        assertEquals(400, result.getStatus());
    }

    @Test
    void testParametriObbligatoriMancantiIncongruenti2() {
        Response result = psoManager.parametriObbligatoriMancantiIncongruenti(0, "msg");

        assertNotNull(result.getEntity());
        assertTrue(result.getEntity() instanceof Errore);
        assertEquals(400, result.getStatus());
    }

    @Test
    void testConflictException() {
        Response result = psoManager.conflictException("msg");

        assertNotNull(result.getEntity());
        assertTrue(result.getEntity() instanceof Errore);
        assertEquals(409, result.getStatus());
    }

    @Test
    void testConflictException2() {
        Response result = psoManager.conflictException(0, "msg");

        assertNotNull(result.getEntity());
        assertTrue(result.getEntity() instanceof Errore);
        assertEquals(409, result.getStatus());
    }

    @Test
    void testParametriObbligatoriMancanti() {
        Response result = psoManager.parametriObbligatoriMancanti(Arrays.<String>asList("String"));

        assertNotNull(result.getEntity());
        assertTrue(result.getEntity() instanceof Errore);
        assertEquals(400, result.getStatus());
    }

    @Test
    void testNoResoultFound() {
        Response result = psoManager.noResoultFound("msg");

        assertNotNull(result.getEntity());
        assertTrue(result.getEntity() instanceof Errore);
        assertEquals(404, result.getStatus());
    }

    @Test
    void testResponseOK() {
        Response result = psoManager.responseOK();

        assertNotNull(result.getEntity());
        assertEquals(200, result.getStatus());
    }

    @Test
    void testGetComuneByCodIstat() {
        when(comuneDao.selectByPrimaryKey(anyString())).thenReturn(new ExtTtComuneDTO());

        ExtTtComuneDTO result = psoManager.getComuneByCodIstat("codIstatComune");
        assertEquals(new ExtTtComuneDTO(), result);
    }
}
