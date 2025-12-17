package it.csi.serse.serseweb.integration.ws.cxf.helper;

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
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.BasicInformazioniAggiuntiveDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.CustomXMLInformazioniAggiuntiveDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.InfoPersonaGroupDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.OperatoreFPInformazioniAggiuntiveDto;
import it.csi.serse.serseweb.utils.XmlConverterUtil;
import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.Application;
import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.Identita;
import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.OrchflaiFlaidoorsrv;
import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.Ruolo;
import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.UseCase;
import it.csi.serse.serseweb.api.exception.InternalErrorException;
import it.csi.serse.serseweb.model.Utente;
import it.csi.serse.serseweb.utils.Constants;
import it.csi.serse.serseweb.vo.InfoOperatore;
import it.csi.serse.serseweb.vo.UserInfo;
import it.csi.serse.serseweb.mapper.GenericMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Component
public class SecurityHelper {

	static final Logger LOG = LogManager.getLogger(Constants.COD_COMPONENTE + ".integration");
	
	@Autowired
    @Qualifier("orchflaiFlaidoorsrv")
    private OrchflaiFlaidoorsrv orcflai;
	

	@Autowired
	private GenericMapper mapper;

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi di supporto alla sicurezza.
	//////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////
	//// Metodi per la sicurezza basata su IRIDE2
	///////////////////////////////////////////////////////////////////////////////

	public static final Application SERSEWEB_APPLICATION = new Application();
	
	static {
		SERSEWEB_APPLICATION.setId("SERSEWEB");
	}

	/**
	 * restituisce il percorso effettivo della configurazione della PD di IRIDE da
	 * caricare. Se la security (e la pep-implementation) e' custom viene restituito
	 * sempre il valore della costante IRIDE_PEP_RESOURCE. Se la security non e'
	 * custom viene restituito un valore differente a seconda del valore della
	 * property "pdProtocol":
	 * <ul>
	 * <li>EJB: IRIDE_PEP_RESOURCE</li>
	 * <li>WS: IRIDE_PEP_WS_RESOURCE</li>
	 * <li>(altro): IRIDE_PEP_RESOURCE</li>
	 * </ul>
	 */

	/**
	 * Carica la configurazione della PD del PEP e crea il proxy.
	 * 
	 * @return il proxy della PD del PEP.
	 */

	protected Identita getCurrentUser(HttpServletRequest hreq) throws IllegalStateException {
		Identita id = (Identita) hreq.getAttribute(Constants.IRIDE_ATTRIBUTES.ID_REQ_ATTR);
		if (id == null) {
			throw new IllegalStateException(
					"Errore nel reperimento del current user dalla sessione: attributo non trovato");
		} else {
			return id;
		}
	}

	public UserInfo getCurrentUserInfo(HttpServletRequest hreq) throws IllegalStateException {

		Utente u = (Utente) hreq.getAttribute(Constants.IRIDE_ATTRIBUTES.USERINFO_REQ_ATTR);

		UserInfo userInfo = mapper.map(u);

		if (userInfo == null) {
			throw new IllegalStateException(
					"Errore nel reperimento del current user dalla sessione: attributo non trovato");
		} else {
			return userInfo;
		}
	}

	public boolean verifyCurrentUserForRole(HttpServletRequest hreq, String roleCode, String domainCode)
			throws Exception {
		Identita currentUser = getCurrentUser(hreq);
		Ruolo rol = new Ruolo();

		rol.setCodiceRuolo(roleCode);
		rol.setCodiceDominio(domainCode);

		return orcflai.isPersonaInRuolo(getCurrentUser(hreq), rol);
	}

	/**
	 * estrae il prefisso dal cod ruolo in formato <idruolo>@<coddominio>
	 * 
	 * @param codRuolo
	 */
	private String getPrefixFromCodRuolo(String codRuolo) {
		return codRuolo.substring(0, codRuolo.indexOf("@"));
	}

	/**
	 * estrae il codice dominio dal cod ruolo in formato <idruolo>@<coddominio>
	 * 
	 * @param codRuolo
	 */
	private String getDomainFromCodRuolo(String codRuolo) {
		return codRuolo.substring(codRuolo.indexOf("@") + 1);
	}

