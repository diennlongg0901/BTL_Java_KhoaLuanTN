<%-- 
    Document   : DangKy
    Created on : Aug 4, 2022, 10:02:05 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">QUẢN LÝ SINH VIÊN</h1>


    <c:forEach var="sv" items="${Sinhvien}">
        <div class="card" >
            <div class="card-header"> <h2> ${p.tenSV} </h2> </div>
            <div class="card-body">
                <img src="<c:url value="picture/Anh1" />" alt="${p.tenSV}" />
            </div>
                <div class="card-footer"><h3>${p.maSV}</h3></div>
        </div>
    </c:forEach>
    
