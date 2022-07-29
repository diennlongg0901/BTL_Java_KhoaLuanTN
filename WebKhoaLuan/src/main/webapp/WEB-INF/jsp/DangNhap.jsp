<%-- 
    Document   : DangNhap
    Created on : Jul 27, 2022, 9:32:47 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/DangNhap" var="action" />
<div class="container-fluid">
    <h2 class="text-center">Đăng nhập</h2>
    <div class="form-group container-fluid">
        <form>
            <div class="form-outline mb-4">
                <label class="form-label" for="vaiTro">Vai trò người dùng</label>
                <select id="vaiTro" name="vaiTro">
                    <option value="volvo">Sinh viên</option>
                    <option value="saab">Giảng viên</option>
                    <option value="fiat">Giáo vụ</option>
                    <option value="audi">Quản trị</option>
                </select>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="fusername">Username</label>
                <input type="text" id="username" class="form-control" />
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="password">Password</label>
                <input type="password" id="password" class="form-control" />
            </div>
            
            <button type="button" class="btn btn-primary btn-block mb-4">Đăng nhập</button>
            
            <div class="col">
                <a href="#!">Quên mật khẩu?</a>
            </div>
        </form>
    </div>
</div>