/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.pojo.Detai;
import com.demo.pojo.Khoaluan;
import com.demo.service.ThesisService;
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
    
    //ĐỀ TÀI KHÓA LUẬN
    @GetMapping("/DeTaiKhoaLuan")
    public String DeTaiKLView(Model model) {
        model.addAttribute("detai", this.thesisService.getTopics());
        model.addAttribute("detaimoi", new Detai());
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
    
    //KHÓA LUẬN
    @GetMapping("/sinhvien/DangKyKL")
    public String DangKyKLView(Model model) {
        model.addAttribute("khoaluan", new Khoaluan());
        return "DangKyKhoaLuan";
    }
    
    @RequestMapping("/sinhvien/DangKyKL")
    public String DangKyKL(Model model, @ModelAttribute(value = "khoaluan") Khoaluan thesis) {   
        return "DangKyKhoaLuan";
    }
    
    @GetMapping("/sinhvien/KhoaLuan")
    public String nopKLView(Model model) {
        return "Khoaluan";
    }
    
    @RequestMapping("/sinhvien/KhoaLuan")
    public String NopKL(Model model) {
        return "KhoaLuan";
    }
    
    @RequestMapping("/giaovu/PhanCongGV")
    public String PhanCongGV() {
        return "PhanCongGiangVien";
    }
    
    @RequestMapping("/giaovu/ThongKeDiem")
    public String ThongKeDiem() {
        return "ThongKeDiem";
    }
}
