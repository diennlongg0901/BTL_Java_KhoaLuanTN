/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author PC
 */
@Entity
@Table(name = "nguoidung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findByMaND", query = "SELECT n FROM Nguoidung n WHERE n.nguoidungPK.maND = :maND"),
    @NamedQuery(name = "Nguoidung.findByHo", query = "SELECT n FROM Nguoidung n WHERE n.ho = :ho"),
    @NamedQuery(name = "Nguoidung.findByTen", query = "SELECT n FROM Nguoidung n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nguoidung.findByGioiTinh", query = "SELECT n FROM Nguoidung n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Nguoidung.findByNgaySinh", query = "SELECT n FROM Nguoidung n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nguoidung.findByUsername", query = "SELECT n FROM Nguoidung n WHERE n.username = :username"),
    @NamedQuery(name = "Nguoidung.findByPassword", query = "SELECT n FROM Nguoidung n WHERE n.password = :password"),
    @NamedQuery(name = "Nguoidung.findByAnh", query = "SELECT n FROM Nguoidung n WHERE n.anh = :anh"),
    @NamedQuery(name = "Nguoidung.findByDiaChi", query = "SELECT n FROM Nguoidung n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nguoidung.findByEmail", query = "SELECT n FROM Nguoidung n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoidung.findBySdt", query = "SELECT n FROM Nguoidung n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "Nguoidung.findByHoatDong", query = "SELECT n FROM Nguoidung n WHERE n.hoatDong = :hoatDong"),
    @NamedQuery(name = "Nguoidung.findByChucvumaChucVu", query = "SELECT n FROM Nguoidung n WHERE n.nguoidungPK.chucvumaChucVu = :chucvumaChucVu")})
public class Nguoidung implements Serializable {

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected NguoidungPK nguoidungPK;
    @Size(max = 50)
    @Column(name = "ho")
    private String ho;
    @Size(max = 30)
    @Column(name = "ten")
    private String ten;
    @Size(max = 5)
    @Column(name = "gioiTinh")
    private String gioiTinh;
    @Column(name = "ngaySinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinh;
    @Size(max = 50)
    @Column(name = "username")
    private String username;
    @Size(max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "anh")
    private String anh;
    
    
    
    @Size(max = 100)
    @Column(name = "diaChi")
    private String diaChi;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 30)
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "hoatDong")
    private Short hoatDong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Collection<Quantri> quantriCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Collection<Giangvien> giangvienCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Collection<Giaovu> giaovuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Collection<Sinhvien> sinhvienCollection;
    @JoinColumn(name = "chucvu_maChucVu", referencedColumnName = "maChucVu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chucvu chucvu;
    @Transient
    private String confirmPassword;
    @Transient
    private MultipartFile file;
    //SINH VIÊN
    @Transient
    private String nienKhoa;
    @Transient
    private short tinhTrang;
    @Transient
    private int khoa;
    @Transient
    private int nganh;
    //GIẢNG VIÊN
    @Transient
    private String hocHam;
    @Transient
    private String hocVi;
    //GIÁO VỤ
    @Transient
    private String phongBan;
    
    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
    
    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public short getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(short tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public int getNganh() {
        return nganh;
    }

    public void setNganh(int nganh) {
        this.nganh = nganh;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public Nguoidung() {
    }

    public Nguoidung(NguoidungPK nguoidungPK) {
        this.nguoidungPK = nguoidungPK;
    }

    public Nguoidung(String maND, String chucvumaChucVu) {
        this.nguoidungPK = new NguoidungPK(maND, chucvumaChucVu);
    }

    public NguoidungPK getNguoidungPK() {
        return nguoidungPK;
    }

    public void setNguoidungPK(NguoidungPK nguoidungPK) {
        this.nguoidungPK = nguoidungPK;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Short getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(Short hoatDong) {
        this.hoatDong = hoatDong;
    }

    @XmlTransient
    public Collection<Quantri> getQuantriCollection() {
        return quantriCollection;
    }

    public void setQuantriCollection(Collection<Quantri> quantriCollection) {
        this.quantriCollection = quantriCollection;
    }

    @XmlTransient
    public Collection<Giangvien> getGiangvienCollection() {
        return giangvienCollection;
    }

    public void setGiangvienCollection(Collection<Giangvien> giangvienCollection) {
        this.giangvienCollection = giangvienCollection;
    }

    @XmlTransient
    public Collection<Giaovu> getGiaovuCollection() {
        return giaovuCollection;
    }

    public void setGiaovuCollection(Collection<Giaovu> giaovuCollection) {
        this.giaovuCollection = giaovuCollection;
    }

    @XmlTransient
    public Collection<Sinhvien> getSinhvienCollection() {
        return sinhvienCollection;
    }

    public void setSinhvienCollection(Collection<Sinhvien> sinhvienCollection) {
        this.sinhvienCollection = sinhvienCollection;
    }

    public Chucvu getChucvu() {
        return chucvu;
    }

    public void setChucvu(Chucvu chucvu) {
        this.chucvu = chucvu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nguoidungPK != null ? nguoidungPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.nguoidungPK == null && other.nguoidungPK != null) || (this.nguoidungPK != null && !this.nguoidungPK.equals(other.nguoidungPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.pojo.Nguoidung[ nguoidungPK=" + nguoidungPK + " ]";
    }
    
}
