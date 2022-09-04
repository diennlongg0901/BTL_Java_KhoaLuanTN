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
import com.demo.pojo.Nganh;
import com.demo.pojo.NganhPK;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //  Lấy danh sách tài khoản người dùng theo username
    @Override
    public List<Nguoidung> getUsers(String username) {
        return this.userRepo.getUsers(username);
    }

    //  Lấy danh sách tài khoản người dùng
    @Override
    public List<Nguoidung> getAllUsers() {
        return this.userRepo.getAllUsers();
    }

    //  Lấy tài khoản người dùng theo username
    @Override
    public Nguoidung getUserbyID(String username) {
        return this.userRepo.getUserbyID(username);
    }

    //  Lấy tài khỏan người dùng theo username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Nguoidung> user = this.getUsers(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản người dùng quản trị không có!");
        }
        Nguoidung u = user.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(u.getChucvu().getMaCV()));
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), auth);
    }

    //  Lấy danh sách tài khoản giảng viên bảng người dùng
    @Override
    public List<Nguoidung> getAllGV() {
        return this.userRepo.getAllGV();
    }

    //  Lấy danh sách tài khoản giảng viên
    @Override
    public List<Giangvien> getListGV() {
        return this.userRepo.getListGV();
    }

    //  Lấy danh sách tài khoản sinh viên
    @Override
    public List<Nguoidung> getAllSV() {
        return this.userRepo.getAllSV();
    }

    //  Lấy danh sách tài khoản giáo vụ
    @Override
    public List<Nguoidung> getAllGVU() {
        return this.userRepo.getAllGVU();
    }

    //  Lấy danh sách tài khoản quản trị
    @Override
    public List<Nguoidung> getAllQT() {
        return this.userRepo.getAllQT();
    }

    //  Lấy tài khoản sinh viên theo mã sinh viên
    @Override
    public Sinhvien getSVbyID(String id) {
        return this.userRepo.getSVbyID(id);
    }

    //  Lấy tài khoản giảng viên theo mã giảng viên
    @Override
    public Giangvien getGVbyID(String id) {
        return this.userRepo.getGVbyID(id);
    }
    
    //THÊM NGƯỜI DÙNG
    //  Thêm mới tài khoản người dùng
    @Override
    public boolean addUser(Nguoidung user) {
        try {
            String password = user.getUsername();
            NguoidungPK nguoidungPK = new NguoidungPK();
            user.setPassword(this.passwordEncoder.encode(password));
            user.setHoatDong(Short.parseShort("1"));
            user.setDiaChi(user.getDiaChi());
            user.setEmail(user.getEmail());
            user.setSdt(user.getSdt());
            nguoidungPK.setMaND(user.getUsername());
            nguoidungPK.setMaCV(user.getChucvu().getMaCV());
            user.setNguoidungPK(nguoidungPK);
            Map m = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAnh((String) m.get("secure_url"));
            this.userRepo.addUser(user);
            switch (user.getChucvu().getMaCV()) {
                case "ROLE_QT":
                    Quantri qt = new Quantri();
                    QuantriPK qtPK = new QuantriPK();
                    qtPK.setMaQT(user.getUsername());
                    qtPK.setMaND(user.getUsername());
                    qtPK.setMaCV("ROLE_QT");
                    qt.setNhiemVu("Quản trị người dùng");
                    qt.setNguoidung(user);
                    qt.setQuantriPK(qtPK);
                    addUserQT(qt);
                    break;
                case "ROLE_GVU":
                    Giaovu gvu = new Giaovu();
                    GiaovuPK gvuPK = new GiaovuPK();
                    gvuPK.setMaGVU(user.getUsername());
                    gvuPK.setMaND(user.getUsername());
                    gvuPK.setMaCV("ROLE_GVU");
                    gvu.setPhongBan(user.getPhongBan());
                    gvu.setNguoidung(user);
                    gvu.setGiaovuPK(gvuPK);
                    addUserGVU(gvu);
                    break;
                case "ROLE_GV":
                    Giangvien gv = new Giangvien();
                    GiangvienPK gvPK = new GiangvienPK();
                    gvPK.setMaGV(user.getUsername());
                    gvPK.setMaND(user.getUsername());
                    gvPK.setMaCV("ROLE_GV");
                    gv.setHocVi(user.getHocVi());
                    gv.setHocVi(user.getHocHam());
                    gv.setNguoidung(user);
                    gv.setGiangvienPK(gvPK);
                    addUserGV(gv);
                    break;
                case "ROLE_SV":
                    Sinhvien sv = new Sinhvien();
                    SinhvienPK svPK = new SinhvienPK();
                    Nganh nganh = new Nganh();
                    NganhPK nganhPK = new NganhPK();
                    svPK.setMaND(user.getUsername());
                    svPK.setMaSV(user.getUsername());
                    svPK.setMaCV("ROLE_SV");
                    svPK.setMaKhoa(user.getKhoaDK());
                    svPK.setMaNganh(user.getNganhDK());
                    nganhPK.setMaNganh(user.getNganhDK());
                    nganhPK.setMaKhoa(user.getKhoaDK());
                    nganh.setNganhPK(nganhPK);
                    sv.setNienKhoa(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    sv.setTinhTrang(Short.parseShort("1"));
                    sv.setNganh(nganh);
                    sv.setNguoidung(user);
                    sv.setSinhvienPK(svPK);
                    addUserSV(sv);
                    break;
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //  Thêm mới tài khoản quản trị
    @Override
    public boolean addUserQT(Quantri userQT) {
        return this.userRepo.addUserQT(userQT);
    }

    //  Thêm mới tài khoản giáo vụ
    @Override
    public boolean addUserGVU(Giaovu userGVU) {
        return this.userRepo.addUserGVU(userGVU);
    }

    //  Thêm mới tài khoản sinh viên
    @Override
    public boolean addUserSV(Sinhvien userSV) {
        return this.userRepo.addUserSV(userSV);
    }

    //  Thêm mới tài khoản giảng viên
    @Override
    public boolean addUserGV(Giangvien userGV) {
        return this.userRepo.addUserGV(userGV);
    }

    //CẬP NHẬT NGƯỜI DÙNG
    //  Cập nhật tài khoản người dùng
    @Override
    public void updateUsers(String userID, Nguoidung user) {
        Nguoidung u = this.userRepo.getUserbyID(userID);
        Map m;
        if (!user.getHo().isEmpty()) {
            u.setHo(user.getHo());
        }
        if (!user.getTen().isEmpty()) {
            u.setTen(user.getTen());
        }
        if (!user.getNgaySinh().toString().isEmpty()) {
            u.setNgaySinh(user.getNgaySinh());
        }
        if (!user.getUsername().isEmpty()) {
            u.setUsername(user.getUsername());
        }
        if (!user.getGioiTinh().isEmpty()) {
            u.setGioiTinh(user.getGioiTinh());
        }
        if (!user.getHoatDong().equals(u.getHoatDong())) {
            u.setHoatDong(Short.parseShort(user.getHoatDong().toString()));
        }
        try {
            m = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            u.setAnh((String) m.get("secure_url"));
        } catch (IOException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.userRepo.updateUsers(u);
    }

    //  Cập nhật tài khoản người dùng hiện tại
    @Override
    public void updateParticularUsers(Nguoidung user) {
        Nguoidung u = this.userRepo.getUserbyID(user.getNguoidungPK().getMaND());
        Map m;
        u.setNguoidungPK(user.getNguoidungPK());
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

    //  Cập nhật tài khoản sinh viên
    @Override
    public void updateUsersSV(Sinhvien user) {
        this.userRepo.updateUsersSV(user);
    }

    //  Cập nhật tài khoản giảng viên
    @Override
    public void updateUsersGV(Giangvien user) {
        this.userRepo.updateUsersGV(user);
    }

    //  Cập nhật tài khoản giáo vụ
    @Override
    public void updateUsersGVU(Giaovu user) {
        this.userRepo.updateUsersGVU(user);
    }

    //XÓA NGƯỜI DÙNG
    //  Xóa tài khoản người dùng
    @Override
    public void deleteUsers(String userID) {
        this.userRepo.deleteUsers(userID);
    }

    //  Xóa tài khoản quản trị
    @Override
    public void deleteUsersQT(String userID) {
        this.userRepo.deleteUsersQT(userID);
        this.userRepo.deleteUsers(userID);
    }

    //  Xóa tài khoản giáo vụ
    @Override
    public void deleteUsersGVU(String userID) {
        this.userRepo.deleteUsersGVU(userID);
        this.userRepo.deleteUsers(userID);
    }

    //  Xóa tài khoản giảng viên
    @Override
    public void deleteUsersGV(String userID) {
        this.userRepo.deleteUsersGV(userID);
        this.userRepo.deleteUsers(userID);
    }

    //  Xóa tài khoản sinh viên
    @Override
    public void deleteUsersSV(String userID) {
        this.userRepo.deleteUsersSV(userID);
        this.userRepo.deleteUsers(userID);
    }
}
