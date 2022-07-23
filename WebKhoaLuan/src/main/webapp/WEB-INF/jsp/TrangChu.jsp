<%-- 
    Document   : TrangChu
    Created on : Jul 20, 2022, 10:26:33 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Chủ - Trường Đại Học AA</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Trường Đại học AA</a>
                    </li>
                    <div>                 
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item" style="float:right">
                                <a class="nav-link" href="#">Thông báo mới</a>
                            </li>
                            <li class="nav-item" style="float:right">
                                <a class="nav-link" href="#">Đăng nhập</a>
                            </li>
                        </ul>
                    </div>
                </ul>
            </div>
        </nav>
        
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
        </div>
                
        <div class="mt-4 p-5 bg-white text-black rounded">
            <h1>TRƯỜNG ĐẠI HỌC AA</h1>
            <p>AAU &copy; 2022</p>
        </div>
    </body>
</html>
