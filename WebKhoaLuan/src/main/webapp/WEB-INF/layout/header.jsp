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
            
            <li class="nav-item">
                <a class="nav-link" href="<c:url value = "/admin/QLSinhVien" />"><strong>Quản ly sinh viên</strong></a>
            </li>
            
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="<c:url value = "/DangNhap" />"><strong>Đăng nhập</strong></a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link text-success" href="<c:url value = "/DangNhap" />"><strong>Đăng xuất</strong></a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>