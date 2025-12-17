package it.csi.serse.serseweb.filter;

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
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import it.csi.serse.serseweb.api.exception.UtenteNonAbilitatoException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.ws.cxf.flaidoor.Identita;
import it.csi.serse.serseweb.api.exception.MalformedIdTokenException;
import it.csi.serse.serseweb.model.Utente;
import it.csi.serse.serseweb.utils.Constants;

@Component
@Order(1)
public class IrideIdAdapterFilter  implements Filter {
	private static final Logger LOG = LogManager.getLogger(IrideIdAdapterFilter.class);

	public static final String AUTH_ID_MARKER = "Shib-Iride-IdentitaDigitale";
	public static final String AUTH_ID_MARKER2 = "shib-iride-identitadigitale";
	private static final String DEVMODE_INIT_PARAM = "devmode";
	@Value( "${idadapterfilter.devmode}" )
	private boolean devmode;
	//private boolean devmode = false;

	@Override
	public void init(FilterConfig fc) throws ServletException {
		String devmodeParam = fc.getInitParameter(DEVMODE_INIT_PARAM);
		
		//this.devmode = "true".equalsIgnoreCase(devmodeParam);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {
		
		if (!(req instanceof HttpServletRequest)) {
			fchn.doFilter(req, resp);
			return;
		}
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;

		
		
		String token = getToken(hreq);
		LOG.debug("doFilter - token: {} for url: {} ", token, hreq.getRequestURL());
		
		if (token == null) {
			// il marcatore deve sempre essere presente altrimenti e' una
			// condizione di errore (escluse le pagine home e di servizio)
			if (mustCheckPage(hreq.getRequestURI())) {
				// LOG.error("[IrideIdAdapterFilter::doFilter] Tentativo di accesso a pagina non
				// home e non di servizio senza token di sicurezza");
				
				
				hresp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				PrintWriter pw = hresp.getWriter();
				pw.append("{\"error\": \"Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza\"}");
				
				return;
				
				//throw new ServletException(
				//		"Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
			}
			fchn.doFilter(hreq, hresp);
			return;
		}

		Identita identita=null;
		try {
			identita = getFlaidoorIdentitaFromToken(normalizeToken(token));
		} catch (MalformedIdTokenException e) {
			LOG.error("Token iride non valido: {} - {}", token, e.getMessage(), e);
			//throw new ServletException("Token di sicurezza non corretto.");
			
			hresp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			hresp.setContentType("text/json");
			PrintWriter pw = hresp.getWriter();
			pw.append("{\"error\": \"Token di sicurezza non valido\"}");
			return;
		}
		

		hreq.setAttribute(Constants.IRIDE_ATTRIBUTES.ID_REQ_ATTR, identita);

		Utente utente = new Utente();
		utente.setNome(identita.getNome());
		utente.setCognome(identita.getCognome());
		utente.setEnte("--");
		utente.setRuolo("--");
		utente.setCodFisc(identita.getCodFiscale());
		utente.setLivAuth(identita.getLivelloAutenticazione());
		utente.setCommunity(identita.getIdProvider());


		hreq.setAttribute(Constants.IRIDE_ATTRIBUTES.USERINFO_REQ_ATTR, utente);

		fchn.doFilter(hreq, hresp);
	}
	
	
	private Identita getFlaidoorIdentitaFromToken(String token) throws MalformedIdTokenException {
		Identita identita=new Identita();
	    int slash1Index = token.indexOf('/');
	    if (slash1Index == -1)
	      throw new MalformedIdTokenException(token); 
	    identita.setCodFiscale(token.substring(0, slash1Index));
	    int slash2Index = token.indexOf('/', slash1Index + 1);
	    if (slash2Index == -1)
	      throw new MalformedIdTokenException(token); 
	    identita.setNome(token.substring(slash1Index + 1, slash2Index));
	    int slash3Index = token.indexOf('/', slash2Index + 1);
	    if (slash3Index == -1)
	      throw new MalformedIdTokenException(token); 
	    identita.setCognome(token.substring(slash2Index + 1, slash3Index));
	    int slash4Index = token.indexOf('/', slash3Index + 1);
	    if (slash4Index == -1)
	      throw new MalformedIdTokenException(token); 
	    identita.setIdProvider (token.substring(slash3Index + 1, slash4Index));
	    int slash5Index = token.indexOf('/', slash4Index + 1);
	    if (slash5Index == -1)
	      throw new MalformedIdTokenException(token); 
	    identita.setTimestamp (token.substring(slash4Index + 1, slash5Index));
	    int slash6Index = token.indexOf('/', slash5Index + 1);
	    if (slash6Index == -1)
	      throw new MalformedIdTokenException(token); 
	    identita.setLivelloAutenticazione (Integer.parseInt(token.substring(slash5Index + 1, slash6Index)));
	    identita.setMac (token.substring(slash6Index + 1));
	    
	    return identita;
	  }


	private boolean mustCheckPage(String requestURI) {
		return requestURI.startsWith("/") && !requestURI.startsWith("/serseweb/bff");
	}
	

	public String getToken(HttpServletRequest httpreq) {
		
		String marker = (String) httpreq.getHeader(AUTH_ID_MARKER);
		
		LOG.info("marker:"+marker);
		if (marker == null) marker =  (String) httpreq.getHeader(AUTH_ID_MARKER2);
	
		if (marker == null && devmode) {
			return getTokenDevMode(httpreq);
		}

		if(marker==null && !devmode){
			throw new UtenteNonAbilitatoException();
		}
		return marker;
	}
/*
	private String getTokenDevMode(HttpServletRequest httpreq) {
		String marker = (String) httpreq.getParameter(AUTH_ID_MARKER);
		if (marker == null) marker =  (String) httpreq.getParameter(AUTH_ID_MARKER2);
		return marker;
	}*/
	
	private String getTokenDevMode(HttpServletRequest httpreq) {
		//return "AAAAAA00A11H000P/CSI PIEMONTE/DEMO 27/ACTALIS_EU/20220330135210/16/1B0mBEyMNK4zYLTAiYPXfQ=="; demo 27
		
		return "AAAAAA00A11D000L/CSI PIEMONTE/DEMO 23/ACTALIS_EU/20230314153733/16/Dzy7jiwy6S/9FXETmoxnwQ=="; //demo 23
	}
	
	
	private String normalizeToken(String token) {
		return token;
	}
	
	public static void main(String[] args) {
		Identita i = new Identita();
		i.setCodFiscale("AAAAAA00A11B000J");
		i.setCognome("Piemonte");
		i.setNome("Demo 21");
		i.setIdProvider("SHIB");
		i.setTimestamp("timestamp");
		i.setLivelloAutenticazione(0);
		i.setMac("mac");
		System.out.println(i);
	}
}

