<%-- 
    Document   : ThongKeDiem
    Created on : Aug 16, 2022, 1:42:34 PM
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

<h2 class="text-center mt-5"><strong>THỐNG KÊ ĐIỂM KHÓA LUẬN</strong></h2>
<div class="container-fluid">
    <form action="">
        <div class="row">
            <div class="col-md-8 form-group mt-4">
            <input type="text" name="nam" class="form-control" placeholder="Nhập năm cần tìm" />
        </div>
        <div class="col-md-4 form-group">
            <input type="submit" class="btn btn-primary btn-block mt-4 " value="Tìm" />
        </div>
        </div>
    </form>
</div>
<div class="row">
    <div class="mt-4 col">
        <canvas id="scoreChartID"></canvas>
    </div>
    <table class="table mt-4 col" >
        <tr>
            <th>Điểm:</th>
            <th>Số lần:</th>
        </tr>
        <c:forEach items="${scoreStats}" var="s">
            <tr>
                <th>${s[0]}</th>
                <th>${s[1]}</th>

            </tr>
        </c:forEach>
    </table>
</div>

<script>
    let scoreLabels = [], scoreInfo = [];
    <c:forEach items="${scoreStats}" var="s">
    scoreLabels.push('${s[0]}');
    scoreInfo.push('${s[1]}');
    </c:forEach>
    window.onload = function () {
        scoreChart("scoreChartID", scoreLabels, scoreInfo);
    };
</script>