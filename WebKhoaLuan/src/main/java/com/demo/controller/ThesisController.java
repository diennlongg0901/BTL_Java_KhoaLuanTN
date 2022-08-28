/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.pojo.Dangkykhoaluan;
import com.demo.pojo.DangkykhoaluanPK;
import com.demo.pojo.Detai;
import com.demo.pojo.Khoaluan;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.Sinhvien;
import com.demo.service.RoleService;
import com.demo.service.ThesisService;
import com.demo.service.UserService;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class ThesisController {
    
    @Autowired
    private ThesisService thesisService;    
    @Autowired
    private UserService userService;     
    @Autowired
    private RoleService roleService;
    
    //ĐỀ TÀI KHÓA LUẬN
    @GetMapping(value="/DeTaiKhoaLuan",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DeTaiKLView(Model model) {
        model.addAttribute("detai", this.thesisService.getTopics());
        model.addAttribute("detaimoi", new Detai());
        model.addAttribute("nguoidung", new Nguoidung());
        return "DeTaiKhoaLuan";
    }
    
    @RequestMapping(value = "/DeTaiKhoaLuan", produces = "application/x-www-form-urlencoded;charset=UTF-8") 
    public String DeTaiKL(Model model, @ModelAttribute(value = "detaimoi") Detai topic) {
        String errMsg = "";
        
        topic.setNam(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        if (this.thesisService.addTopic(topic) == true) {
            errMsg = "Thêm đề tài thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/DeTaiKhoaLuan";
        } else {
            errMsg = "Thêm đề tài không thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/DeTaiKhoaLuan/{id}")
    public String xoaDeTai(Model model, @PathVariable(value = "id") int id) {
        String errMsg = "";
        if (this.thesisService.deleteTopic(id) == true) {
            errMsg = "Xóa đề tài thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/DeTaiKhoaLuan";
        } else {
            errMsg = "Xóa đề tài không thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/";
        }
    }
    
    //ĐĂNG KÝ KHÓA LUẬN
    @GetMapping(value ="/sinhvien/DangKyKL/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DangKyKLView(Model model, @PathVariable("id") String id) {
        model.addAttribute("detai", this.thesisService.getTopics());
        model.addAttribute("dangkykhoaluan", new Dangkykhoaluan());
        model.addAttribute("nguoidung", this.userService.getUserbyID(id));
        return "DangKyKhoaLuan";
    }
    
    @RequestMapping(value="/sinhvien/DangKyKL/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DangKyKL(Model model,@PathVariable("id") String id ,@ModelAttribute(value = "dangkykhoaluan") Dangkykhoaluan dk) {
        model.addAttribute("detai", this.thesisService.getTopics());     
        Sinhvien sv = this.userService.getSVbyID(id);
        DangkykhoaluanPK dkklPK = new DangkykhoaluanPK();
        dkklPK.setMaDT(dk.getMaDT());
        dkklPK.setMaND(id);
        dkklPK.setSinhvienmaSV(id);
        dkklPK.setMaCV("ROLE_SV");
        dkklPK.setMaKhoa(sv.getSinhvienPK().getMaKhoa());
        dkklPK.setMaNganh(sv.getSinhvienPK().getMaNganh());
        dk.setDangkykhoaluanPK(dkklPK);
        this.thesisService.addRegistration(dk);
        return "DangKyKhoaLuan";
    }
    
    //KHÓA LUẬN
    @GetMapping("/giaovu/dsDangKyKhoaLuan")
    public String dsKhoaLuan(Model model) {
        model.addAttribute("dsdangkykhoaluan", this.thesisService.getRegistedThesises());
        return "DangKyKhoaLuan";
    }
    
    @GetMapping("/giaovu/PhanCongGV/{id}")
    public String PhanCongGVView(Model model) {
        model.addAttribute("giangvien", this.userService.getAllGV());
        model.addAttribute("khoaluan", new Khoaluan());
        return "PhanCongGiangVien";
    }
    
    @RequestMapping("/giaovu/PhanCongGV/{id}")
    public String PhanCongGV(Model model, @PathVariable(value = "id") int id, 
            @ModelAttribute(value = "khoaluan") Khoaluan kl) {
        model.addAttribute("giangvien", this.userService.getAllGV());
        return "PhanCongGiangVien";
    }
    
    @GetMapping("/sinhvien/KhoaLuan")
    public String nopKLView(Model model) {
        return "KhoaLuan";
    }
    
    @RequestMapping("/sinhvien/KhoaLuan")
    public String NopKL(Model model) {
        return "KhoaLuan";
    }

    @RequestMapping("/giaovu/ThongKeDiem")
    public String ThongKeDiem() {
        return "ThongKeDiem";
    }
}
