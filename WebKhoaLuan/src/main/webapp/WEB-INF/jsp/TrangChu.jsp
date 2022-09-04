<%-- 
    Document   : TrangChu
    Created on : Jul 20, 2022, 10:26:33 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${pageContext.servletContext.contextPath}/picture/Anh1.jpg" alt="TruongDaiHocAA" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.servletContext.contextPath}/picture/Anh2.jpg" alt="TruongDaiHocAA" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.servletContext.contextPath}/picture/Anh3.jpg" alt="TruongDaiHocAA" class="d-block w-100">
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
    
    <div class="container mt-3">
        <h2 id="thongbao">Thông báo</h2>
  <ul class="list-group">
    <li class="list-group-item">Tuyển sinh năm 2022-2023</li>
    <li class="list-group-item">Sinh hoạt & giao lưu sinh viên</li>
    <li class="list-group-item">Gây quỹ, trao tặng học bổng sinh viên </li>
  </ul>
</div>
</div>
