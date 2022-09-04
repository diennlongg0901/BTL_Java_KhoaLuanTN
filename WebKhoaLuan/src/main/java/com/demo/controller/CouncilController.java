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
import org.springframework.web.bind.annotation.PathVariable;
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

    //LẤY DANH SÁCH HỘI ĐỒNG
    @GetMapping("/giaovu/HoiDong")
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

    @GetMapping("/giangvien/HoiDong/{id}")
    public String HoiDong(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("hoidonggv", this.councilService.getCouncilByGV(id));
        return "HoiDong";
    }

    //THÊM HỘI ĐỒNG VÀ CHI TIẾT HỘI ĐỒNG
    @PostMapping(value = "/giaovu/HoiDong", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String HoiDong(Model model, @ModelAttribute(value = "hoidong") Hoidong council,
            @ModelAttribute(value = "chitiethoidong") Chitiethoidong detailCouncil) {
        model.addAttribute("giangvien", this.userService.getListGV());

        int sl = 0;
        String errMsg = "";
        if (council.getTenHD() != null) {
            if (this.councilService.addCouncil(council) == true) {
                errMsg = "Thêm hội đồng thành công.";

            } else {
                errMsg = "Đã xảy ra lỗi!";
            }
        } else {
            Hoidong hd = new Hoidong();
            hd = (Hoidong) this.councilService.getNewCouncil();
            if (this.councilService.countMember(hd.getMaHD()) < 5) {
                if (this.councilService.addDetailCouncil(detailCouncil) == true) {
                    errMsg = "Thêm thành viên hội đồng thành công.";
                } else {
                    errMsg = "Đã xảy ra lỗi!";
                }
            } else {
                errMsg = "Vượt quá số lượn thành viên!";
            }
        }
        model.addAttribute("errMsg", errMsg);
        return "Hoidong";
    }
    
    @GetMapping("/giaovu/Hoidong/{id}")
    public String KhoaHoiDongView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("nguoidung", this.userService.getAllUsers());
        model.addAttribute("giangvien", this.userService.getListGV());
        model.addAttribute("hoidong", new Hoidong());
        model.addAttribute("chitiethoidong", new Chitiethoidong());
        model.addAttribute("dschitiethoidong", this.councilService.getListCouncilDetail());
        return "HoiDong";
    }
    
    @RequestMapping("/giaovu/Hoidong/{id}")
    public String KhoaHoiDong(Model model, @PathVariable(value = "id") int id) {
        this.councilService.blockCouncil(id);
        return "redirect:/giaovu/HoiDong";
    }
}
