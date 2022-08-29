/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
 * @author ADMIN
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
    @NamedQuery(name = "Nguoidung.findByMaCV", query = "SELECT n FROM Nguoidung n WHERE n.nguoidungPK.maCV = :maCV")})
public class Nguoidung implements Serializable {

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
    private Set<Quantri> quantriSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Set<Giangvien> giangvienSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Set<Giaovu> giaovuSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private Set<Sinhvien> sinhvienSet;
    @JoinColumn(name = "maCV", referencedColumnName = "maCV", insertable = false, updatable = false)
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
    private String khoa;
    @Transient
    private String nganh;
    @Transient
    private String khoaDK;
    @Transient
    private String nganhDK;
    //GIẢNG VIÊN
    @Transient
    private String hocHam;
    @Transient
    private String hocVi;
    //GIÁO VỤ
    @Transient
    private String phongBan;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getKhoaDK() {
        return khoaDK;
    }

    public void setKhoaDK(String khoaDK) {
        this.khoaDK = khoaDK;
    }

    public String getNganhDK() {
        return nganhDK;
    }

    public void setNganhDK(String nganhDK) {
        this.nganhDK = nganhDK;
    }

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

    public Nguoidung() {
    }

    public Nguoidung(NguoidungPK nguoidungPK) {
        this.nguoidungPK = nguoidungPK;
    }

    public Nguoidung(String maND, String maCV) {
        this.nguoidungPK = new NguoidungPK(maND, maCV);
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
