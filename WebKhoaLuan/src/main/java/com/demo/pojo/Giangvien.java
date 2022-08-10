/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "giangvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giangvien.findAll", query = "SELECT g FROM Giangvien g"),
    @NamedQuery(name = "Giangvien.findByMaGV", query = "SELECT g FROM Giangvien g WHERE g.giangvienPK.maGV = :maGV"),
    @NamedQuery(name = "Giangvien.findByHocVi", query = "SELECT g FROM Giangvien g WHERE g.hocVi = :hocVi"),
    @NamedQuery(name = "Giangvien.findByHocHam", query = "SELECT g FROM Giangvien g WHERE g.hocHam = :hocHam"),
    @NamedQuery(name = "Giangvien.findByMaND", query = "SELECT g FROM Giangvien g WHERE g.giangvienPK.maND = :maND"),
    @NamedQuery(name = "Giangvien.findByMaChucVu", query = "SELECT g FROM Giangvien g WHERE g.giangvienPK.maChucVu = :maChucVu")})
public class Giangvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GiangvienPK giangvienPK;
    @Size(max = 50)
    @Column(name = "hocVi")
    private String hocVi;
    @Size(max = 50)
    @Column(name = "hocHam")
    private String hocHam;
    @JoinColumns({
        @JoinColumn(name = "maND", referencedColumnName = "maND", insertable = false, updatable = false),
        @JoinColumn(name = "maChucVu", referencedColumnName = "chucvu_maChucVu", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giangvien")
    private Collection<Chitiethoidong> chitiethoidongCollection;

    public Giangvien() {
    }

    public Giangvien(GiangvienPK giangvienPK) {
        this.giangvienPK = giangvienPK;
    }

    public Giangvien(String maGV, String maND, String maChucVu) {
        this.giangvienPK = new GiangvienPK(maGV, maND, maChucVu);
    }

    public GiangvienPK getGiangvienPK() {
        return giangvienPK;
    }

    public void setGiangvienPK(GiangvienPK giangvienPK) {
        this.giangvienPK = giangvienPK;
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

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }

    @XmlTransient
    public Collection<Chitiethoidong> getChitiethoidongCollection() {
        return chitiethoidongCollection;
    }

    public void setChitiethoidongCollection(Collection<Chitiethoidong> chitiethoidongCollection) {
        this.chitiethoidongCollection = chitiethoidongCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (giangvienPK != null ? giangvienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giangvien)) {
            return false;
        }
        Giangvien other = (Giangvien) object;
        if ((this.giangvienPK == null && other.giangvienPK != null) || (this.giangvienPK != null && !this.giangvienPK.equals(other.giangvienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Giangvien[ giangvienPK=" + giangvienPK + " ]";
    }
    
}
