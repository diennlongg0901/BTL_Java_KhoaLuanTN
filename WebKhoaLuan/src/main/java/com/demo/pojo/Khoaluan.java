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
    @NamedQuery(name = "Khoaluan.findByMaDK", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maDK = :maDK"),
    @NamedQuery(name = "Khoaluan.findByMaDT", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maDT = :maDT"),
    @NamedQuery(name = "Khoaluan.findByMaSV", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maSV = :maSV"),
    @NamedQuery(name = "Khoaluan.findByMaND", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maND = :maND"),
    @NamedQuery(name = "Khoaluan.findByMaCV", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maCV = :maCV"),
    @NamedQuery(name = "Khoaluan.findByMaNganh", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maNganh = :maNganh"),
    @NamedQuery(name = "Khoaluan.findByMaKhoa", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maKhoa = :maKhoa"),
    @NamedQuery(name = "Khoaluan.findByMaGV", query = "SELECT k FROM Khoaluan k WHERE k.maGV = :maGV"),
    @NamedQuery(name = "Khoaluan.findByMaSV2", query = "SELECT k FROM Khoaluan k WHERE k.maSV2 = :maSV2")})
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
    @Size(max = 10)
    @Column(name = "maGV")
    private String maGV;
    @Size(max = 10)
    @Column(name = "maSV2")
    private String maSV2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaluan")
    private Set<Diem> diemSet;
    @JoinColumns({
        @JoinColumn(name = "maDK", referencedColumnName = "maDK", insertable = false, updatable = false),
        @JoinColumn(name = "maDT", referencedColumnName = "maDT", insertable = false, updatable = false),
        @JoinColumn(name = "maSV", referencedColumnName = "sinhvien_maSV", insertable = false, updatable = false),
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maCV", referencedColumnName = "maCV", insertable = false, updatable = false),
        @JoinColumn(name = "maNganh", referencedColumnName = "maNganh", insertable = false, updatable = false),
        @JoinColumn(name = "maKhoa", referencedColumnName = "maKhoa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Dangkykhoaluan dangkykhoaluan;

    public Khoaluan() {
    }

    public Khoaluan(KhoaluanPK khoaluanPK) {
        this.khoaluanPK = khoaluanPK;
    }

    public Khoaluan(int maKL, int maDK, int maDT, String maSV, String maND, String maCV, String maNganh, String maKhoa) {
        this.khoaluanPK = new KhoaluanPK(maKL, maDK, maDT, maSV, maND, maCV, maNganh, maKhoa);
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

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaSV2() {
        return maSV2;
    }

    public void setMaSV2(String maSV2) {
        this.maSV2 = maSV2;
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
