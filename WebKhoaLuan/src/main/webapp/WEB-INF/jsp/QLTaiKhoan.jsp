<%-- 
    Document   : DangKy
    Created on : Aug 4, 2022, 10:02:05 PM
    Author     : PC
--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">QUẢN LÝ TÀI KHOẢN NGƯỜI DÙNG</h1>

<form:form method="post" action="" modelAttribute="nguoidung" enctype="multipart/form-data" > 
    <div class="form-group">
        <label for="file">Ảnh đại diện</label>
        <form:input type="file" path="file" id="image" cssClass="form-control" />
    </div>
        
    <div class="form-group">
        <input type="submit" value="Thêm tài khoản người dùng" class="btn btn-danger" />
    </div>
</form:form>


    
