/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class ThesisController {
    
    @RequestMapping("/DeTaiKhoaLuan") 
    public String DeTaiKL() {
        return "DeTaiKhoaLuan";
    }
    
    @RequestMapping("/giaovu/PhanCongGV")
    public String PhanCongGV() {
        return "PhanCongGiangVien";
    }
    
    @RequestMapping("/giaovu/ThongKeDiem")
    public String ThongKeDiem() {
        return "ThongKeDiem";
    }
    
    @RequestMapping("/sinhvien/KhoaLuan")
    public String NopKL() {
        return "KhoaLuan";
    }
}
