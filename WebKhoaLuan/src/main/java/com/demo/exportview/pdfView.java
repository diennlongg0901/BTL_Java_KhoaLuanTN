/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.exportview;

import com.demo.pojo.Tongketkhoaluan;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author ADMIN
 */
public class pdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document dcmnt, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType( "application/pdf" );
        response.setHeader("Content-Disposition", "filename=\"script.pdf\"");

        @SuppressWarnings("unused")
        Tongketkhoaluan scoreScript = (Tongketkhoaluan) map.get("scoreScript");
        DateFormat dinhDangNgay = new SimpleDateFormat("dd/MM/yyyy");
        String ngay = dinhDangNgay.format(new Date());
        
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        
        Paragraph p = new Paragraph("THE UNIVERSITY OF VIETNAM", fontTitle);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        
        Paragraph p1 = new Paragraph("THESIS SCRIPT", fontParagraph);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph p2 = new Paragraph("Thesis ID: " + scoreScript.getMaKL() + "              " + "Student's ID: " + scoreScript.getMaSV(), fontParagraph);
        p2.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph p3 = new Paragraph("Score: " + scoreScript.getDiem() + "                " + "  Result: " + scoreScript.getKetQua(), fontParagraph);
        p3.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph p4 = new Paragraph("Ho Chi Minh city, " + ngay, fontParagraph);
        p4.setAlignment(Paragraph.ALIGN_RIGHT);
        
        Paragraph p5 = new Paragraph("Sign             ", fontParagraph);
        p5.setAlignment(Paragraph.ALIGN_RIGHT);

        document.add(p);
        document.add(p1);
        document.add(p2);
        document.add(p3);
        document.add(p4);
        document.add(p5);
        document.close();
    }

}
