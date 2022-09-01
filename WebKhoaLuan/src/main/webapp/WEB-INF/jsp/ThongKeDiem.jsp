<%-- 
    Document   : ThongKeDiem
    Created on : Aug 16, 2022, 1:42:34 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>--%>


<h2 class="text-center"><strong>THỐNG KÊ ĐIỂM KHÓA LUẬN</strong></h2

<!--<div>
    <canvas id="scoreChart"></canvas>
</div>-->

<table class="table">
    <tr>
<!--        <th>Mã sinh viên 1:</th>-->
<!--        <th>Mã sinh viên 2:</th>-->
        <th>Mã khóa luận:</th>
        <th>Tên đề tài:</th>
<!--        <th>Điểm:</th>-->
    </tr>
    <c:forEach items="${scoreStats}" var="s">
        <tr>
            <th>${p[0]}</th>
            <th>${p[1]}</th>
<!--            <th>${p[2]}</th>-->
<!--            <th>${p[3]}</th>-->
<!--            <th>${p[4]}</th>-->
        </tr>
    </c:forEach>
</table>

