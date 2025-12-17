package it.csi.serse.serseweb.excel;

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


import it.csi.serse.serseweb.api.exception.ErroreGestitoException;
import it.csi.serse.serseweb.model.ExcelInterventoModel;
import it.csi.serse.serseweb.model.ExcelModelloModel;
import it.csi.serse.serseweb.model.ExcelServizioModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


public class ExcelExport {


    public byte[] getBytes(Workbook workbook) {

        byte[] bytes;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            workbook.write(byteArrayOutputStream);
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {

            throw new RuntimeException("Failed to convert Excel to byte array: " + e.getMessage());
        }

        return bytes;
    }


    public <T>  Response addDataToWorkbook(List<T> dati, List<String> headers ) {

        Workbook workbook = new XSSFWorkbook();



        Sheet dataSheet = workbook.createSheet();

        dataSheet=inizializzaHeaders(dataSheet,headers);
        CellStyle dataStyle= workbook.createCellStyle();
        dataStyle.setWrapText(true);
        dataStyle.setVerticalAlignment(VerticalAlignment.TOP);
        dataStyle.setShrinkToFit(true);
        for (int i = 1; i <= dati.size(); i++) {
            Row row = dataSheet.createRow(i);
               if(dati.get(i-1) instanceof ExcelServizioModel) {
                    inserisciDatoInRigaServizio((ExcelServizioModel)dati.get(i-1), row);
               }else if(dati.get(i-1) instanceof ExcelInterventoModel){
                    inserisciDatoRigaIntervento((ExcelInterventoModel)dati.get(i-1),row);
               }else if(dati.get(i-1) instanceof ExcelModelloModel){
                    inserisciDatoRigaModello((ExcelModelloModel)dati.get(i-1), row);
               }else{
                   throw new ErroreGestitoException("tipo di dato non supportato");
               }
               row.setRowStyle(dataStyle);
               row.setHeight((short)1000);
        }



        for (int i=0; i < headers.size();i++){
            int size= dataSheet.getRow(0).getCell(i).getStringCellValue().length();
            if(size<25){size=25;}
            //dobbiamo moltiplicare il valore per 256
            //perchè il parametro che passiamo equivale a 1/256 di dimensione di un carattere
            dataSheet.setColumnWidth(i,(size+2) * 256);
        }


       return  Response.ok(getBytes(workbook)).build();

    }

