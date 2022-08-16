<%-- 
    Document   : GiaoVu
    Created on : Aug 9, 2022, 8:06:17 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h2 class="text-center mt-5">ĐỀ TÀI KHÓA LUẬN</h2>
<c:url value="/DeTaiKhoaLuan" var="action"/>
<div class="container">
    <c:if test="${pageContext.request.isUserInRole('ROLE_GVU')}">
        <h3>Thêm đề tài khóa luận</h3>
        <div class="form-group container">
            <form:form method="post" action="${action}">
                <div class="form-outline mt-4">
                    <label class="form-label">Tên đề tài</label>
                    <input type="text" class="form-control"/>
                </div>
                <div class="form-outline mt-4">
                    <label class="form-label">Nội dung đề tài</label>
                    <textarea class="form-control" placeholder="Nhập nội dung chi tiết đề tài khóa luận"></textarea>
                </div>
                <div class="form-outline mt-4">
                    <input type="submit" class="btn btn-primary btn-block mb-4" value="Thêm đề tài" />
                </div>
            </form:form>
        </div>
    </c:if>
    <h3>Danh sách đề tài khóa luận</h3>
</div>
