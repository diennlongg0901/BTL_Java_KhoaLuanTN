/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "sinhvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinhvien.findAll", query = "SELECT s FROM Sinhvien s"),
    @NamedQuery(name = "Sinhvien.findByMaSoSV", query = "SELECT s FROM Sinhvien s WHERE s.maSoSV = :maSoSV"),
    @NamedQuery(name = "Sinhvien.findByHoSV", query = "SELECT s FROM Sinhvien s WHERE s.hoSV = :hoSV"),
    @NamedQuery(name = "Sinhvien.findByTenSV", query = "SELECT s FROM Sinhvien s WHERE s.tenSV = :tenSV"),
    @NamedQuery(name = "Sinhvien.findByGioiTinhSV", query = "SELECT s FROM Sinhvien s WHERE s.gioiTinhSV = :gioiTinhSV"),
    @NamedQuery(name = "Sinhvien.findByNgaySinhSV", query = "SELECT s FROM Sinhvien s WHERE s.ngaySinhSV = :ngaySinhSV"),
    @NamedQuery(name = "Sinhvien.findByDiaChiSV", query = "SELECT s FROM Sinhvien s WHERE s.diaChiSV = :diaChiSV"),
    @NamedQuery(name = "Sinhvien.findBySoDTSV", query = "SELECT s FROM Sinhvien s WHERE s.soDTSV = :soDTSV"),
    @NamedQuery(name = "Sinhvien.findByEmailSV", query = "SELECT s FROM Sinhvien s WHERE s.emailSV = :emailSV"),
    @NamedQuery(name = "Sinhvien.findByUsernameSV", query = "SELECT s FROM Sinhvien s WHERE s.usernameSV = :usernameSV"),
    @NamedQuery(name = "Sinhvien.findByPasswordSV", query = "SELECT s FROM Sinhvien s WHERE s.passwordSV = :passwordSV"),
    @NamedQuery(name = "Sinhvien.findByAnhSV", query = "SELECT s FROM Sinhvien s WHERE s.anhSV = :anhSV"),
    @NamedQuery(name = "Sinhvien.findByNienKhoa", query = "SELECT s FROM Sinhvien s WHERE s.nienKhoa = :nienKhoa"),
    @NamedQuery(name = "Sinhvien.findByTinhTrang", query = "SELECT s FROM Sinhvien s WHERE s.tinhTrang = :tinhTrang")})
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maSoSV")
    private String maSoSV;
    @Size(max = 50)
    @Column(name = "hoSV")
    private String hoSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tenSV")
    private String tenSV;
    @Size(max = 5)
    @Column(name = "gioiTinhSV")
    private String gioiTinhSV;
    @Column(name = "ngaySinhSV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinhSV;
    @Size(max = 100)
    @Column(name = "diaChiSV")
    private String diaChiSV;
    @Size(max = 15)
    @Column(name = "soDTSV")
    private String soDTSV;
    @Size(max = 50)
    @Column(name = "emailSV")
    private String emailSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usernameSV")
    private String usernameSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "passwordSV")
    private String passwordSV;
    @Size(max = 100)
    @Column(name = "anhSV")
    private String anhSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nienKhoa")
    private String nienKhoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tinhTrang")
    private short tinhTrang;
    @JoinColumn(name = "chucvu_maChucVu", referencedColumnName = "maChucVu")
    @ManyToOne(optional = false)
    private Chucvu chucvumaChucVu;
    @JoinColumn(name = "nganh_maNganh", referencedColumnName = "maNganh")
    @ManyToOne(optional = false)
    private Nganh nganhmaNganh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvienmaSoSV")
    private Collection<Khoaluan> khoaluanCollection;

    public Sinhvien() {
    }

    public Sinhvien(String maSoSV) {
        this.maSoSV = maSoSV;
    }

    public Sinhvien(String maSoSV, String tenSV, String usernameSV, String passwordSV, String nienKhoa, short tinhTrang) {
        this.maSoSV = maSoSV;
        this.tenSV = tenSV;
        this.usernameSV = usernameSV;
        this.passwordSV = passwordSV;
        this.nienKhoa = nienKhoa;
        this.tinhTrang = tinhTrang;
    }

    public String getMaSoSV() {
        return maSoSV;
    }

    public void setMaSoSV(String maSoSV) {
        this.maSoSV = maSoSV;
    }

    public String getHoSV() {
        return hoSV;
    }

    public void setHoSV(String hoSV) {
        this.hoSV = hoSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getGioiTinhSV() {
        return gioiTinhSV;
    }

    public void setGioiTinhSV(String gioiTinhSV) {
        this.gioiTinhSV = gioiTinhSV;
    }

    public Date getNgaySinhSV() {
        return ngaySinhSV;
    }

    public void setNgaySinhSV(Date ngaySinhSV) {
        this.ngaySinhSV = ngaySinhSV;
    }

    public String getDiaChiSV() {
        return diaChiSV;
    }

    public void setDiaChiSV(String diaChiSV) {
        this.diaChiSV = diaChiSV;
    }

    public String getSoDTSV() {
        return soDTSV;
    }

    public void setSoDTSV(String soDTSV) {
        this.soDTSV = soDTSV;
    }

    public String getEmailSV() {
        return emailSV;
    }

    public void setEmailSV(String emailSV) {
        this.emailSV = emailSV;
    }

    public String getUsernameSV() {
        return usernameSV;
    }

    public void setUsernameSV(String usernameSV) {
        this.usernameSV = usernameSV;
    }

    public String getPasswordSV() {
        return passwordSV;
    }

    public void setPasswordSV(String passwordSV) {
        this.passwordSV = passwordSV;
    }

    public String getAnhSV() {
        return anhSV;
    }

    public void setAnhSV(String anhSV) {
        this.anhSV = anhSV;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public short getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(short tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Chucvu getChucvumaChucVu() {
        return chucvumaChucVu;
    }

    public void setChucvumaChucVu(Chucvu chucvumaChucVu) {
        this.chucvumaChucVu = chucvumaChucVu;
    }

    public Nganh getNganhmaNganh() {
        return nganhmaNganh;
    }

    public void setNganhmaNganh(Nganh nganhmaNganh) {
        this.nganhmaNganh = nganhmaNganh;
    }

    @XmlTransient
    public Collection<Khoaluan> getKhoaluanCollection() {
        return khoaluanCollection;
    }

    public void setKhoaluanCollection(Collection<Khoaluan> khoaluanCollection) {
        this.khoaluanCollection = khoaluanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSoSV != null ? maSoSV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinhvien)) {
            return false;
        }
        Sinhvien other = (Sinhvien) object;
        if ((this.maSoSV == null && other.maSoSV != null) || (this.maSoSV != null && !this.maSoSV.equals(other.maSoSV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Sinhvien[ maSoSV=" + maSoSV + " ]";
    }
    
}
