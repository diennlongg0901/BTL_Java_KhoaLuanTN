/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Khoaluan.findByMaKL", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maKL = :maKL"),
    @NamedQuery(name = "Khoaluan.findByNam", query = "SELECT k FROM Khoaluan k WHERE k.nam = :nam"),
    @NamedQuery(name = "Khoaluan.findByGhiChu", query = "SELECT k FROM Khoaluan k WHERE k.ghiChu = :ghiChu"),
    @NamedQuery(name = "Khoaluan.findByNgayNop", query = "SELECT k FROM Khoaluan k WHERE k.ngayNop = :ngayNop"),
    @NamedQuery(name = "Khoaluan.findByMaDT", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maDT = :maDT"),
    @NamedQuery(name = "Khoaluan.findBySinhvienmaSV", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.sinhvienmaSV = :sinhvienmaSV"),
    @NamedQuery(name = "Khoaluan.findByMaND", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maND = :maND"),
    @NamedQuery(name = "Khoaluan.findByMaCV", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maCV = :maCV"),
    @NamedQuery(name = "Khoaluan.findByMaNganh", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maNganh = :maNganh"),
    @NamedQuery(name = "Khoaluan.findBySinhvienmaKhoa", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.sinhvienmaKhoa = :sinhvienmaKhoa")})
public class Khoaluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KhoaluanPK khoaluanPK;
    @Size(max = 15)
    @Column(name = "nam")
    private String nam;
    @Size(max = 100)
    @Column(name = "ghiChu")
    private String ghiChu;
    @Column(name = "ngayNop")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayNop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaluan")
    private Set<Diem> diemSet;
    @JoinColumn(name = "maDT", referencedColumnName = "maDT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Detai detai;
    @JoinColumns({
        @JoinColumn(name = "sinhvien_maSV", referencedColumnName = "maSV", insertable = false, updatable = false),       
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maCV", referencedColumnName = "maCV", insertable = false, updatable = false),
        @JoinColumn(name = "maNganh", referencedColumnName = "maNganh", insertable = false, updatable = false), 
        @JoinColumn(name = "sinhvien_maKhoa", referencedColumnName = "maKhoa", insertable = false, updatable = false)
        })
    @ManyToOne(optional = false)
    private Sinhvien sinhvien;

    public Khoaluan() {
    }

    public Khoaluan(KhoaluanPK khoaluanPK) {
        this.khoaluanPK = khoaluanPK;
    }

    public Khoaluan(int maKL, int maDT, String sinhvienmaSV, String maND, String maCV, String maNganh, String sinhvienmaKhoa) {
        this.khoaluanPK = new KhoaluanPK(maKL, maDT, sinhvienmaSV, maND, maCV, maNganh, sinhvienmaKhoa);
    }

    public KhoaluanPK getKhoaluanPK() {
        return khoaluanPK;
    }

    public void setKhoaluanPK(KhoaluanPK khoaluanPK) {
        this.khoaluanPK = khoaluanPK;
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

    @XmlTransient
    public Set<Diem> getDiemSet() {
        return diemSet;
    }

    public void setDiemSet(Set<Diem> diemSet) {
        this.diemSet = diemSet;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (khoaluanPK != null ? khoaluanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoaluan)) {
            return false;
        }
        Khoaluan other = (Khoaluan) object;
        if ((this.khoaluanPK == null && other.khoaluanPK != null) || (this.khoaluanPK != null && !this.khoaluanPK.equals(other.khoaluanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Khoaluan[ khoaluanPK=" + khoaluanPK + " ]";
    }
    
}
