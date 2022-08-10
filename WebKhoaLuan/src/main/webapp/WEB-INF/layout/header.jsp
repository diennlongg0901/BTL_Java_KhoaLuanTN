<%-- 
    Document   : header
    Created on : Jul 25, 2022, 9:50:28 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm fixed-top py-3 bg-light navbar-light">
    <div class="container-fluid">
        <a class="nav-link active" href="<c:url value="/" />"><strong>Trường Đại học AA</strong></a>
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="#"><strong>Thông báo mới</strong></a>
            </li>
            <c:if test="${pageContext.request.isUserInRole('ROLE_QT')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Quản lý tài khoản</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/DangKy"/>">Tạo tài khoản</a></li>
                        <li><a class="dropdown-item" href="#">Chỉnh sửa tài khoản</a></li>
                        <li><a class="dropdown-item" href="#">Xem tài khoản</a></li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><strong>Chức năng giáo vụ</strong></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><strong>Chức năng giảng viên</strong></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><strong>Chức năng sinh viên</strong></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="<c:url value = "/DangNhap" />"><strong>Đăng nhập</strong></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="<c:url value = "/logout" />"><strong>Đăng xuất</strong></a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>