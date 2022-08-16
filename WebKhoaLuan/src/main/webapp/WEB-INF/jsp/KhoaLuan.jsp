<%-- 
    Document   : SinhVien
    Created on : Aug 8, 2022, 9:01:20 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h2 class="text-center mt-5">KHÓA LUẬN TỐT NGHIỆP</h2>
<div class="container">
    <div class="form-group container">
        <form:form method="post" action="${action}">
            <div class="form-outline mt-4">
                <label class="form-label" for="ho">Mã sinh viên</label>
                <input type="text" class="form-control"/>
            </div>
            <div class="form-outline mt-4">
                <label class="form-label" for="ho">Ghi chú</label>
                <textarea class="form-control" placeholder="Nhập ghi chú cho khóa luận (nếu có)"></textarea>
            </div>
            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Chọn file"/>
            </div>
            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Nộp khóa luận"/>
            </div>
        </form:form>   
    </div>
</div>