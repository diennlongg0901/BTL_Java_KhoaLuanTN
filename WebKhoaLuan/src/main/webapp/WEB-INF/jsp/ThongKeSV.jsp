<%-- 
    Document   : ThongKeSV
    Created on : Sep 2, 2022, 3:57:42 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<h2 class="text-center mt-5"><strong>THỐNG KẾ SINH VIÊN THAM GIA KHÓA LUẬN</strong></h2>
<div class="container">
    <form action="">
        <div class="row">
            <div class="col-md-8 form-group mt-4">
                <input type="text" name="maKhoa" class="form-control" placeholder="Nhập khoa cần tìm" />
            </div>

            <div class="col-md-4 form-group">
                <input type="submit" class="btn btn-primary btn-block mt-4 " value="Tìm" />
            </div>
        </div>
    </form>
</div>
<div class="row">
    <div class="mt-4 col">
        <canvas id="svChartID"></canvas>
    </div>
    <table class="table mt-4 col" >
        <tr>
            <th>Khoa:</th>
            <th>Số sinh viên tham gia:</th>
        </tr>
        <c:forEach items="${svStats}" var="s">
            <tr>
                <th>${s[0]}</th>
                <th>${s[1]}</th>

            </tr>
        </c:forEach>
    </table>
</div>

<script>
    let svLabels = [], svInfo = [];
    <c:forEach items="${svStats}" var="s">
    svLabels.push('${s[0]}');
    svInfo.push('${s[1]}');
    </c:forEach>
    window.onload = function () {
        svChart("svChartID", svLabels, svInfo);
    }
</script>