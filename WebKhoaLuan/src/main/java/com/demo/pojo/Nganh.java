/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "nganh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nganh.findAll", query = "SELECT n FROM Nganh n"),
    @NamedQuery(name = "Nganh.findByMaNganh", query = "SELECT n FROM Nganh n WHERE n.nganhPK.maNganh = :maNganh"),
    @NamedQuery(name = "Nganh.findByTenNganh", query = "SELECT n FROM Nganh n WHERE n.tenNganh = :tenNganh"),
    @NamedQuery(name = "Nganh.findByThongTin", query = "SELECT n FROM Nganh n WHERE n.thongTin = :thongTin"),
    @NamedQuery(name = "Nganh.findByKhoamaKhoa", query = "SELECT n FROM Nganh n WHERE n.nganhPK.khoamaKhoa = :khoamaKhoa")})
public class Nganh implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NganhPK nganhPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tenNganh")
    private String tenNganh;
    @Size(max = 200)
    @Column(name = "thongTin")
    private String thongTin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nganh")
    private Collection<Sinhvien> sinhvienCollection;
    @JoinColumn(name = "khoa_maKhoa", referencedColumnName = "maKhoa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khoa khoa;

    public Nganh() {
    }

    public Nganh(NganhPK nganhPK) {
        this.nganhPK = nganhPK;
    }

    public Nganh(NganhPK nganhPK, String tenNganh) {
        this.nganhPK = nganhPK;
        this.tenNganh = tenNganh;
    }

    public Nganh(int maNganh, int khoamaKhoa) {
        this.nganhPK = new NganhPK(maNganh, khoamaKhoa);
    }

    public NganhPK getNganhPK() {
        return nganhPK;
    }

    public void setNganhPK(NganhPK nganhPK) {
        this.nganhPK = nganhPK;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    @XmlTransient
    public Collection<Sinhvien> getSinhvienCollection() {
        return sinhvienCollection;
    }

    public void setSinhvienCollection(Collection<Sinhvien> sinhvienCollection) {
        this.sinhvienCollection = sinhvienCollection;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nganhPK != null ? nganhPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nganh)) {
            return false;
        }
        Nganh other = (Nganh) object;
        if ((this.nganhPK == null && other.nganhPK != null) || (this.nganhPK != null && !this.nganhPK.equals(other.nganhPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Nganh[ nganhPK=" + nganhPK + " ]";
    }
    
}
