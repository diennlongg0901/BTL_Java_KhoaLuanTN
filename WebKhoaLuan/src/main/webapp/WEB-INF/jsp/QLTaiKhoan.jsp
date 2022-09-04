<%-- 
    Document   : DangKy
    Created on : Aug 4, 2022, 10:02:05 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${message != null}">
    <div class ="alert alert-danger">
        ${message}
    </div>
</c:if>

<!-- PHẦN QUẢN TRỊ XEM DANH SÁCH TÀI KHOẢN NGƯỜI DÙNG -->
<h2 class="text-center mt-5"><strong>QUẢN LÝ TÀI KHOẢN NGƯỜI DÙNG</strong></h2>
<c:url value="/quantri/QLTaiKhoan" var="action" />
<div class="container form-outline mt-4">
    <label class="form-label" for="vaiTro">Lọc người dùng theo chức vụ</label>
    <select id="vaiTro" name="vaiTro" onchange="window.location.href = this.value">
        <option value="" >Chức vụ</option>
        <c:forEach items="${chucvu}" var="c">
            <option value="${action}/${c.maCV}" >${c.tenCV}</option>
        </c:forEach>
    </select>
</div>
<hr class="mt-4">
<table class="table">
    <thead>
        <tr>
            <th scope="col">Ảnh</th>
            <th scope="col">Mã</th>
            <th scope="col">Họ tên</th>
            <th scope="col">G.Tính</th>
            <th scope="col">N.Sinh</th>
            <th scope="col">Đ.Chỉ</th>
            <th scope="col">Email</th>
            <th scope="col">SĐT</th>
            <th scope="col">Username</th>
            <th scope="col">H.Động</th>
            <th scope="col">C.Vụ</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${nguoidung}" var="nd">
            <tr>
                <td>
                    <img src="${nd.anh}" alt="alt" class="img-fluid rounded" style="width: 50px; height: 50px;"/>
                </td>
                <td>${nd.nguoidungPK.maND}</td>
                <td>${nd.ho} ${nd.ten}</td>
                <td>${nd.gioiTinh}</td>
                <td>${nd.ngaySinh}</td>
                <td>${nd.diaChi}</td>
                <td>${nd.email}</td>
                <td>${nd.sdt}</td>
                <td>${nd.username}</td>
                <td>${nd.hoatDong}</td>
                <td>${nd.chucvu.tenCV}</td>
                <td><a href=" <c:url value="/quantri/QLTaiKhoan/${nd.nguoidungPK.maND}" />">Xóa</a></td>
                <td><a href="<c:url value='/quantri/ThongTinND/${nd.nguoidungPK.maND}' />" >Cập nhật</a></td>              
            </tr>
        </c:forEach>
    </tbody>
</table>