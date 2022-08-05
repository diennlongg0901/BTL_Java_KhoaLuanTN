<%-- 
    Document   : DangKy
    Created on : Aug 4, 2022, 10:02:05 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">QUẢN LÝ SINH VIÊN</h1>


    <c:forEach var="sv" items="${Sinhvien}">
        <h2> ${sv.maSV} </h2>
        <h3>${sv.nienKhoa}</h3>
        <h3>${sv.tinhTrang}</h3>
        
<!--        <div class="card" >
            <div class="card-header">  </div>
            <div class="card-body">
                
                <img src="<c:url value="picture/Anh1" />" alt="${sv.tenSV}" />
            </div>
                <div class="card-footer"></div>
        </div>-->
    </c:forEach>
    
