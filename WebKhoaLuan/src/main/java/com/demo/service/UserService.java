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
    boolean addUser (Nguoidung user);
    boolean addUserQT (Quantri userQT);
    boolean addUserSV (Sinhvien userSV);
    boolean addUserGV (Giangvien userGV);
    boolean addUserGVU (Giaovu userGVU);
    List<Nguoidung> getUsers(String username);
    List<Nguoidung> getAllUsers();

}
