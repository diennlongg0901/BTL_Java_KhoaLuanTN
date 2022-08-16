<%-- 
    Document   : ThongTinNguoiDung
    Created on : Aug 16, 2022, 10:02:55 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN GIÁO VỤ</h2>
</c:if>

<c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN GIẢNG VIÊN</h2>
</c:if>

<c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
    <h2 class="text-center mt-5">THÔNG TIN TÀI KHOẢN SINH VIÊN</h2>
</c:if>