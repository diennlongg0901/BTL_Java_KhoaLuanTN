/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.pojo.Diem;
import com.demo.pojo.DiemPK;
import com.demo.pojo.Khoaluan;
import com.demo.service.ScoreService;
import com.demo.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ThesisService thesisService;
    
    @GetMapping("/sinhvien/DiemKL/{id}")
    public String DiemView(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("khoaluansv", this.thesisService.getThesisBySV(id));
        int kl =this.thesisService.getThesisBySV(id).getMaKL();
        model.addAttribute("diemhd", this.scoreService.getScore(kl, 1));
        model.addAttribute("diemgvhd", this.scoreService.getScore(kl, 2));
        model.addAttribute("", model);
        return "Diem";
    }
    
    @RequestMapping("/giaovu/ThongKeDiem")
    public String ThongKeDiem() {
        return "ThongKeDiem";
    }
    
    @GetMapping("/giangvien/ChamDiem/{id}")
    public String ChamDiemView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("diem", new Diem());
//        model.addAttribute("tieuchi", this.scoreService.getCriteria(id));
        return "Diem";
    }
    
    @PostMapping(value = "/giangvien/ChamDiem/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String ChamDiemGVHD(Model model, @PathVariable(value = "id") int id,
            @ModelAttribute(value = "diem") Diem diem) {
        Khoaluan kl = this.thesisService.getThesisbyID(id);
        DiemPK dPK  = new DiemPK();
        dPK.setMaKL(id);
        dPK.setMaND(diem.getMaGVHD());
        dPK.setMaGV(diem.getMaGVHD());
        dPK.setMaCV("ROLE_GV");
        dPK.setMaTC(2);
        diem.setDiemPK(dPK);
        this.scoreService.addScore(diem);
        return "Diem";
    }
    
    @GetMapping("/giangvien/ChamDiemHD/{id}")
    public String ChamDiemHDView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("diem", new Diem());
        return "Diem";
    }
    
    @PostMapping(value = "/giangvien/ChamDiemHD/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String ChamDiemHD(Model model, @PathVariable(value = "id") int id,
            @ModelAttribute(value = "diem") Diem diem) {
        Khoaluan kl = this.thesisService.getThesisbyID(id);
        DiemPK dPK  = new DiemPK();
        dPK.setMaKL(id);
        dPK.setMaND(diem.getMaGVHD());
        dPK.setMaGV(diem.getMaGVHD());
        dPK.setMaCV("ROLE_GV");
        dPK.setMaTC(1);
        diem.setDiemPK(dPK);
        this.scoreService.addScore(diem);
        return "Diem";
    }
}