    protected Sheet inizializzaHeaders(Sheet sheet, List<String> headers){
        Row row=sheet.createRow(0);
        CellStyle style=sheet.getWorkbook().createCellStyle();
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        for (int i=0; i< headers.size();i++){
            row.createCell(i);

            Cell tmp=row.createCell(i);

            tmp.setCellValue(headers.get(i));
            tmp.setCellStyle(style);

        }
        return sheet;
    }
    protected Row inserisciDatoRigaModello(ExcelModelloModel dato, Row row){

        Cell pso= row.createCell(0);
        Cell sportello= row.createCell(1);
        Cell soggettoBeneficiario=row.createCell(2);
        Cell soggettoAttuatoreProrietario=row.createCell(3);
        Cell istanzaCandidatura=row.createCell(4);
        Cell identificativoModello=row.createCell(5);
        Cell titoloModello=row.createCell(6);
        Cell tipologiaModello=row.createCell(7);
        Cell finalitaModello= row.createCell(8);
        Cell referente= row.createCell(9);
        Cell statoModello= row.createCell(10);
        Cell tipologieServiziAssociati= row.createCell(11);
        Cell serviziEstrni= row.createCell(12);
        Cell totInterventiAssociati= row.createCell(13);
        Cell entiCoinvolti= row.createCell(14);
        Cell codUserInserimento=row.createCell(15);
        Cell codUserAggiornamento=row.createCell(16);

        pso.setCellValue(dato.getTipologiaPso());
        sportello.setCellValue(dato.getSportelloRiferimento());
        soggettoBeneficiario.setCellValue(dato.getSoggettoBeneficiario());
        soggettoAttuatoreProrietario.setCellValue(dato.getSoggettoAttuatoreProprietario());
        istanzaCandidatura.setCellValue(dato.getIstanzaCandidatura());
        identificativoModello.setCellValue(dato.getIdModello());
        titoloModello.setCellValue(dato.getTitoloModello());
        tipologiaModello.setCellValue(dato.getTipologiaModello());
        finalitaModello.setCellValue(dato.getFinalitaModello());
        referente.setCellValue(dato.getCognomeNomeReferente());
        statoModello.setCellValue(dato.getStatoModello());
        tipologieServiziAssociati.setCellValue(dato.getTipologieServizi());
        serviziEstrni.setCellValue(dato.getServiziEsterni());
        totInterventiAssociati.setCellValue(dato.getTotInterventiAssociati());
        entiCoinvolti.setCellValue(dato.getEntiCoinvolti());
        codUserInserimento.setCellValue(dato.getCodUserInserimento());
        codUserAggiornamento.setCellValue(dato.getCoduserAggiornamento());
        return row;
    }
    protected Row inserisciDatoRigaIntervento(ExcelInterventoModel dato, Row row){
        Cell pso= row.createCell(0);
        Cell sportello= row.createCell(1);
        Cell soggettoBeneficiario=row.createCell(2);
        Cell soggettoAttuatoreProrietario=row.createCell(3);
        Cell istanzaCandidatura=row.createCell(4);
        Cell identificativoIntervento=row.createCell(5);
        Cell titoloIntervento=row.createCell(6);
        Cell tipologiaIntervento=row.createCell(7);
        Cell finalitaIntervento= row.createCell(8);
        Cell identificativoModelloAssociato=row.createCell(9);
        Cell referente= row.createCell(10);
        Cell statoIntervento= row.createCell(11);
        Cell cognomeNomeDestinatario=row.createCell(12);
        Cell cfDestinatario=row.createCell(13);
        Cell tipologieServizi=row.createCell(14);
        Cell totServiziAssociati= row.createCell(15);
        Cell totServiziChiusi= row.createCell(16);
        Cell entiCoinvolti= row.createCell(17);
        Cell codUserInserimento=row.createCell(18);
        Cell codUserAggiornamento=row.createCell(19);

        pso.setCellValue(dato.getTipologiaPso());
        sportello.setCellValue(dato.getSportelloRiferimento());
        soggettoBeneficiario.setCellValue(dato.getSoggettoBeneficiario());
        soggettoAttuatoreProrietario.setCellValue(dato.getSoggettoAttuatoreProprietario());
        istanzaCandidatura.setCellValue(dato.getIstanzaCandidatura());
        identificativoIntervento.setCellValue(dato.getIdIntervento());
        titoloIntervento.setCellValue(dato.getTitoloIntervento());
        tipologiaIntervento.setCellValue(dato.getTipologiaIntervento());
        finalitaIntervento.setCellValue(dato.getFinalitaIntervento());
        if(dato.getIdModelloAssociato()!=null) {
            identificativoModelloAssociato.setCellValue(dato.getIdModelloAssociato());
        }else{
            identificativoModelloAssociato.setBlank();
        }
        referente.setCellValue(dato.getCognomeNomeReferente());
        statoIntervento.setCellValue(dato.getStatoIntervento());
        cognomeNomeDestinatario.setCellValue(dato.getCognomeNomeDestinatario());
        cfDestinatario.setCellValue(dato.getCodiceFiscaleDestinatario());
        tipologieServizi.setCellValue(dato.getTipologieServizi());
        totServiziAssociati.setCellValue(dato.getTotServizi());
        totServiziChiusi.setCellValue(dato.getTotServiziChiusi());
        entiCoinvolti.setCellValue(dato.getEntiCoinvolti());
        codUserInserimento.setCellValue(dato.getCodUserInserimento());
        codUserAggiornamento.setCellValue(dato.getCoduserAggiornamento());


        return row;
    }
    protected Row inserisciDatoInRigaServizio(ExcelServizioModel dato, Row row){
        Cell pso = row.createCell(0);
        Cell sportello = row.createCell(1);
        Cell soggettoBeneficiario = row.createCell(2);
        Cell soggettoAttuatoreProrietario = row.createCell(3);
        Cell sedeSoggettoAttuatore = row.createCell(4);
        Cell istanzaCandidatura = row.createCell(5);
        Cell identificativoServizio = row.createCell(6);
        Cell titoloServizio = row.createCell(7);
        Cell tipologiaServizio = row.createCell(8);
        Cell finalitaSerivzio = row.createCell(9);
        Cell identificativoInterventoAssociato = row.createCell(10);
        Cell statoServizio = row.createCell(11);
        Cell durata = row.createCell(12);
        Cell numMaxDestinatari = row.createCell(13);
        Cell numDestinatariAssociati = row.createCell(14);
        Cell cognomeNomeDestinatario = row.createCell(15);
        Cell cfDestinatario = row.createCell(16);
        Cell totIncontri = row.createCell(17);
        Cell totIncontriChiusi = row.createCell(18);
        Cell entiCoinvolti = row.createCell(19);
        Cell codUserInserimento = row.createCell(20);
        Cell codUserAggiornamento = row.createCell(21);
        Cell valoreCampoAggiuntivo1 = row.createCell(22);

        pso.setCellValue(dato.getTipologiaPso());
        sportello.setCellValue(dato.getSportelloRiferimento());
        soggettoBeneficiario.setCellValue(dato.getSoggettoBeneficiario());
        soggettoAttuatoreProrietario.setCellValue(dato.getSoggettoAttuatoreProprietario());
        sedeSoggettoAttuatore.setCellValue(dato.getSedeSoggettoAttuatore()!= null ? dato.getSedeSoggettoAttuatore() : "" );
        istanzaCandidatura.setCellValue(dato.getIstanzaCandidatura());
        identificativoServizio.setCellValue(dato.getIdServizio());
        titoloServizio.setCellValue(dato.getTitoloServizio());
        tipologiaServizio.setCellValue(dato.getTipologiaServizio());
        finalitaSerivzio.setCellValue(dato.getFinalitaServizio());
        if(dato.getIdInterventoAssociato()!=null) {
            identificativoInterventoAssociato.setCellValue(dato.getIdInterventoAssociato());
        }else{
            identificativoInterventoAssociato.setBlank();
        }
        statoServizio.setCellValue(dato.getStatoServizio());
        durata.setCellValue(dato.getDurata());
        numMaxDestinatari.setCellValue(dato.getNumMaxDestinatari());
        numDestinatariAssociati.setCellValue(dato.getNumDestinatariAssociati());
        cognomeNomeDestinatario.setCellValue(dato.getCognomeNomeDestinatario());
        cfDestinatario.setCellValue(dato.getCodiceFiscaleDestinatario());
        totIncontri.setCellValue(dato.getTotIncontriDefiniti());
        totIncontriChiusi.setCellValue(dato.getTotIncontriChiusi());
        entiCoinvolti.setCellValue(dato.getEntiCoinvolti());
        codUserInserimento.setCellValue(dato.getCodUserInserimento());
        codUserAggiornamento.setCellValue(dato.getCoduserAggiornamento());
        valoreCampoAggiuntivo1.setCellValue(dato.getValoreCampoAggiuntivo1());

        return row;
    }


}
