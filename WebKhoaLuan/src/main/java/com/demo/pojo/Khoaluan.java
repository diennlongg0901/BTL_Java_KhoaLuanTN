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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @NamedQuery(name = "Khoaluan.findByMaKL", query = "SELECT k FROM Khoaluan k WHERE k.maKL = :maKL"),
    @NamedQuery(name = "Khoaluan.findByDeTaiKL", query = "SELECT k FROM Khoaluan k WHERE k.deTaiKL = :deTaiKL"),
    @NamedQuery(name = "Khoaluan.findByNam", query = "SELECT k FROM Khoaluan k WHERE k.nam = :nam"),
    @NamedQuery(name = "Khoaluan.findByGhiChu", query = "SELECT k FROM Khoaluan k WHERE k.ghiChu = :ghiChu")})
public class Khoaluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maKL")
    private Integer maKL;
    @Size(max = 100)
    @Column(name = "deTaiKL")
    private String deTaiKL;
    @Column(name = "nam")
    private Integer nam;
    @Size(max = 100)
    @Column(name = "ghiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaluan")
    private Collection<Diem> diemCollection;
    @JoinColumn(name = "giangvien_maGV", referencedColumnName = "maGV")
    @ManyToOne(optional = false)
    private Giangvien giangvienmaGV;
    @JoinColumn(name = "hoidong_maHD", referencedColumnName = "maHD")
    @ManyToOne(optional = false)
    private Hoidong hoidongmaHD;
    @JoinColumn(name = "sinhvien_maSoSV", referencedColumnName = "maSoSV")
    @ManyToOne(optional = false)
    private Sinhvien sinhvienmaSoSV;

    public Khoaluan() {
    }

    public Khoaluan(Integer maKL) {
        this.maKL = maKL;
    }

    public Integer getMaKL() {
        return maKL;
    }

    public void setMaKL(Integer maKL) {
        this.maKL = maKL;
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
    public Collection<Diem> getDiemCollection() {
        return diemCollection;
    }

    public void setDiemCollection(Collection<Diem> diemCollection) {
        this.diemCollection = diemCollection;
    }

    public Giangvien getGiangvienmaGV() {
        return giangvienmaGV;
    }

    public void setGiangvienmaGV(Giangvien giangvienmaGV) {
        this.giangvienmaGV = giangvienmaGV;
    }

    public Hoidong getHoidongmaHD() {
        return hoidongmaHD;
    }

    public void setHoidongmaHD(Hoidong hoidongmaHD) {
        this.hoidongmaHD = hoidongmaHD;
    }

    public Sinhvien getSinhvienmaSoSV() {
        return sinhvienmaSoSV;
    }

    public void setSinhvienmaSoSV(Sinhvien sinhvienmaSoSV) {
        this.sinhvienmaSoSV = sinhvienmaSoSV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKL != null ? maKL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoaluan)) {
            return false;
        }
        Khoaluan other = (Khoaluan) object;
        if ((this.maKL == null && other.maKL != null) || (this.maKL != null && !this.maKL.equals(other.maKL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Khoaluan[ maKL=" + maKL + " ]";
    }
    
}
