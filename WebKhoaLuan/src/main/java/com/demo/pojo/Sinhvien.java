/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "sinhvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinhvien.findAll", query = "SELECT s FROM Sinhvien s"),
    @NamedQuery(name = "Sinhvien.findByMaSV", query = "SELECT s FROM Sinhvien s WHERE s.maSV = :maSV"),
    @NamedQuery(name = "Sinhvien.findByNienKhoa", query = "SELECT s FROM Sinhvien s WHERE s.nienKhoa = :nienKhoa"),
    @NamedQuery(name = "Sinhvien.findByTinhTrang", query = "SELECT s FROM Sinhvien s WHERE s.tinhTrang = :tinhTrang")})
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maSV")
    private String maSV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nienKhoa")
    private String nienKhoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tinhTrang")
    private short tinhTrang;
    @JoinColumn(name = "nganh_maNganh", referencedColumnName = "maNganh")
    @ManyToOne(optional = false)
    private Nganh nganhmaNganh;
    @JoinColumn(name = "nguoidung_maND", referencedColumnName = "maND")
    @ManyToOne(optional = false)
    private Nguoidung nguoidungmaND;

    public Sinhvien() {
    }

    public Sinhvien(String maSV) {
        this.maSV = maSV;
    }

    public Sinhvien(String maSV, String nienKhoa, short tinhTrang) {
        this.maSV = maSV;
        this.nienKhoa = nienKhoa;
        this.tinhTrang = tinhTrang;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
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

    public Nganh getNganhmaNganh() {
        return nganhmaNganh;
    }

    public void setNganhmaNganh(Nganh nganhmaNganh) {
        this.nganhmaNganh = nganhmaNganh;
    }

    public Nguoidung getNguoidungmaND() {
        return nguoidungmaND;
    }

    public void setNguoidungmaND(Nguoidung nguoidungmaND) {
        this.nguoidungmaND = nguoidungmaND;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSV != null ? maSV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinhvien)) {
            return false;
        }
        Sinhvien other = (Sinhvien) object;
        if ((this.maSV == null && other.maSV != null) || (this.maSV != null && !this.maSV.equals(other.maSV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Sinhvien[ maSV=" + maSV + " ]";
    }
    
}
