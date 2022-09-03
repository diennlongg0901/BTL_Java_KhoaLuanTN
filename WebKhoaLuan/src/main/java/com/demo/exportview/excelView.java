/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.exportview;

import com.demo.pojo.Diem;
import com.demo.pojo.Tongketkhoaluan;
import com.demo.repository.ScoreRepo;
import com.demo.service.ScoreService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author ADMIN
 */
public class excelView extends AbstractXlsView {
    
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook wrkbk, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment: filename=\"script.xls\"");
        
        @SuppressWarnings("unchecked")
        List<Diem> scoreScript = (List<Diem>) map.get("scoreScript");

        Sheet sheet = wrkbk.createSheet("score script");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Mã khóa luận");
        header.createCell(1).setCellValue("Sinh viên");
        header.createCell(2).setCellValue("Giảng viên");
        header.createCell(3).setCellValue("Điểm");
        header.createCell(4).setCellValue("Vị trí giảng viên");

        int numRow = 1;
        for(Diem diem : scoreScript) {
            Row row = sheet.createRow(numRow++);
            row.createCell(0).setCellValue(diem.getKhoaluan().getMaKL());
            row.createCell(1).setCellValue(diem.getKhoaluan().getDangkykhoaluan().getSinhvien().getSinhvienPK().getMaSV() + " - " +
                    diem.getKhoaluan().getDangkykhoaluan().getSinhvien().getNguoidung().getHo() + " " + diem.getKhoaluan().getDangkykhoaluan().getSinhvien().getNguoidung().getHo());
            row.createCell(2).setCellValue(diem.getGiangvien().getGiangvienPK().getMaGV() + " - " +
                    diem.getGiangvien().getNguoidung().getHo() + " " + diem.getGiangvien().getNguoidung().getTen());
            row.createCell(3).setCellValue(String.valueOf(diem.getDiem()));
            if (diem.getTieuchi().getMaTC() == 2) {
                row.createCell(4).setCellValue("Ban hội đồng");
            } else {
                row.createCell(4).setCellValue("Giảng viên hướng dẫn");
            }
        }
    }
}
