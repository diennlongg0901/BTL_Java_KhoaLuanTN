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
    //  Thêm đề tài
    @Override
    public boolean addTopic(Detai topic) {
        return this.thesisRepo.addTopic(topic);
    }

    //  Lấy danh sách đề tài
    @Override
    public List<Detai> getTopics() {
        return this.thesisRepo.getTopics();
    }

    //  Xóa đề tài
    @Override
    public boolean deleteTopic(int topicID) {
        return this.thesisRepo.deleteTopic(topicID);
    }

    //KHÓA LUẬN
    //  Thêm khóa luận
    @Override
    public boolean addThesis(Khoaluan thesis) {        
        return this.thesisRepo.addThesis(thesis);
    }
    
    //  Thêm đăng ký khóa luận
    @Override
    public boolean addRegistration(Dangkykhoaluan dangkykhoaluan) {        
        return this.thesisRepo.addRegistration(dangkykhoaluan);
    }

    //  Lấy danh sách khóa luận
    @Override
    public List<Khoaluan> getThesis() {
        return this.thesisRepo.getThesis();
    }

    //  Lấy danh sách đăng ký khóa luận
    @Override
    public List<Dangkykhoaluan> getRegistedThesises() {
       return this.thesisRepo.getRegistedThesises();
    }

    //  Lấy danh sách đăng ký khóa luận theo mã đăng ký
    @Override
    public Dangkykhoaluan getRegistedThesisByID(int id) {
        return this.thesisRepo.getRegistedThesisByID(id);
    }

    //  Lấy danh sách khóa luận theo mã khóa luận
    @Override
    public Khoaluan getThesisbyID(int id) {
        return this.thesisRepo.getThesisbyID(id);
    }

    //  Lấy danh sách khóa luận theo mã giảng viên
    @Override
    public List<Khoaluan> getThesisByGV(String idGV) {
        return this.thesisRepo.getThesisByGV(idGV);
    }
   
    //  Lấy danh sách khóa luận theo mã sinh viên
    @Override
    public Khoaluan getThesisBySV(String idSV) {
        return this.thesisRepo.getThesisBySV(idSV);
    }

    //  Lấy danh sách khóa luận theo mã hội đồng
    @Override
    public List<Khoaluan> getThesisByIDCouncil(int i) {
       return this.thesisRepo.getThesisByIDCouncil(i);
    }
    
    //  Cập nhậ thông tin khóa luận
    @Override
    public boolean updateThesis(Khoaluan khoaluan) {       
        return this.thesisRepo.updateThesis(khoaluan);
    }

    //  Xóa đăng ký khóa luận theo mã đề tài
    @Override
    public void deleteRegistedThesis(int i) {
        this.thesisRepo.deleteRegistedThesis(i);
    }
}
