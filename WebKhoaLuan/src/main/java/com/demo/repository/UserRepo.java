/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.repository;

import com.demo.pojo.Quantri;
import java.util.List;

/**
 *
 * @author PC
 */
public interface UserRepo {
    boolean addUser (Quantri userQuantri);
    List<Quantri> getUsersQT(String username);
}
