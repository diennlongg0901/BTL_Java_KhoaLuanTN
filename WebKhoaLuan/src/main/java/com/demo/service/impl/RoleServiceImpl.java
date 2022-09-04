/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Chucvu;
import com.demo.pojo.Khoa;
import com.demo.pojo.Nganh;
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
    
    //  Lấy danh sách chức vụ
    @Override
    public List<Chucvu> getChucvu() {
        return this.roleRepo.getChucvu();
    }

    //  Lấy danh sách ngành
    @Override
    public List<Nganh> getNganh() {
        return this.roleRepo.getNganh();
    }

    //  Lấy danh sách khoa
    @Override
    public List<Khoa> getKhoa() {
        return this.roleRepo.getKhoa();
    }
}
