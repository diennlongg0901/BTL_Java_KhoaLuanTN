/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.pojo.Giangvien;
import com.demo.pojo.Giaovu;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.NguoidungPK;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import com.demo.pojo.SinhvienPK;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import javax.annotation.Resource;
import jdk.vm.ci.aarch64.AArch64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String xoaTK(Model model, @PathVariable(value = "nguoidungPK.maND") String userID) {
        String errMsg = " ";
        String role = userID.substring(0, 2);
        try {
            if (userID.substring(0, 3).equals("GVU")) {
                this.userService.deleteUsersGVU(userID);
            } else {
                switch (role) {
                    case "GV":
                        this.userService.deleteUsersGV(userID);
                        break;
                    case "SV":
                        this.userService.deleteUsersSV(userID);
                        break;
                    case "QT":
                        this.userService.deleteUsersQT(userID);
                        break;
                }
            }
            return "redirect:/quantri/QLTaiKhoan";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMSG", errMsg);
        return "redirect:/";
    }

    @GetMapping("/quantri/QLTaiKhoan/ROLE_SV")
    public String dsSinhVien(Model model) {
        model.addAttribute("chucvu", this.roleService.getChucvu());
        model.addAttribute("nguoidung", this.userService.getAllSV());
        return "QLTaiKhoan";
    }

    @GetMapping("/quantri/QLTaiKhoan/ROLE_GV")
    public String dsGiangVien(Model model) {
        model.addAttribute("chucvu", this.roleService.getChucvu());
        model.addAttribute("nguoidung", this.userService.getAllGV());
        return "QLTaiKhoan";
    }

    @GetMapping("/quantri/QLTaiKhoan/ROLE_GVU")
    public String dsGiaoVu(Model model) {
        model.addAttribute("chucvu", this.roleService.getChucvu());
        model.addAttribute("nguoidung", this.userService.getAllGVU());
        return "QLTaiKhoan";
    }

    @GetMapping("/quantri/QLTaiKhoan/ROLE_QT")
    public String dsQuanTri(Model model) {
        model.addAttribute("chucvu", this.roleService.getChucvu());
        model.addAttribute("nguoidung", this.userService.getAllQT());
        return "QLTaiKhoan";
    }

    @GetMapping("/quantri/ThongTinND/{id}")
    public String CapNhatView(Model model) {
        model.addAttribute("nganh", this.roleService.getNganh());
        model.addAttribute("khoa", this.roleService.getKhoa());
        model.addAttribute("sinhvien", new Sinhvien());
        model.addAttribute("nguoidung", new Nguoidung());
        return "ThongTinNguoiDung";
    }

    @RequestMapping("/quantri/ThongTinND/{id}")
    public String CapNhatND(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd,
            @ModelAttribute(value = "sinhvien") Sinhvien sv) {
        model.addAttribute("nganh", this.roleService.getNganh());
        model.addAttribute("khoa", this.roleService.getKhoa());
        model.addAttribute("giaovu", new Giaovu());
        model.addAttribute("giangvien", new Giangvien());
        model.addAttribute("quantri", new Quantri());
        String errMsg = " ";
        String role = id.substring(0, 2);
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        if (id.substring(0, 3).equals("GVU")) {
            userPK.setChucvumaChucVu("ROLE_GVU");
            nd.setNguoidungPK(userPK);
            this.userService.updateUsers(id, nd);
            return "redirect:/quantri/QLTaiKhoan";
        } else {
            switch (role) {
                case "GV":
                    userPK.setChucvumaChucVu("ROLE_GV");
                    nd.setNguoidungPK(userPK);
                    this.userService.updateUsers(id, nd);
                    return "redirect:/quantri/QLTaiKhoan";
                case "SV":
                    userPK.setChucvumaChucVu("ROLE_SV");
                    nd.setNguoidungPK(userPK);
                    this.userService.updateUsers(id, nd);
                    SinhvienPK svPK = new SinhvienPK();
                    svPK.setMaSV(id);
                    svPK.setMaND(id);
                    svPK.setMaChucVu("ROLE_SV");
                    sv.setSinhvienPK(svPK);
                    sv.setNienKhoa(sv.getNienKhoa());
                    this.userService.updateUsersSV(sv);
                    return "redirect:/quantri/QLTaiKhoan";
                case "QT":
                    userPK.setChucvumaChucVu("ROLE_QT");
                    nd.setNguoidungPK(userPK);
                    this.userService.updateUsers(id, nd);
                    return "redirect:/quantri/QLTaiKhoan";
            }
        }
        return "ThongTinNguoiDung";
    }

//    @RequestMapping("/quantri/ThongTinND/{id}")
//    public String CapNhatRieng(Model model, @PathVariable(value = "id") String id,
//            @ModelAttribute(value = "sinhvien") Sinhvien sv) {
//        String errMsg = " ";
//        SinhvienPK svPK = new SinhvienPK();
//        svPK.setMaSV(id);
//        svPK.setMaND(id);
//        svPK.setMaChucVu("ROLE_SV");
//        sv.setSinhvienPK(svPK);
//        try {
//            this.userService.updateUsersSV(sv);
//            return "redirect:/quantri/QLTaiKhoan";
//        } catch (Exception e) {
//            errMsg = "Đã có lỗi!";
//        }
//        return "ThongTinNguoiDung";
//    }
    //GIÁO VỤ
    @GetMapping("/giaovu/ThongTinGVU/{id}")
    public String GiaoVu(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        return "ThongTinNguoiDung";
    }

    @RequestMapping("/giaovu/ThongTinGVU/{id}")
    public String CapNhatGVU(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        String errMsg = " ";
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        userPK.setChucvumaChucVu("ROLE_GVU");
        try {
            if (!nd.getPassword().isEmpty()) {
                if (nd.getPassword().equals(nd.getConfirmPassword())) {
                    this.userService.updateParticularUsers(nd);
                } else {
                    errMsg = "Xác nhận mật khẩu sai. Vui long kiểm tra lại";
                }
            } else {
                this.userService.updateParticularUsers(nd);
            }
            return "redirect:/";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "ThongTinNguoiDung";
    }

    //GIẢNG VIÊN
    @GetMapping("/giangvien/ThongTinGV/{id}")
    public String GiangVien(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        return "ThongTinNguoiDung";
    }

    @RequestMapping("/giangvien/ThongTinGV/{id}")
    public String CapNhatGV(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        String errMsg = " ";
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        userPK.setChucvumaChucVu("ROLE_GV");
        try {
            if (!nd.getPassword().isEmpty()) {
                if (nd.getPassword().equals(nd.getConfirmPassword())) {
                    this.userService.updateParticularUsers(nd);
                } else {
                    errMsg = "Xác nhận mật khẩu sai. Vui long kiểm tra lại";
                }
            } else {
                this.userService.updateParticularUsers(nd);
            }
            return "redirect:/";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "ThongTinNguoiDung";
    }

    //SINH VIÊN
    @GetMapping("/sinhvien/ThongTinSV/{id}")
    public String SinhVien(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        return "ThongTinNguoiDung";
    }

    @RequestMapping("/sinhvien/ThongTinSV/{id}")
    public String CapNhatSV(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        String errMsg = " ";
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        userPK.setChucvumaChucVu("ROLE_SV");
        try {
            if (!nd.getPassword().isEmpty()) {
                if (nd.getPassword().equals(nd.getConfirmPassword())) {
                    nd.setNguoidungPK(userPK);
                    this.userService.updateParticularUsers(nd);
                } else {
                    errMsg = "Xác nhận mật khẩu sai. Vui long kiểm tra lại";
                }
            } else {
                this.userService.updateParticularUsers(nd);
            }
            return "redirect:/";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "ThongTinNguoiDung";
    }
}
