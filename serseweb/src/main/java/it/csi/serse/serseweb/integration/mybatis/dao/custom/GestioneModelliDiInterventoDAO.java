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
import it.csi.serse.serseweb.integration.mybatis.dto.custom.ModelloInterventoDTO;
import it.csi.serse.serseweb.vo.ExcelModelliBean;

@Component
@Mapper
public interface GestioneModelliDiInterventoDAO extends ParentDAO {

	List<ModelloInterventoDTO> getModelliIntervento(@Param("filter") FilterModelliSemplificato filter,
		@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("sort") SortBean sort);

	Long countModelliIntervento(@Param("filter") FilterModelliSemplificato filter);
	
	Integer deleteModelloIntervento(@Param("idModelloIntervento") Integer idModelloIntervento);
	
	Integer insertModelloIntervento(@Param("modelloIntervento") ModelloInterventoDTO modelloIntervento);
	
	Integer updateModelloIntervento(@Param("modelloIntervento") ModelloInterventoDTO modelloIntervento);

	ModelloInterventoDTO  getModelloDiInterventoById(@Param("idModelloIntervento") Long idModelloIntervento);

	Integer getDatiExcelModello(@Param("idModelloIntervento") Long idModelloIntervento);

	List<ExcelModelliBean> getModelliExcel(@Param("filter") FilterModelliSemplificato filter);

	public static class FilterModelliSemplificato {
		private Long numProgrSportello;
		private String gruppoOperatore;
		private Integer codOperatore;
		private Integer modelId;
		private String gruppoOpBeneficiario;
		private Integer codOpBeneficiario;
		private Boolean isProprietario;
		private String codiceTipoModello;
		private String enteCoinvolto;
		private Integer idServizioRegionale;
		private Integer idStatoModelloIntervento;
		private Long idModelloIntervento;

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
		public String getCodiceTipoModello() {
			return codiceTipoModello;
		}
		public void setCodiceTipoModello(String codiceTipoModello) {
			this.codiceTipoModello = codiceTipoModello;
		}
		public String getEnteCoinvolto() {
			return enteCoinvolto;
		}
		public void setEnteCoinvolto(String enteCoinvolto) {
			this.enteCoinvolto = enteCoinvolto;
		}
		public Integer getIdServizioRegionale() {
			return idServizioRegionale;
		}
		public void setIdServizioRegionale(Integer idServizioRegionale) {
			this.idServizioRegionale = idServizioRegionale;
		}
		public Integer getIdStatoModelloIntervento() {
			return idStatoModelloIntervento;
		}
		public void setIdStatoModelloIntervento(Integer idStatoModelloIntervento) {
			this.idStatoModelloIntervento = idStatoModelloIntervento;
		}
		public Long getIdModelloIntervento() {
			return idModelloIntervento;
		}
		public void setIdModelloIntervento(Long idModelloIntervento) {
			this.idModelloIntervento = idModelloIntervento;
		}
	}
}
