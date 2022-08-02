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
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author ADMIN
 */
@Entity
@Table(name = "chucvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chucvu.findAll", query = "SELECT c FROM Chucvu c"),
    @NamedQuery(name = "Chucvu.findByMaChucVu", query = "SELECT c FROM Chucvu c WHERE c.maChucVu = :maChucVu"),
    @NamedQuery(name = "Chucvu.findByTenChucVu", query = "SELECT c FROM Chucvu c WHERE c.tenChucVu = :tenChucVu")})
public class Chucvu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "maChucVu")
    private String maChucVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tenChucVu")
    private String tenChucVu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chucvumaChucVu")
    private Set<Giaovu> giaovuSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chucvumaChucVu")
    private Set<Sinhvien> sinhvienSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chucvumaChucVu")
    private Set<Quantri> quantriSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chucvumaChucVu")
    private Set<Giangvien> giangvienSet;

    public Chucvu() {
    }

    public Chucvu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public Chucvu(String maChucVu, String tenChucVu) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    @XmlTransient
    public Set<Giaovu> getGiaovuSet() {
        return giaovuSet;
    }

    public void setGiaovuSet(Set<Giaovu> giaovuSet) {
        this.giaovuSet = giaovuSet;
    }

    @XmlTransient
    public Set<Sinhvien> getSinhvienSet() {
        return sinhvienSet;
    }

    public void setSinhvienSet(Set<Sinhvien> sinhvienSet) {
        this.sinhvienSet = sinhvienSet;
    }

    @XmlTransient
    public Set<Quantri> getQuantriSet() {
        return quantriSet;
    }

    public void setQuantriSet(Set<Quantri> quantriSet) {
        this.quantriSet = quantriSet;
    }

    @XmlTransient
    public Set<Giangvien> getGiangvienSet() {
        return giangvienSet;
    }

    public void setGiangvienSet(Set<Giangvien> giangvienSet) {
        this.giangvienSet = giangvienSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChucVu != null ? maChucVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chucvu)) {
            return false;
        }
        Chucvu other = (Chucvu) object;
        if ((this.maChucVu == null && other.maChucVu != null) || (this.maChucVu != null && !this.maChucVu.equals(other.maChucVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Chucvu[ maChucVu=" + maChucVu + " ]";
    }
    
}
