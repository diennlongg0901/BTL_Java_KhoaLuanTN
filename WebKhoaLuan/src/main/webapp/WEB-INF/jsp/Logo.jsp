<%-- 
    Document   : dn
    Created on : Jul 29, 2022, 2:27:06 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm py-3 bg-light navbar-light">
    <div class="container-fluid">
        <a class="nav-link active" href="<c:url value = "/" />"><strong>Trường Đại học AA</strong></a>
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <c:if test="${pageContext.request.isUserInRole('ROLE_QT')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Quản lý tài khoản</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/DangKy"/>">Tạo tài khoản</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/QLTaiKhoan"/>">Chỉnh sửa tài khoản</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/quantri/ThongTinQT/${pageContext.request.userPrincipal.name}"/>">Thông tin người dùng</a></li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Chức năng giáo vụ</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/DeTaiKhoaLuan"/>">Tạo đề tài khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/giaovu/PhanCongGV"/>">Phân công giảng viên hướng dẫn</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/HoiDong"/>">Tạo hội đồng</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/giaovu/ThongKeDiem"/>">Xem thống kê điểm</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giaovu/ThongTinSV/${pageContext.request.userPrincipal.name}"/>">Thông tin người dùng</a></li>
                    </ul>
                </li>
            </c:if>

            <c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Chức năng giảng viên</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/DeTaiKhoaLuan"/>">Xem danh sách khóa luận</a></li>
                        <li><a class="dropdown-item" href="#">Chấm điểm khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/HoiDong"/>">Xem thông tin hội đồng</a></li>
                        <li><a class="dropdown-item" href="<c:url value = "/giangvien/ThongTinSV/${pageContext.request.userPrincipal.name}"/>">Thông tin người dùng</a></li>
                    </ul>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><strong>Chức năng sinh viên</strong></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value = "/DeTaiKhoaLuan"/>">Đăng ký đề tài khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/sinhvien/KhoaLuan"/>">Nộp khóa luận</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/sinhvien/DiemKL"/>">Xem điểm khóa luận</a></li>
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
