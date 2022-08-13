/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Giangvien;
import com.demo.pojo.GiangvienPK;
import com.demo.pojo.Giaovu;
import com.demo.pojo.GiaovuPK;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.NguoidungPK;
import com.demo.pojo.Quantri;
import com.demo.pojo.QuantriPK;
import com.demo.pojo.Sinhvien;
import com.demo.pojo.SinhvienPK;
import com.demo.repository.UserRepo;
import com.demo.service.UserService;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public List<Nguoidung> getUsers(String username) {
        return this.userRepo.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Nguoidung> user = this.getUsers(username);
        if (user.isEmpty())
        {
            throw new UsernameNotFoundException("Tài khoản người dùng quản trị không có!");
        }
        Nguoidung u = user.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(u.getChucvu().getMaChucVu()));
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), auth);
    }

    @Override
    public boolean addUser(Nguoidung user) {
        String password = user.getUsername();
        NguoidungPK nguoidungPK = new NguoidungPK();
        user.setPassword(this.passwordEncoder.encode(password));
        user.setHoatDong(Short.parseShort("1"));
        nguoidungPK.setMaND(user.getUsername());
        nguoidungPK.setChucvumaChucVu(user.getChucvu().getMaChucVu());
        user.setNguoidungPK(nguoidungPK);
        this.userRepo.addUser(user);
        switch (user.getChucvu().getMaChucVu()) {
            case "ROLE_QT":
                Quantri qt = new Quantri();
                qt.setNguoidung(user);
                QuantriPK quantriPK = new QuantriPK();
                quantriPK.setMaQT(user.getUsername());
                quantriPK.setNguoidungmaND(user.getUsername());
                quantriPK.setNguoidungchucvumaChucVu(user.getChucvu().getMaChucVu());
                qt.setQuantriPK(quantriPK);
                addUserQT(qt);
                break;
            case "ROLE_GVU":
                Giaovu gvu = new Giaovu();
                gvu.setNguoidung(user);
                GiaovuPK giaovuPK = new GiaovuPK();
                giaovuPK.setMaGV(user.getUsername());
                giaovuPK.setNguoidungchucvumaChucVu(user.getChucvu().getMaChucVu());
                giaovuPK.setNguoidungmaND(user.getUsername());
                gvu.setGiaovuPK(giaovuPK);
                addUserGVU(gvu);
                break;
            case "ROLE_GV":
                Giangvien gv = new Giangvien();
                gv.setNguoidung(user);
                GiangvienPK giangvienPK = new GiangvienPK();
                giangvienPK.setMaChucVu(user.getChucvu().getMaChucVu());
                giangvienPK.setMaGV(user.getUsername());
                giangvienPK.setMaND(user.getUsername());
                addUserGV(gv);
                break;
            case "ROLE_SV":
                Sinhvien sv = new Sinhvien();
                sv.setNguoidung(user);
                SinhvienPK sinhvienPK = new SinhvienPK();
                sinhvienPK.setMaSV(user.getUsername());
                sinhvienPK.setMaND(user.getUsername());
                sinhvienPK.setMaChucVu(user.getChucvu().getMaChucVu());
                sinhvienPK.setMaNganh(Short.parseShort("1"));
                sinhvienPK.setMaKhoa(Short.parseShort("1"));
                sv.setSinhvienPK(sinhvienPK);
                addUserSV(sv);
                break;
        }
        return true;
    }

    @Override
    public List<Nguoidung> getAllUsers() {
        return this.userRepo.getAllUsers();
    }  

    @Override
    public boolean addUserQT(Quantri userQT) {
        userQT.setChucVu("Quản trị người dùng");     
        return this.userRepo.addUserQT(userQT);
    }

    @Override
    public boolean addUserSV(Sinhvien userSV) {
        userSV.setTinhTrang(Short.parseShort("1"));
        userSV.setNienKhoa(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        return this.userRepo.addUserSV(userSV);
    }

    @Override
    public boolean addUserGV(Giangvien userGV) {
        return this.userRepo.addUserGV(userGV);
    }

    @Override
    public boolean addUserGVU(Giaovu userGVU) {
        userGVU.setPhongBan("1");
        return this.userRepo.addUserGVU(userGVU);
    }
}
