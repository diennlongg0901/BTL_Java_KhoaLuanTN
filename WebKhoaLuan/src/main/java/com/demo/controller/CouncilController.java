/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.pojo.Chitiethoidong;
import com.demo.pojo.Hoidong;
import com.demo.service.CouncilService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
public class CouncilController {

    @Autowired
    private UserService userService;
    @Autowired
    private CouncilService councilService;
    @Autowired
    private UserService userDetailsService;

    //LẤY DANH SÁCH HỘI ĐỒNG
    @GetMapping("/HoiDong")
    public String HoiDong(Model model) {
        model.addAttribute("nguoidung", this.userService.getAllUsers());
        model.addAttribute("giangvien", this.userService.getListGV());
        model.addAttribute("hoidong", new Hoidong());
        model.addAttribute("chitiethoidong", new Chitiethoidong());
        model.addAttribute("dschitiethoidong", this.councilService.getListCouncilDetail());
        return "HoiDong";
    }
    
    @RequestMapping("/Hoidong")
    public String DSHoiDong(Model model, @RequestParam(value = "tenHD", required = false, defaultValue = "") String tenHD) {
        model.addAttribute("dschitiethoidong", this.councilService.getCouncilDetail(tenHD));
        return "HoiDong";
    }

    //THÊM HỘI ĐỒNG
    @PostMapping("/HoiDong")
    public String HoiDong(Model model, @ModelAttribute(value = "hoidong") Hoidong council,
            @ModelAttribute(value = "chitiethoidong") Chitiethoidong detailCouncil) {
        model.addAttribute("giangvien", this.userService.getListGV());
        String errMsg = " ";
        if (council.getTenHD() != null) {
            if (this.councilService.addCouncil(council) == true) {
                errMsg = " ";
            } else {
                errMsg = "Đã xảy ra lỗi!";
            }
        } else if (this.councilService.addDetailCouncil(detailCouncil) == true) {
            errMsg = " ";
        } else {
            errMsg = "Đã xảy ra lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "HoiDong";
    }
}