	public boolean verifyCurrentUserForUC(HttpServletRequest hreq, String useCaseCode) throws Exception {
		Identita currentUser = getCurrentUser(hreq);
		UseCase uc = new UseCase();

		uc.setAppId(SERSEWEB_APPLICATION);
		uc.setId(useCaseCode);

		UserInfo currentUserInfo = getCurrentUserInfo(hreq);
		if (currentUserInfo == null || currentUserInfo.getCodRuolo() == null
				|| currentUserInfo.getCodRuolo().length() == 0) {
			// verifica dell'abilitazione allo UC senza tener conto del ruolo corrente
			return orcflai.isPersonaAutorizzataInUseCase(getCurrentUser(hreq), uc);
		} else {
			// verifica dell'abilitazione allo UC tenendo conto del ruolo corrente
			List<Ruolo> ruoliForPersonaInUseCase = orcflai.findRuoliForPersonaInUseCase(currentUser, uc);
			
			boolean authorized = false;
			if (ruoliForPersonaInUseCase != null) { // Aggiunto per evitare un null pointer
				String codDominioRuolo = getDomainFromCodRuolo(currentUserInfo.getCodRuolo());
				String codRuoloRuolo = getPrefixFromCodRuolo(currentUserInfo.getCodRuolo());
				Ruolo currentRole = new Ruolo();
				currentRole.setCodiceRuolo(codRuoloRuolo);
				currentRole.setCodiceDominio(codDominioRuolo);

				for (Ruolo ruolo : ruoliForPersonaInUseCase) {
					if (ruolo != null && currentRole.getMnemonico().equals(ruolo.getMnemonico())) {
						authorized = true;
						break;
					}
				}
			}
			return authorized;
		}

	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	// dao, proxy di pd, ...)

	// 1. getInfoPersonaInUseCase(Identita, (Application=null, Ruolo))
	// public ArrayList<it.csi.gamopera.operweb.dto.common.AddInfo>
	// getInfoPersonaInUseCase(Identita identita, UseCase usecase)
	public String getInfoPersonaInUseCase(HttpServletRequest hreq, UseCase usecase) throws Exception {

		Identita identita = (Identita) hreq.getAttribute(Constants.IRIDE_ATTRIBUTES.ID_REQ_ATTR);

		// Valuta se convertire già qui la String in u nArrayList<AddInfo>
		return orcflai.getInfoPersonaInUseCase(identita, usecase);
	}

	// 2.findRuoliForPersonaInApplication(Identita, Application(OPERWEB))
	// public ArrayList<it.csi.gambudget.budgetweb.dto.common.Ruolo>
	// findRuoliInApplication(
	public ArrayList<it.csi.serse.serseweb.vo.Ruolo> findRuoliForPersonaInApplication(HttpServletRequest hreq){

		try {
			Identita identita = (Identita) hreq.getAttribute(Constants.IRIDE_ATTRIBUTES.ID_REQ_ATTR);

			List<Ruolo> ruoliFromOrchflai = orcflai.findRuoliForPersonaInApplication(identita, SERSEWEB_APPLICATION);
			ArrayList<it.csi.serse.serseweb.vo.Ruolo> ruoloReturnList = new ArrayList<>();
			if (ruoliFromOrchflai != null && ruoliFromOrchflai.size() > 0) {

				
				for (Ruolo ruoloFromOrchflai : ruoliFromOrchflai){
					
					UseCase useCase=new UseCase();
					useCase.setId(ruoloFromOrchflai.getMnemonico());
					String infoAggiuntive = getInfoPersonaInUseCase(hreq,useCase);
					
					InfoPersonaGroupDto dto = XmlConverterUtil.streamFromXml(infoAggiuntive);

					// Il ruolo DELEGATO vedremo più avanti come gestirlo
					if (!ruoloFromOrchflai.getCodiceRuolo().equalsIgnoreCase("DELEGATO")) {

						it.csi.serse.serseweb.vo.Ruolo ruolo = new it.csi.serse.serseweb.vo.Ruolo();

						ruolo.setCodiceRuolo(ruoloFromOrchflai.getCodiceRuolo());
						ruolo.setCodiceDominio(ruoloFromOrchflai.getCodiceDominio());
						ruolo.setMnemonico(ruoloFromOrchflai.getMnemonico());
						
						if (dto!=null && dto.getProfiloPersona()!=null && dto.getProfiloPersona().getDescrizioneProfiloBreve()!=null)
							ruolo.setDescrizione(dto.getProfiloPersona().getDescrizioneProfiloBreve().toUpperCase());

						ruoloReturnList.add(ruolo);
					}
				}
				return ruoloReturnList;
			} else
				return ruoloReturnList;
		} catch (Exception e) {
			//throw  new ErroreConnessioneServizioException(501,e.getMessage());
			throw new InternalErrorException(e)	;	}

	}
	
	//////////////////////////////////////////////////////////////////////////////
	/// Metodi per richiesta e mappatura dati
	//////////////////////////////////////////////////////////////////////////////
	public Response getInfoOperatoreForRuolo(@NotNull String codRuolo, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		try {
			if (!codRuolo.equals("SERVIZIO_ASSISTENZA_SERSE") && !codRuolo.equals("FUNZIONARIO_MASTER_SERSE")) {
				ArrayList<it.csi.serse.serseweb.vo.Ruolo> ruoli = findRuoliForPersonaInApplication(httpRequest);
				it.csi.serse.serseweb.vo.Ruolo selected=ruoli.stream().filter(ruolo -> ruolo.getCodiceRuolo().equals(codRuolo)).findAny().orElse(null);
								
				String infoAggiuntiveXml="";
				List<BasicInformazioniAggiuntiveDto> basicInfoAggiuntive=null;
				
				if(selected!=null)
				{
					UseCase useCase=new UseCase();
					useCase.setId(selected.getMnemonico());
					infoAggiuntiveXml = getInfoPersonaInUseCase(httpRequest,useCase);
				}

				InfoPersonaGroupDto infoPersonaGruopDto = XmlConverterUtil.streamFromXml(infoAggiuntiveXml);
				
				if(infoPersonaGruopDto!=null) {
					basicInfoAggiuntive=infoPersonaGruopDto.getElencoInformazioniAggiuntive();
				}
				
				List<InfoOperatore> infoOperatoreList= new ArrayList<>();
				
				
				/*per accedere a tutte le informazioni aggiuntive è indispensabile 
				 * ottenere l'oggetto BasicInformazioniAggiuntiveDto
				 * BasicInformazioniAggiuntiveDto basicInformazioniAggiuntiveDt:dto.getElencoInformazioniAggiuntive() 
				 *  e successivamente fare un cast a OperatoreFPInformazioniAggiuntiveDto
				 * (OperatoreFPInformazioniAggiuntiveDto)basicInformazioniAggiuntiveDt
				 * così sarà possibile accedere a tutti i campi
				 * */
				if (basicInfoAggiuntive!=null) {
					for (BasicInformazioniAggiuntiveDto basicInformazioniAggiuntiveDt:infoPersonaGruopDto.getElencoInformazioniAggiuntive()) {
						
						OperatoreFPInformazioniAggiuntiveDto operatoreFPInformazioniAggiuntiveDto=(OperatoreFPInformazioniAggiuntiveDto)basicInformazioniAggiuntiveDt;
						InfoOperatore tmp= new InfoOperatore();
						
						tmp.setCodOperatore(Integer.valueOf(operatoreFPInformazioniAggiuntiveDto.getCodiceOperatore()));
						tmp.setDescrOperatore(operatoreFPInformazioniAggiuntiveDto.getDescrizioneOperatore());
						tmp.setGruppoOperatore(operatoreFPInformazioniAggiuntiveDto.getGruppoOperatore());
						tmp.setCodDbOperatore(BigDecimal.valueOf(Double.valueOf(operatoreFPInformazioniAggiuntiveDto.getCodiceDbOperatore())).setScale(0));
						infoOperatoreList.add(tmp);
					}
				}
				return Response.ok(infoOperatoreList).build();
			/*
			 * TODO
			 * 
			 * ancora non sappiamo come va implementata
			 * */	
				
			}else if(codRuolo.equals("FUNZIONARIO_MASTER_SERSE")){
				ArrayList<it.csi.serse.serseweb.vo.Ruolo> ruoli = findRuoliForPersonaInApplication(httpRequest);
				it.csi.serse.serseweb.vo.Ruolo selected=ruoli.stream().filter(ruolo -> ruolo.getCodiceRuolo().equals(codRuolo)).findAny().orElse(null);
								
				String infoAggiuntiveXml="";
				List<BasicInformazioniAggiuntiveDto> basicInfoAggiuntive=null;
				
				if(selected!=null)
				{
					UseCase useCase=new UseCase();
					useCase.setId(selected.getMnemonico());
					infoAggiuntiveXml = getInfoPersonaInUseCase(httpRequest,useCase);
				}
				
				InfoPersonaGroupDto infoPersonaGruopDto = XmlConverterUtil.streamFromXml(infoAggiuntiveXml);
				
						
				if(infoPersonaGruopDto!=null) {
					basicInfoAggiuntive=infoPersonaGruopDto.getElencoInformazioniAggiuntive();
				}
				
				List<InfoOperatore> infoOperatoreList= new ArrayList<>();
				if (basicInfoAggiuntive!=null) {
					for (BasicInformazioniAggiuntiveDto basicInformazioniAggiuntiveDt:infoPersonaGruopDto.getElencoInformazioniAggiuntive()) {
						
						CustomXMLInformazioniAggiuntiveDto infoAggiuntiveCustomXml= (CustomXMLInformazioniAggiuntiveDto)basicInformazioniAggiuntiveDt;
						InfoOperatore tmp= new InfoOperatore();

					}
					
				}
				
			}
			return null;
		} catch (Exception e) {
			throw  new InternalErrorException(e);
		}
		
	}

	public boolean testResources() throws Exception {
		return orcflai.testResources();
	}
}