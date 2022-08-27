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
@Table(name = "nganh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nganh.findAll", query = "SELECT n FROM Nganh n"),
    @NamedQuery(name = "Nganh.findByMaNganh", query = "SELECT n FROM Nganh n WHERE n.nganhPK.maNganh = :maNganh"),
    @NamedQuery(name = "Nganh.findByTenNganh", query = "SELECT n FROM Nganh n WHERE n.tenNganh = :tenNganh"),
    @NamedQuery(name = "Nganh.findByChiTiet", query = "SELECT n FROM Nganh n WHERE n.chiTiet = :chiTiet"),
    @NamedQuery(name = "Nganh.findByMaKhoa", query = "SELECT n FROM Nganh n WHERE n.nganhPK.maKhoa = :maKhoa")})
public class Nganh implements Serializable {

    @JoinColumn(name = "maKhoa", referencedColumnName = "maKhoa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khoa khoa;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NganhPK nganhPK;
    @Size(max = 100)
    @Column(name = "tenNganh")
    private String tenNganh;
    @Size(max = 200)
    @Column(name = "chiTiet")
    private String chiTiet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nganh")
    private Set<Sinhvien> sinhvienSet;
    
    public Nganh() {
    }

    public Nganh(NganhPK nganhPK) {
        this.nganhPK = nganhPK;
    }

    public Nganh(String maNganh, String maKhoa) {
        this.nganhPK = new NganhPK(maNganh, maKhoa);
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

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    @XmlTransient
    public Set<Sinhvien> getSinhvienSet() {
        return sinhvienSet;
    }

    public void setSinhvienSet(Set<Sinhvien> sinhvienSet) {
        this.sinhvienSet = sinhvienSet;
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
