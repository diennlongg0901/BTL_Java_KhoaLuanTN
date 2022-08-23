/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.service;

import com.demo.pojo.Giangvien;
import com.demo.pojo.Giaovu;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author PC
 */
public interface UserService extends UserDetailsService {
    
    //THÊM NGƯỜI DÙNG
    boolean addUser (Nguoidung user);
    boolean addUserQT (Quantri userQT);
    boolean addUserGVU (Giaovu userGVU);
    boolean addUserGV (Giangvien userGV);
    boolean addUserSV (Sinhvien userSV);
    
    //LẤY NGƯỜI DÙNG   
    List<Nguoidung> getUsers(String username);
    Nguoidung getUserbyID(String username);
    List<Nguoidung> getAllUsers();
    List<Nguoidung> getAllGV();
    List<Giangvien> getListGV();
    List<Nguoidung> getAllSV();
    List<Nguoidung> getAllGVU();
    List<Nguoidung> getAllQT();
    
    //XÓA NGƯỜI DÙNG   
    void deleteUsers(String userID);
    void deleteUsersQT(String userID);
    void deleteUsersGVU(String userID);
    void deleteUsersGV(String userID);
    void deleteUsersSV(String userID);
       
    //CẬP NHẬT NGƯỜI DÙNG
    void updateUsers(String userID, Nguoidung user);
    void updateParticularUsers(Nguoidung user);
}
