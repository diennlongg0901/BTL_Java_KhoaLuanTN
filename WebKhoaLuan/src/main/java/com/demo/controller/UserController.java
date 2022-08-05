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
        model.addAttribute("chucvu", this.roleService.getChucvu());
        return "DangNhap";
    }
    
    @GetMapping("/admin/QLSinhVien")
    public String QLSinhVien(Model model){
        model.addAttribute("Sinhvien", this.userService.getSinhvien());
        return "QLSinhVien";
    }
}
