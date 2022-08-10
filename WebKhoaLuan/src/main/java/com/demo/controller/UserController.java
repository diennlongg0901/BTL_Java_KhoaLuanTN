/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.service.RoleService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author PC
 */
@Controller
public class UserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/DangNhap")
    public String DangNhap(Model model){
        return "DangNhap";
    }
    
    @GetMapping("/quantri/QLTaiKhoan")
    public String QLTaiKhoan(Model model){
        model.addAttribute("nguoidung", this.userService.getAllUsers());
        return "QLTaiKhoan";
    }
    
    @GetMapping("/quantri/DangKy")
    public String DangKy(Model model) {
        model.addAttribute("chucvu", this.roleService.getChucvu());
        return "DangKy";
    }
    
    @GetMapping("/sinhvien/")
    public String SinhVien() {
        return "SinhVien";
    }
    
    @GetMapping("/giaovu/")
    public String GiaoVu() {
        return "GiaoVu";
    }
    
    @GetMapping("/giangvien/")
    public String GiangVien() {
        return "GiangVien";
    }
}
