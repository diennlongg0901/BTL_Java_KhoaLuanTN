/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Diem;
import com.demo.pojo.Tieuchi;
import com.demo.repository.CouncilRepo;
import com.demo.repository.ScoreRepo;
import com.demo.service.ScoreService;
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
    public double calculation(double gvhd, double hd) {
       double total = ((gvhd * 0.4) + (hd * 0.6));
       return total;
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

    @Override
    public String resultThesis(double score) {
        String result = "";
        if (score <= 10 && score >= 8.5) {
            result = "A";
            return result;
        }
        if (score < 8.5 && score >= 8) {
            result = "B+";
            return result;
        }
        if (score < 8 && score >= 7) {
            result = "B";
            return result;
        }
        if (score < 7 && score >= 6.5) {
            result = "C+";
            return result;
        }
        if (score < 6.5 && score >= 5.5) {
            result = "C";
            return result;
        }
        if (score < 5.5 && score >= 5) {
            result = "D+";
            return result;
        }
        if (score < 5 &&score >= 4) {
            result = "D";
            return result;
        }
        result = "F";
        return result;
    }

    @Override
    public List<Diem> getThesisScores(int thesisID) {
        return this.scoreRepo.getThesisScores(thesisID);
    }
}