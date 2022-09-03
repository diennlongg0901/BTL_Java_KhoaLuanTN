<%-- 
    Document   : dn
    Created on : Jul 29, 2022, 2:27:06 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm py-3 bg-light navbar-light">
    <div class="container-fluid">
        <a class="navbar-brand link-dark" href="<c:url value = "/" />">
            <img src="${pageContext.servletContext.contextPath}/picture/University.svg" alt="TruongDaiHocAA" class="icon-seal-small" style="height: 70px" />
            <strong>The University of VietNam</strong>
        </a>
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <c:if test="${pageContext.request.isUserInRole('ROLE_QT')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Quản lý tài khoản</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/DangKy"/>">Đăng ký tài khoản</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/QLTaiKhoan"/>">Quản lý tài khoản</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/ThongKeDiem"/>">Thống kê điểm</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/ThongKeSV"/>">Thống kê sinh viên</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/ThongTinQT/${pageContext.request.userPrincipal.name}"/>">Thông tin người dùng</a></li> 
                    </ul>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Chức năng giáo vụ</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/DeTaiKhoaLuan"/>">Đề tài khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giaovu/dsDangKyKhoaLuan"/>">Danh sách đăng ký khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giaovu/HoiDong"/>">Hội đồng</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/giaovu/ThongKeDiem"/>">Thống kê điểm</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giaovu/ThongKeSV"/>">Thống kê sinh viên</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giaovu/ThongTinGVU/${pageContext.request.userPrincipal.name}"/>">Thông tin người dùng</a></li> 
                    </ul>
                </li>
            </c:if>

            <c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Chức năng giảng viên</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/giangvien/HoiDong/${pageContext.request.userPrincipal.name}"/>">Thông tin hội đồng</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/DeTaiKhoaLuan"/>">Đề tài khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giangvien/dsKhoaLuan/${pageContext.request.userPrincipal.name}"/>">Danh sách khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giangvien/ThongTinGV/${pageContext.request.userPrincipal.name}"/>">Thông tin người dùng</a></li>
                    </ul>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Chức năng sinh viên</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/DeTaiKhoaLuan"/>">Đăng ký đề tài khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/sinhvien/KhoaLuan/"/>">Nộp khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/sinhvien/DiemKL/${pageContext.request.userPrincipal.name}"/>">Xem điểm khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/sinhvien/ThongTinSV/${pageContext.request.userPrincipal.name}"/>">Thông tin người dùng</a></li>
                    </ul>
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
