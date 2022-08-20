/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;


import com.demo.pojo.Giangvien;
import com.demo.pojo.Giaovu;
import antlr.Utils;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.NguoidungPK;
import com.demo.pojo.Nguoidung_;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Method;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@Resource(name = "userDetailsService")
public class UserController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserService userDetailsService;

    @GetMapping("/DangNhap")
    public String DangNhap(Model model) {
        return "DangNhap";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateTK(@PathVariable("id") String id, Model model){
        model.addAttribute("nguoidungPK", this.userService.getUserbyID(id));
        return "QLTaiKhoan";
    }

    //QUẢN TRỊ
    @GetMapping("/quantri/QLTaiKhoan")
    public String QLTaiKhoan(Model model) {
        model.addAttribute("nguoidung", this.userService.getAllUsers());
        model.addAttribute("chucvu", this.roleService.getChucvu());
        return "QLTaiKhoan";
    }
    
    @GetMapping("/quantri/DangKy")
    public String DangKyView(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        model.addAttribute("quantri", new Quantri());
        model.addAttribute("sinhvien", new Sinhvien());
        model.addAttribute("giaovu", new Giaovu());
        model.addAttribute("giangvien", new Giangvien());
        model.addAttribute("chucvu", this.roleService.getChucvu());
        model.addAttribute("nganh", this.roleService.getNganh());
        model.addAttribute("khoa", this.roleService.getKhoa());
        return "DangKy";
    }

    @PostMapping(value = "/quantri/DangKy", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DangKy(Model model, @ModelAttribute(value = "nguoidung") Nguoidung nd,
            @ModelAttribute(value = "quantri") Quantri qt,
            @ModelAttribute(value = "sinhvien") Sinhvien sv,
            @ModelAttribute(value = "giaovu") Giaovu gvu,
            @ModelAttribute(value = "giangvien") Giangvien gv) {
        String errMsg = "";
        model.addAttribute("chucvu", this.roleService.getChucvu());
        model.addAttribute("nganh", this.roleService.getNganh());
        model.addAttribute("khoa", this.roleService.getKhoa());
        if (this.userDetailsService.addUser(nd) == true) {
            switch (nd.getChucvu().getMaChucVu()) {
                case "ROLE_QT":
                    this.userDetailsService.addUserQT(qt);
                    return "redirect:/quantri/QLTaiKhoan";
                case "ROLE_GVU":
                    this.userDetailsService.addUserGVU(gvu);
                    return "redirect:/quantri/QLTaiKhoan";
                case "ROLE_GV":
                    this.userDetailsService.addUserGV(gv);
                    return "redirect:/quantri/QLTaiKhoan";
                case "ROLE_SV":
                    this.userDetailsService.addUserSV(sv);
                    return "redirect:/quantri/QLTaiKhoan";
            }            
        } else {
            errMsg = "Đăng ký không thành công, vui lòng kiểm tra lại!";
        }
        
        model.addAttribute("errMsg", errMsg);
        return "DangKy";
    }
    
    @RequestMapping(value = "/quantri/QLTaiKhoan/{nguoidungPK.maND}")
    public String xoaTK(Model model, @PathVariable(value = "nguoidungPK.maND") String userID){
        String errMsg = " ";
        String role = userID.substring(0, 2);
        try {
            switch (role) {
                case "GV0":
                    this.userService.deleteUsersGV(userID);
                    break;
                case "GVU":
                    this.userService.deleteUsersGVU(userID);
                    break;
                case "SV0":
                    this.userService.deleteUsersSV(userID);
                    break;
                case "QT0":
                    this.userService.deleteUsersQT(userID);
                    break;
        }
            return "redirect:/quantri/QLTaiKhoan";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!" + " " + userID + " " + e;
        }
        model.addAttribute("errMSG", errMsg);
        return "redirect:/";      
    }
    
    //GIÁO VỤ
    @GetMapping("/giaovu/")
    public String GiaoVu() {
        return "ThongTinNguoiDung";
    }

    //GIẢNG VIÊN
    @GetMapping("/giangvien/")
    public String GiangVien() {
        return "ThongTinNguoiDung";
    }
    
    //SINH VIÊN
    @GetMapping("/sinhvien/")
    public String SinhVien() {
        return "ThongTinNguoiDung";
    }
}
