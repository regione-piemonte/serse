package it.csi.serse.serseweb.mapper;

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

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import it.csi.serse.serseweb.vo.Comune;
import it.csi.serse.serseweb.vo.PersonaGiuridica;
import it.csi.serse.serseweb.vo.SedeOperatore;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FlaiAnagMapper {

	/* =========== ANAGRAFE PG =============================================================== */
	
    @Mapping(target = "codiceIstatComune", source = "codiceComune")
    @Mapping(target = "descrizioneComune", source = "denominazioneComune")
    @Mapping(target = "provincia.codiceProvincia", source = "siglaProvincia")
	// recupera il CAP a posteriori dalla sede legale (vd. AfterMapping). Il bacino non viene settato.
	public Comune toVo(it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.Comune source);
	
	public SedeOperatore toVo(it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiSede dto);

	// Questo è alternativo a quello sotto, prende i dati della sede e del CAP da un posto diverso
    @Mapping(target = "denominazione", source = "sintesiPG.denominazionePersonaGiuridica")
    @Mapping(target = "codOperatore", source = "sintesiPG.sintesiOperatore.operatore.codiceOperatore")
    @Mapping(target = "gruppoOperatore", source = "sintesiPG.sintesiOperatore.operatore.codiceGruppoOperatore")
    @Mapping(target = "codiceFiscale", source = "sintesiPG.codiceFiscale")
    @Mapping(target = "partitaIva", source = "sintesiPG.partitaIva")
    @Mapping(target = "sede", source = "datiOperatore.sedeLegale.datiGenerali")
    public PersonaGiuridica toVo(it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.DettaglioPersonaGiuridica dto);
	
	@AfterMapping
	public default void toVo(@MappingTarget PersonaGiuridica target, it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.ResultDettaglioPersonaGiuridica source) {
		try {
			target.getSede().getComune().setCap(
				source.getDettaglioPersonaGiuridica().getDatiOperatore().getSedeLegale().getDatiGenerali().getCap()
			);
		} catch(NullPointerException exc) {
			//pazienza
		}
	}
	
    @Mapping(target = "denominazione", source = "denominazionePersonaGiuridica")
    @Mapping(target = "codOperatore", source = "sintesiOperatore.operatore.codiceOperatore")
    @Mapping(target = "gruppoOperatore", source = "sintesiOperatore.operatore.codiceGruppoOperatore")
    @Mapping(target = "sede", source = "sintesiSedeLegale") // e si porterà dietro comune e provincia
	public PersonaGiuridica toVo(it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica dto);

	public List<PersonaGiuridica> toVoListaPG(List<it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafepg.SintesiPersonaGiuridica> dto);

	/* =========== ANAGRAFE SEDI =============================================================== */
	
    @Mapping(target = "comune", ignore = true)
	public SedeOperatore toVo(it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.SintesiSede dto, @Context VoMapper voMapper);

	@AfterMapping
	default void afterMapping(it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.SintesiSede source, @MappingTarget SedeOperatore target, @Context VoMapper voMapper) {
		if (source.getComune() != null && source.getComune().getCodiceComune() != null) {
			target.setComune(voMapper.tornaComune(source.getComune().getCodiceComune()));
		}
	}

	public List<SedeOperatore> toVoListaSedi(List<it.csi.serse.serseweb.integration.ws.cxf.flaianag.flaianagpgAnagrafesedi.SintesiSede> dto, @Context VoMapper voMapper);
}
