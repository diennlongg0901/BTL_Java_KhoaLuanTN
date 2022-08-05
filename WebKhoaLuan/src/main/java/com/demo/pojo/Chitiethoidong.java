/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "chitiethoidong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitiethoidong.findAll", query = "SELECT c FROM Chitiethoidong c"),
    @NamedQuery(name = "Chitiethoidong.findByHoidongmaHD", query = "SELECT c FROM Chitiethoidong c WHERE c.chitiethoidongPK.hoidongmaHD = :hoidongmaHD"),
    @NamedQuery(name = "Chitiethoidong.findByNguoidungmaND", query = "SELECT c FROM Chitiethoidong c WHERE c.chitiethoidongPK.nguoidungmaND = :nguoidungmaND"),
    @NamedQuery(name = "Chitiethoidong.findByVaiTro", query = "SELECT c FROM Chitiethoidong c WHERE c.vaiTro = :vaiTro")})
public class Chitiethoidong implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChitiethoidongPK chitiethoidongPK;
    @Size(max = 45)
    @Column(name = "vaiTro")
    private String vaiTro;
    @JoinColumn(name = "hoidong_maHD", referencedColumnName = "maHD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hoidong hoidong;
    @JoinColumn(name = "nguoidung_maND", referencedColumnName = "maND", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Chitiethoidong() {
    }

    public Chitiethoidong(ChitiethoidongPK chitiethoidongPK) {
        this.chitiethoidongPK = chitiethoidongPK;
    }

    public Chitiethoidong(int hoidongmaHD, String nguoidungmaND) {
        this.chitiethoidongPK = new ChitiethoidongPK(hoidongmaHD, nguoidungmaND);
    }

    public ChitiethoidongPK getChitiethoidongPK() {
        return chitiethoidongPK;
    }

    public void setChitiethoidongPK(ChitiethoidongPK chitiethoidongPK) {
        this.chitiethoidongPK = chitiethoidongPK;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Hoidong getHoidong() {
        return hoidong;
    }

    public void setHoidong(Hoidong hoidong) {
        this.hoidong = hoidong;
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chitiethoidongPK != null ? chitiethoidongPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitiethoidong)) {
            return false;
        }
        Chitiethoidong other = (Chitiethoidong) object;
        if ((this.chitiethoidongPK == null && other.chitiethoidongPK != null) || (this.chitiethoidongPK != null && !this.chitiethoidongPK.equals(other.chitiethoidongPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Chitiethoidong[ chitiethoidongPK=" + chitiethoidongPK + " ]";
    }
    
}
