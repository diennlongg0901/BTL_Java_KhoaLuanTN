/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Giangvien;
import com.demo.pojo.Giaovu;
import com.demo.pojo.Nguoidung;
import com.demo.pojo.Quantri;
import com.demo.pojo.Sinhvien;
import java.util.List;

/**
 *
 * @author PC
 */
public interface UserRepo {

    //THÊM NGƯỜI DÙNG
    boolean addUser(Nguoidung user);
    boolean addUserQT(Quantri userQT);
    boolean addUserGVU(Giaovu userGVU);
    boolean addUserGV(Giangvien userGV);
    boolean addUserSV(Sinhvien userSV);

    //LẤY NGƯỜI DÙNG
    List<Nguoidung> getUsers(String username);
    Nguoidung getUserbyID(String id);
    List<Nguoidung> getAllUsers();
    List<Nguoidung> getAllGV();
    List<Giangvien> getListGV();
    List<Nguoidung> getAllSV();
    List<Nguoidung> getAllGVU();
    List<Nguoidung> getAllQT();
    Giangvien getGVbyID(String id);
    Sinhvien getSVbyID(String id);

    //XÓA NGƯỜI DÙNG 
    void deleteUsers(String userID);
    void deleteUsersQT(String userID);
    void deleteUsersGVU(String userID);
    void deleteUsersGV(String userID);
    void deleteUsersSV(String userID);
    
    //CẬP NHẬT NGƯỜI DÙNG
    void updateUsers(Nguoidung user);
    void updateParticularUsers(Nguoidung user);
    void updateUsersSV (Sinhvien user);
    void updateUsersGV (Giangvien user);
    void updateUsersGVU (Giaovu user);
}
