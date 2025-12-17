package it.csi.serse.serseweb.integration.mybatis.dao.custom;

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

import it.csi.serse.serseweb.api.manager.SortBean;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DestinatarioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.DettaglioClasseDestinatarioServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioRegionaleDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioVoceSpesaDTO;
import it.csi.serse.serseweb.vo.ExcelServiziBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.integration.mybatis.dto.custom.ServizioModelloDTO;

@Component
@Mapper
public interface GestioneServiziDAO extends ParentDAO{
	List<ServizioModelloDTO> getTipologieServiziForModelloIntervento(@Param("idModellointervento")Long idModellointervento);
	List<ServizioRegionaleDTO> getTipologieServiziForIntervento(@Param("idIntervento")Long idModellointervento);
	List<ServizioModelloDTO> getServiziEsternoForIdModelloIntervento(@Param("idModelloIntervento") Long idModelloIntervento);
	
	ServizioModelloDTO getServizioEsternoById( @Param("idServizioModello")Long idServizioModello );
	Integer deleteServizioModelloById(@Param("idServizioModello")Long idServizioModello);
	Integer insertServiziModelloEsterno(@Param("servizioModelloEsterno") ServizioModelloDTO servizioModelloEsterno);
	Integer updateServiziModelloEsterno(@Param("servizioModelloEsterno") ServizioModelloDTO servizioModelloEsterno);

	List<ServizioRegionaleDTO> getServiziRegionaliForPso(@Param("idPso")Long idPso);
	Integer deleteServiziModelloRegionale(@Param("idServizioModello") Long idServizioModello, @Param("idModelloIntervento") Long idModelloIntervento, @Param("idServizioRegionale") Long idServizioRegionale);
	Integer insertServiziModelloRegionale(@Param("servizioModelloRegionale") ServizioModelloDTO servizioModelloRegionale);
	Integer updateServiziModelloRegionale(@Param("servizioModelloRegionale") ServizioModelloDTO servizioModelloRegionale);

	List<ServizioDTO> getServizi(@Param("filter") FilterServiziSemplificato filtroSemplificato,
		@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("sort") SortBean sort);

	Long countServizi(@Param("filter") FilterServiziSemplificato filtroSemplificato);

	DestinatarioDTO getDestinatarioForServizioIndividuale(@Param("idServizio") Long idServizio);

	ServizioDTO getServizioById(@Param("idServizio") Long idServizio);
	
	List<ServizioVoceSpesaDTO> getServiziVoceSpesa(@Param("idServizio")Long idServizio);

	List<ServizioDTO> getServiziDestinatari(@Param("idDestinatario") Long idDestinatario);

    List<ExcelServiziBean> getServiziExcel(@Param("filter") FilterServiziSemplificato filter);

	DettaglioClasseDestinatarioServizioDTO getClasseServizioByIdServzioAndIdPso(@Param("idServizio")Long idServizio, @Param("idPso")Long idPso);

	public static class FilterServiziSemplificato {
		private Long numProgrSportello;
		private String gruppoOperatore;
		private Integer codOperatore;
		private Long idServizio;
		private Integer modelId;
		private Long idServizioRegionale;
		private String denominazioneEnte;
		private String codFiscaleDestinatario;
		private Long idStatoServizio;
		private String idFinalitaServizio;
		private Integer progressivoSede;
		private String gruppoOpBeneficiario;
		private Integer codOpBeneficiario;
		private Integer situazioneIncontro;
		private Boolean isProprietario;

		public Long getNumProgrSportello() {
			return numProgrSportello;
		}
		public void setNumProgrSportello(Long numProgrSportello) {
			this.numProgrSportello = numProgrSportello;
		}
		public String getGruppoOperatore() {
			return gruppoOperatore;
		}
		public void setGruppoOperatore(String gruppoOperatore) {
			this.gruppoOperatore = gruppoOperatore;
		}
		public Integer getCodOperatore() {
			return codOperatore;
		}
		public void setCodOperatore(Integer codOperatore) {
			this.codOperatore = codOperatore;
		}
		public Long getIdServizio() {
			return idServizio;
		}
		public void setIdServizio(Long idServizio) {
			this.idServizio = idServizio;
		}
		public Integer getModelId() {
			return modelId;
		}
		public void setModelId(Integer modelId) {
			this.modelId = modelId;
		}
		public Long getIdServizioRegionale() {
			return idServizioRegionale;
		}
		public void setIdServizioRegionale(Long idServizioRegionale) {
			this.idServizioRegionale = idServizioRegionale;
		}
		public String getDenominazioneEnte() {
			return denominazioneEnte;
		}
		public void setDenominazioneEnte(String denominazioneEnte) {
			this.denominazioneEnte = denominazioneEnte;
		}
		public String getCodFiscaleDestinatario() {
			return codFiscaleDestinatario;
		}
		public void setCodFiscaleDestinatario(String codFiscaleDestinatario) {
			this.codFiscaleDestinatario = codFiscaleDestinatario;
		}
		public Long getIdStatoServizio() {
			return idStatoServizio;
		}
		public void setIdStatoServizio(Long idStatoServizio) {
			this.idStatoServizio = idStatoServizio;
		}
		public String getIdFinalitaServizio() {
			return idFinalitaServizio;
		}
		public void setIdFinalitaServizio(String idFinalitaServizio) {
			this.idFinalitaServizio = idFinalitaServizio;
		}
		public Integer getProgressivoSede() {
			return progressivoSede;
		}
		public void setProgressivoSede(Integer progressivoSede) {
			this.progressivoSede = progressivoSede;
		}
		public String getGruppoOpBeneficiario() {
			return gruppoOpBeneficiario;
		}
		public void setGruppoOpBeneficiario(String gruppoOpBeneficiario) {
			this.gruppoOpBeneficiario = gruppoOpBeneficiario;
		}
		public Integer getCodOpBeneficiario() {
			return codOpBeneficiario;
		}
		public void setCodOpBeneficiario(Integer codOpBeneficiario) {
			this.codOpBeneficiario = codOpBeneficiario;
		}
		public Integer getSituazioneIncontro() {
			return situazioneIncontro;
		}
		public void setSituazioneIncontro(Integer situazioneIncontro) {
			this.situazioneIncontro = situazioneIncontro;
		}
		public Boolean getIsProprietario() {
			return isProprietario;
		}
		public void setIsProprietario(Boolean isProprietario) {
			this.isProprietario = isProprietario;
		}
	}
}
