/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Nguoidung;
import com.demo.pojo.Sinhvien;
import com.demo.repository.UserRepo;
import com.demo.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    
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
        return this.userRepo.addUser(user);
    }

    @Override
    public List<Nguoidung> getAllUsers() {
        return this.userRepo.getAllUsers();
    }  
}
