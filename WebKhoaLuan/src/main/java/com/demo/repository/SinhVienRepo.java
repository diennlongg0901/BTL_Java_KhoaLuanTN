/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Sinhvien;
import java.util.List;

/**
 *
 * @author PC
 */
public interface SinhVienRepo {
    List<Sinhvien> getSinhvien(String kw);
}
