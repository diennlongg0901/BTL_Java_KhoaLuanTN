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
@Table(name = "giangvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giangvien.findAll", query = "SELECT g FROM Giangvien g"),
    @NamedQuery(name = "Giangvien.findByMaGV", query = "SELECT g FROM Giangvien g WHERE g.maGV = :maGV"),
    @NamedQuery(name = "Giangvien.findByHocVi", query = "SELECT g FROM Giangvien g WHERE g.hocVi = :hocVi"),
    @NamedQuery(name = "Giangvien.findByHocHam", query = "SELECT g FROM Giangvien g WHERE g.hocHam = :hocHam")})
public class Giangvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maGV")
    private String maGV;
    @Size(max = 50)
    @Column(name = "hocVi")
    private String hocVi;
    @Size(max = 50)
    @Column(name = "hocHam")
    private String hocHam;
    @JoinColumn(name = "nguoidung_maND", referencedColumnName = "maND")
    @ManyToOne(optional = false)
    private Nguoidung nguoidungmaND;

    public Giangvien() {
    }

    public Giangvien(String maGV) {
        this.maGV = maGV;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
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
        hash += (maGV != null ? maGV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giangvien)) {
            return false;
        }
        Giangvien other = (Giangvien) object;
        if ((this.maGV == null && other.maGV != null) || (this.maGV != null && !this.maGV.equals(other.maGV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Giangvien[ maGV=" + maGV + " ]";
    }
    
}
