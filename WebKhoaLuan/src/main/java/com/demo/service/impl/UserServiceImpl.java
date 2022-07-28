/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Giaovu;
import com.demo.repository.UserRepo;
import com.demo.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
//@Service("userDetailsService")
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    @Transactional
//    public void addUser(User user) {
//        user.(
//                bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.addUser(user);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public User getUserByUsername(String username) {
//        return userRepository.getUsers(username).get(0);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        List<User> users = userRepository.getUsers(username);
//        if (users.isEmpty()) {
//            throw new UsernameNotFoundException("Không tồn tại!");
//        }
//        User u = users.get(0);
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
//        return new org.springframework.security.core.userdetails.User(
//                u.getUsername(), u.getPassword(), authorities);
//
//    }
