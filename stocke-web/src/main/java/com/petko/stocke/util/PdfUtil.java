package com.petko.stocke.util;


import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class PdfUtil {

    private static final String IMAGE_FORMAT         = "png";
    private static final int DEFAULT_QR_CODE_WIDTH   = 120;
    private static final int DEFAULT_QR_CODE_HEIGHT  = 120;
    private static final int PERSONAL_QR_CODE_WIDTH  = 190;
    private static final int PERSONAL_QR_CODE_HEIGHT = 190;
    private static final int HEADER_TEXT_SIZE        = 14;
    private static final int TEXT_SIZE               = 12;
    // для того чтобы указанный путь работал, нужно скопировать папку src\main\resources\fonts в каталог liferay
    private static final String FONT_PATH = "/opt/liferay/fonts/arial.ttf";

    /**
     * Создание PDF документа с заданными параметрами
     * @param pdfParams
     * @throws Exception
     */
    public static byte[] createPdf(Map<String,String> pdfParams) throws Exception {
        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outByteStream);
//        PdfWriter writer = new PdfWriter("QR-cod.pdf");
        // Creating a PdfDocument
        PdfDocument pdf = new PdfDocument(writer);
        FontProgram fontProgram = FontProgramFactory.createFont(FONT_PATH);
        PdfFont font = PdfFontFactory.createFont(fontProgram,"cp1251",true);

        BufferedImage bufferedImage = QrCodeUtil.toQrCode(pdfParams.get("inputQr"),
                DEFAULT_QR_CODE_WIDTH, DEFAULT_QR_CODE_HEIGHT);
        ByteArrayOutputStream outputImgStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, IMAGE_FORMAT, outputImgStream);
        outputImgStream.toByteArray();

        // Creating a Document
        Document document = new Document(pdf);

        Text headText = new Text("QR-код для получения угольной продукции");
        headText.setBold();
        headText.setFont(font);
        headText.setFontSize(HEADER_TEXT_SIZE);
        headText.setFontColor(Color.BLACK);

        // Creating Paragraphs
        Paragraph paragraph = new Paragraph(headText);

        // Creating a table
        float [] pointColumnWidths = {300F, 200F};
        Table table = new Table(pointColumnWidths);
        // Adding cell to the table
        Cell listCell1 = new Cell(); // Creating a cell
        listCell1.setFont(font);
        listCell1.setFontSize(TEXT_SIZE);
        Border border = new DashedBorder(Color.WHITE, 3);
        listCell1.setBorder(border);
        listCell1.setTextAlignment(TextAlignment.LEFT);
        ListItem item1 = new ListItem("Персональные данные");
        item1.setBold();
        item1.setMarginTop(10);
        listCell1.add(item1);
        ListItem item2 = new ListItem(pdfParams.get("fio"));
        item2.setMarginTop(5);
        listCell1.add(item2);
        String birthDate = DateFormatUtil.parseDate(pdfParams.get("birthDate"), "dd.MM.yyyy");
        ListItem item3 = new ListItem("Дата рождения: "+birthDate);

        item3.setMarginTop(5);
        listCell1.add(item3);
        ListItem item4 = new ListItem("Пол: "+pdfParams.get("gender"));
        item4.setMarginTop(5);
        listCell1.add(item4);
        ListItem item5 = new ListItem("Документ удостоверяющий личность");
        item5.setBold();
        item5.setMarginTop(10);
        listCell1.add(item5);
        ListItem item6 = new ListItem("Серия и номер: "+pdfParams.get("docNumber"));
        item6.setMarginTop(5);
        listCell1.add(item6);

        Cell listCell2 = new Cell(); // Creating a cell
        listCell2.setBorder(border);

        ImageData data = ImageDataFactory.create(outputImgStream.toByteArray());
        Image img = new Image(data);
        listCell2.add(img);

        table.addCell(listCell1);
        table.addCell(listCell2);

        // Adding paragraphs to document
        document.add(paragraph);
        document.add(table);

        // Closing the document
        document.close();

        log.debug("PDF файл сформирован");
        return outByteStream.toByteArray();
    }


    /**
     * Создание PDF документа с Qr кодом с персональной страницы
     * @param fileParams
     * @throws Exception
     */
    public static byte[] createPdfPersonal(Map<String,String> fileParams) {
        log.info("createPdfPersonal");
        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        log.info("createPdfPersonal");
        try {
            PdfWriter writer = new PdfWriter(outByteStream);
            //        PdfWriter writer = new PdfWriter("QR-cod.pdf");
            // Creating a PdfDocument
            PdfDocument pdf = new PdfDocument(writer);
            FontProgram fontProgram  = FontProgramFactory.createFont(FONT_PATH);
            log.info("createPdfPersonal: "+fileParams.get("inputQr"));
            PdfFont font = PdfFontFactory.createFont(fontProgram,"cp1251",true);

            // Creating a Document
            Document document = new Document(pdf);

            Paragraph title_1 = setTitle("Домовладение",font);
            Cell listCell1_1 = setStyleCell(font);
            setListItem("Адрес: "+fileParams.get("address"),listCell1_1);

            Paragraph title_2 = setTitle("Персональные данные",font);
            title_2.setMarginTop(30);
            Cell listCell2_1 = setStyleCell(font);
            setListItem("ФИО: "           + fileParams.get("fullName"),listCell2_1);
            setListItem("Дата рождения: " + fileParams.get("birthdate"),listCell2_1);

            Paragraph title_3 = setTitle("Паспортные данные",font);
            title_3.setMarginTop(30);
            Cell listCell3_1 = setStyleCell(font);
            setListItem("Паспорт выдан: "    + fileParams.get("textField14"),listCell3_1);
            setListItem("Код подразделения: "+ fileParams.get("textField13"),listCell3_1);
            setListItem("Дата выдачи: "      + fileParams.get("data11"),listCell3_1);
            setListItem("Серия и номер: "    + fileParams.get("textField"),listCell3_1);

            BufferedImage bufferedImage = QrCodeUtil.toQrCode(fileParams.get("inputQr"),
                    PERSONAL_QR_CODE_WIDTH, PERSONAL_QR_CODE_HEIGHT);
            ByteArrayOutputStream outputImgStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, IMAGE_FORMAT, outputImgStream);
            outputImgStream.toByteArray();

            ImageData data = ImageDataFactory.create(outputImgStream.toByteArray());
            Image img = new Image(data);
            img.setMarginTop(50);
            img.setHorizontalAlignment(HorizontalAlignment.CENTER);


            // Adding paragraphs to document
            document.add(title_1    );
            document.add(listCell1_1);
            document.add(title_2    );
            document.add(listCell2_1);
            document.add(title_3    );
            document.add(listCell3_1);
            document.add(img        );

            // Closing the document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("createPdfPersonal");

        return outByteStream.toByteArray();
    }

    /**
     * Создание заголовка и присвоение ему стилей
     * @param title
     * @param font
     * @return
     */
    private static Paragraph setTitle(String title,PdfFont font) {
        Text text = new Text(title);
        text.setBold();
        text.setFont(font);
        text.setFontSize(HEADER_TEXT_SIZE);
        text.setFontColor(Color.BLACK);
        Paragraph paragraph = new Paragraph(text);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        return paragraph;
    }

    /**
     * Добавление стилей строке
     * @param font
     * @return
     */
    private static Cell setStyleCell(PdfFont font) {
        Cell listCell1_1 = new Cell(); // Creating a cell
        listCell1_1.setFont(font);
        listCell1_1.setFontSize(TEXT_SIZE);
        listCell1_1.setTextAlignment(TextAlignment.LEFT);
        return listCell1_1;
    }

    /**
     * Установка текста для строки с установлеными стилями
     * @param text
     * @param listCell1_1
     */
    private static void setListItem(String text, Cell listCell1_1) {
        ListItem item1_1 = new ListItem(text);
        item1_1.setMarginTop(10);
        listCell1_1.add(item1_1);
    }

}
