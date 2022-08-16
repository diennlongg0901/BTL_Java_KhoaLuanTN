/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;


import com.demo.pojo.Giangvien;
import com.demo.pojo.Giaovu;
import antlr.Utils;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @Autowired
    private UserService userDetailsService;

    @GetMapping("/DangNhap")
    public String DangNhap(Model model) {
        return "DangNhap";
    }

    @GetMapping("/quantri/QLTaiKhoan")
    public String QLTaiKhoan(Model model) {
        model.addAttribute("nguoidung", this.userService.getAllUsers());
        model.addAttribute("chucvu", this.roleService.getChucvu());
        return "QLTaiKhoan";
    }
    
//    @GetMapping("/quantri/QLTaiKhoan/{nguoidungPK.maND}")
//    public String xoaTaiKhoanView(Model model) {
//        model.addAttribute("nguoidung", this.userService.getAllUsers());
//        model.addAttribute("chucvu", this.roleService.getChucvu());
//        return "QLTaiKhoan";
//    }
    
    @RequestMapping("/quantri/QLTaiKhoan/{nguoidungPK.maND}")
    public String xoaTaikhoan(@PathVariable(value = "nguoidungPK.maND") String userID){
       if (this.userDetailsService.deleteUsers(userID) == true)
       {
           return "redirect:/quantri/QLTaiKhoan";
       }
       else
       {
           return "redirect:/";
       }
        
    }
    
//    @DeleteMapping("/quantri/QLTaiKhoan/{nguoidungPK.maND}")
//    public void xoaTaikhoan(@PathVariable(value = "{nguoidungPK.maND}") int maND, HttpSession session){
//        Map<Integer, Nguoidung> nguoiDung = (Map<Integer, Nguoidung>) session.getAttribute("nguoiDung");
//        if(nguoiDung != null && nguoiDung.containsKey(maND)){
//            nguoiDung.remove(maND);
//            session.setAttribute("nguoiDung", maND);
//        }
//    }
    
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

    @PostMapping("/quantri/DangKy")
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
    
//    @GetMapping("/quantri/DKBoSung")
//    public String DKBSView(Model model) {
//        model.addAttribute("nguoidung", new Nguoidung());
//        model.addAttribute("quantri", new Quantri());
//        model.addAttribute("sinhvien", new Sinhvien());
//        model.addAttribute("giaovu", new Giaovu());
//        model.addAttribute("giangvien", new Giangvien());
//        model.addAttribute("chucvu", this.roleService.getChucvu());
//        model.addAttribute("nganh", this.roleService.getNganh());
//        model.addAttribute("khoa", this.roleService.getKhoa());
//        return "DangKy";
//    }
    
//    @PostMapping("/quantri/DKBoSung")
//    public String DKBoSung(Model model, @ModelAttribute(value = "nguoidung") Nguoidung nd,
//            @ModelAttribute(value = "sinhvien") Sinhvien sv,
//            @ModelAttribute(value = "giaovu") Giaovu gvu,
//            @ModelAttribute(value = "giangvien") Giangvien gv) {
//        String errMsg = "";
//        model.addAttribute("chucvu", this.roleService.getChucvu());
//        model.addAttribute("nganh", this.roleService.getNganh());
//        model.addAttribute("khoa", this.roleService.getKhoa());
//            switch (nd.getChucvu().getMaChucVu()) {
////                case "ROLE_QT":
////                    this.userDetailsService.addUserQT(qt);
////                    return "redirect:/quantri/QLTaiKhoan";
//                case "ROLE_GVU":
//                    this.userDetailsService.addUserGVU(gvu);
//                    return "redirect:/quantri/DKBoSung";
//                case "ROLE_GV":
//                    this.userDetailsService.addUserGV(gv);
//                    return "redirect:/quantri/DKBoSung";
//                case "ROLE_SV":
//                    this.userDetailsService.addUserSV(sv);
//                    return "redirect:/quantri/DKBoSung";
//            }
//            
////        } else {
////            errMsg = "Đăng ký không thành công, vui lòng kiểm tra lại!";
////        }
//
////        model.addAttribute("errMsg", errMsg);
//        return "DangKyBoSung";
//    }
    
    @GetMapping("/sinhvien/")
    public String SinhVien() {
        return "ThongTinNguoiDung";
    }

    @GetMapping("/giaovu/")
    public String GiaoVu() {
        return "ThongTinNguoiDung";
    }

    @GetMapping("/giangvien/")
    public String GiangVien() {
        return "ThongTinNguoiDung";
    }
}
