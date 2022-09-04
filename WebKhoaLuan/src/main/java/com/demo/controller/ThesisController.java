/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.controller;

import com.demo.pojo.Dangkykhoaluan;
import com.demo.pojo.DangkykhoaluanPK;
import com.demo.pojo.Detai;
import com.demo.pojo.Diem;
import com.demo.pojo.DiemPK;
import com.demo.pojo.Giangvien;
import com.demo.pojo.Khoaluan;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.NguoidungPK;
import com.demo.pojo.Sinhvien;
import com.demo.service.CouncilService;
import com.demo.service.RoleService;
import com.demo.service.ThesisService;
import com.demo.service.UserService;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class ThesisController {

    @Autowired
    private ThesisService thesisService;
    @Autowired
    private UserService userService;
    @Autowired
    private CouncilService councilService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MailSender mailSender;

    //ĐỀ TÀI KHÓA LUẬN
    @GetMapping(value = "/DeTaiKhoaLuan", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DeTaiKLView(Model model) {
        model.addAttribute("detai", this.thesisService.getTopics());
        model.addAttribute("detaimoi", new Detai());
        model.addAttribute("nguoidung", new Nguoidung());
        return "DeTaiKhoaLuan";
    }

    @RequestMapping(value = "/DeTaiKhoaLuan", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DeTaiKL(Model model, @ModelAttribute(value = "detaimoi") Detai topic) {
        String errMsg = "";

        topic.setNam(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        if (this.thesisService.addTopic(topic) == true) {
            errMsg = "Thêm đề tài thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/DeTaiKhoaLuan";
        } else {
            errMsg = "Thêm đề tài không thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/DeTaiKhoaLuan/{id}")
    public String xoaDeTai(Model model, @PathVariable(value = "id") int id) {
        String errMsg = "";
        this.thesisService.deleteRegistedThesis(id);
        if (this.thesisService.deleteTopic(id) == true) {
            errMsg = "Xóa đề tài thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/DeTaiKhoaLuan";
        } else {
            errMsg = "Xóa đề tài không thành công.";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/";
        }
    }

    //ĐĂNG KÝ KHÓA LUẬN
    @GetMapping(value = "/sinhvien/DangKyKL/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DangKyKLView(Model model, @PathVariable("id") String id) {
        model.addAttribute("detai", this.thesisService.getTopics());
        model.addAttribute("dangkykhoaluan", new Dangkykhoaluan());
        model.addAttribute("nguoidung", this.userService.getUserbyID(id));
        return "DangKyKhoaLuan";
    }

    @RequestMapping(value = "/sinhvien/DangKyKL/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String DangKyKL(Model model, @PathVariable("id") String id, @ModelAttribute(value = "dangkykhoaluan") Dangkykhoaluan dk) {
        model.addAttribute("detai", this.thesisService.getTopics());
        Sinhvien sv = this.userService.getSVbyID(id);
        DangkykhoaluanPK dkklPK = new DangkykhoaluanPK();
        dkklPK.setMaDT(dk.getMaDT());
        dkklPK.setMaND(id);
        dkklPK.setMaSV(id);
        dkklPK.setMaCV("ROLE_SV");
        dkklPK.setMaKhoa(sv.getSinhvienPK().getMaKhoa());
        dkklPK.setMaNganh(sv.getSinhvienPK().getMaNganh());
        dk.setDangkykhoaluanPK(dkklPK);
        if (this.thesisService.addRegistration(dk) == true) {
            return "redirect:/";
        }

        return "DangKyKhoaLuan";
    }

    //KHÓA LUẬN
    @GetMapping("/giaovu/dsDangKyKhoaLuan")
    public String dsDangKyKL(Model model) {
        model.addAttribute("dsdangkykhoaluan", this.thesisService.getRegistedThesises());
        return "DangKyKhoaLuan";
    }

    @GetMapping("/giaovu/PhanCongGV/{id}")
    public String PhanCongGVView(Model model, @PathVariable(value = "id") int id) {
        String idSV = this.thesisService.getRegistedThesisByID(id).getMaSV2();
        model.addAttribute("giangvien", this.userService.getListGV());
        model.addAttribute("hoidong", this.councilService.getCouncils());
        model.addAttribute("khoaluan", new Khoaluan());
        model.addAttribute("dangkykhoaluan", this.thesisService.getRegistedThesisByID(id));
        if (!idSV.isEmpty()) {
            model.addAttribute("sinhvien", this.userService.getUserbyID(idSV));
        } else {
            model.addAttribute("sinhvien", null);
        }
        return "PhanCongGiangVien";
    }

    @RequestMapping("/giaovu/PhanCongGV/{id}")
    public String PhanCongGV(Model model, @PathVariable(value = "id") int id,
            @ModelAttribute(value = "khoaluan") Khoaluan kl) {
        model.addAttribute("giangvien", this.userService.getAllGV());
        model.addAttribute("hoidong", this.councilService.getCouncils());
        Dangkykhoaluan dkkl = this.thesisService.getRegistedThesisByID(id);
        kl.setMaSV2(dkkl.getMaSV2());
        kl.setNam(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        kl.setDangkykhoaluan(dkkl);
        this.thesisService.addThesis(kl);
        Giangvien gv1 = this.userService.getGVbyID(kl.getMaGV());
        String email1 = gv1.getNguoidung().getEmail();
        sendEmail(email1, "Hội đồng trường đại học", "Bạn đã được phân công để hướng dẫn khóa luận " + kl.getMaKL() + ". Vui lòng vào Website để xem thông tin.");

        if (kl.getMaGV2() != null) {
            Giangvien gv2 = this.userService.getGVbyID(kl.getMaGV2());
            String email2 = gv2.getNguoidung().getEmail();
            sendEmail(email2, "Hội đồng trường đại học", "Bạn đã được phân công để hướng dẫn thứ 2 khóa luận " + kl.getMaKL() + ". Vui lòng vào Website để xem thông tin.");
        }
        return "redirect:/giaovu/dsDangKyKhoaLuan";
    }

    @GetMapping(value = "/sinhvien/KhoaLuan/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String nopKLView(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("sinhvien", this.userService.getUserbyID(id));
        model.addAttribute("khoaluan", new Khoaluan());
        return "KhoaLuan";
    }

    @RequestMapping(value = "/sinhvien/KhoaLuan/{id}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String NopKL(Model model, @PathVariable("id") String id, @ModelAttribute("value=khoaluan") Khoaluan khoaluan) {
        Date date = Date.from(Instant.now());
        Khoaluan kl = this.thesisService.getThesisBySV(id);
        kl.setGhiChu(khoaluan.getGhiChu());
        kl.setNgayNop(date);
        kl.setFile(khoaluan.getFile());
        this.thesisService.updateThesis(kl);

        return "KhoaLuan";
    }

    @GetMapping("/giangvien/dsKhoaLuan/{idGV}")
    public String dsKhoaLuan(Model model, @PathVariable(value = "idGV") String idGV) {
        model.addAttribute("dskhoaluanGV", this.thesisService.getThesisByGV(idGV));
        return "KhoaLuan";
    }

    @GetMapping("/giangvien/KhoaLuanHD/{id}")
    public String dsKhoaLuanHD(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dskhoaluanhd", this.thesisService.getThesisByIDCouncil(id));
        return "KhoaLuanHD";
    }

    public void sendEmail(String to, String chuDe, String noiDung) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(chuDe);
        simpleMailMessage.setText(noiDung);

        mailSender.send(simpleMailMessage);
    }
}
