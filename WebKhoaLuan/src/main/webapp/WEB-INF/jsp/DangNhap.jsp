<%-- 
    Document   : DangNhap
    Created on : Jul 27, 2022, 9:32:47 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Đã có lỗi! Vui lòng thử đăng nhập lại!
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Tài khoản không được quyền truy cập!
    </div>
</c:if>

<!-- ĐĂNG NHẬP TÀI KHOẢN NGƯỜI DÙNG -->
<c:url value="/DangNhap" var="action" />
<div class="container">
    <h2 class="text-center mt-5"><strong>ĐĂNG NHẬP</strong></h2>
    <div class="form-group container">
        <form method="post" action="${action}">
            <div class="form-outline mb-4">
                <label class="form-label" for="username">Username</label>
                <input type="text" id="username" name="username" class="form-control" />
            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control" />
            </div>
            <input type="submit" class="btn btn-primary btn-block mb-4" value="Đăng nhập"/>
            <div class="col">
                <a href="#!">Quên mật khẩu?</a>
            </div>
        </form>
    </div>
</div>