package it.csi.serse.serseweb.integration.mybatis.dto.custom;

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

import java.io.Serializable;
import java.util.Date;

public class AnnoScolasticoDTO extends ParentDTO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3505674859663965857L;
    private Long idAnnoScolastico = null;
    private String descrAnnoScolastico = null;
    private Date dataInizioVal = null;
    private Date dataFineVal = null;
	/**
	 * @return the idAnnoScolastico
	 */
	public Long getIdAnnoScolastico() {
		return idAnnoScolastico;
	}
	/**
	 * @param idAnnoScolastico the idAnnoScolastico to set
	 */
	public void setIdAnnoScolastico(Long idAnnoScolastico) {
		this.idAnnoScolastico = idAnnoScolastico;
	}
	/**
	 * @return the descrAnnoScolastico
	 */
	public String getDescrAnnoScolastico() {
		return descrAnnoScolastico;
	}
	/**
	 * @param descrAnnoScolastico the descrAnnoScolastico to set
	 */
	public void setDescrAnnoScolastico(String descrAnnoScolastico) {
		this.descrAnnoScolastico = descrAnnoScolastico;
	}
	/**
	 * @return the dataInizioVal
	 */
	public Date getDataInizioVal() {
		return dataInizioVal;
	}
	/**
	 * @param dataInizioVal the dataInizioVal to set
	 */
	public void setDataInizioVal(Date dataInizioVal) {
		this.dataInizioVal = dataInizioVal;
	}
	/**
	 * @return the dataFineVal
	 */
	public Date getDataFineVal() {
		return dataFineVal;
	}
	/**
	 * @param dataFineVal the dataFineVal to set
	 */
	public void setDataFineVal(Date dataFineVal) {
		this.dataFineVal = dataFineVal;
	}

    
}
