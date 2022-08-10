<%-- 
    Document   : DangKy
    Created on : Aug 4, 2022, 10:02:05 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center">QUẢN LÝ TÀI KHOẢN NGƯỜI DÙNG</h2>

<div class="form-outline mb-4">
    <label class="form-label" for="vaiTro">Vai trò người dùng</label>
    <select id="vaiTro" name="vaiTro">
        <c:forEach items="${chucvu}" var="c">
            <option value="${c.maChucVu}">${c.tenChucVu}</option>
        </c:forEach>
    </select>
</div>

<%--<c:forEach var="nd" items="${nguoidung}">--%>
<!--        <h2> ${nd.ten} </h2>
    <h3>${nd.hoatDong}</h3>
    <h3>${nd.ngaySinh}</h3>
    
    <div class="card" >
        <div class="card-header">  </div>
        <div class="card-body">
            
            <img src="<c:url value="picture/Anh1" />" alt="${sv.tenSV}" />
        </div>
            <div class="card-footer"></div>
    </div>-->
<%--</c:forEach>--%>

