/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    @Autowired
    private Cloudinary cloudinary; 
    
    //LẤY NGƯỜI DÙNG 
    @Override
    public List<Nguoidung> getUsers(String username) {
        return this.userRepo.getUsers(username);
    }

    @Override
    public List<Nguoidung> getAllUsers() {
        return this.userRepo.getAllUsers();
    }
    
    @Override
    public Nguoidung getUserbyID(String username) {
        return this.userRepo.getUserbyID(username);
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
    public List<Nguoidung> getAllGV() {
        return this.userRepo.getAllGV();
    }
    
    @Override
    public List<Giangvien> getListGV() {
        return this.userRepo.getListGV();
    }
    
    @Override
    public List<Nguoidung> getAllSV() {
        return this.userRepo.getAllSV();
    }

    @Override
    public List<Nguoidung> getAllGVU() {
        return this.userRepo.getAllGVU();
    }

    @Override
    public List<Nguoidung> getAllQT() {
        return this.userRepo.getAllQT();
    }
    
    @Override
    public Sinhvien getSVbyID(String id) {
        return this.userRepo.getSVbyID(id);
    }

    //THÊM NGƯỜI DÙNG
    @Override
    public boolean addUser(Nguoidung user) {
        try {
            String password = user.getUsername();
            NguoidungPK nguoidungPK = new NguoidungPK();
            user.setPassword(this.passwordEncoder.encode(password));
            user.setHoatDong(Short.parseShort("1"));
            nguoidungPK.setMaND(user.getUsername());
            nguoidungPK.setChucvumaChucVu(user.getChucvu().getMaChucVu());
            user.setNguoidungPK(nguoidungPK);
            Map m = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAnh((String) m.get("secure_url"));
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
                    gv.setGiangvienPK(giangvienPK);
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUserQT(Quantri userQT) {
        userQT.setChucVu("Quản trị người dùng");     
        return this.userRepo.addUserQT(userQT);
    }
    
    @Override
    public boolean addUserGVU(Giaovu userGVU) {
        userGVU.setPhongBan("1");
        return this.userRepo.addUserGVU(userGVU);
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

    //CẬP NHẬT NGƯỜI DÙNG
    @Override
    public void updateUsers(String userID, Nguoidung user) {
      Nguoidung u = new Nguoidung();
      u.setHo(user.getHo());
      u.setTen(user.getTen());
      u.setNgaySinh(user.getNgaySinh());
      u.setUsername(user.getUsername());
      u.setGioiTinh(user.getGioiTinh());
      u.setHoatDong(Short.parseShort(user.getHoatDong().toString()));
      this.userRepo.updateUsers(user);
    }
    
    @Override
    public void updateParticularUsers(Nguoidung user) {
        Nguoidung u = new Nguoidung();
        NguoidungPK uPK = new NguoidungPK();
        uPK.setMaND(user.getNguoidungPK().getMaND());
        uPK.setChucvumaChucVu(user.getNguoidungPK().getChucvumaChucVu());
        u = this.userRepo.getUserbyID(user.getNguoidungPK().getMaND());
        if (!user.getSdt().isEmpty()) {
            u.setSdt(user.getSdt());
        }
        if (!user.getEmail().isEmpty()) {
            u.setEmail(user.getEmail());
        }
        if (!user.getNgaySinh().toString().isEmpty()) {
            u.setNgaySinh(user.getNgaySinh());
        }
        if (!user.getDiaChi().isEmpty()) {
            u.setDiaChi(user.getDiaChi());
        }
        if (!user.getPassword().isEmpty()) {
            u.setPassword(this.passwordEncoder.encode(user.getPassword()));  
        }
        this.userRepo.updateUsers(u);
    }
    
    @Override
    public void updateUsersSV(Sinhvien user) {
        this.userRepo.updateUsersSV(user);
    }
    
    //XÓA NGƯỜI DÙNG
    @Override
    public void deleteUsers(String userID) {
        this.userRepo.deleteUsers(userID);       
    }

    @Override
    public void deleteUsersQT(String userID) {
        this.userRepo.deleteUsersQT(userID);
        this.userRepo.deleteUsers(userID);
    }

     @Override
    public void deleteUsersGVU(String userID) {
        this.userRepo.deleteUsersGVU(userID);
        this.userRepo.deleteUsers(userID);
    }
    
    @Override
    public void deleteUsersGV(String userID) {
        this.userRepo.deleteUsersGV(userID);
        this.userRepo.deleteUsers(userID);
    }

    @Override
    public void deleteUsersSV(String userID) {
        this.userRepo.deleteUsersSV(userID);
        this.userRepo.deleteUsers(userID);
    }
}