/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Diem;
import com.demo.pojo.DiemPK;
import com.demo.pojo.Tieuchi;
import com.demo.repository.CouncilRepo;
import com.demo.repository.ScoreRepo;
import com.demo.service.ScoreService;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepo scoreRepo;
    @Autowired
    private CouncilRepo councilRepo;

    @Override
    public Tieuchi getCriteria(int id) {
        return this.scoreRepo.getCriteria(id);
    }

    @Override
    public boolean addScore(Diem score) {
        return this.scoreRepo.addScore(score);
    }

    @Override
    public double calculateCouncilScore(int thesisID) {
        List<Diem> councilScore = this.scoreRepo.getScore(thesisID, 1);
        int numMember = this.councilRepo.countMember(councilScore.get(0).getKhoaluan().getHoidong().getMaHD());
        double total = 0;
        for (int i = 0; i < councilScore.size(); i++) {
            total = total + Double.parseDouble(councilScore.get(i).getDiem().toString());
        }
        total = total / numMember;
        return total;
    }

    @Override
    public double calculation(double d, double d1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calculateGVHDScore(int thesisID) {
        List<Diem> councilScore = this.scoreRepo.getScore(thesisID, 2);
        double total = 0;
        if (councilScore.size() == 2) {
            for (int i = 0; i < councilScore.size(); i++) {
                total = total + Double.parseDouble(councilScore.get(i).getDiem().toString());
            }
            total = total / 2;
        } else {
            total = total + Double.parseDouble(councilScore.get(0).getDiem().toString());
        }
        return total;
    }

    @Override
    public List<Diem> getScore(int thesisID, int criteriaID) {
        return this.scoreRepo.getScore(thesisID, thesisID);
    }
}
