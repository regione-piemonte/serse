package it.csi.serse.serseweb.api;

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

import java.util.Date;

import org.junit.jupiter.api.Test;

import it.csi.serse.serseweb.vo.AmministrazioneResponsabile;
import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.ModelloIntervento;
import it.csi.serse.serseweb.vo.Provincia;
import it.csi.serse.serseweb.vo.Pso;
import it.csi.serse.serseweb.vo.Referente;
import it.csi.serse.serseweb.vo.ServizioModello;
import it.csi.serse.serseweb.vo.ServizioRegionale;
import it.csi.serse.serseweb.vo.SoggettoAttuatore;
import it.csi.serse.serseweb.vo.Sportello;
import it.csi.serse.serseweb.vo.StatoModelloIntervento;
import it.csi.serse.serseweb.vo.TipoModello;
import it.csi.serse.serseweb.vo.TipologiaPso;

public class DatiPerTest {
	
	public Pso datiPso() {
		Pso pso = new Pso();
		pso.setAmministrazioneResponsabile(datiAmministrazioneResponsabile());
		pso.setCodCicloFinanziario("cod");
		pso.setDescrizione("desc");
		pso.setIdAttoIndirizzo(1);
		pso.setIdPso(1l);
		pso.setSiglaEnte("sigla");
		pso.setTipologiaPso(datiTipologiaPso());
		return pso;
	}
	
	public TipologiaPso datiTipologiaPso() {
		TipologiaPso tipologiaPso = new TipologiaPso();
		tipologiaPso.setAnnoApprovazione(2021);
		tipologiaPso.setCodClassificazioneAdi("cod");
		tipologiaPso.setCodProgrammazione(1);
		tipologiaPso.setDescrizione("desc");
		tipologiaPso.setIdAttoIndirizzo(1);
		tipologiaPso.setTipologiaPsoId("pr");
		return tipologiaPso;
	}
	
	public AmministrazioneResponsabile datiAmministrazioneResponsabile() {
		AmministrazioneResponsabile ammRes = new AmministrazioneResponsabile();
		ammRes.setCodAr(1);
		ammRes.setDescrizione("desc");
		ammRes.setSiglaEnte("SD");
		
		return ammRes;
	}
	
	public Referente datiReferente() {
		Referente referente = new Referente();  
        referente.setReferenteCognome("cognome");
        referente.setReferenteEmail("Mail");
        referente.setReferenteNome("Nome");
        referente.setReferenteTelefono("3233");
        
        return referente;
		
	}
	
	public SoggettoAttuatore datiSoggettoAttuatore() {
		SoggettoAttuatore soggettoAttuatore = new SoggettoAttuatore();
        soggettoAttuatore.setCodOperatore(123);
        soggettoAttuatore.setCodUserAggiornamento("cod");
        soggettoAttuatore.setCodUserInserimento("coduser");
        soggettoAttuatore.setDataInserimento(new Date());
        soggettoAttuatore.setFlgCapofila("v");
        soggettoAttuatore.setGruppoOperatore("grupo");
        soggettoAttuatore.setIdSoggettoAttuatore(1l);
        soggettoAttuatore.setModelId(1);
        soggettoAttuatore.setNumProgrSportello(1);
        
        return soggettoAttuatore;
	}
	
	public Sportello datiSportello() {
		Sportello sportello = new Sportello();
        sportello.setDataFine(new Date());
        sportello.setDataInizio(new Date());
        sportello.setDescrizioneSportello("desc sportello");
        sportello.setPso(datiPso());
		
        return sportello;
	}
	
	public Provincia datiProvincia() {
		Provincia provincia = new Provincia();
        provincia.setCodiceProvincia("mi");
        provincia.setCodiceRegione("lo");
        provincia.setDescrizioneProvincia("descr");
        provincia.setSiglaProvincia("sigla");
        
		return provincia;
	}
	
	public Comune datiComune() {
		Comune comune = new Comune();
        comune.setCap("cap");
        comune.setCodiceFiscaleComune("cfcomune");
        comune.setCodiceIstatComune("cicomune");
        comune.setDescrizioneComune("descr");
        comune.setProvincia(datiProvincia());
        
		return comune;
	}
	
	public TipoModello datiTipoModello() {
		TipoModello tipoModello = new TipoModello();
		tipoModello.setCodTipoModello("cod");
		tipoModello.setDescrizione("desc");
		tipoModello.setFlgModelloStandard("v");
		tipoModello.setFlgProgettazioneIndividuale("f");
		
		return tipoModello;
	}
	
	public StatoModelloIntervento datiStatoModelloIntervento() {
		StatoModelloIntervento statoModelloIntervento = new StatoModelloIntervento();
		statoModelloIntervento.setDescrStatoModelloDiIntervento("desc");
		statoModelloIntervento.setIdStatoModelloDiIntervento(1l);
		
		return statoModelloIntervento;
	}
	
	public ModelloIntervento datiModelloIntervento() {
		ModelloIntervento modello = new ModelloIntervento();
        modello.setCodUserAggiornamento("coduta");
        modello.setCodUserInserimento("coduin");
        modello.setDataAggiornamento(new Date());
        modello.setDataInserimento(new Date());
        modello.setDescrizione("desc");
        modello.setIdModelloIntervento(1l);
        modello.setIdPso(1l);
        modello.setReferente(datiReferente());
        modello.setSoggettoAttuatore(datiSoggettoAttuatore());
        modello.setStatoModelloIntervento(datiStatoModelloIntervento());
        modello.setTipoModello(datiTipoModello());
        modello.setTitolo("Titolo");
	        
	    return modello;    
		
	}
	
	public ServizioRegionale datiServizioRegionale() {
		ServizioRegionale servizioRegionale = new ServizioRegionale();
		servizioRegionale.setCodFinalitaServizio("cod finalita");
		servizioRegionale.setCodiceServizioRegionale("codice servizio");
		servizioRegionale.setDescrFinalitaServizio("desc finalita");
		servizioRegionale.setDescrServizioRegionale("servizio regionale");
		servizioRegionale.setIdClassificazione(1l);
		servizioRegionale.setIdPso(1l);
		servizioRegionale.setIdServizioRegionale(1l);
		servizioRegionale.setOreConsentiteMax(1);
		servizioRegionale.setOreConsentiteMin(1);
		return servizioRegionale;
		
	}
	
	public ServizioModello datiServizioModello() {
		ServizioModello servizioModello = new ServizioModello();
		servizioModello.setCodFinalitaServizioEsterno("codFinalita");
		servizioModello.setCodUserAggiorn("cod user agriorn");
		servizioModello.setCodUserInserim("cod user inse");
		servizioModello.setDAggiorn(new Date());
		servizioModello.setDescrFinalitaServizioEsterno("desc finalita");
		servizioModello.setDescrizioneServizioEsterno("desc servizio");
		servizioModello.setDInserim(new Date());
		servizioModello.setIdDestinatario(1l);
		servizioModello.setIdModelloDiIntervento(1l);
		servizioModello.setIdServizioModello(1l);
		servizioModello.setReferente(datiReferente());
		servizioModello.setServizioRegionale(datiServizioRegionale());
		servizioModello.setTitoloServizioEsterno("titolo");
		return servizioModello;
	}

}
