/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Chucvu;
import com.demo.pojo.Khoa;
import com.demo.pojo.Nganh;
import java.util.List;

/**
 *
 * @author ADMIN
 */

public interface RoleRepo {
    List<Chucvu> getChucvu();
    List<Nganh> getNganh();
    List<Khoa> getKhoa();
}
