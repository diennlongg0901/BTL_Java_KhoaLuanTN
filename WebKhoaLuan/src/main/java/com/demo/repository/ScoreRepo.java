/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Diem;
import com.demo.pojo.Khoaluan;
import com.demo.pojo.Tieuchi;
import com.demo.pojo.Tongketkhoaluan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ScoreRepo {
    
    //TIÊU CHÍ
    Tieuchi getCriteria(int id);
    List<Diem> getScore(int thesisID, int criteriaID);
    List<Diem> getThesisScores(int thesisID);
    
    //ĐIỂM
    boolean addScore(Diem score);
    double calculation(double scoreHD, double scoreGVHD);
    boolean addResult(Tongketkhoaluan result);
    
    //THỐNG KÊ ĐIỂM VÀ SINH VIÊN
    List<Object> scoreStats(String kw);
    List<Object> svStats(String kw);
}
