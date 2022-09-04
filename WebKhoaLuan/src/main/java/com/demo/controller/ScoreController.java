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
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private UserService userService;

    @GetMapping("/sinhvien/DiemKL/{id}")
    public String DiemView(Model model, @PathVariable(value = "id") String id) {
        Khoaluan kl = this.thesisService.getThesisBySV(id);
        double gvhd = this.scoreService.calculateGVHDScore(kl.getMaKL());
        double hd = this.scoreService.calculateCouncilScore(kl.getMaKL());
        double diemTong = this.scoreService.calculation(hd, gvhd);
        String result = this.scoreService.resultThesis(diemTong);
        model.addAttribute("khoaluansv", kl);
        model.addAttribute("diemhd", hd);
        model.addAttribute("diemgvhd", gvhd);
        model.addAttribute("giangvienhd", this.userService.getUserbyID(kl.getMaGV()));
        model.addAttribute("giangvienhd2", this.userService.getUserbyID(kl.getMaGV2()));
        model.addAttribute("diemkl", diemTong);
        model.addAttribute("ketqua", this.scoreService.resultThesis(diemTong));
        model.addAttribute("nhanxet", this.scoreService.getThesisScores(kl.getMaKL()));
//        if (kl.getNgayNop().compareTo(kl.getDangkykhoaluan().getDetai().getHanNop()) > 0) {
//            diemTong = 0.0;
//            result = "F";
//        }
        if (this.scoreService.getResult(id) == false) {
            return "Diem";
        }
        this.scoreService.addResult(kl, result, diemTong);
        return "Diem";
    }

    @RequestMapping(value = {"/giaovu/ThongKeDiem", "/quantri/ThongKeDiem"})
    public String ThongKeDiem(Model model, @RequestParam(value = "nam", required = false, defaultValue = "") String nam) {
        model.addAttribute("scoreStats", this.scoreService.scoreStats(nam));
        return "ThongKeDiem";
    }

    @RequestMapping(value = {"/giaovu/ThongKeSV", "/quantri/ThongKeSV"})
    public String ThongKeSV(Model model, @RequestParam(value = "maKhoa", required = false, defaultValue = "") String maKhoa) {
        model.addAttribute("svStats", this.scoreService.svStats(maKhoa));
        return "ThongKeSV";
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
        DiemPK dPK = new DiemPK();
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
        DiemPK dPK = new DiemPK();
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
