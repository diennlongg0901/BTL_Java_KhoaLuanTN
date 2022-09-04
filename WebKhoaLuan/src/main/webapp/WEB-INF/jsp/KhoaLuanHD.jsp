<%-- 
    Document   : KhoaLuanHD
    Created on : Aug 31, 2022, 7:56:16 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<!-- PHẦN GIẢNG VIÊN XEM DANH SÁCH KHÓA LUẬN MÀ HỘI ĐỒNG CHẤM -->
<h2 class="text-center mt-5"><strong>DANH SÁCH KHÓA LUẬN TỐT NGHIỆP THEO HỘI ĐỒNG</strong></h2>
    <table class="table mt-4">
        <thead>
            <tr>
                <th scope="col">Sinh viên</th>
                <th scope="col">Email</th>
                <th scope="col">SĐT</th>
                <th scope="col">Giảng viên HD 2</th>
                <th scope="col">Đề tài</th>
                <th scope="col">Bài nộp</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dskhoaluanhd}" var="klhd">
                <tr>
                    <td>${klhd.dangkykhoaluan.dangkykhoaluanPK.maSV} - ${klhd.dangkykhoaluan.sinhvien.nguoidung.ho} ${klhd.dangkykhoaluan.sinhvien.nguoidung.ten}</td>
                    <td>${klhd.dangkykhoaluan.sinhvien.nguoidung.email}</td>
                    <td>${klhd.dangkykhoaluan.sinhvien.nguoidung.sdt}</td>
                    <td>${klhd.maGV2} - </td>
                    <td>${klhd.dangkykhoaluan.detai.maDT}.${klhd.dangkykhoaluan.detai.tenDT}</td>
                    <td>${klhd.file}</td>
                    <td><a href=" <c:url value="/giangvien/ChamDiemHD/${klhd.maKL}" />">Chấm điểm</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>