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
    @NamedQuery(name = "Khoaluan.findByDeTaiKL", query = "SELECT k FROM Khoaluan k WHERE k.deTaiKL = :deTaiKL"),
    @NamedQuery(name = "Khoaluan.findByNam", query = "SELECT k FROM Khoaluan k WHERE k.nam = :nam"),
    @NamedQuery(name = "Khoaluan.findByGhiChu", query = "SELECT k FROM Khoaluan k WHERE k.ghiChu = :ghiChu"),
    @NamedQuery(name = "Khoaluan.findByHoidongmaHD", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.hoidongmaHD = :hoidongmaHD"),
    @NamedQuery(name = "Khoaluan.findByMaSV", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maSV = :maSV"),
    @NamedQuery(name = "Khoaluan.findByMaND", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maND = :maND"),
    @NamedQuery(name = "Khoaluan.findByMaChucVu", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maChucVu = :maChucVu"),
    @NamedQuery(name = "Khoaluan.findByMaNganh", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maNganh = :maNganh"),
    @NamedQuery(name = "Khoaluan.findByMaKhoa", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maKhoa = :maKhoa")})
public class Khoaluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KhoaluanPK khoaluanPK;
    @Size(max = 100)
    @Column(name = "deTaiKL")
    private String deTaiKL;
    @Column(name = "nam")
    private Integer nam;
    @Size(max = 100)
    @Column(name = "ghiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaluan")
    private Set<Diem> diemSet;
    @JoinColumn(name = "hoidong_maHD", referencedColumnName = "maHD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hoidong hoidong;
    @JoinColumns({
        @JoinColumn(name = "maSV", referencedColumnName = "maSV", insertable = false, updatable = false),
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maChucVu", referencedColumnName = "maChucVu", insertable = false, updatable = false),
        @JoinColumn(name = "maNganh", referencedColumnName = "maNganh", insertable = false, updatable = false),
        @JoinColumn(name = "maKhoa", referencedColumnName = "maKhoa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Sinhvien sinhvien;

    public Khoaluan() {
    }

    public Khoaluan(KhoaluanPK khoaluanPK) {
        this.khoaluanPK = khoaluanPK;
    }

    public Khoaluan(int maKL, int hoidongmaHD, String maSV, String maND, String maChucVu, int maNganh, int maKhoa) {
        this.khoaluanPK = new KhoaluanPK(maKL, hoidongmaHD, maSV, maND, maChucVu, maNganh, maKhoa);
    }

    public KhoaluanPK getKhoaluanPK() {
        return khoaluanPK;
    }

    public void setKhoaluanPK(KhoaluanPK khoaluanPK) {
        this.khoaluanPK = khoaluanPK;
    }

    public String getDeTaiKL() {
        return deTaiKL;
    }

    public void setDeTaiKL(String deTaiKL) {
        this.deTaiKL = deTaiKL;
    }

    public Integer getNam() {
        return nam;
    }

    public void setNam(Integer nam) {
        this.nam = nam;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @XmlTransient
    public Set<Diem> getDiemSet() {
        return diemSet;
    }

    public void setDiemSet(Set<Diem> diemSet) {
        this.diemSet = diemSet;
    }

    public Hoidong getHoidong() {
        return hoidong;
    }

    public void setHoidong(Hoidong hoidong) {
        this.hoidong = hoidong;
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
