/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Diem;
import com.demo.pojo.Tieuchi;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ScoreRepo {
    
    //TIÊU CHÍ
    Tieuchi getCriteria(int id);
    List<Diem> getScore(int thesisID, int criteriaID);
    
    //ĐIỂM
    boolean addScore(Diem score);
    double calculation(double scoreHD, double scoreGVHD);
}
