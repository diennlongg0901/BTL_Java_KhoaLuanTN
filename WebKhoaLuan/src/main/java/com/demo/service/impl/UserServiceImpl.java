/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Quantri;
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
    public List<Quantri> getUsersQT(String username) {
        return this.userRepo.getUsersQT(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Quantri> quantri = this.getUsersQT(username);
        if (quantri.isEmpty())
        {
            throw new UsernameNotFoundException("Tài khoản người dùng quản trị không có!");
        }
        Quantri qt = quantri.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(qt.getChucVu()));
        return new org.springframework.security.core.userdetails.User(qt.getUsernamQT(), qt.getPasswordQT(), auth);
    }

    @Override
    public boolean addUser(Quantri userQuantri) {
        return this.userRepo.addUser(userQuantri);
    }
}
