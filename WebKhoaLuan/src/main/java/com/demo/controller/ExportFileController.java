/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.exportview.excelView;
import com.demo.exportview.pdfView;
import com.demo.pojo.Diem;
import com.demo.pojo.Khoaluan;
import com.demo.pojo.Tongketkhoaluan;
import com.demo.service.ScoreService;
import com.demo.service.ThesisService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ADMIN
 */
@Controller
public class ExportFileController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ThesisService thesisService;
    
    @RequestMapping("/sinhvien/DiemKL/xls/{id}")
    public ModelAndView xuatFileExcel(Model model, @PathVariable(value = "id") String id){
        Khoaluan kl = this.thesisService.getThesisBySV(id);
        List<Diem> scoreList = this.scoreService.getThesisScores(kl.getMaKL());        
        return new ModelAndView(new excelView(), "scoreScript", scoreList);
    }
    
    @RequestMapping("/sinhvien/DiemKL/pdf/{id}")
    public ModelAndView xuatFilePDF(Model model, @PathVariable(value = "id") String id){
        Tongketkhoaluan result = this.scoreService.getResultScore(id);        
        return new ModelAndView(new pdfView(), "scoreScript", result);
    }  
}
