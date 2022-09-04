/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.service;

import com.demo.pojo.Dangkykhoaluan;
import com.demo.pojo.Detai;
import com.demo.pojo.Khoaluan;
import java.util.List;

/**
 *
 * @author ADMIN
 */

public interface ThesisService {
    
    //ĐỀ TÀI KHÓA LUẬN
    boolean addTopic(Detai topic);
    List<Detai> getTopics();
    boolean deleteTopic(int topicID);

    //ĐĂNG KÝ KHÓA LUẬN
    boolean addRegistration(Dangkykhoaluan dangkykhoaluan);
    List<Dangkykhoaluan> getRegistedThesises();
    Dangkykhoaluan getRegistedThesisByID(int id);
    void deleteRegistedThesis(int idTopic);
    
    //KHÓA LUẬN
    boolean addThesis(Khoaluan thesis);   
    boolean updateThesis(Khoaluan thesis);
    List<Khoaluan> getThesis();
    List<Khoaluan> getThesisByGV(String idGV);
    List<Khoaluan>getThesisByIDCouncil(int id);
    Khoaluan getThesisBySV(String id);
    Khoaluan getThesisbyID(int id);
}
