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


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.AkOperatore;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiOperatore;
import it.csi.serse.serseapi.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica;
import it.csi.serse.serseapi.integration.ws.cxf.helper.FlaianagpgHelper;
import it.csi.serse.serseapi.vo.OutputEsposizioneServiziItem;


class GestInterscSerseManagerTest {

    @InjectMocks
    private GestInterscSerseManager gestInterscSerseManager;

    @Mock
    private FlaianagpgHelper flaiAnag;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPopolaDenominazioni() {
        // Arrange
        List<OutputEsposizioneServiziItem> list = new ArrayList<>();
        OutputEsposizioneServiziItem item1 = new OutputEsposizioneServiziItem();
        item1.setGruppoSoggettoAttuatore("A");
        item1.setCodiceSoggettoAttuatore(1);
        item1.setGruppoSoggettoBeneficiario("B");
        item1.setCodiceSoggettoBeneficiario(2);
        list.add(item1);

        OutputEsposizioneServiziItem item2 = new OutputEsposizioneServiziItem();
        item2.setGruppoSoggettoAttuatore("C");
        item2.setCodiceSoggettoAttuatore(3);
        list.add(item2);

        List<SintesiPersonaGiuridica> mockResultElencoPG = new ArrayList<>();

        SintesiPersonaGiuridica persona1 = new SintesiPersonaGiuridica();
        SintesiOperatore operatore1 = new SintesiOperatore();
        operatore1.setOperatore(new AkOperatore());
        operatore1.getOperatore().setCodiceGruppoOperatore("A");
        operatore1.getOperatore().setCodiceOperatore(1);
        persona1.setSintesiOperatore(operatore1);
        persona1.setDenominazionePersonaGiuridica("Denominazione Attuatore A1");
        mockResultElencoPG.add(persona1);

        SintesiPersonaGiuridica persona2 = new SintesiPersonaGiuridica();
        SintesiOperatore operatore2 = new SintesiOperatore();
        operatore2.setOperatore(new AkOperatore());
        operatore2.getOperatore().setCodiceGruppoOperatore("B");
        operatore2.getOperatore().setCodiceOperatore(2);
        persona2.setSintesiOperatore(operatore2);
        persona2.setDenominazionePersonaGiuridica("Denominazione Beneficiario B2");
        mockResultElencoPG.add(persona2);

        when(flaiAnag.getElencoPGGCO(anyList())).thenReturn(mockResultElencoPG);

        // Act
        gestInterscSerseManager.popolaDenominazioni(list);

        // Assert
        assertEquals("Denominazione Attuatore A1", item1.getDenominazioneSoggettoAttuatore());
        assertEquals("Denominazione Beneficiario B2", item1.getDenominazioneSoggettoBeneficiario());
        assertNull(item2.getDenominazioneSoggettoAttuatore());
        assertNull(item2.getDenominazioneSoggettoBeneficiario());

        verify(flaiAnag, times(1)).getElencoPGGCO(anyList());
    }
}