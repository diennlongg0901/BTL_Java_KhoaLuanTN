/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.service.impl;

import com.demo.pojo.Dangkykhoaluan;
import com.demo.pojo.Detai;
import com.demo.pojo.Khoaluan;
import com.demo.repository.ThesisRepo;
import com.demo.service.ThesisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ThesisServiceImpl implements ThesisService {
    
    @Autowired
    private ThesisRepo thesisRepo;

    //ĐỀ TÀI KHÓA LUẬN
    @Override
    public boolean addTopic(Detai topic) {
        return this.thesisRepo.addTopic(topic);
    }

    @Override
    public List<Detai> getTopics() {
        return this.thesisRepo.getTopics();
    }

    @Override
    public boolean deleteTopic(int topicID) {
        return this.thesisRepo.deleteTopic(topicID);
    }

    //KHÓA LUẬN
    @Override
    public boolean addThesis(Khoaluan thesis) {        
        return this.thesisRepo.addThesis(thesis);
    }
    
    @Override
    public boolean addRegistration(Dangkykhoaluan dangkykhoaluan) {        
        return this.thesisRepo.addRegistration(dangkykhoaluan);
    }

    @Override
    public List<Khoaluan> getThesis() {
        return this.thesisRepo.getThesis();
    }

    @Override
    public List<Dangkykhoaluan> getRegistedThesises() {
       return this.thesisRepo.getRegistedThesises();
    }

    @Override
    public Dangkykhoaluan getRegistedThesisByID(int id) {
        return this.thesisRepo.getRegistedThesisByID(id);
    }

    @Override
    public Khoaluan getThesisbyID(int id) {
        return this.thesisRepo.getThesisbyID(id);
    }

    @Override
    public List<Khoaluan> getThesisByGV(String idGV) {
        return this.thesisRepo.getThesisByGV(idGV);
    }
    
    @Override
    public boolean updateThesis(Khoaluan khoaluan) {       
        return this.thesisRepo.updateThesis(khoaluan);
    }


    @Override
    public Khoaluan getThesisBySV(String idSV) {
        return this.thesisRepo.getThesisBySV(idSV);
    }

    @Override
    public List<Khoaluan> getThesisByIDCouncil(int i) {
       return this.thesisRepo.getThesisByIDCouncil(i);
    }

    
}
