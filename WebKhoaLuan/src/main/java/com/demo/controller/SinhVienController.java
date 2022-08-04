/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

/**
 *
 * @author PC
 */
@Controller
public class SinhVienController {
    
    @Autowired
    private SinhVienService sinhvienService;
    
    
    @GetMapping("/admin/QLSinhVien")
    public String QLSinhVien(Model model){
        model.addAttribute("Sinhvien", this.sinhvienService.getSinhvien(""));
        return "QLSinhVien";
    }
}
