<%-- 
    Document   : Diem
    Created on : Aug 16, 2022, 3:19:48 PM
    Author     : ADMIN
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${pageContext.request.isUserInRole('ROLE_GV')}">
    <h2 class="text-center mt-5">CHẤM ĐIỂM KHÓA LUẬN</h2>    
    <div class="container mt-5">
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="diem">
            <div class="form-outline mt-4">
                <form:input type="text" path="maGVHD" placeholder="Mã giảng viên" value="${pageContext.request.userPrincipal.name}"/>
            </div>
            <div class="form-outline mt-4">
                <form:textarea type="text" class="form-control" path="nhanXet" placeholder="Nhận xét bài khóa luận"/>
            </div>       
            <div class="form-outline mt-4">
                <form:input type="number" step="0.05" path="diem" placeholder="Nhập điểm cho khóa luận"/>
            </div>

            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Xác nhận"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </form:form>
    </div>   
</c:if>

<c:if test="${pageContext.request.isUserInRole('ROLE_SV')}">
    <h2 class="text-center mt-5">ĐIỂM KHÓA LUẬN</h2>
    <div class="container mt-5">
        <h4 class="mt-4">Thông tin về khóa luận</h4>
        <div class="row mt-4">
            <div class="col-md-3">

            </div>
        </div>
        <hr>
        <h4 class="mt-4">Điểm số chi tiết của khóa luận</h4>

        <hr>
        <h4 class="mt-4">Kết quả bài khóa luận</h4>
    </div>
</c:if>