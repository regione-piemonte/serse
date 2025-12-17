package it.csi.serse.serseweb.utils;

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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.BasicInformazioniAggiuntiveDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.InfoPersonaGroupDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.ProfiloPersonaDto;

/*
 * Non posso usare la classe XmlConverterUtil della libreria di flaidoor per 2 motivi
 * - utilizza log4j che io non utilizzo poichè è vulnerabile 
 * - ottengo un'errore com.thoughtworks.xstream.security.ForbiddenClassException per cui ho dovuto aggiungere questo codice:
 *   stream.addPermission(AnyTypePermission.ANY);
 */
public class XmlConverterUtil {
  private static final String XSD_RESOURCE = "/infoaggiuntive.xsd";
  
  private static final String INFOAGGIUNTIVE_SCHEMA_NS_URI = "http://www.example.org/infoaggiuntive";
  
  private static final String W3C_XML_SCHEMA_NS_URI = "http://www.w3.org/2001/XMLSchema";
  
  private static Logger logger = LogManager.getLogger("orchflai");
  
  public static InfoPersonaGroupDto streamFromXml(String infoAggiuntiveXML, boolean forceCustomXML) {
    try {
      XStream stream = getXStreamForInfoPersonaGroupDto(forceCustomXML);
      stream.addPermission(AnyTypePermission.ANY);
      InfoPersonaGroupDto infop = (InfoPersonaGroupDto)stream.fromXML(infoAggiuntiveXML);
      infop = XstreamCustomXMLInformazioniAggiuntiveDtoConverter.addXmlCustomToBean(infop, infoAggiuntiveXML);
      return infop;
    } catch (Throwable e) {
      logger.error("[XmlConverterUtil::streamFromXml] Errore durante la deserializzazione.", e);
      return null;
    } 
  }
  
  public static InfoPersonaGroupDto streamFromXml(String infoAggiuntiveXML) {
    return streamFromXml(infoAggiuntiveXML, false);
  }
  
  public static String streamToXml(InfoPersonaGroupDto infoPersonaGroupDto) {
    XStream stream = getXStreamForInfoPersonaGroupDto(false);
    String xml = "";
    if (infoPersonaGroupDto != null && infoPersonaGroupDto.getProfiloPersona() != null) {
      xml = stream.toXML(infoPersonaGroupDto);
      if (infoPersonaGroupDto.getElencoInformazioniAggiuntive() != null && 
        !infoPersonaGroupDto.getElencoInformazioniAggiuntive().isEmpty())
        xml = XstreamCustomXMLInformazioniAggiuntiveDtoConverter.replaceXmlCustom(xml, infoPersonaGroupDto.getElencoInformazioniAggiuntive()); 
    } 
    return xml;
  }
  
  private static XStream getXStreamForInfoPersonaGroupDto(boolean forceCustomXML) {
    XStream stream = new XStream((HierarchicalStreamDriver)new DomDriver());
    stream.alias("info-persona-group", InfoPersonaGroupDto.class);
    stream.aliasField("profilo-persona", InfoPersonaGroupDto.class, "profiloPersona");
    stream.aliasField("id-profilo", ProfiloPersonaDto.class, "idProfilo");
    stream.aliasField("id-macro-profilo", ProfiloPersonaDto.class, "idMacroprofilo");
    stream.aliasField("descrizione-breve-profilo", ProfiloPersonaDto.class, "descrizioneProfiloBreve");
    stream.aliasField("descrizione-estesa-profilo", ProfiloPersonaDto.class, "descrizioneProfiloEstesa");
    stream.aliasField("tipoDelega", ProfiloPersonaDto.class, "tipoDelega");
    stream.addImplicitCollection(InfoPersonaGroupDto.class, "elencoInformazioniAggiuntive");
    stream.aliasType("info-persona", BasicInformazioniAggiuntiveDto.class);
    stream.useAttributeFor(BasicInformazioniAggiuntiveDto.class, "codiceRuolo");
    stream.aliasAttribute(BasicInformazioniAggiuntiveDto.class, "codiceRuolo", "ruolo");
    stream.useAttributeFor(BasicInformazioniAggiuntiveDto.class, "categoria");
    stream.registerConverter((Converter)new XstreamCustomXMLInformazioniAggiuntiveDtoConverter(stream.getMapper(), stream.getReflectionProvider(), forceCustomXML), 10000);
    return stream;
  }
}
