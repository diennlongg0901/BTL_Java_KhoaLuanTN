/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Dangkykhoaluan;
import com.demo.pojo.Detai;
import com.demo.pojo.Khoaluan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ThesisRepo {
    
    //ĐỀ TÀI KHÓA LUẬN
    boolean addTopic(Detai topic);
    List<Detai> getTopics();
    boolean deleteTopic(int topicID);
    //Đăng ký khóa luận
    boolean addDK_thesis(Dangkykhoaluan dangkykhoaluan);
    List<Dangkykhoaluan> getDangkykhoaluans();
    //KHÓA LUẬN
    boolean addThesis(Khoaluan thesis);
    List<Khoaluan> getThesis();
}
