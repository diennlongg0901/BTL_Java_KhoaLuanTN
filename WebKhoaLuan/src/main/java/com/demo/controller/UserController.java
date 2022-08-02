/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author PC
 */
@Controller
public class UserController {
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/DangNhap")
    public String DangNhap(Model model){
        model.addAttribute("chucvu", this.roleService.getChucvu());
        return "DangNhap";
    }
}
