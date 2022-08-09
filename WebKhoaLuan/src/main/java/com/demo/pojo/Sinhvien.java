/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Sinhvien.findByMaSV", query = "SELECT s FROM Sinhvien s WHERE s.sinhvienPK.maSV = :maSV"),
    @NamedQuery(name = "Sinhvien.findByNienKhoa", query = "SELECT s FROM Sinhvien s WHERE s.nienKhoa = :nienKhoa"),
    @NamedQuery(name = "Sinhvien.findByTinhTrang", query = "SELECT s FROM Sinhvien s WHERE s.tinhTrang = :tinhTrang"),
    @NamedQuery(name = "Sinhvien.findByMaND", query = "SELECT s FROM Sinhvien s WHERE s.sinhvienPK.maND = :maND"),
    @NamedQuery(name = "Sinhvien.findByMaChucVu", query = "SELECT s FROM Sinhvien s WHERE s.sinhvienPK.maChucVu = :maChucVu"),
    @NamedQuery(name = "Sinhvien.findByMaNganh", query = "SELECT s FROM Sinhvien s WHERE s.sinhvienPK.maNganh = :maNganh"),
    @NamedQuery(name = "Sinhvien.findByMaKhoa", query = "SELECT s FROM Sinhvien s WHERE s.sinhvienPK.maKhoa = :maKhoa")})
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SinhvienPK sinhvienPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nienKhoa")
    private String nienKhoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tinhTrang")
    private short tinhTrang;
    @JoinColumns({
        @JoinColumn(name = "maNganh", referencedColumnName = "maNganh", insertable = false, updatable = false),
        @JoinColumn(name = "maKhoa", referencedColumnName = "khoa_maKhoa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nganh nganh;
    @JoinColumns({
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maChucVu", referencedColumnName = "chucvu_maChucVu", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvien")
    private Set<Khoaluan> khoaluanSet;

    public Sinhvien() {
    }

    public Sinhvien(SinhvienPK sinhvienPK) {
        this.sinhvienPK = sinhvienPK;
    }

    public Sinhvien(SinhvienPK sinhvienPK, String nienKhoa, short tinhTrang) {
        this.sinhvienPK = sinhvienPK;
        this.nienKhoa = nienKhoa;
        this.tinhTrang = tinhTrang;
    }

    public Sinhvien(String maSV, String maND, String maChucVu, int maNganh, int maKhoa) {
        this.sinhvienPK = new SinhvienPK(maSV, maND, maChucVu, maNganh, maKhoa);
    }

    public SinhvienPK getSinhvienPK() {
        return sinhvienPK;
    }

    public void setSinhvienPK(SinhvienPK sinhvienPK) {
        this.sinhvienPK = sinhvienPK;
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

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
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
        hash += (sinhvienPK != null ? sinhvienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinhvien)) {
            return false;
        }
        Sinhvien other = (Sinhvien) object;
        if ((this.sinhvienPK == null && other.sinhvienPK != null) || (this.sinhvienPK != null && !this.sinhvienPK.equals(other.sinhvienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Sinhvien[ sinhvienPK=" + sinhvienPK + " ]";
    }
    
}
