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
 * @author ADMIN
 */
@Entity
@Table(name = "giangvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giangvien.findAll", query = "SELECT g FROM Giangvien g"),
    @NamedQuery(name = "Giangvien.findByMaGV", query = "SELECT g FROM Giangvien g WHERE g.maGV = :maGV"),
    @NamedQuery(name = "Giangvien.findByHoGV", query = "SELECT g FROM Giangvien g WHERE g.hoGV = :hoGV"),
    @NamedQuery(name = "Giangvien.findByTenGV", query = "SELECT g FROM Giangvien g WHERE g.tenGV = :tenGV"),
    @NamedQuery(name = "Giangvien.findByGioiTinhGV", query = "SELECT g FROM Giangvien g WHERE g.gioiTinhGV = :gioiTinhGV"),
    @NamedQuery(name = "Giangvien.findByNgaySinhGV", query = "SELECT g FROM Giangvien g WHERE g.ngaySinhGV = :ngaySinhGV"),
    @NamedQuery(name = "Giangvien.findByDiaChiGV", query = "SELECT g FROM Giangvien g WHERE g.diaChiGV = :diaChiGV"),
    @NamedQuery(name = "Giangvien.findBySoDTGV", query = "SELECT g FROM Giangvien g WHERE g.soDTGV = :soDTGV"),
    @NamedQuery(name = "Giangvien.findByEmailGV", query = "SELECT g FROM Giangvien g WHERE g.emailGV = :emailGV"),
    @NamedQuery(name = "Giangvien.findByUsernameGV", query = "SELECT g FROM Giangvien g WHERE g.usernameGV = :usernameGV"),
    @NamedQuery(name = "Giangvien.findByPasswordGV", query = "SELECT g FROM Giangvien g WHERE g.passwordGV = :passwordGV"),
    @NamedQuery(name = "Giangvien.findByAnhGV", query = "SELECT g FROM Giangvien g WHERE g.anhGV = :anhGV"),
    @NamedQuery(name = "Giangvien.findByHocVi", query = "SELECT g FROM Giangvien g WHERE g.hocVi = :hocVi"),
    @NamedQuery(name = "Giangvien.findByHocHam", query = "SELECT g FROM Giangvien g WHERE g.hocHam = :hocHam")})
public class Giangvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maGV")
    private String maGV;
    @Size(max = 50)
    @Column(name = "hoGV")
    private String hoGV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tenGV")
    private String tenGV;
    @Size(max = 5)
    @Column(name = "gioiTinhGV")
    private String gioiTinhGV;
    @Column(name = "ngaySinhGV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinhGV;
    @Size(max = 100)
    @Column(name = "diaChiGV")
    private String diaChiGV;
    @Size(max = 15)
    @Column(name = "soDTGV")
    private String soDTGV;
    @Size(max = 50)
    @Column(name = "emailGV")
    private String emailGV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usernameGV")
    private String usernameGV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "passwordGV")
    private String passwordGV;
    @Size(max = 100)
    @Column(name = "anhGV")
    private String anhGV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "hocVi")
    private String hocVi;
    @Size(max = 50)
    @Column(name = "hocHam")
    private String hocHam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giangvien")
    private Collection<Chitiethoidong> chitiethoidongCollection;
    @JoinColumn(name = "chucvu_maChucVu", referencedColumnName = "maChucVu")
    @ManyToOne(optional = false)
    private Chucvu chucvumaChucVu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giangvienmaGV")
    private Collection<Khoaluan> khoaluanCollection;

    public Giangvien() {
    }

    public Giangvien(String maGV) {
        this.maGV = maGV;
    }

    public Giangvien(String maGV, String tenGV, String usernameGV, String passwordGV, String hocVi) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.usernameGV = usernameGV;
        this.passwordGV = passwordGV;
        this.hocVi = hocVi;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHoGV() {
        return hoGV;
    }

    public void setHoGV(String hoGV) {
        this.hoGV = hoGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getGioiTinhGV() {
        return gioiTinhGV;
    }

    public void setGioiTinhGV(String gioiTinhGV) {
        this.gioiTinhGV = gioiTinhGV;
    }

    public Date getNgaySinhGV() {
        return ngaySinhGV;
    }

    public void setNgaySinhGV(Date ngaySinhGV) {
        this.ngaySinhGV = ngaySinhGV;
    }

    public String getDiaChiGV() {
        return diaChiGV;
    }

    public void setDiaChiGV(String diaChiGV) {
        this.diaChiGV = diaChiGV;
    }

    public String getSoDTGV() {
        return soDTGV;
    }

    public void setSoDTGV(String soDTGV) {
        this.soDTGV = soDTGV;
    }

    public String getEmailGV() {
        return emailGV;
    }

    public void setEmailGV(String emailGV) {
        this.emailGV = emailGV;
    }

    public String getUsernameGV() {
        return usernameGV;
    }

    public void setUsernameGV(String usernameGV) {
        this.usernameGV = usernameGV;
    }

    public String getPasswordGV() {
        return passwordGV;
    }

    public void setPasswordGV(String passwordGV) {
        this.passwordGV = passwordGV;
    }

    public String getAnhGV() {
        return anhGV;
    }

    public void setAnhGV(String anhGV) {
        this.anhGV = anhGV;
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

    @XmlTransient
    public Collection<Chitiethoidong> getChitiethoidongCollection() {
        return chitiethoidongCollection;
    }

    public void setChitiethoidongCollection(Collection<Chitiethoidong> chitiethoidongCollection) {
        this.chitiethoidongCollection = chitiethoidongCollection;
    }

    public Chucvu getChucvumaChucVu() {
        return chucvumaChucVu;
    }

    public void setChucvumaChucVu(Chucvu chucvumaChucVu) {
        this.chucvumaChucVu = chucvumaChucVu;
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
