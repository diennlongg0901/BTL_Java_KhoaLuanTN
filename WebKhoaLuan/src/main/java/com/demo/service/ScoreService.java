/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.service;

import com.demo.pojo.Diem;
import com.demo.pojo.Khoaluan;
import com.demo.pojo.Tieuchi;
import com.demo.pojo.Tongketkhoaluan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ScoreService {
    
    //TIÊU CHÍ
    Tieuchi getCriteria(int id);

    //ĐIỂM
    boolean addScore(Diem score);
    double calculateCouncilScore(int thesisID);
    double calculateGVHDScore(int thesisID);
    double calculation(double scoreHD, double scoreGVHD);
    String resultThesis(double score);
    public boolean addResult(Khoaluan thesis, String result, double score);
    List<Diem> getAllScore(int id);
    List<Diem> getScore(int thesisID, int criteriaID);
    List<Diem> getThesisScores(int thesisID);
    boolean getResult(String id);
    Tongketkhoaluan getResultScore(String id);
    
    //THỐNG KÊ
    List<Object> scoreStats(String kw);
    List<Object> svStats(String id);
}
