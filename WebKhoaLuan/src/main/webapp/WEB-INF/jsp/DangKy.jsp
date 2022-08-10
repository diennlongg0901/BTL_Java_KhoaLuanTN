<%-- 
    Document   : DangKy
    Created on : Aug 10, 2022, 10:33:14 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/DangKy" var="action" />
<div class="container">
    <h2 class="text-center mt-5">ĐĂNG KÝ TÀI KHOẢN NGƯỜI DÙNG</h2>
    <div class="form-group container">
        <form method="post" action="${action}">

            <div class="form-outline mt-4">
                <label class="form-label" for="vaiTro">Vai trò người dùng</label>
                <select id="vaiTro" name="vaiTro">
                    <c:forEach items="${chucvu}" var="c">
                        <option value="${c.maChucVu}">${c.tenChucVu}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-outline mt-4">
                <label class="form-label" for="ho">Họ</label>
                <input type="text" id="ho" name="ho" class="form-control" />
            </div>

            <div class="form-outline mt-4">
                <label class="form-label" for="ten">Tên</label>
                <input type="text" id="ten" name="ten" class="form-control" />
            </div>

            <label class="form-label mt-4" for="gioiTinh">Giới tính</label>
            <div class="d-flex">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="nam" id="nam" value="nam" checked>
                    <label class="form-check-label" for="nam">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="nu" id="nu" value="nữ">
                    <label class="form-check-label" for="nu">Nữ</label>
                </div>
            </div>

            <label for="date" class="col-1 col-form-label mt-4">Ngày sinh</label>
            <div class="col-5">
                <div class="input-group date" id="datepicker">
                    <input type="text" class="form-control" id="ngaySinh" name="ngaySinh"/>
                    <span class="input-group-append">
                        <span class="input-group-text bg-light d-block">
                            <i class="fa fa-calendar"></i>
                        </span>
                    </span>
                </div>
            </div>

            <div class="form-outline mt-4">
                <label class="form-label" for="diaChi">Địa chỉ</label>
                <input type="text" id="diaChi" name="diaChi" class="form-control" />
            </div>

            <div class="form-outline mt-4">
                <label class="form-label" for="email">Email</label>
                <input type="email" id="email" name="email" class="form-control" />
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="sdt">Số điện thoại</label>
                <input type="number" id="sdt" name="sdt" class="form-control" />
            </div>
        </form>
    </div>
</div>


<script type="text/javascript">
    $(function () {
        $('#datepicker').datepicker();
    });
</script>




