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

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import it.csi.serse.serseweb.api.manager.SortBean;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.InterventoDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TestInterventoModificaDTO;
import it.csi.serse.serseweb.integration.mybatis.dto.custom.TipoInterventoDTO;
import it.csi.serse.serseweb.vo.ExcelInterventiBean;

@Component
@Mapper
public interface InterventiDAO extends ParentDAO{

	List<TipoInterventoDTO>  getTipologieInterventoForPso(@Param("idPso") Long idPso);

	Integer deleteInterventoById(@Param("idIntervento") Long idIntervento);
	
	List<InterventoDTO> getInterventi(@Param("filter") FilterInterventiSemplificato filter,
		@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("sort") SortBean sort);
	
	Long countInterventi(@Param("filter") FilterInterventiSemplificato filter);
	
	List<TestInterventoModificaDTO> verificaCampiIntervento(@Param("idIntervento") Long idIntervento);

	InterventoDTO getInterventoById(@Param("idIntervento") Long idIntervento);
	
	List<InterventoDTO> getInterventiPerModello(@Param("idModelloDiIntervento") Long idModelloDiIntervento);

	List<ExcelInterventiBean> getInterventiExcel(@Param("filter") FilterInterventiSemplificato filter);

	public static class FilterInterventiSemplificato {
		private Long numProgrSportello;
		private String gruppoOperatore;
		private Integer codOperatore;
		private Integer modelId;
		private String gruppoOpBeneficiario;
		private Integer codOpBeneficiario;
		private Boolean isProprietario;

		private String codiceFiscaleDestinatario;
		private String denominazioneEnteCoinvolto;
		private String codiceTipoIntervento;
		private Integer idStatoIntervento;
		private Long idIntervento;
		private Long idServizio;

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
		public Integer getModelId() {
			return modelId;
		}
		public void setModelId(Integer modelId) {
			this.modelId = modelId;
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
		public Boolean getIsProprietario() {
			return isProprietario;
		}
		public void setIsProprietario(Boolean isProprietario) {
			this.isProprietario = isProprietario;
		}
		public String getCodiceFiscaleDestinatario() {
			return codiceFiscaleDestinatario;
		}
		public void setCodiceFiscaleDestinatario(String codiceFiscaleDestinatario) {
			this.codiceFiscaleDestinatario = codiceFiscaleDestinatario;
		}
		public String getDenominazioneEnteCoinvolto() {
			return denominazioneEnteCoinvolto;
		}
		public void setDenominazionEnteCoinvolto(String denominazioneEnteCoinvolto) {
			this.denominazioneEnteCoinvolto = denominazioneEnteCoinvolto;
		}
		public String getCodiceTipoIntervento() {
			return codiceTipoIntervento;
		}
		public void setCodiceTipoIntervento(String codiceTipoIntervento) {
			this.codiceTipoIntervento = codiceTipoIntervento;
		}
		public Integer getIdStatoIntervento() {
			return idStatoIntervento;
		}
		public void setIdStatoIntervento(Integer idStatoIntervento) {
			this.idStatoIntervento = idStatoIntervento;
		}
		public Long getIdIntervento() {
			return idIntervento;
		}
		public void setIdIntervento(Long idIntervento) {
			this.idIntervento = idIntervento;
		}
		public Long getIdServizio() {
			return idServizio;
		}
		public void setIdServizio(Long idServizio) {
			this.idServizio = idServizio;
		}
	}
}
