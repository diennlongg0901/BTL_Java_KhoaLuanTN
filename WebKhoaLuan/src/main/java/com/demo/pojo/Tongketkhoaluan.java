/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author PC
 */
@Entity
@Table(name = "tongketkhoaluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tongketkhoaluan.findAll", query = "SELECT t FROM Tongketkhoaluan t"),
    @NamedQuery(name = "Tongketkhoaluan.findByMaKQ", query = "SELECT t FROM Tongketkhoaluan t WHERE t.maKQ = :maKQ"),
    @NamedQuery(name = "Tongketkhoaluan.findByMaSV", query = "SELECT t FROM Tongketkhoaluan t WHERE t.maSV = :maSV"),
    @NamedQuery(name = "Tongketkhoaluan.findByMaKL", query = "SELECT t FROM Tongketkhoaluan t WHERE t.maKL = :maKL"),
    @NamedQuery(name = "Tongketkhoaluan.findByKetQua", query = "SELECT t FROM Tongketkhoaluan t WHERE t.ketQua = :ketQua"),
    @NamedQuery(name = "Tongketkhoaluan.findByDiem", query = "SELECT t FROM Tongketkhoaluan t WHERE t.diem = :diem"),
    @NamedQuery(name = "Tongketkhoaluan.findByNam", query = "SELECT t FROM Tongketkhoaluan t WHERE t.nam = :nam"),
    @NamedQuery(name = "Tongketkhoaluan.findByMaKhoa", query = "SELECT t FROM Tongketkhoaluan t WHERE t.maKhoa = :maKhoa")})
public class Tongketkhoaluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maKQ")
    private Integer maKQ;
    @Size(max = 10)
    @Column(name = "maSV")
    private String maSV;
    @Column(name = "maKL")
    private Integer maKL;
    @Size(max = 100)
    @Column(name = "ketQua")
    private String ketQua;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diem")
    private BigDecimal diem;
    @Size(max = 15)
    @Column(name = "nam")
    private String nam;
    @Size(max = 10)
    @Column(name = "maKhoa")
    private String maKhoa;

    public Tongketkhoaluan() {
    }

    public Tongketkhoaluan(Integer maKQ) {
        this.maKQ = maKQ;
    }

    public Integer getMaKQ() {
        return maKQ;
    }

    public void setMaKQ(Integer maKQ) {
        this.maKQ = maKQ;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public Integer getMaKL() {
        return maKL;
    }

    public void setMaKL(Integer maKL) {
        this.maKL = maKL;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKQ != null ? maKQ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tongketkhoaluan)) {
            return false;
        }
        Tongketkhoaluan other = (Tongketkhoaluan) object;
        if ((this.maKQ == null && other.maKQ != null) || (this.maKQ != null && !this.maKQ.equals(other.maKQ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Tongketkhoaluan[ maKQ=" + maKQ + " ]";
    }
    
}
