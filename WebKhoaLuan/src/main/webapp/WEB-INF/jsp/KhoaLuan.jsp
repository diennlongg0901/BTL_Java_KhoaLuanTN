<%-- 
    Document   : SinhVien
    Created on : Aug 8, 2022, 9:01:20 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:url value="/sinhvien/KhoaLuan/${pageContext.request.userPrincipal.name}" var="action" />
<h2 class="text-center mt-5">KHÓA LUẬN TỐT NGHIỆP</h2>
<div class="container">
    <div class="form-group container">
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="khoaluan" >
            <form:textarea class="form-control" path="ghiChu" placeholder="Nội dung chi tiết đề tài khóa luận"></form:textarea>
                  

            <div class=" mt-4">
                <lable class="form-label mt-4">Nộp bài khóa luận</lable>
                <form:input type="file" id="file" path="file" class="form-control"  />
            </div>
            
            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Nộp khóa luận"/>
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </form:form>   
    </div>
</div>