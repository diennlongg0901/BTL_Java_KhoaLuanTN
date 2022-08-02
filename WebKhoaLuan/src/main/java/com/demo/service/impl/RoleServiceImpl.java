/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Chucvu;
import com.demo.repository.RoleRepo;
import com.demo.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepo roleRepo;
    
    @Override
    public List<Chucvu> getChucvu() {
        return this.roleRepo.getChucvu();
    }
}
