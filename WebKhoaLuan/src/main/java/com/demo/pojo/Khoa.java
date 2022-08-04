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
@Table(name = "khoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khoa.findAll", query = "SELECT k FROM Khoa k"),
    @NamedQuery(name = "Khoa.findByMaKhoa", query = "SELECT k FROM Khoa k WHERE k.maKhoa = :maKhoa"),
    @NamedQuery(name = "Khoa.findByTenKhoa", query = "SELECT k FROM Khoa k WHERE k.tenKhoa = :tenKhoa"),
    @NamedQuery(name = "Khoa.findBySoDTKhoa", query = "SELECT k FROM Khoa k WHERE k.soDTKhoa = :soDTKhoa"),
    @NamedQuery(name = "Khoa.findByDiaChiKhoa", query = "SELECT k FROM Khoa k WHERE k.diaChiKhoa = :diaChiKhoa"),
    @NamedQuery(name = "Khoa.findByWebSite", query = "SELECT k FROM Khoa k WHERE k.webSite = :webSite"),
    @NamedQuery(name = "Khoa.findByEmailKhoa", query = "SELECT k FROM Khoa k WHERE k.emailKhoa = :emailKhoa")})
public class Khoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maKhoa")
    private Integer maKhoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tenKhoa")
    private String tenKhoa;
    @Size(max = 15)
    @Column(name = "soDTKhoa")
    private String soDTKhoa;
    @Size(max = 100)
    @Column(name = "diaChiKhoa")
    private String diaChiKhoa;
    @Size(max = 50)
    @Column(name = "webSite")
    private String webSite;
    @Size(max = 50)
    @Column(name = "emailKhoa")
    private String emailKhoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoamaKhoa")
    private Collection<Nganh> nganhCollection;

    public Khoa() {
    }

    public Khoa(Integer maKhoa) {
        this.maKhoa = maKhoa;
    }

    public Khoa(Integer maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public Integer getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(Integer maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getSoDTKhoa() {
        return soDTKhoa;
    }

    public void setSoDTKhoa(String soDTKhoa) {
        this.soDTKhoa = soDTKhoa;
    }

    public String getDiaChiKhoa() {
        return diaChiKhoa;
    }

    public void setDiaChiKhoa(String diaChiKhoa) {
        this.diaChiKhoa = diaChiKhoa;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEmailKhoa() {
        return emailKhoa;
    }

    public void setEmailKhoa(String emailKhoa) {
        this.emailKhoa = emailKhoa;
    }

    @XmlTransient
    public Collection<Nganh> getNganhCollection() {
        return nganhCollection;
    }

    public void setNganhCollection(Collection<Nganh> nganhCollection) {
        this.nganhCollection = nganhCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhoa != null ? maKhoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoa)) {
            return false;
        }
        Khoa other = (Khoa) object;
        if ((this.maKhoa == null && other.maKhoa != null) || (this.maKhoa != null && !this.maKhoa.equals(other.maKhoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Khoa[ maKhoa=" + maKhoa + " ]";
    }
    
}
