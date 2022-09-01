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

<!-- PHẦN GIÁO VỤ XEM THỐNG KÊ ĐIỂM KHÓA LUẬN -->
<h2 class="text-center"><strong>THỐNG KÊ ĐIỂM KHÓA LUẬN</strong></h2>