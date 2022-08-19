/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Chitiethoidong;
import com.demo.pojo.Hoidong;


/**
 *
 * @author ADMIN
 */
public interface CouncilRepo {
    boolean addCouncil(Hoidong council);
    Object getNewCouncil();
    boolean addDetailCouncil (Chitiethoidong detailCouncil);
}
