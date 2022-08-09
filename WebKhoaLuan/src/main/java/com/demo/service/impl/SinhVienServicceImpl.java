/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Sinhvien;
import com.demo.repository.SinhVienRepo;
import com.demo.service.SinhVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class SinhVienServicceImpl implements SinhVienService{
    @Autowired
    private SinhVienRepo sinhVienRepo;
    
    @Override
    public List<Sinhvien> getSinhvien(String kw){
        return this.sinhVienRepo.getSinhvien(kw);
    }
}
