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
    @NamedQuery(name = "Khoa.findBySdtKhoa", query = "SELECT k FROM Khoa k WHERE k.sdtKhoa = :sdtKhoa"),
    @NamedQuery(name = "Khoa.findByDiaChiKhoa", query = "SELECT k FROM Khoa k WHERE k.diaChiKhoa = :diaChiKhoa"),
    @NamedQuery(name = "Khoa.findByEmailKhoa", query = "SELECT k FROM Khoa k WHERE k.emailKhoa = :emailKhoa"),
    @NamedQuery(name = "Khoa.findByWebsite", query = "SELECT k FROM Khoa k WHERE k.website = :website")})
public class Khoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "maKhoa")
    private String maKhoa;
    @Size(max = 100)
    @Column(name = "tenKhoa")
    private String tenKhoa;
    @Size(max = 15)
    @Column(name = "sdtKhoa")
    private String sdtKhoa;
    @Size(max = 100)
    @Column(name = "diaChiKhoa")
    private String diaChiKhoa;
    @Size(max = 50)
    @Column(name = "emailKhoa")
    private String emailKhoa;
    @Size(max = 50)
    @Column(name = "website")
    private String website;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoa")
    private Collection<Nganh> nganhCollection;

    public Collection<Nganh> getNganhCollection() {
        return nganhCollection;
    }

    public void setNganhCollection(Collection<Nganh> nganhCollection) {
        this.nganhCollection = nganhCollection;
    }

    public Khoa() {
    }

    public Khoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getSdtKhoa() {
        return sdtKhoa;
    }

    public void setSdtKhoa(String sdtKhoa) {
        this.sdtKhoa = sdtKhoa;
    }

    public String getDiaChiKhoa() {
        return diaChiKhoa;
    }

    public void setDiaChiKhoa(String diaChiKhoa) {
        this.diaChiKhoa = diaChiKhoa;
    }

    public String getEmailKhoa() {
        return emailKhoa;
    }

    public void setEmailKhoa(String emailKhoa) {
        this.emailKhoa = emailKhoa;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
