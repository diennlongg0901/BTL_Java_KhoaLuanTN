/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "hoidong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoidong.findAll", query = "SELECT h FROM Hoidong h"),
    @NamedQuery(name = "Hoidong.findByMaHD", query = "SELECT h FROM Hoidong h WHERE h.maHD = :maHD"),
    @NamedQuery(name = "Hoidong.findByTenHD", query = "SELECT h FROM Hoidong h WHERE h.tenHD = :tenHD"),
    @NamedQuery(name = "Hoidong.findByTinhTrangHD", query = "SELECT h FROM Hoidong h WHERE h.tinhTrangHD = :tinhTrangHD"),
    @NamedQuery(name = "Hoidong.findByHoatDong", query = "SELECT h FROM Hoidong h WHERE h.hoatDong = :hoatDong")})
public class Hoidong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maHD")
    private Integer maHD;
    @Size(max = 150)
    @Column(name = "tenHD")
    private String tenHD;
    @Size(max = 45)
    @Column(name = "tinhTrangHD")
    private String tinhTrangHD;
    @Column(name = "hoatDong")
    private Short hoatDong;

    public Hoidong() {
    }

    public Hoidong(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public String getTenHD() {
        return tenHD;
    }

    public void setTenHD(String tenHD) {
        this.tenHD = tenHD;
    }

    public String getTinhTrangHD() {
        return tinhTrangHD;
    }

    public void setTinhTrangHD(String tinhTrangHD) {
        this.tinhTrangHD = tinhTrangHD;
    }

    public Short getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(Short hoatDong) {
        this.hoatDong = hoatDong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHD != null ? maHD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoidong)) {
            return false;
        }
        Hoidong other = (Hoidong) object;
        if ((this.maHD == null && other.maHD != null) || (this.maHD != null && !this.maHD.equals(other.maHD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Hoidong[ maHD=" + maHD + " ]";
    }
    
}
