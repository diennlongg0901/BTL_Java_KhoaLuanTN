/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.pojo.Giangvien;
import com.demo.pojo.GiangvienPK;
import com.demo.pojo.Giaovu;
import com.demo.pojo.GiaovuPK;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.NguoidungPK;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import com.demo.pojo.SinhvienPK;
import com.demo.service.CouncilService;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    private CouncilService councilService;
    @Autowired
    private UserService userDetailsService;

    @ModelAttribute
    public void commonAttributes(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }

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
        try {
            if (this.userDetailsService.addUser(nd) == true) {                
                errMsg = "Đăng ký thành công, vui lòng kiểm tra lại!";
            } else {              
                errMsg = "Đăng ký không thành công, vui lòng kiểm tra lại!";
            }
            model.addAttribute("errMsg", errMsg);
            return "redirect:/quantri/QLTaiKhoan";
        } catch (Exception e) {
            errMsg = e.getMessage();
        }
        model.addAttribute("errMsg", errMsg);
        return "redirect:/";
    }

    @RequestMapping("/quantri/QLTaiKhoan/{nguoidungPK.maND}")
    public String xoaTK(Model model, @PathVariable(value = "nguoidungPK.maND") String userID) {
        String errMsg = "";
        String role = userID.substring(0, 2);
        try {
            if (userID.substring(0, 3).equals("GVU")) {
                this.userService.deleteUsersGVU(userID);
            } else {
                switch (role) {
                    case "GV":
                        this.councilService.deleteMember(userID);
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
            model.addAttribute("errMSG", errMsg);
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
        model.addAttribute("nguoidung", new Nguoidung());
        model.addAttribute("sinhvien", new Sinhvien());
        model.addAttribute("giaovu", new Giaovu());
        model.addAttribute("giangvien", new Giangvien());
        model.addAttribute("quantri", new Quantri());
        return "CapNhatND";
    }

    @RequestMapping(value = "/quantri/ThongTinND/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String CapNhatND(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        model.addAttribute("nganh", this.roleService.getNganh());
        model.addAttribute("khoa", this.roleService.getKhoa());
        String role = id.substring(0, 2);
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        if (id.substring(0, 3).equals("GVU")) {
            userPK.setMaCV("ROLE_GVU");
            nd.setNguoidungPK(userPK);
            this.userService.updateUsers(id, nd);
            Giaovu gvu = new Giaovu();
            GiaovuPK gvuPK = new GiaovuPK();
            gvuPK.setMaGVU(id);
            gvuPK.setMaND(id);
            gvuPK.setMaCV("ROLE_GVU");
            gvu.setPhongBan(nd.getPhongBan());
            gvu.setGiaovuPK(gvuPK);
            this.userService.updateUsersGVU(gvu);
            return "redirect:/quantri/QLTaiKhoan";
        } else {
            switch (role) {
                case "GV":
                    userPK.setMaCV("ROLE_GV");
                    nd.setNguoidungPK(userPK);
                    this.userService.updateUsers(id, nd);
                    GiangvienPK gvPK = new GiangvienPK();
                    Giangvien gv = new Giangvien();
                    gvPK.setMaND(id);
                    gvPK.setMaGV(id);
                    gvPK.setMaCV("ROLE_GV");
                    gv.setHocHam(nd.getHocHam());
                    gv.setHocVi(nd.getHocVi());
                    gv.setGiangvienPK(gvPK);
                    this.userService.updateUsersGV(gv);
                    return "redirect:/quantri/QLTaiKhoan";
                case "SV":
                    userPK.setMaCV("ROLE_SV");
                    nd.setNguoidungPK(userPK);
                    this.userService.updateUsers(id, nd);
                    SinhvienPK svPK = new SinhvienPK();
                    Sinhvien sv = new Sinhvien();
                    svPK.setMaSV(id);
                    svPK.setMaND(id);
                    svPK.setMaCV("ROLE_SV");
                    svPK.setMaKhoa(nd.getKhoa());
                    svPK.setMaNganh(nd.getNganh());
                    sv.setSinhvienPK(svPK);
                    sv.setNienKhoa(nd.getNienKhoa());
                    sv.setTinhTrang(nd.getTinhTrang());
                    this.userService.updateUsersSV(sv);
                    return "redirect:/quantri/QLTaiKhoan";
                case "QT":
                    userPK.setMaCV("ROLE_QT");
                    nd.setNguoidungPK(userPK);
                    this.userService.updateUsers(id, nd);
                    return "redirect:/quantri/QLTaiKhoan";
            }
        }
        return "CapNhatND";
    }

    @GetMapping("/quantri/ThongTinQT/{id}")
    public String QuanTri(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("nguoidung", new Nguoidung());
        model.addAttribute("thongtinnguoidung", this.userService.getUserbyID(id));
        return "ThongTinNguoiDung";
    }

    @RequestMapping(value = "/quantri/ThongTinQT/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String CapNhatQT(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        String errMsg = "";
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        userPK.setMaCV("ROLE_QT");
        nd.setNguoidungPK(userPK);
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
            model.addAttribute("errMsg", errMsg);
            return "ThongTinNguoiDung";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "ThongTinNguoiDung";
    }

    //GIÁO VỤ
    @GetMapping("/giaovu/ThongTinGVU/{id}")
    public String GiaoVu(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("nguoidung", new Nguoidung());
        model.addAttribute("thongtinnguoidung", this.userService.getUserbyID(id));
        return "ThongTinNguoiDung";
    }

    @RequestMapping(value = "/giaovu/ThongTinGVU/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String CapNhatGVU(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        String errMsg = "";
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        userPK.setMaCV("ROLE_GVU");
        nd.setNguoidungPK(userPK);
        try {
            if (!nd.getPassword().isEmpty()) {
                if (nd.getPassword().equals(nd.getConfirmPassword())) {
                    this.userService.updateParticularUsers(nd);
                } else {
                    errMsg = "Xác nhận mật khẩu sai. Vui long kiểm tra lại!";
                }
            } else {
                this.userService.updateParticularUsers(nd);
            }
            model.addAttribute("errMsg", errMsg);
            return "redirect:/";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "ThongTinNguoiDung";
    }

    //GIẢNG VIÊN
    @GetMapping("/giangvien/ThongTinGV/{id}")
    public String GiangVien(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("nguoidung", new Nguoidung());
        model.addAttribute("thongtinnguoidung", this.userService.getUserbyID(id));
        return "ThongTinNguoiDung";
    }

    @RequestMapping(value = "/giangvien/ThongTinGV/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String CapNhatGV(Model model, HttpSession session, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        String errMsg = "";

        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        userPK.setMaCV("ROLE_GV");
        nd.setNguoidungPK(userPK);
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
            model.addAttribute("errMsg", errMsg);
            return "redirect:/";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "ThongTinNguoiDung";
    }

    //SINH VIÊN
    @GetMapping("/sinhvien/ThongTinSV/{id}")
    public String SinhVien(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("nguoidung", new Nguoidung());
        model.addAttribute("thongtinnguoidung", this.userService.getUserbyID(id));
        return "ThongTinNguoiDung";
    }

    @RequestMapping(value = "/sinhvien/ThongTinSV/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String CapNhatSV(Model model, @PathVariable(value = "id") String id,
            @ModelAttribute(value = "nguoidung") Nguoidung nd) {
        String errMsg = "";
        NguoidungPK userPK = new NguoidungPK();
        userPK.setMaND(id);
        userPK.setMaCV("ROLE_SV");
        nd.setNguoidungPK(userPK);
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
            model.addAttribute("errMsg", errMsg);
            return "redirect:/";
        } catch (Exception e) {
            errMsg = "Đã có lỗi!";
        }
        model.addAttribute("errMsg", errMsg);
        return "ThongTinNguoiDung";
    }
}
