/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "detai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detai.findAll", query = "SELECT d FROM Detai d"),
    @NamedQuery(name = "Detai.findByMaDT", query = "SELECT d FROM Detai d WHERE d.maDT = :maDT"),
    @NamedQuery(name = "Detai.findByTenDT", query = "SELECT d FROM Detai d WHERE d.tenDT = :tenDT"),
    @NamedQuery(name = "Detai.findByHanNop", query = "SELECT d FROM Detai d WHERE d.hanNop = :hanNop"),
    @NamedQuery(name = "Detai.findByNoiDung", query = "SELECT d FROM Detai d WHERE d.noiDung = :noiDung"),
    @NamedQuery(name = "Detai.findByNam", query = "SELECT d FROM Detai d WHERE d.nam = :nam")})
public class Detai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maDT")
    private Integer maDT;
    @Size(max = 200)
    @Column(name = "tenDT")
    private String tenDT;
    @Column(name = "hanNop")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hanNop;
    @Size(max = 2000)
    @Column(name = "noiDung")
    private String noiDung;
    @Size(max = 15)
    @Column(name = "nam")
    private String nam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detai")
    private Set<Dangkykhoaluan> dangkykhoaluanSet;

    public Detai() {
    }

    public Detai(Integer maDT) {
        this.maDT = maDT;
    }

    public Integer getMaDT() {
        return maDT;
    }

    public void setMaDT(Integer maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public Date getHanNop() {
        return hanNop;
    }

    public void setHanNop(Date hanNop) {
        this.hanNop = hanNop;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @XmlTransient
    public Set<Dangkykhoaluan> getDangkykhoaluanSet() {
        return dangkykhoaluanSet;
    }

    public void setDangkykhoaluanSet(Set<Dangkykhoaluan> dangkykhoaluanSet) {
        this.dangkykhoaluanSet = dangkykhoaluanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDT != null ? maDT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detai)) {
            return false;
        }
        Detai other = (Detai) object;
        if ((this.maDT == null && other.maDT != null) || (this.maDT != null && !this.maDT.equals(other.maDT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Detai[ maDT=" + maDT + " ]";
    }
    
}
