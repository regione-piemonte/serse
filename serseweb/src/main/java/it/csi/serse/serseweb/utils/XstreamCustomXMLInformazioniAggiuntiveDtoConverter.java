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

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.BasicInformazioniAggiuntiveDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.CustomXMLInformazioniAggiuntiveDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.InfoPersonaGroupDto;
import it.csi.flaidoor.orchflai.dto.flaidoorsrv.informazioniaggiuntive.util.XmlInfoPersonaTipo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/*
 * Non posso usare la classe XmlConverterUtil della libreria di flaidoor perchè utilizza log4j che io non utilizzo poichè è vulnerabile 
 */
public class XstreamCustomXMLInformazioniAggiuntiveDtoConverter extends ReflectionConverter {
  private static final String TO_REPLACE = "TOREPLACE";
  
  private static Logger log = LogManager.getLogger("orchflai.presentation");
  
  private boolean forceCustomXML = false;
  
  public XstreamCustomXMLInformazioniAggiuntiveDtoConverter(Mapper mapper, ReflectionProvider reflectionProvider, boolean forceCustomXML) {
    super(mapper, reflectionProvider);
    this.forceCustomXML = forceCustomXML;
  }
  
  @Override
  public boolean canConvert(Class type) {
    return BasicInformazioniAggiuntiveDto.class.isAssignableFrom(type);
  }
  
  public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
    if (value instanceof CustomXMLInformazioniAggiuntiveDto) {
      CustomXMLInformazioniAggiuntiveDto customXmlInfoAggDto = (CustomXMLInformazioniAggiuntiveDto)value;
      if (customXmlInfoAggDto.getCodiceRuolo() != null)
        writer.addAttribute("ruolo", 
            customXmlInfoAggDto.getCodiceRuolo()); 
      if (customXmlInfoAggDto.getCategoria() != null)
        writer.addAttribute("categoria", 
            customXmlInfoAggDto.getCategoria()); 
      if (customXmlInfoAggDto.getDescrizioneDettaglio() != null) {
        writer.startNode("descrizioneDettaglio");
        context.convertAnother(customXmlInfoAggDto.getDescrizioneDettaglio());
        writer.endNode();
      } 
      if (customXmlInfoAggDto.getCodiceDettaglio() != null) {
        writer.startNode("codiceDettaglio");
        context.convertAnother(customXmlInfoAggDto.getCodiceDettaglio());
        writer.endNode();
      } 
      if (customXmlInfoAggDto.get_xml() != null && customXmlInfoAggDto.getCodiceDettaglio() != null) {
        writer.startNode("TOREPLACE");
        context.convertAnother(customXmlInfoAggDto.getCodiceDettaglio());
        writer.endNode();
      } 
    } else {
      super.marshal(value, writer, context);
    } 
  }
  
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    try {
      BasicInformazioniAggiuntiveDto infoAggiuntiveDto = XmlInfoPersonaTipo.instanceBasicInformazioniAggiuntiveDto(reader.getAttribute("categoria"));
      if (this.forceCustomXML || infoAggiuntiveDto instanceof CustomXMLInformazioniAggiuntiveDto)
        return unmarshalCustomXml(reader, context); 
      return doUnmarshal(infoAggiuntiveDto, reader, context);
    } catch (Throwable e) {
      log.warn("[XstreamCustomXMLInformazioniAggiuntiveDtoConverter::unmarshal]" + e.getMessage());
      return unmarshalCustomXml(reader, context);
    } 
  }
  
  private Object unmarshalCustomXml(HierarchicalStreamReader reader, UnmarshallingContext context) {
    String codiceRuolo = reader.getAttribute("ruolo");
    String categoria = reader.getAttribute("categoria");
    String codiceDettaglio = "";
    String descrizioneDettaglio = "";
    while (reader.hasMoreChildren()) {
      reader.moveDown();
      if ("codiceDettaglio".equals(reader.getNodeName()))
        codiceDettaglio = reader.getValue(); 
      if ("descrizioneDettaglio".equals(reader.getNodeName()))
        descrizioneDettaglio = reader.getValue(); 
      reader.moveUp();
    } 
    CustomXMLInformazioniAggiuntiveDto custom = new CustomXMLInformazioniAggiuntiveDto();
    custom.setCodiceDettaglio(codiceDettaglio);
    custom.setCodiceRuolo(codiceRuolo);
    custom.setCategoria(categoria);
    custom.setDescrizioneDettaglio(descrizioneDettaglio);
    return custom;
  }
  
  public static String replaceXmlCustom(String xml, List elencoCustomXmlDto) {
    String newXml = xml;
    if (elencoCustomXmlDto != null && elencoCustomXmlDto.size() > 0)
      for (Object obj : elencoCustomXmlDto) {
        if (obj.getClass().equals(CustomXMLInformazioniAggiuntiveDto.class)) {
          CustomXMLInformazioniAggiuntiveDto customXmlDto = (CustomXMLInformazioniAggiuntiveDto)obj;
          newXml = newXml.replaceAll("<TOREPLACE>" + customXmlDto.getCodiceDettaglio() + "</" + "TOREPLACE" + ">", customXmlDto.get_xml());
        } 
      }  
    return newXml;
  }
  
  public static InfoPersonaGroupDto addXmlCustomToBean(InfoPersonaGroupDto infop, String infoAggiuntiveXML) {
    InfoPersonaGroupDto infopNew = infop;
    if (infoAggiuntiveXML != null && !infoAggiuntiveXML.equals("")) {
      List<BasicInformazioniAggiuntiveDto> elenco = infopNew.getElencoInformazioniAggiuntive();
      if (elenco != null && !elenco.isEmpty())
        for (BasicInformazioniAggiuntiveDto obj : elenco) {
          if (obj.getClass().equals(CustomXMLInformazioniAggiuntiveDto.class)) {
            CustomXMLInformazioniAggiuntiveDto custom = (CustomXMLInformazioniAggiuntiveDto)obj;
            Pattern pat = Pattern.compile("<codiceDettaglio>" + custom.getCodiceDettaglio() + "</codiceDettaglio>(.+)</info-persona>+", 32);
            Matcher matcher = pat.matcher(infoAggiuntiveXML);
            if (matcher.find()) {
              String customXml = matcher.group(1);
              custom.set_xml(customXml.trim());
            } 
          } 
        }  
    } 
    return infopNew;
  }
}
