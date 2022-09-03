/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "khoaluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khoaluan.findAll", query = "SELECT k FROM Khoaluan k"),
    @NamedQuery(name = "Khoaluan.findByMaKL", query = "SELECT k FROM Khoaluan k WHERE k.maKL = :maKL"),
    @NamedQuery(name = "Khoaluan.findByNam", query = "SELECT k FROM Khoaluan k WHERE k.nam = :nam"),
    @NamedQuery(name = "Khoaluan.findByGhiChu", query = "SELECT k FROM Khoaluan k WHERE k.ghiChu = :ghiChu"),
    @NamedQuery(name = "Khoaluan.findByNgayNop", query = "SELECT k FROM Khoaluan k WHERE k.ngayNop = :ngayNop"),
    @NamedQuery(name = "Khoaluan.findByMaSV2", query = "SELECT k FROM Khoaluan k WHERE k.maSV2 = :maSV2"),
    @NamedQuery(name = "Khoaluan.findByMaGV", query = "SELECT k FROM Khoaluan k WHERE k.maGV = :maGV"),
    @NamedQuery(name = "Khoaluan.findByMaGV2", query = "SELECT k FROM Khoaluan k WHERE k.maGV2 = :maGV2"),
    @NamedQuery(name = "Khoaluan.findByFile", query = "SELECT k FROM Khoaluan k WHERE k.file = :file")})
public class Khoaluan implements Serializable {

   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maKL")
    private Integer maKL;
    @Size(max = 15)
    @Column(name = "nam")
    private String nam;
    @Size(max = 100)
    @Column(name = "ghiChu")
    private String ghiChu;
    @Column(name = "ngayNop")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayNop;
    @Size(max = 10)
    @Column(name = "maSV2")
    private String maSV2;
    @Size(max = 10)
    @Column(name = "maGV")
    private String maGV;
    @Size(max = 10)
    @Column(name = "maGV2")
    private String maGV2;
    @Size(max = 100)
    @Column(name = "file")
    private String file;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaluan")
    private Set<Diem> diemSet;
    @JoinColumns({
        @JoinColumn(name = "maDK", referencedColumnName = "maDK"),
        @JoinColumn(name = "maDT", referencedColumnName = "maDT"),
        @JoinColumn(name = "maSV", referencedColumnName = "maSV"),
        @JoinColumn(name = "maND", referencedColumnName = "maND"),
        @JoinColumn(name = "maCV", referencedColumnName = "maCV"),
        @JoinColumn(name = "maNganh", referencedColumnName = "maNganh"),
        @JoinColumn(name = "maKhoa", referencedColumnName = "maKhoa")})
    @ManyToOne(optional = false)
    private Dangkykhoaluan dangkykhoaluan;
    @JoinColumns({
        @JoinColumn(name = "maHD", referencedColumnName = "maHD")})
    @ManyToOne(optional = false)
    private Hoidong hoidong;
    @Transient
    private int maDT;

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }


    public Khoaluan() {
    }

    public Khoaluan(Integer maKL) {
        this.maKL = maKL;
    }

    public Integer getMaKL() {
        return maKL;
    }

    public void setMaKL(Integer maKL) {
        this.maKL = maKL;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }

    public String getMaSV2() {
        return maSV2;
    }

    public void setMaSV2(String maSV2) {
        this.maSV2 = maSV2;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaGV2() {
        return maGV2;
    }

    public void setMaGV2(String maGV2) {
        this.maGV2 = maGV2;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @XmlTransient
    public Set<Diem> getDiemSet() {
        return diemSet;
    }

    public void setDiemSet(Set<Diem> diemSet) {
        this.diemSet = diemSet;
    }

    public Dangkykhoaluan getDangkykhoaluan() {
        return dangkykhoaluan;
    }

    public void setDangkykhoaluan(Dangkykhoaluan dangkykhoaluan) {
        this.dangkykhoaluan = dangkykhoaluan;
    }

    public Hoidong getHoidong() {
        return hoidong;
    }

    public void setHoidong(Hoidong hoidong) {
        this.hoidong = hoidong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKL != null ? maKL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoaluan)) {
            return false;
        }
        Khoaluan other = (Khoaluan) object;
        if ((this.maKL == null && other.maKL != null) || (this.maKL != null && !this.maKL.equals(other.maKL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Khoaluan[ maKL=" + maKL + " ]";
    }

 
    
}
