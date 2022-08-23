<%--
    Document   : DangKy
    Created on : Aug 10, 2022, 10:33:14 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/quantri/DangKy" var="action" />
<c:url value="/quantri/DKBoSung" var="action1" />
<div class="container">
    <h2 class="text-center mt-5">ĐĂNG KÝ TÀI KHOẢN NGƯỜI DÙNG</h2>
    <div class="form-group container">
        <h4 class="mt-4">Thông tin chung  tài khoản người dùng:</h4>
        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="nguoidung" >
            <div class="form-outline mt-4">
                <label class="form-label" for="vaiTro">Vai trò người dùng</label>
                <form:select id="vaiTro" path="chucvu" onchange="chonCV()">
                    <c:forEach items="${chucvu}" var="c">
                        <form:option value="${c.maChucVu}" path="chucvu" >${c.tenChucVu}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="row">
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="ho" path="ho" class="form-control" placeholder="Họ" />
                </div>
                <div class="form-outline mt-4 col">
                    <form:input type="text" id="ten" path="ten" class="form-control" placeholder="Tên" />
                </div>
            </div>

            <div class ="row">
                <div class="form-outline mt-4 col">                    
                    <form:input type="text" id="username" path="username" class="form-control" placeholder="Username" />
                </div>

                <div class="col mt-4">
                    <div class="input-group date" id="datepicker">
                        <form:input type="text" class="form-control" id="ngaySinh" path="ngaySinh" placeholder="Ngày sinh" />
                        <span class="input-group-append">
                            <span class="input-group-text bg-light d-block">
                                <i class="fa fa-calendar"></i>
                            </span>
                        </span>
                    </div>
                </div>
            </div>
            <div class ="row">
                <div class="d-flex col mt-4">
                    <label class="form-label col-xl-2" for="gioiTinh">Giới tính:</label>
                    <div class="form-check form-check-inline">
                        <form:radiobutton class="form-check-input" path="gioiTinh" value="Nam" checked="checked" />
                        <label class="form-check-label" for="nam">Nam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <form:radiobutton class="form-check-input" path="gioiTinh" value="Nữ" />
                        <label class="form-check-label" for="nu">Nữ</label>
                    </div>
                </div>

                        
                <div class="col mt-4">   
                    
                    <form:input type="file" id="anh" path="file" class="form-control"  />
                </div>
            </div>
            <div class="form-outline mt-4">
                <input type="submit" class="btn btn-primary btn-block mb-4" value="Tạo tài khoản người dùng"/>
                <input type="reset" class="btn btn-primary btn-block mb-4" value="Hủy"/>
            </div>
        </form:form>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#datepicker').datepicker();
    });
</script>