/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "dangkykhoaluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dangkykhoaluan.findAll", query = "SELECT d FROM Dangkykhoaluan d"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaDK", query = "SELECT d FROM Dangkykhoaluan d WHERE d.dangkykhoaluanPK.maDK = :maDK"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaDT", query = "SELECT d FROM Dangkykhoaluan d WHERE d.dangkykhoaluanPK.maDT = :maDT"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaSV2", query = "SELECT d FROM Dangkykhoaluan d WHERE d.maSV2 = :maSV2"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaSV", query = "SELECT d FROM Dangkykhoaluan d WHERE d.dangkykhoaluanPK.maSV = :maSV"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaND", query = "SELECT d FROM Dangkykhoaluan d WHERE d.dangkykhoaluanPK.maND = :maND"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaCV", query = "SELECT d FROM Dangkykhoaluan d WHERE d.dangkykhoaluanPK.maCV = :maCV"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaNganh", query = "SELECT d FROM Dangkykhoaluan d WHERE d.dangkykhoaluanPK.maNganh = :maNganh"),
    @NamedQuery(name = "Dangkykhoaluan.findByMaKhoa", query = "SELECT d FROM Dangkykhoaluan d WHERE d.dangkykhoaluanPK.maKhoa = :maKhoa")})
public class Dangkykhoaluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DangkykhoaluanPK dangkykhoaluanPK;
    @Size(max = 10)
    @Column(name = "maSV2")
    private String maSV2;
    @JoinColumn(name = "maDT", referencedColumnName = "maDT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Detai detai;
    @JoinColumns({
        @JoinColumn(name = "maSV", referencedColumnName = "maSV", insertable = false, updatable = false),
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maCV", referencedColumnName = "maCV", insertable = false, updatable = false),
        @JoinColumn(name = "maNganh", referencedColumnName = "maNganh", insertable = false, updatable = false),
        @JoinColumn(name = "maKhoa", referencedColumnName = "maKhoa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Sinhvien sinhvien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dangkykhoaluan")
    private Set<Khoaluan> khoaluanSet;
    @Transient
    private int maDT;

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public Dangkykhoaluan() {
    }

    public Dangkykhoaluan(DangkykhoaluanPK dangkykhoaluanPK) {
        this.dangkykhoaluanPK = dangkykhoaluanPK;
    }

    public Dangkykhoaluan(int maDK, int maDT, String maSV, String maND, String maCV, String maNganh, String maKhoa) {
        this.dangkykhoaluanPK = new DangkykhoaluanPK(maDK, maDT, maSV, maND, maCV, maNganh, maKhoa);
    }

    public DangkykhoaluanPK getDangkykhoaluanPK() {
        return dangkykhoaluanPK;
    }

    public void setDangkykhoaluanPK(DangkykhoaluanPK dangkykhoaluanPK) {
        this.dangkykhoaluanPK = dangkykhoaluanPK;
    }

    public String getMaSV2() {
        return maSV2;
    }

    public void setMaSV2(String maSV2) {
        this.maSV2 = maSV2;
    }

    public Detai getDetai() {
        return detai;
    }

    public void setDetai(Detai detai) {
        this.detai = detai;
    }

    public Sinhvien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(Sinhvien sinhvien) {
        this.sinhvien = sinhvien;
    }

    @XmlTransient
    public Set<Khoaluan> getKhoaluanSet() {
        return khoaluanSet;
    }

    public void setKhoaluanSet(Set<Khoaluan> khoaluanSet) {
        this.khoaluanSet = khoaluanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dangkykhoaluanPK != null ? dangkykhoaluanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dangkykhoaluan)) {
            return false;
        }
        Dangkykhoaluan other = (Dangkykhoaluan) object;
        if ((this.dangkykhoaluanPK == null && other.dangkykhoaluanPK != null) || (this.dangkykhoaluanPK != null && !this.dangkykhoaluanPK.equals(other.dangkykhoaluanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Dangkykhoaluan[ dangkykhoaluanPK=" + dangkykhoaluanPK + " ]";
    }
    
}
